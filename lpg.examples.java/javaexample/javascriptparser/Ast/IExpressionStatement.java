package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 * is implemented by:
 *<b>
 *<ul>
 *<li>ExpressionQualifiedIdentifier
 *<li>ParenExpression
 *<li>ParenListExpression
 *<li>ArrayLiteral
 *<li>FullNewExpression
 *<li>ShortNewExpression
 *<li>ExpressionStatement
 *<li>ES_BitwiseAndExpression_allowIn
 *<li>ES_BitwiseXorExpression_allowIn
 *<li>ES_BitwiseOrExpression_allowIn
 *<li>ES_LogicalAndExpression_allowIn
 *<li>ES_LogicalXorExpression_allowIn
 *<li>ES_LogicalOrExpression_allowIn
 *<li>ES_ConditionalExpression_allowIn
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
 *<li>ES_PrimaryExpression0
 *<li>ES_PrimaryExpression1
 *<li>ES_PrimaryExpression2
 *<li>ES_PrimaryExpression3
 *<li>ES_PrimaryExpression4
 *<li>ES_PrimaryExpression5
 *<li>ES_PrimaryExpression6
 *<li>ES_FullPostfixExpression0
 *<li>ES_FullPostfixExpression1
 *<li>ES_FullPostfixExpression2
 *<li>ES_FullPostfixExpression3
 *<li>ES_FullPostfixExpression4
 *<li>ES_UnaryExpression0
 *<li>ES_UnaryExpression1
 *<li>ES_UnaryExpression2
 *<li>ES_UnaryExpression3
 *<li>ES_UnaryExpression4
 *<li>ES_UnaryExpression5
 *<li>ES_UnaryExpression6
 *<li>ES_UnaryExpression7
 *<li>ES_UnaryExpression8
 *<li>ES_UnaryExpression9
 *<li>ES_MultiplicativeExpression0
 *<li>ES_MultiplicativeExpression1
 *<li>ES_MultiplicativeExpression2
 *<li>ES_AdditiveExpression0
 *<li>ES_AdditiveExpression1
 *<li>ES_ShiftExpression0
 *<li>ES_ShiftExpression1
 *<li>ES_ShiftExpression2
 *<li>ES_RelationalExpression_allowIn0
 *<li>ES_RelationalExpression_allowIn1
 *<li>ES_RelationalExpression_allowIn2
 *<li>ES_RelationalExpression_allowIn3
 *<li>ES_RelationalExpression_allowIn4
 *<li>ES_RelationalExpression_allowIn5
 *<li>ES_RelationalExpression_allowIn6
 *<li>ES_RelationalExpression_allowIn7
 *<li>ES_EqualityExpression_allowIn0
 *<li>ES_EqualityExpression_allowIn1
 *<li>ES_EqualityExpression_allowIn2
 *<li>ES_EqualityExpression_allowIn3
 *<li>ES_AssignmentExpression_allowIn0
 *<li>ES_AssignmentExpression_allowIn1
 *<li>ES_AssignmentExpression_allowIn2
 *</ul>
 *</b>
 */
public interface IExpressionStatement
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


