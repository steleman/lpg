//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 * is implemented by:
 *<b>
 *<ul>
 *<li>BooleanType
 *<li>ByteType
 *<li>ShortType
 *<li>IntType
 *<li>LongType
 *<li>CharType
 *<li>FloatType
 *<li>DoubleType
 *<li>PrimitiveArrayType
 *<li>ClassOrInterfaceArrayType
 *<li>SimpleName
 *<li>QualifiedName
 *</ul>
 *</b>
 */
public interface IType
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
    void accept(ArgumentVisitor v, Object o);
    Object accept(ResultVisitor v);
    Object accept(ResultArgumentVisitor v, Object o);
}


