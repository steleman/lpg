package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 434:  Program ::= Directives
 *</em>
 *<p>
 *<b>
 *<li>Rule 435:  Program ::= PackageDefinitionList Directives
 *</b>
 */
public class Program extends Ast implements IProgram
{
    private IPackageDefinitionList _PackageDefinitionList;
    private IDirectives _Directives;

    public IPackageDefinitionList getPackageDefinitionList() { return _PackageDefinitionList; }
    /**
     * The value returned by <b>getDirectives</b> may be <b>null</b>
     */
    public IDirectives getDirectives() { return _Directives; }

    public Program(IToken leftIToken, IToken rightIToken,
                   IPackageDefinitionList _PackageDefinitionList,
                   IDirectives _Directives)
    {
        super(leftIToken, rightIToken);

        this._PackageDefinitionList = _PackageDefinitionList;
        this._Directives = _Directives;
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
        if (! (o instanceof Program)) return false;
        Program other = (Program) o;
        if (! _PackageDefinitionList.equals(other._PackageDefinitionList)) return false;
        if (_Directives == null)
            if (other._Directives != null) return false;
            else; // continue
        else if (! _Directives.equals(other._Directives)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_PackageDefinitionList.hashCode());
        hash = hash * 31 + (_Directives == null ? 0 : _Directives.hashCode());
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
            _PackageDefinitionList.accept(v);
            if (_Directives != null) _Directives.accept(v);
        }
        v.endVisit(this);
    }
}


