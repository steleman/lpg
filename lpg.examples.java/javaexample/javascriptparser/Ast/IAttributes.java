package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 * is implemented by:
 *<b>
 *<ul>
 *<li>AttributeCombination
 *<li>Identifier0
 *<li>Identifier1
 *<li>Identifier2
 *<li>Identifier3
 *<li>SimpleQualifiedIdentifier0
 *<li>SimpleQualifiedIdentifier1
 *<li>ReservedNamespace0
 *<li>ReservedNamespace1
 *<li>AttributeExpression0
 *<li>AttributeExpression1
 *<li>Attribute0
 *<li>Attribute1
 *</ul>
 *</b>
 */
public interface IAttributes
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


