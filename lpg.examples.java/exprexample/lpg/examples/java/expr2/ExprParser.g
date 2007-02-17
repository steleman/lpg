%options ast_directory=./ExprAst,automatic_ast=toplevel,variables=nt,visitor=default
%options programming_language=java
%options package=lpg.examples.java.expr2
%options template=dtParserTemplateD.g
%options import_terminals=ExprLexer.g

$Terminals
    PLUS ::= +
    MULTIPLY ::= *
    LPAREN ::= (
    RPAREN ::= )
$end

$Ast
    /.
        int value;
        public int getValue() { return value; }
        public void setValue(int value) { this.value = value; }
    ./
$End

$Rules
    E ::= E + T
        | T
    T ::= T * F
        | F
    F ::= IntegerLiteral
    F$ParenExpr ::= ( E )
$End
