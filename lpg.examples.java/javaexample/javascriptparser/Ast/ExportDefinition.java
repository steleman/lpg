package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 378:  ExportDefinition ::= EXPORT ExportBindingList
 *</b>
 */
public class ExportDefinition extends Ast implements IExportDefinition
{
    private AstToken _EXPORT;
    private IExportBindingList _ExportBindingList;

    public AstToken getEXPORT() { return _EXPORT; }
    public IExportBindingList getExportBindingList() { return _ExportBindingList; }

    public ExportDefinition(IToken leftIToken, IToken rightIToken,
                            AstToken _EXPORT,
                            IExportBindingList _ExportBindingList)
    {
        super(leftIToken, rightIToken);

        this._EXPORT = _EXPORT;
        this._ExportBindingList = _ExportBindingList;
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
        if (! (o instanceof ExportDefinition)) return false;
        ExportDefinition other = (ExportDefinition) o;
        if (! _EXPORT.equals(other._EXPORT)) return false;
        if (! _ExportBindingList.equals(other._ExportBindingList)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_EXPORT.hashCode());
        hash = hash * 31 + (_ExportBindingList.hashCode());
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
            _EXPORT.accept(v);
            _ExportBindingList.accept(v);
        }
        v.endVisit(this);
    }
}


