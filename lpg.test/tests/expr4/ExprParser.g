%options variables=nt
%options ast_type=Integer
%options programming_language=java
%options package=expr4
%options template=dtParserTemplateF.gi
%options import_terminals=ExprLexer.gi

%Terminals
    PLUS ::= +
    MULTIPLY ::= *
    LPAREN ::= (
    RPAREN ::= )
%end

%Types
    Integer ::= E | T | F
%End

%Rules
    E ::= E + T
        /.
                    setResult(new Integer(E.intValue() + T.intValue()));
        ./
        | T
    T ::= T * F
        /.
                    setResult(new Integer(T.intValue() * F.intValue()));
        ./
        | F
    F ::= IntegerLiteral$number
        /.
                    setResult(new Integer(number.toString()));
        ./
    F$ParenExpr ::= ( E )
        /.
                    setResult(E);
        ./
%End
