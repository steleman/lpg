package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 * is implemented by <b>VariableDefinition_allowIn</b>
 */
public interface IVariableDefinition_allowIn
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


