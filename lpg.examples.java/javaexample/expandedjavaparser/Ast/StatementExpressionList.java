//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 185:  ForUpdate ::= StatementExpressionList
 *<li>Rule 186:  StatementExpressionList ::= StatementExpression
 *<li>Rule 187:  StatementExpressionList ::= StatementExpressionList , StatementExpression
 *<li>Rule 340:  ForUpdateopt ::= $Empty
 *<li>Rule 341:  ForUpdateopt ::= ForUpdate
 *</b>
 */
public class StatementExpressionList extends AstList implements IForUpdate, IStatementExpressionList, IForUpdateopt
{
    public IStatementExpression getStatementExpressionAt(int i) { return (IStatementExpression) getElementAt(i); }

    public StatementExpressionList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken, leftRecursive);
        initialize();
    }

    public StatementExpressionList(IStatementExpression _StatementExpression, boolean leftRecursive)
    {
        super((Ast) _StatementExpression, leftRecursive);
        ((Ast) _StatementExpression).setParent(this);
        initialize();
    }

    public void add(IStatementExpression _StatementExpression)
    {
        super.add((Ast) _StatementExpression);
        ((Ast) _StatementExpression).setParent(this);
    }

    public void accept(Visitor v) { for (int i = 0; i < size(); i++) getStatementExpressionAt(i).accept(v); }
    public void accept(ArgumentVisitor v, Object o) { for (int i = 0; i < size(); i++) getStatementExpressionAt(i).accept(v, o); }
    public Object accept(ResultVisitor v)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(getStatementExpressionAt(i).accept(v));
        return result;
    }
    public Object accept(ResultArgumentVisitor v, Object o)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(getStatementExpressionAt(i).accept(v, o));
        return result;
    }
}


