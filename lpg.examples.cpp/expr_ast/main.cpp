#include "ExprLexer.h"
#include "ExprParser.h"
#include "ExprAst/AstNodes.h"
#include "MyVisitor.h"

#include <assert.h>
#include <iostream>
#include <vector>
using namespace std;



int
main(int argc, char**argv)
{
    if (argc < 1) {
        return 1;
    }
    ExprLexer  lexer(argv[1]);
    ExprParser parser(&lexer);
    lexer.lexer(&parser);
    lexer.dump();
    printf("lex ok.\n\n");

    Ast* ast = (Ast*) parser.parser();
    printf("parse ok.\n");

    MyVisitor vis;
    ast->accept(&vis);
    printf("\nresult:%d\n", ast->getValue());

    return 0;
}
