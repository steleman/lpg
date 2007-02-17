//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 270:  RelationalExpression ::= RelationalExpression instanceof ReferenceType
 *</b>
 */
public class InstanceofExpression extends Ast implements IRelationalExpression
{
    private IRelationalExpression _RelationalExpression;
    private AstToken _instanceof;
    private IReferenceType _ReferenceType;

    public IRelationalExpression getRelationalExpression() { return _RelationalExpression; }
    public AstToken getinstanceof() { return _instanceof; }
    public IReferenceType getReferenceType() { return _ReferenceType; }

    public InstanceofExpression(IToken leftIToken, IToken rightIToken,
                                IRelationalExpression _RelationalExpression,
                                AstToken _instanceof,
                                IReferenceType _ReferenceType)
    {
        super(leftIToken, rightIToken);

        this._RelationalExpression = _RelationalExpression;
        ((Ast) _RelationalExpression).setParent(this);
        this._instanceof = _instanceof;
        ((Ast) _instanceof).setParent(this);
        this._ReferenceType = _ReferenceType;
        ((Ast) _ReferenceType).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_RelationalExpression);
        list.add(_instanceof);
        list.add(_ReferenceType);
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
        if (! (o instanceof InstanceofExpression)) return false;
        InstanceofExpression other = (InstanceofExpression) o;
        if (! _RelationalExpression.equals(other._RelationalExpression)) return false;
        if (! _instanceof.equals(other._instanceof)) return false;
        if (! _ReferenceType.equals(other._ReferenceType)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_RelationalExpression.hashCode());
        hash = hash * 31 + (_instanceof.hashCode());
        hash = hash * 31 + (_ReferenceType.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


