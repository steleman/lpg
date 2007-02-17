//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 269:  RelationalExpression ::= RelationalExpression >= ShiftExpression
 *</b>
 */
public class GreaterEqualExpression extends Ast implements IRelationalExpression
{
    private IRelationalExpression _RelationalExpression;
    private AstToken _GREATER_EQUAL;
    private IShiftExpression _ShiftExpression;

    public IRelationalExpression getRelationalExpression() { return _RelationalExpression; }
    public AstToken getGREATER_EQUAL() { return _GREATER_EQUAL; }
    public IShiftExpression getShiftExpression() { return _ShiftExpression; }

    public GreaterEqualExpression(IToken leftIToken, IToken rightIToken,
                                  IRelationalExpression _RelationalExpression,
                                  AstToken _GREATER_EQUAL,
                                  IShiftExpression _ShiftExpression)
    {
        super(leftIToken, rightIToken);

        this._RelationalExpression = _RelationalExpression;
        ((Ast) _RelationalExpression).setParent(this);
        this._GREATER_EQUAL = _GREATER_EQUAL;
        ((Ast) _GREATER_EQUAL).setParent(this);
        this._ShiftExpression = _ShiftExpression;
        ((Ast) _ShiftExpression).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_RelationalExpression);
        list.add(_GREATER_EQUAL);
        list.add(_ShiftExpression);
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
        if (! (o instanceof GreaterEqualExpression)) return false;
        GreaterEqualExpression other = (GreaterEqualExpression) o;
        if (! _RelationalExpression.equals(other._RelationalExpression)) return false;
        if (! _GREATER_EQUAL.equals(other._GREATER_EQUAL)) return false;
        if (! _ShiftExpression.equals(other._ShiftExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_RelationalExpression.hashCode());
        hash = hash * 31 + (_GREATER_EQUAL.hashCode());
        hash = hash * 31 + (_ShiftExpression.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


