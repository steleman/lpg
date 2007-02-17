package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 436:  PackageDefinitionList ::= PackageDefinition
 *</em>
 *<p>
 *<b>
 *<li>Rule 437:  PackageDefinitionList ::= PackageDefinitionList PackageDefinition
 *</b>
 */
public class PackageDefinitionList extends Ast implements IPackageDefinitionList
{
    private IPackageDefinitionList _PackageDefinitionList;
    private PackageDefinition _PackageDefinition;

    public IPackageDefinitionList getPackageDefinitionList() { return _PackageDefinitionList; }
    public PackageDefinition getPackageDefinition() { return _PackageDefinition; }

    public PackageDefinitionList(IToken leftIToken, IToken rightIToken,
                                 IPackageDefinitionList _PackageDefinitionList,
                                 PackageDefinition _PackageDefinition)
    {
        super(leftIToken, rightIToken);

        this._PackageDefinitionList = _PackageDefinitionList;
        this._PackageDefinition = _PackageDefinition;
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
        if (! (o instanceof PackageDefinitionList)) return false;
        PackageDefinitionList other = (PackageDefinitionList) o;
        if (! _PackageDefinitionList.equals(other._PackageDefinitionList)) return false;
        if (! _PackageDefinition.equals(other._PackageDefinition)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_PackageDefinitionList.hashCode());
        hash = hash * 31 + (_PackageDefinition.hashCode());
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
            _PackageDefinition.accept(v);
        }
        v.endVisit(this);
    }
}


