//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import expandedjavaparser.*;
import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 108:  InterfaceDeclaration ::= Modifiersopt interface IDENTIFIER$Name ExtendsInterfacesopt InterfaceBody
 *</b>
 */
public class InterfaceDeclaration extends Ast implements IInterfaceDeclaration
{
    private JavaParser environment;
    public JavaParser getEnvironment() { return environment; }

    private ModifierList _Modifiersopt;
    private AstToken _interface;
    private AstToken _Name;
    private InterfaceTypeList _ExtendsInterfacesopt;
    private InterfaceBody _InterfaceBody;

    public ModifierList getModifiersopt() { return _Modifiersopt; }
    public AstToken getinterface() { return _interface; }
    public AstToken getName() { return _Name; }
    public InterfaceTypeList getExtendsInterfacesopt() { return _ExtendsInterfacesopt; }
    public InterfaceBody getInterfaceBody() { return _InterfaceBody; }

    public InterfaceDeclaration(JavaParser environment, IToken leftIToken, IToken rightIToken,
                                ModifierList _Modifiersopt,
                                AstToken _interface,
                                AstToken _Name,
                                InterfaceTypeList _ExtendsInterfacesopt,
                                InterfaceBody _InterfaceBody)
    {
        super(leftIToken, rightIToken);

        this.environment = environment;
        this._Modifiersopt = _Modifiersopt;
        ((Ast) _Modifiersopt).setParent(this);
        this._interface = _interface;
        ((Ast) _interface).setParent(this);
        this._Name = _Name;
        ((Ast) _Name).setParent(this);
        this._ExtendsInterfacesopt = _ExtendsInterfacesopt;
        ((Ast) _ExtendsInterfacesopt).setParent(this);
        this._InterfaceBody = _InterfaceBody;
        ((Ast) _InterfaceBody).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_Modifiersopt);
        list.add(_interface);
        list.add(_Name);
        list.add(_ExtendsInterfacesopt);
        list.add(_InterfaceBody);
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
        if (! (o instanceof InterfaceDeclaration)) return false;
        InterfaceDeclaration other = (InterfaceDeclaration) o;
        if (! _Modifiersopt.equals(other._Modifiersopt)) return false;
        if (! _interface.equals(other._interface)) return false;
        if (! _Name.equals(other._Name)) return false;
        if (! _ExtendsInterfacesopt.equals(other._ExtendsInterfacesopt)) return false;
        if (! _InterfaceBody.equals(other._InterfaceBody)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_Modifiersopt.hashCode());
        hash = hash * 31 + (_interface.hashCode());
        hash = hash * 31 + (_Name.hashCode());
        hash = hash * 31 + (_ExtendsInterfacesopt.hashCode());
        hash = hash * 31 + (_InterfaceBody.hashCode());
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


