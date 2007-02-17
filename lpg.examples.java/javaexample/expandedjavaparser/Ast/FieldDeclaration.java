//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import expandedjavaparser.*;
import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 78:  FieldDeclaration ::= Modifiersopt Type VariableDeclarators ;
 *</b>
 */
public class FieldDeclaration extends Ast implements IFieldDeclaration
{
    private JavaParser environment;
    public JavaParser getEnvironment() { return environment; }

    private ModifierList _Modifiersopt;
    private IType _Type;
    private VariableDeclaratorList _VariableDeclarators;
    private AstToken _SEMICOLON;

    public ModifierList getModifiersopt() { return _Modifiersopt; }
    public IType getType() { return _Type; }
    public VariableDeclaratorList getVariableDeclarators() { return _VariableDeclarators; }
    public AstToken getSEMICOLON() { return _SEMICOLON; }

    public FieldDeclaration(JavaParser environment, IToken leftIToken, IToken rightIToken,
                            ModifierList _Modifiersopt,
                            IType _Type,
                            VariableDeclaratorList _VariableDeclarators,
                            AstToken _SEMICOLON)
    {
        super(leftIToken, rightIToken);

        this.environment = environment;
        this._Modifiersopt = _Modifiersopt;
        ((Ast) _Modifiersopt).setParent(this);
        this._Type = _Type;
        ((Ast) _Type).setParent(this);
        this._VariableDeclarators = _VariableDeclarators;
        ((Ast) _VariableDeclarators).setParent(this);
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
        list.add(_Modifiersopt);
        list.add(_Type);
        list.add(_VariableDeclarators);
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
        if (! (o instanceof FieldDeclaration)) return false;
        FieldDeclaration other = (FieldDeclaration) o;
        if (! _Modifiersopt.equals(other._Modifiersopt)) return false;
        if (! _Type.equals(other._Type)) return false;
        if (! _VariableDeclarators.equals(other._VariableDeclarators)) return false;
        if (! _SEMICOLON.equals(other._SEMICOLON)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_Modifiersopt.hashCode());
        hash = hash * 31 + (_Type.hashCode());
        hash = hash * 31 + (_VariableDeclarators.hashCode());
        hash = hash * 31 + (_SEMICOLON.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }

private IToken docComment;
public IToken getDocComment() { return docComment; }
    
public void initialize()
{
    docComment = environment.getDocComment(getLeftIToken());
}
}


