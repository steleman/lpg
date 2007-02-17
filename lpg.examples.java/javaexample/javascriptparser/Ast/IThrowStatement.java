package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 * is implemented by <b>ThrowStatement</b>
 */
public interface IThrowStatement
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


