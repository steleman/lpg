package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 323:  Directive_abbrev ::= Attributes no_line_break$ AnnotatableDirective_abbrev
 *</b>
 */
public class Directive_abbrev0 extends Ast implements IDirective_abbrev
{
    private IAttributes _Attributes;
    private IAnnotatableDirective_abbrev _AnnotatableDirective_abbrev;

    public IAttributes getAttributes() { return _Attributes; }
    public IAnnotatableDirective_abbrev getAnnotatableDirective_abbrev() { return _AnnotatableDirective_abbrev; }

    public Directive_abbrev0(IToken leftIToken, IToken rightIToken,
                             IAttributes _Attributes,
                             IAnnotatableDirective_abbrev _AnnotatableDirective_abbrev)
    {
        super(leftIToken, rightIToken);

        this._Attributes = _Attributes;
        this._AnnotatableDirective_abbrev = _AnnotatableDirective_abbrev;
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
        if (! (o instanceof Directive_abbrev0)) return false;
        Directive_abbrev0 other = (Directive_abbrev0) o;
        if (! _Attributes.equals(other._Attributes)) return false;
        if (! _AnnotatableDirective_abbrev.equals(other._AnnotatableDirective_abbrev)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_Attributes.hashCode());
        hash = hash * 31 + (_AnnotatableDirective_abbrev.hashCode());
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
            _AnnotatableDirective_abbrev.accept(v);
        }
        v.endVisit(this);
    }
}


