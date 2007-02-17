package expr5.ExprAst;

import lpg.javaruntime.*;

/**
 *<em>
 *<li>Rule 4:  T ::= F
 *</em>
 *<p>
 *<b>
 *<li>Rule 3:  T ::= T * F
 *</b>
 */
public class T extends Ast implements IT
{
    private IT _T;
    private IF _F;

    public IT getT() { return _T; }
    public IF getF() { return _F; }

    public T(IToken leftIToken, IToken rightIToken,
             IT _T,
             IF _F)
    {
        super(leftIToken, rightIToken);

        this._T = _T;
        this._F = _F;
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
        if (! (o instanceof T)) return false;
        T other = (T) o;
        if (! _T.equals(other._T)) return false;
        if (! _F.equals(other._F)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_T.hashCode());
        hash = hash * 31 + (_F.hashCode());
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
            _T.accept(v);
            _F.accept(v);
        }
        v.endVisit(this);
    }
}


