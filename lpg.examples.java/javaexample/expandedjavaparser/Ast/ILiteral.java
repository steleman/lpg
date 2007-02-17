//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

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
 *</ul>
 *</b>
 */
public interface ILiteral extends IAstToken, IPrimaryNoNewArray {}


