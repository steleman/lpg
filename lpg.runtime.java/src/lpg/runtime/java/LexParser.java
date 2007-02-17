package lpg.runtime.java;

public class LexParser
{
    private boolean taking_actions = false;
    
    private int START_STATE,
                LA_STATE_OFFSET,
                EOFT_SYMBOL,
                ACCEPT_ACTION,
                ERROR_ACTION,
                START_SYMBOL,
                NUM_RULES;

    private ILexStream tokStream;
    private ParseTable prs;
    private RuleAction ra;
    private IntTuple action = null;

    public LexParser() {}

    public LexParser(ILexStream tokStream, ParseTable prs, RuleAction ra)
    {
        this.tokStream = tokStream;
        this.prs = prs;
        this.ra = ra;

        START_STATE = prs.getStartState();
        LA_STATE_OFFSET = prs.getLaStateOffset();
        EOFT_SYMBOL = prs.getEoftSymbol();
        ACCEPT_ACTION = prs.getAcceptAction();
        ERROR_ACTION = prs.getErrorAction();
        START_SYMBOL = prs.getStartSymbol();
        NUM_RULES = prs.getNumRules();
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
    
    private int lastToken,
                currentAction,
                curtok,
                starttok,
                current_kind;

    //
    // The following functions can be invoked only when the parser is
    // processing actions. Thus, they can be invoked when the parser
    // was entered via the main entry point (parseCharacters()). When using
    // the incremental parser (via the entry point scanNextToken(int [], int)),
    // they always return 0 when invoked. // TODO: Should we throw an Exception instead?
    // However, note that when parseActions() is invoked after successfully
    // parsing an input with the incremental parser, then they can be invoked.
    //
    public final int getFirstToken(int i) { return getToken(i); }
    public final int getLastToken(int i)
    {
        if (taking_actions)
            return (i >= prs.rhs(currentAction)
                       ? lastToken
                       : tokStream.getPrevious(getToken(i + 1)));
        throw new UnavailableParserInformationException();
    }
    public final int getCurrentRule()
    {
        if (taking_actions)
            return currentAction;
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
    public final int getToken(int i)
    {
        if (taking_actions)
            return locationStack[stateStackTop + (i - 1)];
        throw new UnavailableParserInformationException();
    }
    public final void setSym1(int i) {}
    public final int getSym(int i) { return getLastToken(i); }

    public final int getFirstToken() { return starttok; }
    public final int getLastToken()  { return lastToken; }

    public void resetTokenStream(int i)
    {
        // TODO: if i exceeds the upper bound, reset it to point to the last element.
        tokStream.reset(i);
        curtok = tokStream.getToken();
        current_kind = tokStream.getKind(curtok);
        if (stack == null)
            reallocateStacks();
        if (action == null)
             action = new IntTuple(1 << 10);
    }

    //
    // Parse the input and create a stream of tokens.
    //
    public void parseCharacters()
    {
        parseCharacters(null);
    }

    public void parseCharacters(Monitor monitor)
    {
        //
        // Indicate that we are running the regular parser and that it's
        // ok to use the utility functions to query the parser.
        //
        taking_actions = true;
        
        resetTokenStream(0);
        lastToken = tokStream.getPrevious(curtok);

        //
        // Until it reaches the end-of-file token, this outer loop
        // resets the parser and processes the next token.
        //
        ProcessTokens: while (current_kind != EOFT_SYMBOL)
        {
            //
            // if the parser needs to stop processing,
            // it may do so here.
            //
            if (monitor != null && monitor.isCancelled())
                break ProcessTokens;

            stateStackTop = -1;
            currentAction = START_STATE;
            starttok = curtok;

            ScanToken:for (;;)
            {
                try
                {
                    stack[++stateStackTop] = currentAction;
                }
                catch(IndexOutOfBoundsException e)
                {
                    reallocateStacks();
                    stack[stateStackTop] = currentAction;
                }

                locationStack[stateStackTop] = curtok;
    
                currentAction = tAction(currentAction, current_kind);
    
                if (currentAction <= NUM_RULES)
                {
                    stateStackTop--; // make reduction look like a shift-reduce
                    do
                    {
                        stateStackTop -= (prs.rhs(currentAction) - 1);
                        ra.ruleAction(currentAction);
                        int lhs_symbol = prs.lhs(currentAction);
                        if (lhs_symbol == START_SYMBOL)
                        {
                            if (starttok == curtok) // null string reduction to START_SYMBOL is illegal
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
                else break ScanToken; // ERROR_ACTION only. (ACCEPT_ACTION is not possible)
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
                    break ProcessTokens;
                tokStream.reportLexicalError(starttok, curtok);
                lastToken = curtok;
                curtok = tokStream.getToken();
                current_kind = tokStream.getKind(curtok);
            }
            else tokStream.makeToken(starttok, lastToken, 0);
        }

        taking_actions = false; // indicate that we are done

        return;
    }

    //
    // keep looking ahead until we compute a valid action
    //
    private int lookahead(int act, int token)
    {
        act = prs.lookAhead(act - LA_STATE_OFFSET, tokStream.getKind(token));
        return (act > LA_STATE_OFFSET
                    ? lookahead(act, tokStream.getNext(token))
                    : act);
    }

    //
    // Compute the next action defined on act and sym. If this
    // action requires more lookahead, these lookahead symbols
    // are in the token stream beginning at the next token that
    // is yielded by peek().
    //
    private int tAction(int act, int sym)
    {
        act = prs.tAction(act, sym);
        return  (act > LA_STATE_OFFSET
                     ? lookahead(act, tokStream.peek())
                     : act);
    }

    public void scanNextToken(int i)
    {
        resetTokenStream(i);
        scanNextToken();
    }
    
    public boolean scanNextToken()
    {
        //
        // Indicate that we are going to run the incremental parser and that
        // it's forbidden to use the utility functions to query the parser.
        //
        taking_actions = false;
        
        stateStackTop = -1;
        currentAction = START_STATE;
        starttok = curtok;
        action.reset();

        ScanToken: for (;;)
        {
            try
            {
                stack[++stateStackTop] = currentAction;
            }
            catch(IndexOutOfBoundsException e)
            {
                reallocateStacks();
                stack[stateStackTop] = currentAction;
            }

            currentAction = tAction(currentAction, current_kind);

            action.add(currentAction); // save the action

            if (currentAction <= NUM_RULES)
            {
                stateStackTop--; // make reduction look like a shift-reduce
                do
                {
                    int lhs_symbol = prs.lhs(currentAction);
                    if (lhs_symbol == START_SYMBOL)
                    {
                        if (starttok == curtok) // null string reduction to START_SYMBOL is illegal
                            break ScanToken;
                        else 
                        {
                            parseActions();
                            return true;
                        }
                    }
                    stateStackTop -= (prs.rhs(currentAction) - 1);
                    currentAction = prs.ntAction(stack[stateStackTop], lhs_symbol);
                } while(currentAction <= NUM_RULES);
            }
            else if (currentAction > ERROR_ACTION)
            {
                curtok = tokStream.getToken();
                current_kind = tokStream.getKind(curtok);
                currentAction -= ERROR_ACTION;
                do
                {
                    int lhs_symbol = prs.lhs(currentAction);
                    if (lhs_symbol == START_SYMBOL)
                    {
                        parseActions();
                        return true;
                    }
                    stateStackTop -= (prs.rhs(currentAction) - 1);
                    currentAction = prs.ntAction(stack[stateStackTop], lhs_symbol);
                } while(currentAction <= NUM_RULES);
            }
            else if (currentAction < ACCEPT_ACTION)
            {
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
            {
                action = null; // turn into garbage!
                return false;
            }
            lastToken = curtok;
            tokStream.reportLexicalError(starttok, curtok);
            curtok = tokStream.getToken();
            current_kind = tokStream.getKind(curtok);
        }
        else
        {
            lastToken = tokStream.getPrevious(curtok);
            tokStream.makeToken(starttok, lastToken, 0);
        }
        
        return true;
    }

    //
    // Now do the final parse of the input based on the actions in
    // the list "action" and the sequence of tokens in the token stream.
    //
    private void parseActions()
    {
        //
        // Indicate that we are running the regular parser and that it's
        // ok to use the utility functions to query the parser.
        //
        taking_actions = true;
        
        curtok = starttok;
        lastToken = tokStream.getPrevious(curtok);

        //
        // Reparse the input...
        //
        stateStackTop = -1;
        currentAction = START_STATE;
        process_actions:for (int i = 0; i < action.size(); i++)
        {
            stack[++stateStackTop] = currentAction;
            locationStack[stateStackTop] = curtok;

            currentAction = action.get(i);
            if (currentAction <= NUM_RULES) // a reduce action?
            {
                stateStackTop--; // turn reduction intoshift-reduction
                do
                {
                    stateStackTop -= (prs.rhs(currentAction) - 1);
                    ra.ruleAction(currentAction);
                    int lhs_symbol = prs.lhs(currentAction);
                    if (lhs_symbol == START_SYMBOL)
                    {
                        // assert(starttok != curtok);  // null string reduction to START_SYMBOL is illegal
                        break process_actions;
                    }
                    currentAction = prs.ntAction(stack[stateStackTop], lhs_symbol);
                } while(currentAction <= NUM_RULES);
            }
            else // a shift or shift-reduce action
            {
                lastToken = curtok;
                curtok = tokStream.getNext(curtok);
                if (currentAction > ERROR_ACTION) // a shift-reduce action?
                {
                    current_kind = tokStream.getKind(curtok);
                    currentAction -= ERROR_ACTION;
                    do
                    {
                        stateStackTop -= (prs.rhs(currentAction) - 1);
                        ra.ruleAction(currentAction);
                        int lhs_symbol = prs.lhs(currentAction);
                        if (lhs_symbol == START_SYMBOL)
                            break process_actions;
                        currentAction = prs.ntAction(stack[stateStackTop], lhs_symbol);
                    } while(currentAction <= NUM_RULES);
                }
            }
        }

        taking_actions = false; // indicate that we are done

        return;
    }
}
