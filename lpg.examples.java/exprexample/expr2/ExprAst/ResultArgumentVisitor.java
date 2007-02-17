package expr2.ExprAst;

public interface ResultArgumentVisitor
{
    Object visit(AstToken n, Object o);
    Object visit(E n, Object o);
    Object visit(T n, Object o);
    Object visit(F n, Object o);
    Object visit(ParenExpr n, Object o);
}

