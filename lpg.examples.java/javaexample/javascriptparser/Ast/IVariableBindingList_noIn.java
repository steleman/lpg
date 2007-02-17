package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 * is implemented by:
 *<b>
 *<ul>
 *<li>VariableBindingList_noIn
 *<li>VariableBinding_noIn
 *</ul>
 *</b>
 */
public interface IVariableBindingList_noIn
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


