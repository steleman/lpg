package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 * is implemented by <b>SubstatementsPrefix</b>
 */
public interface ISubstatementsPrefix
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


