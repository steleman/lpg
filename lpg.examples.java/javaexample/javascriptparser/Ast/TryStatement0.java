package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 313:  TryStatement ::= TRY Block CatchClauses
 *</b>
 */
public class TryStatement0 extends Ast implements ITryStatement
{
    private AstToken _TRY;
    private Block _Block;
    private ICatchClauses _CatchClauses;

    public AstToken getTRY() { return _TRY; }
    public Block getBlock() { return _Block; }
    public ICatchClauses getCatchClauses() { return _CatchClauses; }

    public TryStatement0(IToken leftIToken, IToken rightIToken,
                         AstToken _TRY,
                         Block _Block,
                         ICatchClauses _CatchClauses)
    {
        super(leftIToken, rightIToken);

        this._TRY = _TRY;
        this._Block = _Block;
        this._CatchClauses = _CatchClauses;
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
        if (! (o instanceof TryStatement0)) return false;
        TryStatement0 other = (TryStatement0) o;
        if (! _TRY.equals(other._TRY)) return false;
        if (! _Block.equals(other._Block)) return false;
        if (! _CatchClauses.equals(other._CatchClauses)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_TRY.hashCode());
        hash = hash * 31 + (_Block.hashCode());
        hash = hash * 31 + (_CatchClauses.hashCode());
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
            _TRY.accept(v);
            _Block.accept(v);
            _CatchClauses.accept(v);
        }
        v.endVisit(this);
    }
}


