package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 158:  ConditionalExpression_noIn ::= LogicalOrExpression_noIn
 *</em>
 *<p>
 *<b>
 *<li>Rule 159:  ConditionalExpression_noIn ::= LogicalOrExpression_noIn ? AssignmentExpression_noIn : AssignmentExpression_noIn
 *</b>
 */
public class ConditionalExpression_noIn extends Ast implements IConditionalExpression_noIn
{
    private ILogicalOrExpression_noIn _LogicalOrExpression_noIn;
    private AstToken _QUESTION;
    private IAssignmentExpression_noIn _AssignmentExpression_noIn;
    private AstToken _COLON;
    private IAssignmentExpression_noIn _AssignmentExpression_noIn5;

    public ILogicalOrExpression_noIn getLogicalOrExpression_noIn() { return _LogicalOrExpression_noIn; }
    public AstToken getQUESTION() { return _QUESTION; }
    public IAssignmentExpression_noIn getAssignmentExpression_noIn() { return _AssignmentExpression_noIn; }
    public AstToken getCOLON() { return _COLON; }
    public IAssignmentExpression_noIn getAssignmentExpression_noIn5() { return _AssignmentExpression_noIn5; }

    public ConditionalExpression_noIn(IToken leftIToken, IToken rightIToken,
                                      ILogicalOrExpression_noIn _LogicalOrExpression_noIn,
                                      AstToken _QUESTION,
                                      IAssignmentExpression_noIn _AssignmentExpression_noIn,
                                      AstToken _COLON,
                                      IAssignmentExpression_noIn _AssignmentExpression_noIn5)
    {
        super(leftIToken, rightIToken);

        this._LogicalOrExpression_noIn = _LogicalOrExpression_noIn;
        this._QUESTION = _QUESTION;
        this._AssignmentExpression_noIn = _AssignmentExpression_noIn;
        this._COLON = _COLON;
        this._AssignmentExpression_noIn5 = _AssignmentExpression_noIn5;
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
        if (! (o instanceof ConditionalExpression_noIn)) return false;
        ConditionalExpression_noIn other = (ConditionalExpression_noIn) o;
        if (! _LogicalOrExpression_noIn.equals(other._LogicalOrExpression_noIn)) return false;
        if (! _QUESTION.equals(other._QUESTION)) return false;
        if (! _AssignmentExpression_noIn.equals(other._AssignmentExpression_noIn)) return false;
        if (! _COLON.equals(other._COLON)) return false;
        if (! _AssignmentExpression_noIn5.equals(other._AssignmentExpression_noIn5)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_LogicalOrExpression_noIn.hashCode());
        hash = hash * 31 + (_QUESTION.hashCode());
        hash = hash * 31 + (_AssignmentExpression_noIn.hashCode());
        hash = hash * 31 + (_COLON.hashCode());
        hash = hash * 31 + (_AssignmentExpression_noIn5.hashCode());
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
            _LogicalOrExpression_noIn.accept(v);
            _QUESTION.accept(v);
            _AssignmentExpression_noIn.accept(v);
            _COLON.accept(v);
            _AssignmentExpression_noIn5.accept(v);
        }
        v.endVisit(this);
    }
}


