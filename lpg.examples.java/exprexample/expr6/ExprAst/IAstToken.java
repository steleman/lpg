package expr6.ExprAst;

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
}


