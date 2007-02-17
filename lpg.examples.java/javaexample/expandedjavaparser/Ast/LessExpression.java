//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 266:  RelationalExpression ::= RelationalExpression < ShiftExpression
 *</b>
 */
public class LessExpression extends Ast implements IRelationalExpression
{
    private IRelationalExpression _RelationalExpression;
    private AstToken _LESS;
    private IShiftExpression _ShiftExpression;

    public IRelationalExpression getRelationalExpression() { return _RelationalExpression; }
    public AstToken getLESS() { return _LESS; }
    public IShiftExpression getShiftExpression() { return _ShiftExpression; }

    public LessExpression(IToken leftIToken, IToken rightIToken,
                          IRelationalExpression _RelationalExpression,
                          AstToken _LESS,
                          IShiftExpression _ShiftExpression)
    {
        super(leftIToken, rightIToken);

        this._RelationalExpression = _RelationalExpression;
        ((Ast) _RelationalExpression).setParent(this);
        this._LESS = _LESS;
        ((Ast) _LESS).setParent(this);
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
        list.add(_LESS);
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
        if (! (o instanceof LessExpression)) return false;
        LessExpression other = (LessExpression) o;
        if (! _RelationalExpression.equals(other._RelationalExpression)) return false;
        if (! _LESS.equals(other._LESS)) return false;
        if (! _ShiftExpression.equals(other._ShiftExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_RelationalExpression.hashCode());
        hash = hash * 31 + (_LESS.hashCode());
        hash = hash * 31 + (_ShiftExpression.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


