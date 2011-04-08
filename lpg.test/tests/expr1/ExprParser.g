%options ast_directory=./ExprAst,automatic_ast=toplevel,variables=nt,visitor=default,states
%options programming_language=java
%options package=expr1
%options template=dtParserTemplateF.gi
%options import_terminals=ExprLexer.gi

%Terminals
    PLUS ::= +
    MULTIPLY ::= *
    LPAREN ::= (
    RPAREN ::= )
%end

%Rules
    E ::= E + T
            | T
    T ::= T * F
        | F
    F ::= IntegerLiteral$Number
    F$ParenExpr ::= ( E )
%End
