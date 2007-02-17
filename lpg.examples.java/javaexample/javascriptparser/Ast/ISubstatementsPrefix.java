package javascriptparser.Ast;

import lpg.runtime.java.*;


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


