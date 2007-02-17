package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 * is implemented by <b>SuperStatement</b>
 */
public interface ISuperStatement
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


