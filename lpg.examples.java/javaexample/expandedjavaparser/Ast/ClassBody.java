//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 66:  ClassBody ::= { ClassBodyDeclarationsopt }
 *</b>
 */
public class ClassBody extends Ast implements IClassBody
{
    private AstToken _LBRACE;
    private ClassBodyDeclarationList _ClassBodyDeclarationsopt;
    private AstToken _RBRACE;

    public AstToken getLBRACE() { return _LBRACE; }
    public ClassBodyDeclarationList getClassBodyDeclarationsopt() { return _ClassBodyDeclarationsopt; }
    public AstToken getRBRACE() { return _RBRACE; }

    public ClassBody(IToken leftIToken, IToken rightIToken,
                     AstToken _LBRACE,
                     ClassBodyDeclarationList _ClassBodyDeclarationsopt,
                     AstToken _RBRACE)
    {
        super(leftIToken, rightIToken);

        this._LBRACE = _LBRACE;
        ((Ast) _LBRACE).setParent(this);
        this._ClassBodyDeclarationsopt = _ClassBodyDeclarationsopt;
        ((Ast) _ClassBodyDeclarationsopt).setParent(this);
        this._RBRACE = _RBRACE;
        ((Ast) _RBRACE).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_LBRACE);
        list.add(_ClassBodyDeclarationsopt);
        list.add(_RBRACE);
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
        if (! (o instanceof ClassBody)) return false;
        ClassBody other = (ClassBody) o;
        if (! _LBRACE.equals(other._LBRACE)) return false;
        if (! _ClassBodyDeclarationsopt.equals(other._ClassBodyDeclarationsopt)) return false;
        if (! _RBRACE.equals(other._RBRACE)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_LBRACE.hashCode());
        hash = hash * 31 + (_ClassBodyDeclarationsopt.hashCode());
        hash = hash * 31 + (_RBRACE.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


