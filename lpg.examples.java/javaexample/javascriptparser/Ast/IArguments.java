package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 * is implemented by:
 *<b>
 *<ul>
 *<li>ParenExpression
 *<li>ParenListExpression
 *<li>Arguments0
 *<li>Arguments1
 *</ul>
 *</b>
 */
public interface IArguments
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


