package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 131:  EqualityExpression_noIn ::= EqualityExpression_noIn !== RelationalExpression_noIn
 *</b>
 */
public class EqualityExpression_noIn3 extends Ast implements IEqualityExpression_noIn
{
    private IEqualityExpression_noIn _EqualityExpression_noIn;
    private AstToken _NOT_EQUAL_EQUAL;
    private IRelationalExpression_noIn _RelationalExpression_noIn;

    public IEqualityExpression_noIn getEqualityExpression_noIn() { return _EqualityExpression_noIn; }
    public AstToken getNOT_EQUAL_EQUAL() { return _NOT_EQUAL_EQUAL; }
    public IRelationalExpression_noIn getRelationalExpression_noIn() { return _RelationalExpression_noIn; }

    public EqualityExpression_noIn3(IToken leftIToken, IToken rightIToken,
                                    IEqualityExpression_noIn _EqualityExpression_noIn,
                                    AstToken _NOT_EQUAL_EQUAL,
                                    IRelationalExpression_noIn _RelationalExpression_noIn)
    {
        super(leftIToken, rightIToken);

        this._EqualityExpression_noIn = _EqualityExpression_noIn;
        this._NOT_EQUAL_EQUAL = _NOT_EQUAL_EQUAL;
        this._RelationalExpression_noIn = _RelationalExpression_noIn;
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
        if (! (o instanceof EqualityExpression_noIn3)) return false;
        EqualityExpression_noIn3 other = (EqualityExpression_noIn3) o;
        if (! _EqualityExpression_noIn.equals(other._EqualityExpression_noIn)) return false;
        if (! _NOT_EQUAL_EQUAL.equals(other._NOT_EQUAL_EQUAL)) return false;
        if (! _RelationalExpression_noIn.equals(other._RelationalExpression_noIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_EqualityExpression_noIn.hashCode());
        hash = hash * 31 + (_NOT_EQUAL_EQUAL.hashCode());
        hash = hash * 31 + (_RelationalExpression_noIn.hashCode());
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
            _EqualityExpression_noIn.accept(v);
            _NOT_EQUAL_EQUAL.accept(v);
            _RelationalExpression_noIn.accept(v);
        }
        v.endVisit(this);
    }
}


