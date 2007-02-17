package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 * is implemented by <b>CaseElementsPrefix</b>
 */
public interface ICaseElementsPrefix
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


