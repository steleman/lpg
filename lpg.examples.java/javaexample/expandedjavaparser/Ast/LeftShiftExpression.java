//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 262:  ShiftExpression ::= ShiftExpression << AdditiveExpression
 *</b>
 */
public class LeftShiftExpression extends Ast implements IShiftExpression
{
    private IShiftExpression _ShiftExpression;
    private AstToken _LEFT_SHIFT;
    private IAdditiveExpression _AdditiveExpression;

    public IShiftExpression getShiftExpression() { return _ShiftExpression; }
    public AstToken getLEFT_SHIFT() { return _LEFT_SHIFT; }
    public IAdditiveExpression getAdditiveExpression() { return _AdditiveExpression; }

    public LeftShiftExpression(IToken leftIToken, IToken rightIToken,
                               IShiftExpression _ShiftExpression,
                               AstToken _LEFT_SHIFT,
                               IAdditiveExpression _AdditiveExpression)
    {
        super(leftIToken, rightIToken);

        this._ShiftExpression = _ShiftExpression;
        ((Ast) _ShiftExpression).setParent(this);
        this._LEFT_SHIFT = _LEFT_SHIFT;
        ((Ast) _LEFT_SHIFT).setParent(this);
        this._AdditiveExpression = _AdditiveExpression;
        ((Ast) _AdditiveExpression).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_ShiftExpression);
        list.add(_LEFT_SHIFT);
        list.add(_AdditiveExpression);
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
        if (! (o instanceof LeftShiftExpression)) return false;
        LeftShiftExpression other = (LeftShiftExpression) o;
        if (! _ShiftExpression.equals(other._ShiftExpression)) return false;
        if (! _LEFT_SHIFT.equals(other._LEFT_SHIFT)) return false;
        if (! _AdditiveExpression.equals(other._AdditiveExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ShiftExpression.hashCode());
        hash = hash * 31 + (_LEFT_SHIFT.hashCode());
        hash = hash * 31 + (_AdditiveExpression.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


