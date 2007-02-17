//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import expandedjavaparser.*;
import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 99:  ConstructorDeclaration ::= Modifiersopt ConstructorDeclarator Throwsopt ConstructorBody
 *</b>
 */
public class ConstructorDeclaration extends Ast implements IConstructorDeclaration
{
    private JavaParser environment;
    public JavaParser getEnvironment() { return environment; }

    private ModifierList _Modifiersopt;
    private ConstructorDeclarator _ConstructorDeclarator;
    private ClassTypeList _Throwsopt;
    private IConstructorBody _ConstructorBody;

    public ModifierList getModifiersopt() { return _Modifiersopt; }
    public ConstructorDeclarator getConstructorDeclarator() { return _ConstructorDeclarator; }
    public ClassTypeList getThrowsopt() { return _Throwsopt; }
    public IConstructorBody getConstructorBody() { return _ConstructorBody; }

    public ConstructorDeclaration(JavaParser environment, IToken leftIToken, IToken rightIToken,
                                  ModifierList _Modifiersopt,
                                  ConstructorDeclarator _ConstructorDeclarator,
                                  ClassTypeList _Throwsopt,
                                  IConstructorBody _ConstructorBody)
    {
        super(leftIToken, rightIToken);

        this.environment = environment;
        this._Modifiersopt = _Modifiersopt;
        ((Ast) _Modifiersopt).setParent(this);
        this._ConstructorDeclarator = _ConstructorDeclarator;
        ((Ast) _ConstructorDeclarator).setParent(this);
        this._Throwsopt = _Throwsopt;
        ((Ast) _Throwsopt).setParent(this);
        this._ConstructorBody = _ConstructorBody;
        ((Ast) _ConstructorBody).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_Modifiersopt);
        list.add(_ConstructorDeclarator);
        list.add(_Throwsopt);
        list.add(_ConstructorBody);
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
        if (! (o instanceof ConstructorDeclaration)) return false;
        ConstructorDeclaration other = (ConstructorDeclaration) o;
        if (! _Modifiersopt.equals(other._Modifiersopt)) return false;
        if (! _ConstructorDeclarator.equals(other._ConstructorDeclarator)) return false;
        if (! _Throwsopt.equals(other._Throwsopt)) return false;
        if (! _ConstructorBody.equals(other._ConstructorBody)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_Modifiersopt.hashCode());
        hash = hash * 31 + (_ConstructorDeclarator.hashCode());
        hash = hash * 31 + (_Throwsopt.hashCode());
        hash = hash * 31 + (_ConstructorBody.hashCode());
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


