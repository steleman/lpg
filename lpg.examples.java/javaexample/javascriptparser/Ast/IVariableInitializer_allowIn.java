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
 *<li>BitwiseAndExpression_allowIn
 *<li>BitwiseXorExpression_allowIn
 *<li>BitwiseOrExpression_allowIn
 *<li>LogicalAndExpression_allowIn
 *<li>LogicalXorExpression_allowIn
 *<li>LogicalOrExpression_allowIn
 *<li>ConditionalExpression_allowIn
 *<li>AttributeCombination
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
 *<li>AttributeExpression0
 *<li>AttributeExpression1
 *<li>FullPostfixExpression0
 *<li>FullPostfixExpression1
 *<li>FullPostfixExpression2
 *<li>FullPostfixExpression3
 *<li>FullPostfixExpression4
 *<li>UnaryExpression0
 *<li>UnaryExpression1
 *<li>UnaryExpression2
 *<li>UnaryExpression3
 *<li>UnaryExpression4
 *<li>UnaryExpression5
 *<li>UnaryExpression6
 *<li>UnaryExpression7
 *<li>UnaryExpression8
 *<li>UnaryExpression9
 *<li>MultiplicativeExpression0
 *<li>MultiplicativeExpression1
 *<li>MultiplicativeExpression2
 *<li>AdditiveExpression0
 *<li>AdditiveExpression1
 *<li>ShiftExpression0
 *<li>ShiftExpression1
 *<li>ShiftExpression2
 *<li>RelationalExpression_allowIn0
 *<li>RelationalExpression_allowIn1
 *<li>RelationalExpression_allowIn2
 *<li>RelationalExpression_allowIn3
 *<li>RelationalExpression_allowIn4
 *<li>RelationalExpression_allowIn5
 *<li>RelationalExpression_allowIn6
 *<li>RelationalExpression_allowIn7
 *<li>EqualityExpression_allowIn0
 *<li>EqualityExpression_allowIn1
 *<li>EqualityExpression_allowIn2
 *<li>EqualityExpression_allowIn3
 *<li>AssignmentExpression_allowIn0
 *<li>AssignmentExpression_allowIn1
 *<li>AssignmentExpression_allowIn2
 *</ul>
 *</b>
 */
public interface IVariableInitializer_allowIn
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


