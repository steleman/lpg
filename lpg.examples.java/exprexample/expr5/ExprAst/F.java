package expr5.ExprAst;

import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 5:  F ::= IntegerLiteral
 *</b>
 */
public class F extends AstToken implements IF
{
    public F(IToken token) { super(token); initialize(); }

    public void accept(Visitor v)
    {
        if (! v.preVisit(this)) return;
        enter(v);
        v.postVisit(this);
    }

    public void enter(Visitor v)
    {
        v.visit(this);
        v.endVisit(this);
    }
}


