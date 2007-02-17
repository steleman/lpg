package javascriptparser.Ast;

import lpg.javaruntime.*;


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


