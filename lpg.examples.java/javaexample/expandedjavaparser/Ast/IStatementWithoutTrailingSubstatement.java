//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

/**
 * is implemented by:
 *<b>
 *<ul>
 *<li>Block
 *<li>EmptyStatement
 *<li>ExpressionStatement
 *<li>SwitchStatement
 *<li>DoStatement
 *<li>BreakStatement
 *<li>ContinueStatement
 *<li>ReturnStatement
 *<li>ThrowStatement
 *<li>SynchronizedStatement
 *<li>TryStatement
 *</ul>
 *</b>
 */
public interface IStatementWithoutTrailingSubstatement extends IStatement, IStatementNoShortIf {}


