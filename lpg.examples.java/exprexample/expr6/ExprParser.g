%options ast_directory=./ExprAst,automatic_ast=toplevel,variables=nt,visitor=preorder
%options fp=ExprParser,prefix=TK_
%options programming_language=java
%options package=expr6
%options template=dtParserTemplateD.g
%options import_terminals=ExprLexer.g

$Terminals
    PLUS     ::= +
    MULTIPLY ::= *
    LPAREN   ::= (
    RPAREN   ::= )
    COMMA    ::= ,
$end

$Rules
    EL$$E ::= E
            | EL , E

    E ::= E + T
        | T

    T ::= T * F
        | F

    F ::= IntegerLiteral

    F$ParenExpr ::= ( E )
$End
