package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 * is implemented by:
 *<b>
 *<ul>
 *<li>ImportDirective0
 *<li>ImportDirective1
 *</ul>
 *</b>
 */
public interface IImportDirective
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


