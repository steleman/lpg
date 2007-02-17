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
 *<li>ObjectLiteral
 *<li>ArrayLiteral
 *<li>FullNewExpression
 *<li>ShortNewExpression
 *<li>BitwiseAndExpression_noIn
 *<li>BitwiseXorExpression_noIn
 *<li>BitwiseOrExpression_noIn
 *<li>LogicalAndExpression_noIn
 *<li>LogicalXorExpression_noIn
 *<li>LogicalOrExpression_noIn
 *<li>ConditionalExpression_noIn
 *<li>ListExpression_noIn
 *<li>ForInitializer
 *<li>VariableDefinition_noIn
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
 *<li>RelationalExpression_noIn0
 *<li>RelationalExpression_noIn1
 *<li>RelationalExpression_noIn2
 *<li>RelationalExpression_noIn3
 *<li>RelationalExpression_noIn4
 *<li>RelationalExpression_noIn5
 *<li>RelationalExpression_noIn6
 *<li>EqualityExpression_noIn0
 *<li>EqualityExpression_noIn1
 *<li>EqualityExpression_noIn2
 *<li>EqualityExpression_noIn3
 *<li>AssignmentExpression_noIn0
 *<li>AssignmentExpression_noIn1
 *<li>AssignmentExpression_noIn2
 *</ul>
 *</b>
 */
public interface IForInitializer
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


