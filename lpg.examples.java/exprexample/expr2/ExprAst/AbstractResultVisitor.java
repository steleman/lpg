package expr2.ExprAst;

public abstract class AbstractResultVisitor implements ResultVisitor, ResultArgumentVisitor
{
    public abstract Object unimplementedVisitor(String s);

    public Object visit(AstToken n) { return unimplementedVisitor("visit(AstToken)"); }
    public Object visit(AstToken n, Object o) { return  unimplementedVisitor("visit(AstToken, Object)"); }

    public Object visit(E n) { return unimplementedVisitor("visit(E)"); }
    public Object visit(E n, Object o) { return  unimplementedVisitor("visit(E, Object)"); }

    public Object visit(T n) { return unimplementedVisitor("visit(T)"); }
    public Object visit(T n, Object o) { return  unimplementedVisitor("visit(T, Object)"); }

    public Object visit(F n) { return unimplementedVisitor("visit(F)"); }
    public Object visit(F n, Object o) { return  unimplementedVisitor("visit(F, Object)"); }

    public Object visit(ParenExpr n) { return unimplementedVisitor("visit(ParenExpr)"); }
    public Object visit(ParenExpr n, Object o) { return  unimplementedVisitor("visit(ParenExpr, Object)"); }
}

