//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 * is implemented by:
 *<b>
 *<ul>
 *<li>ThisCall
 *<li>SuperCall
 *</ul>
 *</b>
 */
public interface IExplicitConstructorInvocationopt
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
    void accept(ArgumentVisitor v, Object o);
    Object accept(ResultVisitor v);
    Object accept(ResultArgumentVisitor v, Object o);
}


