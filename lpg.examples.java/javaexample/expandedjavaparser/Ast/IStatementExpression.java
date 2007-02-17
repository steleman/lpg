//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 * is implemented by:
 *<b>
 *<ul>
 *<li>ClassInstanceCreationExpression
 *<li>MethodInvocation
 *<li>PrimaryMethodInvocation
 *<li>SuperMethodInvocation
 *<li>PostIncrementExpression
 *<li>PostDecrementExpression
 *<li>PreIncrementExpression
 *<li>PreDecrementExpression
 *<li>Assignment
 *</ul>
 *</b>
 */
public interface IStatementExpression
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
    void accept(ArgumentVisitor v, Object o);
    Object accept(ResultVisitor v);
    Object accept(ResultArgumentVisitor v, Object o);
}


