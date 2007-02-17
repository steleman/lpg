package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 118:  RelationalExpression_noIn ::= RelationalExpression_noIn >= ShiftExpression
 *</b>
 */
public class RelationalExpression_noIn3 extends Ast implements IRelationalExpression_noIn
{
    private IRelationalExpression_noIn _RelationalExpression_noIn;
    private AstToken _GREATER_EQUAL;
    private IShiftExpression _ShiftExpression;

    public IRelationalExpression_noIn getRelationalExpression_noIn() { return _RelationalExpression_noIn; }
    public AstToken getGREATER_EQUAL() { return _GREATER_EQUAL; }
    public IShiftExpression getShiftExpression() { return _ShiftExpression; }

    public RelationalExpression_noIn3(IToken leftIToken, IToken rightIToken,
                                      IRelationalExpression_noIn _RelationalExpression_noIn,
                                      AstToken _GREATER_EQUAL,
                                      IShiftExpression _ShiftExpression)
    {
        super(leftIToken, rightIToken);

        this._RelationalExpression_noIn = _RelationalExpression_noIn;
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
        if (! (o instanceof RelationalExpression_noIn3)) return false;
        RelationalExpression_noIn3 other = (RelationalExpression_noIn3) o;
        if (! _RelationalExpression_noIn.equals(other._RelationalExpression_noIn)) return false;
        if (! _GREATER_EQUAL.equals(other._GREATER_EQUAL)) return false;
        if (! _ShiftExpression.equals(other._ShiftExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_RelationalExpression_noIn.hashCode());
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
            _RelationalExpression_noIn.accept(v);
            _GREATER_EQUAL.accept(v);
            _ShiftExpression.accept(v);
        }
        v.endVisit(this);
    }
}


