package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 * is implemented by <b>UseDirective</b>
 */
public interface IUseDirective
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


