package expr1.ExprAst;

public interface ArgumentVisitor
{
    void visit(AstToken n, Object o);
    void visit(E n, Object o);
    void visit(T n, Object o);
    void visit(F n, Object o);
    void visit(ParenExpr n, Object o);
}

