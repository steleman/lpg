//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 43:  SingleTypeImportDeclaration ::= import Name ;
 *</b>
 */
public class SingleTypeImportDeclaration extends Ast implements ISingleTypeImportDeclaration
{
    private AstToken _import;
    private IName _Name;
    private AstToken _SEMICOLON;

    public AstToken getimport() { return _import; }
    public IName getName() { return _Name; }
    public AstToken getSEMICOLON() { return _SEMICOLON; }

    public SingleTypeImportDeclaration(IToken leftIToken, IToken rightIToken,
                                       AstToken _import,
                                       IName _Name,
                                       AstToken _SEMICOLON)
    {
        super(leftIToken, rightIToken);

        this._import = _import;
        ((Ast) _import).setParent(this);
        this._Name = _Name;
        ((Ast) _Name).setParent(this);
        this._SEMICOLON = _SEMICOLON;
        ((Ast) _SEMICOLON).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_import);
        list.add(_Name);
        list.add(_SEMICOLON);
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
        if (! (o instanceof SingleTypeImportDeclaration)) return false;
        SingleTypeImportDeclaration other = (SingleTypeImportDeclaration) o;
        if (! _import.equals(other._import)) return false;
        if (! _Name.equals(other._Name)) return false;
        if (! _SEMICOLON.equals(other._SEMICOLON)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_import.hashCode());
        hash = hash * 31 + (_Name.hashCode());
        hash = hash * 31 + (_SEMICOLON.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}

