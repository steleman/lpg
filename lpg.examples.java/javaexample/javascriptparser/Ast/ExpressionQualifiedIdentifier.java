package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 9:  ExpressionQualifiedIdentifier ::= ParenExpression :: Identifier
 *</b>
 */
public class ExpressionQualifiedIdentifier extends Ast implements IExpressionQualifiedIdentifier
{
    private ParenExpression _ParenExpression;
    private AstToken _COLON_COLON;
    private IIdentifier _Identifier;

    public ParenExpression getParenExpression() { return _ParenExpression; }
    public AstToken getCOLON_COLON() { return _COLON_COLON; }
    public IIdentifier getIdentifier() { return _Identifier; }

    public ExpressionQualifiedIdentifier(IToken leftIToken, IToken rightIToken,
                                         ParenExpression _ParenExpression,
                                         AstToken _COLON_COLON,
                                         IIdentifier _Identifier)
    {
        super(leftIToken, rightIToken);

        this._ParenExpression = _ParenExpression;
        this._COLON_COLON = _COLON_COLON;
        this._Identifier = _Identifier;
        initialize();
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        //
        // The super call test is not required for now because an Ast node
        // can only extend the root Ast, AstToken and AstList and none of
        // these nodes contain additional children.
        //
        // if (! super.equals(o)) return false;
        //
        if (! (o instanceof ExpressionQualifiedIdentifier)) return false;
        ExpressionQualifiedIdentifier other = (ExpressionQualifiedIdentifier) o;
        if (! _ParenExpression.equals(other._ParenExpression)) return false;
        if (! _COLON_COLON.equals(other._COLON_COLON)) return false;
        if (! _Identifier.equals(other._Identifier)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ParenExpression.hashCode());
        hash = hash * 31 + (_COLON_COLON.hashCode());
        hash = hash * 31 + (_Identifier.hashCode());
        return hash;
    }

    public void accept(Visitor v)
    {
        if (! v.preVisit(this)) return;
        enter(v);
        v.postVisit(this);
    }

    public void enter(Visitor v)
    {
        boolean checkChildren = v.visit(this);
        if (checkChildren)
        {
            _ParenExpression.accept(v);
            _COLON_COLON.accept(v);
            _Identifier.accept(v);
        }
        v.endVisit(this);
    }
}


