package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 340:  AnnotatableDirective_abbrev ::= ExportDefinition Semicolon_abbrev
 *</b>
 */
public class AnnotatableDirective_abbrev3 extends Ast implements IAnnotatableDirective_abbrev
{
    private ExportDefinition _ExportDefinition;
    private ISemicolon_abbrev _Semicolon_abbrev;

    public ExportDefinition getExportDefinition() { return _ExportDefinition; }
    /**
     * The value returned by <b>getSemicolon_abbrev</b> may be <b>null</b>
     */
    public ISemicolon_abbrev getSemicolon_abbrev() { return _Semicolon_abbrev; }

    public AnnotatableDirective_abbrev3(IToken leftIToken, IToken rightIToken,
                                        ExportDefinition _ExportDefinition,
                                        ISemicolon_abbrev _Semicolon_abbrev)
    {
        super(leftIToken, rightIToken);

        this._ExportDefinition = _ExportDefinition;
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
        if (! (o instanceof AnnotatableDirective_abbrev3)) return false;
        AnnotatableDirective_abbrev3 other = (AnnotatableDirective_abbrev3) o;
        if (! _ExportDefinition.equals(other._ExportDefinition)) return false;
        if (_Semicolon_abbrev == null)
            if (other._Semicolon_abbrev != null) return false;
            else; // continue
        else if (! _Semicolon_abbrev.equals(other._Semicolon_abbrev)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ExportDefinition.hashCode());
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
            _ExportDefinition.accept(v);
            if (_Semicolon_abbrev != null) _Semicolon_abbrev.accept(v);
        }
        v.endVisit(this);
    }
}


