/*
 * Created on Aug 13, 2005
 *
 */
package expr5;

import expr5.ExprAst.*;
import lpg.runtime.*;

/**
 * @author Gerry Fisher
 *
 */
public class JavaVisitor extends AbstractVisitor
{
    public void unimplementedVisitor(String s) {
        System.out.println("unimplemented visitor \"" + s + "\"");
    }

    public boolean visit(E expr) { return true; }
    public void endVisit(E expr) 
    {
        expr.setValue(((Ast) expr.getE()).getValue() +
                      ((Ast) expr.getT()).getValue());
    }

    public boolean visit(T expr) { return true; }
    public void endVisit(T expr) 
    {
        expr.setValue(((Ast) expr.getT()).getValue() *
                      ((Ast) expr.getF()).getValue());
    }

    public boolean visit(F expr) { return true; }
    public void endVisit(F expr) 
    {
        expr.setValue(new Integer(expr.getIToken().toString()).intValue());
    }

    public boolean visit(ParenExpr expr) { return true; }
    public void endVisit(ParenExpr expr) 
    {
        expr.setValue(((Ast) expr.getE()).getValue());
    }
}
