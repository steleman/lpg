package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 * is implemented by:
 *<b>
 *<ul>
 *<li>UntypedVariableBindingList
 *<li>UntypedVariableBinding
 *</ul>
 *</b>
 */
public interface IUntypedVariableBindingList
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


