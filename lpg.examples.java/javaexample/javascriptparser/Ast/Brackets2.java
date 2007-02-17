package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 76:  Brackets ::= [ ExpressionsWithRest ]
 *</b>
 */
public class Brackets2 extends Ast implements IBrackets
{
    private AstToken _LBRACKET;
    private IExpressionsWithRest _ExpressionsWithRest;
    private AstToken _RBRACKET;

    public AstToken getLBRACKET() { return _LBRACKET; }
    public IExpressionsWithRest getExpressionsWithRest() { return _ExpressionsWithRest; }
    public AstToken getRBRACKET() { return _RBRACKET; }

    public Brackets2(IToken leftIToken, IToken rightIToken,
                     AstToken _LBRACKET,
                     IExpressionsWithRest _ExpressionsWithRest,
                     AstToken _RBRACKET)
    {
        super(leftIToken, rightIToken);

        this._LBRACKET = _LBRACKET;
        this._ExpressionsWithRest = _ExpressionsWithRest;
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
        if (! (o instanceof Brackets2)) return false;
        Brackets2 other = (Brackets2) o;
        if (! _LBRACKET.equals(other._LBRACKET)) return false;
        if (! _ExpressionsWithRest.equals(other._ExpressionsWithRest)) return false;
        if (! _RBRACKET.equals(other._RBRACKET)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_LBRACKET.hashCode());
        hash = hash * 31 + (_ExpressionsWithRest.hashCode());
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
            _ExpressionsWithRest.accept(v);
            _RBRACKET.accept(v);
        }
        v.endVisit(this);
    }
}


