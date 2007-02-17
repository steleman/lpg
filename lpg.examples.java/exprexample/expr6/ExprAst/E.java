package expr6.ExprAst;

import lpg.runtime.java.*;

/**
 *<em>
 *<li>Rule 4:  E ::= T
 *</em>
 *<p>
 *<b>
 *<li>Rule 3:  E ::= E + T
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

    public void accept(Visitor v)
    {
        if (! v.preVisit(this)) return;
        enter(v);
        v.postVisit(this);
    }

    public void enter(Visitor v)
    {
        boolean checkChildren = v.visit(this);
        if (checkChildren)
        {
            _E.accept(v);
            _T.accept(v);
        }
        v.endVisit(this);
    }
}


