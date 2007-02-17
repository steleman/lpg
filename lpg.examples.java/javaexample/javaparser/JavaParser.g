%options var=nt,automatic_ast,visitor=default
%options la=2
%options fp=JavaParser
%options package=javaparser
%options template=dtParserTemplateD.g
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

$EOL
    ;
$End

$Start
    CompilationUnit
$End

$Headers
    /.
        public IToken getDocComment(IToken token)
        {
            int token_index = token.getTokenIndex();
            IToken[] adjuncts = getPrecedingAdjuncts(token_index);
            int i = adjuncts.length - 1;
            return (i >= 0 && adjuncts[i].getKind() == $sym_type.TK_DocComment
                            ? adjuncts[i]
                            : null);
        }
        
    ./
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

    Literal$BooleanLiteral ::= BooleanLiteral

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
           | QualifiedName

    SimpleName ::= 'IDENTIFIER'

    QualifiedName ::= Name '.' 'IDENTIFIER'

    --18.6 Productions from 7: Packages
    CompilationUnit ::= PackageDeclarationopt ImportDeclarationsopt TypeDeclarationsopt

    ImportDeclarations$$ImportDeclaration ::= ImportDeclaration
                                            | ImportDeclarations ImportDeclaration

    TypeDeclarations$$TypeDeclaration ::= TypeDeclaration
                                        | TypeDeclarations TypeDeclaration

    PackageDeclaration ::= 'package' Name ';'

    ImportDeclaration ::= SingleTypeImportDeclaration

    ImportDeclaration ::= TypeImportOnDemandDeclaration

    SingleTypeImportDeclaration ::= 'import' Name ';'

    TypeImportOnDemandDeclaration ::= 'import' Name '.' '*' ';'

    TypeDeclaration ::= ClassDeclaration

    TypeDeclaration ::= InterfaceDeclaration

    TypeDeclaration$EmptyDeclaration ::= ;

    --18.7 Only in the LALR(1) Grammar

    Modifiers$$Modifier ::= Modifier
                          | Modifiers Modifier

    --
    -- Assign a name to each modifier to force construction of a type for them.
    -- Otherwise, we sould get the token...
    --
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

    ClassDeclaration ::= Modifiersopt 'class' 'IDENTIFIER'$Name Superopt Interfacesopt ClassBody
    /.
            private IToken docComment;
            public IToken getDocComment() { return docComment; }
            
            public void initialize()
            {
                docComment = environment.getDocComment(getLeftIToken());
            }
    ./

    Super ::= 'extends' ClassType

    Interfaces$$InterfaceType ::= 'implements' InterfaceTypeList

    InterfaceTypeList$$InterfaceType ::= InterfaceType
                                       | InterfaceTypeList ',' InterfaceType

    ClassBody ::= '{' ClassBodyDeclarationsopt '}'

    ClassBodyDeclarations$$ClassBodyDeclaration ::= ClassBodyDeclaration
                                                  | ClassBodyDeclarations ClassBodyDeclaration

    ClassBodyDeclaration ::= ClassMemberDeclaration
                           | StaticInitializer
                           | ConstructorDeclaration
                           | Block --1.1 feature

    ClassMemberDeclaration ::= FieldDeclaration
                             | MethodDeclaration
                             | ClassDeclaration      --1.1 feature
                             | InterfaceDeclaration  --1.1 features

    ClassMemberDeclaration$EmptyDeclaration ::= ;

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
    /.
            private IToken docComment;
            public IToken getDocComment() { return docComment; }
            
            public void initialize()
            {
                docComment = environment.getDocComment(getLeftIToken());
            }
    ./

    VariableDeclarators$$VariableDeclarator ::= VariableDeclarator
                                              | VariableDeclarators ',' VariableDeclarator

    VariableDeclarator ::= VariableDeclaratorId
                         | VariableDeclaratorId '=' VariableInitializer

    VariableDeclaratorId ::= 'IDENTIFIER' Dimsopt

    VariableInitializer ::= Expression
                          | ArrayInitializer

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
    /.
            private IToken docComment;
            public IToken getDocComment() { return docComment; }
            
            public void initialize()
            {
                docComment = environment.getDocComment(getLeftIToken());
            }
    ./

    MethodHeader$TypedMethodHeader ::= Modifiersopt Type MethodDeclarator Throwsopt

    MethodHeader$VoidMethodHeader ::= Modifiersopt 'void' MethodDeclarator Throwsopt

    MethodDeclarator ::= 'IDENTIFIER' '(' FormalParameterListopt ')' Dimsopt

    FormalParameterList$$FormalParameter ::= FormalParameter
                                           | FormalParameterList ',' FormalParameter

    FormalParameter$FormalParameter ::= Modifiersopt Type VariableDeclaratorId

    Throws$$ClassType ::= 'throws' ClassTypeList

    ClassTypeList$$ClassType ::= ClassType
                               | ClassTypeList ',' ClassType

    MethodBody ::= Block

    MethodBody$EmptyMethodBody ::= ';'

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
    /.
            private IToken docComment;
            public IToken getDocComment() { return docComment; }
            
            public void initialize()
            {
                docComment = environment.getDocComment(getLeftIToken());
            }
    ./

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
    -- in the rules below in order to avoid conflicts with BlockStatementopt.
    --
    -- ConstructorBody ::= '{' ExplicitConstructorInvocationopt BlockStatementsopt '}'
    --
    ConstructorBody ::= Block
                      | '{' ExplicitConstructorInvocation BlockStatementsopt '}'

    ExplicitConstructorInvocation$ThisCall ::= 'this' '(' ArgumentListopt ')' ';'
                                             | Primary '.' 'this' '(' ArgumentListopt ')' ';' --1.2 feature

    ExplicitConstructorInvocation$SuperCall ::= 'super' '(' ArgumentListopt ')' ';'
                                              | Primary$expression '.' 'super' '(' ArgumentListopt ')' ';' --1.1 feature
                                              | Name$expression '.' 'super' '(' ArgumentListopt ')' ';'    --1.1 feature

    --18.9 Productions from 9: Interface Declarations

    --18.9.1 Productions from 9.1: Interface Declarations
    --InterfaceModifier ::=
    --      'public'
    --    | 'abstract'
    --
    InterfaceDeclaration ::= Modifiersopt 'interface' 'IDENTIFIER'$Name ExtendsInterfacesopt InterfaceBody
    /.
            private IToken docComment;
            public IToken getDocComment() { return docComment; }
            
            public void initialize()
            {
                docComment = environment.getDocComment(getLeftIToken());
            }
    ./

    ExtendsInterfaces$$InterfaceType ::= 'extends' InterfaceTypeList

    InterfaceBody ::= '{' InterfaceMemberDeclarationsopt '}'

    InterfaceMemberDeclarations$$InterfaceMemberDeclaration ::= InterfaceMemberDeclaration
                                                              | InterfaceMemberDeclarations InterfaceMemberDeclaration

    InterfaceMemberDeclaration ::= ConstantDeclaration
                                 | AbstractMethodDeclaration
                                 | ClassDeclaration      --1.1 feature
                                 | InterfaceDeclaration  --1.1 feature

    --
    -- Empty declarations are not valid Java InterfaceMemberDeclarations.
    -- However, since the current (2/14/97) Java compiler accepts them
    -- (in fact, some of the official tests contain this erroneous
    -- syntax), we decided to accept them as valid syntax and flag them
    -- as a warning during semantic processing.
    --
    InterfaceMemberDeclaration$EmptyDeclaration ::= ;

    ConstantDeclaration ::= FieldDeclaration

    AbstractMethodDeclaration ::= MethodHeader ';'
    /.
            private IToken docComment;
            public IToken getDocComment() { return docComment; }
            
            public void initialize()
            {
                docComment = environment.getDocComment(getLeftIToken());
            }
    ./

    --18.10 Productions from 10: Arrays
    ArrayInitializer ::= '{' VariableInitializersopt Commaopt '}'
    
    VariableInitializers$$VariableInitializer ::= VariableInitializer
                                                | VariableInitializers ',' VariableInitializer

    --18.11 Productions from 13: Blocks and Statements

    Block ::= '{' BlockStatementsopt '}'

    BlockStatements$$BlockStatement ::= BlockStatement
                                      | BlockStatements BlockStatement

    BlockStatement ::= LocalVariableDeclarationStatement
                     | Statement
                     | ClassDeclaration --1.1 feature

    LocalVariableDeclarationStatement ::= LocalVariableDeclaration ';'

    LocalVariableDeclaration$LocalVariableDeclaration ::= Modifiers Type VariableDeclarators --1.1 feature
                                                        | Type VariableDeclarators
    /.
            public void initialize()
            {
                if (_Modifiers == null)
                    if (_Modifiers == null)
                    {
                        IToken left = getLeftIToken(),
                            right = getRightIToken();
                        _Modifiers = new ModifierList(left, right, true);
                    }
            }
    ./

    Statement ::= StatementWithoutTrailingSubstatement
                | LabeledStatement
                | IfThenStatement
                | IfThenElseStatement
                | WhileStatement
                | ForStatement

    StatementNoShortIf ::= StatementWithoutTrailingSubstatement
                         | LabeledStatementNoShortIf
                         | IfThenElseStatementNoShortIf
                         | WhileStatementNoShortIf
                         | ForStatementNoShortIf

    StatementWithoutTrailingSubstatement ::= Block
                                           | EmptyStatement
                                           | ExpressionStatement
                                           | SwitchStatement
                                           | DoStatement
                                           | BreakStatement
                                           | ContinueStatement
                                           | ReturnStatement
                                           | SynchronizedStatement
                                           | ThrowStatement
                                           | TryStatement

    EmptyStatement ::= ;

    LabeledStatement$LabeledStatement ::= 'IDENTIFIER' ':' Statement

    LabeledStatementNoShortIf$LabeledStatement ::= 'IDENTIFIER' ':' StatementNoShortIf$Statement

    ExpressionStatement ::= StatementExpression ';'

    StatementExpression ::= Assignment
                          | PreIncrementExpression
                          | PreDecrementExpression
                          | PostIncrementExpression
                          | PostDecrementExpression
                          | MethodInvocation
                          | ClassInstanceCreationExpression

    IfThenStatement$IfStatement ::=  'if' '(' Expression ')' Statement$thenStmt

    IfThenElseStatement$IfStatement ::=  'if' '(' Expression ')' StatementNoShortIf$thenStmt 'else' Statement$elseStmt

    IfThenElseStatementNoShortIf$IfStatement ::=  'if' '(' Expression ')' StatementNoShortIf$thenStmt 'else' StatementNoShortIf$elseStmt

    SwitchStatement ::= 'switch' '(' Expression ')' SwitchBlock

    SwitchBlock$SwitchBlock ::= '{' SwitchLabelsopt '}'
    /.
            public void initialize()
            {
		        if (_SwitchBlockStatements == null)
		        {
		            IToken left = getLeftIToken(),
		            		right = getRightIToken();
		            _SwitchBlockStatements = new SwitchBlockStatementList(left, right, true);
		        }
            }
    ./
    SwitchBlock$SwitchBlock ::= '{' SwitchBlockStatements SwitchLabelsopt '}'

    SwitchBlockStatements$$SwitchBlockStatement ::= SwitchBlockStatement
                                                  | SwitchBlockStatements SwitchBlockStatement

    SwitchBlockStatement ::= SwitchLabels BlockStatements

    SwitchLabels$$SwitchLabel ::= SwitchLabel
                                | SwitchLabels SwitchLabel

    SwitchLabel$CaseLabel ::= 'case' ConstantExpression ':'

    SwitchLabel$DefaultLabel ::= 'default' ':'

    WhileStatement$WhileStatement ::= 'while' '(' Expression ')' Statement

    WhileStatementNoShortIf$WhileStatement ::= 'while' '(' Expression ')' StatementNoShortIf$Statement

    DoStatement ::= 'do' Statement 'while' '(' Expression ')' ';'

    ForStatement$ForStatement ::= 'for' '(' ForInitopt ';' Expressionopt ';' ForUpdateopt ')' Statement

    ForStatementNoShortIf$ForStatement ::= 'for' '(' ForInitopt ';' Expressionopt ';' ForUpdateopt ')' StatementNoShortIf$Statement

    ForInit ::= StatementExpressionList
              | LocalVariableDeclaration

    ForUpdate$$StatementExpression ::= StatementExpressionList

    StatementExpressionList$$StatementExpression ::= StatementExpression
                                                   | StatementExpressionList ',' StatementExpression

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

    SynchronizedStatement ::= 'synchronized' '(' Expression ')' Block

    TryStatement$TryStatement ::= 'try' Block Catches$Catchesopt
                                | 'try' Block Catchesopt Finally

    Catches$$CatchClause ::= CatchClause
                           | Catches CatchClause

    CatchClause ::= 'catch' '(' FormalParameter ')' Block

    Finally ::= 'finally' Block

    --18.12 Productions from 14: Expressions

    Primary ::= PrimaryNoNewArray
              | ArrayCreationExpression

    PrimaryNoNewArray ::= Literal
                        | MethodInvocation
                        | ArrayAccess
                        | ClassInstanceCreationExpression
                        | FieldAccess

    PrimaryNoNewArray$ParenthesizedExpression ::= '(' Expression ')'

    PrimaryNoNewArray$PrimaryThis ::= this
                                    | Name '.' 'this'  -- 1.1 feature

    PrimaryNoNewArray$PrimaryClassLiteral ::= Type '.' 'class' --1.1 feature

    PrimaryNoNewArray$PrimaryVoidClassLiteral ::= 'void' '.' 'class' --1.1 feature

    --1.1 feature
    --
    -- In Java 1.0 a ClassBody could not appear at all in a
    -- ClassInstanceCreationExpression.
    --
    ClassInstanceCreationExpression$ClassInstanceCreationExpression ::= 'new' ClassType '(' ArgumentListopt ')' ClassBodyopt
                                                                      | Primary$expression '.' 'new' SimpleName$ClassType '(' ArgumentListopt ')' ClassBodyopt --1.1 feature
                                                                      | Name$expression '.' 'new' SimpleName$ClassType '(' ArgumentListopt ')' ClassBodyopt    --1.1 feature

    ArgumentList$$Expression ::= Expression
                               | ArgumentList ',' Expression

    ArrayCreationExpression$ArrayCreationExpression ::= 'new' PrimitiveType$Type DimExprs Dimsopt
                                                      | 'new' ClassOrInterfaceType$Type DimExprs Dimsopt
                                                      | 'new' ArrayType$Type ArrayInitializer --1.1 feature

    DimExprs$$DimExpr ::= DimExpr
                        | DimExprs DimExpr

    DimExpr ::= '[' Expression ']'

    Dims$$Dim ::= Dim
                | Dims Dim

    Dim ::= '[' ']'
    
    FieldAccess$FieldAccess ::= Primary '.' 'IDENTIFIER'

    FieldAccess$SuperFieldAccess ::= 'super' '.' 'IDENTIFIER'
                                   | Name '.' 'super' '.' 'IDENTIFIER' --1.2 feature

    MethodInvocation$MethodInvocation ::= Name '(' ArgumentListopt ')'

    MethodInvocation$PrimaryMethodInvocation ::= Primary '.' 'IDENTIFIER' '(' ArgumentListopt ')'

    MethodInvocation$SuperMethodInvocation ::= 'super' '.' 'IDENTIFIER' '(' ArgumentListopt ')'
                                             | Name '.' 'super' '.' 'IDENTIFIER' '(' ArgumentListopt ')' --1.2 feature

    ArrayAccess$ArrayAccess ::= Name$Base '[' Expression ']'
                              | PrimaryNoNewArray$Base '[' Expression ']'

    PostfixExpression ::= Primary
                        | Name
                        | PostIncrementExpression
                        | PostDecrementExpression

    PostIncrementExpression ::= PostfixExpression '++'

    PostDecrementExpression ::= PostfixExpression '--'

    UnaryExpression ::= PreIncrementExpression
                      | PreDecrementExpression
                      | UnaryExpressionNotPlusMinus


    UnaryExpression$PlusUnaryExpression ::= '+' UnaryExpression

    UnaryExpression$MinusUnaryExpression ::= '-' UnaryExpression


    PreIncrementExpression ::= '++' UnaryExpression

    PreDecrementExpression ::= '--' UnaryExpression

    UnaryExpressionNotPlusMinus ::= PostfixExpression
                                  | CastExpression

    UnaryExpressionNotPlusMinus$UnaryComplementExpression ::= '~' UnaryExpression

    UnaryExpressionNotPlusMinus$UnaryNotExpression ::= '!' UnaryExpression


    CastExpression$PrimitiveCastExpression ::= '(' PrimitiveType Dimsopt ')' UnaryExpression

    --
    -- Make sure that the Expression is syntactically a name.
    -- It was specified here as an Expression to avoid conflicts.
    --
    CastExpression$ClassCastExpression ::= '(' Expression$Name ')' UnaryExpressionNotPlusMinus
                                         | '(' Name$Name Dims ')' UnaryExpressionNotPlusMinus

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
                            | PackageDeclaration

    Superopt ::= $empty
               | Super

    Expressionopt ::= $empty
                    | Expression

    ClassBodyopt ::= $empty     --1.1 feature
                   | ClassBody  --1.1 feature

    ImportDeclarationsopt$$ImportDeclaration ::= $empty
                                               | ImportDeclarations

    TypeDeclarationsopt$$TypeDeclaration ::= $empty
                                           | TypeDeclarations

    ClassBodyDeclarationsopt$$ClassBodyDeclaration ::= $empty
                                                     | ClassBodyDeclarations

    Modifiersopt$$Modifier ::= $empty
                             | Modifiers

    ExplicitConstructorInvocationopt ::= $empty
                                       | ExplicitConstructorInvocation

    BlockStatementsopt$$BlockStatement ::= $empty
                                         | BlockStatements

    Dimsopt$$Dim ::= $empty
                   | Dims

    ArgumentListopt$$Expression ::= $empty
                                  | ArgumentList

    Throwsopt$$ClassType ::= $empty
                           | Throws

    FormalParameterListopt$$FormalParameter ::= $empty
                                              | FormalParameterList

    Interfacesopt$$InterfaceType ::= $empty
                                   | Interfaces

    InterfaceMemberDeclarationsopt$$InterfaceMemberDeclaration ::= $empty
                                                                 | InterfaceMemberDeclarations

    ForInitopt ::= $empty
                 | ForInit

    ForUpdateopt$$StatementExpression ::= $empty
                                        | ForUpdate

    ExtendsInterfacesopt$$InterfaceType ::= $empty
                                          | ExtendsInterfaces

    Catchesopt$$CatchClause ::= $empty
                              | Catches
    
    VariableInitializersopt$$VariableInitializer ::= $empty
                                                   | VariableInitializers

    SwitchBlockStatementsopt$$SwitchBlockStatement ::= $empty
                                                     | SwitchBlockStatements

    SwitchLabelsopt$$SwitchLabel ::= $empty
                                   | SwitchLabels

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
               | ,

    IDENTIFIERopt ::= $empty
                    | IDENTIFIER


$End

$Types
    Statement ::= StatementNoShortIf
                | StatementWithoutTrailingSubstatement

	LabeledStatement ::= LabeledStatementNoShortIf

    IfThenElseStatement ::= IfThenElseStatementNoShortIf

    WhileStatement ::= WhileStatementNoShortIf

    ForStatement ::= ForStatementNoShortIf
$End
