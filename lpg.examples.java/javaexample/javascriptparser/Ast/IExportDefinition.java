package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 * is implemented by <b>ExportDefinition</b>
 */
public interface IExportDefinition
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


