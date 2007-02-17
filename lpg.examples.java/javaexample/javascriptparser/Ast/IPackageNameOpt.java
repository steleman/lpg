package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 * is implemented by:
 *<b>
 *<ul>
 *<li>PackageName
 *<li>PackageIdentifiers
 *<li>Identifier0
 *<li>Identifier1
 *<li>Identifier2
 *<li>Identifier3
 *</ul>
 *</b>
 */
public interface IPackageNameOpt
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


