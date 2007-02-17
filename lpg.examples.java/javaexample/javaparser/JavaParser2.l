
Options in effect for C:\eclipse\workspace-3.1\lpg.lpgjavaruntime.examples\javaexample\javaparser\JavaParser2.g:

    ACTION-BLOCK=("JavaParser.java","/.","./")

    AST-DIRECTORY=""  AST-TYPE="Ast"  NOATTRIBUTES  AUTOMATIC-AST=NESTED  
    NOBACKTRACK  BYTE  CONFLICTS  DAT-DIRECTORY="./"  
    DAT-FILE="JavaParserdcl.data"  DCL-FILE="JavaParserdcl.java"  NODEBUG  
    DEF-FILE="JavaParserdef.java"  NOEDIT  ERROR-MAPS  ESCAPE='$'  
    EXPORT-TERMINALS=("JavaParserexp.java","","")  EXTENDS-PARSETABLE  
    FACTORY="new "  FILE-PREFIX="JavaParser"  NOFIRST  NOFOLLOW  NOGOTO-DEFAULT
    GRM-FILE="C:\eclipse\workspace-3.1\lpg.lpgjavaruntime.examples\javaexample\javaparser\JavaParser2.g"
    FACTORY="new "  FILE-PREFIX="JavaParser"  NOFIRST  NOFOLLOW  NOGOTO-DEFAULT
    IMP-FILE="JavaParserimp.java"  IMPORT-TERMINALS="JavaLexer.g"  
    INCLUDE-DIRECTORY="C:\eclipse\workspace-3.1\lpg.lpgjavaruntime.examples\javaexample\javaparser\;C:\eclipse\workspace-3.1\lpg.lpgjavaruntime\include"
    IMP-FILE="JavaParserimp.java"  IMPORT-TERMINALS="JavaLexer.g"  LALR=2  LIST
    MARGIN=4  MAX-CASES=1024  NAMES=OPTIMIZED  NONT-CHECK  OR_MARKER='|'  
    PACKAGE="javaparser"  PARSETABLE-INTERFACES="lpg.lpgjavaruntime.ParseTable"
    PREFIX="TK_"  PRIORITY  PROGRAMMING_LANGUAGE=JAVA  
    PRS-FILE="JavaParserprs.java"  NOQUIET  READ-REDUCE  REMAP-TERMINALS  SCOPES
    NOSERIALIZE  NOSHIFT-DEFAULT  NOSINGLE-PRODUCTIONS  NOSOFT-KEYWORDS  
    NOSTATES  SUFFIX=""  SYM-FILE="JavaParsersym.java"  TAB-FILE="JavaParser2.t"
    TABLE  TEMPLATE="dtParserTemplateD.g"  TRACE=CONFLICTS  
    VARIABLES=NONTERMINALS  NOVERBOSE  VISITOR=DEFAULT  VISITOR-TYPE="Visitor"
    WARNINGS  NOXREF  

C:\eclipse\workspace-3.1\lpg.lpgjavaruntime.examples\javaexample\javaparser\JavaParser2.g:102:5:102:13:3883:3891: WARNING:Respecification of the eof symbol
C:\eclipse\workspace-3.1\lpg.lpgjavaruntime.examples\javaexample\javaparser\JavaParser2.g:106:5:106:15:3914:3924: WARNING:Respecification of the error symbol

Predefined Macros:

    $rule_number
    $rule_text
    $rule_size
    $input_file
    $current_line
    $next_line
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
    $vititor_type



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

    ++ ::= PLUS_PLUS
    '--' ::= MINUS_MINUS
    == ::= EQUAL_EQUAL
    <= ::= LESS_EQUAL
    >= ::= GREATER_EQUAL
    != ::= NOT_EQUAL
    << ::= LEFT_SHIFT
    >> ::= RIGHT_SHIFT
    >>> ::= UNSIGNED_RIGHT_SHIFT
    += ::= PLUS_EQUAL
    -= ::= MINUS_EQUAL
    *= ::= MULTIPLY_EQUAL
    /= ::= DIVIDE_EQUAL
    &= ::= AND_EQUAL
    |= ::= OR_EQUAL
    ^= ::= XOR_EQUAL
    %= ::= REMAINDER_EQUAL
    <<= ::= LEFT_SHIFT_EQUAL
    >>= ::= RIGHT_SHIFT_EQUAL
    >>>= ::= UNSIGNED_RIGHT_SHIFT_EQUAL
    || ::= OR_OR
    && ::= AND_AND
    + ::= PLUS
    - ::= MINUS
    ! ::= NOT
    % ::= REMAINDER
    ^ ::= XOR
    & ::= AND
    * ::= MULTIPLY
    '|' ::= OR
    ~ ::= TWIDDLE
    / ::= DIVIDE
    > ::= GREATER
    < ::= LESS
    ( ::= LPAREN
    ) ::= RPAREN
    { ::= LBRACE
    } ::= RBRACE
    [ ::= LBRACKET
    ] ::= RBRACKET
    ; ::= SEMICOLON
    ? ::= QUESTION
    : ::= COLON
    , ::= COMMA
    . ::= DOT
    = ::= EQUAL


Start:

    CompilationUnit

Eol:

    SEMICOLON

Eof:

    EOF_TOKEN

Error:

    ERROR_TOKEN

Terminals:

    IDENTIFIER
    abstract
    boolean
    break
    byte
    case
    catch
    char
    class
    const
    continue
    default
    do
    double
    else
    extends
    false
    final
    finally
    float
    for
    goto
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
    EOF_TOKEN
    SlComment
    MlComment
    DocComment
    ERROR_TOKEN


Soft Keywords:



Rules:

1      Literal$IntegerLiteral ::= IntegerLiteral
2      Literal$LongLiteral ::= LongLiteral
3      Literal$FloatLiteral ::= FloatingPointLiteral
4      Literal$DoubleLiteral ::= DoubleLiteral
5      Literal$BooleanLiteral ::= BooleanLiteral
6      Literal$CharacterLiteral ::= CharacterLiteral
7      Literal$StringLiteral ::= StringLiteral
8      Literal$NullLiteral ::= null $null_literal
9      BooleanLiteral$TrueLiteral ::= true
10     BooleanLiteral$FalseLiteral ::= false
11     Type ::= PrimitiveType
12     Type ::= ReferenceType
13     PrimitiveType ::= NumericType
14     PrimitiveType$BooleanType ::= boolean
15     NumericType ::= IntegralType
16     NumericType ::= FloatingPointType
17     IntegralType$ByteType ::= byte
18     IntegralType$ShortType ::= short
19     IntegralType$IntType ::= int
20     IntegralType$LongType ::= long
21     IntegralType$CharType ::= char
22     FloatingPointType$FloatType ::= float
23     FloatingPointType$DoubleType ::= double
24     ReferenceType ::= ClassOrInterfaceType
25     ReferenceType ::= ArrayType
26     ClassOrInterfaceType ::= Name
27     ArrayType$PrimitiveArrayType ::= PrimitiveType Dims
28     ArrayType$ClassOrInterfaceArrayType ::= Name Dims
29     ClassType ::= ClassOrInterfaceType
30     InterfaceType ::= ClassOrInterfaceType
31     Name ::= SimpleName
32            | QualifiedName
33     SimpleName ::= IDENTIFIER
34     QualifiedName ::= Name . IDENTIFIER
35     CompilationUnit ::= PackageDeclarationopt ImportDeclarationsopt TypeDeclarationsopt
36     ImportDeclarations$$ImportDeclaration ::= ImportDeclaration
37                          | ImportDeclarations ImportDeclaration
38     TypeDeclarations$$TypeDeclaration ::= TypeDeclaration
39                        | TypeDeclarations TypeDeclaration
40     PackageDeclaration ::= package Name ;
41     ImportDeclaration ::= SingleTypeImportDeclaration
42     ImportDeclaration ::= TypeImportOnDemandDeclaration
43     SingleTypeImportDeclaration ::= import Name ;
44     TypeImportOnDemandDeclaration ::= import Name . * ;
45     TypeDeclaration ::= ClassDeclaration
46     TypeDeclaration ::= InterfaceDeclaration
47     TypeDeclaration$EmptyDeclaration ::= ;
48     Modifiers$$Modifier ::= Modifier
49                 | Modifiers Modifier
50     Modifier$PublicModifier ::= public
51     Modifier$ProtectedModifier ::= protected
52     Modifier$PrivateModifier ::= private
53     Modifier$StaticModifier ::= static
54     Modifier$AbstractModifier ::= abstract
55     Modifier$FinalModifier ::= final
56     Modifier$NativeModifier ::= native
57     Modifier$StrictfpModifier ::= strictfp
58     Modifier$SynchronizedModifier ::= synchronized
59     Modifier$TransientModifier ::= transient
60     Modifier$VolatileModifier ::= volatile
61     ClassDeclaration ::= Modifiersopt class IDENTIFIER $Name Superopt Interfacesopt ClassBody
62     Super ::= extends ClassType
63     Interfaces$$InterfaceType ::= implements InterfaceTypeList
64     InterfaceTypeList$$InterfaceType ::= InterfaceType
65                         | InterfaceTypeList , InterfaceType
66     ClassBody ::= { ClassBodyDeclarationsopt }
67     ClassBodyDeclarations$$ClassBodyDeclaration ::= ClassBodyDeclaration
68                             | ClassBodyDeclarations ClassBodyDeclaration
69     ClassBodyDeclaration ::= ClassMemberDeclaration
70                            | StaticInitializer
71                            | ConstructorDeclaration
72                            | Block
73     ClassMemberDeclaration ::= FieldDeclaration
74                              | MethodDeclaration
75                              | ClassDeclaration
76                              | InterfaceDeclaration
77     ClassMemberDeclaration$EmptyDeclaration ::= ;
78     FieldDeclaration ::= Modifiersopt Type VariableDeclarators ;
79     VariableDeclarators$$VariableDeclarator ::= VariableDeclarator
80                           | VariableDeclarators , VariableDeclarator
81     VariableDeclarator ::= VariableDeclaratorId
82                          | VariableDeclaratorId = VariableInitializer
83     VariableDeclaratorId ::= IDENTIFIER Dimsopt
84     VariableInitializer ::= Expression
85                           | ArrayInitializer
86     MethodDeclaration ::= MethodHeader MethodBody
87     MethodHeader$TypedMethodHeader ::= Modifiersopt Type MethodDeclarator Throwsopt
88     MethodHeader$VoidMethodHeader ::= Modifiersopt void MethodDeclarator Throwsopt
89     MethodDeclarator ::= IDENTIFIER ( FormalParameterListopt ) Dimsopt
90     FormalParameterList$$FormalParameter ::= FormalParameter
91                           | FormalParameterList , FormalParameter
92     FormalParameter$FormalParameter ::= Modifiersopt Type VariableDeclaratorId
93     Throws$$ClassType ::= throws ClassTypeList
94     ClassTypeList$$ClassType ::= ClassType
95                     | ClassTypeList , ClassType
96     MethodBody ::= Block
97     MethodBody$EmptyMethodBody ::= ;
98     StaticInitializer ::= static Block
99     ConstructorDeclaration ::= Modifiersopt ConstructorDeclarator Throwsopt ConstructorBody
100    ConstructorDeclarator ::= IDENTIFIER ( FormalParameterListopt )
101    ConstructorBody ::= Block
102                      | { ExplicitConstructorInvocation BlockStatementsopt }
103    ExplicitConstructorInvocation$ThisCall ::= this ( ArgumentListopt ) ;
104                                    | Primary . this ( ArgumentListopt ) ;
105    ExplicitConstructorInvocation$SuperCall ::= super ( ArgumentListopt ) ;
106                                    | Primary $expression . super ( ArgumentListopt ) ;
107                                    | Name $expression . super ( ArgumentListopt ) ;
108    InterfaceDeclaration ::= Modifiersopt interface IDENTIFIER $Name ExtendsInterfacesopt InterfaceBody
109    ExtendsInterfaces$$InterfaceType ::= extends InterfaceTypeList
110    InterfaceBody ::= { InterfaceMemberDeclarationsopt }
111    InterfaceMemberDeclarations$$InterfaceMemberDeclaration ::= InterfaceMemberDeclaration
112                                  | InterfaceMemberDeclarations InterfaceMemberDeclaration
113    InterfaceMemberDeclaration ::= ConstantDeclaration
114                                 | AbstractMethodDeclaration
115                                 | ClassDeclaration
116                                 | InterfaceDeclaration
117    InterfaceMemberDeclaration$EmptyDeclaration ::= ;
118    ConstantDeclaration ::= FieldDeclaration
119    AbstractMethodDeclaration ::= MethodHeader ;
120    ArrayInitializer ::= { VariableInitializersopt Commaopt }
121    VariableInitializers$$VariableInitializer ::= VariableInitializer
122                           | VariableInitializers , VariableInitializer
123    Block ::= { BlockStatementsopt }
124    BlockStatements$$BlockStatement ::= BlockStatement
125                      | BlockStatements BlockStatement
126    BlockStatement ::= LocalVariableDeclarationStatement
127                     | Statement
128                     | ClassDeclaration
129    LocalVariableDeclarationStatement ::= LocalVariableDeclaration ;
130    LocalVariableDeclaration$LocalVariableDeclaration ::= Modifiers Type VariableDeclarators
131                               | Type VariableDeclarators
132    Statement ::= StatementWithoutTrailingSubstatement
133                | LabeledStatement
134                | IfThenStatement
135                | IfThenElseStatement
136                | WhileStatement
137                | ForStatement
138    StatementNoShortIf ::= StatementWithoutTrailingSubstatement
139                         | LabeledStatementNoShortIf
140                         | IfThenElseStatementNoShortIf
141                         | WhileStatementNoShortIf
142                         | ForStatementNoShortIf
143    StatementWithoutTrailingSubstatement ::= Block
144                                           | EmptyStatement
145                                           | ExpressionStatement
146                                           | SwitchStatement
147                                           | DoStatement
148                                           | BreakStatement
149                                           | ContinueStatement
150                                           | ReturnStatement
151                                           | SynchronizedStatement
152                                           | ThrowStatement
153                                           | TryStatement
154    EmptyStatement ::= ;
155    LabeledStatement$LabeledStatement ::= IDENTIFIER : Statement
156    LabeledStatementNoShortIf$LabeledStatement ::= IDENTIFIER : StatementNoShortIf $Statement
157    ExpressionStatement ::= StatementExpression ;
158    StatementExpression ::= Assignment
159                          | PreIncrementExpression
160                          | PreDecrementExpression
161                          | PostIncrementExpression
162                          | PostDecrementExpression
163                          | MethodInvocation
164                          | ClassInstanceCreationExpression
165    IfThenStatement$IfStatement ::= if ( Expression ) Statement $thenStmt
166    IfThenElseStatement$IfStatement ::= if ( Expression ) StatementNoShortIf $thenStmt else Statement $elseStmt
167    IfThenElseStatementNoShortIf$IfStatement ::= if ( Expression ) StatementNoShortIf $thenStmt else StatementNoShortIf $elseStmt
168    SwitchStatement ::= switch ( Expression ) SwitchBlock
169    SwitchBlock$SwitchBlock ::= { SwitchLabelsopt }
170    SwitchBlock$SwitchBlock ::= { SwitchBlockStatements SwitchLabelsopt }
171    SwitchBlockStatements$$SwitchBlockStatement ::= SwitchBlockStatement
172                            | SwitchBlockStatements SwitchBlockStatement
173    SwitchBlockStatement ::= SwitchLabels BlockStatements
174    SwitchLabels$$SwitchLabel ::= SwitchLabel
175                   | SwitchLabels SwitchLabel
176    SwitchLabel$CaseLabel ::= case ConstantExpression :
177    SwitchLabel$DefaultLabel ::= default :
178    WhileStatement$WhileStatement ::= while ( Expression ) Statement
179    WhileStatementNoShortIf$WhileStatement ::= while ( Expression ) StatementNoShortIf $Statement
180    DoStatement ::= do Statement while ( Expression ) ;
181    ForStatement$ForStatement ::= for ( ForInitopt ; Expressionopt ; ForUpdateopt ) Statement
182    ForStatementNoShortIf$ForStatement ::= for ( ForInitopt ; Expressionopt ; ForUpdateopt ) StatementNoShortIf $Statement
183    ForInit ::= StatementExpressionList
184              | LocalVariableDeclaration
185    ForUpdate$$StatementExpression ::= StatementExpressionList
186    StatementExpressionList$$StatementExpression ::= StatementExpression
187                              | StatementExpressionList , StatementExpression
188    BreakStatement ::= break IDENTIFIERopt ;
189    ContinueStatement ::= continue IDENTIFIERopt ;
190    ReturnStatement ::= return Expressionopt ;
191    ThrowStatement ::= throw Expression ;
192    SynchronizedStatement ::= synchronized ( Expression ) Block
193    TryStatement$TryStatement ::= try Block Catches $Catchesopt
194                   | try Block Catchesopt Finally
195    Catches$$CatchClause ::= CatchClause
196              | Catches CatchClause
197    CatchClause ::= catch ( FormalParameter ) Block
198    Finally ::= finally Block
199    Primary ::= PrimaryNoNewArray
200              | ArrayCreationExpression
201    PrimaryNoNewArray ::= Literal
202                        | MethodInvocation
203                        | ArrayAccess
204                        | ClassInstanceCreationExpression
205                        | FieldAccess
206    PrimaryNoNewArray$ParenthesizedExpression ::= ( Expression )
207    PrimaryNoNewArray$PrimaryThis ::= this
208                        | Name . this
209    PrimaryNoNewArray$PrimaryClassLiteral ::= Type . class
210    PrimaryNoNewArray$PrimaryVoidClassLiteral ::= void . class
211    ClassInstanceCreationExpression$ClassInstanceCreationExpression ::= new ClassType ( ArgumentListopt ) ClassBodyopt
212                                      | Primary $expression . new SimpleName $ClassType ( ArgumentListopt ) ClassBodyopt
213                                      | Name $expression . new SimpleName $ClassType ( ArgumentListopt ) ClassBodyopt
214    ArgumentList$$Expression ::= Expression
215                   | ArgumentList , Expression
216    ArrayCreationExpression$ArrayCreationExpression ::= new PrimitiveType $Type DimExprs Dimsopt
217                              | new ClassOrInterfaceType $Type DimExprs Dimsopt
218                              | new ArrayType $Type ArrayInitializer
219    DimExprs$$DimExpr ::= DimExpr
220               | DimExprs DimExpr
221    DimExpr ::= [ Expression ]
222    Dims$$Dim ::= Dim
223           | Dims Dim
224    Dim ::= [ ]
225    FieldAccess$FieldAccess ::= Primary . IDENTIFIER
226    FieldAccess$SuperFieldAccess ::= super . IDENTIFIER
227                  | Name . super . IDENTIFIER
228    MethodInvocation$MethodInvocation ::= Name ( ArgumentListopt )
229    MethodInvocation$PrimaryMethodInvocation ::= Primary . IDENTIFIER ( ArgumentListopt )
230    MethodInvocation$SuperMethodInvocation ::= super . IDENTIFIER ( ArgumentListopt )
231                       | Name . super . IDENTIFIER ( ArgumentListopt )
232    ArrayAccess$ArrayAccess ::= Name $Base [ Expression ]
233                  | PrimaryNoNewArray $Base [ Expression ]
234    PostfixExpression ::= Primary
235                        | Name
236                        | PostIncrementExpression
237                        | PostDecrementExpression
238    PostIncrementExpression ::= PostfixExpression ++
239    PostDecrementExpression ::= PostfixExpression '--'
240    UnaryExpression ::= PreIncrementExpression
241                      | PreDecrementExpression
242                      | UnaryExpressionNotPlusMinus
243    UnaryExpression$PlusUnaryExpression ::= + UnaryExpression
244    UnaryExpression$MinusUnaryExpression ::= - UnaryExpression
245    PreIncrementExpression ::= ++ UnaryExpression
246    PreDecrementExpression ::= '--' UnaryExpression
247    UnaryExpressionNotPlusMinus ::= PostfixExpression
248                                  | CastExpression
249    UnaryExpressionNotPlusMinus$UnaryComplementExpression ::= ~ UnaryExpression
250    UnaryExpressionNotPlusMinus$UnaryNotExpression ::= ! UnaryExpression
251    CastExpression$PrimitiveCastExpression ::= ( PrimitiveType Dimsopt ) UnaryExpression
252    CastExpression$ClassCastExpression ::= ( Expression $Name ) UnaryExpressionNotPlusMinus
253                     | ( Name $Name Dims ) UnaryExpressionNotPlusMinus
254    MultiplicativeExpression ::= UnaryExpression
255    MultiplicativeExpression$MultiplyExpression ::= MultiplicativeExpression * UnaryExpression
256    MultiplicativeExpression$DivideExpression ::= MultiplicativeExpression / UnaryExpression
257    MultiplicativeExpression$ModExpression ::= MultiplicativeExpression % UnaryExpression
258    AdditiveExpression ::= MultiplicativeExpression
259    AdditiveExpression$AddExpression ::= AdditiveExpression + MultiplicativeExpression
260    AdditiveExpression$SubtractExpression ::= AdditiveExpression - MultiplicativeExpression
261    ShiftExpression ::= AdditiveExpression
262    ShiftExpression$LeftShiftExpression ::= ShiftExpression << AdditiveExpression
263    ShiftExpression$RightShiftExpression ::= ShiftExpression >> AdditiveExpression
264    ShiftExpression$UnsignedRightShiftExpression ::= ShiftExpression >>> AdditiveExpression
265    RelationalExpression ::= ShiftExpression
266    RelationalExpression$LessExpression ::= RelationalExpression < ShiftExpression
267    RelationalExpression$GreaterExpression ::= RelationalExpression > ShiftExpression
268    RelationalExpression$LessEqualExpression ::= RelationalExpression <= ShiftExpression
269    RelationalExpression$GreaterEqualExpression ::= RelationalExpression >= ShiftExpression
270    RelationalExpression$InstanceofExpression ::= RelationalExpression instanceof ReferenceType
271    EqualityExpression ::= RelationalExpression
272    EqualityExpression$EqualExpression ::= EqualityExpression == RelationalExpression
273    EqualityExpression$NotEqualExpression ::= EqualityExpression != RelationalExpression
274    AndExpression ::= EqualityExpression
275    AndExpression ::= AndExpression & EqualityExpression
276    ExclusiveOrExpression ::= AndExpression
277    ExclusiveOrExpression ::= ExclusiveOrExpression ^ AndExpression
278    InclusiveOrExpression ::= ExclusiveOrExpression
279    InclusiveOrExpression ::= InclusiveOrExpression '|' ExclusiveOrExpression
280    ConditionalAndExpression ::= InclusiveOrExpression
281    ConditionalAndExpression ::= ConditionalAndExpression && InclusiveOrExpression
282    ConditionalOrExpression ::= ConditionalAndExpression
283    ConditionalOrExpression ::= ConditionalOrExpression || ConditionalAndExpression
284    ConditionalExpression ::= ConditionalOrExpression
285    ConditionalExpression ::= ConditionalOrExpression ? Expression : ConditionalExpression
286    AssignmentExpression ::= ConditionalExpression
287    AssignmentExpression ::= Assignment
288    Assignment ::= LeftHandSide AssignmentOperator AssignmentExpression
289    LeftHandSide ::= Name
290    LeftHandSide ::= FieldAccess
291    LeftHandSide ::= ArrayAccess
292    AssignmentOperator$EqualOperator ::= =
293    AssignmentOperator$MultiplyEqualOperator ::= *=
294    AssignmentOperator$DivideEqualOperator ::= /=
295    AssignmentOperator$ModEqualOperator ::= %=
296    AssignmentOperator$PlusEqualOperator ::= +=
297    AssignmentOperator$MinusEqualOperator ::= -=
298    AssignmentOperator$LeftShiftEqualOperator ::= <<=
299    AssignmentOperator$RightShiftEqualOperator ::= >>=
300    AssignmentOperator$UnsignedRightShiftEqualOperator ::= >>>=
301    AssignmentOperator$AndEqualOperator ::= &=
302    AssignmentOperator$ExclusiveOrEqualOperator ::= ^=
303    AssignmentOperator$OrEqualOperator ::= |=
304    Expression ::= AssignmentExpression
305    ConstantExpression ::= Expression
306    PackageDeclarationopt ::= $Empty
307                            | PackageDeclaration
308    Superopt ::= $Empty
309               | Super
310    Expressionopt ::= $Empty
311                    | Expression
312    ClassBodyopt ::= $Empty
313                   | ClassBody
314    ImportDeclarationsopt$$ImportDeclaration ::= $Empty
315                            | ImportDeclarations
316    TypeDeclarationsopt$$TypeDeclaration ::= $Empty
317                          | TypeDeclarations
318    ClassBodyDeclarationsopt$$ClassBodyDeclaration ::= $Empty
319                               | ClassBodyDeclarations
320    Modifiersopt$$Modifier ::= $Empty
321                   | Modifiers
322    ExplicitConstructorInvocationopt ::= $Empty
323                                       | ExplicitConstructorInvocation
324    BlockStatementsopt$$BlockStatement ::= $Empty
325                         | BlockStatements
326    Dimsopt$$Dim ::= $Empty
327              | Dims
328    ArgumentListopt$$Expression ::= $Empty
329                      | ArgumentList
330    Throwsopt$$ClassType ::= $Empty
331                | Throws
332    FormalParameterListopt$$FormalParameter ::= $Empty
333                             | FormalParameterList
334    Interfacesopt$$InterfaceType ::= $Empty
335                    | Interfaces
336    InterfaceMemberDeclarationsopt$$InterfaceMemberDeclaration ::= $Empty
337                                     | InterfaceMemberDeclarations
338    ForInitopt ::= $Empty
339                 | ForInit
340    ForUpdateopt$$StatementExpression ::= $Empty
341                   | ForUpdate
342    ExtendsInterfacesopt$$InterfaceType ::= $Empty
343                           | ExtendsInterfaces
344    Catchesopt$$CatchClause ::= $Empty
345                 | Catches
346    VariableInitializersopt$$VariableInitializer ::= $Empty
347                              | VariableInitializers
348    SwitchBlockStatementsopt$$SwitchBlockStatement ::= $Empty
349                               | SwitchBlockStatements
350    SwitchLabelsopt$$SwitchLabel ::= $Empty
351                      | SwitchLabels
352    Commaopt ::= $Empty
353               | ,
354    IDENTIFIERopt ::= $Empty
355                    | IDENTIFIER


Types:

    Statement ::= StatementNoShortIf
                | StatementWithoutTrailingSubstatement
    LabeledStatement ::= LabeledStatementNoShortIf
    IfThenElseStatement ::= IfThenElseStatementNoShortIf
    WhileStatement ::= WhileStatementNoShortIf
    ForStatement ::= ForStatementNoShortIf

*** The following Terminals are useless: 
        const  goto  SlComment  MlComment  DocComment  
*** The following Non-Terminals are useless: 
        ExplicitConstructorInvocationopt SwitchBlockStatementsopt 


 IBM LALR Parser Generator              1.00 (Feb 28 2006)


Name map:

'$empty' ::= '$empty'
IDENTIFIER ::= IDENTIFIER
abstract ::= abstract
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
IntegerLiteral ::= IntegerLiteral
LongLiteral ::= LongLiteral
FloatingPointLiteral ::= FloatingPointLiteral
DoubleLiteral ::= DoubleLiteral
CharacterLiteral ::= CharacterLiteral
StringLiteral ::= StringLiteral
PLUS_PLUS ::= ++
MINUS_MINUS ::= --
EQUAL_EQUAL ::= ==
LESS_EQUAL ::= <=
GREATER_EQUAL ::= >=
NOT_EQUAL ::= !=
LEFT_SHIFT ::= <<
RIGHT_SHIFT ::= >>
UNSIGNED_RIGHT_SHIFT ::= >>>
PLUS_EQUAL ::= +=
MINUS_EQUAL ::= -=
MULTIPLY_EQUAL ::= *=
DIVIDE_EQUAL ::= /=
AND_EQUAL ::= &=
OR_EQUAL ::= |=
XOR_EQUAL ::= ^=
REMAINDER_EQUAL ::= %=
LEFT_SHIFT_EQUAL ::= <<=
RIGHT_SHIFT_EQUAL ::= >>=
UNSIGNED_RIGHT_SHIFT_EQUAL ::= >>>=
OR_OR ::= ||
AND_AND ::= &&
PLUS ::= +
MINUS ::= -
NOT ::= !
REMAINDER ::= %
XOR ::= ^
AND ::= &
MULTIPLY ::= *
OR ::= '|'
TWIDDLE ::= ~
DIVIDE ::= /
GREATER ::= >
LESS ::= <
LPAREN ::= (
RPAREN ::= )
LBRACE ::= {
RBRACE ::= }
LBRACKET ::= [
RBRACKET ::= ]
SEMICOLON ::= ;
QUESTION ::= ?
COLON ::= :
COMMA ::= ,
DOT ::= .
EQUAL ::= =
EOF_TOKEN ::= EOF_TOKEN
SlComment ::= SlComment
MlComment ::= MlComment
DocComment ::= DocComment
ERROR_TOKEN ::= ERROR_TOKEN
Type ::= Type
PrimitiveType ::= PrimitiveType
ReferenceType ::= ReferenceType
ClassOrInterfaceType ::= ClassOrInterfaceType
ArrayType ::= ArrayType
Name ::= Name
Dims ::= Dims
ClassType ::= ClassType
InterfaceType ::= InterfaceType
SimpleName ::= SimpleName
ImportDeclarations ::= ImportDeclarations
ImportDeclaration ::= ImportDeclaration
TypeDeclarations ::= TypeDeclarations
TypeDeclaration ::= TypeDeclaration
Modifiers ::= Modifiers
Modifier ::= Modifier
ClassBody ::= ClassBody
InterfaceTypeList ::= InterfaceTypeList
ClassBodyDeclarations ::= ClassBodyDeclarations
ClassBodyDeclaration ::= ClassBodyDeclaration
Block ::= Block
VariableDeclarators ::= VariableDeclarators
VariableDeclarator ::= VariableDeclarator
VariableDeclaratorId ::= VariableDeclaratorId
VariableInitializer ::= VariableInitializer
Expression ::= Expression
ArrayInitializer ::= ArrayInitializer
MethodHeader ::= MethodHeader
MethodBody ::= MethodBody
MethodDeclarator ::= MethodDeclarator
FormalParameterList ::= FormalParameterList
FormalParameter ::= FormalParameter
ClassTypeList ::= ClassTypeList
ConstructorDeclarator ::= ConstructorDeclarator
ConstructorBody ::= ConstructorBody
ExplicitConstructorInvocation ::= ExplicitConstructorInvocation
Primary ::= Primary
InterfaceBody ::= InterfaceBody
InterfaceMemberDeclarations ::= InterfaceMemberDeclarations
InterfaceMemberDeclaration ::= InterfaceMemberDeclaration
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
SwitchBlockStatements ::= SwitchBlockStatements
SwitchBlockStatement ::= SwitchBlockStatement
SwitchLabels ::= SwitchLabels
SwitchLabel ::= SwitchLabel
ConstantExpression ::= ConstantExpression
StatementExpressionList ::= StatementExpressionList
Catches ::= Catches
Finally ::= Finally
CatchClause ::= CatchClause
PrimaryNoNewArray ::= PrimaryNoNewArray
ArrayAccess ::= ArrayAccess
FieldAccess ::= FieldAccess
ArgumentList ::= ArgumentList
DimExprs ::= DimExprs
DimExpr ::= DimExpr
Dim ::= Dim
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
ConditionalExpression ::= ConditionalExpression
AssignmentExpression ::= AssignmentExpression
LeftHandSide ::= LeftHandSide
AssignmentOperator ::= AssignmentOperator
CompilationUnit ::= 
Literal ::= 
BooleanLiteral ::= 
NumericType ::= 
IntegralType ::= 
FloatingPointType ::= 
QualifiedName ::= 
PackageDeclarationopt ::= 
ImportDeclarationsopt ::= 
TypeDeclarationsopt ::= 
PackageDeclaration ::= 
SingleTypeImportDeclaration ::= 
TypeImportOnDemandDeclaration ::= 
ClassDeclaration ::= 
InterfaceDeclaration ::= 
Modifiersopt ::= 
Superopt ::= 
Interfacesopt ::= 
Super ::= 
Interfaces ::= 
ClassBodyDeclarationsopt ::= 
ClassMemberDeclaration ::= 
StaticInitializer ::= 
ConstructorDeclaration ::= 
FieldDeclaration ::= 
MethodDeclaration ::= 
Dimsopt ::= 
Throwsopt ::= 
FormalParameterListopt ::= 
Throws ::= 
BlockStatementsopt ::= 
ArgumentListopt ::= 
ExtendsInterfacesopt ::= 
ExtendsInterfaces ::= 
InterfaceMemberDeclarationsopt ::= 
ConstantDeclaration ::= 
AbstractMethodDeclaration ::= 
VariableInitializersopt ::= 
Commaopt ::= 
LocalVariableDeclarationStatement ::= 
LabeledStatement ::= 
IfThenStatement ::= 
IfThenElseStatement ::= 
WhileStatement ::= 
ForStatement ::= 
LabeledStatementNoShortIf ::= 
IfThenElseStatementNoShortIf ::= 
WhileStatementNoShortIf ::= 
ForStatementNoShortIf ::= 
EmptyStatement ::= 
ExpressionStatement ::= 
SwitchStatement ::= 
DoStatement ::= 
BreakStatement ::= 
ContinueStatement ::= 
ReturnStatement ::= 
SynchronizedStatement ::= 
ThrowStatement ::= 
TryStatement ::= 
Assignment ::= 
PreIncrementExpression ::= 
PreDecrementExpression ::= 
SwitchLabelsopt ::= 
ForInitopt ::= 
Expressionopt ::= 
ForUpdateopt ::= 
ForInit ::= 
ForUpdate ::= 
IDENTIFIERopt ::= 
Catchesopt ::= 
ArrayCreationExpression ::= 
ClassBodyopt ::= 
CastExpression ::= 
ExplicitConstructorInvocationopt ::= 
SwitchBlockStatementsopt ::= 

 IBM LALR Parser Generator              1.00 (Feb 28 2006)


Scopes:

ForStatementNoShortIf ::= for LPAREN ForInitopt SEMICOLON Expressionopt 
                          SEMICOLON ForUpdateopt  .RPAREN StatementNoShortIf 
ForStatement ::= for LPAREN ForInitopt SEMICOLON Expressionopt SEMICOLON 
                 ForUpdateopt  .RPAREN Statement 
ClassInstanceCreationExpression ::= Name DOT new SimpleName LPAREN 
                                    ArgumentListopt  .RPAREN 
ClassInstanceCreationExpression ::= Primary DOT new SimpleName LPAREN 
                                    ArgumentListopt  .RPAREN 
MethodInvocation ::= super DOT IDENTIFIER LPAREN ArgumentListopt  .RPAREN 
MethodInvocation ::= Primary DOT IDENTIFIER LPAREN ArgumentListopt  .RPAREN 
DoStatement ::= do Statement while LPAREN Expression  .RPAREN SEMICOLON 
IfThenElseStatementNoShortIf ::= if LPAREN Expression RPAREN 
                                 StatementNoShortIf  .else StatementNoShortIf 
IfThenElseStatement ::= if LPAREN Expression RPAREN StatementNoShortIf  .else 
                        Statement 
ExplicitConstructorInvocation ::= Name DOT super LPAREN ArgumentListopt  .
                                  RPAREN SEMICOLON 
ExplicitConstructorInvocation ::= Primary DOT super LPAREN ArgumentListopt  .
                                  RPAREN SEMICOLON 
ExplicitConstructorInvocation ::= Primary DOT this LPAREN ArgumentListopt  .
                                  RPAREN SEMICOLON 
ForStatementNoShortIf ::= for LPAREN ForInitopt SEMICOLON Expressionopt  .
                          SEMICOLON RPAREN StatementNoShortIf 
ForStatement ::= for LPAREN ForInitopt SEMICOLON Expressionopt  .SEMICOLON 
                 RPAREN Statement 
ClassInstanceCreationExpression ::= new ClassType LPAREN ArgumentListopt  .
                                    RPAREN 
ArrayAccess ::= PrimaryNoNewArray LBRACKET Expression  .RBRACKET 
ArrayAccess ::= Name LBRACKET Expression  .RBRACKET 
MethodInvocation ::= Name LPAREN ArgumentListopt  .RPAREN 
TryStatement ::= try Block Catchesopt  .Finally 
SwitchBlock ::= LBRACE SwitchBlockStatements SwitchLabelsopt  .RBRACE 
ArrayInitializer ::= LBRACE VariableInitializersopt Commaopt  .RBRACE 
ConstructorBody ::= LBRACE ExplicitConstructorInvocation BlockStatementsopt  .
                    RBRACE 
FieldDeclaration ::= Modifiersopt Type VariableDeclarators  .SEMICOLON 
ConditionalExpression ::= ConditionalOrExpression QUESTION Expression  .COLON 
                          ConditionalExpression 
SynchronizedStatement ::= synchronized LPAREN Expression  .RPAREN Block 
WhileStatementNoShortIf ::= while LPAREN Expression  .RPAREN StatementNoShortIf 
WhileStatement ::= while LPAREN Expression  .RPAREN Statement 
SwitchStatement ::= switch LPAREN Expression  .RPAREN SwitchBlock 
IfThenStatement ::= if LPAREN Expression  .RPAREN Statement 
ExplicitConstructorInvocation ::= super LPAREN ArgumentListopt  .RPAREN 
                                  SEMICOLON 
ExplicitConstructorInvocation ::= this LPAREN ArgumentListopt  .RPAREN 
                                  SEMICOLON 
IfThenElseStatementNoShortIf ::= if LPAREN Expression  .RPAREN 
                                 StatementNoShortIf else StatementNoShortIf 
IfThenElseStatement ::= if LPAREN Expression  .RPAREN StatementNoShortIf else 
                        Statement 
ForStatementNoShortIf ::= for LPAREN ForInitopt  .SEMICOLON SEMICOLON RPAREN 
                          StatementNoShortIf 
ForStatement ::= for LPAREN ForInitopt  .SEMICOLON SEMICOLON RPAREN Statement 
DimExpr ::= LBRACKET Expression  .RBRACKET 
PrimaryNoNewArray ::= LPAREN Expression  .RPAREN 
TryStatement ::= try Block  .Catches 
ThrowStatement ::= throw Expression  .SEMICOLON 
ReturnStatement ::= return Expressionopt  .SEMICOLON 
SwitchLabel ::= case ConstantExpression  .COLON 
SwitchBlock ::= LBRACE SwitchLabelsopt  .RBRACE 
Block ::= LBRACE BlockStatementsopt  .RBRACE 
InterfaceBody ::= LBRACE InterfaceMemberDeclarationsopt  .RBRACE 
ClassBody ::= LBRACE ClassBodyDeclarationsopt  .RBRACE 
CastExpression ::= LPAREN Expression  .RPAREN UnaryExpressionNotPlusMinus 
DoStatement ::= do Statement  .while LPAREN Expression RPAREN SEMICOLON 
SwitchBlockStatement ::= SwitchLabels  .BlockStatements 
ExpressionStatement ::= StatementExpression  .SEMICOLON 
LocalVariableDeclarationStatement ::= LocalVariableDeclaration  .SEMICOLON 
Assignment ::= LeftHandSide  .AssignmentOperator AssignmentExpression 
ExplicitConstructorInvocation ::= Primary  .DOT super LPAREN RPAREN SEMICOLON 
ExplicitConstructorInvocation ::= Primary  .DOT this LPAREN RPAREN SEMICOLON 


C:\eclipse\workspace-3.1\lpg.lpgjavaruntime.examples\javaexample\javaparser\JavaParser2.g is LALR(2).


Number of Terminals: 109
Number of Nonterminals: 161
Number of Productions: 356
Number of Items: 1031
Number of Scopes: 54
Number of States: 333
Number of look-ahead states: 6
Number of Shift actions: 1279
Number of Goto actions: 1440
Number of Shift/Reduce actions: 2019
Number of Goto/Reduce actions: 2367
Number of Reduce actions: 1602
Number of Shift-Reduce conflicts: 0
Number of Reduce-Reduce conflicts: 0

Number of entries in base Action Table: 4140
Additional space required for compaction of Action Table: 16.4%

Number of unique terminal states: 242
Number of Shift actions saved by merging: 2177
Number of Conflict points saved by merging: 0
Number of Reduce actions saved by merging: 136
Number of Reduce saved by default: 1387

Number of entries in Terminal Action Table: 1448
Additional space required for compaction of Terminal Table: 4.2%

Actions in Compressed Tables:
     Number of Shifts: 485
     Number of Shift/Reduces: 636
     Number of Look-Ahead Shifts: 6
     Number of Gotos: 1440
     Number of Goto/Reduces: 2367
     Number of Reduces: 79
     Number of Defaults: 112

Parsing Tables storage:
    Storage required for BASE_CHECK: 10354 Bytes
    Storage required for BASE_ACTION: 10356 Bytes
    Storage required for TERM_CHECK: 1568 Bytes
    Storage required for TERM_ACTION: 3020 Bytes

Error maps storage:
    Storage required for ACTION_SYMBOLS_BASE map: 668 Bytes
    Storage required for ACTION_SYMBOLS_RANGE map: 653 Bytes
    Storage required for NACTION_SYMBOLS_BASE map: 668 Bytes
    Storage required for NACTION_SYMBOLS_RANGE map: 332 Bytes
    Storage required for TERMINAL_INDEX map: 220 Bytes
    Storage required for NON_TERMINAL_INDEX map: 326 Bytes

    Storage required for SCOPE_PREFIX map: 108 Bytes
    Storage required for SCOPE_SUFFIX map: 108 Bytes
    Storage required for SCOPE_LHS_SYMBOL map: 108 Bytes
    Storage required for SCOPE_LOOK_AHEAD map: 54 Bytes
    Storage required for SCOPE_STATE_SET map: 108 Bytes
    Storage required for SCOPE_RIGHT_SIDE map: 566 Bytes
    Storage required for SCOPE_STATE map: 410 Bytes
    Storage required for IN_SYMB map: 668 Bytes

    Number of names: 198
    Number of characters in name: 1880
