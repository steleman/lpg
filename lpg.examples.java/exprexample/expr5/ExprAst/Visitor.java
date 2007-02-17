package expr5.ExprAst;

public interface Visitor
{
    boolean preVisit(Ast element);

    void postVisit(Ast element);

    boolean visit(AstToken n);
    void endVisit(AstToken n);

    boolean visit(E n);
    void endVisit(E n);

    boolean visit(T n);
    void endVisit(T n);

    boolean visit(F n);
    void endVisit(F n);

    boolean visit(ParenExpr n);
    void endVisit(ParenExpr n);
}


