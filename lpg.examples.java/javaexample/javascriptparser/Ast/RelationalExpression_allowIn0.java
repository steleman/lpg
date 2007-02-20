package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 106:  RelationalExpression_allowIn ::= RelationalExpression_allowIn < ShiftExpression
 *</b>
 */
public class RelationalExpression_allowIn0 extends Ast implements IRelationalExpression_allowIn
{
    private IRelationalExpression_allowIn _RelationalExpression_allowIn;
    private AstToken _LESS;
    private IShiftExpression _ShiftExpression;

    public IRelationalExpression_allowIn getRelationalExpression_allowIn() { return _RelationalExpression_allowIn; }
    public AstToken getLESS() { return _LESS; }
    public IShiftExpression getShiftExpression() { return _ShiftExpression; }

    public RelationalExpression_allowIn0(IToken leftIToken, IToken rightIToken,
                                         IRelationalExpression_allowIn _RelationalExpression_allowIn,
                                         AstToken _LESS,
                                         IShiftExpression _ShiftExpression)
    {
        super(leftIToken, rightIToken);

        this._RelationalExpression_allowIn = _RelationalExpression_allowIn;
        this._LESS = _LESS;
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
        if (! (o instanceof RelationalExpression_allowIn0)) return false;
        RelationalExpression_allowIn0 other = (RelationalExpression_allowIn0) o;
        if (! _RelationalExpression_allowIn.equals(other._RelationalExpression_allowIn)) return false;
        if (! _LESS.equals(other._LESS)) return false;
        if (! _ShiftExpression.equals(other._ShiftExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_RelationalExpression_allowIn.hashCode());
        hash = hash * 31 + (_LESS.hashCode());
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
            _LESS.accept(v);
            _ShiftExpression.accept(v);
        }
        v.endVisit(this);
    }
}

