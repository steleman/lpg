package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 379:  ExportBindingList ::= ExportBinding
 *</em>
 *<p>
 *<b>
 *<li>Rule 380:  ExportBindingList ::= ExportBindingList , ExportBinding
 *</b>
 */
public class ExportBindingList extends Ast implements IExportBindingList
{
    private IExportBindingList _ExportBindingList;
    private AstToken _COMMA;
    private IExportBinding _ExportBinding;

    public IExportBindingList getExportBindingList() { return _ExportBindingList; }
    public AstToken getCOMMA() { return _COMMA; }
    public IExportBinding getExportBinding() { return _ExportBinding; }

    public ExportBindingList(IToken leftIToken, IToken rightIToken,
                             IExportBindingList _ExportBindingList,
                             AstToken _COMMA,
                             IExportBinding _ExportBinding)
    {
        super(leftIToken, rightIToken);

        this._ExportBindingList = _ExportBindingList;
        this._COMMA = _COMMA;
        this._ExportBinding = _ExportBinding;
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
        if (! (o instanceof ExportBindingList)) return false;
        ExportBindingList other = (ExportBindingList) o;
        if (! _ExportBindingList.equals(other._ExportBindingList)) return false;
        if (! _COMMA.equals(other._COMMA)) return false;
        if (! _ExportBinding.equals(other._ExportBinding)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ExportBindingList.hashCode());
        hash = hash * 31 + (_COMMA.hashCode());
        hash = hash * 31 + (_ExportBinding.hashCode());
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
            _ExportBindingList.accept(v);
            _COMMA.accept(v);
            _ExportBinding.accept(v);
        }
        v.endVisit(this);
    }
}


