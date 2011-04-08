--
-- The Xml Parser based on the definition in the document:
--
-- http://www.w3.org/TR/2004/REC-xml-20040204
--
%options variables=nt
%options la=15
%options fp=XmlParser
%options error-maps
%options scopes
%options single_productions
%options package=xmlparser
%options template=dtUnifiedTemplateF.gi

%Define
    --
    -- Definition of macros used in the parser template
    --
    $super_stream_class /.Utf8LpgLexStream./
%End

%Include
    XmlUtil.gi
%End

%Terminals

    -- U0000    NUL  --  (Null char.)
    -- U0001    SOH  --  (Start of Header)
    -- U0002    STX  --  (Start of Text)
    -- U0003    ETX  --  (End of Text)
    -- U0004    EOT  --  (End of Transmission)
    -- U0005    ENQ  --  (Enquiry)
    -- U0006    ACK  --  (Acknowledgment)
    -- U0007    BEL  --  (Bell)
    -- U0008     BS  --  (Backspace)
    HT --     U0009  --  (Horizontal Tab)     
    LF --     U000A  --  (Line Feed)     
    -- U000B     VT  --  (Vertical Tab)
    -- U000C     FF  --  (Form Feed)     
    CR --     U000D  --  (Carriage Return)     
    -- U000E     SO  --  (Shift Out)
    -- U000F     SI  --  (Shift In)
    -- U0010    DLE  --  (Data Link Escape)
    -- U0011    DC1  --  (XON) (Device Control 1)
    -- U0012    DC2  --  (Device Control 2)
    -- U0013    DC3  --  (XOFF)(Device Control 3)
    -- U0014    DC4  --  (Device Control 4)
    -- U0015    NAK  --  (Negative Acknowledgement)
    -- U0016    SYN  --  (Synchronous Idle)
    -- U0017    ETB  --  (End of Trans. Block)
    -- U0018    CAN  --  (Cancel)
    -- U0019     EM  --  (End of Medium)
    -- U001A    SUB  --  (Substitute)
    -- U001B    ESC  --  (Escape)
    -- U001C     FS  --  (File Separator)
    -- U001D     GS  --  (Group Separator)
    -- U001E     RS  --  (Request to Send)(Record Separator)
    -- U001F     US  --  (Unit Separator)
    Space --  U0020  --  (Space)     

    Exclamation  ::= '!' -- 021 (exclamation mark)
    DoubleQuote  ::= '"' -- 022 (double quote)
    Sharp        ::= '#' -- 023 (number sign)
    DollarSign   ::= '$' -- 024 (dollar sign)
    Percent      ::= '%' -- 025 (percent)
    Ampersand    ::= '&' -- 026 (ampersand)
    SingleQuote  ::= "'" -- 027 (single quote)
    LeftParen    ::= '(' -- 028 (left/opening parenthesis)
    RightParen   ::= ')' -- 029 (right/closing parenthesis)
    Star         ::= '*' -- 02A (asterisk)
    Plus         ::= '+' -- 02B (plus)
    Comma        ::= ',' -- 02C (comma)
    Minus        ::= '-' -- 02D (minus or dash)
    Dot          ::= '.' -- 02E (dot)
    Slash        ::= '/' -- 02F (forward slash)

    0 -- 030
    1 -- 031
    2 -- 032
    3 -- 033
    4 -- 034
    5 -- 035
    6 -- 036
    7 -- 037
    8 -- 038
    9 -- 039

    Colon        ::= ':' -- 03A (colon)
    SemiColon    ::= ';' -- 03B (semi-colon)
    LessThan     ::= '<' -- 03C (less than)
    Equal        ::= '=' -- 03D (equal sign)
    GreaterThan  ::= '>' -- 03E (greater than)
    QuestionMark ::= '?' -- 03F (question mark)
    AtSign       ::= '@' -- 040 (AT symbol)

    A -- 041
    B -- 042
    C -- 043
    D -- 044
    E -- 045
    F -- 046
    G -- 047
    H -- 048
    I -- 049
    J -- 04A
    K -- 04B
    L -- 04C
    M -- 04D
    N -- 04E
    O -- 04F
    P -- 050
    Q -- 051
    R -- 052
    S -- 053
    T -- 054
    U -- 055
    V -- 056
    W -- 057
    X -- 058
    Y -- 059
    Z -- 05A

    LeftBracket  ::= '[' -- 05B (left/opening bracket)
    BackSlash    ::= '\' -- 05C (back slash)
    RightBracket ::= ']' -- 05D (right/closing bracket)
    Caret        ::= '^' -- 05E (caret/cirumflex)
    _ -- 05F (underscore)
    BackQuote    ::= '`' -- 060 (backquote)

    a -- 061
    b -- 062
    c -- 063
    d -- 064
    e -- 065
    f -- 066
    g -- 067
    h -- 068
    i -- 069
    j -- 06A
    k -- 06B
    l -- 06C
    m -- 06D
    n -- 06E
    o -- 06F
    p -- 070
    q -- 071
    r -- 072
    s -- 073
    t -- 074
    u -- 075
    v -- 076
    w -- 077
    x -- 078
    y -- 079
    z -- 07A

    LeftBrace    ::= '{' -- 07B (left/opening brace)
    VerticalBar  ::= '|' -- 07C (vertical bar)
    RightBrace   ::= '}' -- 07D (right/closing brace)
    Tilde        ::= '~' -- 07E (tilde)

    NonAsciiBaseChar
    Ideographic
    CombiningChar
    Extender
    NonAsciiDigit
    OtherValidChar

    Unused

    ExtSubsetMarker
    ExtParserEntMarker

%End

%Error
    Unused
%End

%Start
   document
%End

%Rules
    --[1] document ::= prolog element Misc* 
    document ::= prolog element Misc*$
        /.
                    setResult(new Ast());
        ./
               | ExtSubsetMarker extSubset
        /.
                    setResult(new Ast());
        ./
               | ExtParserEntMarker extParsedEnt
        /.
                    setResult(new Ast());
        ./

    -- [2] Char ::= #x9 | #xA | #xD | [#x20-#xD7FF] | [#xE000-#xFFFD] | [#x10000-#x10FFFF]
    --Char -> SpaceChar
    --      | NonSpaceChar
    --

    --[3] S ::= (#x20 | #x9 | #xD | #xA)+ 
    WhiteSpaces ::= SpaceChar
                  | WhiteSpaces SpaceChar

    --[4] NameChar ::= Letter | Digit | '.' | '-' | '_' | ':' | CombiningChar | Extender 
    NameChar -> Letter
              | Digit
              | '.'
              | '-'
              | '_'
              | ':'
              | CombiningChar
              | Extender 

    --[5] Name ::= (Letter | '_' | ':') (NameChar)* 
    -- Name ::= (Letter | '_' | ':') (NameChar)* 
    Name ::= Letter
           | '_'
           | ':'
           | Name NameChar 

    --[6] Names ::= Name (#x20 Name)* 
    -- Names ::= Name (#x20 Name)* 
    Names ::= Name
            | Names U0020 Name 

    --[7] Nmtoken ::= (NameChar)+ 
    -- Nmtoken ::= (NameChar)+ 
    Nmtoken ::= NameChar
              | Nmtoken NameChar 

    --[8] Nmtokens ::= Nmtoken (#x20 Nmtoken)* 
    -- Nmtokens ::= Nmtoken (#x20 Nmtoken)* 
    Nmtokens ::= Nmtoken
               | Nmtokens U0020 Nmtoken

    --[9] EntityValue ::= '"' ([^%&"] | PEReference | Reference)* '"'  
    --                  | "'" ([^%&'] | PEReference | Reference)* "'" 
    EntityValue ::= '"' DoubleEntityValueContent '"'  
                  | "'" SingleEntityValueContent "'" 
    DoubleEntityValueContent ::= %Empty
                               | DoubleEntityValueContent Char[^%&"]
                               | DoubleEntityValueContent PEReference
                               | DoubleEntityValueContent Reference
    SingleEntityValueContent ::= %Empty
                               | SingleEntityValueContent Char[^%&']
                               | SingleEntityValueContent PEReference
                               | SingleEntityValueContent Reference

    --[10] AttValue ::= '"' ([^<&"] | Reference)* '"'  
    --                | "'" ([^<&'] | Reference)* "'" 
    AttValue ::= '"' DoubleAttValueContent '"'  
               | "'" SingleAttValueContent "'" 
    DoubleAttValueContent ::= %Empty
                            | DoubleAttValueContent Char[^<&"]
                            | DoubleAttValueContent Reference
    SingleAttValueContent ::= %Empty
                            | SingleAttValueContent Char[^<&']
                            | SingleAttValueContent Reference

    --[11] SystemLiteral ::= ('"' [^"]* '"') | ("'" [^']* "'")  
    SystemLiteral ::= '"' DoubleSystemLiteralContent '"'
                    | "'" SingleSystemLiteralContent "'"

    DoubleSystemLiteralContent ::= %Empty
                                 | DoubleSystemLiteralContent Char[^"]

    SingleSystemLiteralContent ::= %Empty
                                 | SingleSystemLiteralContent Char[^']

    --[12] PubidLiteral ::= '"' PubidChar* '"' | "'" (PubidChar - "'")* "'" 
    PubidLiteral ::= '"' DoublePubidLiteralContent '"'
                   | "'" SinglePubidLiteralContent "'" 
    DoublePubidLiteralContent ::= %Empty
                                | DoublePubidLiteralContent PubidChar
    SinglePubidLiteralContent ::= %Empty
                                | SinglePubidLiteralContent PubidChar[^']

    --[13] PubidChar ::= #x20 | #xD | #xA | [a-zA-Z0-9] | [-'()+,./:=?;!*#@$_%] 
    PubidChar -> PubidChar[^']
               | "'"

    --[14] CharData ::= [^<&]* - ([^<&]* ']]>' [^<&]*) 
    CharData ::= CharDataContent
               | CharDataContent ']'
               | CharDataContent 2OrMoreBrackets

    CharDataContent ::= %Empty
                      | CharDataContent 2OrMoreBrackets Char[^<&]>]
                      | CharDataContent '>'
                      | CharDataContent ']' Char[^<&]]
                      | CharDataContent Char[^<&]>]

    2OrMoreBrackets ::= ']' ']'
                      | 2OrMoreBrackets ']'

    --[15] Comment ::= '<!--' ((Char - '-') | ('-' (Char - '-')))* '-->' 
    Comment ::= '<' '!' '-' '-' CommentContent '-' '-' '>'
              | '<' '!' '-' '-' CommentContent '-' '-' '-' '>'

    CommentContent ::= %Empty
                     | CommentContent Char[^-] 
                     | CommentContent '-' Char[^-]

    --[16] PI ::= '<?' PITarget (S (Char* - (Char* '?>' Char*)))? '?>' 
    PI ::= '<' '?' PITarget '?' '>'
         | '<' '?' PITarget WhiteSpaces '?' '>'
         | '<' '?' PITarget WhiteSpaces AfterPITarget Questions '>'

    AfterPITarget ::= NonSpaceChar[^?>]
                    | Questions Char[^?>]
                    | '>'
                    | AfterPITarget Questions Char[^?>]
                    | AfterPITarget '>'
                    | AfterPITarget Char[^?>]

    Questions ::= '?'
                | Questions '?'

     --[17] PITarget ::= Name - (('X' | 'x') ('M' | 'm') ('L' | 'l')) 
     PITarget ::= Letter[^Xx] PITargettail
                | Xx
                | Xx NameChar[^Mm] PITargettail
                | Xx Mm
                | Xx Mm NameChar[^Ll] PITargettail
                | Xx Mm Ll NameChar PITargettail
                | '_' PITargettail
                | ':' PITargettail

    PITargettail ::= %Empty
                   | PITargettail NameChar

    --[18] CDSect ::= CDStart CData CDEnd 
    CDSect ::= '<' '!' '[' 'C' 'D' 'A' 'T' 'A' '[' CData 2OrMoreBrackets '>' 

    --[19] CDStart ::= '<![CDATA[' 
    --CDStart ::= '<' '!' '[' 'C' 'D' 'A' 'T' 'A' '['
    --

    --[20] CData ::= (Char* - (Char* ']]>' Char*))  
    CData ::= %Empty
            | CData 2OrMoreBrackets Char[^]>]
            | CData '>'
            | CData ']' Char[^]>]
            | CData Char[^]>]

    --[21] CDEnd ::= ']]>' 
    --CDEnd ::= ']' ']' '>'
    --

    --[22] prolog ::= XMLDecl? Misc* (doctypedecl Misc*)? 
    prolog ::= Misc*
             | XMLDecl Misc*
             | Misc* doctypedecl Misc*
             | XMLDecl Misc* doctypedecl Misc*

    --[23] XMLDecl ::= '<?xml' VersionInfo EncodingDecl? SDDecl? S? '?>' 
    XMLDecl ::= '<' '?' Xx Mm Ll VersionInfo '?' '>' 
              | '<' '?' Xx Mm Ll VersionInfo WhiteSpaces '?' '>' 
              | '<' '?' Xx Mm Ll VersionInfo SDDecl '?' '>' 
              | '<' '?' Xx Mm Ll VersionInfo SDDecl WhiteSpaces '?' '>' 
              | '<' '?' Xx Mm Ll VersionInfo EncodingDecl '?' '>' 
              | '<' '?' Xx Mm Ll VersionInfo EncodingDecl WhiteSpaces '?' '>' 
              | '<' '?' Xx Mm Ll VersionInfo EncodingDecl SDDecl '?' '>' 
              | '<' '?' Xx Mm Ll VersionInfo EncodingDecl SDDecl WhiteSpaces '?' '>' 

    --[24] VersionInfo ::= S 'version' Eq ("'" VersionNum "'" | '"' VersionNum '"') 
    VersionInfo ::= WhiteSpaces Vv Ee Rr Ss Ii Oo Nn Eq "'" VersionNum "'"
                  | WhiteSpaces Vv Ee Rr Ss Ii Oo Nn Eq '"' VersionNum '"'

    --[25] Eq ::= S? '=' S? 
    Eq ::= '='
         | '=' WhiteSpaces
         | WhiteSpaces '='
         | WhiteSpaces '=' WhiteSpaces

    --[26] VersionNum ::= '1.0' 
   VersionNum ::= '1' '.' '0' 

    --[27] Misc ::= Comment | PI | S 
    Misc* ::= %Empty
            | WhiteSpaces 
            | Misc* Comment
            | Misc* PI
            | Misc* Comment WhiteSpaces
            | Misc* PI WhiteSpaces


    --[28] doctypedecl ::= '<!DOCTYPE' S Name (S ExternalID)? S? ('[' intSubset ']' S?)? '>' [VC: Root Element Type] 
    doctypedecl ::= '<' '!' 'D' 'O' 'C' 'T' 'Y' 'P' 'E' WhiteSpaces Name '>'
                  | '<' '!' 'D' 'O' 'C' 'T' 'Y' 'P' 'E' WhiteSpaces Name WhiteSpaces '>'
                  | '<' '!' 'D' 'O' 'C' 'T' 'Y' 'P' 'E' WhiteSpaces Name '[' intSubset ']' '>'
                  | '<' '!' 'D' 'O' 'C' 'T' 'Y' 'P' 'E' WhiteSpaces Name '[' intSubset ']' WhiteSpaces '>'
                  | '<' '!' 'D' 'O' 'C' 'T' 'Y' 'P' 'E' WhiteSpaces Name WhiteSpaces '[' intSubset ']' '>'
                  | '<' '!' 'D' 'O' 'C' 'T' 'Y' 'P' 'E' WhiteSpaces Name WhiteSpaces '[' intSubset ']' WhiteSpaces '>'
                  | '<' '!' 'D' 'O' 'C' 'T' 'Y' 'P' 'E' WhiteSpaces Name WhiteSpaces ExternalID '>'
                  | '<' '!' 'D' 'O' 'C' 'T' 'Y' 'P' 'E' WhiteSpaces Name WhiteSpaces ExternalID WhiteSpaces '>'
                  | '<' '!' 'D' 'O' 'C' 'T' 'Y' 'P' 'E' WhiteSpaces Name WhiteSpaces ExternalID '[' intSubset ']' '>'
                  | '<' '!' 'D' 'O' 'C' 'T' 'Y' 'P' 'E' WhiteSpaces Name WhiteSpaces ExternalID '[' intSubset ']' WhiteSpaces '>'
                  | '<' '!' 'D' 'O' 'C' 'T' 'Y' 'P' 'E' WhiteSpaces Name WhiteSpaces ExternalID WhiteSpaces '[' intSubset ']' '>'
                  | '<' '!' 'D' 'O' 'C' 'T' 'Y' 'P' 'E' WhiteSpaces Name WhiteSpaces ExternalID WhiteSpaces '[' intSubset ']' WhiteSpaces '>'

    --[28a] DeclSep ::= PEReference | S [WFC: PE Between Declarations] 
    --DeclSep ::= PEReference
    --          | WhiteSpaces

    --[28b] intSubset ::= (markupdecl | DeclSep)* 
    intSubset ::= %Empty
                | WhiteSpaces
                | intSubset markupdecl
                | intSubset PEReference
                | intSubset markupdecl WhiteSpaces
                | intSubset PEReference WhiteSpaces

    --[29] markupdecl ::= elementdecl | AttlistDecl | EntityDecl | NotationDecl | PI | Comment [VC: Proper Declaration/PE Nesting]
    markupdecl -> elementdecl
                | AttlistDecl
                | EntityDecl
                | NotationDecl
                | PI
                | Comment

    --[30] extSubset ::= TextDecl? extSubsetDecl 
    extSubset ::= extSubsetDecl 
                | TextDecl extSubsetDecl 

    --[31] extSubsetDecl ::= ( markupdecl | conditionalSect | DeclSep)* 
    extSubsetDecl ::= %Empty
                    | WhiteSpaces
                    | extSubsetDecl markupdecl
                    | extSubsetDecl conditionalSect
                    | extSubsetDecl PEReference
                    | extSubsetDecl markupdecl WhiteSpaces
                    | extSubsetDecl conditionalSect WhiteSpaces
                    | extSubsetDecl PEReference WhiteSpaces

    --[32] SDDecl ::= S 'standalone' Eq (("'" ('yes' | 'no') "'") | ('"' ('yes' | 'no') '"'))  [VC: Standalone Document Declaration] 
    SDDecl ::= WhiteSpaces 's' 't' 'a' 'n' 'd' 'a' 'l' 'o' 'n' 'e' Eq YesOrNo
    YesOrNo ::= '"' 'y' 'e' 's' '"'
              | "'" 'y' 'e' 's' "'"
              | '"' 'n' 'o' '"'
              | "'" 'n' 'o' "'"

    --[39] element ::= EmptyElemTag 
    --               | STag content ETag [WFC: Element Type Match] 
    element ::= '<' Name Attributes '/' '>'
              | '<' Name Attributes WhiteSpaces '/' '>'

              | '<' Name$SName Attributes '>' content  '<' '/' Name$EName '>'
        /.
                    checkNames($SName, $EName);
                    setResult(new Ast());
        ./
              | '<' Name$SName Attributes WhiteSpaces '>' content  '<' '/' Name$EName '>'
        /.
                    setResult(new Ast());
        ./
              | '<' Name$SName Attributes '>' content  '<' '/' Name$EName WhiteSpaces '>' 
        /.
                    setResult(new Ast());
        ./
              | '<' Name$SName Attributes WhiteSpaces '>' content  '<' '/' Name$EName WhiteSpaces$ '>' 
        /.
                    setResult(new Ast());
        ./

    --[40] STag ::= '<' Name (S Attribute)* S? '>' [WFC: Unique Att Spec]
    --STag ::= '<' Name Attributes '>'
    --       | '<' Name Attributes WhiteSpaces '>'
    Attributes ::= %Empty
                 | Attributes WhiteSpaces Attribute

    --[41] Attribute ::= Name Eq AttValue [VC: Attribute Value Type] 
    Attribute ::= Name Eq AttValue

    --[42] ETag ::= '</' Name S? '>' 
    --ETag ::= '<' '/' Name '>'
    --       | '<' '/' Name WhiteSpaces '>' 

    --[43] content ::= CharData? ((element | Reference | CDSect | PI | Comment) CharData?)* 
    --
    -- Note that since CharData can be empty, we need not be concerned about CharData?
    --
    content ::= CharData
              | content element CharData 
              | content Reference CharData
              | content CDSect CharData
              | content PI CharData
              | content Comment CharData

    --[44] EmptyElemTag ::= '<' Name (S Attribute)* S? '/>' [WFC: Unique Att Spec] 
    --EmptyElemTag ::= '<' Name Attributes '/' '>'
    --               | '<' Name Attributes WhiteSpaces '/' '>'

    --[45] elementdecl ::= '<!ELEMENT' S Name S contentspec S? '>' [VC: Unique Element Type Declaration] 
    elementdecl ::= '<' '!' 'E' 'L' 'E' 'M' 'E' 'N' 'T' WhiteSpaces Name WhiteSpaces contentspec '>'
                  | '<' '!' 'E' 'L' 'E' 'M' 'E' 'N' 'T' WhiteSpaces Name WhiteSpaces contentspec WhiteSpaces '>'

    --[46] contentspec ::= 'EMPTY' | 'ANY' | Mixed | children 
    contentspec ::= 'E' 'M' 'P' 'T' 'Y'
                  | 'A' 'N' 'Y'
                  | Mixed
                  | children 

    --[47] children ::= (choice | seq) ('?' | '*' | '+')? 
    children ::= choice
               | seq
               | choice '?'
               | seq '?'
               | choice '*'
               | seq '*'
               | choice '+'
               | seq '+'

    --[48] cp ::= (Name | choice | seq) ('?' | '*' | '+')? 
    cp ::= Name
         | choice
         | seq
         | Name '?'
         | choice '?'
         | seq '?'
         | Name '*'
         | choice '*'
         | seq '*'
         | Name '+'
         | choice '+'
         | seq '+'

    --[49] choice ::= '(' S? cp ( S? '|' S? cp )+ S? ')' [VC: Proper Group/PE Nesting]
    choice ::= '(' cp InnerChoiceContent ')'
             | '(' cp InnerChoiceContent WhiteSpaces ')'
             | '(' WhiteSpaces cp InnerChoiceContent ')'
             | '(' WhiteSpaces cp InnerChoiceContent WhiteSpaces ')'
    InnerChoiceContent ::= '|' cp
                         | '|' WhiteSpaces cp
                         | WhiteSpaces '|' cp
                         | WhiteSpaces '|' WhiteSpaces cp
                         | InnerChoiceContent '|' cp
                         | InnerChoiceContent '|' WhiteSpaces cp
                         | InnerChoiceContent WhiteSpaces '|' cp
                         | InnerChoiceContent WhiteSpaces '|' WhiteSpaces cp

    --[50] seq ::= '(' S? cp ( S? ',' S? cp )* S? ')' [VC: Proper Group/PE Nesting] 
    seq ::= '(' cp ')'
          | '(' WhiteSpaces cp ')'
          | '(' cp WhiteSpaces ')'
          | '(' WhiteSpaces cp WhiteSpaces ')'
          | '(' cp InnerSeqContent ')'
          | '(' WhiteSpaces cp InnerSeqContent ')'
          | '(' cp InnerSeqContent WhiteSpaces ')'
          | '(' WhiteSpaces cp InnerSeqContent WhiteSpaces ')'

    InnerSeqContent ::= ',' cp
                      | ',' WhiteSpaces cp
                      | WhiteSpaces ',' cp
                      | WhiteSpaces ',' WhiteSpaces cp
                      | InnerSeqContent ',' cp
                      | InnerSeqContent ',' WhiteSpaces cp
                      | InnerSeqContent WhiteSpaces ',' cp
                      | InnerSeqContent WhiteSpaces ',' WhiteSpaces cp

    --[51] Mixed ::= '(' S? '#PCDATA' (S? '|' S? Name)* S? ')*'  
    --             | '(' S? '#PCDATA' S? ')'  [VC: Proper Group/PE Nesting] 
    Mixed ::= '(' '#' 'P' 'C' 'D' 'A' 'T' 'A' ')' '*'
            | '(' WhiteSpaces '#' 'P' 'C' 'D' 'A' 'T' 'A' ')' '*'
            | '(' '#' 'P' 'C' 'D' 'A' 'T' 'A' InnerMixedContent ')' '*'  
            | '(' WhiteSpaces '#' 'P' 'C' 'D' 'A' 'T' 'A' InnerMixedContent ')' '*'  
            | '(' '#' 'P' 'C' 'D' 'A' 'T' 'A' WhiteSpaces ')' '*'  
            | '(' WhiteSpaces '#' 'P' 'C' 'D' 'A' 'T' 'A' WhiteSpaces ')' '*'  
            | '(' '#' 'P' 'C' 'D' 'A' 'T' 'A' InnerMixedContent WhiteSpaces ')' '*'  
            | '(' WhiteSpaces '#' 'P' 'C' 'D' 'A' 'T' 'A' InnerMixedContent WhiteSpaces ')' '*'  
            | '(' '#' 'P' 'C' 'D' 'A' 'T' 'A' ')'
            | '(' WhiteSpaces '#' 'P' 'C' 'D' 'A' 'T' 'A' ')'
            | '(' '#' 'P' 'C' 'D' 'A' 'T' 'A' WhiteSpaces ')'
            | '(' WhiteSpaces '#' 'P' 'C' 'D' 'A' 'T' 'A' WhiteSpaces ')'
    InnerMixedContent ::= '|' Name
                        | '|' WhiteSpaces Name
                        | WhiteSpaces '|' Name
                        | WhiteSpaces '|' WhiteSpaces Name
                        | InnerMixedContent '|' Name
                        | InnerMixedContent '|' WhiteSpaces Name
                        | InnerMixedContent WhiteSpaces '|' Name
                        | InnerMixedContent WhiteSpaces '|' WhiteSpaces Name

    --[52] AttlistDecl ::= '<!ATTLIST' S Name AttDef* S? '>' 
    AttlistDecl ::= '<' '!' 'A' 'T' 'T' 'L' 'I' 'S' 'T' WhiteSpaces Name AttDef* '>' 
                  | '<' '!' 'A' 'T' 'T' 'L' 'I' 'S' 'T' WhiteSpaces Name AttDef* WhiteSpaces '>' 
    AttDef* ::= %Empty
              | AttDef* AttDef

    --[53] AttDef ::= S Name S AttType S DefaultDecl 
    AttDef ::= WhiteSpaces Name WhiteSpaces AttType WhiteSpaces DefaultDecl 

    --[54] AttType ::= StringType | TokenizedType | EnumeratedType 
    AttType -> StringType
             | TokenizedType
             | EnumeratedType 

    --[55] StringType ::= 'CDATA' 
    StringType ::= 'C' 'D' 'A' 'T' 'A' 

    --[56] TokenizedType ::= 'ID' [VC: ID] 
    --                     | 'IDREF' [VC: IDREF] 
    --                     | 'IDREFS' [VC: IDREF] 
    --                     | 'ENTITY' [VC: Entity Name] 
    --                     | 'ENTITIES' [VC: Entity Name] 
    --                     | 'NMTOKEN' [VC: Name Token] 
    --                     | 'NMTOKENS' [VC: Name Token] 
    TokenizedType ::= 'I' 'D'
                    | 'I' 'D' 'R' 'E' 'F'
                    | 'I' 'D' 'R' 'E' 'F' 'S'
                    | 'E' 'N' 'T' 'I' 'T' 'Y'
                    | 'E' 'N' 'T' 'I' 'T' 'I' 'E' 'S'
                    | 'N' 'M' 'T' 'O' 'K' 'E' 'N'
                    | 'N' 'M' 'T' 'O' 'K' 'E' 'N' 'S'

    --[57] EnumeratedType ::= NotationType | Enumeration 
    EnumeratedType -> NotationType
                    | Enumeration 

    --[58] NotationType ::= 'NOTATION' S '(' S? Name (S? '|' S? Name)* S? ')'  [VC: Notation Attributes] 
    NotationType ::= 'N' 'O' 'T' 'A' 'T' 'I' 'O' 'N' WhiteSpaces '(' Name InnerNotationTypeContent ')'
                   | 'N' 'O' 'T' 'A' 'T' 'I' 'O' 'N' WhiteSpaces '(' Name InnerNotationTypeContent WhiteSpaces ')'
                   | 'N' 'O' 'T' 'A' 'T' 'I' 'O' 'N' WhiteSpaces '(' WhiteSpaces Name InnerNotationTypeContent ')'
                   | 'N' 'O' 'T' 'A' 'T' 'I' 'O' 'N' WhiteSpaces '(' WhiteSpaces Name InnerNotationTypeContent WhiteSpaces ')'
    InnerNotationTypeContent ::= %Empty
                               | InnerNotationTypeContent WhiteSpaces '|' Name
                               | InnerNotationTypeContent WhiteSpaces '|' WhiteSpaces Name

    --[59] Enumeration ::= '(' S? Nmtoken (S? '|' S? Nmtoken)* S? ')' [VC: Enumeration] 
    Enumeration ::= '(' Nmtoken InnerEnumerationContent ')'
                  | '(' Nmtoken InnerEnumerationContent WhiteSpaces ')'
                  | '(' WhiteSpaces Nmtoken InnerEnumerationContent ')'
                  | '(' WhiteSpaces Nmtoken InnerEnumerationContent WhiteSpaces ')'
    InnerEnumerationContent ::= %Empty
                              | InnerEnumerationContent '|' Nmtoken
                              | InnerEnumerationContent '|' WhiteSpaces Nmtoken
                              | InnerEnumerationContent WhiteSpaces '|' Nmtoken
                              | InnerEnumerationContent WhiteSpaces '|' WhiteSpaces Nmtoken

   --[60] DefaultDecl ::= '#REQUIRED' | '#IMPLIED'  
   --                   | (('#FIXED' S)? AttValue) [VC: Required Attribute] 
   DefaultDecl ::= '#' 'R' 'E' 'Q' 'U' 'I' 'R' 'E' 'D'
                 | '#' 'I' 'M' 'P' 'L' 'I' 'E' 'D'  
                 | AttValue
                 | '#' 'F' 'I' 'X' 'E' 'D' WhiteSpaces AttValue

    --[61] conditionalSect ::= includeSect | ignoreSect 
    conditionalSect -> includeSect
                     | ignoreSect 

    --[62] includeSect ::= '<![' S? 'INCLUDE' S? '[' extSubsetDecl ']]>'  [VC: Proper Conditional Section/PE Nesting] 
    includeSect ::= '<' '!' '[' 'I' 'N' 'C' 'L' 'U' 'D' 'E' '[' extSubsetDecl ']' ']' '>'
                  | '<' '!' '[' 'I' 'N' 'C' 'L' 'U' 'D' 'E' WhiteSpaces '[' extSubsetDecl ']' ']' '>'
                  | '<' '!' '[' WhiteSpaces 'I' 'N' 'C' 'L' 'U' 'D' 'E' '[' extSubsetDecl ']' ']' '>'
                  | '<' '!' '[' WhiteSpaces 'I' 'N' 'C' 'L' 'U' 'D' 'E' WhiteSpaces '[' extSubsetDecl ']' ']' '>'

    --[63] ignoreSect ::= '<![' S? 'IGNORE' S? '[' ignoreSectContents* ']]>' [VC: Proper Conditional Section/PE Nesting] 
    --[64] ignoreSectContents ::= Ignore ('<![' ignoreSectContents ']]>' Ignore)* 
    ignoreSect ::= '<' '!' '[' 'I' 'G' 'N' 'O' 'R' 'E' '[' ignoreSectContents* ']' ']' '>'
                 | '<' '!' '[' 'I' 'G' 'N' 'O' 'R' 'E' WhiteSpaces '[' ignoreSectContents* ']' ']' '>'
                 | '<' '!' '[' WhiteSpaces 'I' 'G' 'N' 'O' 'R' 'E' '[' ignoreSectContents* ']' ']' '>'
                 | '<' '!' '[' WhiteSpaces 'I' 'G' 'N' 'O' 'R' 'E' WhiteSpaces '[' ignoreSectContents* ']' ']' '>'
    ignoreSectContents* ::= Ignore
                          | Ignore ignoreSectContents
    ignoreSectContents ::= '<' '!' '[' ignoreSectContents* ']' ']' '>' Ignore
                         | ignoreSectContents '<' '!' '[' ignoreSectContents ']' ']' '>' Ignore

    --[65] Ignore ::= Char* - (Char* ('<![' | ']]>') Char*)  
    Ignore ::= %Empty
             | Ignore Char[^<]]
             | Ignore '<' Char[^!]
             | Ignore '<' '!' Char[^[]
             | Ignore ']' Char[^]]
             | Ignore ']' ']' Char[^>]

    --[66] CharRef ::= '&#' [0-9]+ ';'  
    --               | '&#x' [0-9a-fA-F]+ ';' [WFC: Legal Character] 
    CharRef ::= '&' '#' [0-9]+ ';'  
              | '&' '#' 'x' [0-9a-fA-F]+ ';'
    
    [0-9]+ ::= AsciiDigit
             | [0-9]+ AsciiDigit

    [0-9a-fA-F]+ ::= AsciiDigit
                   | AsciiLetter
                   | [0-9a-fA-F]+ AsciiDigit
                   | [0-9a-fA-F]+ AsciiLetter

    --[67] Reference ::= EntityRef | CharRef 
    Reference -> EntityRef
               | CharRef 

    --[68] EntityRef ::= '&' Name ';' [WFC: Entity Declared] 
    EntityRef ::= '&' Name ';'

    --[69] PEReference ::= '%' Name ';' [VC: Entity Declared] 
    PEReference ::= '%' Name ';'

    --[70] EntityDecl ::= GEDecl | PEDecl 
    EntityDecl -> GEDecl
                | PEDecl 

    --[71] GEDecl ::= '<!ENTITY' S Name S EntityDef S? '>' 
    GEDecl ::= '<' '!' 'E' 'N' 'T' 'I' 'T' 'Y' WhiteSpaces Name WhiteSpaces EntityValue '>' 
             | '<' '!' 'E' 'N' 'T' 'I' 'T' 'Y' WhiteSpaces Name WhiteSpaces EntityValue WhiteSpaces '>' 
             | '<' '!' 'E' 'N' 'T' 'I' 'T' 'Y' WhiteSpaces Name WhiteSpaces ExternalID '>' 
             | '<' '!' 'E' 'N' 'T' 'I' 'T' 'Y' WhiteSpaces Name WhiteSpaces ExternalID WhiteSpaces '>' 
             | '<' '!' 'E' 'N' 'T' 'I' 'T' 'Y' WhiteSpaces Name WhiteSpaces ExternalID NDataDecl '>' 
             | '<' '!' 'E' 'N' 'T' 'I' 'T' 'Y' WhiteSpaces Name WhiteSpaces ExternalID NDataDecl WhiteSpaces '>' 

    --[72] PEDecl ::= '<!ENTITY' S '%' S Name S PEDef S? '>' 
    PEDecl ::= '<' '!' 'E' 'N' 'T' 'I' 'T' 'Y' WhiteSpaces '%' WhiteSpaces Name WhiteSpaces PEDef '>' 
             | '<' '!' 'E' 'N' 'T' 'I' 'T' 'Y' WhiteSpaces '%' WhiteSpaces Name WhiteSpaces PEDef WhiteSpaces '>' 

    --[73] EntityDef ::= EntityValue| (ExternalID NDataDecl?) 
    -- EntityDef ::= EntityValue
    --             | ExternalID 
    --             | ExternalID NDataDecl 

    --[74] PEDef ::= EntityValue | ExternalID 
    PEDef -> EntityValue 
           | ExternalID 

    --[75] ExternalID ::= 'SYSTEM' S SystemLiteral 
    --                  | 'PUBLIC' S PubidLiteral S SystemLiteral 
    ExternalID ::= 'S' 'Y' 'S' 'T' 'E' 'M' WhiteSpaces SystemLiteral 
                 | 'P' 'U' 'B' 'L' 'I' 'C' WhiteSpaces PubidLiteral WhiteSpaces SystemLiteral 

    --[76] NDataDecl ::= S 'NDATA' S Name [VC: Notation Declared] 
    NDataDecl ::= WhiteSpaces 'N' 'D' 'A' 'T' 'A' WhiteSpaces Name

    --[77] TextDecl ::= '<?xml' VersionInfo? EncodingDecl S? '?>' 
    TextDecl ::= '<' '?' Xx Mm Ll EncodingDecl  '?' '>' 
               | '<' '?' Xx Mm Ll EncodingDecl WhiteSpaces '?' '>' 
               | '<' '?' Xx Mm Ll VersionInfo EncodingDecl '?' '>' 
               | '<' '?' Xx Mm Ll VersionInfo EncodingDecl WhiteSpaces '?' '>' 

    --[78] extParsedEnt ::= TextDecl? content 
    extParsedEnt ::= content 
                   | TextDecl content 

    --[80] EncodingDecl ::= S 'encoding' Eq ('"' EncName '"' | "'" EncName "'" )  
    EncodingDecl ::= WhiteSpaces 'e' 'n' 'c' 'o' 'd' 'i' 'n' 'g' Eq '"' EncName '"'
                   | WhiteSpaces 'e' 'n' 'c' 'o' 'd' 'i' 'n' 'g' Eq "'" EncName "'"

    --[81] EncName ::= [A-Za-z] ([A-Za-z0-9._] | '-')* 
    EncName ::= AsciiLetter
              | EncName AsciiLetter
              | EncName AsciiDigit
              | EncName '.'
              | EncName '_'
              | EncName '-'

    --[82] NotationDecl ::= '<!NOTATION' S Name S (ExternalID | PublicID) S? '>' [VC: Unique Notation Name] 
    NotationDecl ::= '<' '!' 'N' 'O' 'T' 'A' 'T' 'I' 'O' 'N' WhiteSpaces Name WhiteSpaces 'S' 'Y' 'S' 'T' 'E' 'M' WhiteSpaces SystemLiteral '>'
                   | '<' '!' 'N' 'O' 'T' 'A' 'T' 'I' 'O' 'N' WhiteSpaces Name WhiteSpaces 'S' 'Y' 'S' 'T' 'E' 'M' WhiteSpaces SystemLiteral WhiteSpaces '>'
                   | '<' '!' 'N' 'O' 'T' 'A' 'T' 'I' 'O' 'N' WhiteSpaces Name WhiteSpaces 'P' 'U' 'B' 'L' 'I' 'C' WhiteSpaces PubidLiteral WhiteSpaces SystemLiteral '>'
                   | '<' '!' 'N' 'O' 'T' 'A' 'T' 'I' 'O' 'N' WhiteSpaces Name WhiteSpaces 'P' 'U' 'B' 'L' 'I' 'C' WhiteSpaces PubidLiteral WhiteSpaces SystemLiteral WhiteSpaces '>'
                   | '<' '!' 'N' 'O' 'T' 'A' 'T' 'I' 'O' 'N' WhiteSpaces Name WhiteSpaces 'P' 'U' 'B' 'L' 'I' 'C' WhiteSpaces PubidLiteral '>'
                   | '<' '!' 'N' 'O' 'T' 'A' 'T' 'I' 'O' 'N' WhiteSpaces Name WhiteSpaces 'P' 'U' 'B' 'L' 'I' 'C' WhiteSpaces PubidLiteral WhiteSpaces '>'

    --[83] PublicID ::= 'PUBLIC' S PubidLiteral 
    -- PublicID ::= 'P' 'U' 'B' 'L' 'I' 'C' WhiteSpaces PubidLiteral 

    --[84] Letter ::= BaseChar | Ideographic 
    Letter -> BaseChar
            | Ideographic 

    --[85]    BaseChar ::= [#x0041-#x005A]
    --         | [#x0061-#x007A]
    --         | [#x00C0-#x00D6]
    --         | [#x00D8-#x00F6]
    --         | [#x00F8-#x00FF]
    --         | [#x0100-#x0131]
    --         | [#x0134-#x013E]
    --         | [#x0141-#x0148]
    --         | [#x014A-#x017E]
    --         | [#x0180-#x01C3]
    --         | [#x01CD-#x01F0]
    --         | [#x01F4-#x01F5]
    --         | [#x01FA-#x0217]
    --         | [#x0250-#x02A8]
    --         | [#x02BB-#x02C1]
    --         | #x0386
    --         | [#x0388-#x038A]
    --         | #x038C
    --         | [#x038E-#x03A1]
    --         | [#x03A3-#x03CE]
    --         | [#x03D0-#x03D6]
    --         | #x03DA
    --         | #x03DC
    --         | #x03DE
    --         | #x03E0
    --         | [#x03E2-#x03F3]
    --         | [#x0401-#x040C]
    --         | [#x040E-#x044F]
    --         | [#x0451-#x045C]
    --         | [#x045E-#x0481]
    --         | [#x0490-#x04C4]
    --         | [#x04C7-#x04C8]
    --         | [#x04CB-#x04CC]
    --         | [#x04D0-#x04EB]
    --         | [#x04EE-#x04F5]
    --         | [#x04F8-#x04F9]
    --         | [#x0531-#x0556]
    --         | #x0559
    --         | [#x0561-#x0586]
    --         | [#x05D0-#x05EA]
    --         | [#x05F0-#x05F2]
    --         | [#x0621-#x063A]
    --         | [#x0641-#x064A]
    --         | [#x0671-#x06B7]
    --         | [#x06BA-#x06BE]
    --         | [#x06C0-#x06CE]
    --         | [#x06D0-#x06D3]
    --         | #x06D5
    --         | [#x06E5-#x06E6]
    --         | [#x0905-#x0939]
    --         | #x093D
    --         | [#x0958-#x0961]
    --         | [#x0985-#x098C]
    --         | [#x098F-#x0990]
    --         | [#x0993-#x09A8]
    --         | [#x09AA-#x09B0]
    --         | #x09B2
    --         | [#x09B6-#x09B9]
    --         | [#x09DC-#x09DD]
    --         | [#x09DF-#x09E1]
    --         | [#x09F0-#x09F1]
    --         | [#x0A05-#x0A0A]
    --         | [#x0A0F-#x0A10]
    --         | [#x0A13-#x0A28]
    --         | [#x0A2A-#x0A30]
    --         | [#x0A32-#x0A33]
    --         | [#x0A35-#x0A36]
    --         | [#x0A38-#x0A39]
    --         | [#x0A59-#x0A5C]
    --         | #x0A5E
    --         | [#x0A72-#x0A74]
    --         | [#x0A85-#x0A8B]
    --         | #x0A8D
    --         | [#x0A8F-#x0A91]
    --         | [#x0A93-#x0AA8]
    --         | [#x0AAA-#x0AB0]
    --         | [#x0AB2-#x0AB3]
    --         | [#x0AB5-#x0AB9]
    --         | #x0ABD
    --         | #x0AE0
    --         | [#x0B05-#x0B0C]
    --         | [#x0B0F-#x0B10]
    --         | [#x0B13-#x0B28]
    --         | [#x0B2A-#x0B30]
    --         | [#x0B32-#x0B33]
    --         | [#x0B36-#x0B39]
    --         | #x0B3D
    --         | [#x0B5C-#x0B5D]
    --         | [#x0B5F-#x0B61]
    --         | [#x0B85-#x0B8A]
    --         | [#x0B8E-#x0B90]
    --         | [#x0B92-#x0B95]
    --         | [#x0B99-#x0B9A]
    --         | #x0B9C
    --         | [#x0B9E-#x0B9F]
    --         | [#x0BA3-#x0BA4]
    --         | [#x0BA8-#x0BAA]
    --         | [#x0BAE-#x0BB5]
    --         | [#x0BB7-#x0BB9]
    --         | [#x0C05-#x0C0C]
    --         | [#x0C0E-#x0C10]
    --         | [#x0C12-#x0C28]
    --         | [#x0C2A-#x0C33]
    --         | [#x0C35-#x0C39]
    --         | [#x0C60-#x0C61]
    --         | [#x0C85-#x0C8C]
    --         | [#x0C8E-#x0C90]
    --         | [#x0C92-#x0CA8]
    --         | [#x0CAA-#x0CB3]
    --         | [#x0CB5-#x0CB9]
    --         | #x0CDE
    --         | [#x0CE0-#x0CE1]
    --         | [#x0D05-#x0D0C]
    --         | [#x0D0E-#x0D10]
    --         | [#x0D12-#x0D28]
    --         | [#x0D2A-#x0D39]
    --         | [#x0D60-#x0D61]
    --         | [#x0E01-#x0E2E]
    --         | #x0E30
    --         | [#x0E32-#x0E33]
    --         | [#x0E40-#x0E45]
    --         | [#x0E81-#x0E82]
    --         | #x0E84
    --         | [#x0E87-#x0E88]
    --         | #x0E8A
    --         | #x0E8D
    --         | [#x0E94-#x0E97]
    --         | [#x0E99-#x0E9F]
    --         | [#x0EA1-#x0EA3]
    --         | #x0EA5
    --         | #x0EA7
    --         | [#x0EAA-#x0EAB]
    --         | [#x0EAD-#x0EAE]
    --         | #x0EB0
    --         | [#x0EB2-#x0EB3]
    --         | #x0EBD
    --         | [#x0EC0-#x0EC4]
    --         | [#x0F40-#x0F47]
    --         | [#x0F49-#x0F69]
    --         | [#x10A0-#x10C5]
    --         | [#x10D0-#x10F6]
    --         | #x1100
    --         | [#x1102-#x1103]
    --         | [#x1105-#x1107]
    --         | #x1109
    --         | [#x110B-#x110C]
    --         | [#x110E-#x1112]
    --         | #x113C
    --         | #x113E
    --         | #x1140
    --         | #x114C
    --         | #x114E
    --         | #x1150
    --         | [#x1154-#x1155]
    --         | #x1159
    --         | [#x115F-#x1161]
    --         | #x1163
    --         | #x1165
    --         | #x1167
    --         | #x1169
    --         | [#x116D-#x116E]
    --         | [#x1172-#x1173]
    --         | #x1175
    --         | #x119E
    --         | #x11A8
    --         | #x11AB
    --         | [#x11AE-#x11AF]
    --         | [#x11B7-#x11B8]
    --         | #x11BA
    --         | [#x11BC-#x11C2]
    --         | #x11EB
    --         | #x11F0
    --         | #x11F9
    --         | [#x1E00-#x1E9B]
    --         | [#x1EA0-#x1EF9]
    --         | [#x1F00-#x1F15]
    --         | [#x1F18-#x1F1D]
    --         | [#x1F20-#x1F45]
    --         | [#x1F48-#x1F4D]
    --         | [#x1F50-#x1F57]
    --         | #x1F59
    --         | #x1F5B
    --         | #x1F5D
    --         | [#x1F5F-#x1F7D]
    --         | [#x1F80-#x1FB4]
    --         | [#x1FB6-#x1FBC]
    --         | #x1FBE
    --         | [#x1FC2-#x1FC4]
    --         | [#x1FC6-#x1FCC]
    --         | [#x1FD0-#x1FD3]
    --         | [#x1FD6-#x1FDB]
    --         | [#x1FE0-#x1FEC]
    --         | [#x1FF2-#x1FF4]
    --         | [#x1FF6-#x1FFC]
    --         | #x2126
    --         | [#x212A-#x212B]
    --         | #x212E
    --         | [#x2180-#x2182]
    --         | [#x3041-#x3094]
    --         | [#x30A1-#x30FA]
    --         | [#x3105-#x312C]
    --         | [#xAC00-#xD7A3]  

    BaseChar -> AsciiLetter
              | NonAsciiBaseChar

    --[86] Ideographic ::= [#x4E00-#x9FA5]
    --                   | #x3007
    --                   | [#x3021-#x3029]  
    --[87] CombiningChar ::= [#x0300-#x0345]
    --                     | [#x0360-#x0361]
    --                     | [#x0483-#x0486]
    --                     | [#x0591-#x05A1]
    --                     | [#x05A3-#x05B9]
    --                     | [#x05BB-#x05BD]
    --                     | #x05BF
    --                     | [#x05C1-#x05C2]
    --                     | #x05C4
    --                     | [#x064B-#x0652]
    --                     | #x0670
    --                     | [#x06D6-#x06DC]
    --                     | [#x06DD-#x06DF]
    --                     | [#x06E0-#x06E4]
    --                     | [#x06E7-#x06E8]
    --                     | [#x06EA-#x06ED]
    --                     | [#x0901-#x0903]
    --                     | #x093C
    --                     | [#x093E-#x094C]
    --                     | #x094D
    --                     | [#x0951-#x0954]
    --                     | [#x0962-#x0963]
    --                     | [#x0981-#x0983]
    --                     | #x09BC
    --                     | #x09BE
    --                     | #x09BF
    --                     | [#x09C0-#x09C4]
    --                     | [#x09C7-#x09C8]
    --                     | [#x09CB-#x09CD]
    --                     | #x09D7
    --                     | [#x09E2-#x09E3]
    --                     | #x0A02
    --                     | #x0A3C
    --                     | #x0A3E
    --                     | #x0A3F
    --                     | [#x0A40-#x0A42]
    --                     | [#x0A47-#x0A48]
    --                     | [#x0A4B-#x0A4D]
    --                     | [#x0A70-#x0A71]
    --                     | [#x0A81-#x0A83]
    --                     | #x0ABC
    --                     | [#x0ABE-#x0AC5]
    --                     | [#x0AC7-#x0AC9]
    --                     | [#x0ACB-#x0ACD]
    --                     | [#x0B01-#x0B03]
    --                     | #x0B3C
    --                     | [#x0B3E-#x0B43]
    --                     | [#x0B47-#x0B48]
    --                     | [#x0B4B-#x0B4D]
    --                     | [#x0B56-#x0B57]
    --                     | [#x0B82-#x0B83]
    --                     | [#x0BBE-#x0BC2]
    --                     | [#x0BC6-#x0BC8]
    --                     | [#x0BCA-#x0BCD]
    --                     | #x0BD7
    --                     | [#x0C01-#x0C03]
    --                     | [#x0C3E-#x0C44]
    --                     | [#x0C46-#x0C48]
    --                     | [#x0C4A-#x0C4D]
    --                     | [#x0C55-#x0C56]
    --                     | [#x0C82-#x0C83]
    --                     | [#x0CBE-#x0CC4]
    --                     | [#x0CC6-#x0CC8]
    --                     | [#x0CCA-#x0CCD]
    --                     | [#x0CD5-#x0CD6]
    --                     | [#x0D02-#x0D03]
    --                     | [#x0D3E-#x0D43]
    --                     | [#x0D46-#x0D48]
    --                     | [#x0D4A-#x0D4D]
    --                     | #x0D57
    --                     | #x0E31
    --                     | [#x0E34-#x0E3A]
    --                     | [#x0E47-#x0E4E]
    --                     | #x0EB1
    --                     | [#x0EB4-#x0EB9]
    --                     | [#x0EBB-#x0EBC]
    --                     | [#x0EC8-#x0ECD]
    --                     | [#x0F18-#x0F19]
    --                     | #x0F35
    --                     | #x0F37
    --                     | #x0F39
    --                     | #x0F3E
    --                     | #x0F3F
    --                     | [#x0F71-#x0F84]
    --                     | [#x0F86-#x0F8B]
    --                     | [#x0F90-#x0F95]
    --                     | #x0F97
    --                     | [#x0F99-#x0FAD]
    --                     | [#x0FB1-#x0FB7]
    --                     | #x0FB9
    --                     | [#x20D0-#x20DC]
    --                     | #x20E1
    --                     | [#x302A-#x302F]
    --                     | #x3099
    --                     | #x309A  

    --[88] Digit ::= [#x0030-#x0039]
    --             | [#x0660-#x0669]
    --             | [#x06F0-#x06F9]
    --             | [#x0966-#x096F]
    --             | [#x09E6-#x09EF]
    --             | [#x0A66-#x0A6F]
    --             | [#x0AE6-#x0AEF]
    --             | [#x0B66-#x0B6F]
    --             | [#x0BE7-#x0BEF]
    --             | [#x0C66-#x0C6F]
    --             | [#x0CE6-#x0CEF]
    --             | [#x0D66-#x0D6F]
    --             | [#x0E50-#x0E59]
    --             | [#x0ED0-#x0ED9]
    --             | [#x0F20-#x0F29]  
    Digit -> AsciiDigit
           | NonAsciiDigit

    --[89] Extender ::= #x00B7
    --                | #x02D0
    --                | #x02D1
    --                | #x0387
    --                | #x0640
    --                | #x0E46
    --                | #x0EC6
    --                | #x3005
    --                | [#x3031-#x3035]
    --                | [#x309D-#x309E]
    --                | [#x30FC-#x30FE]  
%End

%Import
    XmlCharSubsets.gi
  %DropSymbols
       NonSpaceChar
%End
