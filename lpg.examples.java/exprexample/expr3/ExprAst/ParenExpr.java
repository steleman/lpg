package expr3.ExprAst;

import expr3.*;
import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 6:  F ::= ( E )
 *</b>
 */
public class ParenExpr extends Ast implements IF
{
    private ExprParser environment;
    public ExprParser getEnvironment() { return environment; }

    private IE _E;

    public IE getE() { return _E; }

    public ParenExpr(ExprParser environment, IToken leftIToken, IToken rightIToken,
                     IE _E)
    {
        super(leftIToken, rightIToken);

        this.environment = environment;
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

    void initialize()
    {
        setValue(((Ast) getE()).getValue());
    }
}


