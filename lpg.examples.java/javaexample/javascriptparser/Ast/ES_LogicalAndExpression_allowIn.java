package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 510:  ES_LogicalAndExpression_allowIn ::= ES_BitwiseOrExpression_allowIn
 *</em>
 *<p>
 *<b>
 *<li>Rule 511:  ES_LogicalAndExpression_allowIn ::= ES_LogicalAndExpression_allowIn && BitwiseOrExpression_allowIn
 *</b>
 */
public class ES_LogicalAndExpression_allowIn extends Ast implements IES_LogicalAndExpression_allowIn
{
    private IES_LogicalAndExpression_allowIn _ES_LogicalAndExpression_allowIn;
    private AstToken _AND_AND;
    private IBitwiseOrExpression_allowIn _BitwiseOrExpression_allowIn;

    public IES_LogicalAndExpression_allowIn getES_LogicalAndExpression_allowIn() { return _ES_LogicalAndExpression_allowIn; }
    public AstToken getAND_AND() { return _AND_AND; }
    public IBitwiseOrExpression_allowIn getBitwiseOrExpression_allowIn() { return _BitwiseOrExpression_allowIn; }

    public ES_LogicalAndExpression_allowIn(IToken leftIToken, IToken rightIToken,
                                           IES_LogicalAndExpression_allowIn _ES_LogicalAndExpression_allowIn,
                                           AstToken _AND_AND,
                                           IBitwiseOrExpression_allowIn _BitwiseOrExpression_allowIn)
    {
        super(leftIToken, rightIToken);

        this._ES_LogicalAndExpression_allowIn = _ES_LogicalAndExpression_allowIn;
        this._AND_AND = _AND_AND;
        this._BitwiseOrExpression_allowIn = _BitwiseOrExpression_allowIn;
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
        if (! (o instanceof ES_LogicalAndExpression_allowIn)) return false;
        ES_LogicalAndExpression_allowIn other = (ES_LogicalAndExpression_allowIn) o;
        if (! _ES_LogicalAndExpression_allowIn.equals(other._ES_LogicalAndExpression_allowIn)) return false;
        if (! _AND_AND.equals(other._AND_AND)) return false;
        if (! _BitwiseOrExpression_allowIn.equals(other._BitwiseOrExpression_allowIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ES_LogicalAndExpression_allowIn.hashCode());
        hash = hash * 31 + (_AND_AND.hashCode());
        hash = hash * 31 + (_BitwiseOrExpression_allowIn.hashCode());
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
            _ES_LogicalAndExpression_allowIn.accept(v);
            _AND_AND.accept(v);
            _BitwiseOrExpression_allowIn.accept(v);
        }
        v.endVisit(this);
    }
}


