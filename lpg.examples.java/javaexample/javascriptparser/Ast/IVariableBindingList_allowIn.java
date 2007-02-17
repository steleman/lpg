package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 * is implemented by:
 *<b>
 *<ul>
 *<li>VariableBindingList_allowIn
 *<li>VariableBinding_allowIn
 *</ul>
 *</b>
 */
public interface IVariableBindingList_allowIn
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


