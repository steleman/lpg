package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 * is implemented by:
 *<b>
 *<ul>
 *<li>ExpressionQualifiedIdentifier
 *<li>ParenExpression
 *<li>ParenListExpression
 *<li>ObjectLiteral
 *<li>ArrayLiteral
 *<li>FullNewExpression
 *<li>ShortNewExpression
 *<li>Identifier0
 *<li>Identifier1
 *<li>Identifier2
 *<li>Identifier3
 *<li>SimpleQualifiedIdentifier0
 *<li>SimpleQualifiedIdentifier1
 *<li>PrimaryExpression0
 *<li>PrimaryExpression1
 *<li>PrimaryExpression2
 *<li>PrimaryExpression3
 *<li>PrimaryExpression4
 *<li>PrimaryExpression5
 *<li>PrimaryExpression6
 *<li>ReservedNamespace0
 *<li>ReservedNamespace1
 *<li>FunctionExpression0
 *<li>FunctionExpression1
 *<li>FullNewSubexpression0
 *<li>FullNewSubexpression1
 *</ul>
 *</b>
 */
public interface IShortNewSubexpression
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


