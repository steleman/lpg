package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 * is implemented by <b>IncludeDirective</b>
 */
public interface IIncludeDirective
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


