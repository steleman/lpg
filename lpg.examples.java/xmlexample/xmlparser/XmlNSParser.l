
Options in effect for D:/eclipse/workspace/lpg.javaruntime.examples/xmlexample/xmlparser/XmlNSParser.gnew:

    ACTION-BLOCK=("D:\eclipse\workspace\lpg.javaruntime.examples\xmlexample\xmlparser\XmlParser.java","/.","./")

    AST-DIRECTORY=""  AST-TYPE="Ast"  NOATTRIBUTES  NOAUTOMATIC-AST  NOBACKTRACK
    BYTE  CONFLICTS  
    DAT-DIRECTORY="D:\eclipse\workspace\lpg.javaruntime.examples\xmlexample\xmlparser\"
    BYTE  CONFLICTS  
    DAT-FILE="D:\eclipse\workspace\lpg.javaruntime.examples\xmlexample\xmlparser\XmlParserdcl.data"
    BYTE  CONFLICTS  
    DCL-FILE="D:\eclipse\workspace\lpg.javaruntime.examples\xmlexample\xmlparser\XmlParserdcl.java"
    BYTE  CONFLICTS  NODEBUG  
    DEF-FILE="D:\eclipse\workspace\lpg.javaruntime.examples\xmlexample\xmlparser\XmlParserdef.java"
    BYTE  CONFLICTS  NODEBUG  NOEDIT  ERROR-MAPS  ESCAPE='$'  
    EXPORT-TERMINALS=("D:\eclipse\workspace\lpg.javaruntime.examples\xmlexample\xmlparser\XmlParserexp.java","","")
    BYTE  CONFLICTS  NODEBUG  NOEDIT  ERROR-MAPS  ESCAPE='$'  EXTENDS-PARSETABLE
    FACTORY="new "  FILE-PREFIX="XmlParser"  NOFIRST  NOFOLLOW  NOGLR  
    NOGOTO-DEFAULT  
    GRM-FILE="D:/eclipse/workspace/lpg.javaruntime.examples/xmlexample/xmlparser/XmlNSParser.gnew"
    NOGOTO-DEFAULT  
    IMP-FILE="D:\eclipse\workspace\lpg.javaruntime.examples\xmlexample\xmlparser\XmlParserimp.java"
    NOGOTO-DEFAULT  
    INCLUDE-DIRECTORY="D:\eclipse\workspace\lpg.javaruntime.examples\xmlexample\xmlparser\;.;D:\eclipse\workspace\lpgjavaruntime\include;D:\eclipse\workspace;D:\eclipse\workspace\com.ibm.db.parsers.sql2003\src\com\ibm\db\parsers\sql2003;D:\eclipse\workspace\com.ibm.db.parsers.sql2003\src\com\ibm\db\parsers\sql2003\lexer;D:\eclipse\workspace\com.ibm.db.parsers.sql.common.db2.lexer\src\com\ibm\db\parsers\sql\common\db2\lexer;D:\eclipse\workspace\com.ibm.db.parsers.sql.routines.db2.common\src\com\ibm\db\parsers\sql\routines\db2\common;"
    NOGOTO-DEFAULT  LALR=15  LIST  MARGIN=4  MAX-CASES=1024  NAMES=OPTIMIZED  
    NONT-CHECK  OR_MARKER='|'  
    OUT-DIRECTORY="D:\eclipse\workspace\lpg.javaruntime.examples\xmlexample\xmlparser\"
    NONT-CHECK  OR_MARKER='|'  PACKAGE="xmlparser"  NOPARENT-SAVE  
    PARSETABLE-INTERFACES="lpg.javaruntime.ParseTable"  PREFIX="Char_"  PRIORITY
    PROGRAMMING_LANGUAGE=JAVA  
    PRS-FILE="D:\eclipse\workspace\lpg.javaruntime.examples\xmlexample\xmlparser\XmlParserprs.java"
    PROGRAMMING_LANGUAGE=JAVA  NOQUIET  READ-REDUCE  REMAP-TERMINALS  SCOPES  
    NOSERIALIZE  NOSHIFT-DEFAULT  SINGLE-PRODUCTIONS  NOSOFT-KEYWORDS  NOSTATES
    SUFFIX=""  
    SYM-FILE="D:\eclipse\workspace\lpg.javaruntime.examples\xmlexample\xmlparser\XmlParsersym.java"
    SUFFIX=""  TAB-FILE="XmlNSParser.t"  TABLE  TEMPLATE="dtUnifiedTemplate.g"
    TRACE=CONFLICTS  VARIABLES=NONTERMINALS  NOVERBOSE  NOVISITOR  
    VISITOR-TYPE="Visitor"  WARNINGS  NOXREF  


Predefined Macros:

    $rule_number
    $rule_text
    $rule_size
    $input_file
    $current_line
    $next_line
    $#identifier
    $symbol_declarations
    $num_rules
    $num_terminals
    $num_nonterminals
    $num_non_terminals
    $num_symbols
    $template
    $file_prefix
    $package
    $ast_package
    $ast_type
    $exp_type
    $prs_type
    $sym_type
    $action_type
    $visitor_type



Defined Symbols:



    $Header
    /.    
                    //    
                    // Rule $rule_number:  $rule_text    
                    //./


    $BeginAction
    /. $Header    
                    case $rule_number: {./


    $EndAction
    /.          break;    
                    }./


    $BeginJava
    /.$BeginAction    
                        $symbol_declarations./


    $EndJava
    /.$EndAction./


    $NoAction
    /. $Header    
                    case $rule_number:    
                        break;./


    $NullAction
    /. $Header    
                    case $rule_number:    
                        $setResult(null);    
                        break;./


    $BeginActions
    /.    
            public void ruleAction(int ruleNumber)    
            {    
                switch (ruleNumber)    
                {./


    $SplitActions
    /.    
    	            default:    
    	                ruleAction$rule_number(ruleNumber);    
    	                break;    
    	        }    
    	        return;    
    	    }    
    	    
    	    public void ruleAction$rule_number(int ruleNumber)    
    	    {    
    	        switch (ruleNumber)    
    	        {./


    $EndActions
    /.    
                    default:    
                        break;    
                }    
                return;    
            }./


    $additional_interfaces
    /../


    $super_stream_class
    /.Utf8LpgLexStream./


Aliases:

    ! ::= Exclamation
    '"' ::= DoubleQuote
    # ::= Sharp
    '$' ::= DollarSign
    % ::= Percent
    & ::= Ampersand
    "'" ::= SingleQuote
    ( ::= LeftParen
    ) ::= RightParen
    * ::= Star
    + ::= Plus
    , ::= Comma
    - ::= Minus
    . ::= Dot
    / ::= Slash
    : ::= Colon
    ; ::= SemiColon
    < ::= LessThan
    = ::= Equal
    > ::= GreaterThan
    ? ::= QuestionMark
    @ ::= AtSign
    [ ::= LeftBracket
    \ ::= BackSlash
    ] ::= RightBracket
    ^ ::= Caret
    ` ::= BackQuote
    { ::= LeftBrace
    '|' ::= VerticalBar
    } ::= RightBrace
    ~ ::= Tilde


Start:

    document

Eof:

    EOF

Error:

    Unused

Terminals:

    HT
    LF
    CR
    Space
    Exclamation
    DoubleQuote
    Sharp
    DollarSign
    Percent
    Ampersand
    SingleQuote
    LeftParen
    RightParen
    Star
    Plus
    Comma
    Minus
    Dot
    Slash
    0
    1
    2
    3
    4
    5
    6
    7
    8
    9
    Colon
    SemiColon
    LessThan
    Equal
    GreaterThan
    QuestionMark
    AtSign
    A
    B
    C
    D
    E
    F
    G
    H
    I
    J
    K
    L
    M
    N
    O
    P
    Q
    R
    S
    T
    U
    V
    W
    X
    Y
    Z
    LeftBracket
    BackSlash
    RightBracket
    Caret
    _
    BackQuote
    a
    b
    c
    d
    e
    f
    g
    h
    i
    j
    k
    l
    m
    n
    o
    p
    q
    r
    s
    t
    u
    v
    w
    x
    y
    z
    LeftBrace
    VerticalBar
    RightBrace
    Tilde
    NonAsciiBaseChar
    Ideographic
    CombiningChar
    Extender
    NonAsciiDigit
    OtherValidChar
    Unused
    ExtSubsetMarker
    ExtParserEntMarker
    EOF


Soft Keywords:



Rules:

1      NameChar[^:] -> Aa
2                    | Bb
3                    | Cc
4                    | Dd
5                    | Ee
6                    | Ff
7                    | Gg
8                    | Hh
9                    | Ii
10                   | Jj
11                   | Kk
12                   | Ll
13                   | Mm
14                   | Nn
15                   | Oo
16                   | Pp
17                   | Qq
18                   | Rr
19                   | Ss
20                   | Tt
21                   | Uu
22                   | Vv
23                   | Ww
24                   | Xx
25                   | Yy
26                   | Zz
27                   | NonAsciiBaseChar
28                   | Ideographic
29                   | Digit
30                   | .
31                   | -
32                   | _
33                   | CombiningChar
34                   | Extender
35     NameChar[^x:] -> A
36                    | B
37                    | C
38                    | D
39                    | E
40                    | F
41                    | G
42                    | H
43                    | I
44                    | J
45                    | K
46                    | L
47                    | M
48                    | N
49                    | O
50                    | P
51                    | Q
52                    | R
53                    | S
54                    | T
55                    | U
56                    | V
57                    | W
58                    | X
59                    | Y
60                    | Z
61                    | a
62                    | b
63                    | c
64                    | d
65                    | e
66                    | f
67                    | g
68                    | h
69                    | i
70                    | j
71                    | k
72                    | l
73                    | m
74                    | n
75                    | o
76                    | p
77                    | q
78                    | r
79                    | s
80                    | t
81                    | u
82                    | v
83                    | w
84                    | y
85                    | z
86                    | NonAsciiBaseChar
87                    | Ideographic
88                    | Digit
89                    | .
90                    | -
91                    | _
92                    | CombiningChar
93                    | Extender
94     NameChar[^m:] -> A
95                    | B
96                    | C
97                    | D
98                    | E
99                    | F
100                   | G
101                   | H
102                   | I
103                   | J
104                   | K
105                   | L
106                   | M
107                   | N
108                   | O
109                   | P
110                   | Q
111                   | R
112                   | S
113                   | T
114                   | U
115                   | V
116                   | W
117                   | X
118                   | Y
119                   | Z
120                   | a
121                   | b
122                   | c
123                   | d
124                   | e
125                   | f
126                   | g
127                   | h
128                   | i
129                   | j
130                   | k
131                   | l
132                   | n
133                   | o
134                   | p
135                   | q
136                   | r
137                   | s
138                   | t
139                   | u
140                   | v
141                   | w
142                   | x
143                   | y
144                   | z
145                   | NonAsciiBaseChar
146                   | Ideographic
147                   | Digit
148                   | .
149                   | -
150                   | _
151                   | CombiningChar
152                   | Extender
153    NameChar[^l:] -> A
154                   | B
155                   | C
156                   | D
157                   | E
158                   | F
159                   | G
160                   | H
161                   | I
162                   | J
163                   | K
164                   | L
165                   | M
166                   | N
167                   | O
168                   | P
169                   | Q
170                   | R
171                   | S
172                   | T
173                   | U
174                   | V
175                   | W
176                   | X
177                   | Y
178                   | Z
179                   | a
180                   | b
181                   | c
182                   | d
183                   | e
184                   | f
185                   | g
186                   | h
187                   | i
188                   | j
189                   | k
190                   | m
191                   | n
192                   | o
193                   | p
194                   | q
195                   | r
196                   | s
197                   | t
198                   | u
199                   | v
200                   | w
201                   | x
202                   | y
203                   | z
204                   | NonAsciiBaseChar
205                   | Ideographic
206                   | Digit
207                   | .
208                   | -
209                   | _
210                   | CombiningChar
211                   | Extender
212    NameChar[^n:] -> A
213                   | B
214                   | C
215                   | D
216                   | E
217                   | F
218                   | G
219                   | H
220                   | I
221                   | J
222                   | K
223                   | L
224                   | M
225                   | N
226                   | O
227                   | P
228                   | Q
229                   | R
230                   | S
231                   | T
232                   | U
233                   | V
234                   | W
235                   | X
236                   | Y
237                   | Z
238                   | a
239                   | b
240                   | c
241                   | d
242                   | e
243                   | f
244                   | g
245                   | h
246                   | i
247                   | j
248                   | k
249                   | l
250                   | m
251                   | o
252                   | p
253                   | q
254                   | r
255                   | s
256                   | t
257                   | u
258                   | v
259                   | w
260                   | x
261                   | y
262                   | z
263                   | NonAsciiBaseChar
264                   | Ideographic
265                   | Digit
266                   | .
267                   | -
268                   | _
269                   | CombiningChar
270                   | Extender
271    NameChar[^s:] -> A
272                   | B
273                   | C
274                   | D
275                   | E
276                   | F
277                   | G
278                   | H
279                   | I
280                   | J
281                   | K
282                   | L
283                   | M
284                   | N
285                   | O
286                   | P
287                   | Q
288                   | R
289                   | S
290                   | T
291                   | U
292                   | V
293                   | W
294                   | X
295                   | Y
296                   | Z
297                   | a
298                   | b
299                   | c
300                   | d
301                   | e
302                   | f
303                   | g
304                   | h
305                   | i
306                   | j
307                   | k
308                   | l
309                   | m
310                   | n
311                   | o
312                   | p
313                   | q
314                   | r
315                   | t
316                   | u
317                   | v
318                   | w
319                   | x
320                   | y
321                   | z
322                   | NonAsciiBaseChar
323                   | Ideographic
324                   | Digit
325                   | .
326                   | -
327                   | _
328                   | CombiningChar
329                   | Extender
330    document ::= prolog element Misc* $
331               | ExtSubsetMarker extSubset
332               | ExtParserEntMarker extParsedEnt
333    WhiteSpaces ::= SpaceChar
334                  | WhiteSpaces SpaceChar
335    NameChar -> Letter
336              | Digit
337              | .
338              | -
339              | _
340              | :
341              | CombiningChar
342              | Extender
343    Name ::= Letter
344           | _
345           | :
346           | Name NameChar
347    Names ::= Name
348            | Names U0020 Name
349    Nmtoken ::= NameChar
350              | Nmtoken NameChar
351    Nmtokens ::= Nmtoken
352               | Nmtokens U0020 Nmtoken
353    EntityValue ::= '"' DoubleEntityValueContent '"'
354                  | "'" SingleEntityValueContent "'"
355    DoubleEntityValueContent ::= $Empty
356                               | DoubleEntityValueContent 'Char[^%&\"]'
357                               | DoubleEntityValueContent PEReference
358                               | DoubleEntityValueContent Reference
359    SingleEntityValueContent ::= $Empty
360                               | SingleEntityValueContent "Char[^%&\']"
361                               | SingleEntityValueContent PEReference
362                               | SingleEntityValueContent Reference
363    AttValue ::= '"' DoubleAttValueContent '"'
364               | "'" SingleAttValueContent "'"
365    DoubleAttValueContent ::= $Empty
366                            | DoubleAttValueContent 'Char[^<&\"]'
367                            | DoubleAttValueContent Reference
368    SingleAttValueContent ::= $Empty
369                            | SingleAttValueContent "Char[^<&\']"
370                            | SingleAttValueContent Reference
371    SystemLiteral ::= '"' DoubleSystemLiteralContent '"'
372                    | "'" SingleSystemLiteralContent "'"
373    DoubleSystemLiteralContent ::= $Empty
374                                 | DoubleSystemLiteralContent 'Char[^\"]'
375    SingleSystemLiteralContent ::= $Empty
376                                 | SingleSystemLiteralContent "Char[^\']"
377    PubidLiteral ::= '"' DoublePubidLiteralContent '"'
378                   | "'" SinglePubidLiteralContent "'"
379    DoublePubidLiteralContent ::= $Empty
380                                | DoublePubidLiteralContent PubidChar
381    SinglePubidLiteralContent ::= $Empty
382                                | SinglePubidLiteralContent "PubidChar[^\']"
383    PubidChar -> "PubidChar[^\']"
384               | "'"
385    CharData ::= CharDataContent
386               | CharDataContent ]
387               | CharDataContent 2OrMoreBrackets
388    CharDataContent ::= $Empty
389                      | CharDataContent 2OrMoreBrackets Char[^<&]>]
390                      | CharDataContent >
391                      | CharDataContent ] Char[^<&]]
392                      | CharDataContent Char[^<&]>]
393    2OrMoreBrackets ::= ] ]
394                      | 2OrMoreBrackets ]
395    Comment ::= < ! - - CommentContent - - >
396              | < ! - - CommentContent - - - >
397    CommentContent ::= $Empty
398                     | CommentContent Char[^-]
399                     | CommentContent - Char[^-]
400    PI ::= < ? PITarget ? >
401         | < ? PITarget WhiteSpaces ? >
402         | < ? PITarget WhiteSpaces AfterPITarget Questions >
403    AfterPITarget ::= NonSpaceChar[^?>]
404                    | Questions Char[^?>]
405                    | >
406                    | AfterPITarget Questions Char[^?>]
407                    | AfterPITarget >
408                    | AfterPITarget Char[^?>]
409    Questions ::= ?
410                | Questions ?
411    PITarget ::= Letter[^Xx] PITargettail
412               | Xx
413               | Xx NameChar[^Mm] PITargettail
414               | Xx Mm
415               | Xx Mm NameChar[^Ll] PITargettail
416               | Xx Mm Ll NameChar PITargettail
417               | _ PITargettail
418               | : PITargettail
419    PITargettail ::= $Empty
420                   | PITargettail NameChar
421    CDSect ::= < ! [ C D A T A [ CData 2OrMoreBrackets >
422    CData ::= $Empty
423            | CData 2OrMoreBrackets Char[^]>]
424            | CData >
425            | CData ] Char[^]>]
426            | CData Char[^]>]
427    prolog ::= Misc*
428             | XMLDecl Misc*
429             | Misc* doctypedecl Misc*
430             | XMLDecl Misc* doctypedecl Misc*
431    XMLDecl ::= < ? Xx Mm Ll VersionInfo ? >
432              | < ? Xx Mm Ll VersionInfo WhiteSpaces ? >
433              | < ? Xx Mm Ll VersionInfo SDDecl ? >
434              | < ? Xx Mm Ll VersionInfo SDDecl WhiteSpaces ? >
435              | < ? Xx Mm Ll VersionInfo EncodingDecl ? >
436              | < ? Xx Mm Ll VersionInfo EncodingDecl WhiteSpaces ? >
437              | < ? Xx Mm Ll VersionInfo EncodingDecl SDDecl ? >
438              | < ? Xx Mm Ll VersionInfo EncodingDecl SDDecl WhiteSpaces ? >
439    VersionInfo ::= WhiteSpaces Vv Ee Rr Ss Ii Oo Nn Eq "'" VersionNum "'"
440                  | WhiteSpaces Vv Ee Rr Ss Ii Oo Nn Eq '"' VersionNum '"'
441    Eq ::= =
442         | = WhiteSpaces
443         | WhiteSpaces =
444         | WhiteSpaces = WhiteSpaces
445    VersionNum ::= 1 . 0
446    Misc* ::= $Empty
447            | WhiteSpaces
448            | Misc* Comment
449            | Misc* PI
450            | Misc* Comment WhiteSpaces
451            | Misc* PI WhiteSpaces
452    intSubset ::= $Empty
453                | WhiteSpaces
454                | intSubset markupdecl
455                | intSubset PEReference
456                | intSubset markupdecl WhiteSpaces
457                | intSubset PEReference WhiteSpaces
458    markupdecl -> elementdecl
459                | AttlistDecl
460                | EntityDecl
461                | NotationDecl
462                | PI
463                | Comment
464    extSubset ::= extSubsetDecl
465                | TextDecl extSubsetDecl
466    extSubsetDecl ::= $Empty
467                    | WhiteSpaces
468                    | extSubsetDecl markupdecl
469                    | extSubsetDecl conditionalSect
470                    | extSubsetDecl PEReference
471                    | extSubsetDecl markupdecl WhiteSpaces
472                    | extSubsetDecl conditionalSect WhiteSpaces
473                    | extSubsetDecl PEReference WhiteSpaces
474    SDDecl ::= WhiteSpaces s t a n d a l o n e Eq YesOrNo
475    YesOrNo ::= '"' y e s '"'
476              | "'" y e s "'"
477              | '"' n o '"'
478              | "'" n o "'"
479    Attributes ::= $Empty
480                 | Attributes WhiteSpaces Attribute
481    content ::= CharData
482              | content element CharData
483              | content Reference CharData
484              | content CDSect CharData
485              | content PI CharData
486              | content Comment CharData
487    contentspec ::= E M P T Y
488                  | A N Y
489                  | Mixed
490                  | children
491    children ::= choice
492               | seq
493               | choice ?
494               | seq ?
495               | choice *
496               | seq *
497               | choice +
498               | seq +
499    cp ::= choice
500         | seq
501         | choice ?
502         | seq ?
503         | choice *
504         | seq *
505         | choice +
506         | seq +
507    choice ::= ( cp InnerChoiceContent )
508             | ( cp InnerChoiceContent WhiteSpaces )
509             | ( WhiteSpaces cp InnerChoiceContent )
510             | ( WhiteSpaces cp InnerChoiceContent WhiteSpaces )
511    InnerChoiceContent ::= '|' cp
512                         | '|' WhiteSpaces cp
513                         | WhiteSpaces '|' cp
514                         | WhiteSpaces '|' WhiteSpaces cp
515                         | InnerChoiceContent '|' cp
516                         | InnerChoiceContent '|' WhiteSpaces cp
517                         | InnerChoiceContent WhiteSpaces '|' cp
518                         | InnerChoiceContent WhiteSpaces '|' WhiteSpaces cp
519    seq ::= ( cp )
520          | ( WhiteSpaces cp )
521          | ( cp WhiteSpaces )
522          | ( WhiteSpaces cp WhiteSpaces )
523          | ( cp InnerSeqContent )
524          | ( WhiteSpaces cp InnerSeqContent )
525          | ( cp InnerSeqContent WhiteSpaces )
526          | ( WhiteSpaces cp InnerSeqContent WhiteSpaces )
527    InnerSeqContent ::= , cp
528                      | , WhiteSpaces cp
529                      | WhiteSpaces , cp
530                      | WhiteSpaces , WhiteSpaces cp
531                      | InnerSeqContent , cp
532                      | InnerSeqContent , WhiteSpaces cp
533                      | InnerSeqContent WhiteSpaces , cp
534                      | InnerSeqContent WhiteSpaces , WhiteSpaces cp
535    Mixed ::= ( # P C D A T A ) *
536            | ( WhiteSpaces # P C D A T A ) *
537            | ( # P C D A T A InnerMixedContent ) *
538            | ( WhiteSpaces # P C D A T A InnerMixedContent ) *
539            | ( # P C D A T A WhiteSpaces ) *
540            | ( WhiteSpaces # P C D A T A WhiteSpaces ) *
541            | ( # P C D A T A InnerMixedContent WhiteSpaces ) *
542            | ( WhiteSpaces # P C D A T A InnerMixedContent WhiteSpaces ) *
543            | ( # P C D A T A )
544            | ( WhiteSpaces # P C D A T A )
545            | ( # P C D A T A WhiteSpaces )
546            | ( WhiteSpaces # P C D A T A WhiteSpaces )
547    AttDef* ::= $Empty
548              | AttDef* AttDef
549    AttType -> StringType
550             | TokenizedType
551             | EnumeratedType
552    StringType ::= C D A T A
553    TokenizedType ::= I D
554                    | I D R E F
555                    | I D R E F S
556                    | E N T I T Y
557                    | E N T I T I E S
558                    | N M T O K E N
559                    | N M T O K E N S
560    EnumeratedType -> NotationType
561                    | Enumeration
562    NotationType ::= N O T A T I O N WhiteSpaces ( Name InnerNotationTypeContent )
563                   | N O T A T I O N WhiteSpaces ( Name InnerNotationTypeContent WhiteSpaces )
564                   | N O T A T I O N WhiteSpaces ( WhiteSpaces Name InnerNotationTypeContent )
565                   | N O T A T I O N WhiteSpaces ( WhiteSpaces Name InnerNotationTypeContent WhiteSpaces )
566    InnerNotationTypeContent ::= $Empty
567                               | InnerNotationTypeContent WhiteSpaces '|' Name
568                               | InnerNotationTypeContent WhiteSpaces '|' WhiteSpaces Name
569    Enumeration ::= ( Nmtoken InnerEnumerationContent )
570                  | ( Nmtoken InnerEnumerationContent WhiteSpaces )
571                  | ( WhiteSpaces Nmtoken InnerEnumerationContent )
572                  | ( WhiteSpaces Nmtoken InnerEnumerationContent WhiteSpaces )
573    InnerEnumerationContent ::= $Empty
574                              | InnerEnumerationContent '|' Nmtoken
575                              | InnerEnumerationContent '|' WhiteSpaces Nmtoken
576                              | InnerEnumerationContent WhiteSpaces '|' Nmtoken
577                              | InnerEnumerationContent WhiteSpaces '|' WhiteSpaces Nmtoken
578    DefaultDecl ::= # R E Q U I R E D
579                  | # I M P L I E D
580                  | AttValue
581                  | # F I X E D WhiteSpaces AttValue
582    conditionalSect -> includeSect
583                     | ignoreSect
584    includeSect ::= < ! [ I N C L U D E [ extSubsetDecl ] ] >
585                  | < ! [ I N C L U D E WhiteSpaces [ extSubsetDecl ] ] >
586                  | < ! [ WhiteSpaces I N C L U D E [ extSubsetDecl ] ] >
587                  | < ! [ WhiteSpaces I N C L U D E WhiteSpaces [ extSubsetDecl ] ] >
588    ignoreSect ::= < ! [ I G N O R E [ ignoreSectContents* ] ] >
589                 | < ! [ I G N O R E WhiteSpaces [ ignoreSectContents* ] ] >
590                 | < ! [ WhiteSpaces I G N O R E [ ignoreSectContents* ] ] >
591                 | < ! [ WhiteSpaces I G N O R E WhiteSpaces [ ignoreSectContents* ] ] >
592    ignoreSectContents* ::= Ignore
593                          | Ignore ignoreSectContents
594    ignoreSectContents ::= < ! [ ignoreSectContents* ] ] > Ignore
595                         | ignoreSectContents < ! [ ignoreSectContents ] ] > Ignore
596    Ignore ::= $Empty
597             | Ignore Char[^<]]
598             | Ignore < Char[^!]
599             | Ignore < ! Char[^[]
600             | Ignore ] Char[^]]
601             | Ignore ] ] Char[^>]
602    CharRef ::= & # [0-9]+ ;
603              | & # x [0-9a-fA-F]+ ;
604    [0-9]+ ::= AsciiDigit
605             | [0-9]+ AsciiDigit
606    [0-9a-fA-F]+ ::= AsciiDigit
607                   | AsciiLetter
608                   | [0-9a-fA-F]+ AsciiDigit
609                   | [0-9a-fA-F]+ AsciiLetter
610    Reference -> EntityRef
611               | CharRef
612    EntityRef ::= & Name ;
613    PEReference ::= % Name ;
614    EntityDecl -> GEDecl
615                | PEDecl
616    GEDecl ::= < ! E N T I T Y WhiteSpaces Name WhiteSpaces EntityValue >
617             | < ! E N T I T Y WhiteSpaces Name WhiteSpaces EntityValue WhiteSpaces >
618             | < ! E N T I T Y WhiteSpaces Name WhiteSpaces ExternalID >
619             | < ! E N T I T Y WhiteSpaces Name WhiteSpaces ExternalID WhiteSpaces >
620             | < ! E N T I T Y WhiteSpaces Name WhiteSpaces ExternalID NDataDecl >
621             | < ! E N T I T Y WhiteSpaces Name WhiteSpaces ExternalID NDataDecl WhiteSpaces >
622    PEDecl ::= < ! E N T I T Y WhiteSpaces % WhiteSpaces Name WhiteSpaces PEDef >
623             | < ! E N T I T Y WhiteSpaces % WhiteSpaces Name WhiteSpaces PEDef WhiteSpaces >
624    PEDef -> EntityValue
625           | ExternalID
626    ExternalID ::= S Y S T E M WhiteSpaces SystemLiteral
627                 | P U B L I C WhiteSpaces PubidLiteral WhiteSpaces SystemLiteral
628    NDataDecl ::= WhiteSpaces N D A T A WhiteSpaces Name
629    TextDecl ::= < ? Xx Mm Ll EncodingDecl ? >
630               | < ? Xx Mm Ll EncodingDecl WhiteSpaces ? >
631               | < ? Xx Mm Ll VersionInfo EncodingDecl ? >
632               | < ? Xx Mm Ll VersionInfo EncodingDecl WhiteSpaces ? >
633    extParsedEnt ::= content
634                   | TextDecl content
635    EncodingDecl ::= WhiteSpaces e n c o d i n g Eq '"' EncName '"'
636                   | WhiteSpaces e n c o d i n g Eq "'" EncName "'"
637    EncName ::= AsciiLetter
638              | EncName AsciiLetter
639              | EncName AsciiDigit
640              | EncName .
641              | EncName _
642              | EncName -
643    NotationDecl ::= < ! N O T A T I O N WhiteSpaces Name WhiteSpaces S Y S T E M WhiteSpaces SystemLiteral >
644                   | < ! N O T A T I O N WhiteSpaces Name WhiteSpaces S Y S T E M WhiteSpaces SystemLiteral WhiteSpaces >
645                   | < ! N O T A T I O N WhiteSpaces Name WhiteSpaces P U B L I C WhiteSpaces PubidLiteral WhiteSpaces SystemLiteral >
646                   | < ! N O T A T I O N WhiteSpaces Name WhiteSpaces P U B L I C WhiteSpaces PubidLiteral WhiteSpaces SystemLiteral WhiteSpaces >
647                   | < ! N O T A T I O N WhiteSpaces Name WhiteSpaces P U B L I C WhiteSpaces PubidLiteral >
648                   | < ! N O T A T I O N WhiteSpaces Name WhiteSpaces P U B L I C WhiteSpaces PubidLiteral WhiteSpaces >
649    Letter -> BaseChar
650            | Ideographic
651    BaseChar -> AsciiLetter
652              | NonAsciiBaseChar
653    Digit -> AsciiDigit
654           | NonAsciiDigit
655    U0009 -> HT
656    U000A -> LF
657    U000D -> CR
658    U0020 -> Space
659    Aa -> A
660        | a
661    Bb -> B
662        | b
663    Cc -> C
664        | c
665    Dd -> D
666        | d
667    Ee -> E
668        | e
669    Ff -> F
670        | f
671    Gg -> G
672        | g
673    Hh -> H
674        | h
675    Ii -> I
676        | i
677    Jj -> J
678        | j
679    Kk -> K
680        | k
681    Ll -> L
682        | l
683    Mm -> M
684        | m
685    Nn -> N
686        | n
687    Oo -> O
688        | o
689    Pp -> P
690        | p
691    Qq -> Q
692        | q
693    Rr -> R
694        | r
695    Ss -> S
696        | s
697    Tt -> T
698        | t
699    Uu -> U
700        | u
701    Vv -> V
702        | v
703    Ww -> W
704        | w
705    Xx -> X
706        | x
707    Yy -> Y
708        | y
709    Zz -> Z
710        | z
711    AsciiLetter -> Aa
712                 | Bb
713                 | Cc
714                 | Dd
715                 | Ee
716                 | Ff
717                 | Gg
718                 | Hh
719                 | Ii
720                 | Jj
721                 | Kk
722                 | Ll
723                 | Mm
724                 | Nn
725                 | Oo
726                 | Pp
727                 | Qq
728                 | Rr
729                 | Ss
730                 | Tt
731                 | Uu
732                 | Vv
733                 | Ww
734                 | Xx
735                 | Yy
736                 | Zz
737    AsciiDigit -> 0
738                | 1
739                | 2
740                | 3
741                | 4
742                | 5
743                | 6
744                | 7
745                | 8
746                | 9
747    NonSpaceChar[^?>] -> !
748                       | '"'
749                       | #
750                       | '$'
751                       | %
752                       | &
753                       | "'"
754                       | (
755                       | )
756                       | *
757                       | +
758                       | ,
759                       | -
760                       | .
761                       | /
762                       | :
763                       | ;
764                       | <
765                       | =
766                       | @
767                       | [
768                       | \
769                       | ]
770                       | ^
771                       | _
772                       | `
773                       | {
774                       | '|'
775                       | }
776                       | ~
777                       | BaseChar
778                       | Ideographic
779                       | CombiningChar
780                       | Extender
781                       | Digit
782                       | OtherValidChar
783    SpaceChar -> U0009
784               | U000D
785               | U0020
786               | U000A
787    Char[^-] -> SpaceChar
788              | !
789              | '"'
790              | #
791              | '$'
792              | %
793              | &
794              | "'"
795              | (
796              | )
797              | *
798              | +
799              | ,
800              | .
801              | /
802              | :
803              | ;
804              | <
805              | =
806              | >
807              | ?
808              | @
809              | [
810              | \
811              | ]
812              | ^
813              | _
814              | `
815              | {
816              | '|'
817              | }
818              | ~
819              | BaseChar
820              | Ideographic
821              | CombiningChar
822              | Extender
823              | Digit
824              | OtherValidChar
825    'Char[^%&\"]' -> SpaceChar
826                | !
827                | #
828                | '$'
829                | "'"
830                | (
831                | )
832                | *
833                | +
834                | ,
835                | -
836                | .
837                | /
838                | :
839                | ;
840                | <
841                | =
842                | >
843                | ?
844                | @
845                | [
846                | \
847                | ]
848                | ^
849                | _
850                | `
851                | {
852                | '|'
853                | }
854                | ~
855                | BaseChar
856                | Ideographic
857                | CombiningChar
858                | Extender
859                | Digit
860                | OtherValidChar
861    "Char[^%&\']" -> SpaceChar
862                | !
863                | '"'
864                | #
865                | '$'
866                | (
867                | )
868                | *
869                | +
870                | ,
871                | -
872                | .
873                | /
874                | :
875                | ;
876                | <
877                | =
878                | >
879                | ?
880                | @
881                | [
882                | \
883                | ]
884                | ^
885                | _
886                | `
887                | {
888                | '|'
889                | }
890                | ~
891                | BaseChar
892                | Ideographic
893                | CombiningChar
894                | Extender
895                | Digit
896                | OtherValidChar
897    'Char[^<&\"]' -> SpaceChar
898                | !
899                | #
900                | '$'
901                | %
902                | "'"
903                | (
904                | )
905                | *
906                | +
907                | ,
908                | -
909                | .
910                | /
911                | :
912                | ;
913                | =
914                | >
915                | ?
916                | @
917                | [
918                | \
919                | ]
920                | ^
921                | _
922                | `
923                | {
924                | '|'
925                | }
926                | ~
927                | BaseChar
928                | Ideographic
929                | CombiningChar
930                | Extender
931                | Digit
932                | OtherValidChar
933    "Char[^<&\']" -> SpaceChar
934                | !
935                | '"'
936                | #
937                | '$'
938                | %
939                | (
940                | )
941                | *
942                | +
943                | ,
944                | -
945                | .
946                | /
947                | :
948                | ;
949                | =
950                | >
951                | ?
952                | @
953                | [
954                | \
955                | ]
956                | ^
957                | _
958                | `
959                | {
960                | '|'
961                | }
962                | ~
963                | BaseChar
964                | Ideographic
965                | CombiningChar
966                | Extender
967                | Digit
968                | OtherValidChar
969    'Char[^\"]' -> SpaceChar
970              | !
971              | #
972              | '$'
973              | %
974              | &
975              | "'"
976              | (
977              | )
978              | *
979              | +
980              | ,
981              | -
982              | .
983              | /
984              | :
985              | ;
986              | <
987              | =
988              | >
989              | ?
990              | @
991              | [
992              | \
993              | ]
994              | ^
995              | _
996              | `
997              | {
998              | '|'
999              | }
1000             | ~
1001             | BaseChar
1002             | Ideographic
1003             | CombiningChar
1004             | Extender
1005             | Digit
1006             | OtherValidChar
1007   "Char[^\']" -> SpaceChar
1008             | !
1009             | '"'
1010             | #
1011             | '$'
1012             | %
1013             | &
1014             | (
1015             | )
1016             | *
1017             | +
1018             | ,
1019             | -
1020             | .
1021             | /
1022             | :
1023             | ;
1024             | <
1025             | =
1026             | >
1027             | ?
1028             | @
1029             | [
1030             | \
1031             | ]
1032             | ^
1033             | _
1034             | `
1035             | {
1036             | '|'
1037             | }
1038             | ~
1039             | BaseChar
1040             | Ideographic
1041             | CombiningChar
1042             | Extender
1043             | Digit
1044             | OtherValidChar
1045   Char[^<&]] -> SpaceChar
1046               | !
1047               | '"'
1048               | #
1049               | '$'
1050               | %
1051               | "'"
1052               | (
1053               | )
1054               | *
1055               | +
1056               | ,
1057               | -
1058               | .
1059               | /
1060               | :
1061               | ;
1062               | =
1063               | >
1064               | ?
1065               | @
1066               | [
1067               | \
1068               | ^
1069               | _
1070               | `
1071               | {
1072               | '|'
1073               | }
1074               | ~
1075               | BaseChar
1076               | Ideographic
1077               | CombiningChar
1078               | Extender
1079               | Digit
1080               | OtherValidChar
1081   Char[^<&]>] -> SpaceChar
1082                | !
1083                | '"'
1084                | #
1085                | '$'
1086                | %
1087                | "'"
1088                | (
1089                | )
1090                | *
1091                | +
1092                | ,
1093                | -
1094                | .
1095                | /
1096                | :
1097                | ;
1098                | =
1099                | ?
1100                | @
1101                | [
1102                | \
1103                | ^
1104                | _
1105                | `
1106                | {
1107                | '|'
1108                | }
1109                | ~
1110                | BaseChar
1111                | Ideographic
1112                | CombiningChar
1113                | Extender
1114                | Digit
1115                | OtherValidChar
1116   Char[^]>] -> SpaceChar
1117              | !
1118              | '"'
1119              | #
1120              | '$'
1121              | %
1122              | &
1123              | "'"
1124              | (
1125              | )
1126              | *
1127              | +
1128              | ,
1129              | -
1130              | .
1131              | /
1132              | :
1133              | ;
1134              | <
1135              | =
1136              | ?
1137              | @
1138              | [
1139              | \
1140              | ^
1141              | _
1142              | `
1143              | {
1144              | '|'
1145              | }
1146              | ~
1147              | BaseChar
1148              | Ideographic
1149              | CombiningChar
1150              | Extender
1151              | Digit
1152              | OtherValidChar
1153   Char[^>] -> SpaceChar
1154             | !
1155             | '"'
1156             | #
1157             | '$'
1158             | %
1159             | &
1160             | "'"
1161             | (
1162             | )
1163             | *
1164             | +
1165             | ,
1166             | -
1167             | .
1168             | /
1169             | :
1170             | ;
1171             | <
1172             | =
1173             | ?
1174             | @
1175             | [
1176             | \
1177             | ]
1178             | ^
1179             | _
1180             | `
1181             | {
1182             | '|'
1183             | }
1184             | ~
1185             | BaseChar
1186             | Ideographic
1187             | CombiningChar
1188             | Extender
1189             | Digit
1190             | OtherValidChar
1191   Char[^?>] -> SpaceChar
1192              | !
1193              | '"'
1194              | #
1195              | '$'
1196              | %
1197              | &
1198              | "'"
1199              | (
1200              | )
1201              | *
1202              | +
1203              | ,
1204              | -
1205              | .
1206              | /
1207              | :
1208              | ;
1209              | <
1210              | =
1211              | @
1212              | [
1213              | \
1214              | ]
1215              | ^
1216              | _
1217              | `
1218              | {
1219              | '|'
1220              | }
1221              | ~
1222              | BaseChar
1223              | Ideographic
1224              | CombiningChar
1225              | Extender
1226              | Digit
1227              | OtherValidChar
1228   Char[^]] -> SpaceChar
1229             | !
1230             | '"'
1231             | #
1232             | '$'
1233             | %
1234             | &
1235             | "'"
1236             | (
1237             | )
1238             | *
1239             | +
1240             | ,
1241             | -
1242             | .
1243             | /
1244             | :
1245             | ;
1246             | <
1247             | =
1248             | >
1249             | ?
1250             | @
1251             | [
1252             | \
1253             | ^
1254             | _
1255             | `
1256             | {
1257             | '|'
1258             | }
1259             | ~
1260             | BaseChar
1261             | Ideographic
1262             | CombiningChar
1263             | Extender
1264             | Digit
1265             | OtherValidChar
1266   Char[^!] -> SpaceChar
1267             | '"'
1268             | #
1269             | '$'
1270             | %
1271             | &
1272             | "'"
1273             | (
1274             | )
1275             | *
1276             | +
1277             | ,
1278             | -
1279             | .
1280             | /
1281             | :
1282             | ;
1283             | <
1284             | =
1285             | >
1286             | ?
1287             | @
1288             | [
1289             | \
1290             | ]
1291             | ^
1292             | _
1293             | `
1294             | {
1295             | '|'
1296             | }
1297             | ~
1298             | BaseChar
1299             | Ideographic
1300             | CombiningChar
1301             | Extender
1302             | Digit
1303             | OtherValidChar
1304   Char[^<]] -> SpaceChar
1305              | !
1306              | '"'
1307              | #
1308              | '$'
1309              | %
1310              | &
1311              | "'"
1312              | (
1313              | )
1314              | *
1315              | +
1316              | ,
1317              | -
1318              | .
1319              | /
1320              | :
1321              | ;
1322              | =
1323              | >
1324              | ?
1325              | @
1326              | [
1327              | \
1328              | ^
1329              | _
1330              | `
1331              | {
1332              | '|'
1333              | }
1334              | ~
1335              | BaseChar
1336              | Ideographic
1337              | CombiningChar
1338              | Extender
1339              | Digit
1340              | OtherValidChar
1341   Char[^[] -> SpaceChar
1342             | !
1343             | '"'
1344             | #
1345             | '$'
1346             | %
1347             | &
1348             | "'"
1349             | (
1350             | )
1351             | *
1352             | +
1353             | ,
1354             | -
1355             | .
1356             | /
1357             | :
1358             | ;
1359             | <
1360             | =
1361             | >
1362             | ?
1363             | @
1364             | \
1365             | ]
1366             | ^
1367             | _
1368             | `
1369             | {
1370             | '|'
1371             | }
1372             | ~
1373             | BaseChar
1374             | Ideographic
1375             | CombiningChar
1376             | Extender
1377             | Digit
1378             | OtherValidChar
1379   Letter[^Xx] -> Aa
1380                | Bb
1381                | Cc
1382                | Dd
1383                | Ee
1384                | Ff
1385                | Gg
1386                | Hh
1387                | Ii
1388                | Jj
1389                | Kk
1390                | Ll
1391                | Mm
1392                | Nn
1393                | Oo
1394                | Pp
1395                | Qq
1396                | Rr
1397                | Ss
1398                | Tt
1399                | Uu
1400                | Vv
1401                | Ww
1402                | Yy
1403                | Zz
1404                | NonAsciiBaseChar
1405                | Ideographic
1406   NameChar[^Mm] -> Aa
1407                  | Bb
1408                  | Cc
1409                  | Dd
1410                  | Ee
1411                  | Ff
1412                  | Gg
1413                  | Hh
1414                  | Ii
1415                  | Jj
1416                  | Kk
1417                  | Ll
1418                  | Nn
1419                  | Oo
1420                  | Pp
1421                  | Qq
1422                  | Rr
1423                  | Ss
1424                  | Tt
1425                  | Uu
1426                  | Vv
1427                  | Ww
1428                  | Xx
1429                  | Yy
1430                  | Zz
1431                  | NonAsciiBaseChar
1432                  | Ideographic
1433                  | Digit
1434                  | .
1435                  | -
1436                  | _
1437                  | :
1438                  | CombiningChar
1439                  | Extender
1440   NameChar[^Ll] -> Aa
1441                  | Bb
1442                  | Cc
1443                  | Dd
1444                  | Ee
1445                  | Ff
1446                  | Gg
1447                  | Hh
1448                  | Ii
1449                  | Jj
1450                  | Kk
1451                  | Mm
1452                  | Nn
1453                  | Oo
1454                  | Pp
1455                  | Qq
1456                  | Rr
1457                  | Ss
1458                  | Tt
1459                  | Uu
1460                  | Vv
1461                  | Ww
1462                  | Xx
1463                  | Yy
1464                  | Zz
1465                  | NonAsciiBaseChar
1466                  | Ideographic
1467                  | Digit
1468                  | .
1469                  | -
1470                  | _
1471                  | :
1472                  | CombiningChar
1473                  | Extender
1474   "PubidChar[^\']" -> U0020
1475                  | U000D
1476                  | U000A
1477                  | AsciiLetter
1478                  | AsciiDigit
1479                  | -
1480                  | (
1481                  | )
1482                  | +
1483                  | ,
1484                  | .
1485                  | /
1486                  | :
1487                  | =
1488                  | ?
1489                  | ;
1490                  | !
1491                  | *
1492                  | #
1493                  | @
1494                  | '$'
1495                  | _
1496                  | %
1497   NSAttName ::= x m l n s
1498               | x m l n s : NCName
1499               | AttNCNamePrefix
1500               | AttNCNamePrefix : NCName
1501   AttNCNamePrefix ::= x
1502                     | x m
1503                     | x m l
1504                     | x m l n
1505                     | ComplexAttNCNamePrefix
1506   ComplexAttNCNamePrefix ::= NameChar[^x:]
1507                            | x NameChar[^m:]
1508                            | x m NameChar[^l:]
1509                            | x m l NameChar[^n:]
1510                            | x m l n NameChar[^s:]
1511                            | x m l n s NameChar[^:]
1512                            | ComplexAttNCNamePrefix NameChar[^:]
1513   NCName ::= Letter
1514            | _
1515            | NCName NameChar[^:]
1516   QName ::= NCName
1517           | NCName : NCName
1518   element ::= < QName Attributes / >
1519             | < QName Attributes WhiteSpaces / >
1520             | < QName $SName Attributes > content < / QName $EName >
1521             | < QName $SName Attributes WhiteSpaces > content < / QName $EName >
1522             | < QName $SName Attributes > content < / QName $EName WhiteSpaces >
1523             | < QName $SName Attributes WhiteSpaces > content < / QName $EName WhiteSpaces $ >
1524   Attribute ::= NSAttName Eq AttValue
1525   doctypedecl ::= < ! D O C T Y P E WhiteSpaces QName >
1526                 | < ! D O C T Y P E WhiteSpaces QName WhiteSpaces >
1527                 | < ! D O C T Y P E WhiteSpaces QName [ intSubset ] >
1528                 | < ! D O C T Y P E WhiteSpaces QName [ intSubset ] WhiteSpaces >
1529                 | < ! D O C T Y P E WhiteSpaces QName WhiteSpaces [ intSubset ] >
1530                 | < ! D O C T Y P E WhiteSpaces QName WhiteSpaces [ intSubset ] WhiteSpaces >
1531                 | < ! D O C T Y P E WhiteSpaces QName WhiteSpaces ExternalID >
1532                 | < ! D O C T Y P E WhiteSpaces QName WhiteSpaces ExternalID WhiteSpaces >
1533                 | < ! D O C T Y P E WhiteSpaces QName WhiteSpaces ExternalID [ intSubset ] >
1534                 | < ! D O C T Y P E WhiteSpaces QName WhiteSpaces ExternalID [ intSubset ] WhiteSpaces >
1535                 | < ! D O C T Y P E WhiteSpaces QName WhiteSpaces ExternalID WhiteSpaces [ intSubset ] >
1536                 | < ! D O C T Y P E WhiteSpaces QName WhiteSpaces ExternalID WhiteSpaces [ intSubset ] WhiteSpaces >
1537   elementdecl ::= < ! E L E M E N T WhiteSpaces QName WhiteSpaces contentspec >
1538                 | < ! E L E M E N T WhiteSpaces QName WhiteSpaces contentspec WhiteSpaces >
1539   cp ::= QName
1540        | QName ?
1541        | QName *
1542        | QName +
1543   InnerMixedContent ::= '|' QName
1544                       | '|' WhiteSpaces QName
1545                       | WhiteSpaces '|' QName
1546                       | WhiteSpaces '|' WhiteSpaces QName
1547                       | InnerMixedContent '|' QName
1548                       | InnerMixedContent '|' WhiteSpaces QName
1549                       | InnerMixedContent WhiteSpaces '|' QName
1550                       | InnerMixedContent WhiteSpaces '|' WhiteSpaces QName
1551   AttlistDecl ::= < ! A T T L I S T WhiteSpaces QName AttDef* >
1552                 | < ! A T T L I S T WhiteSpaces QName AttDef* WhiteSpaces >
1553   AttDef ::= WhiteSpaces NSAttName WhiteSpaces $ AttType WhiteSpaces $ DefaultDecl
D:/eclipse/workspace/lpg.javaruntime.examples/xmlexample/xmlparser/XmlParser.g:231:5:231:9:5876:5880: Error: The nonterminal Names is useless.
D:/eclipse/workspace/lpg.javaruntime.examples/xmlexample/xmlparser/XmlParser.g:241:5:241:12:6158:6165: Error: The nonterminal Nmtokens is useless.


 IBM LALR Parser Generator              1.00 (Feb 16 2007)


Name map:

'$empty' ::= '$empty'
HT ::= HT
LF ::= LF
CR ::= CR
Space ::= Space
Exclamation ::= !
DoubleQuote ::= "
Sharp ::= #
DollarSign ::= '$'
Percent ::= %
Ampersand ::= &
SingleQuote ::= ''''
LeftParen ::= (
RightParen ::= )
Star ::= *
Plus ::= +
Comma ::= ,
Minus ::= -
Dot ::= .
Slash ::= /
0 ::= 0
1 ::= 1
2 ::= 2
3 ::= 3
4 ::= 4
5 ::= 5
6 ::= 6
7 ::= 7
8 ::= 8
9 ::= 9
Colon ::= :
SemiColon ::= ;
LessThan ::= <
Equal ::= =
GreaterThan ::= >
QuestionMark ::= ?
AtSign ::= @
A ::= A
B ::= B
C ::= C
D ::= D
E ::= E
F ::= F
G ::= G
H ::= H
I ::= I
J ::= J
K ::= K
L ::= L
M ::= M
N ::= N
O ::= O
P ::= P
Q ::= Q
R ::= R
S ::= S
T ::= T
U ::= U
V ::= V
W ::= W
X ::= X
Y ::= Y
Z ::= Z
LeftBracket ::= [
BackSlash ::= \
RightBracket ::= ]
Caret ::= ^
_ ::= _
BackQuote ::= `
a ::= a
b ::= b
c ::= c
d ::= d
e ::= e
f ::= f
g ::= g
h ::= h
i ::= i
j ::= j
k ::= k
l ::= l
m ::= m
n ::= n
o ::= o
p ::= p
q ::= q
r ::= r
s ::= s
t ::= t
u ::= u
v ::= v
w ::= w
x ::= x
y ::= y
z ::= z
LeftBrace ::= {
VerticalBar ::= '|'
RightBrace ::= }
Tilde ::= ~
NonAsciiBaseChar ::= NonAsciiBaseChar
Ideographic ::= Ideographic
CombiningChar ::= CombiningChar
Extender ::= Extender
NonAsciiDigit ::= NonAsciiDigit
OtherValidChar ::= OtherValidChar
Unused ::= Unused
ExtSubsetMarker ::= ExtSubsetMarker
ExtParserEntMarker ::= ExtParserEntMarker
EOF ::= EOF
document ::= document
NameChar[^:] ::= NameChar[^:]
Ee ::= Ee
Ii ::= Ii
Ll ::= Ll
Mm ::= Mm
Nn ::= Nn
Oo ::= Oo
Rr ::= Rr
Ss ::= Ss
Vv ::= Vv
Xx ::= Xx
NameChar[^m:] ::= NameChar[^m:]
NameChar[^l:] ::= NameChar[^l:]
NameChar[^n:] ::= NameChar[^n:]
NameChar[^s:] ::= NameChar[^s:]
element ::= element
WhiteSpaces ::= WhiteSpaces
SpaceChar ::= SpaceChar
NameChar ::= NameChar
Name ::= Name
Nmtoken ::= Nmtoken
EntityValue ::= EntityValue
Char[^%&"] ::= Char[^%&"]
PEReference ::= PEReference
Reference ::= Reference
Char[^%&'] ::= Char[^%&']
AttValue ::= AttValue
Char[^<&"] ::= Char[^<&"]
Char[^<&'] ::= Char[^<&']
SystemLiteral ::= SystemLiteral
Char[^"] ::= Char[^"]
Char[^'] ::= Char[^']
PubidLiteral ::= PubidLiteral
PubidChar ::= PubidChar
PubidChar[^'] ::= PubidChar[^']
2OrMoreBrackets ::= 2OrMoreBrackets
Char[^<&]>] ::= Char[^<&]>]
Char[^<&]] ::= Char[^<&]]
Comment ::= Comment
Char[^-] ::= Char[^-]
PI ::= PI
PITarget ::= PITarget
AfterPITarget ::= AfterPITarget
Questions ::= Questions
Char[^?>] ::= Char[^?>]
Letter[^Xx] ::= Letter[^Xx]
NameChar[^Mm] ::= NameChar[^Mm]
NameChar[^Ll] ::= NameChar[^Ll]
CDSect ::= CDSect
Char[^]>] ::= Char[^]>]
XMLDecl ::= XMLDecl
doctypedecl ::= doctypedecl
VersionInfo ::= VersionInfo
SDDecl ::= SDDecl
EncodingDecl ::= EncodingDecl
Eq ::= Eq
VersionNum ::= VersionNum
markupdecl ::= markupdecl
TextDecl ::= TextDecl
conditionalSect ::= conditionalSect
YesOrNo ::= YesOrNo
Attribute ::= Attribute
contentspec ::= contentspec
choice ::= choice
seq ::= seq
cp ::= cp
InnerChoiceContent ::= InnerChoiceContent
InnerSeqContent ::= InnerSeqContent
InnerMixedContent ::= InnerMixedContent
AttDef ::= AttDef
AttType ::= AttType
DefaultDecl ::= DefaultDecl
ignoreSectContents ::= ignoreSectContents
Char[^<]] ::= Char[^<]]
Char[^!] ::= Char[^!]
Char[^[] ::= Char[^[]
Char[^]] ::= Char[^]]
Char[^>] ::= Char[^>]
[0-9]+ ::= [0-9]+
[0-9a-fA-F]+ ::= [0-9a-fA-F]+
AsciiDigit ::= AsciiDigit
AsciiLetter ::= AsciiLetter
ExternalID ::= ExternalID
NDataDecl ::= NDataDecl
PEDef ::= PEDef
EncName ::= EncName
NSAttName ::= NSAttName
NCName ::= NCName
AttNCNamePrefix ::= AttNCNamePrefix
ComplexAttNCNamePrefix ::= ComplexAttNCNamePrefix
QName ::= QName
Aa ::= 
Bb ::= 
Cc ::= 
Dd ::= 
Ff ::= 
Gg ::= 
Hh ::= 
Jj ::= 
Kk ::= 
Pp ::= 
Qq ::= 
Tt ::= 
Uu ::= 
Ww ::= 
Yy ::= 
Zz ::= 
Digit ::= 
NameChar[^x:] ::= 
prolog ::= 
Misc* ::= 
extSubset ::= 
extParsedEnt ::= 
Letter ::= 
Names ::= 
U0020 ::= 
Nmtokens ::= 
DoubleEntityValueContent ::= 
SingleEntityValueContent ::= 
DoubleAttValueContent ::= 
SingleAttValueContent ::= 
DoubleSystemLiteralContent ::= 
SingleSystemLiteralContent ::= 
DoublePubidLiteralContent ::= 
SinglePubidLiteralContent ::= 
CharData ::= 
CharDataContent ::= 
CommentContent ::= 
NonSpaceChar[^?>] ::= 
PITargettail ::= 
CData ::= 
intSubset ::= 
elementdecl ::= 
AttlistDecl ::= 
EntityDecl ::= 
NotationDecl ::= 
extSubsetDecl ::= 
Attributes ::= 
content ::= 
Mixed ::= 
children ::= 
AttDef* ::= 
StringType ::= 
TokenizedType ::= 
EnumeratedType ::= 
NotationType ::= 
Enumeration ::= 
InnerNotationTypeContent ::= 
InnerEnumerationContent ::= 
includeSect ::= 
ignoreSect ::= 
ignoreSectContents* ::= 
Ignore ::= 
CharRef ::= 
EntityRef ::= 
GEDecl ::= 
PEDecl ::= 
BaseChar ::= 
U0009 ::= 
U000A ::= 
U000D ::= 

 IBM LALR Parser Generator              1.00 (Feb 16 2007)


Scopes:

includeSect ::= LessThan Exclamation LeftBracket WhiteSpaces I N C L U D E 
                WhiteSpaces LeftBracket extSubsetDecl  .RightBracket 
                RightBracket GreaterThan 
includeSect ::= LessThan Exclamation LeftBracket WhiteSpaces I N C L U D E 
                LeftBracket extSubsetDecl  .RightBracket RightBracket 
                GreaterThan 
includeSect ::= LessThan Exclamation LeftBracket I N C L U D E WhiteSpaces 
                LeftBracket extSubsetDecl  .RightBracket RightBracket 
                GreaterThan 
includeSect ::= LessThan Exclamation LeftBracket I N C L U D E LeftBracket 
                extSubsetDecl  .RightBracket RightBracket GreaterThan 
element ::= LessThan QName Attributes WhiteSpaces GreaterThan content  .
            LessThan Slash QName GreaterThan 
element ::= LessThan QName Attributes WhiteSpaces GreaterThan content  .
            LessThan Slash QName WhiteSpaces GreaterThan 
element ::= LessThan QName Attributes GreaterThan content  .LessThan Slash 
            QName GreaterThan 
ignoreSectContents ::= ignoreSectContents LessThan Exclamation LeftBracket 
                       ignoreSectContents  .RightBracket RightBracket 
                       GreaterThan Ignore 
element ::= LessThan QName Attributes GreaterThan content  .LessThan Slash 
            QName WhiteSpaces GreaterThan 
seq ::= LeftParen WhiteSpaces cp InnerSeqContent  .RightParen 
choice ::= LeftParen WhiteSpaces cp InnerChoiceContent  .RightParen 
seq ::= LeftParen WhiteSpaces cp InnerSeqContent  .WhiteSpaces RightParen 
choice ::= LeftParen WhiteSpaces cp InnerChoiceContent  .WhiteSpaces RightParen 
ignoreSectContents ::= LessThan Exclamation LeftBracket ignoreSectContents*  .
                       RightBracket RightBracket GreaterThan Ignore 
seq ::= LeftParen cp InnerSeqContent  .RightParen 
seq ::= LeftParen WhiteSpaces cp  .RightParen 
choice ::= LeftParen cp InnerChoiceContent  .RightParen 
seq ::= LeftParen cp InnerSeqContent  .WhiteSpaces RightParen 
seq ::= LeftParen WhiteSpaces cp  .InnerSeqContent RightParen 
seq ::= LeftParen WhiteSpaces cp  .WhiteSpaces RightParen 
choice ::= LeftParen WhiteSpaces cp  .InnerChoiceContent RightParen 
choice ::= LeftParen cp InnerChoiceContent  .WhiteSpaces RightParen 
seq ::= LeftParen WhiteSpaces cp  .InnerSeqContent WhiteSpaces RightParen 
choice ::= LeftParen WhiteSpaces cp  .InnerChoiceContent WhiteSpaces RightParen 
seq ::= LeftParen cp  .RightParen 
extSubsetDecl ::= extSubsetDecl conditionalSect  .WhiteSpaces 
seq ::= LeftParen cp  .InnerSeqContent RightParen 
seq ::= LeftParen cp  .WhiteSpaces RightParen 
choice ::= LeftParen cp  .InnerChoiceContent RightParen 
seq ::= LeftParen cp  .InnerSeqContent WhiteSpaces RightParen 
choice ::= LeftParen cp  .InnerChoiceContent WhiteSpaces RightParen 


D:/eclipse/workspace/lpg.javaruntime.examples/xmlexample/xmlparser/XmlNSParser.gnew is LALR(6).


Number of Terminals: 108
Number of Nonterminals: 162
Number of Productions: 1554
Number of Single Productions: 1206
Number of Items: 4565
Number of Scopes: 31
Number of States: 630
Number of look-ahead states: 62
Number of Shift actions: 5871
Number of Goto actions: 2811
Number of Shift/Reduce actions: 5882
Number of Goto/Reduce actions: 2709
Number of Reduce actions: 8007
Number of Shift-Reduce conflicts: 0
Number of Reduce-Reduce conflicts: 0

Number of entries in base Action Table: 6150
Additional space required for compaction of Action Table: 8.4%

Number of unique terminal states: 583
Number of Shift actions saved by merging: 2562
Number of Conflict points saved by merging: 0
Number of Reduce actions saved by merging: 3262
Number of Reduce saved by default: 4734

Number of entries in Terminal Action Table: 9847
Additional space required for compaction of Terminal Table: 1.1%

Actions in Compressed Tables:
     Number of Shifts: 3696
     Number of Shift/Reduces: 5495
     Number of Look-Ahead Shifts: 62
     Number of Gotos: 2811
     Number of Goto/Reduces: 2709
     Number of Reduces: 11
     Number of Defaults: 139

Parsing Tables storage:
    Storage required for BASE_CHECK: 16450 Bytes
    Storage required for BASE_ACTION: 16452 Bytes
    Storage required for TERM_CHECK: 9982 Bytes
    Storage required for TERM_ACTION: 19914 Bytes

Error maps storage:
    Storage required for ACTION_SYMBOLS_BASE map: 1262 Bytes
    Storage required for ACTION_SYMBOLS_RANGE map: 1148 Bytes
    Storage required for NACTION_SYMBOLS_BASE map: 1262 Bytes
    Storage required for NACTION_SYMBOLS_RANGE map: 482 Bytes
    Storage required for TERMINAL_INDEX map: 218 Bytes
    Storage required for NON_TERMINAL_INDEX map: 328 Bytes

    Storage required for SCOPE_PREFIX map: 62 Bytes
    Storage required for SCOPE_SUFFIX map: 62 Bytes
    Storage required for SCOPE_LHS_SYMBOL map: 62 Bytes
    Storage required for SCOPE_LOOK_AHEAD map: 31 Bytes
    Storage required for SCOPE_STATE_SET map: 31 Bytes
    Storage required for SCOPE_RIGHT_SIDE map: 300 Bytes
    Storage required for SCOPE_STATE map: 92 Bytes
    Storage required for IN_SYMB map: 1262 Bytes

    Number of names: 203
    Number of characters in name: 1042
