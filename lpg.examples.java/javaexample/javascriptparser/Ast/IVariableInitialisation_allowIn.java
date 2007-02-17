package javascriptparser.Ast;

import lpg.runtime.java.*;


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


