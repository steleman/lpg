#ifndef LPG_RUNTIME_STACKS_INCLUDED
#define LPG_RUNTIME_STACKS_INCLUDED

#include <limits.h>
#include <iostream>
#include "tuple.h"
#include "Token.h"

class PrsStream
{
protected:
    Tuple<Token> tokens_;
    int index_;
public:
    PrsStream() : tokens_(12, 16) {};
    virtual ~PrsStream() {};
    virtual void* parser() =0;
    inline int getNext(int i)
      { return (++i < tokens_.Length() ? i : tokens_.Length() - 1); }
    inline int getPrevious(int i) 
      { return (i <= 0 ? 0 : i - 1); }
    inline int peek() 
      { return getNext(index_); }
    inline void reset(int i = 1) 
      { index_ = getPrevious(i); }
    inline int getToken()
      { return index_ = getNext(index_); }
    inline int getToken(int end_token)
      { return index_ = (index_ < end_token ? getNext(index_) : tokens_.Length() - 1); }
    inline int badToken()
      { return 0; }
    inline unsigned getKind(int i)
      { return tokens_[i].getKind(); }
    inline void resetTokenStream(int size = 0)
      { tokens_.Reset(size); }
    inline void makeToken(const char* inputChars, int startLoc, int endLoc, int kind)
    {
        Token token(inputChars, startLoc, endLoc, kind);
        tokens_.Push(token);
    }

    void dump()
    {
        printf("TOKENS(%d)\n", tokens_.Length());
        for (int i = 0; i < tokens_.Length(); i++) {
            printf("% 4d|[% 4d] %s\n", i, 
                   tokens_[i].getKind(),
                   tokens_[i].getValue());
        }
    }

    inline Token* getIToken(int i)
    {
        return &tokens_[i];
    }
};

class Stacks
{
protected:
    int          stateStackTop_;
    Array<int>   stateStack_;
    Array<int>   locationStack_;
    Array<void*> parseStack_;
    enum { STACK_INCREMENT = 256 };

    Stacks() : stateStackTop_(-1) {}

    void reallocateStacks()
    {
        int new_size = stateStack_.Size() + STACK_INCREMENT;
    
        assert(new_size <= SHRT_MAX);
        stateStack_.Resize(new_size);
        locationStack_.Resize(new_size);
        parseStack_.Resize(new_size);
    
        return;
    }

public:
    inline void setSym(void* sym)
    {
        parseStack_[stateStackTop_] = sym;
    }
    inline void* getSym(int i) 
    {
        return parseStack_[stateStackTop_ + (i - 1)]; 
    }
    inline int getToken(int i)
    {
        return locationStack_[stateStackTop_ + (i - 1)];
    }
};

template<class TokenStream, class Prs, class RuleAction>
class DeterministicParser : public Stacks
{
    TokenStream* tokStream_;
    RuleAction*  ra_;
    int          currentAction_, lastToken_;
    enum {
        START_STATE     = Prs::START_STATE,
        NUM_RULES       = Prs::NUM_RULES,

        NUM_STATES      = Prs::NUM_STATES,
        NUM_TOKENS      = Prs::EOFT_SYMBOL,

        LA_STATE_OFFSET = Prs::LA_STATE_OFFSET,
        ACCEPT_ACTION   = Prs::ACCEPT_ACTION,
        ERROR_ACTION    = Prs::ERROR_ACTION,
        ERROR_SYMBOL    = Prs::ERROR_SYMBOL,
    };

    int tAction(int act, int sym)
    {
        act = Prs::t_action(act, sym);
        if (act > LA_STATE_OFFSET) {
            for (int tok = tokStream_->peek(); ; tok = tokStream_->getNext(tok)) {
                act = Prs::look_ahead(act - LA_STATE_OFFSET, tokStream_->getKind(tok));
                if (act <= LA_STATE_OFFSET)
                    break;
            } 
        }
        return act;
    }

public:
    int tAction_dump()
    {
        int i =0, j = 0, act = 0;
        for (i = 0; i <= NUM_STATES; i++) {
            printf("% 3d|", i);
            for (j= 0; j<= NUM_TOKENS; j++) {
                int act = Prs::t_action(i, j);
                printf("% 3d(% 3d) ", act, act - ERROR_ACTION);
            }
            printf("\n");
        }
        return 0;
    }

    DeterministicParser(TokenStream* tokStream, RuleAction* ra) :
        tokStream_(tokStream), ra_(ra), currentAction_(0), lastToken_(0) { }

    void* parse(int start_index)
    {
        tokStream_->reset(start_index);

        int currentToken  = tokStream_->getToken();
        int currentKind   = tokStream_->getKind(currentToken);

        stateStackTop_ = -1;
        currentAction_ = START_STATE;
        for (;;) {
            //printf("A(%d) C(%d) K(%d)\n", currentAction_, currentToken, currentKind);
            if (++stateStackTop_ >= stateStack_.Size())
                reallocateStacks();

            stateStack_[stateStackTop_] = currentAction_;
            locationStack_[stateStackTop_] = currentToken;

            currentAction_ = tAction(currentAction_, currentKind);
            // printf("-> %d\n", currentAction_);
            if (currentAction_ <= NUM_RULES) {
                // printf("currentAction_<=NUM_RULES\n");
                stateStackTop_--; // make reduction look like a shift-reduce
            } else if (currentAction_ > ERROR_ACTION) {
                // printf("currentAction_>ERR\n");
                lastToken_ = currentToken;
                currentToken = tokStream_->getToken();
                currentKind = tokStream_->getKind(currentToken);

                currentAction_ -= ERROR_ACTION;
            } else if (currentAction_ < ACCEPT_ACTION) {
                // printf("act<ACC\n");
                lastToken_ = currentToken;
                currentToken = tokStream_->getToken();
                currentKind = tokStream_->getKind(currentToken);
                continue;
            } else break;
        
            do {
                stateStackTop_ -= (Prs::rhs[currentAction_] - 1);
                ra_->ruleAction(currentAction_);
                currentAction_ =
                    Prs::nt_action(stateStack_[stateStackTop_], Prs::lhs[currentAction_]);
            } while(currentAction_ <= NUM_RULES);
        }
        if (currentAction_ == ERROR_ACTION)
        {
            printf("syntax error.\n");
            printf("A(%d) C(%d) K(%d)\n", currentAction_, currentToken, currentKind);
            exit(12);
        }

        return parseStack_[0];
    }

    inline int getFirstToken()
    {
        return getToken(1);
    }
    inline int getFirstToken(int i)
    {
        return getToken(i);
    }
    inline int getLastToken()
    {
        return lastToken_;
    }
    inline int getLastToken(int i)
    {
        return (i >= Prs::rhs[currentAction_]
                ? lastToken_
                : tokStream_->getPrevious(getToken(i + 1)));
    }
};
#endif
