package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 362:  ImportDirective ::= IMPORT PackageName
 *</b>
 */
public class ImportDirective0 extends Ast implements IImportDirective
{
    private AstToken _IMPORT;
    private IPackageName _PackageName;

    public AstToken getIMPORT() { return _IMPORT; }
    public IPackageName getPackageName() { return _PackageName; }

    public ImportDirective0(IToken leftIToken, IToken rightIToken,
                            AstToken _IMPORT,
                            IPackageName _PackageName)
    {
        super(leftIToken, rightIToken);

        this._IMPORT = _IMPORT;
        this._PackageName = _PackageName;
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
        if (! (o instanceof ImportDirective0)) return false;
        ImportDirective0 other = (ImportDirective0) o;
        if (! _IMPORT.equals(other._IMPORT)) return false;
        if (! _PackageName.equals(other._PackageName)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_IMPORT.hashCode());
        hash = hash * 31 + (_PackageName.hashCode());
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
            _IMPORT.accept(v);
            _PackageName.accept(v);
        }
        v.endVisit(this);
    }
}


