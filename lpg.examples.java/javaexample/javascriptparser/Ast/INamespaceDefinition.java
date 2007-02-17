package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 * is implemented by <b>NamespaceDefinition</b>
 */
public interface INamespaceDefinition
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


