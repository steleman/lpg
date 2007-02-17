package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 370:  PragmaExpr ::= Identifier
 *</em>
 *<p>
 *<b>
 *<li>Rule 371:  PragmaExpr ::= Identifier ( PragmaArgument )
 *</b>
 */
public class PragmaExpr extends Ast implements IPragmaExpr
{
    private IIdentifier _Identifier;
    private AstToken _LPAREN;
    private IPragmaArgument _PragmaArgument;
    private AstToken _RPAREN;

    public IIdentifier getIdentifier() { return _Identifier; }
    public AstToken getLPAREN() { return _LPAREN; }
    public IPragmaArgument getPragmaArgument() { return _PragmaArgument; }
    public AstToken getRPAREN() { return _RPAREN; }

    public PragmaExpr(IToken leftIToken, IToken rightIToken,
                      IIdentifier _Identifier,
                      AstToken _LPAREN,
                      IPragmaArgument _PragmaArgument,
                      AstToken _RPAREN)
    {
        super(leftIToken, rightIToken);

        this._Identifier = _Identifier;
        this._LPAREN = _LPAREN;
        this._PragmaArgument = _PragmaArgument;
        this._RPAREN = _RPAREN;
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
        if (! (o instanceof PragmaExpr)) return false;
        PragmaExpr other = (PragmaExpr) o;
        if (! _Identifier.equals(other._Identifier)) return false;
        if (! _LPAREN.equals(other._LPAREN)) return false;
        if (! _PragmaArgument.equals(other._PragmaArgument)) return false;
        if (! _RPAREN.equals(other._RPAREN)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_Identifier.hashCode());
        hash = hash * 31 + (_LPAREN.hashCode());
        hash = hash * 31 + (_PragmaArgument.hashCode());
        hash = hash * 31 + (_RPAREN.hashCode());
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
            _Identifier.accept(v);
            _LPAREN.accept(v);
            _PragmaArgument.accept(v);
            _RPAREN.accept(v);
        }
        v.endVisit(this);
    }
}


