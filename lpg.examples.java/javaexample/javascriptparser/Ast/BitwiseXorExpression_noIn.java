package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 138:  BitwiseXorExpression_noIn ::= BitwiseAndExpression_noIn
 *</em>
 *<p>
 *<b>
 *<li>Rule 139:  BitwiseXorExpression_noIn ::= BitwiseXorExpression_noIn ^ BitwiseAndExpression_noIn
 *</b>
 */
public class BitwiseXorExpression_noIn extends Ast implements IBitwiseXorExpression_noIn
{
    private IBitwiseXorExpression_noIn _BitwiseXorExpression_noIn;
    private AstToken _XOR;
    private IBitwiseAndExpression_noIn _BitwiseAndExpression_noIn;

    public IBitwiseXorExpression_noIn getBitwiseXorExpression_noIn() { return _BitwiseXorExpression_noIn; }
    public AstToken getXOR() { return _XOR; }
    public IBitwiseAndExpression_noIn getBitwiseAndExpression_noIn() { return _BitwiseAndExpression_noIn; }

    public BitwiseXorExpression_noIn(IToken leftIToken, IToken rightIToken,
                                     IBitwiseXorExpression_noIn _BitwiseXorExpression_noIn,
                                     AstToken _XOR,
                                     IBitwiseAndExpression_noIn _BitwiseAndExpression_noIn)
    {
        super(leftIToken, rightIToken);

        this._BitwiseXorExpression_noIn = _BitwiseXorExpression_noIn;
        this._XOR = _XOR;
        this._BitwiseAndExpression_noIn = _BitwiseAndExpression_noIn;
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
        if (! (o instanceof BitwiseXorExpression_noIn)) return false;
        BitwiseXorExpression_noIn other = (BitwiseXorExpression_noIn) o;
        if (! _BitwiseXorExpression_noIn.equals(other._BitwiseXorExpression_noIn)) return false;
        if (! _XOR.equals(other._XOR)) return false;
        if (! _BitwiseAndExpression_noIn.equals(other._BitwiseAndExpression_noIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_BitwiseXorExpression_noIn.hashCode());
        hash = hash * 31 + (_XOR.hashCode());
        hash = hash * 31 + (_BitwiseAndExpression_noIn.hashCode());
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
            _BitwiseXorExpression_noIn.accept(v);
            _XOR.accept(v);
            _BitwiseAndExpression_noIn.accept(v);
        }
        v.endVisit(this);
    }
}


