package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 * is implemented by <b>Inheritance</b>
 */
public interface IInheritance
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


