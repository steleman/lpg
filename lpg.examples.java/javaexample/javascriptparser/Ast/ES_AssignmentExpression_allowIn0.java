package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 519:  ES_AssignmentExpression_allowIn ::= ES_PostfixExpression = AssignmentExpression_allowIn
 *</b>
 */
public class ES_AssignmentExpression_allowIn0 extends Ast implements IES_AssignmentExpression_allowIn
{
    private IES_PostfixExpression _ES_PostfixExpression;
    private AstToken _EQUAL;
    private IAssignmentExpression_allowIn _AssignmentExpression_allowIn;

    public IES_PostfixExpression getES_PostfixExpression() { return _ES_PostfixExpression; }
    public AstToken getEQUAL() { return _EQUAL; }
    public IAssignmentExpression_allowIn getAssignmentExpression_allowIn() { return _AssignmentExpression_allowIn; }

    public ES_AssignmentExpression_allowIn0(IToken leftIToken, IToken rightIToken,
                                            IES_PostfixExpression _ES_PostfixExpression,
                                            AstToken _EQUAL,
                                            IAssignmentExpression_allowIn _AssignmentExpression_allowIn)
    {
        super(leftIToken, rightIToken);

        this._ES_PostfixExpression = _ES_PostfixExpression;
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
        if (! (o instanceof ES_AssignmentExpression_allowIn0)) return false;
        ES_AssignmentExpression_allowIn0 other = (ES_AssignmentExpression_allowIn0) o;
        if (! _ES_PostfixExpression.equals(other._ES_PostfixExpression)) return false;
        if (! _EQUAL.equals(other._EQUAL)) return false;
        if (! _AssignmentExpression_allowIn.equals(other._AssignmentExpression_allowIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ES_PostfixExpression.hashCode());
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
            _ES_PostfixExpression.accept(v);
            _EQUAL.accept(v);
            _AssignmentExpression_allowIn.accept(v);
        }
        v.endVisit(this);
    }
}


