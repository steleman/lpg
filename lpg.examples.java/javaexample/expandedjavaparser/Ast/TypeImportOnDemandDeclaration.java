//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 44:  TypeImportOnDemandDeclaration ::= import Name . * ;
 *</b>
 */
public class TypeImportOnDemandDeclaration extends Ast implements ITypeImportOnDemandDeclaration
{
    private AstToken _import;
    private IName _Name;
    private AstToken _DOT;
    private AstToken _MULTIPLY;
    private AstToken _SEMICOLON;

    public AstToken getimport() { return _import; }
    public IName getName() { return _Name; }
    public AstToken getDOT() { return _DOT; }
    public AstToken getMULTIPLY() { return _MULTIPLY; }
    public AstToken getSEMICOLON() { return _SEMICOLON; }

    public TypeImportOnDemandDeclaration(IToken leftIToken, IToken rightIToken,
                                         AstToken _import,
                                         IName _Name,
                                         AstToken _DOT,
                                         AstToken _MULTIPLY,
                                         AstToken _SEMICOLON)
    {
        super(leftIToken, rightIToken);

        this._import = _import;
        ((Ast) _import).setParent(this);
        this._Name = _Name;
        ((Ast) _Name).setParent(this);
        this._DOT = _DOT;
        ((Ast) _DOT).setParent(this);
        this._MULTIPLY = _MULTIPLY;
        ((Ast) _MULTIPLY).setParent(this);
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
        list.add(_DOT);
        list.add(_MULTIPLY);
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
        if (! (o instanceof TypeImportOnDemandDeclaration)) return false;
        TypeImportOnDemandDeclaration other = (TypeImportOnDemandDeclaration) o;
        if (! _import.equals(other._import)) return false;
        if (! _Name.equals(other._Name)) return false;
        if (! _DOT.equals(other._DOT)) return false;
        if (! _MULTIPLY.equals(other._MULTIPLY)) return false;
        if (! _SEMICOLON.equals(other._SEMICOLON)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_import.hashCode());
        hash = hash * 31 + (_Name.hashCode());
        hash = hash * 31 + (_DOT.hashCode());
        hash = hash * 31 + (_MULTIPLY.hashCode());
        hash = hash * 31 + (_SEMICOLON.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


