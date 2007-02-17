package expr5.ExprAst;

import lpg.javaruntime.*;

/**
 * is implemented by:
 *<b>
 *<ul>
 *<li>E
 *<li>T
 *<li>F
 *<li>ParenExpr
 *</ul>
 *</b>
 */
public interface IE
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


