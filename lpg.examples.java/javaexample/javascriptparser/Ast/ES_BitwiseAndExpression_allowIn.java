package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 504:  ES_BitwiseAndExpression_allowIn ::= ES_EqualityExpression_allowIn
 *</em>
 *<p>
 *<b>
 *<li>Rule 505:  ES_BitwiseAndExpression_allowIn ::= ES_BitwiseAndExpression_allowIn & EqualityExpression_allowIn
 *</b>
 */
public class ES_BitwiseAndExpression_allowIn extends Ast implements IES_BitwiseAndExpression_allowIn
{
    private IES_BitwiseAndExpression_allowIn _ES_BitwiseAndExpression_allowIn;
    private AstToken _AND;
    private IEqualityExpression_allowIn _EqualityExpression_allowIn;

    public IES_BitwiseAndExpression_allowIn getES_BitwiseAndExpression_allowIn() { return _ES_BitwiseAndExpression_allowIn; }
    public AstToken getAND() { return _AND; }
    public IEqualityExpression_allowIn getEqualityExpression_allowIn() { return _EqualityExpression_allowIn; }

    public ES_BitwiseAndExpression_allowIn(IToken leftIToken, IToken rightIToken,
                                           IES_BitwiseAndExpression_allowIn _ES_BitwiseAndExpression_allowIn,
                                           AstToken _AND,
                                           IEqualityExpression_allowIn _EqualityExpression_allowIn)
    {
        super(leftIToken, rightIToken);

        this._ES_BitwiseAndExpression_allowIn = _ES_BitwiseAndExpression_allowIn;
        this._AND = _AND;
        this._EqualityExpression_allowIn = _EqualityExpression_allowIn;
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
        if (! (o instanceof ES_BitwiseAndExpression_allowIn)) return false;
        ES_BitwiseAndExpression_allowIn other = (ES_BitwiseAndExpression_allowIn) o;
        if (! _ES_BitwiseAndExpression_allowIn.equals(other._ES_BitwiseAndExpression_allowIn)) return false;
        if (! _AND.equals(other._AND)) return false;
        if (! _EqualityExpression_allowIn.equals(other._EqualityExpression_allowIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ES_BitwiseAndExpression_allowIn.hashCode());
        hash = hash * 31 + (_AND.hashCode());
        hash = hash * 31 + (_EqualityExpression_allowIn.hashCode());
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
            _ES_BitwiseAndExpression_allowIn.accept(v);
            _AND.accept(v);
            _EqualityExpression_allowIn.accept(v);
        }
        v.endVisit(this);
    }
}


