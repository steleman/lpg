package lpg.examples.java.expr1.ExprAst;

import lpg.runtime.java.*;

/**
 * is always implemented by <b>AstToken</b>. It is also implemented by:
 *<b>
 *<ul>
 *<li>F
 *<li>ParenExpr
 *</ul>
 *</b>
 */
public interface IAstToken
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
    void accept(ArgumentVisitor v, Object o);
    Object accept(ResultVisitor v);
    Object accept(ResultArgumentVisitor v, Object o);
}


