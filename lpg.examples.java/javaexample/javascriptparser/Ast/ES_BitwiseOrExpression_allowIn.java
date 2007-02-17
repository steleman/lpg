package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 508:  ES_BitwiseOrExpression_allowIn ::= ES_BitwiseXorExpression_allowIn
 *</em>
 *<p>
 *<b>
 *<li>Rule 509:  ES_BitwiseOrExpression_allowIn ::= ES_BitwiseOrExpression_allowIn | BitwiseXorExpression_allowIn
 *</b>
 */
public class ES_BitwiseOrExpression_allowIn extends Ast implements IES_BitwiseOrExpression_allowIn
{
    private IES_BitwiseOrExpression_allowIn _ES_BitwiseOrExpression_allowIn;
    private AstToken _OR;
    private IBitwiseXorExpression_allowIn _BitwiseXorExpression_allowIn;

    public IES_BitwiseOrExpression_allowIn getES_BitwiseOrExpression_allowIn() { return _ES_BitwiseOrExpression_allowIn; }
    public AstToken getOR() { return _OR; }
    public IBitwiseXorExpression_allowIn getBitwiseXorExpression_allowIn() { return _BitwiseXorExpression_allowIn; }

    public ES_BitwiseOrExpression_allowIn(IToken leftIToken, IToken rightIToken,
                                          IES_BitwiseOrExpression_allowIn _ES_BitwiseOrExpression_allowIn,
                                          AstToken _OR,
                                          IBitwiseXorExpression_allowIn _BitwiseXorExpression_allowIn)
    {
        super(leftIToken, rightIToken);

        this._ES_BitwiseOrExpression_allowIn = _ES_BitwiseOrExpression_allowIn;
        this._OR = _OR;
        this._BitwiseXorExpression_allowIn = _BitwiseXorExpression_allowIn;
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
        if (! (o instanceof ES_BitwiseOrExpression_allowIn)) return false;
        ES_BitwiseOrExpression_allowIn other = (ES_BitwiseOrExpression_allowIn) o;
        if (! _ES_BitwiseOrExpression_allowIn.equals(other._ES_BitwiseOrExpression_allowIn)) return false;
        if (! _OR.equals(other._OR)) return false;
        if (! _BitwiseXorExpression_allowIn.equals(other._BitwiseXorExpression_allowIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ES_BitwiseOrExpression_allowIn.hashCode());
        hash = hash * 31 + (_OR.hashCode());
        hash = hash * 31 + (_BitwiseXorExpression_allowIn.hashCode());
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
            _ES_BitwiseOrExpression_allowIn.accept(v);
            _OR.accept(v);
            _BitwiseXorExpression_allowIn.accept(v);
        }
        v.endVisit(this);
    }
}


