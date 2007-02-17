package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 332:  Directive_full ::= Attributes no_line_break$ { Directives }
 *</b>
 */
public class Directive_full1 extends Ast implements IDirective_full
{
    private IAttributes _Attributes;
    private AstToken _LBRACE;
    private IDirectives _Directives;
    private AstToken _RBRACE;

    public IAttributes getAttributes() { return _Attributes; }
    public AstToken getLBRACE() { return _LBRACE; }
    /**
     * The value returned by <b>getDirectives</b> may be <b>null</b>
     */
    public IDirectives getDirectives() { return _Directives; }
    public AstToken getRBRACE() { return _RBRACE; }

    public Directive_full1(IToken leftIToken, IToken rightIToken,
                           IAttributes _Attributes,
                           AstToken _LBRACE,
                           IDirectives _Directives,
                           AstToken _RBRACE)
    {
        super(leftIToken, rightIToken);

        this._Attributes = _Attributes;
        this._LBRACE = _LBRACE;
        this._Directives = _Directives;
        this._RBRACE = _RBRACE;
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
        if (! (o instanceof Directive_full1)) return false;
        Directive_full1 other = (Directive_full1) o;
        if (! _Attributes.equals(other._Attributes)) return false;
        if (! _LBRACE.equals(other._LBRACE)) return false;
        if (_Directives == null)
            if (other._Directives != null) return false;
            else; // continue
        else if (! _Directives.equals(other._Directives)) return false;
        if (! _RBRACE.equals(other._RBRACE)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_Attributes.hashCode());
        hash = hash * 31 + (_LBRACE.hashCode());
        hash = hash * 31 + (_Directives == null ? 0 : _Directives.hashCode());
        hash = hash * 31 + (_RBRACE.hashCode());
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
            _Attributes.accept(v);
            _LBRACE.accept(v);
            if (_Directives != null) _Directives.accept(v);
            _RBRACE.accept(v);
        }
        v.endVisit(this);
    }
}


