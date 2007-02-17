package javascriptparser.Ast;

public interface Visitor
{
    boolean preVisit(Ast element);

    void postVisit(Ast element);

    boolean visit(AstToken n);
    void endVisit(AstToken n);

    boolean visit(no_line_break n);
    void endVisit(no_line_break n);

    boolean visit(ExpressionQualifiedIdentifier n);
    void endVisit(ExpressionQualifiedIdentifier n);

    boolean visit(ParenExpression n);
    void endVisit(ParenExpression n);

    boolean visit(ParenListExpression n);
    void endVisit(ParenListExpression n);

    boolean visit(ObjectLiteral n);
    void endVisit(ObjectLiteral n);

    boolean visit(NonemptyFieldList n);
    void endVisit(NonemptyFieldList n);

    boolean visit(LiteralField n);
    void endVisit(LiteralField n);

    boolean visit(ArrayLiteral n);
    void endVisit(ArrayLiteral n);

    boolean visit(FullNewExpression n);
    void endVisit(FullNewExpression n);

    boolean visit(ShortNewExpression n);
    void endVisit(ShortNewExpression n);

    boolean visit(PropertyOperator n);
    void endVisit(PropertyOperator n);

    boolean visit(ExpressionsWithRest n);
    void endVisit(ExpressionsWithRest n);

    boolean visit(RestExpression n);
    void endVisit(RestExpression n);

    boolean visit(BitwiseAndExpression_allowIn n);
    void endVisit(BitwiseAndExpression_allowIn n);

    boolean visit(BitwiseAndExpression_noIn n);
    void endVisit(BitwiseAndExpression_noIn n);

    boolean visit(BitwiseXorExpression_allowIn n);
    void endVisit(BitwiseXorExpression_allowIn n);

    boolean visit(BitwiseXorExpression_noIn n);
    void endVisit(BitwiseXorExpression_noIn n);

    boolean visit(BitwiseOrExpression_allowIn n);
    void endVisit(BitwiseOrExpression_allowIn n);

    boolean visit(BitwiseOrExpression_noIn n);
    void endVisit(BitwiseOrExpression_noIn n);

    boolean visit(LogicalAndExpression_allowIn n);
    void endVisit(LogicalAndExpression_allowIn n);

    boolean visit(LogicalAndExpression_noIn n);
    void endVisit(LogicalAndExpression_noIn n);

    boolean visit(LogicalXorExpression_allowIn n);
    void endVisit(LogicalXorExpression_allowIn n);

    boolean visit(LogicalXorExpression_noIn n);
    void endVisit(LogicalXorExpression_noIn n);

    boolean visit(LogicalOrExpression_allowIn n);
    void endVisit(LogicalOrExpression_allowIn n);

    boolean visit(LogicalOrExpression_noIn n);
    void endVisit(LogicalOrExpression_noIn n);

    boolean visit(ConditionalExpression_allowIn n);
    void endVisit(ConditionalExpression_allowIn n);

    boolean visit(ConditionalExpression_noIn n);
    void endVisit(ConditionalExpression_noIn n);

    boolean visit(NonAssignmentExpression_allowIn n);
    void endVisit(NonAssignmentExpression_allowIn n);

    boolean visit(NonAssignmentExpression_noIn n);
    void endVisit(NonAssignmentExpression_noIn n);

    boolean visit(ListExpression_allowIn n);
    void endVisit(ListExpression_allowIn n);

    boolean visit(ListExpression_noIn n);
    void endVisit(ListExpression_noIn n);

    boolean visit(Substatements n);
    void endVisit(Substatements n);

    boolean visit(SubstatementsPrefix n);
    void endVisit(SubstatementsPrefix n);

    boolean visit(EmptyStatement n);
    void endVisit(EmptyStatement n);

    boolean visit(SuperStatement n);
    void endVisit(SuperStatement n);

    boolean visit(Block n);
    void endVisit(Block n);

    boolean visit(LabeledStatement_abbrev n);
    void endVisit(LabeledStatement_abbrev n);

    boolean visit(LabeledStatement_noShortIf n);
    void endVisit(LabeledStatement_noShortIf n);

    boolean visit(LabeledStatement_full n);
    void endVisit(LabeledStatement_full n);

    boolean visit(IfStatement_noShortIf n);
    void endVisit(IfStatement_noShortIf n);

    boolean visit(SwitchStatement n);
    void endVisit(SwitchStatement n);

    boolean visit(CaseElements n);
    void endVisit(CaseElements n);

    boolean visit(CaseElementsPrefix n);
    void endVisit(CaseElementsPrefix n);

    boolean visit(DoStatement n);
    void endVisit(DoStatement n);

    boolean visit(WhileStatement_abbrev n);
    void endVisit(WhileStatement_abbrev n);

    boolean visit(WhileStatement_noShortIf n);
    void endVisit(WhileStatement_noShortIf n);

    boolean visit(WhileStatement_full n);
    void endVisit(WhileStatement_full n);

    boolean visit(ForInitializer n);
    void endVisit(ForInitializer n);

    boolean visit(WithStatement_abbrev n);
    void endVisit(WithStatement_abbrev n);

    boolean visit(WithStatement_noShortIf n);
    void endVisit(WithStatement_noShortIf n);

    boolean visit(WithStatement_full n);
    void endVisit(WithStatement_full n);

    boolean visit(ThrowStatement n);
    void endVisit(ThrowStatement n);

    boolean visit(CatchClauses n);
    void endVisit(CatchClauses n);

    boolean visit(CatchClause n);
    void endVisit(CatchClause n);

    boolean visit(Directives n);
    void endVisit(Directives n);

    boolean visit(DirectivesPrefix n);
    void endVisit(DirectivesPrefix n);

    boolean visit(AttributeCombination n);
    void endVisit(AttributeCombination n);

    boolean visit(UseDirective n);
    void endVisit(UseDirective n);

    boolean visit(IncludeDirective n);
    void endVisit(IncludeDirective n);

    boolean visit(Pragma n);
    void endVisit(Pragma n);

    boolean visit(PragmaItems n);
    void endVisit(PragmaItems n);

    boolean visit(PragmaItem n);
    void endVisit(PragmaItem n);

    boolean visit(PragmaExpr n);
    void endVisit(PragmaExpr n);

    boolean visit(ExportDefinition n);
    void endVisit(ExportDefinition n);

    boolean visit(ExportBindingList n);
    void endVisit(ExportBindingList n);

    boolean visit(ExportBinding n);
    void endVisit(ExportBinding n);

    boolean visit(VariableDefinition_allowIn n);
    void endVisit(VariableDefinition_allowIn n);

    boolean visit(VariableDefinition_noIn n);
    void endVisit(VariableDefinition_noIn n);

    boolean visit(VariableBindingList_allowIn n);
    void endVisit(VariableBindingList_allowIn n);

    boolean visit(VariableBindingList_noIn n);
    void endVisit(VariableBindingList_noIn n);

    boolean visit(VariableBinding_allowIn n);
    void endVisit(VariableBinding_allowIn n);

    boolean visit(VariableBinding_noIn n);
    void endVisit(VariableBinding_noIn n);

    boolean visit(VariableInitialisation_allowIn n);
    void endVisit(VariableInitialisation_allowIn n);

    boolean visit(VariableInitialisation_noIn n);
    void endVisit(VariableInitialisation_noIn n);

    boolean visit(TypedIdentifier_allowIn n);
    void endVisit(TypedIdentifier_allowIn n);

    boolean visit(TypedIdentifier_noIn n);
    void endVisit(TypedIdentifier_noIn n);

    boolean visit(SimpleVariableDefinition n);
    void endVisit(SimpleVariableDefinition n);

    boolean visit(UntypedVariableBindingList n);
    void endVisit(UntypedVariableBindingList n);

    boolean visit(UntypedVariableBinding n);
    void endVisit(UntypedVariableBinding n);

    boolean visit(FunctionDefinition n);
    void endVisit(FunctionDefinition n);

    boolean visit(FunctionCommon n);
    void endVisit(FunctionCommon n);

    boolean visit(NonemptyParameters n);
    void endVisit(NonemptyParameters n);

    boolean visit(ParameterInitList n);
    void endVisit(ParameterInitList n);

    boolean visit(Parameter n);
    void endVisit(Parameter n);

    boolean visit(ParameterAttributes n);
    void endVisit(ParameterAttributes n);

    boolean visit(ParameterInit n);
    void endVisit(ParameterInit n);

    boolean visit(Result n);
    void endVisit(Result n);

    boolean visit(ClassDefinition n);
    void endVisit(ClassDefinition n);

    boolean visit(Inheritance n);
    void endVisit(Inheritance n);

    boolean visit(NamespaceDefinition n);
    void endVisit(NamespaceDefinition n);

    boolean visit(Program n);
    void endVisit(Program n);

    boolean visit(PackageDefinitionList n);
    void endVisit(PackageDefinitionList n);

    boolean visit(PackageDefinition n);
    void endVisit(PackageDefinition n);

    boolean visit(PackageName n);
    void endVisit(PackageName n);

    boolean visit(PackageIdentifiers n);
    void endVisit(PackageIdentifiers n);

    boolean visit(ExpressionStatement n);
    void endVisit(ExpressionStatement n);

    boolean visit(ES_BitwiseAndExpression_allowIn n);
    void endVisit(ES_BitwiseAndExpression_allowIn n);

    boolean visit(ES_BitwiseXorExpression_allowIn n);
    void endVisit(ES_BitwiseXorExpression_allowIn n);

    boolean visit(ES_BitwiseOrExpression_allowIn n);
    void endVisit(ES_BitwiseOrExpression_allowIn n);

    boolean visit(ES_LogicalAndExpression_allowIn n);
    void endVisit(ES_LogicalAndExpression_allowIn n);

    boolean visit(ES_LogicalXorExpression_allowIn n);
    void endVisit(ES_LogicalXorExpression_allowIn n);

    boolean visit(ES_LogicalOrExpression_allowIn n);
    void endVisit(ES_LogicalOrExpression_allowIn n);

    boolean visit(ES_ConditionalExpression_allowIn n);
    void endVisit(ES_ConditionalExpression_allowIn n);

    boolean visit(Identifier0 n);
    void endVisit(Identifier0 n);

    boolean visit(Identifier1 n);
    void endVisit(Identifier1 n);

    boolean visit(Identifier2 n);
    void endVisit(Identifier2 n);

    boolean visit(Identifier3 n);
    void endVisit(Identifier3 n);

    boolean visit(SimpleQualifiedIdentifier0 n);
    void endVisit(SimpleQualifiedIdentifier0 n);

    boolean visit(SimpleQualifiedIdentifier1 n);
    void endVisit(SimpleQualifiedIdentifier1 n);

    boolean visit(PrimaryExpression0 n);
    void endVisit(PrimaryExpression0 n);

    boolean visit(PrimaryExpression1 n);
    void endVisit(PrimaryExpression1 n);

    boolean visit(PrimaryExpression2 n);
    void endVisit(PrimaryExpression2 n);

    boolean visit(PrimaryExpression3 n);
    void endVisit(PrimaryExpression3 n);

    boolean visit(PrimaryExpression4 n);
    void endVisit(PrimaryExpression4 n);

    boolean visit(PrimaryExpression5 n);
    void endVisit(PrimaryExpression5 n);

    boolean visit(PrimaryExpression6 n);
    void endVisit(PrimaryExpression6 n);

    boolean visit(ReservedNamespace0 n);
    void endVisit(ReservedNamespace0 n);

    boolean visit(ReservedNamespace1 n);
    void endVisit(ReservedNamespace1 n);

    boolean visit(FunctionExpression0 n);
    void endVisit(FunctionExpression0 n);

    boolean visit(FunctionExpression1 n);
    void endVisit(FunctionExpression1 n);

    boolean visit(FieldName0 n);
    void endVisit(FieldName0 n);

    boolean visit(FieldName1 n);
    void endVisit(FieldName1 n);

    boolean visit(ElementList0 n);
    void endVisit(ElementList0 n);

    boolean visit(ElementList1 n);
    void endVisit(ElementList1 n);

    boolean visit(SuperExpression0 n);
    void endVisit(SuperExpression0 n);

    boolean visit(SuperExpression1 n);
    void endVisit(SuperExpression1 n);

    boolean visit(AttributeExpression0 n);
    void endVisit(AttributeExpression0 n);

    boolean visit(AttributeExpression1 n);
    void endVisit(AttributeExpression1 n);

    boolean visit(FullPostfixExpression0 n);
    void endVisit(FullPostfixExpression0 n);

    boolean visit(FullPostfixExpression1 n);
    void endVisit(FullPostfixExpression1 n);

    boolean visit(FullPostfixExpression2 n);
    void endVisit(FullPostfixExpression2 n);

    boolean visit(FullPostfixExpression3 n);
    void endVisit(FullPostfixExpression3 n);

    boolean visit(FullPostfixExpression4 n);
    void endVisit(FullPostfixExpression4 n);

    boolean visit(FullNewSubexpression0 n);
    void endVisit(FullNewSubexpression0 n);

    boolean visit(FullNewSubexpression1 n);
    void endVisit(FullNewSubexpression1 n);

    boolean visit(Brackets0 n);
    void endVisit(Brackets0 n);

    boolean visit(Brackets1 n);
    void endVisit(Brackets1 n);

    boolean visit(Brackets2 n);
    void endVisit(Brackets2 n);

    boolean visit(Arguments0 n);
    void endVisit(Arguments0 n);

    boolean visit(Arguments1 n);
    void endVisit(Arguments1 n);

    boolean visit(UnaryExpression0 n);
    void endVisit(UnaryExpression0 n);

    boolean visit(UnaryExpression1 n);
    void endVisit(UnaryExpression1 n);

    boolean visit(UnaryExpression2 n);
    void endVisit(UnaryExpression2 n);

    boolean visit(UnaryExpression3 n);
    void endVisit(UnaryExpression3 n);

    boolean visit(UnaryExpression4 n);
    void endVisit(UnaryExpression4 n);

    boolean visit(UnaryExpression5 n);
    void endVisit(UnaryExpression5 n);

    boolean visit(UnaryExpression6 n);
    void endVisit(UnaryExpression6 n);

    boolean visit(UnaryExpression7 n);
    void endVisit(UnaryExpression7 n);

    boolean visit(UnaryExpression8 n);
    void endVisit(UnaryExpression8 n);

    boolean visit(UnaryExpression9 n);
    void endVisit(UnaryExpression9 n);

    boolean visit(MultiplicativeExpression0 n);
    void endVisit(MultiplicativeExpression0 n);

    boolean visit(MultiplicativeExpression1 n);
    void endVisit(MultiplicativeExpression1 n);

    boolean visit(MultiplicativeExpression2 n);
    void endVisit(MultiplicativeExpression2 n);

    boolean visit(AdditiveExpression0 n);
    void endVisit(AdditiveExpression0 n);

    boolean visit(AdditiveExpression1 n);
    void endVisit(AdditiveExpression1 n);

    boolean visit(ShiftExpression0 n);
    void endVisit(ShiftExpression0 n);

    boolean visit(ShiftExpression1 n);
    void endVisit(ShiftExpression1 n);

    boolean visit(ShiftExpression2 n);
    void endVisit(ShiftExpression2 n);

    boolean visit(RelationalExpression_allowIn0 n);
    void endVisit(RelationalExpression_allowIn0 n);

    boolean visit(RelationalExpression_allowIn1 n);
    void endVisit(RelationalExpression_allowIn1 n);

    boolean visit(RelationalExpression_allowIn2 n);
    void endVisit(RelationalExpression_allowIn2 n);

    boolean visit(RelationalExpression_allowIn3 n);
    void endVisit(RelationalExpression_allowIn3 n);

    boolean visit(RelationalExpression_allowIn4 n);
    void endVisit(RelationalExpression_allowIn4 n);

    boolean visit(RelationalExpression_allowIn5 n);
    void endVisit(RelationalExpression_allowIn5 n);

    boolean visit(RelationalExpression_allowIn6 n);
    void endVisit(RelationalExpression_allowIn6 n);

    boolean visit(RelationalExpression_allowIn7 n);
    void endVisit(RelationalExpression_allowIn7 n);

    boolean visit(RelationalExpression_noIn0 n);
    void endVisit(RelationalExpression_noIn0 n);

    boolean visit(RelationalExpression_noIn1 n);
    void endVisit(RelationalExpression_noIn1 n);

    boolean visit(RelationalExpression_noIn2 n);
    void endVisit(RelationalExpression_noIn2 n);

    boolean visit(RelationalExpression_noIn3 n);
    void endVisit(RelationalExpression_noIn3 n);

    boolean visit(RelationalExpression_noIn4 n);
    void endVisit(RelationalExpression_noIn4 n);

    boolean visit(RelationalExpression_noIn5 n);
    void endVisit(RelationalExpression_noIn5 n);

    boolean visit(RelationalExpression_noIn6 n);
    void endVisit(RelationalExpression_noIn6 n);

    boolean visit(EqualityExpression_allowIn0 n);
    void endVisit(EqualityExpression_allowIn0 n);

    boolean visit(EqualityExpression_allowIn1 n);
    void endVisit(EqualityExpression_allowIn1 n);

    boolean visit(EqualityExpression_allowIn2 n);
    void endVisit(EqualityExpression_allowIn2 n);

    boolean visit(EqualityExpression_allowIn3 n);
    void endVisit(EqualityExpression_allowIn3 n);

    boolean visit(EqualityExpression_noIn0 n);
    void endVisit(EqualityExpression_noIn0 n);

    boolean visit(EqualityExpression_noIn1 n);
    void endVisit(EqualityExpression_noIn1 n);

    boolean visit(EqualityExpression_noIn2 n);
    void endVisit(EqualityExpression_noIn2 n);

    boolean visit(EqualityExpression_noIn3 n);
    void endVisit(EqualityExpression_noIn3 n);

    boolean visit(AssignmentExpression_allowIn0 n);
    void endVisit(AssignmentExpression_allowIn0 n);

    boolean visit(AssignmentExpression_allowIn1 n);
    void endVisit(AssignmentExpression_allowIn1 n);

    boolean visit(AssignmentExpression_allowIn2 n);
    void endVisit(AssignmentExpression_allowIn2 n);

    boolean visit(AssignmentExpression_noIn0 n);
    void endVisit(AssignmentExpression_noIn0 n);

    boolean visit(AssignmentExpression_noIn1 n);
    void endVisit(AssignmentExpression_noIn1 n);

    boolean visit(AssignmentExpression_noIn2 n);
    void endVisit(AssignmentExpression_noIn2 n);

    boolean visit(CompoundAssignment0 n);
    void endVisit(CompoundAssignment0 n);

    boolean visit(CompoundAssignment1 n);
    void endVisit(CompoundAssignment1 n);

    boolean visit(CompoundAssignment2 n);
    void endVisit(CompoundAssignment2 n);

    boolean visit(CompoundAssignment3 n);
    void endVisit(CompoundAssignment3 n);

    boolean visit(CompoundAssignment4 n);
    void endVisit(CompoundAssignment4 n);

    boolean visit(CompoundAssignment5 n);
    void endVisit(CompoundAssignment5 n);

    boolean visit(CompoundAssignment6 n);
    void endVisit(CompoundAssignment6 n);

    boolean visit(CompoundAssignment7 n);
    void endVisit(CompoundAssignment7 n);

    boolean visit(CompoundAssignment8 n);
    void endVisit(CompoundAssignment8 n);

    boolean visit(CompoundAssignment9 n);
    void endVisit(CompoundAssignment9 n);

    boolean visit(CompoundAssignment10 n);
    void endVisit(CompoundAssignment10 n);

    boolean visit(LogicalAssignment0 n);
    void endVisit(LogicalAssignment0 n);

    boolean visit(LogicalAssignment1 n);
    void endVisit(LogicalAssignment1 n);

    boolean visit(LogicalAssignment2 n);
    void endVisit(LogicalAssignment2 n);

    boolean visit(Statement_abbrev0 n);
    void endVisit(Statement_abbrev0 n);

    boolean visit(Statement_abbrev1 n);
    void endVisit(Statement_abbrev1 n);

    boolean visit(Statement_abbrev2 n);
    void endVisit(Statement_abbrev2 n);

    boolean visit(Statement_abbrev3 n);
    void endVisit(Statement_abbrev3 n);

    boolean visit(Statement_abbrev4 n);
    void endVisit(Statement_abbrev4 n);

    boolean visit(Statement_abbrev5 n);
    void endVisit(Statement_abbrev5 n);

    boolean visit(Statement_abbrev6 n);
    void endVisit(Statement_abbrev6 n);

    boolean visit(Statement_noShortIf0 n);
    void endVisit(Statement_noShortIf0 n);

    boolean visit(Statement_noShortIf1 n);
    void endVisit(Statement_noShortIf1 n);

    boolean visit(Statement_noShortIf2 n);
    void endVisit(Statement_noShortIf2 n);

    boolean visit(Statement_noShortIf3 n);
    void endVisit(Statement_noShortIf3 n);

    boolean visit(Statement_noShortIf4 n);
    void endVisit(Statement_noShortIf4 n);

    boolean visit(Statement_noShortIf5 n);
    void endVisit(Statement_noShortIf5 n);

    boolean visit(Statement_noShortIf6 n);
    void endVisit(Statement_noShortIf6 n);

    boolean visit(Statement_full0 n);
    void endVisit(Statement_full0 n);

    boolean visit(Statement_full1 n);
    void endVisit(Statement_full1 n);

    boolean visit(Statement_full2 n);
    void endVisit(Statement_full2 n);

    boolean visit(Statement_full3 n);
    void endVisit(Statement_full3 n);

    boolean visit(Statement_full4 n);
    void endVisit(Statement_full4 n);

    boolean visit(Statement_full5 n);
    void endVisit(Statement_full5 n);

    boolean visit(Statement_full6 n);
    void endVisit(Statement_full6 n);

    boolean visit(Substatement_abbrev0 n);
    void endVisit(Substatement_abbrev0 n);

    boolean visit(Substatement_abbrev1 n);
    void endVisit(Substatement_abbrev1 n);

    boolean visit(Substatement_noShortIf0 n);
    void endVisit(Substatement_noShortIf0 n);

    boolean visit(Substatement_noShortIf1 n);
    void endVisit(Substatement_noShortIf1 n);

    boolean visit(Substatement_full0 n);
    void endVisit(Substatement_full0 n);

    boolean visit(Substatement_full1 n);
    void endVisit(Substatement_full1 n);

    boolean visit(Semicolon_abbrev0 n);
    void endVisit(Semicolon_abbrev0 n);

    boolean visit(Semicolon_abbrev1 n);
    void endVisit(Semicolon_abbrev1 n);

    boolean visit(Semicolon_noShortIf0 n);
    void endVisit(Semicolon_noShortIf0 n);

    boolean visit(Semicolon_noShortIf1 n);
    void endVisit(Semicolon_noShortIf1 n);

    boolean visit(Semicolon_full0 n);
    void endVisit(Semicolon_full0 n);

    boolean visit(Semicolon_full1 n);
    void endVisit(Semicolon_full1 n);

    boolean visit(IfStatement_abbrev0 n);
    void endVisit(IfStatement_abbrev0 n);

    boolean visit(IfStatement_abbrev1 n);
    void endVisit(IfStatement_abbrev1 n);

    boolean visit(IfStatement_full0 n);
    void endVisit(IfStatement_full0 n);

    boolean visit(IfStatement_full1 n);
    void endVisit(IfStatement_full1 n);

    boolean visit(CaseLabel0 n);
    void endVisit(CaseLabel0 n);

    boolean visit(CaseLabel1 n);
    void endVisit(CaseLabel1 n);

    boolean visit(ForStatement_abbrev0 n);
    void endVisit(ForStatement_abbrev0 n);

    boolean visit(ForStatement_abbrev1 n);
    void endVisit(ForStatement_abbrev1 n);

    boolean visit(ForStatement_noShortIf0 n);
    void endVisit(ForStatement_noShortIf0 n);

    boolean visit(ForStatement_noShortIf1 n);
    void endVisit(ForStatement_noShortIf1 n);

    boolean visit(ForStatement_full0 n);
    void endVisit(ForStatement_full0 n);

    boolean visit(ForStatement_full1 n);
    void endVisit(ForStatement_full1 n);

    boolean visit(ForInBinding0 n);
    void endVisit(ForInBinding0 n);

    boolean visit(ForInBinding1 n);
    void endVisit(ForInBinding1 n);

    boolean visit(ContinueStatement0 n);
    void endVisit(ContinueStatement0 n);

    boolean visit(ContinueStatement1 n);
    void endVisit(ContinueStatement1 n);

    boolean visit(BreakStatement0 n);
    void endVisit(BreakStatement0 n);

    boolean visit(BreakStatement1 n);
    void endVisit(BreakStatement1 n);

    boolean visit(ReturnStatement0 n);
    void endVisit(ReturnStatement0 n);

    boolean visit(ReturnStatement1 n);
    void endVisit(ReturnStatement1 n);

    boolean visit(TryStatement0 n);
    void endVisit(TryStatement0 n);

    boolean visit(TryStatement1 n);
    void endVisit(TryStatement1 n);

    boolean visit(Directive_abbrev0 n);
    void endVisit(Directive_abbrev0 n);

    boolean visit(Directive_abbrev1 n);
    void endVisit(Directive_abbrev1 n);

    boolean visit(Directive_abbrev2 n);
    void endVisit(Directive_abbrev2 n);

    boolean visit(Directive_abbrev3 n);
    void endVisit(Directive_abbrev3 n);

    boolean visit(Directive_abbrev4 n);
    void endVisit(Directive_abbrev4 n);

    boolean visit(Directive_full0 n);
    void endVisit(Directive_full0 n);

    boolean visit(Directive_full1 n);
    void endVisit(Directive_full1 n);

    boolean visit(Directive_full2 n);
    void endVisit(Directive_full2 n);

    boolean visit(Directive_full3 n);
    void endVisit(Directive_full3 n);

    boolean visit(AnnotatableDirective_abbrev0 n);
    void endVisit(AnnotatableDirective_abbrev0 n);

    boolean visit(AnnotatableDirective_abbrev1 n);
    void endVisit(AnnotatableDirective_abbrev1 n);

    boolean visit(AnnotatableDirective_abbrev2 n);
    void endVisit(AnnotatableDirective_abbrev2 n);

    boolean visit(AnnotatableDirective_abbrev3 n);
    void endVisit(AnnotatableDirective_abbrev3 n);

    boolean visit(AnnotatableDirective_abbrev4 n);
    void endVisit(AnnotatableDirective_abbrev4 n);

    boolean visit(AnnotatableDirective_full0 n);
    void endVisit(AnnotatableDirective_full0 n);

    boolean visit(AnnotatableDirective_full1 n);
    void endVisit(AnnotatableDirective_full1 n);

    boolean visit(AnnotatableDirective_full2 n);
    void endVisit(AnnotatableDirective_full2 n);

    boolean visit(AnnotatableDirective_full3 n);
    void endVisit(AnnotatableDirective_full3 n);

    boolean visit(AnnotatableDirective_full4 n);
    void endVisit(AnnotatableDirective_full4 n);

    boolean visit(Attribute0 n);
    void endVisit(Attribute0 n);

    boolean visit(Attribute1 n);
    void endVisit(Attribute1 n);

    boolean visit(ImportDirective0 n);
    void endVisit(ImportDirective0 n);

    boolean visit(ImportDirective1 n);
    void endVisit(ImportDirective1 n);

    boolean visit(PragmaArgument0 n);
    void endVisit(PragmaArgument0 n);

    boolean visit(PragmaArgument1 n);
    void endVisit(PragmaArgument1 n);

    boolean visit(PragmaArgument2 n);
    void endVisit(PragmaArgument2 n);

    boolean visit(PragmaArgument3 n);
    void endVisit(PragmaArgument3 n);

    boolean visit(PragmaArgument4 n);
    void endVisit(PragmaArgument4 n);

    boolean visit(PragmaArgument5 n);
    void endVisit(PragmaArgument5 n);

    boolean visit(VariableDefinitionKind0 n);
    void endVisit(VariableDefinitionKind0 n);

    boolean visit(VariableDefinitionKind1 n);
    void endVisit(VariableDefinitionKind1 n);

    boolean visit(FunctionName0 n);
    void endVisit(FunctionName0 n);

    boolean visit(FunctionName1 n);
    void endVisit(FunctionName1 n);

    boolean visit(RestParameter0 n);
    void endVisit(RestParameter0 n);

    boolean visit(RestParameter1 n);
    void endVisit(RestParameter1 n);

    boolean visit(ES_PrimaryExpression0 n);
    void endVisit(ES_PrimaryExpression0 n);

    boolean visit(ES_PrimaryExpression1 n);
    void endVisit(ES_PrimaryExpression1 n);

    boolean visit(ES_PrimaryExpression2 n);
    void endVisit(ES_PrimaryExpression2 n);

    boolean visit(ES_PrimaryExpression3 n);
    void endVisit(ES_PrimaryExpression3 n);

    boolean visit(ES_PrimaryExpression4 n);
    void endVisit(ES_PrimaryExpression4 n);

    boolean visit(ES_PrimaryExpression5 n);
    void endVisit(ES_PrimaryExpression5 n);

    boolean visit(ES_PrimaryExpression6 n);
    void endVisit(ES_PrimaryExpression6 n);

    boolean visit(ES_FullPostfixExpression0 n);
    void endVisit(ES_FullPostfixExpression0 n);

    boolean visit(ES_FullPostfixExpression1 n);
    void endVisit(ES_FullPostfixExpression1 n);

    boolean visit(ES_FullPostfixExpression2 n);
    void endVisit(ES_FullPostfixExpression2 n);

    boolean visit(ES_FullPostfixExpression3 n);
    void endVisit(ES_FullPostfixExpression3 n);

    boolean visit(ES_FullPostfixExpression4 n);
    void endVisit(ES_FullPostfixExpression4 n);

    boolean visit(ES_UnaryExpression0 n);
    void endVisit(ES_UnaryExpression0 n);

    boolean visit(ES_UnaryExpression1 n);
    void endVisit(ES_UnaryExpression1 n);

    boolean visit(ES_UnaryExpression2 n);
    void endVisit(ES_UnaryExpression2 n);

    boolean visit(ES_UnaryExpression3 n);
    void endVisit(ES_UnaryExpression3 n);

    boolean visit(ES_UnaryExpression4 n);
    void endVisit(ES_UnaryExpression4 n);

    boolean visit(ES_UnaryExpression5 n);
    void endVisit(ES_UnaryExpression5 n);

    boolean visit(ES_UnaryExpression6 n);
    void endVisit(ES_UnaryExpression6 n);

    boolean visit(ES_UnaryExpression7 n);
    void endVisit(ES_UnaryExpression7 n);

    boolean visit(ES_UnaryExpression8 n);
    void endVisit(ES_UnaryExpression8 n);

    boolean visit(ES_UnaryExpression9 n);
    void endVisit(ES_UnaryExpression9 n);

    boolean visit(ES_MultiplicativeExpression0 n);
    void endVisit(ES_MultiplicativeExpression0 n);

    boolean visit(ES_MultiplicativeExpression1 n);
    void endVisit(ES_MultiplicativeExpression1 n);

    boolean visit(ES_MultiplicativeExpression2 n);
    void endVisit(ES_MultiplicativeExpression2 n);

    boolean visit(ES_AdditiveExpression0 n);
    void endVisit(ES_AdditiveExpression0 n);

    boolean visit(ES_AdditiveExpression1 n);
    void endVisit(ES_AdditiveExpression1 n);

    boolean visit(ES_ShiftExpression0 n);
    void endVisit(ES_ShiftExpression0 n);

    boolean visit(ES_ShiftExpression1 n);
    void endVisit(ES_ShiftExpression1 n);

    boolean visit(ES_ShiftExpression2 n);
    void endVisit(ES_ShiftExpression2 n);

    boolean visit(ES_RelationalExpression_allowIn0 n);
    void endVisit(ES_RelationalExpression_allowIn0 n);

    boolean visit(ES_RelationalExpression_allowIn1 n);
    void endVisit(ES_RelationalExpression_allowIn1 n);

    boolean visit(ES_RelationalExpression_allowIn2 n);
    void endVisit(ES_RelationalExpression_allowIn2 n);

    boolean visit(ES_RelationalExpression_allowIn3 n);
    void endVisit(ES_RelationalExpression_allowIn3 n);

    boolean visit(ES_RelationalExpression_allowIn4 n);
    void endVisit(ES_RelationalExpression_allowIn4 n);

    boolean visit(ES_RelationalExpression_allowIn5 n);
    void endVisit(ES_RelationalExpression_allowIn5 n);

    boolean visit(ES_RelationalExpression_allowIn6 n);
    void endVisit(ES_RelationalExpression_allowIn6 n);

    boolean visit(ES_RelationalExpression_allowIn7 n);
    void endVisit(ES_RelationalExpression_allowIn7 n);

    boolean visit(ES_EqualityExpression_allowIn0 n);
    void endVisit(ES_EqualityExpression_allowIn0 n);

    boolean visit(ES_EqualityExpression_allowIn1 n);
    void endVisit(ES_EqualityExpression_allowIn1 n);

    boolean visit(ES_EqualityExpression_allowIn2 n);
    void endVisit(ES_EqualityExpression_allowIn2 n);

    boolean visit(ES_EqualityExpression_allowIn3 n);
    void endVisit(ES_EqualityExpression_allowIn3 n);

    boolean visit(ES_AssignmentExpression_allowIn0 n);
    void endVisit(ES_AssignmentExpression_allowIn0 n);

    boolean visit(ES_AssignmentExpression_allowIn1 n);
    void endVisit(ES_AssignmentExpression_allowIn1 n);

    boolean visit(ES_AssignmentExpression_allowIn2 n);
    void endVisit(ES_AssignmentExpression_allowIn2 n);
}


