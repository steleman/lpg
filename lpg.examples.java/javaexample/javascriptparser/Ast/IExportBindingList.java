package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 * is implemented by:
 *<b>
 *<ul>
 *<li>ExportBindingList
 *<li>ExportBinding
 *<li>Identifier0
 *<li>Identifier1
 *<li>Identifier2
 *<li>Identifier3
 *<li>FunctionName0
 *<li>FunctionName1
 *</ul>
 *</b>
 */
public interface IExportBindingList
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


