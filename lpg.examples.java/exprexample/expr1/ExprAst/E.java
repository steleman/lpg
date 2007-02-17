package expr1.ExprAst;

import lpg.javaruntime.*;

/**
 *<em>
 *<li>Rule 2:  E ::= T
 *</em>
 *<p>
 *<b>
 *<li>Rule 1:  E ::= E + T
 *</b>
 */
public class E extends Ast implements IE
{
    private IE _E;
    private IT _T;

    public IE getE() { return _E; }
    public IT getT() { return _T; }

    public E(IToken leftIToken, IToken rightIToken,
             IE _E,
             IT _T)
    {
        super(leftIToken, rightIToken);

        this._E = _E;
        this._T = _T;
        initialize();
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
        if (! (o instanceof E)) return false;
        E other = (E) o;
        if (! _E.equals(other._E)) return false;
        if (! _T.equals(other._T)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_E.hashCode());
        hash = hash * 31 + (_T.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


