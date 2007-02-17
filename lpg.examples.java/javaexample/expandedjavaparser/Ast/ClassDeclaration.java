//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import expandedjavaparser.*;
import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 61:  ClassDeclaration ::= Modifiersopt class IDENTIFIER$Name Superopt Interfacesopt ClassBody
 *</b>
 */
public class ClassDeclaration extends Ast implements IClassDeclaration
{
    private JavaParser environment;
    public JavaParser getEnvironment() { return environment; }

    private ModifierList _Modifiersopt;
    private AstToken _class;
    private AstToken _Name;
    private Super _Superopt;
    private InterfaceTypeList _Interfacesopt;
    private ClassBody _ClassBody;

    public ModifierList getModifiersopt() { return _Modifiersopt; }
    public AstToken getclass() { return _class; }
    public AstToken getName() { return _Name; }
    /**
     * The value returned by <b>getSuperopt</b> may be <b>null</b>
     */
    public Super getSuperopt() { return _Superopt; }
    public InterfaceTypeList getInterfacesopt() { return _Interfacesopt; }
    public ClassBody getClassBody() { return _ClassBody; }

    public ClassDeclaration(JavaParser environment, IToken leftIToken, IToken rightIToken,
                            ModifierList _Modifiersopt,
                            AstToken _class,
                            AstToken _Name,
                            Super _Superopt,
                            InterfaceTypeList _Interfacesopt,
                            ClassBody _ClassBody)
    {
        super(leftIToken, rightIToken);

        this.environment = environment;
        this._Modifiersopt = _Modifiersopt;
        ((Ast) _Modifiersopt).setParent(this);
        this._class = _class;
        ((Ast) _class).setParent(this);
        this._Name = _Name;
        ((Ast) _Name).setParent(this);
        this._Superopt = _Superopt;
        if (_Superopt != null) ((Ast) _Superopt).setParent(this);
        this._Interfacesopt = _Interfacesopt;
        ((Ast) _Interfacesopt).setParent(this);
        this._ClassBody = _ClassBody;
        ((Ast) _ClassBody).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_Modifiersopt);
        list.add(_class);
        list.add(_Name);
        list.add(_Superopt);
        list.add(_Interfacesopt);
        list.add(_ClassBody);
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
        if (! (o instanceof ClassDeclaration)) return false;
        ClassDeclaration other = (ClassDeclaration) o;
        if (! _Modifiersopt.equals(other._Modifiersopt)) return false;
        if (! _class.equals(other._class)) return false;
        if (! _Name.equals(other._Name)) return false;
        if (_Superopt == null)
            if (other._Superopt != null) return false;
            else; // continue
        else if (! _Superopt.equals(other._Superopt)) return false;
        if (! _Interfacesopt.equals(other._Interfacesopt)) return false;
        if (! _ClassBody.equals(other._ClassBody)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_Modifiersopt.hashCode());
        hash = hash * 31 + (_class.hashCode());
        hash = hash * 31 + (_Name.hashCode());
        hash = hash * 31 + (_Superopt == null ? 0 : _Superopt.hashCode());
        hash = hash * 31 + (_Interfacesopt.hashCode());
        hash = hash * 31 + (_ClassBody.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }

/* $identifier */
private IToken docComment;
public IToken getDocComment() { return docComment; }
    
public void initialize()
{
    docComment = environment.getDocComment(getLeftIToken());
}
}


