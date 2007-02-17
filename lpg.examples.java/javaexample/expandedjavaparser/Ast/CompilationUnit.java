//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 35:  CompilationUnit ::= PackageDeclarationopt ImportDeclarationsopt TypeDeclarationsopt
 *</b>
 */
public class CompilationUnit extends Ast implements ICompilationUnit
{
    private PackageDeclaration _PackageDeclarationopt;
    private ImportDeclarationList _ImportDeclarationsopt;
    private TypeDeclarationList _TypeDeclarationsopt;

    /**
     * The value returned by <b>getPackageDeclarationopt</b> may be <b>null</b>
     */
    public PackageDeclaration getPackageDeclarationopt() { return _PackageDeclarationopt; }
    public ImportDeclarationList getImportDeclarationsopt() { return _ImportDeclarationsopt; }
    public TypeDeclarationList getTypeDeclarationsopt() { return _TypeDeclarationsopt; }

    public CompilationUnit(IToken leftIToken, IToken rightIToken,
                           PackageDeclaration _PackageDeclarationopt,
                           ImportDeclarationList _ImportDeclarationsopt,
                           TypeDeclarationList _TypeDeclarationsopt)
    {
        super(leftIToken, rightIToken);

        this._PackageDeclarationopt = _PackageDeclarationopt;
        if (_PackageDeclarationopt != null) ((Ast) _PackageDeclarationopt).setParent(this);
        this._ImportDeclarationsopt = _ImportDeclarationsopt;
        ((Ast) _ImportDeclarationsopt).setParent(this);
        this._TypeDeclarationsopt = _TypeDeclarationsopt;
        ((Ast) _TypeDeclarationsopt).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_PackageDeclarationopt);
        list.add(_ImportDeclarationsopt);
        list.add(_TypeDeclarationsopt);
        return list;
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
        if (! (o instanceof CompilationUnit)) return false;
        CompilationUnit other = (CompilationUnit) o;
        if (_PackageDeclarationopt == null)
            if (other._PackageDeclarationopt != null) return false;
            else; // continue
        else if (! _PackageDeclarationopt.equals(other._PackageDeclarationopt)) return false;
        if (! _ImportDeclarationsopt.equals(other._ImportDeclarationsopt)) return false;
        if (! _TypeDeclarationsopt.equals(other._TypeDeclarationsopt)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_PackageDeclarationopt == null ? 0 : _PackageDeclarationopt.hashCode());
        hash = hash * 31 + (_ImportDeclarationsopt.hashCode());
        hash = hash * 31 + (_TypeDeclarationsopt.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


