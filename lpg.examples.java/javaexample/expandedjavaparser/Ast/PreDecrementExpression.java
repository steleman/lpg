//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 246:  PreDecrementExpression ::= -- UnaryExpression
 *</b>
 */
public class PreDecrementExpression extends Ast implements IPreDecrementExpression
{
    private AstToken _MINUS_MINUS;
    private IUnaryExpression _UnaryExpression;

    public AstToken getMINUS_MINUS() { return _MINUS_MINUS; }
    public IUnaryExpression getUnaryExpression() { return _UnaryExpression; }

    public PreDecrementExpression(IToken leftIToken, IToken rightIToken,
                                  AstToken _MINUS_MINUS,
                                  IUnaryExpression _UnaryExpression)
    {
        super(leftIToken, rightIToken);

        this._MINUS_MINUS = _MINUS_MINUS;
        ((Ast) _MINUS_MINUS).setParent(this);
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
        list.add(_MINUS_MINUS);
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
        if (! (o instanceof PreDecrementExpression)) return false;
        PreDecrementExpression other = (PreDecrementExpression) o;
        if (! _MINUS_MINUS.equals(other._MINUS_MINUS)) return false;
        if (! _UnaryExpression.equals(other._UnaryExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_MINUS_MINUS.hashCode());
        hash = hash * 31 + (_UnaryExpression.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


