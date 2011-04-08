--
-- The Java Lexer
--

%Options la=2
%Options fp=ExprLexer,prefix=Char_
%options single-productions
%options package=expr4
%options template=LexerTemplateF.gi
%options export_terminals=("ExprParsersym.java", "TK_")

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

%Eof
    EOF
%End

%Start
    Token
%End

%Rules

    ---------------------  Rules for Scanned Tokens --------------------------------
    -- The lexer creates an array list of tokens which is defined in the PrsStream class.
    -- A token has three attributes: a start offset, an end offset and a kind.
    -- 
    -- Only rules that produce complete tokens have actions to create token objects.
    -- When making a token, calls to the methods, $getToken(1) and $getRightSpan(), 
    -- provide the offsets (i.e. the span) of a rule's right hand side (rhs) and thus of the token.
    -- For a rule of the form A ::= A1 A2 ... An, the start offset of the rhs of A is given by
    -- getToken(1) or by getLeftToken() and the end offset by getRightToken().
    --  
    -- Regarding rules for parsing in general, note that for a rhs symbol Ai, the 
    -- method getRhsFirstToken(i) returns the location of the leftmost character derived from Ai.  
    --------------------------------------------------------------------------------
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
