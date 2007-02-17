package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 341:  AnnotatableDirective_abbrev ::= UseDirective Semicolon_abbrev
 *</b>
 */
public class AnnotatableDirective_abbrev4 extends Ast implements IAnnotatableDirective_abbrev
{
    private UseDirective _UseDirective;
    private ISemicolon_abbrev _Semicolon_abbrev;

    public UseDirective getUseDirective() { return _UseDirective; }
    /**
     * The value returned by <b>getSemicolon_abbrev</b> may be <b>null</b>
     */
    public ISemicolon_abbrev getSemicolon_abbrev() { return _Semicolon_abbrev; }

    public AnnotatableDirective_abbrev4(IToken leftIToken, IToken rightIToken,
                                        UseDirective _UseDirective,
                                        ISemicolon_abbrev _Semicolon_abbrev)
    {
        super(leftIToken, rightIToken);

        this._UseDirective = _UseDirective;
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
        if (! (o instanceof AnnotatableDirective_abbrev4)) return false;
        AnnotatableDirective_abbrev4 other = (AnnotatableDirective_abbrev4) o;
        if (! _UseDirective.equals(other._UseDirective)) return false;
        if (_Semicolon_abbrev == null)
            if (other._Semicolon_abbrev != null) return false;
            else; // continue
        else if (! _Semicolon_abbrev.equals(other._Semicolon_abbrev)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_UseDirective.hashCode());
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
            _UseDirective.accept(v);
            if (_Semicolon_abbrev != null) _Semicolon_abbrev.accept(v);
        }
        v.endVisit(this);
    }
}


