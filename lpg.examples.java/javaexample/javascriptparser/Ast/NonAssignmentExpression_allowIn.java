package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 160:  NonAssignmentExpression_allowIn ::= LogicalOrExpression_allowIn
 *</em>
 *<p>
 *<b>
 *<li>Rule 161:  NonAssignmentExpression_allowIn ::= LogicalOrExpression_allowIn ? NonAssignmentExpression_allowIn : NonAssignmentExpression_allowIn
 *</b>
 */
public class NonAssignmentExpression_allowIn extends Ast implements INonAssignmentExpression_allowIn
{
    private ILogicalOrExpression_allowIn _LogicalOrExpression_allowIn;
    private AstToken _QUESTION;
    private INonAssignmentExpression_allowIn _NonAssignmentExpression_allowIn;
    private AstToken _COLON;
    private INonAssignmentExpression_allowIn _NonAssignmentExpression_allowIn5;

    public ILogicalOrExpression_allowIn getLogicalOrExpression_allowIn() { return _LogicalOrExpression_allowIn; }
    public AstToken getQUESTION() { return _QUESTION; }
    public INonAssignmentExpression_allowIn getNonAssignmentExpression_allowIn() { return _NonAssignmentExpression_allowIn; }
    public AstToken getCOLON() { return _COLON; }
    public INonAssignmentExpression_allowIn getNonAssignmentExpression_allowIn5() { return _NonAssignmentExpression_allowIn5; }

    public NonAssignmentExpression_allowIn(IToken leftIToken, IToken rightIToken,
                                           ILogicalOrExpression_allowIn _LogicalOrExpression_allowIn,
                                           AstToken _QUESTION,
                                           INonAssignmentExpression_allowIn _NonAssignmentExpression_allowIn,
                                           AstToken _COLON,
                                           INonAssignmentExpression_allowIn _NonAssignmentExpression_allowIn5)
    {
        super(leftIToken, rightIToken);

        this._LogicalOrExpression_allowIn = _LogicalOrExpression_allowIn;
        this._QUESTION = _QUESTION;
        this._NonAssignmentExpression_allowIn = _NonAssignmentExpression_allowIn;
        this._COLON = _COLON;
        this._NonAssignmentExpression_allowIn5 = _NonAssignmentExpression_allowIn5;
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
        if (! (o instanceof NonAssignmentExpression_allowIn)) return false;
        NonAssignmentExpression_allowIn other = (NonAssignmentExpression_allowIn) o;
        if (! _LogicalOrExpression_allowIn.equals(other._LogicalOrExpression_allowIn)) return false;
        if (! _QUESTION.equals(other._QUESTION)) return false;
        if (! _NonAssignmentExpression_allowIn.equals(other._NonAssignmentExpression_allowIn)) return false;
        if (! _COLON.equals(other._COLON)) return false;
        if (! _NonAssignmentExpression_allowIn5.equals(other._NonAssignmentExpression_allowIn5)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_LogicalOrExpression_allowIn.hashCode());
        hash = hash * 31 + (_QUESTION.hashCode());
        hash = hash * 31 + (_NonAssignmentExpression_allowIn.hashCode());
        hash = hash * 31 + (_COLON.hashCode());
        hash = hash * 31 + (_NonAssignmentExpression_allowIn5.hashCode());
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
            _LogicalOrExpression_allowIn.accept(v);
            _QUESTION.accept(v);
            _NonAssignmentExpression_allowIn.accept(v);
            _COLON.accept(v);
            _NonAssignmentExpression_allowIn5.accept(v);
        }
        v.endVisit(this);
    }
}


