package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 * is implemented by:
 *<b>
 *<ul>
 *<li>PragmaItems
 *<li>PragmaItem
 *<li>PragmaExpr
 *<li>Identifier0
 *<li>Identifier1
 *<li>Identifier2
 *<li>Identifier3
 *</ul>
 *</b>
 */
public interface IPragmaItems
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


