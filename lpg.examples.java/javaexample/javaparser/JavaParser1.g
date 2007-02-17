%options escape=$,list,var,automatic_ast,visitor
%options la=2
%options table=java
%options fp=JavaParser,prefix=TK_
%options error-maps
%options scopes
%options package=javaparser
%options template=dtParserTemplateB.g
%options import_terminals=JavaLexer.g

------------------------------------------------------------------------
--
--                               J A V A
--
-- This Java grammar is almost identical (except where noted) to the grammar
-- defined in chapter 19 of the Java Language Specification manual together
-- with the additional rules found in the 1.1 document. It is written here
-- in JIKES PG format. In specifying the rules we enclosed all terminal
-- symbols in single quotes so that they can be quickly distinguished from
-- non-terminals. Optional symbols are suffixed with a question mark (?)
-- and the rules expanding such definitions can be found at the end.
--
------------------------------------------------------------------------

$Define
    --
    -- Definition of macros used in the parser template
    --
    $package_declaration /.package $package;./
    $import_classes /../
    $prs_stream_class /.PrsStream./
    $action_class /.$file_prefix./
    $ast_class /.Ast./
$End

$Alias
    <SwitchStatement> ::= SwitchStatement
$End
    
$Terminals
    IDENTIFIER

    abstract boolean break byte case catch char class const
    continue default do double else extends false final finally float
    for goto if implements import instanceof int
    interface long native new null package private
    protected public return short static strictfp super switch
    synchronized this throw throws transient true try void
    volatile while

    IntegerLiteral        -- the usual
    LongLiteral           -- IntegerLiteral followed by 'l' or 'L'
    FloatingPointLiteral  --
                          -- FloatingPointLiteral ::= Digits . Digits? ExponentPart? FloatingTypeSuffix?
                          --                        | . Digits ExponentPart? FloatingTypeSuffix?
                          --                        | Digits ExponentPart FloatingTypeSuffix?
                          --                        | Digits ExponentPart? FloatingTypeSuffix
                          --
                          -- ExponentPart ::= ('e'|'E') ('+'|'-')? Digits
                          -- FloatingTypeSuffix ::= 'f' |  'F'
                          --
    DoubleLiteral         -- See FloatingPointLiteral except that
                          -- FloatingTypeSuffix ::= 'd' | 'D'
                          --
    CharacterLiteral      -- the usual
    StringLiteral         -- the usual

    PLUS_PLUS                  ::= '++'
    MINUS_MINUS                ::= '--'
    EQUAL_EQUAL                ::= '=='
    LESS_EQUAL                 ::= '<='
    GREATER_EQUAL              ::= '>='
    NOT_EQUAL                  ::= '!='
    LEFT_SHIFT                 ::= '<<'
    RIGHT_SHIFT                ::= '>>'
    UNSIGNED_RIGHT_SHIFT       ::= '>>>'
    PLUS_EQUAL                 ::= '+='
    MINUS_EQUAL                ::= '-='
    MULTIPLY_EQUAL             ::= '*='
    DIVIDE_EQUAL               ::= '/='
    AND_EQUAL                  ::= '&='
    OR_EQUAL                   ::= '|='
    XOR_EQUAL                  ::= '^='
    REMAINDER_EQUAL            ::= '%='
    LEFT_SHIFT_EQUAL           ::= '<<='
    RIGHT_SHIFT_EQUAL          ::= '>>='
    UNSIGNED_RIGHT_SHIFT_EQUAL ::= '>>>='
    OR_OR                      ::= '||'
    AND_AND                    ::= '&&'

    PLUS      ::= '+'
    MINUS     ::= '-'
    NOT       ::= '!'
    REMAINDER ::= '%'
    XOR       ::= '^'
    AND       ::= '&'
    MULTIPLY  ::= '*'
    OR        ::= '|'
    TWIDDLE   ::= '~'
    DIVIDE    ::= '/'
    GREATER   ::= '>'
    LESS      ::= '<'
    LPAREN    ::= '('
    RPAREN    ::= ')'
    LBRACE    ::= '{'
    RBRACE    ::= '}'
    LBRACKET  ::= '['
    RBRACKET  ::= ']'
    SEMICOLON ::= ';'
    QUESTION  ::= '?'
    COLON     ::= ':'
    COMMA     ::= ','
    DOT       ::= '.'
    EQUAL     ::= '='
$End

$EOF
    EOF_TOKEN
$End

$ERROR
    ERROR_TOKEN
$End

$EOL
    ;
$End

$Start
    CompilationUnit
$End

$Rules

    --18.3 Productions from 3: Lexical Structure
    --
    -- Expand the definition IntegerLiteral and BooleanLiteral
    --

    Literal$IntegerLiteral ::= IntegerLiteral

    Literal$LongLiteral ::= LongLiteral

    Literal$FloatLiteral ::= FloatingPointLiteral

    Literal$DoubleLiteral ::= DoubleLiteral

    Literal ::= BooleanLiteral

    Literal$CharacterLiteral ::= CharacterLiteral

    Literal$StringLiteral ::= StringLiteral

    Literal$NullLiteral ::= null$null_literal

    BooleanLiteral$TrueLiteral ::= true

	BooleanLiteral$FalseLiteral ::= false

    --18.4 Productions from 4: Types, Values and Variables

    Type ::= PrimitiveType

    Type ::= ReferenceType

    PrimitiveType ::= NumericType

    PrimitiveType$BooleanType ::= 'boolean'

    NumericType ::= IntegralType

    NumericType ::= FloatingPointType

    IntegralType$ByteType ::= 'byte'

    IntegralType$ShortType ::= 'short'

    IntegralType$IntType ::= 'int'

    IntegralType$LongType ::= 'long'

    IntegralType$CharType ::= 'char'

    FloatingPointType$FloatType ::= 'float'

    FloatingPointType$DoubleType ::= 'double'

    ReferenceType ::= ClassOrInterfaceType

    ReferenceType ::= ArrayType

    ClassOrInterfaceType ::= Name

    --
    -- These rules have been rewritten to avoid some conflicts introduced
    -- by adding the 1.1 features
    --
    -- ArrayType ::= PrimitiveType '[' ']'
    -- ArrayType ::= Name '[' ']'
    -- ArrayType ::= ArrayType '[' ']'
    --
    ArrayType$PrimitiveArrayType ::= PrimitiveType Dims

    ArrayType$ClassOrInterfaceArrayType ::= Name Dims

    ClassType ::= ClassOrInterfaceType

    InterfaceType ::= ClassOrInterfaceType

    --18.5 Productions from 6: Names

    Name ::= SimpleName

    Name ::= QualifiedName

    SimpleName ::= 'IDENTIFIER'

    QualifiedName ::= Name '.' 'IDENTIFIER'

    --18.6 Productions from 7: Packages

    CompilationUnit ::= PackageDeclarationopt ImportDeclarationsopt TypeDeclarationsopt

    ImportDeclarations ::= ImportDeclaration

    ImportDeclarations ::= ImportDeclarations ImportDeclaration

    TypeDeclarations ::= TypeDeclaration

    TypeDeclarations ::= TypeDeclarations TypeDeclaration

    PackageDeclaration ::= 'package' Name ';'

    ImportDeclaration ::= SingleTypeImportDeclaration

    ImportDeclaration ::= TypeImportOnDemandDeclaration

    SingleTypeImportDeclaration ::= 'import' Name ';'

    TypeImportOnDemandDeclaration ::= 'import' Name '.' '*' ';'

    TypeDeclaration ::= ClassDeclaration

    TypeDeclaration ::= InterfaceDeclaration

    TypeDeclaration$EmptyDeclaration ::= ';'

    --18.7 Only in the LALR(1) Grammar

    Modifiers ::= Modifier

    Modifiers ::= Modifiers Modifier

    Modifier$PublicModifier ::= 'public'

    Modifier$ProtectedModifier ::= 'protected'

    Modifier$PrivateModifier ::= 'private'

    Modifier$StaticModifier ::= 'static'

    Modifier$AbstractModifier ::= 'abstract'

    Modifier$FinalModifier ::= 'final'

    Modifier$NativeModifier ::= 'native'

    Modifier$StrictfpModifier ::= 'strictfp'

    Modifier$SynchronizedModifier ::= 'synchronized'

    Modifier$TransientModifier ::= 'transient'

    Modifier$VolatileModifier ::= 'volatile'

    --18.8 Productions from 8: Class Declarations
    --ClassModifier ::=
    --      'abstract'
    --    | 'final'
    --    | 'public'
    --18.8.1 Productions from 8.1: Class Declarations

    ClassDeclaration ::= Modifiersopt 'class' 'IDENTIFIER' Superopt Interfacesopt ClassBody

    Super ::= 'extends' ClassType

    Interfaces ::= 'implements' InterfaceTypeList

    InterfaceTypeList ::= InterfaceType

    InterfaceTypeList ::= InterfaceTypeList ',' InterfaceType

    ClassBody ::= '{' ClassBodyDeclarationsopt '}'

    ClassBodyDeclarations ::= ClassBodyDeclaration

    ClassBodyDeclarations ::= ClassBodyDeclarations ClassBodyDeclaration

    ClassBodyDeclaration ::= ClassMemberDeclaration

    ClassBodyDeclaration ::= StaticInitializer

    ClassBodyDeclaration ::= ConstructorDeclaration

    --1.1 feature
    ClassBodyDeclaration ::= Block

    ClassMemberDeclaration ::= FieldDeclaration

    ClassMemberDeclaration ::= MethodDeclaration

    --1.1 feature
    ClassMemberDeclaration ::= ClassDeclaration

    --1.1 feature
    ClassMemberDeclaration ::= InterfaceDeclaration

    --
    -- Empty declarations are not valid Java ClassMemberDeclarations.
    -- However, since the current (2/14/97) Java compiler accepts them
    -- (in fact, some of the official tests contain this erroneous
    -- syntax), we decided to accept them as valid syntax and flag them
    -- as a warning during semantic processing.
    --
    ClassMemberDeclaration$EmptyDeclaration ::= ';'

    --18.8.2 Productions from 8.3: Field Declarations
    --VariableModifier ::=
    --      'public'
    --    | 'protected'
    --    | 'private'
    --    | 'static'
    --    | 'final'
    --    | 'transient'
    --    | 'volatile'

    FieldDeclaration ::= Modifiersopt Type VariableDeclarators ';'

    VariableDeclarators ::= VariableDeclarator

    VariableDeclarators ::= VariableDeclarators ',' VariableDeclarator

    VariableDeclarator ::= VariableDeclaratorId

    VariableDeclarator ::= VariableDeclaratorId '=' VariableInitializer

    VariableDeclaratorId ::= 'IDENTIFIER' Dimsopt

    VariableInitializer ::= Expression

    VariableInitializer ::= ArrayInitializer

    --18.8.3 Productions from 8.4: Method Declarations
    --MethodModifier ::=
    --      'public'
    --    | 'protected'
    --    | 'private'
    --    | 'static'
    --    | 'abstract'
    --    | 'final'
    --    | 'native'
    --    | 'synchronized'
    --

    MethodDeclaration ::= MethodHeader MethodBody

    MethodHeader$TypedMethodHeader ::= Modifiersopt Type MethodDeclarator Throwsopt

    MethodHeader$VoidMethodHeader ::= Modifiersopt 'void' MethodDeclarator Throwsopt

    MethodDeclarator ::= 'IDENTIFIER' '(' FormalParameterListopt ')' Dimsopt

    FormalParameterList ::= FormalParameter

    FormalParameterList ::= FormalParameterList ',' FormalParameter

    FormalParameter$FormalParameter ::= Type VariableDeclaratorId

    --1.1 feature
    FormalParameter$FormalParameter ::= Modifiers Type VariableDeclaratorId

    Throws ::= 'throws' ClassTypeList

    ClassTypeList ::= ClassType

    ClassTypeList ::= ClassTypeList ',' ClassType

    MethodBody ::= Block

    MethodBody$EmptyMethodBody ::= ';'

    --18.8.4 Productions from 8.5: Static Initializers

    StaticInitializer ::= 'static' Block$Block

    --18.8.5 Productions from 8.6: Constructor Declarations
    --ConstructorModifier ::=
    --      'public'
    --    | 'protected'
    --    | 'private'
    --
    --

    ConstructorDeclaration ::= Modifiersopt ConstructorDeclarator Throwsopt ConstructorBody

    --
    -- The original rule specifies SimpleName but it appears to be an
    -- error as the rule for a method declarator uses an IDENTIFIER.
    --...Until further notice, ...
    --
    -- ConstructorDeclarator ::= SimpleName '(' FormalParameterListopt ')'
    --

    ConstructorDeclarator ::= 'IDENTIFIER' '(' FormalParameterListopt ')'

    --
    -- NOTE that the rules ExplicitConstructorInvocationopt has been expanded
    -- in the rule below in order to make the grammar lalr(1).
    --
    -- ConstructorBody ::= '{' ExplicitConstructorInvocationopt BlockStatementsopt '}'
    --
    ConstructorBody ::= Block

    ConstructorBody ::= '{' ExplicitConstructorInvocation BlockStatementsopt '}'

    ExplicitConstructorInvocation$ThisCall ::= 'this' '(' ArgumentListopt ')' ';'

    ExplicitConstructorInvocation$SuperCall ::= 'super' '(' ArgumentListopt ')' ';'

    --1.2 feature
    ExplicitConstructorInvocation$ThisCall ::= Primary '.' 'this' '(' ArgumentListopt ')' ';'

    --1.1 feature
    ExplicitConstructorInvocation$SuperCall ::= Primary$expression '.' 'super' '(' ArgumentListopt ')' ';'

    --1.1 feature
    ExplicitConstructorInvocation$SuperCall ::= Name$expression '.' 'super' '(' ArgumentListopt ')' ';'

    --18.9 Productions from 9: Interface Declarations

    --18.9.1 Productions from 9.1: Interface Declarations
    --InterfaceModifier ::=
    --      'public'
    --    | 'abstract'
    --
    InterfaceDeclaration ::= Modifiersopt 'interface' 'IDENTIFIER' ExtendsInterfacesopt InterfaceBody

    ExtendsInterfaces ::= 'extends' InterfaceTypeList

    InterfaceBody ::= '{' InterfaceMemberDeclarationsopt '}'

    InterfaceMemberDeclarations ::= InterfaceMemberDeclaration

    InterfaceMemberDeclarations ::= InterfaceMemberDeclarations InterfaceMemberDeclaration

    InterfaceMemberDeclaration ::= ConstantDeclaration

    InterfaceMemberDeclaration ::= AbstractMethodDeclaration

    --1.1 feature
    InterfaceMemberDeclaration ::= ClassDeclaration

    --1.1 feature
    InterfaceMemberDeclaration ::= InterfaceDeclaration

    --
    -- Empty declarations are not valid Java InterfaceMemberDeclarations.
    -- However, since the current (2/14/97) Java compiler accepts them
    -- (in fact, some of the official tests contain this erroneous
    -- syntax), we decided to accept them as valid syntax and flag them
    -- as a warning during semantic processing.
    --
    InterfaceMemberDeclaration$EmptyDeclaration ::= ';'

    ConstantDeclaration ::= FieldDeclaration

    AbstractMethodDeclaration ::= MethodHeader ';'

    --18.10 Productions from 10: Arrays

    --
    -- NOTE that the rules VariableInitializersopt and ,opt have been expanded,
    -- where appropriate, in the rule below in order to make the grammar lalr(1).
    --
    -- ArrayInitializer ::= '{' VariableInitializersopt Commaopt '}'
    --
    ArrayInitializer$ArrayInitializer ::= '{' Commaopt '}'

    ArrayInitializer$ArrayInitializer ::= '{' VariableInitializers '}'

    ArrayInitializer$ArrayInitializer ::= '{' VariableInitializers , '}'

    VariableInitializers ::= VariableInitializer

    VariableInitializers ::= VariableInitializers ',' VariableInitializer

    --18.11 Productions from 13: Blocks and Statements

    Block$Block ::= '{' BlockStatementsopt '}'

    BlockStatements ::= BlockStatement

    BlockStatements ::= BlockStatements BlockStatement

    BlockStatement ::= LocalVariableDeclarationStatement

    BlockStatement ::= Statement

    --1.1 feature
    BlockStatement ::= ClassDeclaration

    LocalVariableDeclarationStatement ::= LocalVariableDeclaration ';'

    LocalVariableDeclaration$LocalVariableDeclaration ::= Type VariableDeclarators

    --1.1 feature
    LocalVariableDeclaration$LocalVariableDeclaration ::= Modifiers Type VariableDeclarators

    Statement ::= StatementWithoutTrailingSubstatement

    Statement ::= LabeledStatement

    Statement ::= IfThenStatement

    Statement ::= IfThenElseStatement

    Statement ::= WhileStatement

    Statement ::= ForStatement

    StatementNoShortIf ::= StatementWithoutTrailingSubstatement

    StatementNoShortIf ::= LabeledStatementNoShortIf

    StatementNoShortIf ::= IfThenElseStatementNoShortIf

    StatementNoShortIf ::= WhileStatementNoShortIf

    StatementNoShortIf ::= ForStatementNoShortIf

    StatementWithoutTrailingSubstatement ::= Block

    StatementWithoutTrailingSubstatement ::= EmptyStatement

    StatementWithoutTrailingSubstatement ::= ExpressionStatement

    StatementWithoutTrailingSubstatement ::= SwitchStatement

    StatementWithoutTrailingSubstatement ::= DoStatement

    StatementWithoutTrailingSubstatement ::= BreakStatement

    StatementWithoutTrailingSubstatement ::= ContinueStatement

    StatementWithoutTrailingSubstatement ::= ReturnStatement

    StatementWithoutTrailingSubstatement ::= SynchronizedStatement

    StatementWithoutTrailingSubstatement ::= ThrowStatement

    StatementWithoutTrailingSubstatement ::= TryStatement

    EmptyStatement ::= ';'

    LabeledStatement$LabeledStatement ::= 'IDENTIFIER' ':' Statement

    LabeledStatementNoShortIf$LabeledStatement ::= 'IDENTIFIER' ':' StatementNoShortIf$Statement

    ExpressionStatement ::= StatementExpression ';'

    StatementExpression ::= Assignment

    StatementExpression ::= PreIncrementExpression

    StatementExpression ::= PreDecrementExpression

    StatementExpression ::= PostIncrementExpression

    StatementExpression ::= PostDecrementExpression

    StatementExpression ::= MethodInvocation

    StatementExpression ::= ClassInstanceCreationExpression

    IfThenStatement$IfStatement ::=  'if' '(' Expression ')' Statement$thenStmt

    IfThenElseStatement$IfStatement ::=  'if' '(' Expression ')' StatementNoShortIf$thenStmt 'else' Statement$elseStmt

    IfThenElseStatementNoShortIf$IfStatement ::=  'if' '(' Expression ')' StatementNoShortIf$thenStmt 'else' StatementNoShortIf$elseStmt

    <SwitchStatement> ::= 'switch' '(' Expression ')' SwitchBlock

    SwitchBlock$SwitchBlock ::= '{' '}'

    SwitchBlock$SwitchBlock ::= '{' SwitchBlockStatements '}'

    SwitchBlock$SwitchBlock ::= '{' SwitchLabels '}'

    SwitchBlock$SwitchBlock ::= '{' SwitchBlockStatements SwitchLabels '}'

    SwitchBlockStatements ::= SwitchBlockStatement

    SwitchBlockStatements ::= SwitchBlockStatements SwitchBlockStatement

    SwitchBlockStatement ::= SwitchLabels BlockStatements

    SwitchLabels ::= SwitchLabel

    SwitchLabels ::= SwitchLabels SwitchLabel

    SwitchLabel$CaseLabel ::= 'case' ConstantExpression ':'

    SwitchLabel$DefaultLabel ::= 'default' ':'

    WhileStatement$WhileStatement ::= 'while' '(' Expression ')' Statement

    WhileStatementNoShortIf$WhileStatement ::= 'while' '(' Expression ')' StatementNoShortIf$Statement

    DoStatement ::= 'do' Statement 'while' '(' Expression ')' ';'

    ForStatement$ForStatement ::= 'for' '(' ForInitopt ';' Expressionopt ';' ForUpdateopt ')' Statement

    ForStatementNoShortIf$ForStatement ::= 'for' '(' ForInitopt ';' Expressionopt ';' ForUpdateopt ')' StatementNoShortIf$Statement

    ForInit ::= StatementExpressionList

    ForInit ::= LocalVariableDeclaration

    ForUpdate ::= StatementExpressionList

    StatementExpressionList ::= StatementExpression

    StatementExpressionList ::= StatementExpressionList ',' StatementExpression

    --
    -- NOTE that the rule Identifieropt was expanded in line in the two
    -- contexts where it appeared: Break and Continue statements.
    -- This was done because there is no straightforward way of passing
    -- optional token information in the parse stack.
    --
    BreakStatement ::= 'break' IDENTIFIERopt ';'

    ContinueStatement ::= 'continue' IDENTIFIERopt ';'

    ReturnStatement ::= 'return' Expressionopt ';'

    ThrowStatement ::= 'throw' Expression ';'

    SynchronizedStatement ::= 'synchronized' '(' Expression ')' Block$Block

    TryStatement$TryStatement ::= 'try' Block$Block Catches$Catchesopt

    TryStatement$TryStatement ::= 'try' Block$Block Catchesopt Finally

    Catches ::= CatchClause

    Catches ::= Catches CatchClause

    CatchClause ::= 'catch' '(' FormalParameter ')' Block$Block

    Finally ::= 'finally' Block$Block

    --18.12 Productions from 14: Expressions

    Primary ::= PrimaryNoNewArray

    Primary ::= ArrayCreationExpression

    PrimaryNoNewArray ::= Literal

    PrimaryNoNewArray$PrimaryThis ::= this

    PrimaryNoNewArray$ParenthesizedExpression ::= '(' Expression ')'

    PrimaryNoNewArray ::= ClassInstanceCreationExpression

    PrimaryNoNewArray ::= FieldAccess

    --1.1 feature
    PrimaryNoNewArray$PrimaryThis ::= Name '.' 'this'

    --1.1 feature
    PrimaryNoNewArray$PrimaryClassLiteral ::= Type '.' 'class'

    --1.1 feature
    PrimaryNoNewArray$PrimaryVoidClassLiteral ::= 'void' '.' 'class'

    PrimaryNoNewArray ::= MethodInvocation

    PrimaryNoNewArray ::= ArrayAccess

    --1.1 feature
    --
    -- In Java 1.0 a ClassBody could not appear at all in a
    -- ClassInstanceCreationExpression.
    --
    ClassInstanceCreationExpression$ClassInstanceCreationExpression ::= 'new' ClassType '(' ArgumentListopt ')' ClassBodyopt

    --1.1 feature
    ClassInstanceCreationExpression$ClassInstanceCreationExpression ::= Primary$expression '.' 'new' SimpleName '(' ArgumentListopt ')' ClassBodyopt

    --1.1 feature
    ClassInstanceCreationExpression$ClassInstanceCreationExpression ::= Name$expression '.' 'new' SimpleName '(' ArgumentListopt ')' ClassBodyopt

    ArgumentList ::= Expression

    ArgumentList ::= ArgumentList ',' Expression

    ArrayCreationExpression$ArrayCreationExpression ::= 'new' PrimitiveType$Type DimExprs Dimsopt

    ArrayCreationExpression$ArrayCreationExpression ::= 'new' ClassOrInterfaceType$Type DimExprs Dimsopt

    --1.1 feature
    ArrayCreationExpression$ArrayCreationExpression ::= 'new' ArrayType$Type ArrayInitializer

    DimExprs ::= DimExpr

    DimExprs ::= DimExprs DimExpr

    DimExpr ::= '[' Expression ']'

    Dims$Dims ::= '[' ']'

    Dims$Dims ::= Dims '[' ']'

    FieldAccess$FieldAccess ::= Primary '.' 'IDENTIFIER'

    FieldAccess$SuperFieldAccess ::= 'super' '.' 'IDENTIFIER'

    --1.2 feature
    FieldAccess$SuperFieldAccess ::= Name '.' 'super' '.' 'IDENTIFIER'

    MethodInvocation$MethodInvocation ::= Name '(' ArgumentListopt ')'

    MethodInvocation$PrimaryMethodInvocation ::= Primary '.' 'IDENTIFIER' '(' ArgumentListopt ')'

    MethodInvocation$SuperMethodInvocation ::= 'super' '.' 'IDENTIFIER' '(' ArgumentListopt ')'

    --1.2 feature
    MethodInvocation$SuperMethodInvocation ::= Name '.' 'super' '.' 'IDENTIFIER' '(' ArgumentListopt ')'

    ArrayAccess$ArrayAccess ::= Name$Base '[' Expression ']'

    ArrayAccess$ArrayAccess ::= PrimaryNoNewArray$Base '[' Expression ']'

    PostfixExpression ::= Primary

    PostfixExpression ::= Name

    PostfixExpression ::= PostIncrementExpression

    PostfixExpression ::= PostDecrementExpression

    PostIncrementExpression ::= PostfixExpression '++'

    PostDecrementExpression ::= PostfixExpression '--'

    UnaryExpression ::= PreIncrementExpression

    UnaryExpression ::= PreDecrementExpression

    UnaryExpression$PlusUnaryExpression ::= '+' UnaryExpression

    UnaryExpression$MinusUnaryExpression ::= '-' UnaryExpression

    UnaryExpression ::= UnaryExpressionNotPlusMinus

    PreIncrementExpression ::= '++' UnaryExpression

    PreDecrementExpression ::= '--' UnaryExpression

    UnaryExpressionNotPlusMinus ::= PostfixExpression

    UnaryExpressionNotPlusMinus ::= '~' UnaryExpression

    UnaryExpressionNotPlusMinus ::= '!' UnaryExpression

    UnaryExpressionNotPlusMinus ::= CastExpression

    CastExpression$PrimitiveCastExpression ::= '(' PrimitiveType Dimsopt ')' UnaryExpression

    --
    -- Make sure that the Expression is syntactically a name.
    -- It was specified here as an Expression to avoid conflicts.
    --
    CastExpression$ClassCastExpression ::= '(' Expression$Nam ')' UnaryExpressionNotPlusMinus

    CastExpression$ClassCastExpression ::= '(' Name$Nam Dims ')' UnaryExpressionNotPlusMinus

    MultiplicativeExpression ::= UnaryExpression

    MultiplicativeExpression$MultiplyExpression ::= MultiplicativeExpression '*' UnaryExpression

    MultiplicativeExpression$DivideExpression ::= MultiplicativeExpression '/' UnaryExpression

    MultiplicativeExpression$ModExpression ::= MultiplicativeExpression '%' UnaryExpression

    AdditiveExpression ::= MultiplicativeExpression

    AdditiveExpression$AddExpression ::= AdditiveExpression '+' MultiplicativeExpression

    AdditiveExpression$SubtractExpression ::= AdditiveExpression '-' MultiplicativeExpression

    ShiftExpression ::= AdditiveExpression

    ShiftExpression$LeftShiftExpression ::= ShiftExpression '<<'  AdditiveExpression

    ShiftExpression$RightShiftExpression ::= ShiftExpression '>>'  AdditiveExpression

    ShiftExpression$UnsignedRightShiftExpression ::= ShiftExpression '>>>' AdditiveExpression

    RelationalExpression ::= ShiftExpression

    RelationalExpression$LessExpression ::= RelationalExpression '<'  ShiftExpression

    RelationalExpression$GreaterExpression ::= RelationalExpression '>'  ShiftExpression

    RelationalExpression$LessEqualExpression ::= RelationalExpression '<=' ShiftExpression

    RelationalExpression$GreaterEqualExpression ::= RelationalExpression '>=' ShiftExpression

    RelationalExpression$InstanceofExpression ::= RelationalExpression 'instanceof' ReferenceType

    EqualityExpression ::= RelationalExpression

    EqualityExpression$EqualExpression ::= EqualityExpression '==' RelationalExpression

    EqualityExpression$NotEqualExpression ::= EqualityExpression '!=' RelationalExpression


    AndExpression ::= EqualityExpression

    AndExpression ::= AndExpression '&' EqualityExpression

    ExclusiveOrExpression ::= AndExpression

    ExclusiveOrExpression ::= ExclusiveOrExpression '^' AndExpression

    InclusiveOrExpression ::= ExclusiveOrExpression

    InclusiveOrExpression ::= InclusiveOrExpression '|' ExclusiveOrExpression

    ConditionalAndExpression ::= InclusiveOrExpression

    ConditionalAndExpression ::= ConditionalAndExpression '&&' InclusiveOrExpression

    ConditionalOrExpression ::= ConditionalAndExpression

    ConditionalOrExpression ::= ConditionalOrExpression '||' ConditionalAndExpression

    ConditionalExpression ::= ConditionalOrExpression

    ConditionalExpression ::= ConditionalOrExpression '?' Expression ':' ConditionalExpression

    AssignmentExpression ::= ConditionalExpression

    AssignmentExpression ::= Assignment

    Assignment ::= LeftHandSide AssignmentOperator AssignmentExpression

    LeftHandSide ::= Name

    LeftHandSide ::= FieldAccess

    LeftHandSide ::= ArrayAccess

    AssignmentOperator$EqualOperator ::= '='

    AssignmentOperator$MultiplyEqualOperator ::= '*='

    AssignmentOperator$DivideEqualOperator ::= '/='

    AssignmentOperator$ModEqualOperator ::= '%='

    AssignmentOperator$PlusEqualOperator ::= '+='

    AssignmentOperator$MinusEqualOperator ::= '-='

    AssignmentOperator$LeftShiftEqualOperator ::= '<<='

    AssignmentOperator$RightShiftEqualOperator ::= '>>='

    AssignmentOperator$UnsignedRightShiftEqualOperator ::= '>>>='

    AssignmentOperator$AndEqualOperator ::= '&='

    AssignmentOperator$ExclusiveOrEqualOperator ::= '^='

    AssignmentOperator$OrEqualOperator ::= '|='

    Expression ::= AssignmentExpression

    ConstantExpression ::= Expression

    ---------------------------------------------------------------------------------------
    --
    -- The following rules are for optional nonterminals.
    --
    ---------------------------------------------------------------------------------------

    PackageDeclarationopt ::= $empty

    PackageDeclarationopt ::= PackageDeclaration

    Superopt ::= $empty

    Superopt ::= Super

    Expressionopt ::= $empty

    Expressionopt ::= Expression

    --1.1 feature
    ClassBodyopt ::= $empty

    --1.1 feature
    ClassBodyopt ::= ClassBody

    ImportDeclarationsopt ::= $empty

    ImportDeclarationsopt ::= ImportDeclarations

    TypeDeclarationsopt ::= $empty

    TypeDeclarationsopt ::= TypeDeclarations

    ClassBodyDeclarationsopt ::= $empty

    ClassBodyDeclarationsopt ::= ClassBodyDeclarations

    Modifiersopt ::= $empty

    Modifiersopt ::= Modifiers

    BlockStatementsopt ::= $empty

    BlockStatementsopt ::= BlockStatements

    Dimsopt ::= $empty

    Dimsopt ::= Dims

    ArgumentListopt ::= $empty

    ArgumentListopt ::= ArgumentList

    Throwsopt ::= $empty

    Throwsopt ::= Throws

    FormalParameterListopt ::= $empty

    FormalParameterListopt ::= FormalParameterList

    Interfacesopt ::= $empty

    Interfacesopt ::= Interfaces

    InterfaceMemberDeclarationsopt ::= $empty

    InterfaceMemberDeclarationsopt ::= InterfaceMemberDeclarations

    ForInitopt ::= $empty

    ForInitopt ::= ForInit

    ForUpdateopt ::= $empty

    ForUpdateopt ::= ForUpdate

    ExtendsInterfacesopt ::= $empty

    ExtendsInterfacesopt ::= ExtendsInterfaces

    Catchesopt ::= $empty

    Catchesopt ::= Catches

    ---------------------------------------------------------------------------------------
    --
    -- The rules below are for optional terminal symbols.  An optional comma,
    -- is only used in the context of an array initializer - It is a
    -- "syntactic sugar" that otherwise serves no other purpose. By contrast,
    -- an optional identifier is used in the definition of a break and
    -- continue statement. When the identifier does not appear, a NULL
    -- is produced. When the identifier is present, the user should use the
    -- corresponding Token(i) method. See break statement as an example.
    --
    ---------------------------------------------------------------------------------------

    Commaopt ::= $empty

    Commaopt ::= ,

    IDENTIFIERopt ::= $empty

    IDENTIFIERopt ::= IDENTIFIER

$Types

    Statement ::= StatementNoShortIf
                | StatementWithoutTrailingSubstatement

	LabeledStatement ::= LabeledStatementNoShortIf

    IfThenElseStatement ::= IfThenElseStatementNoShortIf

    WhileStatement ::= WhileStatementNoShortIf

    ForStatement ::= ForStatementNoShortIf

$End
