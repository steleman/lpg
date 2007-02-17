//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

/**
 * is always implemented by <b>AstToken</b>. It is also implemented by:
 *<b>
 *<ul>
 *<li>ByteType
 *<li>ShortType
 *<li>IntType
 *<li>LongType
 *<li>CharType
 *</ul>
 *</b>
 */
public interface IIntegralType extends INumericType, IAstToken {}


