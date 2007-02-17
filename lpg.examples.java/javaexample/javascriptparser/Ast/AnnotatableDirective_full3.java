package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 347:  AnnotatableDirective_full ::= ExportDefinition Semicolon_full
 *</b>
 */
public class AnnotatableDirective_full3 extends Ast implements IAnnotatableDirective_full
{
    private ExportDefinition _ExportDefinition;
    private ISemicolon_full _Semicolon_full;

    public ExportDefinition getExportDefinition() { return _ExportDefinition; }
    public ISemicolon_full getSemicolon_full() { return _Semicolon_full; }

    public AnnotatableDirective_full3(IToken leftIToken, IToken rightIToken,
                                      ExportDefinition _ExportDefinition,
                                      ISemicolon_full _Semicolon_full)
    {
        super(leftIToken, rightIToken);

        this._ExportDefinition = _ExportDefinition;
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
        if (! (o instanceof AnnotatableDirective_full3)) return false;
        AnnotatableDirective_full3 other = (AnnotatableDirective_full3) o;
        if (! _ExportDefinition.equals(other._ExportDefinition)) return false;
        if (! _Semicolon_full.equals(other._Semicolon_full)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ExportDefinition.hashCode());
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
            _ExportDefinition.accept(v);
            _Semicolon_full.accept(v);
        }
        v.endVisit(this);
    }
}


