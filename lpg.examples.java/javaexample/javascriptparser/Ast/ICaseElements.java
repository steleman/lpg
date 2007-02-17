package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 * is implemented by:
 *<b>
 *<ul>
 *<li>CaseElements
 *<li>CaseLabel0
 *<li>CaseLabel1
 *</ul>
 *</b>
 */
public interface ICaseElements
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


