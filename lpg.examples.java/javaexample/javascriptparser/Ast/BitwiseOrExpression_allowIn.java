package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 140:  BitwiseOrExpression_allowIn ::= BitwiseXorExpression_allowIn
 *</em>
 *<p>
 *<b>
 *<li>Rule 141:  BitwiseOrExpression_allowIn ::= BitwiseOrExpression_allowIn | BitwiseXorExpression_allowIn
 *</b>
 */
public class BitwiseOrExpression_allowIn extends Ast implements IBitwiseOrExpression_allowIn
{
    private IBitwiseOrExpression_allowIn _BitwiseOrExpression_allowIn;
    private AstToken _OR;
    private IBitwiseXorExpression_allowIn _BitwiseXorExpression_allowIn;

    public IBitwiseOrExpression_allowIn getBitwiseOrExpression_allowIn() { return _BitwiseOrExpression_allowIn; }
    public AstToken getOR() { return _OR; }
    public IBitwiseXorExpression_allowIn getBitwiseXorExpression_allowIn() { return _BitwiseXorExpression_allowIn; }

    public BitwiseOrExpression_allowIn(IToken leftIToken, IToken rightIToken,
                                       IBitwiseOrExpression_allowIn _BitwiseOrExpression_allowIn,
                                       AstToken _OR,
                                       IBitwiseXorExpression_allowIn _BitwiseXorExpression_allowIn)
    {
        super(leftIToken, rightIToken);

        this._BitwiseOrExpression_allowIn = _BitwiseOrExpression_allowIn;
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
        if (! (o instanceof BitwiseOrExpression_allowIn)) return false;
        BitwiseOrExpression_allowIn other = (BitwiseOrExpression_allowIn) o;
        if (! _BitwiseOrExpression_allowIn.equals(other._BitwiseOrExpression_allowIn)) return false;
        if (! _OR.equals(other._OR)) return false;
        if (! _BitwiseXorExpression_allowIn.equals(other._BitwiseXorExpression_allowIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_BitwiseOrExpression_allowIn.hashCode());
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
            _BitwiseOrExpression_allowIn.accept(v);
            _OR.accept(v);
            _BitwiseXorExpression_allowIn.accept(v);
        }
        v.endVisit(this);
    }
}


