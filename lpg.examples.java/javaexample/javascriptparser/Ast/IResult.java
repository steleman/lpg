package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 * is implemented by <b>Result</b>
 */
public interface IResult
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


