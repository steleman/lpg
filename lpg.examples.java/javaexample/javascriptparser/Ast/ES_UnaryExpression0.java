package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 469:  ES_UnaryExpression ::= DELETE PostfixExpression
 *</b>
 */
public class ES_UnaryExpression0 extends Ast implements IES_UnaryExpression
{
    private AstToken _DELETE;
    private IPostfixExpression _PostfixExpression;

    public AstToken getDELETE() { return _DELETE; }
    public IPostfixExpression getPostfixExpression() { return _PostfixExpression; }

    public ES_UnaryExpression0(IToken leftIToken, IToken rightIToken,
                               AstToken _DELETE,
                               IPostfixExpression _PostfixExpression)
    {
        super(leftIToken, rightIToken);

        this._DELETE = _DELETE;
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
        if (! (o instanceof ES_UnaryExpression0)) return false;
        ES_UnaryExpression0 other = (ES_UnaryExpression0) o;
        if (! _DELETE.equals(other._DELETE)) return false;
        if (! _PostfixExpression.equals(other._PostfixExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_DELETE.hashCode());
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
            _DELETE.accept(v);
            _PostfixExpression.accept(v);
        }
        v.endVisit(this);
    }
}

