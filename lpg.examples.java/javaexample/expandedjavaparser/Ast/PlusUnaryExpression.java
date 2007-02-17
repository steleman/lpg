//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 243:  UnaryExpression ::= + UnaryExpression
 *</b>
 */
public class PlusUnaryExpression extends Ast implements IUnaryExpression
{
    private AstToken _PLUS;
    private IUnaryExpression _UnaryExpression;

    public AstToken getPLUS() { return _PLUS; }
    public IUnaryExpression getUnaryExpression() { return _UnaryExpression; }

    public PlusUnaryExpression(IToken leftIToken, IToken rightIToken,
                               AstToken _PLUS,
                               IUnaryExpression _UnaryExpression)
    {
        super(leftIToken, rightIToken);

        this._PLUS = _PLUS;
        ((Ast) _PLUS).setParent(this);
        this._UnaryExpression = _UnaryExpression;
        ((Ast) _UnaryExpression).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_PLUS);
        list.add(_UnaryExpression);
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
        if (! (o instanceof PlusUnaryExpression)) return false;
        PlusUnaryExpression other = (PlusUnaryExpression) o;
        if (! _PLUS.equals(other._PLUS)) return false;
        if (! _UnaryExpression.equals(other._UnaryExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_PLUS.hashCode());
        hash = hash * 31 + (_UnaryExpression.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


