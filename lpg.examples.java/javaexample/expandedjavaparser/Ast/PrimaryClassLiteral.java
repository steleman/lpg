//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 209:  PrimaryNoNewArray ::= Type . class
 *</b>
 */
public class PrimaryClassLiteral extends Ast implements IPrimaryNoNewArray
{
    private IType _Type;
    private AstToken _DOT;
    private AstToken _class;

    public IType getType() { return _Type; }
    public AstToken getDOT() { return _DOT; }
    public AstToken getclass() { return _class; }

    public PrimaryClassLiteral(IToken leftIToken, IToken rightIToken,
                               IType _Type,
                               AstToken _DOT,
                               AstToken _class)
    {
        super(leftIToken, rightIToken);

        this._Type = _Type;
        ((Ast) _Type).setParent(this);
        this._DOT = _DOT;
        ((Ast) _DOT).setParent(this);
        this._class = _class;
        ((Ast) _class).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_Type);
        list.add(_DOT);
        list.add(_class);
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
        if (! (o instanceof PrimaryClassLiteral)) return false;
        PrimaryClassLiteral other = (PrimaryClassLiteral) o;
        if (! _Type.equals(other._Type)) return false;
        if (! _DOT.equals(other._DOT)) return false;
        if (! _class.equals(other._class)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_Type.hashCode());
        hash = hash * 31 + (_DOT.hashCode());
        hash = hash * 31 + (_class.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


