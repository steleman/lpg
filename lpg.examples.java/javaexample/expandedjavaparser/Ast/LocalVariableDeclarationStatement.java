//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 129:  LocalVariableDeclarationStatement ::= LocalVariableDeclaration ;
 *</b>
 */
public class LocalVariableDeclarationStatement extends Ast implements ILocalVariableDeclarationStatement
{
    private LocalVariableDeclaration _LocalVariableDeclaration;
    private AstToken _SEMICOLON;

    public LocalVariableDeclaration getLocalVariableDeclaration() { return _LocalVariableDeclaration; }
    public AstToken getSEMICOLON() { return _SEMICOLON; }

    public LocalVariableDeclarationStatement(IToken leftIToken, IToken rightIToken,
                                             LocalVariableDeclaration _LocalVariableDeclaration,
                                             AstToken _SEMICOLON)
    {
        super(leftIToken, rightIToken);

        this._LocalVariableDeclaration = _LocalVariableDeclaration;
        ((Ast) _LocalVariableDeclaration).setParent(this);
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
        list.add(_LocalVariableDeclaration);
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
        if (! (o instanceof LocalVariableDeclarationStatement)) return false;
        LocalVariableDeclarationStatement other = (LocalVariableDeclarationStatement) o;
        if (! _LocalVariableDeclaration.equals(other._LocalVariableDeclaration)) return false;
        if (! _SEMICOLON.equals(other._SEMICOLON)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_LocalVariableDeclaration.hashCode());
        hash = hash * 31 + (_SEMICOLON.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


