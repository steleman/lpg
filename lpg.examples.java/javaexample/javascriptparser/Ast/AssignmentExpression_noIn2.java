package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 171:  AssignmentExpression_noIn ::= PostfixExpression LogicalAssignment AssignmentExpression_noIn
 *</b>
 */
public class AssignmentExpression_noIn2 extends Ast implements IAssignmentExpression_noIn
{
    private IPostfixExpression _PostfixExpression;
    private ILogicalAssignment _LogicalAssignment;
    private IAssignmentExpression_noIn _AssignmentExpression_noIn;

    public IPostfixExpression getPostfixExpression() { return _PostfixExpression; }
    public ILogicalAssignment getLogicalAssignment() { return _LogicalAssignment; }
    public IAssignmentExpression_noIn getAssignmentExpression_noIn() { return _AssignmentExpression_noIn; }

    public AssignmentExpression_noIn2(IToken leftIToken, IToken rightIToken,
                                      IPostfixExpression _PostfixExpression,
                                      ILogicalAssignment _LogicalAssignment,
                                      IAssignmentExpression_noIn _AssignmentExpression_noIn)
    {
        super(leftIToken, rightIToken);

        this._PostfixExpression = _PostfixExpression;
        this._LogicalAssignment = _LogicalAssignment;
        this._AssignmentExpression_noIn = _AssignmentExpression_noIn;
        initialize();
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
        if (! (o instanceof AssignmentExpression_noIn2)) return false;
        AssignmentExpression_noIn2 other = (AssignmentExpression_noIn2) o;
        if (! _PostfixExpression.equals(other._PostfixExpression)) return false;
        if (! _LogicalAssignment.equals(other._LogicalAssignment)) return false;
        if (! _AssignmentExpression_noIn.equals(other._AssignmentExpression_noIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_PostfixExpression.hashCode());
        hash = hash * 31 + (_LogicalAssignment.hashCode());
        hash = hash * 31 + (_AssignmentExpression_noIn.hashCode());
        return hash;
    }

    public void accept(Visitor v)
    {
        if (! v.preVisit(this)) return;
        enter(v);
        v.postVisit(this);
    }

    public void enter(Visitor v)
    {
        boolean checkChildren = v.visit(this);
        if (checkChildren)
        {
            _PostfixExpression.accept(v);
            _LogicalAssignment.accept(v);
            _AssignmentExpression_noIn.accept(v);
        }
        v.endVisit(this);
    }
}


