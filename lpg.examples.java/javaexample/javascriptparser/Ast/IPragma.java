package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 * is implemented by <b>Pragma</b>
 */
public interface IPragma
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


