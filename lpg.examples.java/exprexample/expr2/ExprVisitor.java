/*
 * Created on Aug 13, 2005
 *
 */
package expr2;

import expr2.ExprAst.*;

/**
 * @author Gerry Fisher
 *
 */
public class ExprVisitor extends AbstractVisitor
{
    public void unimplementedVisitor(String s) {
        System.out.println(s);
    }

    public void visit(E expr) 
    {
        expr.getE().accept(this);
        expr.getT().accept(this);
        expr.setValue(((Ast) expr.getE()).getValue() +
                      ((Ast) expr.getT()).getValue());
    }

    public void visit(T expr) 
    {
        expr.getT().accept(this);
        expr.getF().accept(this);
        expr.setValue(((Ast) expr.getT()).getValue() *
                      ((Ast) expr.getF()).getValue());
    }

    public void visit(F expr) 
    {
        expr.setValue(new Integer(expr.getIToken().toString()).intValue());
    }

    public void visit(ParenExpr expr)
    {
        expr.getE().accept(this);
        expr.setValue(((Ast) expr.getE()).getValue());
    }
}
