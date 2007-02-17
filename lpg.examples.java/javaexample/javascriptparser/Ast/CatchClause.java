package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 319:  CatchClause ::= CATCH ( Parameter ) Block
 *</b>
 */
public class CatchClause extends Ast implements ICatchClause
{
    private AstToken _CATCH;
    private AstToken _LPAREN;
    private Parameter _Parameter;
    private AstToken _RPAREN;
    private Block _Block;

    public AstToken getCATCH() { return _CATCH; }
    public AstToken getLPAREN() { return _LPAREN; }
    public Parameter getParameter() { return _Parameter; }
    public AstToken getRPAREN() { return _RPAREN; }
    public Block getBlock() { return _Block; }

    public CatchClause(IToken leftIToken, IToken rightIToken,
                       AstToken _CATCH,
                       AstToken _LPAREN,
                       Parameter _Parameter,
                       AstToken _RPAREN,
                       Block _Block)
    {
        super(leftIToken, rightIToken);

        this._CATCH = _CATCH;
        this._LPAREN = _LPAREN;
        this._Parameter = _Parameter;
        this._RPAREN = _RPAREN;
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
        if (! (o instanceof CatchClause)) return false;
        CatchClause other = (CatchClause) o;
        if (! _CATCH.equals(other._CATCH)) return false;
        if (! _LPAREN.equals(other._LPAREN)) return false;
        if (! _Parameter.equals(other._Parameter)) return false;
        if (! _RPAREN.equals(other._RPAREN)) return false;
        if (! _Block.equals(other._Block)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_CATCH.hashCode());
        hash = hash * 31 + (_LPAREN.hashCode());
        hash = hash * 31 + (_Parameter.hashCode());
        hash = hash * 31 + (_RPAREN.hashCode());
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
            _CATCH.accept(v);
            _LPAREN.accept(v);
            _Parameter.accept(v);
            _RPAREN.accept(v);
            _Block.accept(v);
        }
        v.endVisit(this);
    }
}


