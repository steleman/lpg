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
 *</ul>
 *</b>
 */
public interface IPrimary extends IPostfixExpression {}


