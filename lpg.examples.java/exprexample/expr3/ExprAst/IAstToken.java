package expr3.ExprAst;

import lpg.javaruntime.*;

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

}


