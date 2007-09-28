struct MyVisitor : public Visitor
{
    int nspc_;
    MyVisitor() : nspc_(0) {}

    void indent()     { nspc_ += 4; }
    void unindent()   { nspc_ -= 4; }
    void put_indent() { for(int i=0; i < nspc_; i++) printf(" "); }

    virtual void visit(AstToken* expr)
    {
    }

    virtual void visit(E* expr)
    {
        put_indent(); printf("E(\n");
        indent();
        expr->getE()->accept(this);
        expr->getT()->accept(this);
        unindent();

        expr->setValue(dynamic_cast<Ast*>(expr->getE())->getValue() +
                       dynamic_cast<Ast*>(expr->getT())->getValue());
        put_indent(); printf(")[%d]\n", expr->getValue());
    }

    virtual void visit(T* expr)
    {
        put_indent(); printf("T(\n");
        indent();
        expr->getT()->accept(this);
        expr->getF()->accept(this);
        unindent();

        expr->setValue(dynamic_cast<Ast*>(expr->getT())->getValue() *
                       dynamic_cast<Ast*>(expr->getF())->getValue());
        put_indent(); printf(")[%d]\n", expr->getValue());
    }

    virtual void visit(F* expr)
    {
        put_indent(); printf("F");
        expr->setValue(atoi(expr->getIToken()->toString()));
        printf("[%d]\n", expr->getValue());
    }

    virtual void visit(ParenExpr* expr)
    {
        put_indent(); printf("Paren(\n");

        indent();
        expr->getE()->accept(this);
        unindent();

        expr->setValue(dynamic_cast<Ast*>(expr->getE())->getValue());
        put_indent(); printf(")[%d]\n", expr->getValue());
    }
};
