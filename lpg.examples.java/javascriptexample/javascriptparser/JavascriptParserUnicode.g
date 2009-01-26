%options states,la=2
%options fp=JavascriptParser
%options ast_directory=./Ast
%options visitor=preorder
%options noparent_saved
%options variables
%options automatic_ast=toplevel
%options package=javascriptparser
%options template=dtParserTemplateF.gi
%options import_terminals=JavascriptLexerUnicode.gi
%options action-block=("IAst.java", "/:", ":/")

%Headers
    /:
    package $package;
    import lpg.runtime.*;

    public interface IAst extends lpg.runtime.IAst
    {
        public void extra();
    }
    :/
%End
%Globals
    /.
    import $package.IAst;
    ./
%End
%Ast
    /.
        public void extra() {}
    ./
%End

-- JavaScript 2.0
-- Formal Description
-- Syntactic Grammar
--	previousupnext
--
-- Monday, June 30, 2003
-- 
-- This LALR(1) grammar describes the syntax of the JavaScript 2.0 proposal.
-- The starting nonterminal is Program. See also the description of the grammar
-- notation.
-- 
-- This document is also available as a Word RTF file.
--
-- Terminals
-- 
-- General tokens:
--
-- Identifier NegatedMinLong Number RegularExpression String VirtualSemicolon
--
-- Punctuation tokens:
--
-- ! != !== % %= & && &&= &= ( ) * *= + ++ += , -
-- '--' -= . ... / /= : :: ; < << <<= <= = == === 
-- > >= >> >>= >>> >>>= ? [ ] ^ ^= ^^ ^^= { | |= ||
-- ||= } ~
-- 
-- Reserved words:
--
-- as break case catch class const continue default delete do else export
-- extends false finally for function if import in instanceof is namespace
-- new null package private public return super switch this throw true try
-- typeof use var void while with
-- 
-- Future reserved words:
--
-- abstract debugger enum goto implements interface native protected
-- synchronized throws transient volatile
--
-- Non-reserved words:
--
-- get include set
--
-- Expressions extension: {allowIn, noIn}
-- 
--  s extensions: {abbrev, noShortIf, full}
--

%Terminals

    NOT                                 ::= ! 
    NOT_EQUAL                           ::= != 
    NOT_EQUAL_EQUAL                     ::= !== 
    REMAINDER                           ::= '%' 
    REMAINDER_EQUAL                     ::= '%='
    AND                                 ::= '&' 
    AND_AND                             ::= '&&' 
    AND_AND_EQUAL                       ::= '&&=' 
    AND_EQUAL                           ::= '&=' 
    LPAREN                              ::= '('
    RPAREN                              ::= ')' 
    MULTIPLY                            ::= '*'
    MULTIPLY_EQUAL                      ::= '*='
    PLUS                                ::= '+'
    PLUS_PLUS                           ::= '++'
    PLUS_EQUAL                          ::= '+='
    COMMA                               ::= ','
    MINUS                               ::= '-'
    MINUS_MINUS                         ::= '--'
    MINUS_EQUAL                         ::= '-='
    PERIOD                              ::= '.'
    ETC                                 ::= '...'
    SLASH                               ::= '/'
    SLASH_EQUAL                         ::= '/='
    COLON                               ::= ':'
    COLON_COLON                         ::= '::'
    SEMICOLON                           ::= ';'
    LESS                                ::= '<'
    LEFT_SHIFT                          ::= '<<'
    LEFT_SHIFT_EQUAL                    ::= '<<='
    LESS_EQUAL                          ::= '<='
    EQUAL                               ::= '='
    EQUAL_EQUAL                         ::= '==' 
    EQUAL_EQUAL_EQUAL                   ::= '==='
    GREATER                             ::= '>'
    GREATER_EQUAL                       ::= '>='
    RIGHT_SHIFT                         ::= '>>'
    RIGHT_SHIFT_EQUAL                   ::= '>>='
    UNSIGNED_RIGHT_SHIFT                ::= '>>>'
    UNSIGNED_RIGHT_SHIFT_EQUAL          ::= '>>>='
    QUESTION                            ::= '?'
    LBRACKET                            ::= '['
    RBRACKET                            ::= ']'
    XOR                                 ::= '^'
    XOR_EQUAL                           ::= '^='
    XOR_XOR                             ::= '^^'
    XOR_XOR_EQUAL                       ::= '^^='
    LBRACE                              ::= '{' 
    OR                                  ::= '|'
    OR_EQUAL                            ::= '|='
    OR_OR                               ::= '||'
    OR_OR_EQUAL                         ::= '||='
    RBRACE                              ::= '}'
    TWIDDLE                             ::= '~'

%End

%Keywords
    EXCLUDE
    GET
    INCLUDE
    SET
%End

--$DisjointPredecessorSets
--    SLASH  RegularExpression
--$End

%Start
    Program
%End

%Rules
    --
    -- Make sure that the current token is on the same line
    -- as its predecessor.
    --
    no_line_break ::= NO_LINE_BREAK

    -- Identifiers

    Identifier ::=
       IDENTIFIER
    |  GET
    |  SET
    |  INCLUDE

    -- Qualified Identifiers

    SimpleQualifiedIdentifier ::=
       Identifier
    |  Identifier :: Identifier
    |  ReservedNamespace :: Identifier

    ExpressionQualifiedIdentifier ::= ParenExpression :: Identifier

    QualifiedIdentifier ::=
       SimpleQualifiedIdentifier
    |  ExpressionQualifiedIdentifier

    -- Primary Expressions

    PrimaryExpression ::=
       NULL
    |  TRUE
    |  FALSE
    |  Number
    |  String
    |  THIS
    |  RegularExpression
    |  ReservedNamespace
    |  ParenListExpression
    |  ArrayLiteral
    |  ObjectLiteral
    |  FunctionExpression

    ReservedNamespace ::=
       PUBLIC
    |  PRIVATE

    ParenExpression ::= '(' AssignmentExpression_allowIn ')'

    ParenListExpression ::=
       ParenExpression
    |  '(' ListExpression_allowIn ',' AssignmentExpression_allowIn ')'

    -- Function Expressions

    FunctionExpression ::=
       FUNCTION FunctionCommon
    |  FUNCTION Identifier FunctionCommon

    -- Object Literals

    ObjectLiteral ::= '{' FieldList '}'

    FieldList ::=
       %Empty
    |  NonemptyFieldList

    --
    -- Replace the rules below by right-recursive rules.
    --
    -- NonemptyFieldList ::=
    --    LiteralField
    -- |  LiteralField ',' NonemptyFieldList

    NonemptyFieldList ::=
       LiteralField
    |  NonemptyFieldList ',' LiteralField

    LiteralField ::= FieldName ':' AssignmentExpression_allowIn

    FieldName ::=
       QualifiedIdentifier
    |  String
    |  Number
    |  ParenExpression

    -- Array Literals

    ArrayLiteral ::= '[' ElementList ']'

    --
    -- Replace the rules below by right-recursive rules.
    --
    -- ElementList ::=
    --    %Empty
    -- |  LiteralElement
    -- |  ',' ElementList
    -- |  LiteralElement ',' ElementList

    ElementList ::=
       %Empty
    |  LiteralElement
    |  ElementList ',' 
    |  ElementList ',' LiteralElement

    LiteralElement ::= AssignmentExpression_allowIn

    -- Super Expressions

    SuperExpression ::=
       SUPER
    |  SUPER ParenExpression

    -- Postfix Expressions

    PostfixExpression ::=
       AttributeExpression
    |  FullPostfixExpression
    |  ShortNewExpression

    AttributeExpression ::=
       SimpleQualifiedIdentifier
    |  AttributeExpression PropertyOperator
    |  AttributeExpression Arguments

    FullPostfixExpression ::=
       PrimaryExpression
    |  ExpressionQualifiedIdentifier
    |  FullNewExpression
    |  FullPostfixExpression PropertyOperator
    |  SuperExpression PropertyOperator
    |  FullPostfixExpression Arguments
    |  PostfixExpression no_line_break$ '++'
    |  PostfixExpression no_line_break$ '--'

    FullNewExpression ::= NEW FullNewSubexpression Arguments

    FullNewSubexpression ::=
       PrimaryExpression
    |  QualifiedIdentifier
    |  FullNewExpression
    |  FullNewSubexpression PropertyOperator
    |  SuperExpression PropertyOperator

    ShortNewExpression ::= NEW ShortNewSubexpression

    ShortNewSubexpression ::=
       FullNewSubexpression
    |  ShortNewExpression

    -- Property Operators

    PropertyOperator ::=
       '.' QualifiedIdentifier
    |  Brackets

    Brackets ::=
       '[' ']'
    |  '[' ListExpression_allowIn ']'
    |  '[' ExpressionsWithRest ']'

    Arguments ::=
       '(' ')'
    |  ParenListExpression
    |  '(' ExpressionsWithRest ')'

    ExpressionsWithRest ::=
       RestExpression
    |  ListExpression_allowIn ',' RestExpression

    RestExpression ::= '...' AssignmentExpression_allowIn

    -- Unary Operators

    UnaryExpression ::=
       PostfixExpression
    |  DELETE PostfixExpression
    |  VOID UnaryExpression
    |  TYPEOF UnaryExpression
    |  '++' PostfixExpression
    |  '--' PostfixExpression
    |  '+' UnaryExpression
    |  '-' UnaryExpression
    |  '-' NegatedMinLong
    |  '~' UnaryExpression
    |  '!' UnaryExpression

    -- Multiplicative Operators

    MultiplicativeExpression ::=
       UnaryExpression
    |  MultiplicativeExpression '*' UnaryExpression
    |  MultiplicativeExpression '/' UnaryExpression
    |  MultiplicativeExpression '%' UnaryExpression

    -- Additive Operators

    AdditiveExpression ::=
       MultiplicativeExpression
    |  AdditiveExpression '+' MultiplicativeExpression
    |  AdditiveExpression '-' MultiplicativeExpression

    -- Bitwise Shift Operators

    ShiftExpression ::=
       AdditiveExpression
    |  ShiftExpression '<<' AdditiveExpression
    |  ShiftExpression '>>' AdditiveExpression
    |  ShiftExpression '>>>' AdditiveExpression

    -- Relational Operators

    RelationalExpression_allowIn ::=
       ShiftExpression
    |  RelationalExpression_allowIn '<' ShiftExpression
    |  RelationalExpression_allowIn '>' ShiftExpression
    |  RelationalExpression_allowIn '<=' ShiftExpression
    |  RelationalExpression_allowIn '>=' ShiftExpression
    |  RelationalExpression_allowIn IS ShiftExpression
    |  RelationalExpression_allowIn AS ShiftExpression
    |  RelationalExpression_allowIn IN ShiftExpression
    |  RelationalExpression_allowIn INSTANCEOF ShiftExpression

    RelationalExpression_noIn ::=
       ShiftExpression
    |  RelationalExpression_noIn '<' ShiftExpression
    |  RelationalExpression_noIn '>' ShiftExpression
    |  RelationalExpression_noIn '<=' ShiftExpression
    |  RelationalExpression_noIn '>=' ShiftExpression
    |  RelationalExpression_noIn IS ShiftExpression
    |  RelationalExpression_noIn AS ShiftExpression
    |  RelationalExpression_noIn INSTANCEOF ShiftExpression

    -- Equality Operators

    EqualityExpression_allowIn ::=
       RelationalExpression_allowIn
    |  EqualityExpression_allowIn '=='  RelationalExpression_allowIn
    |  EqualityExpression_allowIn '!='  RelationalExpression_allowIn
    |  EqualityExpression_allowIn '===' RelationalExpression_allowIn
    |  EqualityExpression_allowIn '!==' RelationalExpression_allowIn

    EqualityExpression_noIn ::=
       RelationalExpression_noIn
    |  EqualityExpression_noIn '=='  RelationalExpression_noIn
    |  EqualityExpression_noIn '!='  RelationalExpression_noIn
    |  EqualityExpression_noIn '===' RelationalExpression_noIn
    |  EqualityExpression_noIn '!==' RelationalExpression_noIn

    -- Binary Bitwise Operators

    BitwiseAndExpression_allowIn ::=
       EqualityExpression_allowIn
    |  BitwiseAndExpression_allowIn '&' EqualityExpression_allowIn

    BitwiseAndExpression_noIn ::=
       EqualityExpression_noIn
    |  BitwiseAndExpression_noIn '&' EqualityExpression_noIn

    BitwiseXorExpression_allowIn ::=
       BitwiseAndExpression_allowIn
    |  BitwiseXorExpression_allowIn '^' BitwiseAndExpression_allowIn

    BitwiseXorExpression_noIn ::=
       BitwiseAndExpression_noIn
    |  BitwiseXorExpression_noIn '^' BitwiseAndExpression_noIn

    BitwiseOrExpression_allowIn ::=
       BitwiseXorExpression_allowIn
    |  BitwiseOrExpression_allowIn '|' BitwiseXorExpression_allowIn

    BitwiseOrExpression_noIn ::=
       BitwiseXorExpression_noIn
    |  BitwiseOrExpression_noIn '|' BitwiseXorExpression_noIn

    -- Binary Logical Operators

    LogicalAndExpression_allowIn ::=
       BitwiseOrExpression_allowIn
    |  LogicalAndExpression_allowIn '&&' BitwiseOrExpression_allowIn

    LogicalAndExpression_noIn ::=
       BitwiseOrExpression_noIn
    |  LogicalAndExpression_noIn '&&' BitwiseOrExpression_noIn

    LogicalXorExpression_allowIn ::=
       LogicalAndExpression_allowIn
    |  LogicalXorExpression_allowIn '^^' LogicalAndExpression_allowIn

    LogicalXorExpression_noIn ::=
       LogicalAndExpression_noIn
    |  LogicalXorExpression_noIn '^^' LogicalAndExpression_noIn

    LogicalOrExpression_allowIn ::=
       LogicalXorExpression_allowIn
    |  LogicalOrExpression_allowIn '||' LogicalXorExpression_allowIn

    LogicalOrExpression_noIn ::=
       LogicalXorExpression_noIn
    |  LogicalOrExpression_noIn '||' LogicalXorExpression_noIn

    -- Conditional Operator

    ConditionalExpression_allowIn ::=
       LogicalOrExpression_allowIn
    |  LogicalOrExpression_allowIn '?' AssignmentExpression_allowIn ':' AssignmentExpression_allowIn

    ConditionalExpression_noIn ::=
       LogicalOrExpression_noIn
    |  LogicalOrExpression_noIn '?' AssignmentExpression_noIn ':' AssignmentExpression_noIn

    NonAssignmentExpression_allowIn ::=
       LogicalOrExpression_allowIn
    |  LogicalOrExpression_allowIn '?' NonAssignmentExpression_allowIn ':' NonAssignmentExpression_allowIn

    NonAssignmentExpression_noIn ::=
       LogicalOrExpression_noIn
    |  LogicalOrExpression_noIn '?' NonAssignmentExpression_noIn ':' NonAssignmentExpression_noIn

    -- Assignment Operators

    AssignmentExpression_allowIn ::=
       ConditionalExpression_allowIn
    |  PostfixExpression '=' AssignmentExpression_allowIn
    |  PostfixExpression CompoundAssignment AssignmentExpression_allowIn
    |  PostfixExpression LogicalAssignment AssignmentExpression_allowIn

    AssignmentExpression_noIn ::=
       ConditionalExpression_noIn
    |  PostfixExpression '=' AssignmentExpression_noIn
    |  PostfixExpression CompoundAssignment AssignmentExpression_noIn
    |  PostfixExpression LogicalAssignment AssignmentExpression_noIn

    CompoundAssignment ::=
       '*='
    |  '/='
    |  '%='
    |  '+='
    |  '-='
    |  '<<='
    |  '>>='
    |  '>>>='
    |  '&='
    |  '^='
    |  '|='

    LogicalAssignment ::=
       '&&='
    |  '^^='
    |  '||='

    -- Comma Expressions

    ListExpression_allowIn ::=
       AssignmentExpression_allowIn
    |  ListExpression_allowIn ',' AssignmentExpression_allowIn

    ListExpression_noIn ::=
       AssignmentExpression_noIn
    |  ListExpression_noIn ',' AssignmentExpression_noIn

    -- Type Expressions

    TypeExpression_allowIn ::= NonAssignmentExpression_allowIn

    TypeExpression_noIn ::= NonAssignmentExpression_noIn

    -- Statements

    Statement_abbrev ::=
       ExpressionStatement Semicolon_abbrev
    |  SuperStatement Semicolon_abbrev
    |  Block
    |  LabeledStatement_abbrev
    |  IfStatement_abbrev
    |  SwitchStatement
    |  DoStatement Semicolon_abbrev
    |  WhileStatement_abbrev
    |  ForStatement_abbrev
    |  WithStatement_abbrev
    |  ContinueStatement Semicolon_abbrev
    |  BreakStatement Semicolon_abbrev
    |  ReturnStatement Semicolon_abbrev
    |  ThrowStatement Semicolon_abbrev
    |  TryStatement

    Statement_noShortIf ::=
       ExpressionStatement Semicolon_noShortIf
    |  SuperStatement Semicolon_noShortIf
    |  Block
    |  LabeledStatement_noShortIf
    |  IfStatement_noShortIf
    |  SwitchStatement
    |  DoStatement Semicolon_noShortIf
    |  WhileStatement_noShortIf
    |  ForStatement_noShortIf
    |  WithStatement_noShortIf
    |  ContinueStatement Semicolon_noShortIf
    |  BreakStatement Semicolon_noShortIf
    |  ReturnStatement Semicolon_noShortIf
    |  ThrowStatement Semicolon_noShortIf
    |  TryStatement

    Statement_full ::=
       ExpressionStatement Semicolon_full
    |  SuperStatement Semicolon_full
    |  Block
    |  LabeledStatement_full
    |  IfStatement_full
    |  SwitchStatement
    |  DoStatement Semicolon_full
    |  WhileStatement_full
    |  ForStatement_full
    |  WithStatement_full
    |  ContinueStatement Semicolon_full
    |  BreakStatement Semicolon_full
    |  ReturnStatement Semicolon_full
    |  ThrowStatement Semicolon_full
    |  TryStatement

    Substatement_abbrev ::=
       EmptyStatement
    |  Statement_abbrev
    |  SimpleVariableDefinition Semicolon_abbrev
    |  Attributes no_line_break$ '{' Substatements '}'

    Substatement_noShortIf ::=
       EmptyStatement
    |  Statement_noShortIf
    |  SimpleVariableDefinition Semicolon_noShortIf
    |  Attributes no_line_break$ '{' Substatements '}'

    Substatement_full ::=
       EmptyStatement
    |  Statement_full
    |  SimpleVariableDefinition Semicolon_full
    |  Attributes no_line_break$ '{' Substatements '}'

    Substatements ::=
       %Empty
    |  SubstatementsPrefix Substatement_abbrev

    SubstatementsPrefix ::=
       %Empty
    |  SubstatementsPrefix Substatement_full

    Semicolon_abbrev ::=
       ';'
    |  VirtualSemicolon
    |  %Empty

    Semicolon_noShortIf ::=
       ';'
    |  VirtualSemicolon
    |  %Empty

    Semicolon_full ::=
       ';'
    |  VirtualSemicolon

    -- Empty Statement

    EmptyStatement ::= ';'

    -- Expression Statement

    --
    -- To enforce the lookahead restriction, the definition of ExpressionStatement
    -- has been expanded below in a seperate $Rules section
    --
    --    ExpressionStatement ::= ListExpression_allowIn
    --
    --    Lookahead notin { 'function', '{' }
    --

    -- Super Statement

    SuperStatement ::= SUPER Arguments

    -- Block Statement

    Block ::= '{' Directives '}'

    -- Labeled Statements

    LabeledStatement_abbrev ::= Identifier ':' Substatement_abbrev

    LabeledStatement_noShortIf ::= Identifier ':' Substatement_noShortIf

    LabeledStatement_full ::= Identifier ':' Substatement_full

    -- If Statement

    IfStatement_abbrev ::=
       IF ParenListExpression Substatement_abbrev
    |  IF ParenListExpression Substatement_noShortIf ELSE Substatement_abbrev

    IfStatement_full ::=
       IF ParenListExpression Substatement_full
    |  IF ParenListExpression Substatement_noShortIf ELSE Substatement_full

    IfStatement_noShortIf ::= IF ParenListExpression Substatement_noShortIf ELSE Substatement_noShortIf

    -- Switch Statement

    SwitchStatement ::= SWITCH ParenListExpression '{' CaseElements '}'

    CaseElements ::=
       %Empty
    |  CaseLabel
    |  CaseLabel CaseElementsPrefix CaseElement_abbrev

    CaseElementsPrefix ::=
       %Empty
    |  CaseElementsPrefix CaseElement_full

    CaseElement_abbrev ::=
       Directive_abbrev
    |  CaseLabel

    --
    -- These rules are useless.
    --
    -- CaseElement_noShortIf ::=
    --    Directive_noShortIf
    -- |  CaseLabel
    --
    CaseElement_full ::=
       Directive_full
    |  CaseLabel

    CaseLabel ::=
       CASE ListExpression_allowIn ':'
    |  DEFAULT ':'

    -- Do-While Statement

    DoStatement ::= DO Substatement_abbrev WHILE ParenListExpression

    -- While Statement

    WhileStatement_abbrev ::= WHILE ParenListExpression Substatement_abbrev

    WhileStatement_noShortIf ::= WHILE ParenListExpression Substatement_noShortIf

    WhileStatement_full ::= WHILE ParenListExpression Substatement_full

    -- For Statements

    ForStatement_abbrev ::=
       FOR '(' ForInitializer ';' OptionalExpression ';' OptionalExpression ')' Substatement_abbrev
    |  FOR '(' ForInBinding IN ListExpression_allowIn ')' Substatement_abbrev

    ForStatement_noShortIf ::=
       FOR '(' ForInitializer ';' OptionalExpression ';' OptionalExpression ')' Substatement_noShortIf
    |  FOR '(' ForInBinding IN ListExpression_allowIn ')' Substatement_noShortIf

    ForStatement_full ::=
       FOR '(' ForInitializer ';' OptionalExpression ';' OptionalExpression ')' Substatement_full
    |  FOR '(' ForInBinding IN ListExpression_allowIn ')' Substatement_full

    ForInitializer ::=
       %Empty
    |  ListExpression_noIn
    |  VariableDefinition_noIn
    |  Attributes no_line_break$ VariableDefinition_noIn

    ForInBinding ::=
       PostfixExpression
    |  VariableDefinitionKind VariableBinding_noIn
    |  Attributes no_line_break$ VariableDefinitionKind VariableBinding_noIn

    OptionalExpression ::=
       ListExpression_allowIn
    |  %Empty

    -- With Statement

    WithStatement_abbrev ::= WITH ParenListExpression Substatement_abbrev

    WithStatement_noShortIf ::= WITH ParenListExpression Substatement_noShortIf

    WithStatement_full ::= WITH ParenListExpression Substatement_full

    -- Continue and Break Statements

    ContinueStatement ::=
       CONTINUE
    |  CONTINUE no_line_break$ Identifier

    BreakStatement ::=
       BREAK
    |  BREAK no_line_break$ Identifier

    -- Return Statement

    ReturnStatement ::=
       RETURN
    |  RETURN no_line_break$ ListExpression_allowIn

    -- Throw Statement

    ThrowStatement ::= THROW no_line_break$ ListExpression_allowIn

    -- Try Statement

    TryStatement ::=
       TRY Block CatchClauses
    |  TRY Block CatchClausesOpt FINALLY Block

    CatchClausesOpt ::=
       %Empty
    |  CatchClauses

    CatchClauses ::=
       CatchClause
    |  CatchClauses CatchClause

    CatchClause ::= CATCH '(' Parameter ')' Block

    -- Directives

    Directive_abbrev ::=
       EmptyStatement
    |  Statement_abbrev
    |  AnnotatableDirective_abbrev
    |  Attributes no_line_break$ AnnotatableDirective_abbrev
    |  Attributes no_line_break$ '{' Directives '}'
    |  IncludeDirective Semicolon_abbrev
    |  Pragma Semicolon_abbrev

    --
    -- Whereever a Directive_abbrev can be expected, we can use that point
    -- as a good error recovery point.
    -- 
    Directive_abbrev ::= ERROR_TOKEN

    --
    -- These rules are useless.
    --
    -- Directive_noShortIf ::=
    --    EmptyStatement
    -- |  Statement_noShortIf
    -- |  AnnotatableDirective_noShortIf
    -- |  Attributes no_line_break AnnotatableDirective_noShortIf
    -- |  Attributes no_line_break '{' Directives '}'
    -- |  IncludeDirective Semicolon_noShortIf
    -- |  Pragma Semicolon_noShortIf
    --
    Directive_full ::=
       EmptyStatement
    |  Statement_full
    |  AnnotatableDirective_full
    |  Attributes no_line_break$ AnnotatableDirective_full
    |  Attributes no_line_break$ '{' Directives '}'
    |  IncludeDirective Semicolon_full
    |  Pragma Semicolon_full

    AnnotatableDirective_abbrev ::=
       VariableDefinition_allowIn Semicolon_abbrev
    |  FunctionDefinition
    |  ClassDefinition
    |  NamespaceDefinition Semicolon_abbrev
    |  ImportDirective Semicolon_abbrev
    |  ExportDefinition Semicolon_abbrev
    |  UseDirective Semicolon_abbrev

    --
    -- These rules are useless.
    --
    -- AnnotatableDirective_noShortIf ::=
    --    VariableDefinition_allowIn Semicolon_noShortIf
    -- |  FunctionDefinition
    -- |  ClassDefinition
    -- |  NamespaceDefinition Semicolon_noShortIf
    -- |  ImportDirective Semicolon_noShortIf
    -- |  ExportDefinition Semicolon_noShortIf
    -- |  UseDirective Semicolon_noShortIf
    --
    AnnotatableDirective_full ::=
       VariableDefinition_allowIn Semicolon_full
    |  FunctionDefinition
    |  ClassDefinition
    |  NamespaceDefinition Semicolon_full
    |  ImportDirective Semicolon_full
    |  ExportDefinition Semicolon_full
    |  UseDirective Semicolon_full

    --
    -- Replace the rules below to avoid conflicts.
    --
    -- Directives ::=
    --    %Empty
    -- |  DirectivesPrefix Directive_abbrev
    --
    -- DirectivesPrefix ::=
    --    %Empty
    -- |  DirectivesPrefix Directive_full

    Directives ::=
       %Empty
    |  Directive_abbrev
    |  DirectivesPrefix Directive_abbrev

    DirectivesPrefix ::=
       Directive_full
    |  DirectivesPrefix Directive_full

    -- Attributes

    Attributes ::=
       Attribute
    |  AttributeCombination

    AttributeCombination ::= Attribute no_line_break$ Attributes

    Attribute ::=
       AttributeExpression
    |  TRUE
    |  FALSE
    |  ReservedNamespace

    -- Use Directive

    UseDirective ::= USE NAMESPACE ParenListExpression

    -- Import Directive

    ImportDirective ::=
       IMPORT PackageName
    |  IMPORT Identifier = PackageName

    -- Include Directive

    IncludeDirective ::= INCLUDE no_line_break$ String

    -- Pragma

    Pragma ::= USE PragmaItems

    PragmaItems ::=
       PragmaItem
    |  PragmaItems ',' PragmaItem

    PragmaItem ::=
       PragmaExpr
    |  PragmaExpr '?'

    PragmaExpr ::=
       Identifier
    |  Identifier '(' PragmaArgument ')'

    PragmaArgument ::=
       TRUE
    |  FALSE
    |  Number
    |  '-' Number
    |  '-' NegatedMinLong
    |  String

    -- Definitions


    -- Export Definition

    ExportDefinition ::= EXPORT ExportBindingList

    ExportBindingList ::=
       ExportBinding
    |  ExportBindingList ',' ExportBinding

    ExportBinding ::=
       FunctionName
    |  FunctionName '=' FunctionName

    -- Variable Definition

    VariableDefinition_allowIn ::= VariableDefinitionKind VariableBindingList_allowIn

    VariableDefinition_noIn ::= VariableDefinitionKind VariableBindingList_noIn

    VariableDefinitionKind ::=
       VAR
    |  CONST

    VariableBindingList_allowIn ::=
       VariableBinding_allowIn
    |  VariableBindingList_allowIn ',' VariableBinding_allowIn

    VariableBindingList_noIn ::=
       VariableBinding_noIn
    |  VariableBindingList_noIn ',' VariableBinding_noIn

    VariableBinding_allowIn ::= TypedIdentifier_allowIn VariableInitialisation_allowIn

    VariableBinding_noIn ::= TypedIdentifier_noIn VariableInitialisation_noIn

    VariableInitialisation_allowIn ::=
       %Empty
    |  '=' VariableInitializer_allowIn

    VariableInitialisation_noIn ::=
       %Empty
    |  '=' VariableInitializer_noIn

    VariableInitializer_allowIn ::=
       AssignmentExpression_allowIn
    |  AttributeCombination

    VariableInitializer_noIn ::=
       AssignmentExpression_noIn
    |  AttributeCombination

    TypedIdentifier_allowIn ::=
       Identifier
    |  Identifier ':' TypeExpression_allowIn

    TypedIdentifier_noIn ::=
       Identifier
    |  Identifier ':' TypeExpression_noIn

    -- Simple Variable Definition
    -- 
    -- A SimpleVariableDefinition represents the subset of VariableDefinition expansions that may be used when
    -- the variable definition is used as a Substatement? instead of a Directive? in non-strict mode. In strict
    -- mode variable definitions may not be used as substatements.
    --
    SimpleVariableDefinition ::= VAR UntypedVariableBindingList

    UntypedVariableBindingList ::=
       UntypedVariableBinding
    |  UntypedVariableBindingList ',' UntypedVariableBinding

    UntypedVariableBinding ::= Identifier VariableInitialisation_allowIn

    -- Function Definition

    FunctionDefinition ::= FUNCTION FunctionName FunctionCommon

    FunctionName ::=
       Identifier
    |  GET no_line_break$ Identifier
    |  SET no_line_break$ Identifier

    FunctionCommon ::= '(' Parameters ')' Result Block

    Parameters ::=
       %Empty
    |  NonemptyParameters

    --
    -- Replace the rules below by right-recursive rules.
    --
    -- NonemptyParameters ::=
    --    ParameterInit
    -- |  ParameterInit ',' NonemptyParameters
    -- |  RestParameter

    NonemptyParameters ::=
       ParameterInitList
    |  RestParameter
    |  ParameterInitList RestParameter

    ParameterInitList ::= 
       ParameterInit
    |  ParameterInitList ',' ParameterInit

    Parameter ::= ParameterAttributes TypedIdentifier_allowIn

    ParameterAttributes ::=
       %Empty
    |  CONST

    ParameterInit ::=
       Parameter
    |  Parameter = AssignmentExpression_allowIn

    RestParameter ::=
       '...'
    |  '...' ParameterAttributes Identifier

    Result ::=
       %Empty
    |  ':' TypeExpression_allowIn

    -- Class Definition

    ClassDefinition ::= CLASS Identifier Inheritance Block
    Inheritance ::=
       %Empty
    |  EXTENDS TypeExpression_allowIn

    -- Namespace Definition

    NamespaceDefinition ::= NAMESPACE Identifier

    -- Programs
    --
    -- Program ::=
    --      Directives
    --    | PackageDefinition Program
    --
    
    Program ::=
       Directives
    |  PackageDefinitionList Directives

    PackageDefinitionList ::=
       PackageDefinition
    |  PackageDefinitionList PackageDefinition

    -- Package Definition

    PackageDefinition ::= PACKAGE PackageNameOpt Block

    PackageNameOpt ::=
       %Empty
    |  PackageName

    PackageName ::=
       String
    |  PackageIdentifiers

    PackageIdentifiers ::=
       Identifier
    |  PackageIdentifiers '.' Identifier
%End

------------------------------------------------------------------------------------
--
--    ListExpression_allowIn ::=
--       AssignmentExpression_allowIn
--    |  ListExpression_allowIn ',' AssignmentExpression_allowIn
--
-- ExpressionStatement ::= ListExpression_allowIn
--
-- Lookahead notin { 'function', '{' }
--
------------------------------------------------------------------------------------
--
-- The definition of ExpressionStatement is expanded here in order to enforce
-- the lookahead restriction.
--
-- Restriction: the first token in the ListExpression_allowIn cannot be
-- the token FUNCTION or the token '{'. In other words, the initial expression
-- cannot be an ObjectLiteral or a FunctionExpression
--
-- Solution: First we expand the definition of ListExpression_allowIn on the
-- right-hand side of the ExpressionStatement rules. Next, we replace all the 
-- expression nonterminals A that may be derived directly or indirectly from the
-- initial AssignmentExpression_allowIN (inclusive) by a new nonterminal
-- ES_A and write a new version of the set of rules associated with A for ES_A.
-- For the rules associated with ES_PrimaryExpression, we omit the two right-hand
-- sides: ObjectLiteral (which starts with '{') and FunctionReference which starts
-- with 'FUNCTION'.
--
%Rules
    ExpressionStatement ::=
       ES_AssignmentExpression_allowIn
    |  ExpressionStatement ',' AssignmentExpression_allowIn

    -- Primary Expressions

    ES_PrimaryExpression ::=
       NULL
    |  TRUE
    |  FALSE
    |  Number
    |  String
    |  THIS
    |  RegularExpression
    |  ReservedNamespace
    |  ParenListExpression
    |  ArrayLiteral
--    |  ObjectLiteral
--    |  FunctionExpression

    -- Postfix Expressions

    ES_PostfixExpression ::=
       AttributeExpression
    |  ES_FullPostfixExpression
    |  ShortNewExpression

    ES_FullPostfixExpression ::=
       ES_PrimaryExpression
    |  ExpressionQualifiedIdentifier
    |  FullNewExpression
    |  ES_FullPostfixExpression PropertyOperator
    |  SuperExpression PropertyOperator
    |  ES_FullPostfixExpression Arguments
    |  ES_PostfixExpression no_line_break$ '++'
    |  ES_PostfixExpression no_line_break$ '--'

    -- Unary Operators

    ES_UnaryExpression ::=
       ES_PostfixExpression
    |  DELETE PostfixExpression
    |  VOID UnaryExpression
    |  TYPEOF UnaryExpression
    |  '++' PostfixExpression
    |  '--' PostfixExpression
    |  '+' UnaryExpression
    |  '-' UnaryExpression
    |  '-' NegatedMinLong
    |  '~' UnaryExpression
    |  '!' UnaryExpression

    -- Multiplicative Operators

    ES_MultiplicativeExpression ::=
       ES_UnaryExpression
    |  ES_MultiplicativeExpression '*' UnaryExpression
    |  ES_MultiplicativeExpression '/' UnaryExpression
    |  ES_MultiplicativeExpression '%' UnaryExpression

    -- Additive Operators

    ES_AdditiveExpression ::=
       ES_MultiplicativeExpression
    |  ES_AdditiveExpression '+' MultiplicativeExpression
    |  ES_AdditiveExpression '-' MultiplicativeExpression

    -- Bitwise Shift Operators

    ES_ShiftExpression ::=
       ES_AdditiveExpression
    |  ES_ShiftExpression '<<' AdditiveExpression
    |  ES_ShiftExpression '>>' AdditiveExpression
    |  ES_ShiftExpression '>>>' AdditiveExpression

    -- Relational Operators

    ES_RelationalExpression_allowIn ::=
       ES_ShiftExpression
    |  ES_RelationalExpression_allowIn '<' ShiftExpression
    |  ES_RelationalExpression_allowIn '>' ShiftExpression
    |  ES_RelationalExpression_allowIn '<=' ShiftExpression
    |  ES_RelationalExpression_allowIn '>=' ShiftExpression
    |  ES_RelationalExpression_allowIn IS ShiftExpression
    |  ES_RelationalExpression_allowIn AS ShiftExpression
    |  ES_RelationalExpression_allowIn IN ShiftExpression
    |  ES_RelationalExpression_allowIn INSTANCEOF ShiftExpression

    -- Equality Operators

    ES_EqualityExpression_allowIn ::=
       ES_RelationalExpression_allowIn
    |  ES_EqualityExpression_allowIn '=='  RelationalExpression_allowIn
    |  ES_EqualityExpression_allowIn '!='  RelationalExpression_allowIn
    |  ES_EqualityExpression_allowIn '===' RelationalExpression_allowIn
    |  ES_EqualityExpression_allowIn '!==' RelationalExpression_allowIn

    -- Binary Bitwise Operators

    ES_BitwiseAndExpression_allowIn ::=
       ES_EqualityExpression_allowIn
    |  ES_BitwiseAndExpression_allowIn '&' EqualityExpression_allowIn

    ES_BitwiseXorExpression_allowIn ::=
       ES_BitwiseAndExpression_allowIn
    |  ES_BitwiseXorExpression_allowIn '^' BitwiseAndExpression_allowIn

    ES_BitwiseOrExpression_allowIn ::=
       ES_BitwiseXorExpression_allowIn
    |  ES_BitwiseOrExpression_allowIn '|' BitwiseXorExpression_allowIn

    -- Binary Logical Operators

    ES_LogicalAndExpression_allowIn ::=
       ES_BitwiseOrExpression_allowIn
    |  ES_LogicalAndExpression_allowIn '&&' BitwiseOrExpression_allowIn

    ES_LogicalXorExpression_allowIn ::=
       ES_LogicalAndExpression_allowIn
    |  ES_LogicalXorExpression_allowIn '^^' LogicalAndExpression_allowIn

    ES_LogicalOrExpression_allowIn ::=
       ES_LogicalXorExpression_allowIn
    |  ES_LogicalOrExpression_allowIn '||' LogicalXorExpression_allowIn

    -- Conditional Operator

    ES_ConditionalExpression_allowIn ::=
       ES_LogicalOrExpression_allowIn
    |  ES_LogicalOrExpression_allowIn '?' AssignmentExpression_allowIn ':' AssignmentExpression_allowIn

    -- Assignment Operators

    ES_AssignmentExpression_allowIn ::=
       ES_ConditionalExpression_allowIn
    |  ES_PostfixExpression '=' AssignmentExpression_allowIn
    |  ES_PostfixExpression CompoundAssignment AssignmentExpression_allowIn
    |  ES_PostfixExpression LogicalAssignment AssignmentExpression_allowIn
%End
