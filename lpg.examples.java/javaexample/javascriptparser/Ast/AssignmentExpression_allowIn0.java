package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 165:  AssignmentExpression_allowIn ::= PostfixExpression = AssignmentExpression_allowIn
 *</b>
 */
public class AssignmentExpression_allowIn0 extends Ast implements IAssignmentExpression_allowIn
{
    private IPostfixExpression _PostfixExpression;
    private AstToken _EQUAL;
    private IAssignmentExpression_allowIn _AssignmentExpression_allowIn;

    public IPostfixExpression getPostfixExpression() { return _PostfixExpression; }
    public AstToken getEQUAL() { return _EQUAL; }
    public IAssignmentExpression_allowIn getAssignmentExpression_allowIn() { return _AssignmentExpression_allowIn; }

    public AssignmentExpression_allowIn0(IToken leftIToken, IToken rightIToken,
                                         IPostfixExpression _PostfixExpression,
                                         AstToken _EQUAL,
                                         IAssignmentExpression_allowIn _AssignmentExpression_allowIn)
    {
        super(leftIToken, rightIToken);

        this._PostfixExpression = _PostfixExpression;
        this._EQUAL = _EQUAL;
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
        if (! (o instanceof AssignmentExpression_allowIn0)) return false;
        AssignmentExpression_allowIn0 other = (AssignmentExpression_allowIn0) o;
        if (! _PostfixExpression.equals(other._PostfixExpression)) return false;
        if (! _EQUAL.equals(other._EQUAL)) return false;
        if (! _AssignmentExpression_allowIn.equals(other._AssignmentExpression_allowIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_PostfixExpression.hashCode());
        hash = hash * 31 + (_EQUAL.hashCode());
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
            _EQUAL.accept(v);
            _AssignmentExpression_allowIn.accept(v);
        }
        v.endVisit(this);
    }
}


