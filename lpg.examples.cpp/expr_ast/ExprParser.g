%options ast_directory=./ExprAst,automatic_ast=toplevel,variables=nt,visitor=default,states

$Terminals
    PLUS ::= +
    MULTIPLY ::= *
    LPAREN ::= (
    RPAREN ::= )
    IntegerLiteral
$end

$Rules
    E ::= E + T
            | T
    T ::= T * F
        | F
    F ::= IntegerLiteral$Number
    F$ParenExpr ::= ( E )
$End
