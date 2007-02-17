package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 126:  EqualityExpression_allowIn ::= EqualityExpression_allowIn !== RelationalExpression_allowIn
 *</b>
 */
public class EqualityExpression_allowIn3 extends Ast implements IEqualityExpression_allowIn
{
    private IEqualityExpression_allowIn _EqualityExpression_allowIn;
    private AstToken _NOT_EQUAL_EQUAL;
    private IRelationalExpression_allowIn _RelationalExpression_allowIn;

    public IEqualityExpression_allowIn getEqualityExpression_allowIn() { return _EqualityExpression_allowIn; }
    public AstToken getNOT_EQUAL_EQUAL() { return _NOT_EQUAL_EQUAL; }
    public IRelationalExpression_allowIn getRelationalExpression_allowIn() { return _RelationalExpression_allowIn; }

    public EqualityExpression_allowIn3(IToken leftIToken, IToken rightIToken,
                                       IEqualityExpression_allowIn _EqualityExpression_allowIn,
                                       AstToken _NOT_EQUAL_EQUAL,
                                       IRelationalExpression_allowIn _RelationalExpression_allowIn)
    {
        super(leftIToken, rightIToken);

        this._EqualityExpression_allowIn = _EqualityExpression_allowIn;
        this._NOT_EQUAL_EQUAL = _NOT_EQUAL_EQUAL;
        this._RelationalExpression_allowIn = _RelationalExpression_allowIn;
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
        if (! (o instanceof EqualityExpression_allowIn3)) return false;
        EqualityExpression_allowIn3 other = (EqualityExpression_allowIn3) o;
        if (! _EqualityExpression_allowIn.equals(other._EqualityExpression_allowIn)) return false;
        if (! _NOT_EQUAL_EQUAL.equals(other._NOT_EQUAL_EQUAL)) return false;
        if (! _RelationalExpression_allowIn.equals(other._RelationalExpression_allowIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_EqualityExpression_allowIn.hashCode());
        hash = hash * 31 + (_NOT_EQUAL_EQUAL.hashCode());
        hash = hash * 31 + (_RelationalExpression_allowIn.hashCode());
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
            _EqualityExpression_allowIn.accept(v);
            _NOT_EQUAL_EQUAL.accept(v);
            _RelationalExpression_allowIn.accept(v);
        }
        v.endVisit(this);
    }
}


