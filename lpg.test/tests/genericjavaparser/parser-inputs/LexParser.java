package com.ibm.lpg;

public class LexParser
{
    private int START_STATE,
                START_SYMBOL,
                NUM_RULES,
                LA_STATE_OFFSET,
                EOFT_SYMBOL,
                ACCEPT_ACTION,
                ERROR_ACTION;

    private TokenStream tokStream;
    private ParseTable prs;
    private RuleAction ra;
    public LexParser(TokenStream tokStream, ParseTable prs, RuleAction ra)
    {
        this.tokStream = tokStream;
        this.prs = prs;
        this.ra = ra;

        START_STATE = prs.getStartState();
        START_SYMBOL = prs.getStartSymbol();
        NUM_RULES = prs.getNumRules();
        LA_STATE_OFFSET = prs.getLaStateOffset();
        EOFT_SYMBOL = prs.getEoftSymbol();
        ACCEPT_ACTION = prs.getAcceptAction();
        ERROR_ACTION = prs.getErrorAction();
    }

    //
    // Stacks portion
    //
    private int STACK_INCREMENT = 1024,
                stateStackTop,
                stackLength = 0,
                stack[],
                locationStack[];
    private void reallocateStacks()
    {
        int old_stack_length = (stack == null ? 0 : stackLength);
        stackLength += STACK_INCREMENT;

        if (old_stack_length == 0)
        {
            stack = new int[stackLength];
            locationStack = new int[stackLength];
        }
        else
        {
            System.arraycopy(stack, 0, stack = new int[stackLength], 0, old_stack_length);
            System.arraycopy(locationStack, 0, locationStack = new int[stackLength], 0, old_stack_length);
        }
        return;
    }
    //
    // Given a rule of the form     A ::= x1 x2 ... xn     n > 0
    //
    // the function getToken(i) yields the symbol xi, if xi is a terminal
    // or ti, if xi is a nonterminal that produced a string of the form
    // xi => ti w. If xi is a nullable nonterminal, then ti is the first
    //  symbol that immediately follows xi in the input (the lookahead).
    //
    public final int getToken(int i)
    {
        return locationStack[stateStackTop + (i - 1)];
    }
    public final void setSym1(int i) {}
    public final int getSym(int i) { return getLastToken(i); }


    private int lastToken,
                currentAction;
    public final int getCurrentRule()     { return currentAction; }
    public final int getFirstToken()      { return getToken(1); }
    public final int getFirstToken(int i) { return getToken(i); }
    public final int getLastToken()       { return lastToken; }
    public final int getLastToken(int i)  { return (i >= prs.rhs(currentAction)
                                                       ? lastToken
                                                       : tokStream.getPrevious(getToken(i + 1))); }

    //
    // Parse the input and create a stream of tokens.
    //
    public void parseCharacters()
    {
        tokStream.reset();
        int starttok,
            curtok = tokStream.getToken(),
            current_kind = tokStream.getKind(curtok);

        lastToken = tokStream.getPrevious(curtok);

        //
        // Until it reaches the end-of-file token, this outer loop
        // resets the parser and processes the next token.
        //
        ProcessTokens: while (current_kind != EOFT_SYMBOL)
        {
            stateStackTop = -1;
            currentAction = START_STATE;
            starttok = curtok;

            ScanToken:for (;;)
            {
                if (++stateStackTop >= stackLength)
                    reallocateStacks();
                stack[stateStackTop] = currentAction;
                locationStack[stateStackTop] = curtok;
    
                currentAction = tAction(currentAction, current_kind);
    
                if (currentAction <= NUM_RULES)
                {
                    stateStackTop--; // make reduction look like a shift-reduce
                    do
                    {
                        int rule_size = prs.rhs(currentAction);
                        stateStackTop -= (rule_size - 1);
                        ra.ruleAction(currentAction);
                        int lhs_symbol = prs.lhs(currentAction);
                        if (lhs_symbol == START_SYMBOL)
                        {
                            if (rule_size == 0) //empty reduction to START_SYMBOL is illegal
                                 break ScanToken;
                            else continue ProcessTokens;
                        }
                        currentAction = prs.ntAction(stack[stateStackTop], lhs_symbol);
                    } while(currentAction <= NUM_RULES);
                }
                else if (currentAction > ERROR_ACTION)
                {
                    lastToken = curtok;
                    curtok = tokStream.getToken();
                    current_kind = tokStream.getKind(curtok);
                    currentAction -= ERROR_ACTION;
                    do
                    {
                        stateStackTop -= (prs.rhs(currentAction) - 1);
                        ra.ruleAction(currentAction);
                        int lhs_symbol = prs.lhs(currentAction);
                        if (lhs_symbol == START_SYMBOL)
                            continue ProcessTokens;
                        currentAction = prs.ntAction(stack[stateStackTop], lhs_symbol);
                    } while(currentAction <= NUM_RULES);
                }
                else if (currentAction < ACCEPT_ACTION)
                {
                    lastToken = curtok;
                    curtok = tokStream.getToken();
                    current_kind = tokStream.getKind(curtok);
                }
                else break; // ERROR_ACTION only. (ACCEPT_ACTION is not possible)
            }

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
            if (starttok == curtok)
            {
                if (current_kind == EOFT_SYMBOL)
                    return;
                tokStream.reportError(starttok, curtok);
                lastToken = curtok;
                curtok = tokStream.getToken();
                current_kind = tokStream.getKind(curtok);
            }
            else tokStream.makeToken(starttok, lastToken, 0);
        }

        return;
    }

    private final int tAction(int act, int sym)
    {
        act = prs.tAction(act, sym);
        if (act > LA_STATE_OFFSET)
        {
            int next_token = tokStream.peek();
            act = prs.lookAhead(act - LA_STATE_OFFSET, tokStream.getKind(next_token));
            while(act > LA_STATE_OFFSET)
            {
                next_token = tokStream.getNext(next_token);
                act = prs.lookAhead(act - LA_STATE_OFFSET, tokStream.getKind(next_token));
            }
        }
        return act;
    }
}
