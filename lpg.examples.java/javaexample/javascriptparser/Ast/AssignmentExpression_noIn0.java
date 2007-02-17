package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 169:  AssignmentExpression_noIn ::= PostfixExpression = AssignmentExpression_noIn
 *</b>
 */
public class AssignmentExpression_noIn0 extends Ast implements IAssignmentExpression_noIn
{
    private IPostfixExpression _PostfixExpression;
    private AstToken _EQUAL;
    private IAssignmentExpression_noIn _AssignmentExpression_noIn;

    public IPostfixExpression getPostfixExpression() { return _PostfixExpression; }
    public AstToken getEQUAL() { return _EQUAL; }
    public IAssignmentExpression_noIn getAssignmentExpression_noIn() { return _AssignmentExpression_noIn; }

    public AssignmentExpression_noIn0(IToken leftIToken, IToken rightIToken,
                                      IPostfixExpression _PostfixExpression,
                                      AstToken _EQUAL,
                                      IAssignmentExpression_noIn _AssignmentExpression_noIn)
    {
        super(leftIToken, rightIToken);

        this._PostfixExpression = _PostfixExpression;
        this._EQUAL = _EQUAL;
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
        if (! (o instanceof AssignmentExpression_noIn0)) return false;
        AssignmentExpression_noIn0 other = (AssignmentExpression_noIn0) o;
        if (! _PostfixExpression.equals(other._PostfixExpression)) return false;
        if (! _EQUAL.equals(other._EQUAL)) return false;
        if (! _AssignmentExpression_noIn.equals(other._AssignmentExpression_noIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_PostfixExpression.hashCode());
        hash = hash * 31 + (_EQUAL.hashCode());
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
            _EQUAL.accept(v);
            _AssignmentExpression_noIn.accept(v);
        }
        v.endVisit(this);
    }
}


