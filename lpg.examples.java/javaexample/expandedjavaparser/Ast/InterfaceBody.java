//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 110:  InterfaceBody ::= { InterfaceMemberDeclarationsopt }
 *</b>
 */
public class InterfaceBody extends Ast implements IInterfaceBody
{
    private AstToken _LBRACE;
    private InterfaceMemberDeclarationList _InterfaceMemberDeclarationsopt;
    private AstToken _RBRACE;

    public AstToken getLBRACE() { return _LBRACE; }
    public InterfaceMemberDeclarationList getInterfaceMemberDeclarationsopt() { return _InterfaceMemberDeclarationsopt; }
    public AstToken getRBRACE() { return _RBRACE; }

    public InterfaceBody(IToken leftIToken, IToken rightIToken,
                         AstToken _LBRACE,
                         InterfaceMemberDeclarationList _InterfaceMemberDeclarationsopt,
                         AstToken _RBRACE)
    {
        super(leftIToken, rightIToken);

        this._LBRACE = _LBRACE;
        ((Ast) _LBRACE).setParent(this);
        this._InterfaceMemberDeclarationsopt = _InterfaceMemberDeclarationsopt;
        ((Ast) _InterfaceMemberDeclarationsopt).setParent(this);
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
        list.add(_InterfaceMemberDeclarationsopt);
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
        if (! (o instanceof InterfaceBody)) return false;
        InterfaceBody other = (InterfaceBody) o;
        if (! _LBRACE.equals(other._LBRACE)) return false;
        if (! _InterfaceMemberDeclarationsopt.equals(other._InterfaceMemberDeclarationsopt)) return false;
        if (! _RBRACE.equals(other._RBRACE)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_LBRACE.hashCode());
        hash = hash * 31 + (_InterfaceMemberDeclarationsopt.hashCode());
        hash = hash * 31 + (_RBRACE.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


