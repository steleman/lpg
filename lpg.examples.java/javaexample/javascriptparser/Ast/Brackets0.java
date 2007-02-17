package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 74:  Brackets ::= [ ]
 *</b>
 */
public class Brackets0 extends Ast implements IBrackets
{
    private AstToken _LBRACKET;
    private AstToken _RBRACKET;

    public AstToken getLBRACKET() { return _LBRACKET; }
    public AstToken getRBRACKET() { return _RBRACKET; }

    public Brackets0(IToken leftIToken, IToken rightIToken,
                     AstToken _LBRACKET,
                     AstToken _RBRACKET)
    {
        super(leftIToken, rightIToken);

        this._LBRACKET = _LBRACKET;
        this._RBRACKET = _RBRACKET;
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
        if (! (o instanceof Brackets0)) return false;
        Brackets0 other = (Brackets0) o;
        if (! _LBRACKET.equals(other._LBRACKET)) return false;
        if (! _RBRACKET.equals(other._RBRACKET)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_LBRACKET.hashCode());
        hash = hash * 31 + (_RBRACKET.hashCode());
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
            _LBRACKET.accept(v);
            _RBRACKET.accept(v);
        }
        v.endVisit(this);
    }
}


