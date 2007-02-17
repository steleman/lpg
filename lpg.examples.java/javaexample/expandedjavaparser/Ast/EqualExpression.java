//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 272:  EqualityExpression ::= EqualityExpression == RelationalExpression
 *</b>
 */
public class EqualExpression extends Ast implements IEqualityExpression
{
    private IEqualityExpression _EqualityExpression;
    private AstToken _EQUAL_EQUAL;
    private IRelationalExpression _RelationalExpression;

    public IEqualityExpression getEqualityExpression() { return _EqualityExpression; }
    public AstToken getEQUAL_EQUAL() { return _EQUAL_EQUAL; }
    public IRelationalExpression getRelationalExpression() { return _RelationalExpression; }

    public EqualExpression(IToken leftIToken, IToken rightIToken,
                           IEqualityExpression _EqualityExpression,
                           AstToken _EQUAL_EQUAL,
                           IRelationalExpression _RelationalExpression)
    {
        super(leftIToken, rightIToken);

        this._EqualityExpression = _EqualityExpression;
        ((Ast) _EqualityExpression).setParent(this);
        this._EQUAL_EQUAL = _EQUAL_EQUAL;
        ((Ast) _EQUAL_EQUAL).setParent(this);
        this._RelationalExpression = _RelationalExpression;
        ((Ast) _RelationalExpression).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_EqualityExpression);
        list.add(_EQUAL_EQUAL);
        list.add(_RelationalExpression);
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
        if (! (o instanceof EqualExpression)) return false;
        EqualExpression other = (EqualExpression) o;
        if (! _EqualityExpression.equals(other._EqualityExpression)) return false;
        if (! _EQUAL_EQUAL.equals(other._EQUAL_EQUAL)) return false;
        if (! _RelationalExpression.equals(other._RelationalExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_EqualityExpression.hashCode());
        hash = hash * 31 + (_EQUAL_EQUAL.hashCode());
        hash = hash * 31 + (_RelationalExpression.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


