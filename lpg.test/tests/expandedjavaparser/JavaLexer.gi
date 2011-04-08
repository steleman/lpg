--
-- The Java Lexer
--
%Options la=2,states,list
%Options fp=JavaLexer
%options single-productions
%options package=expandedjavaparser
%options template=LexerTemplateF.gi
%options filter=JavaKWLexer.gi

%Define
    --
    -- Definition of macro used in the included file LexerBasicMapB.g
    -- This type is the type of the parser of the filter grammar
    -- JavaKWLexer.g
    --
    $kw_lexer_class /.$JavaKWLexer./

%End

%Include
    LexerBasicMapF.gi
%End

%Export

    SlComment
    MlComment
    DocComment

    IDENTIFIER
    IntegerLiteral
    LongLiteral
    FloatingPointLiteral
    DoubleLiteral
    CharacterLiteral
    StringLiteral
    PLUS_PLUS
    MINUS_MINUS
    EQUAL_EQUAL
    LESS_EQUAL
    GREATER_EQUAL
    NOT_EQUAL
    LEFT_SHIFT
    RIGHT_SHIFT
    UNSIGNED_RIGHT_SHIFT
    PLUS_EQUAL
    MINUS_EQUAL
    MULTIPLY_EQUAL
    DIVIDE_EQUAL
    AND_EQUAL
    OR_EQUAL
    XOR_EQUAL
    REMAINDER_EQUAL
    LEFT_SHIFT_EQUAL
    RIGHT_SHIFT_EQUAL
    UNSIGNED_RIGHT_SHIFT_EQUAL
    OR_OR
    AND_AND
    PLUS
    MINUS
    NOT
    REMAINDER
    XOR
    AND
    MULTIPLY
    OR
    TWIDDLE
    DIVIDE
    GREATER
    LESS
    LPAREN
    RPAREN
    LBRACE
    RBRACE
    LBRACKET
    RBRACKET
    SEMICOLON
    QUESTION
    COLON
    COMMA
    DOT
    EQUAL

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
    Token ::= Identifier
        /.
                    checkForKeyWord();
        ./
    Token ::= '"' SLBody '"'
        /.
                    makeToken($_StringLiteral);
        ./
    Token ::= "'" NotSQ "'"
        /.
                    makeToken($_CharacterLiteral);
        ./
    Token ::= IntegerLiteral
        /.
                    makeToken($_IntegerLiteral);
        ./
    Token ::= FloatingPointLiteral
        /.
                    makeToken($_FloatingPointLiteral);
        ./
    Token ::= DoubleLiteral
        /.
                    makeToken($_DoubleLiteral);
        ./
    Token ::= '/' '*' Inside Stars '/'
        /.
                    if (getILexStream().getKind(getRhsFirstTokenIndex(3)) == $sym_type.Char_Star)
                         makeComment($_DocComment);
                    else makeComment($_MlComment);
        ./
    Token ::= SLC
        /.
                    makeComment($_SlComment);
        ./
    Token ::= WS -- White Space is scanned but not added to output vector
        /.
                    skipToken();
        ./
    Token ::= '+'
        /.
                    makeToken($_PLUS);
        ./
    Token ::= '-'
        /.
                    makeToken($_MINUS);
        ./

    Token ::= '*'
        /.
                    makeToken($_MULTIPLY);
        ./

    Token ::= '/'
        /.
                    makeToken($_DIVIDE);
        ./

    Token ::= '('
        /.
                    makeToken($_LPAREN);
        ./

    Token ::= ')'
        /.
                    makeToken($_RPAREN);
        ./

    Token ::= '='
        /.
                    makeToken($_EQUAL);
        ./

    Token ::= ','
        /.
                    makeToken($_COMMA);
        ./

    Token ::= ':'
        /.
                    makeToken($_COLON);
        ./

    Token ::= ';'
        /.
                    makeToken($_SEMICOLON);
        ./

    Token ::= '^'
        /.
                    makeToken($_XOR);
        ./

    Token ::= '%'
        /.
                    makeToken($_REMAINDER);
        ./

    Token ::= '~'
        /.
                    makeToken($_TWIDDLE);
        ./

    Token ::= '|'
        /.
                    makeToken($_OR);
        ./

    Token ::= '&'
        /.
                    makeToken($_AND);
        ./

    Token ::= '<'
        /.
                    makeToken($_LESS);
        ./

    Token ::= '>'
        /.
                    makeToken($_GREATER);
        ./

    Token ::= '.'
        /.
                    makeToken($_DOT);
        ./

    Token ::= '!'
        /.
                    makeToken($_NOT);
        ./

    Token ::= '['
        /.
                    makeToken($_LBRACKET);
        ./

    Token ::= ']'
        /.
                    makeToken($_RBRACKET);
        ./

    Token ::= '{'
        /.
                    makeToken($_LBRACE);
        ./

    Token ::= '}'
        /.
                    makeToken($_RBRACE);
        ./

    Token ::= '?'
        /.
                    makeToken($_QUESTION);
        ./

    Token ::= '+' '+'
        /.
                    makeToken($_PLUS_PLUS);
        ./

    Token ::= '-' '-'
        /.
                    makeToken($_MINUS_MINUS);
        ./

    Token ::= '=' '='
        /.
                    makeToken($_EQUAL_EQUAL);
        ./

    Token ::= '<' '='
        /.
                    makeToken($_LESS_EQUAL);
        ./

    Token ::= '>' '='
        /.
                    makeToken($_GREATER_EQUAL);
        ./

    Token ::= '!' '='
        /.
                    makeToken($_NOT_EQUAL);
        ./

    Token ::= '<' '<'
        /.
                    makeToken($_LEFT_SHIFT);
        ./

    Token ::= '>' '>'
        /.
                    makeToken($_RIGHT_SHIFT);
        ./

    Token ::= '>' '>' '>'
        /.
                    makeToken($_UNSIGNED_RIGHT_SHIFT);
        ./

    Token ::= '+' '='
        /.
                    makeToken($_PLUS_EQUAL);
        ./

    Token ::= '-' '='
        /.
                    makeToken($_MINUS_EQUAL);
        ./

    Token ::= '*' '='
        /.
                    makeToken($_MULTIPLY_EQUAL);
        ./

    Token ::= '/' '='
        /.
                    makeToken($_DIVIDE_EQUAL);
        ./

    Token ::= '&' '='
        /.
                    makeToken($_AND_EQUAL);
        ./

    Token ::= '|' '='
        /.
                    makeToken($_OR_EQUAL);
        ./

    Token ::= '^' '='
        /.
                    makeToken($_XOR_EQUAL);
        ./

    Token ::= '%' '='
        /.
                    makeToken($_REMAINDER_EQUAL);
        ./

    Token ::= '<' '<' '='
        /.
                    makeToken($_LEFT_SHIFT_EQUAL);
        ./

    Token ::= '>' '>' '='
        /.
                    makeToken($_RIGHT_SHIFT_EQUAL);
        ./

    Token ::= '>' '>' '>' '='
        /.
                    makeToken($_UNSIGNED_RIGHT_SHIFT_EQUAL);
        ./

    Token ::= '|' '|'
        /.
                    makeToken($_OR_OR);
        ./

    Token ::= '&' '&'
        /.
                    makeToken($_AND_AND);
        ./

    IntegerLiteral -> Integer
                    | Integer LetterLl
                    | '0' LetterXx HexDigits
                    | '0' LetterXx HexDigits LetterLl

    DoubleLiteral -> Decimal
                   | Decimal LetterForD
                   | Decimal Exponent
                   | Decimal Exponent LetterForD
                   | Integer Exponent
                   | Integer Exponent LetterForD
                   | Integer LetterForD

    FloatingPointLiteral -> Decimal LetterForF
                          | Decimal Exponent LetterForF
                          | Integer Exponent LetterForF
                          | Integer LetterForF

    Inside ::= Inside Stars NotSlashOrStar
             | Inside '/'
             | Inside NotSlashOrStar
             | %Empty

    Stars -> '*'
           | Stars '*'

    SLC ::= '/' '/'
          | SLC NotEol

    SLBody ::= %Empty
             | SLBody NotDQ

    Integer -> Digit
             | Integer Digit

    HexDigits -> HexDigit
               | HexDigits HexDigit

    Decimal ::= '.' Integer
              | Integer '.'
              | Integer '.' Integer

    Exponent ::= LetterEe Integer
               | LetterEe '-' Integer
               | LetterEe '+' Integer

    WSChar -> Space
            | LF
            | CR
            | HT
            | FF

    Letter -> LowerCaseLetter
            | UpperCaseLetter
            | _
            | '$'
            | '\u0080..\ufffe'

    LowerCaseLetter -> a | b | c | d | e | f | g | h | i | j | k | l | m |
                       n | o | p | q | r | s | t | u | v | w | x | y | z

    UpperCaseLetter -> A | B | C | D | E | F | G | H | I | J | K | L | M |
                       N | O | P | Q | R | S | T | U | V | W | X | Y | Z

    Digit -> 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9

    OctalDigit -> 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7

    a..f -> a | b | c | d | e | f | A | B | C | D | E | F

    HexDigit -> Digit
              | a..f

    OctalDigits3 -> OctalDigit
                  | OctalDigit OctalDigit
                  | OctalDigit OctalDigit OctalDigit

    LetterForD -> 'D'
                | 'd'

    LetterForF -> 'F'
                | 'f'

    LetterLl -> 'L'
              | 'l'

    LetterEe -> 'E'
              | 'e'

    LetterXx -> 'X'
              | 'x'


    WS -> WSChar
        | WS WSChar

    Identifier -> Letter
                | Identifier Letter
                | Identifier Digit

    SpecialNotStar -> '+' | '-' | '/' | '(' | ')' | '"' | '!' | '@' | '`' | '~' |
                      '%' | '&' | '^' | ':' | ';' | "'" | '\' | '|' | '{' | '}' |
                      '[' | ']' | '?' | ',' | '.' | '<' | '>' | '=' | '#'

    SpecialNotSlash -> '+' | '-' | -- exclude the star as well
                       '(' | ')' | '"' | '!' | '@' | '`' | '~' |
                       '%' | '&' | '^' | ':' | ';' | "'" | '\' | '|' | '{' | '}' |
                       '[' | ']' | '?' | ',' | '.' | '<' | '>' | '=' | '#'

    SpecialNotDQ -> '+' | '-' | '/' | '(' | ')' | '*' | '!' | '@' | '`' | '~' |
                    '%' | '&' | '^' | ':' | ';' | "'" | '|' | '{' | '}' |
                    '[' | ']' | '?' | ',' | '.' | '<' | '>' | '=' | '#'

    SpecialNotSQ -> '+' | '-' | '*' | '(' | ')' | '"' | '!' | '@' | '`' | '~' |
                    '%' | '&' | '^' | ':' | ';' | '/' | '|' | '{' | '}' |
                    '[' | ']' | '?' | ',' | '.' | '<' | '>' | '=' | '#'

    NotSlashOrStar -> Letter
                    | Digit
                    | SpecialNotSlash
                    | WSChar

    NotEol -> Letter
            | Digit
            | Space
            | '*'
            | SpecialNotStar
            | HT
            | FF
            | CtlCharNotWS

    NotDQ -> Letter
           | Digit
           | SpecialNotDQ
           | Space
           | HT
           | FF
           | EscapeSequence
           | '\' u HexDigit HexDigit HexDigit HexDigit
           | '\' OctalDigit

    NotSQ -> Letter
           | Digit
           | SpecialNotSQ
           | Space
           | HT
           | FF
           | EscapeSequence
           | '\' u HexDigit HexDigit HexDigit HexDigit
           | '\' OctalDigits3

    EscapeSequence ::= '\' b
                     | '\' t
                     | '\' n
                     | '\' f
                     | '\' r
                     | '\' '"'
                     | '\' "'"
                     | '\' '\'
%End
