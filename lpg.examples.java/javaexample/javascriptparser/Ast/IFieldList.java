package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 * is implemented by:
 *<b>
 *<ul>
 *<li>NonemptyFieldList
 *<li>LiteralField
 *</ul>
 *</b>
 */
public interface IFieldList
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


