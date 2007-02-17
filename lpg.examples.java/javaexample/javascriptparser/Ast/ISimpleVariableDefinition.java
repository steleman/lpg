package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 * is implemented by <b>SimpleVariableDefinition</b>
 */
public interface ISimpleVariableDefinition
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


