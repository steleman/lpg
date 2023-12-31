--
-- The EXPR Lexer
--
%Options la=2
%options package=lpg.examples.java.expr1,verbose
%options fp=ExprLexer
%options template=LexerTemplateF.gi

%Include
    LexerVeryBasicMapF.gi
%End

%Export

    IntegerLiteral
    PLUS
    MULTIPLY
    LPAREN
    RPAREN

%End

%Terminals
    CtlCharNotWS

    LF   CR   HT   FF

    a    b    c    d    e    f    g    h    i    j    k    l    m
    n    o    p    q    r    s    t    u    v    w    x    y    z
    _

    A    B    C    D    E    F    G    H    I    J    K    L    M
    N    O    P    Q    R    S    T    U    V    W    X    Y    Z

    0    1    2    3    4    5    6    7    8    9

    AfterASCII   ::= '\u0080..\ufffe'
    Space        ::= ' '
    LF           ::= NewLine
    CR           ::= Return
    HT           ::= HorizontalTab
    FF           ::= FormFeed
    DoubleQuote  ::= '"'
    SingleQuote  ::= "'"
    Percent      ::= '%'
    VerticalBar  ::= '|'
    Exclamation  ::= '!'
    AtSign       ::= '@'
    BackQuote    ::= '`'
    Tilde        ::= '~'
    Sharp        ::= '#'
    DollarSign   ::= '$'
    Ampersand    ::= '&'
    Caret        ::= '^'
    Colon        ::= ':'
    SemiColon    ::= ';'
    BackSlash    ::= '\'
    LeftBrace    ::= '{'
    RightBrace   ::= '}'
    LeftBracket  ::= '['
    RightBracket ::= ']'
    QuestionMark ::= '?'
    Comma        ::= ','
    Dot          ::= '.'
    LessThan     ::= '<'
    GreaterThan  ::= '>'
    Plus         ::= '+'
    Minus        ::= '-'
    Slash        ::= '/'
    Star         ::= '*'
    LeftParen    ::= '('
    RightParen   ::= ')'
    Equal        ::= '='

%End

%Start
    Token
%End

%Rules
   Token ::= IntegerLiteral
        /.
                    makeToken($_IntegerLiteral);
        ./
    Token ::= '+'
        /.
                    makeToken($_PLUS);
        ./
    Token ::= '*'
        /.
                    makeToken($_MULTIPLY);
        ./
    Token ::= '('
        /.
                    makeToken($_LPAREN);
        ./

    Token ::= ')'
        /.
                    makeToken($_RPAREN);
        ./
    Token ::= WS -- White Space is scanned but not added to output vector
        /.
                    skipToken();
        ./
    IntegerLiteral -> Integer
                    | Integer LetterLl
                    | '0' LetterXx HexDigits
                    | '0' LetterXx HexDigits LetterLl

    Integer -> Digit
             | Integer Digit

    HexDigits -> HexDigit
               | HexDigits HexDigit

    Digit -> 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9

    a..f -> a | b | c | d | e | f | A | B | C | D | E | F

    HexDigit -> Digit
              | a..f

    LetterLl -> 'L'
              | 'l'

    LetterXx -> 'X'
              | 'x'

    WSChar -> Space
            | LF
            | CR
            | HT
            | FF

    WS -> WSChar
        | WS WSChar

%End
