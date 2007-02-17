package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 333:  Directive_full ::= IncludeDirective Semicolon_full
 *</b>
 */
public class Directive_full2 extends Ast implements IDirective_full
{
    private IncludeDirective _IncludeDirective;
    private ISemicolon_full _Semicolon_full;

    public IncludeDirective getIncludeDirective() { return _IncludeDirective; }
    public ISemicolon_full getSemicolon_full() { return _Semicolon_full; }

    public Directive_full2(IToken leftIToken, IToken rightIToken,
                           IncludeDirective _IncludeDirective,
                           ISemicolon_full _Semicolon_full)
    {
        super(leftIToken, rightIToken);

        this._IncludeDirective = _IncludeDirective;
        this._Semicolon_full = _Semicolon_full;
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
        if (! (o instanceof Directive_full2)) return false;
        Directive_full2 other = (Directive_full2) o;
        if (! _IncludeDirective.equals(other._IncludeDirective)) return false;
        if (! _Semicolon_full.equals(other._Semicolon_full)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_IncludeDirective.hashCode());
        hash = hash * 31 + (_Semicolon_full.hashCode());
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
            _IncludeDirective.accept(v);
            _Semicolon_full.accept(v);
        }
        v.endVisit(this);
    }
}


