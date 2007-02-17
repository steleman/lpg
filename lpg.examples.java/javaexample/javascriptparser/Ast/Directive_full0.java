package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 331:  Directive_full ::= Attributes no_line_break$ AnnotatableDirective_full
 *</b>
 */
public class Directive_full0 extends Ast implements IDirective_full
{
    private IAttributes _Attributes;
    private IAnnotatableDirective_full _AnnotatableDirective_full;

    public IAttributes getAttributes() { return _Attributes; }
    public IAnnotatableDirective_full getAnnotatableDirective_full() { return _AnnotatableDirective_full; }

    public Directive_full0(IToken leftIToken, IToken rightIToken,
                           IAttributes _Attributes,
                           IAnnotatableDirective_full _AnnotatableDirective_full)
    {
        super(leftIToken, rightIToken);

        this._Attributes = _Attributes;
        this._AnnotatableDirective_full = _AnnotatableDirective_full;
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
        if (! (o instanceof Directive_full0)) return false;
        Directive_full0 other = (Directive_full0) o;
        if (! _Attributes.equals(other._Attributes)) return false;
        if (! _AnnotatableDirective_full.equals(other._AnnotatableDirective_full)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_Attributes.hashCode());
        hash = hash * 31 + (_AnnotatableDirective_full.hashCode());
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
            _AnnotatableDirective_full.accept(v);
        }
        v.endVisit(this);
    }
}


