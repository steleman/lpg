//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 124:  BlockStatements ::= BlockStatement
 *<li>Rule 125:  BlockStatements ::= BlockStatements BlockStatement
 *<li>Rule 324:  BlockStatementsopt ::= $Empty
 *<li>Rule 325:  BlockStatementsopt ::= BlockStatements
 *</b>
 */
public class BlockStatementList extends AstList implements IBlockStatements, IBlockStatementsopt
{
    public IBlockStatement getBlockStatementAt(int i) { return (IBlockStatement) getElementAt(i); }

    public BlockStatementList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken, leftRecursive);
        initialize();
    }

    public BlockStatementList(IBlockStatement _BlockStatement, boolean leftRecursive)
    {
        super((Ast) _BlockStatement, leftRecursive);
        ((Ast) _BlockStatement).setParent(this);
        initialize();
    }

    public void add(IBlockStatement _BlockStatement)
    {
        super.add((Ast) _BlockStatement);
        ((Ast) _BlockStatement).setParent(this);
    }

    public void accept(Visitor v) { for (int i = 0; i < size(); i++) getBlockStatementAt(i).accept(v); }
    public void accept(ArgumentVisitor v, Object o) { for (int i = 0; i < size(); i++) getBlockStatementAt(i).accept(v, o); }
    public Object accept(ResultVisitor v)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(getBlockStatementAt(i).accept(v));
        return result;
    }
    public Object accept(ResultArgumentVisitor v, Object o)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(getBlockStatementAt(i).accept(v, o));
        return result;
    }
}


