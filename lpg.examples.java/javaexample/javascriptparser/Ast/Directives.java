package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 349:  Directives ::= $Empty
 *<li>Rule 350:  Directives ::= Directive_abbrev
 *</em>
 *<p>
 *<b>
 *<li>Rule 351:  Directives ::= DirectivesPrefix Directive_abbrev
 *</b>
 */
public class Directives extends Ast implements IDirectives
{
    private IDirectivesPrefix _DirectivesPrefix;
    private IDirective_abbrev _Directive_abbrev;

    public IDirectivesPrefix getDirectivesPrefix() { return _DirectivesPrefix; }
    public IDirective_abbrev getDirective_abbrev() { return _Directive_abbrev; }

    public Directives(IToken leftIToken, IToken rightIToken,
                      IDirectivesPrefix _DirectivesPrefix,
                      IDirective_abbrev _Directive_abbrev)
    {
        super(leftIToken, rightIToken);

        this._DirectivesPrefix = _DirectivesPrefix;
        this._Directive_abbrev = _Directive_abbrev;
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
        if (! (o instanceof Directives)) return false;
        Directives other = (Directives) o;
        if (! _DirectivesPrefix.equals(other._DirectivesPrefix)) return false;
        if (! _Directive_abbrev.equals(other._Directive_abbrev)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_DirectivesPrefix.hashCode());
        hash = hash * 31 + (_Directive_abbrev.hashCode());
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
            _Directive_abbrev.accept(v);
        }
        v.endVisit(this);
    }
}


