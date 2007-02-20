package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 166:  AssignmentExpression_allowIn ::= PostfixExpression CompoundAssignment AssignmentExpression_allowIn
 *</b>
 */
public class AssignmentExpression_allowIn1 extends Ast implements IAssignmentExpression_allowIn
{
    private IPostfixExpression _PostfixExpression;
    private ICompoundAssignment _CompoundAssignment;
    private IAssignmentExpression_allowIn _AssignmentExpression_allowIn;

    public IPostfixExpression getPostfixExpression() { return _PostfixExpression; }
    public ICompoundAssignment getCompoundAssignment() { return _CompoundAssignment; }
    public IAssignmentExpression_allowIn getAssignmentExpression_allowIn() { return _AssignmentExpression_allowIn; }

    public AssignmentExpression_allowIn1(IToken leftIToken, IToken rightIToken,
                                         IPostfixExpression _PostfixExpression,
                                         ICompoundAssignment _CompoundAssignment,
                                         IAssignmentExpression_allowIn _AssignmentExpression_allowIn)
    {
        super(leftIToken, rightIToken);

        this._PostfixExpression = _PostfixExpression;
        this._CompoundAssignment = _CompoundAssignment;
        this._AssignmentExpression_allowIn = _AssignmentExpression_allowIn;
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
        if (! (o instanceof AssignmentExpression_allowIn1)) return false;
        AssignmentExpression_allowIn1 other = (AssignmentExpression_allowIn1) o;
        if (! _PostfixExpression.equals(other._PostfixExpression)) return false;
        if (! _CompoundAssignment.equals(other._CompoundAssignment)) return false;
        if (! _AssignmentExpression_allowIn.equals(other._AssignmentExpression_allowIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_PostfixExpression.hashCode());
        hash = hash * 31 + (_CompoundAssignment.hashCode());
        hash = hash * 31 + (_AssignmentExpression_allowIn.hashCode());
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
            _CompoundAssignment.accept(v);
            _AssignmentExpression_allowIn.accept(v);
        }
        v.endVisit(this);
    }
}

