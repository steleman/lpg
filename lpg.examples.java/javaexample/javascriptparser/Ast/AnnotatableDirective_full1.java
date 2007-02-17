package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 345:  AnnotatableDirective_full ::= NamespaceDefinition Semicolon_full
 *</b>
 */
public class AnnotatableDirective_full1 extends Ast implements IAnnotatableDirective_full
{
    private NamespaceDefinition _NamespaceDefinition;
    private ISemicolon_full _Semicolon_full;

    public NamespaceDefinition getNamespaceDefinition() { return _NamespaceDefinition; }
    public ISemicolon_full getSemicolon_full() { return _Semicolon_full; }

    public AnnotatableDirective_full1(IToken leftIToken, IToken rightIToken,
                                      NamespaceDefinition _NamespaceDefinition,
                                      ISemicolon_full _Semicolon_full)
    {
        super(leftIToken, rightIToken);

        this._NamespaceDefinition = _NamespaceDefinition;
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
        if (! (o instanceof AnnotatableDirective_full1)) return false;
        AnnotatableDirective_full1 other = (AnnotatableDirective_full1) o;
        if (! _NamespaceDefinition.equals(other._NamespaceDefinition)) return false;
        if (! _Semicolon_full.equals(other._Semicolon_full)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_NamespaceDefinition.hashCode());
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
            _NamespaceDefinition.accept(v);
            _Semicolon_full.accept(v);
        }
        v.endVisit(this);
    }
}


