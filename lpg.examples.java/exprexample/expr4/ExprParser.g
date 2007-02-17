%options variables=nt
%options ast_type=Integer
%options programming_language=java
%options package=expr4
%options template=dtParserTemplateE.g
%options import_terminals=ExprLexer.g

$Terminals
    PLUS ::= +
    MULTIPLY ::= *
    LPAREN ::= (
    RPAREN ::= )
$end

$Types
    Integer ::= E | T | F
$End

$Rules
    E ::= E + T
        /.$BeginJava
                    setResult(new Integer(E.intValue() + T.intValue()));
          $EndJava
        ./
        | T
    T ::= T * F
        /.$BeginJava
                    setResult(new Integer(T.intValue() * F.intValue()));
          $EndJava
        ./
        | F
    F ::= IntegerLiteral$number
        /.$BeginJava
                    setResult(new Integer(number.toString()));
          $EndJava
        ./
    F$ParenExpr ::= ( E )
        /.$BeginJava
                    setResult(E);
          $EndJava
        ./
$End