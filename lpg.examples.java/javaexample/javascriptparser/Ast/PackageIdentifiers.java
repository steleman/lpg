package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 443:  PackageIdentifiers ::= Identifier
 *</em>
 *<p>
 *<b>
 *<li>Rule 444:  PackageIdentifiers ::= PackageIdentifiers . Identifier
 *</b>
 */
public class PackageIdentifiers extends Ast implements IPackageIdentifiers
{
    private IPackageIdentifiers _PackageIdentifiers;
    private AstToken _PERIOD;
    private IIdentifier _Identifier;

    public IPackageIdentifiers getPackageIdentifiers() { return _PackageIdentifiers; }
    public AstToken getPERIOD() { return _PERIOD; }
    public IIdentifier getIdentifier() { return _Identifier; }

    public PackageIdentifiers(IToken leftIToken, IToken rightIToken,
                              IPackageIdentifiers _PackageIdentifiers,
                              AstToken _PERIOD,
                              IIdentifier _Identifier)
    {
        super(leftIToken, rightIToken);

        this._PackageIdentifiers = _PackageIdentifiers;
        this._PERIOD = _PERIOD;
        this._Identifier = _Identifier;
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
        if (! (o instanceof PackageIdentifiers)) return false;
        PackageIdentifiers other = (PackageIdentifiers) o;
        if (! _PackageIdentifiers.equals(other._PackageIdentifiers)) return false;
        if (! _PERIOD.equals(other._PERIOD)) return false;
        if (! _Identifier.equals(other._Identifier)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_PackageIdentifiers.hashCode());
        hash = hash * 31 + (_PERIOD.hashCode());
        hash = hash * 31 + (_Identifier.hashCode());
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
            _PackageIdentifiers.accept(v);
            _PERIOD.accept(v);
            _Identifier.accept(v);
        }
        v.endVisit(this);
    }
}


