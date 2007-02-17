package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 134:  BitwiseAndExpression_noIn ::= EqualityExpression_noIn
 *</em>
 *<p>
 *<b>
 *<li>Rule 135:  BitwiseAndExpression_noIn ::= BitwiseAndExpression_noIn & EqualityExpression_noIn
 *</b>
 */
public class BitwiseAndExpression_noIn extends Ast implements IBitwiseAndExpression_noIn
{
    private IBitwiseAndExpression_noIn _BitwiseAndExpression_noIn;
    private AstToken _AND;
    private IEqualityExpression_noIn _EqualityExpression_noIn;

    public IBitwiseAndExpression_noIn getBitwiseAndExpression_noIn() { return _BitwiseAndExpression_noIn; }
    public AstToken getAND() { return _AND; }
    public IEqualityExpression_noIn getEqualityExpression_noIn() { return _EqualityExpression_noIn; }

    public BitwiseAndExpression_noIn(IToken leftIToken, IToken rightIToken,
                                     IBitwiseAndExpression_noIn _BitwiseAndExpression_noIn,
                                     AstToken _AND,
                                     IEqualityExpression_noIn _EqualityExpression_noIn)
    {
        super(leftIToken, rightIToken);

        this._BitwiseAndExpression_noIn = _BitwiseAndExpression_noIn;
        this._AND = _AND;
        this._EqualityExpression_noIn = _EqualityExpression_noIn;
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
        if (! (o instanceof BitwiseAndExpression_noIn)) return false;
        BitwiseAndExpression_noIn other = (BitwiseAndExpression_noIn) o;
        if (! _BitwiseAndExpression_noIn.equals(other._BitwiseAndExpression_noIn)) return false;
        if (! _AND.equals(other._AND)) return false;
        if (! _EqualityExpression_noIn.equals(other._EqualityExpression_noIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_BitwiseAndExpression_noIn.hashCode());
        hash = hash * 31 + (_AND.hashCode());
        hash = hash * 31 + (_EqualityExpression_noIn.hashCode());
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
            _BitwiseAndExpression_noIn.accept(v);
            _AND.accept(v);
            _EqualityExpression_noIn.accept(v);
        }
        v.endVisit(this);
    }
}


