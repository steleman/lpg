#ifndef LPG_RUNTIME_DETERMINISTIC_PARSER_INCLUDED
#define LPG_RUNTIME_DETERMINISTIC_PARSER_INCLUDED

#include "Stacks.h"

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
