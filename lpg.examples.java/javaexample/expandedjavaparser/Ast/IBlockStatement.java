//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 * is implemented by:
 *<b>
 *<ul>
 *<li>ClassDeclaration
 *<li>Block
 *<li>LocalVariableDeclarationStatement
 *<li>EmptyStatement
 *<li>LabeledStatement
 *<li>ExpressionStatement
 *<li>IfStatement
 *<li>SwitchStatement
 *<li>WhileStatement
 *<li>DoStatement
 *<li>ForStatement
 *<li>BreakStatement
 *<li>ContinueStatement
 *<li>ReturnStatement
 *<li>ThrowStatement
 *<li>SynchronizedStatement
 *<li>TryStatement
 *</ul>
 *</b>
 */
public interface IBlockStatement
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
    void accept(ArgumentVisitor v, Object o);
    Object accept(ResultVisitor v);
    Object accept(ResultArgumentVisitor v, Object o);
}


