package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 162:  NonAssignmentExpression_noIn ::= LogicalOrExpression_noIn
 *</em>
 *<p>
 *<b>
 *<li>Rule 163:  NonAssignmentExpression_noIn ::= LogicalOrExpression_noIn ? NonAssignmentExpression_noIn : NonAssignmentExpression_noIn
 *</b>
 */
public class NonAssignmentExpression_noIn extends Ast implements INonAssignmentExpression_noIn
{
    private ILogicalOrExpression_noIn _LogicalOrExpression_noIn;
    private AstToken _QUESTION;
    private INonAssignmentExpression_noIn _NonAssignmentExpression_noIn;
    private AstToken _COLON;
    private INonAssignmentExpression_noIn _NonAssignmentExpression_noIn5;

    public ILogicalOrExpression_noIn getLogicalOrExpression_noIn() { return _LogicalOrExpression_noIn; }
    public AstToken getQUESTION() { return _QUESTION; }
    public INonAssignmentExpression_noIn getNonAssignmentExpression_noIn() { return _NonAssignmentExpression_noIn; }
    public AstToken getCOLON() { return _COLON; }
    public INonAssignmentExpression_noIn getNonAssignmentExpression_noIn5() { return _NonAssignmentExpression_noIn5; }

    public NonAssignmentExpression_noIn(IToken leftIToken, IToken rightIToken,
                                        ILogicalOrExpression_noIn _LogicalOrExpression_noIn,
                                        AstToken _QUESTION,
                                        INonAssignmentExpression_noIn _NonAssignmentExpression_noIn,
                                        AstToken _COLON,
                                        INonAssignmentExpression_noIn _NonAssignmentExpression_noIn5)
    {
        super(leftIToken, rightIToken);

        this._LogicalOrExpression_noIn = _LogicalOrExpression_noIn;
        this._QUESTION = _QUESTION;
        this._NonAssignmentExpression_noIn = _NonAssignmentExpression_noIn;
        this._COLON = _COLON;
        this._NonAssignmentExpression_noIn5 = _NonAssignmentExpression_noIn5;
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
        if (! (o instanceof NonAssignmentExpression_noIn)) return false;
        NonAssignmentExpression_noIn other = (NonAssignmentExpression_noIn) o;
        if (! _LogicalOrExpression_noIn.equals(other._LogicalOrExpression_noIn)) return false;
        if (! _QUESTION.equals(other._QUESTION)) return false;
        if (! _NonAssignmentExpression_noIn.equals(other._NonAssignmentExpression_noIn)) return false;
        if (! _COLON.equals(other._COLON)) return false;
        if (! _NonAssignmentExpression_noIn5.equals(other._NonAssignmentExpression_noIn5)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_LogicalOrExpression_noIn.hashCode());
        hash = hash * 31 + (_QUESTION.hashCode());
        hash = hash * 31 + (_NonAssignmentExpression_noIn.hashCode());
        hash = hash * 31 + (_COLON.hashCode());
        hash = hash * 31 + (_NonAssignmentExpression_noIn5.hashCode());
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
            _NonAssignmentExpression_noIn.accept(v);
            _COLON.accept(v);
            _NonAssignmentExpression_noIn5.accept(v);
        }
        v.endVisit(this);
    }
}


