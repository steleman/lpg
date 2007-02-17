package lpg.examples.java.expr1.ExprAst;

public abstract class AbstractVisitor implements Visitor, ArgumentVisitor
{
    public abstract void unimplementedVisitor(String s);

    public void visit(AstToken n) { unimplementedVisitor("visit(AstToken)"); }
    public void visit(AstToken n, Object o) { unimplementedVisitor("visit(AstToken, Object)"); }

    public void visit(E n) { unimplementedVisitor("visit(E)"); }
    public void visit(E n, Object o) { unimplementedVisitor("visit(E, Object)"); }

    public void visit(T n) { unimplementedVisitor("visit(T)"); }
    public void visit(T n, Object o) { unimplementedVisitor("visit(T, Object)"); }

    public void visit(F n) { unimplementedVisitor("visit(F)"); }
    public void visit(F n, Object o) { unimplementedVisitor("visit(F, Object)"); }

    public void visit(ParenExpr n) { unimplementedVisitor("visit(ParenExpr)"); }
    public void visit(ParenExpr n, Object o) { unimplementedVisitor("visit(ParenExpr, Object)"); }
}

