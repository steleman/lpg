package lpg.examples.java.expr1.ExprAst;

public interface ResultVisitor
{
    Object visit(AstToken n);
    Object visit(E n);
    Object visit(T n);
    Object visit(F n);
    Object visit(ParenExpr n);
}

