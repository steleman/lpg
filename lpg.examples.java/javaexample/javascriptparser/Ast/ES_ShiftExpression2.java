package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 489:  ES_ShiftExpression ::= ES_ShiftExpression >>> AdditiveExpression
 *</b>
 */
public class ES_ShiftExpression2 extends Ast implements IES_ShiftExpression
{
    private IES_ShiftExpression _ES_ShiftExpression;
    private AstToken _UNSIGNED_RIGHT_SHIFT;
    private IAdditiveExpression _AdditiveExpression;

    public IES_ShiftExpression getES_ShiftExpression() { return _ES_ShiftExpression; }
    public AstToken getUNSIGNED_RIGHT_SHIFT() { return _UNSIGNED_RIGHT_SHIFT; }
    public IAdditiveExpression getAdditiveExpression() { return _AdditiveExpression; }

    public ES_ShiftExpression2(IToken leftIToken, IToken rightIToken,
                               IES_ShiftExpression _ES_ShiftExpression,
                               AstToken _UNSIGNED_RIGHT_SHIFT,
                               IAdditiveExpression _AdditiveExpression)
    {
        super(leftIToken, rightIToken);

        this._ES_ShiftExpression = _ES_ShiftExpression;
        this._UNSIGNED_RIGHT_SHIFT = _UNSIGNED_RIGHT_SHIFT;
        this._AdditiveExpression = _AdditiveExpression;
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
        if (! (o instanceof ES_ShiftExpression2)) return false;
        ES_ShiftExpression2 other = (ES_ShiftExpression2) o;
        if (! _ES_ShiftExpression.equals(other._ES_ShiftExpression)) return false;
        if (! _UNSIGNED_RIGHT_SHIFT.equals(other._UNSIGNED_RIGHT_SHIFT)) return false;
        if (! _AdditiveExpression.equals(other._AdditiveExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ES_ShiftExpression.hashCode());
        hash = hash * 31 + (_UNSIGNED_RIGHT_SHIFT.hashCode());
        hash = hash * 31 + (_AdditiveExpression.hashCode());
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
            _ES_ShiftExpression.accept(v);
            _UNSIGNED_RIGHT_SHIFT.accept(v);
            _AdditiveExpression.accept(v);
        }
        v.endVisit(this);
    }
}


