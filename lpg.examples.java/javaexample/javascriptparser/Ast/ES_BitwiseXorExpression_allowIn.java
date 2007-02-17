package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 506:  ES_BitwiseXorExpression_allowIn ::= ES_BitwiseAndExpression_allowIn
 *</em>
 *<p>
 *<b>
 *<li>Rule 507:  ES_BitwiseXorExpression_allowIn ::= ES_BitwiseXorExpression_allowIn ^ BitwiseAndExpression_allowIn
 *</b>
 */
public class ES_BitwiseXorExpression_allowIn extends Ast implements IES_BitwiseXorExpression_allowIn
{
    private IES_BitwiseXorExpression_allowIn _ES_BitwiseXorExpression_allowIn;
    private AstToken _XOR;
    private IBitwiseAndExpression_allowIn _BitwiseAndExpression_allowIn;

    public IES_BitwiseXorExpression_allowIn getES_BitwiseXorExpression_allowIn() { return _ES_BitwiseXorExpression_allowIn; }
    public AstToken getXOR() { return _XOR; }
    public IBitwiseAndExpression_allowIn getBitwiseAndExpression_allowIn() { return _BitwiseAndExpression_allowIn; }

    public ES_BitwiseXorExpression_allowIn(IToken leftIToken, IToken rightIToken,
                                           IES_BitwiseXorExpression_allowIn _ES_BitwiseXorExpression_allowIn,
                                           AstToken _XOR,
                                           IBitwiseAndExpression_allowIn _BitwiseAndExpression_allowIn)
    {
        super(leftIToken, rightIToken);

        this._ES_BitwiseXorExpression_allowIn = _ES_BitwiseXorExpression_allowIn;
        this._XOR = _XOR;
        this._BitwiseAndExpression_allowIn = _BitwiseAndExpression_allowIn;
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
        if (! (o instanceof ES_BitwiseXorExpression_allowIn)) return false;
        ES_BitwiseXorExpression_allowIn other = (ES_BitwiseXorExpression_allowIn) o;
        if (! _ES_BitwiseXorExpression_allowIn.equals(other._ES_BitwiseXorExpression_allowIn)) return false;
        if (! _XOR.equals(other._XOR)) return false;
        if (! _BitwiseAndExpression_allowIn.equals(other._BitwiseAndExpression_allowIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ES_BitwiseXorExpression_allowIn.hashCode());
        hash = hash * 31 + (_XOR.hashCode());
        hash = hash * 31 + (_BitwiseAndExpression_allowIn.hashCode());
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
            _ES_BitwiseXorExpression_allowIn.accept(v);
            _XOR.accept(v);
            _BitwiseAndExpression_allowIn.accept(v);
        }
        v.endVisit(this);
    }
}


