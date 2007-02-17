package javascriptparser.Ast;

import lpg.javaruntime.*;


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


