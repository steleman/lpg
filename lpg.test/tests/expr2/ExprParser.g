%options ast_directory=./ExprAst,automatic_ast=toplevel,variables=nt,visitor=default
%options programming_language=java
%options package=expr2
%options template=dtParserTemplateF.gi
%options import_terminals=ExprLexer.gi

%Terminals
    PLUS ::= +
    MULTIPLY ::= *
    LPAREN ::= (
    RPAREN ::= )
%end

%Ast
    /.
        int value;
        public int getValue() { return value; }
        public void setValue(int value) { this.value = value; }
    ./
%End

%Rules
    E ::= E + T
        | T
    T ::= T * F
        | F
    F ::= IntegerLiteral
    F$ParenExpr ::= ( E )
%End
