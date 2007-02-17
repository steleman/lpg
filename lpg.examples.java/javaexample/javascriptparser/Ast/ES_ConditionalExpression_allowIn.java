package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 516:  ES_ConditionalExpression_allowIn ::= ES_LogicalOrExpression_allowIn
 *</em>
 *<p>
 *<b>
 *<li>Rule 517:  ES_ConditionalExpression_allowIn ::= ES_LogicalOrExpression_allowIn ? AssignmentExpression_allowIn : AssignmentExpression_allowIn
 *</b>
 */
public class ES_ConditionalExpression_allowIn extends Ast implements IES_ConditionalExpression_allowIn
{
    private IES_LogicalOrExpression_allowIn _ES_LogicalOrExpression_allowIn;
    private AstToken _QUESTION;
    private IAssignmentExpression_allowIn _AssignmentExpression_allowIn;
    private AstToken _COLON;
    private IAssignmentExpression_allowIn _AssignmentExpression_allowIn5;

    public IES_LogicalOrExpression_allowIn getES_LogicalOrExpression_allowIn() { return _ES_LogicalOrExpression_allowIn; }
    public AstToken getQUESTION() { return _QUESTION; }
    public IAssignmentExpression_allowIn getAssignmentExpression_allowIn() { return _AssignmentExpression_allowIn; }
    public AstToken getCOLON() { return _COLON; }
    public IAssignmentExpression_allowIn getAssignmentExpression_allowIn5() { return _AssignmentExpression_allowIn5; }

    public ES_ConditionalExpression_allowIn(IToken leftIToken, IToken rightIToken,
                                            IES_LogicalOrExpression_allowIn _ES_LogicalOrExpression_allowIn,
                                            AstToken _QUESTION,
                                            IAssignmentExpression_allowIn _AssignmentExpression_allowIn,
                                            AstToken _COLON,
                                            IAssignmentExpression_allowIn _AssignmentExpression_allowIn5)
    {
        super(leftIToken, rightIToken);

        this._ES_LogicalOrExpression_allowIn = _ES_LogicalOrExpression_allowIn;
        this._QUESTION = _QUESTION;
        this._AssignmentExpression_allowIn = _AssignmentExpression_allowIn;
        this._COLON = _COLON;
        this._AssignmentExpression_allowIn5 = _AssignmentExpression_allowIn5;
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
        if (! (o instanceof ES_ConditionalExpression_allowIn)) return false;
        ES_ConditionalExpression_allowIn other = (ES_ConditionalExpression_allowIn) o;
        if (! _ES_LogicalOrExpression_allowIn.equals(other._ES_LogicalOrExpression_allowIn)) return false;
        if (! _QUESTION.equals(other._QUESTION)) return false;
        if (! _AssignmentExpression_allowIn.equals(other._AssignmentExpression_allowIn)) return false;
        if (! _COLON.equals(other._COLON)) return false;
        if (! _AssignmentExpression_allowIn5.equals(other._AssignmentExpression_allowIn5)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ES_LogicalOrExpression_allowIn.hashCode());
        hash = hash * 31 + (_QUESTION.hashCode());
        hash = hash * 31 + (_AssignmentExpression_allowIn.hashCode());
        hash = hash * 31 + (_COLON.hashCode());
        hash = hash * 31 + (_AssignmentExpression_allowIn5.hashCode());
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
            _ES_LogicalOrExpression_allowIn.accept(v);
            _QUESTION.accept(v);
            _AssignmentExpression_allowIn.accept(v);
            _COLON.accept(v);
            _AssignmentExpression_allowIn5.accept(v);
        }
        v.endVisit(this);
    }
}


