package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 142:  BitwiseOrExpression_noIn ::= BitwiseXorExpression_noIn
 *</em>
 *<p>
 *<b>
 *<li>Rule 143:  BitwiseOrExpression_noIn ::= BitwiseOrExpression_noIn | BitwiseXorExpression_noIn
 *</b>
 */
public class BitwiseOrExpression_noIn extends Ast implements IBitwiseOrExpression_noIn
{
    private IBitwiseOrExpression_noIn _BitwiseOrExpression_noIn;
    private AstToken _OR;
    private IBitwiseXorExpression_noIn _BitwiseXorExpression_noIn;

    public IBitwiseOrExpression_noIn getBitwiseOrExpression_noIn() { return _BitwiseOrExpression_noIn; }
    public AstToken getOR() { return _OR; }
    public IBitwiseXorExpression_noIn getBitwiseXorExpression_noIn() { return _BitwiseXorExpression_noIn; }

    public BitwiseOrExpression_noIn(IToken leftIToken, IToken rightIToken,
                                    IBitwiseOrExpression_noIn _BitwiseOrExpression_noIn,
                                    AstToken _OR,
                                    IBitwiseXorExpression_noIn _BitwiseXorExpression_noIn)
    {
        super(leftIToken, rightIToken);

        this._BitwiseOrExpression_noIn = _BitwiseOrExpression_noIn;
        this._OR = _OR;
        this._BitwiseXorExpression_noIn = _BitwiseXorExpression_noIn;
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
        if (! (o instanceof BitwiseOrExpression_noIn)) return false;
        BitwiseOrExpression_noIn other = (BitwiseOrExpression_noIn) o;
        if (! _BitwiseOrExpression_noIn.equals(other._BitwiseOrExpression_noIn)) return false;
        if (! _OR.equals(other._OR)) return false;
        if (! _BitwiseXorExpression_noIn.equals(other._BitwiseXorExpression_noIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_BitwiseOrExpression_noIn.hashCode());
        hash = hash * 31 + (_OR.hashCode());
        hash = hash * 31 + (_BitwiseXorExpression_noIn.hashCode());
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
            _BitwiseOrExpression_noIn.accept(v);
            _OR.accept(v);
            _BitwiseXorExpression_noIn.accept(v);
        }
        v.endVisit(this);
    }
}


