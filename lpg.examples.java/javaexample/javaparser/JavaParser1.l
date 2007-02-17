
Options in effect for C:\lpgjavaruntime\examples\javaexample\src\javaparser\JavaParser1.g:

    ACTION-BLOCK=("JavaParser.java","/.","./")

    AUTOMATIC-AST=NESTED  AST-DIRECTORY="./"  AST-PACKAGE="javaparser"  
    AST-TYPE="Ast"  NOATTRIBUTES  NOBACKTRACK  BYTE  CONFLICTS  
    DAT-DIRECTORY="./"  DAT-FILE="JavaParserdcl.data"  
    DCL-FILE="JavaParserdcl.java"  NODEBUG  DEF-FILE="JavaParserdef.java"  
    NOEDIT  ERROR-MAPS  ESCAPE='$'  
    EXPORT-TERMINALS=("JavaParserexp.java","","")  EXTENDS-PARSETABLE  
    FACTORY="new "  FILE-PREFIX="JavaParser"  NOFIRST  NOFOLLOW  NOGOTO-DEFAULT
    GRM-FILE="C:\lpgjavaruntime\examples\javaexample\src\javaparser\JavaParser1.g"
    IMP-FILE="JavaParserimp.java"  IMPORT-TERMINALS="JavaLexer.g"  
    INCLUDE-DIRECTORY="C:\lpgjavaruntime\examples\javaexample\src\javaparser\;.;C:\eclipse\workspace\lpg.lpgjavaruntime\include;C:\eclipse\workspace;C:\eclipse\workspace\com.ibm.db.parsers.sql2003\src\com\ibm\db\parsers\sql2003;C:\eclipse\workspace\com.ibm.db.parsers.sql.db2.zseries\src\com\ibm\db\parsers\db2\lexer;"
    IMP-FILE="JavaParserimp.java"  IMPORT-TERMINALS="JavaLexer.g"  LALR=2  LIST
    MARGIN=4  MAX-CASES=1024  NAMES=OPTIMIZED  NONT-CHECK  OR_MARKER='|'  
    PACKAGE="javaparser"  PARSETABLE-INTERFACES="lpg.lpgjavaruntime.ParseTable"
    PREFIX="TK_"  PRIORITY  PROGRAMMING_LANGUAGE=JAVA  
    PRS-FILE="JavaParserprs.java"  NOQUIET  READ-REDUCE  REMAP-TERMINALS  
    NOSAVE-PARENT  SCOPES  NOSERIALIZE  NOSHIFT-DEFAULT  NOSINGLE-PRODUCTIONS  
    NOSOFT-KEYWORDS  NOSTATES  SUFFIX=""  SYM-FILE="JavaParsersym.java"  
    TAB-FILE="JavaParser1.t"  TABLE  TEMPLATE="dtParserTemplateB.g"  
    TRACE=CONFLICTS  VARIABLES  NOVERBOSE  VISITOR=DEFAULT  
    VISITOR-TYPE="Visitor"  WARNINGS  NOXREF  


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



    $copyright
    /../


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


    $import_classes
    /../


    $action_class
    /.$file_prefix./


    $ast_class
    /.Ast./


    $setSym1
    /.getParser().setSym1./


    $setResult
    /.getParser().setSym1./


    $getSym
    /.getParser().getSym./


    $getToken
    /.getParser().getToken./


    $getIToken
    /.getIToken./


    $getLeftSpan
    /.getParser().getFirstToken./


    $getRightSpan
    /.getParser().getLastToken./


    $prs_stream
    /.prsStream./


    $package_declaration
    /.package $package;./


    $prs_stream_class
    /.PrsStream./


Aliases:

    <SwitchStatement> ::= SwitchStatement
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
    SlComment
    MlComment
    DocComment
    EOF_TOKEN
    ERROR_TOKEN


Rules:

1      Literal ::= IntegerLiteral
2      Literal ::= LongLiteral
3      Literal ::= FloatingPointLiteral
4      Literal ::= DoubleLiteral
5      Literal ::= BooleanLiteral
6      Literal ::= CharacterLiteral
7      Literal ::= StringLiteral
8      Literal ::= null $null_literal
9      BooleanLiteral ::= true
10     BooleanLiteral ::= false
11     Type ::= PrimitiveType
12     Type ::= ReferenceType
13     PrimitiveType ::= NumericType
14     PrimitiveType ::= boolean
15     NumericType ::= IntegralType
16     NumericType ::= FloatingPointType
17     IntegralType ::= byte
18     IntegralType ::= short
19     IntegralType ::= int
20     IntegralType ::= long
21     IntegralType ::= char
22     FloatingPointType ::= float
23     FloatingPointType ::= double
24     ReferenceType ::= ClassOrInterfaceType
25     ReferenceType ::= ArrayType
26     ClassOrInterfaceType ::= Name
27     ArrayType ::= PrimitiveType Dims
28     ArrayType ::= Name Dims
29     ClassType ::= ClassOrInterfaceType
30     InterfaceType ::= ClassOrInterfaceType
31     Name ::= SimpleName
32     Name ::= QualifiedName
33     SimpleName ::= IDENTIFIER
34     QualifiedName ::= Name . IDENTIFIER
35     CompilationUnit ::= PackageDeclarationopt ImportDeclarationsopt TypeDeclarationsopt
36     ImportDeclarations ::= ImportDeclaration
37     ImportDeclarations ::= ImportDeclarations ImportDeclaration
38     TypeDeclarations ::= TypeDeclaration
39     TypeDeclarations ::= TypeDeclarations TypeDeclaration
40     PackageDeclaration ::= package Name ;
41     ImportDeclaration ::= SingleTypeImportDeclaration
42     ImportDeclaration ::= TypeImportOnDemandDeclaration
43     SingleTypeImportDeclaration ::= import Name ;
44     TypeImportOnDemandDeclaration ::= import Name . * ;
45     TypeDeclaration ::= ClassDeclaration
46     TypeDeclaration ::= InterfaceDeclaration
47     TypeDeclaration ::= ;
48     Modifiers ::= Modifier
49     Modifiers ::= Modifiers Modifier
50     Modifier ::= public
51     Modifier ::= protected
52     Modifier ::= private
53     Modifier ::= static
54     Modifier ::= abstract
55     Modifier ::= final
56     Modifier ::= native
57     Modifier ::= strictfp
58     Modifier ::= synchronized
59     Modifier ::= transient
60     Modifier ::= volatile
61     ClassDeclaration ::= Modifiersopt class IDENTIFIER Superopt Interfacesopt ClassBody
62     Super ::= extends ClassType
63     Interfaces ::= implements InterfaceTypeList
64     InterfaceTypeList ::= InterfaceType
65     InterfaceTypeList ::= InterfaceTypeList , InterfaceType
66     ClassBody ::= { ClassBodyDeclarationsopt }
67     ClassBodyDeclarations ::= ClassBodyDeclaration
68     ClassBodyDeclarations ::= ClassBodyDeclarations ClassBodyDeclaration
69     ClassBodyDeclaration ::= ClassMemberDeclaration
70     ClassBodyDeclaration ::= StaticInitializer
71     ClassBodyDeclaration ::= ConstructorDeclaration
72     ClassBodyDeclaration ::= Block
73     ClassMemberDeclaration ::= FieldDeclaration
74     ClassMemberDeclaration ::= MethodDeclaration
75     ClassMemberDeclaration ::= ClassDeclaration
76     ClassMemberDeclaration ::= InterfaceDeclaration
77     ClassMemberDeclaration ::= ;
78     FieldDeclaration ::= Modifiersopt Type VariableDeclarators ;
79     VariableDeclarators ::= VariableDeclarator
80     VariableDeclarators ::= VariableDeclarators , VariableDeclarator
81     VariableDeclarator ::= VariableDeclaratorId
82     VariableDeclarator ::= VariableDeclaratorId = VariableInitializer
83     VariableDeclaratorId ::= IDENTIFIER Dimsopt
84     VariableInitializer ::= Expression
85     VariableInitializer ::= ArrayInitializer
86     MethodDeclaration ::= MethodHeader MethodBody
87     MethodHeader ::= Modifiersopt Type MethodDeclarator Throwsopt
88     MethodHeader ::= Modifiersopt void MethodDeclarator Throwsopt
89     MethodDeclarator ::= IDENTIFIER ( FormalParameterListopt ) Dimsopt
90     FormalParameterList ::= FormalParameter
91     FormalParameterList ::= FormalParameterList , FormalParameter
92     FormalParameter ::= Type VariableDeclaratorId
93     FormalParameter ::= Modifiers Type VariableDeclaratorId
94     Throws ::= throws ClassTypeList
95     ClassTypeList ::= ClassType
96     ClassTypeList ::= ClassTypeList , ClassType
97     MethodBody ::= Block
98     MethodBody ::= ;
99     StaticInitializer ::= static Block $Block
100    ConstructorDeclaration ::= Modifiersopt ConstructorDeclarator Throwsopt ConstructorBody
101    ConstructorDeclarator ::= IDENTIFIER ( FormalParameterListopt )
102    ConstructorBody ::= Block
103    ConstructorBody ::= { ExplicitConstructorInvocation BlockStatementsopt }
104    ExplicitConstructorInvocation ::= this ( ArgumentListopt ) ;
105    ExplicitConstructorInvocation ::= super ( ArgumentListopt ) ;
106    ExplicitConstructorInvocation ::= Primary . this ( ArgumentListopt ) ;
107    ExplicitConstructorInvocation ::= Primary $expression . super ( ArgumentListopt ) ;
108    ExplicitConstructorInvocation ::= Name $expression . super ( ArgumentListopt ) ;
109    InterfaceDeclaration ::= Modifiersopt interface IDENTIFIER ExtendsInterfacesopt InterfaceBody
110    ExtendsInterfaces ::= extends InterfaceTypeList
111    InterfaceBody ::= { InterfaceMemberDeclarationsopt }
112    InterfaceMemberDeclarations ::= InterfaceMemberDeclaration
113    InterfaceMemberDeclarations ::= InterfaceMemberDeclarations InterfaceMemberDeclaration
114    InterfaceMemberDeclaration ::= ConstantDeclaration
115    InterfaceMemberDeclaration ::= AbstractMethodDeclaration
116    InterfaceMemberDeclaration ::= ClassDeclaration
117    InterfaceMemberDeclaration ::= InterfaceDeclaration
118    InterfaceMemberDeclaration ::= ;
119    ConstantDeclaration ::= FieldDeclaration
120    AbstractMethodDeclaration ::= MethodHeader ;
121    ArrayInitializer ::= { Commaopt }
122    ArrayInitializer ::= { VariableInitializers }
123    ArrayInitializer ::= { VariableInitializers , }
124    VariableInitializers ::= VariableInitializer
125    VariableInitializers ::= VariableInitializers , VariableInitializer
126    Block ::= { BlockStatementsopt }
127    BlockStatements ::= BlockStatement
128    BlockStatements ::= BlockStatements BlockStatement
129    BlockStatement ::= LocalVariableDeclarationStatement
130    BlockStatement ::= Statement
131    BlockStatement ::= ClassDeclaration
132    LocalVariableDeclarationStatement ::= LocalVariableDeclaration ;
133    LocalVariableDeclaration ::= Type VariableDeclarators
134    LocalVariableDeclaration ::= Modifiers Type VariableDeclarators
135    Statement ::= StatementWithoutTrailingSubstatement
136    Statement ::= LabeledStatement
137    Statement ::= IfThenStatement
138    Statement ::= IfThenElseStatement
139    Statement ::= WhileStatement
140    Statement ::= ForStatement
141    StatementNoShortIf ::= StatementWithoutTrailingSubstatement
142    StatementNoShortIf ::= LabeledStatementNoShortIf
143    StatementNoShortIf ::= IfThenElseStatementNoShortIf
144    StatementNoShortIf ::= WhileStatementNoShortIf
145    StatementNoShortIf ::= ForStatementNoShortIf
146    StatementWithoutTrailingSubstatement ::= Block
147    StatementWithoutTrailingSubstatement ::= EmptyStatement
148    StatementWithoutTrailingSubstatement ::= ExpressionStatement
149    StatementWithoutTrailingSubstatement ::= SwitchStatement
150    StatementWithoutTrailingSubstatement ::= DoStatement
151    StatementWithoutTrailingSubstatement ::= BreakStatement
152    StatementWithoutTrailingSubstatement ::= ContinueStatement
153    StatementWithoutTrailingSubstatement ::= ReturnStatement
154    StatementWithoutTrailingSubstatement ::= SynchronizedStatement
155    StatementWithoutTrailingSubstatement ::= ThrowStatement
156    StatementWithoutTrailingSubstatement ::= TryStatement
157    EmptyStatement ::= ;
158    LabeledStatement ::= IDENTIFIER : Statement
159    LabeledStatementNoShortIf ::= IDENTIFIER : StatementNoShortIf $Statement
160    ExpressionStatement ::= StatementExpression ;
161    StatementExpression ::= Assignment
162    StatementExpression ::= PreIncrementExpression
163    StatementExpression ::= PreDecrementExpression
164    StatementExpression ::= PostIncrementExpression
165    StatementExpression ::= PostDecrementExpression
166    StatementExpression ::= MethodInvocation
167    StatementExpression ::= ClassInstanceCreationExpression
168    IfThenStatement ::= if ( Expression ) Statement $thenStmt
169    IfThenElseStatement ::= if ( Expression ) StatementNoShortIf $thenStmt else Statement $elseStmt
170    IfThenElseStatementNoShortIf ::= if ( Expression ) StatementNoShortIf $thenStmt else StatementNoShortIf $elseStmt
171    SwitchStatement ::= switch ( Expression ) SwitchBlock
172    SwitchBlock ::= { }
173    SwitchBlock ::= { SwitchBlockStatements }
174    SwitchBlock ::= { SwitchLabels }
175    SwitchBlock ::= { SwitchBlockStatements SwitchLabels }
176    SwitchBlockStatements ::= SwitchBlockStatement
177    SwitchBlockStatements ::= SwitchBlockStatements SwitchBlockStatement
178    SwitchBlockStatement ::= SwitchLabels BlockStatements
179    SwitchLabels ::= SwitchLabel
180    SwitchLabels ::= SwitchLabels SwitchLabel
181    SwitchLabel ::= case ConstantExpression :
182    SwitchLabel ::= default :
183    WhileStatement ::= while ( Expression ) Statement
184    WhileStatementNoShortIf ::= while ( Expression ) StatementNoShortIf $Statement
185    DoStatement ::= do Statement while ( Expression ) ;
186    ForStatement ::= for ( ForInitopt ; Expressionopt ; ForUpdateopt ) Statement
187    ForStatementNoShortIf ::= for ( ForInitopt ; Expressionopt ; ForUpdateopt ) StatementNoShortIf $Statement
188    ForInit ::= StatementExpressionList
189    ForInit ::= LocalVariableDeclaration
190    ForUpdate ::= StatementExpressionList
191    StatementExpressionList ::= StatementExpression
192    StatementExpressionList ::= StatementExpressionList , StatementExpression
193    BreakStatement ::= break IDENTIFIERopt ;
194    ContinueStatement ::= continue IDENTIFIERopt ;
195    ReturnStatement ::= return Expressionopt ;
196    ThrowStatement ::= throw Expression ;
197    SynchronizedStatement ::= synchronized ( Expression ) Block $Block
198    TryStatement ::= try Block $Block Catches $Catchesopt
199    TryStatement ::= try Block $Block Catchesopt Finally
200    Catches ::= CatchClause
201    Catches ::= Catches CatchClause
202    CatchClause ::= catch ( FormalParameter ) Block $Block
203    Finally ::= finally Block $Block
204    Primary ::= PrimaryNoNewArray
205    Primary ::= ArrayCreationExpression
206    PrimaryNoNewArray ::= Literal
207    PrimaryNoNewArray ::= this
208    PrimaryNoNewArray ::= ( Expression )
209    PrimaryNoNewArray ::= ClassInstanceCreationExpression
210    PrimaryNoNewArray ::= FieldAccess
211    PrimaryNoNewArray ::= Name . this
212    PrimaryNoNewArray ::= Type . class
213    PrimaryNoNewArray ::= void . class
214    PrimaryNoNewArray ::= MethodInvocation
215    PrimaryNoNewArray ::= ArrayAccess
216    ClassInstanceCreationExpression ::= new ClassType ( ArgumentListopt ) ClassBodyopt
217    ClassInstanceCreationExpression ::= Primary $expression . new SimpleName ( ArgumentListopt ) ClassBodyopt
218    ClassInstanceCreationExpression ::= Name $expression . new SimpleName ( ArgumentListopt ) ClassBodyopt
219    ArgumentList ::= Expression
220    ArgumentList ::= ArgumentList , Expression
221    ArrayCreationExpression ::= new PrimitiveType $Type DimExprs Dimsopt
222    ArrayCreationExpression ::= new ClassOrInterfaceType $Type DimExprs Dimsopt
223    ArrayCreationExpression ::= new ArrayType $Type ArrayInitializer
224    DimExprs ::= DimExpr
225    DimExprs ::= DimExprs DimExpr
226    DimExpr ::= [ Expression ]
227    Dims ::= [ ]
228    Dims ::= Dims [ ]
229    FieldAccess ::= Primary . IDENTIFIER
230    FieldAccess ::= super . IDENTIFIER
231    FieldAccess ::= Name . super . IDENTIFIER
232    MethodInvocation ::= Name ( ArgumentListopt )
233    MethodInvocation ::= Primary . IDENTIFIER ( ArgumentListopt )
234    MethodInvocation ::= super . IDENTIFIER ( ArgumentListopt )
235    MethodInvocation ::= Name . super . IDENTIFIER ( ArgumentListopt )
236    ArrayAccess ::= Name $Base [ Expression ]
237    ArrayAccess ::= PrimaryNoNewArray $Base [ Expression ]
238    PostfixExpression ::= Primary
239    PostfixExpression ::= Name
240    PostfixExpression ::= PostIncrementExpression
241    PostfixExpression ::= PostDecrementExpression
242    PostIncrementExpression ::= PostfixExpression ++
243    PostDecrementExpression ::= PostfixExpression '--'
244    UnaryExpression ::= PreIncrementExpression
245    UnaryExpression ::= PreDecrementExpression
246    UnaryExpression ::= + UnaryExpression
247    UnaryExpression ::= - UnaryExpression
248    UnaryExpression ::= UnaryExpressionNotPlusMinus
249    PreIncrementExpression ::= ++ UnaryExpression
250    PreDecrementExpression ::= '--' UnaryExpression
251    UnaryExpressionNotPlusMinus ::= PostfixExpression
252    UnaryExpressionNotPlusMinus ::= ~ UnaryExpression
253    UnaryExpressionNotPlusMinus ::= ! UnaryExpression
254    UnaryExpressionNotPlusMinus ::= CastExpression
255    CastExpression ::= ( PrimitiveType Dimsopt ) UnaryExpression
256    CastExpression ::= ( Expression $Nam ) UnaryExpressionNotPlusMinus
257    CastExpression ::= ( Name $Nam Dims ) UnaryExpressionNotPlusMinus
258    MultiplicativeExpression ::= UnaryExpression
259    MultiplicativeExpression ::= MultiplicativeExpression * UnaryExpression
260    MultiplicativeExpression ::= MultiplicativeExpression / UnaryExpression
261    MultiplicativeExpression ::= MultiplicativeExpression % UnaryExpression
262    AdditiveExpression ::= MultiplicativeExpression
263    AdditiveExpression ::= AdditiveExpression + MultiplicativeExpression
264    AdditiveExpression ::= AdditiveExpression - MultiplicativeExpression
265    ShiftExpression ::= AdditiveExpression
266    ShiftExpression ::= ShiftExpression << AdditiveExpression
267    ShiftExpression ::= ShiftExpression >> AdditiveExpression
268    ShiftExpression ::= ShiftExpression >>> AdditiveExpression
269    RelationalExpression ::= ShiftExpression
270    RelationalExpression ::= RelationalExpression < ShiftExpression
271    RelationalExpression ::= RelationalExpression > ShiftExpression
272    RelationalExpression ::= RelationalExpression <= ShiftExpression
273    RelationalExpression ::= RelationalExpression >= ShiftExpression
274    RelationalExpression ::= RelationalExpression instanceof ReferenceType
275    EqualityExpression ::= RelationalExpression
276    EqualityExpression ::= EqualityExpression == RelationalExpression
277    EqualityExpression ::= EqualityExpression != RelationalExpression
278    AndExpression ::= EqualityExpression
279    AndExpression ::= AndExpression & EqualityExpression
280    ExclusiveOrExpression ::= AndExpression
281    ExclusiveOrExpression ::= ExclusiveOrExpression ^ AndExpression
282    InclusiveOrExpression ::= ExclusiveOrExpression
283    InclusiveOrExpression ::= InclusiveOrExpression '|' ExclusiveOrExpression
284    ConditionalAndExpression ::= InclusiveOrExpression
285    ConditionalAndExpression ::= ConditionalAndExpression && InclusiveOrExpression
286    ConditionalOrExpression ::= ConditionalAndExpression
287    ConditionalOrExpression ::= ConditionalOrExpression || ConditionalAndExpression
288    ConditionalExpression ::= ConditionalOrExpression
289    ConditionalExpression ::= ConditionalOrExpression ? Expression : ConditionalExpression
290    AssignmentExpression ::= ConditionalExpression
291    AssignmentExpression ::= Assignment
292    Assignment ::= LeftHandSide AssignmentOperator AssignmentExpression
293    LeftHandSide ::= Name
294    LeftHandSide ::= FieldAccess
295    LeftHandSide ::= ArrayAccess
296    AssignmentOperator ::= =
297    AssignmentOperator ::= *=
298    AssignmentOperator ::= /=
299    AssignmentOperator ::= %=
300    AssignmentOperator ::= +=
301    AssignmentOperator ::= -=
302    AssignmentOperator ::= <<=
303    AssignmentOperator ::= >>=
304    AssignmentOperator ::= >>>=
305    AssignmentOperator ::= &=
306    AssignmentOperator ::= ^=
307    AssignmentOperator ::= |=
308    Expression ::= AssignmentExpression
309    ConstantExpression ::= Expression
310    PackageDeclarationopt ::= $Empty
311    PackageDeclarationopt ::= PackageDeclaration
312    Superopt ::= $Empty
313    Superopt ::= Super
314    Expressionopt ::= $Empty
315    Expressionopt ::= Expression
316    ClassBodyopt ::= $Empty
317    ClassBodyopt ::= ClassBody
318    ImportDeclarationsopt ::= $Empty
319    ImportDeclarationsopt ::= ImportDeclarations
320    TypeDeclarationsopt ::= $Empty
321    TypeDeclarationsopt ::= TypeDeclarations
322    ClassBodyDeclarationsopt ::= $Empty
323    ClassBodyDeclarationsopt ::= ClassBodyDeclarations
324    Modifiersopt ::= $Empty
325    Modifiersopt ::= Modifiers
326    BlockStatementsopt ::= $Empty
327    BlockStatementsopt ::= BlockStatements
328    Dimsopt ::= $Empty
329    Dimsopt ::= Dims
330    ArgumentListopt ::= $Empty
331    ArgumentListopt ::= ArgumentList
332    Throwsopt ::= $Empty
333    Throwsopt ::= Throws
334    FormalParameterListopt ::= $Empty
335    FormalParameterListopt ::= FormalParameterList
336    Interfacesopt ::= $Empty
337    Interfacesopt ::= Interfaces
338    InterfaceMemberDeclarationsopt ::= $Empty
339    InterfaceMemberDeclarationsopt ::= InterfaceMemberDeclarations
340    ForInitopt ::= $Empty
341    ForInitopt ::= ForInit
342    ForUpdateopt ::= $Empty
343    ForUpdateopt ::= ForUpdate
344    ExtendsInterfacesopt ::= $Empty
345    ExtendsInterfacesopt ::= ExtendsInterfaces
346    Catchesopt ::= $Empty
347    Catchesopt ::= Catches
348    Commaopt ::= $Empty
349    Commaopt ::= ,
350    IDENTIFIERopt ::= $Empty
351    IDENTIFIERopt ::= IDENTIFIER


Types:

    Statement ::= StatementNoShortIf
                | StatementWithoutTrailingSubstatement
    LabeledStatement ::= LabeledStatementNoShortIf
    IfThenElseStatement ::= IfThenElseStatementNoShortIf
    WhileStatement ::= WhileStatementNoShortIf
    ForStatement ::= ForStatementNoShortIf

*** The following Terminals are useless: 
        const  goto  SlComment  MlComment  DocComment  


 IBM Research Jikes Parser Generator    3.05 (Jan  5 2006)


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
SlComment ::= SlComment
MlComment ::= MlComment
DocComment ::= DocComment
EOF_TOKEN ::= EOF_TOKEN
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
SwitchStatement ::= 
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
IDENTIFIERopt ::= 
Catchesopt ::= 
ArrayCreationExpression ::= 
ClassBodyopt ::= 
CastExpression ::= 

 IBM Research Jikes Parser Generator    3.05 (Jan  5 2006)


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
ForStatementNoShortIf ::= for LPAREN ForInitopt  .SEMICOLON SEMICOLON RPAREN 
                          StatementNoShortIf 
ForStatement ::= for LPAREN ForInitopt  .SEMICOLON SEMICOLON RPAREN Statement 
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
ExplicitConstructorInvocation ::= Primary  .DOT super LPAREN RPAREN SEMICOLON 
ExplicitConstructorInvocation ::= Primary  .DOT this LPAREN RPAREN SEMICOLON 


C:\lpgjavaruntime\examples\javaexample\src\javaparser\JavaParser1.g is LALR(2).


Number of Terminals: 109
Number of Nonterminals: 156
Number of Productions: 352
Number of Items: 1036
Number of Scopes: 57
Number of States: 333
Number of look-ahead states: 5
Number of Shift actions: 1272
Number of Goto actions: 1463
Number of Shift/Reduce actions: 2100
Number of Goto/Reduce actions: 2419
Number of Reduce actions: 1560
Number of Shift-Reduce conflicts: 0
Number of Reduce-Reduce conflicts: 0

Number of entries in base Action Table: 4215
Additional space required for compaction of Action Table: 17.2%

Number of unique terminal states: 241
Number of Shift actions saved by merging: 2195
Number of Conflict points saved by merging: 0
Number of Reduce actions saved by merging: 117
Number of Reduce saved by default: 1366

Number of entries in Terminal Action Table: 1500
Additional space required for compaction of Terminal Table: 4.8%

Actions in Compressed Tables:
     Number of Shifts: 490
     Number of Shift/Reduces: 687
     Number of Look-Ahead Shifts: 5
     Number of Gotos: 1463
     Number of Goto/Reduces: 2419
     Number of Reduces: 77
     Number of Defaults: 108

Parsing Tables storage:
    Storage required for BASE_CHECK: 10586 Bytes
    Storage required for BASE_ACTION: 10588 Bytes
    Storage required for TERM_CHECK: 1624 Bytes
    Storage required for TERM_ACTION: 3148 Bytes

Error maps storage:
    Storage required for ACTION_SYMBOLS_BASE map: 668 Bytes
    Storage required for ACTION_SYMBOLS_RANGE map: 653 Bytes
    Storage required for NACTION_SYMBOLS_BASE map: 668 Bytes
    Storage required for NACTION_SYMBOLS_RANGE map: 344 Bytes
    Storage required for TERMINAL_INDEX map: 220 Bytes
    Storage required for NON_TERMINAL_INDEX map: 316 Bytes

    Storage required for SCOPE_PREFIX map: 114 Bytes
    Storage required for SCOPE_SUFFIX map: 114 Bytes
    Storage required for SCOPE_LHS_SYMBOL map: 114 Bytes
    Storage required for SCOPE_LOOK_AHEAD map: 57 Bytes
    Storage required for SCOPE_STATE_SET map: 114 Bytes
    Storage required for SCOPE_RIGHT_SIDE map: 582 Bytes
    Storage required for SCOPE_STATE map: 418 Bytes
    Storage required for IN_SYMB map: 668 Bytes

    Number of names: 197
    Number of characters in name: 1877
