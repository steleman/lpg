//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 288:  Assignment ::= LeftHandSide AssignmentOperator AssignmentExpression
 *</b>
 */
public class Assignment extends Ast implements IAssignment
{
    private ILeftHandSide _LeftHandSide;
    private IAssignmentOperator _AssignmentOperator;
    private IAssignmentExpression _AssignmentExpression;

    public ILeftHandSide getLeftHandSide() { return _LeftHandSide; }
    public IAssignmentOperator getAssignmentOperator() { return _AssignmentOperator; }
    public IAssignmentExpression getAssignmentExpression() { return _AssignmentExpression; }

    public Assignment(IToken leftIToken, IToken rightIToken,
                      ILeftHandSide _LeftHandSide,
                      IAssignmentOperator _AssignmentOperator,
                      IAssignmentExpression _AssignmentExpression)
    {
        super(leftIToken, rightIToken);

        this._LeftHandSide = _LeftHandSide;
        ((Ast) _LeftHandSide).setParent(this);
        this._AssignmentOperator = _AssignmentOperator;
        ((Ast) _AssignmentOperator).setParent(this);
        this._AssignmentExpression = _AssignmentExpression;
        ((Ast) _AssignmentExpression).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_LeftHandSide);
        list.add(_AssignmentOperator);
        list.add(_AssignmentExpression);
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
        if (! (o instanceof Assignment)) return false;
        Assignment other = (Assignment) o;
        if (! _LeftHandSide.equals(other._LeftHandSide)) return false;
        if (! _AssignmentOperator.equals(other._AssignmentOperator)) return false;
        if (! _AssignmentExpression.equals(other._AssignmentExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_LeftHandSide.hashCode());
        hash = hash * 31 + (_AssignmentOperator.hashCode());
        hash = hash * 31 + (_AssignmentExpression.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


