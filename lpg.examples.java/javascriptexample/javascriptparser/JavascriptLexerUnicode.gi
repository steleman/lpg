--
-- ECMA Script 03/24/03
--
-- JavaScript 2.0
-- Formal Description
-- Lexical Grammar
-- 
-- Monday, November 26, 2001
-- 
-- This LALR(1) grammar describes the lexical syntax of the JavaScript 2.0 proposal.
-- See also the description of the grammar notation.
--
-- The start symbols are: NextInputElementunit if the previous input element was a
-- number; NextInputElementre if the previous input element was not a number and a
-- / should be interpreted as a regular expression; and NextInputElementdiv if the
-- previous input element was not a number and a / should be interpreted as a
-- division or division-assignment operator.
--
%options states,error_maps,list
%options fp=JavascriptLexer
--%options single-productions
%options package=javascriptparser
%options template=LexerTemplateF.gi
%options filter=JavascriptKWLexerUnicode.gi

%Define
    --
    -- Definition of macro used in the included file LexerBasicMapF.gi
    --
    $kw_lexer_class /.$JavascriptKWLexerUnicode./

%End

%Export

    SlComment
    MlComment

    NO_LINE_BREAK
    
    NegatedMinLong
    Number
    RegularExpression
    String
    VirtualSemicolon
    IDENTIFIER
    NOT
    NOT_EQUAL
    NOT_EQUAL_EQUAL
    REMAINDER
    REMAINDER_EQUAL
    AND
    AND_AND
    AND_AND_EQUAL
    AND_EQUAL
    LPAREN
    RPAREN
    MULTIPLY
    MULTIPLY_EQUAL
    PLUS
    PLUS_PLUS
    PLUS_EQUAL
    COMMA
    MINUS
    MINUS_MINUS
    MINUS_EQUAL
    PERIOD
    ETC
    SLASH
    SLASH_EQUAL
    COLON
    COLON_COLON
    SEMICOLON
    LESS
    LEFT_SHIFT
    LEFT_SHIFT_EQUAL
    LESS_EQUAL
    EQUAL
    EQUAL_EQUAL
    EQUAL_EQUAL_EQUAL
    GREATER
    GREATER_EQUAL
    RIGHT_SHIFT
    RIGHT_SHIFT_EQUAL
    UNSIGNED_RIGHT_SHIFT
    UNSIGNED_RIGHT_SHIFT_EQUAL
    QUESTION
    LBRACKET
    RBRACKET
    XOR
    XOR_EQUAL
    XOR_XOR
    XOR_XOR_EQUAL
    LBRACE
    OR
    OR_EQUAL
    OR_OR
    OR_OR_EQUAL
    RBRACE
    TWIDDLE
%End

%Terminals

    U0009 ::= HT
    U000A ::= LF
    U000B ::= VT
    U000C ::= FF
    U000D ::= CR
    Exclamation ::= '!'
    DoubleQuote ::= '"'
    DollarSign ::= '$'
    Percent ::= '%'
    Ampersand ::= '&'
    SingleQuote ::= "'"
    LeftParen ::= '('
    RightParen ::= ')'
    Star ::= '*'
    Plus ::= '+'
    Comma ::= ','
    Minus ::= '-'
    Dot ::= '.'
    Slash ::= '/'
    zero ::= '0'
    one__nine
    Colon ::= ':'
    SemiColon ::= ';'
    LessThan ::= '<'
    Equal ::= '='
    GreaterThan ::= '>'
    QuestionMark ::= '?'
    A__D
    E
    F
    L
    U
    X
    LeftBracket ::= '['
    BackSlash ::= '\'
    RightBracket ::= ']'
    Caret ::= '^'
    Underscore ::= '_'
    a
    b
    c__d
    e
    f
    l
    n
    r
    t
    u
    v
    x
    LeftBrace ::= '{'
    VerticalBar ::= '|'
    RightBrace ::= '}'
    Tilde ::= '~'
    U2028__U2029
    Generic_Lu
    Generic_Ll
    Generic_Lt
    Generic_Lm
    Generic_Lo
    Generic_Mn
    Generic_Mc
    Generic_Nd
    Generic_Nl
    Generic_Pc
    Generic_Zs
    Generic_Cn
    Illegal
%End


%Start
    NextInputElement
%End

%Headers
    /.
        private boolean no_parse_errors_detected = true;
        private PrsStream prsStream;
        private DeterministicParser parser = null;
        private int sym[] = null;
        private int ERROR_ACTION;

        private void errorDetected()
        {
            no_parse_errors_detected = false;
            parser.errorReset();
        }
        
        public void makeToken(int startLoc, int endLoc, int kind)
        {
            sym[0] = kind;
            if (parser.parse(sym, 0) == ERROR_ACTION)
            {
                int previous_token_index = prsStream.getSize() - 1;
                IToken previous_token = prsStream.getIToken(previous_token_index);
                if (prsStream.getLineNumberOfCharAt(startLoc) > previous_token.getLine())
                {
                    sym[0] = $_VirtualSemicolon;
                    if (parser.parse(sym, 0) == ERROR_ACTION)
                         errorDetected();
                    //
                    // Note that even if we can't parse the virtual semicolon, we
                    // add it to the stream to help the Error recovery program make
                    // better recovery decisions later.
                    //
                    prsStream.makeToken(previous_token.getEndOffset() + 1,
                                        previous_token.getEndOffset(),
                                        $_VirtualSemicolon);
                }
                else // assert(getLineNumberOfCharAt(startLoc) == previous_token.getLine())
                {
                    sym[0] = $_NO_LINE_BREAK;
                    sym[1] = kind; // need two lookahead tokens here!
                    if (parser.parse(sym, 0) == ERROR_ACTION)
                         errorDetected();
                    else prsStream.makeToken(previous_token.getEndOffset() + 1,
                                             previous_token.getEndOffset(),
                                             $_NO_LINE_BREAK);
                }

                sym[0] = kind;
                if (parser.parse(sym, 0) == ERROR_ACTION)
                    errorDetected();
            }
            prsStream.makeToken(startLoc, endLoc, kind);
        }
        
        public boolean lexer(Monitor monitor,
                             PrsStream prsStream,
                             DeterministicParser parser,
                             ParseTable parse_table)
        {
            LexStream lexStream = (LexStream) getILexStream();
            lexStream.setPrsStream(prsStream);

            this.parser = parser;
            this.prsStream = prsStream;
            this.ERROR_ACTION = parse_table.getErrorAction();
            this.sym = new int[parse_table.getMaxLa()];

            char [] input_chars = lexStream.getInputChars();
            if (input_chars == null)
                throw new NullPointerException("LexStream was not initialized");

            LexParser scanner = getParser();
            parser.resetParser();

            prsStream.makeToken(0, 0, 0); // Token list must start with a bad token
            
            for (int char_index = 0; 
                 char_index < input_chars.length;
                 char_index = scanner.getLastToken() + 1)
            {
                if (char_index + 1 < input_chars.length &&
                    input_chars[char_index] == '/' &&
                    input_chars[char_index + 1] != '*' &&
                    input_chars[char_index + 1] != '/')
                {
                    sym[0] = (input_chars[char_index + 1] == '='
                                   ? $_SLASH_EQUAL
                                   : $_SLASH);
                    if (parser.parse(sym, 0) != ERROR_ACTION)
                    {
                        prsStream.makeToken(char_index,
                                            (sym[0] == $_SLASH ? char_index : char_index + 1),
                                            sym[0]);
                        char_index += (sym[0] == $_SLASH ? 1 : 2);
                    }
                }

                scanner.scanNextToken(char_index);
            }

            int last_index = input_chars.length - 1;
            prsStream.makeToken(last_index, last_index - 1, parse_table.getEoftSymbol()); // and end with the end of file token
            prsStream.setStreamLength(prsStream.getSize());
            
            sym[0] = parse_table.getEoftSymbol();

            if (parser.parse(sym, 0) == ERROR_ACTION)
                errorDetected();
            
            return no_parse_errors_detected;
        }
    ./
%End

%Rules

    --
    -- Unicode Character Classes
    --
    --     WhiteSpaceCharacter ->  HT
    --                          |  VT
    --                          |  FF
    --                          |  Space
    --                          |  U00A0
    --                          |  Any other character in category Zs in the unicode Character Database
    WhiteSpaceCharacter ->  HT
                         |  VT
                         |  FF
                         |  Unicode_Zs  -- Unicode_Zs includes Space and U00A0

    LineTerminator ->  LF
                    |  CR
                    |  U2028__U2029

    --
    -- Comments
    --

    LineComment ::= '/' '/' LineCommentCharacters

    LineCommentCharacters ::=
       %Empty
    |  LineCommentCharacters NonTerminator

    --
    -- The LineBreak issue is taken care of in the parser. Thus, we do
    -- not need to distinguish between a SingleLineBlockComment and a
    -- MultiLineBlockComment
    --
    -- SingleLineBlockComment ::= '/' '*' BlockCommentCharacters '*' '/'
    --
    -- BlockCommentCharacters ::=
    --    %Empty
    -- |  BlockCommentCharacters NonTerminatorOrSlash
    -- |  PreSlashCharacters '/'
    --
    -- PreSlashCharacters ::=
    --    %Empty
    -- |  BlockCommentCharacters NonTerminatorOrAsteriskOrSlash
    -- |  PreSlashCharacters '/'
    --
    -- MultiLineBlockComment ::= '/' '*' MultiLineBlockCommentCharacters BlockCommentCharacters '*' '/'
    --
    -- MultiLineBlockCommentCharacters ::=
    --    BlockCommentCharacters LineTerminator
    -- |  MultiLineBlockCommentCharacters BlockCommentCharacters LineTerminator
    --
    -- NonTerminatorOrSlash ::= NonTerminator except '/'
    --
    -- NonTerminatorOrAsteriskOrSlash ::= NonTerminator except '*' | '/'
    --
    BlockComment ::= '/' '*' InsideComment Stars '/'

    InsideComment ::= %Empty
                    | InsideComment Stars NotSlashOrStar
                    | InsideComment '/'
                    | InsideComment NotSlashOrStar

    Stars ::= '*'
            | Stars '*'

    NotSlashOrStar -> NotStarOrSlashOrBackslashOrLineTerminatorOrQuotesOr_
                    | '\'
                    | LineTerminator
                    | '"'
                    | "'"
                    | '_'

    --
    --    UnicodeCharacter except LineTerminator
    --
    NonTerminator -> NotStarOrSlashOrBackslashOrLineTerminatorOrQuotesOr_
                   | '*'
                   | '/'
                   | '\'
                   | "'"
                   | '"'
                   | '_'

    --
    -- White Space
    --
    -- We do not need to worry about SingleLineBlockComment.
    -- Remove the null WhiteSpace choice and add treat the LineTerminators
    -- like white spaces
    --
    -- WhiteSpace ::=
    --    %Empty
    -- |  WhiteSpace WhiteSpaceCharacter
    -- |  WhiteSpace SingleLineBlockComment
    --
    --
    -- Line Breaks
    --
    -- LineBreak ::=
    --    LineTerminator
    -- |  LineComment LineTerminator
    -- |  MultiLineBlockComment
    --
    -- LineBreaks ::=
    --    LineBreak
    -- |  LineBreaks WhiteSpace LineBreak
    --
    WhiteSpace ::=
       WhiteSpaceCharacter
    |  LineTerminator
    |  WhiteSpace WhiteSpaceCharacter
    |  WhiteSpace LineTerminator

    --
    -- Input Elements
    --
    -- ? ? {re, div, unit}
    -- NextInputElementre ::= WhiteSpace InputElementre
    -- NextInputElementdiv ::= WhiteSpace InputElementdiv
    -- NextInputElementunit ::=
    --    [lookahead not in {ContinuingIdentifierCharacter, \}] WhiteSpace InputElementdiv
    -- |  [lookahead not in {_}] IdentifierName
    -- InputElementre ::=
    --    LineBreaks
    -- |  IdentifierOrKeyword
    -- |  Punctuator
    -- |  NumericLiteral
    -- |  StringLiteral
    -- |  RegExpLiteral
    -- |  EndOfInput
    -- InputElementdiv ::=
    --    LineBreaks
    -- |  IdentifierOrKeyword
    -- |  Punctuator
    -- |  DivisionPunctuator
    -- |  NumericLiteral
    -- |  StringLiteral
    -- |  EndOfInput
    -- EndOfInput ::=
    --    End
    -- |  LineComment End
    --
    NextInputElement ::=
        WhiteSpace
        /.
                    skipToken();
        ./
    |  IdentifierOrKeyword
        /.
                    checkForKeyWord();
        ./
    |  Punctuator
    |  NumericLiteral
        /.
                    makeToken($_Number);
        ./
    |  StringLiteral
        /.
                    makeToken($_String);
        ./
    |  RegExpLiteral
        /.
                    makeToken($_RegularExpression);
        ./
    |  LineComment
        /.
                    makeComment($_SlComment);
        ./
    |  BlockComment
        /.
                    makeComment($_MlComment);
        ./

    --
    -- Keywords and Identifiers
    --
    IdentifierOrKeyword -> IdentifierName

    IdentifierName ::=
       InitialIdentifierCharacterOrEscape
    |  NullEscapes InitialIdentifierCharacterOrEscape
    |  IdentifierName ContinuingIdentifierCharacterOrEscape
    |  IdentifierName NullEscape

    NullEscapes ->
       NullEscape
    |  NullEscapes NullEscape

    NullEscape ::= '\' '_'

    InitialIdentifierCharacterOrEscape ::=
       InitialIdentifierCharacter
    |  '\' HexEscape

    InitialIdentifierCharacter ::= UnicodeInitialAlphabetic | '$' | '_'

    --
    -- Any character in category Lu (uppercase letter),
    --                           Ll (lowercase letter),
    --                           Lt (titlecase letter),
    --                           Lm (modifier letter),
    --                           Lo (other letter),
    --                        or Nl (letter number) in the Unicode Character Database.
    --
    UnicodeInitialAlphabetic -> Unicode_Lu
                              | Unicode_Ll
                              | Unicode_Lt
                              | Unicode_Lm
                              | Unicode_Lo
                              | Unicode_Nl

    ContinuingIdentifierCharacterOrEscape ::=
       ContinuingIdentifierCharacter
    |  '\' HexEscape

    --
    -- ContinuingIdentifierCharacter ::= UnicodeAlphanumeric | '$' | '_'
    -- 
    -- UnicodeAlphanumeric includes Unicode_Pc which include the symbol '_'
    --
    ContinuingIdentifierCharacter -> UnicodeAlphanumeric | '$'

    -- 
    --  Any character in the category Lu (uppercase letter),
    --                                Ll (lowercase letter),
    --                                Lt (titlecase letter),
    --                                Lm (modifier letter),
    --                                Lo (other letter),
    --                                Nd (decimal number),
    --                                Nl (letter number),
    --                                Mn (non-spacing mark),
    --                                Mc (combining spacing mark),
    --                             or Pc (connector punctuation) in the Unicode Character Database.
    --
    UnicodeAlphanumeric -> Unicode_Lu
                         | Unicode_Ll
                         | Unicode_Lt
                         | Unicode_Lm
                         | Unicode_Lo
                         | Unicode_Nd
                         | Unicode_Nl
                         | Unicode_Mn
                         | Unicode_Mc
                         | Unicode_Pc

    -- Punctuators
    --

    Punctuator ::=
       '!'
        /.
                    makeToken($_NOT);
        ./
    |  '!' '='
        /.
                    makeToken($_NOT_EQUAL);
        ./
    |  '!' '=' '='
        /.
                    makeToken($_NOT_EQUAL_EQUAL);
        ./
    |  '%'
        /.
                    makeToken($_REMAINDER);
        ./
    |  '%' '='
        /.
                    makeToken($_REMAINDER_EQUAL);
        ./
    |  '&'
        /.
                    makeToken($_AND);
        ./
    |  '&' '&'
        /.
                    makeToken($_AND_AND);
        ./
    |  '&' '='
        /.
                    makeToken($_AND_EQUAL);
        ./
    |  '&' '&' '='
        /.
                    makeToken($_AND_AND_EQUAL);
        ./
    |  '('
        /.
                    makeToken($_LPAREN);
        ./
    |  ')'
        /.
                    makeToken($_RPAREN);
        ./
    |  '*'
        /.
                    makeToken($_MULTIPLY);
        ./
    |  '*' '='
        /.
                    makeToken($_MULTIPLY_EQUAL);
        ./
    |  '+'
        /.
                    makeToken($_PLUS);
        ./
    |  '+' '+'
        /.
                    makeToken($_PLUS_PLUS);
        ./
    |  '+' '='
        /.
                    makeToken($_PLUS_EQUAL);
        ./
    |  ','
        /.
                    makeToken($_COMMA);
        ./
    |  '-'
        /.
                    makeToken($_MINUS);
        ./
    |  '-' '-'
        /.
                    makeToken($_MINUS_MINUS);
        ./
    |  '-' '='
        /.
                    makeToken($_MINUS_EQUAL);
        ./
    |  '.'
        /.
                    makeToken($_PERIOD);
        ./
    |  '.' '.' '.'
        /.
                    makeToken($_ETC);
        ./
    |  ':'
        /.
                    makeToken($_COLON);
        ./
    |  ':' ':'
        /.
                    makeToken($_COLON_COLON);
        ./
    |  ';'
        /.
                    makeToken($_SEMICOLON);
        ./
    |  '<'
        /.
                    makeToken($_LESS);
        ./
    |  '<' '='
        /.
                    makeToken($_LESS_EQUAL);
        ./
    |  '<' '<'
        /.
                    makeToken($_LEFT_SHIFT);
        ./
    |  '<' '<' '='
        /.
                    makeToken($_LEFT_SHIFT_EQUAL);
        ./
    |  '='
        /.
                    makeToken($_EQUAL);
        ./
    |  '=' '='
        /.
                    makeToken($_EQUAL_EQUAL);
        ./
    |  '=' '=' '='
        /.
                    makeToken($_EQUAL_EQUAL_EQUAL);
        ./
    |  '>'
        /.
                    makeToken($_GREATER);
        ./
    |  '>' '='
        /.
                    makeToken($_GREATER_EQUAL);
        ./
    |  '>' '>'
        /.
                    makeToken($_RIGHT_SHIFT);
        ./
    |  '>' '>' '='
        /.
                    makeToken($_RIGHT_SHIFT_EQUAL);
        ./
    |  '>' '>' '>'
        /.
                    makeToken($_UNSIGNED_RIGHT_SHIFT);
        ./
    |  '>' '>' '>' '='
        /.
                    makeToken($_UNSIGNED_RIGHT_SHIFT_EQUAL);
        ./
    |  '?'
        /.
                    makeToken($_QUESTION);
        ./
    |  '['
        /.
                    makeToken($_LBRACKET);
        ./
    |  ']'
        /.
                    makeToken($_RBRACKET);
        ./
    |  '^'
        /.
                    makeToken($_XOR);
        ./
    |  '^' '='
        /.
                    makeToken($_XOR_EQUAL);
        ./
    |  '^' '^'
        /.
                    makeToken($_XOR_XOR);
        ./
    |  '^' '^' '='
        /.
                    makeToken($_XOR_XOR_EQUAL);
        ./
    |  '{'
        /.
                    makeToken($_LBRACE);
        ./
    |  '|'
        /.
                    makeToken($_OR);
        ./
    |  '|' '='
        /.
                    makeToken($_OR_EQUAL);
        ./
    |  '|' '|'
        /.
                    makeToken($_OR_OR);
        ./
    |  '|' '|' '='
        /.
                    makeToken($_OR_OR_EQUAL);
        ./
    |  '}'
        /.
                    makeToken($_RBRACE);
        ./
    |  '~'
        /.
                    makeToken($_TWIDDLE);
        ./

    -- DivisionPunctuator ::=
    --   / [lookahead not in {/, *}]
    -- |  / =
                
    --
    -- Numeric Literals
    --

    NumericLiteral ::=
       DecimalLiteral
    |  HexIntegerLiteral
    |  DecimalLiteral LetterF
    |  IntegerLiteral LetterL
    |  IntegerLiteral LetterU LetterL

    IntegerLiteral ->
       DecimalIntegerLiteral
    |  HexIntegerLiteral

    LetterF -> 'F' | 'f'

    LetterL -> 'L' | 'l'

    LetterU -> 'U' | 'u'

    DecimalLiteral ::=
       Mantissa
    |  Mantissa LetterE SignedInteger

    LetterE -> 'E' | 'e'

    Mantissa ::=
       DecimalIntegerLiteral
    |  DecimalIntegerLiteral '.'
    |  DecimalIntegerLiteral '.' Fraction
    |  '.' Fraction

    DecimalIntegerLiteral ->
       '0'
    |  NonZeroDecimalDigits

    NonZeroDecimalDigits ::=
       NonZeroDigit
    |  NonZeroDecimalDigits ASCIIDigit

    Fraction -> DecimalDigits

    SignedInteger ::=
       DecimalDigits
    |  '+' DecimalDigits
    |  '-' DecimalDigits

    DecimalDigits ::=
       ASCIIDigit
    |  DecimalDigits ASCIIDigit

    HexIntegerLiteral ::=
       '0' LetterX HexDigit
    |  HexIntegerLiteral HexDigit

    LetterX -> 'X' | 'x'

    ASCIIDigit -> '0' | one__nine
 
    NonZeroDigit -> one__nine

    HexDigit -> '0' | one__nine | A__D | 'E' | 'F' | 'a' | 'b' | c__d | 'e' | 'f'

    --
    -- String Literals
    --
    StringLiteral ::=
       "'" StringChars_single "'"
    |  '"' StringChars_double '"'

    StringChars_single ::=
       %Empty
    |  StringChars_single StringChar_single
    |  StringChars_single NullEscape

    StringChars_double ::=
       %Empty
    |  StringChars_double StringChar_double
    |  StringChars_double NullEscape

    StringChar_single ::=
       LiteralStringChar_single
    |  \ StringEscape

    StringChar_double ::=
       LiteralStringChar_double
    |  \ StringEscape

    --
    -- UnicodeCharacter except "'" | '\' | LineTerminator
    --
    LiteralStringChar_single -> NotStarOrSlashOrBackslashOrLineTerminatorOrQuotesOr_
                              | '*'
                              | '/'
                              | LineTerminator
                              | '"'
                              | '_'

    --
    -- UnicodeCharacter except '"' | '\' | LineTerminator
    --
    LiteralStringChar_double -> NotStarOrSlashOrBackslashOrLineTerminatorOrQuotesOr_
                              | '*'
                              | '/'
                              | LineTerminator
                              | "'"
                              | '_'

    --
    -- StringEscape ->
    --    ControlEscape
    -- |  ZeroEscape
    -- |  HexEscape
    -- |  IdentityEscape
    -- 
    -- ZeroEscape, ControlEscape and HexEscape are subsumed by IdentityEscape
    -- 
    -- ControlEscape ->
    --    'b'
    -- |  'f'
    -- |  'n'
    -- |  'r'
    -- |  't'
    -- |  'v'
    --
    -- ZeroEscape ::= '0' -- [lookahead not in {ASCIIDigit}]
    --
    StringEscape -> IdentityEscape

    --    
    -- NonTerminator except '_' | UnicodeAlphanumeric
    -- Note that UnicodeAlphanumeric is subsumed by NonTerminator
    -- 
    IdentityEscape -> NotStarOrSlashOrBackslashOrLineTerminatorOrQuotesOr_
                    | '*'
                    | '/'
                    | '\'
                    | "'"
                    | '"'

    HexEscape ::=
       'x' HexDigit HexDigit
    |  'u' HexDigit HexDigit HexDigit HexDigit

    --
    -- Regular Expression Literals
    --

    RegExpLiteral ::= RegExpBody RegExpFlags

    RegExpFlags ::=
       %Empty
    |  RegExpFlags ContinuingIdentifierCharacterOrEscape
    |  RegExpFlags NullEscape

    --
    -- '/' [lookahead not in {*}] RegExpChars '/'
    --
    RegExpBody ::= '/' InitialRegExpChar RegExpChars '/'

    InitialRegExpChar -> NotStarOrSlashOrBackslashOrLineTerminatorOrQuotesOr_
                       | '"'
                       | "'"
                       | '_'
                       | '\' NonTerminator
        
    RegExpChars ::=
       %Empty
    |  RegExpChars RegExpChar

    RegExpChar ::=
       OrdinaryRegExpChar
    |  '\' NonTerminator

    --
    -- NonTerminator except '\' | '/'
    --
    OrdinaryRegExpChar -> NotStarOrSlashOrBackslashOrLineTerminatorOrQuotesOr_
                        | '*'
                        | '"'
                        | "'"
                        | '_'
%End

%Rules

    NotStarOrSlashOrBackslashOrLineTerminatorOrQuotesOr_ -> Generic_Lu
                                                          | Generic_Ll
                                                          | Generic_Lt
                                                          | Generic_Lm
                                                          | Generic_Lo
                                                          | Generic_Mn
                                                          | Generic_Mc
                                                          | Generic_Nd
                                                          | Generic_Nl
                                                          | Generic_Pc
                                                          | Generic_Zs
                                                          | Generic_Cn
                                                          | HT
                                                          | VT
                                                          | FF
                                                          | '!'
                                                          | '$'
                                                          | '%'
                                                          | '&'
                                                          | '('
                                                          | ')'
                                                          | '+'
                                                          | ','
                                                          | '-'
                                                          | '.'
                                                          | '0'
                                                          | one__nine
                                                          | ':'
                                                          | ';'
                                                          | '<'
                                                          | '='
                                                          | '>'
                                                          | '?'
                                                          | A__D
                                                          | E
                                                          | F
                                                          | L
                                                          | U
                                                          | X
                                                          | '['
                                                          | ']'
                                                          | '^'
                                                          | a
                                                          | b
                                                          | c__d
                                                          | e
                                                          | f
                                                          | l
                                                          | n
                                                          | r
                                                          | t
                                                          | u
                                                          | v
                                                          | x
                                                          | '{'
                                                          | '|'
                                                          | '}'
                                                          | '~'

    Unicode_Ll -> Generic_Ll
                | a
                | b
                | c__d
                | e
                | f
                | l
                | n
                | r
                | t
                | u
                | v
                | x
    Unicode_Lm -> Generic_Lm
    Unicode_Lo -> Generic_Lo
    Unicode_Lt -> Generic_Lt
    Unicode_Lu -> Generic_Lu
                | A__D
                | E
                | F
                | L
                | U
                | X
    Unicode_Mc -> Generic_Mc
    Unicode_Mn -> Generic_Mn
    Unicode_Nd -> Generic_Nd
                | '0'
                | one__nine
    Unicode_Nl -> Generic_Nl
    Unicode_Pc -> Generic_Pc
                | '_'
    Unicode_Zs -> Generic_Zs
%End

%Headers
    /.
        //
        // The Lexer contains an array of characters as the input stream to be parsed.
        // There are methods to retrieve and classify characters.
        // The lexparser "token" is implemented simply as the index of the next character in the array.
        // The Lexer extends the abstract class LpgLexStream with an implementation of the abstract
        // method getKind.  The template defines the Lexer class and the lexer() method.
        // A driver creates the action class, "Lexer", passing an Option object to the constructor.
        //
        $kw_lexer_class kwLexer;
        private final static int ECLIPSE_TAB_VALUE = 4;

        public int [] getKeywordKinds() { return kwLexer.getKeywordKinds(); }

        public $action_type(String filename) throws java.io.IOException
        {
            this(filename, ECLIPSE_TAB_VALUE);
            this.kwLexer = new $kw_lexer_class(((LexStream) getILexStream()).getInputChars(), $_IDENTIFIER);
        }

        public void initialize(char [] content, String filename)
        {
            LexStream lexStream = (LexStream) getILexStream();
            lexStream.initialize(content, filename);
            if (this.kwLexer == null)
                 this.kwLexer = new $kw_lexer_class(lexStream.getInputChars(), $_IDENTIFIER);
            else this.kwLexer.setInputChars(lexStream.getInputChars());
        }
        
        final void makeToken(int kind)
        {
            int startOffset = getLeftSpan(),
                endOffset = getRightSpan();
            makeToken(startOffset, endOffset, kind);
        }

        final void makeComment(int kind)
        {
            int startOffset = getLeftSpan(),
                endOffset = getRightSpan();
            getILexStream().getIPrsStream().makeAdjunct(startOffset, endOffset, kind);
        }

        final void skipToken() { }
        
        final void checkForKeyWord()
        {
            int startOffset = getLeftSpan(),
                endOffset = getRightSpan(),
            kwKind = kwLexer.lexer(startOffset, endOffset);
            makeToken(startOffset, endOffset, kwKind);
        }

        //
        //
        //
        static class $super_stream_class extends LpgLexStream
        {
            //
            // Construct and initialize the XML character lookup table.
            //
            static byte tokenKind[] = new byte[0x10000]; // 0x10000 == 65536
            static
            {
                for (int i = 0x0000; i <= 0x0008; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0009] = $sym_type.$prefix$U0009;
                tokenKind[0x000A] = $sym_type.$prefix$U000A;
                tokenKind[0x000B] = $sym_type.$prefix$U000B;
                tokenKind[0x000C] = $sym_type.$prefix$U000C;
                tokenKind[0x000D] = $sym_type.$prefix$U000D;
                for (int i = 0x000E; i <= 0x001F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0020] = $sym_type.$prefix$Generic_Zs;
                tokenKind[0x0021] = $sym_type.$prefix$Exclamation;
                tokenKind[0x0022] = $sym_type.$prefix$DoubleQuote;
                tokenKind[0x0023] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0024] = $sym_type.$prefix$DollarSign;
                tokenKind[0x0025] = $sym_type.$prefix$Percent;
                tokenKind[0x0026] = $sym_type.$prefix$Ampersand;
                tokenKind[0x0027] = $sym_type.$prefix$SingleQuote;
                tokenKind[0x0028] = $sym_type.$prefix$LeftParen;
                tokenKind[0x0029] = $sym_type.$prefix$RightParen;
                tokenKind[0x002A] = $sym_type.$prefix$Star;
                tokenKind[0x002B] = $sym_type.$prefix$Plus;
                tokenKind[0x002C] = $sym_type.$prefix$Comma;
                tokenKind[0x002D] = $sym_type.$prefix$Minus;
                tokenKind[0x002E] = $sym_type.$prefix$Dot;
                tokenKind[0x002F] = $sym_type.$prefix$Slash;
                tokenKind[0x0030] = $sym_type.$prefix$zero;
                for (int i = 0x0031; i <= 0x0039; i++)
                    tokenKind[i] = $sym_type.$prefix$one__nine;
                tokenKind[0x003A] = $sym_type.$prefix$Colon;
                tokenKind[0x003B] = $sym_type.$prefix$SemiColon;
                tokenKind[0x003C] = $sym_type.$prefix$LessThan;
                tokenKind[0x003D] = $sym_type.$prefix$Equal;
                tokenKind[0x003E] = $sym_type.$prefix$GreaterThan;
                tokenKind[0x003F] = $sym_type.$prefix$QuestionMark;
                tokenKind[0x0040] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0041; i <= 0x0044; i++)
                    tokenKind[i] = $sym_type.$prefix$A__D;
                tokenKind[0x0045] = $sym_type.$prefix$E;
                tokenKind[0x0046] = $sym_type.$prefix$F;
                for (int i = 0x0047; i <= 0x004B; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x004C] = $sym_type.$prefix$L;
                for (int i = 0x004D; i <= 0x0054; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0055] = $sym_type.$prefix$U;
                tokenKind[0x0056] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0057] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0058] = $sym_type.$prefix$X;
                tokenKind[0x0059] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x005A] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x005B] = $sym_type.$prefix$LeftBracket;
                tokenKind[0x005C] = $sym_type.$prefix$BackSlash;
                tokenKind[0x005D] = $sym_type.$prefix$RightBracket;
                tokenKind[0x005E] = $sym_type.$prefix$Caret;
                tokenKind[0x005F] = $sym_type.$prefix$Underscore;
                tokenKind[0x0060] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0061] = $sym_type.$prefix$a;
                tokenKind[0x0062] = $sym_type.$prefix$b;
                tokenKind[0x0063] = $sym_type.$prefix$c__d;
                tokenKind[0x0064] = $sym_type.$prefix$c__d;
                tokenKind[0x0065] = $sym_type.$prefix$e;
                tokenKind[0x0066] = $sym_type.$prefix$f;
                for (int i = 0x0067; i <= 0x006B; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x006C] = $sym_type.$prefix$l;
                tokenKind[0x006D] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x006E] = $sym_type.$prefix$n;
                for (int i = 0x006F; i <= 0x0071; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0072] = $sym_type.$prefix$r;
                tokenKind[0x0073] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0074] = $sym_type.$prefix$t;
                tokenKind[0x0075] = $sym_type.$prefix$u;
                tokenKind[0x0076] = $sym_type.$prefix$v;
                tokenKind[0x0077] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0078] = $sym_type.$prefix$x;
                tokenKind[0x0079] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x007A] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x007B] = $sym_type.$prefix$LeftBrace;
                tokenKind[0x007C] = $sym_type.$prefix$VerticalBar;
                tokenKind[0x007D] = $sym_type.$prefix$RightBrace;
                tokenKind[0x007E] = $sym_type.$prefix$Tilde;
                for (int i = 0x007F; i <= 0x009F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x00A0] = $sym_type.$prefix$Generic_Zs;
                for (int i = 0x00A1; i <= 0x00A9; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x00AA] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x00AB; i <= 0x00B4; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x00B5] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x00B6; i <= 0x00B9; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x00BA] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x00BB; i <= 0x00BF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x00C0; i <= 0x00D6; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x00D7] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x00D8; i <= 0x00DE; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lu;
                for (int i = 0x00DF; i <= 0x00F6; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x00F7] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x00F8; i <= 0x00FF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0100] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0101] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0102] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0103] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0104] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0105] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0106] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0107] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0108] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0109] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x010A] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x010B] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x010C] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x010D] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x010E] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x010F] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0110] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0111] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0112] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0113] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0114] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0115] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0116] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0117] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0118] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0119] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x011A] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x011B] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x011C] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x011D] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x011E] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x011F] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0120] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0121] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0122] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0123] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0124] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0125] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0126] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0127] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0128] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0129] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x012A] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x012B] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x012C] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x012D] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x012E] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x012F] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0130] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0131] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0132] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0133] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0134] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0135] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0136] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0137] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0138] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0139] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x013A] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x013B] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x013C] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x013D] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x013E] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x013F] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0140] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0141] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0142] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0143] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0144] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0145] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0146] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0147] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0148] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0149] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x014A] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x014B] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x014C] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x014D] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x014E] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x014F] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0150] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0151] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0152] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0153] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0154] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0155] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0156] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0157] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0158] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0159] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x015A] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x015B] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x015C] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x015D] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x015E] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x015F] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0160] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0161] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0162] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0163] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0164] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0165] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0166] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0167] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0168] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0169] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x016A] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x016B] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x016C] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x016D] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x016E] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x016F] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0170] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0171] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0172] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0173] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0174] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0175] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0176] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0177] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0178] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0179] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x017A] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x017B] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x017C] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x017D] = $sym_type.$prefix$Generic_Lu;
                for (int i = 0x017E; i <= 0x0180; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0181] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0182] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0183] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0184] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0185] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0186] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0187] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0188] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x0189; i <= 0x018B; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x018C] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x018D] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x018E; i <= 0x0191; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0192] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0193] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0194] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0195] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x0196; i <= 0x0198; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lu;
                for (int i = 0x0199; i <= 0x019B; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x019C] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x019D] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x019E] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x019F] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01A0] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01A1] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x01A2] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01A3] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x01A4] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01A5] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x01A6] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01A7] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01A8] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x01A9] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01AA] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x01AB] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x01AC] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01AD] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x01AE] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01AF] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01B0] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x01B1; i <= 0x01B3; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01B4] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x01B5] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01B6] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x01B7] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01B8] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01B9] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x01BA] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x01BB] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x01BC] = $sym_type.$prefix$Generic_Lu;
                for (int i = 0x01BD; i <= 0x01BF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x01C0; i <= 0x01C3; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x01C4] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01C5] = $sym_type.$prefix$Generic_Lt;
                tokenKind[0x01C6] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x01C7] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01C8] = $sym_type.$prefix$Generic_Lt;
                tokenKind[0x01C9] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x01CA] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01CB] = $sym_type.$prefix$Generic_Lt;
                tokenKind[0x01CC] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x01CD] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01CE] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x01CF] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01D0] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x01D1] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01D2] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x01D3] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01D4] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x01D5] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01D6] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x01D7] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01D8] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x01D9] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01DA] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x01DB] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01DC] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x01DD] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x01DE] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01DF] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x01E0] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01E1] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x01E2] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01E3] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x01E4] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01E5] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x01E6] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01E7] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x01E8] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01E9] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x01EA] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01EB] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x01EC] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01ED] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x01EE] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01EF] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x01F0] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x01F1] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01F2] = $sym_type.$prefix$Generic_Lt;
                tokenKind[0x01F3] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x01F4] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01F5] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x01F6; i <= 0x01F8; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01F9] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x01FA] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01FB] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x01FC] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01FD] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x01FE] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x01FF] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0200] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0201] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0202] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0203] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0204] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0205] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0206] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0207] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0208] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0209] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x020A] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x020B] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x020C] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x020D] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x020E] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x020F] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0210] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0211] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0212] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0213] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0214] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0215] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0216] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0217] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0218] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0219] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x021A] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x021B] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x021C] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x021D] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x021E] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x021F] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0220] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0221] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0222] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0223] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0224] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0225] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0226] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0227] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0228] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0229] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x022A] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x022B] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x022C] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x022D] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x022E] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x022F] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0230] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0231] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0232] = $sym_type.$prefix$Generic_Lu;
                for (int i = 0x0233; i <= 0x0239; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x023A] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x023B] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x023C] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x023D] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x023E] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x023F] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0240] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0241] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0242] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x0243; i <= 0x0246; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0247] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0248] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0249] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x024A] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x024B] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x024C] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x024D] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x024E] = $sym_type.$prefix$Generic_Lu;
                for (int i = 0x024F; i <= 0x0293; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0294] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x0295; i <= 0x02AF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x02B0; i <= 0x02C1; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lm;
                for (int i = 0x02C2; i <= 0x02C5; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x02C6; i <= 0x02D1; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lm;
                for (int i = 0x02D2; i <= 0x02DF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x02E0; i <= 0x02E4; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lm;
                for (int i = 0x02E5; i <= 0x02ED; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x02EE] = $sym_type.$prefix$Generic_Lm;
                for (int i = 0x02EF; i <= 0x02FF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0300; i <= 0x036F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x0370; i <= 0x0379; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x037A] = $sym_type.$prefix$Generic_Lm;
                for (int i = 0x037B; i <= 0x037D; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x037E; i <= 0x0385; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0386] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0387] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0388; i <= 0x038A; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x038B] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x038C] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x038D] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x038E] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x038F] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0390] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x0391; i <= 0x03A1; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x03A2] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x03A3; i <= 0x03AB; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lu;
                for (int i = 0x03AC; i <= 0x03CE; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x03CF] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x03D0] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x03D1] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x03D2; i <= 0x03D4; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lu;
                for (int i = 0x03D5; i <= 0x03D7; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x03D8] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x03D9] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x03DA] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x03DB] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x03DC] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x03DD] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x03DE] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x03DF] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x03E0] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x03E1] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x03E2] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x03E3] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x03E4] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x03E5] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x03E6] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x03E7] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x03E8] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x03E9] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x03EA] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x03EB] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x03EC] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x03ED] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x03EE] = $sym_type.$prefix$Generic_Lu;
                for (int i = 0x03EF; i <= 0x03F3; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x03F4] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x03F5] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x03F6] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x03F7] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x03F8] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x03F9] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x03FA] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x03FB] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x03FC] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x03FD; i <= 0x042F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lu;
                for (int i = 0x0430; i <= 0x045F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0460] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0461] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0462] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0463] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0464] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0465] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0466] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0467] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0468] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0469] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x046A] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x046B] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x046C] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x046D] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x046E] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x046F] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0470] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0471] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0472] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0473] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0474] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0475] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0476] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0477] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0478] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0479] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x047A] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x047B] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x047C] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x047D] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x047E] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x047F] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0480] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0481] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0482] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0483; i <= 0x0486; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x0487; i <= 0x0489; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x048A] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x048B] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x048C] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x048D] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x048E] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x048F] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0490] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0491] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0492] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0493] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0494] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0495] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0496] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0497] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0498] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0499] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x049A] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x049B] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x049C] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x049D] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x049E] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x049F] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04A0] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04A1] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04A2] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04A3] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04A4] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04A5] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04A6] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04A7] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04A8] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04A9] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04AA] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04AB] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04AC] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04AD] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04AE] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04AF] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04B0] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04B1] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04B2] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04B3] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04B4] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04B5] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04B6] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04B7] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04B8] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04B9] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04BA] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04BB] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04BC] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04BD] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04BE] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04BF] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04C0] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04C1] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04C2] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04C3] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04C4] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04C5] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04C6] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04C7] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04C8] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04C9] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04CA] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04CB] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04CC] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04CD] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04CE] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04CF] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04D0] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04D1] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04D2] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04D3] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04D4] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04D5] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04D6] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04D7] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04D8] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04D9] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04DA] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04DB] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04DC] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04DD] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04DE] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04DF] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04E0] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04E1] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04E2] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04E3] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04E4] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04E5] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04E6] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04E7] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04E8] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04E9] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04EA] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04EB] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04EC] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04ED] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04EE] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04EF] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04F0] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04F1] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04F2] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04F3] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04F4] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04F5] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04F6] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04F7] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04F8] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04F9] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04FA] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04FB] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04FC] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04FD] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x04FE] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x04FF] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0500] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0501] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0502] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0503] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0504] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0505] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0506] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0507] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0508] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0509] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x050A] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x050B] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x050C] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x050D] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x050E] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x050F] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0510] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0511] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x0512] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0513] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x0514; i <= 0x0530; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0531; i <= 0x0556; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x0557] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0558] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0559] = $sym_type.$prefix$Generic_Lm;
                for (int i = 0x055A; i <= 0x0560; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0561; i <= 0x0587; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x0588; i <= 0x0590; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0591; i <= 0x05BD; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x05BE] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x05BF] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x05C0] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x05C1] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x05C2] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x05C3] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x05C4] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x05C5] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x05C6] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x05C7] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x05C8; i <= 0x05CF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x05D0; i <= 0x05EA; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x05EB; i <= 0x05EF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x05F0; i <= 0x05F2; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x05F3; i <= 0x060F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0610; i <= 0x0615; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x0616; i <= 0x0620; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0621; i <= 0x063A; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x063B; i <= 0x063F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0640] = $sym_type.$prefix$Generic_Lm;
                for (int i = 0x0641; i <= 0x064A; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x064B; i <= 0x065E; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x065F] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0660; i <= 0x0669; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Nd;
                for (int i = 0x066A; i <= 0x066D; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x066E] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x066F] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0670] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x0671; i <= 0x06D3; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x06D4] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x06D5] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x06D6; i <= 0x06DC; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x06DD] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x06DE] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x06DF; i <= 0x06E4; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x06E5] = $sym_type.$prefix$Generic_Lm;
                tokenKind[0x06E6] = $sym_type.$prefix$Generic_Lm;
                tokenKind[0x06E7] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x06E8] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x06E9] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x06EA; i <= 0x06ED; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x06EE] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x06EF] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x06F0; i <= 0x06F9; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Nd;
                for (int i = 0x06FA; i <= 0x06FC; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x06FD] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x06FE] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x06FF] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x0700; i <= 0x070F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0710] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0711] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x0712; i <= 0x072F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x0730; i <= 0x074A; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x074B] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x074C] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x074D; i <= 0x076D; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x076E; i <= 0x077F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0780; i <= 0x07A5; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x07A6; i <= 0x07B0; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x07B1] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x07B2; i <= 0x07BF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x07C0; i <= 0x07C9; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Nd;
                for (int i = 0x07CA; i <= 0x07EA; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x07EB; i <= 0x07F3; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x07F4] = $sym_type.$prefix$Generic_Lm;
                tokenKind[0x07F5] = $sym_type.$prefix$Generic_Lm;
                for (int i = 0x07F6; i <= 0x07F9; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x07FA] = $sym_type.$prefix$Generic_Lm;
                for (int i = 0x07FB; i <= 0x0900; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0901] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0902] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0903] = $sym_type.$prefix$Generic_Mc;
                for (int i = 0x0904; i <= 0x0939; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x093A] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x093B] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x093C] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x093D] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x093E; i <= 0x0940; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mc;
                for (int i = 0x0941; i <= 0x0948; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x0949; i <= 0x094C; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x094D] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x094E] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x094F] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0950] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x0951; i <= 0x0954; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x0955; i <= 0x0957; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0958; i <= 0x0961; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0962] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0963] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0964] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0965] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0966; i <= 0x096F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Nd;
                for (int i = 0x0970; i <= 0x097A; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x097B; i <= 0x097F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0980] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0981] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0982] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0983] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0984] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0985; i <= 0x098C; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x098D] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x098E] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x098F] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0990] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0991] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0992] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0993; i <= 0x09A8; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x09A9] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x09AA; i <= 0x09B0; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x09B1] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x09B2] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x09B3; i <= 0x09B5; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x09B6; i <= 0x09B9; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x09BA] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x09BB] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x09BC] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x09BD] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x09BE; i <= 0x09C0; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mc;
                for (int i = 0x09C1; i <= 0x09C4; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x09C5] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x09C6] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x09C7] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x09C8] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x09C9] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x09CA] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x09CB] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x09CC] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x09CD] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x09CE] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x09CF; i <= 0x09D6; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x09D7] = $sym_type.$prefix$Generic_Mc;
                for (int i = 0x09D8; i <= 0x09DB; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x09DC] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x09DD] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x09DE] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x09DF; i <= 0x09E1; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x09E2] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x09E3] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x09E4] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x09E5] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x09E6; i <= 0x09EF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Nd;
                tokenKind[0x09F0] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x09F1] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x09F2; i <= 0x0A00; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0A01] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0A02] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0A03] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0A04] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0A05; i <= 0x0A0A; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x0A0B; i <= 0x0A0E; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0A0F] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0A10] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0A11] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0A12] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0A13; i <= 0x0A28; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0A29] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0A2A; i <= 0x0A30; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0A31] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0A32] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0A33] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0A34] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0A35] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0A36] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0A37] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0A38] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0A39] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0A3A] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0A3B] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0A3C] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0A3D] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0A3E; i <= 0x0A40; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0A41] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0A42] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x0A43; i <= 0x0A46; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0A47] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0A48] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0A49] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0A4A] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0A4B; i <= 0x0A4D; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x0A4E; i <= 0x0A58; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0A59; i <= 0x0A5C; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0A5D] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0A5E] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x0A5F; i <= 0x0A65; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0A66; i <= 0x0A6F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Nd;
                tokenKind[0x0A70] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0A71] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x0A72; i <= 0x0A74; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x0A75; i <= 0x0A80; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0A81] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0A82] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0A83] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0A84] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0A85; i <= 0x0A8D; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0A8E] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0A8F; i <= 0x0A91; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0A92] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0A93; i <= 0x0AA8; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0AA9] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0AAA; i <= 0x0AB0; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0AB1] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0AB2] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0AB3] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0AB4] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0AB5; i <= 0x0AB9; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0ABA] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0ABB] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0ABC] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0ABD] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x0ABE; i <= 0x0AC0; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mc;
                for (int i = 0x0AC1; i <= 0x0AC5; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0AC6] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0AC7] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0AC8] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0AC9] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0ACA] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0ACB] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0ACC] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0ACD] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0ACE] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0ACF] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0AD0] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x0AD1; i <= 0x0ADF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0AE0] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0AE1] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0AE2] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0AE3] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0AE4] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0AE5] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0AE6; i <= 0x0AEF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Nd;
                for (int i = 0x0AF0; i <= 0x0B00; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0B01] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0B02] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0B03] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0B04] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0B05; i <= 0x0B0C; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0B0D] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0B0E] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0B0F] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0B10] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0B11] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0B12] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0B13; i <= 0x0B28; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0B29] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0B2A; i <= 0x0B30; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0B31] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0B32] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0B33] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0B34] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0B35; i <= 0x0B39; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0B3A] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0B3B] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0B3C] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0B3D] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0B3E] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0B3F] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0B40] = $sym_type.$prefix$Generic_Mc;
                for (int i = 0x0B41; i <= 0x0B43; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x0B44; i <= 0x0B46; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0B47] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0B48] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0B49] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0B4A] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0B4B] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0B4C] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0B4D] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x0B4E; i <= 0x0B55; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0B56] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0B57] = $sym_type.$prefix$Generic_Mc;
                for (int i = 0x0B58; i <= 0x0B5B; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0B5C] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0B5D] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0B5E] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0B5F; i <= 0x0B61; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x0B62; i <= 0x0B65; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0B66; i <= 0x0B6F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Nd;
                tokenKind[0x0B70] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0B71] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x0B72; i <= 0x0B81; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0B82] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0B83] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0B84] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0B85; i <= 0x0B8A; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x0B8B; i <= 0x0B8D; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0B8E; i <= 0x0B90; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0B91] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0B92; i <= 0x0B95; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x0B96; i <= 0x0B98; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0B99] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0B9A] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0B9B] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0B9C] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0B9D] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0B9E] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0B9F] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x0BA0; i <= 0x0BA2; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0BA3] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0BA4] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x0BA5; i <= 0x0BA7; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0BA8; i <= 0x0BAA; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x0BAB; i <= 0x0BAD; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0BAE; i <= 0x0BB9; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x0BBA; i <= 0x0BBD; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0BBE] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0BBF] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0BC0] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0BC1] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0BC2] = $sym_type.$prefix$Generic_Mc;
                for (int i = 0x0BC3; i <= 0x0BC5; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0BC6; i <= 0x0BC8; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0BC9] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0BCA; i <= 0x0BCC; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0BCD] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x0BCE; i <= 0x0BD6; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0BD7] = $sym_type.$prefix$Generic_Mc;
                for (int i = 0x0BD8; i <= 0x0BE5; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0BE6; i <= 0x0BEF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Nd;
                for (int i = 0x0BF0; i <= 0x0C00; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0C01; i <= 0x0C03; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0C04] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0C05; i <= 0x0C0C; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0C0D] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0C0E; i <= 0x0C10; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0C11] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0C12; i <= 0x0C28; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0C29] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0C2A; i <= 0x0C33; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0C34] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0C35; i <= 0x0C39; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x0C3A; i <= 0x0C3D; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0C3E; i <= 0x0C40; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x0C41; i <= 0x0C44; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0C45] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0C46; i <= 0x0C48; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0C49] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0C4A; i <= 0x0C4D; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x0C4E; i <= 0x0C54; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0C55] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0C56] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x0C57; i <= 0x0C5F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0C60] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0C61] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x0C62; i <= 0x0C65; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0C66; i <= 0x0C6F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Nd;
                for (int i = 0x0C70; i <= 0x0C81; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0C82] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0C83] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0C84] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0C85; i <= 0x0C8C; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0C8D] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0C8E; i <= 0x0C90; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0C91] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0C92; i <= 0x0CA8; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0CA9] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0CAA; i <= 0x0CB3; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0CB4] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0CB5; i <= 0x0CB9; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0CBA] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0CBB] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0CBC] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0CBD] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0CBE] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0CBF] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x0CC0; i <= 0x0CC4; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0CC5] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0CC6] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0CC7] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0CC8] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0CC9] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0CCA] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0CCB] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0CCC] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0CCD] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x0CCE; i <= 0x0CD4; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0CD5] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0CD6] = $sym_type.$prefix$Generic_Mc;
                for (int i = 0x0CD7; i <= 0x0CDD; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0CDE] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0CDF] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0CE0] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0CE1] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0CE2] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0CE3] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0CE4] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0CE5] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0CE6; i <= 0x0CEF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Nd;
                for (int i = 0x0CF0; i <= 0x0D01; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0D02] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0D03] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0D04] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0D05; i <= 0x0D0C; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0D0D] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0D0E; i <= 0x0D10; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0D11] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0D12; i <= 0x0D28; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0D29] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0D2A; i <= 0x0D39; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x0D3A; i <= 0x0D3D; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0D3E; i <= 0x0D40; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mc;
                for (int i = 0x0D41; i <= 0x0D43; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0D44] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0D45] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0D46; i <= 0x0D48; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0D49] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0D4A; i <= 0x0D4C; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0D4D] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x0D4E; i <= 0x0D56; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0D57] = $sym_type.$prefix$Generic_Mc;
                for (int i = 0x0D58; i <= 0x0D5F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0D60] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0D61] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x0D62; i <= 0x0D65; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0D66; i <= 0x0D6F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Nd;
                for (int i = 0x0D70; i <= 0x0D81; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0D82] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0D83] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0D84] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0D85; i <= 0x0D96; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x0D97; i <= 0x0D99; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0D9A; i <= 0x0DB1; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0DB2] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0DB3; i <= 0x0DBB; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0DBC] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0DBD] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0DBE] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0DBF] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0DC0; i <= 0x0DC6; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x0DC7; i <= 0x0DC9; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0DCA] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x0DCB; i <= 0x0DCE; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0DCF; i <= 0x0DD1; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mc;
                for (int i = 0x0DD2; i <= 0x0DD4; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0DD5] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0DD6] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0DD7] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0DD8; i <= 0x0DDF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mc;
                for (int i = 0x0DE0; i <= 0x0DF1; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0DF2] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0DF3] = $sym_type.$prefix$Generic_Mc;
                for (int i = 0x0DF4; i <= 0x0E00; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0E01; i <= 0x0E30; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0E31] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0E32] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0E33] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x0E34; i <= 0x0E3A; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x0E3B; i <= 0x0E3F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0E40; i <= 0x0E45; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0E46] = $sym_type.$prefix$Generic_Lm;
                for (int i = 0x0E47; i <= 0x0E4E; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0E4F] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0E50; i <= 0x0E59; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Nd;
                for (int i = 0x0E5A; i <= 0x0E80; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0E81] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0E82] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0E83] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0E84] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0E85] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0E86] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0E87] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0E88] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0E89] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0E8A] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0E8B] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0E8C] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0E8D] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x0E8E; i <= 0x0E93; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0E94; i <= 0x0E97; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0E98] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0E99; i <= 0x0E9F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0EA0] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0EA1; i <= 0x0EA3; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0EA4] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0EA5] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0EA6] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0EA7] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0EA8] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0EA9] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0EAA] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0EAB] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0EAC] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0EAD; i <= 0x0EB0; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0EB1] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0EB2] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0EB3] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x0EB4; i <= 0x0EB9; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0EBA] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0EBB] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0EBC] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0EBD] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0EBE] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0EBF] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0EC0; i <= 0x0EC4; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0EC5] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0EC6] = $sym_type.$prefix$Generic_Lm;
                tokenKind[0x0EC7] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0EC8; i <= 0x0ECD; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0ECE] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0ECF] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0ED0; i <= 0x0ED9; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Nd;
                tokenKind[0x0EDA] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0EDB] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0EDC] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0EDD] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x0EDE; i <= 0x0EFF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0F00] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x0F01; i <= 0x0F17; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0F18] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0F19] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x0F1A; i <= 0x0F1F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0F20; i <= 0x0F29; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Nd;
                for (int i = 0x0F2A; i <= 0x0F34; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0F35] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0F36] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0F37] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0F38] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0F39] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x0F3A; i <= 0x0F3D; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0F3E] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x0F3F] = $sym_type.$prefix$Generic_Mc;
                for (int i = 0x0F40; i <= 0x0F47; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x0F48] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0F49; i <= 0x0F6A; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x0F6B; i <= 0x0F70; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0F71; i <= 0x0F7E; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0F7F] = $sym_type.$prefix$Generic_Mc;
                for (int i = 0x0F80; i <= 0x0F84; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0F85] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0F86] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0F87] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x0F88; i <= 0x0F8B; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x0F8C; i <= 0x0F8F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0F90; i <= 0x0F97; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x0F98] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x0F99; i <= 0x0FBC; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x0FBD; i <= 0x0FC5; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x0FC6] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x0FC7; i <= 0x0FFF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1000; i <= 0x1021; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x1022] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1023; i <= 0x1027; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x1028] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x1029] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x102A] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x102B] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x102C] = $sym_type.$prefix$Generic_Mc;
                for (int i = 0x102D; i <= 0x1030; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x1031] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x1032] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x1033; i <= 0x1035; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x1036] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x1037] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x1038] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x1039] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x103A; i <= 0x103F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1040; i <= 0x1049; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Nd;
                for (int i = 0x104A; i <= 0x104F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1050; i <= 0x1055; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x1056] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x1057] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x1058] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x1059] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x105A; i <= 0x109F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x10A0; i <= 0x10C5; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lu;
                for (int i = 0x10C6; i <= 0x10CF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x10D0; i <= 0x10FA; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x10FB] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x10FC] = $sym_type.$prefix$Generic_Lm;
                for (int i = 0x10FD; i <= 0x10FF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1100; i <= 0x1159; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x115A; i <= 0x115E; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x115F; i <= 0x11A2; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x11A3; i <= 0x11A7; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x11A8; i <= 0x11F9; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x11FA; i <= 0x11FF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1200; i <= 0x1248; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x1249] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x124A; i <= 0x124D; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x124E] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x124F] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1250; i <= 0x1256; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x1257] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x1258] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x1259] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x125A; i <= 0x125D; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x125E] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x125F] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1260; i <= 0x1288; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x1289] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x128A; i <= 0x128D; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x128E] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x128F] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1290; i <= 0x12B0; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x12B1] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x12B2; i <= 0x12B5; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x12B6] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x12B7] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x12B8; i <= 0x12BE; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x12BF] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x12C0] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x12C1] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x12C2; i <= 0x12C5; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x12C6] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x12C7] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x12C8; i <= 0x12D6; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x12D7] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x12D8; i <= 0x1310; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x1311] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1312; i <= 0x1315; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x1316] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x1317] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1318; i <= 0x135A; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x135B; i <= 0x135E; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x135F] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x1360; i <= 0x137F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1380; i <= 0x138F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x1390; i <= 0x139F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x13A0; i <= 0x13F4; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x13F5; i <= 0x1400; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1401; i <= 0x166C; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x166D] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x166E] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x166F; i <= 0x1676; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x1677; i <= 0x167F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x1680] = $sym_type.$prefix$Generic_Zs;
                for (int i = 0x1681; i <= 0x169A; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x169B; i <= 0x169F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x16A0; i <= 0x16EA; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x16EB; i <= 0x16ED; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x16EE; i <= 0x16F0; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Nl;
                for (int i = 0x16F1; i <= 0x16FF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1700; i <= 0x170C; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x170D] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x170E; i <= 0x1711; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x1712; i <= 0x1714; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x1715; i <= 0x171F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1720; i <= 0x1731; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x1732; i <= 0x1734; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x1735; i <= 0x173F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1740; i <= 0x1751; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x1752] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x1753] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x1754; i <= 0x175F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1760; i <= 0x176C; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x176D] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x176E; i <= 0x1770; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x1771] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x1772] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x1773] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x1774; i <= 0x177F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1780; i <= 0x17B3; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x17B4] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x17B5] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x17B6] = $sym_type.$prefix$Generic_Mc;
                for (int i = 0x17B7; i <= 0x17BD; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x17BE; i <= 0x17C5; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x17C6] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x17C7] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x17C8] = $sym_type.$prefix$Generic_Mc;
                for (int i = 0x17C9; i <= 0x17D3; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x17D4; i <= 0x17D6; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x17D7] = $sym_type.$prefix$Generic_Lm;
                for (int i = 0x17D8; i <= 0x17DB; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x17DC] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x17DD] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x17DE] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x17DF] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x17E0; i <= 0x17E9; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Nd;
                for (int i = 0x17EA; i <= 0x180A; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x180B; i <= 0x180D; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x180E] = $sym_type.$prefix$Generic_Zs;
                tokenKind[0x180F] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1810; i <= 0x1819; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Nd;
                for (int i = 0x181A; i <= 0x181F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1820; i <= 0x1842; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x1843] = $sym_type.$prefix$Generic_Lm;
                for (int i = 0x1844; i <= 0x1877; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x1878; i <= 0x187F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1880; i <= 0x18A8; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x18A9] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x18AA; i <= 0x18FF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1900; i <= 0x191C; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x191D; i <= 0x191F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1920; i <= 0x1922; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x1923; i <= 0x1926; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x1927] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x1928] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x1929; i <= 0x192B; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mc;
                for (int i = 0x192C; i <= 0x192F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x1930] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x1931] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x1932] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x1933; i <= 0x1938; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mc;
                for (int i = 0x1939; i <= 0x193B; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x193C; i <= 0x1945; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1946; i <= 0x194F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Nd;
                for (int i = 0x1950; i <= 0x196D; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x196E] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x196F] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1970; i <= 0x1974; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x1975; i <= 0x197F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1980; i <= 0x19A9; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x19AA; i <= 0x19AF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x19B0; i <= 0x19C0; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mc;
                for (int i = 0x19C1; i <= 0x19C7; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x19C8] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x19C9] = $sym_type.$prefix$Generic_Mc;
                for (int i = 0x19CA; i <= 0x19CF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x19D0; i <= 0x19D9; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Nd;
                for (int i = 0x19DA; i <= 0x19FF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1A00; i <= 0x1A16; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x1A17] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x1A18] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x1A19; i <= 0x1A1B; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mc;
                for (int i = 0x1A1C; i <= 0x1AFF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1B00; i <= 0x1B03; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x1B04] = $sym_type.$prefix$Generic_Mc;
                for (int i = 0x1B05; i <= 0x1B33; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x1B34] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x1B35] = $sym_type.$prefix$Generic_Mc;
                for (int i = 0x1B36; i <= 0x1B3A; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x1B3B] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x1B3C] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x1B3D; i <= 0x1B41; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x1B42] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x1B43] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0x1B44] = $sym_type.$prefix$Generic_Mc;
                for (int i = 0x1B45; i <= 0x1B4B; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x1B4C; i <= 0x1B4F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1B50; i <= 0x1B59; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Nd;
                for (int i = 0x1B5A; i <= 0x1B6A; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1B6B; i <= 0x1B73; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x1B74; i <= 0x1CFF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1D00; i <= 0x1D2B; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x1D2C; i <= 0x1D61; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lm;
                for (int i = 0x1D62; i <= 0x1D77; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1D78] = $sym_type.$prefix$Generic_Lm;
                for (int i = 0x1D79; i <= 0x1D9A; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x1D9B; i <= 0x1DBF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lm;
                for (int i = 0x1DC0; i <= 0x1DCA; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x1DCB; i <= 0x1DFD; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x1DFE] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x1DFF] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x1E00] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E01] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E02] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E03] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E04] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E05] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E06] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E07] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E08] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E09] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E0A] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E0B] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E0C] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E0D] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E0E] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E0F] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E10] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E11] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E12] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E13] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E14] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E15] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E16] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E17] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E18] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E19] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E1A] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E1B] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E1C] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E1D] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E1E] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E1F] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E20] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E21] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E22] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E23] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E24] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E25] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E26] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E27] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E28] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E29] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E2A] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E2B] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E2C] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E2D] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E2E] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E2F] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E30] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E31] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E32] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E33] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E34] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E35] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E36] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E37] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E38] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E39] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E3A] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E3B] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E3C] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E3D] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E3E] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E3F] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E40] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E41] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E42] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E43] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E44] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E45] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E46] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E47] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E48] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E49] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E4A] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E4B] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E4C] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E4D] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E4E] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E4F] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E50] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E51] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E52] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E53] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E54] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E55] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E56] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E57] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E58] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E59] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E5A] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E5B] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E5C] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E5D] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E5E] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E5F] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E60] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E61] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E62] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E63] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E64] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E65] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E66] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E67] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E68] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E69] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E6A] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E6B] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E6C] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E6D] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E6E] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E6F] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E70] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E71] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E72] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E73] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E74] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E75] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E76] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E77] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E78] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E79] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E7A] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E7B] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E7C] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E7D] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E7E] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E7F] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E80] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E81] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E82] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E83] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E84] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E85] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E86] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E87] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E88] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E89] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E8A] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E8B] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E8C] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E8D] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E8E] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E8F] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E90] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E91] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E92] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1E93] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1E94] = $sym_type.$prefix$Generic_Lu;
                for (int i = 0x1E95; i <= 0x1E9B; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x1E9C; i <= 0x1E9F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x1EA0] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1EA1] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1EA2] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1EA3] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1EA4] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1EA5] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1EA6] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1EA7] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1EA8] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1EA9] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1EAA] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1EAB] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1EAC] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1EAD] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1EAE] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1EAF] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1EB0] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1EB1] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1EB2] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1EB3] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1EB4] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1EB5] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1EB6] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1EB7] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1EB8] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1EB9] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1EBA] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1EBB] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1EBC] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1EBD] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1EBE] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1EBF] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1EC0] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1EC1] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1EC2] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1EC3] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1EC4] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1EC5] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1EC6] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1EC7] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1EC8] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1EC9] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1ECA] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1ECB] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1ECC] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1ECD] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1ECE] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1ECF] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1ED0] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1ED1] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1ED2] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1ED3] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1ED4] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1ED5] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1ED6] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1ED7] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1ED8] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1ED9] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1EDA] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1EDB] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1EDC] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1EDD] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1EDE] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1EDF] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1EE0] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1EE1] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1EE2] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1EE3] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1EE4] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1EE5] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1EE6] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1EE7] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1EE8] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1EE9] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1EEA] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1EEB] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1EEC] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1EED] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1EEE] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1EEF] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1EF0] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1EF1] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1EF2] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1EF3] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1EF4] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1EF5] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1EF6] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1EF7] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1EF8] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1EF9] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x1EFA; i <= 0x1EFF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1F00; i <= 0x1F07; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x1F08; i <= 0x1F0F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lu;
                for (int i = 0x1F10; i <= 0x1F15; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1F16] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x1F17] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1F18; i <= 0x1F1D; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1F1E] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x1F1F] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1F20; i <= 0x1F27; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x1F28; i <= 0x1F2F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lu;
                for (int i = 0x1F30; i <= 0x1F37; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x1F38; i <= 0x1F3F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lu;
                for (int i = 0x1F40; i <= 0x1F45; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1F46] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x1F47] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1F48; i <= 0x1F4D; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1F4E] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x1F4F] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1F50; i <= 0x1F57; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1F58] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x1F59] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1F5A] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x1F5B] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1F5C] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x1F5D] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1F5E] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x1F5F] = $sym_type.$prefix$Generic_Lu;
                for (int i = 0x1F60; i <= 0x1F67; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x1F68; i <= 0x1F6F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lu;
                for (int i = 0x1F70; i <= 0x1F7D; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1F7E] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x1F7F] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1F80; i <= 0x1F87; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x1F88; i <= 0x1F8F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lt;
                for (int i = 0x1F90; i <= 0x1F97; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x1F98; i <= 0x1F9F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lt;
                for (int i = 0x1FA0; i <= 0x1FA7; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x1FA8; i <= 0x1FAF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lt;
                for (int i = 0x1FB0; i <= 0x1FB4; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1FB5] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x1FB6] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1FB7] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x1FB8; i <= 0x1FBB; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1FBC] = $sym_type.$prefix$Generic_Lt;
                tokenKind[0x1FBD] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x1FBE] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x1FBF; i <= 0x1FC1; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1FC2; i <= 0x1FC4; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1FC5] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x1FC6] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1FC7] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x1FC8; i <= 0x1FCB; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1FCC] = $sym_type.$prefix$Generic_Lt;
                for (int i = 0x1FCD; i <= 0x1FCF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1FD0; i <= 0x1FD3; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1FD4] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x1FD5] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x1FD6] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1FD7] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x1FD8; i <= 0x1FDB; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lu;
                for (int i = 0x1FDC; i <= 0x1FDF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1FE0; i <= 0x1FE7; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x1FE8; i <= 0x1FEC; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lu;
                for (int i = 0x1FED; i <= 0x1FF1; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x1FF2; i <= 0x1FF4; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1FF5] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x1FF6] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x1FF7] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x1FF8; i <= 0x1FFB; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x1FFC] = $sym_type.$prefix$Generic_Lt;
                for (int i = 0x1FFD; i <= 0x1FFF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x2000; i <= 0x200A; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Zs;
                for (int i = 0x200B; i <= 0x2027; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x2028] = $sym_type.$prefix$U2028__U2029;
                tokenKind[0x2029] = $sym_type.$prefix$U2028__U2029;
                for (int i = 0x202A; i <= 0x202E; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x202F] = $sym_type.$prefix$Generic_Zs;
                for (int i = 0x2030; i <= 0x203E; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x203F] = $sym_type.$prefix$Generic_Pc;
                tokenKind[0x2040] = $sym_type.$prefix$Generic_Pc;
                for (int i = 0x2041; i <= 0x2053; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x2054] = $sym_type.$prefix$Generic_Pc;
                for (int i = 0x2055; i <= 0x205E; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x205F] = $sym_type.$prefix$Generic_Zs;
                for (int i = 0x2060; i <= 0x2070; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x2071] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x2072; i <= 0x207E; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x207F] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x2080; i <= 0x208F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x2090; i <= 0x2094; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lm;
                for (int i = 0x2095; i <= 0x20CF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x20D0; i <= 0x20DC; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x20DD; i <= 0x20E0; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x20E1] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x20E2; i <= 0x20E4; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x20E5; i <= 0x20EF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0x20F0; i <= 0x2101; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x2102] = $sym_type.$prefix$Generic_Lu;
                for (int i = 0x2103; i <= 0x2106; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x2107] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2108] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x2109] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x210A] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x210B; i <= 0x210D; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x210E] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x210F] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x2110; i <= 0x2112; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2113] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2114] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x2115] = $sym_type.$prefix$Generic_Lu;
                for (int i = 0x2116; i <= 0x2118; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x2119; i <= 0x211D; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lu;
                for (int i = 0x211E; i <= 0x2123; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x2124] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2125] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x2126] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2127] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x2128] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2129] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x212A; i <= 0x212D; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x212E] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x212F] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x2130; i <= 0x2133; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2134] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x2135; i <= 0x2138; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x2139] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x213A] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x213B] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x213C] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x213D] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x213E] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x213F] = $sym_type.$prefix$Generic_Lu;
                for (int i = 0x2140; i <= 0x2144; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x2145] = $sym_type.$prefix$Generic_Lu;
                for (int i = 0x2146; i <= 0x2149; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x214A; i <= 0x214D; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x214E] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x214F; i <= 0x215F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x2160; i <= 0x2182; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Nl;
                tokenKind[0x2183] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2184] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x2185; i <= 0x2BFF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x2C00; i <= 0x2C2E; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2C2F] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x2C30; i <= 0x2C5E; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2C5F] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x2C60] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2C61] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x2C62; i <= 0x2C64; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2C65] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2C66] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2C67] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2C68] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2C69] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2C6A] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2C6B] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2C6C] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x2C6D; i <= 0x2C73; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x2C74] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2C75] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2C76] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2C77] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x2C78; i <= 0x2C7F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x2C80] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2C81] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2C82] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2C83] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2C84] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2C85] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2C86] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2C87] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2C88] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2C89] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2C8A] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2C8B] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2C8C] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2C8D] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2C8E] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2C8F] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2C90] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2C91] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2C92] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2C93] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2C94] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2C95] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2C96] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2C97] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2C98] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2C99] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2C9A] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2C9B] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2C9C] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2C9D] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2C9E] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2C9F] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2CA0] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2CA1] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2CA2] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2CA3] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2CA4] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2CA5] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2CA6] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2CA7] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2CA8] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2CA9] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2CAA] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2CAB] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2CAC] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2CAD] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2CAE] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2CAF] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2CB0] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2CB1] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2CB2] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2CB3] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2CB4] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2CB5] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2CB6] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2CB7] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2CB8] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2CB9] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2CBA] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2CBB] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2CBC] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2CBD] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2CBE] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2CBF] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2CC0] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2CC1] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2CC2] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2CC3] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2CC4] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2CC5] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2CC6] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2CC7] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2CC8] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2CC9] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2CCA] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2CCB] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2CCC] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2CCD] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2CCE] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2CCF] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2CD0] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2CD1] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2CD2] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2CD3] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2CD4] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2CD5] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2CD6] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2CD7] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2CD8] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2CD9] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2CDA] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2CDB] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2CDC] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2CDD] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2CDE] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2CDF] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2CE0] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2CE1] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2CE2] = $sym_type.$prefix$Generic_Lu;
                tokenKind[0x2CE3] = $sym_type.$prefix$Generic_Ll;
                tokenKind[0x2CE4] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x2CE5; i <= 0x2CFF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x2D00; i <= 0x2D25; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0x2D26; i <= 0x2D2F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x2D30; i <= 0x2D65; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x2D66; i <= 0x2D6E; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x2D6F] = $sym_type.$prefix$Generic_Lm;
                for (int i = 0x2D70; i <= 0x2D7F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x2D80; i <= 0x2D96; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x2D97; i <= 0x2D9F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x2DA0; i <= 0x2DA6; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x2DA7] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x2DA8; i <= 0x2DAE; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x2DAF] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x2DB0; i <= 0x2DB6; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x2DB7] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x2DB8; i <= 0x2DBE; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x2DBF] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x2DC0; i <= 0x2DC6; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x2DC7] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x2DC8; i <= 0x2DCE; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x2DCF] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x2DD0; i <= 0x2DD6; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x2DD7] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x2DD8; i <= 0x2DDE; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x2DDF; i <= 0x2FFF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x3000] = $sym_type.$prefix$Generic_Zs;
                for (int i = 0x3001; i <= 0x3004; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x3005] = $sym_type.$prefix$Generic_Lm;
                tokenKind[0x3006] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x3007] = $sym_type.$prefix$Generic_Nl;
                for (int i = 0x3008; i <= 0x3020; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x3021; i <= 0x3029; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Nl;
                for (int i = 0x302A; i <= 0x302F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x3030] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x3031; i <= 0x3035; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lm;
                tokenKind[0x3036] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x3037] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x3038; i <= 0x303A; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Nl;
                tokenKind[0x303B] = $sym_type.$prefix$Generic_Lm;
                tokenKind[0x303C] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x303D; i <= 0x3040; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x3041; i <= 0x3096; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x3097] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x3098] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x3099] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x309A] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0x309B] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x309C] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x309D] = $sym_type.$prefix$Generic_Lm;
                tokenKind[0x309E] = $sym_type.$prefix$Generic_Lm;
                tokenKind[0x309F] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x30A0] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x30A1; i <= 0x30FA; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0x30FB] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x30FC; i <= 0x30FE; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lm;
                tokenKind[0x30FF] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x3100; i <= 0x3104; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x3105; i <= 0x312C; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x312D; i <= 0x3130; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x3131; i <= 0x318E; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x318F; i <= 0x319F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x31A0; i <= 0x31B7; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x31B8; i <= 0x31EF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0x31F0; i <= 0x31FF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x3200; i <= 0x33FF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x3400] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x3401; i <= 0x4DB4; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x4DB5] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x4DB6; i <= 0x4DFF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x4E00] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x4E01; i <= 0x9FBA; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0x9FBB] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0x9FBC; i <= 0x9FFF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0xA000; i <= 0xA014; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0xA015] = $sym_type.$prefix$Generic_Lm;
                for (int i = 0xA016; i <= 0xA48C; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0xA48D; i <= 0xA716; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0xA717; i <= 0xA71A; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lm;
                for (int i = 0xA71B; i <= 0xA7FF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0xA800] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0xA801] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0xA802] = $sym_type.$prefix$Generic_Mc;
                for (int i = 0xA803; i <= 0xA805; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0xA806] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0xA807; i <= 0xA80A; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0xA80B] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0xA80C; i <= 0xA822; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0xA823] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0xA824] = $sym_type.$prefix$Generic_Mc;
                tokenKind[0xA825] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0xA826] = $sym_type.$prefix$Generic_Mn;
                tokenKind[0xA827] = $sym_type.$prefix$Generic_Mc;
                for (int i = 0xA828; i <= 0xA83F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0xA840; i <= 0xA873; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0xA874; i <= 0xABFF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0xAC00] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0xAC01; i <= 0xD7A2; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0xD7A3] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0xD7A4; i <= 0xF8FF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0xF900; i <= 0xFA2D; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0xFA2E] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0xFA2F] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0xFA30; i <= 0xFA6A; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0xFA6B; i <= 0xFA6F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0xFA70; i <= 0xFAD9; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0xFADA; i <= 0xFAFF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0xFB00; i <= 0xFB06; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0xFB07; i <= 0xFB12; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0xFB13; i <= 0xFB17; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0xFB18; i <= 0xFB1C; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0xFB1D] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0xFB1E] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0xFB1F; i <= 0xFB28; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0xFB29] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0xFB2A; i <= 0xFB36; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0xFB37] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0xFB38; i <= 0xFB3C; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0xFB3D] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0xFB3E] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0xFB3F] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0xFB40] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0xFB41] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0xFB42] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0xFB43] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0xFB44] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0xFB45] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0xFB46; i <= 0xFBB1; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0xFBB2; i <= 0xFBD2; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0xFBD3; i <= 0xFD3D; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0xFD3E; i <= 0xFD4F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0xFD50; i <= 0xFD8F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0xFD90] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0xFD91] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0xFD92; i <= 0xFDC7; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0xFDC8; i <= 0xFDEF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0xFDF0; i <= 0xFDFB; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0xFDFC; i <= 0xFDFF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0xFE00; i <= 0xFE0F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0xFE10; i <= 0xFE1F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0xFE20; i <= 0xFE23; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Mn;
                for (int i = 0xFE24; i <= 0xFE32; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0xFE33] = $sym_type.$prefix$Generic_Pc;
                tokenKind[0xFE34] = $sym_type.$prefix$Generic_Pc;
                for (int i = 0xFE35; i <= 0xFE4C; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0xFE4D; i <= 0xFE4F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Pc;
                for (int i = 0xFE50; i <= 0xFE6F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0xFE70; i <= 0xFE74; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0xFE75] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0xFE76; i <= 0xFEFC; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0xFEFD; i <= 0xFF0F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0xFF10; i <= 0xFF19; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Nd;
                for (int i = 0xFF1A; i <= 0xFF20; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0xFF21; i <= 0xFF3A; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lu;
                for (int i = 0xFF3B; i <= 0xFF3E; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0xFF3F] = $sym_type.$prefix$Generic_Pc;
                tokenKind[0xFF40] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0xFF41; i <= 0xFF5A; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Ll;
                for (int i = 0xFF5B; i <= 0xFF65; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0xFF66; i <= 0xFF6F; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0xFF70] = $sym_type.$prefix$Generic_Lm;
                for (int i = 0xFF71; i <= 0xFF9D; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0xFF9E] = $sym_type.$prefix$Generic_Lm;
                tokenKind[0xFF9F] = $sym_type.$prefix$Generic_Lm;
                for (int i = 0xFFA0; i <= 0xFFBE; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0xFFBF; i <= 0xFFC1; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0xFFC2; i <= 0xFFC7; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0xFFC8] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0xFFC9] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0xFFCA; i <= 0xFFCF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0xFFD0] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0xFFD1] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0xFFD2; i <= 0xFFD7; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                tokenKind[0xFFD8] = $sym_type.$prefix$Generic_Cn;
                tokenKind[0xFFD9] = $sym_type.$prefix$Generic_Cn;
                for (int i = 0xFFDA; i <= 0xFFDC; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Lo;
                for (int i = 0xFFDD; i <= 0xFFFF; i++)
                    tokenKind[i] = $sym_type.$prefix$Generic_Cn;
            }

            //
            // Compute the kind of character at index i.
            //
            public final int getKind(int i)  // Classify character at ith location
            {
                return (i >= getStreamLength() ? $sym_type.$prefix$EOF : tokenKind[getCharValue(i)]);
            }

            public String[] orderedExportedSymbols() { return $exp_type.orderedTerminalSymbols; }

            public $super_stream_class(String filename, int tab) throws java.io.IOException
            {
                super(filename, tab);
            }

            public $super_stream_class(char[] input_chars, String filename, int tab)
            {
                super(input_chars, filename, tab);
            }
    
            public $super_stream_class(char[] input_chars, String filename)
            {
                this(input_chars, filename, 1);
            }
        }
    ./
%End
