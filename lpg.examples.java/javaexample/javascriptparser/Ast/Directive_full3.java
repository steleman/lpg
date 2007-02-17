package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 334:  Directive_full ::= Pragma Semicolon_full
 *</b>
 */
public class Directive_full3 extends Ast implements IDirective_full
{
    private Pragma _Pragma;
    private ISemicolon_full _Semicolon_full;

    public Pragma getPragma() { return _Pragma; }
    public ISemicolon_full getSemicolon_full() { return _Semicolon_full; }

    public Directive_full3(IToken leftIToken, IToken rightIToken,
                           Pragma _Pragma,
                           ISemicolon_full _Semicolon_full)
    {
        super(leftIToken, rightIToken);

        this._Pragma = _Pragma;
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
        if (! (o instanceof Directive_full3)) return false;
        Directive_full3 other = (Directive_full3) o;
        if (! _Pragma.equals(other._Pragma)) return false;
        if (! _Semicolon_full.equals(other._Semicolon_full)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_Pragma.hashCode());
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
            _Pragma.accept(v);
            _Semicolon_full.accept(v);
        }
        v.endVisit(this);
    }
}


