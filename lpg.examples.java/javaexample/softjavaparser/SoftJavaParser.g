%options soft-keywords
%options la=2
%options package=softjavaparser
%options template=btParserTemplateF.gi

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

%Keywords

    abstract boolean break byte case catch char class const
    continue default do double else extends false final finally float
    for goto if implements import instanceof int
    interface long native new null package private
    protected public return short static strictfp super switch
    synchronized this throw throws transient true try void
    volatile while

%End

%Identifier

    IDENTIFIER

%End

%Terminals

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

%End

%EOL
    ;
%End

%Start
    Goal
%End

%Rules

    --18.2 Productions from 2.3: The syntactic Grammar

    Goal ::= initialize CompilationUnit
        /.
                    setResult(new Ast());
        ./

    Goal ::= initialize ConstructorBody
        /.
                    setResult(new Ast());
        ./

    initialize ::= %Empty
        /.
                    System.out.println("****Begin Parser: ");
                    System.out.flush();
                    setResult(null);
        ./

    identifier ::= IDENTIFIER
        /.
                    if (getIPrsStream().getKind(getRhsTokenIndex(1)) != $sym_type.TK_IDENTIFIER)
                    {
                        System.out.println("Turning keyword " +
                                           getIPrsStream().getName(getRhsTokenIndex(1)) +
                                           " at " +
                                           getIPrsStream().getLine(getRhsTokenIndex(1)) +
                                           ":" +
                                           getIPrsStream().getColumn(getRhsTokenIndex(1)) +
                                           " into an identifier");
                    }
        ./

    --18.3 Productions from 3: Lexical Structure
    --
    -- Expand the definition IntegerLiteral and BooleanLiteral
    --

    Literal ::= IntegerLiteral

    Literal ::= LongLiteral

    Literal ::= FloatingPointLiteral

    Literal ::= DoubleLiteral

    Literal ::= BooleanLiteral

    Literal ::= CharacterLiteral

    Literal ::= StringLiteral

    Literal ::= null

    BooleanLiteral ::= true

    BooleanLiteral ::= false

    --18.4 Productions from 4: Types, Values and Variables

    Type ::= PrimitiveType

    Type ::= ReferenceType

    PrimitiveType ::= NumericType

    PrimitiveType ::= 'boolean'

    NumericType ::= IntegralType

    NumericType ::= FloatingPointType

    IntegralType ::= 'byte'

    IntegralType ::= 'short'

    IntegralType ::= 'int'

    IntegralType ::= 'long'

    IntegralType ::= 'char'

    FloatingPointType ::= 'float'

    FloatingPointType ::= 'double'

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
    ArrayType ::= PrimitiveType Dims

    ArrayType ::= Name Dims

    ClassType ::= ClassOrInterfaceType

    InterfaceType ::= ClassOrInterfaceType

    --18.5 Productions from 6: Names

    Name ::= SimpleName

    Name ::= QualifiedName

    SimpleName ::= identifier

    QualifiedName ::= Name '.' identifier

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

    TypeDeclaration ::= ';'

    --18.7 Only in the LALR(1) Grammar

    Modifiers ::= Modifier

    Modifiers ::= Modifiers Modifier

    Modifier ::= 'public'

    Modifier ::= 'protected'

    Modifier ::= 'private'

    Modifier ::= 'static'

    Modifier ::= 'abstract'

    Modifier ::= 'final'

    Modifier ::= 'native'

    Modifier ::= 'strictfp'

    Modifier ::= 'synchronized'

    Modifier ::= 'transient'

    Modifier ::= 'volatile'

    --18.8 Productions from 8: Class Declarations
    --ClassModifier ::=
    --      'abstract'
    --    | 'final'
    --    | 'public'
    --18.8.1 Productions from 8.1: Class Declarations

    ClassDeclaration ::= Modifiersopt 'class' identifier Superopt Interfacesopt ClassBody

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
    ClassMemberDeclaration ::= ';'

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

    VariableDeclaratorId ::= identifier Dimsopt

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

    MethodHeader ::= Modifiersopt Type MethodDeclarator Throwsopt

    MethodHeader ::= Modifiersopt 'void' MethodDeclarator Throwsopt

    MethodDeclarator ::= identifier '(' FormalParameterListopt ')' Dimsopt

    FormalParameterList ::= FormalParameter

    FormalParameterList ::= FormalParameterList ',' FormalParameter

    FormalParameter ::= Type VariableDeclaratorId

    --1.1 feature
    FormalParameter ::= Modifiers Type VariableDeclaratorId

    Throws ::= 'throws' ClassTypeList

    ClassTypeList ::= ClassType

    ClassTypeList ::= ClassTypeList ',' ClassType

    MethodBody ::= Block

    MethodBody ::= ';'

    --18.8.4 Productions from 8.5: Static Initializers

    StaticInitializer ::= 'static' Block

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

    ConstructorDeclarator ::= identifier '(' FormalParameterListopt ')'

    --
    -- NOTE that the rules ExplicitConstructorInvocationopt has been expanded
    -- in the rule below in order to make the grammar lalr(1).
    --
    -- ConstructorBody ::= '{' ExplicitConstructorInvocationopt BlockStatementsopt '}'
    --
    ConstructorBody ::= Block

    ConstructorBody ::= '{' ExplicitConstructorInvocation BlockStatementsopt '}'

    ExplicitConstructorInvocation ::= 'this' '(' ArgumentListopt ')' ';'

    ExplicitConstructorInvocation ::= 'super' '(' ArgumentListopt ')' ';'

    --1.2 feature
    ExplicitConstructorInvocation ::= Primary '.' 'this' '(' ArgumentListopt ')' ';'

    --1.1 feature
    ExplicitConstructorInvocation ::= Primary '.' 'super' '(' ArgumentListopt ')' ';'

    --1.1 feature
    ExplicitConstructorInvocation ::= Name '.' 'super' '(' ArgumentListopt ')' ';'

    --18.9 Productions from 9: Interface Declarations

    --18.9.1 Productions from 9.1: Interface Declarations
    --InterfaceModifier ::=
    --      'public'
    --    | 'abstract'
    --
    InterfaceDeclaration ::= Modifiersopt 'interface' identifier ExtendsInterfacesopt InterfaceBody

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
    InterfaceMemberDeclaration ::= ';'

    ConstantDeclaration ::= FieldDeclaration

    AbstractMethodDeclaration ::= MethodHeader ';'

    --18.10 Productions from 10: Arrays

    --
    -- NOTE that the rules VariableInitializersopt and ,opt have been expanded,
    -- where appropriate, in the rule below in order to make the grammar lalr(1).
    --
    -- ArrayInitializer ::= '{' VariableInitializersopt ,opt '}'
    --
    ArrayInitializer ::= '{' ,opt '}'

    ArrayInitializer ::= '{' VariableInitializers '}'

    ArrayInitializer ::= '{' VariableInitializers , '}'

    VariableInitializers ::= VariableInitializer

    VariableInitializers ::= VariableInitializers ',' VariableInitializer

    --18.11 Productions from 13: Blocks and Statements

    Block ::= '{' BlockStatementsopt '}'

    BlockStatements ::= BlockStatement

    BlockStatements ::= BlockStatements BlockStatement

    BlockStatement ::= LocalVariableDeclarationStatement

    BlockStatement ::= Statement

    --1.1 feature
    BlockStatement ::= ClassDeclaration

    LocalVariableDeclarationStatement ::= LocalVariableDeclaration ';'

    LocalVariableDeclaration ::= Type VariableDeclarators

    --1.1 feature
    LocalVariableDeclaration ::= Modifiers Type VariableDeclarators

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

    LabeledStatement ::= identifier ':' Statement

    LabeledStatementNoShortIf ::= identifier ':' StatementNoShortIf

    ExpressionStatement ::= StatementExpression ';'

    StatementExpression ::= Assignment

    StatementExpression ::= PreIncrementExpression

    StatementExpression ::= PreDecrementExpression

    StatementExpression ::= PostIncrementExpression

    StatementExpression ::= PostDecrementExpression

    StatementExpression ::= MethodInvocation

    StatementExpression ::= ClassInstanceCreationExpression

    IfThenStatement ::=  'if' '(' Expression ')' Statement

    IfThenElseStatement ::=  'if' '(' Expression ')' StatementNoShortIf 'else' Statement

    IfThenElseStatementNoShortIf ::=  'if' '(' Expression ')' StatementNoShortIf 'else' StatementNoShortIf

    SwitchStatement ::= 'switch' '(' Expression ')' SwitchBlock

    SwitchBlock ::= '{' '}'

    SwitchBlock ::= '{' SwitchBlockStatements '}'

    SwitchBlock ::= '{' SwitchLabels '}'

    SwitchBlock ::= '{' SwitchBlockStatements SwitchLabels '}'

    SwitchBlockStatements ::= SwitchBlockStatement

    SwitchBlockStatements ::= SwitchBlockStatements SwitchBlockStatement

    SwitchBlockStatement ::= SwitchLabels BlockStatements

    SwitchLabels ::= SwitchLabel

    SwitchLabels ::= SwitchLabels SwitchLabel

    SwitchLabel ::= 'case' ConstantExpression ':'

    SwitchLabel ::= 'default' ':'

    WhileStatement ::= 'while' '(' Expression ')' Statement

    WhileStatementNoShortIf ::= 'while' '(' Expression ')' StatementNoShortIf

    DoStatement ::= 'do' Statement 'while' '(' Expression ')' ';'

    ForStatement ::= 'for' '(' ForInitopt ';' Expressionopt ';' ForUpdateopt ')' Statement

    ForStatementNoShortIf ::= 'for' '(' ForInitopt ';' Expressionopt ';' ForUpdateopt ')' StatementNoShortIf

    ForInit ::= StatementExpressionList

    ForInit ::= LocalVariableDeclaration

    ForUpdate ::= StatementExpressionList

    StatementExpressionList ::= StatementExpression

    StatementExpressionList ::= StatementExpressionList ',' StatementExpression

    --
    -- NOTE that the rule IDENTIFIERopt was expanded in line in the two
    -- contexts where it appeared: Break and Continue statements.
    -- This was done because there is no straightforward way of passing
    -- optional token information in the parse stack.
    --
    BreakStatement ::= 'break' ';'

    BreakStatement ::= 'break' identifier ';'

    ContinueStatement ::= 'continue' ';'

    ContinueStatement ::= 'continue' identifier ';'

    ReturnStatement ::= 'return' Expressionopt ';'

    ThrowStatement ::= 'throw' Expression ';'

    SynchronizedStatement ::= 'synchronized' '(' Expression ')' Block

    TryStatement ::= 'try' Block Catches

    TryStatement ::= 'try' Block Catchesopt Finally

    Catches ::= CatchClause

    Catches ::= Catches CatchClause

    CatchClause ::= 'catch' '(' FormalParameter ')' Block

    Finally ::= 'finally' Block

    --18.12 Productions from 14: Expressions

    Primary ::= PrimaryNoNewArray

    Primary ::= ArrayCreationExpression

    PrimaryNoNewArray ::= Literal

    PrimaryNoNewArray ::= this

    PrimaryNoNewArray ::= '(' Expression ')'

    PrimaryNoNewArray ::= ClassInstanceCreationExpression

    PrimaryNoNewArray ::= FieldAccess

    --1.1 feature
    PrimaryNoNewArray ::= Name '.' 'this'

    --1.1 feature
    PrimaryNoNewArray ::= Type '.' 'class'

    --1.1 feature
    PrimaryNoNewArray ::= 'void' '.' 'class'

    PrimaryNoNewArray ::= MethodInvocation

    PrimaryNoNewArray ::= ArrayAccess

    --1.1 feature
    --
    -- In Java 1.0 a ClassBody could not appear at all in a
    -- ClassInstanceCreationExpression.
    --
    ClassInstanceCreationExpression ::= 'new' ClassType '(' ArgumentListopt ')' ClassBodyopt

    --1.1 feature
    ClassInstanceCreationExpression ::= Primary '.' 'new' SimpleName '(' ArgumentListopt ')' ClassBodyopt

    --1.1 feature
    ClassInstanceCreationExpression ::= Name '.' 'new' SimpleName '(' ArgumentListopt ')' ClassBodyopt

    ArgumentList ::= Expression

    ArgumentList ::= ArgumentList ',' Expression

    ArrayCreationExpression ::= 'new' PrimitiveType DimExprs Dimsopt

    ArrayCreationExpression ::= 'new' ClassOrInterfaceType DimExprs Dimsopt

    --1.1 feature
    ArrayCreationExpression ::= 'new' ArrayType ArrayInitializer

    DimExprs ::= DimExpr

    DimExprs ::= DimExprs DimExpr

    DimExpr ::= '[' Expression ']'

    Dims ::= '[' ']'

    Dims ::= Dims '[' ']'

    FieldAccess ::= Primary '.' identifier

    FieldAccess ::= 'super' '.' identifier

    --1.2 feature
    FieldAccess ::= Name '.' 'super' '.' identifier

    MethodInvocation ::= Name '(' ArgumentListopt ')'

    MethodInvocation ::= Primary '.' identifier '(' ArgumentListopt ')'

    MethodInvocation ::= 'super' '.' identifier '(' ArgumentListopt ')'

    --1.2 feature
    MethodInvocation ::= Name '.' 'super' '.' identifier '(' ArgumentListopt ')'

    ArrayAccess ::= Name '[' Expression ']'

    ArrayAccess ::= PrimaryNoNewArray '[' Expression ']'

    PostfixExpression ::= Primary

    PostfixExpression ::= Name

    PostfixExpression ::= PostIncrementExpression

    PostfixExpression ::= PostDecrementExpression

    PostIncrementExpression ::= PostfixExpression '++'

    PostDecrementExpression ::= PostfixExpression '--'

    UnaryExpression ::= PreIncrementExpression

    UnaryExpression ::= PreDecrementExpression

    UnaryExpression ::= '+' UnaryExpression

    UnaryExpression ::= '-' UnaryExpression

    UnaryExpression ::= UnaryExpressionNotPlusMinus

    PreIncrementExpression ::= '++' UnaryExpression

    PreDecrementExpression ::= '--' UnaryExpression

    UnaryExpressionNotPlusMinus ::= PostfixExpression

    UnaryExpressionNotPlusMinus ::= '~' UnaryExpression

    UnaryExpressionNotPlusMinus ::= '!' UnaryExpression

    UnaryExpressionNotPlusMinus ::= CastExpression

    CastExpression ::= '(' PrimitiveType Dimsopt ')' UnaryExpression

    CastExpression ::= '(' Expression ')' UnaryExpressionNotPlusMinus

    CastExpression ::= '(' Name Dims ')' UnaryExpressionNotPlusMinus

    MultiplicativeExpression ::= UnaryExpression

    MultiplicativeExpression ::= MultiplicativeExpression '*' UnaryExpression

    MultiplicativeExpression ::= MultiplicativeExpression '/' UnaryExpression

    MultiplicativeExpression ::= MultiplicativeExpression '%' UnaryExpression

    AdditiveExpression ::= MultiplicativeExpression

    AdditiveExpression ::= AdditiveExpression '+' MultiplicativeExpression

    AdditiveExpression ::= AdditiveExpression '-' MultiplicativeExpression

    ShiftExpression ::= AdditiveExpression

    ShiftExpression ::= ShiftExpression '<<'  AdditiveExpression

    ShiftExpression ::= ShiftExpression '>>'  AdditiveExpression

    ShiftExpression ::= ShiftExpression '>>>' AdditiveExpression

    RelationalExpression ::= ShiftExpression

    RelationalExpression ::= RelationalExpression '<'  ShiftExpression

    RelationalExpression ::= RelationalExpression '>'  ShiftExpression

    RelationalExpression ::= RelationalExpression '<=' ShiftExpression

    RelationalExpression ::= RelationalExpression '>=' ShiftExpression

    RelationalExpression ::= RelationalExpression 'instanceof' ReferenceType

    EqualityExpression ::= RelationalExpression

    EqualityExpression ::= EqualityExpression '==' RelationalExpression

    EqualityExpression ::= EqualityExpression '!=' RelationalExpression


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

    AssignmentOperator ::= '='

    AssignmentOperator ::= '*='

    AssignmentOperator ::= '/='

    AssignmentOperator ::= '%='

    AssignmentOperator ::= '+='

    AssignmentOperator ::= '-='

    AssignmentOperator ::= '<<='

    AssignmentOperator ::= '>>='

    AssignmentOperator ::= '>>>='

    AssignmentOperator ::= '&='

    AssignmentOperator ::= '^='

    AssignmentOperator ::= '|='

    Expression ::= AssignmentExpression

    ConstantExpression ::= Expression

    ---------------------------------------------------------------------------------------
    --
    -- The following rules are for optional nonterminals.
    --
    ---------------------------------------------------------------------------------------

    PackageDeclarationopt ::= %Empty

    PackageDeclarationopt ::= PackageDeclaration

    Superopt ::= %Empty

    Superopt ::= Super

    Expressionopt ::= %Empty

    Expressionopt ::= Expression

    --1.1 feature
    ClassBodyopt ::= %Empty

    --1.1 feature
    ClassBodyopt ::= ClassBody

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

    ,opt ::= %Empty

    ,opt ::= ,

    ImportDeclarationsopt ::= %Empty

    ImportDeclarationsopt ::= ImportDeclarations

    TypeDeclarationsopt ::= %Empty

    TypeDeclarationsopt ::= TypeDeclarations

    ClassBodyDeclarationsopt ::= %Empty

    ClassBodyDeclarationsopt ::= ClassBodyDeclarations

    Modifiersopt ::= %Empty

    Modifiersopt ::= Modifiers

    BlockStatementsopt ::= %Empty

    BlockStatementsopt ::= BlockStatements

    Dimsopt ::= %Empty

    Dimsopt ::= Dims

    ArgumentListopt ::= %Empty

    ArgumentListopt ::= ArgumentList

    Throwsopt ::= %Empty

    Throwsopt ::= Throws

    FormalParameterListopt ::= %Empty

    FormalParameterListopt ::= FormalParameterList

    Interfacesopt ::= %Empty

    Interfacesopt ::= Interfaces

    InterfaceMemberDeclarationsopt ::= %Empty

    InterfaceMemberDeclarationsopt ::= InterfaceMemberDeclarations

    ForInitopt ::= %Empty

    ForInitopt ::= ForInit

    ForUpdateopt ::= %Empty

    ForUpdateopt ::= ForUpdate

    ExtendsInterfacesopt ::= %Empty

    ExtendsInterfacesopt ::= ExtendsInterfaces

    Catchesopt ::= %Empty

    Catchesopt ::= Catches

%End
