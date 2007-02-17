package expr4;

import lpg.runtime.java.*;

public class ExprParser extends PrsStream implements RuleAction
{
    private boolean unimplementedSymbolsWarning = false;
        
    private static ParseTable prs = new ExprParserprs();
    public ParseTable getParseTable() { return prs; }

    private DeterministicParser dtParser = null;
    public DeterministicParser getParser() { return dtParser; }

    private void setResult(Object object) { dtParser.setSym1(object); }
    public Object getRhsSym(int i) { return dtParser.getSym(i); }

    public int getRhsTokenIndex(int i) { return dtParser.getToken(i); }
    public IToken getRhsIToken(int i) { return super.getIToken(getRhsTokenIndex(i)); }

    public int getRhsFirstTokenIndex(int i) { return dtParser.getFirstToken(i); }
    public IToken getRhsFirstIToken(int i) { return super.getIToken(getRhsFirstTokenIndex(i)); }

    public int getRhsLastTokenIndex(int i) { return dtParser.getLastToken(i); }
    public IToken getRhsLastIToken(int i) { return super.getIToken(getRhsLastTokenIndex(i)); }

    public int getLeftSpan() { return dtParser.getFirstToken(); }
    public IToken getLeftIToken()  { return super.getIToken(getLeftSpan()); }

    public int getRightSpan() { return dtParser.getLastToken(); }
    public IToken getRightIToken() { return super.getIToken(getRightSpan()); }

    public int getRhsErrorTokenIndex(int i)
    {
        int index = dtParser.getToken(i);
        IToken err = super.getIToken(index);
        return (err instanceof ErrorToken ? index : 0);
    }
    public ErrorToken getRhsErrorIToken(int i)
    {
        int index = dtParser.getToken(i);
        IToken err = super.getIToken(index);
        return (ErrorToken) (err instanceof ErrorToken ? err : null);
    }

    public ExprParser(ILexStream lexStream)
    {
        super(lexStream);

        try
        {
            super.remapTerminalSymbols(orderedTerminalSymbols(), ExprParserprs.EOFT_SYMBOL);
        }
        catch(NullExportedSymbolsException e) {
        }
        catch(NullTerminalSymbolsException e) {
        }
        catch(UnimplementedTerminalsException e)
        {
            if (unimplementedSymbolsWarning) {
                java.util.ArrayList unimplemented_symbols = e.getSymbols();
                System.out.println("The Lexer will not scan the following token(s):");
                for (int i = 0; i < unimplemented_symbols.size(); i++)
                {
                    Integer id = (Integer) unimplemented_symbols.get(i);
                    System.out.println("    " + ExprParsersym.orderedTerminalSymbols[id.intValue()]);               
                }
                System.out.println();                        
            }
        }
        catch(UndefinedEofSymbolException e)
        {
            throw new Error(new UndefinedEofSymbolException
                                ("The Lexer does not implement the Eof symbol " +
                                 ExprParsersym.orderedTerminalSymbols[ExprParserprs.EOFT_SYMBOL]));
        } 

        try
        {
            dtParser = new DeterministicParser(this, prs, this);
        }
        catch (NotDeterministicParseTableException e)
        {
            throw new Error(new NotDeterministicParseTableException
                                 ("Regenerate ExprParserprs.java with -NOBACKTRACK option"));
        }
        catch (BadParseSymFileException e)
        {
            throw new Error(new BadParseSymFileException("Bad Parser Symbol File -- ExprParsersym.java. Regenerate ExprParserprs.java"));
        }
    }

    public String[] orderedTerminalSymbols() { return ExprParsersym.orderedTerminalSymbols; }
    public String getTokenKindName(int kind) { return ExprParsersym.orderedTerminalSymbols[kind]; }            
    public int getEOFTokenKind() { return ExprParserprs.EOFT_SYMBOL; }
    public PrsStream getParseStream() { return (PrsStream) this; }

    public Integer parser()
    {
        return parser(null, 0);
    }
    
    public Integer parser(Monitor monitor)
    {
        return parser(monitor, 0);
    }
    
    public Integer parser(int error_repair_count)
    {
        return parser(null, error_repair_count);
    }
    
    public Integer parser(Monitor monitor, int error_repair_count)
    {
        dtParser.setMonitor(monitor);
        
        try
        {
            return (Integer) dtParser.parse();
        }
        catch (BadParseException e)
        {
            reset(e.error_token); // point to error token

            DiagnoseParser diagnoseParser = new DiagnoseParser(this, prs);
            diagnoseParser.diagnose(e.error_token);
        }

        return null;
    }

    public class BadActionException extends Exception
    {
        private static final long serialVersionUID = 1L;
    }

    public final void ruleAction(int rule_number)
    {
        try
        {
            ruleAction[rule_number].action();
        }
        catch (Error e)
        {
            if (e.getCause() instanceof BadActionException)
                throw new Error("No action specified for rule " + rule_number);
        }
    }

    abstract class Action
    {
        public abstract void action();
    }

    final class NoAction extends Action
    {
        public void action() {}
    }

    final class BadAction extends Action
    {
        public void action()
        {
            throw new Error(new BadActionException());
        }
    }

    //
    // Action for a null rule
    //
    final class NullAction extends Action
    {
        public void action() { dtParser.setSym1(null); }
    }


    //
    // Declare and initialize ruleAction array.
    //
    Action ruleAction[] = new Action[6 + 1];
    {
        ruleAction[0] = null;

        ruleAction[1] = new act1();
        ruleAction[3] = new act3();
        ruleAction[5] = new act5();
        ruleAction[6] = new act6();


        //
        // Make sure that all elements of ruleAction are properly initialized
        //
        for (int i = 0; i < ruleAction.length; i++)
        {
            if (ruleAction[i] == null)
                 ruleAction[i] = new NoAction();
        }
    };
 
    //
    // Rule 1:  E ::= E + T
    //
    final class act1 extends Action
    {
        public void action()
        {
            //#line 20 "C:/eclipse/workspace/lpg.runtime.java.examples/exprexample/expr4/ExprParser.g"
            Integer E = (Integer) getRhsSym(1);
            //#line 20 "C:/eclipse/workspace/lpg.runtime.java.examples/exprexample/expr4/ExprParser.g"
            Integer T = (Integer) getRhsSym(3);
            setResult(new Integer(E.intValue() + T.intValue()));
            return;
        }
    }
 
    //
    // Rule 3:  T ::= T * F
    //
    final class act3 extends Action
    {
        public void action()
        {
            //#line 26 "C:/eclipse/workspace/lpg.runtime.java.examples/exprexample/expr4/ExprParser.g"
            Integer T = (Integer) getRhsSym(1);
            //#line 26 "C:/eclipse/workspace/lpg.runtime.java.examples/exprexample/expr4/ExprParser.g"
            Integer F = (Integer) getRhsSym(3);
            setResult(new Integer(T.intValue() * F.intValue()));
            return;
        }
    }
 
    //
    // Rule 5:  F ::= IntegerLiteral$number
    //
    final class act5 extends Action
    {
        public void action()
        {
            //#line 32 "C:/eclipse/workspace/lpg.runtime.java.examples/exprexample/expr4/ExprParser.g"
            IToken number = (IToken) getRhsIToken(1);
            setResult(new Integer(number.toString()));
            return;
        }
    }
 
    //
    // Rule 6:  F ::= ( E )
    //
    final class act6 extends Action
    {
        public void action()
        {
            //#line 37 "C:/eclipse/workspace/lpg.runtime.java.examples/exprexample/expr4/ExprParser.g"
            Integer E = (Integer) getRhsSym(2);
            setResult(E);
            return;
        }
    }

}

