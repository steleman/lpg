//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import expandedjavaparser.*;
import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 119:  AbstractMethodDeclaration ::= MethodHeader ;
 *</b>
 */
public class AbstractMethodDeclaration extends Ast implements IAbstractMethodDeclaration
{
    private JavaParser environment;
    public JavaParser getEnvironment() { return environment; }

    private IMethodHeader _MethodHeader;
    private AstToken _SEMICOLON;

    public IMethodHeader getMethodHeader() { return _MethodHeader; }
    public AstToken getSEMICOLON() { return _SEMICOLON; }

    public AbstractMethodDeclaration(JavaParser environment, IToken leftIToken, IToken rightIToken,
                                     IMethodHeader _MethodHeader,
                                     AstToken _SEMICOLON)
    {
        super(leftIToken, rightIToken);

        this.environment = environment;
        this._MethodHeader = _MethodHeader;
        ((Ast) _MethodHeader).setParent(this);
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
        list.add(_MethodHeader);
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
        if (! (o instanceof AbstractMethodDeclaration)) return false;
        AbstractMethodDeclaration other = (AbstractMethodDeclaration) o;
        if (! _MethodHeader.equals(other._MethodHeader)) return false;
        if (! _SEMICOLON.equals(other._SEMICOLON)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_MethodHeader.hashCode());
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


