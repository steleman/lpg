package lpg.examples.java.expr2;

import lpg.examples.java.expr2.ExprAst.*;
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

    public Ast parser()
    {
        return parser(null, 0);
    }
        
    public Ast parser(Monitor monitor)
    {
        return parser(monitor, 0);
    }
        
    public Ast parser(int error_repair_count)
    {
        return parser(null, error_repair_count);
    }
        
    public Ast parser(Monitor monitor, int error_repair_count)
    {
        dtParser.setMonitor(monitor);
        
        try
        {
            return (Ast) dtParser.parse();
        }
        catch (BadParseException e)
        {
            reset(e.error_token); // point to error token

            DiagnoseParser diagnoseParser = new DiagnoseParser(this, prs);
            diagnoseParser.diagnose(e.error_token);
        }

        return null;
    }


    public void ruleAction(int ruleNumber)
    {
        switch (ruleNumber)
        {
 
            //
            // Rule 1:  E ::= E + T
            //
            case 1: {
                setResult(
                    new E(getLeftIToken(), getRightIToken(),
                          (IE)getRhsSym(1),
                          (IT)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 2:  E ::= T
            //
            case 2:
                break; 
            //
            // Rule 3:  T ::= T * F
            //
            case 3: {
                setResult(
                    new T(getLeftIToken(), getRightIToken(),
                          (IT)getRhsSym(1),
                          (IF)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 4:  T ::= F
            //
            case 4:
                break; 
            //
            // Rule 5:  F ::= IntegerLiteral
            //
            case 5: {
                setResult(
                    new F(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 6:  F ::= ( E )
            //
            case 6: {
                setResult(
                    new ParenExpr(getLeftIToken(), getRightIToken(),
                                  (IE)getRhsSym(2))
                );
                break;
            }
    
            default:
                break;
        }
        return;
    }
}

