package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 473:  ES_UnaryExpression ::= -- PostfixExpression
 *</b>
 */
public class ES_UnaryExpression4 extends Ast implements IES_UnaryExpression
{
    private AstToken _MINUS_MINUS;
    private IPostfixExpression _PostfixExpression;

    public AstToken getMINUS_MINUS() { return _MINUS_MINUS; }
    public IPostfixExpression getPostfixExpression() { return _PostfixExpression; }

    public ES_UnaryExpression4(IToken leftIToken, IToken rightIToken,
                               AstToken _MINUS_MINUS,
                               IPostfixExpression _PostfixExpression)
    {
        super(leftIToken, rightIToken);

        this._MINUS_MINUS = _MINUS_MINUS;
        this._PostfixExpression = _PostfixExpression;
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
        if (! (o instanceof ES_UnaryExpression4)) return false;
        ES_UnaryExpression4 other = (ES_UnaryExpression4) o;
        if (! _MINUS_MINUS.equals(other._MINUS_MINUS)) return false;
        if (! _PostfixExpression.equals(other._PostfixExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_MINUS_MINUS.hashCode());
        hash = hash * 31 + (_PostfixExpression.hashCode());
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
            _MINUS_MINUS.accept(v);
            _PostfixExpression.accept(v);
        }
        v.endVisit(this);
    }
}


