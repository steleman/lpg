package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 * is implemented by <b>Substatements</b>
 */
public interface ISubstatements
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


