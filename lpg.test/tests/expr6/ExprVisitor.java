/*
 * Created on Feb 7, 2006
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package expr6;

import expr6.ExprAst.AbstractVisitor;
import expr6.ExprAst.Ast;
import expr6.ExprAst.EList;
import expr6.ExprAst.E;
import expr6.ExprAst.F;
import expr6.ExprAst.ParenExpr;
import expr6.ExprAst.T;
// import lpg.runtime.java.*;

import java.util.Stack;

public class ExprVisitor extends AbstractVisitor {

	Stack<Ast> exprStack = new Stack<Ast>();
	Stack<Integer> evalStack = new Stack<Integer>();
	
	public String visitAst(Ast ast) { 
		if (ast != null)
		{ 
			ast.accept(this);
			
			for (int j = 0; j < evalStack.size(); j++)
                System.out.println(exprStack.get(j).toString() + " = " + evalStack.get(j).toString());
            return "****Success";
		}
		else return "****No Values";
	}
	
	public void unimplementedVisitor(String s) {
	    System.out.println("unimplemented visitor \"" + s + "\"");
	}

    public boolean visit(EList expr_list) { return true; }
    public void endVisit(EList expr_list) {  }

    public boolean visit(E expr) { return true; }
    public void endVisit(E expr) 
    {
        int t = ((Integer)evalStack.pop()).intValue();
        int e = ((Integer)evalStack.pop()).intValue();
        exprStack.pop();
        exprStack.pop();
        exprStack.push(expr);
        evalStack.push(new Integer(e + t));
    }

    public boolean visit(T expr) { return true; }
    public void endVisit(T expr) 
    {
        int f = ((Integer)evalStack.pop()).intValue();
        int t = ((Integer)evalStack.pop()).intValue();
        exprStack.pop();
        exprStack.pop();
        exprStack.push(expr);
        evalStack.push(new Integer(t * f));
    }

    public boolean visit(F expr) { return true; }
    public void endVisit(F expr) 
    {
        exprStack.push(expr);
        evalStack.push(new Integer(expr.getIToken().toString()));
    }

    public boolean visit(ParenExpr expr) { return true; }
    public void endVisit(ParenExpr expr) {  }

    public Integer getValue(int i) { return (Integer)evalStack.get(i);}
}
