//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

/**
 * is always implemented by <b>AstToken</b>. It is also implemented by:
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
 *</ul>
 *</b>
 */
public interface IPrimitiveType extends IType, IAstToken {}


