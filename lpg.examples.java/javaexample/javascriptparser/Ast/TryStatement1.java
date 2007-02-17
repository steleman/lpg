package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 314:  TryStatement ::= TRY Block CatchClausesOpt FINALLY Block
 *</b>
 */
public class TryStatement1 extends Ast implements ITryStatement
{
    private AstToken _TRY;
    private Block _Block;
    private ICatchClausesOpt _CatchClausesOpt;
    private AstToken _FINALLY;
    private Block _Block5;

    public AstToken getTRY() { return _TRY; }
    public Block getBlock() { return _Block; }
    /**
     * The value returned by <b>getCatchClausesOpt</b> may be <b>null</b>
     */
    public ICatchClausesOpt getCatchClausesOpt() { return _CatchClausesOpt; }
    public AstToken getFINALLY() { return _FINALLY; }
    public Block getBlock5() { return _Block5; }

    public TryStatement1(IToken leftIToken, IToken rightIToken,
                         AstToken _TRY,
                         Block _Block,
                         ICatchClausesOpt _CatchClausesOpt,
                         AstToken _FINALLY,
                         Block _Block5)
    {
        super(leftIToken, rightIToken);

        this._TRY = _TRY;
        this._Block = _Block;
        this._CatchClausesOpt = _CatchClausesOpt;
        this._FINALLY = _FINALLY;
        this._Block5 = _Block5;
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
        if (! (o instanceof TryStatement1)) return false;
        TryStatement1 other = (TryStatement1) o;
        if (! _TRY.equals(other._TRY)) return false;
        if (! _Block.equals(other._Block)) return false;
        if (_CatchClausesOpt == null)
            if (other._CatchClausesOpt != null) return false;
            else; // continue
        else if (! _CatchClausesOpt.equals(other._CatchClausesOpt)) return false;
        if (! _FINALLY.equals(other._FINALLY)) return false;
        if (! _Block5.equals(other._Block5)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_TRY.hashCode());
        hash = hash * 31 + (_Block.hashCode());
        hash = hash * 31 + (_CatchClausesOpt == null ? 0 : _CatchClausesOpt.hashCode());
        hash = hash * 31 + (_FINALLY.hashCode());
        hash = hash * 31 + (_Block5.hashCode());
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
            if (_CatchClausesOpt != null) _CatchClausesOpt.accept(v);
            _FINALLY.accept(v);
            _Block5.accept(v);
        }
        v.endVisit(this);
    }
}


