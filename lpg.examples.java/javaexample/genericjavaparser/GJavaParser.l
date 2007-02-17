
Options in effect for D:/eclipse/workspace/lpg.javaruntime.examples/javaexample/genericjavaparser/GJavaParser.g:

    ACTION-BLOCK=("D:\eclipse\workspace\lpg.javaruntime.examples\javaexample\genericjavaparser\JavaParser.java","/.","./")

    AST-DIRECTORY=""  AST-TYPE="Ast"  NOATTRIBUTES  NOAUTOMATIC-AST  BACKTRACK
    BYTE  CONFLICTS  
    DAT-DIRECTORY="D:\eclipse\workspace\lpg.javaruntime.examples\javaexample\genericjavaparser\"
    BYTE  CONFLICTS  
    DAT-FILE="D:\eclipse\workspace\lpg.javaruntime.examples\javaexample\genericjavaparser\JavaParserdcl.data"
    BYTE  CONFLICTS  
    DCL-FILE="D:\eclipse\workspace\lpg.javaruntime.examples\javaexample\genericjavaparser\JavaParserdcl.java"
    BYTE  CONFLICTS  NODEBUG  
    DEF-FILE="D:\eclipse\workspace\lpg.javaruntime.examples\javaexample\genericjavaparser\JavaParserdef.java"
    BYTE  CONFLICTS  NODEBUG  NOEDIT  ERROR-MAPS  ESCAPE='$'  
    EXPORT-TERMINALS=("D:\eclipse\workspace\lpg.javaruntime.examples\javaexample\genericjavaparser\JavaParserexp.java","","")
    BYTE  CONFLICTS  NODEBUG  NOEDIT  ERROR-MAPS  ESCAPE='$'  EXTENDS-PARSETABLE
    FACTORY="new "  FILE-PREFIX="JavaParser"  NOFIRST  NOFOLLOW  NOGLR  
    NOGOTO-DEFAULT  
    GRM-FILE="D:/eclipse/workspace/lpg.javaruntime.examples/javaexample/genericjavaparser/GJavaParser.g"
    NOGOTO-DEFAULT  
    IMP-FILE="D:\eclipse\workspace\lpg.javaruntime.examples\javaexample\genericjavaparser\JavaParserimp.java"
    NOGOTO-DEFAULT  IMPORT-TERMINALS="GJavaLexer.g"  
    INCLUDE-DIRECTORY="D:\eclipse\workspace\lpg.javaruntime.examples\javaexample\genericjavaparser\;.;D:\eclipse\workspace\lpg.javaruntime.v2\include;D:\eclipse\workspace;D:\eclipse\workspace\com.ibm.db.parsers.sql2003\src\com\ibm\db\parsers\sql2003;D:\eclipse\workspace\com.ibm.db.parsers.sql2003\src\com\ibm\db\parsers\sql2003\lexer;D:\eclipse\workspace\com.ibm.db.parsers.sql.common.db2.lexer\src\com\ibm\db\parsers\sql\common\db2\lexer;D:\eclipse\workspace\com.ibm.db.parsers.sql.routines.db2.common\src\com\ibm\db\parsers\sql\routines\db2\common;"
    NOGOTO-DEFAULT  IMPORT-TERMINALS="GJavaLexer.g"  LALR=1  LIST  MARGIN=4  
    MAX-CASES=1024  NAMES=OPTIMIZED  NONT-CHECK  OR_MARKER='|'  
    OUT-DIRECTORY="D:\eclipse\workspace\lpg.javaruntime.examples\javaexample\genericjavaparser\"
    MAX-CASES=1024  NAMES=OPTIMIZED  NONT-CHECK  OR_MARKER='|'  
    PACKAGE="genericjavaparser"  NOPARENT-SAVE  
    PARSETABLE-INTERFACES="lpg.javaruntime.ParseTable"  PREFIX="TK_"  PRIORITY
    PROGRAMMING_LANGUAGE=JAVA  
    PRS-FILE="D:\eclipse\workspace\lpg.javaruntime.examples\javaexample\genericjavaparser\JavaParserprs.java"
    PROGRAMMING_LANGUAGE=JAVA  NOQUIET  READ-REDUCE  REMAP-TERMINALS  SCOPES  
    NOSERIALIZE  NOSHIFT-DEFAULT  NOSINGLE-PRODUCTIONS  NOSOFT-KEYWORDS  
    NOSTATES  SUFFIX=""  
    SYM-FILE="D:\eclipse\workspace\lpg.javaruntime.examples\javaexample\genericjavaparser\JavaParsersym.java"
    NOSTATES  SUFFIX=""  TAB-FILE="GJavaParser.t"  TABLE  
    TEMPLATE="btParserTemplateD.g"  TRACE=CONFLICTS  NOVARIABLES  NOVERBOSE  
    NOVISITOR  VISITOR-TYPE="Visitor"  WARNINGS  NOXREF  

D:/eclipse/workspace/lpg.javaruntime.examples/javaexample/genericjavaparser/GJavaParser.g:808:41:808:44:26247:26250: Warning: The undeclared symbol "name" is assumed to be a terminal

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


    $BadAction
    /. $Header    
                    case $rule_number:    
                        throw new Error("No action specified for rule " + $rule_number);./


    $NullAction
    /. $Header    
                    case $rule_number:    
                        setResult(null);    
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


    $ast_class
    /.$ast_type./


    $unimplemented_symbols_warning
    /.false./


    $setSym1
    /. // macro setSym1 is deprecated. Use function setResult    
                    getParser().setSym1./


    $setResult
    /. // macro setResult is deprecated. Use function setResult    
                     getParser().setSym1./


    $getSym
    /. // macro getSym is deprecated. Use function getRhsSym    
                  getParser().getSym./


    $getToken
    /. // macro getToken is deprecated. Use function getRhsTokenIndex    
                    getParser().getToken./


    $getIToken
    /. // macro getIToken is deprecated. Use function getRhsIToken    
                     super.getIToken./


    $getLeftSpan
    /. // macro getLeftSpan is deprecated. Use function getLeftSpan    
                       getParser().getFirstToken./


    $getRightSpan
    /. // macro getRightSpan is deprecated. Use function getRightSpan    
                        getParser().getLastToken./


Aliases:

    '--' ::= MINUS_MINUS
    '|' ::= OR
    - ::= MINUS
    -= ::= MINUS_EQUAL
    ! ::= NOT
    != ::= NOT_EQUAL
    % ::= REMAINDER
    %= ::= REMAINDER_EQUAL
    & ::= AND
    && ::= AND_AND
    &= ::= AND_EQUAL
    ( ::= LPAREN
    ) ::= RPAREN
    * ::= MULTIPLY
    *= ::= MULTIPLY_EQUAL
    , ::= COMMA
    . ::= DOT
    / ::= DIVIDE
    /= ::= DIVIDE_EQUAL
    : ::= COLON
    ; ::= SEMICOLON
    ? ::= QUESTION
    @ ::= AT
    [ ::= LBRACKET
    ] ::= RBRACKET
    ^ ::= XOR
    ^= ::= XOR_EQUAL
    { ::= LBRACE
    || ::= OR_OR
    |= ::= OR_EQUAL
    } ::= RBRACE
    ~ ::= TWIDDLE
    + ::= PLUS
    ++ ::= PLUS_PLUS
    += ::= PLUS_EQUAL
    < ::= LESS
    << ::= LEFT_SHIFT
    <<= ::= LEFT_SHIFT_EQUAL
    <= ::= LESS_EQUAL
    = ::= EQUAL
    == ::= EQUAL_EQUAL
    > ::= GREATER
    >= ::= GREATER_EQUAL
    >> ::= RIGHT_SHIFT
    >>= ::= RIGHT_SHIFT_EQUAL
    >>> ::= UNSIGNED_RIGHT_SHIFT
    >>>= ::= UNSIGNED_RIGHT_SHIFT_EQUAL
    ... ::= ELLIPSIS


Start:

    CompilationUnit

Identifier:

    IDENTIFIER

Eof:

    EOF_TOKEN

Error:

    ERROR_TOKEN

Terminals:

    IntegerLiteral
    LongLiteral
    FloatingPointLiteral
    DoubleLiteral
    CharacterLiteral
    StringLiteral
    MINUS_MINUS
    OR
    MINUS
    MINUS_EQUAL
    NOT
    NOT_EQUAL
    REMAINDER
    REMAINDER_EQUAL
    AND
    AND_AND
    AND_EQUAL
    LPAREN
    RPAREN
    MULTIPLY
    MULTIPLY_EQUAL
    COMMA
    DOT
    DIVIDE
    DIVIDE_EQUAL
    COLON
    SEMICOLON
    QUESTION
    AT
    LBRACKET
    RBRACKET
    XOR
    XOR_EQUAL
    LBRACE
    OR_OR
    OR_EQUAL
    RBRACE
    TWIDDLE
    PLUS
    PLUS_PLUS
    PLUS_EQUAL
    LESS
    LEFT_SHIFT
    LEFT_SHIFT_EQUAL
    LESS_EQUAL
    EQUAL
    EQUAL_EQUAL
    GREATER
    GREATER_EQUAL
    RIGHT_SHIFT
    RIGHT_SHIFT_EQUAL
    UNSIGNED_RIGHT_SHIFT
    UNSIGNED_RIGHT_SHIFT_EQUAL
    ELLIPSIS
    const
    goto
    EOF_TOKEN
    IDENTIFIER
    ERROR_TOKEN
    name


Soft Keywords:

    abstract
    assert
    boolean
    break
    byte
    case
    catch
    char
    class
    continue
    default
    do
    double
    enum
    else
    extends
    false
    final
    finally
    float
    for
    if
    implements
    import
    instanceof
    int
    interface
    long
    native
    new
    null
    package
    private
    protected
    public
    return
    short
    static
    strictfp
    super
    switch
    synchronized
    this
    throw
    throws
    transient
    true
    try
    void
    volatile
    while


Rules:

1      identifier ::= IDENTIFIER
2      Type ::= PrimitiveType
3             | ReferenceType
4      PrimitiveType ::= NumericType
5                      | boolean
6      NumericType ::= IntegralType
7                    | FloatingPointType
8      IntegralType ::= byte
9                     | short
10                    | int
11                    | long
12                    | char
13     FloatingPointType ::= float
14                         | double
15     ReferenceType ::= ClassOrInterfaceType
16                     | TypeVariable
17                     | ArrayType
18     ClassOrInterfaceType ::= ClassType
19     ClassType ::= TypeName TypeArgumentsopt
20     InterfaceType ::= TypeName TypeArgumentsopt
21     TypeName ::= identifier
22                | TypeName . identifier
23     ClassName ::= TypeName
24     TypeVariable ::= identifier
25     ArrayType ::= Type [ ]
26     TypeParameter ::= TypeVariable TypeBoundopt
27     TypeBound ::= extends ClassOrInterfaceType AdditionalBoundListopt
28     AdditionalBoundList ::= AdditionalBound
29                           | AdditionalBoundList AdditionalBound
30     AdditionalBound ::= & InterfaceType
31     TypeArguments ::= < ActualTypeArgumentList >
32     ActualTypeArgumentList ::= ActualTypeArgument
33                              | ActualTypeArgumentList , ActualTypeArgument
34     ActualTypeArgument ::= ReferenceType
35                          | Wildcard
36     Wildcard ::= ? WildcardBoundsOpt
37     WildcardBounds ::= extends ReferenceType
38                      | super ReferenceType
39     PackageName ::= identifier
40                   | PackageName . identifier
41     ExpressionName ::= identifier
42                      | AmbiguousName . identifier
43     MethodName ::= identifier
44                  | AmbiguousName . identifier
45     PackageOrTypeName ::= identifier
46                         | PackageOrTypeName . identifier
47     AmbiguousName ::= identifier
48                     | AmbiguousName . identifier
49     CompilationUnit ::= PackageDeclarationopt ImportDeclarationsopt TypeDeclarationsopt
50     ImportDeclarations ::= ImportDeclaration
51                          | ImportDeclarations ImportDeclaration
52     TypeDeclarations ::= TypeDeclaration
53                        | TypeDeclarations TypeDeclaration
54     PackageDeclaration ::= Annotationsopt package PackageName ;
55     ImportDeclaration ::= SingleTypeImportDeclaration
56                         | TypeImportOnDemandDeclaration
57                         | SingleStaticImportDeclaration
58                         | StaticImportOnDemandDeclaration
59     SingleTypeImportDeclaration ::= import TypeName ;
60     TypeImportOnDemandDeclaration ::= import PackageOrTypeName . * ;
61     SingleStaticImportDeclaration ::= import static TypeName . identifier ;
62     StaticImportOnDemandDeclaration ::= import static TypeName . * ;
63     TypeDeclaration ::= ClassDeclaration
64                       | InterfaceDeclaration
65                       | ;
66                       | ERROR_TOKEN
67     ClassDeclaration ::= NormalClassDeclaration
68                        | EnumDeclaration
69     NormalClassDeclaration ::= ClassModifiersopt class identifier TypeParametersopt Superopt Interfacesopt ClassBody
70     ClassModifiers ::= ClassModifier
71                      | ClassModifiers ClassModifier
72     ClassModifier ::= Annotation
73                     | public
74                     | protected
75                     | private
76                     | abstract
77                     | static
78                     | final
79                     | strictfp
80     TypeParameters ::= < TypeParameterList >
81     TypeParameterList ::= TypeParameter
82                         | TypeParameterList , TypeParameter
83     Super ::= extends ClassType
84     Interfaces ::= implements InterfaceTypeList
85     InterfaceTypeList ::= InterfaceType
86                         | InterfaceTypeList , InterfaceType
87     ClassBody ::= { ClassBodyDeclarationsopt }
88     ClassBodyDeclarations ::= ClassBodyDeclaration
89                             | ClassBodyDeclarations ClassBodyDeclaration
90     ClassBodyDeclaration ::= ClassMemberDeclaration
91                            | InstanceInitializer
92                            | StaticInitializer
93                            | ConstructorDeclaration
94                            | ERROR_TOKEN
95     ClassMemberDeclaration ::= FieldDeclaration
96                              | MethodDeclaration
97                              | ClassDeclaration
98                              | InterfaceDeclaration
99                              | ;
100    FieldDeclaration ::= FieldModifiersopt Type VariableDeclarators ;
101    VariableDeclarators ::= VariableDeclarator
102                          | VariableDeclarators , VariableDeclarator
103    VariableDeclarator ::= VariableDeclaratorId
104                         | VariableDeclaratorId = VariableInitializer
105    VariableDeclaratorId ::= identifier
106                           | VariableDeclaratorId [ ]
107    VariableInitializer ::= Expression
108                          | ArrayInitializer
109    FieldModifiers ::= FieldModifier
110                     | FieldModifiers FieldModifier
111    FieldModifier ::= Annotation
112                    | public
113                    | protected
114                    | private
115                    | static
116                    | final
117                    | transient
118                    | volatile
119    MethodDeclaration ::= MethodHeader MethodBody
120    MethodHeader ::= MethodModifiersopt TypeParametersopt ResultType MethodDeclarator Throwsopt
121    ResultType ::= Type
122                 | void
123    MethodDeclarator ::= identifier ( FormalParameterListopt )
124    MethodDeclarator ::= MethodDeclarator [ ]
125    FormalParameterList ::= LastFormalParameter
126                          | FormalParameters , LastFormalParameter
127    FormalParameters ::= FormalParameter
128                       | FormalParameters , FormalParameter
129    FormalParameter ::= VariableModifiersopt Type VariableDeclaratorId
130    VariableModifiers ::= VariableModifier
131                        | VariableModifiers VariableModifier
132    VariableModifier ::= final
133                       | Annotations
134    LastFormalParameter ::= VariableModifiersopt Type ...opt VariableDeclaratorId
135    MethodModifiers ::= MethodModifier
136                      | MethodModifiers MethodModifier
137    MethodModifier ::= Annotations
138                     | public
139                     | protected
140                     | private
141                     | abstract
142                     | static
143                     | final
144                     | synchronized
145                     | native
146                     | strictfp
147    Throws ::= throws ExceptionTypeList
148    ExceptionTypeList ::= ExceptionType
149                        | ExceptionTypeList , ExceptionType
150    ExceptionType ::= ClassType
151                    | TypeVariable
152    MethodBody ::= Block
153                 | ;
154    InstanceInitializer ::= Block
155    StaticInitializer ::= static Block
156    ConstructorDeclaration ::= ConstructorModifiersopt ConstructorDeclarator Throwsopt ConstructorBody
157    ConstructorDeclarator ::= TypeParametersopt SimpleTypeName ( FormalParameterListopt )
158    SimpleTypeName ::= identifier
159    ConstructorModifiers ::= ConstructorModifier
160                           | ConstructorModifiers ConstructorModifier
161    ConstructorModifier ::= Annotations
162                          | public
163                          | protected
164                          | private
165    ConstructorBody ::= { ExplicitConstructorInvocationopt BlockStatementsopt }
166    ExplicitConstructorInvocation ::= TypeArgumentsopt this ( ArgumentListopt ) ;
167                                    | TypeArgumentsopt super ( ArgumentListopt ) ;
168                                    | Primary . TypeArgumentsopt super ( ArgumentListopt ) ;
169    EnumDeclaration ::= ClassModifiersopt enum identifier Interfacesopt EnumBody
170    EnumBody ::= { EnumConstantsopt ,opt EnumBodyDeclarationsopt }
171    EnumConstants ::= EnumConstant
172                    | EnumConstants , EnumConstant
173    EnumConstant ::= Annotationsopt identifier Argumentsopt ClassBodyopt
174    Arguments ::= ( ArgumentListopt )
175    EnumBodyDeclarations ::= ; ClassBodyDeclarationsopt
176    InterfaceDeclaration ::= NormalInterfaceDeclaration
177                           | AnnotationTypeDeclaration
178    NormalInterfaceDeclaration ::= InterfaceModifiersopt interface identifier TypeParametersopt ExtendsInterfacesopt InterfaceBody
179    InterfaceModifiers ::= InterfaceModifier
180                         | InterfaceModifiers InterfaceModifier
181    InterfaceModifier ::= Annotation
182                        | public
183                        | protected
184                        | private
185                        | abstract
186                        | static
187                        | strictfp
188    ExtendsInterfaces ::= extends InterfaceType
189                        | ExtendsInterfaces , InterfaceType
190    InterfaceBody ::= { InterfaceMemberDeclarationsopt }
191    InterfaceMemberDeclarations ::= InterfaceMemberDeclaration
192                                  | InterfaceMemberDeclarations InterfaceMemberDeclaration
193    InterfaceMemberDeclaration ::= ConstantDeclaration
194                                 | AbstractMethodDeclaration
195                                 | ClassDeclaration
196                                 | InterfaceDeclaration
197                                 | ;
198                                 | ERROR_TOKEN
199    ConstantDeclaration ::= ConstantModifiersopt Type VariableDeclarators
200    ConstantModifiers ::= ConstantModifier
201                        | ConstantModifiers ConstantModifier
202    ConstantModifier ::= Annotation
203                       | public
204                       | static
205                       | final
206    AbstractMethodDeclaration ::= AbstractMethodModifiersopt TypeParametersopt ResultType MethodDeclarator Throwsopt ;
207    AbstractMethodModifiers ::= AbstractMethodModifier
208                              | AbstractMethodModifiers AbstractMethodModifier
209    AbstractMethodModifier ::= Annotations
210                             | public
211                             | abstract
212    AnnotationTypeDeclaration ::= InterfaceModifiersopt @ interface identifier AnnotationTypeBody
213    AnnotationTypeBody ::= { AnnotationTypeElementDeclarationsopt }
214    AnnotationTypeElementDeclarations ::= AnnotationTypeElementDeclaration
215                                        | AnnotationTypeElementDeclarations AnnotationTypeElementDeclaration
216    AnnotationTypeElementDeclaration ::= AbstractMethodModifiersopt Type identifier ( ) DefaultValueopt ;
217                                       | ConstantDeclaration
218                                       | ClassDeclaration
219                                       | InterfaceDeclaration
220                                       | EnumDeclaration
221                                       | AnnotationTypeDeclaration
222                                       | ;
223    DefaultValue ::= default ElementValue
224    Annotations ::= Annotation
225                  | Annotations Annotation
226    Annotation ::= NormalAnnotation
227                 | MarkerAnnotation
228                 | SingleElementAnnotation
229    NormalAnnotation ::= @ TypeName ( ElementValuePairsopt )
230    ElementValuePairs ::= ElementValuePair
231                        | ElementValuePairs , ElementValuePair
232    ElementValuePair ::= SimpleName = ElementValue
233    SimpleName ::= identifier
234    ElementValue ::= ConditionalExpression
235                   | Annotation
236                   | ElementValueArrayInitializer
237    ElementValueArrayInitializer ::= { ElementValuesopt ,opt }
238    ElementValues ::= ElementValue
239                    | ElementValues , ElementValue
240    MarkerAnnotation ::= @ TypeName
241    SingleElementAnnotation ::= @ TypeName ( ElementValue )
242    ArrayInitializer ::= { VariableInitializersopt ,opt }
243    VariableInitializers ::= VariableInitializer
244                           | VariableInitializers , VariableInitializer
245    Block ::= { BlockStatementsopt }
246    BlockStatements ::= BlockStatement
247                      | BlockStatements BlockStatement
248    BlockStatement ::= LocalVariableDeclarationStatement
249                     | ClassDeclaration
250                     | Statement
251    LocalVariableDeclarationStatement ::= LocalVariableDeclaration ;
252    LocalVariableDeclaration ::= VariableModifiersopt Type VariableDeclarators
253    Statement ::= StatementWithoutTrailingSubstatement
254                | LabeledStatement
255                | IfThenStatement
256                | IfThenElseStatement
257                | WhileStatement
258                | ForStatement
259    StatementWithoutTrailingSubstatement ::= Block
260                                           | EmptyStatement
261                                           | ExpressionStatement
262                                           | AssertStatement
263                                           | SwitchStatement
264                                           | DoStatement
265                                           | BreakStatement
266                                           | ContinueStatement
267                                           | ReturnStatement
268                                           | SynchronizedStatement
269                                           | ThrowStatement
270                                           | TryStatement
271    StatementNoShortIf ::= StatementWithoutTrailingSubstatement
272                         | LabeledStatementNoShortIf
273                         | IfThenElseStatementNoShortIf
274                         | WhileStatementNoShortIf
275                         | ForStatementNoShortIf
276    IfThenStatement ::= if ( Expression ) Statement
277    IfThenElseStatement ::= if ( Expression ) StatementNoShortIf else Statement
278    IfThenElseStatementNoShortIf ::= if ( Expression ) StatementNoShortIf else StatementNoShortIf
279    EmptyStatement ::= ;
280                     | ERROR_TOKEN
281    LabeledStatement ::= identifier : Statement
282    LabeledStatementNoShortIf ::= identifier : StatementNoShortIf
283    ExpressionStatement ::= StatementExpression ;
284    StatementExpression ::= Assignment
285                          | PreIncrementExpression
286                          | PreDecrementExpression
287                          | PostIncrementExpression
288                          | PostDecrementExpression
289                          | MethodInvocation
290                          | ClassInstanceCreationExpression
291    AssertStatement ::= assert Expression ;
292                      | assert Expression : Expression ;
293    SwitchStatement ::= switch ( Expression ) SwitchBlock
294    SwitchBlock ::= { SwitchBlockStatementGroupsopt SwitchLabelsopt }
295    SwitchBlockStatementGroups ::= SwitchBlockStatementGroup
296                                 | SwitchBlockStatementGroups SwitchBlockStatementGroup
297    SwitchBlockStatementGroup ::= SwitchLabels BlockStatements
298    SwitchLabels ::= SwitchLabel
299                   | SwitchLabels SwitchLabel
300    SwitchLabel ::= case ConstantExpression :
301                  | case EnumConstant :
302                  | default :
303    EnumConstant ::= identifier
304    WhileStatement ::= while ( Expression ) Statement
305    WhileStatementNoShortIf ::= while ( Expression ) StatementNoShortIf
306    DoStatement ::= do Statement while ( Expression ) ;
307    ForStatement ::= BasicForStatement
308                   | EnhancedForStatement
309    BasicForStatement ::= for ( ForInitopt ; Expressionopt ; ForUpdateopt ) Statement
310    ForStatementNoShortIf ::= for ( ForInitopt ; Expressionopt ; ForUpdateopt ) StatementNoShortIf
311    ForInit ::= StatementExpressionList
312              | LocalVariableDeclaration
313    ForUpdate ::= StatementExpressionList
314    StatementExpressionList ::= StatementExpression
315                              | StatementExpressionList , StatementExpression
316    EnhancedForStatement ::= for ( FormalParameter : Expression ) Statement
317    BreakStatement ::= break identifieropt ;
318    ContinueStatement ::= continue identifieropt ;
319    ReturnStatement ::= return Expressionopt ;
320    ThrowStatement ::= throw Expression ;
321    SynchronizedStatement ::= synchronized ( Expression ) Block
322    TryStatement ::= try Block Catches
323                   | try Block Catchesopt Finally
324    Catches ::= CatchClause
325              | Catches CatchClause
326    CatchClause ::= catch ( FormalParameter ) Block
327    Finally ::= finally Block
328    Primary ::= PrimaryNoNewArray
329              | ArrayCreationExpression
330    PrimaryNoNewArray ::= Literal
331                        | Type . class
332                        | void . class
333                        | this
334                        | ClassName . this
335                        | ( Expression )
336                        | ClassInstanceCreationExpression
337                        | FieldAccess
338                        | MethodInvocation
339                        | ArrayAccess
340    Literal ::= IntegerLiteral
341              | LongLiteral
342              | FloatingPointLiteral
343              | DoubleLiteral
344              | BooleanLiteral
345              | CharacterLiteral
346              | StringLiteral
347              | null
348    BooleanLiteral ::= true
349                     | false
350    ClassInstanceCreationExpression ::= new TypeArgumentsopt ClassOrInterfaceType TypeArgumentsopt ( ArgumentListopt ) ClassBodyopt
351                                      | Primary . new TypeArgumentsopt identifier TypeArgumentsopt ( ArgumentListopt ) ClassBodyopt
352                                      | name . new TypeArgumentsopt identifier TypeArgumentsopt ( ArgumentListopt ) ClassBodyopt
353    ArgumentList ::= Expression
354                   | ArgumentList , Expression
355    ArrayCreationExpression ::= new PrimitiveType DimExprs Dimsopt
356                              | new ClassOrInterfaceType DimExprs Dimsopt
357                              | new PrimitiveType Dims ArrayInitializer
358                              | new ClassOrInterfaceType Dims ArrayInitializer
359    DimExprs ::= DimExpr
360               | DimExprs DimExpr
361    DimExpr ::= [ Expression ]
362    Dims ::= [ ]
363           | Dims [ ]
364    FieldAccess ::= Primary . identifier
365                  | super . identifier
366                  | ClassName . super . identifier
367    MethodInvocation ::= MethodName ( ArgumentListopt )
368                       | Primary . TypeArgumentsopt identifier ( ArgumentListopt )
369                       | super . TypeArgumentsopt identifier ( ArgumentListopt )
370                       | ClassName . super . TypeArgumentsopt identifier ( ArgumentListopt )
371                       | TypeName . TypeArguments identifier ( ArgumentListopt )
372    ArrayAccess ::= ExpressionName [ Expression ]
373                  | PrimaryNoNewArray [ Expression ]
374    PostfixExpression ::= Primary
375                        | ExpressionName
376                        | PostIncrementExpression
377                        | PostDecrementExpression
378    PostIncrementExpression ::= PostfixExpression ++
379    PostDecrementExpression ::= PostfixExpression '--'
380    UnaryExpression ::= PreIncrementExpression
381                      | PreDecrementExpression
382                      | + UnaryExpression
383                      | - UnaryExpression
384                      | UnaryExpressionNotPlusMinus
385    PreIncrementExpression ::= ++ UnaryExpression
386    PreDecrementExpression ::= '--' UnaryExpression
387    UnaryExpressionNotPlusMinus ::= PostfixExpression
388                                  | ~ UnaryExpression
389                                  | ! UnaryExpression
390                                  | CastExpression
391    CastExpression ::= ( PrimitiveType Dimsopt ) UnaryExpression
392                     | ( ReferenceType ) UnaryExpressionNotPlusMinus
393    MultiplicativeExpression ::= UnaryExpression
394                               | MultiplicativeExpression * UnaryExpression
395                               | MultiplicativeExpression / UnaryExpression
396                               | MultiplicativeExpression % UnaryExpression
397    AdditiveExpression ::= MultiplicativeExpression
398                         | AdditiveExpression + MultiplicativeExpression
399                         | AdditiveExpression - MultiplicativeExpression
400    ShiftExpression ::= AdditiveExpression
401                      | ShiftExpression << AdditiveExpression
402                      | ShiftExpression > > AdditiveExpression
403                      | ShiftExpression > > > AdditiveExpression
404    RelationalExpression ::= ShiftExpression
405                           | RelationalExpression < ShiftExpression
406                           | RelationalExpression > ShiftExpression
407                           | RelationalExpression <= ShiftExpression
408                           | RelationalExpression > = ShiftExpression
409                           | RelationalExpression instanceof ReferenceType
410    EqualityExpression ::= RelationalExpression
411                         | EqualityExpression == RelationalExpression
412                         | EqualityExpression != RelationalExpression
413    AndExpression ::= EqualityExpression
414                    | AndExpression & EqualityExpression
415    ExclusiveOrExpression ::= AndExpression
416                            | ExclusiveOrExpression ^ AndExpression
417    InclusiveOrExpression ::= ExclusiveOrExpression
418                            | InclusiveOrExpression '|' ExclusiveOrExpression
419    ConditionalAndExpression ::= InclusiveOrExpression
420                               | ConditionalAndExpression && InclusiveOrExpression
421    ConditionalOrExpression ::= ConditionalAndExpression
422                              | ConditionalOrExpression || ConditionalAndExpression
423    ConditionalExpression ::= ConditionalOrExpression
424                            | ConditionalOrExpression ? Expression : ConditionalExpression
425    AssignmentExpression ::= ConditionalExpression
426                           | Assignment
427    Assignment ::= LeftHandSide AssignmentOperator AssignmentExpression
428    LeftHandSide ::= ExpressionName
429                   | FieldAccess
430                   | ArrayAccess
431    AssignmentOperator ::= =
432                         | *=
433                         | /=
434                         | %=
435                         | +=
436                         | -=
437                         | <<=
438                         | > > =
439                         | > > > =
440                         | &=
441                         | ^=
442                         | |=
443    Expression ::= AssignmentExpression
444    ConstantExpression ::= Expression
445    Dimsopt ::= $Empty
446              | Dims
447    Catchesopt ::= $Empty
448                 | Catches
449    identifieropt ::= $Empty
450                    | identifier
451    ForUpdateopt ::= $Empty
452                   | ForUpdate
453    Expressionopt ::= $Empty
454                    | Expression
455    ForInitopt ::= $Empty
456                 | ForInit
457    SwitchLabelsopt ::= $Empty
458                      | SwitchLabels
459    SwitchBlockStatementGroupsopt ::= $Empty
460                                    | SwitchBlockStatementGroups
461    VariableModifiersopt ::= $Empty
462                           | VariableModifiers
463    VariableInitializersopt ::= $Empty
464                              | VariableInitializers
465    ElementValuesopt ::= $Empty
466                       | ElementValues
467    ElementValuePairsopt ::= $Empty
468                           | ElementValuePairs
469    DefaultValueopt ::= $Empty
470                      | DefaultValue
471    AnnotationTypeElementDeclarationsopt ::= $Empty
472                                           | AnnotationTypeElementDeclarations
473    AbstractMethodModifiersopt ::= $Empty
474                                 | AbstractMethodModifiers
475    ConstantModifiersopt ::= $Empty
476                           | ConstantModifiers
477    InterfaceMemberDeclarationsopt ::= $Empty
478                                     | InterfaceMemberDeclarations
479    ExtendsInterfacesopt ::= $Empty
480                           | ExtendsInterfaces
481    InterfaceModifiersopt ::= $Empty
482                            | InterfaceModifiers
483    ClassBodyopt ::= $Empty
484                   | ClassBody
485    Argumentsopt ::= $Empty
486                   | Arguments
487    EnumBodyDeclarationsopt ::= $Empty
488                              | EnumBodyDeclarations
489    ,opt ::= $Empty
490           | ,
491    EnumConstantsopt ::= $Empty
492                       | EnumConstants
493    ArgumentListopt ::= $Empty
494                      | ArgumentList
495    BlockStatementsopt ::= $Empty
496                         | BlockStatements
497    ExplicitConstructorInvocationopt ::= $Empty
498                                       | ExplicitConstructorInvocation
499    ConstructorModifiersopt ::= $Empty
500                              | ConstructorModifiers
501    ...opt ::= $Empty
502             | ...
503    FormalParameterListopt ::= $Empty
504                             | FormalParameterList
505    Throwsopt ::= $Empty
506                | Throws
507    MethodModifiersopt ::= $Empty
508                         | MethodModifiers
509    FieldModifiersopt ::= $Empty
510                        | FieldModifiers
511    ClassBodyDeclarationsopt ::= $Empty
512                               | ClassBodyDeclarations
513    Interfacesopt ::= $Empty
514                    | Interfaces
515    Superopt ::= $Empty
516               | Super
517    TypeParametersopt ::= $Empty
518                        | TypeParameters
519    ClassModifiersopt ::= $Empty
520                        | ClassModifiers
521    Annotationsopt ::= $Empty
522                     | Annotations
523    TypeDeclarationsopt ::= $Empty
524                          | TypeDeclarations
525    ImportDeclarationsopt ::= $Empty
526                            | ImportDeclarations
527    PackageDeclarationopt ::= $Empty
528                            | PackageDeclaration
529    WildcardBoundsOpt ::= $Empty
530                        | WildcardBounds
531    AdditionalBoundListopt ::= $Empty
532                             | AdditionalBoundList
533    TypeBoundopt ::= $Empty
534                   | TypeBound
535    TypeArgumentsopt ::= $Empty
536                       | TypeArguments


Strongly-connected components in ranks:

    ArrayType
    ReferenceType
    Type

    ArrayAccess
    MethodInvocation
    FieldAccess
    ClassInstanceCreationExpression
    PrimaryNoNewArray
    Primary

    PostDecrementExpression
    PostIncrementExpression
    PostfixExpression



RANK RULE
==== ====
1    229   NormalAnnotation ::= AT TypeName LPAREN ElementValuePairsopt RPAREN
2    240   MarkerAnnotation ::= AT TypeName
3    241   SingleElementAnnotation ::= AT TypeName LPAREN ElementValue RPAREN
4    226   Annotation ::= NormalAnnotation
5    227   Annotation ::= MarkerAnnotation
6    228   Annotation ::= SingleElementAnnotation
7    224   Annotations ::= Annotation
8    225   Annotations ::= Annotations Annotation
9    522   Annotationsopt ::= Annotations
10   521   Annotationsopt ::=
11   54    PackageDeclaration ::= Annotationsopt package PackageName SEMICOLON
12   528   PackageDeclarationopt ::= PackageDeclaration
13   527   PackageDeclarationopt ::=
14   59    SingleTypeImportDeclaration ::= import TypeName SEMICOLON
15   60    TypeImportOnDemandDeclaration ::= import PackageOrTypeName DOT MULTIPLY SEMICOLON
16   61    SingleStaticImportDeclaration ::= import static TypeName DOT identifier SEMICOLON
17   62    StaticImportOnDemandDeclaration ::= import static TypeName DOT MULTIPLY SEMICOLON
18   55    ImportDeclaration ::= SingleTypeImportDeclaration
19   56    ImportDeclaration ::= TypeImportOnDemandDeclaration
20   57    ImportDeclaration ::= SingleStaticImportDeclaration
21   58    ImportDeclaration ::= StaticImportOnDemandDeclaration
22   50    ImportDeclarations ::= ImportDeclaration
23   51    ImportDeclarations ::= ImportDeclarations ImportDeclaration
24   526   ImportDeclarationsopt ::= ImportDeclarations
25   525   ImportDeclarationsopt ::=
26   72    ClassModifier ::= Annotation
27   73    ClassModifier ::= public
28   74    ClassModifier ::= protected
29   75    ClassModifier ::= private
30   76    ClassModifier ::= abstract
31   77    ClassModifier ::= static
32   78    ClassModifier ::= final
33   79    ClassModifier ::= strictfp
34   70    ClassModifiers ::= ClassModifier
35   71    ClassModifiers ::= ClassModifiers ClassModifier
36   520   ClassModifiersopt ::= ClassModifiers
37   519   ClassModifiersopt ::=
38   69    NormalClassDeclaration ::= ClassModifiersopt class identifier TypeParametersopt Superopt Interfacesopt ClassBody
39   169   EnumDeclaration ::= ClassModifiersopt enum identifier Interfacesopt EnumBody
40   67    ClassDeclaration ::= NormalClassDeclaration
41   68    ClassDeclaration ::= EnumDeclaration
42   181   InterfaceModifier ::= Annotation
43   182   InterfaceModifier ::= public
44   183   InterfaceModifier ::= protected
45   184   InterfaceModifier ::= private
46   185   InterfaceModifier ::= abstract
47   186   InterfaceModifier ::= static
48   187   InterfaceModifier ::= strictfp
49   179   InterfaceModifiers ::= InterfaceModifier
50   180   InterfaceModifiers ::= InterfaceModifiers InterfaceModifier
51   482   InterfaceModifiersopt ::= InterfaceModifiers
52   481   InterfaceModifiersopt ::=
53   178   NormalInterfaceDeclaration ::= InterfaceModifiersopt interface identifier TypeParametersopt ExtendsInterfacesopt InterfaceBody
54   212   AnnotationTypeDeclaration ::= InterfaceModifiersopt AT interface identifier AnnotationTypeBody
55   176   InterfaceDeclaration ::= NormalInterfaceDeclaration
56   177   InterfaceDeclaration ::= AnnotationTypeDeclaration
57   63    TypeDeclaration ::= ClassDeclaration
58   64    TypeDeclaration ::= InterfaceDeclaration
59   65    TypeDeclaration ::= SEMICOLON
60   66    TypeDeclaration ::= ERROR_TOKEN
61   52    TypeDeclarations ::= TypeDeclaration
62   53    TypeDeclarations ::= TypeDeclarations TypeDeclaration
63   524   TypeDeclarationsopt ::= TypeDeclarations
64   523   TypeDeclarationsopt ::=
65   49    CompilationUnit ::= PackageDeclarationopt ImportDeclarationsopt TypeDeclarationsopt
66   0     $accept ::= CompilationUnit
67   1     identifier ::= IDENTIFIER
68   8     IntegralType ::= byte
69   9     IntegralType ::= short
70   10    IntegralType ::= int
71   11    IntegralType ::= long
72   12    IntegralType ::= char
73   13    FloatingPointType ::= float
74   14    FloatingPointType ::= double
75   6     NumericType ::= IntegralType
76   7     NumericType ::= FloatingPointType
77   4     PrimitiveType ::= NumericType
78   5     PrimitiveType ::= boolean
79   21    TypeName ::= identifier
80   22    TypeName ::= TypeName DOT identifier
81   19    ClassType ::= TypeName TypeArgumentsopt
82   18    ClassOrInterfaceType ::= ClassType
83   24    TypeVariable ::= identifier
84   25    ArrayType ::= Type LBRACKET RBRACKET
85   15    ReferenceType ::= ClassOrInterfaceType
86   16    ReferenceType ::= TypeVariable
87   17    ReferenceType ::= ArrayType
88   2     Type ::= PrimitiveType
89   3     Type ::= ReferenceType
90   31    TypeArguments ::= LESS ActualTypeArgumentList GREATER
91   536   TypeArgumentsopt ::= TypeArguments
92   535   TypeArgumentsopt ::=
93   20    InterfaceType ::= TypeName TypeArgumentsopt
94   23    ClassName ::= TypeName
95   26    TypeParameter ::= TypeVariable TypeBoundopt
96   27    TypeBound ::= extends ClassOrInterfaceType AdditionalBoundListopt
97   534   TypeBoundopt ::= TypeBound
98   533   TypeBoundopt ::=
99   30    AdditionalBound ::= AND InterfaceType
100  28    AdditionalBoundList ::= AdditionalBound
101  29    AdditionalBoundList ::= AdditionalBoundList AdditionalBound
102  532   AdditionalBoundListopt ::= AdditionalBoundList
103  531   AdditionalBoundListopt ::=
104  36    Wildcard ::= QUESTION WildcardBoundsOpt
105  34    ActualTypeArgument ::= ReferenceType
106  35    ActualTypeArgument ::= Wildcard
107  32    ActualTypeArgumentList ::= ActualTypeArgument
108  33    ActualTypeArgumentList ::= ActualTypeArgumentList COMMA ActualTypeArgument
109  37    WildcardBounds ::= extends ReferenceType
110  38    WildcardBounds ::= super ReferenceType
111  530   WildcardBoundsOpt ::= WildcardBounds
112  529   WildcardBoundsOpt ::=
113  39    PackageName ::= identifier
114  40    PackageName ::= PackageName DOT identifier
115  47    AmbiguousName ::= identifier
116  48    AmbiguousName ::= AmbiguousName DOT identifier
117  41    ExpressionName ::= identifier
118  42    ExpressionName ::= AmbiguousName DOT identifier
119  43    MethodName ::= identifier
120  44    MethodName ::= AmbiguousName DOT identifier
121  45    PackageOrTypeName ::= identifier
122  46    PackageOrTypeName ::= PackageOrTypeName DOT identifier
123  80    TypeParameters ::= LESS TypeParameterList GREATER
124  518   TypeParametersopt ::= TypeParameters
125  517   TypeParametersopt ::=
126  83    Super ::= extends ClassType
127  516   Superopt ::= Super
128  515   Superopt ::=
129  84    Interfaces ::= implements InterfaceTypeList
130  514   Interfacesopt ::= Interfaces
131  513   Interfacesopt ::=
132  87    ClassBody ::= LBRACE ClassBodyDeclarationsopt RBRACE
133  81    TypeParameterList ::= TypeParameter
134  82    TypeParameterList ::= TypeParameterList COMMA TypeParameter
135  85    InterfaceTypeList ::= InterfaceType
136  86    InterfaceTypeList ::= InterfaceTypeList COMMA InterfaceType
137  111   FieldModifier ::= Annotation
138  112   FieldModifier ::= public
139  113   FieldModifier ::= protected
140  114   FieldModifier ::= private
141  115   FieldModifier ::= static
142  116   FieldModifier ::= final
143  117   FieldModifier ::= transient
144  118   FieldModifier ::= volatile
145  109   FieldModifiers ::= FieldModifier
146  110   FieldModifiers ::= FieldModifiers FieldModifier
147  510   FieldModifiersopt ::= FieldModifiers
148  509   FieldModifiersopt ::=
149  100   FieldDeclaration ::= FieldModifiersopt Type VariableDeclarators SEMICOLON
150  137   MethodModifier ::= Annotations
151  138   MethodModifier ::= public
152  139   MethodModifier ::= protected
153  140   MethodModifier ::= private
154  141   MethodModifier ::= abstract
155  142   MethodModifier ::= static
156  143   MethodModifier ::= final
157  144   MethodModifier ::= synchronized
158  145   MethodModifier ::= native
159  146   MethodModifier ::= strictfp
160  135   MethodModifiers ::= MethodModifier
161  136   MethodModifiers ::= MethodModifiers MethodModifier
162  508   MethodModifiersopt ::= MethodModifiers
163  507   MethodModifiersopt ::=
164  121   ResultType ::= Type
165  122   ResultType ::= void
166  120   MethodHeader ::= MethodModifiersopt TypeParametersopt ResultType MethodDeclarator Throwsopt
167  119   MethodDeclaration ::= MethodHeader MethodBody
168  95    ClassMemberDeclaration ::= FieldDeclaration
169  96    ClassMemberDeclaration ::= MethodDeclaration
170  97    ClassMemberDeclaration ::= ClassDeclaration
171  98    ClassMemberDeclaration ::= InterfaceDeclaration
172  99    ClassMemberDeclaration ::= SEMICOLON
173  245   Block ::= LBRACE BlockStatementsopt RBRACE
174  154   InstanceInitializer ::= Block
175  155   StaticInitializer ::= static Block
176  161   ConstructorModifier ::= Annotations
177  162   ConstructorModifier ::= public
178  163   ConstructorModifier ::= protected
179  164   ConstructorModifier ::= private
180  159   ConstructorModifiers ::= ConstructorModifier
181  160   ConstructorModifiers ::= ConstructorModifiers ConstructorModifier
182  500   ConstructorModifiersopt ::= ConstructorModifiers
183  499   ConstructorModifiersopt ::=
184  158   SimpleTypeName ::= identifier
185  157   ConstructorDeclarator ::= TypeParametersopt SimpleTypeName LPAREN FormalParameterListopt RPAREN
186  156   ConstructorDeclaration ::= ConstructorModifiersopt ConstructorDeclarator Throwsopt ConstructorBody
187  90    ClassBodyDeclaration ::= ClassMemberDeclaration
188  91    ClassBodyDeclaration ::= InstanceInitializer
189  92    ClassBodyDeclaration ::= StaticInitializer
190  93    ClassBodyDeclaration ::= ConstructorDeclaration
191  94    ClassBodyDeclaration ::= ERROR_TOKEN
192  88    ClassBodyDeclarations ::= ClassBodyDeclaration
193  89    ClassBodyDeclarations ::= ClassBodyDeclarations ClassBodyDeclaration
194  512   ClassBodyDeclarationsopt ::= ClassBodyDeclarations
195  511   ClassBodyDeclarationsopt ::=
196  105   VariableDeclaratorId ::= identifier
197  106   VariableDeclaratorId ::= VariableDeclaratorId LBRACKET RBRACKET
198  103   VariableDeclarator ::= VariableDeclaratorId
199  104   VariableDeclarator ::= VariableDeclaratorId EQUAL VariableInitializer
200  101   VariableDeclarators ::= VariableDeclarator
201  102   VariableDeclarators ::= VariableDeclarators COMMA VariableDeclarator
202  385   PreIncrementExpression ::= PLUS_PLUS UnaryExpression
203  386   PreDecrementExpression ::= MINUS_MINUS UnaryExpression
204  348   BooleanLiteral ::= true
205  349   BooleanLiteral ::= false
206  340   Literal ::= IntegerLiteral
207  341   Literal ::= LongLiteral
208  342   Literal ::= FloatingPointLiteral
209  343   Literal ::= DoubleLiteral
210  344   Literal ::= BooleanLiteral
211  345   Literal ::= CharacterLiteral
212  346   Literal ::= StringLiteral
213  347   Literal ::= null
214  355   ArrayCreationExpression ::= new PrimitiveType DimExprs Dimsopt
215  356   ArrayCreationExpression ::= new ClassOrInterfaceType DimExprs Dimsopt
216  357   ArrayCreationExpression ::= new PrimitiveType Dims ArrayInitializer
217  358   ArrayCreationExpression ::= new ClassOrInterfaceType Dims ArrayInitializer
218  372   ArrayAccess ::= ExpressionName LBRACKET Expression RBRACKET
219  373   ArrayAccess ::= PrimaryNoNewArray LBRACKET Expression RBRACKET
220  367   MethodInvocation ::= MethodName LPAREN ArgumentListopt RPAREN
221  368   MethodInvocation ::= Primary DOT TypeArgumentsopt identifier LPAREN ArgumentListopt RPAREN
222  369   MethodInvocation ::= super DOT TypeArgumentsopt identifier LPAREN ArgumentListopt RPAREN
223  370   MethodInvocation ::= ClassName DOT super DOT TypeArgumentsopt identifier LPAREN ArgumentListopt RPAREN
224  371   MethodInvocation ::= TypeName DOT TypeArguments identifier LPAREN ArgumentListopt RPAREN
225  364   FieldAccess ::= Primary DOT identifier
226  365   FieldAccess ::= super DOT identifier
227  366   FieldAccess ::= ClassName DOT super DOT identifier
228  350   ClassInstanceCreationExpression ::= new TypeArgumentsopt ClassOrInterfaceType TypeArgumentsopt LPAREN ArgumentListopt RPAREN ClassBodyopt
229  351   ClassInstanceCreationExpression ::= Primary DOT new TypeArgumentsopt identifier TypeArgumentsopt LPAREN ArgumentListopt RPAREN ClassBodyopt
230  352   ClassInstanceCreationExpression ::= name DOT new TypeArgumentsopt identifier TypeArgumentsopt LPAREN ArgumentListopt RPAREN ClassBodyopt
231  330   PrimaryNoNewArray ::= Literal
232  331   PrimaryNoNewArray ::= Type DOT class
233  332   PrimaryNoNewArray ::= void DOT class
234  333   PrimaryNoNewArray ::= this
235  334   PrimaryNoNewArray ::= ClassName DOT this
236  335   PrimaryNoNewArray ::= LPAREN Expression RPAREN
237  336   PrimaryNoNewArray ::= ClassInstanceCreationExpression
238  337   PrimaryNoNewArray ::= FieldAccess
239  338   PrimaryNoNewArray ::= MethodInvocation
240  339   PrimaryNoNewArray ::= ArrayAccess
241  328   Primary ::= PrimaryNoNewArray
242  329   Primary ::= ArrayCreationExpression
243  379   PostDecrementExpression ::= PostfixExpression MINUS_MINUS
244  378   PostIncrementExpression ::= PostfixExpression PLUS_PLUS
245  374   PostfixExpression ::= Primary
246  375   PostfixExpression ::= ExpressionName
247  376   PostfixExpression ::= PostIncrementExpression
248  377   PostfixExpression ::= PostDecrementExpression
249  391   CastExpression ::= LPAREN PrimitiveType Dimsopt RPAREN UnaryExpression
250  392   CastExpression ::= LPAREN ReferenceType RPAREN UnaryExpressionNotPlusMinus
251  387   UnaryExpressionNotPlusMinus ::= PostfixExpression
252  388   UnaryExpressionNotPlusMinus ::= TWIDDLE UnaryExpression
253  389   UnaryExpressionNotPlusMinus ::= NOT UnaryExpression
254  390   UnaryExpressionNotPlusMinus ::= CastExpression
255  380   UnaryExpression ::= PreIncrementExpression
256  381   UnaryExpression ::= PreDecrementExpression
257  382   UnaryExpression ::= PLUS UnaryExpression
258  383   UnaryExpression ::= MINUS UnaryExpression
259  384   UnaryExpression ::= UnaryExpressionNotPlusMinus
260  393   MultiplicativeExpression ::= UnaryExpression
261  394   MultiplicativeExpression ::= MultiplicativeExpression MULTIPLY UnaryExpression
262  395   MultiplicativeExpression ::= MultiplicativeExpression DIVIDE UnaryExpression
263  396   MultiplicativeExpression ::= MultiplicativeExpression REMAINDER UnaryExpression
264  397   AdditiveExpression ::= MultiplicativeExpression
265  398   AdditiveExpression ::= AdditiveExpression PLUS MultiplicativeExpression
266  399   AdditiveExpression ::= AdditiveExpression MINUS MultiplicativeExpression
267  400   ShiftExpression ::= AdditiveExpression
268  401   ShiftExpression ::= ShiftExpression LEFT_SHIFT AdditiveExpression
269  402   ShiftExpression ::= ShiftExpression GREATER GREATER AdditiveExpression
270  403   ShiftExpression ::= ShiftExpression GREATER GREATER GREATER AdditiveExpression
271  404   RelationalExpression ::= ShiftExpression
272  405   RelationalExpression ::= RelationalExpression LESS ShiftExpression
273  406   RelationalExpression ::= RelationalExpression GREATER ShiftExpression
274  407   RelationalExpression ::= RelationalExpression LESS_EQUAL ShiftExpression
275  408   RelationalExpression ::= RelationalExpression GREATER EQUAL ShiftExpression
276  409   RelationalExpression ::= RelationalExpression instanceof ReferenceType
277  410   EqualityExpression ::= RelationalExpression
278  411   EqualityExpression ::= EqualityExpression EQUAL_EQUAL RelationalExpression
279  412   EqualityExpression ::= EqualityExpression NOT_EQUAL RelationalExpression
280  413   AndExpression ::= EqualityExpression
281  414   AndExpression ::= AndExpression AND EqualityExpression
282  415   ExclusiveOrExpression ::= AndExpression
283  416   ExclusiveOrExpression ::= ExclusiveOrExpression XOR AndExpression
284  417   InclusiveOrExpression ::= ExclusiveOrExpression
285  418   InclusiveOrExpression ::= InclusiveOrExpression OR ExclusiveOrExpression
286  419   ConditionalAndExpression ::= InclusiveOrExpression
287  420   ConditionalAndExpression ::= ConditionalAndExpression AND_AND InclusiveOrExpression
288  421   ConditionalOrExpression ::= ConditionalAndExpression
289  422   ConditionalOrExpression ::= ConditionalOrExpression OR_OR ConditionalAndExpression
290  423   ConditionalExpression ::= ConditionalOrExpression
291  424   ConditionalExpression ::= ConditionalOrExpression QUESTION Expression COLON ConditionalExpression
292  428   LeftHandSide ::= ExpressionName
293  429   LeftHandSide ::= FieldAccess
294  430   LeftHandSide ::= ArrayAccess
295  427   Assignment ::= LeftHandSide AssignmentOperator AssignmentExpression
296  425   AssignmentExpression ::= ConditionalExpression
297  426   AssignmentExpression ::= Assignment
298  443   Expression ::= AssignmentExpression
299  242   ArrayInitializer ::= LBRACE VariableInitializersopt ,opt RBRACE
300  107   VariableInitializer ::= Expression
301  108   VariableInitializer ::= ArrayInitializer
302  152   MethodBody ::= Block
303  153   MethodBody ::= SEMICOLON
304  123   MethodDeclarator ::= identifier LPAREN FormalParameterListopt RPAREN
305  124   MethodDeclarator ::= MethodDeclarator LBRACKET RBRACKET
306  147   Throws ::= throws ExceptionTypeList
307  506   Throwsopt ::= Throws
308  505   Throwsopt ::=
309  132   VariableModifier ::= final
310  133   VariableModifier ::= Annotations
311  130   VariableModifiers ::= VariableModifier
312  131   VariableModifiers ::= VariableModifiers VariableModifier
313  462   VariableModifiersopt ::= VariableModifiers
314  461   VariableModifiersopt ::=
315  134   LastFormalParameter ::= VariableModifiersopt Type ...opt VariableDeclaratorId
316  129   FormalParameter ::= VariableModifiersopt Type VariableDeclaratorId
317  127   FormalParameters ::= FormalParameter
318  128   FormalParameters ::= FormalParameters COMMA FormalParameter
319  125   FormalParameterList ::= LastFormalParameter
320  126   FormalParameterList ::= FormalParameters COMMA LastFormalParameter
321  504   FormalParameterListopt ::= FormalParameterList
322  503   FormalParameterListopt ::=
323  502   ...opt ::= ELLIPSIS
324  501   ...opt ::=
325  150   ExceptionType ::= ClassType
326  151   ExceptionType ::= TypeVariable
327  148   ExceptionTypeList ::= ExceptionType
328  149   ExceptionTypeList ::= ExceptionTypeList COMMA ExceptionType
329  165   ConstructorBody ::= LBRACE ExplicitConstructorInvocationopt BlockStatementsopt RBRACE
330  166   ExplicitConstructorInvocation ::= TypeArgumentsopt this LPAREN ArgumentListopt RPAREN SEMICOLON
331  167   ExplicitConstructorInvocation ::= TypeArgumentsopt super LPAREN ArgumentListopt RPAREN SEMICOLON
332  168   ExplicitConstructorInvocation ::= Primary DOT TypeArgumentsopt super LPAREN ArgumentListopt RPAREN SEMICOLON
333  498   ExplicitConstructorInvocationopt ::= ExplicitConstructorInvocation
334  497   ExplicitConstructorInvocationopt ::=
335  252   LocalVariableDeclaration ::= VariableModifiersopt Type VariableDeclarators
336  251   LocalVariableDeclarationStatement ::= LocalVariableDeclaration SEMICOLON
337  279   EmptyStatement ::= SEMICOLON
338  280   EmptyStatement ::= ERROR_TOKEN
339  284   StatementExpression ::= Assignment
340  285   StatementExpression ::= PreIncrementExpression
341  286   StatementExpression ::= PreDecrementExpression
342  287   StatementExpression ::= PostIncrementExpression
343  288   StatementExpression ::= PostDecrementExpression
344  289   StatementExpression ::= MethodInvocation
345  290   StatementExpression ::= ClassInstanceCreationExpression
346  283   ExpressionStatement ::= StatementExpression SEMICOLON
347  291   AssertStatement ::= assert Expression SEMICOLON
348  292   AssertStatement ::= assert Expression COLON Expression SEMICOLON
349  293   SwitchStatement ::= switch LPAREN Expression RPAREN SwitchBlock
350  306   DoStatement ::= do Statement while LPAREN Expression RPAREN SEMICOLON
351  317   BreakStatement ::= break identifieropt SEMICOLON
352  318   ContinueStatement ::= continue identifieropt SEMICOLON
353  319   ReturnStatement ::= return Expressionopt SEMICOLON
354  321   SynchronizedStatement ::= synchronized LPAREN Expression RPAREN Block
355  320   ThrowStatement ::= throw Expression SEMICOLON
356  322   TryStatement ::= try Block Catches
357  323   TryStatement ::= try Block Catchesopt Finally
358  259   StatementWithoutTrailingSubstatement ::= Block
359  260   StatementWithoutTrailingSubstatement ::= EmptyStatement
360  261   StatementWithoutTrailingSubstatement ::= ExpressionStatement
361  262   StatementWithoutTrailingSubstatement ::= AssertStatement
362  263   StatementWithoutTrailingSubstatement ::= SwitchStatement
363  264   StatementWithoutTrailingSubstatement ::= DoStatement
364  265   StatementWithoutTrailingSubstatement ::= BreakStatement
365  266   StatementWithoutTrailingSubstatement ::= ContinueStatement
366  267   StatementWithoutTrailingSubstatement ::= ReturnStatement
367  268   StatementWithoutTrailingSubstatement ::= SynchronizedStatement
368  269   StatementWithoutTrailingSubstatement ::= ThrowStatement
369  270   StatementWithoutTrailingSubstatement ::= TryStatement
370  281   LabeledStatement ::= identifier COLON Statement
371  276   IfThenStatement ::= if LPAREN Expression RPAREN Statement
372  277   IfThenElseStatement ::= if LPAREN Expression RPAREN StatementNoShortIf else Statement
373  304   WhileStatement ::= while LPAREN Expression RPAREN Statement
374  309   BasicForStatement ::= for LPAREN ForInitopt SEMICOLON Expressionopt SEMICOLON ForUpdateopt RPAREN Statement
375  316   EnhancedForStatement ::= for LPAREN FormalParameter COLON Expression RPAREN Statement
376  307   ForStatement ::= BasicForStatement
377  308   ForStatement ::= EnhancedForStatement
378  253   Statement ::= StatementWithoutTrailingSubstatement
379  254   Statement ::= LabeledStatement
380  255   Statement ::= IfThenStatement
381  256   Statement ::= IfThenElseStatement
382  257   Statement ::= WhileStatement
383  258   Statement ::= ForStatement
384  248   BlockStatement ::= LocalVariableDeclarationStatement
385  249   BlockStatement ::= ClassDeclaration
386  250   BlockStatement ::= Statement
387  246   BlockStatements ::= BlockStatement
388  247   BlockStatements ::= BlockStatements BlockStatement
389  496   BlockStatementsopt ::= BlockStatements
390  495   BlockStatementsopt ::=
391  353   ArgumentList ::= Expression
392  354   ArgumentList ::= ArgumentList COMMA Expression
393  494   ArgumentListopt ::= ArgumentList
394  493   ArgumentListopt ::=
395  170   EnumBody ::= LBRACE EnumConstantsopt ,opt EnumBodyDeclarationsopt RBRACE
396  173   EnumConstant ::= Annotationsopt identifier Argumentsopt ClassBodyopt
397  303   EnumConstant ::= identifier
398  171   EnumConstants ::= EnumConstant
399  172   EnumConstants ::= EnumConstants COMMA EnumConstant
400  492   EnumConstantsopt ::= EnumConstants
401  491   EnumConstantsopt ::=
402  490   ,opt ::= COMMA
403  489   ,opt ::=
404  175   EnumBodyDeclarations ::= SEMICOLON ClassBodyDeclarationsopt
405  488   EnumBodyDeclarationsopt ::= EnumBodyDeclarations
406  487   EnumBodyDeclarationsopt ::=
407  174   Arguments ::= LPAREN ArgumentListopt RPAREN
408  486   Argumentsopt ::= Arguments
409  485   Argumentsopt ::=
410  484   ClassBodyopt ::= ClassBody
411  483   ClassBodyopt ::=
412  188   ExtendsInterfaces ::= extends InterfaceType
413  189   ExtendsInterfaces ::= ExtendsInterfaces COMMA InterfaceType
414  480   ExtendsInterfacesopt ::= ExtendsInterfaces
415  479   ExtendsInterfacesopt ::=
416  190   InterfaceBody ::= LBRACE InterfaceMemberDeclarationsopt RBRACE
417  202   ConstantModifier ::= Annotation
418  203   ConstantModifier ::= public
419  204   ConstantModifier ::= static
420  205   ConstantModifier ::= final
421  200   ConstantModifiers ::= ConstantModifier
422  201   ConstantModifiers ::= ConstantModifiers ConstantModifier
423  476   ConstantModifiersopt ::= ConstantModifiers
424  475   ConstantModifiersopt ::=
425  199   ConstantDeclaration ::= ConstantModifiersopt Type VariableDeclarators
426  209   AbstractMethodModifier ::= Annotations
427  210   AbstractMethodModifier ::= public
428  211   AbstractMethodModifier ::= abstract
429  207   AbstractMethodModifiers ::= AbstractMethodModifier
430  208   AbstractMethodModifiers ::= AbstractMethodModifiers AbstractMethodModifier
431  474   AbstractMethodModifiersopt ::= AbstractMethodModifiers
432  473   AbstractMethodModifiersopt ::=
433  206   AbstractMethodDeclaration ::= AbstractMethodModifiersopt TypeParametersopt ResultType MethodDeclarator Throwsopt SEMICOLON
434  193   InterfaceMemberDeclaration ::= ConstantDeclaration
435  194   InterfaceMemberDeclaration ::= AbstractMethodDeclaration
436  195   InterfaceMemberDeclaration ::= ClassDeclaration
437  196   InterfaceMemberDeclaration ::= InterfaceDeclaration
438  197   InterfaceMemberDeclaration ::= SEMICOLON
439  198   InterfaceMemberDeclaration ::= ERROR_TOKEN
440  191   InterfaceMemberDeclarations ::= InterfaceMemberDeclaration
441  192   InterfaceMemberDeclarations ::= InterfaceMemberDeclarations InterfaceMemberDeclaration
442  478   InterfaceMemberDeclarationsopt ::= InterfaceMemberDeclarations
443  477   InterfaceMemberDeclarationsopt ::=
444  213   AnnotationTypeBody ::= LBRACE AnnotationTypeElementDeclarationsopt RBRACE
445  216   AnnotationTypeElementDeclaration ::= AbstractMethodModifiersopt Type identifier LPAREN RPAREN DefaultValueopt SEMICOLON
446  217   AnnotationTypeElementDeclaration ::= ConstantDeclaration
447  218   AnnotationTypeElementDeclaration ::= ClassDeclaration
448  219   AnnotationTypeElementDeclaration ::= InterfaceDeclaration
449  220   AnnotationTypeElementDeclaration ::= EnumDeclaration
450  221   AnnotationTypeElementDeclaration ::= AnnotationTypeDeclaration
451  222   AnnotationTypeElementDeclaration ::= SEMICOLON
452  214   AnnotationTypeElementDeclarations ::= AnnotationTypeElementDeclaration
453  215   AnnotationTypeElementDeclarations ::= AnnotationTypeElementDeclarations AnnotationTypeElementDeclaration
454  472   AnnotationTypeElementDeclarationsopt ::= AnnotationTypeElementDeclarations
455  471   AnnotationTypeElementDeclarationsopt ::=
456  223   DefaultValue ::= default ElementValue
457  470   DefaultValueopt ::= DefaultValue
458  469   DefaultValueopt ::=
459  237   ElementValueArrayInitializer ::= LBRACE ElementValuesopt ,opt RBRACE
460  234   ElementValue ::= ConditionalExpression
461  235   ElementValue ::= Annotation
462  236   ElementValue ::= ElementValueArrayInitializer
463  233   SimpleName ::= identifier
464  232   ElementValuePair ::= SimpleName EQUAL ElementValue
465  230   ElementValuePairs ::= ElementValuePair
466  231   ElementValuePairs ::= ElementValuePairs COMMA ElementValuePair
467  468   ElementValuePairsopt ::= ElementValuePairs
468  467   ElementValuePairsopt ::=
469  238   ElementValues ::= ElementValue
470  239   ElementValues ::= ElementValues COMMA ElementValue
471  466   ElementValuesopt ::= ElementValues
472  465   ElementValuesopt ::=
473  243   VariableInitializers ::= VariableInitializer
474  244   VariableInitializers ::= VariableInitializers COMMA VariableInitializer
475  464   VariableInitializersopt ::= VariableInitializers
476  463   VariableInitializersopt ::=
477  282   LabeledStatementNoShortIf ::= identifier COLON StatementNoShortIf
478  278   IfThenElseStatementNoShortIf ::= if LPAREN Expression RPAREN StatementNoShortIf else StatementNoShortIf
479  305   WhileStatementNoShortIf ::= while LPAREN Expression RPAREN StatementNoShortIf
480  310   ForStatementNoShortIf ::= for LPAREN ForInitopt SEMICOLON Expressionopt SEMICOLON ForUpdateopt RPAREN StatementNoShortIf
481  271   StatementNoShortIf ::= StatementWithoutTrailingSubstatement
482  272   StatementNoShortIf ::= LabeledStatementNoShortIf
483  273   StatementNoShortIf ::= IfThenElseStatementNoShortIf
484  274   StatementNoShortIf ::= WhileStatementNoShortIf
485  275   StatementNoShortIf ::= ForStatementNoShortIf
486  294   SwitchBlock ::= LBRACE SwitchBlockStatementGroupsopt SwitchLabelsopt RBRACE
487  300   SwitchLabel ::= case ConstantExpression COLON
488  301   SwitchLabel ::= case EnumConstant COLON
489  302   SwitchLabel ::= default COLON
490  298   SwitchLabels ::= SwitchLabel
491  299   SwitchLabels ::= SwitchLabels SwitchLabel
492  297   SwitchBlockStatementGroup ::= SwitchLabels BlockStatements
493  295   SwitchBlockStatementGroups ::= SwitchBlockStatementGroup
494  296   SwitchBlockStatementGroups ::= SwitchBlockStatementGroups SwitchBlockStatementGroup
495  460   SwitchBlockStatementGroupsopt ::= SwitchBlockStatementGroups
496  459   SwitchBlockStatementGroupsopt ::=
497  458   SwitchLabelsopt ::= SwitchLabels
498  457   SwitchLabelsopt ::=
499  444   ConstantExpression ::= Expression
500  314   StatementExpressionList ::= StatementExpression
501  315   StatementExpressionList ::= StatementExpressionList COMMA StatementExpression
502  311   ForInit ::= StatementExpressionList
503  312   ForInit ::= LocalVariableDeclaration
504  456   ForInitopt ::= ForInit
505  455   ForInitopt ::=
506  454   Expressionopt ::= Expression
507  453   Expressionopt ::=
508  313   ForUpdate ::= StatementExpressionList
509  452   ForUpdateopt ::= ForUpdate
510  451   ForUpdateopt ::=
511  450   identifieropt ::= identifier
512  449   identifieropt ::=
513  326   CatchClause ::= catch LPAREN FormalParameter RPAREN Block
514  324   Catches ::= CatchClause
515  325   Catches ::= Catches CatchClause
516  448   Catchesopt ::= Catches
517  447   Catchesopt ::=
518  327   Finally ::= finally Block
519  361   DimExpr ::= LBRACKET Expression RBRACKET
520  359   DimExprs ::= DimExpr
521  360   DimExprs ::= DimExprs DimExpr
522  362   Dims ::= LBRACKET RBRACKET
523  363   Dims ::= Dims LBRACKET RBRACKET
524  446   Dimsopt ::= Dims
525  445   Dimsopt ::=
526  431   AssignmentOperator ::= EQUAL
527  432   AssignmentOperator ::= MULTIPLY_EQUAL
528  433   AssignmentOperator ::= DIVIDE_EQUAL
529  434   AssignmentOperator ::= REMAINDER_EQUAL
530  435   AssignmentOperator ::= PLUS_EQUAL
531  436   AssignmentOperator ::= MINUS_EQUAL
532  437   AssignmentOperator ::= LEFT_SHIFT_EQUAL
533  438   AssignmentOperator ::= GREATER GREATER EQUAL
534  439   AssignmentOperator ::= GREATER GREATER GREATER EQUAL
535  440   AssignmentOperator ::= AND_EQUAL
536  441   AssignmentOperator ::= XOR_EQUAL
537  442   AssignmentOperator ::= OR_EQUAL
D:/eclipse/workspace/lpg.javaruntime.examples/javaexample/genericjavaparser/GJavaParser.g:137:5:137:17:3674:3686: Informative: The terminal GREATER_EQUAL is useless.
D:/eclipse/workspace/lpg.javaruntime.examples/javaexample/genericjavaparser/GJavaParser.g:138:5:138:15:3713:3723: Informative: The terminal RIGHT_SHIFT is useless.
D:/eclipse/workspace/lpg.javaruntime.examples/javaexample/genericjavaparser/GJavaParser.g:139:5:139:21:3752:3768: Informative: The terminal RIGHT_SHIFT_EQUAL is useless.
D:/eclipse/workspace/lpg.javaruntime.examples/javaexample/genericjavaparser/GJavaParser.g:140:5:140:24:3793:3812: Informative: The terminal UNSIGNED_RIGHT_SHIFT is useless.
D:/eclipse/workspace/lpg.javaruntime.examples/javaexample/genericjavaparser/GJavaParser.g:141:5:141:30:3833:3858: Informative: The terminal UNSIGNED_RIGHT_SHIFT_EQUAL is useless.
D:/eclipse/workspace/lpg.javaruntime.examples/javaexample/genericjavaparser/GJavaKWLexer.g:22:5:22:9:297:301: Informative: The terminal const is useless.
D:/eclipse/workspace/lpg.javaruntime.examples/javaexample/genericjavaparser/GJavaKWLexer.g:35:5:35:8:443:446: Informative: The terminal goto is useless.


 IBM LALR Parser Generator              1.00 (Feb 16 2007)


Name map:

'$empty' ::= '$empty'
IntegerLiteral ::= IntegerLiteral
LongLiteral ::= LongLiteral
FloatingPointLiteral ::= FloatingPointLiteral
DoubleLiteral ::= DoubleLiteral
CharacterLiteral ::= CharacterLiteral
StringLiteral ::= StringLiteral
MINUS_MINUS ::= --
OR ::= '|'
MINUS ::= -
MINUS_EQUAL ::= -=
NOT ::= !
NOT_EQUAL ::= !=
REMAINDER ::= %
REMAINDER_EQUAL ::= %=
AND ::= &
AND_AND ::= &&
AND_EQUAL ::= &=
LPAREN ::= (
RPAREN ::= )
MULTIPLY ::= *
MULTIPLY_EQUAL ::= *=
COMMA ::= ,
DOT ::= .
DIVIDE ::= /
DIVIDE_EQUAL ::= /=
COLON ::= :
SEMICOLON ::= ;
QUESTION ::= ?
AT ::= @
LBRACKET ::= [
RBRACKET ::= ]
XOR ::= ^
XOR_EQUAL ::= ^=
LBRACE ::= {
OR_OR ::= ||
OR_EQUAL ::= |=
RBRACE ::= }
TWIDDLE ::= ~
PLUS ::= +
PLUS_PLUS ::= ++
PLUS_EQUAL ::= +=
LESS ::= <
LEFT_SHIFT ::= <<
LEFT_SHIFT_EQUAL ::= <<=
LESS_EQUAL ::= <=
EQUAL ::= =
EQUAL_EQUAL ::= ==
GREATER ::= >
GREATER_EQUAL ::= >=
RIGHT_SHIFT ::= >>
RIGHT_SHIFT_EQUAL ::= >>=
UNSIGNED_RIGHT_SHIFT ::= >>>
UNSIGNED_RIGHT_SHIFT_EQUAL ::= >>>=
ELLIPSIS ::= ...
abstract ::= abstract
assert ::= assert
boolean ::= boolean
break ::= break
byte ::= byte
case ::= case
catch ::= catch
char ::= char
class ::= class
const ::= const
continue ::= continue
default ::= default
do ::= do
double ::= double
enum ::= enum
else ::= else
extends ::= extends
false ::= false
final ::= final
finally ::= finally
float ::= float
for ::= for
goto ::= goto
if ::= if
implements ::= implements
import ::= import
instanceof ::= instanceof
int ::= int
interface ::= interface
long ::= long
native ::= native
new ::= new
null ::= null
package ::= package
private ::= private
protected ::= protected
public ::= public
return ::= return
short ::= short
static ::= static
strictfp ::= strictfp
super ::= super
switch ::= switch
synchronized ::= synchronized
this ::= this
throw ::= throw
throws ::= throws
transient ::= transient
true ::= true
try ::= try
void ::= void
volatile ::= volatile
while ::= while
EOF_TOKEN ::= EOF_TOKEN
IDENTIFIER ::= IDENTIFIER
ERROR_TOKEN ::= ERROR_TOKEN
name ::= name
identifier ::= identifier
Type ::= Type
PrimitiveType ::= PrimitiveType
ReferenceType ::= ReferenceType
ClassOrInterfaceType ::= ClassOrInterfaceType
TypeVariable ::= TypeVariable
ClassType ::= ClassType
TypeName ::= TypeName
InterfaceType ::= InterfaceType
ClassName ::= ClassName
TypeParameter ::= TypeParameter
AdditionalBoundList ::= AdditionalBoundList
AdditionalBound ::= AdditionalBound
TypeArguments ::= TypeArguments
ActualTypeArgumentList ::= ActualTypeArgumentList
ActualTypeArgument ::= ActualTypeArgument
PackageName ::= PackageName
ExpressionName ::= ExpressionName
AmbiguousName ::= AmbiguousName
MethodName ::= MethodName
PackageOrTypeName ::= PackageOrTypeName
ImportDeclarations ::= ImportDeclarations
ImportDeclaration ::= ImportDeclaration
TypeDeclarations ::= TypeDeclarations
TypeDeclaration ::= TypeDeclaration
EnumDeclaration ::= EnumDeclaration
ClassBody ::= ClassBody
ClassModifiers ::= ClassModifiers
ClassModifier ::= ClassModifier
Annotation ::= Annotation
TypeParameterList ::= TypeParameterList
InterfaceTypeList ::= InterfaceTypeList
ClassBodyDeclarations ::= ClassBodyDeclarations
ClassBodyDeclaration ::= ClassBodyDeclaration
VariableDeclarators ::= VariableDeclarators
VariableDeclarator ::= VariableDeclarator
VariableDeclaratorId ::= VariableDeclaratorId
VariableInitializer ::= VariableInitializer
Expression ::= Expression
ArrayInitializer ::= ArrayInitializer
FieldModifiers ::= FieldModifiers
FieldModifier ::= FieldModifier
MethodHeader ::= MethodHeader
MethodBody ::= MethodBody
ResultType ::= ResultType
MethodDeclarator ::= MethodDeclarator
LastFormalParameter ::= LastFormalParameter
FormalParameters ::= FormalParameters
FormalParameter ::= FormalParameter
VariableModifiers ::= VariableModifiers
VariableModifier ::= VariableModifier
Annotations ::= Annotations
MethodModifiers ::= MethodModifiers
MethodModifier ::= MethodModifier
ExceptionTypeList ::= ExceptionTypeList
ExceptionType ::= ExceptionType
Block ::= Block
ConstructorDeclarator ::= ConstructorDeclarator
ConstructorBody ::= ConstructorBody
SimpleTypeName ::= SimpleTypeName
ConstructorModifiers ::= ConstructorModifiers
ConstructorModifier ::= ConstructorModifier
Primary ::= Primary
EnumBody ::= EnumBody
EnumConstants ::= EnumConstants
EnumConstant ::= EnumConstant
AnnotationTypeDeclaration ::= AnnotationTypeDeclaration
InterfaceBody ::= InterfaceBody
InterfaceModifiers ::= InterfaceModifiers
InterfaceModifier ::= InterfaceModifier
ExtendsInterfaces ::= ExtendsInterfaces
InterfaceMemberDeclarations ::= InterfaceMemberDeclarations
InterfaceMemberDeclaration ::= InterfaceMemberDeclaration
ConstantModifiers ::= ConstantModifiers
ConstantModifier ::= ConstantModifier
AbstractMethodModifiers ::= AbstractMethodModifiers
AbstractMethodModifier ::= AbstractMethodModifier
AnnotationTypeBody ::= AnnotationTypeBody
AnnotationTypeElementDeclarations ::= AnnotationTypeElementDeclarations
AnnotationTypeElementDeclaration ::= AnnotationTypeElementDeclaration
ElementValue ::= ElementValue
ElementValuePairs ::= ElementValuePairs
ElementValuePair ::= ElementValuePair
SimpleName ::= SimpleName
ConditionalExpression ::= ConditionalExpression
ElementValues ::= ElementValues
VariableInitializers ::= VariableInitializers
BlockStatements ::= BlockStatements
BlockStatement ::= BlockStatement
Statement ::= Statement
LocalVariableDeclaration ::= LocalVariableDeclaration
StatementWithoutTrailingSubstatement ::= StatementWithoutTrailingSubstatement
StatementNoShortIf ::= StatementNoShortIf
StatementExpression ::= StatementExpression
PostIncrementExpression ::= PostIncrementExpression
PostDecrementExpression ::= PostDecrementExpression
MethodInvocation ::= MethodInvocation
ClassInstanceCreationExpression ::= ClassInstanceCreationExpression
SwitchBlock ::= SwitchBlock
SwitchBlockStatementGroups ::= SwitchBlockStatementGroups
SwitchBlockStatementGroup ::= SwitchBlockStatementGroup
SwitchLabels ::= SwitchLabels
SwitchLabel ::= SwitchLabel
ConstantExpression ::= ConstantExpression
StatementExpressionList ::= StatementExpressionList
Catches ::= Catches
Finally ::= Finally
CatchClause ::= CatchClause
PrimaryNoNewArray ::= PrimaryNoNewArray
FieldAccess ::= FieldAccess
ArrayAccess ::= ArrayAccess
ArgumentList ::= ArgumentList
DimExprs ::= DimExprs
Dims ::= Dims
DimExpr ::= DimExpr
PostfixExpression ::= PostfixExpression
UnaryExpression ::= UnaryExpression
UnaryExpressionNotPlusMinus ::= UnaryExpressionNotPlusMinus
MultiplicativeExpression ::= MultiplicativeExpression
AdditiveExpression ::= AdditiveExpression
ShiftExpression ::= ShiftExpression
RelationalExpression ::= RelationalExpression
EqualityExpression ::= EqualityExpression
AndExpression ::= AndExpression
ExclusiveOrExpression ::= ExclusiveOrExpression
InclusiveOrExpression ::= InclusiveOrExpression
ConditionalAndExpression ::= ConditionalAndExpression
ConditionalOrExpression ::= ConditionalOrExpression
AssignmentExpression ::= AssignmentExpression
LeftHandSide ::= LeftHandSide
AssignmentOperator ::= AssignmentOperator
CompilationUnit ::= 
NumericType ::= 
IntegralType ::= 
FloatingPointType ::= 
ArrayType ::= 
TypeArgumentsopt ::= 
TypeBoundopt ::= 
TypeBound ::= 
AdditionalBoundListopt ::= 
Wildcard ::= 
WildcardBoundsOpt ::= 
WildcardBounds ::= 
PackageDeclarationopt ::= 
ImportDeclarationsopt ::= 
TypeDeclarationsopt ::= 
PackageDeclaration ::= 
Annotationsopt ::= 
SingleTypeImportDeclaration ::= 
TypeImportOnDemandDeclaration ::= 
SingleStaticImportDeclaration ::= 
StaticImportOnDemandDeclaration ::= 
ClassDeclaration ::= 
InterfaceDeclaration ::= 
NormalClassDeclaration ::= 
ClassModifiersopt ::= 
TypeParametersopt ::= 
Superopt ::= 
Interfacesopt ::= 
TypeParameters ::= 
Super ::= 
Interfaces ::= 
ClassBodyDeclarationsopt ::= 
ClassMemberDeclaration ::= 
InstanceInitializer ::= 
StaticInitializer ::= 
ConstructorDeclaration ::= 
FieldDeclaration ::= 
MethodDeclaration ::= 
FieldModifiersopt ::= 
MethodModifiersopt ::= 
Throwsopt ::= 
FormalParameterListopt ::= 
FormalParameterList ::= 
VariableModifiersopt ::= 
...opt ::= 
Throws ::= 
ConstructorModifiersopt ::= 
ExplicitConstructorInvocationopt ::= 
BlockStatementsopt ::= 
ExplicitConstructorInvocation ::= 
ArgumentListopt ::= 
EnumConstantsopt ::= 
,opt ::= 
EnumBodyDeclarationsopt ::= 
Argumentsopt ::= 
ClassBodyopt ::= 
Arguments ::= 
EnumBodyDeclarations ::= 
NormalInterfaceDeclaration ::= 
InterfaceModifiersopt ::= 
ExtendsInterfacesopt ::= 
InterfaceMemberDeclarationsopt ::= 
ConstantDeclaration ::= 
AbstractMethodDeclaration ::= 
ConstantModifiersopt ::= 
AbstractMethodModifiersopt ::= 
AnnotationTypeElementDeclarationsopt ::= 
DefaultValueopt ::= 
DefaultValue ::= 
NormalAnnotation ::= 
MarkerAnnotation ::= 
SingleElementAnnotation ::= 
ElementValuePairsopt ::= 
ElementValueArrayInitializer ::= 
ElementValuesopt ::= 
VariableInitializersopt ::= 
LocalVariableDeclarationStatement ::= 
LabeledStatement ::= 
IfThenStatement ::= 
IfThenElseStatement ::= 
WhileStatement ::= 
ForStatement ::= 
EmptyStatement ::= 
ExpressionStatement ::= 
AssertStatement ::= 
SwitchStatement ::= 
DoStatement ::= 
BreakStatement ::= 
ContinueStatement ::= 
ReturnStatement ::= 
SynchronizedStatement ::= 
ThrowStatement ::= 
TryStatement ::= 
LabeledStatementNoShortIf ::= 
IfThenElseStatementNoShortIf ::= 
WhileStatementNoShortIf ::= 
ForStatementNoShortIf ::= 
Assignment ::= 
PreIncrementExpression ::= 
PreDecrementExpression ::= 
SwitchBlockStatementGroupsopt ::= 
SwitchLabelsopt ::= 
BasicForStatement ::= 
EnhancedForStatement ::= 
ForInitopt ::= 
Expressionopt ::= 
ForUpdateopt ::= 
ForInit ::= 
ForUpdate ::= 
identifieropt ::= 
Catchesopt ::= 
ArrayCreationExpression ::= 
Literal ::= 
BooleanLiteral ::= 
Dimsopt ::= 
CastExpression ::= 

 IBM LALR Parser Generator              1.00 (Feb 16 2007)


Scopes:

MethodInvocation ::= ClassName DOT super DOT TypeArgumentsopt identifier 
                     LPAREN ArgumentListopt  .RPAREN 
ClassInstanceCreationExpression ::= name DOT new TypeArgumentsopt identifier 
                                    TypeArgumentsopt LPAREN ArgumentListopt  .
                                    RPAREN ClassBodyopt 
ClassInstanceCreationExpression ::= Primary DOT new TypeArgumentsopt 
                                    identifier TypeArgumentsopt LPAREN 
                                    ArgumentListopt  .RPAREN ClassBodyopt 
ForStatementNoShortIf ::= for LPAREN ForInitopt SEMICOLON Expressionopt 
                          SEMICOLON ForUpdateopt  .RPAREN StatementNoShortIf 
BasicForStatement ::= for LPAREN ForInitopt SEMICOLON Expressionopt 
                      SEMICOLON ForUpdateopt  .RPAREN Statement 
MethodInvocation ::= TypeName DOT TypeArguments identifier LPAREN 
                     ArgumentListopt  .RPAREN 
MethodInvocation ::= super DOT TypeArgumentsopt identifier LPAREN 
                     ArgumentListopt  .RPAREN 
MethodInvocation ::= Primary DOT TypeArgumentsopt identifier LPAREN 
                     ArgumentListopt  .RPAREN 
AnnotationTypeElementDeclaration ::= AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN 
                                     DefaultValueopt  .SEMICOLON 
ClassInstanceCreationExpression ::= new TypeArgumentsopt 
                                    ClassOrInterfaceType TypeArgumentsopt 
                                    LPAREN ArgumentListopt  .RPAREN 
                                    ClassBodyopt 
ExplicitConstructorInvocation ::= Primary DOT TypeArgumentsopt super LPAREN 
                                  ArgumentListopt  .RPAREN SEMICOLON 
AbstractMethodDeclaration ::= AbstractMethodModifiersopt TypeParametersopt 
                              ResultType MethodDeclarator Throwsopt  .SEMICOLON 
EnhancedForStatement ::= for LPAREN FormalParameter COLON Expression  .RPAREN 
                         Statement 
DoStatement ::= do Statement while LPAREN Expression  .RPAREN SEMICOLON 
IfThenElseStatementNoShortIf ::= if LPAREN Expression RPAREN 
                                 StatementNoShortIf  .else StatementNoShortIf 
IfThenElseStatement ::= if LPAREN Expression RPAREN StatementNoShortIf  .else 
                        Statement 
ForStatementNoShortIf ::= for LPAREN ForInitopt SEMICOLON Expressionopt  .
                          SEMICOLON ForUpdateopt RPAREN StatementNoShortIf 
BasicForStatement ::= for LPAREN ForInitopt SEMICOLON Expressionopt  .SEMICOLON 
                      ForUpdateopt RPAREN Statement 
AssertStatement ::= assert Expression COLON Expression  .SEMICOLON 
SingleElementAnnotation ::= AT TypeName LPAREN ElementValue  .RPAREN 
NormalAnnotation ::= AT TypeName LPAREN ElementValuePairsopt  .RPAREN 
EnumBody ::= LBRACE EnumConstantsopt ,opt EnumBodyDeclarationsopt  .RBRACE 
ConstructorDeclarator ::= TypeParametersopt SimpleTypeName LPAREN 
                          FormalParameterListopt  .RPAREN 
ExplicitConstructorInvocation ::= TypeArgumentsopt super LPAREN 
                                  ArgumentListopt  .RPAREN SEMICOLON 
ExplicitConstructorInvocation ::= TypeArgumentsopt this LPAREN 
                                  ArgumentListopt  .RPAREN SEMICOLON 
ArrayAccess ::= PrimaryNoNewArray LBRACKET Expression  .RBRACKET 
ArrayAccess ::= ExpressionName LBRACKET Expression  .RBRACKET 
MethodInvocation ::= MethodName LPAREN ArgumentListopt  .RPAREN 
TryStatement ::= try Block Catchesopt  .Finally 
SwitchBlock ::= LBRACE SwitchBlockStatementGroupsopt SwitchLabelsopt  .RBRACE 
ArrayInitializer ::= LBRACE VariableInitializersopt ,opt  .RBRACE 
ElementValueArrayInitializer ::= LBRACE ElementValuesopt ,opt  .RBRACE 
ConstructorBody ::= LBRACE ExplicitConstructorInvocationopt 
                    BlockStatementsopt  .RBRACE 
ConstructorDeclaration ::= ConstructorModifiersopt ConstructorDeclarator 
                           Throwsopt  .ConstructorBody 
MethodDeclarator ::= identifier LPAREN FormalParameterListopt  .RPAREN 
FieldDeclaration ::= FieldModifiersopt Type VariableDeclarators  .SEMICOLON 
ConditionalExpression ::= ConditionalOrExpression QUESTION Expression  .COLON 
                          ConditionalExpression 
CatchClause ::= catch LPAREN FormalParameter  .RPAREN Block 
SynchronizedStatement ::= synchronized LPAREN Expression  .RPAREN Block 
WhileStatementNoShortIf ::= while LPAREN Expression  .RPAREN StatementNoShortIf 
WhileStatement ::= while LPAREN Expression  .RPAREN Statement 
SwitchStatement ::= switch LPAREN Expression  .RPAREN SwitchBlock 
IfThenStatement ::= if LPAREN Expression  .RPAREN Statement 
EnhancedForStatement ::= for LPAREN FormalParameter  .COLON Expression RPAREN 
                         Statement 
IfThenElseStatementNoShortIf ::= if LPAREN Expression  .RPAREN 
                                 StatementNoShortIf else StatementNoShortIf 
IfThenElseStatement ::= if LPAREN Expression  .RPAREN StatementNoShortIf else 
                        Statement 
ForStatementNoShortIf ::= for LPAREN ForInitopt  .SEMICOLON Expressionopt 
                          SEMICOLON ForUpdateopt RPAREN StatementNoShortIf 
BasicForStatement ::= for LPAREN ForInitopt  .SEMICOLON Expressionopt SEMICOLON 
                      ForUpdateopt RPAREN Statement 
DimExpr ::= LBRACKET Expression  .RBRACKET 
PrimaryNoNewArray ::= LPAREN Expression  .RPAREN 
TryStatement ::= try Block  .Catches 
ThrowStatement ::= throw Expression  .SEMICOLON 
ReturnStatement ::= return Expressionopt  .SEMICOLON 
SwitchLabel ::= case EnumConstant  .COLON 
SwitchLabel ::= case ConstantExpression  .COLON 
AssertStatement ::= assert Expression  .SEMICOLON 
Block ::= LBRACE BlockStatementsopt  .RBRACE 
AnnotationTypeBody ::= LBRACE AnnotationTypeElementDeclarationsopt  .RBRACE 
InterfaceBody ::= LBRACE InterfaceMemberDeclarationsopt  .RBRACE 
Arguments ::= LPAREN ArgumentListopt  .RPAREN 
ClassBody ::= LBRACE ClassBodyDeclarationsopt  .RBRACE 
TypeArguments ::= LESS ActualTypeArgumentList  .GREATER 
AssertStatement ::= assert Expression  .COLON Expression SEMICOLON 
MethodHeader ::= MethodModifiersopt TypeParametersopt  .ResultType 
                 MethodDeclarator Throwsopt 
AbstractMethodDeclaration ::= AbstractMethodModifiersopt TypeParametersopt  .
                              ResultType MethodDeclarator Throwsopt SEMICOLON 
DoStatement ::= do Statement  .while LPAREN Expression RPAREN SEMICOLON 
SwitchBlockStatementGroup ::= SwitchLabels  .BlockStatements 
ExpressionStatement ::= StatementExpression  .SEMICOLON 
LocalVariableDeclarationStatement ::= LocalVariableDeclaration  .SEMICOLON 
MethodDeclaration ::= MethodHeader  .MethodBody 
Assignment ::= LeftHandSide  .AssignmentOperator AssignmentExpression 
LocalVariableDeclaration ::= VariableModifiersopt  .Type VariableDeclarators 
ConstantDeclaration ::= ConstantModifiersopt  .Type VariableDeclarators 
FormalParameter ::= VariableModifiersopt  .Type VariableDeclaratorId 
FormalParameterList ::= FormalParameters  .COMMA LastFormalParameter 
EnumConstant ::= Annotationsopt  .identifier Argumentsopt ClassBodyopt 
ConstructorDeclaration ::= ConstructorModifiersopt  .ConstructorDeclarator 
                           Throwsopt ConstructorBody 
LastFormalParameter ::= VariableModifiersopt  .Type ...opt VariableDeclaratorId 
FieldDeclaration ::= FieldModifiersopt  .Type VariableDeclarators SEMICOLON 
AnnotationTypeDeclaration ::= InterfaceModifiersopt  .AT interface identifier 
                              AnnotationTypeBody 
EnumDeclaration ::= ClassModifiersopt  .enum identifier Interfacesopt EnumBody 
NormalInterfaceDeclaration ::= InterfaceModifiersopt  .interface identifier 
                               TypeParametersopt ExtendsInterfacesopt 
                               InterfaceBody 
AnnotationTypeElementDeclaration ::= AbstractMethodModifiersopt  .Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
NormalClassDeclaration ::= ClassModifiersopt  .class identifier 
                           TypeParametersopt Superopt Interfacesopt ClassBody 
ExplicitConstructorInvocation ::= Primary  .DOT TypeArgumentsopt super LPAREN 
                                  ArgumentListopt RPAREN SEMICOLON 

 IBM LALR Parser Generator              1.00 (Feb 16 2007)


---------------------------------- CONFLICTS ----------------------------------



STATE 1 ------------------------------------------------------------------------
( )

'$accept' ::= .CompilationUnit 

CompilationUnit ::= .PackageDeclarationopt ImportDeclarationsopt 
                    TypeDeclarationsopt 
PackageDeclaration ::= .Annotationsopt package PackageName SEMICOLON 
Annotations ::= .Annotation 
Annotations ::= .Annotations Annotation 
Annotation ::= .NormalAnnotation 
Annotation ::= .MarkerAnnotation 
Annotation ::= .SingleElementAnnotation 
NormalAnnotation ::= .AT TypeName LPAREN ElementValuePairsopt RPAREN 
MarkerAnnotation ::= .AT TypeName 
SingleElementAnnotation ::= .AT TypeName LPAREN ElementValue RPAREN 
Annotationsopt ::= . (521)
Annotationsopt ::= .Annotations 
PackageDeclarationopt ::= . (527)
PackageDeclarationopt ::= .PackageDeclaration 

*** Shift/reduce conflict on "AT" with rule 527

CompilationUnit ::= .PackageDeclarationopt ImportDeclarationsopt 
                    TypeDeclarationsopt 
PackageDeclarationopt ::= . (527)




STATE 7 ------------------------------------------------------------------------
( 3 )

CompilationUnit ::= PackageDeclarationopt ImportDeclarationsopt  .
                    TypeDeclarationsopt 

TypeDeclarations ::= .TypeDeclaration 
TypeDeclarations ::= .TypeDeclarations TypeDeclaration 
TypeDeclaration ::= .ClassDeclaration 
TypeDeclaration ::= .InterfaceDeclaration 
TypeDeclaration ::= .SEMICOLON 
TypeDeclaration ::= .ERROR_TOKEN 
ClassDeclaration ::= .NormalClassDeclaration 
ClassDeclaration ::= .EnumDeclaration 
NormalClassDeclaration ::= .ClassModifiersopt class identifier 
                           TypeParametersopt Superopt Interfacesopt ClassBody 
ClassModifiers ::= .ClassModifier 
ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifier ::= .Annotation 
ClassModifier ::= .public 
ClassModifier ::= .protected 
ClassModifier ::= .private 
ClassModifier ::= .abstract 
ClassModifier ::= .static 
ClassModifier ::= .final 
ClassModifier ::= .strictfp 
EnumDeclaration ::= .ClassModifiersopt enum identifier Interfacesopt EnumBody 
InterfaceDeclaration ::= .NormalInterfaceDeclaration 
InterfaceDeclaration ::= .AnnotationTypeDeclaration 
NormalInterfaceDeclaration ::= .InterfaceModifiersopt interface identifier 
                               TypeParametersopt ExtendsInterfacesopt 
                               InterfaceBody 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifier ::= .Annotation 
InterfaceModifier ::= .public 
InterfaceModifier ::= .protected 
InterfaceModifier ::= .private 
InterfaceModifier ::= .abstract 
InterfaceModifier ::= .static 
InterfaceModifier ::= .strictfp 
AnnotationTypeDeclaration ::= .InterfaceModifiersopt AT interface identifier 
                              AnnotationTypeBody 
Annotation ::= .NormalAnnotation 
Annotation ::= .MarkerAnnotation 
Annotation ::= .SingleElementAnnotation 
NormalAnnotation ::= .AT TypeName LPAREN ElementValuePairsopt RPAREN 
MarkerAnnotation ::= .AT TypeName 
SingleElementAnnotation ::= .AT TypeName LPAREN ElementValue RPAREN 
InterfaceModifiersopt ::= . (481)
InterfaceModifiersopt ::= .InterfaceModifiers 
ClassModifiersopt ::= . (519)
ClassModifiersopt ::= .ClassModifiers 
TypeDeclarationsopt ::= . (523)
TypeDeclarationsopt ::= .TypeDeclarations 

*** Shift/reduce conflict on "AT" with rule 481

AnnotationTypeDeclaration ::= .InterfaceModifiersopt AT interface identifier 
                              AnnotationTypeBody 
InterfaceModifiersopt ::= . (481)




STATE 12 -----------------------------------------------------------------------
( 7 23 183 227 228 254 259 276 297 )

InterfaceModifiers ::= InterfaceModifiers  .InterfaceModifier 
InterfaceModifiersopt ::= InterfaceModifiers . (482)

InterfaceModifier ::= .Annotation 
InterfaceModifier ::= .public 
InterfaceModifier ::= .protected 
InterfaceModifier ::= .private 
InterfaceModifier ::= .abstract 
InterfaceModifier ::= .static 
InterfaceModifier ::= .strictfp 
Annotation ::= .NormalAnnotation 
Annotation ::= .MarkerAnnotation 
Annotation ::= .SingleElementAnnotation 
NormalAnnotation ::= .AT TypeName LPAREN ElementValuePairsopt RPAREN 
MarkerAnnotation ::= .AT TypeName 
SingleElementAnnotation ::= .AT TypeName LPAREN ElementValue RPAREN 

*** Shift/reduce conflict on "AT" with rule 482

AnnotationTypeDeclaration ::= .InterfaceModifiersopt AT interface identifier 
                              AnnotationTypeBody 
InterfaceModifiersopt ::= InterfaceModifiers . (482)




STATE 14 -----------------------------------------------------------------------
( 7 23 183 227 228 254 )

ClassModifier ::= strictfp . (79)
InterfaceModifier ::= strictfp . (187)

*** Reduce/reduce conflict on "strictfp" between rule 79 and 187

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= strictfp . (79)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= strictfp . (187)

*** Reduce/reduce conflict on "static" between rule 79 and 187

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= strictfp . (79)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= strictfp . (187)

*** Reduce/reduce conflict on "public" between rule 79 and 187

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= strictfp . (79)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= strictfp . (187)

*** Reduce/reduce conflict on "protected" between rule 79 and 187

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= strictfp . (79)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= strictfp . (187)

*** Reduce/reduce conflict on "private" between rule 79 and 187

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= strictfp . (79)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= strictfp . (187)

*** Reduce/reduce conflict on "abstract" between rule 79 and 187

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= strictfp . (79)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= strictfp . (187)

*** Reduce/reduce conflict on "AT" between rule 79 and 187

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= strictfp . (79)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= strictfp . (187)




STATE 15 -----------------------------------------------------------------------
( 7 23 )

ClassModifier ::= static . (77)
InterfaceModifier ::= static . (186)

*** Reduce/reduce conflict on "strictfp" between rule 77 and 186

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= static . (186)

*** Reduce/reduce conflict on "static" between rule 77 and 186

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= static . (186)

*** Reduce/reduce conflict on "public" between rule 77 and 186

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= static . (186)

*** Reduce/reduce conflict on "protected" between rule 77 and 186

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= static . (186)

*** Reduce/reduce conflict on "private" between rule 77 and 186

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= static . (186)

*** Reduce/reduce conflict on "abstract" between rule 77 and 186

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= static . (186)

*** Reduce/reduce conflict on "AT" between rule 77 and 186

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= static . (186)




STATE 16 -----------------------------------------------------------------------
( 7 23 )

ClassModifier ::= abstract . (76)
InterfaceModifier ::= abstract . (185)

*** Reduce/reduce conflict on "strictfp" between rule 76 and 185

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= abstract . (76)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= abstract . (185)

*** Reduce/reduce conflict on "static" between rule 76 and 185

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= abstract . (76)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= abstract . (185)

*** Reduce/reduce conflict on "public" between rule 76 and 185

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= abstract . (76)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= abstract . (185)

*** Reduce/reduce conflict on "protected" between rule 76 and 185

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= abstract . (76)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= abstract . (185)

*** Reduce/reduce conflict on "private" between rule 76 and 185

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= abstract . (76)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= abstract . (185)

*** Reduce/reduce conflict on "abstract" between rule 76 and 185

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= abstract . (76)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= abstract . (185)

*** Reduce/reduce conflict on "AT" between rule 76 and 185

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= abstract . (76)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= abstract . (185)




STATE 17 -----------------------------------------------------------------------
( 7 23 183 227 228 254 )

ClassModifier ::= private . (75)
InterfaceModifier ::= private . (184)

*** Reduce/reduce conflict on "strictfp" between rule 75 and 184

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= private . (75)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= private . (184)

*** Reduce/reduce conflict on "static" between rule 75 and 184

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= private . (75)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= private . (184)

*** Reduce/reduce conflict on "public" between rule 75 and 184

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= private . (75)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= private . (184)

*** Reduce/reduce conflict on "protected" between rule 75 and 184

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= private . (75)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= private . (184)

*** Reduce/reduce conflict on "private" between rule 75 and 184

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= private . (75)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= private . (184)

*** Reduce/reduce conflict on "abstract" between rule 75 and 184

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= private . (75)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= private . (184)

*** Reduce/reduce conflict on "AT" between rule 75 and 184

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= private . (75)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= private . (184)




STATE 18 -----------------------------------------------------------------------
( 7 23 183 227 228 254 )

ClassModifier ::= protected . (74)
InterfaceModifier ::= protected . (183)

*** Reduce/reduce conflict on "strictfp" between rule 74 and 183

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= protected . (74)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= protected . (183)

*** Reduce/reduce conflict on "static" between rule 74 and 183

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= protected . (74)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= protected . (183)

*** Reduce/reduce conflict on "public" between rule 74 and 183

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= protected . (74)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= protected . (183)

*** Reduce/reduce conflict on "protected" between rule 74 and 183

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= protected . (74)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= protected . (183)

*** Reduce/reduce conflict on "private" between rule 74 and 183

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= protected . (74)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= protected . (183)

*** Reduce/reduce conflict on "abstract" between rule 74 and 183

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= protected . (74)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= protected . (183)

*** Reduce/reduce conflict on "AT" between rule 74 and 183

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= protected . (74)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= protected . (183)




STATE 19 -----------------------------------------------------------------------
( 7 23 )

ClassModifier ::= public . (73)
InterfaceModifier ::= public . (182)

*** Reduce/reduce conflict on "strictfp" between rule 73 and 182

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= public . (182)

*** Reduce/reduce conflict on "static" between rule 73 and 182

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= public . (182)

*** Reduce/reduce conflict on "public" between rule 73 and 182

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= public . (182)

*** Reduce/reduce conflict on "protected" between rule 73 and 182

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= public . (182)

*** Reduce/reduce conflict on "private" between rule 73 and 182

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= public . (182)

*** Reduce/reduce conflict on "abstract" between rule 73 and 182

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= public . (182)

*** Reduce/reduce conflict on "AT" between rule 73 and 182

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= public . (182)




STATE 20 -----------------------------------------------------------------------
( 7 23 )

ClassModifier ::= Annotation . (72)
InterfaceModifier ::= Annotation . (181)

*** Reduce/reduce conflict on "strictfp" between rule 72 and 181

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= Annotation . (181)

*** Reduce/reduce conflict on "static" between rule 72 and 181

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= Annotation . (181)

*** Reduce/reduce conflict on "public" between rule 72 and 181

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= Annotation . (181)

*** Reduce/reduce conflict on "protected" between rule 72 and 181

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= Annotation . (181)

*** Reduce/reduce conflict on "private" between rule 72 and 181

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= Annotation . (181)

*** Reduce/reduce conflict on "abstract" between rule 72 and 181

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= Annotation . (181)

*** Reduce/reduce conflict on "AT" between rule 72 and 181

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= Annotation . (181)




STATE 23 -----------------------------------------------------------------------
( 7 )

TypeDeclarations ::= TypeDeclarations  .TypeDeclaration 
TypeDeclarationsopt ::= TypeDeclarations . (524)

TypeDeclaration ::= .ClassDeclaration 
TypeDeclaration ::= .InterfaceDeclaration 
TypeDeclaration ::= .SEMICOLON 
TypeDeclaration ::= .ERROR_TOKEN 
ClassDeclaration ::= .NormalClassDeclaration 
ClassDeclaration ::= .EnumDeclaration 
NormalClassDeclaration ::= .ClassModifiersopt class identifier 
                           TypeParametersopt Superopt Interfacesopt ClassBody 
ClassModifiers ::= .ClassModifier 
ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifier ::= .Annotation 
ClassModifier ::= .public 
ClassModifier ::= .protected 
ClassModifier ::= .private 
ClassModifier ::= .abstract 
ClassModifier ::= .static 
ClassModifier ::= .final 
ClassModifier ::= .strictfp 
EnumDeclaration ::= .ClassModifiersopt enum identifier Interfacesopt EnumBody 
InterfaceDeclaration ::= .NormalInterfaceDeclaration 
InterfaceDeclaration ::= .AnnotationTypeDeclaration 
NormalInterfaceDeclaration ::= .InterfaceModifiersopt interface identifier 
                               TypeParametersopt ExtendsInterfacesopt 
                               InterfaceBody 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifier ::= .Annotation 
InterfaceModifier ::= .public 
InterfaceModifier ::= .protected 
InterfaceModifier ::= .private 
InterfaceModifier ::= .abstract 
InterfaceModifier ::= .static 
InterfaceModifier ::= .strictfp 
AnnotationTypeDeclaration ::= .InterfaceModifiersopt AT interface identifier 
                              AnnotationTypeBody 
Annotation ::= .NormalAnnotation 
Annotation ::= .MarkerAnnotation 
Annotation ::= .SingleElementAnnotation 
NormalAnnotation ::= .AT TypeName LPAREN ElementValuePairsopt RPAREN 
MarkerAnnotation ::= .AT TypeName 
SingleElementAnnotation ::= .AT TypeName LPAREN ElementValue RPAREN 
InterfaceModifiersopt ::= . (481)
InterfaceModifiersopt ::= .InterfaceModifiers 
ClassModifiersopt ::= . (519)
ClassModifiersopt ::= .ClassModifiers 

*** Shift/reduce conflict on "AT" with rule 481

AnnotationTypeDeclaration ::= .InterfaceModifiersopt AT interface identifier 
                              AnnotationTypeBody 
InterfaceModifiersopt ::= . (481)




STATE 27 -----------------------------------------------------------------------
( 8 )

TypeName ::= identifier . (21)
PackageOrTypeName ::= identifier . (45)

*** Reduce/reduce conflict on "DOT" between rule 21 and 45

TypeName ::= .TypeName DOT identifier 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
PackageOrTypeName ::= .PackageOrTypeName DOT identifier 
PackageOrTypeName ::= identifier . (45)




STATE 54 -----------------------------------------------------------------------
( 29 42 43 44 58 59 60 62 63 80 86 88 101 109 110 111 113 114 115 116 117 119 
  120 121 122 123 124 125 126 127 137 155 160 164 166 174 194 205 208 210 213 
  238 240 242 247 267 278 282 298 299 300 305 314 316 319 321 327 339 354 359 
  361 362 363 364 371 375 384 396 405 408 409 410 411 412 436 437 443 444 446 
  447 448 449 450 451 452 462 468 471 472 473 474 479 480 482 )

ClassType ::= TypeName  .TypeArgumentsopt 
TypeName ::= TypeName  .DOT identifier 
ClassName ::= TypeName . (23)
MethodInvocation ::= TypeName  .DOT TypeArguments identifier LPAREN 
                     ArgumentListopt RPAREN 

TypeArguments ::= .LESS ActualTypeArgumentList GREATER 
TypeArgumentsopt ::= . (535)
TypeArgumentsopt ::= .TypeArguments 

*** Shift/reduce conflict on "DOT" with rule 535

PrimaryNoNewArray ::= .Type DOT class 
Type ::= .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= TypeName  .TypeArgumentsopt 
TypeArgumentsopt ::= . (535)

*** Shift/reduce conflict on "DOT" with rule 23

PrimaryNoNewArray ::= .ClassName DOT this 
ClassName ::= TypeName . (23)




STATE 55 -----------------------------------------------------------------------
( 29 )

TypeName ::= identifier . (21)
TypeVariable ::= identifier . (24)
ExpressionName ::= identifier . (41)
MethodName ::= identifier . (43)
AmbiguousName ::= identifier . (47)
SimpleName ::= identifier . (233)

*** Reduce/reduce conflict on "LESS" between rule 21 and 41

ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
RelationalExpression ::= .RelationalExpression LESS ShiftExpression 
RelationalExpression ::= .ShiftExpression 
ShiftExpression ::= .AdditiveExpression 
AdditiveExpression ::= .MultiplicativeExpression 
MultiplicativeExpression ::= .UnaryExpression 
UnaryExpression ::= .UnaryExpressionNotPlusMinus 
UnaryExpressionNotPlusMinus ::= .PostfixExpression 
PostfixExpression ::= .ExpressionName 
ExpressionName ::= identifier . (41)

*** Reduce/reduce conflict on "LBRACKET" between rule 21 and 41

ArrayType ::= .Type LBRACKET RBRACKET 
Type ::= .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
ArrayAccess ::= .ExpressionName LBRACKET Expression RBRACKET 
ExpressionName ::= identifier . (41)

*** Reduce/reduce conflict on "LBRACKET" between rule 21 and 24

ArrayType ::= .Type LBRACKET RBRACKET 
Type ::= .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
ArrayType ::= .Type LBRACKET RBRACKET 
Type ::= .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "DOT" between rule 21 and 47

PrimaryNoNewArray ::= .Type DOT class 
Type ::= .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
ExpressionName ::= .AmbiguousName DOT identifier 
AmbiguousName ::= identifier . (47)

*** Reduce/reduce conflict on "DOT" between rule 21 and 24

PrimaryNoNewArray ::= .Type DOT class 
Type ::= .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
PrimaryNoNewArray ::= .Type DOT class 
Type ::= .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)




STATE 56 -----------------------------------------------------------------------
( 29 42 43 44 58 59 60 62 63 80 86 88 101 109 110 111 113 114 115 116 117 119 
  120 121 122 123 124 125 126 127 137 155 160 164 166 174 194 205 208 210 213 
  238 240 242 247 267 278 282 298 299 300 305 314 316 319 321 327 339 354 359 
  361 362 363 364 371 375 384 396 405 408 409 410 411 412 436 437 443 444 446 
  447 448 449 450 451 452 462 468 471 472 473 474 479 480 482 )

ClassInstanceCreationExpression ::= new  .TypeArgumentsopt ClassOrInterfaceType 
                                    TypeArgumentsopt LPAREN ArgumentListopt 
                                    RPAREN ClassBodyopt 
ArrayCreationExpression ::= new  .PrimitiveType DimExprs Dimsopt 
ArrayCreationExpression ::= new  .ClassOrInterfaceType DimExprs Dimsopt 
ArrayCreationExpression ::= new  .PrimitiveType Dims ArrayInitializer 
ArrayCreationExpression ::= new  .ClassOrInterfaceType Dims ArrayInitializer 

identifier ::= .IDENTIFIER 
PrimitiveType ::= .NumericType 
PrimitiveType ::= .boolean 
NumericType ::= .IntegralType 
NumericType ::= .FloatingPointType 
IntegralType ::= .byte 
IntegralType ::= .short 
IntegralType ::= .int 
IntegralType ::= .long 
IntegralType ::= .char 
FloatingPointType ::= .float 
FloatingPointType ::= .double 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= .identifier 
TypeName ::= .TypeName DOT identifier 
TypeArguments ::= .LESS ActualTypeArgumentList GREATER 
TypeArgumentsopt ::= . (535)
TypeArgumentsopt ::= .TypeArguments 

*** Shift/reduce conflict on "IDENTIFIER" with rule 535

ClassInstanceCreationExpression ::= new  .TypeArgumentsopt ClassOrInterfaceType 
                                    TypeArgumentsopt LPAREN ArgumentListopt 
                                    RPAREN ClassBodyopt 
TypeArgumentsopt ::= . (535)




STATE 65 -----------------------------------------------------------------------
( 29 42 58 80 86 88 101 116 117 122 123 124 125 126 127 137 155 164 194 205 
  213 238 240 242 247 267 278 298 299 300 305 314 316 321 327 354 359 362 363 
  371 384 405 410 411 436 437 443 448 449 468 471 )

ShiftExpression ::= ShiftExpression  .LEFT_SHIFT AdditiveExpression 
ShiftExpression ::= ShiftExpression  .GREATER GREATER AdditiveExpression 
ShiftExpression ::= ShiftExpression  .GREATER GREATER GREATER 
                    AdditiveExpression 
RelationalExpression ::= ShiftExpression . (404)

*** Shift/reduce conflict on "GREATER" with rule 404

RelationalExpression ::= .RelationalExpression GREATER ShiftExpression 
RelationalExpression ::= ShiftExpression . (404)




STATE 68 -----------------------------------------------------------------------
( 29 42 58 80 86 88 101 122 123 124 125 126 127 137 155 164 194 205 213 238 
  240 242 247 267 278 298 299 300 305 314 316 321 327 354 359 362 363 371 384 
  405 410 411 436 437 443 448 449 468 471 )

RelationalExpression ::= RelationalExpression  .LESS ShiftExpression 
RelationalExpression ::= RelationalExpression  .GREATER ShiftExpression 
RelationalExpression ::= RelationalExpression  .LESS_EQUAL ShiftExpression 
RelationalExpression ::= RelationalExpression  .GREATER EQUAL ShiftExpression 
RelationalExpression ::= RelationalExpression  .instanceof ReferenceType 
EqualityExpression ::= RelationalExpression . (410)

*** Shift/reduce conflict on "LESS" with rule 410

InterfaceMemberDeclarations ::= .InterfaceMemberDeclarations 
                                InterfaceMemberDeclaration 
InterfaceMemberDeclarations ::= .InterfaceMemberDeclaration 
InterfaceMemberDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= RelationalExpression . (410)




STATE 83 -----------------------------------------------------------------------
( 42 43 44 58 59 60 62 63 80 86 88 101 109 110 111 113 114 115 116 117 119 120 
  121 122 123 124 125 126 127 137 155 160 164 166 174 194 205 208 210 213 238 
  240 242 247 267 278 298 299 300 305 314 316 321 327 354 359 362 363 364 371 
  375 384 405 410 411 412 436 437 447 448 449 452 468 471 479 )

TypeName ::= identifier . (21)
TypeVariable ::= identifier . (24)
ExpressionName ::= identifier . (41)
MethodName ::= identifier . (43)
AmbiguousName ::= identifier . (47)

*** Reduce/reduce conflict on "LESS" between rule 21 and 41

ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
RelationalExpression ::= .RelationalExpression LESS ShiftExpression 
RelationalExpression ::= .ShiftExpression 
ShiftExpression ::= .AdditiveExpression 
AdditiveExpression ::= .MultiplicativeExpression 
MultiplicativeExpression ::= .UnaryExpression 
UnaryExpression ::= .UnaryExpressionNotPlusMinus 
UnaryExpressionNotPlusMinus ::= .PostfixExpression 
PostfixExpression ::= .ExpressionName 
ExpressionName ::= identifier . (41)

*** Reduce/reduce conflict on "LBRACKET" between rule 21 and 41

ArrayType ::= .Type LBRACKET RBRACKET 
Type ::= .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
ArrayAccess ::= .ExpressionName LBRACKET Expression RBRACKET 
ExpressionName ::= identifier . (41)

*** Reduce/reduce conflict on "LBRACKET" between rule 21 and 24

ArrayType ::= .Type LBRACKET RBRACKET 
Type ::= .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
ArrayType ::= .Type LBRACKET RBRACKET 
Type ::= .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "RPAREN" between rule 21 and 41

CastExpression ::= LPAREN  .ReferenceType RPAREN UnaryExpressionNotPlusMinus 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
SingleElementAnnotation ::= AT TypeName LPAREN  .ElementValue RPAREN 
ElementValue ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= .InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= .ShiftExpression 
ShiftExpression ::= .AdditiveExpression 
AdditiveExpression ::= .MultiplicativeExpression 
MultiplicativeExpression ::= .UnaryExpression 
UnaryExpression ::= MINUS  .UnaryExpression 
UnaryExpression ::= .UnaryExpressionNotPlusMinus 
UnaryExpressionNotPlusMinus ::= .PostfixExpression 
PostfixExpression ::= .ExpressionName 
ExpressionName ::= identifier . (41)

*** Reduce/reduce conflict on "RPAREN" between rule 21 and 24

CastExpression ::= LPAREN  .ReferenceType RPAREN UnaryExpressionNotPlusMinus 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
CastExpression ::= LPAREN  .ReferenceType RPAREN UnaryExpressionNotPlusMinus 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "DOT" between rule 21 and 47

PrimaryNoNewArray ::= .Type DOT class 
Type ::= .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
ExpressionName ::= .AmbiguousName DOT identifier 
AmbiguousName ::= identifier . (47)

*** Reduce/reduce conflict on "DOT" between rule 21 and 24

PrimaryNoNewArray ::= .Type DOT class 
Type ::= .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
PrimaryNoNewArray ::= .Type DOT class 
Type ::= .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)




STATE 84 -----------------------------------------------------------------------
( 42 )

ElementValues ::= ElementValues  .COMMA ElementValue 
ElementValuesopt ::= ElementValues . (466)

*** Shift/reduce conflict on "COMMA" with rule 466

ElementValueArrayInitializer ::= LBRACE  .ElementValuesopt ,opt RBRACE 
ElementValuesopt ::= ElementValues . (466)




STATE 90 -----------------------------------------------------------------------
( 50 )

FieldAccess ::= super DOT  .identifier 
MethodInvocation ::= super DOT  .TypeArgumentsopt identifier LPAREN 
                     ArgumentListopt RPAREN 

identifier ::= .IDENTIFIER 
TypeArguments ::= .LESS ActualTypeArgumentList GREATER 
TypeArgumentsopt ::= . (535)
TypeArgumentsopt ::= .TypeArguments 

*** Shift/reduce conflict on "IDENTIFIER" with rule 535

MethodInvocation ::= super DOT  .TypeArgumentsopt identifier LPAREN 
                     ArgumentListopt RPAREN 
TypeArgumentsopt ::= . (535)




STATE 92 -----------------------------------------------------------------------
( 52 )

ClassInstanceCreationExpression ::= Primary DOT  .new TypeArgumentsopt 
                                    identifier TypeArgumentsopt LPAREN 
                                    ArgumentListopt RPAREN ClassBodyopt 
FieldAccess ::= Primary DOT  .identifier 
MethodInvocation ::= Primary DOT  .TypeArgumentsopt identifier LPAREN 
                     ArgumentListopt RPAREN 

identifier ::= .IDENTIFIER 
TypeArguments ::= .LESS ActualTypeArgumentList GREATER 
TypeArgumentsopt ::= . (535)
TypeArgumentsopt ::= .TypeArguments 

*** Shift/reduce conflict on "IDENTIFIER" with rule 535

MethodInvocation ::= Primary DOT  .TypeArgumentsopt identifier LPAREN 
                     ArgumentListopt RPAREN 
TypeArgumentsopt ::= . (535)




STATE 100 ----------------------------------------------------------------------
( 56 96 99 118 193 201 202 203 215 221 231 272 283 333 342 350 390 394 400 421 )

ClassType ::= TypeName  .TypeArgumentsopt 
TypeName ::= TypeName  .DOT identifier 

TypeArguments ::= .LESS ActualTypeArgumentList GREATER 
TypeArgumentsopt ::= . (535)
TypeArgumentsopt ::= .TypeArguments 

*** Shift/reduce conflict on "LESS" with rule 535

ClassInstanceCreationExpression ::= new TypeArgumentsopt  .ClassOrInterfaceType 
                                    TypeArgumentsopt LPAREN ArgumentListopt 
                                    RPAREN ClassBodyopt 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= TypeName  .TypeArgumentsopt 
TypeArgumentsopt ::= . (535)




STATE 104 ----------------------------------------------------------------------
( 58 )

Type ::= PrimitiveType . (2)
CastExpression ::= LPAREN PrimitiveType  .Dimsopt RPAREN UnaryExpression 

Dims ::= .LBRACKET RBRACKET 
Dims ::= .Dims LBRACKET RBRACKET 
Dimsopt ::= . (445)
Dimsopt ::= .Dims 

*** Shift/reduce conflict on "LBRACKET" with rule 2

ArrayType ::= .Type LBRACKET RBRACKET 
Type ::= PrimitiveType . (2)




STATE 106 ----------------------------------------------------------------------
( 58 86 88 101 126 155 164 194 205 238 240 242 247 267 278 282 298 299 300 305 
  314 316 319 321 327 339 354 359 361 362 363 364 384 396 405 408 409 410 411 
  412 436 437 443 444 446 447 448 449 450 451 452 462 468 471 472 473 474 479 
  480 482 )

PrimaryNoNewArray ::= ArrayAccess . (339)
LeftHandSide ::= ArrayAccess . (430)

*** Reduce/reduce conflict on "GREATER" between rule 339 and 430

ShiftExpression ::= .ShiftExpression GREATER GREATER AdditiveExpression 
ShiftExpression ::= .AdditiveExpression 
AdditiveExpression ::= .MultiplicativeExpression 
MultiplicativeExpression ::= .UnaryExpression 
UnaryExpression ::= .UnaryExpressionNotPlusMinus 
UnaryExpressionNotPlusMinus ::= .PostfixExpression 
PostfixExpression ::= .Primary 
Primary ::= .PrimaryNoNewArray 
PrimaryNoNewArray ::= ArrayAccess . (339)
------------------------------------------------------------------------------
Assignment ::= .LeftHandSide AssignmentOperator AssignmentExpression 
LeftHandSide ::= ArrayAccess . (430)




STATE 107 ----------------------------------------------------------------------
( 58 86 88 101 126 155 164 194 205 238 240 242 247 267 278 282 298 299 300 305 
  314 316 319 321 327 339 354 359 361 362 363 364 384 396 405 408 409 410 411 
  412 436 437 443 444 446 447 448 449 450 451 452 462 468 471 472 473 474 479 
  480 482 )

PrimaryNoNewArray ::= FieldAccess . (337)
LeftHandSide ::= FieldAccess . (429)

*** Reduce/reduce conflict on "GREATER" between rule 337 and 429

ShiftExpression ::= .ShiftExpression GREATER GREATER AdditiveExpression 
ShiftExpression ::= .AdditiveExpression 
AdditiveExpression ::= .MultiplicativeExpression 
MultiplicativeExpression ::= .UnaryExpression 
UnaryExpression ::= .UnaryExpressionNotPlusMinus 
UnaryExpressionNotPlusMinus ::= .PostfixExpression 
PostfixExpression ::= .Primary 
Primary ::= .PrimaryNoNewArray 
PrimaryNoNewArray ::= FieldAccess . (337)
------------------------------------------------------------------------------
Assignment ::= .LeftHandSide AssignmentOperator AssignmentExpression 
LeftHandSide ::= FieldAccess . (429)




STATE 108 ----------------------------------------------------------------------
( 58 86 88 101 126 155 164 194 205 238 240 242 247 267 278 282 298 299 300 305 
  314 316 319 321 327 339 354 359 361 362 363 364 384 396 405 408 409 410 411 
  412 436 437 443 444 446 447 448 449 450 451 452 462 468 471 472 473 474 479 
  480 482 )

ArrayAccess ::= ExpressionName  .LBRACKET Expression RBRACKET 
PostfixExpression ::= ExpressionName . (375)
LeftHandSide ::= ExpressionName . (428)

*** Reduce/reduce conflict on "GREATER" between rule 375 and 428

ShiftExpression ::= .ShiftExpression GREATER GREATER AdditiveExpression 
ShiftExpression ::= .AdditiveExpression 
AdditiveExpression ::= .MultiplicativeExpression 
MultiplicativeExpression ::= .UnaryExpression 
UnaryExpression ::= .UnaryExpressionNotPlusMinus 
UnaryExpressionNotPlusMinus ::= .PostfixExpression 
PostfixExpression ::= ExpressionName . (375)
------------------------------------------------------------------------------
Assignment ::= .LeftHandSide AssignmentOperator AssignmentExpression 
LeftHandSide ::= ExpressionName . (428)




STATE 150 ----------------------------------------------------------------------
( 96 118 201 202 203 215 221 272 283 333 342 350 390 394 400 421 )

TypeName ::= identifier . (21)
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "ERROR_TOKEN" between rule 21 and 24

InterfaceMemberDeclarations ::= .InterfaceMemberDeclarations 
                                InterfaceMemberDeclaration 
InterfaceMemberDeclarations ::= .InterfaceMemberDeclaration 
InterfaceMemberDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
InterfaceMemberDeclarations ::= .InterfaceMemberDeclarations 
                                InterfaceMemberDeclaration 
InterfaceMemberDeclarations ::= .InterfaceMemberDeclaration 
InterfaceMemberDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "IDENTIFIER" between rule 21 and 24

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "void" between rule 21 and 24

InterfaceMemberDeclarations ::= .InterfaceMemberDeclarations 
                                InterfaceMemberDeclaration 
InterfaceMemberDeclarations ::= .InterfaceMemberDeclaration 
InterfaceMemberDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
InterfaceMemberDeclarations ::= .InterfaceMemberDeclarations 
                                InterfaceMemberDeclaration 
InterfaceMemberDeclarations ::= .InterfaceMemberDeclaration 
InterfaceMemberDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "strictfp" between rule 21 and 24

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "static" between rule 21 and 24

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "short" between rule 21 and 24

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "public" between rule 21 and 24

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "protected" between rule 21 and 24

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "private" between rule 21 and 24

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "long" between rule 21 and 24

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "interface" between rule 21 and 24

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "int" between rule 21 and 24

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "instanceof" between rule 21 and 24

RelationalExpression ::= .RelationalExpression instanceof ReferenceType 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
RelationalExpression ::= .RelationalExpression instanceof ReferenceType 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "float" between rule 21 and 24

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "final" between rule 21 and 24

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "enum" between rule 21 and 24

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "double" between rule 21 and 24

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "class" between rule 21 and 24

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "char" between rule 21 and 24

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "byte" between rule 21 and 24

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "boolean" between rule 21 and 24

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "abstract" between rule 21 and 24

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "ELLIPSIS" between rule 21 and 24

LastFormalParameter ::= VariableModifiersopt  .Type ...opt VariableDeclaratorId 
Type ::= .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
LastFormalParameter ::= VariableModifiersopt  .Type ...opt VariableDeclaratorId 
Type ::= .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "GREATER" between rule 21 and 24

TypeArguments ::= LESS  .ActualTypeArgumentList GREATER 
ActualTypeArgumentList ::= .ActualTypeArgument 
ActualTypeArgument ::= .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
TypeArguments ::= LESS  .ActualTypeArgumentList GREATER 
ActualTypeArgumentList ::= .ActualTypeArgument 
ActualTypeArgument ::= .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "EQUAL_EQUAL" between rule 21 and 24

EqualityExpression ::= .EqualityExpression EQUAL_EQUAL RelationalExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
EqualityExpression ::= .EqualityExpression EQUAL_EQUAL RelationalExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "LESS_EQUAL" between rule 21 and 24

RelationalExpression ::= .RelationalExpression LESS_EQUAL ShiftExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
RelationalExpression ::= .RelationalExpression LESS_EQUAL ShiftExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "LESS" between rule 21 and 24

ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
RelationalExpression ::= .RelationalExpression LESS ShiftExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "RBRACE" between rule 21 and 24

ElementValueArrayInitializer ::= LBRACE  .ElementValuesopt ,opt RBRACE 
ElementValuesopt ::= .ElementValues 
ElementValues ::= .ElementValue 
ElementValue ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= .InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
ElementValueArrayInitializer ::= LBRACE  .ElementValuesopt ,opt RBRACE 
ElementValuesopt ::= .ElementValues 
ElementValues ::= .ElementValue 
ElementValue ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= .InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "OR_OR" between rule 21 and 24

ConditionalOrExpression ::= .ConditionalOrExpression OR_OR 
                            ConditionalAndExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= .InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
ConditionalOrExpression ::= .ConditionalOrExpression OR_OR 
                            ConditionalAndExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= .InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "LBRACE" between rule 21 and 24

ConstructorDeclaration ::= ConstructorModifiersopt ConstructorDeclarator  .
                           Throwsopt ConstructorBody 
Throwsopt ::= .Throws 
Throws ::= throws  .ExceptionTypeList 
ExceptionTypeList ::= .ExceptionType 
ExceptionType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
ConstructorDeclaration ::= ConstructorModifiersopt ConstructorDeclarator  .
                           Throwsopt ConstructorBody 
Throwsopt ::= .Throws 
Throws ::= throws  .ExceptionTypeList 
ExceptionTypeList ::= .ExceptionType 
ExceptionType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "XOR" between rule 21 and 24

ExclusiveOrExpression ::= .ExclusiveOrExpression XOR AndExpression 
ExclusiveOrExpression ::= .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
ExclusiveOrExpression ::= .ExclusiveOrExpression XOR AndExpression 
ExclusiveOrExpression ::= .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "RBRACKET" between rule 21 and 24

ArrayAccess ::= ExpressionName LBRACKET  .Expression RBRACKET 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= .InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
ArrayAccess ::= ExpressionName LBRACKET  .Expression RBRACKET 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= .InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "LBRACKET" between rule 21 and 24

ArrayType ::= .Type LBRACKET RBRACKET 
Type ::= .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
ArrayType ::= .Type LBRACKET RBRACKET 
Type ::= .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "AT" between rule 21 and 24

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "QUESTION" between rule 21 and 24

ConditionalExpression ::= .ConditionalOrExpression QUESTION Expression COLON 
                          ConditionalExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= .InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
ConditionalExpression ::= .ConditionalOrExpression QUESTION Expression COLON 
                          ConditionalExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= .InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "SEMICOLON" between rule 21 and 24

ExpressionStatement ::= .StatementExpression SEMICOLON 
StatementExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
ExpressionStatement ::= .StatementExpression SEMICOLON 
StatementExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "COLON" between rule 21 and 24

ConditionalExpression ::= ConditionalOrExpression QUESTION  .Expression COLON 
                          ConditionalExpression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
ConditionalExpression ::= ConditionalOrExpression QUESTION  .Expression COLON 
                          ConditionalExpression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "COMMA" between rule 21 and 24

ActualTypeArgumentList ::= .ActualTypeArgumentList COMMA ActualTypeArgument 
ActualTypeArgumentList ::= .ActualTypeArgument 
ActualTypeArgument ::= .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
ActualTypeArgumentList ::= .ActualTypeArgumentList COMMA ActualTypeArgument 
ActualTypeArgumentList ::= .ActualTypeArgument 
ActualTypeArgument ::= .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "RPAREN" between rule 21 and 24

SingleElementAnnotation ::= AT TypeName LPAREN  .ElementValue RPAREN 
ElementValue ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= .InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
SingleElementAnnotation ::= AT TypeName LPAREN  .ElementValue RPAREN 
ElementValue ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= .InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "AND_AND" between rule 21 and 24

ConditionalAndExpression ::= .ConditionalAndExpression AND_AND 
                             InclusiveOrExpression 
ConditionalAndExpression ::= .InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
ConditionalAndExpression ::= .ConditionalAndExpression AND_AND 
                             InclusiveOrExpression 
ConditionalAndExpression ::= .InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "AND" between rule 21 and 24

AndExpression ::= .AndExpression AND EqualityExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
AndExpression ::= .AndExpression AND EqualityExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "NOT_EQUAL" between rule 21 and 24

EqualityExpression ::= .EqualityExpression NOT_EQUAL RelationalExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
EqualityExpression ::= .EqualityExpression NOT_EQUAL RelationalExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "OR" between rule 21 and 24

InclusiveOrExpression ::= .InclusiveOrExpression OR ExclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
InclusiveOrExpression ::= .InclusiveOrExpression OR ExclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= RelationalExpression instanceof  .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)




STATE 170 ----------------------------------------------------------------------
( 116 )

RelationalExpression ::= RelationalExpression  .LESS ShiftExpression 
RelationalExpression ::= RelationalExpression  .GREATER ShiftExpression 
RelationalExpression ::= RelationalExpression  .LESS_EQUAL ShiftExpression 
RelationalExpression ::= RelationalExpression  .GREATER EQUAL ShiftExpression 
RelationalExpression ::= RelationalExpression  .instanceof ReferenceType 
EqualityExpression ::= EqualityExpression NOT_EQUAL RelationalExpression .
                        (412)

*** Shift/reduce conflict on "LESS" with rule 412

InterfaceMemberDeclarations ::= .InterfaceMemberDeclarations 
                                InterfaceMemberDeclaration 
InterfaceMemberDeclarations ::= .InterfaceMemberDeclaration 
InterfaceMemberDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= EqualityExpression NOT_EQUAL RelationalExpression .
                        (412)




STATE 171 ----------------------------------------------------------------------
( 117 )

RelationalExpression ::= RelationalExpression  .LESS ShiftExpression 
RelationalExpression ::= RelationalExpression  .GREATER ShiftExpression 
RelationalExpression ::= RelationalExpression  .LESS_EQUAL ShiftExpression 
RelationalExpression ::= RelationalExpression  .GREATER EQUAL ShiftExpression 
RelationalExpression ::= RelationalExpression  .instanceof ReferenceType 
EqualityExpression ::= EqualityExpression EQUAL_EQUAL RelationalExpression .
                        (411)

*** Shift/reduce conflict on "LESS" with rule 411

InterfaceMemberDeclarations ::= .InterfaceMemberDeclarations 
                                InterfaceMemberDeclaration 
InterfaceMemberDeclarations ::= .InterfaceMemberDeclaration 
InterfaceMemberDeclaration ::= .ConstantDeclaration 
ConstantDeclaration ::= ConstantModifiersopt Type  .VariableDeclarators 
VariableDeclarators ::= .VariableDeclarator 
VariableDeclarator ::= VariableDeclaratorId EQUAL  .VariableInitializer 
VariableInitializer ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= LeftHandSide AssignmentOperator  .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= ConditionalAndExpression AND_AND  .
                             InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= ExclusiveOrExpression XOR  .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= EqualityExpression EQUAL_EQUAL RelationalExpression .
                        (411)




STATE 173 ----------------------------------------------------------------------
( 119 )

ShiftExpression ::= ShiftExpression  .LEFT_SHIFT AdditiveExpression 
ShiftExpression ::= ShiftExpression  .GREATER GREATER AdditiveExpression 
ShiftExpression ::= ShiftExpression  .GREATER GREATER GREATER 
                    AdditiveExpression 
RelationalExpression ::= RelationalExpression LESS_EQUAL ShiftExpression .
                          (407)

*** Shift/reduce conflict on "GREATER" with rule 407

RelationalExpression ::= .RelationalExpression GREATER ShiftExpression 
RelationalExpression ::= RelationalExpression LESS_EQUAL ShiftExpression .
                          (407)




STATE 175 ----------------------------------------------------------------------
( 120 )

ShiftExpression ::= ShiftExpression  .LEFT_SHIFT AdditiveExpression 
ShiftExpression ::= ShiftExpression  .GREATER GREATER AdditiveExpression 
ShiftExpression ::= ShiftExpression  .GREATER GREATER GREATER 
                    AdditiveExpression 
RelationalExpression ::= RelationalExpression GREATER ShiftExpression . (406)

*** Shift/reduce conflict on "GREATER" with rule 406

RelationalExpression ::= .RelationalExpression GREATER ShiftExpression 
RelationalExpression ::= RelationalExpression GREATER ShiftExpression . (406)




STATE 176 ----------------------------------------------------------------------
( 121 )

ShiftExpression ::= ShiftExpression  .LEFT_SHIFT AdditiveExpression 
ShiftExpression ::= ShiftExpression  .GREATER GREATER AdditiveExpression 
ShiftExpression ::= ShiftExpression  .GREATER GREATER GREATER 
                    AdditiveExpression 
RelationalExpression ::= RelationalExpression LESS ShiftExpression . (405)

*** Shift/reduce conflict on "GREATER" with rule 405

RelationalExpression ::= .RelationalExpression GREATER ShiftExpression 
RelationalExpression ::= RelationalExpression LESS ShiftExpression . (405)




STATE 183 ----------------------------------------------------------------------
( 128 )

AnnotationTypeBody ::= LBRACE  .AnnotationTypeElementDeclarationsopt RBRACE 

ClassDeclaration ::= .NormalClassDeclaration 
ClassDeclaration ::= .EnumDeclaration 
NormalClassDeclaration ::= .ClassModifiersopt class identifier 
                           TypeParametersopt Superopt Interfacesopt ClassBody 
ClassModifiers ::= .ClassModifier 
ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifier ::= .Annotation 
ClassModifier ::= .public 
ClassModifier ::= .protected 
ClassModifier ::= .private 
ClassModifier ::= .abstract 
ClassModifier ::= .static 
ClassModifier ::= .final 
ClassModifier ::= .strictfp 
EnumDeclaration ::= .ClassModifiersopt enum identifier Interfacesopt EnumBody 
InterfaceDeclaration ::= .NormalInterfaceDeclaration 
InterfaceDeclaration ::= .AnnotationTypeDeclaration 
NormalInterfaceDeclaration ::= .InterfaceModifiersopt interface identifier 
                               TypeParametersopt ExtendsInterfacesopt 
                               InterfaceBody 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifier ::= .Annotation 
InterfaceModifier ::= .public 
InterfaceModifier ::= .protected 
InterfaceModifier ::= .private 
InterfaceModifier ::= .abstract 
InterfaceModifier ::= .static 
InterfaceModifier ::= .strictfp 
ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiers ::= .ConstantModifier 
ConstantModifiers ::= .ConstantModifiers ConstantModifier 
ConstantModifier ::= .Annotation 
ConstantModifier ::= .public 
ConstantModifier ::= .static 
ConstantModifier ::= .final 
AbstractMethodModifiers ::= .AbstractMethodModifier 
AbstractMethodModifiers ::= .AbstractMethodModifiers AbstractMethodModifier 
AbstractMethodModifier ::= .Annotations 
AbstractMethodModifier ::= .public 
AbstractMethodModifier ::= .abstract 
AnnotationTypeDeclaration ::= .InterfaceModifiersopt AT interface identifier 
                              AnnotationTypeBody 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
AnnotationTypeElementDeclaration ::= .ClassDeclaration 
AnnotationTypeElementDeclaration ::= .InterfaceDeclaration 
AnnotationTypeElementDeclaration ::= .EnumDeclaration 
AnnotationTypeElementDeclaration ::= .AnnotationTypeDeclaration 
AnnotationTypeElementDeclaration ::= .SEMICOLON 
Annotations ::= .Annotation 
Annotations ::= .Annotations Annotation 
Annotation ::= .NormalAnnotation 
Annotation ::= .MarkerAnnotation 
Annotation ::= .SingleElementAnnotation 
NormalAnnotation ::= .AT TypeName LPAREN ElementValuePairsopt RPAREN 
MarkerAnnotation ::= .AT TypeName 
SingleElementAnnotation ::= .AT TypeName LPAREN ElementValue RPAREN 
AnnotationTypeElementDeclarationsopt ::= . (471)
AnnotationTypeElementDeclarationsopt ::= .AnnotationTypeElementDeclarations 
AbstractMethodModifiersopt ::= . (473)
AbstractMethodModifiersopt ::= .AbstractMethodModifiers 
ConstantModifiersopt ::= . (475)
ConstantModifiersopt ::= .ConstantModifiers 
InterfaceModifiersopt ::= . (481)
InterfaceModifiersopt ::= .InterfaceModifiers 
ClassModifiersopt ::= . (519)
ClassModifiersopt ::= .ClassModifiers 

*** Shift/reduce conflict on "AT" with rule 481

AnnotationTypeDeclaration ::= .InterfaceModifiersopt AT interface identifier 
                              AnnotationTypeBody 
InterfaceModifiersopt ::= . (481)

*** Reduce/reduce conflict on "IDENTIFIER" between rule 473 and 475

AnnotationTypeElementDeclaration ::= .AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
AbstractMethodModifiersopt ::= . (473)
------------------------------------------------------------------------------
ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= . (475)

*** Reduce/reduce conflict on "short" between rule 473 and 475

AnnotationTypeElementDeclaration ::= .AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
AbstractMethodModifiersopt ::= . (473)
------------------------------------------------------------------------------
ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= . (475)

*** Reduce/reduce conflict on "long" between rule 473 and 475

AnnotationTypeElementDeclaration ::= .AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
AbstractMethodModifiersopt ::= . (473)
------------------------------------------------------------------------------
ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= . (475)

*** Reduce/reduce conflict on "int" between rule 473 and 475

AnnotationTypeElementDeclaration ::= .AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
AbstractMethodModifiersopt ::= . (473)
------------------------------------------------------------------------------
ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= . (475)

*** Reduce/reduce conflict on "float" between rule 473 and 475

AnnotationTypeElementDeclaration ::= .AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
AbstractMethodModifiersopt ::= . (473)
------------------------------------------------------------------------------
ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= . (475)

*** Reduce/reduce conflict on "double" between rule 473 and 475

AnnotationTypeElementDeclaration ::= .AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
AbstractMethodModifiersopt ::= . (473)
------------------------------------------------------------------------------
ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= . (475)

*** Reduce/reduce conflict on "char" between rule 473 and 475

AnnotationTypeElementDeclaration ::= .AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
AbstractMethodModifiersopt ::= . (473)
------------------------------------------------------------------------------
ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= . (475)

*** Reduce/reduce conflict on "byte" between rule 473 and 475

AnnotationTypeElementDeclaration ::= .AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
AbstractMethodModifiersopt ::= . (473)
------------------------------------------------------------------------------
ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= . (475)

*** Reduce/reduce conflict on "boolean" between rule 473 and 475

AnnotationTypeElementDeclaration ::= .AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
AbstractMethodModifiersopt ::= . (473)
------------------------------------------------------------------------------
ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= . (475)




STATE 189 ----------------------------------------------------------------------
( 131 )

EnumBody ::= LBRACE  .EnumConstantsopt ,opt EnumBodyDeclarationsopt RBRACE 

identifier ::= .IDENTIFIER 
EnumConstants ::= .EnumConstant 
EnumConstants ::= .EnumConstants COMMA EnumConstant 
EnumConstant ::= .Annotationsopt identifier Argumentsopt ClassBodyopt 
Annotations ::= .Annotation 
Annotations ::= .Annotations Annotation 
Annotation ::= .NormalAnnotation 
Annotation ::= .MarkerAnnotation 
Annotation ::= .SingleElementAnnotation 
NormalAnnotation ::= .AT TypeName LPAREN ElementValuePairsopt RPAREN 
MarkerAnnotation ::= .AT TypeName 
SingleElementAnnotation ::= .AT TypeName LPAREN ElementValue RPAREN 
EnumConstant ::= .identifier 
EnumConstantsopt ::= . (491)
EnumConstantsopt ::= .EnumConstants 
Annotationsopt ::= . (521)
Annotationsopt ::= .Annotations 

*** Shift/reduce conflict on "IDENTIFIER" with rule 521

EnumConstant ::= .Annotationsopt identifier Argumentsopt ClassBodyopt 
Annotationsopt ::= . (521)




STATE 195 ----------------------------------------------------------------------
( 142 )

FieldAccess ::= ClassName DOT super DOT  .identifier 
MethodInvocation ::= ClassName DOT super DOT  .TypeArgumentsopt identifier 
                     LPAREN ArgumentListopt RPAREN 

identifier ::= .IDENTIFIER 
TypeArguments ::= .LESS ActualTypeArgumentList GREATER 
TypeArgumentsopt ::= . (535)
TypeArgumentsopt ::= .TypeArguments 

*** Shift/reduce conflict on "IDENTIFIER" with rule 535

MethodInvocation ::= ClassName DOT super DOT  .TypeArgumentsopt identifier 
                     LPAREN ArgumentListopt RPAREN 
TypeArgumentsopt ::= . (535)




STATE 212 ----------------------------------------------------------------------
( 174 )

ShiftExpression ::= ShiftExpression  .LEFT_SHIFT AdditiveExpression 
ShiftExpression ::= ShiftExpression  .GREATER GREATER AdditiveExpression 
ShiftExpression ::= ShiftExpression  .GREATER GREATER GREATER 
                    AdditiveExpression 
RelationalExpression ::= RelationalExpression GREATER EQUAL ShiftExpression .
                          (408)

*** Shift/reduce conflict on "GREATER" with rule 408

RelationalExpression ::= .RelationalExpression GREATER ShiftExpression 
RelationalExpression ::= RelationalExpression GREATER EQUAL ShiftExpression .
                          (408)




STATE 216 ----------------------------------------------------------------------
( 183 227 )

InterfaceDeclaration ::= AnnotationTypeDeclaration . (177)
AnnotationTypeElementDeclaration ::= AnnotationTypeDeclaration . (221)

*** Reduce/reduce conflict on "IDENTIFIER" between rule 177 and 221

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .InterfaceDeclaration 
InterfaceDeclaration ::= AnnotationTypeDeclaration . (177)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= AnnotationTypeDeclaration . (221)

*** Reduce/reduce conflict on "strictfp" between rule 177 and 221

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .InterfaceDeclaration 
InterfaceDeclaration ::= AnnotationTypeDeclaration . (177)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= AnnotationTypeDeclaration . (221)

*** Reduce/reduce conflict on "static" between rule 177 and 221

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .InterfaceDeclaration 
InterfaceDeclaration ::= AnnotationTypeDeclaration . (177)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= AnnotationTypeDeclaration . (221)

*** Reduce/reduce conflict on "short" between rule 177 and 221

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .InterfaceDeclaration 
InterfaceDeclaration ::= AnnotationTypeDeclaration . (177)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= AnnotationTypeDeclaration . (221)

*** Reduce/reduce conflict on "public" between rule 177 and 221

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .InterfaceDeclaration 
InterfaceDeclaration ::= AnnotationTypeDeclaration . (177)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= AnnotationTypeDeclaration . (221)

*** Reduce/reduce conflict on "protected" between rule 177 and 221

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .InterfaceDeclaration 
InterfaceDeclaration ::= AnnotationTypeDeclaration . (177)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= AnnotationTypeDeclaration . (221)

*** Reduce/reduce conflict on "private" between rule 177 and 221

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .InterfaceDeclaration 
InterfaceDeclaration ::= AnnotationTypeDeclaration . (177)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= AnnotationTypeDeclaration . (221)

*** Reduce/reduce conflict on "long" between rule 177 and 221

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .InterfaceDeclaration 
InterfaceDeclaration ::= AnnotationTypeDeclaration . (177)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= AnnotationTypeDeclaration . (221)

*** Reduce/reduce conflict on "interface" between rule 177 and 221

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .InterfaceDeclaration 
InterfaceDeclaration ::= AnnotationTypeDeclaration . (177)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= AnnotationTypeDeclaration . (221)

*** Reduce/reduce conflict on "int" between rule 177 and 221

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .InterfaceDeclaration 
InterfaceDeclaration ::= AnnotationTypeDeclaration . (177)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= AnnotationTypeDeclaration . (221)

*** Reduce/reduce conflict on "float" between rule 177 and 221

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .InterfaceDeclaration 
InterfaceDeclaration ::= AnnotationTypeDeclaration . (177)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= AnnotationTypeDeclaration . (221)

*** Reduce/reduce conflict on "final" between rule 177 and 221

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .InterfaceDeclaration 
InterfaceDeclaration ::= AnnotationTypeDeclaration . (177)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= AnnotationTypeDeclaration . (221)

*** Reduce/reduce conflict on "enum" between rule 177 and 221

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .InterfaceDeclaration 
InterfaceDeclaration ::= AnnotationTypeDeclaration . (177)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= AnnotationTypeDeclaration . (221)

*** Reduce/reduce conflict on "double" between rule 177 and 221

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .InterfaceDeclaration 
InterfaceDeclaration ::= AnnotationTypeDeclaration . (177)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= AnnotationTypeDeclaration . (221)

*** Reduce/reduce conflict on "class" between rule 177 and 221

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .InterfaceDeclaration 
InterfaceDeclaration ::= AnnotationTypeDeclaration . (177)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= AnnotationTypeDeclaration . (221)

*** Reduce/reduce conflict on "char" between rule 177 and 221

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .InterfaceDeclaration 
InterfaceDeclaration ::= AnnotationTypeDeclaration . (177)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= AnnotationTypeDeclaration . (221)

*** Reduce/reduce conflict on "byte" between rule 177 and 221

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .InterfaceDeclaration 
InterfaceDeclaration ::= AnnotationTypeDeclaration . (177)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= AnnotationTypeDeclaration . (221)

*** Reduce/reduce conflict on "boolean" between rule 177 and 221

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .InterfaceDeclaration 
InterfaceDeclaration ::= AnnotationTypeDeclaration . (177)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= AnnotationTypeDeclaration . (221)

*** Reduce/reduce conflict on "abstract" between rule 177 and 221

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .InterfaceDeclaration 
InterfaceDeclaration ::= AnnotationTypeDeclaration . (177)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= AnnotationTypeDeclaration . (221)

*** Reduce/reduce conflict on "RBRACE" between rule 177 and 221

AnnotationTypeBody ::= LBRACE  .AnnotationTypeElementDeclarationsopt RBRACE 
AnnotationTypeElementDeclarationsopt ::= .AnnotationTypeElementDeclarations 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .InterfaceDeclaration 
InterfaceDeclaration ::= AnnotationTypeDeclaration . (177)
------------------------------------------------------------------------------
AnnotationTypeBody ::= LBRACE  .AnnotationTypeElementDeclarationsopt RBRACE 
AnnotationTypeElementDeclarationsopt ::= .AnnotationTypeElementDeclarations 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= AnnotationTypeDeclaration . (221)

*** Reduce/reduce conflict on "AT" between rule 177 and 221

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .InterfaceDeclaration 
InterfaceDeclaration ::= AnnotationTypeDeclaration . (177)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= AnnotationTypeDeclaration . (221)

*** Reduce/reduce conflict on "SEMICOLON" between rule 177 and 221

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .InterfaceDeclaration 
InterfaceDeclaration ::= AnnotationTypeDeclaration . (177)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= AnnotationTypeDeclaration . (221)




STATE 217 ----------------------------------------------------------------------
( 183 227 )

ClassDeclaration ::= EnumDeclaration . (68)
AnnotationTypeElementDeclaration ::= EnumDeclaration . (220)

*** Reduce/reduce conflict on "IDENTIFIER" between rule 68 and 220

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ClassDeclaration 
ClassDeclaration ::= EnumDeclaration . (68)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= EnumDeclaration . (220)

*** Reduce/reduce conflict on "strictfp" between rule 68 and 220

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ClassDeclaration 
ClassDeclaration ::= EnumDeclaration . (68)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= EnumDeclaration . (220)

*** Reduce/reduce conflict on "static" between rule 68 and 220

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ClassDeclaration 
ClassDeclaration ::= EnumDeclaration . (68)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= EnumDeclaration . (220)

*** Reduce/reduce conflict on "short" between rule 68 and 220

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ClassDeclaration 
ClassDeclaration ::= EnumDeclaration . (68)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= EnumDeclaration . (220)

*** Reduce/reduce conflict on "public" between rule 68 and 220

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ClassDeclaration 
ClassDeclaration ::= EnumDeclaration . (68)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= EnumDeclaration . (220)

*** Reduce/reduce conflict on "protected" between rule 68 and 220

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ClassDeclaration 
ClassDeclaration ::= EnumDeclaration . (68)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= EnumDeclaration . (220)

*** Reduce/reduce conflict on "private" between rule 68 and 220

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ClassDeclaration 
ClassDeclaration ::= EnumDeclaration . (68)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= EnumDeclaration . (220)

*** Reduce/reduce conflict on "long" between rule 68 and 220

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ClassDeclaration 
ClassDeclaration ::= EnumDeclaration . (68)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= EnumDeclaration . (220)

*** Reduce/reduce conflict on "interface" between rule 68 and 220

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ClassDeclaration 
ClassDeclaration ::= EnumDeclaration . (68)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= EnumDeclaration . (220)

*** Reduce/reduce conflict on "int" between rule 68 and 220

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ClassDeclaration 
ClassDeclaration ::= EnumDeclaration . (68)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= EnumDeclaration . (220)

*** Reduce/reduce conflict on "float" between rule 68 and 220

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ClassDeclaration 
ClassDeclaration ::= EnumDeclaration . (68)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= EnumDeclaration . (220)

*** Reduce/reduce conflict on "final" between rule 68 and 220

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ClassDeclaration 
ClassDeclaration ::= EnumDeclaration . (68)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= EnumDeclaration . (220)

*** Reduce/reduce conflict on "enum" between rule 68 and 220

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ClassDeclaration 
ClassDeclaration ::= EnumDeclaration . (68)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= EnumDeclaration . (220)

*** Reduce/reduce conflict on "double" between rule 68 and 220

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ClassDeclaration 
ClassDeclaration ::= EnumDeclaration . (68)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= EnumDeclaration . (220)

*** Reduce/reduce conflict on "class" between rule 68 and 220

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ClassDeclaration 
ClassDeclaration ::= EnumDeclaration . (68)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= EnumDeclaration . (220)

*** Reduce/reduce conflict on "char" between rule 68 and 220

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ClassDeclaration 
ClassDeclaration ::= EnumDeclaration . (68)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= EnumDeclaration . (220)

*** Reduce/reduce conflict on "byte" between rule 68 and 220

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ClassDeclaration 
ClassDeclaration ::= EnumDeclaration . (68)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= EnumDeclaration . (220)

*** Reduce/reduce conflict on "boolean" between rule 68 and 220

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ClassDeclaration 
ClassDeclaration ::= EnumDeclaration . (68)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= EnumDeclaration . (220)

*** Reduce/reduce conflict on "abstract" between rule 68 and 220

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ClassDeclaration 
ClassDeclaration ::= EnumDeclaration . (68)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= EnumDeclaration . (220)

*** Reduce/reduce conflict on "RBRACE" between rule 68 and 220

AnnotationTypeBody ::= LBRACE  .AnnotationTypeElementDeclarationsopt RBRACE 
AnnotationTypeElementDeclarationsopt ::= .AnnotationTypeElementDeclarations 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ClassDeclaration 
ClassDeclaration ::= EnumDeclaration . (68)
------------------------------------------------------------------------------
AnnotationTypeBody ::= LBRACE  .AnnotationTypeElementDeclarationsopt RBRACE 
AnnotationTypeElementDeclarationsopt ::= .AnnotationTypeElementDeclarations 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= EnumDeclaration . (220)

*** Reduce/reduce conflict on "AT" between rule 68 and 220

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ClassDeclaration 
ClassDeclaration ::= EnumDeclaration . (68)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= EnumDeclaration . (220)

*** Reduce/reduce conflict on "SEMICOLON" between rule 68 and 220

AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= .ClassDeclaration 
ClassDeclaration ::= EnumDeclaration . (68)
------------------------------------------------------------------------------
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclarations 
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarations ::= .AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclaration ::= EnumDeclaration . (220)




STATE 218 ----------------------------------------------------------------------
( 183 227 228 254 )

ClassModifier ::= final . (78)
ConstantModifier ::= final . (205)

*** Reduce/reduce conflict on "static" between rule 78 and 205

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= final . (78)
------------------------------------------------------------------------------
ConstantModifiers ::= .ConstantModifiers ConstantModifier 
ConstantModifiers ::= .ConstantModifier 
ConstantModifier ::= final . (205)

*** Reduce/reduce conflict on "public" between rule 78 and 205

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= final . (78)
------------------------------------------------------------------------------
ConstantModifiers ::= .ConstantModifiers ConstantModifier 
ConstantModifiers ::= .ConstantModifier 
ConstantModifier ::= final . (205)

*** Reduce/reduce conflict on "final" between rule 78 and 205

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= final . (78)
------------------------------------------------------------------------------
ConstantModifiers ::= .ConstantModifiers ConstantModifier 
ConstantModifiers ::= .ConstantModifier 
ConstantModifier ::= final . (205)

*** Reduce/reduce conflict on "AT" between rule 78 and 205

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= final . (78)
------------------------------------------------------------------------------
ConstantModifiers ::= .ConstantModifiers ConstantModifier 
ConstantModifiers ::= .ConstantModifier 
ConstantModifier ::= final . (205)




STATE 219 ----------------------------------------------------------------------
( 183 227 228 254 )

ClassModifier ::= static . (77)
InterfaceModifier ::= static . (186)
ConstantModifier ::= static . (204)

*** Reduce/reduce conflict on "strictfp" between rule 77 and 186

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= static . (186)

*** Reduce/reduce conflict on "protected" between rule 77 and 186

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= static . (186)

*** Reduce/reduce conflict on "private" between rule 77 and 186

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= static . (186)

*** Reduce/reduce conflict on "abstract" between rule 77 and 186

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= static . (186)

*** Reduce/reduce conflict on "static" between rule 77 and 204

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
ConstantModifiers ::= .ConstantModifiers ConstantModifier 
ConstantModifiers ::= .ConstantModifier 
ConstantModifier ::= static . (204)

*** Reduce/reduce conflict on "static" between rule 77 and 186

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= static . (186)

*** Reduce/reduce conflict on "public" between rule 77 and 204

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
ConstantModifiers ::= .ConstantModifiers ConstantModifier 
ConstantModifiers ::= .ConstantModifier 
ConstantModifier ::= static . (204)

*** Reduce/reduce conflict on "public" between rule 77 and 186

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= static . (186)

*** Reduce/reduce conflict on "final" between rule 77 and 204

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
ConstantModifiers ::= .ConstantModifiers ConstantModifier 
ConstantModifiers ::= .ConstantModifier 
ConstantModifier ::= static . (204)

*** Reduce/reduce conflict on "AT" between rule 77 and 204

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
ConstantModifiers ::= .ConstantModifiers ConstantModifier 
ConstantModifiers ::= .ConstantModifier 
ConstantModifier ::= static . (204)

*** Reduce/reduce conflict on "AT" between rule 77 and 186

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= static . (186)




STATE 222 ----------------------------------------------------------------------
( 183 227 228 254 )

ClassModifier ::= Annotation . (72)
InterfaceModifier ::= Annotation . (181)
ConstantModifier ::= Annotation . (202)
Annotations ::= Annotation . (224)

*** Reduce/reduce conflict on "strictfp" between rule 72 and 181

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= Annotation . (181)

*** Reduce/reduce conflict on "protected" between rule 72 and 181

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= Annotation . (181)

*** Reduce/reduce conflict on "private" between rule 72 and 181

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= Annotation . (181)

*** Reduce/reduce conflict on "static" between rule 72 and 202

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
ConstantModifiers ::= .ConstantModifiers ConstantModifier 
ConstantModifiers ::= .ConstantModifier 
ConstantModifier ::= Annotation . (202)

*** Reduce/reduce conflict on "static" between rule 72 and 181

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= Annotation . (181)

*** Reduce/reduce conflict on "final" between rule 72 and 202

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
ConstantModifiers ::= .ConstantModifiers ConstantModifier 
ConstantModifiers ::= .ConstantModifier 
ConstantModifier ::= Annotation . (202)

*** Reduce/reduce conflict on "IDENTIFIER" between rule 202 and 224

ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= .ConstantModifiers 
ConstantModifiers ::= .ConstantModifier 
ConstantModifier ::= Annotation . (202)
------------------------------------------------------------------------------
AnnotationTypeElementDeclaration ::= .AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
AbstractMethodModifiersopt ::= .AbstractMethodModifiers 
AbstractMethodModifiers ::= .AbstractMethodModifier 
AbstractMethodModifier ::= .Annotations 
Annotations ::= Annotation . (224)

*** Reduce/reduce conflict on "short" between rule 202 and 224

ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= .ConstantModifiers 
ConstantModifiers ::= .ConstantModifier 
ConstantModifier ::= Annotation . (202)
------------------------------------------------------------------------------
AnnotationTypeElementDeclaration ::= .AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
AbstractMethodModifiersopt ::= .AbstractMethodModifiers 
AbstractMethodModifiers ::= .AbstractMethodModifier 
AbstractMethodModifier ::= .Annotations 
Annotations ::= Annotation . (224)

*** Reduce/reduce conflict on "public" between rule 72 and 224

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
AbstractMethodModifiers ::= .AbstractMethodModifiers AbstractMethodModifier 
AbstractMethodModifiers ::= .AbstractMethodModifier 
AbstractMethodModifier ::= .Annotations 
Annotations ::= Annotation . (224)

*** Reduce/reduce conflict on "public" between rule 72 and 202

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
ConstantModifiers ::= .ConstantModifiers ConstantModifier 
ConstantModifiers ::= .ConstantModifier 
ConstantModifier ::= Annotation . (202)

*** Reduce/reduce conflict on "public" between rule 72 and 181

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= Annotation . (181)

*** Reduce/reduce conflict on "long" between rule 202 and 224

ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= .ConstantModifiers 
ConstantModifiers ::= .ConstantModifier 
ConstantModifier ::= Annotation . (202)
------------------------------------------------------------------------------
AnnotationTypeElementDeclaration ::= .AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
AbstractMethodModifiersopt ::= .AbstractMethodModifiers 
AbstractMethodModifiers ::= .AbstractMethodModifier 
AbstractMethodModifier ::= .Annotations 
Annotations ::= Annotation . (224)

*** Reduce/reduce conflict on "int" between rule 202 and 224

ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= .ConstantModifiers 
ConstantModifiers ::= .ConstantModifier 
ConstantModifier ::= Annotation . (202)
------------------------------------------------------------------------------
AnnotationTypeElementDeclaration ::= .AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
AbstractMethodModifiersopt ::= .AbstractMethodModifiers 
AbstractMethodModifiers ::= .AbstractMethodModifier 
AbstractMethodModifier ::= .Annotations 
Annotations ::= Annotation . (224)

*** Reduce/reduce conflict on "float" between rule 202 and 224

ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= .ConstantModifiers 
ConstantModifiers ::= .ConstantModifier 
ConstantModifier ::= Annotation . (202)
------------------------------------------------------------------------------
AnnotationTypeElementDeclaration ::= .AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
AbstractMethodModifiersopt ::= .AbstractMethodModifiers 
AbstractMethodModifiers ::= .AbstractMethodModifier 
AbstractMethodModifier ::= .Annotations 
Annotations ::= Annotation . (224)

*** Reduce/reduce conflict on "double" between rule 202 and 224

ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= .ConstantModifiers 
ConstantModifiers ::= .ConstantModifier 
ConstantModifier ::= Annotation . (202)
------------------------------------------------------------------------------
AnnotationTypeElementDeclaration ::= .AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
AbstractMethodModifiersopt ::= .AbstractMethodModifiers 
AbstractMethodModifiers ::= .AbstractMethodModifier 
AbstractMethodModifier ::= .Annotations 
Annotations ::= Annotation . (224)

*** Reduce/reduce conflict on "char" between rule 202 and 224

ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= .ConstantModifiers 
ConstantModifiers ::= .ConstantModifier 
ConstantModifier ::= Annotation . (202)
------------------------------------------------------------------------------
AnnotationTypeElementDeclaration ::= .AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
AbstractMethodModifiersopt ::= .AbstractMethodModifiers 
AbstractMethodModifiers ::= .AbstractMethodModifier 
AbstractMethodModifier ::= .Annotations 
Annotations ::= Annotation . (224)

*** Reduce/reduce conflict on "byte" between rule 202 and 224

ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= .ConstantModifiers 
ConstantModifiers ::= .ConstantModifier 
ConstantModifier ::= Annotation . (202)
------------------------------------------------------------------------------
AnnotationTypeElementDeclaration ::= .AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
AbstractMethodModifiersopt ::= .AbstractMethodModifiers 
AbstractMethodModifiers ::= .AbstractMethodModifier 
AbstractMethodModifier ::= .Annotations 
Annotations ::= Annotation . (224)

*** Reduce/reduce conflict on "boolean" between rule 202 and 224

ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= .ConstantModifiers 
ConstantModifiers ::= .ConstantModifier 
ConstantModifier ::= Annotation . (202)
------------------------------------------------------------------------------
AnnotationTypeElementDeclaration ::= .AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
AbstractMethodModifiersopt ::= .AbstractMethodModifiers 
AbstractMethodModifiers ::= .AbstractMethodModifier 
AbstractMethodModifier ::= .Annotations 
Annotations ::= Annotation . (224)

*** Reduce/reduce conflict on "abstract" between rule 72 and 224

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
AbstractMethodModifiers ::= .AbstractMethodModifiers AbstractMethodModifier 
AbstractMethodModifiers ::= .AbstractMethodModifier 
AbstractMethodModifier ::= .Annotations 
Annotations ::= Annotation . (224)

*** Reduce/reduce conflict on "abstract" between rule 72 and 181

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= Annotation . (181)

*** Reduce/reduce conflict on "AT" between rule 72 and 224

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
AbstractMethodModifiers ::= .AbstractMethodModifiers AbstractMethodModifier 
AbstractMethodModifiers ::= .AbstractMethodModifier 
AbstractMethodModifier ::= .Annotations 
Annotations ::= Annotation . (224)

*** Reduce/reduce conflict on "AT" between rule 72 and 202

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
ConstantModifiers ::= .ConstantModifiers ConstantModifier 
ConstantModifiers ::= .ConstantModifier 
ConstantModifier ::= Annotation . (202)

*** Reduce/reduce conflict on "AT" between rule 72 and 181

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= Annotation . (181)




STATE 223 ----------------------------------------------------------------------
( 183 227 228 254 )

ClassModifier ::= abstract . (76)
InterfaceModifier ::= abstract . (185)
AbstractMethodModifier ::= abstract . (211)

*** Reduce/reduce conflict on "strictfp" between rule 76 and 185

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= abstract . (76)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= abstract . (185)

*** Reduce/reduce conflict on "static" between rule 76 and 185

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= abstract . (76)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= abstract . (185)

*** Reduce/reduce conflict on "protected" between rule 76 and 185

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= abstract . (76)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= abstract . (185)

*** Reduce/reduce conflict on "private" between rule 76 and 185

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= abstract . (76)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= abstract . (185)

*** Reduce/reduce conflict on "public" between rule 76 and 211

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= abstract . (76)
------------------------------------------------------------------------------
AbstractMethodModifiers ::= .AbstractMethodModifiers AbstractMethodModifier 
AbstractMethodModifiers ::= .AbstractMethodModifier 
AbstractMethodModifier ::= abstract . (211)

*** Reduce/reduce conflict on "public" between rule 76 and 185

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= abstract . (76)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= abstract . (185)

*** Reduce/reduce conflict on "abstract" between rule 76 and 211

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= abstract . (76)
------------------------------------------------------------------------------
AbstractMethodModifiers ::= .AbstractMethodModifiers AbstractMethodModifier 
AbstractMethodModifiers ::= .AbstractMethodModifier 
AbstractMethodModifier ::= abstract . (211)

*** Reduce/reduce conflict on "abstract" between rule 76 and 185

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= abstract . (76)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= abstract . (185)

*** Reduce/reduce conflict on "AT" between rule 76 and 211

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= abstract . (76)
------------------------------------------------------------------------------
AbstractMethodModifiers ::= .AbstractMethodModifiers AbstractMethodModifier 
AbstractMethodModifiers ::= .AbstractMethodModifier 
AbstractMethodModifier ::= abstract . (211)

*** Reduce/reduce conflict on "AT" between rule 76 and 185

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= abstract . (76)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= abstract . (185)




STATE 224 ----------------------------------------------------------------------
( 183 227 228 254 )

ClassModifier ::= public . (73)
InterfaceModifier ::= public . (182)
ConstantModifier ::= public . (203)
AbstractMethodModifier ::= public . (210)

*** Reduce/reduce conflict on "strictfp" between rule 73 and 182

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= public . (182)

*** Reduce/reduce conflict on "protected" between rule 73 and 182

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= public . (182)

*** Reduce/reduce conflict on "private" between rule 73 and 182

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= public . (182)

*** Reduce/reduce conflict on "static" between rule 73 and 203

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
ConstantModifiers ::= .ConstantModifiers ConstantModifier 
ConstantModifiers ::= .ConstantModifier 
ConstantModifier ::= public . (203)

*** Reduce/reduce conflict on "static" between rule 73 and 182

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= public . (182)

*** Reduce/reduce conflict on "final" between rule 73 and 203

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
ConstantModifiers ::= .ConstantModifiers ConstantModifier 
ConstantModifiers ::= .ConstantModifier 
ConstantModifier ::= public . (203)

*** Reduce/reduce conflict on "IDENTIFIER" between rule 203 and 210

ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= .ConstantModifiers 
ConstantModifiers ::= .ConstantModifier 
ConstantModifier ::= public . (203)
------------------------------------------------------------------------------
AnnotationTypeElementDeclaration ::= .AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
AbstractMethodModifiersopt ::= .AbstractMethodModifiers 
AbstractMethodModifiers ::= .AbstractMethodModifier 
AbstractMethodModifier ::= public . (210)

*** Reduce/reduce conflict on "short" between rule 203 and 210

ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= .ConstantModifiers 
ConstantModifiers ::= .ConstantModifier 
ConstantModifier ::= public . (203)
------------------------------------------------------------------------------
AnnotationTypeElementDeclaration ::= .AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
AbstractMethodModifiersopt ::= .AbstractMethodModifiers 
AbstractMethodModifiers ::= .AbstractMethodModifier 
AbstractMethodModifier ::= public . (210)

*** Reduce/reduce conflict on "public" between rule 73 and 210

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
AbstractMethodModifiers ::= .AbstractMethodModifiers AbstractMethodModifier 
AbstractMethodModifiers ::= .AbstractMethodModifier 
AbstractMethodModifier ::= public . (210)

*** Reduce/reduce conflict on "public" between rule 73 and 203

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
ConstantModifiers ::= .ConstantModifiers ConstantModifier 
ConstantModifiers ::= .ConstantModifier 
ConstantModifier ::= public . (203)

*** Reduce/reduce conflict on "public" between rule 73 and 182

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= public . (182)

*** Reduce/reduce conflict on "long" between rule 203 and 210

ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= .ConstantModifiers 
ConstantModifiers ::= .ConstantModifier 
ConstantModifier ::= public . (203)
------------------------------------------------------------------------------
AnnotationTypeElementDeclaration ::= .AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
AbstractMethodModifiersopt ::= .AbstractMethodModifiers 
AbstractMethodModifiers ::= .AbstractMethodModifier 
AbstractMethodModifier ::= public . (210)

*** Reduce/reduce conflict on "int" between rule 203 and 210

ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= .ConstantModifiers 
ConstantModifiers ::= .ConstantModifier 
ConstantModifier ::= public . (203)
------------------------------------------------------------------------------
AnnotationTypeElementDeclaration ::= .AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
AbstractMethodModifiersopt ::= .AbstractMethodModifiers 
AbstractMethodModifiers ::= .AbstractMethodModifier 
AbstractMethodModifier ::= public . (210)

*** Reduce/reduce conflict on "float" between rule 203 and 210

ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= .ConstantModifiers 
ConstantModifiers ::= .ConstantModifier 
ConstantModifier ::= public . (203)
------------------------------------------------------------------------------
AnnotationTypeElementDeclaration ::= .AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
AbstractMethodModifiersopt ::= .AbstractMethodModifiers 
AbstractMethodModifiers ::= .AbstractMethodModifier 
AbstractMethodModifier ::= public . (210)

*** Reduce/reduce conflict on "double" between rule 203 and 210

ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= .ConstantModifiers 
ConstantModifiers ::= .ConstantModifier 
ConstantModifier ::= public . (203)
------------------------------------------------------------------------------
AnnotationTypeElementDeclaration ::= .AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
AbstractMethodModifiersopt ::= .AbstractMethodModifiers 
AbstractMethodModifiers ::= .AbstractMethodModifier 
AbstractMethodModifier ::= public . (210)

*** Reduce/reduce conflict on "char" between rule 203 and 210

ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= .ConstantModifiers 
ConstantModifiers ::= .ConstantModifier 
ConstantModifier ::= public . (203)
------------------------------------------------------------------------------
AnnotationTypeElementDeclaration ::= .AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
AbstractMethodModifiersopt ::= .AbstractMethodModifiers 
AbstractMethodModifiers ::= .AbstractMethodModifier 
AbstractMethodModifier ::= public . (210)

*** Reduce/reduce conflict on "byte" between rule 203 and 210

ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= .ConstantModifiers 
ConstantModifiers ::= .ConstantModifier 
ConstantModifier ::= public . (203)
------------------------------------------------------------------------------
AnnotationTypeElementDeclaration ::= .AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
AbstractMethodModifiersopt ::= .AbstractMethodModifiers 
AbstractMethodModifiers ::= .AbstractMethodModifier 
AbstractMethodModifier ::= public . (210)

*** Reduce/reduce conflict on "boolean" between rule 203 and 210

ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= .ConstantModifiers 
ConstantModifiers ::= .ConstantModifier 
ConstantModifier ::= public . (203)
------------------------------------------------------------------------------
AnnotationTypeElementDeclaration ::= .AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
AbstractMethodModifiersopt ::= .AbstractMethodModifiers 
AbstractMethodModifiers ::= .AbstractMethodModifier 
AbstractMethodModifier ::= public . (210)

*** Reduce/reduce conflict on "abstract" between rule 73 and 210

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
AbstractMethodModifiers ::= .AbstractMethodModifiers AbstractMethodModifier 
AbstractMethodModifiers ::= .AbstractMethodModifier 
AbstractMethodModifier ::= public . (210)

*** Reduce/reduce conflict on "abstract" between rule 73 and 182

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= public . (182)

*** Reduce/reduce conflict on "AT" between rule 73 and 210

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
AbstractMethodModifiers ::= .AbstractMethodModifiers AbstractMethodModifier 
AbstractMethodModifiers ::= .AbstractMethodModifier 
AbstractMethodModifier ::= public . (210)

*** Reduce/reduce conflict on "AT" between rule 73 and 203

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
ConstantModifiers ::= .ConstantModifiers ConstantModifier 
ConstantModifiers ::= .ConstantModifier 
ConstantModifier ::= public . (203)

*** Reduce/reduce conflict on "AT" between rule 73 and 182

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= public . (182)




STATE 225 ----------------------------------------------------------------------
( 183 226 227 228 254 )

AbstractMethodModifier ::= Annotations . (209)
Annotations ::= Annotations  .Annotation 

Annotation ::= .NormalAnnotation 
Annotation ::= .MarkerAnnotation 
Annotation ::= .SingleElementAnnotation 
NormalAnnotation ::= .AT TypeName LPAREN ElementValuePairsopt RPAREN 
MarkerAnnotation ::= .AT TypeName 
SingleElementAnnotation ::= .AT TypeName LPAREN ElementValue RPAREN 

*** Shift/reduce conflict on "AT" with rule 209

AbstractMethodModifiers ::= .AbstractMethodModifiers AbstractMethodModifier 
AbstractMethodModifiers ::= .AbstractMethodModifier 
AbstractMethodModifier ::= Annotations . (209)




STATE 227 ----------------------------------------------------------------------
( 183 )

AnnotationTypeElementDeclarations ::= AnnotationTypeElementDeclarations  .
                                      AnnotationTypeElementDeclaration 
AnnotationTypeElementDeclarationsopt ::= AnnotationTypeElementDeclarations .
                                         (472)

ClassDeclaration ::= .NormalClassDeclaration 
ClassDeclaration ::= .EnumDeclaration 
NormalClassDeclaration ::= .ClassModifiersopt class identifier 
                           TypeParametersopt Superopt Interfacesopt ClassBody 
ClassModifiers ::= .ClassModifier 
ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifier ::= .Annotation 
ClassModifier ::= .public 
ClassModifier ::= .protected 
ClassModifier ::= .private 
ClassModifier ::= .abstract 
ClassModifier ::= .static 
ClassModifier ::= .final 
ClassModifier ::= .strictfp 
EnumDeclaration ::= .ClassModifiersopt enum identifier Interfacesopt EnumBody 
InterfaceDeclaration ::= .NormalInterfaceDeclaration 
InterfaceDeclaration ::= .AnnotationTypeDeclaration 
NormalInterfaceDeclaration ::= .InterfaceModifiersopt interface identifier 
                               TypeParametersopt ExtendsInterfacesopt 
                               InterfaceBody 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifier ::= .Annotation 
InterfaceModifier ::= .public 
InterfaceModifier ::= .protected 
InterfaceModifier ::= .private 
InterfaceModifier ::= .abstract 
InterfaceModifier ::= .static 
InterfaceModifier ::= .strictfp 
ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiers ::= .ConstantModifier 
ConstantModifiers ::= .ConstantModifiers ConstantModifier 
ConstantModifier ::= .Annotation 
ConstantModifier ::= .public 
ConstantModifier ::= .static 
ConstantModifier ::= .final 
AbstractMethodModifiers ::= .AbstractMethodModifier 
AbstractMethodModifiers ::= .AbstractMethodModifiers AbstractMethodModifier 
AbstractMethodModifier ::= .Annotations 
AbstractMethodModifier ::= .public 
AbstractMethodModifier ::= .abstract 
AnnotationTypeDeclaration ::= .InterfaceModifiersopt AT interface identifier 
                              AnnotationTypeBody 
AnnotationTypeElementDeclaration ::= .AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
AnnotationTypeElementDeclaration ::= .ConstantDeclaration 
AnnotationTypeElementDeclaration ::= .ClassDeclaration 
AnnotationTypeElementDeclaration ::= .InterfaceDeclaration 
AnnotationTypeElementDeclaration ::= .EnumDeclaration 
AnnotationTypeElementDeclaration ::= .AnnotationTypeDeclaration 
AnnotationTypeElementDeclaration ::= .SEMICOLON 
Annotations ::= .Annotation 
Annotations ::= .Annotations Annotation 
Annotation ::= .NormalAnnotation 
Annotation ::= .MarkerAnnotation 
Annotation ::= .SingleElementAnnotation 
NormalAnnotation ::= .AT TypeName LPAREN ElementValuePairsopt RPAREN 
MarkerAnnotation ::= .AT TypeName 
SingleElementAnnotation ::= .AT TypeName LPAREN ElementValue RPAREN 
AbstractMethodModifiersopt ::= . (473)
AbstractMethodModifiersopt ::= .AbstractMethodModifiers 
ConstantModifiersopt ::= . (475)
ConstantModifiersopt ::= .ConstantModifiers 
InterfaceModifiersopt ::= . (481)
InterfaceModifiersopt ::= .InterfaceModifiers 
ClassModifiersopt ::= . (519)
ClassModifiersopt ::= .ClassModifiers 

*** Shift/reduce conflict on "AT" with rule 481

AnnotationTypeDeclaration ::= .InterfaceModifiersopt AT interface identifier 
                              AnnotationTypeBody 
InterfaceModifiersopt ::= . (481)

*** Reduce/reduce conflict on "IDENTIFIER" between rule 473 and 475

AnnotationTypeElementDeclaration ::= .AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
AbstractMethodModifiersopt ::= . (473)
------------------------------------------------------------------------------
ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= . (475)

*** Reduce/reduce conflict on "short" between rule 473 and 475

AnnotationTypeElementDeclaration ::= .AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
AbstractMethodModifiersopt ::= . (473)
------------------------------------------------------------------------------
ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= . (475)

*** Reduce/reduce conflict on "long" between rule 473 and 475

AnnotationTypeElementDeclaration ::= .AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
AbstractMethodModifiersopt ::= . (473)
------------------------------------------------------------------------------
ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= . (475)

*** Reduce/reduce conflict on "int" between rule 473 and 475

AnnotationTypeElementDeclaration ::= .AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
AbstractMethodModifiersopt ::= . (473)
------------------------------------------------------------------------------
ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= . (475)

*** Reduce/reduce conflict on "float" between rule 473 and 475

AnnotationTypeElementDeclaration ::= .AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
AbstractMethodModifiersopt ::= . (473)
------------------------------------------------------------------------------
ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= . (475)

*** Reduce/reduce conflict on "double" between rule 473 and 475

AnnotationTypeElementDeclaration ::= .AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
AbstractMethodModifiersopt ::= . (473)
------------------------------------------------------------------------------
ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= . (475)

*** Reduce/reduce conflict on "char" between rule 473 and 475

AnnotationTypeElementDeclaration ::= .AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
AbstractMethodModifiersopt ::= . (473)
------------------------------------------------------------------------------
ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= . (475)

*** Reduce/reduce conflict on "byte" between rule 473 and 475

AnnotationTypeElementDeclaration ::= .AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
AbstractMethodModifiersopt ::= . (473)
------------------------------------------------------------------------------
ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= . (475)

*** Reduce/reduce conflict on "boolean" between rule 473 and 475

AnnotationTypeElementDeclaration ::= .AbstractMethodModifiersopt Type 
                                     identifier LPAREN RPAREN DefaultValueopt 
                                     SEMICOLON 
AbstractMethodModifiersopt ::= . (473)
------------------------------------------------------------------------------
ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= . (475)




STATE 228 ----------------------------------------------------------------------
( 184 )

InterfaceBody ::= LBRACE  .InterfaceMemberDeclarationsopt RBRACE 

ClassDeclaration ::= .NormalClassDeclaration 
ClassDeclaration ::= .EnumDeclaration 
NormalClassDeclaration ::= .ClassModifiersopt class identifier 
                           TypeParametersopt Superopt Interfacesopt ClassBody 
ClassModifiers ::= .ClassModifier 
ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifier ::= .Annotation 
ClassModifier ::= .public 
ClassModifier ::= .protected 
ClassModifier ::= .private 
ClassModifier ::= .abstract 
ClassModifier ::= .static 
ClassModifier ::= .final 
ClassModifier ::= .strictfp 
EnumDeclaration ::= .ClassModifiersopt enum identifier Interfacesopt EnumBody 
InterfaceDeclaration ::= .NormalInterfaceDeclaration 
InterfaceDeclaration ::= .AnnotationTypeDeclaration 
NormalInterfaceDeclaration ::= .InterfaceModifiersopt interface identifier 
                               TypeParametersopt ExtendsInterfacesopt 
                               InterfaceBody 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifier ::= .Annotation 
InterfaceModifier ::= .public 
InterfaceModifier ::= .protected 
InterfaceModifier ::= .private 
InterfaceModifier ::= .abstract 
InterfaceModifier ::= .static 
InterfaceModifier ::= .strictfp 
InterfaceMemberDeclarations ::= .InterfaceMemberDeclaration 
InterfaceMemberDeclarations ::= .InterfaceMemberDeclarations 
                                InterfaceMemberDeclaration 
InterfaceMemberDeclaration ::= .ConstantDeclaration 
InterfaceMemberDeclaration ::= .AbstractMethodDeclaration 
InterfaceMemberDeclaration ::= .ClassDeclaration 
InterfaceMemberDeclaration ::= .InterfaceDeclaration 
InterfaceMemberDeclaration ::= .SEMICOLON 
InterfaceMemberDeclaration ::= .ERROR_TOKEN 
ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiers ::= .ConstantModifier 
ConstantModifiers ::= .ConstantModifiers ConstantModifier 
ConstantModifier ::= .Annotation 
ConstantModifier ::= .public 
ConstantModifier ::= .static 
ConstantModifier ::= .final 
AbstractMethodDeclaration ::= .AbstractMethodModifiersopt TypeParametersopt 
                              ResultType MethodDeclarator Throwsopt SEMICOLON 
AbstractMethodModifiers ::= .AbstractMethodModifier 
AbstractMethodModifiers ::= .AbstractMethodModifiers AbstractMethodModifier 
AbstractMethodModifier ::= .Annotations 
AbstractMethodModifier ::= .public 
AbstractMethodModifier ::= .abstract 
AnnotationTypeDeclaration ::= .InterfaceModifiersopt AT interface identifier 
                              AnnotationTypeBody 
Annotations ::= .Annotation 
Annotations ::= .Annotations Annotation 
Annotation ::= .NormalAnnotation 
Annotation ::= .MarkerAnnotation 
Annotation ::= .SingleElementAnnotation 
NormalAnnotation ::= .AT TypeName LPAREN ElementValuePairsopt RPAREN 
MarkerAnnotation ::= .AT TypeName 
SingleElementAnnotation ::= .AT TypeName LPAREN ElementValue RPAREN 
AbstractMethodModifiersopt ::= . (473)
AbstractMethodModifiersopt ::= .AbstractMethodModifiers 
ConstantModifiersopt ::= . (475)
ConstantModifiersopt ::= .ConstantModifiers 
InterfaceMemberDeclarationsopt ::= . (477)
InterfaceMemberDeclarationsopt ::= .InterfaceMemberDeclarations 
InterfaceModifiersopt ::= . (481)
InterfaceModifiersopt ::= .InterfaceModifiers 
ClassModifiersopt ::= . (519)
ClassModifiersopt ::= .ClassModifiers 

*** Shift/reduce conflict on "AT" with rule 481

AnnotationTypeDeclaration ::= .InterfaceModifiersopt AT interface identifier 
                              AnnotationTypeBody 
InterfaceModifiersopt ::= . (481)

*** Reduce/reduce conflict on "IDENTIFIER" between rule 475 and 473

ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= . (475)
------------------------------------------------------------------------------
AbstractMethodDeclaration ::= .AbstractMethodModifiersopt TypeParametersopt 
                              ResultType MethodDeclarator Throwsopt SEMICOLON 
AbstractMethodModifiersopt ::= . (473)

*** Reduce/reduce conflict on "short" between rule 475 and 473

ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= . (475)
------------------------------------------------------------------------------
AbstractMethodDeclaration ::= .AbstractMethodModifiersopt TypeParametersopt 
                              ResultType MethodDeclarator Throwsopt SEMICOLON 
AbstractMethodModifiersopt ::= . (473)

*** Reduce/reduce conflict on "long" between rule 475 and 473

ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= . (475)
------------------------------------------------------------------------------
AbstractMethodDeclaration ::= .AbstractMethodModifiersopt TypeParametersopt 
                              ResultType MethodDeclarator Throwsopt SEMICOLON 
AbstractMethodModifiersopt ::= . (473)

*** Reduce/reduce conflict on "int" between rule 475 and 473

ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= . (475)
------------------------------------------------------------------------------
AbstractMethodDeclaration ::= .AbstractMethodModifiersopt TypeParametersopt 
                              ResultType MethodDeclarator Throwsopt SEMICOLON 
AbstractMethodModifiersopt ::= . (473)

*** Reduce/reduce conflict on "float" between rule 475 and 473

ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= . (475)
------------------------------------------------------------------------------
AbstractMethodDeclaration ::= .AbstractMethodModifiersopt TypeParametersopt 
                              ResultType MethodDeclarator Throwsopt SEMICOLON 
AbstractMethodModifiersopt ::= . (473)

*** Reduce/reduce conflict on "double" between rule 475 and 473

ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= . (475)
------------------------------------------------------------------------------
AbstractMethodDeclaration ::= .AbstractMethodModifiersopt TypeParametersopt 
                              ResultType MethodDeclarator Throwsopt SEMICOLON 
AbstractMethodModifiersopt ::= . (473)

*** Reduce/reduce conflict on "char" between rule 475 and 473

ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= . (475)
------------------------------------------------------------------------------
AbstractMethodDeclaration ::= .AbstractMethodModifiersopt TypeParametersopt 
                              ResultType MethodDeclarator Throwsopt SEMICOLON 
AbstractMethodModifiersopt ::= . (473)

*** Reduce/reduce conflict on "byte" between rule 475 and 473

ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= . (475)
------------------------------------------------------------------------------
AbstractMethodDeclaration ::= .AbstractMethodModifiersopt TypeParametersopt 
                              ResultType MethodDeclarator Throwsopt SEMICOLON 
AbstractMethodModifiersopt ::= . (473)

*** Reduce/reduce conflict on "boolean" between rule 475 and 473

ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= . (475)
------------------------------------------------------------------------------
AbstractMethodDeclaration ::= .AbstractMethodModifiersopt TypeParametersopt 
                              ResultType MethodDeclarator Throwsopt SEMICOLON 
AbstractMethodModifiersopt ::= . (473)




STATE 234 ----------------------------------------------------------------------
( 189 )

EnumConstants ::= EnumConstants  .COMMA EnumConstant 
EnumConstantsopt ::= EnumConstants . (492)

*** Shift/reduce conflict on "COMMA" with rule 492

EnumBody ::= LBRACE  .EnumConstantsopt ,opt EnumBodyDeclarationsopt RBRACE 
EnumConstantsopt ::= EnumConstants . (492)




STATE 246 ----------------------------------------------------------------------
( 205 )

VariableInitializers ::= VariableInitializers  .COMMA VariableInitializer 
VariableInitializersopt ::= VariableInitializers . (464)

*** Shift/reduce conflict on "COMMA" with rule 464

ArrayInitializer ::= LBRACE  .VariableInitializersopt ,opt RBRACE 
VariableInitializersopt ::= VariableInitializers . (464)




STATE 254 ----------------------------------------------------------------------
( 228 )

InterfaceMemberDeclarations ::= InterfaceMemberDeclarations  .
                                InterfaceMemberDeclaration 
InterfaceMemberDeclarationsopt ::= InterfaceMemberDeclarations . (478)

ClassDeclaration ::= .NormalClassDeclaration 
ClassDeclaration ::= .EnumDeclaration 
NormalClassDeclaration ::= .ClassModifiersopt class identifier 
                           TypeParametersopt Superopt Interfacesopt ClassBody 
ClassModifiers ::= .ClassModifier 
ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifier ::= .Annotation 
ClassModifier ::= .public 
ClassModifier ::= .protected 
ClassModifier ::= .private 
ClassModifier ::= .abstract 
ClassModifier ::= .static 
ClassModifier ::= .final 
ClassModifier ::= .strictfp 
EnumDeclaration ::= .ClassModifiersopt enum identifier Interfacesopt EnumBody 
InterfaceDeclaration ::= .NormalInterfaceDeclaration 
InterfaceDeclaration ::= .AnnotationTypeDeclaration 
NormalInterfaceDeclaration ::= .InterfaceModifiersopt interface identifier 
                               TypeParametersopt ExtendsInterfacesopt 
                               InterfaceBody 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifier ::= .Annotation 
InterfaceModifier ::= .public 
InterfaceModifier ::= .protected 
InterfaceModifier ::= .private 
InterfaceModifier ::= .abstract 
InterfaceModifier ::= .static 
InterfaceModifier ::= .strictfp 
InterfaceMemberDeclaration ::= .ConstantDeclaration 
InterfaceMemberDeclaration ::= .AbstractMethodDeclaration 
InterfaceMemberDeclaration ::= .ClassDeclaration 
InterfaceMemberDeclaration ::= .InterfaceDeclaration 
InterfaceMemberDeclaration ::= .SEMICOLON 
InterfaceMemberDeclaration ::= .ERROR_TOKEN 
ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiers ::= .ConstantModifier 
ConstantModifiers ::= .ConstantModifiers ConstantModifier 
ConstantModifier ::= .Annotation 
ConstantModifier ::= .public 
ConstantModifier ::= .static 
ConstantModifier ::= .final 
AbstractMethodDeclaration ::= .AbstractMethodModifiersopt TypeParametersopt 
                              ResultType MethodDeclarator Throwsopt SEMICOLON 
AbstractMethodModifiers ::= .AbstractMethodModifier 
AbstractMethodModifiers ::= .AbstractMethodModifiers AbstractMethodModifier 
AbstractMethodModifier ::= .Annotations 
AbstractMethodModifier ::= .public 
AbstractMethodModifier ::= .abstract 
AnnotationTypeDeclaration ::= .InterfaceModifiersopt AT interface identifier 
                              AnnotationTypeBody 
Annotations ::= .Annotation 
Annotations ::= .Annotations Annotation 
Annotation ::= .NormalAnnotation 
Annotation ::= .MarkerAnnotation 
Annotation ::= .SingleElementAnnotation 
NormalAnnotation ::= .AT TypeName LPAREN ElementValuePairsopt RPAREN 
MarkerAnnotation ::= .AT TypeName 
SingleElementAnnotation ::= .AT TypeName LPAREN ElementValue RPAREN 
AbstractMethodModifiersopt ::= . (473)
AbstractMethodModifiersopt ::= .AbstractMethodModifiers 
ConstantModifiersopt ::= . (475)
ConstantModifiersopt ::= .ConstantModifiers 
InterfaceModifiersopt ::= . (481)
InterfaceModifiersopt ::= .InterfaceModifiers 
ClassModifiersopt ::= . (519)
ClassModifiersopt ::= .ClassModifiers 

*** Shift/reduce conflict on "AT" with rule 481

AnnotationTypeDeclaration ::= .InterfaceModifiersopt AT interface identifier 
                              AnnotationTypeBody 
InterfaceModifiersopt ::= . (481)

*** Reduce/reduce conflict on "IDENTIFIER" between rule 475 and 473

ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= . (475)
------------------------------------------------------------------------------
AbstractMethodDeclaration ::= .AbstractMethodModifiersopt TypeParametersopt 
                              ResultType MethodDeclarator Throwsopt SEMICOLON 
AbstractMethodModifiersopt ::= . (473)

*** Reduce/reduce conflict on "short" between rule 475 and 473

ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= . (475)
------------------------------------------------------------------------------
AbstractMethodDeclaration ::= .AbstractMethodModifiersopt TypeParametersopt 
                              ResultType MethodDeclarator Throwsopt SEMICOLON 
AbstractMethodModifiersopt ::= . (473)

*** Reduce/reduce conflict on "long" between rule 475 and 473

ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= . (475)
------------------------------------------------------------------------------
AbstractMethodDeclaration ::= .AbstractMethodModifiersopt TypeParametersopt 
                              ResultType MethodDeclarator Throwsopt SEMICOLON 
AbstractMethodModifiersopt ::= . (473)

*** Reduce/reduce conflict on "int" between rule 475 and 473

ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= . (475)
------------------------------------------------------------------------------
AbstractMethodDeclaration ::= .AbstractMethodModifiersopt TypeParametersopt 
                              ResultType MethodDeclarator Throwsopt SEMICOLON 
AbstractMethodModifiersopt ::= . (473)

*** Reduce/reduce conflict on "float" between rule 475 and 473

ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= . (475)
------------------------------------------------------------------------------
AbstractMethodDeclaration ::= .AbstractMethodModifiersopt TypeParametersopt 
                              ResultType MethodDeclarator Throwsopt SEMICOLON 
AbstractMethodModifiersopt ::= . (473)

*** Reduce/reduce conflict on "double" between rule 475 and 473

ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= . (475)
------------------------------------------------------------------------------
AbstractMethodDeclaration ::= .AbstractMethodModifiersopt TypeParametersopt 
                              ResultType MethodDeclarator Throwsopt SEMICOLON 
AbstractMethodModifiersopt ::= . (473)

*** Reduce/reduce conflict on "char" between rule 475 and 473

ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= . (475)
------------------------------------------------------------------------------
AbstractMethodDeclaration ::= .AbstractMethodModifiersopt TypeParametersopt 
                              ResultType MethodDeclarator Throwsopt SEMICOLON 
AbstractMethodModifiersopt ::= . (473)

*** Reduce/reduce conflict on "byte" between rule 475 and 473

ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= . (475)
------------------------------------------------------------------------------
AbstractMethodDeclaration ::= .AbstractMethodModifiersopt TypeParametersopt 
                              ResultType MethodDeclarator Throwsopt SEMICOLON 
AbstractMethodModifiersopt ::= . (473)

*** Reduce/reduce conflict on "boolean" between rule 475 and 473

ConstantDeclaration ::= .ConstantModifiersopt Type VariableDeclarators 
ConstantModifiersopt ::= . (475)
------------------------------------------------------------------------------
AbstractMethodDeclaration ::= .AbstractMethodModifiersopt TypeParametersopt 
                              ResultType MethodDeclarator Throwsopt SEMICOLON 
AbstractMethodModifiersopt ::= . (473)




STATE 258 ----------------------------------------------------------------------
( 234 )

EnumConstants ::= EnumConstants COMMA  .EnumConstant 

identifier ::= .IDENTIFIER 
EnumConstant ::= .Annotationsopt identifier Argumentsopt ClassBodyopt 
Annotations ::= .Annotation 
Annotations ::= .Annotations Annotation 
Annotation ::= .NormalAnnotation 
Annotation ::= .MarkerAnnotation 
Annotation ::= .SingleElementAnnotation 
NormalAnnotation ::= .AT TypeName LPAREN ElementValuePairsopt RPAREN 
MarkerAnnotation ::= .AT TypeName 
SingleElementAnnotation ::= .AT TypeName LPAREN ElementValue RPAREN 
EnumConstant ::= .identifier 
Annotationsopt ::= . (521)
Annotationsopt ::= .Annotations 

*** Shift/reduce conflict on "IDENTIFIER" with rule 521

EnumConstant ::= .Annotationsopt identifier Argumentsopt ClassBodyopt 
Annotationsopt ::= . (521)




STATE 259 ----------------------------------------------------------------------
( 236 277 301 368 369 )

ClassBody ::= LBRACE  .ClassBodyDeclarationsopt RBRACE 

ClassDeclaration ::= .NormalClassDeclaration 
ClassDeclaration ::= .EnumDeclaration 
NormalClassDeclaration ::= .ClassModifiersopt class identifier 
                           TypeParametersopt Superopt Interfacesopt ClassBody 
ClassModifiers ::= .ClassModifier 
ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifier ::= .Annotation 
ClassModifier ::= .public 
ClassModifier ::= .protected 
ClassModifier ::= .private 
ClassModifier ::= .abstract 
ClassModifier ::= .static 
ClassModifier ::= .final 
ClassModifier ::= .strictfp 
ClassBodyDeclarations ::= .ClassBodyDeclaration 
ClassBodyDeclarations ::= .ClassBodyDeclarations ClassBodyDeclaration 
ClassBodyDeclaration ::= .ClassMemberDeclaration 
ClassBodyDeclaration ::= .InstanceInitializer 
ClassBodyDeclaration ::= .StaticInitializer 
ClassBodyDeclaration ::= .ConstructorDeclaration 
ClassBodyDeclaration ::= .ERROR_TOKEN 
ClassMemberDeclaration ::= .FieldDeclaration 
ClassMemberDeclaration ::= .MethodDeclaration 
ClassMemberDeclaration ::= .ClassDeclaration 
ClassMemberDeclaration ::= .InterfaceDeclaration 
ClassMemberDeclaration ::= .SEMICOLON 
FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiers ::= .FieldModifier 
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifier ::= .Annotation 
FieldModifier ::= .public 
FieldModifier ::= .protected 
FieldModifier ::= .private 
FieldModifier ::= .static 
FieldModifier ::= .final 
FieldModifier ::= .transient 
FieldModifier ::= .volatile 
MethodDeclaration ::= .MethodHeader MethodBody 
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiers ::= .MethodModifier 
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifier ::= .Annotations 
MethodModifier ::= .public 
MethodModifier ::= .protected 
MethodModifier ::= .private 
MethodModifier ::= .abstract 
MethodModifier ::= .static 
MethodModifier ::= .final 
MethodModifier ::= .synchronized 
MethodModifier ::= .native 
MethodModifier ::= .strictfp 
InstanceInitializer ::= .Block 
StaticInitializer ::= .static Block 
ConstructorDeclaration ::= .ConstructorModifiersopt ConstructorDeclarator 
                           Throwsopt ConstructorBody 
ConstructorModifiers ::= .ConstructorModifier 
ConstructorModifiers ::= .ConstructorModifiers ConstructorModifier 
ConstructorModifier ::= .Annotations 
ConstructorModifier ::= .public 
ConstructorModifier ::= .protected 
ConstructorModifier ::= .private 
EnumDeclaration ::= .ClassModifiersopt enum identifier Interfacesopt EnumBody 
InterfaceDeclaration ::= .NormalInterfaceDeclaration 
InterfaceDeclaration ::= .AnnotationTypeDeclaration 
NormalInterfaceDeclaration ::= .InterfaceModifiersopt interface identifier 
                               TypeParametersopt ExtendsInterfacesopt 
                               InterfaceBody 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifier ::= .Annotation 
InterfaceModifier ::= .public 
InterfaceModifier ::= .protected 
InterfaceModifier ::= .private 
InterfaceModifier ::= .abstract 
InterfaceModifier ::= .static 
InterfaceModifier ::= .strictfp 
AnnotationTypeDeclaration ::= .InterfaceModifiersopt AT interface identifier 
                              AnnotationTypeBody 
Annotations ::= .Annotation 
Annotations ::= .Annotations Annotation 
Annotation ::= .NormalAnnotation 
Annotation ::= .MarkerAnnotation 
Annotation ::= .SingleElementAnnotation 
NormalAnnotation ::= .AT TypeName LPAREN ElementValuePairsopt RPAREN 
MarkerAnnotation ::= .AT TypeName 
SingleElementAnnotation ::= .AT TypeName LPAREN ElementValue RPAREN 
Block ::= .LBRACE BlockStatementsopt RBRACE 
InterfaceModifiersopt ::= . (481)
InterfaceModifiersopt ::= .InterfaceModifiers 
ConstructorModifiersopt ::= . (499)
ConstructorModifiersopt ::= .ConstructorModifiers 
MethodModifiersopt ::= . (507)
MethodModifiersopt ::= .MethodModifiers 
FieldModifiersopt ::= . (509)
FieldModifiersopt ::= .FieldModifiers 
ClassBodyDeclarationsopt ::= . (511)
ClassBodyDeclarationsopt ::= .ClassBodyDeclarations 
ClassModifiersopt ::= . (519)
ClassModifiersopt ::= .ClassModifiers 

*** Shift/reduce conflict on "AT" with rule 481

AnnotationTypeDeclaration ::= .InterfaceModifiersopt AT interface identifier 
                              AnnotationTypeBody 
InterfaceModifiersopt ::= . (481)

*** Reduce/reduce conflict on "short" between rule 507 and 509

MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= . (507)
------------------------------------------------------------------------------
FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= . (509)

*** Reduce/reduce conflict on "long" between rule 507 and 509

MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= . (507)
------------------------------------------------------------------------------
FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= . (509)

*** Reduce/reduce conflict on "int" between rule 507 and 509

MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= . (507)
------------------------------------------------------------------------------
FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= . (509)

*** Reduce/reduce conflict on "float" between rule 507 and 509

MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= . (507)
------------------------------------------------------------------------------
FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= . (509)

*** Reduce/reduce conflict on "double" between rule 507 and 509

MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= . (507)
------------------------------------------------------------------------------
FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= . (509)

*** Reduce/reduce conflict on "char" between rule 507 and 509

MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= . (507)
------------------------------------------------------------------------------
FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= . (509)

*** Reduce/reduce conflict on "byte" between rule 507 and 509

MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= . (507)
------------------------------------------------------------------------------
FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= . (509)

*** Reduce/reduce conflict on "boolean" between rule 507 and 509

MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= . (507)
------------------------------------------------------------------------------
FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= . (509)

*** Reduce/reduce conflict on "IDENTIFIER" between rule 507 and 499

MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= . (507)
------------------------------------------------------------------------------
ConstructorDeclaration ::= .ConstructorModifiersopt ConstructorDeclarator 
                           Throwsopt ConstructorBody 
ConstructorModifiersopt ::= . (499)

*** Reduce/reduce conflict on "IDENTIFIER" between rule 507 and 509

MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= . (507)
------------------------------------------------------------------------------
FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= . (509)

*** Reduce/reduce conflict on "LESS" between rule 507 and 499

MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= . (507)
------------------------------------------------------------------------------
ConstructorDeclaration ::= .ConstructorModifiersopt ConstructorDeclarator 
                           Throwsopt ConstructorBody 
ConstructorModifiersopt ::= . (499)




STATE 276 ----------------------------------------------------------------------
( 256 )

EnumBodyDeclarations ::= SEMICOLON  .ClassBodyDeclarationsopt 

ClassDeclaration ::= .NormalClassDeclaration 
ClassDeclaration ::= .EnumDeclaration 
NormalClassDeclaration ::= .ClassModifiersopt class identifier 
                           TypeParametersopt Superopt Interfacesopt ClassBody 
ClassModifiers ::= .ClassModifier 
ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifier ::= .Annotation 
ClassModifier ::= .public 
ClassModifier ::= .protected 
ClassModifier ::= .private 
ClassModifier ::= .abstract 
ClassModifier ::= .static 
ClassModifier ::= .final 
ClassModifier ::= .strictfp 
ClassBodyDeclarations ::= .ClassBodyDeclaration 
ClassBodyDeclarations ::= .ClassBodyDeclarations ClassBodyDeclaration 
ClassBodyDeclaration ::= .ClassMemberDeclaration 
ClassBodyDeclaration ::= .InstanceInitializer 
ClassBodyDeclaration ::= .StaticInitializer 
ClassBodyDeclaration ::= .ConstructorDeclaration 
ClassBodyDeclaration ::= .ERROR_TOKEN 
ClassMemberDeclaration ::= .FieldDeclaration 
ClassMemberDeclaration ::= .MethodDeclaration 
ClassMemberDeclaration ::= .ClassDeclaration 
ClassMemberDeclaration ::= .InterfaceDeclaration 
ClassMemberDeclaration ::= .SEMICOLON 
FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiers ::= .FieldModifier 
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifier ::= .Annotation 
FieldModifier ::= .public 
FieldModifier ::= .protected 
FieldModifier ::= .private 
FieldModifier ::= .static 
FieldModifier ::= .final 
FieldModifier ::= .transient 
FieldModifier ::= .volatile 
MethodDeclaration ::= .MethodHeader MethodBody 
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiers ::= .MethodModifier 
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifier ::= .Annotations 
MethodModifier ::= .public 
MethodModifier ::= .protected 
MethodModifier ::= .private 
MethodModifier ::= .abstract 
MethodModifier ::= .static 
MethodModifier ::= .final 
MethodModifier ::= .synchronized 
MethodModifier ::= .native 
MethodModifier ::= .strictfp 
InstanceInitializer ::= .Block 
StaticInitializer ::= .static Block 
ConstructorDeclaration ::= .ConstructorModifiersopt ConstructorDeclarator 
                           Throwsopt ConstructorBody 
ConstructorModifiers ::= .ConstructorModifier 
ConstructorModifiers ::= .ConstructorModifiers ConstructorModifier 
ConstructorModifier ::= .Annotations 
ConstructorModifier ::= .public 
ConstructorModifier ::= .protected 
ConstructorModifier ::= .private 
EnumDeclaration ::= .ClassModifiersopt enum identifier Interfacesopt EnumBody 
InterfaceDeclaration ::= .NormalInterfaceDeclaration 
InterfaceDeclaration ::= .AnnotationTypeDeclaration 
NormalInterfaceDeclaration ::= .InterfaceModifiersopt interface identifier 
                               TypeParametersopt ExtendsInterfacesopt 
                               InterfaceBody 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifier ::= .Annotation 
InterfaceModifier ::= .public 
InterfaceModifier ::= .protected 
InterfaceModifier ::= .private 
InterfaceModifier ::= .abstract 
InterfaceModifier ::= .static 
InterfaceModifier ::= .strictfp 
AnnotationTypeDeclaration ::= .InterfaceModifiersopt AT interface identifier 
                              AnnotationTypeBody 
Annotations ::= .Annotation 
Annotations ::= .Annotations Annotation 
Annotation ::= .NormalAnnotation 
Annotation ::= .MarkerAnnotation 
Annotation ::= .SingleElementAnnotation 
NormalAnnotation ::= .AT TypeName LPAREN ElementValuePairsopt RPAREN 
MarkerAnnotation ::= .AT TypeName 
SingleElementAnnotation ::= .AT TypeName LPAREN ElementValue RPAREN 
Block ::= .LBRACE BlockStatementsopt RBRACE 
InterfaceModifiersopt ::= . (481)
InterfaceModifiersopt ::= .InterfaceModifiers 
ConstructorModifiersopt ::= . (499)
ConstructorModifiersopt ::= .ConstructorModifiers 
MethodModifiersopt ::= . (507)
MethodModifiersopt ::= .MethodModifiers 
FieldModifiersopt ::= . (509)
FieldModifiersopt ::= .FieldModifiers 
ClassBodyDeclarationsopt ::= . (511)
ClassBodyDeclarationsopt ::= .ClassBodyDeclarations 
ClassModifiersopt ::= . (519)
ClassModifiersopt ::= .ClassModifiers 

*** Shift/reduce conflict on "AT" with rule 481

AnnotationTypeDeclaration ::= .InterfaceModifiersopt AT interface identifier 
                              AnnotationTypeBody 
InterfaceModifiersopt ::= . (481)

*** Reduce/reduce conflict on "short" between rule 507 and 509

MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= . (507)
------------------------------------------------------------------------------
FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= . (509)

*** Reduce/reduce conflict on "long" between rule 507 and 509

MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= . (507)
------------------------------------------------------------------------------
FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= . (509)

*** Reduce/reduce conflict on "int" between rule 507 and 509

MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= . (507)
------------------------------------------------------------------------------
FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= . (509)

*** Reduce/reduce conflict on "float" between rule 507 and 509

MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= . (507)
------------------------------------------------------------------------------
FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= . (509)

*** Reduce/reduce conflict on "double" between rule 507 and 509

MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= . (507)
------------------------------------------------------------------------------
FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= . (509)

*** Reduce/reduce conflict on "char" between rule 507 and 509

MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= . (507)
------------------------------------------------------------------------------
FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= . (509)

*** Reduce/reduce conflict on "byte" between rule 507 and 509

MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= . (507)
------------------------------------------------------------------------------
FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= . (509)

*** Reduce/reduce conflict on "boolean" between rule 507 and 509

MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= . (507)
------------------------------------------------------------------------------
FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= . (509)

*** Reduce/reduce conflict on "IDENTIFIER" between rule 507 and 499

MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= . (507)
------------------------------------------------------------------------------
ConstructorDeclaration ::= .ConstructorModifiersopt ConstructorDeclarator 
                           Throwsopt ConstructorBody 
ConstructorModifiersopt ::= . (499)

*** Reduce/reduce conflict on "IDENTIFIER" between rule 507 and 509

MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= . (507)
------------------------------------------------------------------------------
FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= . (509)

*** Reduce/reduce conflict on "LESS" between rule 507 and 499

MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= . (507)
------------------------------------------------------------------------------
ConstructorDeclaration ::= .ConstructorModifiersopt ConstructorDeclarator 
                           Throwsopt ConstructorBody 
ConstructorModifiersopt ::= . (499)




STATE 282 ----------------------------------------------------------------------
( 259 276 282 285 291 297 313 319 339 361 396 402 404 408 409 438 444 446 450 
  451 462 472 473 474 480 482 )

Block ::= LBRACE  .BlockStatementsopt RBRACE 

identifier ::= .IDENTIFIER 
Type ::= .PrimitiveType 
Type ::= .ReferenceType 
PrimitiveType ::= .NumericType 
PrimitiveType ::= .boolean 
NumericType ::= .IntegralType 
NumericType ::= .FloatingPointType 
IntegralType ::= .byte 
IntegralType ::= .short 
IntegralType ::= .int 
IntegralType ::= .long 
IntegralType ::= .char 
FloatingPointType ::= .float 
FloatingPointType ::= .double 
ReferenceType ::= .ClassOrInterfaceType 
ReferenceType ::= .TypeVariable 
ReferenceType ::= .ArrayType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= .identifier 
TypeName ::= .TypeName DOT identifier 
ClassName ::= .TypeName 
TypeVariable ::= .identifier 
ArrayType ::= .Type LBRACKET RBRACKET 
ExpressionName ::= .identifier 
ExpressionName ::= .AmbiguousName DOT identifier 
MethodName ::= .identifier 
MethodName ::= .AmbiguousName DOT identifier 
AmbiguousName ::= .identifier 
AmbiguousName ::= .AmbiguousName DOT identifier 
ClassDeclaration ::= .NormalClassDeclaration 
ClassDeclaration ::= .EnumDeclaration 
NormalClassDeclaration ::= .ClassModifiersopt class identifier 
                           TypeParametersopt Superopt Interfacesopt ClassBody 
ClassModifiers ::= .ClassModifier 
ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifier ::= .Annotation 
ClassModifier ::= .public 
ClassModifier ::= .protected 
ClassModifier ::= .private 
ClassModifier ::= .abstract 
ClassModifier ::= .static 
ClassModifier ::= .final 
ClassModifier ::= .strictfp 
VariableModifiers ::= .VariableModifier 
VariableModifiers ::= .VariableModifiers VariableModifier 
VariableModifier ::= .final 
VariableModifier ::= .Annotations 
EnumDeclaration ::= .ClassModifiersopt enum identifier Interfacesopt EnumBody 
Annotations ::= .Annotation 
Annotations ::= .Annotations Annotation 
Annotation ::= .NormalAnnotation 
Annotation ::= .MarkerAnnotation 
Annotation ::= .SingleElementAnnotation 
NormalAnnotation ::= .AT TypeName LPAREN ElementValuePairsopt RPAREN 
MarkerAnnotation ::= .AT TypeName 
SingleElementAnnotation ::= .AT TypeName LPAREN ElementValue RPAREN 
Block ::= .LBRACE BlockStatementsopt RBRACE 
BlockStatements ::= .BlockStatement 
BlockStatements ::= .BlockStatements BlockStatement 
BlockStatement ::= .LocalVariableDeclarationStatement 
BlockStatement ::= .ClassDeclaration 
BlockStatement ::= .Statement 
LocalVariableDeclarationStatement ::= .LocalVariableDeclaration SEMICOLON 
LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
Statement ::= .StatementWithoutTrailingSubstatement 
Statement ::= .LabeledStatement 
Statement ::= .IfThenStatement 
Statement ::= .IfThenElseStatement 
Statement ::= .WhileStatement 
Statement ::= .ForStatement 
StatementWithoutTrailingSubstatement ::= .Block 
StatementWithoutTrailingSubstatement ::= .EmptyStatement 
StatementWithoutTrailingSubstatement ::= .ExpressionStatement 
StatementWithoutTrailingSubstatement ::= .AssertStatement 
StatementWithoutTrailingSubstatement ::= .SwitchStatement 
StatementWithoutTrailingSubstatement ::= .DoStatement 
StatementWithoutTrailingSubstatement ::= .BreakStatement 
StatementWithoutTrailingSubstatement ::= .ContinueStatement 
StatementWithoutTrailingSubstatement ::= .ReturnStatement 
StatementWithoutTrailingSubstatement ::= .SynchronizedStatement 
StatementWithoutTrailingSubstatement ::= .ThrowStatement 
StatementWithoutTrailingSubstatement ::= .TryStatement 
IfThenStatement ::= .if LPAREN Expression RPAREN Statement 
IfThenElseStatement ::= .if LPAREN Expression RPAREN StatementNoShortIf else 
                        Statement 
EmptyStatement ::= .SEMICOLON 
EmptyStatement ::= .ERROR_TOKEN 
LabeledStatement ::= .identifier COLON Statement 
ExpressionStatement ::= .StatementExpression SEMICOLON 
StatementExpression ::= .Assignment 
StatementExpression ::= .PreIncrementExpression 
StatementExpression ::= .PreDecrementExpression 
StatementExpression ::= .PostIncrementExpression 
StatementExpression ::= .PostDecrementExpression 
StatementExpression ::= .MethodInvocation 
StatementExpression ::= .ClassInstanceCreationExpression 
AssertStatement ::= .assert Expression SEMICOLON 
AssertStatement ::= .assert Expression COLON Expression SEMICOLON 
SwitchStatement ::= .switch LPAREN Expression RPAREN SwitchBlock 
WhileStatement ::= .while LPAREN Expression RPAREN Statement 
DoStatement ::= .do Statement while LPAREN Expression RPAREN SEMICOLON 
ForStatement ::= .BasicForStatement 
ForStatement ::= .EnhancedForStatement 
BasicForStatement ::= .for LPAREN ForInitopt SEMICOLON Expressionopt SEMICOLON 
                      ForUpdateopt RPAREN Statement 
EnhancedForStatement ::= .for LPAREN FormalParameter COLON Expression RPAREN 
                         Statement 
BreakStatement ::= .break identifieropt SEMICOLON 
ContinueStatement ::= .continue identifieropt SEMICOLON 
ReturnStatement ::= .return Expressionopt SEMICOLON 
ThrowStatement ::= .throw Expression SEMICOLON 
SynchronizedStatement ::= .synchronized LPAREN Expression RPAREN Block 
TryStatement ::= .try Block Catches 
TryStatement ::= .try Block Catchesopt Finally 
Primary ::= .PrimaryNoNewArray 
Primary ::= .ArrayCreationExpression 
PrimaryNoNewArray ::= .Literal 
PrimaryNoNewArray ::= .Type DOT class 
PrimaryNoNewArray ::= .void DOT class 
PrimaryNoNewArray ::= .this 
PrimaryNoNewArray ::= .ClassName DOT this 
PrimaryNoNewArray ::= .LPAREN Expression RPAREN 
PrimaryNoNewArray ::= .ClassInstanceCreationExpression 
PrimaryNoNewArray ::= .FieldAccess 
PrimaryNoNewArray ::= .MethodInvocation 
PrimaryNoNewArray ::= .ArrayAccess 
Literal ::= .IntegerLiteral 
Literal ::= .LongLiteral 
Literal ::= .FloatingPointLiteral 
Literal ::= .DoubleLiteral 
Literal ::= .BooleanLiteral 
Literal ::= .CharacterLiteral 
Literal ::= .StringLiteral 
Literal ::= .null 
BooleanLiteral ::= .true 
BooleanLiteral ::= .false 
ClassInstanceCreationExpression ::= .new TypeArgumentsopt ClassOrInterfaceType 
                                    TypeArgumentsopt LPAREN ArgumentListopt 
                                    RPAREN ClassBodyopt 
ClassInstanceCreationExpression ::= .Primary DOT new TypeArgumentsopt 
                                    identifier TypeArgumentsopt LPAREN 
                                    ArgumentListopt RPAREN ClassBodyopt 
ClassInstanceCreationExpression ::= .name DOT new TypeArgumentsopt identifier 
                                    TypeArgumentsopt LPAREN ArgumentListopt 
                                    RPAREN ClassBodyopt 
ArrayCreationExpression ::= .new PrimitiveType DimExprs Dimsopt 
ArrayCreationExpression ::= .new ClassOrInterfaceType DimExprs Dimsopt 
ArrayCreationExpression ::= .new PrimitiveType Dims ArrayInitializer 
ArrayCreationExpression ::= .new ClassOrInterfaceType Dims ArrayInitializer 
FieldAccess ::= .Primary DOT identifier 
FieldAccess ::= .super DOT identifier 
FieldAccess ::= .ClassName DOT super DOT identifier 
MethodInvocation ::= .MethodName LPAREN ArgumentListopt RPAREN 
MethodInvocation ::= .Primary DOT TypeArgumentsopt identifier LPAREN 
                     ArgumentListopt RPAREN 
MethodInvocation ::= .super DOT TypeArgumentsopt identifier LPAREN 
                     ArgumentListopt RPAREN 
MethodInvocation ::= .ClassName DOT super DOT TypeArgumentsopt identifier 
                     LPAREN ArgumentListopt RPAREN 
MethodInvocation ::= .TypeName DOT TypeArguments identifier LPAREN 
                     ArgumentListopt RPAREN 
ArrayAccess ::= .ExpressionName LBRACKET Expression RBRACKET 
ArrayAccess ::= .PrimaryNoNewArray LBRACKET Expression RBRACKET 
PostfixExpression ::= .Primary 
PostfixExpression ::= .ExpressionName 
PostfixExpression ::= .PostIncrementExpression 
PostfixExpression ::= .PostDecrementExpression 
PostIncrementExpression ::= .PostfixExpression PLUS_PLUS 
PostDecrementExpression ::= .PostfixExpression MINUS_MINUS 
PreIncrementExpression ::= .PLUS_PLUS UnaryExpression 
PreDecrementExpression ::= .MINUS_MINUS UnaryExpression 
Assignment ::= .LeftHandSide AssignmentOperator AssignmentExpression 
LeftHandSide ::= .ExpressionName 
LeftHandSide ::= .FieldAccess 
LeftHandSide ::= .ArrayAccess 
VariableModifiersopt ::= . (461)
VariableModifiersopt ::= .VariableModifiers 
BlockStatementsopt ::= . (495)
BlockStatementsopt ::= .BlockStatements 
ClassModifiersopt ::= . (519)
ClassModifiersopt ::= .ClassModifiers 

*** Shift/reduce conflict on "boolean" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "char" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "long" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "int" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "short" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "byte" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "double" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "float" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "IDENTIFIER" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)




STATE 286 ----------------------------------------------------------------------
( 259 276 297 )

MethodModifier ::= Annotations . (137)
ConstructorModifier ::= Annotations . (161)
Annotations ::= Annotations  .Annotation 

Annotation ::= .NormalAnnotation 
Annotation ::= .MarkerAnnotation 
Annotation ::= .SingleElementAnnotation 
NormalAnnotation ::= .AT TypeName LPAREN ElementValuePairsopt RPAREN 
MarkerAnnotation ::= .AT TypeName 
SingleElementAnnotation ::= .AT TypeName LPAREN ElementValue RPAREN 

*** Shift/reduce conflict on "AT" with rule 137

MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= Annotations . (137)

*** Shift/reduce conflict on "AT" with rule 161

ConstructorModifiers ::= .ConstructorModifiers ConstructorModifier 
ConstructorModifiers ::= .ConstructorModifier 
ConstructorModifier ::= Annotations . (161)

*** Reduce/reduce conflict on "IDENTIFIER" between rule 137 and 161

MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= Annotations . (137)
------------------------------------------------------------------------------
ConstructorDeclaration ::= .ConstructorModifiersopt ConstructorDeclarator 
                           Throwsopt ConstructorBody 
ConstructorModifiersopt ::= .ConstructorModifiers 
ConstructorModifiers ::= .ConstructorModifier 
ConstructorModifier ::= Annotations . (161)

*** Reduce/reduce conflict on "public" between rule 137 and 161

MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= Annotations . (137)
------------------------------------------------------------------------------
ConstructorModifiers ::= .ConstructorModifiers ConstructorModifier 
ConstructorModifiers ::= .ConstructorModifier 
ConstructorModifier ::= Annotations . (161)

*** Reduce/reduce conflict on "protected" between rule 137 and 161

MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= Annotations . (137)
------------------------------------------------------------------------------
ConstructorModifiers ::= .ConstructorModifiers ConstructorModifier 
ConstructorModifiers ::= .ConstructorModifier 
ConstructorModifier ::= Annotations . (161)

*** Reduce/reduce conflict on "private" between rule 137 and 161

MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= Annotations . (137)
------------------------------------------------------------------------------
ConstructorModifiers ::= .ConstructorModifiers ConstructorModifier 
ConstructorModifiers ::= .ConstructorModifier 
ConstructorModifier ::= Annotations . (161)

*** Reduce/reduce conflict on "LESS" between rule 137 and 161

MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= Annotations . (137)
------------------------------------------------------------------------------
ConstructorDeclaration ::= .ConstructorModifiersopt ConstructorDeclarator 
                           Throwsopt ConstructorBody 
ConstructorModifiersopt ::= .ConstructorModifiers 
ConstructorModifiers ::= .ConstructorModifier 
ConstructorModifier ::= Annotations . (161)




STATE 289 ----------------------------------------------------------------------
( 259 276 297 )

ClassModifier ::= final . (78)
FieldModifier ::= final . (116)
MethodModifier ::= final . (143)

*** Reduce/reduce conflict on "IDENTIFIER" between rule 116 and 143

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= final . (116)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= final . (143)

*** Reduce/reduce conflict on "strictfp" between rule 78 and 143

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= final . (78)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= final . (143)

*** Reduce/reduce conflict on "static" between rule 78 and 143

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= final . (78)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= final . (143)

*** Reduce/reduce conflict on "static" between rule 78 and 116

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= final . (78)
------------------------------------------------------------------------------
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= final . (116)

*** Reduce/reduce conflict on "short" between rule 116 and 143

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= final . (116)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= final . (143)

*** Reduce/reduce conflict on "public" between rule 78 and 143

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= final . (78)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= final . (143)

*** Reduce/reduce conflict on "public" between rule 78 and 116

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= final . (78)
------------------------------------------------------------------------------
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= final . (116)

*** Reduce/reduce conflict on "protected" between rule 78 and 143

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= final . (78)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= final . (143)

*** Reduce/reduce conflict on "protected" between rule 78 and 116

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= final . (78)
------------------------------------------------------------------------------
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= final . (116)

*** Reduce/reduce conflict on "private" between rule 78 and 143

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= final . (78)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= final . (143)

*** Reduce/reduce conflict on "private" between rule 78 and 116

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= final . (78)
------------------------------------------------------------------------------
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= final . (116)

*** Reduce/reduce conflict on "long" between rule 116 and 143

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= final . (116)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= final . (143)

*** Reduce/reduce conflict on "int" between rule 116 and 143

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= final . (116)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= final . (143)

*** Reduce/reduce conflict on "float" between rule 116 and 143

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= final . (116)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= final . (143)

*** Reduce/reduce conflict on "final" between rule 78 and 143

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= final . (78)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= final . (143)

*** Reduce/reduce conflict on "final" between rule 78 and 116

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= final . (78)
------------------------------------------------------------------------------
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= final . (116)

*** Reduce/reduce conflict on "double" between rule 116 and 143

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= final . (116)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= final . (143)

*** Reduce/reduce conflict on "char" between rule 116 and 143

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= final . (116)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= final . (143)

*** Reduce/reduce conflict on "byte" between rule 116 and 143

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= final . (116)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= final . (143)

*** Reduce/reduce conflict on "boolean" between rule 116 and 143

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= final . (116)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= final . (143)

*** Reduce/reduce conflict on "abstract" between rule 78 and 143

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= final . (78)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= final . (143)

*** Reduce/reduce conflict on "AT" between rule 78 and 143

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= final . (78)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= final . (143)

*** Reduce/reduce conflict on "AT" between rule 78 and 116

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= final . (78)
------------------------------------------------------------------------------
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= final . (116)




STATE 290 ----------------------------------------------------------------------
( 259 276 297 )

ClassModifier ::= strictfp . (79)
MethodModifier ::= strictfp . (146)
InterfaceModifier ::= strictfp . (187)

*** Reduce/reduce conflict on "final" between rule 79 and 146

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= strictfp . (79)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= strictfp . (146)

*** Reduce/reduce conflict on "strictfp" between rule 79 and 187

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= strictfp . (79)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= strictfp . (187)

*** Reduce/reduce conflict on "strictfp" between rule 79 and 146

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= strictfp . (79)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= strictfp . (146)

*** Reduce/reduce conflict on "static" between rule 79 and 187

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= strictfp . (79)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= strictfp . (187)

*** Reduce/reduce conflict on "static" between rule 79 and 146

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= strictfp . (79)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= strictfp . (146)

*** Reduce/reduce conflict on "public" between rule 79 and 187

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= strictfp . (79)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= strictfp . (187)

*** Reduce/reduce conflict on "public" between rule 79 and 146

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= strictfp . (79)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= strictfp . (146)

*** Reduce/reduce conflict on "protected" between rule 79 and 187

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= strictfp . (79)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= strictfp . (187)

*** Reduce/reduce conflict on "protected" between rule 79 and 146

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= strictfp . (79)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= strictfp . (146)

*** Reduce/reduce conflict on "private" between rule 79 and 187

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= strictfp . (79)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= strictfp . (187)

*** Reduce/reduce conflict on "private" between rule 79 and 146

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= strictfp . (79)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= strictfp . (146)

*** Reduce/reduce conflict on "abstract" between rule 79 and 187

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= strictfp . (79)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= strictfp . (187)

*** Reduce/reduce conflict on "abstract" between rule 79 and 146

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= strictfp . (79)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= strictfp . (146)

*** Reduce/reduce conflict on "AT" between rule 79 and 187

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= strictfp . (79)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= strictfp . (187)

*** Reduce/reduce conflict on "AT" between rule 79 and 146

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= strictfp . (79)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= strictfp . (146)




STATE 291 ----------------------------------------------------------------------
( 259 276 297 )

ClassModifier ::= static . (77)
FieldModifier ::= static . (115)
MethodModifier ::= static . (142)
StaticInitializer ::= static  .Block 
InterfaceModifier ::= static . (186)

Block ::= .LBRACE BlockStatementsopt RBRACE 

*** Reduce/reduce conflict on "IDENTIFIER" between rule 115 and 142

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= static . (115)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= static . (142)

*** Reduce/reduce conflict on "short" between rule 115 and 142

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= static . (115)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= static . (142)

*** Reduce/reduce conflict on "long" between rule 115 and 142

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= static . (115)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= static . (142)

*** Reduce/reduce conflict on "int" between rule 115 and 142

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= static . (115)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= static . (142)

*** Reduce/reduce conflict on "float" between rule 115 and 142

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= static . (115)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= static . (142)

*** Reduce/reduce conflict on "final" between rule 77 and 142

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= static . (142)

*** Reduce/reduce conflict on "final" between rule 77 and 115

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= static . (115)

*** Reduce/reduce conflict on "double" between rule 115 and 142

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= static . (115)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= static . (142)

*** Reduce/reduce conflict on "char" between rule 115 and 142

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= static . (115)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= static . (142)

*** Reduce/reduce conflict on "byte" between rule 115 and 142

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= static . (115)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= static . (142)

*** Reduce/reduce conflict on "boolean" between rule 115 and 142

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= static . (115)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= static . (142)

*** Reduce/reduce conflict on "strictfp" between rule 77 and 186

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= static . (186)

*** Reduce/reduce conflict on "strictfp" between rule 77 and 142

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= static . (142)

*** Reduce/reduce conflict on "static" between rule 77 and 186

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= static . (186)

*** Reduce/reduce conflict on "static" between rule 77 and 142

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= static . (142)

*** Reduce/reduce conflict on "static" between rule 77 and 115

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= static . (115)

*** Reduce/reduce conflict on "public" between rule 77 and 186

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= static . (186)

*** Reduce/reduce conflict on "public" between rule 77 and 142

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= static . (142)

*** Reduce/reduce conflict on "public" between rule 77 and 115

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= static . (115)

*** Reduce/reduce conflict on "protected" between rule 77 and 186

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= static . (186)

*** Reduce/reduce conflict on "protected" between rule 77 and 142

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= static . (142)

*** Reduce/reduce conflict on "protected" between rule 77 and 115

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= static . (115)

*** Reduce/reduce conflict on "private" between rule 77 and 186

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= static . (186)

*** Reduce/reduce conflict on "private" between rule 77 and 142

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= static . (142)

*** Reduce/reduce conflict on "private" between rule 77 and 115

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= static . (115)

*** Reduce/reduce conflict on "abstract" between rule 77 and 186

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= static . (186)

*** Reduce/reduce conflict on "abstract" between rule 77 and 142

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= static . (142)

*** Reduce/reduce conflict on "AT" between rule 77 and 186

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= static . (186)

*** Reduce/reduce conflict on "AT" between rule 77 and 142

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= static . (142)

*** Reduce/reduce conflict on "AT" between rule 77 and 115

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= static . (77)
------------------------------------------------------------------------------
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= static . (115)




STATE 292 ----------------------------------------------------------------------
( 259 276 297 )

ClassModifier ::= abstract . (76)
MethodModifier ::= abstract . (141)
InterfaceModifier ::= abstract . (185)

*** Reduce/reduce conflict on "final" between rule 76 and 141

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= abstract . (76)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= abstract . (141)

*** Reduce/reduce conflict on "strictfp" between rule 76 and 185

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= abstract . (76)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= abstract . (185)

*** Reduce/reduce conflict on "strictfp" between rule 76 and 141

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= abstract . (76)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= abstract . (141)

*** Reduce/reduce conflict on "static" between rule 76 and 185

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= abstract . (76)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= abstract . (185)

*** Reduce/reduce conflict on "static" between rule 76 and 141

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= abstract . (76)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= abstract . (141)

*** Reduce/reduce conflict on "public" between rule 76 and 185

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= abstract . (76)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= abstract . (185)

*** Reduce/reduce conflict on "public" between rule 76 and 141

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= abstract . (76)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= abstract . (141)

*** Reduce/reduce conflict on "protected" between rule 76 and 185

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= abstract . (76)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= abstract . (185)

*** Reduce/reduce conflict on "protected" between rule 76 and 141

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= abstract . (76)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= abstract . (141)

*** Reduce/reduce conflict on "private" between rule 76 and 185

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= abstract . (76)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= abstract . (185)

*** Reduce/reduce conflict on "private" between rule 76 and 141

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= abstract . (76)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= abstract . (141)

*** Reduce/reduce conflict on "abstract" between rule 76 and 185

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= abstract . (76)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= abstract . (185)

*** Reduce/reduce conflict on "abstract" between rule 76 and 141

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= abstract . (76)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= abstract . (141)

*** Reduce/reduce conflict on "AT" between rule 76 and 185

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= abstract . (76)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= abstract . (185)

*** Reduce/reduce conflict on "AT" between rule 76 and 141

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= abstract . (76)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= abstract . (141)




STATE 293 ----------------------------------------------------------------------
( 259 276 297 )

ClassModifier ::= private . (75)
FieldModifier ::= private . (114)
MethodModifier ::= private . (140)
ConstructorModifier ::= private . (164)
InterfaceModifier ::= private . (184)

*** Reduce/reduce conflict on "short" between rule 114 and 140

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= private . (114)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= private . (140)

*** Reduce/reduce conflict on "long" between rule 114 and 140

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= private . (114)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= private . (140)

*** Reduce/reduce conflict on "int" between rule 114 and 140

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= private . (114)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= private . (140)

*** Reduce/reduce conflict on "float" between rule 114 and 140

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= private . (114)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= private . (140)

*** Reduce/reduce conflict on "final" between rule 75 and 140

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= private . (75)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= private . (140)

*** Reduce/reduce conflict on "final" between rule 75 and 114

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= private . (75)
------------------------------------------------------------------------------
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= private . (114)

*** Reduce/reduce conflict on "double" between rule 114 and 140

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= private . (114)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= private . (140)

*** Reduce/reduce conflict on "char" between rule 114 and 140

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= private . (114)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= private . (140)

*** Reduce/reduce conflict on "byte" between rule 114 and 140

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= private . (114)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= private . (140)

*** Reduce/reduce conflict on "boolean" between rule 114 and 140

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= private . (114)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= private . (140)

*** Reduce/reduce conflict on "IDENTIFIER" between rule 114 and 164

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= private . (114)
------------------------------------------------------------------------------
ConstructorDeclaration ::= .ConstructorModifiersopt ConstructorDeclarator 
                           Throwsopt ConstructorBody 
ConstructorModifiersopt ::= .ConstructorModifiers 
ConstructorModifiers ::= .ConstructorModifier 
ConstructorModifier ::= private . (164)

*** Reduce/reduce conflict on "IDENTIFIER" between rule 114 and 140

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= private . (114)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= private . (140)

*** Reduce/reduce conflict on "LESS" between rule 140 and 164

MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= private . (140)
------------------------------------------------------------------------------
ConstructorDeclaration ::= .ConstructorModifiersopt ConstructorDeclarator 
                           Throwsopt ConstructorBody 
ConstructorModifiersopt ::= .ConstructorModifiers 
ConstructorModifiers ::= .ConstructorModifier 
ConstructorModifier ::= private . (164)

*** Reduce/reduce conflict on "strictfp" between rule 75 and 184

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= private . (75)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= private . (184)

*** Reduce/reduce conflict on "strictfp" between rule 75 and 140

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= private . (75)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= private . (140)

*** Reduce/reduce conflict on "static" between rule 75 and 184

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= private . (75)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= private . (184)

*** Reduce/reduce conflict on "static" between rule 75 and 140

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= private . (75)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= private . (140)

*** Reduce/reduce conflict on "static" between rule 75 and 114

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= private . (75)
------------------------------------------------------------------------------
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= private . (114)

*** Reduce/reduce conflict on "public" between rule 75 and 184

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= private . (75)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= private . (184)

*** Reduce/reduce conflict on "public" between rule 75 and 164

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= private . (75)
------------------------------------------------------------------------------
ConstructorModifiers ::= .ConstructorModifiers ConstructorModifier 
ConstructorModifiers ::= .ConstructorModifier 
ConstructorModifier ::= private . (164)

*** Reduce/reduce conflict on "public" between rule 75 and 140

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= private . (75)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= private . (140)

*** Reduce/reduce conflict on "public" between rule 75 and 114

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= private . (75)
------------------------------------------------------------------------------
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= private . (114)

*** Reduce/reduce conflict on "protected" between rule 75 and 184

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= private . (75)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= private . (184)

*** Reduce/reduce conflict on "protected" between rule 75 and 164

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= private . (75)
------------------------------------------------------------------------------
ConstructorModifiers ::= .ConstructorModifiers ConstructorModifier 
ConstructorModifiers ::= .ConstructorModifier 
ConstructorModifier ::= private . (164)

*** Reduce/reduce conflict on "protected" between rule 75 and 140

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= private . (75)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= private . (140)

*** Reduce/reduce conflict on "protected" between rule 75 and 114

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= private . (75)
------------------------------------------------------------------------------
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= private . (114)

*** Reduce/reduce conflict on "private" between rule 75 and 184

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= private . (75)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= private . (184)

*** Reduce/reduce conflict on "private" between rule 75 and 164

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= private . (75)
------------------------------------------------------------------------------
ConstructorModifiers ::= .ConstructorModifiers ConstructorModifier 
ConstructorModifiers ::= .ConstructorModifier 
ConstructorModifier ::= private . (164)

*** Reduce/reduce conflict on "private" between rule 75 and 140

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= private . (75)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= private . (140)

*** Reduce/reduce conflict on "private" between rule 75 and 114

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= private . (75)
------------------------------------------------------------------------------
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= private . (114)

*** Reduce/reduce conflict on "abstract" between rule 75 and 184

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= private . (75)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= private . (184)

*** Reduce/reduce conflict on "abstract" between rule 75 and 140

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= private . (75)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= private . (140)

*** Reduce/reduce conflict on "AT" between rule 75 and 184

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= private . (75)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= private . (184)

*** Reduce/reduce conflict on "AT" between rule 75 and 164

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= private . (75)
------------------------------------------------------------------------------
ConstructorModifiers ::= .ConstructorModifiers ConstructorModifier 
ConstructorModifiers ::= .ConstructorModifier 
ConstructorModifier ::= private . (164)

*** Reduce/reduce conflict on "AT" between rule 75 and 140

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= private . (75)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= private . (140)

*** Reduce/reduce conflict on "AT" between rule 75 and 114

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= private . (75)
------------------------------------------------------------------------------
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= private . (114)




STATE 294 ----------------------------------------------------------------------
( 259 276 297 )

ClassModifier ::= protected . (74)
FieldModifier ::= protected . (113)
MethodModifier ::= protected . (139)
ConstructorModifier ::= protected . (163)
InterfaceModifier ::= protected . (183)

*** Reduce/reduce conflict on "short" between rule 113 and 139

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= protected . (113)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= protected . (139)

*** Reduce/reduce conflict on "long" between rule 113 and 139

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= protected . (113)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= protected . (139)

*** Reduce/reduce conflict on "int" between rule 113 and 139

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= protected . (113)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= protected . (139)

*** Reduce/reduce conflict on "float" between rule 113 and 139

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= protected . (113)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= protected . (139)

*** Reduce/reduce conflict on "final" between rule 74 and 139

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= protected . (74)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= protected . (139)

*** Reduce/reduce conflict on "final" between rule 74 and 113

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= protected . (74)
------------------------------------------------------------------------------
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= protected . (113)

*** Reduce/reduce conflict on "double" between rule 113 and 139

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= protected . (113)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= protected . (139)

*** Reduce/reduce conflict on "char" between rule 113 and 139

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= protected . (113)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= protected . (139)

*** Reduce/reduce conflict on "byte" between rule 113 and 139

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= protected . (113)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= protected . (139)

*** Reduce/reduce conflict on "boolean" between rule 113 and 139

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= protected . (113)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= protected . (139)

*** Reduce/reduce conflict on "IDENTIFIER" between rule 113 and 163

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= protected . (113)
------------------------------------------------------------------------------
ConstructorDeclaration ::= .ConstructorModifiersopt ConstructorDeclarator 
                           Throwsopt ConstructorBody 
ConstructorModifiersopt ::= .ConstructorModifiers 
ConstructorModifiers ::= .ConstructorModifier 
ConstructorModifier ::= protected . (163)

*** Reduce/reduce conflict on "IDENTIFIER" between rule 113 and 139

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= protected . (113)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= protected . (139)

*** Reduce/reduce conflict on "LESS" between rule 139 and 163

MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= protected . (139)
------------------------------------------------------------------------------
ConstructorDeclaration ::= .ConstructorModifiersopt ConstructorDeclarator 
                           Throwsopt ConstructorBody 
ConstructorModifiersopt ::= .ConstructorModifiers 
ConstructorModifiers ::= .ConstructorModifier 
ConstructorModifier ::= protected . (163)

*** Reduce/reduce conflict on "strictfp" between rule 74 and 183

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= protected . (74)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= protected . (183)

*** Reduce/reduce conflict on "strictfp" between rule 74 and 139

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= protected . (74)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= protected . (139)

*** Reduce/reduce conflict on "static" between rule 74 and 183

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= protected . (74)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= protected . (183)

*** Reduce/reduce conflict on "static" between rule 74 and 139

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= protected . (74)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= protected . (139)

*** Reduce/reduce conflict on "static" between rule 74 and 113

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= protected . (74)
------------------------------------------------------------------------------
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= protected . (113)

*** Reduce/reduce conflict on "public" between rule 74 and 183

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= protected . (74)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= protected . (183)

*** Reduce/reduce conflict on "public" between rule 74 and 163

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= protected . (74)
------------------------------------------------------------------------------
ConstructorModifiers ::= .ConstructorModifiers ConstructorModifier 
ConstructorModifiers ::= .ConstructorModifier 
ConstructorModifier ::= protected . (163)

*** Reduce/reduce conflict on "public" between rule 74 and 139

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= protected . (74)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= protected . (139)

*** Reduce/reduce conflict on "public" between rule 74 and 113

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= protected . (74)
------------------------------------------------------------------------------
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= protected . (113)

*** Reduce/reduce conflict on "protected" between rule 74 and 183

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= protected . (74)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= protected . (183)

*** Reduce/reduce conflict on "protected" between rule 74 and 163

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= protected . (74)
------------------------------------------------------------------------------
ConstructorModifiers ::= .ConstructorModifiers ConstructorModifier 
ConstructorModifiers ::= .ConstructorModifier 
ConstructorModifier ::= protected . (163)

*** Reduce/reduce conflict on "protected" between rule 74 and 139

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= protected . (74)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= protected . (139)

*** Reduce/reduce conflict on "protected" between rule 74 and 113

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= protected . (74)
------------------------------------------------------------------------------
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= protected . (113)

*** Reduce/reduce conflict on "private" between rule 74 and 183

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= protected . (74)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= protected . (183)

*** Reduce/reduce conflict on "private" between rule 74 and 163

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= protected . (74)
------------------------------------------------------------------------------
ConstructorModifiers ::= .ConstructorModifiers ConstructorModifier 
ConstructorModifiers ::= .ConstructorModifier 
ConstructorModifier ::= protected . (163)

*** Reduce/reduce conflict on "private" between rule 74 and 139

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= protected . (74)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= protected . (139)

*** Reduce/reduce conflict on "private" between rule 74 and 113

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= protected . (74)
------------------------------------------------------------------------------
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= protected . (113)

*** Reduce/reduce conflict on "abstract" between rule 74 and 183

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= protected . (74)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= protected . (183)

*** Reduce/reduce conflict on "abstract" between rule 74 and 139

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= protected . (74)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= protected . (139)

*** Reduce/reduce conflict on "AT" between rule 74 and 183

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= protected . (74)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= protected . (183)

*** Reduce/reduce conflict on "AT" between rule 74 and 163

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= protected . (74)
------------------------------------------------------------------------------
ConstructorModifiers ::= .ConstructorModifiers ConstructorModifier 
ConstructorModifiers ::= .ConstructorModifier 
ConstructorModifier ::= protected . (163)

*** Reduce/reduce conflict on "AT" between rule 74 and 139

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= protected . (74)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= protected . (139)

*** Reduce/reduce conflict on "AT" between rule 74 and 113

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= protected . (74)
------------------------------------------------------------------------------
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= protected . (113)




STATE 295 ----------------------------------------------------------------------
( 259 276 297 )

ClassModifier ::= public . (73)
FieldModifier ::= public . (112)
MethodModifier ::= public . (138)
ConstructorModifier ::= public . (162)
InterfaceModifier ::= public . (182)

*** Reduce/reduce conflict on "short" between rule 112 and 138

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= public . (112)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= public . (138)

*** Reduce/reduce conflict on "long" between rule 112 and 138

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= public . (112)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= public . (138)

*** Reduce/reduce conflict on "int" between rule 112 and 138

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= public . (112)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= public . (138)

*** Reduce/reduce conflict on "float" between rule 112 and 138

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= public . (112)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= public . (138)

*** Reduce/reduce conflict on "final" between rule 73 and 138

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= public . (138)

*** Reduce/reduce conflict on "final" between rule 73 and 112

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= public . (112)

*** Reduce/reduce conflict on "double" between rule 112 and 138

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= public . (112)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= public . (138)

*** Reduce/reduce conflict on "char" between rule 112 and 138

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= public . (112)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= public . (138)

*** Reduce/reduce conflict on "byte" between rule 112 and 138

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= public . (112)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= public . (138)

*** Reduce/reduce conflict on "boolean" between rule 112 and 138

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= public . (112)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= public . (138)

*** Reduce/reduce conflict on "IDENTIFIER" between rule 112 and 162

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= public . (112)
------------------------------------------------------------------------------
ConstructorDeclaration ::= .ConstructorModifiersopt ConstructorDeclarator 
                           Throwsopt ConstructorBody 
ConstructorModifiersopt ::= .ConstructorModifiers 
ConstructorModifiers ::= .ConstructorModifier 
ConstructorModifier ::= public . (162)

*** Reduce/reduce conflict on "IDENTIFIER" between rule 112 and 138

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= public . (112)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= public . (138)

*** Reduce/reduce conflict on "LESS" between rule 138 and 162

MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= public . (138)
------------------------------------------------------------------------------
ConstructorDeclaration ::= .ConstructorModifiersopt ConstructorDeclarator 
                           Throwsopt ConstructorBody 
ConstructorModifiersopt ::= .ConstructorModifiers 
ConstructorModifiers ::= .ConstructorModifier 
ConstructorModifier ::= public . (162)

*** Reduce/reduce conflict on "strictfp" between rule 73 and 182

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= public . (182)

*** Reduce/reduce conflict on "strictfp" between rule 73 and 138

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= public . (138)

*** Reduce/reduce conflict on "static" between rule 73 and 182

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= public . (182)

*** Reduce/reduce conflict on "static" between rule 73 and 138

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= public . (138)

*** Reduce/reduce conflict on "static" between rule 73 and 112

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= public . (112)

*** Reduce/reduce conflict on "public" between rule 73 and 182

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= public . (182)

*** Reduce/reduce conflict on "public" between rule 73 and 162

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
ConstructorModifiers ::= .ConstructorModifiers ConstructorModifier 
ConstructorModifiers ::= .ConstructorModifier 
ConstructorModifier ::= public . (162)

*** Reduce/reduce conflict on "public" between rule 73 and 138

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= public . (138)

*** Reduce/reduce conflict on "public" between rule 73 and 112

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= public . (112)

*** Reduce/reduce conflict on "protected" between rule 73 and 182

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= public . (182)

*** Reduce/reduce conflict on "protected" between rule 73 and 162

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
ConstructorModifiers ::= .ConstructorModifiers ConstructorModifier 
ConstructorModifiers ::= .ConstructorModifier 
ConstructorModifier ::= public . (162)

*** Reduce/reduce conflict on "protected" between rule 73 and 138

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= public . (138)

*** Reduce/reduce conflict on "protected" between rule 73 and 112

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= public . (112)

*** Reduce/reduce conflict on "private" between rule 73 and 182

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= public . (182)

*** Reduce/reduce conflict on "private" between rule 73 and 162

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
ConstructorModifiers ::= .ConstructorModifiers ConstructorModifier 
ConstructorModifiers ::= .ConstructorModifier 
ConstructorModifier ::= public . (162)

*** Reduce/reduce conflict on "private" between rule 73 and 138

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= public . (138)

*** Reduce/reduce conflict on "private" between rule 73 and 112

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= public . (112)

*** Reduce/reduce conflict on "abstract" between rule 73 and 182

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= public . (182)

*** Reduce/reduce conflict on "abstract" between rule 73 and 138

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= public . (138)

*** Reduce/reduce conflict on "AT" between rule 73 and 182

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= public . (182)

*** Reduce/reduce conflict on "AT" between rule 73 and 162

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
ConstructorModifiers ::= .ConstructorModifiers ConstructorModifier 
ConstructorModifiers ::= .ConstructorModifier 
ConstructorModifier ::= public . (162)

*** Reduce/reduce conflict on "AT" between rule 73 and 138

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= public . (138)

*** Reduce/reduce conflict on "AT" between rule 73 and 112

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= public . (73)
------------------------------------------------------------------------------
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= public . (112)




STATE 296 ----------------------------------------------------------------------
( 259 276 297 )

ClassModifier ::= Annotation . (72)
FieldModifier ::= Annotation . (111)
InterfaceModifier ::= Annotation . (181)
Annotations ::= Annotation . (224)

*** Reduce/reduce conflict on "IDENTIFIER" between rule 111 and 224

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= Annotation . (111)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= .Annotations 
Annotations ::= Annotation . (224)

*** Reduce/reduce conflict on "strictfp" between rule 72 and 224

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= .Annotations 
Annotations ::= Annotation . (224)

*** Reduce/reduce conflict on "strictfp" between rule 72 and 181

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= Annotation . (181)

*** Reduce/reduce conflict on "static" between rule 72 and 224

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= .Annotations 
Annotations ::= Annotation . (224)

*** Reduce/reduce conflict on "static" between rule 72 and 181

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= Annotation . (181)

*** Reduce/reduce conflict on "static" between rule 72 and 111

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= Annotation . (111)

*** Reduce/reduce conflict on "short" between rule 111 and 224

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= Annotation . (111)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= .Annotations 
Annotations ::= Annotation . (224)

*** Reduce/reduce conflict on "public" between rule 72 and 224

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= .Annotations 
Annotations ::= Annotation . (224)

*** Reduce/reduce conflict on "public" between rule 72 and 181

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= Annotation . (181)

*** Reduce/reduce conflict on "public" between rule 72 and 111

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= Annotation . (111)

*** Reduce/reduce conflict on "protected" between rule 72 and 224

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= .Annotations 
Annotations ::= Annotation . (224)

*** Reduce/reduce conflict on "protected" between rule 72 and 181

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= Annotation . (181)

*** Reduce/reduce conflict on "protected" between rule 72 and 111

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= Annotation . (111)

*** Reduce/reduce conflict on "private" between rule 72 and 224

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= .Annotations 
Annotations ::= Annotation . (224)

*** Reduce/reduce conflict on "private" between rule 72 and 181

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= Annotation . (181)

*** Reduce/reduce conflict on "private" between rule 72 and 111

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= Annotation . (111)

*** Reduce/reduce conflict on "long" between rule 111 and 224

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= Annotation . (111)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= .Annotations 
Annotations ::= Annotation . (224)

*** Reduce/reduce conflict on "int" between rule 111 and 224

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= Annotation . (111)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= .Annotations 
Annotations ::= Annotation . (224)

*** Reduce/reduce conflict on "float" between rule 111 and 224

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= Annotation . (111)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= .Annotations 
Annotations ::= Annotation . (224)

*** Reduce/reduce conflict on "final" between rule 72 and 224

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= .Annotations 
Annotations ::= Annotation . (224)

*** Reduce/reduce conflict on "final" between rule 72 and 111

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= Annotation . (111)

*** Reduce/reduce conflict on "double" between rule 111 and 224

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= Annotation . (111)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= .Annotations 
Annotations ::= Annotation . (224)

*** Reduce/reduce conflict on "char" between rule 111 and 224

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= Annotation . (111)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= .Annotations 
Annotations ::= Annotation . (224)

*** Reduce/reduce conflict on "byte" between rule 111 and 224

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= Annotation . (111)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= .Annotations 
Annotations ::= Annotation . (224)

*** Reduce/reduce conflict on "boolean" between rule 111 and 224

FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= .FieldModifiers 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= Annotation . (111)
------------------------------------------------------------------------------
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= .MethodModifiers 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= .Annotations 
Annotations ::= Annotation . (224)

*** Reduce/reduce conflict on "abstract" between rule 72 and 224

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= .Annotations 
Annotations ::= Annotation . (224)

*** Reduce/reduce conflict on "abstract" between rule 72 and 181

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= Annotation . (181)

*** Reduce/reduce conflict on "AT" between rule 72 and 224

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= .MethodModifier 
MethodModifier ::= .Annotations 
Annotations ::= Annotation . (224)

*** Reduce/reduce conflict on "AT" between rule 72 and 181

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifier ::= Annotation . (181)

*** Reduce/reduce conflict on "AT" between rule 72 and 111

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifiers ::= .FieldModifier 
FieldModifier ::= Annotation . (111)




STATE 297 ----------------------------------------------------------------------
( 259 276 )

ClassBodyDeclarations ::= ClassBodyDeclarations  .ClassBodyDeclaration 
ClassBodyDeclarationsopt ::= ClassBodyDeclarations . (512)

ClassDeclaration ::= .NormalClassDeclaration 
ClassDeclaration ::= .EnumDeclaration 
NormalClassDeclaration ::= .ClassModifiersopt class identifier 
                           TypeParametersopt Superopt Interfacesopt ClassBody 
ClassModifiers ::= .ClassModifier 
ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifier ::= .Annotation 
ClassModifier ::= .public 
ClassModifier ::= .protected 
ClassModifier ::= .private 
ClassModifier ::= .abstract 
ClassModifier ::= .static 
ClassModifier ::= .final 
ClassModifier ::= .strictfp 
ClassBodyDeclaration ::= .ClassMemberDeclaration 
ClassBodyDeclaration ::= .InstanceInitializer 
ClassBodyDeclaration ::= .StaticInitializer 
ClassBodyDeclaration ::= .ConstructorDeclaration 
ClassBodyDeclaration ::= .ERROR_TOKEN 
ClassMemberDeclaration ::= .FieldDeclaration 
ClassMemberDeclaration ::= .MethodDeclaration 
ClassMemberDeclaration ::= .ClassDeclaration 
ClassMemberDeclaration ::= .InterfaceDeclaration 
ClassMemberDeclaration ::= .SEMICOLON 
FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiers ::= .FieldModifier 
FieldModifiers ::= .FieldModifiers FieldModifier 
FieldModifier ::= .Annotation 
FieldModifier ::= .public 
FieldModifier ::= .protected 
FieldModifier ::= .private 
FieldModifier ::= .static 
FieldModifier ::= .final 
FieldModifier ::= .transient 
FieldModifier ::= .volatile 
MethodDeclaration ::= .MethodHeader MethodBody 
MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiers ::= .MethodModifier 
MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifier ::= .Annotations 
MethodModifier ::= .public 
MethodModifier ::= .protected 
MethodModifier ::= .private 
MethodModifier ::= .abstract 
MethodModifier ::= .static 
MethodModifier ::= .final 
MethodModifier ::= .synchronized 
MethodModifier ::= .native 
MethodModifier ::= .strictfp 
InstanceInitializer ::= .Block 
StaticInitializer ::= .static Block 
ConstructorDeclaration ::= .ConstructorModifiersopt ConstructorDeclarator 
                           Throwsopt ConstructorBody 
ConstructorModifiers ::= .ConstructorModifier 
ConstructorModifiers ::= .ConstructorModifiers ConstructorModifier 
ConstructorModifier ::= .Annotations 
ConstructorModifier ::= .public 
ConstructorModifier ::= .protected 
ConstructorModifier ::= .private 
EnumDeclaration ::= .ClassModifiersopt enum identifier Interfacesopt EnumBody 
InterfaceDeclaration ::= .NormalInterfaceDeclaration 
InterfaceDeclaration ::= .AnnotationTypeDeclaration 
NormalInterfaceDeclaration ::= .InterfaceModifiersopt interface identifier 
                               TypeParametersopt ExtendsInterfacesopt 
                               InterfaceBody 
InterfaceModifiers ::= .InterfaceModifier 
InterfaceModifiers ::= .InterfaceModifiers InterfaceModifier 
InterfaceModifier ::= .Annotation 
InterfaceModifier ::= .public 
InterfaceModifier ::= .protected 
InterfaceModifier ::= .private 
InterfaceModifier ::= .abstract 
InterfaceModifier ::= .static 
InterfaceModifier ::= .strictfp 
AnnotationTypeDeclaration ::= .InterfaceModifiersopt AT interface identifier 
                              AnnotationTypeBody 
Annotations ::= .Annotation 
Annotations ::= .Annotations Annotation 
Annotation ::= .NormalAnnotation 
Annotation ::= .MarkerAnnotation 
Annotation ::= .SingleElementAnnotation 
NormalAnnotation ::= .AT TypeName LPAREN ElementValuePairsopt RPAREN 
MarkerAnnotation ::= .AT TypeName 
SingleElementAnnotation ::= .AT TypeName LPAREN ElementValue RPAREN 
Block ::= .LBRACE BlockStatementsopt RBRACE 
InterfaceModifiersopt ::= . (481)
InterfaceModifiersopt ::= .InterfaceModifiers 
ConstructorModifiersopt ::= . (499)
ConstructorModifiersopt ::= .ConstructorModifiers 
MethodModifiersopt ::= . (507)
MethodModifiersopt ::= .MethodModifiers 
FieldModifiersopt ::= . (509)
FieldModifiersopt ::= .FieldModifiers 
ClassModifiersopt ::= . (519)
ClassModifiersopt ::= .ClassModifiers 

*** Shift/reduce conflict on "AT" with rule 481

AnnotationTypeDeclaration ::= .InterfaceModifiersopt AT interface identifier 
                              AnnotationTypeBody 
InterfaceModifiersopt ::= . (481)

*** Reduce/reduce conflict on "short" between rule 507 and 509

MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= . (507)
------------------------------------------------------------------------------
FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= . (509)

*** Reduce/reduce conflict on "long" between rule 507 and 509

MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= . (507)
------------------------------------------------------------------------------
FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= . (509)

*** Reduce/reduce conflict on "int" between rule 507 and 509

MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= . (507)
------------------------------------------------------------------------------
FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= . (509)

*** Reduce/reduce conflict on "float" between rule 507 and 509

MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= . (507)
------------------------------------------------------------------------------
FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= . (509)

*** Reduce/reduce conflict on "double" between rule 507 and 509

MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= . (507)
------------------------------------------------------------------------------
FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= . (509)

*** Reduce/reduce conflict on "char" between rule 507 and 509

MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= . (507)
------------------------------------------------------------------------------
FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= . (509)

*** Reduce/reduce conflict on "byte" between rule 507 and 509

MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= . (507)
------------------------------------------------------------------------------
FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= . (509)

*** Reduce/reduce conflict on "boolean" between rule 507 and 509

MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= . (507)
------------------------------------------------------------------------------
FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= . (509)

*** Reduce/reduce conflict on "IDENTIFIER" between rule 507 and 499

MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= . (507)
------------------------------------------------------------------------------
ConstructorDeclaration ::= .ConstructorModifiersopt ConstructorDeclarator 
                           Throwsopt ConstructorBody 
ConstructorModifiersopt ::= . (499)

*** Reduce/reduce conflict on "IDENTIFIER" between rule 507 and 509

MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= . (507)
------------------------------------------------------------------------------
FieldDeclaration ::= .FieldModifiersopt Type VariableDeclarators SEMICOLON 
FieldModifiersopt ::= . (509)

*** Reduce/reduce conflict on "LESS" between rule 507 and 499

MethodHeader ::= .MethodModifiersopt TypeParametersopt ResultType 
                 MethodDeclarator Throwsopt 
MethodModifiersopt ::= . (507)
------------------------------------------------------------------------------
ConstructorDeclaration ::= .ConstructorModifiersopt ConstructorDeclarator 
                           Throwsopt ConstructorBody 
ConstructorModifiersopt ::= . (499)




STATE 309 ----------------------------------------------------------------------
( 280 )

ConstructorModifier ::= Annotations . (161)
Annotations ::= Annotations  .Annotation 

Annotation ::= .NormalAnnotation 
Annotation ::= .MarkerAnnotation 
Annotation ::= .SingleElementAnnotation 
NormalAnnotation ::= .AT TypeName LPAREN ElementValuePairsopt RPAREN 
MarkerAnnotation ::= .AT TypeName 
SingleElementAnnotation ::= .AT TypeName LPAREN ElementValue RPAREN 

*** Shift/reduce conflict on "AT" with rule 161

ConstructorModifiers ::= .ConstructorModifiers ConstructorModifier 
ConstructorModifiers ::= ConstructorModifiers  .ConstructorModifier 
ConstructorModifier ::= Annotations . (161)




STATE 329 ----------------------------------------------------------------------
( 282 319 339 361 396 409 444 446 451 462 474 )

TypeName ::= identifier . (21)
TypeVariable ::= identifier . (24)
ExpressionName ::= identifier . (41)
MethodName ::= identifier . (43)
AmbiguousName ::= identifier . (47)
LabeledStatement ::= identifier  .COLON Statement 

*** Reduce/reduce conflict on "LBRACKET" between rule 21 and 41

ArrayType ::= .Type LBRACKET RBRACKET 
Type ::= .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
ArrayAccess ::= .ExpressionName LBRACKET Expression RBRACKET 
ExpressionName ::= identifier . (41)

*** Reduce/reduce conflict on "LBRACKET" between rule 21 and 24

ArrayType ::= .Type LBRACKET RBRACKET 
Type ::= .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
ArrayType ::= .Type LBRACKET RBRACKET 
Type ::= .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "DOT" between rule 21 and 47

PrimaryNoNewArray ::= .Type DOT class 
Type ::= .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
ExpressionName ::= .AmbiguousName DOT identifier 
AmbiguousName ::= identifier . (47)

*** Reduce/reduce conflict on "DOT" between rule 21 and 24

PrimaryNoNewArray ::= .Type DOT class 
Type ::= .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
PrimaryNoNewArray ::= .Type DOT class 
Type ::= .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)




STATE 334 ----------------------------------------------------------------------
( 282 339 396 444 462 )

ClassModifier ::= Annotation . (72)
Annotations ::= Annotation . (224)

*** Reduce/reduce conflict on "final" between rule 72 and 224

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
VariableModifiers ::= .VariableModifiers VariableModifier 
VariableModifiers ::= .VariableModifier 
VariableModifier ::= .Annotations 
Annotations ::= Annotation . (224)

*** Reduce/reduce conflict on "AT" between rule 72 and 224

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= Annotation . (72)
------------------------------------------------------------------------------
VariableModifiers ::= .VariableModifiers VariableModifier 
VariableModifiers ::= .VariableModifier 
VariableModifier ::= .Annotations 
Annotations ::= Annotation . (224)




STATE 335 ----------------------------------------------------------------------
( 282 337 339 364 374 377 396 403 415 444 447 462 )

VariableModifier ::= Annotations . (133)
Annotations ::= Annotations  .Annotation 

Annotation ::= .NormalAnnotation 
Annotation ::= .MarkerAnnotation 
Annotation ::= .SingleElementAnnotation 
NormalAnnotation ::= .AT TypeName LPAREN ElementValuePairsopt RPAREN 
MarkerAnnotation ::= .AT TypeName 
SingleElementAnnotation ::= .AT TypeName LPAREN ElementValue RPAREN 

*** Shift/reduce conflict on "AT" with rule 133

VariableModifiers ::= .VariableModifiers VariableModifier 
VariableModifiers ::= .VariableModifier 
VariableModifier ::= Annotations . (133)




STATE 336 ----------------------------------------------------------------------
( 282 339 396 444 462 )

ClassModifier ::= final . (78)
VariableModifier ::= final . (132)

*** Reduce/reduce conflict on "final" between rule 78 and 132

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= final . (78)
------------------------------------------------------------------------------
VariableModifiers ::= .VariableModifiers VariableModifier 
VariableModifiers ::= .VariableModifier 
VariableModifier ::= final . (132)

*** Reduce/reduce conflict on "AT" between rule 78 and 132

ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifiers ::= .ClassModifier 
ClassModifier ::= final . (78)
------------------------------------------------------------------------------
VariableModifiers ::= .VariableModifiers VariableModifier 
VariableModifiers ::= .VariableModifier 
VariableModifier ::= final . (132)




STATE 339 ----------------------------------------------------------------------
( 282 396 )

BlockStatements ::= BlockStatements  .BlockStatement 
BlockStatementsopt ::= BlockStatements . (496)

identifier ::= .IDENTIFIER 
Type ::= .PrimitiveType 
Type ::= .ReferenceType 
PrimitiveType ::= .NumericType 
PrimitiveType ::= .boolean 
NumericType ::= .IntegralType 
NumericType ::= .FloatingPointType 
IntegralType ::= .byte 
IntegralType ::= .short 
IntegralType ::= .int 
IntegralType ::= .long 
IntegralType ::= .char 
FloatingPointType ::= .float 
FloatingPointType ::= .double 
ReferenceType ::= .ClassOrInterfaceType 
ReferenceType ::= .TypeVariable 
ReferenceType ::= .ArrayType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= .identifier 
TypeName ::= .TypeName DOT identifier 
ClassName ::= .TypeName 
TypeVariable ::= .identifier 
ArrayType ::= .Type LBRACKET RBRACKET 
ExpressionName ::= .identifier 
ExpressionName ::= .AmbiguousName DOT identifier 
MethodName ::= .identifier 
MethodName ::= .AmbiguousName DOT identifier 
AmbiguousName ::= .identifier 
AmbiguousName ::= .AmbiguousName DOT identifier 
ClassDeclaration ::= .NormalClassDeclaration 
ClassDeclaration ::= .EnumDeclaration 
NormalClassDeclaration ::= .ClassModifiersopt class identifier 
                           TypeParametersopt Superopt Interfacesopt ClassBody 
ClassModifiers ::= .ClassModifier 
ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifier ::= .Annotation 
ClassModifier ::= .public 
ClassModifier ::= .protected 
ClassModifier ::= .private 
ClassModifier ::= .abstract 
ClassModifier ::= .static 
ClassModifier ::= .final 
ClassModifier ::= .strictfp 
VariableModifiers ::= .VariableModifier 
VariableModifiers ::= .VariableModifiers VariableModifier 
VariableModifier ::= .final 
VariableModifier ::= .Annotations 
EnumDeclaration ::= .ClassModifiersopt enum identifier Interfacesopt EnumBody 
Annotations ::= .Annotation 
Annotations ::= .Annotations Annotation 
Annotation ::= .NormalAnnotation 
Annotation ::= .MarkerAnnotation 
Annotation ::= .SingleElementAnnotation 
NormalAnnotation ::= .AT TypeName LPAREN ElementValuePairsopt RPAREN 
MarkerAnnotation ::= .AT TypeName 
SingleElementAnnotation ::= .AT TypeName LPAREN ElementValue RPAREN 
Block ::= .LBRACE BlockStatementsopt RBRACE 
BlockStatement ::= .LocalVariableDeclarationStatement 
BlockStatement ::= .ClassDeclaration 
BlockStatement ::= .Statement 
LocalVariableDeclarationStatement ::= .LocalVariableDeclaration SEMICOLON 
LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
Statement ::= .StatementWithoutTrailingSubstatement 
Statement ::= .LabeledStatement 
Statement ::= .IfThenStatement 
Statement ::= .IfThenElseStatement 
Statement ::= .WhileStatement 
Statement ::= .ForStatement 
StatementWithoutTrailingSubstatement ::= .Block 
StatementWithoutTrailingSubstatement ::= .EmptyStatement 
StatementWithoutTrailingSubstatement ::= .ExpressionStatement 
StatementWithoutTrailingSubstatement ::= .AssertStatement 
StatementWithoutTrailingSubstatement ::= .SwitchStatement 
StatementWithoutTrailingSubstatement ::= .DoStatement 
StatementWithoutTrailingSubstatement ::= .BreakStatement 
StatementWithoutTrailingSubstatement ::= .ContinueStatement 
StatementWithoutTrailingSubstatement ::= .ReturnStatement 
StatementWithoutTrailingSubstatement ::= .SynchronizedStatement 
StatementWithoutTrailingSubstatement ::= .ThrowStatement 
StatementWithoutTrailingSubstatement ::= .TryStatement 
IfThenStatement ::= .if LPAREN Expression RPAREN Statement 
IfThenElseStatement ::= .if LPAREN Expression RPAREN StatementNoShortIf else 
                        Statement 
EmptyStatement ::= .SEMICOLON 
EmptyStatement ::= .ERROR_TOKEN 
LabeledStatement ::= .identifier COLON Statement 
ExpressionStatement ::= .StatementExpression SEMICOLON 
StatementExpression ::= .Assignment 
StatementExpression ::= .PreIncrementExpression 
StatementExpression ::= .PreDecrementExpression 
StatementExpression ::= .PostIncrementExpression 
StatementExpression ::= .PostDecrementExpression 
StatementExpression ::= .MethodInvocation 
StatementExpression ::= .ClassInstanceCreationExpression 
AssertStatement ::= .assert Expression SEMICOLON 
AssertStatement ::= .assert Expression COLON Expression SEMICOLON 
SwitchStatement ::= .switch LPAREN Expression RPAREN SwitchBlock 
WhileStatement ::= .while LPAREN Expression RPAREN Statement 
DoStatement ::= .do Statement while LPAREN Expression RPAREN SEMICOLON 
ForStatement ::= .BasicForStatement 
ForStatement ::= .EnhancedForStatement 
BasicForStatement ::= .for LPAREN ForInitopt SEMICOLON Expressionopt SEMICOLON 
                      ForUpdateopt RPAREN Statement 
EnhancedForStatement ::= .for LPAREN FormalParameter COLON Expression RPAREN 
                         Statement 
BreakStatement ::= .break identifieropt SEMICOLON 
ContinueStatement ::= .continue identifieropt SEMICOLON 
ReturnStatement ::= .return Expressionopt SEMICOLON 
ThrowStatement ::= .throw Expression SEMICOLON 
SynchronizedStatement ::= .synchronized LPAREN Expression RPAREN Block 
TryStatement ::= .try Block Catches 
TryStatement ::= .try Block Catchesopt Finally 
Primary ::= .PrimaryNoNewArray 
Primary ::= .ArrayCreationExpression 
PrimaryNoNewArray ::= .Literal 
PrimaryNoNewArray ::= .Type DOT class 
PrimaryNoNewArray ::= .void DOT class 
PrimaryNoNewArray ::= .this 
PrimaryNoNewArray ::= .ClassName DOT this 
PrimaryNoNewArray ::= .LPAREN Expression RPAREN 
PrimaryNoNewArray ::= .ClassInstanceCreationExpression 
PrimaryNoNewArray ::= .FieldAccess 
PrimaryNoNewArray ::= .MethodInvocation 
PrimaryNoNewArray ::= .ArrayAccess 
Literal ::= .IntegerLiteral 
Literal ::= .LongLiteral 
Literal ::= .FloatingPointLiteral 
Literal ::= .DoubleLiteral 
Literal ::= .BooleanLiteral 
Literal ::= .CharacterLiteral 
Literal ::= .StringLiteral 
Literal ::= .null 
BooleanLiteral ::= .true 
BooleanLiteral ::= .false 
ClassInstanceCreationExpression ::= .new TypeArgumentsopt ClassOrInterfaceType 
                                    TypeArgumentsopt LPAREN ArgumentListopt 
                                    RPAREN ClassBodyopt 
ClassInstanceCreationExpression ::= .Primary DOT new TypeArgumentsopt 
                                    identifier TypeArgumentsopt LPAREN 
                                    ArgumentListopt RPAREN ClassBodyopt 
ClassInstanceCreationExpression ::= .name DOT new TypeArgumentsopt identifier 
                                    TypeArgumentsopt LPAREN ArgumentListopt 
                                    RPAREN ClassBodyopt 
ArrayCreationExpression ::= .new PrimitiveType DimExprs Dimsopt 
ArrayCreationExpression ::= .new ClassOrInterfaceType DimExprs Dimsopt 
ArrayCreationExpression ::= .new PrimitiveType Dims ArrayInitializer 
ArrayCreationExpression ::= .new ClassOrInterfaceType Dims ArrayInitializer 
FieldAccess ::= .Primary DOT identifier 
FieldAccess ::= .super DOT identifier 
FieldAccess ::= .ClassName DOT super DOT identifier 
MethodInvocation ::= .MethodName LPAREN ArgumentListopt RPAREN 
MethodInvocation ::= .Primary DOT TypeArgumentsopt identifier LPAREN 
                     ArgumentListopt RPAREN 
MethodInvocation ::= .super DOT TypeArgumentsopt identifier LPAREN 
                     ArgumentListopt RPAREN 
MethodInvocation ::= .ClassName DOT super DOT TypeArgumentsopt identifier 
                     LPAREN ArgumentListopt RPAREN 
MethodInvocation ::= .TypeName DOT TypeArguments identifier LPAREN 
                     ArgumentListopt RPAREN 
ArrayAccess ::= .ExpressionName LBRACKET Expression RBRACKET 
ArrayAccess ::= .PrimaryNoNewArray LBRACKET Expression RBRACKET 
PostfixExpression ::= .Primary 
PostfixExpression ::= .ExpressionName 
PostfixExpression ::= .PostIncrementExpression 
PostfixExpression ::= .PostDecrementExpression 
PostIncrementExpression ::= .PostfixExpression PLUS_PLUS 
PostDecrementExpression ::= .PostfixExpression MINUS_MINUS 
PreIncrementExpression ::= .PLUS_PLUS UnaryExpression 
PreDecrementExpression ::= .MINUS_MINUS UnaryExpression 
Assignment ::= .LeftHandSide AssignmentOperator AssignmentExpression 
LeftHandSide ::= .ExpressionName 
LeftHandSide ::= .FieldAccess 
LeftHandSide ::= .ArrayAccess 
VariableModifiersopt ::= . (461)
VariableModifiersopt ::= .VariableModifiers 
ClassModifiersopt ::= . (519)
ClassModifiersopt ::= .ClassModifiers 

*** Shift/reduce conflict on "boolean" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "char" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "long" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "int" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "short" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "byte" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "double" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "float" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "IDENTIFIER" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)




STATE 341 ----------------------------------------------------------------------
( 287 )

MethodModifier ::= Annotations . (137)
Annotations ::= Annotations  .Annotation 

Annotation ::= .NormalAnnotation 
Annotation ::= .MarkerAnnotation 
Annotation ::= .SingleElementAnnotation 
NormalAnnotation ::= .AT TypeName LPAREN ElementValuePairsopt RPAREN 
MarkerAnnotation ::= .AT TypeName 
SingleElementAnnotation ::= .AT TypeName LPAREN ElementValue RPAREN 

*** Shift/reduce conflict on "AT" with rule 137

MethodModifiers ::= .MethodModifiers MethodModifier 
MethodModifiers ::= MethodModifiers  .MethodModifier 
MethodModifier ::= Annotations . (137)




STATE 364 ----------------------------------------------------------------------
( 332 )

BasicForStatement ::= for LPAREN  .ForInitopt SEMICOLON Expressionopt SEMICOLON 
                      ForUpdateopt RPAREN Statement 
EnhancedForStatement ::= for LPAREN  .FormalParameter COLON Expression RPAREN 
                         Statement 

identifier ::= .IDENTIFIER 
Type ::= .PrimitiveType 
Type ::= .ReferenceType 
PrimitiveType ::= .NumericType 
PrimitiveType ::= .boolean 
NumericType ::= .IntegralType 
NumericType ::= .FloatingPointType 
IntegralType ::= .byte 
IntegralType ::= .short 
IntegralType ::= .int 
IntegralType ::= .long 
IntegralType ::= .char 
FloatingPointType ::= .float 
FloatingPointType ::= .double 
ReferenceType ::= .ClassOrInterfaceType 
ReferenceType ::= .TypeVariable 
ReferenceType ::= .ArrayType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= .identifier 
TypeName ::= .TypeName DOT identifier 
ClassName ::= .TypeName 
TypeVariable ::= .identifier 
ArrayType ::= .Type LBRACKET RBRACKET 
ExpressionName ::= .identifier 
ExpressionName ::= .AmbiguousName DOT identifier 
MethodName ::= .identifier 
MethodName ::= .AmbiguousName DOT identifier 
AmbiguousName ::= .identifier 
AmbiguousName ::= .AmbiguousName DOT identifier 
FormalParameter ::= .VariableModifiersopt Type VariableDeclaratorId 
VariableModifiers ::= .VariableModifier 
VariableModifiers ::= .VariableModifiers VariableModifier 
VariableModifier ::= .final 
VariableModifier ::= .Annotations 
Annotations ::= .Annotation 
Annotations ::= .Annotations Annotation 
Annotation ::= .NormalAnnotation 
Annotation ::= .MarkerAnnotation 
Annotation ::= .SingleElementAnnotation 
NormalAnnotation ::= .AT TypeName LPAREN ElementValuePairsopt RPAREN 
MarkerAnnotation ::= .AT TypeName 
SingleElementAnnotation ::= .AT TypeName LPAREN ElementValue RPAREN 
LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
StatementExpression ::= .Assignment 
StatementExpression ::= .PreIncrementExpression 
StatementExpression ::= .PreDecrementExpression 
StatementExpression ::= .PostIncrementExpression 
StatementExpression ::= .PostDecrementExpression 
StatementExpression ::= .MethodInvocation 
StatementExpression ::= .ClassInstanceCreationExpression 
ForInit ::= .StatementExpressionList 
ForInit ::= .LocalVariableDeclaration 
StatementExpressionList ::= .StatementExpression 
StatementExpressionList ::= .StatementExpressionList COMMA StatementExpression 
Primary ::= .PrimaryNoNewArray 
Primary ::= .ArrayCreationExpression 
PrimaryNoNewArray ::= .Literal 
PrimaryNoNewArray ::= .Type DOT class 
PrimaryNoNewArray ::= .void DOT class 
PrimaryNoNewArray ::= .this 
PrimaryNoNewArray ::= .ClassName DOT this 
PrimaryNoNewArray ::= .LPAREN Expression RPAREN 
PrimaryNoNewArray ::= .ClassInstanceCreationExpression 
PrimaryNoNewArray ::= .FieldAccess 
PrimaryNoNewArray ::= .MethodInvocation 
PrimaryNoNewArray ::= .ArrayAccess 
Literal ::= .IntegerLiteral 
Literal ::= .LongLiteral 
Literal ::= .FloatingPointLiteral 
Literal ::= .DoubleLiteral 
Literal ::= .BooleanLiteral 
Literal ::= .CharacterLiteral 
Literal ::= .StringLiteral 
Literal ::= .null 
BooleanLiteral ::= .true 
BooleanLiteral ::= .false 
ClassInstanceCreationExpression ::= .new TypeArgumentsopt ClassOrInterfaceType 
                                    TypeArgumentsopt LPAREN ArgumentListopt 
                                    RPAREN ClassBodyopt 
ClassInstanceCreationExpression ::= .Primary DOT new TypeArgumentsopt 
                                    identifier TypeArgumentsopt LPAREN 
                                    ArgumentListopt RPAREN ClassBodyopt 
ClassInstanceCreationExpression ::= .name DOT new TypeArgumentsopt identifier 
                                    TypeArgumentsopt LPAREN ArgumentListopt 
                                    RPAREN ClassBodyopt 
ArrayCreationExpression ::= .new PrimitiveType DimExprs Dimsopt 
ArrayCreationExpression ::= .new ClassOrInterfaceType DimExprs Dimsopt 
ArrayCreationExpression ::= .new PrimitiveType Dims ArrayInitializer 
ArrayCreationExpression ::= .new ClassOrInterfaceType Dims ArrayInitializer 
FieldAccess ::= .Primary DOT identifier 
FieldAccess ::= .super DOT identifier 
FieldAccess ::= .ClassName DOT super DOT identifier 
MethodInvocation ::= .MethodName LPAREN ArgumentListopt RPAREN 
MethodInvocation ::= .Primary DOT TypeArgumentsopt identifier LPAREN 
                     ArgumentListopt RPAREN 
MethodInvocation ::= .super DOT TypeArgumentsopt identifier LPAREN 
                     ArgumentListopt RPAREN 
MethodInvocation ::= .ClassName DOT super DOT TypeArgumentsopt identifier 
                     LPAREN ArgumentListopt RPAREN 
MethodInvocation ::= .TypeName DOT TypeArguments identifier LPAREN 
                     ArgumentListopt RPAREN 
ArrayAccess ::= .ExpressionName LBRACKET Expression RBRACKET 
ArrayAccess ::= .PrimaryNoNewArray LBRACKET Expression RBRACKET 
PostfixExpression ::= .Primary 
PostfixExpression ::= .ExpressionName 
PostfixExpression ::= .PostIncrementExpression 
PostfixExpression ::= .PostDecrementExpression 
PostIncrementExpression ::= .PostfixExpression PLUS_PLUS 
PostDecrementExpression ::= .PostfixExpression MINUS_MINUS 
PreIncrementExpression ::= .PLUS_PLUS UnaryExpression 
PreDecrementExpression ::= .MINUS_MINUS UnaryExpression 
Assignment ::= .LeftHandSide AssignmentOperator AssignmentExpression 
LeftHandSide ::= .ExpressionName 
LeftHandSide ::= .FieldAccess 
LeftHandSide ::= .ArrayAccess 
ForInitopt ::= . (455)
ForInitopt ::= .ForInit 
VariableModifiersopt ::= . (461)
VariableModifiersopt ::= .VariableModifiers 

*** Shift/reduce conflict on "IDENTIFIER" with rule 461

FormalParameter ::= .VariableModifiersopt Type VariableDeclaratorId 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "double" with rule 461

FormalParameter ::= .VariableModifiersopt Type VariableDeclaratorId 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "float" with rule 461

FormalParameter ::= .VariableModifiersopt Type VariableDeclaratorId 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "char" with rule 461

FormalParameter ::= .VariableModifiersopt Type VariableDeclaratorId 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "long" with rule 461

FormalParameter ::= .VariableModifiersopt Type VariableDeclaratorId 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "int" with rule 461

FormalParameter ::= .VariableModifiersopt Type VariableDeclaratorId 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "short" with rule 461

FormalParameter ::= .VariableModifiersopt Type VariableDeclaratorId 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "byte" with rule 461

FormalParameter ::= .VariableModifiersopt Type VariableDeclaratorId 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "boolean" with rule 461

FormalParameter ::= .VariableModifiersopt Type VariableDeclaratorId 
VariableModifiersopt ::= . (461)




STATE 375 ----------------------------------------------------------------------
( 349 )

ConstructorBody ::= LBRACE  .ExplicitConstructorInvocationopt 
                    BlockStatementsopt RBRACE 

identifier ::= .IDENTIFIER 
Type ::= .PrimitiveType 
Type ::= .ReferenceType 
PrimitiveType ::= .NumericType 
PrimitiveType ::= .boolean 
NumericType ::= .IntegralType 
NumericType ::= .FloatingPointType 
IntegralType ::= .byte 
IntegralType ::= .short 
IntegralType ::= .int 
IntegralType ::= .long 
IntegralType ::= .char 
FloatingPointType ::= .float 
FloatingPointType ::= .double 
ReferenceType ::= .ClassOrInterfaceType 
ReferenceType ::= .TypeVariable 
ReferenceType ::= .ArrayType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= .identifier 
TypeName ::= .TypeName DOT identifier 
ClassName ::= .TypeName 
TypeVariable ::= .identifier 
ArrayType ::= .Type LBRACKET RBRACKET 
TypeArguments ::= .LESS ActualTypeArgumentList GREATER 
ExpressionName ::= .identifier 
ExpressionName ::= .AmbiguousName DOT identifier 
MethodName ::= .identifier 
MethodName ::= .AmbiguousName DOT identifier 
AmbiguousName ::= .identifier 
AmbiguousName ::= .AmbiguousName DOT identifier 
ExplicitConstructorInvocation ::= .TypeArgumentsopt this LPAREN ArgumentListopt 
                                  RPAREN SEMICOLON 
ExplicitConstructorInvocation ::= .TypeArgumentsopt super LPAREN 
                                  ArgumentListopt RPAREN SEMICOLON 
ExplicitConstructorInvocation ::= .Primary DOT TypeArgumentsopt super LPAREN 
                                  ArgumentListopt RPAREN SEMICOLON 
Primary ::= .PrimaryNoNewArray 
Primary ::= .ArrayCreationExpression 
PrimaryNoNewArray ::= .Literal 
PrimaryNoNewArray ::= .Type DOT class 
PrimaryNoNewArray ::= .void DOT class 
PrimaryNoNewArray ::= .this 
PrimaryNoNewArray ::= .ClassName DOT this 
PrimaryNoNewArray ::= .LPAREN Expression RPAREN 
PrimaryNoNewArray ::= .ClassInstanceCreationExpression 
PrimaryNoNewArray ::= .FieldAccess 
PrimaryNoNewArray ::= .MethodInvocation 
PrimaryNoNewArray ::= .ArrayAccess 
Literal ::= .IntegerLiteral 
Literal ::= .LongLiteral 
Literal ::= .FloatingPointLiteral 
Literal ::= .DoubleLiteral 
Literal ::= .BooleanLiteral 
Literal ::= .CharacterLiteral 
Literal ::= .StringLiteral 
Literal ::= .null 
BooleanLiteral ::= .true 
BooleanLiteral ::= .false 
ClassInstanceCreationExpression ::= .new TypeArgumentsopt ClassOrInterfaceType 
                                    TypeArgumentsopt LPAREN ArgumentListopt 
                                    RPAREN ClassBodyopt 
ClassInstanceCreationExpression ::= .Primary DOT new TypeArgumentsopt 
                                    identifier TypeArgumentsopt LPAREN 
                                    ArgumentListopt RPAREN ClassBodyopt 
ClassInstanceCreationExpression ::= .name DOT new TypeArgumentsopt identifier 
                                    TypeArgumentsopt LPAREN ArgumentListopt 
                                    RPAREN ClassBodyopt 
ArrayCreationExpression ::= .new PrimitiveType DimExprs Dimsopt 
ArrayCreationExpression ::= .new ClassOrInterfaceType DimExprs Dimsopt 
ArrayCreationExpression ::= .new PrimitiveType Dims ArrayInitializer 
ArrayCreationExpression ::= .new ClassOrInterfaceType Dims ArrayInitializer 
FieldAccess ::= .Primary DOT identifier 
FieldAccess ::= .super DOT identifier 
FieldAccess ::= .ClassName DOT super DOT identifier 
MethodInvocation ::= .MethodName LPAREN ArgumentListopt RPAREN 
MethodInvocation ::= .Primary DOT TypeArgumentsopt identifier LPAREN 
                     ArgumentListopt RPAREN 
MethodInvocation ::= .super DOT TypeArgumentsopt identifier LPAREN 
                     ArgumentListopt RPAREN 
MethodInvocation ::= .ClassName DOT super DOT TypeArgumentsopt identifier 
                     LPAREN ArgumentListopt RPAREN 
MethodInvocation ::= .TypeName DOT TypeArguments identifier LPAREN 
                     ArgumentListopt RPAREN 
ArrayAccess ::= .ExpressionName LBRACKET Expression RBRACKET 
ArrayAccess ::= .PrimaryNoNewArray LBRACKET Expression RBRACKET 
ExplicitConstructorInvocationopt ::= . (497)
ExplicitConstructorInvocationopt ::= .ExplicitConstructorInvocation 
TypeArgumentsopt ::= . (535)
TypeArgumentsopt ::= .TypeArguments 

*** Shift/reduce conflict on "null" with rule 497

ConstructorBody ::= LBRACE  .ExplicitConstructorInvocationopt 
                    BlockStatementsopt RBRACE 
ExplicitConstructorInvocationopt ::= . (497)

*** Shift/reduce conflict on "StringLiteral" with rule 497

ConstructorBody ::= LBRACE  .ExplicitConstructorInvocationopt 
                    BlockStatementsopt RBRACE 
ExplicitConstructorInvocationopt ::= . (497)

*** Shift/reduce conflict on "CharacterLiteral" with rule 497

ConstructorBody ::= LBRACE  .ExplicitConstructorInvocationopt 
                    BlockStatementsopt RBRACE 
ExplicitConstructorInvocationopt ::= . (497)

*** Shift/reduce conflict on "DoubleLiteral" with rule 497

ConstructorBody ::= LBRACE  .ExplicitConstructorInvocationopt 
                    BlockStatementsopt RBRACE 
ExplicitConstructorInvocationopt ::= . (497)

*** Shift/reduce conflict on "FloatingPointLiteral" with rule 497

ConstructorBody ::= LBRACE  .ExplicitConstructorInvocationopt 
                    BlockStatementsopt RBRACE 
ExplicitConstructorInvocationopt ::= . (497)

*** Shift/reduce conflict on "LongLiteral" with rule 497

ConstructorBody ::= LBRACE  .ExplicitConstructorInvocationopt 
                    BlockStatementsopt RBRACE 
ExplicitConstructorInvocationopt ::= . (497)

*** Shift/reduce conflict on "IntegerLiteral" with rule 497

ConstructorBody ::= LBRACE  .ExplicitConstructorInvocationopt 
                    BlockStatementsopt RBRACE 
ExplicitConstructorInvocationopt ::= . (497)

*** Shift/reduce conflict on "false" with rule 497

ConstructorBody ::= LBRACE  .ExplicitConstructorInvocationopt 
                    BlockStatementsopt RBRACE 
ExplicitConstructorInvocationopt ::= . (497)

*** Shift/reduce conflict on "true" with rule 497

ConstructorBody ::= LBRACE  .ExplicitConstructorInvocationopt 
                    BlockStatementsopt RBRACE 
ExplicitConstructorInvocationopt ::= . (497)

*** Shift/reduce conflict on "IDENTIFIER" with rule 497

ConstructorBody ::= LBRACE  .ExplicitConstructorInvocationopt 
                    BlockStatementsopt RBRACE 
ExplicitConstructorInvocationopt ::= . (497)

*** Shift/reduce conflict on "double" with rule 497

ConstructorBody ::= LBRACE  .ExplicitConstructorInvocationopt 
                    BlockStatementsopt RBRACE 
ExplicitConstructorInvocationopt ::= . (497)

*** Shift/reduce conflict on "float" with rule 497

ConstructorBody ::= LBRACE  .ExplicitConstructorInvocationopt 
                    BlockStatementsopt RBRACE 
ExplicitConstructorInvocationopt ::= . (497)

*** Shift/reduce conflict on "char" with rule 497

ConstructorBody ::= LBRACE  .ExplicitConstructorInvocationopt 
                    BlockStatementsopt RBRACE 
ExplicitConstructorInvocationopt ::= . (497)

*** Shift/reduce conflict on "long" with rule 497

ConstructorBody ::= LBRACE  .ExplicitConstructorInvocationopt 
                    BlockStatementsopt RBRACE 
ExplicitConstructorInvocationopt ::= . (497)

*** Shift/reduce conflict on "int" with rule 497

ConstructorBody ::= LBRACE  .ExplicitConstructorInvocationopt 
                    BlockStatementsopt RBRACE 
ExplicitConstructorInvocationopt ::= . (497)

*** Shift/reduce conflict on "short" with rule 497

ConstructorBody ::= LBRACE  .ExplicitConstructorInvocationopt 
                    BlockStatementsopt RBRACE 
ExplicitConstructorInvocationopt ::= . (497)

*** Shift/reduce conflict on "byte" with rule 497

ConstructorBody ::= LBRACE  .ExplicitConstructorInvocationopt 
                    BlockStatementsopt RBRACE 
ExplicitConstructorInvocationopt ::= . (497)

*** Shift/reduce conflict on "boolean" with rule 497

ConstructorBody ::= LBRACE  .ExplicitConstructorInvocationopt 
                    BlockStatementsopt RBRACE 
ExplicitConstructorInvocationopt ::= . (497)

*** Shift/reduce conflict on "name" with rule 497

ConstructorBody ::= LBRACE  .ExplicitConstructorInvocationopt 
                    BlockStatementsopt RBRACE 
ExplicitConstructorInvocationopt ::= . (497)

*** Shift/reduce conflict on "new" with rule 497

ConstructorBody ::= LBRACE  .ExplicitConstructorInvocationopt 
                    BlockStatementsopt RBRACE 
ExplicitConstructorInvocationopt ::= . (497)

*** Shift/reduce conflict on "super" with rule 535

ExplicitConstructorInvocation ::= .TypeArgumentsopt super LPAREN 
                                  ArgumentListopt RPAREN SEMICOLON 
TypeArgumentsopt ::= . (535)

*** Shift/reduce conflict on "super" with rule 497

ConstructorBody ::= LBRACE  .ExplicitConstructorInvocationopt 
                    BlockStatementsopt RBRACE 
ExplicitConstructorInvocationopt ::= . (497)

*** Shift/reduce conflict on "LPAREN" with rule 497

ConstructorBody ::= LBRACE  .ExplicitConstructorInvocationopt 
                    BlockStatementsopt RBRACE 
ExplicitConstructorInvocationopt ::= . (497)

*** Shift/reduce conflict on "this" with rule 535

ExplicitConstructorInvocation ::= .TypeArgumentsopt this LPAREN ArgumentListopt 
                                  RPAREN SEMICOLON 
TypeArgumentsopt ::= . (535)

*** Shift/reduce conflict on "this" with rule 497

ConstructorBody ::= LBRACE  .ExplicitConstructorInvocationopt 
                    BlockStatementsopt RBRACE 
ExplicitConstructorInvocationopt ::= . (497)

*** Shift/reduce conflict on "void" with rule 497

ConstructorBody ::= LBRACE  .ExplicitConstructorInvocationopt 
                    BlockStatementsopt RBRACE 
ExplicitConstructorInvocationopt ::= . (497)




STATE 396 ----------------------------------------------------------------------
( 375 )

ConstructorBody ::= LBRACE ExplicitConstructorInvocationopt  .
                    BlockStatementsopt RBRACE 

identifier ::= .IDENTIFIER 
Type ::= .PrimitiveType 
Type ::= .ReferenceType 
PrimitiveType ::= .NumericType 
PrimitiveType ::= .boolean 
NumericType ::= .IntegralType 
NumericType ::= .FloatingPointType 
IntegralType ::= .byte 
IntegralType ::= .short 
IntegralType ::= .int 
IntegralType ::= .long 
IntegralType ::= .char 
FloatingPointType ::= .float 
FloatingPointType ::= .double 
ReferenceType ::= .ClassOrInterfaceType 
ReferenceType ::= .TypeVariable 
ReferenceType ::= .ArrayType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= .identifier 
TypeName ::= .TypeName DOT identifier 
ClassName ::= .TypeName 
TypeVariable ::= .identifier 
ArrayType ::= .Type LBRACKET RBRACKET 
ExpressionName ::= .identifier 
ExpressionName ::= .AmbiguousName DOT identifier 
MethodName ::= .identifier 
MethodName ::= .AmbiguousName DOT identifier 
AmbiguousName ::= .identifier 
AmbiguousName ::= .AmbiguousName DOT identifier 
ClassDeclaration ::= .NormalClassDeclaration 
ClassDeclaration ::= .EnumDeclaration 
NormalClassDeclaration ::= .ClassModifiersopt class identifier 
                           TypeParametersopt Superopt Interfacesopt ClassBody 
ClassModifiers ::= .ClassModifier 
ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifier ::= .Annotation 
ClassModifier ::= .public 
ClassModifier ::= .protected 
ClassModifier ::= .private 
ClassModifier ::= .abstract 
ClassModifier ::= .static 
ClassModifier ::= .final 
ClassModifier ::= .strictfp 
VariableModifiers ::= .VariableModifier 
VariableModifiers ::= .VariableModifiers VariableModifier 
VariableModifier ::= .final 
VariableModifier ::= .Annotations 
EnumDeclaration ::= .ClassModifiersopt enum identifier Interfacesopt EnumBody 
Annotations ::= .Annotation 
Annotations ::= .Annotations Annotation 
Annotation ::= .NormalAnnotation 
Annotation ::= .MarkerAnnotation 
Annotation ::= .SingleElementAnnotation 
NormalAnnotation ::= .AT TypeName LPAREN ElementValuePairsopt RPAREN 
MarkerAnnotation ::= .AT TypeName 
SingleElementAnnotation ::= .AT TypeName LPAREN ElementValue RPAREN 
Block ::= .LBRACE BlockStatementsopt RBRACE 
BlockStatements ::= .BlockStatement 
BlockStatements ::= .BlockStatements BlockStatement 
BlockStatement ::= .LocalVariableDeclarationStatement 
BlockStatement ::= .ClassDeclaration 
BlockStatement ::= .Statement 
LocalVariableDeclarationStatement ::= .LocalVariableDeclaration SEMICOLON 
LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
Statement ::= .StatementWithoutTrailingSubstatement 
Statement ::= .LabeledStatement 
Statement ::= .IfThenStatement 
Statement ::= .IfThenElseStatement 
Statement ::= .WhileStatement 
Statement ::= .ForStatement 
StatementWithoutTrailingSubstatement ::= .Block 
StatementWithoutTrailingSubstatement ::= .EmptyStatement 
StatementWithoutTrailingSubstatement ::= .ExpressionStatement 
StatementWithoutTrailingSubstatement ::= .AssertStatement 
StatementWithoutTrailingSubstatement ::= .SwitchStatement 
StatementWithoutTrailingSubstatement ::= .DoStatement 
StatementWithoutTrailingSubstatement ::= .BreakStatement 
StatementWithoutTrailingSubstatement ::= .ContinueStatement 
StatementWithoutTrailingSubstatement ::= .ReturnStatement 
StatementWithoutTrailingSubstatement ::= .SynchronizedStatement 
StatementWithoutTrailingSubstatement ::= .ThrowStatement 
StatementWithoutTrailingSubstatement ::= .TryStatement 
IfThenStatement ::= .if LPAREN Expression RPAREN Statement 
IfThenElseStatement ::= .if LPAREN Expression RPAREN StatementNoShortIf else 
                        Statement 
EmptyStatement ::= .SEMICOLON 
EmptyStatement ::= .ERROR_TOKEN 
LabeledStatement ::= .identifier COLON Statement 
ExpressionStatement ::= .StatementExpression SEMICOLON 
StatementExpression ::= .Assignment 
StatementExpression ::= .PreIncrementExpression 
StatementExpression ::= .PreDecrementExpression 
StatementExpression ::= .PostIncrementExpression 
StatementExpression ::= .PostDecrementExpression 
StatementExpression ::= .MethodInvocation 
StatementExpression ::= .ClassInstanceCreationExpression 
AssertStatement ::= .assert Expression SEMICOLON 
AssertStatement ::= .assert Expression COLON Expression SEMICOLON 
SwitchStatement ::= .switch LPAREN Expression RPAREN SwitchBlock 
WhileStatement ::= .while LPAREN Expression RPAREN Statement 
DoStatement ::= .do Statement while LPAREN Expression RPAREN SEMICOLON 
ForStatement ::= .BasicForStatement 
ForStatement ::= .EnhancedForStatement 
BasicForStatement ::= .for LPAREN ForInitopt SEMICOLON Expressionopt SEMICOLON 
                      ForUpdateopt RPAREN Statement 
EnhancedForStatement ::= .for LPAREN FormalParameter COLON Expression RPAREN 
                         Statement 
BreakStatement ::= .break identifieropt SEMICOLON 
ContinueStatement ::= .continue identifieropt SEMICOLON 
ReturnStatement ::= .return Expressionopt SEMICOLON 
ThrowStatement ::= .throw Expression SEMICOLON 
SynchronizedStatement ::= .synchronized LPAREN Expression RPAREN Block 
TryStatement ::= .try Block Catches 
TryStatement ::= .try Block Catchesopt Finally 
Primary ::= .PrimaryNoNewArray 
Primary ::= .ArrayCreationExpression 
PrimaryNoNewArray ::= .Literal 
PrimaryNoNewArray ::= .Type DOT class 
PrimaryNoNewArray ::= .void DOT class 
PrimaryNoNewArray ::= .this 
PrimaryNoNewArray ::= .ClassName DOT this 
PrimaryNoNewArray ::= .LPAREN Expression RPAREN 
PrimaryNoNewArray ::= .ClassInstanceCreationExpression 
PrimaryNoNewArray ::= .FieldAccess 
PrimaryNoNewArray ::= .MethodInvocation 
PrimaryNoNewArray ::= .ArrayAccess 
Literal ::= .IntegerLiteral 
Literal ::= .LongLiteral 
Literal ::= .FloatingPointLiteral 
Literal ::= .DoubleLiteral 
Literal ::= .BooleanLiteral 
Literal ::= .CharacterLiteral 
Literal ::= .StringLiteral 
Literal ::= .null 
BooleanLiteral ::= .true 
BooleanLiteral ::= .false 
ClassInstanceCreationExpression ::= .new TypeArgumentsopt ClassOrInterfaceType 
                                    TypeArgumentsopt LPAREN ArgumentListopt 
                                    RPAREN ClassBodyopt 
ClassInstanceCreationExpression ::= .Primary DOT new TypeArgumentsopt 
                                    identifier TypeArgumentsopt LPAREN 
                                    ArgumentListopt RPAREN ClassBodyopt 
ClassInstanceCreationExpression ::= .name DOT new TypeArgumentsopt identifier 
                                    TypeArgumentsopt LPAREN ArgumentListopt 
                                    RPAREN ClassBodyopt 
ArrayCreationExpression ::= .new PrimitiveType DimExprs Dimsopt 
ArrayCreationExpression ::= .new ClassOrInterfaceType DimExprs Dimsopt 
ArrayCreationExpression ::= .new PrimitiveType Dims ArrayInitializer 
ArrayCreationExpression ::= .new ClassOrInterfaceType Dims ArrayInitializer 
FieldAccess ::= .Primary DOT identifier 
FieldAccess ::= .super DOT identifier 
FieldAccess ::= .ClassName DOT super DOT identifier 
MethodInvocation ::= .MethodName LPAREN ArgumentListopt RPAREN 
MethodInvocation ::= .Primary DOT TypeArgumentsopt identifier LPAREN 
                     ArgumentListopt RPAREN 
MethodInvocation ::= .super DOT TypeArgumentsopt identifier LPAREN 
                     ArgumentListopt RPAREN 
MethodInvocation ::= .ClassName DOT super DOT TypeArgumentsopt identifier 
                     LPAREN ArgumentListopt RPAREN 
MethodInvocation ::= .TypeName DOT TypeArguments identifier LPAREN 
                     ArgumentListopt RPAREN 
ArrayAccess ::= .ExpressionName LBRACKET Expression RBRACKET 
ArrayAccess ::= .PrimaryNoNewArray LBRACKET Expression RBRACKET 
PostfixExpression ::= .Primary 
PostfixExpression ::= .ExpressionName 
PostfixExpression ::= .PostIncrementExpression 
PostfixExpression ::= .PostDecrementExpression 
PostIncrementExpression ::= .PostfixExpression PLUS_PLUS 
PostDecrementExpression ::= .PostfixExpression MINUS_MINUS 
PreIncrementExpression ::= .PLUS_PLUS UnaryExpression 
PreDecrementExpression ::= .MINUS_MINUS UnaryExpression 
Assignment ::= .LeftHandSide AssignmentOperator AssignmentExpression 
LeftHandSide ::= .ExpressionName 
LeftHandSide ::= .FieldAccess 
LeftHandSide ::= .ArrayAccess 
VariableModifiersopt ::= . (461)
VariableModifiersopt ::= .VariableModifiers 
BlockStatementsopt ::= . (495)
BlockStatementsopt ::= .BlockStatements 
ClassModifiersopt ::= . (519)
ClassModifiersopt ::= .ClassModifiers 

*** Shift/reduce conflict on "boolean" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "char" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "long" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "int" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "short" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "byte" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "double" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "float" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "IDENTIFIER" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)




STATE 414 ----------------------------------------------------------------------
( 394 )

ArrayType ::= Type  .LBRACKET RBRACKET 
FormalParameter ::= VariableModifiersopt Type  .VariableDeclaratorId 
LastFormalParameter ::= VariableModifiersopt Type  ....opt VariableDeclaratorId 

identifier ::= .IDENTIFIER 
VariableDeclaratorId ::= .identifier 
VariableDeclaratorId ::= .VariableDeclaratorId LBRACKET RBRACKET 
...opt ::= . (501)
...opt ::= .ELLIPSIS 

*** Shift/reduce conflict on "IDENTIFIER" with rule 501

LastFormalParameter ::= VariableModifiersopt Type  ....opt VariableDeclaratorId 
...opt ::= . (501)




STATE 417 ----------------------------------------------------------------------
( 398 )

ExplicitConstructorInvocation ::= Primary DOT  .TypeArgumentsopt super LPAREN 
                                  ArgumentListopt RPAREN SEMICOLON 
ClassInstanceCreationExpression ::= Primary DOT  .new TypeArgumentsopt 
                                    identifier TypeArgumentsopt LPAREN 
                                    ArgumentListopt RPAREN ClassBodyopt 
FieldAccess ::= Primary DOT  .identifier 
MethodInvocation ::= Primary DOT  .TypeArgumentsopt identifier LPAREN 
                     ArgumentListopt RPAREN 

identifier ::= .IDENTIFIER 
TypeArguments ::= .LESS ActualTypeArgumentList GREATER 
TypeArgumentsopt ::= . (535)
TypeArgumentsopt ::= .TypeArguments 

*** Shift/reduce conflict on "IDENTIFIER" with rule 535

MethodInvocation ::= Primary DOT  .TypeArgumentsopt identifier LPAREN 
                     ArgumentListopt RPAREN 
TypeArgumentsopt ::= . (535)




STATE 423 ----------------------------------------------------------------------
( 406 )

SwitchBlock ::= LBRACE  .SwitchBlockStatementGroupsopt SwitchLabelsopt RBRACE 

SwitchBlockStatementGroups ::= .SwitchBlockStatementGroup 
SwitchBlockStatementGroups ::= .SwitchBlockStatementGroups 
                               SwitchBlockStatementGroup 
SwitchBlockStatementGroup ::= .SwitchLabels BlockStatements 
SwitchLabels ::= .SwitchLabel 
SwitchLabels ::= .SwitchLabels SwitchLabel 
SwitchLabel ::= .case ConstantExpression COLON 
SwitchLabel ::= .case EnumConstant COLON 
SwitchLabel ::= .default COLON 
SwitchBlockStatementGroupsopt ::= . (459)
SwitchBlockStatementGroupsopt ::= .SwitchBlockStatementGroups 

*** Shift/reduce conflict on "default" with rule 459

SwitchBlock ::= LBRACE  .SwitchBlockStatementGroupsopt SwitchLabelsopt RBRACE 
SwitchBlockStatementGroupsopt ::= . (459)

*** Shift/reduce conflict on "case" with rule 459

SwitchBlock ::= LBRACE  .SwitchBlockStatementGroupsopt SwitchLabelsopt RBRACE 
SwitchBlockStatementGroupsopt ::= . (459)




STATE 429 ----------------------------------------------------------------------
( 408 450 472 473 480 482 )

TypeName ::= identifier . (21)
TypeVariable ::= identifier . (24)
ExpressionName ::= identifier . (41)
MethodName ::= identifier . (43)
AmbiguousName ::= identifier . (47)
LabeledStatement ::= identifier  .COLON Statement 
LabeledStatementNoShortIf ::= identifier  .COLON StatementNoShortIf 

*** Reduce/reduce conflict on "LBRACKET" between rule 21 and 41

ArrayType ::= .Type LBRACKET RBRACKET 
Type ::= .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
ArrayAccess ::= .ExpressionName LBRACKET Expression RBRACKET 
ExpressionName ::= identifier . (41)

*** Reduce/reduce conflict on "LBRACKET" between rule 21 and 24

ArrayType ::= .Type LBRACKET RBRACKET 
Type ::= .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
ArrayType ::= .Type LBRACKET RBRACKET 
Type ::= .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "DOT" between rule 21 and 47

PrimaryNoNewArray ::= .Type DOT class 
Type ::= .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
ExpressionName ::= .AmbiguousName DOT identifier 
AmbiguousName ::= identifier . (47)

*** Reduce/reduce conflict on "DOT" between rule 21 and 24

PrimaryNoNewArray ::= .Type DOT class 
Type ::= .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
PrimaryNoNewArray ::= .Type DOT class 
Type ::= .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)




STATE 443 ----------------------------------------------------------------------
( 423 441 444 445 458 )

SwitchLabel ::= case  .ConstantExpression COLON 
SwitchLabel ::= case  .EnumConstant COLON 

identifier ::= .IDENTIFIER 
Type ::= .PrimitiveType 
Type ::= .ReferenceType 
PrimitiveType ::= .NumericType 
PrimitiveType ::= .boolean 
NumericType ::= .IntegralType 
NumericType ::= .FloatingPointType 
IntegralType ::= .byte 
IntegralType ::= .short 
IntegralType ::= .int 
IntegralType ::= .long 
IntegralType ::= .char 
FloatingPointType ::= .float 
FloatingPointType ::= .double 
ReferenceType ::= .ClassOrInterfaceType 
ReferenceType ::= .TypeVariable 
ReferenceType ::= .ArrayType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= .identifier 
TypeName ::= .TypeName DOT identifier 
ClassName ::= .TypeName 
TypeVariable ::= .identifier 
ArrayType ::= .Type LBRACKET RBRACKET 
ExpressionName ::= .identifier 
ExpressionName ::= .AmbiguousName DOT identifier 
MethodName ::= .identifier 
MethodName ::= .AmbiguousName DOT identifier 
AmbiguousName ::= .identifier 
AmbiguousName ::= .AmbiguousName DOT identifier 
EnumConstant ::= .Annotationsopt identifier Argumentsopt ClassBodyopt 
Annotations ::= .Annotation 
Annotations ::= .Annotations Annotation 
Annotation ::= .NormalAnnotation 
Annotation ::= .MarkerAnnotation 
Annotation ::= .SingleElementAnnotation 
NormalAnnotation ::= .AT TypeName LPAREN ElementValuePairsopt RPAREN 
MarkerAnnotation ::= .AT TypeName 
SingleElementAnnotation ::= .AT TypeName LPAREN ElementValue RPAREN 
EnumConstant ::= .identifier 
Primary ::= .PrimaryNoNewArray 
Primary ::= .ArrayCreationExpression 
PrimaryNoNewArray ::= .Literal 
PrimaryNoNewArray ::= .Type DOT class 
PrimaryNoNewArray ::= .void DOT class 
PrimaryNoNewArray ::= .this 
PrimaryNoNewArray ::= .ClassName DOT this 
PrimaryNoNewArray ::= .LPAREN Expression RPAREN 
PrimaryNoNewArray ::= .ClassInstanceCreationExpression 
PrimaryNoNewArray ::= .FieldAccess 
PrimaryNoNewArray ::= .MethodInvocation 
PrimaryNoNewArray ::= .ArrayAccess 
Literal ::= .IntegerLiteral 
Literal ::= .LongLiteral 
Literal ::= .FloatingPointLiteral 
Literal ::= .DoubleLiteral 
Literal ::= .BooleanLiteral 
Literal ::= .CharacterLiteral 
Literal ::= .StringLiteral 
Literal ::= .null 
BooleanLiteral ::= .true 
BooleanLiteral ::= .false 
ClassInstanceCreationExpression ::= .new TypeArgumentsopt ClassOrInterfaceType 
                                    TypeArgumentsopt LPAREN ArgumentListopt 
                                    RPAREN ClassBodyopt 
ClassInstanceCreationExpression ::= .Primary DOT new TypeArgumentsopt 
                                    identifier TypeArgumentsopt LPAREN 
                                    ArgumentListopt RPAREN ClassBodyopt 
ClassInstanceCreationExpression ::= .name DOT new TypeArgumentsopt identifier 
                                    TypeArgumentsopt LPAREN ArgumentListopt 
                                    RPAREN ClassBodyopt 
ArrayCreationExpression ::= .new PrimitiveType DimExprs Dimsopt 
ArrayCreationExpression ::= .new ClassOrInterfaceType DimExprs Dimsopt 
ArrayCreationExpression ::= .new PrimitiveType Dims ArrayInitializer 
ArrayCreationExpression ::= .new ClassOrInterfaceType Dims ArrayInitializer 
FieldAccess ::= .Primary DOT identifier 
FieldAccess ::= .super DOT identifier 
FieldAccess ::= .ClassName DOT super DOT identifier 
MethodInvocation ::= .MethodName LPAREN ArgumentListopt RPAREN 
MethodInvocation ::= .Primary DOT TypeArgumentsopt identifier LPAREN 
                     ArgumentListopt RPAREN 
MethodInvocation ::= .super DOT TypeArgumentsopt identifier LPAREN 
                     ArgumentListopt RPAREN 
MethodInvocation ::= .ClassName DOT super DOT TypeArgumentsopt identifier 
                     LPAREN ArgumentListopt RPAREN 
MethodInvocation ::= .TypeName DOT TypeArguments identifier LPAREN 
                     ArgumentListopt RPAREN 
ArrayAccess ::= .ExpressionName LBRACKET Expression RBRACKET 
ArrayAccess ::= .PrimaryNoNewArray LBRACKET Expression RBRACKET 
PostfixExpression ::= .Primary 
PostfixExpression ::= .ExpressionName 
PostfixExpression ::= .PostIncrementExpression 
PostfixExpression ::= .PostDecrementExpression 
PostIncrementExpression ::= .PostfixExpression PLUS_PLUS 
PostDecrementExpression ::= .PostfixExpression MINUS_MINUS 
UnaryExpression ::= .PreIncrementExpression 
UnaryExpression ::= .PreDecrementExpression 
UnaryExpression ::= .PLUS UnaryExpression 
UnaryExpression ::= .MINUS UnaryExpression 
UnaryExpression ::= .UnaryExpressionNotPlusMinus 
PreIncrementExpression ::= .PLUS_PLUS UnaryExpression 
PreDecrementExpression ::= .MINUS_MINUS UnaryExpression 
UnaryExpressionNotPlusMinus ::= .PostfixExpression 
UnaryExpressionNotPlusMinus ::= .TWIDDLE UnaryExpression 
UnaryExpressionNotPlusMinus ::= .NOT UnaryExpression 
UnaryExpressionNotPlusMinus ::= .CastExpression 
CastExpression ::= .LPAREN PrimitiveType Dimsopt RPAREN UnaryExpression 
CastExpression ::= .LPAREN ReferenceType RPAREN UnaryExpressionNotPlusMinus 
MultiplicativeExpression ::= .UnaryExpression 
MultiplicativeExpression ::= .MultiplicativeExpression MULTIPLY UnaryExpression 
MultiplicativeExpression ::= .MultiplicativeExpression DIVIDE UnaryExpression 
MultiplicativeExpression ::= .MultiplicativeExpression REMAINDER 
                             UnaryExpression 
AdditiveExpression ::= .MultiplicativeExpression 
AdditiveExpression ::= .AdditiveExpression PLUS MultiplicativeExpression 
AdditiveExpression ::= .AdditiveExpression MINUS MultiplicativeExpression 
ShiftExpression ::= .AdditiveExpression 
ShiftExpression ::= .ShiftExpression LEFT_SHIFT AdditiveExpression 
ShiftExpression ::= .ShiftExpression GREATER GREATER AdditiveExpression 
ShiftExpression ::= .ShiftExpression GREATER GREATER GREATER AdditiveExpression 
RelationalExpression ::= .ShiftExpression 
RelationalExpression ::= .RelationalExpression LESS ShiftExpression 
RelationalExpression ::= .RelationalExpression GREATER ShiftExpression 
RelationalExpression ::= .RelationalExpression LESS_EQUAL ShiftExpression 
RelationalExpression ::= .RelationalExpression GREATER EQUAL ShiftExpression 
RelationalExpression ::= .RelationalExpression instanceof ReferenceType 
EqualityExpression ::= .RelationalExpression 
EqualityExpression ::= .EqualityExpression EQUAL_EQUAL RelationalExpression 
EqualityExpression ::= .EqualityExpression NOT_EQUAL RelationalExpression 
AndExpression ::= .EqualityExpression 
AndExpression ::= .AndExpression AND EqualityExpression 
ExclusiveOrExpression ::= .AndExpression 
ExclusiveOrExpression ::= .ExclusiveOrExpression XOR AndExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
InclusiveOrExpression ::= .InclusiveOrExpression OR ExclusiveOrExpression 
ConditionalAndExpression ::= .InclusiveOrExpression 
ConditionalAndExpression ::= .ConditionalAndExpression AND_AND 
                             InclusiveOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalOrExpression ::= .ConditionalOrExpression OR_OR 
                            ConditionalAndExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalExpression ::= .ConditionalOrExpression QUESTION Expression COLON 
                          ConditionalExpression 
AssignmentExpression ::= .ConditionalExpression 
AssignmentExpression ::= .Assignment 
Assignment ::= .LeftHandSide AssignmentOperator AssignmentExpression 
LeftHandSide ::= .ExpressionName 
LeftHandSide ::= .FieldAccess 
LeftHandSide ::= .ArrayAccess 
Expression ::= .AssignmentExpression 
ConstantExpression ::= .Expression 
Annotationsopt ::= . (521)
Annotationsopt ::= .Annotations 

*** Shift/reduce conflict on "IDENTIFIER" with rule 521

EnumConstant ::= .Annotationsopt identifier Argumentsopt ClassBodyopt 
Annotationsopt ::= . (521)




STATE 444 ----------------------------------------------------------------------
( 423 445 )

SwitchBlockStatementGroup ::= SwitchLabels  .BlockStatements 
SwitchLabels ::= SwitchLabels  .SwitchLabel 

identifier ::= .IDENTIFIER 
Type ::= .PrimitiveType 
Type ::= .ReferenceType 
PrimitiveType ::= .NumericType 
PrimitiveType ::= .boolean 
NumericType ::= .IntegralType 
NumericType ::= .FloatingPointType 
IntegralType ::= .byte 
IntegralType ::= .short 
IntegralType ::= .int 
IntegralType ::= .long 
IntegralType ::= .char 
FloatingPointType ::= .float 
FloatingPointType ::= .double 
ReferenceType ::= .ClassOrInterfaceType 
ReferenceType ::= .TypeVariable 
ReferenceType ::= .ArrayType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= .identifier 
TypeName ::= .TypeName DOT identifier 
ClassName ::= .TypeName 
TypeVariable ::= .identifier 
ArrayType ::= .Type LBRACKET RBRACKET 
ExpressionName ::= .identifier 
ExpressionName ::= .AmbiguousName DOT identifier 
MethodName ::= .identifier 
MethodName ::= .AmbiguousName DOT identifier 
AmbiguousName ::= .identifier 
AmbiguousName ::= .AmbiguousName DOT identifier 
ClassDeclaration ::= .NormalClassDeclaration 
ClassDeclaration ::= .EnumDeclaration 
NormalClassDeclaration ::= .ClassModifiersopt class identifier 
                           TypeParametersopt Superopt Interfacesopt ClassBody 
ClassModifiers ::= .ClassModifier 
ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifier ::= .Annotation 
ClassModifier ::= .public 
ClassModifier ::= .protected 
ClassModifier ::= .private 
ClassModifier ::= .abstract 
ClassModifier ::= .static 
ClassModifier ::= .final 
ClassModifier ::= .strictfp 
VariableModifiers ::= .VariableModifier 
VariableModifiers ::= .VariableModifiers VariableModifier 
VariableModifier ::= .final 
VariableModifier ::= .Annotations 
EnumDeclaration ::= .ClassModifiersopt enum identifier Interfacesopt EnumBody 
Annotations ::= .Annotation 
Annotations ::= .Annotations Annotation 
Annotation ::= .NormalAnnotation 
Annotation ::= .MarkerAnnotation 
Annotation ::= .SingleElementAnnotation 
NormalAnnotation ::= .AT TypeName LPAREN ElementValuePairsopt RPAREN 
MarkerAnnotation ::= .AT TypeName 
SingleElementAnnotation ::= .AT TypeName LPAREN ElementValue RPAREN 
Block ::= .LBRACE BlockStatementsopt RBRACE 
BlockStatements ::= .BlockStatement 
BlockStatements ::= .BlockStatements BlockStatement 
BlockStatement ::= .LocalVariableDeclarationStatement 
BlockStatement ::= .ClassDeclaration 
BlockStatement ::= .Statement 
LocalVariableDeclarationStatement ::= .LocalVariableDeclaration SEMICOLON 
LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
Statement ::= .StatementWithoutTrailingSubstatement 
Statement ::= .LabeledStatement 
Statement ::= .IfThenStatement 
Statement ::= .IfThenElseStatement 
Statement ::= .WhileStatement 
Statement ::= .ForStatement 
StatementWithoutTrailingSubstatement ::= .Block 
StatementWithoutTrailingSubstatement ::= .EmptyStatement 
StatementWithoutTrailingSubstatement ::= .ExpressionStatement 
StatementWithoutTrailingSubstatement ::= .AssertStatement 
StatementWithoutTrailingSubstatement ::= .SwitchStatement 
StatementWithoutTrailingSubstatement ::= .DoStatement 
StatementWithoutTrailingSubstatement ::= .BreakStatement 
StatementWithoutTrailingSubstatement ::= .ContinueStatement 
StatementWithoutTrailingSubstatement ::= .ReturnStatement 
StatementWithoutTrailingSubstatement ::= .SynchronizedStatement 
StatementWithoutTrailingSubstatement ::= .ThrowStatement 
StatementWithoutTrailingSubstatement ::= .TryStatement 
IfThenStatement ::= .if LPAREN Expression RPAREN Statement 
IfThenElseStatement ::= .if LPAREN Expression RPAREN StatementNoShortIf else 
                        Statement 
EmptyStatement ::= .SEMICOLON 
EmptyStatement ::= .ERROR_TOKEN 
LabeledStatement ::= .identifier COLON Statement 
ExpressionStatement ::= .StatementExpression SEMICOLON 
StatementExpression ::= .Assignment 
StatementExpression ::= .PreIncrementExpression 
StatementExpression ::= .PreDecrementExpression 
StatementExpression ::= .PostIncrementExpression 
StatementExpression ::= .PostDecrementExpression 
StatementExpression ::= .MethodInvocation 
StatementExpression ::= .ClassInstanceCreationExpression 
AssertStatement ::= .assert Expression SEMICOLON 
AssertStatement ::= .assert Expression COLON Expression SEMICOLON 
SwitchStatement ::= .switch LPAREN Expression RPAREN SwitchBlock 
SwitchLabel ::= .case ConstantExpression COLON 
SwitchLabel ::= .case EnumConstant COLON 
SwitchLabel ::= .default COLON 
WhileStatement ::= .while LPAREN Expression RPAREN Statement 
DoStatement ::= .do Statement while LPAREN Expression RPAREN SEMICOLON 
ForStatement ::= .BasicForStatement 
ForStatement ::= .EnhancedForStatement 
BasicForStatement ::= .for LPAREN ForInitopt SEMICOLON Expressionopt SEMICOLON 
                      ForUpdateopt RPAREN Statement 
EnhancedForStatement ::= .for LPAREN FormalParameter COLON Expression RPAREN 
                         Statement 
BreakStatement ::= .break identifieropt SEMICOLON 
ContinueStatement ::= .continue identifieropt SEMICOLON 
ReturnStatement ::= .return Expressionopt SEMICOLON 
ThrowStatement ::= .throw Expression SEMICOLON 
SynchronizedStatement ::= .synchronized LPAREN Expression RPAREN Block 
TryStatement ::= .try Block Catches 
TryStatement ::= .try Block Catchesopt Finally 
Primary ::= .PrimaryNoNewArray 
Primary ::= .ArrayCreationExpression 
PrimaryNoNewArray ::= .Literal 
PrimaryNoNewArray ::= .Type DOT class 
PrimaryNoNewArray ::= .void DOT class 
PrimaryNoNewArray ::= .this 
PrimaryNoNewArray ::= .ClassName DOT this 
PrimaryNoNewArray ::= .LPAREN Expression RPAREN 
PrimaryNoNewArray ::= .ClassInstanceCreationExpression 
PrimaryNoNewArray ::= .FieldAccess 
PrimaryNoNewArray ::= .MethodInvocation 
PrimaryNoNewArray ::= .ArrayAccess 
Literal ::= .IntegerLiteral 
Literal ::= .LongLiteral 
Literal ::= .FloatingPointLiteral 
Literal ::= .DoubleLiteral 
Literal ::= .BooleanLiteral 
Literal ::= .CharacterLiteral 
Literal ::= .StringLiteral 
Literal ::= .null 
BooleanLiteral ::= .true 
BooleanLiteral ::= .false 
ClassInstanceCreationExpression ::= .new TypeArgumentsopt ClassOrInterfaceType 
                                    TypeArgumentsopt LPAREN ArgumentListopt 
                                    RPAREN ClassBodyopt 
ClassInstanceCreationExpression ::= .Primary DOT new TypeArgumentsopt 
                                    identifier TypeArgumentsopt LPAREN 
                                    ArgumentListopt RPAREN ClassBodyopt 
ClassInstanceCreationExpression ::= .name DOT new TypeArgumentsopt identifier 
                                    TypeArgumentsopt LPAREN ArgumentListopt 
                                    RPAREN ClassBodyopt 
ArrayCreationExpression ::= .new PrimitiveType DimExprs Dimsopt 
ArrayCreationExpression ::= .new ClassOrInterfaceType DimExprs Dimsopt 
ArrayCreationExpression ::= .new PrimitiveType Dims ArrayInitializer 
ArrayCreationExpression ::= .new ClassOrInterfaceType Dims ArrayInitializer 
FieldAccess ::= .Primary DOT identifier 
FieldAccess ::= .super DOT identifier 
FieldAccess ::= .ClassName DOT super DOT identifier 
MethodInvocation ::= .MethodName LPAREN ArgumentListopt RPAREN 
MethodInvocation ::= .Primary DOT TypeArgumentsopt identifier LPAREN 
                     ArgumentListopt RPAREN 
MethodInvocation ::= .super DOT TypeArgumentsopt identifier LPAREN 
                     ArgumentListopt RPAREN 
MethodInvocation ::= .ClassName DOT super DOT TypeArgumentsopt identifier 
                     LPAREN ArgumentListopt RPAREN 
MethodInvocation ::= .TypeName DOT TypeArguments identifier LPAREN 
                     ArgumentListopt RPAREN 
ArrayAccess ::= .ExpressionName LBRACKET Expression RBRACKET 
ArrayAccess ::= .PrimaryNoNewArray LBRACKET Expression RBRACKET 
PostfixExpression ::= .Primary 
PostfixExpression ::= .ExpressionName 
PostfixExpression ::= .PostIncrementExpression 
PostfixExpression ::= .PostDecrementExpression 
PostIncrementExpression ::= .PostfixExpression PLUS_PLUS 
PostDecrementExpression ::= .PostfixExpression MINUS_MINUS 
PreIncrementExpression ::= .PLUS_PLUS UnaryExpression 
PreDecrementExpression ::= .MINUS_MINUS UnaryExpression 
Assignment ::= .LeftHandSide AssignmentOperator AssignmentExpression 
LeftHandSide ::= .ExpressionName 
LeftHandSide ::= .FieldAccess 
LeftHandSide ::= .ArrayAccess 
VariableModifiersopt ::= . (461)
VariableModifiersopt ::= .VariableModifiers 
ClassModifiersopt ::= . (519)
ClassModifiersopt ::= .ClassModifiers 

*** Shift/reduce conflict on "IDENTIFIER" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "double" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "float" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "char" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "long" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "int" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "short" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "byte" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "boolean" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)




STATE 445 ----------------------------------------------------------------------
( 423 )

SwitchBlockStatementGroups ::= SwitchBlockStatementGroups  .
                               SwitchBlockStatementGroup 
SwitchBlockStatementGroupsopt ::= SwitchBlockStatementGroups . (460)

SwitchBlockStatementGroup ::= .SwitchLabels BlockStatements 
SwitchLabels ::= .SwitchLabel 
SwitchLabels ::= .SwitchLabels SwitchLabel 
SwitchLabel ::= .case ConstantExpression COLON 
SwitchLabel ::= .case EnumConstant COLON 
SwitchLabel ::= .default COLON 

*** Shift/reduce conflict on "default" with rule 460

SwitchBlock ::= LBRACE  .SwitchBlockStatementGroupsopt SwitchLabelsopt RBRACE 
SwitchBlockStatementGroupsopt ::= SwitchBlockStatementGroups . (460)

*** Shift/reduce conflict on "case" with rule 460

SwitchBlock ::= LBRACE  .SwitchBlockStatementGroupsopt SwitchLabelsopt RBRACE 
SwitchBlockStatementGroupsopt ::= SwitchBlockStatementGroups . (460)




STATE 447 ----------------------------------------------------------------------
( 426 )

BasicForStatement ::= for LPAREN  .ForInitopt SEMICOLON Expressionopt SEMICOLON 
                      ForUpdateopt RPAREN Statement 
ForStatementNoShortIf ::= for LPAREN  .ForInitopt SEMICOLON Expressionopt 
                          SEMICOLON ForUpdateopt RPAREN StatementNoShortIf 
EnhancedForStatement ::= for LPAREN  .FormalParameter COLON Expression RPAREN 
                         Statement 

identifier ::= .IDENTIFIER 
Type ::= .PrimitiveType 
Type ::= .ReferenceType 
PrimitiveType ::= .NumericType 
PrimitiveType ::= .boolean 
NumericType ::= .IntegralType 
NumericType ::= .FloatingPointType 
IntegralType ::= .byte 
IntegralType ::= .short 
IntegralType ::= .int 
IntegralType ::= .long 
IntegralType ::= .char 
FloatingPointType ::= .float 
FloatingPointType ::= .double 
ReferenceType ::= .ClassOrInterfaceType 
ReferenceType ::= .TypeVariable 
ReferenceType ::= .ArrayType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= .identifier 
TypeName ::= .TypeName DOT identifier 
ClassName ::= .TypeName 
TypeVariable ::= .identifier 
ArrayType ::= .Type LBRACKET RBRACKET 
ExpressionName ::= .identifier 
ExpressionName ::= .AmbiguousName DOT identifier 
MethodName ::= .identifier 
MethodName ::= .AmbiguousName DOT identifier 
AmbiguousName ::= .identifier 
AmbiguousName ::= .AmbiguousName DOT identifier 
FormalParameter ::= .VariableModifiersopt Type VariableDeclaratorId 
VariableModifiers ::= .VariableModifier 
VariableModifiers ::= .VariableModifiers VariableModifier 
VariableModifier ::= .final 
VariableModifier ::= .Annotations 
Annotations ::= .Annotation 
Annotations ::= .Annotations Annotation 
Annotation ::= .NormalAnnotation 
Annotation ::= .MarkerAnnotation 
Annotation ::= .SingleElementAnnotation 
NormalAnnotation ::= .AT TypeName LPAREN ElementValuePairsopt RPAREN 
MarkerAnnotation ::= .AT TypeName 
SingleElementAnnotation ::= .AT TypeName LPAREN ElementValue RPAREN 
LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
StatementExpression ::= .Assignment 
StatementExpression ::= .PreIncrementExpression 
StatementExpression ::= .PreDecrementExpression 
StatementExpression ::= .PostIncrementExpression 
StatementExpression ::= .PostDecrementExpression 
StatementExpression ::= .MethodInvocation 
StatementExpression ::= .ClassInstanceCreationExpression 
ForInit ::= .StatementExpressionList 
ForInit ::= .LocalVariableDeclaration 
StatementExpressionList ::= .StatementExpression 
StatementExpressionList ::= .StatementExpressionList COMMA StatementExpression 
Primary ::= .PrimaryNoNewArray 
Primary ::= .ArrayCreationExpression 
PrimaryNoNewArray ::= .Literal 
PrimaryNoNewArray ::= .Type DOT class 
PrimaryNoNewArray ::= .void DOT class 
PrimaryNoNewArray ::= .this 
PrimaryNoNewArray ::= .ClassName DOT this 
PrimaryNoNewArray ::= .LPAREN Expression RPAREN 
PrimaryNoNewArray ::= .ClassInstanceCreationExpression 
PrimaryNoNewArray ::= .FieldAccess 
PrimaryNoNewArray ::= .MethodInvocation 
PrimaryNoNewArray ::= .ArrayAccess 
Literal ::= .IntegerLiteral 
Literal ::= .LongLiteral 
Literal ::= .FloatingPointLiteral 
Literal ::= .DoubleLiteral 
Literal ::= .BooleanLiteral 
Literal ::= .CharacterLiteral 
Literal ::= .StringLiteral 
Literal ::= .null 
BooleanLiteral ::= .true 
BooleanLiteral ::= .false 
ClassInstanceCreationExpression ::= .new TypeArgumentsopt ClassOrInterfaceType 
                                    TypeArgumentsopt LPAREN ArgumentListopt 
                                    RPAREN ClassBodyopt 
ClassInstanceCreationExpression ::= .Primary DOT new TypeArgumentsopt 
                                    identifier TypeArgumentsopt LPAREN 
                                    ArgumentListopt RPAREN ClassBodyopt 
ClassInstanceCreationExpression ::= .name DOT new TypeArgumentsopt identifier 
                                    TypeArgumentsopt LPAREN ArgumentListopt 
                                    RPAREN ClassBodyopt 
ArrayCreationExpression ::= .new PrimitiveType DimExprs Dimsopt 
ArrayCreationExpression ::= .new ClassOrInterfaceType DimExprs Dimsopt 
ArrayCreationExpression ::= .new PrimitiveType Dims ArrayInitializer 
ArrayCreationExpression ::= .new ClassOrInterfaceType Dims ArrayInitializer 
FieldAccess ::= .Primary DOT identifier 
FieldAccess ::= .super DOT identifier 
FieldAccess ::= .ClassName DOT super DOT identifier 
MethodInvocation ::= .MethodName LPAREN ArgumentListopt RPAREN 
MethodInvocation ::= .Primary DOT TypeArgumentsopt identifier LPAREN 
                     ArgumentListopt RPAREN 
MethodInvocation ::= .super DOT TypeArgumentsopt identifier LPAREN 
                     ArgumentListopt RPAREN 
MethodInvocation ::= .ClassName DOT super DOT TypeArgumentsopt identifier 
                     LPAREN ArgumentListopt RPAREN 
MethodInvocation ::= .TypeName DOT TypeArguments identifier LPAREN 
                     ArgumentListopt RPAREN 
ArrayAccess ::= .ExpressionName LBRACKET Expression RBRACKET 
ArrayAccess ::= .PrimaryNoNewArray LBRACKET Expression RBRACKET 
PostfixExpression ::= .Primary 
PostfixExpression ::= .ExpressionName 
PostfixExpression ::= .PostIncrementExpression 
PostfixExpression ::= .PostDecrementExpression 
PostIncrementExpression ::= .PostfixExpression PLUS_PLUS 
PostDecrementExpression ::= .PostfixExpression MINUS_MINUS 
PreIncrementExpression ::= .PLUS_PLUS UnaryExpression 
PreDecrementExpression ::= .MINUS_MINUS UnaryExpression 
Assignment ::= .LeftHandSide AssignmentOperator AssignmentExpression 
LeftHandSide ::= .ExpressionName 
LeftHandSide ::= .FieldAccess 
LeftHandSide ::= .ArrayAccess 
ForInitopt ::= . (455)
ForInitopt ::= .ForInit 
VariableModifiersopt ::= . (461)
VariableModifiersopt ::= .VariableModifiers 

*** Shift/reduce conflict on "IDENTIFIER" with rule 461

FormalParameter ::= .VariableModifiersopt Type VariableDeclaratorId 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "double" with rule 461

FormalParameter ::= .VariableModifiersopt Type VariableDeclaratorId 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "float" with rule 461

FormalParameter ::= .VariableModifiersopt Type VariableDeclaratorId 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "char" with rule 461

FormalParameter ::= .VariableModifiersopt Type VariableDeclaratorId 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "long" with rule 461

FormalParameter ::= .VariableModifiersopt Type VariableDeclaratorId 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "int" with rule 461

FormalParameter ::= .VariableModifiersopt Type VariableDeclaratorId 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "short" with rule 461

FormalParameter ::= .VariableModifiersopt Type VariableDeclaratorId 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "byte" with rule 461

FormalParameter ::= .VariableModifiersopt Type VariableDeclaratorId 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "boolean" with rule 461

FormalParameter ::= .VariableModifiersopt Type VariableDeclaratorId 
VariableModifiersopt ::= . (461)




STATE 461 ----------------------------------------------------------------------
( 443 )

TypeName ::= identifier . (21)
TypeVariable ::= identifier . (24)
ExpressionName ::= identifier . (41)
MethodName ::= identifier . (43)
AmbiguousName ::= identifier . (47)
EnumConstant ::= identifier . (303)

*** Reduce/reduce conflict on "LESS" between rule 21 and 41

ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
RelationalExpression ::= .RelationalExpression LESS ShiftExpression 
RelationalExpression ::= .ShiftExpression 
ShiftExpression ::= .AdditiveExpression 
AdditiveExpression ::= .MultiplicativeExpression 
MultiplicativeExpression ::= .UnaryExpression 
UnaryExpression ::= .UnaryExpressionNotPlusMinus 
UnaryExpressionNotPlusMinus ::= .PostfixExpression 
PostfixExpression ::= .ExpressionName 
ExpressionName ::= identifier . (41)

*** Reduce/reduce conflict on "LBRACKET" between rule 21 and 41

ArrayType ::= .Type LBRACKET RBRACKET 
Type ::= .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
ArrayAccess ::= .ExpressionName LBRACKET Expression RBRACKET 
ExpressionName ::= identifier . (41)

*** Reduce/reduce conflict on "LBRACKET" between rule 21 and 24

ArrayType ::= .Type LBRACKET RBRACKET 
Type ::= .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
ArrayType ::= .Type LBRACKET RBRACKET 
Type ::= .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "DOT" between rule 21 and 47

PrimaryNoNewArray ::= .Type DOT class 
Type ::= .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
ExpressionName ::= .AmbiguousName DOT identifier 
AmbiguousName ::= identifier . (47)

*** Reduce/reduce conflict on "DOT" between rule 21 and 24

PrimaryNoNewArray ::= .Type DOT class 
Type ::= .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= identifier . (21)
------------------------------------------------------------------------------
PrimaryNoNewArray ::= .Type DOT class 
Type ::= .ReferenceType 
ReferenceType ::= .TypeVariable 
TypeVariable ::= identifier . (24)

*** Reduce/reduce conflict on "COLON" between rule 41 and 303

SwitchLabel ::= case  .ConstantExpression COLON 
ConstantExpression ::= .Expression 
Expression ::= .AssignmentExpression 
AssignmentExpression ::= .ConditionalExpression 
ConditionalExpression ::= .ConditionalOrExpression 
ConditionalOrExpression ::= .ConditionalAndExpression 
ConditionalAndExpression ::= .InclusiveOrExpression 
InclusiveOrExpression ::= .ExclusiveOrExpression 
ExclusiveOrExpression ::= .AndExpression 
AndExpression ::= .EqualityExpression 
EqualityExpression ::= .RelationalExpression 
RelationalExpression ::= .ShiftExpression 
ShiftExpression ::= .AdditiveExpression 
AdditiveExpression ::= .MultiplicativeExpression 
MultiplicativeExpression ::= .UnaryExpression 
UnaryExpression ::= .UnaryExpressionNotPlusMinus 
UnaryExpressionNotPlusMinus ::= .PostfixExpression 
PostfixExpression ::= .ExpressionName 
ExpressionName ::= identifier . (41)
------------------------------------------------------------------------------
SwitchLabel ::= case  .EnumConstant COLON 
EnumConstant ::= identifier . (303)




STATE 462 ----------------------------------------------------------------------
( 444 )

BlockStatements ::= BlockStatements  .BlockStatement 
SwitchBlockStatementGroup ::= SwitchLabels BlockStatements . (297)

identifier ::= .IDENTIFIER 
Type ::= .PrimitiveType 
Type ::= .ReferenceType 
PrimitiveType ::= .NumericType 
PrimitiveType ::= .boolean 
NumericType ::= .IntegralType 
NumericType ::= .FloatingPointType 
IntegralType ::= .byte 
IntegralType ::= .short 
IntegralType ::= .int 
IntegralType ::= .long 
IntegralType ::= .char 
FloatingPointType ::= .float 
FloatingPointType ::= .double 
ReferenceType ::= .ClassOrInterfaceType 
ReferenceType ::= .TypeVariable 
ReferenceType ::= .ArrayType 
ClassOrInterfaceType ::= .ClassType 
ClassType ::= .TypeName TypeArgumentsopt 
TypeName ::= .identifier 
TypeName ::= .TypeName DOT identifier 
ClassName ::= .TypeName 
TypeVariable ::= .identifier 
ArrayType ::= .Type LBRACKET RBRACKET 
ExpressionName ::= .identifier 
ExpressionName ::= .AmbiguousName DOT identifier 
MethodName ::= .identifier 
MethodName ::= .AmbiguousName DOT identifier 
AmbiguousName ::= .identifier 
AmbiguousName ::= .AmbiguousName DOT identifier 
ClassDeclaration ::= .NormalClassDeclaration 
ClassDeclaration ::= .EnumDeclaration 
NormalClassDeclaration ::= .ClassModifiersopt class identifier 
                           TypeParametersopt Superopt Interfacesopt ClassBody 
ClassModifiers ::= .ClassModifier 
ClassModifiers ::= .ClassModifiers ClassModifier 
ClassModifier ::= .Annotation 
ClassModifier ::= .public 
ClassModifier ::= .protected 
ClassModifier ::= .private 
ClassModifier ::= .abstract 
ClassModifier ::= .static 
ClassModifier ::= .final 
ClassModifier ::= .strictfp 
VariableModifiers ::= .VariableModifier 
VariableModifiers ::= .VariableModifiers VariableModifier 
VariableModifier ::= .final 
VariableModifier ::= .Annotations 
EnumDeclaration ::= .ClassModifiersopt enum identifier Interfacesopt EnumBody 
Annotations ::= .Annotation 
Annotations ::= .Annotations Annotation 
Annotation ::= .NormalAnnotation 
Annotation ::= .MarkerAnnotation 
Annotation ::= .SingleElementAnnotation 
NormalAnnotation ::= .AT TypeName LPAREN ElementValuePairsopt RPAREN 
MarkerAnnotation ::= .AT TypeName 
SingleElementAnnotation ::= .AT TypeName LPAREN ElementValue RPAREN 
Block ::= .LBRACE BlockStatementsopt RBRACE 
BlockStatement ::= .LocalVariableDeclarationStatement 
BlockStatement ::= .ClassDeclaration 
BlockStatement ::= .Statement 
LocalVariableDeclarationStatement ::= .LocalVariableDeclaration SEMICOLON 
LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
Statement ::= .StatementWithoutTrailingSubstatement 
Statement ::= .LabeledStatement 
Statement ::= .IfThenStatement 
Statement ::= .IfThenElseStatement 
Statement ::= .WhileStatement 
Statement ::= .ForStatement 
StatementWithoutTrailingSubstatement ::= .Block 
StatementWithoutTrailingSubstatement ::= .EmptyStatement 
StatementWithoutTrailingSubstatement ::= .ExpressionStatement 
StatementWithoutTrailingSubstatement ::= .AssertStatement 
StatementWithoutTrailingSubstatement ::= .SwitchStatement 
StatementWithoutTrailingSubstatement ::= .DoStatement 
StatementWithoutTrailingSubstatement ::= .BreakStatement 
StatementWithoutTrailingSubstatement ::= .ContinueStatement 
StatementWithoutTrailingSubstatement ::= .ReturnStatement 
StatementWithoutTrailingSubstatement ::= .SynchronizedStatement 
StatementWithoutTrailingSubstatement ::= .ThrowStatement 
StatementWithoutTrailingSubstatement ::= .TryStatement 
IfThenStatement ::= .if LPAREN Expression RPAREN Statement 
IfThenElseStatement ::= .if LPAREN Expression RPAREN StatementNoShortIf else 
                        Statement 
EmptyStatement ::= .SEMICOLON 
EmptyStatement ::= .ERROR_TOKEN 
LabeledStatement ::= .identifier COLON Statement 
ExpressionStatement ::= .StatementExpression SEMICOLON 
StatementExpression ::= .Assignment 
StatementExpression ::= .PreIncrementExpression 
StatementExpression ::= .PreDecrementExpression 
StatementExpression ::= .PostIncrementExpression 
StatementExpression ::= .PostDecrementExpression 
StatementExpression ::= .MethodInvocation 
StatementExpression ::= .ClassInstanceCreationExpression 
AssertStatement ::= .assert Expression SEMICOLON 
AssertStatement ::= .assert Expression COLON Expression SEMICOLON 
SwitchStatement ::= .switch LPAREN Expression RPAREN SwitchBlock 
WhileStatement ::= .while LPAREN Expression RPAREN Statement 
DoStatement ::= .do Statement while LPAREN Expression RPAREN SEMICOLON 
ForStatement ::= .BasicForStatement 
ForStatement ::= .EnhancedForStatement 
BasicForStatement ::= .for LPAREN ForInitopt SEMICOLON Expressionopt SEMICOLON 
                      ForUpdateopt RPAREN Statement 
EnhancedForStatement ::= .for LPAREN FormalParameter COLON Expression RPAREN 
                         Statement 
BreakStatement ::= .break identifieropt SEMICOLON 
ContinueStatement ::= .continue identifieropt SEMICOLON 
ReturnStatement ::= .return Expressionopt SEMICOLON 
ThrowStatement ::= .throw Expression SEMICOLON 
SynchronizedStatement ::= .synchronized LPAREN Expression RPAREN Block 
TryStatement ::= .try Block Catches 
TryStatement ::= .try Block Catchesopt Finally 
Primary ::= .PrimaryNoNewArray 
Primary ::= .ArrayCreationExpression 
PrimaryNoNewArray ::= .Literal 
PrimaryNoNewArray ::= .Type DOT class 
PrimaryNoNewArray ::= .void DOT class 
PrimaryNoNewArray ::= .this 
PrimaryNoNewArray ::= .ClassName DOT this 
PrimaryNoNewArray ::= .LPAREN Expression RPAREN 
PrimaryNoNewArray ::= .ClassInstanceCreationExpression 
PrimaryNoNewArray ::= .FieldAccess 
PrimaryNoNewArray ::= .MethodInvocation 
PrimaryNoNewArray ::= .ArrayAccess 
Literal ::= .IntegerLiteral 
Literal ::= .LongLiteral 
Literal ::= .FloatingPointLiteral 
Literal ::= .DoubleLiteral 
Literal ::= .BooleanLiteral 
Literal ::= .CharacterLiteral 
Literal ::= .StringLiteral 
Literal ::= .null 
BooleanLiteral ::= .true 
BooleanLiteral ::= .false 
ClassInstanceCreationExpression ::= .new TypeArgumentsopt ClassOrInterfaceType 
                                    TypeArgumentsopt LPAREN ArgumentListopt 
                                    RPAREN ClassBodyopt 
ClassInstanceCreationExpression ::= .Primary DOT new TypeArgumentsopt 
                                    identifier TypeArgumentsopt LPAREN 
                                    ArgumentListopt RPAREN ClassBodyopt 
ClassInstanceCreationExpression ::= .name DOT new TypeArgumentsopt identifier 
                                    TypeArgumentsopt LPAREN ArgumentListopt 
                                    RPAREN ClassBodyopt 
ArrayCreationExpression ::= .new PrimitiveType DimExprs Dimsopt 
ArrayCreationExpression ::= .new ClassOrInterfaceType DimExprs Dimsopt 
ArrayCreationExpression ::= .new PrimitiveType Dims ArrayInitializer 
ArrayCreationExpression ::= .new ClassOrInterfaceType Dims ArrayInitializer 
FieldAccess ::= .Primary DOT identifier 
FieldAccess ::= .super DOT identifier 
FieldAccess ::= .ClassName DOT super DOT identifier 
MethodInvocation ::= .MethodName LPAREN ArgumentListopt RPAREN 
MethodInvocation ::= .Primary DOT TypeArgumentsopt identifier LPAREN 
                     ArgumentListopt RPAREN 
MethodInvocation ::= .super DOT TypeArgumentsopt identifier LPAREN 
                     ArgumentListopt RPAREN 
MethodInvocation ::= .ClassName DOT super DOT TypeArgumentsopt identifier 
                     LPAREN ArgumentListopt RPAREN 
MethodInvocation ::= .TypeName DOT TypeArguments identifier LPAREN 
                     ArgumentListopt RPAREN 
ArrayAccess ::= .ExpressionName LBRACKET Expression RBRACKET 
ArrayAccess ::= .PrimaryNoNewArray LBRACKET Expression RBRACKET 
PostfixExpression ::= .Primary 
PostfixExpression ::= .ExpressionName 
PostfixExpression ::= .PostIncrementExpression 
PostfixExpression ::= .PostDecrementExpression 
PostIncrementExpression ::= .PostfixExpression PLUS_PLUS 
PostDecrementExpression ::= .PostfixExpression MINUS_MINUS 
PreIncrementExpression ::= .PLUS_PLUS UnaryExpression 
PreDecrementExpression ::= .MINUS_MINUS UnaryExpression 
Assignment ::= .LeftHandSide AssignmentOperator AssignmentExpression 
LeftHandSide ::= .ExpressionName 
LeftHandSide ::= .FieldAccess 
LeftHandSide ::= .ArrayAccess 
VariableModifiersopt ::= . (461)
VariableModifiersopt ::= .VariableModifiers 
ClassModifiersopt ::= . (519)
ClassModifiersopt ::= .ClassModifiers 

*** Shift/reduce conflict on "boolean" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "char" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "long" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "int" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "short" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "byte" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "double" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "float" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)

*** Shift/reduce conflict on "IDENTIFIER" with rule 461

LocalVariableDeclaration ::= .VariableModifiersopt Type VariableDeclarators 
VariableModifiersopt ::= . (461)




***Warning: D:/eclipse/workspace/lpg.javaruntime.examples/javaexample/genericjavaparser/GJavaParser.g is not LALR(1).


Number of Terminals: 111
Number of Nonterminals: 247
Number of Productions: 537
Number of Items: 1510
Number of Scopes: 85
Number of States: 482
Number of Shift actions: 1543
Number of Goto actions: 2149
Number of Shift/Reduce actions: 2194
Number of Goto/Reduce actions: 3059
Number of Reduce actions: 3818
Number of Shift-Reduce conflicts: 134
Number of Reduce-Reduce conflicts: 536
Number of Keyword/Identifier Shift conflicts: 0
Number of Keyword/Identifier Shift-Reduce conflicts: 0
Number of Keyword/Identifier Reduce-Reduce conflicts: 0

Number of entries in base Action Table: 5690
Additional space required for compaction of Action Table: 19.7%

Number of unique terminal states: 338
Number of Shift actions saved by merging: 2355
Number of Conflict points saved by merging: 1
Number of Reduce actions saved by merging: 207
Number of Reduce saved by default: 2344

Number of entries in Terminal Action Table: 2316
Additional space required for compaction of Terminal Table: 7.7%

Actions in Compressed Tables:
     Number of Shifts: 624
     Number of Shift/Reduces: 628
     Number of conflict points: 533
     Number of Gotos: 2149
     Number of Goto/Reduces: 3059
     Number of Reduces: 193
     Number of Defaults: 153

Parsing Tables storage:
    Storage required for BASE_CHECK: 14696 Bytes
    Storage required for BASE_ACTION: 15616 Bytes
    Storage required for TERM_CHECK: 2550 Bytes
    Storage required for TERM_ACTION: 4992 Bytes

Error maps storage:
    Storage required for ACTION_SYMBOLS_BASE map: 966 Bytes
    Storage required for ACTION_SYMBOLS_RANGE map: 831 Bytes
    Storage required for NACTION_SYMBOLS_BASE map: 966 Bytes
    Storage required for NACTION_SYMBOLS_RANGE map: 424 Bytes
    Storage required for TERMINAL_INDEX map: 224 Bytes
    Storage required for NON_TERMINAL_INDEX map: 498 Bytes

    Storage required for SCOPE_PREFIX map: 170 Bytes
    Storage required for SCOPE_SUFFIX map: 170 Bytes
    Storage required for SCOPE_LHS_SYMBOL map: 170 Bytes
    Storage required for SCOPE_LOOK_AHEAD map: 85 Bytes
    Storage required for SCOPE_STATE_SET map: 170 Bytes
    Storage required for SCOPE_RIGHT_SIDE map: 946 Bytes
    Storage required for SCOPE_STATE map: 594 Bytes
    Storage required for IN_SYMB map: 966 Bytes

    Number of names: 245
    Number of characters in name: 2616
