%options la=15
%options single-productions
%options template=LexerTemplate.gi
%options filter=LPGKWLexer.gi

%Globals
    /.// Hi Bob ./
%End

%Define
    $_IDENTIFIER /.$_MACRO_NAME./
    $kw_lexer_class /.LPGKWLexer./
%End

%Include
    LexerBasicMap.gi
%End

%Export
    SINGLE_LINE_COMMENT
    
    MACRO_NAME
    SYMBOL
    BLOCK
    EQUIVALENCE
    PRIORITY_EQUIVALENCE
    ARROW
    PRIORITY_ARROW
    OR_MARKER
    EQUAL
    COMMA
    LEFT_PAREN
    RIGHT_PAREN
    LEFT_BRACKET
    RIGHT_BRACKET
    SHARP
    VBAR
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

%Notice
/.
////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2011 IBM Corporation.
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html
//
//Contributors:
//    Philippe Charles (pcharles@us.ibm.com) - initial API and implementation
//    Robert M. Fuhrer (rfuhrer@watson.ibm.com)
////////////////////////////////////////////////////////////////////////////////
./
%End

%Rules
    Token ::= white /.$BeginAction skipToken(); $EndAction./
    Token ::= singleLineComment /.$BeginAction makeComment(SINGLE_LINE_COMMENT); $EndAction./

    Token ::= OptionLines
    Token ::= MacroSymbol       /.$BeginAction checkForKeyWord(); $EndAction./
    Token ::= Symbol            /.$BeginAction checkForKeyWord(SYMBOL); $EndAction./
    Token ::= Block             /.$BeginAction makeToken(BLOCK); $EndAction./
    Token ::= Equivalence       /.$BeginAction makeToken(EQUIVALENCE); $EndAction./
    Token ::= Equivalence ?     /.$BeginAction makeToken(PRIORITY_EQUIVALENCE); $EndAction./
    Token ::= '#'               /.$BeginAction makeToken(SHARP); $EndAction./
    Token ::= Arrow             /.$BeginAction makeToken(ARROW); $EndAction./
    Token ::= Arrow ?           /.$BeginAction makeToken(PRIORITY_ARROW); $EndAction./
    Token ::= '|'               /.$BeginAction makeToken(OR_MARKER); $EndAction./
    Token ::= '['               /.$BeginAction makeToken(LEFT_BRACKET); $EndAction./
    Token ::= ']'               /.$BeginAction makeToken(RIGHT_BRACKET); $EndAction./

    digit -> 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9

    aA -> a | A
    bB -> b | B
    cC -> c | C
    dD -> d | D
    eE -> e | E
    fF -> f | F
    gG -> g | G
    hH -> h | H
    iI -> i | I
    jJ -> j | J
    kK -> k | K
    lL -> l | L
    mM -> m | M
    nN -> n | N
    oO -> o | O
    pP -> p | P
    qQ -> q | Q
    rR -> r | R
    sS -> s | S
    tT -> t | T
    uU -> u | U
    vV -> v | V
    wW -> w | W
    xX -> x | X
    yY -> y | Y
    zZ -> z | Z

--  lower ::= a | b | c | d | e | f | g | h | i | j | k | l | m | n | o | p | q | r | s | t | u | v | w | x | y | z
--  upper ::= A | B | C | D | E | F | G | H | I | J | K | L | M | N | O | P | Q | R | S | T | U | V | W | X | Y | Z

    letter -> AfterASCII | '_' | aA | bB | cC | dD | eE | fF | gG | hH | iI | jJ | kK | lL | mM | nN | oO | pP | qQ | rR | sS | tT | uU | vV | wW | xX | yY | zZ

    anyNonWhiteChar -> letter | digit | special

    special -> specialNoDotOrSlash | '.' | '/'

    --    special -> '+' | '-' | '(' | ')' | '"' | '!' | '@' | '`' | '~' | '.' | '/' |
    --               '%' | '&' | '^' | ':' | ';' | "'" | '\' | '|' | '{' | '}' |
    --               '[' | ']' | '?' | ',' | '<' | '>' | '=' | '#' | '*' | '$'

    specialNoExclamationDotColonDollar -> '+' | '-' | '(' | ')' | '"' | '@' | '`' | '~' | '/' |
                                          '%' | '&' | '^' | ';' | "'" | '\' | '|' | '{' | '}' |
                                          '[' | ']' | '?' | ',' | '<' | '>' | '=' | '#' | '*'

    specialNoColonDollar -> '+' | '-' | '(' | ')' | '"' | '!' | '@' | '`' | '~' | '.' | '/' |
                            '%' | '&' | '^' | ';' | "'" | '\' | '|' | '{' | '}' |
                            '[' | ']' | '?' | ',' | '<' | '>' | '=' | '#' | '*'

    specialNoEqualDollar -> '+' | '-' | '(' | ')' | '"' | '!' | '@' | '`' | '~' | '.' | '/' |
                            '%' | '&' | '^' | ':' | ';' | "'" | '\' | '|' | '{' | '}' |
                            '[' | ']' | '?' | ',' | '<' | '>' | '#' | '*'

    specialNoQuestionDollar -> '+' | '-' | '(' | ')' | '"' | '!' | '@' | '`' | '~' | '.' | '/' |
                               '%' | '&' | '^' | ':' | ';' | "'" | '\' | '|' | '{' | '}' |
                               '[' | ']' | ',' | '<' | '>' | '=' | '#' | '*'

    specialNoMinusRightAngleDollar -> '+' | '(' | ')' | '!' | '@' | '`' | '~' | '.' | '/' |
                                      '%' | '&' | '^' | ':' | ';' | '"' | '\' | '|' | '{' | '}' |
                                      '[' | ']' | '?' | ',' | '<' | "'" | '=' | '#' | '*' | '$'

    specialNoDollar -> '+' | '-' | '(' | ')' | '"' | '!' | '@' | '`' | '~' | '.' | '/' |
                       '%' | '&' | '^' | ':' | ';' | "'" | '\' | '|' | '{' | '}' |
                       '[' | ']' | '?' | ',' | '<' | '>' | '=' | '#' | '*'

    specialNoDollarBracketSharp -> '+' | '-' | '(' | ')' | '"' | '!' | '@' | '`' | '~' | '.' | '/' |
                       '%' | '&' | '^' | ':' | ';' | "'" | '\' | '|' | '{' | '}' |
                       '?' | ',' | '<' | '>' | '=' | '*'

    specialNoDotOrSlash -> '+' | '-' | '(' | ')' | '"' | '!' | '@' | '`' | '~' |
                           '%' | '&' | '^' | ':' | ';' | "'" | '\' | '|' | '{' | '}' |
                           '[' | ']' | '?' | ',' | '<' | '>' | '=' | '#' | '*' | '$'

    specialNoColonOrSlash -> '+' | '-' | '(' | ')' | '"' | '!' | '@' | '`' | '~' | '.' |
                             '%' | '&' | '^' | ';' | "'" | '\' | '|' | '{' | '}' |
                             '[' | ']' | '?' | ',' | '<' | '>' | '=' | '#' | '*' | '$'

    specialNoExclamationOrSlash -> '+' | '-' | '(' | ')' | '"' | '@' | '`' | '~' | '.' |
                                   '%' | '&' | '^' | ':' | ';' | "'" | '\' | '|' | '{' | '}' |
                                   '[' | ']' | '?' | ',' | '<' | '>' | '=' | '#' | '*' | '$'

    specialNoDoubleQuote -> '+' | '-' | '(' | ')' | '!' | '@' | '`' | '~' | '.' | '/' |
                            '%' | '&' | '^' | ':' | ';' | "'" | '\' | '|' | '{' | '}' |
                            '[' | ']' | '?' | ',' | '<' | '>' | '=' | '#' | '*' | '$'

    specialNoSingleQuote -> '+' | '-' | '(' | ')' | '!' | '@' | '`' | '~' | '.' | '/' |
                            '%' | '&' | '^' | ':' | ';' | '"' | '\' | '|' | '{' | '}' |
                            '[' | ']' | '?' | ',' | '<' | '>' | '=' | '#' | '*' | '$'

    specialNoRightAngle -> '+' | '-' | '(' | ')' | '!' | '@' | '`' | '~' | '.' | '/' |
                           '%' | '&' | '^' | ':' | ';' | '"' | '\' | '|' | '{' | '}' |
                           '[' | ']' | '?' | ',' | '<' | "'" | '=' | '#' | '*' | '$'

    specialNoMinusSingleQuoteDoublequoteLeftAngleCommaLparenRparen -> '+' | '!' | '@' | '`' | '~' | '.' | '/' |
                                                                      '%' | '&' | '^' | ':' | ';' | '\' | '|' | '{' | '}' |
                                                                      '[' | ']' | '?' | '>' | '=' | '#' | '*' | '$'

    specialNoColonMinusSingleQuoteDoublequoteLeftAngleLRBracketOrSlashDollarPercent -> '+' | '(' | ')' | '!' | '@' | '`' | '~' | '.' |
                                                                              '&' | '^' | ';' | '\' | '{' | '}' |
                                                                              '?' | ',' | '>' | '=' | '*'

    Eol -> LF | CR

    whiteChar -> Space | Eol | HT | FF

    white ::= whiteChar
            | white whiteChar

    notEOL -> letter | digit | special | Space | HT | FF

    notEOLOrQuote -> letter | digit | specialNoSingleQuote | Space | HT | FF

    notEOLOrDoubleQuote -> letter | digit | specialNoDoubleQuote | Space | HT | FF

    notEOLOrRightAngle -> letter | digit | specialNoRightAngle | Space | HT | FF

    notEOLOrQuotes ::= %Empty
                     | notEOLOrQuotes notEOLOrQuote

    notEOLOrDoubleQuotes ::= %Empty
                           | notEOLOrDoubleQuotes notEOLOrDoubleQuote

    notEOLOrRightAngles ::= notEOLOrRightAngle
                          | notEOLOrRightAngles notEOLOrRightAngle

    singleLineComment ::= '-' '-'
                        | singleLineComment notEOL

    Equivalence ::= ':' ':' '='
    Arrow       ::= '-' '>'

    Exclamations ::= '!'
                   | Exclamations '!'

    InsideExclamationBlockChar -> letter | whiteChar | digit | specialNoExclamationOrSlash

    InsideExclamationBlock ::= %Empty
                             | InsideExclamationBlock InsideExclamationBlockChar
                             | InsideExclamationBlock Exclamations InsideExclamationBlockChar
                             | InsideExclamationBlock '/'

    Dots ::= '.'
           | Dots '.'

    InsideDotBlockChar -> letter | whiteChar | digit | specialNoDotOrSlash

    InsideDotBlock ::= %Empty
                     | InsideDotBlock InsideDotBlockChar
                     | InsideDotBlock Dots InsideDotBlockChar
                     | InsideDotBlock '/'

    Colons ::= ':'
             | Colons ':'

    InsideColonBlockChar -> letter | whiteChar | digit | specialNoColonOrSlash

    InsideColonBlock ::= %Empty
                       | InsideColonBlock InsideColonBlockChar
                       | InsideColonBlock Colons InsideColonBlockChar
                       | InsideColonBlock '/'

    Block ::= '/' '.' InsideDotBlock Dots '/'
            | '/' ':' InsideColonBlock Colons '/'
            | '/' '!' InsideExclamationBlock Exclamations '/'

    Symbol -> delimitedSymbol
            | specialSymbol
            | normalSymbol

    delimitedSymbol ::= "'" notEOLOrQuotes "'"
                      | '"' notEOLOrDoubleQuotes '"'
                      | '<' letter notEOLOrRightAngles '>'

    MacroSymbol ::= '$'
                  | MacroSymbol letter
                  | MacroSymbol digit

    anyNonWhiteNoColonMinusSingleQuoteDoublequoteLeftAngleLRBracketOrSlashDollarPercent -> letter | digit | specialNoColonMinusSingleQuoteDoublequoteLeftAngleLRBracketOrSlashDollarPercent
    normalSymbol ::= anyNonWhiteNoColonMinusSingleQuoteDoublequoteLeftAngleLRBracketOrSlashDollarPercent
                   | normalSymbol anyNonWhiteNoDollarBracketSharp

    --
    -- Below, we write special rules to recognize initial 
    -- prefixes of these special metasymbols as valid symbols.
    --
    --    BLOCK            /.  ...
    --    EQUIVALENCE      ::=[?]
    --    ARROW            ->[?]
    --    COMMENT          -- ...
    --    OR_MARKER        |
    --    OPTIONS_KEY      %options
    --    bracketed symbol < ... >
    --

    letterNoOo -> AfterASCII | '_' | aA | bB | cC | dD | eE | fF | gG | hH | iI | jJ | kK | lL | mM | nN | pP | qQ | rR | sS | tT | uU | vV | wW | xX | yY | zZ
    letterNoPp -> AfterASCII | '_' | aA | bB | cC | dD | eE | fF | gG | hH | iI | jJ | kK | lL | mM | nN | oO | qQ | rR | sS | tT | uU | vV | wW | xX | yY | zZ
    letterNoTt -> AfterASCII | '_' | aA | bB | cC | dD | eE | fF | gG | hH | iI | jJ | kK | lL | mM | nN | oO | pP | qQ | rR | sS | uU | vV | wW | xX | yY | zZ
    letterNoIi -> AfterASCII | '_' | aA | bB | cC | dD | eE | fF | gG | hH | jJ | kK | lL | mM | nN | oO | pP | qQ | rR | sS | tT | uU | vV | wW | xX | yY | zZ
    letterNoNn -> AfterASCII | '_' | aA | bB | cC | dD | eE | fF | gG | hH | iI | jJ | kK | lL | mM | oO | pP | qQ | rR | sS | tT | uU | vV | wW | xX | yY | zZ
    letterNoSs -> AfterASCII | '_' | aA | bB | cC | dD | eE | fF | gG | hH | iI | jJ | kK | lL | mM | nN | oO | pP | qQ | rR | tT | uU | vV | wW | xX | yY | zZ

    anyNonWhiteNoLetterDollar -> digit | specialNoDollar
    anyNonWhiteNoExclamationDotColonDollar -> letter | digit | specialNoExclamationDotColonDollar
    anyNonWhiteNoColonDollar -> letter | digit | specialNoColonDollar
    anyNonWhiteNoEqualDollar -> letter | digit | specialNoEqualDollar
    anyNonWhiteNoQuestionDollar -> letter | digit | specialNoQuestionDollar
    anyNonWhiteNoMinusRightAngleDollar -> letter | digit | specialNoMinusRightAngleDollar
    anyNonWhiteNoDollar -> letter | digit | specialNoDollar
    anyNonWhiteNoDollarBracketSharp -> letter | digit | specialNoDollarBracketSharp

    anyNonWhiteNoOoDollar -> letterNoOo | digit | specialNoDollar
    anyNonWhiteNoPpDollar -> letterNoPp | digit | specialNoDollar
    anyNonWhiteNoTtDollar -> letterNoTt | digit | specialNoDollar
    anyNonWhiteNoIiDollar -> letterNoIi | digit | specialNoDollar
    anyNonWhiteNoNnDollar -> letterNoNn | digit | specialNoDollar
    anyNonWhiteNoSsDollar -> letterNoSs | digit | specialNoDollar

    specialSymbol -> simpleSpecialSymbol
                   | complexSpecialSymbol

    simpleSpecialSymbol ::= '<'
                          | '/'
                          | ':'
                          | ':' ':'
                          | '-'
                          | '%'
                          | '%' oO
                          | '%' oO pP
                          | '%' oO pP tT
                          | '%' oO pP tT iI
                          | '%' oO pP tT iI oO
                          | '%' oO pP tT iI oO nN

    complexSpecialSymbol ::= '<' anyNonWhiteNoLetterDollar
                           | '/' anyNonWhiteNoExclamationDotColonDollar
                           | ':' anyNonWhiteNoColonDollar
                           | ':' ':' anyNonWhiteNoEqualDollar
                           | ':' ':' '=' anyNonWhiteNoQuestionDollar
                           | ':' ':' '=' '?' anyNonWhiteNoDollar
                           | '-' anyNonWhiteNoMinusRightAngleDollar
                           | '-' '>' anyNonWhiteNoQuestionDollar
                           | '-' '>' '?' anyNonWhiteNoDollar
                           | '|' anyNonWhiteNoDollar
                           | '%' anyNonWhiteNoOoDollar
                           | '%' oO anyNonWhiteNoPpDollar
                           | '%' oO pP anyNonWhiteNoTtDollar
                           | '%' oO pP tT anyNonWhiteNoIiDollar
                           | '%' oO pP tT iI anyNonWhiteNoOoDollar
                           | '%' oO pP tT iI oO anyNonWhiteNoNnDollar
                           | '%' oO pP tT iI oO nN anyNonWhiteNoSsDollar
                           | '%' oO pP tT iI oO nN sS anyNonWhiteNoDollar
                           | complexSpecialSymbol anyNonWhiteNoDollar

    number ::= digit
             | number digit

   --
   -- The following rules are used for processing options.
   --
   OptionLines ::= OptionLineList
          /.$BeginAction
                      // What ever needs to happen after the options have been 
                      // scanned must happen here.
            $EndAction
          ./

   OptionLineList ::= OptionLine
                    | OptionLineList OptionLine
   OptionLine ::= options Eol
                | OptionsHeader Eol
                | OptionsHeader optionList Eol
                | OptionsHeader OptionComment Eol
                | OptionsHeader optionList optionWhiteChar OptionComment Eol

   OptionsHeader ::= options optionWhiteChar optionWhite
   
   options ::= '%' oO pP tT iI oO nN sS
          /.$BeginAction
                      makeToken(getLeftSpan(), getRightSpan(), OPTIONS_KEY);
            $EndAction
          ./

   OptionComment ::= singleLineComment /.$BeginAction makeComment(SINGLE_LINE_COMMENT); $EndAction./
   
   _opt -> %Empty
         | '_'
         | '-'

   no ::= nN oO

   none ::= nN oO nN eE

   anyNoMinusSingleQuoteDoublequoteLeftAngleCommaLparenRparen -> letter
                                                               | digit
                                                               | specialNoMinusSingleQuoteDoublequoteLeftAngleCommaLparenRparen

   optionSymbol ::= anyNoMinusSingleQuoteDoublequoteLeftAngleCommaLparenRparen
                  | '-' anyNoMinusSingleQuoteDoublequoteLeftAngleCommaLparenRparen
                  | optionSymbol '-' anyNoMinusSingleQuoteDoublequoteLeftAngleCommaLparenRparen
                  | optionSymbol anyNoMinusSingleQuoteDoublequoteLeftAngleCommaLparenRparen

   Value ::= delimitedSymbol
           | '-'
           | optionSymbol
           | optionSymbol '-'

   optionWhiteChar -> Space | HT | FF
   optionWhite ::= %Empty
                 | optionWhite optionWhiteChar

   optionList ::= option
                | optionList separator option
   separator ::= ','$comma /.$BeginAction  makeToken(getLeftSpan(), getRightSpan(), COMMA); $EndAction./
   --
   -- action_block
   -- ast_directory
   -- ast_type
   -- automatic_ast
   -- attributes
   --
   option ::= action_block$ab optionWhite '='$eq optionWhite '('$lp optionWhite filename$fn optionWhite ','$comma1 optionWhite block_begin$bb optionWhite ','$comma2 optionWhite block_end$be optionWhite ')'$rp optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($ab), getRhsLastTokenIndex($ab), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($lp), getRhsLastTokenIndex($lp), LEFT_PAREN);
                      makeToken(getRhsFirstTokenIndex($fn), getRhsLastTokenIndex($fn), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($comma1), getRhsLastTokenIndex($comma1), COMMA);
                      makeToken(getRhsFirstTokenIndex($bb), getRhsLastTokenIndex($bb), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($comma2), getRhsLastTokenIndex($comma2), COMMA);
                      makeToken(getRhsFirstTokenIndex($be), getRhsLastTokenIndex($be), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($rp), getRhsLastTokenIndex($rp), RIGHT_PAREN);
            $EndAction
          ./
   action_block ::= aA cC tT iI oO nN _opt bB lL oO cC kK
                  | aA bB
   filename -> Value
   block_begin -> Value
   block_end -> Value

   option ::= ast_directory$ad optionWhite '='$eq optionWhite Value$val optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($ad), getRhsLastTokenIndex($ad), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($val), getRhsLastTokenIndex($val), SYMBOL);
            $EndAction
          ./
   ast_directory ::= aA sS tT _opt dD iI rR eE cC tT oO rR yY
                   | aA dD 

   option ::= ast_type$at optionWhite '='$eq optionWhite Value$val optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($at), getRhsLastTokenIndex($at), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($val), getRhsLastTokenIndex($val), SYMBOL);
            $EndAction
          ./
   ast_type ::= aA sS tT _opt tT yY pP eE
              | aA tT 

   option ::= attributes$a optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($a), getRhsLastTokenIndex($a), SYMBOL); $EndAction./
            | no attributes$a optionWhite  /.$BeginAction  makeToken(getRhsFirstTokenIndex($a), getRhsLastTokenIndex($a), SYMBOL); $EndAction./
   attributes ::= aA tT tT rR iI bB uU tT eE sS

   option ::= automatic_ast$a optionWhite  /.$BeginAction  makeToken(getRhsFirstTokenIndex($a), getRhsLastTokenIndex($a), SYMBOL); $EndAction./
            | no automatic_ast$a optionWhite  /.$BeginAction  makeToken(getRhsFirstTokenIndex($a), getRhsLastTokenIndex($a), SYMBOL); $EndAction./
   option ::= automatic_ast$aa optionWhite '='$eq optionWhite automatic_ast_value$val optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($aa), getRhsLastTokenIndex($aa), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($val), getRhsLastTokenIndex($val), SYMBOL);
            $EndAction
          ./
   automatic_ast ::= aA uU tT oO mM aA tT iI cC _opt aA sS tT
                   | aA aA
   automatic_ast_value ::= none
                         | nN eE sS tT eE dD
                         | tT oO pP _opt lL eE vV eE lL

   --
   -- backtrack
   -- byte
   --
   option ::= backtrack$b optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($b), getRhsLastTokenIndex($b), SYMBOL); $EndAction./
            | no backtrack$b optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($b), getRhsLastTokenIndex($b), SYMBOL); $EndAction./
   backtrack ::= bB aA cC kK tT rR aA cC kK

   option ::= byte$b optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($b), getRhsLastTokenIndex($b), SYMBOL); $EndAction./
            | no byte$b optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($b), getRhsLastTokenIndex($b), SYMBOL); $EndAction./
   byte ::= bB yY tT eE
   

   --
   -- conflicts
   --
   option ::= conflicts$c optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($c), getRhsLastTokenIndex($c), SYMBOL); $EndAction./
            | no conflicts$c optionWhite  /.$BeginAction  makeToken(getRhsFirstTokenIndex($c), getRhsLastTokenIndex($c), SYMBOL); $EndAction./
   conflicts ::= cC oO nN fF lL iI cC tT sS

   --
   -- dat_directory
   -- dat_file
   -- dcl_file
   -- def_file
   -- debug
   --
   option ::= dat_directory$dd optionWhite '='$eq optionWhite Value$val optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($dd), getRhsLastTokenIndex($dd), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($val), getRhsLastTokenIndex($val), SYMBOL);
            $EndAction
          ./
   dat_directory ::= dD aA tT _opt dD iI rR eE cC tT oO rR yY 
                   | dD dD

   option ::= dat_file$df optionWhite '='$eq optionWhite Value$val optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($df), getRhsLastTokenIndex($df), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($val), getRhsLastTokenIndex($val), SYMBOL);
            $EndAction
          ./
   dat_file ::= dD aA tT _opt fF iI lL eE

   option ::= dcl_file$df optionWhite '='$eq optionWhite Value$val optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($df), getRhsLastTokenIndex($df), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($val), getRhsLastTokenIndex($val), SYMBOL);
            $EndAction
          ./
   dcl_file ::= dD cC lL _opt fF iI lL eE

   option ::= def_file$df optionWhite '='$eq optionWhite Value$val optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($df), getRhsLastTokenIndex($df), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($val), getRhsLastTokenIndex($val), SYMBOL);
            $EndAction
          ./
   def_file ::= dD eE fF _opt fF iI lL eE

   option ::= debug$d optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($d), getRhsLastTokenIndex($d), SYMBOL); $EndAction./
            | no debug$d optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($d), getRhsLastTokenIndex($d), SYMBOL); $EndAction./
   debug ::= dD eE bB uU gG

   --
   -- edit
   -- error_maps
   -- escape
   -- export_terminals
   -- extends_parsetable
   --
   option ::= edit$e optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($e), getRhsLastTokenIndex($e), SYMBOL); $EndAction./
            | no edit$e optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($e), getRhsLastTokenIndex($e), SYMBOL); $EndAction./
   edit ::= eE dD iI tT

   option ::= error_maps$e optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($e), getRhsLastTokenIndex($e), SYMBOL); $EndAction./
            | no error_maps$e optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($e), getRhsLastTokenIndex($e), SYMBOL); $EndAction./
   error_maps ::= eE rR rR oO rR _opt mM aA pP sS
                | eE mM

   option ::= escape$e optionWhite '='$eq optionWhite anyNonWhiteChar$val optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($e), getRhsLastTokenIndex($e), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($val), getRhsLastTokenIndex($val), SYMBOL);
            $EndAction
          ./
   escape ::= eE sS cC aA pP eE

   option ::= export_terminals$et optionWhite '='$eq optionWhite filename$fn optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($et), getRhsLastTokenIndex($et), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($fn), getRhsLastTokenIndex($fn), SYMBOL);
            $EndAction
          ./
   option ::= export_terminals$et optionWhite '='$eq optionWhite '('$lp optionWhite filename$fn optionWhite ')'$rp optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($et), getRhsLastTokenIndex($et), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($lp), getRhsLastTokenIndex($lp), LEFT_PAREN);
                      makeToken(getRhsFirstTokenIndex($fn), getRhsLastTokenIndex($fn), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($rp), getRhsLastTokenIndex($rp), RIGHT_PAREN);
            $EndAction
          ./
   option ::= export_terminals$et optionWhite '='$eq optionWhite '('$lp optionWhite filename$fn optionWhite ','$comma optionWhite export_prefix$ep optionWhite ')'$rp optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($et), getRhsLastTokenIndex($et), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($lp), getRhsLastTokenIndex($lp), LEFT_PAREN);
                      makeToken(getRhsFirstTokenIndex($fn), getRhsLastTokenIndex($fn), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($comma), getRhsLastTokenIndex($comma), COMMA);
                      makeToken(getRhsFirstTokenIndex($ep), getRhsLastTokenIndex($ep), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($rp), getRhsLastTokenIndex($rp), RIGHT_PAREN);
            $EndAction
          ./
   option ::= export_terminals$et optionWhite '='$eq optionWhite '('$lp optionWhite filename$fn optionWhite ','$comma1 optionWhite export_prefix$ep optionWhite ','$comma2 optionWhite export_suffix$es optionWhite ')'$rp optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($et), getRhsLastTokenIndex($et), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($lp), getRhsLastTokenIndex($lp), LEFT_PAREN);
                      makeToken(getRhsFirstTokenIndex($fn), getRhsLastTokenIndex($fn), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($comma1), getRhsLastTokenIndex($comma1), COMMA);
                      makeToken(getRhsFirstTokenIndex($ep), getRhsLastTokenIndex($ep), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($comma2), getRhsLastTokenIndex($comma2), COMMA);
                      makeToken(getRhsFirstTokenIndex($es), getRhsLastTokenIndex($es), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($rp), getRhsLastTokenIndex($rp), RIGHT_PAREN);
            $EndAction
          ./
   export_terminals ::= eE xX pP oO rR tT _opt tT eE rR mM iI nN aA lL sS
                      | eE tT 
   export_prefix -> Value
   export_suffix -> Value

   option ::= extends_parsetable$e optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($e), getRhsLastTokenIndex($e), SYMBOL); $EndAction./
            | no extends_parsetable$e optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($e), getRhsLastTokenIndex($e), SYMBOL); $EndAction./
   option ::= extends_parsetable$ep optionWhite '='$eq optionWhite Value$val optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($ep), getRhsLastTokenIndex($ep), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($val), getRhsLastTokenIndex($val), SYMBOL);
            $EndAction
          ./
   extends_parsetable ::= eE xX tT eE nN dD sS _opt pP aA rR sS eE tT aA bB lL eE
                        | eE pP

   --
   -- factory
   -- file_prefix
   -- filter
   -- first
   -- follow
   --
   option ::= factory$f optionWhite '='$eq optionWhite Value$val optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($f), getRhsLastTokenIndex($f), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($val), getRhsLastTokenIndex($val), SYMBOL);
            $EndAction
          ./
   factory ::= fF aA cC tT oO rR yY

   option ::= file_prefix$fp optionWhite '='$eq optionWhite Value$val optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($fp), getRhsLastTokenIndex($fp), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($val), getRhsLastTokenIndex($val), SYMBOL);
            $EndAction
          ./
   file_prefix ::= fF iI lL eE _opt pP rR eE fF iI xX
                 | fF pP

   option ::= filter$f optionWhite '='$eq optionWhite Value$val optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($f), getRhsLastTokenIndex($f), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($val), getRhsLastTokenIndex($val), SYMBOL);
            $EndAction
          ./
   filter ::= fF iI lL tT eE rR

   option ::= first$f optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($f), getRhsLastTokenIndex($f), SYMBOL); $EndAction./
            | no first$f optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($f), getRhsLastTokenIndex($f), SYMBOL); $EndAction./
   first ::= fF iI rR sS tT

   option ::= follow$f optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($f), getRhsLastTokenIndex($f), SYMBOL); $EndAction./
            | no follow$f optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($f), getRhsLastTokenIndex($f), SYMBOL); $EndAction./
   follow ::= fF oO lL lL oO wW

   --
   -- goto_default
   --
   option ::= goto_default$g optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($g), getRhsLastTokenIndex($g), SYMBOL); $EndAction./
            | no goto_default$g optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($g), getRhsLastTokenIndex($g), SYMBOL); $EndAction./
   goto_default ::= gG oO tT oO _opt dD eE fF aA uU lL tT
                  | gG dD

   --
   -- Headers
   --
   option ::= headers$h optionWhite '='$eq optionWhite '('$lp optionWhite filename$fn optionWhite ','$comma1 optionWhite block_begin$bb optionWhite ','$comma2 optionWhite block_end$be optionWhite ')'$rp optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($h), getRhsLastTokenIndex($h), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($lp), getRhsLastTokenIndex($lp), LEFT_PAREN);
                      makeToken(getRhsFirstTokenIndex($fn), getRhsLastTokenIndex($fn), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($comma1), getRhsLastTokenIndex($comma1), COMMA);
                      makeToken(getRhsFirstTokenIndex($bb), getRhsLastTokenIndex($bb), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($comma2), getRhsLastTokenIndex($comma2), COMMA);
                      makeToken(getRhsFirstTokenIndex($be), getRhsLastTokenIndex($be), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($rp), getRhsLastTokenIndex($rp), RIGHT_PAREN);
            $EndAction
          ./
   headers ::= hH eE aA dD eE rR sS

   --
   -- imp_file
   -- import_terminals
   -- include_directory/include_directories
   --
   option ::= imp_file$if optionWhite '='$eq optionWhite Value$val optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($if), getRhsLastTokenIndex($if), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($val), getRhsLastTokenIndex($val), SYMBOL);
            $EndAction
          ./
   imp_file ::= iI mM pP _opt fF iI lL eE
              | iI fF 

   option ::= import_terminals$it optionWhite '='$eq optionWhite Value$val optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($it), getRhsLastTokenIndex($it), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($val), getRhsLastTokenIndex($val), SYMBOL);
            $EndAction
          ./
   import_terminals ::= iI mM pP oO rR tT _opt tT eE rR mM iI nN aA lL sS
                      | iI tT

   option ::= include_directory$id optionWhite '='$eq optionWhite Value$val optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($id), getRhsLastTokenIndex($id), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($val), getRhsLastTokenIndex($val), SYMBOL);
            $EndAction
          ./
   include_directory ::= iI nN cC lL uU dD eE _opt dD iI rR eE cC tT oO rR yY
                       | iI nN cC lL uU dD eE _opt dD iI rR eE cC tT oO rR iI eE sS 
                       | iI dD

   --
   -- lalr_level
   -- list
   --
   option ::= lalr_level$l optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($l), getRhsLastTokenIndex($l), SYMBOL); $EndAction./
            | no lalr_level$l optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($l), getRhsLastTokenIndex($l), SYMBOL); $EndAction./
   option ::= lalr_level$l optionWhite '='$eq optionWhite number$val optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($l), getRhsLastTokenIndex($l), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($val), getRhsLastTokenIndex($val), SYMBOL);
            $EndAction
          ./
   lalr_level ::= lL aA lL rR _opt lL eE vV eE lL
                | lL aA lL rR
                | lL aA
                | lL lL

   option ::= list$l optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($l), getRhsLastTokenIndex($l), SYMBOL); $EndAction./
            | no list$l optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($l), getRhsLastTokenIndex($l), SYMBOL); $EndAction./
   list ::= lL iI sS tT 

   --
   -- margin
   -- max_cases
   --
   option ::= margin$m optionWhite '='$eq optionWhite number$val optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($m), getRhsLastTokenIndex($m), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($val), getRhsLastTokenIndex($val), SYMBOL);
            $EndAction
          ./
   margin ::= mM aA rR gG iI nN

   option ::= max_cases$mc optionWhite '='$eq optionWhite number$val optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($mc), getRhsLastTokenIndex($mc), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($val), getRhsLastTokenIndex($val), SYMBOL);
            $EndAction
          ./
   max_cases ::= mM aA xX _opt cC aA sS eE sS
               | mM cC

   --
   -- names
   -- nt_check
   --
   option ::= names$n optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($n), getRhsLastTokenIndex($n), SYMBOL); $EndAction./
            | no names$n optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($n), getRhsLastTokenIndex($n), SYMBOL); $EndAction./
   option ::= names$n optionWhite '='$eq optionWhite names_value$val optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($n), getRhsLastTokenIndex($n), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($val), getRhsLastTokenIndex($val), SYMBOL);
            $EndAction
          ./
   names ::= nN aA mM eE sS

   names_value ::= oO pP tT iI mM iI zZ eE dD
                 | mM aA xX iI mM uU mM
                 | mM iI nN iI mM uU mM
   

   option ::= nt_check$n optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($n), getRhsLastTokenIndex($n), SYMBOL); $EndAction./
            | no nt_check$n optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($n), getRhsLastTokenIndex($n), SYMBOL); $EndAction./
   nt_check ::= nN tT _opt cC hH eE cC kK
              | nN cC

   --
   -- or_marker
   -- out_directory
   --
   option ::= or_marker$om optionWhite '='$eq optionWhite anyNonWhiteChar$val optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($om), getRhsLastTokenIndex($om), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($val), getRhsLastTokenIndex($val), SYMBOL);
            $EndAction
          ./
   or_marker ::= oO rR _opt mM aA rR kK eE rR
               | oO mM 

   option ::= out_directory$dd optionWhite '='$eq optionWhite Value$val optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($dd), getRhsLastTokenIndex($dd), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($val), getRhsLastTokenIndex($val), SYMBOL);
            $EndAction
          ./
   out_directory ::= oO uU tT _opt dD iI rR eE cC tT oO rR yY 
                   | oO dD

   --
   -- package
   -- parent_saved
   -- parsetable_interfaces
   -- prefix
   -- priority
   -- programming_language
   -- prs_file
   --
   option ::= parent_saved$ps optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($ps), getRhsLastTokenIndex($ps), SYMBOL); $EndAction ./
            | no parent_saved$ps optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($ps), getRhsLastTokenIndex($ps), SYMBOL); $EndAction ./
   parent_saved ::= pP aA rR eE nN tT _opt sS aA vV eE dD
                  | pP sS

   option ::= package$p optionWhite '='$eq optionWhite Value$val optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($p), getRhsLastTokenIndex($p), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($val), getRhsLastTokenIndex($val), SYMBOL);
            $EndAction
          ./
   package ::= pP aA cC kK aA gG eE

   option ::= parsetable_interfaces$pi optionWhite '='$eq optionWhite Value$val optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($pi), getRhsLastTokenIndex($pi), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($val), getRhsLastTokenIndex($val), SYMBOL);
            $EndAction
          ./
   parsetable_interfaces ::= pP aA rR sS eE tT aA bB lL eE _opt iI nN tT eE rR fF aA cC eE sS
                           | pP aA rR sS eE tT aA bB lL eE
                           | pP iI

   option ::= prefix$p optionWhite '='$eq optionWhite Value$val optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($p), getRhsLastTokenIndex($p), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($val), getRhsLastTokenIndex($val), SYMBOL);
            $EndAction
          ./
   prefix ::= pP rR eE fF iI xX

   option ::= priority$p optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($p), getRhsLastTokenIndex($p), SYMBOL); $EndAction./
            | no priority$p optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($p), getRhsLastTokenIndex($p), SYMBOL); $EndAction./
   priority ::= pP rR iI oO rR iI tT yY

   option ::= programming_language$pl optionWhite '='$eq optionWhite programming_language_value$val optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($pl), getRhsLastTokenIndex($pl), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($val), getRhsLastTokenIndex($val), SYMBOL);
            $EndAction
          ./
   programming_language ::= pP rR oO gG rR aA mM mM iI nN gG _opt lL aA nN gG uU aA gG eE
                          | pP lL
   programming_language_value ::= none
                                | xX mM lL
                                | cC
                                | cC pP pP
                                | jJ aA vV aA
                                | pP lL xX
                                | pP lL xX aA sS mM
                                | mM lL
   option ::= prs_file$pf optionWhite '='$eq optionWhite Value$val optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($pf), getRhsLastTokenIndex($pf), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($val), getRhsLastTokenIndex($val), SYMBOL);
            $EndAction
          ./
   prs_file ::= pP rR sS _opt fF iI lL eE
              | pP fF
   

   --
   -- quiet
   --
   option ::= quiet$q optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($q), getRhsLastTokenIndex($q), SYMBOL); $EndAction./
            | no quiet$q optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($q), getRhsLastTokenIndex($q), SYMBOL); $EndAction./
   quiet ::= qQ uU iI eE tT

   --
   -- read_reduce
   -- remap_terminals
   --
   option ::= read_reduce$r optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($r), getRhsLastTokenIndex($r), SYMBOL); $EndAction./
            | no read_reduce$r optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($r), getRhsLastTokenIndex($r), SYMBOL); $EndAction./
   read_reduce ::= rR eE aA dD _opt rR eE dD uU cC eE
                 | rR rR

   option ::= remap_terminals$r optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($r), getRhsLastTokenIndex($r), SYMBOL); $EndAction./
            | no remap_terminals$r optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($r), getRhsLastTokenIndex($r), SYMBOL); $EndAction./
   remap_terminals ::= rR eE mM aA pP _opt tT eE rR mM iI nN aA lL sS
                     | rR tT

   --
   -- scopes
   -- serialize
   -- shift_default
   -- single_productions
   -- slr
   -- soft_keywords
   -- states
   -- suffix
   -- sym_file
   --
   option ::= scopes$s optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($s), getRhsLastTokenIndex($s), SYMBOL); $EndAction ./
            | no scopes$s optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($s), getRhsLastTokenIndex($s), SYMBOL); $EndAction ./
   scopes ::= sS cC oO pP eE sS

   option ::= serialize$s optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($s), getRhsLastTokenIndex($s), SYMBOL); $EndAction ./
            | no serialize$s optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($s), getRhsLastTokenIndex($s), SYMBOL); $EndAction ./
   serialize ::= sS eE rR iI aA lL iI zZ eE

   option ::= shift_default$s optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($s), getRhsLastTokenIndex($s), SYMBOL); $EndAction ./
            | no shift_default$s optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($s), getRhsLastTokenIndex($s), SYMBOL); $EndAction ./
   shift_default ::= sS hH iI fF tT _opt dD eE fF aA uU lL tT
                   | sS dD

   option ::= single_productions$s optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($s), getRhsLastTokenIndex($s), SYMBOL); $EndAction ./
            | no single_productions$s optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($s), getRhsLastTokenIndex($s), SYMBOL); $EndAction ./
   single_productions ::= sS iI nN gG lL eE _opt pP rR oO dD uU cC tT iI oO nN sS
                        | sS pP

   option ::= slr$s optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($s), getRhsLastTokenIndex($s), SYMBOL); $EndAction ./
            | no slr$s optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($s), getRhsLastTokenIndex($s), SYMBOL); $EndAction ./
   slr ::= sS lL rR

   option ::= soft_keywords$s optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($s), getRhsLastTokenIndex($s), SYMBOL); $EndAction ./
            | no soft_keywords$s optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($s), getRhsLastTokenIndex($s), SYMBOL); $EndAction ./
   soft_keywords ::= sS oO fF tT _opt kK eE yY wW oO rR dD sS 
                   | sS oO fF tT
                   | sS kK

   option ::= states$s optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($s), getRhsLastTokenIndex($s), SYMBOL); $EndAction ./
            | no states$s optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($s), getRhsLastTokenIndex($s), SYMBOL); $EndAction ./
   states ::= sS tT aA tT eE sS

   option ::= suffix$s optionWhite '='$eq optionWhite Value$val optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($s), getRhsLastTokenIndex($s), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($val), getRhsLastTokenIndex($val), SYMBOL);
            $EndAction
          ./
   suffix ::= sS uU fF fF iI xX 

   option ::= sym_file$sf optionWhite '='$eq optionWhite Value$val optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($sf), getRhsLastTokenIndex($sf), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($val), getRhsLastTokenIndex($val), SYMBOL);
            $EndAction
          ./
   sym_file ::= sS yY mM _opt fF iI lL eE
              | sS fF 

   --
   -- tab_file
   -- table
   -- template
   -- trace
   --
   option ::= tab_file$tf optionWhite '='$eq optionWhite Value$val optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($tf), getRhsLastTokenIndex($tf), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($val), getRhsLastTokenIndex($val), SYMBOL);
            $EndAction
          ./
   tab_file ::= tT aA bB _opt fF iI lL eE
              | tT fF

   option ::= template$t optionWhite '='$eq optionWhite Value$val optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($t), getRhsLastTokenIndex($t), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($val), getRhsLastTokenIndex($val), SYMBOL);
            $EndAction
          ./
   template ::= tT eE mM pP lL aA tT eE
   

   option ::= trailers$t optionWhite '='$eq optionWhite '('$lp optionWhite filename$fn optionWhite ','$comma1 optionWhite block_begin$bb optionWhite ','$comma2 optionWhite block_end$be optionWhite ')'$rp optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($t), getRhsLastTokenIndex($t), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($lp), getRhsLastTokenIndex($lp), LEFT_PAREN);
                      makeToken(getRhsFirstTokenIndex($fn), getRhsLastTokenIndex($fn), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($comma1), getRhsLastTokenIndex($comma1), COMMA);
                      makeToken(getRhsFirstTokenIndex($bb), getRhsLastTokenIndex($bb), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($comma2), getRhsLastTokenIndex($comma2), COMMA);
                      makeToken(getRhsFirstTokenIndex($be), getRhsLastTokenIndex($be), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($rp), getRhsLastTokenIndex($rp), RIGHT_PAREN);
            $EndAction
          ./
   trailers ::= tT rR aA iI lL eE rR sS

   option ::= table$t optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($t), getRhsLastTokenIndex($t), SYMBOL); $EndAction ./
            | no table$t optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($t), getRhsLastTokenIndex($t), SYMBOL); $EndAction ./
   option ::= table$t optionWhite '='$eq optionWhite programming_language_value$val optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($t), getRhsLastTokenIndex($t), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($val), getRhsLastTokenIndex($val), SYMBOL);
            $EndAction
          ./
   table ::= tT aA bB lL eE 

   option ::= trace$t optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($t), getRhsLastTokenIndex($t), SYMBOL); $EndAction ./
            | no trace$t optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($t), getRhsLastTokenIndex($t), SYMBOL); $EndAction ./
   option ::= trace$t optionWhite '='$eq optionWhite trace_value$val optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($t), getRhsLastTokenIndex($t), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($val), getRhsLastTokenIndex($val), SYMBOL);
            $EndAction
          ./
   trace ::= tT rR aA cC eE

   trace_value ::= none
                 | cC oO nN fF lL iI cC tT sS
                 | fF uU lL lL

   --
   -- variables
   -- verbose
   -- visitor
   -- visitor_type
   --
   option ::= variables$v optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($v), getRhsLastTokenIndex($v), SYMBOL); $EndAction ./
            | no variables$v optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($v), getRhsLastTokenIndex($v), SYMBOL); $EndAction ./
   option ::= variables$v optionWhite '='$eq optionWhite variables_value$val optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($v), getRhsLastTokenIndex($v), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($val), getRhsLastTokenIndex($val), SYMBOL);
            $EndAction
          ./
   variables ::= vV aA rR iI aA bB lL eE sS
   variables_value ::= none
                     | bB oO tT hH
                     | tT eE rR mM iI nN aA lL sS
                     | nN oO nN _opt tT eE rR mM iI nN aA lL sS
                     | nN tT

   option ::= verbose$v optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($v), getRhsLastTokenIndex($v), SYMBOL); $EndAction ./
            | no verbose$v optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($v), getRhsLastTokenIndex($v), SYMBOL); $EndAction ./
   verbose ::= vV eE rR bB oO sS eE

   option ::= visitor$v optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($v), getRhsLastTokenIndex($v), SYMBOL); $EndAction ./
            | no visitor$v optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($v), getRhsLastTokenIndex($v), SYMBOL); $EndAction ./
   option ::= visitor$v optionWhite '='$eq optionWhite visitor_value$val optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($v), getRhsLastTokenIndex($v), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($val), getRhsLastTokenIndex($val), SYMBOL);
            $EndAction
          ./
   visitor ::= vV iI sS iI tT oO rR
   visitor_value ::= none
                   | dD eE fF aA uU lL tT
                   | pP rR eE oO rR dD eE rR

   option ::= visitor_type$vt optionWhite '='$eq optionWhite Value$val optionWhite
          /.$BeginAction
                      makeToken(getRhsFirstTokenIndex($vt), getRhsLastTokenIndex($vt), SYMBOL);
                      makeToken(getRhsFirstTokenIndex($eq), getRhsLastTokenIndex($eq), EQUAL);
                      makeToken(getRhsFirstTokenIndex($val), getRhsLastTokenIndex($val), SYMBOL);
            $EndAction
          ./
   visitor_type ::= vV iI sS iI tT oO rR _opt tT yY pP eE
                  | vV tT

   --
   -- warnings
   --
   option ::= warnings$w optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($w), getRhsLastTokenIndex($w), SYMBOL); $EndAction ./
            | no warnings$w optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($w), getRhsLastTokenIndex($w), SYMBOL); $EndAction ./
   warnings ::= wW aA rR nN iI nN gG sS

   --
   -- xref
   --
   option ::= xreference$x optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($x), getRhsLastTokenIndex($x), SYMBOL); $EndAction ./
            | no xreference$x optionWhite /.$BeginAction  makeToken(getRhsFirstTokenIndex($x), getRhsLastTokenIndex($x), SYMBOL); $EndAction ./
   xreference ::= xX rR eE fF
                | xX rR eE fF eE rR eE nN cC eE
%End
