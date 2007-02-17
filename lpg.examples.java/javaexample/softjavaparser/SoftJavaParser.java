package softjavaparser;

import lpg.javaruntime.*;

public class SoftJavaParser extends PrsStream implements RuleAction
{
    private boolean unimplementedSymbolsWarning = false;

    private static ParseTable prs = new SoftJavaParserprs();
    public ParseTable getParseTable() { return prs; }

    private BacktrackingParser btParser = null;
    public BacktrackingParser getParser() { return btParser; }

    private void setResult(Object object) { btParser.setSym1(object); }
    public Object getRhsSym(int i) { return btParser.getSym(i); }

    public int getRhsTokenIndex(int i) { return btParser.getToken(i); }
    public IToken getRhsIToken(int i) { return super.getIToken(getRhsTokenIndex(i)); }
    
    public int getRhsFirstTokenIndex(int i) { return btParser.getFirstToken(i); }
    public IToken getRhsFirstIToken(int i) { return super.getIToken(getRhsFirstTokenIndex(i)); }

    public int getRhsLastTokenIndex(int i) { return btParser.getLastToken(i); }
    public IToken getRhsLastIToken(int i) { return super.getIToken(getRhsLastTokenIndex(i)); }

    public int getLeftSpan() { return btParser.getFirstToken(); }
    public IToken getLeftIToken()  { return super.getIToken(getLeftSpan()); }

    public int getRightSpan() { return btParser.getLastToken(); }
    public IToken getRightIToken() { return super.getIToken(getRightSpan()); }

    public int getRhsErrorTokenIndex(int i)
    {
        int index = btParser.getToken(i);
        IToken err = super.getIToken(index);
        return (err instanceof ErrorToken ? index : 0);
    }
    public ErrorToken getRhsErrorIToken(int i)
    {
        int index = btParser.getToken(i);
        IToken err = super.getIToken(index);
        return (ErrorToken) (err instanceof ErrorToken ? err : null);
    }

    public SoftJavaParser(ILexStream lexStream)
    {
        super(lexStream);

        try
        {
            super.remapTerminalSymbols(orderedTerminalSymbols(), SoftJavaParserprs.EOFT_SYMBOL);
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
                    System.out.println("    " + SoftJavaParsersym.orderedTerminalSymbols[id.intValue()]);               
                }
                System.out.println();
            }
        }
        catch(UndefinedEofSymbolException e)
        {
            throw new Error(new UndefinedEofSymbolException
                                ("The Lexer does not implement the Eof symbol " +
                                 SoftJavaParsersym.orderedTerminalSymbols[SoftJavaParserprs.EOFT_SYMBOL]));
        } 

        try
        {
            btParser = new BacktrackingParser(this, prs, this);
        }
        catch (NotBacktrackParseTableException e)
        {
            throw new Error(new NotBacktrackParseTableException
                                ("Regenerate SoftJavaParserprs.java with -BACKTRACK option"));
        }
        catch (BadParseSymFileException e)
        {
            throw new Error(new BadParseSymFileException("Bad Parser Symbol File -- SoftJavaParsersym.java"));
        }
    }

    public String[] orderedTerminalSymbols() { return SoftJavaParsersym.orderedTerminalSymbols; }
    public String getTokenKindName(int kind) { return SoftJavaParsersym.orderedTerminalSymbols[kind]; }
    public int getEOFTokenKind() { return SoftJavaParserprs.EOFT_SYMBOL; }
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
        btParser.setMonitor(monitor);
        
        try
        {
            return (Ast) btParser.parse(error_repair_count);
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
            // Rule 1:  Goal ::= initialize CompilationUnit
            //
            case 1: {
                 // macro setSym1 is deprecated. Use function setResult
            getParser().setSym1(new Ast());
                break;
            }
     
            //
            // Rule 2:  Goal ::= initialize ConstructorBody
            //
            case 2: {
                 // macro setSym1 is deprecated. Use function setResult
            getParser().setSym1(new Ast());
                break;
            }
     
            //
            // Rule 3:  initialize ::= $Empty
            //
            case 3: {
                
                System.out.println("****Begin Parser: ");
                System.out.flush();
                 // macro setResult is deprecated. Use function setResult
             getParser().setSym1(null);
                break;
            }
     
            //
            // Rule 4:  identifier ::= IDENTIFIER
            //
            case 4: {
                if (getKind( // macro getToken is deprecated. Use function getRhsTokenIndex
            getParser().getToken(1)) != SoftJavaParsersym.TK_IDENTIFIER)
                {
                    System.out.println("Turning keyword " +
                                       getName( // macro getToken is deprecated. Use function getRhsTokenIndex
            getParser().getToken(1)) +
                                       " at " +
                                       getLine( // macro getToken is deprecated. Use function getRhsTokenIndex
            getParser().getToken(1)) +
                                       ":" +
                                       getColumn( // macro getToken is deprecated. Use function getRhsTokenIndex
            getParser().getToken(1)) +
                                       " into an identifier");
                }
                break;
            }
    
    
            default:
                break;
        }
        return;
    }
}

