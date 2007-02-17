package javascriptparser.Ast;

import lpg.runtime.java.*;


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


