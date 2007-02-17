package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 * is implemented by <b>VariableInitialisation_allowIn</b>
 */
public interface IVariableInitialisation_allowIn
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


