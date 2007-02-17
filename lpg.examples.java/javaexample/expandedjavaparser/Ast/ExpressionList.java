//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 214:  ArgumentList ::= Expression
 *<li>Rule 215:  ArgumentList ::= ArgumentList , Expression
 *<li>Rule 328:  ArgumentListopt ::= $Empty
 *<li>Rule 329:  ArgumentListopt ::= ArgumentList
 *</b>
 */
public class ExpressionList extends AstList implements IArgumentList, IArgumentListopt
{
    public IExpression getExpressionAt(int i) { return (IExpression) getElementAt(i); }

    public ExpressionList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken, leftRecursive);
        initialize();
    }

    public ExpressionList(IExpression _Expression, boolean leftRecursive)
    {
        super((Ast) _Expression, leftRecursive);
        ((Ast) _Expression).setParent(this);
        initialize();
    }

    public void add(IExpression _Expression)
    {
        super.add((Ast) _Expression);
        ((Ast) _Expression).setParent(this);
    }

    public void accept(Visitor v) { for (int i = 0; i < size(); i++) getExpressionAt(i).accept(v); }
    public void accept(ArgumentVisitor v, Object o) { for (int i = 0; i < size(); i++) getExpressionAt(i).accept(v, o); }
    public Object accept(ResultVisitor v)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(getExpressionAt(i).accept(v));
        return result;
    }
    public Object accept(ResultArgumentVisitor v, Object o)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(getExpressionAt(i).accept(v, o));
        return result;
    }
}


