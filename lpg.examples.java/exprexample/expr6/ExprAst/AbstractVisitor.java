package expr6.ExprAst;

public abstract class AbstractVisitor implements Visitor
{
    public abstract void unimplementedVisitor(String s);

    public boolean preVisit(Ast element) { return true; }

    public void postVisit(Ast element) {}

    public boolean visit(AstToken n) { unimplementedVisitor("visit(AstToken)"); return true; }
    public void endVisit(AstToken n) { unimplementedVisitor("endVisit(AstToken)"); }

    public boolean visit(EList n) { unimplementedVisitor("visit(EList)"); return true; }
    public void endVisit(EList n) { unimplementedVisitor("endVisit(EList)"); }

    public boolean visit(E n) { unimplementedVisitor("visit(E)"); return true; }
    public void endVisit(E n) { unimplementedVisitor("endVisit(E)"); }

    public boolean visit(T n) { unimplementedVisitor("visit(T)"); return true; }
    public void endVisit(T n) { unimplementedVisitor("endVisit(T)"); }

    public boolean visit(F n) { unimplementedVisitor("visit(F)"); return true; }
    public void endVisit(F n) { unimplementedVisitor("endVisit(F)"); }

    public boolean visit(ParenExpr n) { unimplementedVisitor("visit(ParenExpr)"); return true; }
    public void endVisit(ParenExpr n) { unimplementedVisitor("endVisit(ParenExpr)"); }
}

