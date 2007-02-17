//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 224:  Dim ::= [ ]
 *</b>
 */
public class Dim extends Ast implements IDim
{
    private AstToken _LBRACKET;
    private AstToken _RBRACKET;

    public AstToken getLBRACKET() { return _LBRACKET; }
    public AstToken getRBRACKET() { return _RBRACKET; }

    public Dim(IToken leftIToken, IToken rightIToken,
               AstToken _LBRACKET,
               AstToken _RBRACKET)
    {
        super(leftIToken, rightIToken);

        this._LBRACKET = _LBRACKET;
        ((Ast) _LBRACKET).setParent(this);
        this._RBRACKET = _RBRACKET;
        ((Ast) _RBRACKET).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_LBRACKET);
        list.add(_RBRACKET);
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
        if (! (o instanceof Dim)) return false;
        Dim other = (Dim) o;
        if (! _LBRACKET.equals(other._LBRACKET)) return false;
        if (! _RBRACKET.equals(other._RBRACKET)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_LBRACKET.hashCode());
        hash = hash * 31 + (_RBRACKET.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


