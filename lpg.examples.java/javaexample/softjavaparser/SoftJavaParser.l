
Options in effect for D:/eclipse/workspace/lpg.javaruntime.examples/javaexample/softjavaparser/SoftJavaParser.g:

    ACTION-BLOCK=("D:\eclipse\workspace\lpg.javaruntime.examples\javaexample\softjavaparser\SoftJavaParser.java","/.","./")

    AST-DIRECTORY=""  AST-TYPE="Ast"  NOATTRIBUTES  NOAUTOMATIC-AST  BACKTRACK
    BYTE  CONFLICTS  
    DAT-DIRECTORY="D:\eclipse\workspace\lpg.javaruntime.examples\javaexample\softjavaparser\"
    BYTE  CONFLICTS  
    DAT-FILE="D:\eclipse\workspace\lpg.javaruntime.examples\javaexample\softjavaparser\SoftJavaParserdcl.data"
    BYTE  CONFLICTS  
    DCL-FILE="D:\eclipse\workspace\lpg.javaruntime.examples\javaexample\softjavaparser\SoftJavaParserdcl.java"
    BYTE  CONFLICTS  NODEBUG  
    DEF-FILE="D:\eclipse\workspace\lpg.javaruntime.examples\javaexample\softjavaparser\SoftJavaParserdef.java"
    BYTE  CONFLICTS  NODEBUG  NOEDIT  ERROR-MAPS  ESCAPE='$'  
    EXPORT-TERMINALS=("D:\eclipse\workspace\lpg.javaruntime.examples\javaexample\softjavaparser\SoftJavaParserexp.java","","")
    BYTE  CONFLICTS  NODEBUG  NOEDIT  ERROR-MAPS  ESCAPE='$'  EXTENDS-PARSETABLE
    FACTORY="new "  FILE-PREFIX="SoftJavaParser"  NOFIRST  NOFOLLOW  NOGLR  
    NOGOTO-DEFAULT  
    GRM-FILE="D:/eclipse/workspace/lpg.javaruntime.examples/javaexample/softjavaparser/SoftJavaParser.g"
    NOGOTO-DEFAULT  
    IMP-FILE="D:\eclipse\workspace\lpg.javaruntime.examples\javaexample\softjavaparser\SoftJavaParserimp.java"
    NOGOTO-DEFAULT  
    INCLUDE-DIRECTORY="D:\eclipse\workspace\lpg.javaruntime.examples\javaexample\softjavaparser\;.;D:\eclipse\workspace\lpgjavaruntime\include;D:\eclipse\workspace;D:\eclipse\workspace\com.ibm.db.parsers.sql2003\src\com\ibm\db\parsers\sql2003;D:\eclipse\workspace\com.ibm.db.parsers.sql2003\src\com\ibm\db\parsers\sql2003\lexer;D:\eclipse\workspace\com.ibm.db.parsers.sql.common.db2.lexer\src\com\ibm\db\parsers\sql\common\db2\lexer;D:\eclipse\workspace\com.ibm.db.parsers.sql.routines.db2.common\src\com\ibm\db\parsers\sql\routines\db2\common;"
    NOGOTO-DEFAULT  LALR=1  LIST  MARGIN=4  MAX-CASES=1024  NAMES=OPTIMIZED  
    NONT-CHECK  OR_MARKER='|'  
    OUT-DIRECTORY="D:\eclipse\workspace\lpg.javaruntime.examples\javaexample\softjavaparser\"
    NONT-CHECK  OR_MARKER='|'  PACKAGE="softjavaparser"  NOPARENT-SAVE  
    PARSETABLE-INTERFACES="lpg.javaruntime.ParseTable"  PREFIX="TK_"  PRIORITY
    PROGRAMMING_LANGUAGE=JAVA  
    PRS-FILE="D:\eclipse\workspace\lpg.javaruntime.examples\javaexample\softjavaparser\SoftJavaParserprs.java"
    PROGRAMMING_LANGUAGE=JAVA  NOQUIET  READ-REDUCE  REMAP-TERMINALS  SCOPES  
    NOSERIALIZE  NOSHIFT-DEFAULT  NOSINGLE-PRODUCTIONS  SOFT-KEYWORDS  NOSTATES
    SUFFIX=""  
    SYM-FILE="D:\eclipse\workspace\lpg.javaruntime.examples\javaexample\softjavaparser\SoftJavaParsersym.java"
    SUFFIX=""  TAB-FILE="SoftJavaParser.t"  TABLE  
    TEMPLATE="btParserTemplateD.g"  TRACE=CONFLICTS  NOVARIABLES  NOVERBOSE  
    NOVISITOR  VISITOR-TYPE="Visitor"  WARNINGS  NOXREF  


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

    Goal

Identifier:

    IDENTIFIER

Eol:

    SEMICOLON

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
    IDENTIFIER
    EOF_TOKEN
    ERROR_TOKEN


Soft Keywords:

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


Rules:

1      Goal ::= initialize CompilationUnit
2      Goal ::= initialize ConstructorBody
3      initialize ::= $Empty
4      identifier ::= IDENTIFIER
5      Literal ::= IntegerLiteral
6      Literal ::= LongLiteral
7      Literal ::= FloatingPointLiteral
8      Literal ::= DoubleLiteral
9      Literal ::= BooleanLiteral
10     Literal ::= CharacterLiteral
11     Literal ::= StringLiteral
12     Literal ::= null
13     BooleanLiteral ::= true
14     BooleanLiteral ::= false
15     Type ::= PrimitiveType
16     Type ::= ReferenceType
17     PrimitiveType ::= NumericType
18     PrimitiveType ::= boolean
19     NumericType ::= IntegralType
20     NumericType ::= FloatingPointType
21     IntegralType ::= byte
22     IntegralType ::= short
23     IntegralType ::= int
24     IntegralType ::= long
25     IntegralType ::= char
26     FloatingPointType ::= float
27     FloatingPointType ::= double
28     ReferenceType ::= ClassOrInterfaceType
29     ReferenceType ::= ArrayType
30     ClassOrInterfaceType ::= Name
31     ArrayType ::= PrimitiveType Dims
32     ArrayType ::= Name Dims
33     ClassType ::= ClassOrInterfaceType
34     InterfaceType ::= ClassOrInterfaceType
35     Name ::= SimpleName
36     Name ::= QualifiedName
37     SimpleName ::= identifier
38     QualifiedName ::= Name . identifier
39     CompilationUnit ::= PackageDeclarationopt ImportDeclarationsopt TypeDeclarationsopt
40     ImportDeclarations ::= ImportDeclaration
41     ImportDeclarations ::= ImportDeclarations ImportDeclaration
42     TypeDeclarations ::= TypeDeclaration
43     TypeDeclarations ::= TypeDeclarations TypeDeclaration
44     PackageDeclaration ::= package Name ;
45     ImportDeclaration ::= SingleTypeImportDeclaration
46     ImportDeclaration ::= TypeImportOnDemandDeclaration
47     SingleTypeImportDeclaration ::= import Name ;
48     TypeImportOnDemandDeclaration ::= import Name . * ;
49     TypeDeclaration ::= ClassDeclaration
50     TypeDeclaration ::= InterfaceDeclaration
51     TypeDeclaration ::= ;
52     Modifiers ::= Modifier
53     Modifiers ::= Modifiers Modifier
54     Modifier ::= public
55     Modifier ::= protected
56     Modifier ::= private
57     Modifier ::= static
58     Modifier ::= abstract
59     Modifier ::= final
60     Modifier ::= native
61     Modifier ::= strictfp
62     Modifier ::= synchronized
63     Modifier ::= transient
64     Modifier ::= volatile
65     ClassDeclaration ::= Modifiersopt class identifier Superopt Interfacesopt ClassBody
66     Super ::= extends ClassType
67     Interfaces ::= implements InterfaceTypeList
68     InterfaceTypeList ::= InterfaceType
69     InterfaceTypeList ::= InterfaceTypeList , InterfaceType
70     ClassBody ::= { ClassBodyDeclarationsopt }
71     ClassBodyDeclarations ::= ClassBodyDeclaration
72     ClassBodyDeclarations ::= ClassBodyDeclarations ClassBodyDeclaration
73     ClassBodyDeclaration ::= ClassMemberDeclaration
74     ClassBodyDeclaration ::= StaticInitializer
75     ClassBodyDeclaration ::= ConstructorDeclaration
76     ClassBodyDeclaration ::= Block
77     ClassMemberDeclaration ::= FieldDeclaration
78     ClassMemberDeclaration ::= MethodDeclaration
79     ClassMemberDeclaration ::= ClassDeclaration
80     ClassMemberDeclaration ::= InterfaceDeclaration
81     ClassMemberDeclaration ::= ;
82     FieldDeclaration ::= Modifiersopt Type VariableDeclarators ;
83     VariableDeclarators ::= VariableDeclarator
84     VariableDeclarators ::= VariableDeclarators , VariableDeclarator
85     VariableDeclarator ::= VariableDeclaratorId
86     VariableDeclarator ::= VariableDeclaratorId = VariableInitializer
87     VariableDeclaratorId ::= identifier Dimsopt
88     VariableInitializer ::= Expression
89     VariableInitializer ::= ArrayInitializer
90     MethodDeclaration ::= MethodHeader MethodBody
91     MethodHeader ::= Modifiersopt Type MethodDeclarator Throwsopt
92     MethodHeader ::= Modifiersopt void MethodDeclarator Throwsopt
93     MethodDeclarator ::= identifier ( FormalParameterListopt ) Dimsopt
94     FormalParameterList ::= FormalParameter
95     FormalParameterList ::= FormalParameterList , FormalParameter
96     FormalParameter ::= Type VariableDeclaratorId
97     FormalParameter ::= Modifiers Type VariableDeclaratorId
98     Throws ::= throws ClassTypeList
99     ClassTypeList ::= ClassType
100    ClassTypeList ::= ClassTypeList , ClassType
101    MethodBody ::= Block
102    MethodBody ::= ;
103    StaticInitializer ::= static Block
104    ConstructorDeclaration ::= Modifiersopt ConstructorDeclarator Throwsopt ConstructorBody
105    ConstructorDeclarator ::= identifier ( FormalParameterListopt )
106    ConstructorBody ::= Block
107    ConstructorBody ::= { ExplicitConstructorInvocation BlockStatementsopt }
108    ExplicitConstructorInvocation ::= this ( ArgumentListopt ) ;
109    ExplicitConstructorInvocation ::= super ( ArgumentListopt ) ;
110    ExplicitConstructorInvocation ::= Primary . this ( ArgumentListopt ) ;
111    ExplicitConstructorInvocation ::= Primary . super ( ArgumentListopt ) ;
112    ExplicitConstructorInvocation ::= Name . super ( ArgumentListopt ) ;
113    InterfaceDeclaration ::= Modifiersopt interface identifier ExtendsInterfacesopt InterfaceBody
114    ExtendsInterfaces ::= extends InterfaceTypeList
115    InterfaceBody ::= { InterfaceMemberDeclarationsopt }
116    InterfaceMemberDeclarations ::= InterfaceMemberDeclaration
117    InterfaceMemberDeclarations ::= InterfaceMemberDeclarations InterfaceMemberDeclaration
118    InterfaceMemberDeclaration ::= ConstantDeclaration
119    InterfaceMemberDeclaration ::= AbstractMethodDeclaration
120    InterfaceMemberDeclaration ::= ClassDeclaration
121    InterfaceMemberDeclaration ::= InterfaceDeclaration
122    InterfaceMemberDeclaration ::= ;
123    ConstantDeclaration ::= FieldDeclaration
124    AbstractMethodDeclaration ::= MethodHeader ;
125    ArrayInitializer ::= { ,opt }
126    ArrayInitializer ::= { VariableInitializers }
127    ArrayInitializer ::= { VariableInitializers , }
128    VariableInitializers ::= VariableInitializer
129    VariableInitializers ::= VariableInitializers , VariableInitializer
130    Block ::= { BlockStatementsopt }
131    BlockStatements ::= BlockStatement
132    BlockStatements ::= BlockStatements BlockStatement
133    BlockStatement ::= LocalVariableDeclarationStatement
134    BlockStatement ::= Statement
135    BlockStatement ::= ClassDeclaration
136    LocalVariableDeclarationStatement ::= LocalVariableDeclaration ;
137    LocalVariableDeclaration ::= Type VariableDeclarators
138    LocalVariableDeclaration ::= Modifiers Type VariableDeclarators
139    Statement ::= StatementWithoutTrailingSubstatement
140    Statement ::= LabeledStatement
141    Statement ::= IfThenStatement
142    Statement ::= IfThenElseStatement
143    Statement ::= WhileStatement
144    Statement ::= ForStatement
145    StatementNoShortIf ::= StatementWithoutTrailingSubstatement
146    StatementNoShortIf ::= LabeledStatementNoShortIf
147    StatementNoShortIf ::= IfThenElseStatementNoShortIf
148    StatementNoShortIf ::= WhileStatementNoShortIf
149    StatementNoShortIf ::= ForStatementNoShortIf
150    StatementWithoutTrailingSubstatement ::= Block
151    StatementWithoutTrailingSubstatement ::= EmptyStatement
152    StatementWithoutTrailingSubstatement ::= ExpressionStatement
153    StatementWithoutTrailingSubstatement ::= SwitchStatement
154    StatementWithoutTrailingSubstatement ::= DoStatement
155    StatementWithoutTrailingSubstatement ::= BreakStatement
156    StatementWithoutTrailingSubstatement ::= ContinueStatement
157    StatementWithoutTrailingSubstatement ::= ReturnStatement
158    StatementWithoutTrailingSubstatement ::= SynchronizedStatement
159    StatementWithoutTrailingSubstatement ::= ThrowStatement
160    StatementWithoutTrailingSubstatement ::= TryStatement
161    EmptyStatement ::= ;
162    LabeledStatement ::= identifier : Statement
163    LabeledStatementNoShortIf ::= identifier : StatementNoShortIf
164    ExpressionStatement ::= StatementExpression ;
165    StatementExpression ::= Assignment
166    StatementExpression ::= PreIncrementExpression
167    StatementExpression ::= PreDecrementExpression
168    StatementExpression ::= PostIncrementExpression
169    StatementExpression ::= PostDecrementExpression
170    StatementExpression ::= MethodInvocation
171    StatementExpression ::= ClassInstanceCreationExpression
172    IfThenStatement ::= if ( Expression ) Statement
173    IfThenElseStatement ::= if ( Expression ) StatementNoShortIf else Statement
174    IfThenElseStatementNoShortIf ::= if ( Expression ) StatementNoShortIf else StatementNoShortIf
175    SwitchStatement ::= switch ( Expression ) SwitchBlock
176    SwitchBlock ::= { }
177    SwitchBlock ::= { SwitchBlockStatements }
178    SwitchBlock ::= { SwitchLabels }
179    SwitchBlock ::= { SwitchBlockStatements SwitchLabels }
180    SwitchBlockStatements ::= SwitchBlockStatement
181    SwitchBlockStatements ::= SwitchBlockStatements SwitchBlockStatement
182    SwitchBlockStatement ::= SwitchLabels BlockStatements
183    SwitchLabels ::= SwitchLabel
184    SwitchLabels ::= SwitchLabels SwitchLabel
185    SwitchLabel ::= case ConstantExpression :
186    SwitchLabel ::= default :
187    WhileStatement ::= while ( Expression ) Statement
188    WhileStatementNoShortIf ::= while ( Expression ) StatementNoShortIf
189    DoStatement ::= do Statement while ( Expression ) ;
190    ForStatement ::= for ( ForInitopt ; Expressionopt ; ForUpdateopt ) Statement
191    ForStatementNoShortIf ::= for ( ForInitopt ; Expressionopt ; ForUpdateopt ) StatementNoShortIf
192    ForInit ::= StatementExpressionList
193    ForInit ::= LocalVariableDeclaration
194    ForUpdate ::= StatementExpressionList
195    StatementExpressionList ::= StatementExpression
196    StatementExpressionList ::= StatementExpressionList , StatementExpression
197    BreakStatement ::= break ;
198    BreakStatement ::= break identifier ;
199    ContinueStatement ::= continue ;
200    ContinueStatement ::= continue identifier ;
201    ReturnStatement ::= return Expressionopt ;
202    ThrowStatement ::= throw Expression ;
203    SynchronizedStatement ::= synchronized ( Expression ) Block
204    TryStatement ::= try Block Catches
205    TryStatement ::= try Block Catchesopt Finally
206    Catches ::= CatchClause
207    Catches ::= Catches CatchClause
208    CatchClause ::= catch ( FormalParameter ) Block
209    Finally ::= finally Block
210    Primary ::= PrimaryNoNewArray
211    Primary ::= ArrayCreationExpression
212    PrimaryNoNewArray ::= Literal
213    PrimaryNoNewArray ::= this
214    PrimaryNoNewArray ::= ( Expression )
215    PrimaryNoNewArray ::= ClassInstanceCreationExpression
216    PrimaryNoNewArray ::= FieldAccess
217    PrimaryNoNewArray ::= Name . this
218    PrimaryNoNewArray ::= Type . class
219    PrimaryNoNewArray ::= void . class
220    PrimaryNoNewArray ::= MethodInvocation
221    PrimaryNoNewArray ::= ArrayAccess
222    ClassInstanceCreationExpression ::= new ClassType ( ArgumentListopt ) ClassBodyopt
223    ClassInstanceCreationExpression ::= Primary . new SimpleName ( ArgumentListopt ) ClassBodyopt
224    ClassInstanceCreationExpression ::= Name . new SimpleName ( ArgumentListopt ) ClassBodyopt
225    ArgumentList ::= Expression
226    ArgumentList ::= ArgumentList , Expression
227    ArrayCreationExpression ::= new PrimitiveType DimExprs Dimsopt
228    ArrayCreationExpression ::= new ClassOrInterfaceType DimExprs Dimsopt
229    ArrayCreationExpression ::= new ArrayType ArrayInitializer
230    DimExprs ::= DimExpr
231    DimExprs ::= DimExprs DimExpr
232    DimExpr ::= [ Expression ]
233    Dims ::= [ ]
234    Dims ::= Dims [ ]
235    FieldAccess ::= Primary . identifier
236    FieldAccess ::= super . identifier
237    FieldAccess ::= Name . super . identifier
238    MethodInvocation ::= Name ( ArgumentListopt )
239    MethodInvocation ::= Primary . identifier ( ArgumentListopt )
240    MethodInvocation ::= super . identifier ( ArgumentListopt )
241    MethodInvocation ::= Name . super . identifier ( ArgumentListopt )
242    ArrayAccess ::= Name [ Expression ]
243    ArrayAccess ::= PrimaryNoNewArray [ Expression ]
244    PostfixExpression ::= Primary
245    PostfixExpression ::= Name
246    PostfixExpression ::= PostIncrementExpression
247    PostfixExpression ::= PostDecrementExpression
248    PostIncrementExpression ::= PostfixExpression ++
249    PostDecrementExpression ::= PostfixExpression '--'
250    UnaryExpression ::= PreIncrementExpression
251    UnaryExpression ::= PreDecrementExpression
252    UnaryExpression ::= + UnaryExpression
253    UnaryExpression ::= - UnaryExpression
254    UnaryExpression ::= UnaryExpressionNotPlusMinus
255    PreIncrementExpression ::= ++ UnaryExpression
256    PreDecrementExpression ::= '--' UnaryExpression
257    UnaryExpressionNotPlusMinus ::= PostfixExpression
258    UnaryExpressionNotPlusMinus ::= ~ UnaryExpression
259    UnaryExpressionNotPlusMinus ::= ! UnaryExpression
260    UnaryExpressionNotPlusMinus ::= CastExpression
261    CastExpression ::= ( PrimitiveType Dimsopt ) UnaryExpression
262    CastExpression ::= ( Expression ) UnaryExpressionNotPlusMinus
263    CastExpression ::= ( Name Dims ) UnaryExpressionNotPlusMinus
264    MultiplicativeExpression ::= UnaryExpression
265    MultiplicativeExpression ::= MultiplicativeExpression * UnaryExpression
266    MultiplicativeExpression ::= MultiplicativeExpression / UnaryExpression
267    MultiplicativeExpression ::= MultiplicativeExpression % UnaryExpression
268    AdditiveExpression ::= MultiplicativeExpression
269    AdditiveExpression ::= AdditiveExpression + MultiplicativeExpression
270    AdditiveExpression ::= AdditiveExpression - MultiplicativeExpression
271    ShiftExpression ::= AdditiveExpression
272    ShiftExpression ::= ShiftExpression << AdditiveExpression
273    ShiftExpression ::= ShiftExpression >> AdditiveExpression
274    ShiftExpression ::= ShiftExpression >>> AdditiveExpression
275    RelationalExpression ::= ShiftExpression
276    RelationalExpression ::= RelationalExpression < ShiftExpression
277    RelationalExpression ::= RelationalExpression > ShiftExpression
278    RelationalExpression ::= RelationalExpression <= ShiftExpression
279    RelationalExpression ::= RelationalExpression >= ShiftExpression
280    RelationalExpression ::= RelationalExpression instanceof ReferenceType
281    EqualityExpression ::= RelationalExpression
282    EqualityExpression ::= EqualityExpression == RelationalExpression
283    EqualityExpression ::= EqualityExpression != RelationalExpression
284    AndExpression ::= EqualityExpression
285    AndExpression ::= AndExpression & EqualityExpression
286    ExclusiveOrExpression ::= AndExpression
287    ExclusiveOrExpression ::= ExclusiveOrExpression ^ AndExpression
288    InclusiveOrExpression ::= ExclusiveOrExpression
289    InclusiveOrExpression ::= InclusiveOrExpression '|' ExclusiveOrExpression
290    ConditionalAndExpression ::= InclusiveOrExpression
291    ConditionalAndExpression ::= ConditionalAndExpression && InclusiveOrExpression
292    ConditionalOrExpression ::= ConditionalAndExpression
293    ConditionalOrExpression ::= ConditionalOrExpression || ConditionalAndExpression
294    ConditionalExpression ::= ConditionalOrExpression
295    ConditionalExpression ::= ConditionalOrExpression ? Expression : ConditionalExpression
296    AssignmentExpression ::= ConditionalExpression
297    AssignmentExpression ::= Assignment
298    Assignment ::= LeftHandSide AssignmentOperator AssignmentExpression
299    LeftHandSide ::= Name
300    LeftHandSide ::= FieldAccess
301    LeftHandSide ::= ArrayAccess
302    AssignmentOperator ::= =
303    AssignmentOperator ::= *=
304    AssignmentOperator ::= /=
305    AssignmentOperator ::= %=
306    AssignmentOperator ::= +=
307    AssignmentOperator ::= -=
308    AssignmentOperator ::= <<=
309    AssignmentOperator ::= >>=
310    AssignmentOperator ::= >>>=
311    AssignmentOperator ::= &=
312    AssignmentOperator ::= ^=
313    AssignmentOperator ::= |=
314    Expression ::= AssignmentExpression
315    ConstantExpression ::= Expression
316    PackageDeclarationopt ::= $Empty
317    PackageDeclarationopt ::= PackageDeclaration
318    Superopt ::= $Empty
319    Superopt ::= Super
320    Expressionopt ::= $Empty
321    Expressionopt ::= Expression
322    ClassBodyopt ::= $Empty
323    ClassBodyopt ::= ClassBody
324    ,opt ::= $Empty
325    ,opt ::= ,
326    ImportDeclarationsopt ::= $Empty
327    ImportDeclarationsopt ::= ImportDeclarations
328    TypeDeclarationsopt ::= $Empty
329    TypeDeclarationsopt ::= TypeDeclarations
330    ClassBodyDeclarationsopt ::= $Empty
331    ClassBodyDeclarationsopt ::= ClassBodyDeclarations
332    Modifiersopt ::= $Empty
333    Modifiersopt ::= Modifiers
334    BlockStatementsopt ::= $Empty
335    BlockStatementsopt ::= BlockStatements
336    Dimsopt ::= $Empty
337    Dimsopt ::= Dims
338    ArgumentListopt ::= $Empty
339    ArgumentListopt ::= ArgumentList
340    Throwsopt ::= $Empty
341    Throwsopt ::= Throws
342    FormalParameterListopt ::= $Empty
343    FormalParameterListopt ::= FormalParameterList
344    Interfacesopt ::= $Empty
345    Interfacesopt ::= Interfaces
346    InterfaceMemberDeclarationsopt ::= $Empty
347    InterfaceMemberDeclarationsopt ::= InterfaceMemberDeclarations
348    ForInitopt ::= $Empty
349    ForInitopt ::= ForInit
350    ForUpdateopt ::= $Empty
351    ForUpdateopt ::= ForUpdate
352    ExtendsInterfacesopt ::= $Empty
353    ExtendsInterfacesopt ::= ExtendsInterfaces
354    Catchesopt ::= $Empty
355    Catchesopt ::= Catches


Strongly-connected components in ranks:

    QualifiedName
    Name

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
1    3     initialize ::=
2    44    PackageDeclaration ::= package Name SEMICOLON
3    317   PackageDeclarationopt ::= PackageDeclaration
4    316   PackageDeclarationopt ::=
5    47    SingleTypeImportDeclaration ::= import Name SEMICOLON
6    48    TypeImportOnDemandDeclaration ::= import Name DOT MULTIPLY SEMICOLON
7    45    ImportDeclaration ::= SingleTypeImportDeclaration
8    46    ImportDeclaration ::= TypeImportOnDemandDeclaration
9    40    ImportDeclarations ::= ImportDeclaration
10   41    ImportDeclarations ::= ImportDeclarations ImportDeclaration
11   327   ImportDeclarationsopt ::= ImportDeclarations
12   326   ImportDeclarationsopt ::=
13   54    Modifier ::= public
14   55    Modifier ::= protected
15   56    Modifier ::= private
16   57    Modifier ::= static
17   58    Modifier ::= abstract
18   59    Modifier ::= final
19   60    Modifier ::= native
20   61    Modifier ::= strictfp
21   62    Modifier ::= synchronized
22   63    Modifier ::= transient
23   64    Modifier ::= volatile
24   52    Modifiers ::= Modifier
25   53    Modifiers ::= Modifiers Modifier
26   333   Modifiersopt ::= Modifiers
27   332   Modifiersopt ::=
28   65    ClassDeclaration ::= Modifiersopt class identifier Superopt Interfacesopt ClassBody
29   113   InterfaceDeclaration ::= Modifiersopt interface identifier ExtendsInterfacesopt InterfaceBody
30   49    TypeDeclaration ::= ClassDeclaration
31   50    TypeDeclaration ::= InterfaceDeclaration
32   51    TypeDeclaration ::= SEMICOLON
33   42    TypeDeclarations ::= TypeDeclaration
34   43    TypeDeclarations ::= TypeDeclarations TypeDeclaration
35   329   TypeDeclarationsopt ::= TypeDeclarations
36   328   TypeDeclarationsopt ::=
37   39    CompilationUnit ::= PackageDeclarationopt ImportDeclarationsopt TypeDeclarationsopt
38   130   Block ::= LBRACE BlockStatementsopt RBRACE
39   106   ConstructorBody ::= Block
40   107   ConstructorBody ::= LBRACE ExplicitConstructorInvocation BlockStatementsopt RBRACE
41   2     Goal ::= initialize ConstructorBody
42   1     Goal ::= initialize CompilationUnit
43   0     $accept ::= Goal
44   4     identifier ::= IDENTIFIER
45   13    BooleanLiteral ::= true
46   14    BooleanLiteral ::= false
47   5     Literal ::= IntegerLiteral
48   6     Literal ::= LongLiteral
49   7     Literal ::= FloatingPointLiteral
50   8     Literal ::= DoubleLiteral
51   9     Literal ::= BooleanLiteral
52   10    Literal ::= CharacterLiteral
53   11    Literal ::= StringLiteral
54   12    Literal ::= null
55   21    IntegralType ::= byte
56   22    IntegralType ::= short
57   23    IntegralType ::= int
58   24    IntegralType ::= long
59   25    IntegralType ::= char
60   26    FloatingPointType ::= float
61   27    FloatingPointType ::= double
62   19    NumericType ::= IntegralType
63   20    NumericType ::= FloatingPointType
64   17    PrimitiveType ::= NumericType
65   18    PrimitiveType ::= boolean
66   37    SimpleName ::= identifier
67   38    QualifiedName ::= Name DOT identifier
68   35    Name ::= SimpleName
69   36    Name ::= QualifiedName
70   30    ClassOrInterfaceType ::= Name
71   31    ArrayType ::= PrimitiveType Dims
72   32    ArrayType ::= Name Dims
73   28    ReferenceType ::= ClassOrInterfaceType
74   29    ReferenceType ::= ArrayType
75   15    Type ::= PrimitiveType
76   16    Type ::= ReferenceType
77   233   Dims ::= LBRACKET RBRACKET
78   234   Dims ::= Dims LBRACKET RBRACKET
79   33    ClassType ::= ClassOrInterfaceType
80   34    InterfaceType ::= ClassOrInterfaceType
81   66    Super ::= extends ClassType
82   319   Superopt ::= Super
83   318   Superopt ::=
84   67    Interfaces ::= implements InterfaceTypeList
85   345   Interfacesopt ::= Interfaces
86   344   Interfacesopt ::=
87   70    ClassBody ::= LBRACE ClassBodyDeclarationsopt RBRACE
88   68    InterfaceTypeList ::= InterfaceType
89   69    InterfaceTypeList ::= InterfaceTypeList COMMA InterfaceType
90   82    FieldDeclaration ::= Modifiersopt Type VariableDeclarators SEMICOLON
91   91    MethodHeader ::= Modifiersopt Type MethodDeclarator Throwsopt
92   92    MethodHeader ::= Modifiersopt void MethodDeclarator Throwsopt
93   90    MethodDeclaration ::= MethodHeader MethodBody
94   77    ClassMemberDeclaration ::= FieldDeclaration
95   78    ClassMemberDeclaration ::= MethodDeclaration
96   79    ClassMemberDeclaration ::= ClassDeclaration
97   80    ClassMemberDeclaration ::= InterfaceDeclaration
98   81    ClassMemberDeclaration ::= SEMICOLON
99   103   StaticInitializer ::= static Block
100  105   ConstructorDeclarator ::= identifier LPAREN FormalParameterListopt RPAREN
101  104   ConstructorDeclaration ::= Modifiersopt ConstructorDeclarator Throwsopt ConstructorBody
102  73    ClassBodyDeclaration ::= ClassMemberDeclaration
103  74    ClassBodyDeclaration ::= StaticInitializer
104  75    ClassBodyDeclaration ::= ConstructorDeclaration
105  76    ClassBodyDeclaration ::= Block
106  71    ClassBodyDeclarations ::= ClassBodyDeclaration
107  72    ClassBodyDeclarations ::= ClassBodyDeclarations ClassBodyDeclaration
108  331   ClassBodyDeclarationsopt ::= ClassBodyDeclarations
109  330   ClassBodyDeclarationsopt ::=
110  87    VariableDeclaratorId ::= identifier Dimsopt
111  85    VariableDeclarator ::= VariableDeclaratorId
112  86    VariableDeclarator ::= VariableDeclaratorId EQUAL VariableInitializer
113  83    VariableDeclarators ::= VariableDeclarator
114  84    VariableDeclarators ::= VariableDeclarators COMMA VariableDeclarator
115  255   PreIncrementExpression ::= PLUS_PLUS UnaryExpression
116  256   PreDecrementExpression ::= MINUS_MINUS UnaryExpression
117  227   ArrayCreationExpression ::= new PrimitiveType DimExprs Dimsopt
118  228   ArrayCreationExpression ::= new ClassOrInterfaceType DimExprs Dimsopt
119  229   ArrayCreationExpression ::= new ArrayType ArrayInitializer
120  242   ArrayAccess ::= Name LBRACKET Expression RBRACKET
121  243   ArrayAccess ::= PrimaryNoNewArray LBRACKET Expression RBRACKET
122  238   MethodInvocation ::= Name LPAREN ArgumentListopt RPAREN
123  239   MethodInvocation ::= Primary DOT identifier LPAREN ArgumentListopt RPAREN
124  240   MethodInvocation ::= super DOT identifier LPAREN ArgumentListopt RPAREN
125  241   MethodInvocation ::= Name DOT super DOT identifier LPAREN ArgumentListopt RPAREN
126  235   FieldAccess ::= Primary DOT identifier
127  236   FieldAccess ::= super DOT identifier
128  237   FieldAccess ::= Name DOT super DOT identifier
129  222   ClassInstanceCreationExpression ::= new ClassType LPAREN ArgumentListopt RPAREN ClassBodyopt
130  223   ClassInstanceCreationExpression ::= Primary DOT new SimpleName LPAREN ArgumentListopt RPAREN ClassBodyopt
131  224   ClassInstanceCreationExpression ::= Name DOT new SimpleName LPAREN ArgumentListopt RPAREN ClassBodyopt
132  212   PrimaryNoNewArray ::= Literal
133  213   PrimaryNoNewArray ::= this
134  214   PrimaryNoNewArray ::= LPAREN Expression RPAREN
135  215   PrimaryNoNewArray ::= ClassInstanceCreationExpression
136  216   PrimaryNoNewArray ::= FieldAccess
137  217   PrimaryNoNewArray ::= Name DOT this
138  218   PrimaryNoNewArray ::= Type DOT class
139  219   PrimaryNoNewArray ::= void DOT class
140  220   PrimaryNoNewArray ::= MethodInvocation
141  221   PrimaryNoNewArray ::= ArrayAccess
142  210   Primary ::= PrimaryNoNewArray
143  211   Primary ::= ArrayCreationExpression
144  249   PostDecrementExpression ::= PostfixExpression MINUS_MINUS
145  248   PostIncrementExpression ::= PostfixExpression PLUS_PLUS
146  244   PostfixExpression ::= Primary
147  245   PostfixExpression ::= Name
148  246   PostfixExpression ::= PostIncrementExpression
149  247   PostfixExpression ::= PostDecrementExpression
150  261   CastExpression ::= LPAREN PrimitiveType Dimsopt RPAREN UnaryExpression
151  262   CastExpression ::= LPAREN Expression RPAREN UnaryExpressionNotPlusMinus
152  263   CastExpression ::= LPAREN Name Dims RPAREN UnaryExpressionNotPlusMinus
153  257   UnaryExpressionNotPlusMinus ::= PostfixExpression
154  258   UnaryExpressionNotPlusMinus ::= TWIDDLE UnaryExpression
155  259   UnaryExpressionNotPlusMinus ::= NOT UnaryExpression
156  260   UnaryExpressionNotPlusMinus ::= CastExpression
157  250   UnaryExpression ::= PreIncrementExpression
158  251   UnaryExpression ::= PreDecrementExpression
159  252   UnaryExpression ::= PLUS UnaryExpression
160  253   UnaryExpression ::= MINUS UnaryExpression
161  254   UnaryExpression ::= UnaryExpressionNotPlusMinus
162  264   MultiplicativeExpression ::= UnaryExpression
163  265   MultiplicativeExpression ::= MultiplicativeExpression MULTIPLY UnaryExpression
164  266   MultiplicativeExpression ::= MultiplicativeExpression DIVIDE UnaryExpression
165  267   MultiplicativeExpression ::= MultiplicativeExpression REMAINDER UnaryExpression
166  268   AdditiveExpression ::= MultiplicativeExpression
167  269   AdditiveExpression ::= AdditiveExpression PLUS MultiplicativeExpression
168  270   AdditiveExpression ::= AdditiveExpression MINUS MultiplicativeExpression
169  271   ShiftExpression ::= AdditiveExpression
170  272   ShiftExpression ::= ShiftExpression LEFT_SHIFT AdditiveExpression
171  273   ShiftExpression ::= ShiftExpression RIGHT_SHIFT AdditiveExpression
172  274   ShiftExpression ::= ShiftExpression UNSIGNED_RIGHT_SHIFT AdditiveExpression
173  275   RelationalExpression ::= ShiftExpression
174  276   RelationalExpression ::= RelationalExpression LESS ShiftExpression
175  277   RelationalExpression ::= RelationalExpression GREATER ShiftExpression
176  278   RelationalExpression ::= RelationalExpression LESS_EQUAL ShiftExpression
177  279   RelationalExpression ::= RelationalExpression GREATER_EQUAL ShiftExpression
178  280   RelationalExpression ::= RelationalExpression instanceof ReferenceType
179  281   EqualityExpression ::= RelationalExpression
180  282   EqualityExpression ::= EqualityExpression EQUAL_EQUAL RelationalExpression
181  283   EqualityExpression ::= EqualityExpression NOT_EQUAL RelationalExpression
182  284   AndExpression ::= EqualityExpression
183  285   AndExpression ::= AndExpression AND EqualityExpression
184  286   ExclusiveOrExpression ::= AndExpression
185  287   ExclusiveOrExpression ::= ExclusiveOrExpression XOR AndExpression
186  288   InclusiveOrExpression ::= ExclusiveOrExpression
187  289   InclusiveOrExpression ::= InclusiveOrExpression OR ExclusiveOrExpression
188  290   ConditionalAndExpression ::= InclusiveOrExpression
189  291   ConditionalAndExpression ::= ConditionalAndExpression AND_AND InclusiveOrExpression
190  292   ConditionalOrExpression ::= ConditionalAndExpression
191  293   ConditionalOrExpression ::= ConditionalOrExpression OR_OR ConditionalAndExpression
192  294   ConditionalExpression ::= ConditionalOrExpression
193  295   ConditionalExpression ::= ConditionalOrExpression QUESTION Expression COLON ConditionalExpression
194  299   LeftHandSide ::= Name
195  300   LeftHandSide ::= FieldAccess
196  301   LeftHandSide ::= ArrayAccess
197  298   Assignment ::= LeftHandSide AssignmentOperator AssignmentExpression
198  296   AssignmentExpression ::= ConditionalExpression
199  297   AssignmentExpression ::= Assignment
200  314   Expression ::= AssignmentExpression
201  125   ArrayInitializer ::= LBRACE ,opt RBRACE
202  126   ArrayInitializer ::= LBRACE VariableInitializers RBRACE
203  127   ArrayInitializer ::= LBRACE VariableInitializers COMMA RBRACE
204  88    VariableInitializer ::= Expression
205  89    VariableInitializer ::= ArrayInitializer
206  337   Dimsopt ::= Dims
207  336   Dimsopt ::=
208  101   MethodBody ::= Block
209  102   MethodBody ::= SEMICOLON
210  93    MethodDeclarator ::= identifier LPAREN FormalParameterListopt RPAREN Dimsopt
211  98    Throws ::= throws ClassTypeList
212  341   Throwsopt ::= Throws
213  340   Throwsopt ::=
214  96    FormalParameter ::= Type VariableDeclaratorId
215  97    FormalParameter ::= Modifiers Type VariableDeclaratorId
216  94    FormalParameterList ::= FormalParameter
217  95    FormalParameterList ::= FormalParameterList COMMA FormalParameter
218  343   FormalParameterListopt ::= FormalParameterList
219  342   FormalParameterListopt ::=
220  99    ClassTypeList ::= ClassType
221  100   ClassTypeList ::= ClassTypeList COMMA ClassType
222  108   ExplicitConstructorInvocation ::= this LPAREN ArgumentListopt RPAREN SEMICOLON
223  109   ExplicitConstructorInvocation ::= super LPAREN ArgumentListopt RPAREN SEMICOLON
224  110   ExplicitConstructorInvocation ::= Primary DOT this LPAREN ArgumentListopt RPAREN SEMICOLON
225  111   ExplicitConstructorInvocation ::= Primary DOT super LPAREN ArgumentListopt RPAREN SEMICOLON
226  112   ExplicitConstructorInvocation ::= Name DOT super LPAREN ArgumentListopt RPAREN SEMICOLON
227  137   LocalVariableDeclaration ::= Type VariableDeclarators
228  138   LocalVariableDeclaration ::= Modifiers Type VariableDeclarators
229  136   LocalVariableDeclarationStatement ::= LocalVariableDeclaration SEMICOLON
230  161   EmptyStatement ::= SEMICOLON
231  165   StatementExpression ::= Assignment
232  166   StatementExpression ::= PreIncrementExpression
233  167   StatementExpression ::= PreDecrementExpression
234  168   StatementExpression ::= PostIncrementExpression
235  169   StatementExpression ::= PostDecrementExpression
236  170   StatementExpression ::= MethodInvocation
237  171   StatementExpression ::= ClassInstanceCreationExpression
238  164   ExpressionStatement ::= StatementExpression SEMICOLON
239  175   SwitchStatement ::= switch LPAREN Expression RPAREN SwitchBlock
240  189   DoStatement ::= do Statement while LPAREN Expression RPAREN SEMICOLON
241  197   BreakStatement ::= break SEMICOLON
242  198   BreakStatement ::= break identifier SEMICOLON
243  199   ContinueStatement ::= continue SEMICOLON
244  200   ContinueStatement ::= continue identifier SEMICOLON
245  201   ReturnStatement ::= return Expressionopt SEMICOLON
246  203   SynchronizedStatement ::= synchronized LPAREN Expression RPAREN Block
247  202   ThrowStatement ::= throw Expression SEMICOLON
248  204   TryStatement ::= try Block Catches
249  205   TryStatement ::= try Block Catchesopt Finally
250  150   StatementWithoutTrailingSubstatement ::= Block
251  151   StatementWithoutTrailingSubstatement ::= EmptyStatement
252  152   StatementWithoutTrailingSubstatement ::= ExpressionStatement
253  153   StatementWithoutTrailingSubstatement ::= SwitchStatement
254  154   StatementWithoutTrailingSubstatement ::= DoStatement
255  155   StatementWithoutTrailingSubstatement ::= BreakStatement
256  156   StatementWithoutTrailingSubstatement ::= ContinueStatement
257  157   StatementWithoutTrailingSubstatement ::= ReturnStatement
258  158   StatementWithoutTrailingSubstatement ::= SynchronizedStatement
259  159   StatementWithoutTrailingSubstatement ::= ThrowStatement
260  160   StatementWithoutTrailingSubstatement ::= TryStatement
261  162   LabeledStatement ::= identifier COLON Statement
262  172   IfThenStatement ::= if LPAREN Expression RPAREN Statement
263  173   IfThenElseStatement ::= if LPAREN Expression RPAREN StatementNoShortIf else Statement
264  187   WhileStatement ::= while LPAREN Expression RPAREN Statement
265  190   ForStatement ::= for LPAREN ForInitopt SEMICOLON Expressionopt SEMICOLON ForUpdateopt RPAREN Statement
266  139   Statement ::= StatementWithoutTrailingSubstatement
267  140   Statement ::= LabeledStatement
268  141   Statement ::= IfThenStatement
269  142   Statement ::= IfThenElseStatement
270  143   Statement ::= WhileStatement
271  144   Statement ::= ForStatement
272  133   BlockStatement ::= LocalVariableDeclarationStatement
273  134   BlockStatement ::= Statement
274  135   BlockStatement ::= ClassDeclaration
275  131   BlockStatements ::= BlockStatement
276  132   BlockStatements ::= BlockStatements BlockStatement
277  335   BlockStatementsopt ::= BlockStatements
278  334   BlockStatementsopt ::=
279  225   ArgumentList ::= Expression
280  226   ArgumentList ::= ArgumentList COMMA Expression
281  339   ArgumentListopt ::= ArgumentList
282  338   ArgumentListopt ::=
283  114   ExtendsInterfaces ::= extends InterfaceTypeList
284  353   ExtendsInterfacesopt ::= ExtendsInterfaces
285  352   ExtendsInterfacesopt ::=
286  115   InterfaceBody ::= LBRACE InterfaceMemberDeclarationsopt RBRACE
287  123   ConstantDeclaration ::= FieldDeclaration
288  124   AbstractMethodDeclaration ::= MethodHeader SEMICOLON
289  118   InterfaceMemberDeclaration ::= ConstantDeclaration
290  119   InterfaceMemberDeclaration ::= AbstractMethodDeclaration
291  120   InterfaceMemberDeclaration ::= ClassDeclaration
292  121   InterfaceMemberDeclaration ::= InterfaceDeclaration
293  122   InterfaceMemberDeclaration ::= SEMICOLON
294  116   InterfaceMemberDeclarations ::= InterfaceMemberDeclaration
295  117   InterfaceMemberDeclarations ::= InterfaceMemberDeclarations InterfaceMemberDeclaration
296  347   InterfaceMemberDeclarationsopt ::= InterfaceMemberDeclarations
297  346   InterfaceMemberDeclarationsopt ::=
298  325   ,opt ::= COMMA
299  324   ,opt ::=
300  128   VariableInitializers ::= VariableInitializer
301  129   VariableInitializers ::= VariableInitializers COMMA VariableInitializer
302  163   LabeledStatementNoShortIf ::= identifier COLON StatementNoShortIf
303  174   IfThenElseStatementNoShortIf ::= if LPAREN Expression RPAREN StatementNoShortIf else StatementNoShortIf
304  188   WhileStatementNoShortIf ::= while LPAREN Expression RPAREN StatementNoShortIf
305  191   ForStatementNoShortIf ::= for LPAREN ForInitopt SEMICOLON Expressionopt SEMICOLON ForUpdateopt RPAREN StatementNoShortIf
306  145   StatementNoShortIf ::= StatementWithoutTrailingSubstatement
307  146   StatementNoShortIf ::= LabeledStatementNoShortIf
308  147   StatementNoShortIf ::= IfThenElseStatementNoShortIf
309  148   StatementNoShortIf ::= WhileStatementNoShortIf
310  149   StatementNoShortIf ::= ForStatementNoShortIf
311  176   SwitchBlock ::= LBRACE RBRACE
312  177   SwitchBlock ::= LBRACE SwitchBlockStatements RBRACE
313  178   SwitchBlock ::= LBRACE SwitchLabels RBRACE
314  179   SwitchBlock ::= LBRACE SwitchBlockStatements SwitchLabels RBRACE
315  185   SwitchLabel ::= case ConstantExpression COLON
316  186   SwitchLabel ::= default COLON
317  183   SwitchLabels ::= SwitchLabel
318  184   SwitchLabels ::= SwitchLabels SwitchLabel
319  182   SwitchBlockStatement ::= SwitchLabels BlockStatements
320  180   SwitchBlockStatements ::= SwitchBlockStatement
321  181   SwitchBlockStatements ::= SwitchBlockStatements SwitchBlockStatement
322  315   ConstantExpression ::= Expression
323  195   StatementExpressionList ::= StatementExpression
324  196   StatementExpressionList ::= StatementExpressionList COMMA StatementExpression
325  192   ForInit ::= StatementExpressionList
326  193   ForInit ::= LocalVariableDeclaration
327  349   ForInitopt ::= ForInit
328  348   ForInitopt ::=
329  321   Expressionopt ::= Expression
330  320   Expressionopt ::=
331  194   ForUpdate ::= StatementExpressionList
332  351   ForUpdateopt ::= ForUpdate
333  350   ForUpdateopt ::=
334  208   CatchClause ::= catch LPAREN FormalParameter RPAREN Block
335  206   Catches ::= CatchClause
336  207   Catches ::= Catches CatchClause
337  355   Catchesopt ::= Catches
338  354   Catchesopt ::=
339  209   Finally ::= finally Block
340  323   ClassBodyopt ::= ClassBody
341  322   ClassBodyopt ::=
342  232   DimExpr ::= LBRACKET Expression RBRACKET
343  230   DimExprs ::= DimExpr
344  231   DimExprs ::= DimExprs DimExpr
345  302   AssignmentOperator ::= EQUAL
346  303   AssignmentOperator ::= MULTIPLY_EQUAL
347  304   AssignmentOperator ::= DIVIDE_EQUAL
348  305   AssignmentOperator ::= REMAINDER_EQUAL
349  306   AssignmentOperator ::= PLUS_EQUAL
350  307   AssignmentOperator ::= MINUS_EQUAL
351  308   AssignmentOperator ::= LEFT_SHIFT_EQUAL
352  309   AssignmentOperator ::= RIGHT_SHIFT_EQUAL
353  310   AssignmentOperator ::= UNSIGNED_RIGHT_SHIFT_EQUAL
354  311   AssignmentOperator ::= AND_EQUAL
355  312   AssignmentOperator ::= XOR_EQUAL
356  313   AssignmentOperator ::= OR_EQUAL
D:/eclipse/workspace/lpg.javaruntime.examples/javaexample/softjavaparser/SoftJavaParser.g:22:55:22:59:909:913: Informative: The terminal const is useless.
D:/eclipse/workspace/lpg.javaruntime.examples/javaexample/softjavaparser/SoftJavaParser.g:24:9:24:12:995:998: Informative: The terminal goto is useless.


 IBM LALR Parser Generator              1.00 (Feb 16 2007)


Name map:

'$empty' ::= '$empty'
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
IDENTIFIER ::= IDENTIFIER
EOF_TOKEN ::= EOF_TOKEN
ERROR_TOKEN ::= ERROR_TOKEN
ConstructorBody ::= ConstructorBody
identifier ::= identifier
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
SwitchLabels ::= SwitchLabels
SwitchBlockStatement ::= SwitchBlockStatement
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
ConditionalExpression ::= ConditionalExpression
AssignmentExpression ::= AssignmentExpression
LeftHandSide ::= LeftHandSide
AssignmentOperator ::= AssignmentOperator
Goal ::= 
initialize ::= 
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
,opt ::= 
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
ForInitopt ::= 
Expressionopt ::= 
ForUpdateopt ::= 
ForInit ::= 
ForUpdate ::= 
Catchesopt ::= 
ArrayCreationExpression ::= 
ClassBodyopt ::= 
CastExpression ::= 

 IBM LALR Parser Generator              1.00 (Feb 16 2007)


Scopes:

MethodInvocation ::= Name DOT super DOT identifier LPAREN ArgumentListopt  .
                     RPAREN 
ForStatementNoShortIf ::= for LPAREN ForInitopt SEMICOLON Expressionopt 
                          SEMICOLON ForUpdateopt  .RPAREN StatementNoShortIf 
ForStatement ::= for LPAREN ForInitopt SEMICOLON Expressionopt SEMICOLON 
                 ForUpdateopt  .RPAREN Statement 
ClassInstanceCreationExpression ::= Name DOT new SimpleName LPAREN 
                                    ArgumentListopt  .RPAREN ClassBodyopt 
ClassInstanceCreationExpression ::= Primary DOT new SimpleName LPAREN 
                                    ArgumentListopt  .RPAREN ClassBodyopt 
MethodInvocation ::= super DOT identifier LPAREN ArgumentListopt  .RPAREN 
MethodInvocation ::= Primary DOT identifier LPAREN ArgumentListopt  .RPAREN 
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
                          SEMICOLON ForUpdateopt RPAREN StatementNoShortIf 
ForStatement ::= for LPAREN ForInitopt SEMICOLON Expressionopt  .SEMICOLON 
                 ForUpdateopt RPAREN Statement 
ClassInstanceCreationExpression ::= new ClassType LPAREN ArgumentListopt  .
                                    RPAREN ClassBodyopt 
ArrayAccess ::= PrimaryNoNewArray LBRACKET Expression  .RBRACKET 
ArrayAccess ::= Name LBRACKET Expression  .RBRACKET 
MethodInvocation ::= Name LPAREN ArgumentListopt  .RPAREN 
TryStatement ::= try Block Catchesopt  .Finally 
SwitchBlock ::= LBRACE SwitchBlockStatements SwitchLabels  .RBRACE 
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
ForStatementNoShortIf ::= for LPAREN ForInitopt  .SEMICOLON Expressionopt 
                          SEMICOLON ForUpdateopt RPAREN StatementNoShortIf 
ForStatement ::= for LPAREN ForInitopt  .SEMICOLON Expressionopt SEMICOLON 
                 ForUpdateopt RPAREN Statement 
DimExpr ::= LBRACKET Expression  .RBRACKET 
PrimaryNoNewArray ::= LPAREN Expression  .RPAREN 
TryStatement ::= try Block  .Catches 
ThrowStatement ::= throw Expression  .SEMICOLON 
ReturnStatement ::= return Expressionopt  .SEMICOLON 
SwitchLabel ::= case ConstantExpression  .COLON 
SwitchBlock ::= LBRACE SwitchLabels  .RBRACE 
SwitchBlock ::= LBRACE SwitchBlockStatements  .RBRACE 
Block ::= LBRACE BlockStatementsopt  .RBRACE 
ArrayInitializer ::= LBRACE VariableInitializers  .RBRACE 
InterfaceBody ::= LBRACE InterfaceMemberDeclarationsopt  .RBRACE 
ClassBody ::= LBRACE ClassBodyDeclarationsopt  .RBRACE 
CastExpression ::= LPAREN Expression  .RPAREN UnaryExpressionNotPlusMinus 
SwitchBlock ::= LBRACE SwitchBlockStatements  .SwitchLabels RBRACE 
ArrayInitializer ::= LBRACE VariableInitializers  .COMMA RBRACE 
DoStatement ::= do Statement  .while LPAREN Expression RPAREN SEMICOLON 
SwitchBlockStatement ::= SwitchLabels  .BlockStatements 
ExpressionStatement ::= StatementExpression  .SEMICOLON 
LocalVariableDeclarationStatement ::= LocalVariableDeclaration  .SEMICOLON 
Assignment ::= LeftHandSide  .AssignmentOperator AssignmentExpression 
ExplicitConstructorInvocation ::= Primary  .DOT super LPAREN ArgumentListopt 
                                  RPAREN SEMICOLON 
ExplicitConstructorInvocation ::= Primary  .DOT this LPAREN ArgumentListopt 
                                  RPAREN SEMICOLON 

 IBM LALR Parser Generator              1.00 (Feb 16 2007)


---------------------------------- CONFLICTS ----------------------------------



STATE 38 -----------------------------------------------------------------------
( 6 )

ClassOrInterfaceType ::= Name . (30)
ArrayType ::= Name  .Dims 
QualifiedName ::= Name  .DOT identifier 
ExplicitConstructorInvocation ::= Name  .DOT super LPAREN ArgumentListopt 
                                  RPAREN SEMICOLON 
PrimaryNoNewArray ::= Name  .DOT this 
ClassInstanceCreationExpression ::= Name  .DOT new SimpleName LPAREN 
                                    ArgumentListopt RPAREN ClassBodyopt 
FieldAccess ::= Name  .DOT super DOT identifier 
MethodInvocation ::= Name  .LPAREN ArgumentListopt RPAREN 
MethodInvocation ::= Name  .DOT super DOT identifier LPAREN ArgumentListopt 
                     RPAREN 
ArrayAccess ::= Name  .LBRACKET Expression RBRACKET 
PostfixExpression ::= Name . (245)
LeftHandSide ::= Name . (299)

Dims ::= .LBRACKET RBRACKET 
Dims ::= .Dims LBRACKET RBRACKET 

*** Shift/reduce conflict on "DOT" with rule 30

PrimaryNoNewArray ::= .Type DOT class 
Type ::= .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= Name . (30)




STATE 59 -----------------------------------------------------------------------
( 12 14 22 23 26 41 50 79 83 89 98 101 104 105 106 107 108 109 114 141 149 150 
  152 154 177 206 207 217 219 221 222 225 226 227 228 229 237 248 251 270 271 
  276 278 279 280 281 282 283 294 296 309 310 311 312 327 328 334 )

ClassOrInterfaceType ::= Name . (30)
ArrayType ::= Name  .Dims 
QualifiedName ::= Name  .DOT identifier 
PrimaryNoNewArray ::= Name  .DOT this 
ClassInstanceCreationExpression ::= Name  .DOT new SimpleName LPAREN 
                                    ArgumentListopt RPAREN ClassBodyopt 
FieldAccess ::= Name  .DOT super DOT identifier 
MethodInvocation ::= Name  .LPAREN ArgumentListopt RPAREN 
MethodInvocation ::= Name  .DOT super DOT identifier LPAREN ArgumentListopt 
                     RPAREN 
ArrayAccess ::= Name  .LBRACKET Expression RBRACKET 
PostfixExpression ::= Name . (245)
LeftHandSide ::= Name . (299)

Dims ::= .LBRACKET RBRACKET 
Dims ::= .Dims LBRACKET RBRACKET 

*** Shift/reduce conflict on "DOT" with rule 30

PrimaryNoNewArray ::= .Type DOT class 
Type ::= .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= Name . (30)

*** 1 Keyword/Identifier Reduce/reduce conflicts detected



STATE 87 -----------------------------------------------------------------------
( 18 48 128 173 216 244 286 292 320 323 331 )

ClassOrInterfaceType ::= Name . (30)
ArrayType ::= Name  .Dims 
QualifiedName ::= Name  .DOT identifier 

Dims ::= .LBRACKET RBRACKET 
Dims ::= .Dims LBRACKET RBRACKET 

*** Shift/reduce conflict on "LBRACKET" with rule 30

ArrayCreationExpression ::= new  .ClassOrInterfaceType DimExprs Dimsopt 
ClassOrInterfaceType ::= Name . (30)




STATE 100 ----------------------------------------------------------------------
( 34 35 62 63 67 68 123 124 125 126 127 129 130 131 132 133 134 135 136 137 
  138 139 140 142 143 183 233 234 235 )

ClassOrInterfaceType ::= Name . (30)
ArrayType ::= Name  .Dims 
QualifiedName ::= Name  .DOT identifier 
PrimaryNoNewArray ::= Name  .DOT this 
ClassInstanceCreationExpression ::= Name  .DOT new SimpleName LPAREN 
                                    ArgumentListopt RPAREN ClassBodyopt 
FieldAccess ::= Name  .DOT super DOT identifier 
MethodInvocation ::= Name  .LPAREN ArgumentListopt RPAREN 
MethodInvocation ::= Name  .DOT super DOT identifier LPAREN ArgumentListopt 
                     RPAREN 
ArrayAccess ::= Name  .LBRACKET Expression RBRACKET 
PostfixExpression ::= Name . (245)

Dims ::= .LBRACKET RBRACKET 
Dims ::= .Dims LBRACKET RBRACKET 

*** Shift/reduce conflict on "DOT" with rule 30

PrimaryNoNewArray ::= .Type DOT class 
Type ::= .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= Name . (30)




STATE 122 ----------------------------------------------------------------------
( 65 )

ClassOrInterfaceType ::= Name . (30)
ArrayType ::= Name  .Dims 
QualifiedName ::= Name  .DOT identifier 
PrimaryNoNewArray ::= Name  .DOT this 
ClassInstanceCreationExpression ::= Name  .DOT new SimpleName LPAREN 
                                    ArgumentListopt RPAREN ClassBodyopt 
FieldAccess ::= Name  .DOT super DOT identifier 
MethodInvocation ::= Name  .LPAREN ArgumentListopt RPAREN 
MethodInvocation ::= Name  .DOT super DOT identifier LPAREN ArgumentListopt 
                     RPAREN 
ArrayAccess ::= Name  .LBRACKET Expression RBRACKET 
PostfixExpression ::= Name . (245)
CastExpression ::= LPAREN Name  .Dims RPAREN UnaryExpressionNotPlusMinus 
LeftHandSide ::= Name . (299)

Dims ::= .LBRACKET RBRACKET 
Dims ::= .Dims LBRACKET RBRACKET 

*** Shift/reduce conflict on "DOT" with rule 30

PrimaryNoNewArray ::= .Type DOT class 
Type ::= .ReferenceType 
ReferenceType ::= .ClassOrInterfaceType 
ClassOrInterfaceType ::= Name . (30)




***Warning: D:/eclipse/workspace/lpg.javaruntime.examples/javaexample/softjavaparser/SoftJavaParser.g is not LALR(1).


Number of Terminals: 106
Number of Nonterminals: 158
Number of Productions: 356
Number of Items: 1048
Number of Scopes: 57
Number of States: 334
Number of Shift actions: 1229
Number of Goto actions: 1496
Number of Shift/Reduce actions: 8611
Number of Goto/Reduce actions: 2516
Number of Reduce actions: 2865
Number of Shift-Reduce conflicts: 5
Number of Reduce-Reduce conflicts: 0
Number of Keyword/Identifier Shift conflicts: 1795
Number of Keyword/Identifier Shift-Reduce conflicts: 67
Number of Keyword/Identifier Reduce-Reduce conflicts: 3

Number of entries in base Action Table: 4346
Additional space required for compaction of Action Table: 15.8%

Number of unique terminal states: 241
Number of Shift actions saved by merging: 4081
Number of Conflict points saved by merging: 1086
Number of Reduce actions saved by merging: 110
Number of Reduce saved by default: 1939

Number of entries in Terminal Action Table: 3257
Additional space required for compaction of Terminal Table: 1.8%

Actions in Compressed Tables:
     Number of Shifts: 335
     Number of Shift/Reduces: 1814
     Number of conflict points: 758
     Number of Gotos: 1496
     Number of Goto/Reduces: 2516
     Number of Reduces: 109
     Number of Defaults: 105

Parsing Tables storage:
    Storage required for BASE_CHECK: 10778 Bytes
    Storage required for BASE_ACTION: 11314 Bytes
    Storage required for TERM_CHECK: 3360 Bytes
    Storage required for TERM_ACTION: 6634 Bytes

Error maps storage:
    Storage required for ACTION_SYMBOLS_BASE map: 670 Bytes
    Storage required for ACTION_SYMBOLS_RANGE map: 926 Bytes
    Storage required for NACTION_SYMBOLS_BASE map: 670 Bytes
    Storage required for NACTION_SYMBOLS_RANGE map: 358 Bytes
    Storage required for TERMINAL_INDEX map: 214 Bytes
    Storage required for NON_TERMINAL_INDEX map: 320 Bytes

    Storage required for SCOPE_PREFIX map: 114 Bytes
    Storage required for SCOPE_SUFFIX map: 114 Bytes
    Storage required for SCOPE_LHS_SYMBOL map: 114 Bytes
    Storage required for SCOPE_LOOK_AHEAD map: 57 Bytes
    Storage required for SCOPE_STATE_SET map: 114 Bytes
    Storage required for SCOPE_RIGHT_SIDE map: 604 Bytes
    Storage required for SCOPE_STATE map: 422 Bytes
    Storage required for IN_SYMB map: 670 Bytes

    Number of names: 195
    Number of characters in name: 1859
