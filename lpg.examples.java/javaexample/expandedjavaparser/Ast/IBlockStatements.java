//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 * is implemented by <b>BlockStatementList</b>
 */
public interface IBlockStatements
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
    void accept(ArgumentVisitor v, Object o);
    Object accept(ResultVisitor v);
    Object accept(ResultArgumentVisitor v, Object o);
}


