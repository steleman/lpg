package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 326:  Directive_abbrev ::= Pragma Semicolon_abbrev
 *</b>
 */
public class Directive_abbrev3 extends Ast implements IDirective_abbrev
{
    private Pragma _Pragma;
    private ISemicolon_abbrev _Semicolon_abbrev;

    public Pragma getPragma() { return _Pragma; }
    /**
     * The value returned by <b>getSemicolon_abbrev</b> may be <b>null</b>
     */
    public ISemicolon_abbrev getSemicolon_abbrev() { return _Semicolon_abbrev; }

    public Directive_abbrev3(IToken leftIToken, IToken rightIToken,
                             Pragma _Pragma,
                             ISemicolon_abbrev _Semicolon_abbrev)
    {
        super(leftIToken, rightIToken);

        this._Pragma = _Pragma;
        this._Semicolon_abbrev = _Semicolon_abbrev;
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
        if (! (o instanceof Directive_abbrev3)) return false;
        Directive_abbrev3 other = (Directive_abbrev3) o;
        if (! _Pragma.equals(other._Pragma)) return false;
        if (_Semicolon_abbrev == null)
            if (other._Semicolon_abbrev != null) return false;
            else; // continue
        else if (! _Semicolon_abbrev.equals(other._Semicolon_abbrev)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_Pragma.hashCode());
        hash = hash * 31 + (_Semicolon_abbrev == null ? 0 : _Semicolon_abbrev.hashCode());
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
            if (_Semicolon_abbrev != null) _Semicolon_abbrev.accept(v);
        }
        v.endVisit(this);
    }
}


