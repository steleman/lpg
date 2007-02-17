package expr5.ExprAst;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 6:  F ::= ( E )
 *</b>
 */
public class ParenExpr extends Ast implements IF
{
    private IE _E;

    public IE getE() { return _E; }

    public ParenExpr(IToken leftIToken, IToken rightIToken,
                     IE _E)
    {
        super(leftIToken, rightIToken);

        this._E = _E;
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
        if (! (o instanceof ParenExpr)) return false;
        ParenExpr other = (ParenExpr) o;
        if (! _E.equals(other._E)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_E.hashCode());
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
            _E.accept(v);
        v.endVisit(this);
    }
}


