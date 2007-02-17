//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 195:  Catches ::= CatchClause
 *<li>Rule 196:  Catches ::= Catches CatchClause
 *<li>Rule 344:  Catchesopt ::= $Empty
 *<li>Rule 345:  Catchesopt ::= Catches
 *</b>
 */
public class CatchClauseList extends AstList implements ICatches, ICatchesopt
{
    public CatchClause getCatchClauseAt(int i) { return (CatchClause) getElementAt(i); }

    public CatchClauseList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken, leftRecursive);
        initialize();
    }

    public CatchClauseList(CatchClause _CatchClause, boolean leftRecursive)
    {
        super((Ast) _CatchClause, leftRecursive);
        ((Ast) _CatchClause).setParent(this);
        initialize();
    }

    public void add(CatchClause _CatchClause)
    {
        super.add((Ast) _CatchClause);
        ((Ast) _CatchClause).setParent(this);
    }

    public void accept(Visitor v) { for (int i = 0; i < size(); i++) v.visit(getCatchClauseAt(i)); }
    public void accept(ArgumentVisitor v, Object o) { for (int i = 0; i < size(); i++) v.visit(getCatchClauseAt(i), o); }
    public Object accept(ResultVisitor v)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(v.visit(getCatchClauseAt(i)));
        return result;
    }
    public Object accept(ResultArgumentVisitor v, Object o)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(v.visit(getCatchClauseAt(i), o));
        return result;
    }
}


