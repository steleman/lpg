#ifndef LPG_RUNTIME_LEXPARSER_H
#define LPG_RUNTIME_LEXPARSER_H

#include <limits.h>

#include "Array.h"

template<class ParseTable, class TLexStream>
class LexParser
{
    char*        inputChars_;
    char*        pic_;
    Array<int>   stack_;
    int          stateStackTop_;
    TLexStream*  lexStream_;
    int          tokenStartOffset_, tokenEndOffset_;
 
    enum {
        START_STATE     = ParseTable::START_STATE,
        LA_STATE_OFFSET = ParseTable::LA_STATE_OFFSET,
        EOFT_SYMBOL     = ParseTable::EOFT_SYMBOL,
        ACCEPT_ACTION   = ParseTable::ACCEPT_ACTION,
        ERROR_ACTION    = ParseTable::ERROR_ACTION,
        NUM_RULES       = ParseTable::NUM_RULES,
        STACK_INCREMENT = 256,
    };

    void ReallocateStacks()
    {
        int new_size = stack_.Size() + STACK_INCREMENT;
    
        assert(new_size <= SHRT_MAX);
        stack_.Resize(new_size);
    
        return;
    }
    int tAction(int act, int sym)
    {
        act = ParseTable::t_action(act, sym);
        if (act > LA_STATE_OFFSET)
        {
            for(++pic_; ; ++pic_)
            {
                act = ParseTable::look_ahead(act - LA_STATE_OFFSET,
                                             TLexStream::getKind(*pic_));
                if (act <= LA_STATE_OFFSET)
                    break;
            } 
        }
        return act;
    }
    inline int currentOffset()
      { return pic_ - inputChars_; }

public:
    LexParser(TLexStream* lexStream) :
        lexStream_(lexStream), tokenStartOffset_(0), tokenEndOffset_(0)
    {
        pic_ = inputChars_ = lexStream_->getInputChars();
    }

    inline int getTokenStartOffset()
    { return tokenStartOffset_; }

    inline int getTokenEndOffset()
    { return tokenEndOffset_; }

    inline int getFirstToken(int i)
    { return 0; }

    inline int getLastToken(int i)
    { return 0; }

    void parseCharacters()
    {
        pic_ = inputChars_;
        const int START_SYMBOL = ParseTable :: lhs[0];

        int current_kind     = TLexStream:: getKind(*pic_);

        while (current_kind != EOFT_SYMBOL) {
        begin_process_token:
            char* ptstart = pic_;
            int   act     = START_STATE;

            stateStackTop_  = -1;
            tokenStartOffset_ = currentOffset();
            // printf("\nSTART:'%s':'%s'\n", pic_, inputChars_ + tokenStartOffset_);
            while (*pic_) {
                //printf("\n+++  in: '%c' kind: %d\n", *pic_, current_kind);

                if (++stateStackTop_ >= stack_.Size())
                    ReallocateStacks();
                stack_[stateStackTop_] = act;
                
                act = tAction(act, current_kind);
                if (act <= NUM_RULES) {
                    stateStackTop_--;
                    do {
                        stateStackTop_ -= (ParseTable::rhs[act] - 1);
                        lexStream_-> ruleAction(act);
                        // printf("act: %d\n", act);
                        if (ParseTable::lhs[act] == START_SYMBOL) {
                            if (ptstart == pic_)
                                goto end_scan_token;
                            else
                                goto begin_process_token;
                        }
                        act = ParseTable::nt_action(stack_[stateStackTop_],
                                                    ParseTable::lhs[act]);
                    } while (act <= NUM_RULES);
                } else if (act > ERROR_ACTION) {
                    tokenEndOffset_ = currentOffset();
                    current_kind = TLexStream::getKind(*++pic_);
                    act -= ERROR_ACTION;
                    do {
                        stateStackTop_ -= (ParseTable::rhs[act] - 1);
                        lexStream_ -> ruleAction(act);
                        // printf("act: %d\n", act);
                        if (ParseTable::lhs[act] == START_SYMBOL) {
                            goto begin_process_token;
                        }
                        act = ParseTable::nt_action(stack_[stateStackTop_],
                                                    ParseTable::lhs[act]);
                    } while(act <= NUM_RULES);
                } else if (act < ACCEPT_ACTION) {
                    tokenEndOffset_ = currentOffset();
                    current_kind = TLexStream::getKind(*++pic_);
                } else break;
            } end_scan_token:

            if (ptstart == pic_)
            {
                if (current_kind == EOFT_SYMBOL)
                    break;
                if (!*pic_) break;
                printf("?%d\n", current_kind);
                // tokStream.reportLexicalError(starttok, curtok);
                tokenEndOffset_ = currentOffset();
                current_kind = TLexStream::getKind(*++pic_);
            }
            else lexStream_-> makeToken(tokenStartOffset_, tokenEndOffset_, 0);
        }
        return;
    }
};

#endif
