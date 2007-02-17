package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 495:  ES_RelationalExpression_allowIn ::= ES_RelationalExpression_allowIn IS ShiftExpression
 *</b>
 */
public class ES_RelationalExpression_allowIn4 extends Ast implements IES_RelationalExpression_allowIn
{
    private IES_RelationalExpression_allowIn _ES_RelationalExpression_allowIn;
    private AstToken _IS;
    private IShiftExpression _ShiftExpression;

    public IES_RelationalExpression_allowIn getES_RelationalExpression_allowIn() { return _ES_RelationalExpression_allowIn; }
    public AstToken getIS() { return _IS; }
    public IShiftExpression getShiftExpression() { return _ShiftExpression; }

    public ES_RelationalExpression_allowIn4(IToken leftIToken, IToken rightIToken,
                                            IES_RelationalExpression_allowIn _ES_RelationalExpression_allowIn,
                                            AstToken _IS,
                                            IShiftExpression _ShiftExpression)
    {
        super(leftIToken, rightIToken);

        this._ES_RelationalExpression_allowIn = _ES_RelationalExpression_allowIn;
        this._IS = _IS;
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
        if (! (o instanceof ES_RelationalExpression_allowIn4)) return false;
        ES_RelationalExpression_allowIn4 other = (ES_RelationalExpression_allowIn4) o;
        if (! _ES_RelationalExpression_allowIn.equals(other._ES_RelationalExpression_allowIn)) return false;
        if (! _IS.equals(other._IS)) return false;
        if (! _ShiftExpression.equals(other._ShiftExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ES_RelationalExpression_allowIn.hashCode());
        hash = hash * 31 + (_IS.hashCode());
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
            _ES_RelationalExpression_allowIn.accept(v);
            _IS.accept(v);
            _ShiftExpression.accept(v);
        }
        v.endVisit(this);
    }
}


