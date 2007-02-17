package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 472:  ES_UnaryExpression ::= ++ PostfixExpression
 *</b>
 */
public class ES_UnaryExpression3 extends Ast implements IES_UnaryExpression
{
    private AstToken _PLUS_PLUS;
    private IPostfixExpression _PostfixExpression;

    public AstToken getPLUS_PLUS() { return _PLUS_PLUS; }
    public IPostfixExpression getPostfixExpression() { return _PostfixExpression; }

    public ES_UnaryExpression3(IToken leftIToken, IToken rightIToken,
                               AstToken _PLUS_PLUS,
                               IPostfixExpression _PostfixExpression)
    {
        super(leftIToken, rightIToken);

        this._PLUS_PLUS = _PLUS_PLUS;
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
        if (! (o instanceof ES_UnaryExpression3)) return false;
        ES_UnaryExpression3 other = (ES_UnaryExpression3) o;
        if (! _PLUS_PLUS.equals(other._PLUS_PLUS)) return false;
        if (! _PostfixExpression.equals(other._PostfixExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_PLUS_PLUS.hashCode());
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
            _PLUS_PLUS.accept(v);
            _PostfixExpression.accept(v);
        }
        v.endVisit(this);
    }
}


