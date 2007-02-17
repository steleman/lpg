package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 346:  AnnotatableDirective_full ::= ImportDirective Semicolon_full
 *</b>
 */
public class AnnotatableDirective_full2 extends Ast implements IAnnotatableDirective_full
{
    private IImportDirective _ImportDirective;
    private ISemicolon_full _Semicolon_full;

    public IImportDirective getImportDirective() { return _ImportDirective; }
    public ISemicolon_full getSemicolon_full() { return _Semicolon_full; }

    public AnnotatableDirective_full2(IToken leftIToken, IToken rightIToken,
                                      IImportDirective _ImportDirective,
                                      ISemicolon_full _Semicolon_full)
    {
        super(leftIToken, rightIToken);

        this._ImportDirective = _ImportDirective;
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
        if (! (o instanceof AnnotatableDirective_full2)) return false;
        AnnotatableDirective_full2 other = (AnnotatableDirective_full2) o;
        if (! _ImportDirective.equals(other._ImportDirective)) return false;
        if (! _Semicolon_full.equals(other._Semicolon_full)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ImportDirective.hashCode());
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
            _ImportDirective.accept(v);
            _Semicolon_full.accept(v);
        }
        v.endVisit(this);
    }
}


