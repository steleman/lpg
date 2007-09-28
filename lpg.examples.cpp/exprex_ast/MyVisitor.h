struct MyVisitor : public Visitor
{
    int nspc_;
    MyVisitor() : nspc_(0) {}

    void indent()     { nspc_ += 4; }
    void unindent()   { nspc_ -= 4; }
    void put_indent() { for(int i=0; i < nspc_; i++) printf(" "); }

    virtual void visit(AstToken* expr)
    {
        put_indent(); printf("AstToken");
        expr->setValue(atoi(expr->getIToken()->toString()));
        printf("[%d]\n", expr->getValue());
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

    virtual void visit(ParenExpr* expr)
    {
        put_indent(); printf("Paren(\n");

        indent();
        expr->getE()->accept(this);
        unindent();

        expr->setValue(dynamic_cast<Ast*>(expr->getE())->getValue());
        put_indent(); printf(")[%d]\n", expr->getValue());
    }

    virtual void visit(F* expr)
    {
        put_indent(); printf("F");
        expr->setValue(atoi(expr->getIToken()->toString()));
        printf("[%d]\n", expr->getValue());
    }

    virtual void visit(ILList* expr)
    {
    }

    virtual void visit(TPL* expr)
    {
        int value = 0, pm = 1;
        put_indent(); printf("TPL(\n");

        if (expr->getPlusOrMinus()) {
            indent();
            expr->getPlusOrMinus()->accept(this);
            unindent();
            pm = dynamic_cast<Ast*>(expr->getPlusOrMinus())->getValue();
        }
        if (expr->getILList()) {
            indent();
            expr->getILList()->accept(this);
            unindent();

            for (int i = 0; i < expr->getILList()->size(); i++) {
                AstToken* il = expr->getILList()->getIntegerLiteralAt(i);
                value += il->getValue();
            }
        }
        expr->setValue( pm * value );
        put_indent(); printf(")[%d]\n", expr->getValue());
    }

    virtual void visit(PlusOrMinus* expr)
    {
        char c = expr->getIToken()->toString()[0];
        put_indent(); printf("DTerm[%c]\n", c);
        if (c == '+') {
            expr->setValue( +1 );
        } else {
            expr->setValue( -1 );
        }
    }
};
