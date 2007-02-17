package expr2.ExprAst;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 5:  F ::= IntegerLiteral
 *</b>
 */
public class F extends AstToken implements IF
{
    public F(IToken token) { super(token); initialize(); }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


