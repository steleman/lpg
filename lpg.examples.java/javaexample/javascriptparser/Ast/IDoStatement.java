package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 * is implemented by <b>DoStatement</b>
 */
public interface IDoStatement
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


