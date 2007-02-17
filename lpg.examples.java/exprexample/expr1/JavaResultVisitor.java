/*
 * Created on Aug 13, 2005
 *
 */
package expr1;

import expr1.ExprAst.*;

/**
 * @author Gerry Fisher
 *
 */
public class JavaResultVisitor extends AbstractResultVisitor
{
    public Object unimplementedVisitor(String s) {
        System.out.println(s);
        return null;
    }

    public Object visit(E expr) 
    {
        Integer left = (Integer) expr.getE().accept(this),
                right = (Integer) expr.getT().accept(this);
        return new Integer(left.intValue() + right.intValue());
    }

    public Object visit(T expr) 
    {
        Integer left = (Integer) expr.getT().accept(this),
                right = (Integer) expr.getF().accept(this);
        return new Integer(left.intValue() * right.intValue());
    }

    public Object visit(F expr)
    {
        return new Integer(expr.getNumber().toString());
    }

    public Object visit(ParenExpr expr)
    {
        return (Integer) expr.getE().accept(this);
    }
}
