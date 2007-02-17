package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 438:  PackageDefinition ::= PACKAGE PackageNameOpt Block
 *</b>
 */
public class PackageDefinition extends Ast implements IPackageDefinition
{
    private AstToken _PACKAGE;
    private IPackageNameOpt _PackageNameOpt;
    private Block _Block;

    public AstToken getPACKAGE() { return _PACKAGE; }
    /**
     * The value returned by <b>getPackageNameOpt</b> may be <b>null</b>
     */
    public IPackageNameOpt getPackageNameOpt() { return _PackageNameOpt; }
    public Block getBlock() { return _Block; }

    public PackageDefinition(IToken leftIToken, IToken rightIToken,
                             AstToken _PACKAGE,
                             IPackageNameOpt _PackageNameOpt,
                             Block _Block)
    {
        super(leftIToken, rightIToken);

        this._PACKAGE = _PACKAGE;
        this._PackageNameOpt = _PackageNameOpt;
        this._Block = _Block;
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
        if (! (o instanceof PackageDefinition)) return false;
        PackageDefinition other = (PackageDefinition) o;
        if (! _PACKAGE.equals(other._PACKAGE)) return false;
        if (_PackageNameOpt == null)
            if (other._PackageNameOpt != null) return false;
            else; // continue
        else if (! _PackageNameOpt.equals(other._PackageNameOpt)) return false;
        if (! _Block.equals(other._Block)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_PACKAGE.hashCode());
        hash = hash * 31 + (_PackageNameOpt == null ? 0 : _PackageNameOpt.hashCode());
        hash = hash * 31 + (_Block.hashCode());
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
            _PACKAGE.accept(v);
            if (_PackageNameOpt != null) _PackageNameOpt.accept(v);
            _Block.accept(v);
        }
        v.endVisit(this);
    }
}


