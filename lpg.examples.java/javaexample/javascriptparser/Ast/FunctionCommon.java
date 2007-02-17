package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 413:  FunctionCommon ::= ( Parameters ) Result Block
 *</b>
 */
public class FunctionCommon extends Ast implements IFunctionCommon
{
    private AstToken _LPAREN;
    private IParameters _Parameters;
    private AstToken _RPAREN;
    private Result _Result;
    private Block _Block;

    public AstToken getLPAREN() { return _LPAREN; }
    /**
     * The value returned by <b>getParameters</b> may be <b>null</b>
     */
    public IParameters getParameters() { return _Parameters; }
    public AstToken getRPAREN() { return _RPAREN; }
    /**
     * The value returned by <b>getResult</b> may be <b>null</b>
     */
    public Result getResult() { return _Result; }
    public Block getBlock() { return _Block; }

    public FunctionCommon(IToken leftIToken, IToken rightIToken,
                          AstToken _LPAREN,
                          IParameters _Parameters,
                          AstToken _RPAREN,
                          Result _Result,
                          Block _Block)
    {
        super(leftIToken, rightIToken);

        this._LPAREN = _LPAREN;
        this._Parameters = _Parameters;
        this._RPAREN = _RPAREN;
        this._Result = _Result;
        this._Block = _Block;
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
        if (! (o instanceof FunctionCommon)) return false;
        FunctionCommon other = (FunctionCommon) o;
        if (! _LPAREN.equals(other._LPAREN)) return false;
        if (_Parameters == null)
            if (other._Parameters != null) return false;
            else; // continue
        else if (! _Parameters.equals(other._Parameters)) return false;
        if (! _RPAREN.equals(other._RPAREN)) return false;
        if (_Result == null)
            if (other._Result != null) return false;
            else; // continue
        else if (! _Result.equals(other._Result)) return false;
        if (! _Block.equals(other._Block)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_LPAREN.hashCode());
        hash = hash * 31 + (_Parameters == null ? 0 : _Parameters.hashCode());
        hash = hash * 31 + (_RPAREN.hashCode());
        hash = hash * 31 + (_Result == null ? 0 : _Result.hashCode());
        hash = hash * 31 + (_Block.hashCode());
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
            _LPAREN.accept(v);
            if (_Parameters != null) _Parameters.accept(v);
            _RPAREN.accept(v);
            if (_Result != null) _Result.accept(v);
            _Block.accept(v);
        }
        v.endVisit(this);
    }
}


