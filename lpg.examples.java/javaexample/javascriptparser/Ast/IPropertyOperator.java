package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 * is implemented by:
 *<b>
 *<ul>
 *<li>PropertyOperator
 *<li>Brackets0
 *<li>Brackets1
 *<li>Brackets2
 *</ul>
 *</b>
 */
public interface IPropertyOperator
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


