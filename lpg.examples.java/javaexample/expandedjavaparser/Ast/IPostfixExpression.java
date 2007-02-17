//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

/**
 * is implemented by:
 *<b>
 *<ul>
 *<li>IntegerLiteral
 *<li>LongLiteral
 *<li>FloatLiteral
 *<li>DoubleLiteral
 *<li>BooleanLiteral
 *<li>CharacterLiteral
 *<li>StringLiteral
 *<li>NullLiteral
 *<li>TrueLiteral
 *<li>FalseLiteral
 *<li>SimpleName
 *<li>QualifiedName
 *<li>ParenthesizedExpression
 *<li>PrimaryThis
 *<li>PrimaryClassLiteral
 *<li>PrimaryVoidClassLiteral
 *<li>ClassInstanceCreationExpression
 *<li>ArrayCreationExpression
 *<li>FieldAccess
 *<li>SuperFieldAccess
 *<li>MethodInvocation
 *<li>PrimaryMethodInvocation
 *<li>SuperMethodInvocation
 *<li>ArrayAccess
 *<li>PostIncrementExpression
 *<li>PostDecrementExpression
 *</ul>
 *</b>
 */
public interface IPostfixExpression extends IUnaryExpressionNotPlusMinus {}


