%options ast_directory=./ExprAst,automatic_ast=toplevel,variables=nt,visitor=default,states
%options programming_language=java
%options package=expr1
%options template=dtParserTemplateD.g
%options import_terminals=ExprLexer.g

$Terminals
    PLUS ::= +
    MULTIPLY ::= *
    LPAREN ::= (
    RPAREN ::= )
$end

$Rules
    E ::= E + T
            | T
    T ::= T * F
        | F
    F ::= IntegerLiteral$Number
    F$ParenExpr ::= ( E )
$End
