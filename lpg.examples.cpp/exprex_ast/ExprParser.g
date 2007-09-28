%options ast_directory=./ExprAst,automatic_ast=toplevel,variables=nt,visitor=default,states

$Terminals
    PLUS ::= +
    MINUS ::= -
    MULTIPLY ::= *
    DIVISION ::= /
    LPAREN ::= (
    RPAREN ::= )
    LT ::= <
    GT ::= >
    IntegerLiteral
$end

$Rules
    E ::= E + T
      |   T
    T ::= T * F
        | F
    F ::= IntegerLiteral$Number
    F$ParenExpr ::= ( E )
    F$TPL ::= < >
            | < PLUS_OR_MINUS$PlusOrMinus IL_LIST$ILList >
    PLUS_OR_MINUS$PlusOrMinus ::= + | -
    IL_LIST$ILList$IntegerLiteral ::= IntegerLiteral$Number
                                    | IL_LIST IntegerLiteral$Number 

$End
