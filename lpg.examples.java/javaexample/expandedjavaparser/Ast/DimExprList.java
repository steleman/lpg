//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 219:  DimExprs ::= DimExpr
 *<li>Rule 220:  DimExprs ::= DimExprs DimExpr
 *</b>
 */
public class DimExprList extends AstList implements IDimExprs
{
    public DimExpr getDimExprAt(int i) { return (DimExpr) getElementAt(i); }

    public DimExprList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken, leftRecursive);
        initialize();
    }

    public DimExprList(DimExpr _DimExpr, boolean leftRecursive)
    {
        super((Ast) _DimExpr, leftRecursive);
        ((Ast) _DimExpr).setParent(this);
        initialize();
    }

    public void add(DimExpr _DimExpr)
    {
        super.add((Ast) _DimExpr);
        ((Ast) _DimExpr).setParent(this);
    }

    public void accept(Visitor v) { for (int i = 0; i < size(); i++) v.visit(getDimExprAt(i)); }
    public void accept(ArgumentVisitor v, Object o) { for (int i = 0; i < size(); i++) v.visit(getDimExprAt(i), o); }
    public Object accept(ResultVisitor v)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(v.visit(getDimExprAt(i)));
        return result;
    }
    public Object accept(ResultArgumentVisitor v, Object o)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(v.visit(getDimExprAt(i), o));
        return result;
    }
}


