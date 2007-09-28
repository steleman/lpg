#include "ExprLexer.h"
#include "ExprParser.h"

#include <assert.h>
#include <iostream>
using namespace std;

int
main(int argc, char** argv)
{
    if (argc < 1) {
        return 1;
    }
    ExprLexer  lexer(argv[1]);
    ExprParser parser(&lexer);
    lexer.lexer(&parser);
    lexer.dump();
    printf("lex ok.\n\n");

    int result = (int) parser.parser();
    printf("parse ok.\n");
    printf("result:%d\n", result);
    return 0;
}
