//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

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
 *<li>PlusUnaryExpression
 *<li>MinusUnaryExpression
 *<li>PreIncrementExpression
 *<li>PreDecrementExpression
 *<li>UnaryComplementExpression
 *<li>UnaryNotExpression
 *<li>PrimitiveCastExpression
 *<li>ClassCastExpression
 *<li>MultiplyExpression
 *<li>DivideExpression
 *<li>ModExpression
 *<li>AddExpression
 *<li>SubtractExpression
 *<li>LeftShiftExpression
 *<li>RightShiftExpression
 *<li>UnsignedRightShiftExpression
 *<li>LessExpression
 *<li>GreaterExpression
 *<li>LessEqualExpression
 *<li>GreaterEqualExpression
 *<li>InstanceofExpression
 *<li>EqualExpression
 *<li>NotEqualExpression
 *<li>AndExpression
 *<li>ExclusiveOrExpression
 *<li>InclusiveOrExpression
 *<li>ConditionalAndExpression
 *<li>ConditionalOrExpression
 *<li>ConditionalExpression
 *<li>Assignment
 *</ul>
 *</b>
 */
public interface IConstantExpression
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
    void accept(ArgumentVisitor v, Object o);
    Object accept(ResultVisitor v);
    Object accept(ResultArgumentVisitor v, Object o);
}


