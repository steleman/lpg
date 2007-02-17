package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 109:  RelationalExpression_allowIn ::= RelationalExpression_allowIn >= ShiftExpression
 *</b>
 */
public class RelationalExpression_allowIn3 extends Ast implements IRelationalExpression_allowIn
{
    private IRelationalExpression_allowIn _RelationalExpression_allowIn;
    private AstToken _GREATER_EQUAL;
    private IShiftExpression _ShiftExpression;

    public IRelationalExpression_allowIn getRelationalExpression_allowIn() { return _RelationalExpression_allowIn; }
    public AstToken getGREATER_EQUAL() { return _GREATER_EQUAL; }
    public IShiftExpression getShiftExpression() { return _ShiftExpression; }

    public RelationalExpression_allowIn3(IToken leftIToken, IToken rightIToken,
                                         IRelationalExpression_allowIn _RelationalExpression_allowIn,
                                         AstToken _GREATER_EQUAL,
                                         IShiftExpression _ShiftExpression)
    {
        super(leftIToken, rightIToken);

        this._RelationalExpression_allowIn = _RelationalExpression_allowIn;
        this._GREATER_EQUAL = _GREATER_EQUAL;
        this._ShiftExpression = _ShiftExpression;
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
        if (! (o instanceof RelationalExpression_allowIn3)) return false;
        RelationalExpression_allowIn3 other = (RelationalExpression_allowIn3) o;
        if (! _RelationalExpression_allowIn.equals(other._RelationalExpression_allowIn)) return false;
        if (! _GREATER_EQUAL.equals(other._GREATER_EQUAL)) return false;
        if (! _ShiftExpression.equals(other._ShiftExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_RelationalExpression_allowIn.hashCode());
        hash = hash * 31 + (_GREATER_EQUAL.hashCode());
        hash = hash * 31 + (_ShiftExpression.hashCode());
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
            _RelationalExpression_allowIn.accept(v);
            _GREATER_EQUAL.accept(v);
            _ShiftExpression.accept(v);
        }
        v.endVisit(this);
    }
}


