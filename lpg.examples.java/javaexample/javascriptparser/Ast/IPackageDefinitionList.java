package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 * is implemented by:
 *<b>
 *<ul>
 *<li>PackageDefinitionList
 *<li>PackageDefinition
 *</ul>
 *</b>
 */
public interface IPackageDefinitionList
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


