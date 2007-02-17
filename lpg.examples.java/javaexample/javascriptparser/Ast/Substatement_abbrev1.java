package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 240:  Substatement_abbrev ::= Attributes no_line_break$ { Substatements }
 *</b>
 */
public class Substatement_abbrev1 extends Ast implements ISubstatement_abbrev
{
    private IAttributes _Attributes;
    private AstToken _LBRACE;
    private Substatements _Substatements;
    private AstToken _RBRACE;

    public IAttributes getAttributes() { return _Attributes; }
    public AstToken getLBRACE() { return _LBRACE; }
    /**
     * The value returned by <b>getSubstatements</b> may be <b>null</b>
     */
    public Substatements getSubstatements() { return _Substatements; }
    public AstToken getRBRACE() { return _RBRACE; }

    public Substatement_abbrev1(IToken leftIToken, IToken rightIToken,
                                IAttributes _Attributes,
                                AstToken _LBRACE,
                                Substatements _Substatements,
                                AstToken _RBRACE)
    {
        super(leftIToken, rightIToken);

        this._Attributes = _Attributes;
        this._LBRACE = _LBRACE;
        this._Substatements = _Substatements;
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
        if (! (o instanceof Substatement_abbrev1)) return false;
        Substatement_abbrev1 other = (Substatement_abbrev1) o;
        if (! _Attributes.equals(other._Attributes)) return false;
        if (! _LBRACE.equals(other._LBRACE)) return false;
        if (_Substatements == null)
            if (other._Substatements != null) return false;
            else; // continue
        else if (! _Substatements.equals(other._Substatements)) return false;
        if (! _RBRACE.equals(other._RBRACE)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_Attributes.hashCode());
        hash = hash * 31 + (_LBRACE.hashCode());
        hash = hash * 31 + (_Substatements == null ? 0 : _Substatements.hashCode());
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
            if (_Substatements != null) _Substatements.accept(v);
            _RBRACE.accept(v);
        }
        v.endVisit(this);
    }
}


