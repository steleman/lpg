package javascriptparser;

import javascriptparser.Ast.*;
import lpg.javaruntime.*;

import javascriptparser.IAst;

public class JavascriptParser extends PrsStream implements RuleAction
{
    private boolean unimplementedSymbolsWarning = false;

    private static ParseTable prs = new JavascriptParserprs();
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

    public JavascriptParser(ILexStream lexStream)
    {
        super(lexStream);

        try
        {
            super.remapTerminalSymbols(orderedTerminalSymbols(), JavascriptParserprs.EOFT_SYMBOL);
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
                    System.out.println("    " + JavascriptParsersym.orderedTerminalSymbols[id.intValue()]);               
                }
                System.out.println();
            }
        }
        catch(UndefinedEofSymbolException e)
        {
            throw new Error(new UndefinedEofSymbolException
                                ("The Lexer does not implement the Eof symbol " +
                                 JavascriptParsersym.orderedTerminalSymbols[JavascriptParserprs.EOFT_SYMBOL]));
        }
        
        try
        {
            dtParser = new DeterministicParser(this, prs, this);
        }
        catch (NotDeterministicParseTableException e)
        {
            throw new Error(new NotDeterministicParseTableException
                                 ("Regenerate JavascriptParserprs.java with -NOBACKTRACK option"));
        }
        catch (BadParseSymFileException e)
        {
            throw new Error(new BadParseSymFileException("Bad Parser Symbol File -- JavascriptParsersym.java. Regenerate JavascriptParserprs.java"));
        }
    }

    public String[] orderedTerminalSymbols() { return JavascriptParsersym.orderedTerminalSymbols; }
    public String getTokenKindName(int kind) { return JavascriptParsersym.orderedTerminalSymbols[kind]; }            
    public int getEOFTokenKind() { return JavascriptParserprs.EOFT_SYMBOL; }
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
            // Rule 1:  no_line_break ::= NO_LINE_BREAK
            //
            case 1: {
                setResult(
                    new no_line_break(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 2:  Identifier ::= IDENTIFIER
            //
            case 2: {
                setResult(
                    new Identifier0(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 3:  Identifier ::= GET
            //
            case 3: {
                setResult(
                    new Identifier1(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 4:  Identifier ::= SET
            //
            case 4: {
                setResult(
                    new Identifier2(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 5:  Identifier ::= INCLUDE
            //
            case 5: {
                setResult(
                    new Identifier3(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 6:  SimpleQualifiedIdentifier ::= Identifier
            //
            case 6:
                break; 
            //
            // Rule 7:  SimpleQualifiedIdentifier ::= Identifier :: Identifier
            //
            case 7: {
                setResult(
                    new SimpleQualifiedIdentifier0(getLeftIToken(), getRightIToken(),
                                                   (IIdentifier)getRhsSym(1),
                                                   new AstToken(getRhsIToken(2)),
                                                   (IIdentifier)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 8:  SimpleQualifiedIdentifier ::= ReservedNamespace :: Identifier
            //
            case 8: {
                setResult(
                    new SimpleQualifiedIdentifier1(getLeftIToken(), getRightIToken(),
                                                   (IReservedNamespace)getRhsSym(1),
                                                   new AstToken(getRhsIToken(2)),
                                                   (IIdentifier)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 9:  ExpressionQualifiedIdentifier ::= ParenExpression :: Identifier
            //
            case 9: {
                setResult(
                    new ExpressionQualifiedIdentifier(getLeftIToken(), getRightIToken(),
                                                      (ParenExpression)getRhsSym(1),
                                                      new AstToken(getRhsIToken(2)),
                                                      (IIdentifier)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 10:  QualifiedIdentifier ::= SimpleQualifiedIdentifier
            //
            case 10:
                break; 
            //
            // Rule 11:  QualifiedIdentifier ::= ExpressionQualifiedIdentifier
            //
            case 11:
                break; 
            //
            // Rule 12:  PrimaryExpression ::= NULL
            //
            case 12: {
                setResult(
                    new PrimaryExpression0(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 13:  PrimaryExpression ::= TRUE
            //
            case 13: {
                setResult(
                    new PrimaryExpression1(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 14:  PrimaryExpression ::= FALSE
            //
            case 14: {
                setResult(
                    new PrimaryExpression2(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 15:  PrimaryExpression ::= Number
            //
            case 15: {
                setResult(
                    new PrimaryExpression3(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 16:  PrimaryExpression ::= String
            //
            case 16: {
                setResult(
                    new PrimaryExpression4(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 17:  PrimaryExpression ::= THIS
            //
            case 17: {
                setResult(
                    new PrimaryExpression5(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 18:  PrimaryExpression ::= RegularExpression
            //
            case 18: {
                setResult(
                    new PrimaryExpression6(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 19:  PrimaryExpression ::= ReservedNamespace
            //
            case 19:
                break; 
            //
            // Rule 20:  PrimaryExpression ::= ParenListExpression
            //
            case 20:
                break; 
            //
            // Rule 21:  PrimaryExpression ::= ArrayLiteral
            //
            case 21:
                break; 
            //
            // Rule 22:  PrimaryExpression ::= ObjectLiteral
            //
            case 22:
                break; 
            //
            // Rule 23:  PrimaryExpression ::= FunctionExpression
            //
            case 23:
                break; 
            //
            // Rule 24:  ReservedNamespace ::= PUBLIC
            //
            case 24: {
                setResult(
                    new ReservedNamespace0(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 25:  ReservedNamespace ::= PRIVATE
            //
            case 25: {
                setResult(
                    new ReservedNamespace1(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 26:  ParenExpression ::= ( AssignmentExpression_allowIn )
            //
            case 26: {
                setResult(
                    new ParenExpression(getLeftIToken(), getRightIToken(),
                                        new AstToken(getRhsIToken(1)),
                                        (IAssignmentExpression_allowIn)getRhsSym(2),
                                        new AstToken(getRhsIToken(3)))
                );
                break;
            } 
            //
            // Rule 27:  ParenListExpression ::= ParenExpression
            //
            case 27:
                break; 
            //
            // Rule 28:  ParenListExpression ::= ( ListExpression_allowIn , AssignmentExpression_allowIn )
            //
            case 28: {
                setResult(
                    new ParenListExpression(getLeftIToken(), getRightIToken(),
                                            new AstToken(getRhsIToken(1)),
                                            (IListExpression_allowIn)getRhsSym(2),
                                            new AstToken(getRhsIToken(3)),
                                            (IAssignmentExpression_allowIn)getRhsSym(4),
                                            new AstToken(getRhsIToken(5)))
                );
                break;
            } 
            //
            // Rule 29:  FunctionExpression ::= FUNCTION FunctionCommon
            //
            case 29: {
                setResult(
                    new FunctionExpression0(getLeftIToken(), getRightIToken(),
                                            new AstToken(getRhsIToken(1)),
                                            (FunctionCommon)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 30:  FunctionExpression ::= FUNCTION Identifier FunctionCommon
            //
            case 30: {
                setResult(
                    new FunctionExpression1(getLeftIToken(), getRightIToken(),
                                            new AstToken(getRhsIToken(1)),
                                            (IIdentifier)getRhsSym(2),
                                            (FunctionCommon)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 31:  ObjectLiteral ::= { FieldList }
            //
            case 31: {
                setResult(
                    new ObjectLiteral(getLeftIToken(), getRightIToken(),
                                      new AstToken(getRhsIToken(1)),
                                      (IFieldList)getRhsSym(2),
                                      new AstToken(getRhsIToken(3)))
                );
                break;
            } 
            //
            // Rule 32:  FieldList ::= $Empty
            //
            case 32: {
                setResult(null);
                break;
            } 
            //
            // Rule 33:  FieldList ::= NonemptyFieldList
            //
            case 33:
                break; 
            //
            // Rule 34:  NonemptyFieldList ::= LiteralField
            //
            case 34:
                break; 
            //
            // Rule 35:  NonemptyFieldList ::= NonemptyFieldList , LiteralField
            //
            case 35: {
                setResult(
                    new NonemptyFieldList(getLeftIToken(), getRightIToken(),
                                          (INonemptyFieldList)getRhsSym(1),
                                          new AstToken(getRhsIToken(2)),
                                          (LiteralField)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 36:  LiteralField ::= FieldName : AssignmentExpression_allowIn
            //
            case 36: {
                setResult(
                    new LiteralField(getLeftIToken(), getRightIToken(),
                                     (IFieldName)getRhsSym(1),
                                     new AstToken(getRhsIToken(2)),
                                     (IAssignmentExpression_allowIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 37:  FieldName ::= QualifiedIdentifier
            //
            case 37:
                break; 
            //
            // Rule 38:  FieldName ::= String
            //
            case 38: {
                setResult(
                    new FieldName0(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 39:  FieldName ::= Number
            //
            case 39: {
                setResult(
                    new FieldName1(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 40:  FieldName ::= ParenExpression
            //
            case 40:
                break; 
            //
            // Rule 41:  ArrayLiteral ::= [ ElementList ]
            //
            case 41: {
                setResult(
                    new ArrayLiteral(getLeftIToken(), getRightIToken(),
                                     new AstToken(getRhsIToken(1)),
                                     (IElementList)getRhsSym(2),
                                     new AstToken(getRhsIToken(3)))
                );
                break;
            } 
            //
            // Rule 42:  ElementList ::= $Empty
            //
            case 42: {
                setResult(null);
                break;
            } 
            //
            // Rule 43:  ElementList ::= LiteralElement
            //
            case 43:
                break; 
            //
            // Rule 44:  ElementList ::= ElementList ,
            //
            case 44: {
                setResult(
                    new ElementList0(getLeftIToken(), getRightIToken(),
                                     (IElementList)getRhsSym(1),
                                     new AstToken(getRhsIToken(2)))
                );
                break;
            } 
            //
            // Rule 45:  ElementList ::= ElementList , LiteralElement
            //
            case 45: {
                setResult(
                    new ElementList1(getLeftIToken(), getRightIToken(),
                                     (IElementList)getRhsSym(1),
                                     new AstToken(getRhsIToken(2)),
                                     (ILiteralElement)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 46:  LiteralElement ::= AssignmentExpression_allowIn
            //
            case 46:
                break; 
            //
            // Rule 47:  SuperExpression ::= SUPER
            //
            case 47: {
                setResult(
                    new SuperExpression0(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 48:  SuperExpression ::= SUPER ParenExpression
            //
            case 48: {
                setResult(
                    new SuperExpression1(getLeftIToken(), getRightIToken(),
                                         new AstToken(getRhsIToken(1)),
                                         (ParenExpression)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 49:  PostfixExpression ::= AttributeExpression
            //
            case 49:
                break; 
            //
            // Rule 50:  PostfixExpression ::= FullPostfixExpression
            //
            case 50:
                break; 
            //
            // Rule 51:  PostfixExpression ::= ShortNewExpression
            //
            case 51:
                break; 
            //
            // Rule 52:  AttributeExpression ::= SimpleQualifiedIdentifier
            //
            case 52:
                break; 
            //
            // Rule 53:  AttributeExpression ::= AttributeExpression PropertyOperator
            //
            case 53: {
                setResult(
                    new AttributeExpression0(getLeftIToken(), getRightIToken(),
                                             (IAttributeExpression)getRhsSym(1),
                                             (IPropertyOperator)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 54:  AttributeExpression ::= AttributeExpression Arguments
            //
            case 54: {
                setResult(
                    new AttributeExpression1(getLeftIToken(), getRightIToken(),
                                             (IAttributeExpression)getRhsSym(1),
                                             (IArguments)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 55:  FullPostfixExpression ::= PrimaryExpression
            //
            case 55:
                break; 
            //
            // Rule 56:  FullPostfixExpression ::= ExpressionQualifiedIdentifier
            //
            case 56:
                break; 
            //
            // Rule 57:  FullPostfixExpression ::= FullNewExpression
            //
            case 57:
                break; 
            //
            // Rule 58:  FullPostfixExpression ::= FullPostfixExpression PropertyOperator
            //
            case 58: {
                setResult(
                    new FullPostfixExpression0(getLeftIToken(), getRightIToken(),
                                               (IFullPostfixExpression)getRhsSym(1),
                                               (IPropertyOperator)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 59:  FullPostfixExpression ::= SuperExpression PropertyOperator
            //
            case 59: {
                setResult(
                    new FullPostfixExpression1(getLeftIToken(), getRightIToken(),
                                               (ISuperExpression)getRhsSym(1),
                                               (IPropertyOperator)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 60:  FullPostfixExpression ::= FullPostfixExpression Arguments
            //
            case 60: {
                setResult(
                    new FullPostfixExpression2(getLeftIToken(), getRightIToken(),
                                               (IFullPostfixExpression)getRhsSym(1),
                                               (IArguments)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 61:  FullPostfixExpression ::= PostfixExpression no_line_break$ ++
            //
            case 61: {
                setResult(
                    new FullPostfixExpression3(getLeftIToken(), getRightIToken(),
                                               (IPostfixExpression)getRhsSym(1),
                                               new AstToken(getRhsIToken(3)))
                );
                break;
            } 
            //
            // Rule 62:  FullPostfixExpression ::= PostfixExpression no_line_break$ --
            //
            case 62: {
                setResult(
                    new FullPostfixExpression4(getLeftIToken(), getRightIToken(),
                                               (IPostfixExpression)getRhsSym(1),
                                               new AstToken(getRhsIToken(3)))
                );
                break;
            } 
            //
            // Rule 63:  FullNewExpression ::= NEW FullNewSubexpression Arguments
            //
            case 63: {
                setResult(
                    new FullNewExpression(getLeftIToken(), getRightIToken(),
                                          new AstToken(getRhsIToken(1)),
                                          (IFullNewSubexpression)getRhsSym(2),
                                          (IArguments)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 64:  FullNewSubexpression ::= PrimaryExpression
            //
            case 64:
                break; 
            //
            // Rule 65:  FullNewSubexpression ::= QualifiedIdentifier
            //
            case 65:
                break; 
            //
            // Rule 66:  FullNewSubexpression ::= FullNewExpression
            //
            case 66:
                break; 
            //
            // Rule 67:  FullNewSubexpression ::= FullNewSubexpression PropertyOperator
            //
            case 67: {
                setResult(
                    new FullNewSubexpression0(getLeftIToken(), getRightIToken(),
                                              (IFullNewSubexpression)getRhsSym(1),
                                              (IPropertyOperator)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 68:  FullNewSubexpression ::= SuperExpression PropertyOperator
            //
            case 68: {
                setResult(
                    new FullNewSubexpression1(getLeftIToken(), getRightIToken(),
                                              (ISuperExpression)getRhsSym(1),
                                              (IPropertyOperator)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 69:  ShortNewExpression ::= NEW ShortNewSubexpression
            //
            case 69: {
                setResult(
                    new ShortNewExpression(getLeftIToken(), getRightIToken(),
                                           new AstToken(getRhsIToken(1)),
                                           (IShortNewSubexpression)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 70:  ShortNewSubexpression ::= FullNewSubexpression
            //
            case 70:
                break; 
            //
            // Rule 71:  ShortNewSubexpression ::= ShortNewExpression
            //
            case 71:
                break; 
            //
            // Rule 72:  PropertyOperator ::= . QualifiedIdentifier
            //
            case 72: {
                setResult(
                    new PropertyOperator(getLeftIToken(), getRightIToken(),
                                         new AstToken(getRhsIToken(1)),
                                         (IQualifiedIdentifier)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 73:  PropertyOperator ::= Brackets
            //
            case 73:
                break; 
            //
            // Rule 74:  Brackets ::= [ ]
            //
            case 74: {
                setResult(
                    new Brackets0(getLeftIToken(), getRightIToken(),
                                  new AstToken(getRhsIToken(1)),
                                  new AstToken(getRhsIToken(2)))
                );
                break;
            } 
            //
            // Rule 75:  Brackets ::= [ ListExpression_allowIn ]
            //
            case 75: {
                setResult(
                    new Brackets1(getLeftIToken(), getRightIToken(),
                                  new AstToken(getRhsIToken(1)),
                                  (IListExpression_allowIn)getRhsSym(2),
                                  new AstToken(getRhsIToken(3)))
                );
                break;
            } 
            //
            // Rule 76:  Brackets ::= [ ExpressionsWithRest ]
            //
            case 76: {
                setResult(
                    new Brackets2(getLeftIToken(), getRightIToken(),
                                  new AstToken(getRhsIToken(1)),
                                  (IExpressionsWithRest)getRhsSym(2),
                                  new AstToken(getRhsIToken(3)))
                );
                break;
            } 
            //
            // Rule 77:  Arguments ::= ( )
            //
            case 77: {
                setResult(
                    new Arguments0(getLeftIToken(), getRightIToken(),
                                   new AstToken(getRhsIToken(1)),
                                   new AstToken(getRhsIToken(2)))
                );
                break;
            } 
            //
            // Rule 78:  Arguments ::= ParenListExpression
            //
            case 78:
                break; 
            //
            // Rule 79:  Arguments ::= ( ExpressionsWithRest )
            //
            case 79: {
                setResult(
                    new Arguments1(getLeftIToken(), getRightIToken(),
                                   new AstToken(getRhsIToken(1)),
                                   (IExpressionsWithRest)getRhsSym(2),
                                   new AstToken(getRhsIToken(3)))
                );
                break;
            } 
            //
            // Rule 80:  ExpressionsWithRest ::= RestExpression
            //
            case 80:
                break; 
            //
            // Rule 81:  ExpressionsWithRest ::= ListExpression_allowIn , RestExpression
            //
            case 81: {
                setResult(
                    new ExpressionsWithRest(getLeftIToken(), getRightIToken(),
                                            (IListExpression_allowIn)getRhsSym(1),
                                            new AstToken(getRhsIToken(2)),
                                            (RestExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 82:  RestExpression ::= ... AssignmentExpression_allowIn
            //
            case 82: {
                setResult(
                    new RestExpression(getLeftIToken(), getRightIToken(),
                                       new AstToken(getRhsIToken(1)),
                                       (IAssignmentExpression_allowIn)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 83:  UnaryExpression ::= PostfixExpression
            //
            case 83:
                break; 
            //
            // Rule 84:  UnaryExpression ::= DELETE PostfixExpression
            //
            case 84: {
                setResult(
                    new UnaryExpression0(getLeftIToken(), getRightIToken(),
                                         new AstToken(getRhsIToken(1)),
                                         (IPostfixExpression)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 85:  UnaryExpression ::= VOID UnaryExpression
            //
            case 85: {
                setResult(
                    new UnaryExpression1(getLeftIToken(), getRightIToken(),
                                         new AstToken(getRhsIToken(1)),
                                         (IUnaryExpression)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 86:  UnaryExpression ::= TYPEOF UnaryExpression
            //
            case 86: {
                setResult(
                    new UnaryExpression2(getLeftIToken(), getRightIToken(),
                                         new AstToken(getRhsIToken(1)),
                                         (IUnaryExpression)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 87:  UnaryExpression ::= ++ PostfixExpression
            //
            case 87: {
                setResult(
                    new UnaryExpression3(getLeftIToken(), getRightIToken(),
                                         new AstToken(getRhsIToken(1)),
                                         (IPostfixExpression)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 88:  UnaryExpression ::= -- PostfixExpression
            //
            case 88: {
                setResult(
                    new UnaryExpression4(getLeftIToken(), getRightIToken(),
                                         new AstToken(getRhsIToken(1)),
                                         (IPostfixExpression)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 89:  UnaryExpression ::= + UnaryExpression
            //
            case 89: {
                setResult(
                    new UnaryExpression5(getLeftIToken(), getRightIToken(),
                                         new AstToken(getRhsIToken(1)),
                                         (IUnaryExpression)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 90:  UnaryExpression ::= - UnaryExpression
            //
            case 90: {
                setResult(
                    new UnaryExpression6(getLeftIToken(), getRightIToken(),
                                         new AstToken(getRhsIToken(1)),
                                         (IUnaryExpression)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 91:  UnaryExpression ::= - NegatedMinLong
            //
            case 91: {
                setResult(
                    new UnaryExpression7(getLeftIToken(), getRightIToken(),
                                         new AstToken(getRhsIToken(1)),
                                         new AstToken(getRhsIToken(2)))
                );
                break;
            } 
            //
            // Rule 92:  UnaryExpression ::= ~ UnaryExpression
            //
            case 92: {
                setResult(
                    new UnaryExpression8(getLeftIToken(), getRightIToken(),
                                         new AstToken(getRhsIToken(1)),
                                         (IUnaryExpression)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 93:  UnaryExpression ::= ! UnaryExpression
            //
            case 93: {
                setResult(
                    new UnaryExpression9(getLeftIToken(), getRightIToken(),
                                         new AstToken(getRhsIToken(1)),
                                         (IUnaryExpression)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 94:  MultiplicativeExpression ::= UnaryExpression
            //
            case 94:
                break; 
            //
            // Rule 95:  MultiplicativeExpression ::= MultiplicativeExpression * UnaryExpression
            //
            case 95: {
                setResult(
                    new MultiplicativeExpression0(getLeftIToken(), getRightIToken(),
                                                  (IMultiplicativeExpression)getRhsSym(1),
                                                  new AstToken(getRhsIToken(2)),
                                                  (IUnaryExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 96:  MultiplicativeExpression ::= MultiplicativeExpression / UnaryExpression
            //
            case 96: {
                setResult(
                    new MultiplicativeExpression1(getLeftIToken(), getRightIToken(),
                                                  (IMultiplicativeExpression)getRhsSym(1),
                                                  new AstToken(getRhsIToken(2)),
                                                  (IUnaryExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 97:  MultiplicativeExpression ::= MultiplicativeExpression % UnaryExpression
            //
            case 97: {
                setResult(
                    new MultiplicativeExpression2(getLeftIToken(), getRightIToken(),
                                                  (IMultiplicativeExpression)getRhsSym(1),
                                                  new AstToken(getRhsIToken(2)),
                                                  (IUnaryExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 98:  AdditiveExpression ::= MultiplicativeExpression
            //
            case 98:
                break; 
            //
            // Rule 99:  AdditiveExpression ::= AdditiveExpression + MultiplicativeExpression
            //
            case 99: {
                setResult(
                    new AdditiveExpression0(getLeftIToken(), getRightIToken(),
                                            (IAdditiveExpression)getRhsSym(1),
                                            new AstToken(getRhsIToken(2)),
                                            (IMultiplicativeExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 100:  AdditiveExpression ::= AdditiveExpression - MultiplicativeExpression
            //
            case 100: {
                setResult(
                    new AdditiveExpression1(getLeftIToken(), getRightIToken(),
                                            (IAdditiveExpression)getRhsSym(1),
                                            new AstToken(getRhsIToken(2)),
                                            (IMultiplicativeExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 101:  ShiftExpression ::= AdditiveExpression
            //
            case 101:
                break; 
            //
            // Rule 102:  ShiftExpression ::= ShiftExpression << AdditiveExpression
            //
            case 102: {
                setResult(
                    new ShiftExpression0(getLeftIToken(), getRightIToken(),
                                         (IShiftExpression)getRhsSym(1),
                                         new AstToken(getRhsIToken(2)),
                                         (IAdditiveExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 103:  ShiftExpression ::= ShiftExpression >> AdditiveExpression
            //
            case 103: {
                setResult(
                    new ShiftExpression1(getLeftIToken(), getRightIToken(),
                                         (IShiftExpression)getRhsSym(1),
                                         new AstToken(getRhsIToken(2)),
                                         (IAdditiveExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 104:  ShiftExpression ::= ShiftExpression >>> AdditiveExpression
            //
            case 104: {
                setResult(
                    new ShiftExpression2(getLeftIToken(), getRightIToken(),
                                         (IShiftExpression)getRhsSym(1),
                                         new AstToken(getRhsIToken(2)),
                                         (IAdditiveExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 105:  RelationalExpression_allowIn ::= ShiftExpression
            //
            case 105:
                break; 
            //
            // Rule 106:  RelationalExpression_allowIn ::= RelationalExpression_allowIn < ShiftExpression
            //
            case 106: {
                setResult(
                    new RelationalExpression_allowIn0(getLeftIToken(), getRightIToken(),
                                                      (IRelationalExpression_allowIn)getRhsSym(1),
                                                      new AstToken(getRhsIToken(2)),
                                                      (IShiftExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 107:  RelationalExpression_allowIn ::= RelationalExpression_allowIn > ShiftExpression
            //
            case 107: {
                setResult(
                    new RelationalExpression_allowIn1(getLeftIToken(), getRightIToken(),
                                                      (IRelationalExpression_allowIn)getRhsSym(1),
                                                      new AstToken(getRhsIToken(2)),
                                                      (IShiftExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 108:  RelationalExpression_allowIn ::= RelationalExpression_allowIn <= ShiftExpression
            //
            case 108: {
                setResult(
                    new RelationalExpression_allowIn2(getLeftIToken(), getRightIToken(),
                                                      (IRelationalExpression_allowIn)getRhsSym(1),
                                                      new AstToken(getRhsIToken(2)),
                                                      (IShiftExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 109:  RelationalExpression_allowIn ::= RelationalExpression_allowIn >= ShiftExpression
            //
            case 109: {
                setResult(
                    new RelationalExpression_allowIn3(getLeftIToken(), getRightIToken(),
                                                      (IRelationalExpression_allowIn)getRhsSym(1),
                                                      new AstToken(getRhsIToken(2)),
                                                      (IShiftExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 110:  RelationalExpression_allowIn ::= RelationalExpression_allowIn IS ShiftExpression
            //
            case 110: {
                setResult(
                    new RelationalExpression_allowIn4(getLeftIToken(), getRightIToken(),
                                                      (IRelationalExpression_allowIn)getRhsSym(1),
                                                      new AstToken(getRhsIToken(2)),
                                                      (IShiftExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 111:  RelationalExpression_allowIn ::= RelationalExpression_allowIn AS ShiftExpression
            //
            case 111: {
                setResult(
                    new RelationalExpression_allowIn5(getLeftIToken(), getRightIToken(),
                                                      (IRelationalExpression_allowIn)getRhsSym(1),
                                                      new AstToken(getRhsIToken(2)),
                                                      (IShiftExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 112:  RelationalExpression_allowIn ::= RelationalExpression_allowIn IN ShiftExpression
            //
            case 112: {
                setResult(
                    new RelationalExpression_allowIn6(getLeftIToken(), getRightIToken(),
                                                      (IRelationalExpression_allowIn)getRhsSym(1),
                                                      new AstToken(getRhsIToken(2)),
                                                      (IShiftExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 113:  RelationalExpression_allowIn ::= RelationalExpression_allowIn INSTANCEOF ShiftExpression
            //
            case 113: {
                setResult(
                    new RelationalExpression_allowIn7(getLeftIToken(), getRightIToken(),
                                                      (IRelationalExpression_allowIn)getRhsSym(1),
                                                      new AstToken(getRhsIToken(2)),
                                                      (IShiftExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 114:  RelationalExpression_noIn ::= ShiftExpression
            //
            case 114:
                break; 
            //
            // Rule 115:  RelationalExpression_noIn ::= RelationalExpression_noIn < ShiftExpression
            //
            case 115: {
                setResult(
                    new RelationalExpression_noIn0(getLeftIToken(), getRightIToken(),
                                                   (IRelationalExpression_noIn)getRhsSym(1),
                                                   new AstToken(getRhsIToken(2)),
                                                   (IShiftExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 116:  RelationalExpression_noIn ::= RelationalExpression_noIn > ShiftExpression
            //
            case 116: {
                setResult(
                    new RelationalExpression_noIn1(getLeftIToken(), getRightIToken(),
                                                   (IRelationalExpression_noIn)getRhsSym(1),
                                                   new AstToken(getRhsIToken(2)),
                                                   (IShiftExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 117:  RelationalExpression_noIn ::= RelationalExpression_noIn <= ShiftExpression
            //
            case 117: {
                setResult(
                    new RelationalExpression_noIn2(getLeftIToken(), getRightIToken(),
                                                   (IRelationalExpression_noIn)getRhsSym(1),
                                                   new AstToken(getRhsIToken(2)),
                                                   (IShiftExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 118:  RelationalExpression_noIn ::= RelationalExpression_noIn >= ShiftExpression
            //
            case 118: {
                setResult(
                    new RelationalExpression_noIn3(getLeftIToken(), getRightIToken(),
                                                   (IRelationalExpression_noIn)getRhsSym(1),
                                                   new AstToken(getRhsIToken(2)),
                                                   (IShiftExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 119:  RelationalExpression_noIn ::= RelationalExpression_noIn IS ShiftExpression
            //
            case 119: {
                setResult(
                    new RelationalExpression_noIn4(getLeftIToken(), getRightIToken(),
                                                   (IRelationalExpression_noIn)getRhsSym(1),
                                                   new AstToken(getRhsIToken(2)),
                                                   (IShiftExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 120:  RelationalExpression_noIn ::= RelationalExpression_noIn AS ShiftExpression
            //
            case 120: {
                setResult(
                    new RelationalExpression_noIn5(getLeftIToken(), getRightIToken(),
                                                   (IRelationalExpression_noIn)getRhsSym(1),
                                                   new AstToken(getRhsIToken(2)),
                                                   (IShiftExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 121:  RelationalExpression_noIn ::= RelationalExpression_noIn INSTANCEOF ShiftExpression
            //
            case 121: {
                setResult(
                    new RelationalExpression_noIn6(getLeftIToken(), getRightIToken(),
                                                   (IRelationalExpression_noIn)getRhsSym(1),
                                                   new AstToken(getRhsIToken(2)),
                                                   (IShiftExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 122:  EqualityExpression_allowIn ::= RelationalExpression_allowIn
            //
            case 122:
                break; 
            //
            // Rule 123:  EqualityExpression_allowIn ::= EqualityExpression_allowIn == RelationalExpression_allowIn
            //
            case 123: {
                setResult(
                    new EqualityExpression_allowIn0(getLeftIToken(), getRightIToken(),
                                                    (IEqualityExpression_allowIn)getRhsSym(1),
                                                    new AstToken(getRhsIToken(2)),
                                                    (IRelationalExpression_allowIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 124:  EqualityExpression_allowIn ::= EqualityExpression_allowIn != RelationalExpression_allowIn
            //
            case 124: {
                setResult(
                    new EqualityExpression_allowIn1(getLeftIToken(), getRightIToken(),
                                                    (IEqualityExpression_allowIn)getRhsSym(1),
                                                    new AstToken(getRhsIToken(2)),
                                                    (IRelationalExpression_allowIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 125:  EqualityExpression_allowIn ::= EqualityExpression_allowIn === RelationalExpression_allowIn
            //
            case 125: {
                setResult(
                    new EqualityExpression_allowIn2(getLeftIToken(), getRightIToken(),
                                                    (IEqualityExpression_allowIn)getRhsSym(1),
                                                    new AstToken(getRhsIToken(2)),
                                                    (IRelationalExpression_allowIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 126:  EqualityExpression_allowIn ::= EqualityExpression_allowIn !== RelationalExpression_allowIn
            //
            case 126: {
                setResult(
                    new EqualityExpression_allowIn3(getLeftIToken(), getRightIToken(),
                                                    (IEqualityExpression_allowIn)getRhsSym(1),
                                                    new AstToken(getRhsIToken(2)),
                                                    (IRelationalExpression_allowIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 127:  EqualityExpression_noIn ::= RelationalExpression_noIn
            //
            case 127:
                break; 
            //
            // Rule 128:  EqualityExpression_noIn ::= EqualityExpression_noIn == RelationalExpression_noIn
            //
            case 128: {
                setResult(
                    new EqualityExpression_noIn0(getLeftIToken(), getRightIToken(),
                                                 (IEqualityExpression_noIn)getRhsSym(1),
                                                 new AstToken(getRhsIToken(2)),
                                                 (IRelationalExpression_noIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 129:  EqualityExpression_noIn ::= EqualityExpression_noIn != RelationalExpression_noIn
            //
            case 129: {
                setResult(
                    new EqualityExpression_noIn1(getLeftIToken(), getRightIToken(),
                                                 (IEqualityExpression_noIn)getRhsSym(1),
                                                 new AstToken(getRhsIToken(2)),
                                                 (IRelationalExpression_noIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 130:  EqualityExpression_noIn ::= EqualityExpression_noIn === RelationalExpression_noIn
            //
            case 130: {
                setResult(
                    new EqualityExpression_noIn2(getLeftIToken(), getRightIToken(),
                                                 (IEqualityExpression_noIn)getRhsSym(1),
                                                 new AstToken(getRhsIToken(2)),
                                                 (IRelationalExpression_noIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 131:  EqualityExpression_noIn ::= EqualityExpression_noIn !== RelationalExpression_noIn
            //
            case 131: {
                setResult(
                    new EqualityExpression_noIn3(getLeftIToken(), getRightIToken(),
                                                 (IEqualityExpression_noIn)getRhsSym(1),
                                                 new AstToken(getRhsIToken(2)),
                                                 (IRelationalExpression_noIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 132:  BitwiseAndExpression_allowIn ::= EqualityExpression_allowIn
            //
            case 132:
                break; 
            //
            // Rule 133:  BitwiseAndExpression_allowIn ::= BitwiseAndExpression_allowIn & EqualityExpression_allowIn
            //
            case 133: {
                setResult(
                    new BitwiseAndExpression_allowIn(getLeftIToken(), getRightIToken(),
                                                     (IBitwiseAndExpression_allowIn)getRhsSym(1),
                                                     new AstToken(getRhsIToken(2)),
                                                     (IEqualityExpression_allowIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 134:  BitwiseAndExpression_noIn ::= EqualityExpression_noIn
            //
            case 134:
                break; 
            //
            // Rule 135:  BitwiseAndExpression_noIn ::= BitwiseAndExpression_noIn & EqualityExpression_noIn
            //
            case 135: {
                setResult(
                    new BitwiseAndExpression_noIn(getLeftIToken(), getRightIToken(),
                                                  (IBitwiseAndExpression_noIn)getRhsSym(1),
                                                  new AstToken(getRhsIToken(2)),
                                                  (IEqualityExpression_noIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 136:  BitwiseXorExpression_allowIn ::= BitwiseAndExpression_allowIn
            //
            case 136:
                break; 
            //
            // Rule 137:  BitwiseXorExpression_allowIn ::= BitwiseXorExpression_allowIn ^ BitwiseAndExpression_allowIn
            //
            case 137: {
                setResult(
                    new BitwiseXorExpression_allowIn(getLeftIToken(), getRightIToken(),
                                                     (IBitwiseXorExpression_allowIn)getRhsSym(1),
                                                     new AstToken(getRhsIToken(2)),
                                                     (IBitwiseAndExpression_allowIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 138:  BitwiseXorExpression_noIn ::= BitwiseAndExpression_noIn
            //
            case 138:
                break; 
            //
            // Rule 139:  BitwiseXorExpression_noIn ::= BitwiseXorExpression_noIn ^ BitwiseAndExpression_noIn
            //
            case 139: {
                setResult(
                    new BitwiseXorExpression_noIn(getLeftIToken(), getRightIToken(),
                                                  (IBitwiseXorExpression_noIn)getRhsSym(1),
                                                  new AstToken(getRhsIToken(2)),
                                                  (IBitwiseAndExpression_noIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 140:  BitwiseOrExpression_allowIn ::= BitwiseXorExpression_allowIn
            //
            case 140:
                break; 
            //
            // Rule 141:  BitwiseOrExpression_allowIn ::= BitwiseOrExpression_allowIn | BitwiseXorExpression_allowIn
            //
            case 141: {
                setResult(
                    new BitwiseOrExpression_allowIn(getLeftIToken(), getRightIToken(),
                                                    (IBitwiseOrExpression_allowIn)getRhsSym(1),
                                                    new AstToken(getRhsIToken(2)),
                                                    (IBitwiseXorExpression_allowIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 142:  BitwiseOrExpression_noIn ::= BitwiseXorExpression_noIn
            //
            case 142:
                break; 
            //
            // Rule 143:  BitwiseOrExpression_noIn ::= BitwiseOrExpression_noIn | BitwiseXorExpression_noIn
            //
            case 143: {
                setResult(
                    new BitwiseOrExpression_noIn(getLeftIToken(), getRightIToken(),
                                                 (IBitwiseOrExpression_noIn)getRhsSym(1),
                                                 new AstToken(getRhsIToken(2)),
                                                 (IBitwiseXorExpression_noIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 144:  LogicalAndExpression_allowIn ::= BitwiseOrExpression_allowIn
            //
            case 144:
                break; 
            //
            // Rule 145:  LogicalAndExpression_allowIn ::= LogicalAndExpression_allowIn && BitwiseOrExpression_allowIn
            //
            case 145: {
                setResult(
                    new LogicalAndExpression_allowIn(getLeftIToken(), getRightIToken(),
                                                     (ILogicalAndExpression_allowIn)getRhsSym(1),
                                                     new AstToken(getRhsIToken(2)),
                                                     (IBitwiseOrExpression_allowIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 146:  LogicalAndExpression_noIn ::= BitwiseOrExpression_noIn
            //
            case 146:
                break; 
            //
            // Rule 147:  LogicalAndExpression_noIn ::= LogicalAndExpression_noIn && BitwiseOrExpression_noIn
            //
            case 147: {
                setResult(
                    new LogicalAndExpression_noIn(getLeftIToken(), getRightIToken(),
                                                  (ILogicalAndExpression_noIn)getRhsSym(1),
                                                  new AstToken(getRhsIToken(2)),
                                                  (IBitwiseOrExpression_noIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 148:  LogicalXorExpression_allowIn ::= LogicalAndExpression_allowIn
            //
            case 148:
                break; 
            //
            // Rule 149:  LogicalXorExpression_allowIn ::= LogicalXorExpression_allowIn ^^ LogicalAndExpression_allowIn
            //
            case 149: {
                setResult(
                    new LogicalXorExpression_allowIn(getLeftIToken(), getRightIToken(),
                                                     (ILogicalXorExpression_allowIn)getRhsSym(1),
                                                     new AstToken(getRhsIToken(2)),
                                                     (ILogicalAndExpression_allowIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 150:  LogicalXorExpression_noIn ::= LogicalAndExpression_noIn
            //
            case 150:
                break; 
            //
            // Rule 151:  LogicalXorExpression_noIn ::= LogicalXorExpression_noIn ^^ LogicalAndExpression_noIn
            //
            case 151: {
                setResult(
                    new LogicalXorExpression_noIn(getLeftIToken(), getRightIToken(),
                                                  (ILogicalXorExpression_noIn)getRhsSym(1),
                                                  new AstToken(getRhsIToken(2)),
                                                  (ILogicalAndExpression_noIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 152:  LogicalOrExpression_allowIn ::= LogicalXorExpression_allowIn
            //
            case 152:
                break; 
            //
            // Rule 153:  LogicalOrExpression_allowIn ::= LogicalOrExpression_allowIn || LogicalXorExpression_allowIn
            //
            case 153: {
                setResult(
                    new LogicalOrExpression_allowIn(getLeftIToken(), getRightIToken(),
                                                    (ILogicalOrExpression_allowIn)getRhsSym(1),
                                                    new AstToken(getRhsIToken(2)),
                                                    (ILogicalXorExpression_allowIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 154:  LogicalOrExpression_noIn ::= LogicalXorExpression_noIn
            //
            case 154:
                break; 
            //
            // Rule 155:  LogicalOrExpression_noIn ::= LogicalOrExpression_noIn || LogicalXorExpression_noIn
            //
            case 155: {
                setResult(
                    new LogicalOrExpression_noIn(getLeftIToken(), getRightIToken(),
                                                 (ILogicalOrExpression_noIn)getRhsSym(1),
                                                 new AstToken(getRhsIToken(2)),
                                                 (ILogicalXorExpression_noIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 156:  ConditionalExpression_allowIn ::= LogicalOrExpression_allowIn
            //
            case 156:
                break; 
            //
            // Rule 157:  ConditionalExpression_allowIn ::= LogicalOrExpression_allowIn ? AssignmentExpression_allowIn : AssignmentExpression_allowIn
            //
            case 157: {
                setResult(
                    new ConditionalExpression_allowIn(getLeftIToken(), getRightIToken(),
                                                      (ILogicalOrExpression_allowIn)getRhsSym(1),
                                                      new AstToken(getRhsIToken(2)),
                                                      (IAssignmentExpression_allowIn)getRhsSym(3),
                                                      new AstToken(getRhsIToken(4)),
                                                      (IAssignmentExpression_allowIn)getRhsSym(5))
                );
                break;
            } 
            //
            // Rule 158:  ConditionalExpression_noIn ::= LogicalOrExpression_noIn
            //
            case 158:
                break; 
            //
            // Rule 159:  ConditionalExpression_noIn ::= LogicalOrExpression_noIn ? AssignmentExpression_noIn : AssignmentExpression_noIn
            //
            case 159: {
                setResult(
                    new ConditionalExpression_noIn(getLeftIToken(), getRightIToken(),
                                                   (ILogicalOrExpression_noIn)getRhsSym(1),
                                                   new AstToken(getRhsIToken(2)),
                                                   (IAssignmentExpression_noIn)getRhsSym(3),
                                                   new AstToken(getRhsIToken(4)),
                                                   (IAssignmentExpression_noIn)getRhsSym(5))
                );
                break;
            } 
            //
            // Rule 160:  NonAssignmentExpression_allowIn ::= LogicalOrExpression_allowIn
            //
            case 160:
                break; 
            //
            // Rule 161:  NonAssignmentExpression_allowIn ::= LogicalOrExpression_allowIn ? NonAssignmentExpression_allowIn : NonAssignmentExpression_allowIn
            //
            case 161: {
                setResult(
                    new NonAssignmentExpression_allowIn(getLeftIToken(), getRightIToken(),
                                                        (ILogicalOrExpression_allowIn)getRhsSym(1),
                                                        new AstToken(getRhsIToken(2)),
                                                        (INonAssignmentExpression_allowIn)getRhsSym(3),
                                                        new AstToken(getRhsIToken(4)),
                                                        (INonAssignmentExpression_allowIn)getRhsSym(5))
                );
                break;
            } 
            //
            // Rule 162:  NonAssignmentExpression_noIn ::= LogicalOrExpression_noIn
            //
            case 162:
                break; 
            //
            // Rule 163:  NonAssignmentExpression_noIn ::= LogicalOrExpression_noIn ? NonAssignmentExpression_noIn : NonAssignmentExpression_noIn
            //
            case 163: {
                setResult(
                    new NonAssignmentExpression_noIn(getLeftIToken(), getRightIToken(),
                                                     (ILogicalOrExpression_noIn)getRhsSym(1),
                                                     new AstToken(getRhsIToken(2)),
                                                     (INonAssignmentExpression_noIn)getRhsSym(3),
                                                     new AstToken(getRhsIToken(4)),
                                                     (INonAssignmentExpression_noIn)getRhsSym(5))
                );
                break;
            } 
            //
            // Rule 164:  AssignmentExpression_allowIn ::= ConditionalExpression_allowIn
            //
            case 164:
                break; 
            //
            // Rule 165:  AssignmentExpression_allowIn ::= PostfixExpression = AssignmentExpression_allowIn
            //
            case 165: {
                setResult(
                    new AssignmentExpression_allowIn0(getLeftIToken(), getRightIToken(),
                                                      (IPostfixExpression)getRhsSym(1),
                                                      new AstToken(getRhsIToken(2)),
                                                      (IAssignmentExpression_allowIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 166:  AssignmentExpression_allowIn ::= PostfixExpression CompoundAssignment AssignmentExpression_allowIn
            //
            case 166: {
                setResult(
                    new AssignmentExpression_allowIn1(getLeftIToken(), getRightIToken(),
                                                      (IPostfixExpression)getRhsSym(1),
                                                      (ICompoundAssignment)getRhsSym(2),
                                                      (IAssignmentExpression_allowIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 167:  AssignmentExpression_allowIn ::= PostfixExpression LogicalAssignment AssignmentExpression_allowIn
            //
            case 167: {
                setResult(
                    new AssignmentExpression_allowIn2(getLeftIToken(), getRightIToken(),
                                                      (IPostfixExpression)getRhsSym(1),
                                                      (ILogicalAssignment)getRhsSym(2),
                                                      (IAssignmentExpression_allowIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 168:  AssignmentExpression_noIn ::= ConditionalExpression_noIn
            //
            case 168:
                break; 
            //
            // Rule 169:  AssignmentExpression_noIn ::= PostfixExpression = AssignmentExpression_noIn
            //
            case 169: {
                setResult(
                    new AssignmentExpression_noIn0(getLeftIToken(), getRightIToken(),
                                                   (IPostfixExpression)getRhsSym(1),
                                                   new AstToken(getRhsIToken(2)),
                                                   (IAssignmentExpression_noIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 170:  AssignmentExpression_noIn ::= PostfixExpression CompoundAssignment AssignmentExpression_noIn
            //
            case 170: {
                setResult(
                    new AssignmentExpression_noIn1(getLeftIToken(), getRightIToken(),
                                                   (IPostfixExpression)getRhsSym(1),
                                                   (ICompoundAssignment)getRhsSym(2),
                                                   (IAssignmentExpression_noIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 171:  AssignmentExpression_noIn ::= PostfixExpression LogicalAssignment AssignmentExpression_noIn
            //
            case 171: {
                setResult(
                    new AssignmentExpression_noIn2(getLeftIToken(), getRightIToken(),
                                                   (IPostfixExpression)getRhsSym(1),
                                                   (ILogicalAssignment)getRhsSym(2),
                                                   (IAssignmentExpression_noIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 172:  CompoundAssignment ::= *=
            //
            case 172: {
                setResult(
                    new CompoundAssignment0(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 173:  CompoundAssignment ::= /=
            //
            case 173: {
                setResult(
                    new CompoundAssignment1(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 174:  CompoundAssignment ::= %=
            //
            case 174: {
                setResult(
                    new CompoundAssignment2(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 175:  CompoundAssignment ::= +=
            //
            case 175: {
                setResult(
                    new CompoundAssignment3(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 176:  CompoundAssignment ::= -=
            //
            case 176: {
                setResult(
                    new CompoundAssignment4(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 177:  CompoundAssignment ::= <<=
            //
            case 177: {
                setResult(
                    new CompoundAssignment5(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 178:  CompoundAssignment ::= >>=
            //
            case 178: {
                setResult(
                    new CompoundAssignment6(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 179:  CompoundAssignment ::= >>>=
            //
            case 179: {
                setResult(
                    new CompoundAssignment7(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 180:  CompoundAssignment ::= &=
            //
            case 180: {
                setResult(
                    new CompoundAssignment8(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 181:  CompoundAssignment ::= ^=
            //
            case 181: {
                setResult(
                    new CompoundAssignment9(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 182:  CompoundAssignment ::= |=
            //
            case 182: {
                setResult(
                    new CompoundAssignment10(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 183:  LogicalAssignment ::= &&=
            //
            case 183: {
                setResult(
                    new LogicalAssignment0(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 184:  LogicalAssignment ::= ^^=
            //
            case 184: {
                setResult(
                    new LogicalAssignment1(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 185:  LogicalAssignment ::= ||=
            //
            case 185: {
                setResult(
                    new LogicalAssignment2(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 186:  ListExpression_allowIn ::= AssignmentExpression_allowIn
            //
            case 186:
                break; 
            //
            // Rule 187:  ListExpression_allowIn ::= ListExpression_allowIn , AssignmentExpression_allowIn
            //
            case 187: {
                setResult(
                    new ListExpression_allowIn(getLeftIToken(), getRightIToken(),
                                               (IListExpression_allowIn)getRhsSym(1),
                                               new AstToken(getRhsIToken(2)),
                                               (IAssignmentExpression_allowIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 188:  ListExpression_noIn ::= AssignmentExpression_noIn
            //
            case 188:
                break; 
            //
            // Rule 189:  ListExpression_noIn ::= ListExpression_noIn , AssignmentExpression_noIn
            //
            case 189: {
                setResult(
                    new ListExpression_noIn(getLeftIToken(), getRightIToken(),
                                            (IListExpression_noIn)getRhsSym(1),
                                            new AstToken(getRhsIToken(2)),
                                            (IAssignmentExpression_noIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 190:  TypeExpression_allowIn ::= NonAssignmentExpression_allowIn
            //
            case 190:
                break; 
            //
            // Rule 191:  TypeExpression_noIn ::= NonAssignmentExpression_noIn
            //
            case 191:
                break; 
            //
            // Rule 192:  Statement_abbrev ::= ExpressionStatement Semicolon_abbrev
            //
            case 192: {
                setResult(
                    new Statement_abbrev0(getLeftIToken(), getRightIToken(),
                                          (IExpressionStatement)getRhsSym(1),
                                          (ISemicolon_abbrev)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 193:  Statement_abbrev ::= SuperStatement Semicolon_abbrev
            //
            case 193: {
                setResult(
                    new Statement_abbrev1(getLeftIToken(), getRightIToken(),
                                          (SuperStatement)getRhsSym(1),
                                          (ISemicolon_abbrev)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 194:  Statement_abbrev ::= Block
            //
            case 194:
                break; 
            //
            // Rule 195:  Statement_abbrev ::= LabeledStatement_abbrev
            //
            case 195:
                break; 
            //
            // Rule 196:  Statement_abbrev ::= IfStatement_abbrev
            //
            case 196:
                break; 
            //
            // Rule 197:  Statement_abbrev ::= SwitchStatement
            //
            case 197:
                break; 
            //
            // Rule 198:  Statement_abbrev ::= DoStatement Semicolon_abbrev
            //
            case 198: {
                setResult(
                    new Statement_abbrev2(getLeftIToken(), getRightIToken(),
                                          (DoStatement)getRhsSym(1),
                                          (ISemicolon_abbrev)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 199:  Statement_abbrev ::= WhileStatement_abbrev
            //
            case 199:
                break; 
            //
            // Rule 200:  Statement_abbrev ::= ForStatement_abbrev
            //
            case 200:
                break; 
            //
            // Rule 201:  Statement_abbrev ::= WithStatement_abbrev
            //
            case 201:
                break; 
            //
            // Rule 202:  Statement_abbrev ::= ContinueStatement Semicolon_abbrev
            //
            case 202: {
                setResult(
                    new Statement_abbrev3(getLeftIToken(), getRightIToken(),
                                          (IContinueStatement)getRhsSym(1),
                                          (ISemicolon_abbrev)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 203:  Statement_abbrev ::= BreakStatement Semicolon_abbrev
            //
            case 203: {
                setResult(
                    new Statement_abbrev4(getLeftIToken(), getRightIToken(),
                                          (IBreakStatement)getRhsSym(1),
                                          (ISemicolon_abbrev)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 204:  Statement_abbrev ::= ReturnStatement Semicolon_abbrev
            //
            case 204: {
                setResult(
                    new Statement_abbrev5(getLeftIToken(), getRightIToken(),
                                          (IReturnStatement)getRhsSym(1),
                                          (ISemicolon_abbrev)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 205:  Statement_abbrev ::= ThrowStatement Semicolon_abbrev
            //
            case 205: {
                setResult(
                    new Statement_abbrev6(getLeftIToken(), getRightIToken(),
                                          (ThrowStatement)getRhsSym(1),
                                          (ISemicolon_abbrev)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 206:  Statement_abbrev ::= TryStatement
            //
            case 206:
                break; 
            //
            // Rule 207:  Statement_noShortIf ::= ExpressionStatement Semicolon_noShortIf
            //
            case 207: {
                setResult(
                    new Statement_noShortIf0(getLeftIToken(), getRightIToken(),
                                             (IExpressionStatement)getRhsSym(1),
                                             (ISemicolon_noShortIf)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 208:  Statement_noShortIf ::= SuperStatement Semicolon_noShortIf
            //
            case 208: {
                setResult(
                    new Statement_noShortIf1(getLeftIToken(), getRightIToken(),
                                             (SuperStatement)getRhsSym(1),
                                             (ISemicolon_noShortIf)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 209:  Statement_noShortIf ::= Block
            //
            case 209:
                break; 
            //
            // Rule 210:  Statement_noShortIf ::= LabeledStatement_noShortIf
            //
            case 210:
                break; 
            //
            // Rule 211:  Statement_noShortIf ::= IfStatement_noShortIf
            //
            case 211:
                break; 
            //
            // Rule 212:  Statement_noShortIf ::= SwitchStatement
            //
            case 212:
                break; 
            //
            // Rule 213:  Statement_noShortIf ::= DoStatement Semicolon_noShortIf
            //
            case 213: {
                setResult(
                    new Statement_noShortIf2(getLeftIToken(), getRightIToken(),
                                             (DoStatement)getRhsSym(1),
                                             (ISemicolon_noShortIf)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 214:  Statement_noShortIf ::= WhileStatement_noShortIf
            //
            case 214:
                break; 
            //
            // Rule 215:  Statement_noShortIf ::= ForStatement_noShortIf
            //
            case 215:
                break; 
            //
            // Rule 216:  Statement_noShortIf ::= WithStatement_noShortIf
            //
            case 216:
                break; 
            //
            // Rule 217:  Statement_noShortIf ::= ContinueStatement Semicolon_noShortIf
            //
            case 217: {
                setResult(
                    new Statement_noShortIf3(getLeftIToken(), getRightIToken(),
                                             (IContinueStatement)getRhsSym(1),
                                             (ISemicolon_noShortIf)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 218:  Statement_noShortIf ::= BreakStatement Semicolon_noShortIf
            //
            case 218: {
                setResult(
                    new Statement_noShortIf4(getLeftIToken(), getRightIToken(),
                                             (IBreakStatement)getRhsSym(1),
                                             (ISemicolon_noShortIf)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 219:  Statement_noShortIf ::= ReturnStatement Semicolon_noShortIf
            //
            case 219: {
                setResult(
                    new Statement_noShortIf5(getLeftIToken(), getRightIToken(),
                                             (IReturnStatement)getRhsSym(1),
                                             (ISemicolon_noShortIf)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 220:  Statement_noShortIf ::= ThrowStatement Semicolon_noShortIf
            //
            case 220: {
                setResult(
                    new Statement_noShortIf6(getLeftIToken(), getRightIToken(),
                                             (ThrowStatement)getRhsSym(1),
                                             (ISemicolon_noShortIf)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 221:  Statement_noShortIf ::= TryStatement
            //
            case 221:
                break; 
            //
            // Rule 222:  Statement_full ::= ExpressionStatement Semicolon_full
            //
            case 222: {
                setResult(
                    new Statement_full0(getLeftIToken(), getRightIToken(),
                                        (IExpressionStatement)getRhsSym(1),
                                        (ISemicolon_full)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 223:  Statement_full ::= SuperStatement Semicolon_full
            //
            case 223: {
                setResult(
                    new Statement_full1(getLeftIToken(), getRightIToken(),
                                        (SuperStatement)getRhsSym(1),
                                        (ISemicolon_full)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 224:  Statement_full ::= Block
            //
            case 224:
                break; 
            //
            // Rule 225:  Statement_full ::= LabeledStatement_full
            //
            case 225:
                break; 
            //
            // Rule 226:  Statement_full ::= IfStatement_full
            //
            case 226:
                break; 
            //
            // Rule 227:  Statement_full ::= SwitchStatement
            //
            case 227:
                break; 
            //
            // Rule 228:  Statement_full ::= DoStatement Semicolon_full
            //
            case 228: {
                setResult(
                    new Statement_full2(getLeftIToken(), getRightIToken(),
                                        (DoStatement)getRhsSym(1),
                                        (ISemicolon_full)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 229:  Statement_full ::= WhileStatement_full
            //
            case 229:
                break; 
            //
            // Rule 230:  Statement_full ::= ForStatement_full
            //
            case 230:
                break; 
            //
            // Rule 231:  Statement_full ::= WithStatement_full
            //
            case 231:
                break; 
            //
            // Rule 232:  Statement_full ::= ContinueStatement Semicolon_full
            //
            case 232: {
                setResult(
                    new Statement_full3(getLeftIToken(), getRightIToken(),
                                        (IContinueStatement)getRhsSym(1),
                                        (ISemicolon_full)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 233:  Statement_full ::= BreakStatement Semicolon_full
            //
            case 233: {
                setResult(
                    new Statement_full4(getLeftIToken(), getRightIToken(),
                                        (IBreakStatement)getRhsSym(1),
                                        (ISemicolon_full)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 234:  Statement_full ::= ReturnStatement Semicolon_full
            //
            case 234: {
                setResult(
                    new Statement_full5(getLeftIToken(), getRightIToken(),
                                        (IReturnStatement)getRhsSym(1),
                                        (ISemicolon_full)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 235:  Statement_full ::= ThrowStatement Semicolon_full
            //
            case 235: {
                setResult(
                    new Statement_full6(getLeftIToken(), getRightIToken(),
                                        (ThrowStatement)getRhsSym(1),
                                        (ISemicolon_full)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 236:  Statement_full ::= TryStatement
            //
            case 236:
                break; 
            //
            // Rule 237:  Substatement_abbrev ::= EmptyStatement
            //
            case 237:
                break; 
            //
            // Rule 238:  Substatement_abbrev ::= Statement_abbrev
            //
            case 238:
                break; 
            //
            // Rule 239:  Substatement_abbrev ::= SimpleVariableDefinition Semicolon_abbrev
            //
            case 239: {
                setResult(
                    new Substatement_abbrev0(getLeftIToken(), getRightIToken(),
                                             (SimpleVariableDefinition)getRhsSym(1),
                                             (ISemicolon_abbrev)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 240:  Substatement_abbrev ::= Attributes no_line_break$ { Substatements }
            //
            case 240: {
                setResult(
                    new Substatement_abbrev1(getLeftIToken(), getRightIToken(),
                                             (IAttributes)getRhsSym(1),
                                             new AstToken(getRhsIToken(3)),
                                             (Substatements)getRhsSym(4),
                                             new AstToken(getRhsIToken(5)))
                );
                break;
            } 
            //
            // Rule 241:  Substatement_noShortIf ::= EmptyStatement
            //
            case 241:
                break; 
            //
            // Rule 242:  Substatement_noShortIf ::= Statement_noShortIf
            //
            case 242:
                break; 
            //
            // Rule 243:  Substatement_noShortIf ::= SimpleVariableDefinition Semicolon_noShortIf
            //
            case 243: {
                setResult(
                    new Substatement_noShortIf0(getLeftIToken(), getRightIToken(),
                                                (SimpleVariableDefinition)getRhsSym(1),
                                                (ISemicolon_noShortIf)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 244:  Substatement_noShortIf ::= Attributes no_line_break$ { Substatements }
            //
            case 244: {
                setResult(
                    new Substatement_noShortIf1(getLeftIToken(), getRightIToken(),
                                                (IAttributes)getRhsSym(1),
                                                new AstToken(getRhsIToken(3)),
                                                (Substatements)getRhsSym(4),
                                                new AstToken(getRhsIToken(5)))
                );
                break;
            } 
            //
            // Rule 245:  Substatement_full ::= EmptyStatement
            //
            case 245:
                break; 
            //
            // Rule 246:  Substatement_full ::= Statement_full
            //
            case 246:
                break; 
            //
            // Rule 247:  Substatement_full ::= SimpleVariableDefinition Semicolon_full
            //
            case 247: {
                setResult(
                    new Substatement_full0(getLeftIToken(), getRightIToken(),
                                           (SimpleVariableDefinition)getRhsSym(1),
                                           (ISemicolon_full)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 248:  Substatement_full ::= Attributes no_line_break$ { Substatements }
            //
            case 248: {
                setResult(
                    new Substatement_full1(getLeftIToken(), getRightIToken(),
                                           (IAttributes)getRhsSym(1),
                                           new AstToken(getRhsIToken(3)),
                                           (Substatements)getRhsSym(4),
                                           new AstToken(getRhsIToken(5)))
                );
                break;
            } 
            //
            // Rule 249:  Substatements ::= $Empty
            //
            case 249: {
                setResult(null);
                break;
            } 
            //
            // Rule 250:  Substatements ::= SubstatementsPrefix Substatement_abbrev
            //
            case 250: {
                setResult(
                    new Substatements(getLeftIToken(), getRightIToken(),
                                      (SubstatementsPrefix)getRhsSym(1),
                                      (ISubstatement_abbrev)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 251:  SubstatementsPrefix ::= $Empty
            //
            case 251: {
                setResult(null);
                break;
            } 
            //
            // Rule 252:  SubstatementsPrefix ::= SubstatementsPrefix Substatement_full
            //
            case 252: {
                setResult(
                    new SubstatementsPrefix(getLeftIToken(), getRightIToken(),
                                            (SubstatementsPrefix)getRhsSym(1),
                                            (ISubstatement_full)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 253:  Semicolon_abbrev ::= ;
            //
            case 253: {
                setResult(
                    new Semicolon_abbrev0(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 254:  Semicolon_abbrev ::= VirtualSemicolon
            //
            case 254: {
                setResult(
                    new Semicolon_abbrev1(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 255:  Semicolon_abbrev ::= $Empty
            //
            case 255: {
                setResult(null);
                break;
            } 
            //
            // Rule 256:  Semicolon_noShortIf ::= ;
            //
            case 256: {
                setResult(
                    new Semicolon_noShortIf0(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 257:  Semicolon_noShortIf ::= VirtualSemicolon
            //
            case 257: {
                setResult(
                    new Semicolon_noShortIf1(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 258:  Semicolon_noShortIf ::= $Empty
            //
            case 258: {
                setResult(null);
                break;
            } 
            //
            // Rule 259:  Semicolon_full ::= ;
            //
            case 259: {
                setResult(
                    new Semicolon_full0(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 260:  Semicolon_full ::= VirtualSemicolon
            //
            case 260: {
                setResult(
                    new Semicolon_full1(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 261:  EmptyStatement ::= ;
            //
            case 261: {
                setResult(
                    new EmptyStatement(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 262:  SuperStatement ::= SUPER Arguments
            //
            case 262: {
                setResult(
                    new SuperStatement(getLeftIToken(), getRightIToken(),
                                       new AstToken(getRhsIToken(1)),
                                       (IArguments)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 263:  Block ::= { Directives }
            //
            case 263: {
                setResult(
                    new Block(getLeftIToken(), getRightIToken(),
                              new AstToken(getRhsIToken(1)),
                              (IDirectives)getRhsSym(2),
                              new AstToken(getRhsIToken(3)))
                );
                break;
            } 
            //
            // Rule 264:  LabeledStatement_abbrev ::= Identifier : Substatement_abbrev
            //
            case 264: {
                setResult(
                    new LabeledStatement_abbrev(getLeftIToken(), getRightIToken(),
                                                (IIdentifier)getRhsSym(1),
                                                new AstToken(getRhsIToken(2)),
                                                (ISubstatement_abbrev)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 265:  LabeledStatement_noShortIf ::= Identifier : Substatement_noShortIf
            //
            case 265: {
                setResult(
                    new LabeledStatement_noShortIf(getLeftIToken(), getRightIToken(),
                                                   (IIdentifier)getRhsSym(1),
                                                   new AstToken(getRhsIToken(2)),
                                                   (ISubstatement_noShortIf)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 266:  LabeledStatement_full ::= Identifier : Substatement_full
            //
            case 266: {
                setResult(
                    new LabeledStatement_full(getLeftIToken(), getRightIToken(),
                                              (IIdentifier)getRhsSym(1),
                                              new AstToken(getRhsIToken(2)),
                                              (ISubstatement_full)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 267:  IfStatement_abbrev ::= IF ParenListExpression Substatement_abbrev
            //
            case 267: {
                setResult(
                    new IfStatement_abbrev0(getLeftIToken(), getRightIToken(),
                                            new AstToken(getRhsIToken(1)),
                                            (IParenListExpression)getRhsSym(2),
                                            (ISubstatement_abbrev)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 268:  IfStatement_abbrev ::= IF ParenListExpression Substatement_noShortIf ELSE Substatement_abbrev
            //
            case 268: {
                setResult(
                    new IfStatement_abbrev1(getLeftIToken(), getRightIToken(),
                                            new AstToken(getRhsIToken(1)),
                                            (IParenListExpression)getRhsSym(2),
                                            (ISubstatement_noShortIf)getRhsSym(3),
                                            new AstToken(getRhsIToken(4)),
                                            (ISubstatement_abbrev)getRhsSym(5))
                );
                break;
            } 
            //
            // Rule 269:  IfStatement_full ::= IF ParenListExpression Substatement_full
            //
            case 269: {
                setResult(
                    new IfStatement_full0(getLeftIToken(), getRightIToken(),
                                          new AstToken(getRhsIToken(1)),
                                          (IParenListExpression)getRhsSym(2),
                                          (ISubstatement_full)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 270:  IfStatement_full ::= IF ParenListExpression Substatement_noShortIf ELSE Substatement_full
            //
            case 270: {
                setResult(
                    new IfStatement_full1(getLeftIToken(), getRightIToken(),
                                          new AstToken(getRhsIToken(1)),
                                          (IParenListExpression)getRhsSym(2),
                                          (ISubstatement_noShortIf)getRhsSym(3),
                                          new AstToken(getRhsIToken(4)),
                                          (ISubstatement_full)getRhsSym(5))
                );
                break;
            } 
            //
            // Rule 271:  IfStatement_noShortIf ::= IF ParenListExpression Substatement_noShortIf ELSE Substatement_noShortIf
            //
            case 271: {
                setResult(
                    new IfStatement_noShortIf(getLeftIToken(), getRightIToken(),
                                              new AstToken(getRhsIToken(1)),
                                              (IParenListExpression)getRhsSym(2),
                                              (ISubstatement_noShortIf)getRhsSym(3),
                                              new AstToken(getRhsIToken(4)),
                                              (ISubstatement_noShortIf)getRhsSym(5))
                );
                break;
            } 
            //
            // Rule 272:  SwitchStatement ::= SWITCH ParenListExpression { CaseElements }
            //
            case 272: {
                setResult(
                    new SwitchStatement(getLeftIToken(), getRightIToken(),
                                        new AstToken(getRhsIToken(1)),
                                        (IParenListExpression)getRhsSym(2),
                                        new AstToken(getRhsIToken(3)),
                                        (ICaseElements)getRhsSym(4),
                                        new AstToken(getRhsIToken(5)))
                );
                break;
            } 
            //
            // Rule 273:  CaseElements ::= $Empty
            //
            case 273: {
                setResult(null);
                break;
            } 
            //
            // Rule 274:  CaseElements ::= CaseLabel
            //
            case 274:
                break; 
            //
            // Rule 275:  CaseElements ::= CaseLabel CaseElementsPrefix CaseElement_abbrev
            //
            case 275: {
                setResult(
                    new CaseElements(getLeftIToken(), getRightIToken(),
                                     (ICaseLabel)getRhsSym(1),
                                     (CaseElementsPrefix)getRhsSym(2),
                                     (ICaseElement_abbrev)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 276:  CaseElementsPrefix ::= $Empty
            //
            case 276: {
                setResult(null);
                break;
            } 
            //
            // Rule 277:  CaseElementsPrefix ::= CaseElementsPrefix CaseElement_full
            //
            case 277: {
                setResult(
                    new CaseElementsPrefix(getLeftIToken(), getRightIToken(),
                                           (CaseElementsPrefix)getRhsSym(1),
                                           (ICaseElement_full)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 278:  CaseElement_abbrev ::= Directive_abbrev
            //
            case 278:
                break; 
            //
            // Rule 279:  CaseElement_abbrev ::= CaseLabel
            //
            case 279:
                break; 
            //
            // Rule 280:  CaseElement_full ::= Directive_full
            //
            case 280:
                break; 
            //
            // Rule 281:  CaseElement_full ::= CaseLabel
            //
            case 281:
                break; 
            //
            // Rule 282:  CaseLabel ::= CASE ListExpression_allowIn :
            //
            case 282: {
                setResult(
                    new CaseLabel0(getLeftIToken(), getRightIToken(),
                                   new AstToken(getRhsIToken(1)),
                                   (IListExpression_allowIn)getRhsSym(2),
                                   new AstToken(getRhsIToken(3)))
                );
                break;
            } 
            //
            // Rule 283:  CaseLabel ::= DEFAULT :
            //
            case 283: {
                setResult(
                    new CaseLabel1(getLeftIToken(), getRightIToken(),
                                   new AstToken(getRhsIToken(1)),
                                   new AstToken(getRhsIToken(2)))
                );
                break;
            } 
            //
            // Rule 284:  DoStatement ::= DO Substatement_abbrev WHILE ParenListExpression
            //
            case 284: {
                setResult(
                    new DoStatement(getLeftIToken(), getRightIToken(),
                                    new AstToken(getRhsIToken(1)),
                                    (ISubstatement_abbrev)getRhsSym(2),
                                    new AstToken(getRhsIToken(3)),
                                    (IParenListExpression)getRhsSym(4))
                );
                break;
            } 
            //
            // Rule 285:  WhileStatement_abbrev ::= WHILE ParenListExpression Substatement_abbrev
            //
            case 285: {
                setResult(
                    new WhileStatement_abbrev(getLeftIToken(), getRightIToken(),
                                              new AstToken(getRhsIToken(1)),
                                              (IParenListExpression)getRhsSym(2),
                                              (ISubstatement_abbrev)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 286:  WhileStatement_noShortIf ::= WHILE ParenListExpression Substatement_noShortIf
            //
            case 286: {
                setResult(
                    new WhileStatement_noShortIf(getLeftIToken(), getRightIToken(),
                                                 new AstToken(getRhsIToken(1)),
                                                 (IParenListExpression)getRhsSym(2),
                                                 (ISubstatement_noShortIf)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 287:  WhileStatement_full ::= WHILE ParenListExpression Substatement_full
            //
            case 287: {
                setResult(
                    new WhileStatement_full(getLeftIToken(), getRightIToken(),
                                            new AstToken(getRhsIToken(1)),
                                            (IParenListExpression)getRhsSym(2),
                                            (ISubstatement_full)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 288:  ForStatement_abbrev ::= FOR ( ForInitializer ; OptionalExpression ; OptionalExpression ) Substatement_abbrev
            //
            case 288: {
                setResult(
                    new ForStatement_abbrev0(getLeftIToken(), getRightIToken(),
                                             new AstToken(getRhsIToken(1)),
                                             new AstToken(getRhsIToken(2)),
                                             (IForInitializer)getRhsSym(3),
                                             new AstToken(getRhsIToken(4)),
                                             (IOptionalExpression)getRhsSym(5),
                                             new AstToken(getRhsIToken(6)),
                                             (IOptionalExpression)getRhsSym(7),
                                             new AstToken(getRhsIToken(8)),
                                             (ISubstatement_abbrev)getRhsSym(9))
                );
                break;
            } 
            //
            // Rule 289:  ForStatement_abbrev ::= FOR ( ForInBinding IN ListExpression_allowIn ) Substatement_abbrev
            //
            case 289: {
                setResult(
                    new ForStatement_abbrev1(getLeftIToken(), getRightIToken(),
                                             new AstToken(getRhsIToken(1)),
                                             new AstToken(getRhsIToken(2)),
                                             (IForInBinding)getRhsSym(3),
                                             new AstToken(getRhsIToken(4)),
                                             (IListExpression_allowIn)getRhsSym(5),
                                             new AstToken(getRhsIToken(6)),
                                             (ISubstatement_abbrev)getRhsSym(7))
                );
                break;
            } 
            //
            // Rule 290:  ForStatement_noShortIf ::= FOR ( ForInitializer ; OptionalExpression ; OptionalExpression ) Substatement_noShortIf
            //
            case 290: {
                setResult(
                    new ForStatement_noShortIf0(getLeftIToken(), getRightIToken(),
                                                new AstToken(getRhsIToken(1)),
                                                new AstToken(getRhsIToken(2)),
                                                (IForInitializer)getRhsSym(3),
                                                new AstToken(getRhsIToken(4)),
                                                (IOptionalExpression)getRhsSym(5),
                                                new AstToken(getRhsIToken(6)),
                                                (IOptionalExpression)getRhsSym(7),
                                                new AstToken(getRhsIToken(8)),
                                                (ISubstatement_noShortIf)getRhsSym(9))
                );
                break;
            } 
            //
            // Rule 291:  ForStatement_noShortIf ::= FOR ( ForInBinding IN ListExpression_allowIn ) Substatement_noShortIf
            //
            case 291: {
                setResult(
                    new ForStatement_noShortIf1(getLeftIToken(), getRightIToken(),
                                                new AstToken(getRhsIToken(1)),
                                                new AstToken(getRhsIToken(2)),
                                                (IForInBinding)getRhsSym(3),
                                                new AstToken(getRhsIToken(4)),
                                                (IListExpression_allowIn)getRhsSym(5),
                                                new AstToken(getRhsIToken(6)),
                                                (ISubstatement_noShortIf)getRhsSym(7))
                );
                break;
            } 
            //
            // Rule 292:  ForStatement_full ::= FOR ( ForInitializer ; OptionalExpression ; OptionalExpression ) Substatement_full
            //
            case 292: {
                setResult(
                    new ForStatement_full0(getLeftIToken(), getRightIToken(),
                                           new AstToken(getRhsIToken(1)),
                                           new AstToken(getRhsIToken(2)),
                                           (IForInitializer)getRhsSym(3),
                                           new AstToken(getRhsIToken(4)),
                                           (IOptionalExpression)getRhsSym(5),
                                           new AstToken(getRhsIToken(6)),
                                           (IOptionalExpression)getRhsSym(7),
                                           new AstToken(getRhsIToken(8)),
                                           (ISubstatement_full)getRhsSym(9))
                );
                break;
            } 
            //
            // Rule 293:  ForStatement_full ::= FOR ( ForInBinding IN ListExpression_allowIn ) Substatement_full
            //
            case 293: {
                setResult(
                    new ForStatement_full1(getLeftIToken(), getRightIToken(),
                                           new AstToken(getRhsIToken(1)),
                                           new AstToken(getRhsIToken(2)),
                                           (IForInBinding)getRhsSym(3),
                                           new AstToken(getRhsIToken(4)),
                                           (IListExpression_allowIn)getRhsSym(5),
                                           new AstToken(getRhsIToken(6)),
                                           (ISubstatement_full)getRhsSym(7))
                );
                break;
            } 
            //
            // Rule 294:  ForInitializer ::= $Empty
            //
            case 294: {
                setResult(null);
                break;
            } 
            //
            // Rule 295:  ForInitializer ::= ListExpression_noIn
            //
            case 295:
                break; 
            //
            // Rule 296:  ForInitializer ::= VariableDefinition_noIn
            //
            case 296:
                break; 
            //
            // Rule 297:  ForInitializer ::= Attributes no_line_break$ VariableDefinition_noIn
            //
            case 297: {
                setResult(
                    new ForInitializer(getLeftIToken(), getRightIToken(),
                                       (IAttributes)getRhsSym(1),
                                       (VariableDefinition_noIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 298:  ForInBinding ::= PostfixExpression
            //
            case 298:
                break; 
            //
            // Rule 299:  ForInBinding ::= VariableDefinitionKind VariableBinding_noIn
            //
            case 299: {
                setResult(
                    new ForInBinding0(getLeftIToken(), getRightIToken(),
                                      (IVariableDefinitionKind)getRhsSym(1),
                                      (VariableBinding_noIn)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 300:  ForInBinding ::= Attributes no_line_break$ VariableDefinitionKind VariableBinding_noIn
            //
            case 300: {
                setResult(
                    new ForInBinding1(getLeftIToken(), getRightIToken(),
                                      (IAttributes)getRhsSym(1),
                                      (IVariableDefinitionKind)getRhsSym(3),
                                      (VariableBinding_noIn)getRhsSym(4))
                );
                break;
            } 
            //
            // Rule 301:  OptionalExpression ::= ListExpression_allowIn
            //
            case 301:
                break; 
            //
            // Rule 302:  OptionalExpression ::= $Empty
            //
            case 302: {
                setResult(null);
                break;
            } 
            //
            // Rule 303:  WithStatement_abbrev ::= WITH ParenListExpression Substatement_abbrev
            //
            case 303: {
                setResult(
                    new WithStatement_abbrev(getLeftIToken(), getRightIToken(),
                                             new AstToken(getRhsIToken(1)),
                                             (IParenListExpression)getRhsSym(2),
                                             (ISubstatement_abbrev)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 304:  WithStatement_noShortIf ::= WITH ParenListExpression Substatement_noShortIf
            //
            case 304: {
                setResult(
                    new WithStatement_noShortIf(getLeftIToken(), getRightIToken(),
                                                new AstToken(getRhsIToken(1)),
                                                (IParenListExpression)getRhsSym(2),
                                                (ISubstatement_noShortIf)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 305:  WithStatement_full ::= WITH ParenListExpression Substatement_full
            //
            case 305: {
                setResult(
                    new WithStatement_full(getLeftIToken(), getRightIToken(),
                                           new AstToken(getRhsIToken(1)),
                                           (IParenListExpression)getRhsSym(2),
                                           (ISubstatement_full)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 306:  ContinueStatement ::= CONTINUE
            //
            case 306: {
                setResult(
                    new ContinueStatement0(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 307:  ContinueStatement ::= CONTINUE no_line_break$ Identifier
            //
            case 307: {
                setResult(
                    new ContinueStatement1(getLeftIToken(), getRightIToken(),
                                           new AstToken(getRhsIToken(1)),
                                           (IIdentifier)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 308:  BreakStatement ::= BREAK
            //
            case 308: {
                setResult(
                    new BreakStatement0(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 309:  BreakStatement ::= BREAK no_line_break$ Identifier
            //
            case 309: {
                setResult(
                    new BreakStatement1(getLeftIToken(), getRightIToken(),
                                        new AstToken(getRhsIToken(1)),
                                        (IIdentifier)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 310:  ReturnStatement ::= RETURN
            //
            case 310: {
                setResult(
                    new ReturnStatement0(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 311:  ReturnStatement ::= RETURN no_line_break$ ListExpression_allowIn
            //
            case 311: {
                setResult(
                    new ReturnStatement1(getLeftIToken(), getRightIToken(),
                                         new AstToken(getRhsIToken(1)),
                                         (IListExpression_allowIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 312:  ThrowStatement ::= THROW no_line_break$ ListExpression_allowIn
            //
            case 312: {
                setResult(
                    new ThrowStatement(getLeftIToken(), getRightIToken(),
                                       new AstToken(getRhsIToken(1)),
                                       (IListExpression_allowIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 313:  TryStatement ::= TRY Block CatchClauses
            //
            case 313: {
                setResult(
                    new TryStatement0(getLeftIToken(), getRightIToken(),
                                      new AstToken(getRhsIToken(1)),
                                      (Block)getRhsSym(2),
                                      (ICatchClauses)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 314:  TryStatement ::= TRY Block CatchClausesOpt FINALLY Block
            //
            case 314: {
                setResult(
                    new TryStatement1(getLeftIToken(), getRightIToken(),
                                      new AstToken(getRhsIToken(1)),
                                      (Block)getRhsSym(2),
                                      (ICatchClausesOpt)getRhsSym(3),
                                      new AstToken(getRhsIToken(4)),
                                      (Block)getRhsSym(5))
                );
                break;
            } 
            //
            // Rule 315:  CatchClausesOpt ::= $Empty
            //
            case 315: {
                setResult(null);
                break;
            } 
            //
            // Rule 316:  CatchClausesOpt ::= CatchClauses
            //
            case 316:
                break; 
            //
            // Rule 317:  CatchClauses ::= CatchClause
            //
            case 317:
                break; 
            //
            // Rule 318:  CatchClauses ::= CatchClauses CatchClause
            //
            case 318: {
                setResult(
                    new CatchClauses(getLeftIToken(), getRightIToken(),
                                     (ICatchClauses)getRhsSym(1),
                                     (CatchClause)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 319:  CatchClause ::= CATCH ( Parameter ) Block
            //
            case 319: {
                setResult(
                    new CatchClause(getLeftIToken(), getRightIToken(),
                                    new AstToken(getRhsIToken(1)),
                                    new AstToken(getRhsIToken(2)),
                                    (Parameter)getRhsSym(3),
                                    new AstToken(getRhsIToken(4)),
                                    (Block)getRhsSym(5))
                );
                break;
            } 
            //
            // Rule 320:  Directive_abbrev ::= EmptyStatement
            //
            case 320:
                break; 
            //
            // Rule 321:  Directive_abbrev ::= Statement_abbrev
            //
            case 321:
                break; 
            //
            // Rule 322:  Directive_abbrev ::= AnnotatableDirective_abbrev
            //
            case 322:
                break; 
            //
            // Rule 323:  Directive_abbrev ::= Attributes no_line_break$ AnnotatableDirective_abbrev
            //
            case 323: {
                setResult(
                    new Directive_abbrev0(getLeftIToken(), getRightIToken(),
                                          (IAttributes)getRhsSym(1),
                                          (IAnnotatableDirective_abbrev)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 324:  Directive_abbrev ::= Attributes no_line_break$ { Directives }
            //
            case 324: {
                setResult(
                    new Directive_abbrev1(getLeftIToken(), getRightIToken(),
                                          (IAttributes)getRhsSym(1),
                                          new AstToken(getRhsIToken(3)),
                                          (IDirectives)getRhsSym(4),
                                          new AstToken(getRhsIToken(5)))
                );
                break;
            } 
            //
            // Rule 325:  Directive_abbrev ::= IncludeDirective Semicolon_abbrev
            //
            case 325: {
                setResult(
                    new Directive_abbrev2(getLeftIToken(), getRightIToken(),
                                          (IncludeDirective)getRhsSym(1),
                                          (ISemicolon_abbrev)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 326:  Directive_abbrev ::= Pragma Semicolon_abbrev
            //
            case 326: {
                setResult(
                    new Directive_abbrev3(getLeftIToken(), getRightIToken(),
                                          (Pragma)getRhsSym(1),
                                          (ISemicolon_abbrev)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 327:  Directive_abbrev ::= ERROR_TOKEN
            //
            case 327: {
                setResult(
                    new Directive_abbrev4(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 328:  Directive_full ::= EmptyStatement
            //
            case 328:
                break; 
            //
            // Rule 329:  Directive_full ::= Statement_full
            //
            case 329:
                break; 
            //
            // Rule 330:  Directive_full ::= AnnotatableDirective_full
            //
            case 330:
                break; 
            //
            // Rule 331:  Directive_full ::= Attributes no_line_break$ AnnotatableDirective_full
            //
            case 331: {
                setResult(
                    new Directive_full0(getLeftIToken(), getRightIToken(),
                                        (IAttributes)getRhsSym(1),
                                        (IAnnotatableDirective_full)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 332:  Directive_full ::= Attributes no_line_break$ { Directives }
            //
            case 332: {
                setResult(
                    new Directive_full1(getLeftIToken(), getRightIToken(),
                                        (IAttributes)getRhsSym(1),
                                        new AstToken(getRhsIToken(3)),
                                        (IDirectives)getRhsSym(4),
                                        new AstToken(getRhsIToken(5)))
                );
                break;
            } 
            //
            // Rule 333:  Directive_full ::= IncludeDirective Semicolon_full
            //
            case 333: {
                setResult(
                    new Directive_full2(getLeftIToken(), getRightIToken(),
                                        (IncludeDirective)getRhsSym(1),
                                        (ISemicolon_full)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 334:  Directive_full ::= Pragma Semicolon_full
            //
            case 334: {
                setResult(
                    new Directive_full3(getLeftIToken(), getRightIToken(),
                                        (Pragma)getRhsSym(1),
                                        (ISemicolon_full)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 335:  AnnotatableDirective_abbrev ::= VariableDefinition_allowIn Semicolon_abbrev
            //
            case 335: {
                setResult(
                    new AnnotatableDirective_abbrev0(getLeftIToken(), getRightIToken(),
                                                     (VariableDefinition_allowIn)getRhsSym(1),
                                                     (ISemicolon_abbrev)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 336:  AnnotatableDirective_abbrev ::= FunctionDefinition
            //
            case 336:
                break; 
            //
            // Rule 337:  AnnotatableDirective_abbrev ::= ClassDefinition
            //
            case 337:
                break; 
            //
            // Rule 338:  AnnotatableDirective_abbrev ::= NamespaceDefinition Semicolon_abbrev
            //
            case 338: {
                setResult(
                    new AnnotatableDirective_abbrev1(getLeftIToken(), getRightIToken(),
                                                     (NamespaceDefinition)getRhsSym(1),
                                                     (ISemicolon_abbrev)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 339:  AnnotatableDirective_abbrev ::= ImportDirective Semicolon_abbrev
            //
            case 339: {
                setResult(
                    new AnnotatableDirective_abbrev2(getLeftIToken(), getRightIToken(),
                                                     (IImportDirective)getRhsSym(1),
                                                     (ISemicolon_abbrev)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 340:  AnnotatableDirective_abbrev ::= ExportDefinition Semicolon_abbrev
            //
            case 340: {
                setResult(
                    new AnnotatableDirective_abbrev3(getLeftIToken(), getRightIToken(),
                                                     (ExportDefinition)getRhsSym(1),
                                                     (ISemicolon_abbrev)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 341:  AnnotatableDirective_abbrev ::= UseDirective Semicolon_abbrev
            //
            case 341: {
                setResult(
                    new AnnotatableDirective_abbrev4(getLeftIToken(), getRightIToken(),
                                                     (UseDirective)getRhsSym(1),
                                                     (ISemicolon_abbrev)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 342:  AnnotatableDirective_full ::= VariableDefinition_allowIn Semicolon_full
            //
            case 342: {
                setResult(
                    new AnnotatableDirective_full0(getLeftIToken(), getRightIToken(),
                                                   (VariableDefinition_allowIn)getRhsSym(1),
                                                   (ISemicolon_full)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 343:  AnnotatableDirective_full ::= FunctionDefinition
            //
            case 343:
                break; 
            //
            // Rule 344:  AnnotatableDirective_full ::= ClassDefinition
            //
            case 344:
                break; 
            //
            // Rule 345:  AnnotatableDirective_full ::= NamespaceDefinition Semicolon_full
            //
            case 345: {
                setResult(
                    new AnnotatableDirective_full1(getLeftIToken(), getRightIToken(),
                                                   (NamespaceDefinition)getRhsSym(1),
                                                   (ISemicolon_full)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 346:  AnnotatableDirective_full ::= ImportDirective Semicolon_full
            //
            case 346: {
                setResult(
                    new AnnotatableDirective_full2(getLeftIToken(), getRightIToken(),
                                                   (IImportDirective)getRhsSym(1),
                                                   (ISemicolon_full)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 347:  AnnotatableDirective_full ::= ExportDefinition Semicolon_full
            //
            case 347: {
                setResult(
                    new AnnotatableDirective_full3(getLeftIToken(), getRightIToken(),
                                                   (ExportDefinition)getRhsSym(1),
                                                   (ISemicolon_full)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 348:  AnnotatableDirective_full ::= UseDirective Semicolon_full
            //
            case 348: {
                setResult(
                    new AnnotatableDirective_full4(getLeftIToken(), getRightIToken(),
                                                   (UseDirective)getRhsSym(1),
                                                   (ISemicolon_full)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 349:  Directives ::= $Empty
            //
            case 349: {
                setResult(null);
                break;
            } 
            //
            // Rule 350:  Directives ::= Directive_abbrev
            //
            case 350:
                break; 
            //
            // Rule 351:  Directives ::= DirectivesPrefix Directive_abbrev
            //
            case 351: {
                setResult(
                    new Directives(getLeftIToken(), getRightIToken(),
                                   (IDirectivesPrefix)getRhsSym(1),
                                   (IDirective_abbrev)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 352:  DirectivesPrefix ::= Directive_full
            //
            case 352:
                break; 
            //
            // Rule 353:  DirectivesPrefix ::= DirectivesPrefix Directive_full
            //
            case 353: {
                setResult(
                    new DirectivesPrefix(getLeftIToken(), getRightIToken(),
                                         (IDirectivesPrefix)getRhsSym(1),
                                         (IDirective_full)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 354:  Attributes ::= Attribute
            //
            case 354:
                break; 
            //
            // Rule 355:  Attributes ::= AttributeCombination
            //
            case 355:
                break; 
            //
            // Rule 356:  AttributeCombination ::= Attribute no_line_break$ Attributes
            //
            case 356: {
                setResult(
                    new AttributeCombination(getLeftIToken(), getRightIToken(),
                                             (IAttribute)getRhsSym(1),
                                             (IAttributes)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 357:  Attribute ::= AttributeExpression
            //
            case 357:
                break; 
            //
            // Rule 358:  Attribute ::= TRUE
            //
            case 358: {
                setResult(
                    new Attribute0(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 359:  Attribute ::= FALSE
            //
            case 359: {
                setResult(
                    new Attribute1(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 360:  Attribute ::= ReservedNamespace
            //
            case 360:
                break; 
            //
            // Rule 361:  UseDirective ::= USE NAMESPACE ParenListExpression
            //
            case 361: {
                setResult(
                    new UseDirective(getLeftIToken(), getRightIToken(),
                                     new AstToken(getRhsIToken(1)),
                                     new AstToken(getRhsIToken(2)),
                                     (IParenListExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 362:  ImportDirective ::= IMPORT PackageName
            //
            case 362: {
                setResult(
                    new ImportDirective0(getLeftIToken(), getRightIToken(),
                                         new AstToken(getRhsIToken(1)),
                                         (IPackageName)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 363:  ImportDirective ::= IMPORT Identifier = PackageName
            //
            case 363: {
                setResult(
                    new ImportDirective1(getLeftIToken(), getRightIToken(),
                                         new AstToken(getRhsIToken(1)),
                                         (IIdentifier)getRhsSym(2),
                                         new AstToken(getRhsIToken(3)),
                                         (IPackageName)getRhsSym(4))
                );
                break;
            } 
            //
            // Rule 364:  IncludeDirective ::= INCLUDE no_line_break$ String
            //
            case 364: {
                setResult(
                    new IncludeDirective(getLeftIToken(), getRightIToken(),
                                         new AstToken(getRhsIToken(1)),
                                         new AstToken(getRhsIToken(3)))
                );
                break;
            } 
            //
            // Rule 365:  Pragma ::= USE PragmaItems
            //
            case 365: {
                setResult(
                    new Pragma(getLeftIToken(), getRightIToken(),
                               new AstToken(getRhsIToken(1)),
                               (IPragmaItems)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 366:  PragmaItems ::= PragmaItem
            //
            case 366:
                break; 
            //
            // Rule 367:  PragmaItems ::= PragmaItems , PragmaItem
            //
            case 367: {
                setResult(
                    new PragmaItems(getLeftIToken(), getRightIToken(),
                                    (IPragmaItems)getRhsSym(1),
                                    new AstToken(getRhsIToken(2)),
                                    (IPragmaItem)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 368:  PragmaItem ::= PragmaExpr
            //
            case 368:
                break; 
            //
            // Rule 369:  PragmaItem ::= PragmaExpr ?
            //
            case 369: {
                setResult(
                    new PragmaItem(getLeftIToken(), getRightIToken(),
                                   (IPragmaExpr)getRhsSym(1),
                                   new AstToken(getRhsIToken(2)))
                );
                break;
            } 
            //
            // Rule 370:  PragmaExpr ::= Identifier
            //
            case 370:
                break; 
            //
            // Rule 371:  PragmaExpr ::= Identifier ( PragmaArgument )
            //
            case 371: {
                setResult(
                    new PragmaExpr(getLeftIToken(), getRightIToken(),
                                   (IIdentifier)getRhsSym(1),
                                   new AstToken(getRhsIToken(2)),
                                   (IPragmaArgument)getRhsSym(3),
                                   new AstToken(getRhsIToken(4)))
                );
                break;
            } 
            //
            // Rule 372:  PragmaArgument ::= TRUE
            //
            case 372: {
                setResult(
                    new PragmaArgument0(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 373:  PragmaArgument ::= FALSE
            //
            case 373: {
                setResult(
                    new PragmaArgument1(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 374:  PragmaArgument ::= Number
            //
            case 374: {
                setResult(
                    new PragmaArgument2(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 375:  PragmaArgument ::= - Number
            //
            case 375: {
                setResult(
                    new PragmaArgument3(getLeftIToken(), getRightIToken(),
                                        new AstToken(getRhsIToken(1)),
                                        new AstToken(getRhsIToken(2)))
                );
                break;
            } 
            //
            // Rule 376:  PragmaArgument ::= - NegatedMinLong
            //
            case 376: {
                setResult(
                    new PragmaArgument4(getLeftIToken(), getRightIToken(),
                                        new AstToken(getRhsIToken(1)),
                                        new AstToken(getRhsIToken(2)))
                );
                break;
            } 
            //
            // Rule 377:  PragmaArgument ::= String
            //
            case 377: {
                setResult(
                    new PragmaArgument5(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 378:  ExportDefinition ::= EXPORT ExportBindingList
            //
            case 378: {
                setResult(
                    new ExportDefinition(getLeftIToken(), getRightIToken(),
                                         new AstToken(getRhsIToken(1)),
                                         (IExportBindingList)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 379:  ExportBindingList ::= ExportBinding
            //
            case 379:
                break; 
            //
            // Rule 380:  ExportBindingList ::= ExportBindingList , ExportBinding
            //
            case 380: {
                setResult(
                    new ExportBindingList(getLeftIToken(), getRightIToken(),
                                          (IExportBindingList)getRhsSym(1),
                                          new AstToken(getRhsIToken(2)),
                                          (IExportBinding)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 381:  ExportBinding ::= FunctionName
            //
            case 381:
                break; 
            //
            // Rule 382:  ExportBinding ::= FunctionName = FunctionName
            //
            case 382: {
                setResult(
                    new ExportBinding(getLeftIToken(), getRightIToken(),
                                      (IFunctionName)getRhsSym(1),
                                      new AstToken(getRhsIToken(2)),
                                      (IFunctionName)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 383:  VariableDefinition_allowIn ::= VariableDefinitionKind VariableBindingList_allowIn
            //
            case 383: {
                setResult(
                    new VariableDefinition_allowIn(getLeftIToken(), getRightIToken(),
                                                   (IVariableDefinitionKind)getRhsSym(1),
                                                   (IVariableBindingList_allowIn)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 384:  VariableDefinition_noIn ::= VariableDefinitionKind VariableBindingList_noIn
            //
            case 384: {
                setResult(
                    new VariableDefinition_noIn(getLeftIToken(), getRightIToken(),
                                                (IVariableDefinitionKind)getRhsSym(1),
                                                (IVariableBindingList_noIn)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 385:  VariableDefinitionKind ::= VAR
            //
            case 385: {
                setResult(
                    new VariableDefinitionKind0(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 386:  VariableDefinitionKind ::= CONST
            //
            case 386: {
                setResult(
                    new VariableDefinitionKind1(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 387:  VariableBindingList_allowIn ::= VariableBinding_allowIn
            //
            case 387:
                break; 
            //
            // Rule 388:  VariableBindingList_allowIn ::= VariableBindingList_allowIn , VariableBinding_allowIn
            //
            case 388: {
                setResult(
                    new VariableBindingList_allowIn(getLeftIToken(), getRightIToken(),
                                                    (IVariableBindingList_allowIn)getRhsSym(1),
                                                    new AstToken(getRhsIToken(2)),
                                                    (VariableBinding_allowIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 389:  VariableBindingList_noIn ::= VariableBinding_noIn
            //
            case 389:
                break; 
            //
            // Rule 390:  VariableBindingList_noIn ::= VariableBindingList_noIn , VariableBinding_noIn
            //
            case 390: {
                setResult(
                    new VariableBindingList_noIn(getLeftIToken(), getRightIToken(),
                                                 (IVariableBindingList_noIn)getRhsSym(1),
                                                 new AstToken(getRhsIToken(2)),
                                                 (VariableBinding_noIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 391:  VariableBinding_allowIn ::= TypedIdentifier_allowIn VariableInitialisation_allowIn
            //
            case 391: {
                setResult(
                    new VariableBinding_allowIn(getLeftIToken(), getRightIToken(),
                                                (ITypedIdentifier_allowIn)getRhsSym(1),
                                                (VariableInitialisation_allowIn)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 392:  VariableBinding_noIn ::= TypedIdentifier_noIn VariableInitialisation_noIn
            //
            case 392: {
                setResult(
                    new VariableBinding_noIn(getLeftIToken(), getRightIToken(),
                                             (ITypedIdentifier_noIn)getRhsSym(1),
                                             (VariableInitialisation_noIn)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 393:  VariableInitialisation_allowIn ::= $Empty
            //
            case 393: {
                setResult(null);
                break;
            } 
            //
            // Rule 394:  VariableInitialisation_allowIn ::= = VariableInitializer_allowIn
            //
            case 394: {
                setResult(
                    new VariableInitialisation_allowIn(getLeftIToken(), getRightIToken(),
                                                       new AstToken(getRhsIToken(1)),
                                                       (IVariableInitializer_allowIn)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 395:  VariableInitialisation_noIn ::= $Empty
            //
            case 395: {
                setResult(null);
                break;
            } 
            //
            // Rule 396:  VariableInitialisation_noIn ::= = VariableInitializer_noIn
            //
            case 396: {
                setResult(
                    new VariableInitialisation_noIn(getLeftIToken(), getRightIToken(),
                                                    new AstToken(getRhsIToken(1)),
                                                    (IVariableInitializer_noIn)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 397:  VariableInitializer_allowIn ::= AssignmentExpression_allowIn
            //
            case 397:
                break; 
            //
            // Rule 398:  VariableInitializer_allowIn ::= AttributeCombination
            //
            case 398:
                break; 
            //
            // Rule 399:  VariableInitializer_noIn ::= AssignmentExpression_noIn
            //
            case 399:
                break; 
            //
            // Rule 400:  VariableInitializer_noIn ::= AttributeCombination
            //
            case 400:
                break; 
            //
            // Rule 401:  TypedIdentifier_allowIn ::= Identifier
            //
            case 401:
                break; 
            //
            // Rule 402:  TypedIdentifier_allowIn ::= Identifier : TypeExpression_allowIn
            //
            case 402: {
                setResult(
                    new TypedIdentifier_allowIn(getLeftIToken(), getRightIToken(),
                                                (IIdentifier)getRhsSym(1),
                                                new AstToken(getRhsIToken(2)),
                                                (ITypeExpression_allowIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 403:  TypedIdentifier_noIn ::= Identifier
            //
            case 403:
                break; 
            //
            // Rule 404:  TypedIdentifier_noIn ::= Identifier : TypeExpression_noIn
            //
            case 404: {
                setResult(
                    new TypedIdentifier_noIn(getLeftIToken(), getRightIToken(),
                                             (IIdentifier)getRhsSym(1),
                                             new AstToken(getRhsIToken(2)),
                                             (ITypeExpression_noIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 405:  SimpleVariableDefinition ::= VAR UntypedVariableBindingList
            //
            case 405: {
                setResult(
                    new SimpleVariableDefinition(getLeftIToken(), getRightIToken(),
                                                 new AstToken(getRhsIToken(1)),
                                                 (IUntypedVariableBindingList)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 406:  UntypedVariableBindingList ::= UntypedVariableBinding
            //
            case 406:
                break; 
            //
            // Rule 407:  UntypedVariableBindingList ::= UntypedVariableBindingList , UntypedVariableBinding
            //
            case 407: {
                setResult(
                    new UntypedVariableBindingList(getLeftIToken(), getRightIToken(),
                                                   (IUntypedVariableBindingList)getRhsSym(1),
                                                   new AstToken(getRhsIToken(2)),
                                                   (UntypedVariableBinding)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 408:  UntypedVariableBinding ::= Identifier VariableInitialisation_allowIn
            //
            case 408: {
                setResult(
                    new UntypedVariableBinding(getLeftIToken(), getRightIToken(),
                                               (IIdentifier)getRhsSym(1),
                                               (VariableInitialisation_allowIn)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 409:  FunctionDefinition ::= FUNCTION FunctionName FunctionCommon
            //
            case 409: {
                setResult(
                    new FunctionDefinition(getLeftIToken(), getRightIToken(),
                                           new AstToken(getRhsIToken(1)),
                                           (IFunctionName)getRhsSym(2),
                                           (FunctionCommon)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 410:  FunctionName ::= Identifier
            //
            case 410:
                break; 
            //
            // Rule 411:  FunctionName ::= GET no_line_break$ Identifier
            //
            case 411: {
                setResult(
                    new FunctionName0(getLeftIToken(), getRightIToken(),
                                      new AstToken(getRhsIToken(1)),
                                      (IIdentifier)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 412:  FunctionName ::= SET no_line_break$ Identifier
            //
            case 412: {
                setResult(
                    new FunctionName1(getLeftIToken(), getRightIToken(),
                                      new AstToken(getRhsIToken(1)),
                                      (IIdentifier)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 413:  FunctionCommon ::= ( Parameters ) Result Block
            //
            case 413: {
                setResult(
                    new FunctionCommon(getLeftIToken(), getRightIToken(),
                                       new AstToken(getRhsIToken(1)),
                                       (IParameters)getRhsSym(2),
                                       new AstToken(getRhsIToken(3)),
                                       (Result)getRhsSym(4),
                                       (Block)getRhsSym(5))
                );
                break;
            } 
            //
            // Rule 414:  Parameters ::= $Empty
            //
            case 414: {
                setResult(null);
                break;
            } 
            //
            // Rule 415:  Parameters ::= NonemptyParameters
            //
            case 415:
                break; 
            //
            // Rule 416:  NonemptyParameters ::= ParameterInitList
            //
            case 416:
                break; 
            //
            // Rule 417:  NonemptyParameters ::= RestParameter
            //
            case 417:
                break; 
            //
            // Rule 418:  NonemptyParameters ::= ParameterInitList RestParameter
            //
            case 418: {
                setResult(
                    new NonemptyParameters(getLeftIToken(), getRightIToken(),
                                           (IParameterInitList)getRhsSym(1),
                                           (IRestParameter)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 419:  ParameterInitList ::= ParameterInit
            //
            case 419:
                break; 
            //
            // Rule 420:  ParameterInitList ::= ParameterInitList , ParameterInit
            //
            case 420: {
                setResult(
                    new ParameterInitList(getLeftIToken(), getRightIToken(),
                                          (IParameterInitList)getRhsSym(1),
                                          new AstToken(getRhsIToken(2)),
                                          (IParameterInit)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 421:  Parameter ::= ParameterAttributes TypedIdentifier_allowIn
            //
            case 421: {
                setResult(
                    new Parameter(getLeftIToken(), getRightIToken(),
                                  (ParameterAttributes)getRhsSym(1),
                                  (ITypedIdentifier_allowIn)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 422:  ParameterAttributes ::= $Empty
            //
            case 422: {
                setResult(null);
                break;
            } 
            //
            // Rule 423:  ParameterAttributes ::= CONST
            //
            case 423: {
                setResult(
                    new ParameterAttributes(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 424:  ParameterInit ::= Parameter
            //
            case 424:
                break; 
            //
            // Rule 425:  ParameterInit ::= Parameter = AssignmentExpression_allowIn
            //
            case 425: {
                setResult(
                    new ParameterInit(getLeftIToken(), getRightIToken(),
                                      (Parameter)getRhsSym(1),
                                      new AstToken(getRhsIToken(2)),
                                      (IAssignmentExpression_allowIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 426:  RestParameter ::= ...
            //
            case 426: {
                setResult(
                    new RestParameter0(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 427:  RestParameter ::= ... ParameterAttributes Identifier
            //
            case 427: {
                setResult(
                    new RestParameter1(getLeftIToken(), getRightIToken(),
                                       new AstToken(getRhsIToken(1)),
                                       (ParameterAttributes)getRhsSym(2),
                                       (IIdentifier)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 428:  Result ::= $Empty
            //
            case 428: {
                setResult(null);
                break;
            } 
            //
            // Rule 429:  Result ::= : TypeExpression_allowIn
            //
            case 429: {
                setResult(
                    new Result(getLeftIToken(), getRightIToken(),
                               new AstToken(getRhsIToken(1)),
                               (ITypeExpression_allowIn)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 430:  ClassDefinition ::= CLASS Identifier Inheritance Block
            //
            case 430: {
                setResult(
                    new ClassDefinition(getLeftIToken(), getRightIToken(),
                                        new AstToken(getRhsIToken(1)),
                                        (IIdentifier)getRhsSym(2),
                                        (Inheritance)getRhsSym(3),
                                        (Block)getRhsSym(4))
                );
                break;
            } 
            //
            // Rule 431:  Inheritance ::= $Empty
            //
            case 431: {
                setResult(null);
                break;
            } 
            //
            // Rule 432:  Inheritance ::= EXTENDS TypeExpression_allowIn
            //
            case 432: {
                setResult(
                    new Inheritance(getLeftIToken(), getRightIToken(),
                                    new AstToken(getRhsIToken(1)),
                                    (ITypeExpression_allowIn)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 433:  NamespaceDefinition ::= NAMESPACE Identifier
            //
            case 433: {
                setResult(
                    new NamespaceDefinition(getLeftIToken(), getRightIToken(),
                                            new AstToken(getRhsIToken(1)),
                                            (IIdentifier)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 434:  Program ::= Directives
            //
            case 434:
                break; 
            //
            // Rule 435:  Program ::= PackageDefinitionList Directives
            //
            case 435: {
                setResult(
                    new Program(getLeftIToken(), getRightIToken(),
                                (IPackageDefinitionList)getRhsSym(1),
                                (IDirectives)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 436:  PackageDefinitionList ::= PackageDefinition
            //
            case 436:
                break; 
            //
            // Rule 437:  PackageDefinitionList ::= PackageDefinitionList PackageDefinition
            //
            case 437: {
                setResult(
                    new PackageDefinitionList(getLeftIToken(), getRightIToken(),
                                              (IPackageDefinitionList)getRhsSym(1),
                                              (PackageDefinition)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 438:  PackageDefinition ::= PACKAGE PackageNameOpt Block
            //
            case 438: {
                setResult(
                    new PackageDefinition(getLeftIToken(), getRightIToken(),
                                          new AstToken(getRhsIToken(1)),
                                          (IPackageNameOpt)getRhsSym(2),
                                          (Block)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 439:  PackageNameOpt ::= $Empty
            //
            case 439: {
                setResult(null);
                break;
            } 
            //
            // Rule 440:  PackageNameOpt ::= PackageName
            //
            case 440:
                break; 
            //
            // Rule 441:  PackageName ::= String
            //
            case 441: {
                setResult(
                    new PackageName(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 442:  PackageName ::= PackageIdentifiers
            //
            case 442:
                break; 
            //
            // Rule 443:  PackageIdentifiers ::= Identifier
            //
            case 443:
                break; 
            //
            // Rule 444:  PackageIdentifiers ::= PackageIdentifiers . Identifier
            //
            case 444: {
                setResult(
                    new PackageIdentifiers(getLeftIToken(), getRightIToken(),
                                           (IPackageIdentifiers)getRhsSym(1),
                                           new AstToken(getRhsIToken(2)),
                                           (IIdentifier)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 445:  ExpressionStatement ::= ES_AssignmentExpression_allowIn
            //
            case 445:
                break; 
            //
            // Rule 446:  ExpressionStatement ::= ExpressionStatement , AssignmentExpression_allowIn
            //
            case 446: {
                setResult(
                    new ExpressionStatement(getLeftIToken(), getRightIToken(),
                                            (IExpressionStatement)getRhsSym(1),
                                            new AstToken(getRhsIToken(2)),
                                            (IAssignmentExpression_allowIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 447:  ES_PrimaryExpression ::= NULL
            //
            case 447: {
                setResult(
                    new ES_PrimaryExpression0(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 448:  ES_PrimaryExpression ::= TRUE
            //
            case 448: {
                setResult(
                    new ES_PrimaryExpression1(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 449:  ES_PrimaryExpression ::= FALSE
            //
            case 449: {
                setResult(
                    new ES_PrimaryExpression2(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 450:  ES_PrimaryExpression ::= Number
            //
            case 450: {
                setResult(
                    new ES_PrimaryExpression3(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 451:  ES_PrimaryExpression ::= String
            //
            case 451: {
                setResult(
                    new ES_PrimaryExpression4(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 452:  ES_PrimaryExpression ::= THIS
            //
            case 452: {
                setResult(
                    new ES_PrimaryExpression5(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 453:  ES_PrimaryExpression ::= RegularExpression
            //
            case 453: {
                setResult(
                    new ES_PrimaryExpression6(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 454:  ES_PrimaryExpression ::= ReservedNamespace
            //
            case 454:
                break; 
            //
            // Rule 455:  ES_PrimaryExpression ::= ParenListExpression
            //
            case 455:
                break; 
            //
            // Rule 456:  ES_PrimaryExpression ::= ArrayLiteral
            //
            case 456:
                break; 
            //
            // Rule 457:  ES_PostfixExpression ::= AttributeExpression
            //
            case 457:
                break; 
            //
            // Rule 458:  ES_PostfixExpression ::= ES_FullPostfixExpression
            //
            case 458:
                break; 
            //
            // Rule 459:  ES_PostfixExpression ::= ShortNewExpression
            //
            case 459:
                break; 
            //
            // Rule 460:  ES_FullPostfixExpression ::= ES_PrimaryExpression
            //
            case 460:
                break; 
            //
            // Rule 461:  ES_FullPostfixExpression ::= ExpressionQualifiedIdentifier
            //
            case 461:
                break; 
            //
            // Rule 462:  ES_FullPostfixExpression ::= FullNewExpression
            //
            case 462:
                break; 
            //
            // Rule 463:  ES_FullPostfixExpression ::= ES_FullPostfixExpression PropertyOperator
            //
            case 463: {
                setResult(
                    new ES_FullPostfixExpression0(getLeftIToken(), getRightIToken(),
                                                  (IES_FullPostfixExpression)getRhsSym(1),
                                                  (IPropertyOperator)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 464:  ES_FullPostfixExpression ::= SuperExpression PropertyOperator
            //
            case 464: {
                setResult(
                    new ES_FullPostfixExpression1(getLeftIToken(), getRightIToken(),
                                                  (ISuperExpression)getRhsSym(1),
                                                  (IPropertyOperator)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 465:  ES_FullPostfixExpression ::= ES_FullPostfixExpression Arguments
            //
            case 465: {
                setResult(
                    new ES_FullPostfixExpression2(getLeftIToken(), getRightIToken(),
                                                  (IES_FullPostfixExpression)getRhsSym(1),
                                                  (IArguments)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 466:  ES_FullPostfixExpression ::= ES_PostfixExpression no_line_break$ ++
            //
            case 466: {
                setResult(
                    new ES_FullPostfixExpression3(getLeftIToken(), getRightIToken(),
                                                  (IES_PostfixExpression)getRhsSym(1),
                                                  new AstToken(getRhsIToken(3)))
                );
                break;
            } 
            //
            // Rule 467:  ES_FullPostfixExpression ::= ES_PostfixExpression no_line_break$ --
            //
            case 467: {
                setResult(
                    new ES_FullPostfixExpression4(getLeftIToken(), getRightIToken(),
                                                  (IES_PostfixExpression)getRhsSym(1),
                                                  new AstToken(getRhsIToken(3)))
                );
                break;
            } 
            //
            // Rule 468:  ES_UnaryExpression ::= ES_PostfixExpression
            //
            case 468:
                break; 
            //
            // Rule 469:  ES_UnaryExpression ::= DELETE PostfixExpression
            //
            case 469: {
                setResult(
                    new ES_UnaryExpression0(getLeftIToken(), getRightIToken(),
                                            new AstToken(getRhsIToken(1)),
                                            (IPostfixExpression)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 470:  ES_UnaryExpression ::= VOID UnaryExpression
            //
            case 470: {
                setResult(
                    new ES_UnaryExpression1(getLeftIToken(), getRightIToken(),
                                            new AstToken(getRhsIToken(1)),
                                            (IUnaryExpression)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 471:  ES_UnaryExpression ::= TYPEOF UnaryExpression
            //
            case 471: {
                setResult(
                    new ES_UnaryExpression2(getLeftIToken(), getRightIToken(),
                                            new AstToken(getRhsIToken(1)),
                                            (IUnaryExpression)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 472:  ES_UnaryExpression ::= ++ PostfixExpression
            //
            case 472: {
                setResult(
                    new ES_UnaryExpression3(getLeftIToken(), getRightIToken(),
                                            new AstToken(getRhsIToken(1)),
                                            (IPostfixExpression)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 473:  ES_UnaryExpression ::= -- PostfixExpression
            //
            case 473: {
                setResult(
                    new ES_UnaryExpression4(getLeftIToken(), getRightIToken(),
                                            new AstToken(getRhsIToken(1)),
                                            (IPostfixExpression)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 474:  ES_UnaryExpression ::= + UnaryExpression
            //
            case 474: {
                setResult(
                    new ES_UnaryExpression5(getLeftIToken(), getRightIToken(),
                                            new AstToken(getRhsIToken(1)),
                                            (IUnaryExpression)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 475:  ES_UnaryExpression ::= - UnaryExpression
            //
            case 475: {
                setResult(
                    new ES_UnaryExpression6(getLeftIToken(), getRightIToken(),
                                            new AstToken(getRhsIToken(1)),
                                            (IUnaryExpression)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 476:  ES_UnaryExpression ::= - NegatedMinLong
            //
            case 476: {
                setResult(
                    new ES_UnaryExpression7(getLeftIToken(), getRightIToken(),
                                            new AstToken(getRhsIToken(1)),
                                            new AstToken(getRhsIToken(2)))
                );
                break;
            } 
            //
            // Rule 477:  ES_UnaryExpression ::= ~ UnaryExpression
            //
            case 477: {
                setResult(
                    new ES_UnaryExpression8(getLeftIToken(), getRightIToken(),
                                            new AstToken(getRhsIToken(1)),
                                            (IUnaryExpression)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 478:  ES_UnaryExpression ::= ! UnaryExpression
            //
            case 478: {
                setResult(
                    new ES_UnaryExpression9(getLeftIToken(), getRightIToken(),
                                            new AstToken(getRhsIToken(1)),
                                            (IUnaryExpression)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 479:  ES_MultiplicativeExpression ::= ES_UnaryExpression
            //
            case 479:
                break; 
            //
            // Rule 480:  ES_MultiplicativeExpression ::= ES_MultiplicativeExpression * UnaryExpression
            //
            case 480: {
                setResult(
                    new ES_MultiplicativeExpression0(getLeftIToken(), getRightIToken(),
                                                     (IES_MultiplicativeExpression)getRhsSym(1),
                                                     new AstToken(getRhsIToken(2)),
                                                     (IUnaryExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 481:  ES_MultiplicativeExpression ::= ES_MultiplicativeExpression / UnaryExpression
            //
            case 481: {
                setResult(
                    new ES_MultiplicativeExpression1(getLeftIToken(), getRightIToken(),
                                                     (IES_MultiplicativeExpression)getRhsSym(1),
                                                     new AstToken(getRhsIToken(2)),
                                                     (IUnaryExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 482:  ES_MultiplicativeExpression ::= ES_MultiplicativeExpression % UnaryExpression
            //
            case 482: {
                setResult(
                    new ES_MultiplicativeExpression2(getLeftIToken(), getRightIToken(),
                                                     (IES_MultiplicativeExpression)getRhsSym(1),
                                                     new AstToken(getRhsIToken(2)),
                                                     (IUnaryExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 483:  ES_AdditiveExpression ::= ES_MultiplicativeExpression
            //
            case 483:
                break; 
            //
            // Rule 484:  ES_AdditiveExpression ::= ES_AdditiveExpression + MultiplicativeExpression
            //
            case 484: {
                setResult(
                    new ES_AdditiveExpression0(getLeftIToken(), getRightIToken(),
                                               (IES_AdditiveExpression)getRhsSym(1),
                                               new AstToken(getRhsIToken(2)),
                                               (IMultiplicativeExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 485:  ES_AdditiveExpression ::= ES_AdditiveExpression - MultiplicativeExpression
            //
            case 485: {
                setResult(
                    new ES_AdditiveExpression1(getLeftIToken(), getRightIToken(),
                                               (IES_AdditiveExpression)getRhsSym(1),
                                               new AstToken(getRhsIToken(2)),
                                               (IMultiplicativeExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 486:  ES_ShiftExpression ::= ES_AdditiveExpression
            //
            case 486:
                break; 
            //
            // Rule 487:  ES_ShiftExpression ::= ES_ShiftExpression << AdditiveExpression
            //
            case 487: {
                setResult(
                    new ES_ShiftExpression0(getLeftIToken(), getRightIToken(),
                                            (IES_ShiftExpression)getRhsSym(1),
                                            new AstToken(getRhsIToken(2)),
                                            (IAdditiveExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 488:  ES_ShiftExpression ::= ES_ShiftExpression >> AdditiveExpression
            //
            case 488: {
                setResult(
                    new ES_ShiftExpression1(getLeftIToken(), getRightIToken(),
                                            (IES_ShiftExpression)getRhsSym(1),
                                            new AstToken(getRhsIToken(2)),
                                            (IAdditiveExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 489:  ES_ShiftExpression ::= ES_ShiftExpression >>> AdditiveExpression
            //
            case 489: {
                setResult(
                    new ES_ShiftExpression2(getLeftIToken(), getRightIToken(),
                                            (IES_ShiftExpression)getRhsSym(1),
                                            new AstToken(getRhsIToken(2)),
                                            (IAdditiveExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 490:  ES_RelationalExpression_allowIn ::= ES_ShiftExpression
            //
            case 490:
                break; 
            //
            // Rule 491:  ES_RelationalExpression_allowIn ::= ES_RelationalExpression_allowIn < ShiftExpression
            //
            case 491: {
                setResult(
                    new ES_RelationalExpression_allowIn0(getLeftIToken(), getRightIToken(),
                                                         (IES_RelationalExpression_allowIn)getRhsSym(1),
                                                         new AstToken(getRhsIToken(2)),
                                                         (IShiftExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 492:  ES_RelationalExpression_allowIn ::= ES_RelationalExpression_allowIn > ShiftExpression
            //
            case 492: {
                setResult(
                    new ES_RelationalExpression_allowIn1(getLeftIToken(), getRightIToken(),
                                                         (IES_RelationalExpression_allowIn)getRhsSym(1),
                                                         new AstToken(getRhsIToken(2)),
                                                         (IShiftExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 493:  ES_RelationalExpression_allowIn ::= ES_RelationalExpression_allowIn <= ShiftExpression
            //
            case 493: {
                setResult(
                    new ES_RelationalExpression_allowIn2(getLeftIToken(), getRightIToken(),
                                                         (IES_RelationalExpression_allowIn)getRhsSym(1),
                                                         new AstToken(getRhsIToken(2)),
                                                         (IShiftExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 494:  ES_RelationalExpression_allowIn ::= ES_RelationalExpression_allowIn >= ShiftExpression
            //
            case 494: {
                setResult(
                    new ES_RelationalExpression_allowIn3(getLeftIToken(), getRightIToken(),
                                                         (IES_RelationalExpression_allowIn)getRhsSym(1),
                                                         new AstToken(getRhsIToken(2)),
                                                         (IShiftExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 495:  ES_RelationalExpression_allowIn ::= ES_RelationalExpression_allowIn IS ShiftExpression
            //
            case 495: {
                setResult(
                    new ES_RelationalExpression_allowIn4(getLeftIToken(), getRightIToken(),
                                                         (IES_RelationalExpression_allowIn)getRhsSym(1),
                                                         new AstToken(getRhsIToken(2)),
                                                         (IShiftExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 496:  ES_RelationalExpression_allowIn ::= ES_RelationalExpression_allowIn AS ShiftExpression
            //
            case 496: {
                setResult(
                    new ES_RelationalExpression_allowIn5(getLeftIToken(), getRightIToken(),
                                                         (IES_RelationalExpression_allowIn)getRhsSym(1),
                                                         new AstToken(getRhsIToken(2)),
                                                         (IShiftExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 497:  ES_RelationalExpression_allowIn ::= ES_RelationalExpression_allowIn IN ShiftExpression
            //
            case 497: {
                setResult(
                    new ES_RelationalExpression_allowIn6(getLeftIToken(), getRightIToken(),
                                                         (IES_RelationalExpression_allowIn)getRhsSym(1),
                                                         new AstToken(getRhsIToken(2)),
                                                         (IShiftExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 498:  ES_RelationalExpression_allowIn ::= ES_RelationalExpression_allowIn INSTANCEOF ShiftExpression
            //
            case 498: {
                setResult(
                    new ES_RelationalExpression_allowIn7(getLeftIToken(), getRightIToken(),
                                                         (IES_RelationalExpression_allowIn)getRhsSym(1),
                                                         new AstToken(getRhsIToken(2)),
                                                         (IShiftExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 499:  ES_EqualityExpression_allowIn ::= ES_RelationalExpression_allowIn
            //
            case 499:
                break; 
            //
            // Rule 500:  ES_EqualityExpression_allowIn ::= ES_EqualityExpression_allowIn == RelationalExpression_allowIn
            //
            case 500: {
                setResult(
                    new ES_EqualityExpression_allowIn0(getLeftIToken(), getRightIToken(),
                                                       (IES_EqualityExpression_allowIn)getRhsSym(1),
                                                       new AstToken(getRhsIToken(2)),
                                                       (IRelationalExpression_allowIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 501:  ES_EqualityExpression_allowIn ::= ES_EqualityExpression_allowIn != RelationalExpression_allowIn
            //
            case 501: {
                setResult(
                    new ES_EqualityExpression_allowIn1(getLeftIToken(), getRightIToken(),
                                                       (IES_EqualityExpression_allowIn)getRhsSym(1),
                                                       new AstToken(getRhsIToken(2)),
                                                       (IRelationalExpression_allowIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 502:  ES_EqualityExpression_allowIn ::= ES_EqualityExpression_allowIn === RelationalExpression_allowIn
            //
            case 502: {
                setResult(
                    new ES_EqualityExpression_allowIn2(getLeftIToken(), getRightIToken(),
                                                       (IES_EqualityExpression_allowIn)getRhsSym(1),
                                                       new AstToken(getRhsIToken(2)),
                                                       (IRelationalExpression_allowIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 503:  ES_EqualityExpression_allowIn ::= ES_EqualityExpression_allowIn !== RelationalExpression_allowIn
            //
            case 503: {
                setResult(
                    new ES_EqualityExpression_allowIn3(getLeftIToken(), getRightIToken(),
                                                       (IES_EqualityExpression_allowIn)getRhsSym(1),
                                                       new AstToken(getRhsIToken(2)),
                                                       (IRelationalExpression_allowIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 504:  ES_BitwiseAndExpression_allowIn ::= ES_EqualityExpression_allowIn
            //
            case 504:
                break; 
            //
            // Rule 505:  ES_BitwiseAndExpression_allowIn ::= ES_BitwiseAndExpression_allowIn & EqualityExpression_allowIn
            //
            case 505: {
                setResult(
                    new ES_BitwiseAndExpression_allowIn(getLeftIToken(), getRightIToken(),
                                                        (IES_BitwiseAndExpression_allowIn)getRhsSym(1),
                                                        new AstToken(getRhsIToken(2)),
                                                        (IEqualityExpression_allowIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 506:  ES_BitwiseXorExpression_allowIn ::= ES_BitwiseAndExpression_allowIn
            //
            case 506:
                break; 
            //
            // Rule 507:  ES_BitwiseXorExpression_allowIn ::= ES_BitwiseXorExpression_allowIn ^ BitwiseAndExpression_allowIn
            //
            case 507: {
                setResult(
                    new ES_BitwiseXorExpression_allowIn(getLeftIToken(), getRightIToken(),
                                                        (IES_BitwiseXorExpression_allowIn)getRhsSym(1),
                                                        new AstToken(getRhsIToken(2)),
                                                        (IBitwiseAndExpression_allowIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 508:  ES_BitwiseOrExpression_allowIn ::= ES_BitwiseXorExpression_allowIn
            //
            case 508:
                break; 
            //
            // Rule 509:  ES_BitwiseOrExpression_allowIn ::= ES_BitwiseOrExpression_allowIn | BitwiseXorExpression_allowIn
            //
            case 509: {
                setResult(
                    new ES_BitwiseOrExpression_allowIn(getLeftIToken(), getRightIToken(),
                                                       (IES_BitwiseOrExpression_allowIn)getRhsSym(1),
                                                       new AstToken(getRhsIToken(2)),
                                                       (IBitwiseXorExpression_allowIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 510:  ES_LogicalAndExpression_allowIn ::= ES_BitwiseOrExpression_allowIn
            //
            case 510:
                break; 
            //
            // Rule 511:  ES_LogicalAndExpression_allowIn ::= ES_LogicalAndExpression_allowIn && BitwiseOrExpression_allowIn
            //
            case 511: {
                setResult(
                    new ES_LogicalAndExpression_allowIn(getLeftIToken(), getRightIToken(),
                                                        (IES_LogicalAndExpression_allowIn)getRhsSym(1),
                                                        new AstToken(getRhsIToken(2)),
                                                        (IBitwiseOrExpression_allowIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 512:  ES_LogicalXorExpression_allowIn ::= ES_LogicalAndExpression_allowIn
            //
            case 512:
                break; 
            //
            // Rule 513:  ES_LogicalXorExpression_allowIn ::= ES_LogicalXorExpression_allowIn ^^ LogicalAndExpression_allowIn
            //
            case 513: {
                setResult(
                    new ES_LogicalXorExpression_allowIn(getLeftIToken(), getRightIToken(),
                                                        (IES_LogicalXorExpression_allowIn)getRhsSym(1),
                                                        new AstToken(getRhsIToken(2)),
                                                        (ILogicalAndExpression_allowIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 514:  ES_LogicalOrExpression_allowIn ::= ES_LogicalXorExpression_allowIn
            //
            case 514:
                break; 
            //
            // Rule 515:  ES_LogicalOrExpression_allowIn ::= ES_LogicalOrExpression_allowIn || LogicalXorExpression_allowIn
            //
            case 515: {
                setResult(
                    new ES_LogicalOrExpression_allowIn(getLeftIToken(), getRightIToken(),
                                                       (IES_LogicalOrExpression_allowIn)getRhsSym(1),
                                                       new AstToken(getRhsIToken(2)),
                                                       (ILogicalXorExpression_allowIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 516:  ES_ConditionalExpression_allowIn ::= ES_LogicalOrExpression_allowIn
            //
            case 516:
                break; 
            //
            // Rule 517:  ES_ConditionalExpression_allowIn ::= ES_LogicalOrExpression_allowIn ? AssignmentExpression_allowIn : AssignmentExpression_allowIn
            //
            case 517: {
                setResult(
                    new ES_ConditionalExpression_allowIn(getLeftIToken(), getRightIToken(),
                                                         (IES_LogicalOrExpression_allowIn)getRhsSym(1),
                                                         new AstToken(getRhsIToken(2)),
                                                         (IAssignmentExpression_allowIn)getRhsSym(3),
                                                         new AstToken(getRhsIToken(4)),
                                                         (IAssignmentExpression_allowIn)getRhsSym(5))
                );
                break;
            } 
            //
            // Rule 518:  ES_AssignmentExpression_allowIn ::= ES_ConditionalExpression_allowIn
            //
            case 518:
                break; 
            //
            // Rule 519:  ES_AssignmentExpression_allowIn ::= ES_PostfixExpression = AssignmentExpression_allowIn
            //
            case 519: {
                setResult(
                    new ES_AssignmentExpression_allowIn0(getLeftIToken(), getRightIToken(),
                                                         (IES_PostfixExpression)getRhsSym(1),
                                                         new AstToken(getRhsIToken(2)),
                                                         (IAssignmentExpression_allowIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 520:  ES_AssignmentExpression_allowIn ::= ES_PostfixExpression CompoundAssignment AssignmentExpression_allowIn
            //
            case 520: {
                setResult(
                    new ES_AssignmentExpression_allowIn1(getLeftIToken(), getRightIToken(),
                                                         (IES_PostfixExpression)getRhsSym(1),
                                                         (ICompoundAssignment)getRhsSym(2),
                                                         (IAssignmentExpression_allowIn)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 521:  ES_AssignmentExpression_allowIn ::= ES_PostfixExpression LogicalAssignment AssignmentExpression_allowIn
            //
            case 521: {
                setResult(
                    new ES_AssignmentExpression_allowIn2(getLeftIToken(), getRightIToken(),
                                                         (IES_PostfixExpression)getRhsSym(1),
                                                         (ILogicalAssignment)getRhsSym(2),
                                                         (IAssignmentExpression_allowIn)getRhsSym(3))
                );
                break;
            }
    
            default:
                break;
        }
        return;
    }
}

