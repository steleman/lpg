//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 238:  PostIncrementExpression ::= PostfixExpression ++
 *</b>
 */
public class PostIncrementExpression extends Ast implements IPostIncrementExpression
{
    private IPostfixExpression _PostfixExpression;
    private AstToken _PLUS_PLUS;

    public IPostfixExpression getPostfixExpression() { return _PostfixExpression; }
    public AstToken getPLUS_PLUS() { return _PLUS_PLUS; }

    public PostIncrementExpression(IToken leftIToken, IToken rightIToken,
                                   IPostfixExpression _PostfixExpression,
                                   AstToken _PLUS_PLUS)
    {
        super(leftIToken, rightIToken);

        this._PostfixExpression = _PostfixExpression;
        ((Ast) _PostfixExpression).setParent(this);
        this._PLUS_PLUS = _PLUS_PLUS;
        ((Ast) _PLUS_PLUS).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_PostfixExpression);
        list.add(_PLUS_PLUS);
        return list;
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
        if (! (o instanceof PostIncrementExpression)) return false;
        PostIncrementExpression other = (PostIncrementExpression) o;
        if (! _PostfixExpression.equals(other._PostfixExpression)) return false;
        if (! _PLUS_PLUS.equals(other._PLUS_PLUS)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_PostfixExpression.hashCode());
        hash = hash * 31 + (_PLUS_PLUS.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


