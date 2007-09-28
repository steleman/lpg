
$Terminals
    PLUS ::= +
    MULTIPLY ::= *
    LPAREN ::= (
    RPAREN ::= )
    IntegerLiteral ::= a
$end

$Types
    int ::= E | T | F
$End

$Rules
    E ::= E + T
        /.$BeginAction
              printf("E<%d> + T<%d>\n", E, T);
              setResult(E + T);
          $EndAction
        ./
        | T
        /.$BeginAction
              printf("T<%d>\n", T);
              setResult(T);
          $EndAction
        ./
    T ::= T * F
        /.$BeginAction
              printf("T<%d> * F<%d>\n", T, F);
              setResult(T * F);
          $EndAction
        ./
        | F
        /.$BeginAction
              printf("F<%d>\n", F);
              setResult(F);
          $EndAction
        ./
    F ::= IntegerLiteral
        /.$BeginAction
             printf("INT<%s>\n", getTokenText(1));
             setResult(atoi(getTokenText(1)));
          $EndAction
        ./
        | ( E )
        /.$BeginAction
              printf("( %d )\n", E);
              setResult(E);
          $EndAction
        ./
$End
