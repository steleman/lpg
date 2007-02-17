package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 363:  ImportDirective ::= IMPORT Identifier = PackageName
 *</b>
 */
public class ImportDirective1 extends Ast implements IImportDirective
{
    private AstToken _IMPORT;
    private IIdentifier _Identifier;
    private AstToken _EQUAL;
    private IPackageName _PackageName;

    public AstToken getIMPORT() { return _IMPORT; }
    public IIdentifier getIdentifier() { return _Identifier; }
    public AstToken getEQUAL() { return _EQUAL; }
    public IPackageName getPackageName() { return _PackageName; }

    public ImportDirective1(IToken leftIToken, IToken rightIToken,
                            AstToken _IMPORT,
                            IIdentifier _Identifier,
                            AstToken _EQUAL,
                            IPackageName _PackageName)
    {
        super(leftIToken, rightIToken);

        this._IMPORT = _IMPORT;
        this._Identifier = _Identifier;
        this._EQUAL = _EQUAL;
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
        if (! (o instanceof ImportDirective1)) return false;
        ImportDirective1 other = (ImportDirective1) o;
        if (! _IMPORT.equals(other._IMPORT)) return false;
        if (! _Identifier.equals(other._Identifier)) return false;
        if (! _EQUAL.equals(other._EQUAL)) return false;
        if (! _PackageName.equals(other._PackageName)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_IMPORT.hashCode());
        hash = hash * 31 + (_Identifier.hashCode());
        hash = hash * 31 + (_EQUAL.hashCode());
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
            _Identifier.accept(v);
            _EQUAL.accept(v);
            _PackageName.accept(v);
        }
        v.endVisit(this);
    }
}


