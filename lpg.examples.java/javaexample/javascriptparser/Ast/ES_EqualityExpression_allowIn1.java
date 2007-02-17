package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 501:  ES_EqualityExpression_allowIn ::= ES_EqualityExpression_allowIn != RelationalExpression_allowIn
 *</b>
 */
public class ES_EqualityExpression_allowIn1 extends Ast implements IES_EqualityExpression_allowIn
{
    private IES_EqualityExpression_allowIn _ES_EqualityExpression_allowIn;
    private AstToken _NOT_EQUAL;
    private IRelationalExpression_allowIn _RelationalExpression_allowIn;

    public IES_EqualityExpression_allowIn getES_EqualityExpression_allowIn() { return _ES_EqualityExpression_allowIn; }
    public AstToken getNOT_EQUAL() { return _NOT_EQUAL; }
    public IRelationalExpression_allowIn getRelationalExpression_allowIn() { return _RelationalExpression_allowIn; }

    public ES_EqualityExpression_allowIn1(IToken leftIToken, IToken rightIToken,
                                          IES_EqualityExpression_allowIn _ES_EqualityExpression_allowIn,
                                          AstToken _NOT_EQUAL,
                                          IRelationalExpression_allowIn _RelationalExpression_allowIn)
    {
        super(leftIToken, rightIToken);

        this._ES_EqualityExpression_allowIn = _ES_EqualityExpression_allowIn;
        this._NOT_EQUAL = _NOT_EQUAL;
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
        if (! (o instanceof ES_EqualityExpression_allowIn1)) return false;
        ES_EqualityExpression_allowIn1 other = (ES_EqualityExpression_allowIn1) o;
        if (! _ES_EqualityExpression_allowIn.equals(other._ES_EqualityExpression_allowIn)) return false;
        if (! _NOT_EQUAL.equals(other._NOT_EQUAL)) return false;
        if (! _RelationalExpression_allowIn.equals(other._RelationalExpression_allowIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ES_EqualityExpression_allowIn.hashCode());
        hash = hash * 31 + (_NOT_EQUAL.hashCode());
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
            _ES_EqualityExpression_allowIn.accept(v);
            _NOT_EQUAL.accept(v);
            _RelationalExpression_allowIn.accept(v);
        }
        v.endVisit(this);
    }
}


