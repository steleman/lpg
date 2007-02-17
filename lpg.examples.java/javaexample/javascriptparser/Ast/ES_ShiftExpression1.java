package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 488:  ES_ShiftExpression ::= ES_ShiftExpression >> AdditiveExpression
 *</b>
 */
public class ES_ShiftExpression1 extends Ast implements IES_ShiftExpression
{
    private IES_ShiftExpression _ES_ShiftExpression;
    private AstToken _RIGHT_SHIFT;
    private IAdditiveExpression _AdditiveExpression;

    public IES_ShiftExpression getES_ShiftExpression() { return _ES_ShiftExpression; }
    public AstToken getRIGHT_SHIFT() { return _RIGHT_SHIFT; }
    public IAdditiveExpression getAdditiveExpression() { return _AdditiveExpression; }

    public ES_ShiftExpression1(IToken leftIToken, IToken rightIToken,
                               IES_ShiftExpression _ES_ShiftExpression,
                               AstToken _RIGHT_SHIFT,
                               IAdditiveExpression _AdditiveExpression)
    {
        super(leftIToken, rightIToken);

        this._ES_ShiftExpression = _ES_ShiftExpression;
        this._RIGHT_SHIFT = _RIGHT_SHIFT;
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
        if (! (o instanceof ES_ShiftExpression1)) return false;
        ES_ShiftExpression1 other = (ES_ShiftExpression1) o;
        if (! _ES_ShiftExpression.equals(other._ES_ShiftExpression)) return false;
        if (! _RIGHT_SHIFT.equals(other._RIGHT_SHIFT)) return false;
        if (! _AdditiveExpression.equals(other._AdditiveExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ES_ShiftExpression.hashCode());
        hash = hash * 31 + (_RIGHT_SHIFT.hashCode());
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
            _RIGHT_SHIFT.accept(v);
            _AdditiveExpression.accept(v);
        }
        v.endVisit(this);
    }
}


