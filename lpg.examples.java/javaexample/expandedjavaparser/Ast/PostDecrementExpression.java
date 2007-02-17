//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 239:  PostDecrementExpression ::= PostfixExpression --
 *</b>
 */
public class PostDecrementExpression extends Ast implements IPostDecrementExpression
{
    private IPostfixExpression _PostfixExpression;
    private AstToken _MINUS_MINUS;

    public IPostfixExpression getPostfixExpression() { return _PostfixExpression; }
    public AstToken getMINUS_MINUS() { return _MINUS_MINUS; }

    public PostDecrementExpression(IToken leftIToken, IToken rightIToken,
                                   IPostfixExpression _PostfixExpression,
                                   AstToken _MINUS_MINUS)
    {
        super(leftIToken, rightIToken);

        this._PostfixExpression = _PostfixExpression;
        ((Ast) _PostfixExpression).setParent(this);
        this._MINUS_MINUS = _MINUS_MINUS;
        ((Ast) _MINUS_MINUS).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_PostfixExpression);
        list.add(_MINUS_MINUS);
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
        if (! (o instanceof PostDecrementExpression)) return false;
        PostDecrementExpression other = (PostDecrementExpression) o;
        if (! _PostfixExpression.equals(other._PostfixExpression)) return false;
        if (! _MINUS_MINUS.equals(other._MINUS_MINUS)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_PostfixExpression.hashCode());
        hash = hash * 31 + (_MINUS_MINUS.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


