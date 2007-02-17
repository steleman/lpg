package javascriptparser.Ast;

import lpg.javaruntime.*;


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


