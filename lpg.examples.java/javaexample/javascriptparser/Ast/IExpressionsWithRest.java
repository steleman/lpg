package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 * is implemented by:
 *<b>
 *<ul>
 *<li>ExpressionsWithRest
 *<li>RestExpression
 *</ul>
 *</b>
 */
public interface IExpressionsWithRest
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


