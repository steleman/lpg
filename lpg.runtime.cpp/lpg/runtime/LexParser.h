#ifndef LPG_RUNTIME_LEXPARSER_H
#define LPG_RUNTIME_LEXPARSER_H

#include <limits.h>

#include "Array.h"

template<class ParseTable, class TCharStream>
class LexParser
{
public:
    class UnavailableParserInformationException {
    public:
        UnavailableParserInformationException() { }

        const char *getMessage() {
            return "RHS token requested while scanning with actions disabled";
        }
    };

private:
    enum {
        START_STATE     = ParseTable::START_STATE,
        LA_STATE_OFFSET = ParseTable::LA_STATE_OFFSET,
        EOFT_SYMBOL     = ParseTable::EOFT_SYMBOL,
        ACCEPT_ACTION   = ParseTable::ACCEPT_ACTION,
        ERROR_ACTION    = ParseTable::ERROR_ACTION,
        NUM_RULES       = ParseTable::NUM_RULES,
        STACK_INCREMENT = 256,
    };
    
    TCharStream*  charStream_;
    const char*  inputChars_; // cached from TCharStream
    bool         taking_actions_;

public:
    LexParser(TCharStream* charStream)
      : charStream_(charStream)
    {
        inputChars_ = charStream_->getInputChars();
    }
    
    void reset(TCharStream *charStream)
    {
        this.charStream_ = charStream;
    }

private:
    Array<int>   stack_, locationStack_, tempStack_;
    int          stateStackTop_;

    void reallocateStacks()
    {
        int new_size = stack_.Size() + STACK_INCREMENT;
        
        assert(new_size <= SHRT_MAX);
        stack_.Resize(new_size);
        locationStack_.Resize(new_size);
        tempStack_.Resize(new_size);
        
        return;
    }

    int lastToken_, currentAction_, curTok_, starttok_, current_kind_;

public:
    inline int getFirstToken(int i)
    {
        return getToken(i);
    }
    
    inline int getLastToken(int i)
    {
        if (taking_actions_) {
            return (i >= ParseTable::rhs[currentAction_]) ? lastToken_ : getToken(i+1) - 1;
        }
        throw new UnavailableParserInformationException();
    }
    
    inline int getCurrentRule()
    {
        if (taking_actions_) {
            return currentAction_;
        }
        throw new UnavailableParserInformationException();
    }

    //
    // Given a rule of the form     A ::= x1 x2 ... xn     n > 0
    //
    // the function getToken(i) yields the symbol xi, if xi is a terminal
    // or ti, if xi is a nonterminal that produced a string of the form
    // xi => ti w. If xi is a nullable nonterminal, then ti is the first
    //  symbol that immediately follows xi in the input (the lookahead).
    //
    inline int getToken(int i)
    {
        if (taking_actions_) {
            return locationStack_[stateStackTop_ + (i - 1)];
        }
        throw new UnavailableParserInformationException();
    }

    void setSym1(int i) {}
    int getSym(int i) { return getLastToken(i); }

    int getFirstToken() { return starttok_; }
    int getLastToken()  { return lastToken_; }

    void resetTokenStream(int i)
    {
        //
        // if i exceeds the upper bound, reset it to point to the last element.
        //
        charStream_->reset(i > charStream_->getStreamLength() ? charStream_->getStreamLength() : i);
        curTok_ = charStream_->getToken();
        current_kind_ = charStream_->getKind(curTok_);
        if (stack_.Size() == 0)
            reallocateStacks();
//        if (action_ == null)
//            action_ = new Tuple<int>(1 << 10);
    }

public:
//    void parseCharacters(int start_offset, int end_offset)
//    {
//        resetTokenStream(start_offset);
//        while (curTok_ <= end_offset)
//        {
//            lexNextToken(end_offset);
//        }
//    }
//
//    int incrementalParseCharacters()
//    {
//        scanNextToken();
//        
//    	return curtok;
//    }

    void parseCharacters()
    {
        if (charStream_->getInputChars() == NULL) {
            return;
        }
        const int START_SYMBOL = ParseTable :: lhs[0];
        //
        // Indicate that we are running the regular parser and that it's
        // ok to use the utility functions to query the parser.
        //
        taking_actions_ = true;
        resetTokenStream(0);
        lastToken_ = charStream_->getPrevious(curTok_);

        //
        // Until it reaches the end-of-file token, this outer loop
        // resets the parser and processes the next token.
        //
    ProcessTokens:
        while (current_kind_ != EOFT_SYMBOL) {
            stateStackTop_ = -1;
            currentAction_ = START_STATE;
            starttok_ = curTok_;

        ScanToken:
            for ( ; ; ) {
                if (++stateStackTop_ >= stack_.Size()) {
                    reallocateStacks();
                }
                stack_[stateStackTop_] = currentAction_;
                locationStack_[stateStackTop_] = curTok_;

                //
                // Compute the action on the next character. If it is a reduce action, we do not
                // want to accept it until we are sure that the character in question is can be parsed.
                // What we are trying to avoid is a situation where Curtok is not the EOF token
                // but it yields a default reduce action in the current configuration even though
                // it cannot ultimately be shifted; However, the state on top of the configuration also
                // contains a valid reduce action on EOF which, if taken, would lead to the successful
                // scanning of the token.
                // 
                // Thus, if the character can be parsed, we proceed normally. Otherwise, we proceed
                // as if we had reached the end of the file (end of the token, since we are really
                // scanning).
                // 
                parseNextCharacter(curTok_, current_kind_);
                if (currentAction_ == ERROR_ACTION && current_kind_ != EOFT_SYMBOL) // if not successful try EOF
                {
                    int save_next_token = charStream_->peek(); // save position after curtok
                    charStream_->reset(charStream_->getStreamLength() - 1); // point to the end of the input
                    parseNextCharacter(curTok_, EOFT_SYMBOL);
                    charStream_->reset(save_next_token); // reset the stream for the next token after curtok
                }

                //
                // At this point, currentAction is either a Shift, Shift-Reduce, Accept or Error action.
                //
                if (currentAction_ > ERROR_ACTION) // Shift+reduce
                {
                    lastToken_ = curTok_;
                    curTok_ = charStream_->getToken();
                    current_kind_ = charStream_->getKind(curTok_);
                    currentAction_ -= ERROR_ACTION;
                    do {
                        stateStackTop_ -= (ParseTable::rhs[currentAction_] - 1);
                        charStream_->ruleAction(currentAction_);
                        int lhs_symbol = ParseTable::lhs[currentAction_];
                        if (lhs_symbol == START_SYMBOL)
                            goto ProcessTokens;
                        currentAction_ = ParseTable::nt_action(stack_[stateStackTop_], lhs_symbol);
                    } while(currentAction_ <= NUM_RULES);
                }
                else if (currentAction_ < ACCEPT_ACTION) // Shift
                {
                    lastToken_ = curTok_;
                    curTok_ = charStream_->getToken();
                    current_kind_ = charStream_->getKind(curTok_);
                }
                else if (currentAction_ == ACCEPT_ACTION) // Accept
                    goto ProcessTokens;
                else { // ERROR_ACTION
                    goto end_scan_token;
                }
            } end_scan_token:

            //
            // Whenever we reach this point, an error has been detected.
            // Note that the parser loop above can never reach the ACCEPT
            // point as it is short-circuited each time it reduces a phrase
            // to the START_SYMBOL.
            //
            // If an error is detected on a single bad character,
            // we advance to the next character before resuming the
            // scan. However, if an error is detected after we start
            // scanning a construct, we form a bad token out of the
            // characters that have already been scanned and resume
            // scanning on the character on which the problem was
            // detected. In other words, in that case, we do not advance.
            //
            if (starttok_ == curTok_)
            {
                if (current_kind_ == EOFT_SYMBOL)
                    goto ProcessTokens;
                charStream_->reportLexicalError(starttok_, curTok_);
                lastToken_ = curTok_;
                curTok_ = charStream_->getToken();
                current_kind_ = charStream_->getKind(curTok_);
            }
            else charStream_->reportLexicalError(starttok_, lastToken_);
        }
        taking_actions_ = false;
       
        return;
    }

private:
    //
    // This function takes as argument a configuration ([stack, stackTop], [tokStream, curtok])
    // and determines whether or not curtok can be validly parsed in this configuration. If so,
    // it parses curtok and returns the final shift or shift-reduce action on it. Otherwise, it
    // leaves the configuration unchanged and returns ERROR_ACTION.
    //
    void parseNextCharacter(int token, int kind)
    {
        const int START_SYMBOL = ParseTable :: lhs[0];
        int start_action = stack_[stateStackTop_], 
            pos = stateStackTop_,
            tempStackTop = stateStackTop_ - 1;
        
    Scan: for (currentAction_ = tAction(start_action, kind);
               currentAction_ <= NUM_RULES;
               currentAction_ = tAction(currentAction_, kind))
        {
            do {
                int lhs_symbol = ParseTable::lhs[currentAction_];
                if (lhs_symbol == START_SYMBOL)
                    goto end_scan;
                tempStackTop -= (ParseTable::rhs[currentAction_] - 1);
                int state = (tempStackTop > pos
                             ? tempStack_[tempStackTop]
                             : stack_[tempStackTop]);
                currentAction_ = ParseTable::nt_action(state, lhs_symbol);
            } while (currentAction_ <= NUM_RULES);

            if (tempStackTop + 1 >= stack_.Size())
                reallocateStacks();
            //
            // ... Update the maximum useful position of the stack,
            // push goto state into (temporary) stack, and compute
            // the next action on the current symbol ...
            //
            pos = pos < tempStackTop ? pos : tempStackTop;
            tempStack_[tempStackTop + 1] = currentAction_;
        } end_scan:
        
        //
        // If no error was detected, we update the configuration up to the point prior to the
        // shift or shift-reduce on the token by processing all reduce and goto actions associated
        // with the current token.
        //
        if (currentAction_ != ERROR_ACTION)
        {
            //
            // Note that it is important that the global variable currentAction be used here when
            // we are actually processing the rules. The reason being that the user-defined function
        	// ra.ruleAction() may call public functions defined in this class (such as getLastToken())
        	// which require that currentAction be properly initialized. 
            //
        Replay: for (currentAction_ = tAction(start_action, kind);
                     currentAction_ <= NUM_RULES;
                     currentAction_ = tAction(currentAction_, kind))
            {
                stateStackTop_--;
                do {
                    stateStackTop_ -= (ParseTable::rhs[currentAction_] - 1);
                    charStream_->ruleAction(currentAction_);
                    int lhs_symbol = ParseTable::lhs[currentAction_];
                    if (lhs_symbol == START_SYMBOL)
                    {
                        currentAction_ = (starttok_ == token // null string reduction to START_SYMBOL is illegal
                                          ? ERROR_ACTION
                                          : ACCEPT_ACTION);
                    goto end_replay;
                    }
                    currentAction_ = ParseTable::nt_action(stack_[stateStackTop_], lhs_symbol);
                } while (currentAction_ <= NUM_RULES);
                stack_[++stateStackTop_] = currentAction_;
                locationStack_[stateStackTop_] = token;
            } end_replay: ;
        }
        
        return;
    }

    //
    // keep looking ahead until we compute a valid action
    //
    int lookahead(int act, int token)
    {
        act = ParseTable::look_ahead(act - LA_STATE_OFFSET, charStream_->getKind(token));
        return (act > LA_STATE_OFFSET
                ? lookahead(act, charStream_->getNext(token))
                : act);
    }
    
    //
    // Compute the next action defined on act and sym. If this
    // action requires more lookahead, these lookahead symbols
    // are in the token stream beginning at the next token that
    // is yielded by peek().
    //
    int tAction(int act, int sym)
    {
        act = ParseTable::t_action(act, sym);
        return  (act > LA_STATE_OFFSET
                 ? lookahead(act, charStream_->peek())
                 : act);
    }
};
#endif
