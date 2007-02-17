package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 352:  DirectivesPrefix ::= Directive_full
 *</em>
 *<p>
 *<b>
 *<li>Rule 353:  DirectivesPrefix ::= DirectivesPrefix Directive_full
 *</b>
 */
public class DirectivesPrefix extends Ast implements IDirectivesPrefix
{
    private IDirectivesPrefix _DirectivesPrefix;
    private IDirective_full _Directive_full;

    public IDirectivesPrefix getDirectivesPrefix() { return _DirectivesPrefix; }
    public IDirective_full getDirective_full() { return _Directive_full; }

    public DirectivesPrefix(IToken leftIToken, IToken rightIToken,
                            IDirectivesPrefix _DirectivesPrefix,
                            IDirective_full _Directive_full)
    {
        super(leftIToken, rightIToken);

        this._DirectivesPrefix = _DirectivesPrefix;
        this._Directive_full = _Directive_full;
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
        if (! (o instanceof DirectivesPrefix)) return false;
        DirectivesPrefix other = (DirectivesPrefix) o;
        if (! _DirectivesPrefix.equals(other._DirectivesPrefix)) return false;
        if (! _Directive_full.equals(other._Directive_full)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_DirectivesPrefix.hashCode());
        hash = hash * 31 + (_Directive_full.hashCode());
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
            _DirectivesPrefix.accept(v);
            _Directive_full.accept(v);
        }
        v.endVisit(this);
    }
}


