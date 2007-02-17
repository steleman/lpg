package lpg.examples.java.expr2.ExprAst;

public interface Visitor
{
    void visit(AstToken n);
    void visit(E n);
    void visit(T n);
    void visit(F n);
    void visit(ParenExpr n);
}

