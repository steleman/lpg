package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 * is implemented by <b>FunctionCommon</b>
 */
public interface IFunctionCommon
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}

