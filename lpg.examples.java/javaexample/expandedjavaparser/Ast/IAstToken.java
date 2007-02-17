//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 * is always implemented by <b>AstToken</b>. It is also implemented by:
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
 *<li>BooleanType
 *<li>ByteType
 *<li>ShortType
 *<li>IntType
 *<li>LongType
 *<li>CharType
 *<li>FloatType
 *<li>DoubleType
 *<li>SimpleName
 *<li>EmptyDeclaration
 *<li>PublicModifier
 *<li>ProtectedModifier
 *<li>PrivateModifier
 *<li>StaticModifier
 *<li>AbstractModifier
 *<li>FinalModifier
 *<li>NativeModifier
 *<li>StrictfpModifier
 *<li>SynchronizedModifier
 *<li>TransientModifier
 *<li>VolatileModifier
 *<li>ClassDeclaration
 *<li>FieldDeclaration
 *<li>MethodDeclaration
 *<li>EmptyMethodBody
 *<li>InterfaceDeclaration
 *<li>AbstractMethodDeclaration
 *<li>Block
 *<li>EmptyStatement
 *<li>ParenthesizedExpression
 *<li>PrimaryThis
 *<li>PrimaryClassLiteral
 *<li>PrimaryVoidClassLiteral
 *<li>ClassInstanceCreationExpression
 *<li>FieldAccess
 *<li>SuperFieldAccess
 *<li>MethodInvocation
 *<li>PrimaryMethodInvocation
 *<li>SuperMethodInvocation
 *<li>ArrayAccess
 *<li>EqualOperator
 *<li>MultiplyEqualOperator
 *<li>DivideEqualOperator
 *<li>ModEqualOperator
 *<li>PlusEqualOperator
 *<li>MinusEqualOperator
 *<li>LeftShiftEqualOperator
 *<li>RightShiftEqualOperator
 *<li>UnsignedRightShiftEqualOperator
 *<li>AndEqualOperator
 *<li>ExclusiveOrEqualOperator
 *<li>OrEqualOperator
 *<li>Commaopt
 *<li>IDENTIFIERopt
 *</ul>
 *</b>
 */
public interface IAstToken
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
    void accept(ArgumentVisitor v, Object o);
    Object accept(ResultVisitor v);
    Object accept(ResultArgumentVisitor v, Object o);
}


