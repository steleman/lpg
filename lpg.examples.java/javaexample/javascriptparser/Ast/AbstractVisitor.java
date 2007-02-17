package javascriptparser.Ast;

public abstract class AbstractVisitor implements Visitor
{
    public abstract void unimplementedVisitor(String s);

    public boolean preVisit(Ast element) { return true; }

    public void postVisit(Ast element) {}

    public boolean visit(AstToken n) { unimplementedVisitor("visit(AstToken)"); return true; }
    public void endVisit(AstToken n) { unimplementedVisitor("endVisit(AstToken)"); }

    public boolean visit(no_line_break n) { unimplementedVisitor("visit(no_line_break)"); return true; }
    public void endVisit(no_line_break n) { unimplementedVisitor("endVisit(no_line_break)"); }

    public boolean visit(ExpressionQualifiedIdentifier n) { unimplementedVisitor("visit(ExpressionQualifiedIdentifier)"); return true; }
    public void endVisit(ExpressionQualifiedIdentifier n) { unimplementedVisitor("endVisit(ExpressionQualifiedIdentifier)"); }

    public boolean visit(ParenExpression n) { unimplementedVisitor("visit(ParenExpression)"); return true; }
    public void endVisit(ParenExpression n) { unimplementedVisitor("endVisit(ParenExpression)"); }

    public boolean visit(ParenListExpression n) { unimplementedVisitor("visit(ParenListExpression)"); return true; }
    public void endVisit(ParenListExpression n) { unimplementedVisitor("endVisit(ParenListExpression)"); }

    public boolean visit(ObjectLiteral n) { unimplementedVisitor("visit(ObjectLiteral)"); return true; }
    public void endVisit(ObjectLiteral n) { unimplementedVisitor("endVisit(ObjectLiteral)"); }

    public boolean visit(NonemptyFieldList n) { unimplementedVisitor("visit(NonemptyFieldList)"); return true; }
    public void endVisit(NonemptyFieldList n) { unimplementedVisitor("endVisit(NonemptyFieldList)"); }

    public boolean visit(LiteralField n) { unimplementedVisitor("visit(LiteralField)"); return true; }
    public void endVisit(LiteralField n) { unimplementedVisitor("endVisit(LiteralField)"); }

    public boolean visit(ArrayLiteral n) { unimplementedVisitor("visit(ArrayLiteral)"); return true; }
    public void endVisit(ArrayLiteral n) { unimplementedVisitor("endVisit(ArrayLiteral)"); }

    public boolean visit(FullNewExpression n) { unimplementedVisitor("visit(FullNewExpression)"); return true; }
    public void endVisit(FullNewExpression n) { unimplementedVisitor("endVisit(FullNewExpression)"); }

    public boolean visit(ShortNewExpression n) { unimplementedVisitor("visit(ShortNewExpression)"); return true; }
    public void endVisit(ShortNewExpression n) { unimplementedVisitor("endVisit(ShortNewExpression)"); }

    public boolean visit(PropertyOperator n) { unimplementedVisitor("visit(PropertyOperator)"); return true; }
    public void endVisit(PropertyOperator n) { unimplementedVisitor("endVisit(PropertyOperator)"); }

    public boolean visit(ExpressionsWithRest n) { unimplementedVisitor("visit(ExpressionsWithRest)"); return true; }
    public void endVisit(ExpressionsWithRest n) { unimplementedVisitor("endVisit(ExpressionsWithRest)"); }

    public boolean visit(RestExpression n) { unimplementedVisitor("visit(RestExpression)"); return true; }
    public void endVisit(RestExpression n) { unimplementedVisitor("endVisit(RestExpression)"); }

    public boolean visit(BitwiseAndExpression_allowIn n) { unimplementedVisitor("visit(BitwiseAndExpression_allowIn)"); return true; }
    public void endVisit(BitwiseAndExpression_allowIn n) { unimplementedVisitor("endVisit(BitwiseAndExpression_allowIn)"); }

    public boolean visit(BitwiseAndExpression_noIn n) { unimplementedVisitor("visit(BitwiseAndExpression_noIn)"); return true; }
    public void endVisit(BitwiseAndExpression_noIn n) { unimplementedVisitor("endVisit(BitwiseAndExpression_noIn)"); }

    public boolean visit(BitwiseXorExpression_allowIn n) { unimplementedVisitor("visit(BitwiseXorExpression_allowIn)"); return true; }
    public void endVisit(BitwiseXorExpression_allowIn n) { unimplementedVisitor("endVisit(BitwiseXorExpression_allowIn)"); }

    public boolean visit(BitwiseXorExpression_noIn n) { unimplementedVisitor("visit(BitwiseXorExpression_noIn)"); return true; }
    public void endVisit(BitwiseXorExpression_noIn n) { unimplementedVisitor("endVisit(BitwiseXorExpression_noIn)"); }

    public boolean visit(BitwiseOrExpression_allowIn n) { unimplementedVisitor("visit(BitwiseOrExpression_allowIn)"); return true; }
    public void endVisit(BitwiseOrExpression_allowIn n) { unimplementedVisitor("endVisit(BitwiseOrExpression_allowIn)"); }

    public boolean visit(BitwiseOrExpression_noIn n) { unimplementedVisitor("visit(BitwiseOrExpression_noIn)"); return true; }
    public void endVisit(BitwiseOrExpression_noIn n) { unimplementedVisitor("endVisit(BitwiseOrExpression_noIn)"); }

    public boolean visit(LogicalAndExpression_allowIn n) { unimplementedVisitor("visit(LogicalAndExpression_allowIn)"); return true; }
    public void endVisit(LogicalAndExpression_allowIn n) { unimplementedVisitor("endVisit(LogicalAndExpression_allowIn)"); }

    public boolean visit(LogicalAndExpression_noIn n) { unimplementedVisitor("visit(LogicalAndExpression_noIn)"); return true; }
    public void endVisit(LogicalAndExpression_noIn n) { unimplementedVisitor("endVisit(LogicalAndExpression_noIn)"); }

    public boolean visit(LogicalXorExpression_allowIn n) { unimplementedVisitor("visit(LogicalXorExpression_allowIn)"); return true; }
    public void endVisit(LogicalXorExpression_allowIn n) { unimplementedVisitor("endVisit(LogicalXorExpression_allowIn)"); }

    public boolean visit(LogicalXorExpression_noIn n) { unimplementedVisitor("visit(LogicalXorExpression_noIn)"); return true; }
    public void endVisit(LogicalXorExpression_noIn n) { unimplementedVisitor("endVisit(LogicalXorExpression_noIn)"); }

    public boolean visit(LogicalOrExpression_allowIn n) { unimplementedVisitor("visit(LogicalOrExpression_allowIn)"); return true; }
    public void endVisit(LogicalOrExpression_allowIn n) { unimplementedVisitor("endVisit(LogicalOrExpression_allowIn)"); }

    public boolean visit(LogicalOrExpression_noIn n) { unimplementedVisitor("visit(LogicalOrExpression_noIn)"); return true; }
    public void endVisit(LogicalOrExpression_noIn n) { unimplementedVisitor("endVisit(LogicalOrExpression_noIn)"); }

    public boolean visit(ConditionalExpression_allowIn n) { unimplementedVisitor("visit(ConditionalExpression_allowIn)"); return true; }
    public void endVisit(ConditionalExpression_allowIn n) { unimplementedVisitor("endVisit(ConditionalExpression_allowIn)"); }

    public boolean visit(ConditionalExpression_noIn n) { unimplementedVisitor("visit(ConditionalExpression_noIn)"); return true; }
    public void endVisit(ConditionalExpression_noIn n) { unimplementedVisitor("endVisit(ConditionalExpression_noIn)"); }

    public boolean visit(NonAssignmentExpression_allowIn n) { unimplementedVisitor("visit(NonAssignmentExpression_allowIn)"); return true; }
    public void endVisit(NonAssignmentExpression_allowIn n) { unimplementedVisitor("endVisit(NonAssignmentExpression_allowIn)"); }

    public boolean visit(NonAssignmentExpression_noIn n) { unimplementedVisitor("visit(NonAssignmentExpression_noIn)"); return true; }
    public void endVisit(NonAssignmentExpression_noIn n) { unimplementedVisitor("endVisit(NonAssignmentExpression_noIn)"); }

    public boolean visit(ListExpression_allowIn n) { unimplementedVisitor("visit(ListExpression_allowIn)"); return true; }
    public void endVisit(ListExpression_allowIn n) { unimplementedVisitor("endVisit(ListExpression_allowIn)"); }

    public boolean visit(ListExpression_noIn n) { unimplementedVisitor("visit(ListExpression_noIn)"); return true; }
    public void endVisit(ListExpression_noIn n) { unimplementedVisitor("endVisit(ListExpression_noIn)"); }

    public boolean visit(Substatements n) { unimplementedVisitor("visit(Substatements)"); return true; }
    public void endVisit(Substatements n) { unimplementedVisitor("endVisit(Substatements)"); }

    public boolean visit(SubstatementsPrefix n) { unimplementedVisitor("visit(SubstatementsPrefix)"); return true; }
    public void endVisit(SubstatementsPrefix n) { unimplementedVisitor("endVisit(SubstatementsPrefix)"); }

    public boolean visit(EmptyStatement n) { unimplementedVisitor("visit(EmptyStatement)"); return true; }
    public void endVisit(EmptyStatement n) { unimplementedVisitor("endVisit(EmptyStatement)"); }

    public boolean visit(SuperStatement n) { unimplementedVisitor("visit(SuperStatement)"); return true; }
    public void endVisit(SuperStatement n) { unimplementedVisitor("endVisit(SuperStatement)"); }

    public boolean visit(Block n) { unimplementedVisitor("visit(Block)"); return true; }
    public void endVisit(Block n) { unimplementedVisitor("endVisit(Block)"); }

    public boolean visit(LabeledStatement_abbrev n) { unimplementedVisitor("visit(LabeledStatement_abbrev)"); return true; }
    public void endVisit(LabeledStatement_abbrev n) { unimplementedVisitor("endVisit(LabeledStatement_abbrev)"); }

    public boolean visit(LabeledStatement_noShortIf n) { unimplementedVisitor("visit(LabeledStatement_noShortIf)"); return true; }
    public void endVisit(LabeledStatement_noShortIf n) { unimplementedVisitor("endVisit(LabeledStatement_noShortIf)"); }

    public boolean visit(LabeledStatement_full n) { unimplementedVisitor("visit(LabeledStatement_full)"); return true; }
    public void endVisit(LabeledStatement_full n) { unimplementedVisitor("endVisit(LabeledStatement_full)"); }

    public boolean visit(IfStatement_noShortIf n) { unimplementedVisitor("visit(IfStatement_noShortIf)"); return true; }
    public void endVisit(IfStatement_noShortIf n) { unimplementedVisitor("endVisit(IfStatement_noShortIf)"); }

    public boolean visit(SwitchStatement n) { unimplementedVisitor("visit(SwitchStatement)"); return true; }
    public void endVisit(SwitchStatement n) { unimplementedVisitor("endVisit(SwitchStatement)"); }

    public boolean visit(CaseElements n) { unimplementedVisitor("visit(CaseElements)"); return true; }
    public void endVisit(CaseElements n) { unimplementedVisitor("endVisit(CaseElements)"); }

    public boolean visit(CaseElementsPrefix n) { unimplementedVisitor("visit(CaseElementsPrefix)"); return true; }
    public void endVisit(CaseElementsPrefix n) { unimplementedVisitor("endVisit(CaseElementsPrefix)"); }

    public boolean visit(DoStatement n) { unimplementedVisitor("visit(DoStatement)"); return true; }
    public void endVisit(DoStatement n) { unimplementedVisitor("endVisit(DoStatement)"); }

    public boolean visit(WhileStatement_abbrev n) { unimplementedVisitor("visit(WhileStatement_abbrev)"); return true; }
    public void endVisit(WhileStatement_abbrev n) { unimplementedVisitor("endVisit(WhileStatement_abbrev)"); }

    public boolean visit(WhileStatement_noShortIf n) { unimplementedVisitor("visit(WhileStatement_noShortIf)"); return true; }
    public void endVisit(WhileStatement_noShortIf n) { unimplementedVisitor("endVisit(WhileStatement_noShortIf)"); }

    public boolean visit(WhileStatement_full n) { unimplementedVisitor("visit(WhileStatement_full)"); return true; }
    public void endVisit(WhileStatement_full n) { unimplementedVisitor("endVisit(WhileStatement_full)"); }

    public boolean visit(ForInitializer n) { unimplementedVisitor("visit(ForInitializer)"); return true; }
    public void endVisit(ForInitializer n) { unimplementedVisitor("endVisit(ForInitializer)"); }

    public boolean visit(WithStatement_abbrev n) { unimplementedVisitor("visit(WithStatement_abbrev)"); return true; }
    public void endVisit(WithStatement_abbrev n) { unimplementedVisitor("endVisit(WithStatement_abbrev)"); }

    public boolean visit(WithStatement_noShortIf n) { unimplementedVisitor("visit(WithStatement_noShortIf)"); return true; }
    public void endVisit(WithStatement_noShortIf n) { unimplementedVisitor("endVisit(WithStatement_noShortIf)"); }

    public boolean visit(WithStatement_full n) { unimplementedVisitor("visit(WithStatement_full)"); return true; }
    public void endVisit(WithStatement_full n) { unimplementedVisitor("endVisit(WithStatement_full)"); }

    public boolean visit(ThrowStatement n) { unimplementedVisitor("visit(ThrowStatement)"); return true; }
    public void endVisit(ThrowStatement n) { unimplementedVisitor("endVisit(ThrowStatement)"); }

    public boolean visit(CatchClauses n) { unimplementedVisitor("visit(CatchClauses)"); return true; }
    public void endVisit(CatchClauses n) { unimplementedVisitor("endVisit(CatchClauses)"); }

    public boolean visit(CatchClause n) { unimplementedVisitor("visit(CatchClause)"); return true; }
    public void endVisit(CatchClause n) { unimplementedVisitor("endVisit(CatchClause)"); }

    public boolean visit(Directives n) { unimplementedVisitor("visit(Directives)"); return true; }
    public void endVisit(Directives n) { unimplementedVisitor("endVisit(Directives)"); }

    public boolean visit(DirectivesPrefix n) { unimplementedVisitor("visit(DirectivesPrefix)"); return true; }
    public void endVisit(DirectivesPrefix n) { unimplementedVisitor("endVisit(DirectivesPrefix)"); }

    public boolean visit(AttributeCombination n) { unimplementedVisitor("visit(AttributeCombination)"); return true; }
    public void endVisit(AttributeCombination n) { unimplementedVisitor("endVisit(AttributeCombination)"); }

    public boolean visit(UseDirective n) { unimplementedVisitor("visit(UseDirective)"); return true; }
    public void endVisit(UseDirective n) { unimplementedVisitor("endVisit(UseDirective)"); }

    public boolean visit(IncludeDirective n) { unimplementedVisitor("visit(IncludeDirective)"); return true; }
    public void endVisit(IncludeDirective n) { unimplementedVisitor("endVisit(IncludeDirective)"); }

    public boolean visit(Pragma n) { unimplementedVisitor("visit(Pragma)"); return true; }
    public void endVisit(Pragma n) { unimplementedVisitor("endVisit(Pragma)"); }

    public boolean visit(PragmaItems n) { unimplementedVisitor("visit(PragmaItems)"); return true; }
    public void endVisit(PragmaItems n) { unimplementedVisitor("endVisit(PragmaItems)"); }

    public boolean visit(PragmaItem n) { unimplementedVisitor("visit(PragmaItem)"); return true; }
    public void endVisit(PragmaItem n) { unimplementedVisitor("endVisit(PragmaItem)"); }

    public boolean visit(PragmaExpr n) { unimplementedVisitor("visit(PragmaExpr)"); return true; }
    public void endVisit(PragmaExpr n) { unimplementedVisitor("endVisit(PragmaExpr)"); }

    public boolean visit(ExportDefinition n) { unimplementedVisitor("visit(ExportDefinition)"); return true; }
    public void endVisit(ExportDefinition n) { unimplementedVisitor("endVisit(ExportDefinition)"); }

    public boolean visit(ExportBindingList n) { unimplementedVisitor("visit(ExportBindingList)"); return true; }
    public void endVisit(ExportBindingList n) { unimplementedVisitor("endVisit(ExportBindingList)"); }

    public boolean visit(ExportBinding n) { unimplementedVisitor("visit(ExportBinding)"); return true; }
    public void endVisit(ExportBinding n) { unimplementedVisitor("endVisit(ExportBinding)"); }

    public boolean visit(VariableDefinition_allowIn n) { unimplementedVisitor("visit(VariableDefinition_allowIn)"); return true; }
    public void endVisit(VariableDefinition_allowIn n) { unimplementedVisitor("endVisit(VariableDefinition_allowIn)"); }

    public boolean visit(VariableDefinition_noIn n) { unimplementedVisitor("visit(VariableDefinition_noIn)"); return true; }
    public void endVisit(VariableDefinition_noIn n) { unimplementedVisitor("endVisit(VariableDefinition_noIn)"); }

    public boolean visit(VariableBindingList_allowIn n) { unimplementedVisitor("visit(VariableBindingList_allowIn)"); return true; }
    public void endVisit(VariableBindingList_allowIn n) { unimplementedVisitor("endVisit(VariableBindingList_allowIn)"); }

    public boolean visit(VariableBindingList_noIn n) { unimplementedVisitor("visit(VariableBindingList_noIn)"); return true; }
    public void endVisit(VariableBindingList_noIn n) { unimplementedVisitor("endVisit(VariableBindingList_noIn)"); }

    public boolean visit(VariableBinding_allowIn n) { unimplementedVisitor("visit(VariableBinding_allowIn)"); return true; }
    public void endVisit(VariableBinding_allowIn n) { unimplementedVisitor("endVisit(VariableBinding_allowIn)"); }

    public boolean visit(VariableBinding_noIn n) { unimplementedVisitor("visit(VariableBinding_noIn)"); return true; }
    public void endVisit(VariableBinding_noIn n) { unimplementedVisitor("endVisit(VariableBinding_noIn)"); }

    public boolean visit(VariableInitialisation_allowIn n) { unimplementedVisitor("visit(VariableInitialisation_allowIn)"); return true; }
    public void endVisit(VariableInitialisation_allowIn n) { unimplementedVisitor("endVisit(VariableInitialisation_allowIn)"); }

    public boolean visit(VariableInitialisation_noIn n) { unimplementedVisitor("visit(VariableInitialisation_noIn)"); return true; }
    public void endVisit(VariableInitialisation_noIn n) { unimplementedVisitor("endVisit(VariableInitialisation_noIn)"); }

    public boolean visit(TypedIdentifier_allowIn n) { unimplementedVisitor("visit(TypedIdentifier_allowIn)"); return true; }
    public void endVisit(TypedIdentifier_allowIn n) { unimplementedVisitor("endVisit(TypedIdentifier_allowIn)"); }

    public boolean visit(TypedIdentifier_noIn n) { unimplementedVisitor("visit(TypedIdentifier_noIn)"); return true; }
    public void endVisit(TypedIdentifier_noIn n) { unimplementedVisitor("endVisit(TypedIdentifier_noIn)"); }

    public boolean visit(SimpleVariableDefinition n) { unimplementedVisitor("visit(SimpleVariableDefinition)"); return true; }
    public void endVisit(SimpleVariableDefinition n) { unimplementedVisitor("endVisit(SimpleVariableDefinition)"); }

    public boolean visit(UntypedVariableBindingList n) { unimplementedVisitor("visit(UntypedVariableBindingList)"); return true; }
    public void endVisit(UntypedVariableBindingList n) { unimplementedVisitor("endVisit(UntypedVariableBindingList)"); }

    public boolean visit(UntypedVariableBinding n) { unimplementedVisitor("visit(UntypedVariableBinding)"); return true; }
    public void endVisit(UntypedVariableBinding n) { unimplementedVisitor("endVisit(UntypedVariableBinding)"); }

    public boolean visit(FunctionDefinition n) { unimplementedVisitor("visit(FunctionDefinition)"); return true; }
    public void endVisit(FunctionDefinition n) { unimplementedVisitor("endVisit(FunctionDefinition)"); }

    public boolean visit(FunctionCommon n) { unimplementedVisitor("visit(FunctionCommon)"); return true; }
    public void endVisit(FunctionCommon n) { unimplementedVisitor("endVisit(FunctionCommon)"); }

    public boolean visit(NonemptyParameters n) { unimplementedVisitor("visit(NonemptyParameters)"); return true; }
    public void endVisit(NonemptyParameters n) { unimplementedVisitor("endVisit(NonemptyParameters)"); }

    public boolean visit(ParameterInitList n) { unimplementedVisitor("visit(ParameterInitList)"); return true; }
    public void endVisit(ParameterInitList n) { unimplementedVisitor("endVisit(ParameterInitList)"); }

    public boolean visit(Parameter n) { unimplementedVisitor("visit(Parameter)"); return true; }
    public void endVisit(Parameter n) { unimplementedVisitor("endVisit(Parameter)"); }

    public boolean visit(ParameterAttributes n) { unimplementedVisitor("visit(ParameterAttributes)"); return true; }
    public void endVisit(ParameterAttributes n) { unimplementedVisitor("endVisit(ParameterAttributes)"); }

    public boolean visit(ParameterInit n) { unimplementedVisitor("visit(ParameterInit)"); return true; }
    public void endVisit(ParameterInit n) { unimplementedVisitor("endVisit(ParameterInit)"); }

    public boolean visit(Result n) { unimplementedVisitor("visit(Result)"); return true; }
    public void endVisit(Result n) { unimplementedVisitor("endVisit(Result)"); }

    public boolean visit(ClassDefinition n) { unimplementedVisitor("visit(ClassDefinition)"); return true; }
    public void endVisit(ClassDefinition n) { unimplementedVisitor("endVisit(ClassDefinition)"); }

    public boolean visit(Inheritance n) { unimplementedVisitor("visit(Inheritance)"); return true; }
    public void endVisit(Inheritance n) { unimplementedVisitor("endVisit(Inheritance)"); }

    public boolean visit(NamespaceDefinition n) { unimplementedVisitor("visit(NamespaceDefinition)"); return true; }
    public void endVisit(NamespaceDefinition n) { unimplementedVisitor("endVisit(NamespaceDefinition)"); }

    public boolean visit(Program n) { unimplementedVisitor("visit(Program)"); return true; }
    public void endVisit(Program n) { unimplementedVisitor("endVisit(Program)"); }

    public boolean visit(PackageDefinitionList n) { unimplementedVisitor("visit(PackageDefinitionList)"); return true; }
    public void endVisit(PackageDefinitionList n) { unimplementedVisitor("endVisit(PackageDefinitionList)"); }

    public boolean visit(PackageDefinition n) { unimplementedVisitor("visit(PackageDefinition)"); return true; }
    public void endVisit(PackageDefinition n) { unimplementedVisitor("endVisit(PackageDefinition)"); }

    public boolean visit(PackageName n) { unimplementedVisitor("visit(PackageName)"); return true; }
    public void endVisit(PackageName n) { unimplementedVisitor("endVisit(PackageName)"); }

    public boolean visit(PackageIdentifiers n) { unimplementedVisitor("visit(PackageIdentifiers)"); return true; }
    public void endVisit(PackageIdentifiers n) { unimplementedVisitor("endVisit(PackageIdentifiers)"); }

    public boolean visit(ExpressionStatement n) { unimplementedVisitor("visit(ExpressionStatement)"); return true; }
    public void endVisit(ExpressionStatement n) { unimplementedVisitor("endVisit(ExpressionStatement)"); }

    public boolean visit(ES_BitwiseAndExpression_allowIn n) { unimplementedVisitor("visit(ES_BitwiseAndExpression_allowIn)"); return true; }
    public void endVisit(ES_BitwiseAndExpression_allowIn n) { unimplementedVisitor("endVisit(ES_BitwiseAndExpression_allowIn)"); }

    public boolean visit(ES_BitwiseXorExpression_allowIn n) { unimplementedVisitor("visit(ES_BitwiseXorExpression_allowIn)"); return true; }
    public void endVisit(ES_BitwiseXorExpression_allowIn n) { unimplementedVisitor("endVisit(ES_BitwiseXorExpression_allowIn)"); }

    public boolean visit(ES_BitwiseOrExpression_allowIn n) { unimplementedVisitor("visit(ES_BitwiseOrExpression_allowIn)"); return true; }
    public void endVisit(ES_BitwiseOrExpression_allowIn n) { unimplementedVisitor("endVisit(ES_BitwiseOrExpression_allowIn)"); }

    public boolean visit(ES_LogicalAndExpression_allowIn n) { unimplementedVisitor("visit(ES_LogicalAndExpression_allowIn)"); return true; }
    public void endVisit(ES_LogicalAndExpression_allowIn n) { unimplementedVisitor("endVisit(ES_LogicalAndExpression_allowIn)"); }

    public boolean visit(ES_LogicalXorExpression_allowIn n) { unimplementedVisitor("visit(ES_LogicalXorExpression_allowIn)"); return true; }
    public void endVisit(ES_LogicalXorExpression_allowIn n) { unimplementedVisitor("endVisit(ES_LogicalXorExpression_allowIn)"); }

    public boolean visit(ES_LogicalOrExpression_allowIn n) { unimplementedVisitor("visit(ES_LogicalOrExpression_allowIn)"); return true; }
    public void endVisit(ES_LogicalOrExpression_allowIn n) { unimplementedVisitor("endVisit(ES_LogicalOrExpression_allowIn)"); }

    public boolean visit(ES_ConditionalExpression_allowIn n) { unimplementedVisitor("visit(ES_ConditionalExpression_allowIn)"); return true; }
    public void endVisit(ES_ConditionalExpression_allowIn n) { unimplementedVisitor("endVisit(ES_ConditionalExpression_allowIn)"); }

    public boolean visit(Identifier0 n) { unimplementedVisitor("visit(Identifier0)"); return true; }
    public void endVisit(Identifier0 n) { unimplementedVisitor("endVisit(Identifier0)"); }

    public boolean visit(Identifier1 n) { unimplementedVisitor("visit(Identifier1)"); return true; }
    public void endVisit(Identifier1 n) { unimplementedVisitor("endVisit(Identifier1)"); }

    public boolean visit(Identifier2 n) { unimplementedVisitor("visit(Identifier2)"); return true; }
    public void endVisit(Identifier2 n) { unimplementedVisitor("endVisit(Identifier2)"); }

    public boolean visit(Identifier3 n) { unimplementedVisitor("visit(Identifier3)"); return true; }
    public void endVisit(Identifier3 n) { unimplementedVisitor("endVisit(Identifier3)"); }

    public boolean visit(SimpleQualifiedIdentifier0 n) { unimplementedVisitor("visit(SimpleQualifiedIdentifier0)"); return true; }
    public void endVisit(SimpleQualifiedIdentifier0 n) { unimplementedVisitor("endVisit(SimpleQualifiedIdentifier0)"); }

    public boolean visit(SimpleQualifiedIdentifier1 n) { unimplementedVisitor("visit(SimpleQualifiedIdentifier1)"); return true; }
    public void endVisit(SimpleQualifiedIdentifier1 n) { unimplementedVisitor("endVisit(SimpleQualifiedIdentifier1)"); }

    public boolean visit(PrimaryExpression0 n) { unimplementedVisitor("visit(PrimaryExpression0)"); return true; }
    public void endVisit(PrimaryExpression0 n) { unimplementedVisitor("endVisit(PrimaryExpression0)"); }

    public boolean visit(PrimaryExpression1 n) { unimplementedVisitor("visit(PrimaryExpression1)"); return true; }
    public void endVisit(PrimaryExpression1 n) { unimplementedVisitor("endVisit(PrimaryExpression1)"); }

    public boolean visit(PrimaryExpression2 n) { unimplementedVisitor("visit(PrimaryExpression2)"); return true; }
    public void endVisit(PrimaryExpression2 n) { unimplementedVisitor("endVisit(PrimaryExpression2)"); }

    public boolean visit(PrimaryExpression3 n) { unimplementedVisitor("visit(PrimaryExpression3)"); return true; }
    public void endVisit(PrimaryExpression3 n) { unimplementedVisitor("endVisit(PrimaryExpression3)"); }

    public boolean visit(PrimaryExpression4 n) { unimplementedVisitor("visit(PrimaryExpression4)"); return true; }
    public void endVisit(PrimaryExpression4 n) { unimplementedVisitor("endVisit(PrimaryExpression4)"); }

    public boolean visit(PrimaryExpression5 n) { unimplementedVisitor("visit(PrimaryExpression5)"); return true; }
    public void endVisit(PrimaryExpression5 n) { unimplementedVisitor("endVisit(PrimaryExpression5)"); }

    public boolean visit(PrimaryExpression6 n) { unimplementedVisitor("visit(PrimaryExpression6)"); return true; }
    public void endVisit(PrimaryExpression6 n) { unimplementedVisitor("endVisit(PrimaryExpression6)"); }

    public boolean visit(ReservedNamespace0 n) { unimplementedVisitor("visit(ReservedNamespace0)"); return true; }
    public void endVisit(ReservedNamespace0 n) { unimplementedVisitor("endVisit(ReservedNamespace0)"); }

    public boolean visit(ReservedNamespace1 n) { unimplementedVisitor("visit(ReservedNamespace1)"); return true; }
    public void endVisit(ReservedNamespace1 n) { unimplementedVisitor("endVisit(ReservedNamespace1)"); }

    public boolean visit(FunctionExpression0 n) { unimplementedVisitor("visit(FunctionExpression0)"); return true; }
    public void endVisit(FunctionExpression0 n) { unimplementedVisitor("endVisit(FunctionExpression0)"); }

    public boolean visit(FunctionExpression1 n) { unimplementedVisitor("visit(FunctionExpression1)"); return true; }
    public void endVisit(FunctionExpression1 n) { unimplementedVisitor("endVisit(FunctionExpression1)"); }

    public boolean visit(FieldName0 n) { unimplementedVisitor("visit(FieldName0)"); return true; }
    public void endVisit(FieldName0 n) { unimplementedVisitor("endVisit(FieldName0)"); }

    public boolean visit(FieldName1 n) { unimplementedVisitor("visit(FieldName1)"); return true; }
    public void endVisit(FieldName1 n) { unimplementedVisitor("endVisit(FieldName1)"); }

    public boolean visit(ElementList0 n) { unimplementedVisitor("visit(ElementList0)"); return true; }
    public void endVisit(ElementList0 n) { unimplementedVisitor("endVisit(ElementList0)"); }

    public boolean visit(ElementList1 n) { unimplementedVisitor("visit(ElementList1)"); return true; }
    public void endVisit(ElementList1 n) { unimplementedVisitor("endVisit(ElementList1)"); }

    public boolean visit(SuperExpression0 n) { unimplementedVisitor("visit(SuperExpression0)"); return true; }
    public void endVisit(SuperExpression0 n) { unimplementedVisitor("endVisit(SuperExpression0)"); }

    public boolean visit(SuperExpression1 n) { unimplementedVisitor("visit(SuperExpression1)"); return true; }
    public void endVisit(SuperExpression1 n) { unimplementedVisitor("endVisit(SuperExpression1)"); }

    public boolean visit(AttributeExpression0 n) { unimplementedVisitor("visit(AttributeExpression0)"); return true; }
    public void endVisit(AttributeExpression0 n) { unimplementedVisitor("endVisit(AttributeExpression0)"); }

    public boolean visit(AttributeExpression1 n) { unimplementedVisitor("visit(AttributeExpression1)"); return true; }
    public void endVisit(AttributeExpression1 n) { unimplementedVisitor("endVisit(AttributeExpression1)"); }

    public boolean visit(FullPostfixExpression0 n) { unimplementedVisitor("visit(FullPostfixExpression0)"); return true; }
    public void endVisit(FullPostfixExpression0 n) { unimplementedVisitor("endVisit(FullPostfixExpression0)"); }

    public boolean visit(FullPostfixExpression1 n) { unimplementedVisitor("visit(FullPostfixExpression1)"); return true; }
    public void endVisit(FullPostfixExpression1 n) { unimplementedVisitor("endVisit(FullPostfixExpression1)"); }

    public boolean visit(FullPostfixExpression2 n) { unimplementedVisitor("visit(FullPostfixExpression2)"); return true; }
    public void endVisit(FullPostfixExpression2 n) { unimplementedVisitor("endVisit(FullPostfixExpression2)"); }

    public boolean visit(FullPostfixExpression3 n) { unimplementedVisitor("visit(FullPostfixExpression3)"); return true; }
    public void endVisit(FullPostfixExpression3 n) { unimplementedVisitor("endVisit(FullPostfixExpression3)"); }

    public boolean visit(FullPostfixExpression4 n) { unimplementedVisitor("visit(FullPostfixExpression4)"); return true; }
    public void endVisit(FullPostfixExpression4 n) { unimplementedVisitor("endVisit(FullPostfixExpression4)"); }

    public boolean visit(FullNewSubexpression0 n) { unimplementedVisitor("visit(FullNewSubexpression0)"); return true; }
    public void endVisit(FullNewSubexpression0 n) { unimplementedVisitor("endVisit(FullNewSubexpression0)"); }

    public boolean visit(FullNewSubexpression1 n) { unimplementedVisitor("visit(FullNewSubexpression1)"); return true; }
    public void endVisit(FullNewSubexpression1 n) { unimplementedVisitor("endVisit(FullNewSubexpression1)"); }

    public boolean visit(Brackets0 n) { unimplementedVisitor("visit(Brackets0)"); return true; }
    public void endVisit(Brackets0 n) { unimplementedVisitor("endVisit(Brackets0)"); }

    public boolean visit(Brackets1 n) { unimplementedVisitor("visit(Brackets1)"); return true; }
    public void endVisit(Brackets1 n) { unimplementedVisitor("endVisit(Brackets1)"); }

    public boolean visit(Brackets2 n) { unimplementedVisitor("visit(Brackets2)"); return true; }
    public void endVisit(Brackets2 n) { unimplementedVisitor("endVisit(Brackets2)"); }

    public boolean visit(Arguments0 n) { unimplementedVisitor("visit(Arguments0)"); return true; }
    public void endVisit(Arguments0 n) { unimplementedVisitor("endVisit(Arguments0)"); }

    public boolean visit(Arguments1 n) { unimplementedVisitor("visit(Arguments1)"); return true; }
    public void endVisit(Arguments1 n) { unimplementedVisitor("endVisit(Arguments1)"); }

    public boolean visit(UnaryExpression0 n) { unimplementedVisitor("visit(UnaryExpression0)"); return true; }
    public void endVisit(UnaryExpression0 n) { unimplementedVisitor("endVisit(UnaryExpression0)"); }

    public boolean visit(UnaryExpression1 n) { unimplementedVisitor("visit(UnaryExpression1)"); return true; }
    public void endVisit(UnaryExpression1 n) { unimplementedVisitor("endVisit(UnaryExpression1)"); }

    public boolean visit(UnaryExpression2 n) { unimplementedVisitor("visit(UnaryExpression2)"); return true; }
    public void endVisit(UnaryExpression2 n) { unimplementedVisitor("endVisit(UnaryExpression2)"); }

    public boolean visit(UnaryExpression3 n) { unimplementedVisitor("visit(UnaryExpression3)"); return true; }
    public void endVisit(UnaryExpression3 n) { unimplementedVisitor("endVisit(UnaryExpression3)"); }

    public boolean visit(UnaryExpression4 n) { unimplementedVisitor("visit(UnaryExpression4)"); return true; }
    public void endVisit(UnaryExpression4 n) { unimplementedVisitor("endVisit(UnaryExpression4)"); }

    public boolean visit(UnaryExpression5 n) { unimplementedVisitor("visit(UnaryExpression5)"); return true; }
    public void endVisit(UnaryExpression5 n) { unimplementedVisitor("endVisit(UnaryExpression5)"); }

    public boolean visit(UnaryExpression6 n) { unimplementedVisitor("visit(UnaryExpression6)"); return true; }
    public void endVisit(UnaryExpression6 n) { unimplementedVisitor("endVisit(UnaryExpression6)"); }

    public boolean visit(UnaryExpression7 n) { unimplementedVisitor("visit(UnaryExpression7)"); return true; }
    public void endVisit(UnaryExpression7 n) { unimplementedVisitor("endVisit(UnaryExpression7)"); }

    public boolean visit(UnaryExpression8 n) { unimplementedVisitor("visit(UnaryExpression8)"); return true; }
    public void endVisit(UnaryExpression8 n) { unimplementedVisitor("endVisit(UnaryExpression8)"); }

    public boolean visit(UnaryExpression9 n) { unimplementedVisitor("visit(UnaryExpression9)"); return true; }
    public void endVisit(UnaryExpression9 n) { unimplementedVisitor("endVisit(UnaryExpression9)"); }

    public boolean visit(MultiplicativeExpression0 n) { unimplementedVisitor("visit(MultiplicativeExpression0)"); return true; }
    public void endVisit(MultiplicativeExpression0 n) { unimplementedVisitor("endVisit(MultiplicativeExpression0)"); }

    public boolean visit(MultiplicativeExpression1 n) { unimplementedVisitor("visit(MultiplicativeExpression1)"); return true; }
    public void endVisit(MultiplicativeExpression1 n) { unimplementedVisitor("endVisit(MultiplicativeExpression1)"); }

    public boolean visit(MultiplicativeExpression2 n) { unimplementedVisitor("visit(MultiplicativeExpression2)"); return true; }
    public void endVisit(MultiplicativeExpression2 n) { unimplementedVisitor("endVisit(MultiplicativeExpression2)"); }

    public boolean visit(AdditiveExpression0 n) { unimplementedVisitor("visit(AdditiveExpression0)"); return true; }
    public void endVisit(AdditiveExpression0 n) { unimplementedVisitor("endVisit(AdditiveExpression0)"); }

    public boolean visit(AdditiveExpression1 n) { unimplementedVisitor("visit(AdditiveExpression1)"); return true; }
    public void endVisit(AdditiveExpression1 n) { unimplementedVisitor("endVisit(AdditiveExpression1)"); }

    public boolean visit(ShiftExpression0 n) { unimplementedVisitor("visit(ShiftExpression0)"); return true; }
    public void endVisit(ShiftExpression0 n) { unimplementedVisitor("endVisit(ShiftExpression0)"); }

    public boolean visit(ShiftExpression1 n) { unimplementedVisitor("visit(ShiftExpression1)"); return true; }
    public void endVisit(ShiftExpression1 n) { unimplementedVisitor("endVisit(ShiftExpression1)"); }

    public boolean visit(ShiftExpression2 n) { unimplementedVisitor("visit(ShiftExpression2)"); return true; }
    public void endVisit(ShiftExpression2 n) { unimplementedVisitor("endVisit(ShiftExpression2)"); }

    public boolean visit(RelationalExpression_allowIn0 n) { unimplementedVisitor("visit(RelationalExpression_allowIn0)"); return true; }
    public void endVisit(RelationalExpression_allowIn0 n) { unimplementedVisitor("endVisit(RelationalExpression_allowIn0)"); }

    public boolean visit(RelationalExpression_allowIn1 n) { unimplementedVisitor("visit(RelationalExpression_allowIn1)"); return true; }
    public void endVisit(RelationalExpression_allowIn1 n) { unimplementedVisitor("endVisit(RelationalExpression_allowIn1)"); }

    public boolean visit(RelationalExpression_allowIn2 n) { unimplementedVisitor("visit(RelationalExpression_allowIn2)"); return true; }
    public void endVisit(RelationalExpression_allowIn2 n) { unimplementedVisitor("endVisit(RelationalExpression_allowIn2)"); }

    public boolean visit(RelationalExpression_allowIn3 n) { unimplementedVisitor("visit(RelationalExpression_allowIn3)"); return true; }
    public void endVisit(RelationalExpression_allowIn3 n) { unimplementedVisitor("endVisit(RelationalExpression_allowIn3)"); }

    public boolean visit(RelationalExpression_allowIn4 n) { unimplementedVisitor("visit(RelationalExpression_allowIn4)"); return true; }
    public void endVisit(RelationalExpression_allowIn4 n) { unimplementedVisitor("endVisit(RelationalExpression_allowIn4)"); }

    public boolean visit(RelationalExpression_allowIn5 n) { unimplementedVisitor("visit(RelationalExpression_allowIn5)"); return true; }
    public void endVisit(RelationalExpression_allowIn5 n) { unimplementedVisitor("endVisit(RelationalExpression_allowIn5)"); }

    public boolean visit(RelationalExpression_allowIn6 n) { unimplementedVisitor("visit(RelationalExpression_allowIn6)"); return true; }
    public void endVisit(RelationalExpression_allowIn6 n) { unimplementedVisitor("endVisit(RelationalExpression_allowIn6)"); }

    public boolean visit(RelationalExpression_allowIn7 n) { unimplementedVisitor("visit(RelationalExpression_allowIn7)"); return true; }
    public void endVisit(RelationalExpression_allowIn7 n) { unimplementedVisitor("endVisit(RelationalExpression_allowIn7)"); }

    public boolean visit(RelationalExpression_noIn0 n) { unimplementedVisitor("visit(RelationalExpression_noIn0)"); return true; }
    public void endVisit(RelationalExpression_noIn0 n) { unimplementedVisitor("endVisit(RelationalExpression_noIn0)"); }

    public boolean visit(RelationalExpression_noIn1 n) { unimplementedVisitor("visit(RelationalExpression_noIn1)"); return true; }
    public void endVisit(RelationalExpression_noIn1 n) { unimplementedVisitor("endVisit(RelationalExpression_noIn1)"); }

    public boolean visit(RelationalExpression_noIn2 n) { unimplementedVisitor("visit(RelationalExpression_noIn2)"); return true; }
    public void endVisit(RelationalExpression_noIn2 n) { unimplementedVisitor("endVisit(RelationalExpression_noIn2)"); }

    public boolean visit(RelationalExpression_noIn3 n) { unimplementedVisitor("visit(RelationalExpression_noIn3)"); return true; }
    public void endVisit(RelationalExpression_noIn3 n) { unimplementedVisitor("endVisit(RelationalExpression_noIn3)"); }

    public boolean visit(RelationalExpression_noIn4 n) { unimplementedVisitor("visit(RelationalExpression_noIn4)"); return true; }
    public void endVisit(RelationalExpression_noIn4 n) { unimplementedVisitor("endVisit(RelationalExpression_noIn4)"); }

    public boolean visit(RelationalExpression_noIn5 n) { unimplementedVisitor("visit(RelationalExpression_noIn5)"); return true; }
    public void endVisit(RelationalExpression_noIn5 n) { unimplementedVisitor("endVisit(RelationalExpression_noIn5)"); }

    public boolean visit(RelationalExpression_noIn6 n) { unimplementedVisitor("visit(RelationalExpression_noIn6)"); return true; }
    public void endVisit(RelationalExpression_noIn6 n) { unimplementedVisitor("endVisit(RelationalExpression_noIn6)"); }

    public boolean visit(EqualityExpression_allowIn0 n) { unimplementedVisitor("visit(EqualityExpression_allowIn0)"); return true; }
    public void endVisit(EqualityExpression_allowIn0 n) { unimplementedVisitor("endVisit(EqualityExpression_allowIn0)"); }

    public boolean visit(EqualityExpression_allowIn1 n) { unimplementedVisitor("visit(EqualityExpression_allowIn1)"); return true; }
    public void endVisit(EqualityExpression_allowIn1 n) { unimplementedVisitor("endVisit(EqualityExpression_allowIn1)"); }

    public boolean visit(EqualityExpression_allowIn2 n) { unimplementedVisitor("visit(EqualityExpression_allowIn2)"); return true; }
    public void endVisit(EqualityExpression_allowIn2 n) { unimplementedVisitor("endVisit(EqualityExpression_allowIn2)"); }

    public boolean visit(EqualityExpression_allowIn3 n) { unimplementedVisitor("visit(EqualityExpression_allowIn3)"); return true; }
    public void endVisit(EqualityExpression_allowIn3 n) { unimplementedVisitor("endVisit(EqualityExpression_allowIn3)"); }

    public boolean visit(EqualityExpression_noIn0 n) { unimplementedVisitor("visit(EqualityExpression_noIn0)"); return true; }
    public void endVisit(EqualityExpression_noIn0 n) { unimplementedVisitor("endVisit(EqualityExpression_noIn0)"); }

    public boolean visit(EqualityExpression_noIn1 n) { unimplementedVisitor("visit(EqualityExpression_noIn1)"); return true; }
    public void endVisit(EqualityExpression_noIn1 n) { unimplementedVisitor("endVisit(EqualityExpression_noIn1)"); }

    public boolean visit(EqualityExpression_noIn2 n) { unimplementedVisitor("visit(EqualityExpression_noIn2)"); return true; }
    public void endVisit(EqualityExpression_noIn2 n) { unimplementedVisitor("endVisit(EqualityExpression_noIn2)"); }

    public boolean visit(EqualityExpression_noIn3 n) { unimplementedVisitor("visit(EqualityExpression_noIn3)"); return true; }
    public void endVisit(EqualityExpression_noIn3 n) { unimplementedVisitor("endVisit(EqualityExpression_noIn3)"); }

    public boolean visit(AssignmentExpression_allowIn0 n) { unimplementedVisitor("visit(AssignmentExpression_allowIn0)"); return true; }
    public void endVisit(AssignmentExpression_allowIn0 n) { unimplementedVisitor("endVisit(AssignmentExpression_allowIn0)"); }

    public boolean visit(AssignmentExpression_allowIn1 n) { unimplementedVisitor("visit(AssignmentExpression_allowIn1)"); return true; }
    public void endVisit(AssignmentExpression_allowIn1 n) { unimplementedVisitor("endVisit(AssignmentExpression_allowIn1)"); }

    public boolean visit(AssignmentExpression_allowIn2 n) { unimplementedVisitor("visit(AssignmentExpression_allowIn2)"); return true; }
    public void endVisit(AssignmentExpression_allowIn2 n) { unimplementedVisitor("endVisit(AssignmentExpression_allowIn2)"); }

    public boolean visit(AssignmentExpression_noIn0 n) { unimplementedVisitor("visit(AssignmentExpression_noIn0)"); return true; }
    public void endVisit(AssignmentExpression_noIn0 n) { unimplementedVisitor("endVisit(AssignmentExpression_noIn0)"); }

    public boolean visit(AssignmentExpression_noIn1 n) { unimplementedVisitor("visit(AssignmentExpression_noIn1)"); return true; }
    public void endVisit(AssignmentExpression_noIn1 n) { unimplementedVisitor("endVisit(AssignmentExpression_noIn1)"); }

    public boolean visit(AssignmentExpression_noIn2 n) { unimplementedVisitor("visit(AssignmentExpression_noIn2)"); return true; }
    public void endVisit(AssignmentExpression_noIn2 n) { unimplementedVisitor("endVisit(AssignmentExpression_noIn2)"); }

    public boolean visit(CompoundAssignment0 n) { unimplementedVisitor("visit(CompoundAssignment0)"); return true; }
    public void endVisit(CompoundAssignment0 n) { unimplementedVisitor("endVisit(CompoundAssignment0)"); }

    public boolean visit(CompoundAssignment1 n) { unimplementedVisitor("visit(CompoundAssignment1)"); return true; }
    public void endVisit(CompoundAssignment1 n) { unimplementedVisitor("endVisit(CompoundAssignment1)"); }

    public boolean visit(CompoundAssignment2 n) { unimplementedVisitor("visit(CompoundAssignment2)"); return true; }
    public void endVisit(CompoundAssignment2 n) { unimplementedVisitor("endVisit(CompoundAssignment2)"); }

    public boolean visit(CompoundAssignment3 n) { unimplementedVisitor("visit(CompoundAssignment3)"); return true; }
    public void endVisit(CompoundAssignment3 n) { unimplementedVisitor("endVisit(CompoundAssignment3)"); }

    public boolean visit(CompoundAssignment4 n) { unimplementedVisitor("visit(CompoundAssignment4)"); return true; }
    public void endVisit(CompoundAssignment4 n) { unimplementedVisitor("endVisit(CompoundAssignment4)"); }

    public boolean visit(CompoundAssignment5 n) { unimplementedVisitor("visit(CompoundAssignment5)"); return true; }
    public void endVisit(CompoundAssignment5 n) { unimplementedVisitor("endVisit(CompoundAssignment5)"); }

    public boolean visit(CompoundAssignment6 n) { unimplementedVisitor("visit(CompoundAssignment6)"); return true; }
    public void endVisit(CompoundAssignment6 n) { unimplementedVisitor("endVisit(CompoundAssignment6)"); }

    public boolean visit(CompoundAssignment7 n) { unimplementedVisitor("visit(CompoundAssignment7)"); return true; }
    public void endVisit(CompoundAssignment7 n) { unimplementedVisitor("endVisit(CompoundAssignment7)"); }

    public boolean visit(CompoundAssignment8 n) { unimplementedVisitor("visit(CompoundAssignment8)"); return true; }
    public void endVisit(CompoundAssignment8 n) { unimplementedVisitor("endVisit(CompoundAssignment8)"); }

    public boolean visit(CompoundAssignment9 n) { unimplementedVisitor("visit(CompoundAssignment9)"); return true; }
    public void endVisit(CompoundAssignment9 n) { unimplementedVisitor("endVisit(CompoundAssignment9)"); }

    public boolean visit(CompoundAssignment10 n) { unimplementedVisitor("visit(CompoundAssignment10)"); return true; }
    public void endVisit(CompoundAssignment10 n) { unimplementedVisitor("endVisit(CompoundAssignment10)"); }

    public boolean visit(LogicalAssignment0 n) { unimplementedVisitor("visit(LogicalAssignment0)"); return true; }
    public void endVisit(LogicalAssignment0 n) { unimplementedVisitor("endVisit(LogicalAssignment0)"); }

    public boolean visit(LogicalAssignment1 n) { unimplementedVisitor("visit(LogicalAssignment1)"); return true; }
    public void endVisit(LogicalAssignment1 n) { unimplementedVisitor("endVisit(LogicalAssignment1)"); }

    public boolean visit(LogicalAssignment2 n) { unimplementedVisitor("visit(LogicalAssignment2)"); return true; }
    public void endVisit(LogicalAssignment2 n) { unimplementedVisitor("endVisit(LogicalAssignment2)"); }

    public boolean visit(Statement_abbrev0 n) { unimplementedVisitor("visit(Statement_abbrev0)"); return true; }
    public void endVisit(Statement_abbrev0 n) { unimplementedVisitor("endVisit(Statement_abbrev0)"); }

    public boolean visit(Statement_abbrev1 n) { unimplementedVisitor("visit(Statement_abbrev1)"); return true; }
    public void endVisit(Statement_abbrev1 n) { unimplementedVisitor("endVisit(Statement_abbrev1)"); }

    public boolean visit(Statement_abbrev2 n) { unimplementedVisitor("visit(Statement_abbrev2)"); return true; }
    public void endVisit(Statement_abbrev2 n) { unimplementedVisitor("endVisit(Statement_abbrev2)"); }

    public boolean visit(Statement_abbrev3 n) { unimplementedVisitor("visit(Statement_abbrev3)"); return true; }
    public void endVisit(Statement_abbrev3 n) { unimplementedVisitor("endVisit(Statement_abbrev3)"); }

    public boolean visit(Statement_abbrev4 n) { unimplementedVisitor("visit(Statement_abbrev4)"); return true; }
    public void endVisit(Statement_abbrev4 n) { unimplementedVisitor("endVisit(Statement_abbrev4)"); }

    public boolean visit(Statement_abbrev5 n) { unimplementedVisitor("visit(Statement_abbrev5)"); return true; }
    public void endVisit(Statement_abbrev5 n) { unimplementedVisitor("endVisit(Statement_abbrev5)"); }

    public boolean visit(Statement_abbrev6 n) { unimplementedVisitor("visit(Statement_abbrev6)"); return true; }
    public void endVisit(Statement_abbrev6 n) { unimplementedVisitor("endVisit(Statement_abbrev6)"); }

    public boolean visit(Statement_noShortIf0 n) { unimplementedVisitor("visit(Statement_noShortIf0)"); return true; }
    public void endVisit(Statement_noShortIf0 n) { unimplementedVisitor("endVisit(Statement_noShortIf0)"); }

    public boolean visit(Statement_noShortIf1 n) { unimplementedVisitor("visit(Statement_noShortIf1)"); return true; }
    public void endVisit(Statement_noShortIf1 n) { unimplementedVisitor("endVisit(Statement_noShortIf1)"); }

    public boolean visit(Statement_noShortIf2 n) { unimplementedVisitor("visit(Statement_noShortIf2)"); return true; }
    public void endVisit(Statement_noShortIf2 n) { unimplementedVisitor("endVisit(Statement_noShortIf2)"); }

    public boolean visit(Statement_noShortIf3 n) { unimplementedVisitor("visit(Statement_noShortIf3)"); return true; }
    public void endVisit(Statement_noShortIf3 n) { unimplementedVisitor("endVisit(Statement_noShortIf3)"); }

    public boolean visit(Statement_noShortIf4 n) { unimplementedVisitor("visit(Statement_noShortIf4)"); return true; }
    public void endVisit(Statement_noShortIf4 n) { unimplementedVisitor("endVisit(Statement_noShortIf4)"); }

    public boolean visit(Statement_noShortIf5 n) { unimplementedVisitor("visit(Statement_noShortIf5)"); return true; }
    public void endVisit(Statement_noShortIf5 n) { unimplementedVisitor("endVisit(Statement_noShortIf5)"); }

    public boolean visit(Statement_noShortIf6 n) { unimplementedVisitor("visit(Statement_noShortIf6)"); return true; }
    public void endVisit(Statement_noShortIf6 n) { unimplementedVisitor("endVisit(Statement_noShortIf6)"); }

    public boolean visit(Statement_full0 n) { unimplementedVisitor("visit(Statement_full0)"); return true; }
    public void endVisit(Statement_full0 n) { unimplementedVisitor("endVisit(Statement_full0)"); }

    public boolean visit(Statement_full1 n) { unimplementedVisitor("visit(Statement_full1)"); return true; }
    public void endVisit(Statement_full1 n) { unimplementedVisitor("endVisit(Statement_full1)"); }

    public boolean visit(Statement_full2 n) { unimplementedVisitor("visit(Statement_full2)"); return true; }
    public void endVisit(Statement_full2 n) { unimplementedVisitor("endVisit(Statement_full2)"); }

    public boolean visit(Statement_full3 n) { unimplementedVisitor("visit(Statement_full3)"); return true; }
    public void endVisit(Statement_full3 n) { unimplementedVisitor("endVisit(Statement_full3)"); }

    public boolean visit(Statement_full4 n) { unimplementedVisitor("visit(Statement_full4)"); return true; }
    public void endVisit(Statement_full4 n) { unimplementedVisitor("endVisit(Statement_full4)"); }

    public boolean visit(Statement_full5 n) { unimplementedVisitor("visit(Statement_full5)"); return true; }
    public void endVisit(Statement_full5 n) { unimplementedVisitor("endVisit(Statement_full5)"); }

    public boolean visit(Statement_full6 n) { unimplementedVisitor("visit(Statement_full6)"); return true; }
    public void endVisit(Statement_full6 n) { unimplementedVisitor("endVisit(Statement_full6)"); }

    public boolean visit(Substatement_abbrev0 n) { unimplementedVisitor("visit(Substatement_abbrev0)"); return true; }
    public void endVisit(Substatement_abbrev0 n) { unimplementedVisitor("endVisit(Substatement_abbrev0)"); }

    public boolean visit(Substatement_abbrev1 n) { unimplementedVisitor("visit(Substatement_abbrev1)"); return true; }
    public void endVisit(Substatement_abbrev1 n) { unimplementedVisitor("endVisit(Substatement_abbrev1)"); }

    public boolean visit(Substatement_noShortIf0 n) { unimplementedVisitor("visit(Substatement_noShortIf0)"); return true; }
    public void endVisit(Substatement_noShortIf0 n) { unimplementedVisitor("endVisit(Substatement_noShortIf0)"); }

    public boolean visit(Substatement_noShortIf1 n) { unimplementedVisitor("visit(Substatement_noShortIf1)"); return true; }
    public void endVisit(Substatement_noShortIf1 n) { unimplementedVisitor("endVisit(Substatement_noShortIf1)"); }

    public boolean visit(Substatement_full0 n) { unimplementedVisitor("visit(Substatement_full0)"); return true; }
    public void endVisit(Substatement_full0 n) { unimplementedVisitor("endVisit(Substatement_full0)"); }

    public boolean visit(Substatement_full1 n) { unimplementedVisitor("visit(Substatement_full1)"); return true; }
    public void endVisit(Substatement_full1 n) { unimplementedVisitor("endVisit(Substatement_full1)"); }

    public boolean visit(Semicolon_abbrev0 n) { unimplementedVisitor("visit(Semicolon_abbrev0)"); return true; }
    public void endVisit(Semicolon_abbrev0 n) { unimplementedVisitor("endVisit(Semicolon_abbrev0)"); }

    public boolean visit(Semicolon_abbrev1 n) { unimplementedVisitor("visit(Semicolon_abbrev1)"); return true; }
    public void endVisit(Semicolon_abbrev1 n) { unimplementedVisitor("endVisit(Semicolon_abbrev1)"); }

    public boolean visit(Semicolon_noShortIf0 n) { unimplementedVisitor("visit(Semicolon_noShortIf0)"); return true; }
    public void endVisit(Semicolon_noShortIf0 n) { unimplementedVisitor("endVisit(Semicolon_noShortIf0)"); }

    public boolean visit(Semicolon_noShortIf1 n) { unimplementedVisitor("visit(Semicolon_noShortIf1)"); return true; }
    public void endVisit(Semicolon_noShortIf1 n) { unimplementedVisitor("endVisit(Semicolon_noShortIf1)"); }

    public boolean visit(Semicolon_full0 n) { unimplementedVisitor("visit(Semicolon_full0)"); return true; }
    public void endVisit(Semicolon_full0 n) { unimplementedVisitor("endVisit(Semicolon_full0)"); }

    public boolean visit(Semicolon_full1 n) { unimplementedVisitor("visit(Semicolon_full1)"); return true; }
    public void endVisit(Semicolon_full1 n) { unimplementedVisitor("endVisit(Semicolon_full1)"); }

    public boolean visit(IfStatement_abbrev0 n) { unimplementedVisitor("visit(IfStatement_abbrev0)"); return true; }
    public void endVisit(IfStatement_abbrev0 n) { unimplementedVisitor("endVisit(IfStatement_abbrev0)"); }

    public boolean visit(IfStatement_abbrev1 n) { unimplementedVisitor("visit(IfStatement_abbrev1)"); return true; }
    public void endVisit(IfStatement_abbrev1 n) { unimplementedVisitor("endVisit(IfStatement_abbrev1)"); }

    public boolean visit(IfStatement_full0 n) { unimplementedVisitor("visit(IfStatement_full0)"); return true; }
    public void endVisit(IfStatement_full0 n) { unimplementedVisitor("endVisit(IfStatement_full0)"); }

    public boolean visit(IfStatement_full1 n) { unimplementedVisitor("visit(IfStatement_full1)"); return true; }
    public void endVisit(IfStatement_full1 n) { unimplementedVisitor("endVisit(IfStatement_full1)"); }

    public boolean visit(CaseLabel0 n) { unimplementedVisitor("visit(CaseLabel0)"); return true; }
    public void endVisit(CaseLabel0 n) { unimplementedVisitor("endVisit(CaseLabel0)"); }

    public boolean visit(CaseLabel1 n) { unimplementedVisitor("visit(CaseLabel1)"); return true; }
    public void endVisit(CaseLabel1 n) { unimplementedVisitor("endVisit(CaseLabel1)"); }

    public boolean visit(ForStatement_abbrev0 n) { unimplementedVisitor("visit(ForStatement_abbrev0)"); return true; }
    public void endVisit(ForStatement_abbrev0 n) { unimplementedVisitor("endVisit(ForStatement_abbrev0)"); }

    public boolean visit(ForStatement_abbrev1 n) { unimplementedVisitor("visit(ForStatement_abbrev1)"); return true; }
    public void endVisit(ForStatement_abbrev1 n) { unimplementedVisitor("endVisit(ForStatement_abbrev1)"); }

    public boolean visit(ForStatement_noShortIf0 n) { unimplementedVisitor("visit(ForStatement_noShortIf0)"); return true; }
    public void endVisit(ForStatement_noShortIf0 n) { unimplementedVisitor("endVisit(ForStatement_noShortIf0)"); }

    public boolean visit(ForStatement_noShortIf1 n) { unimplementedVisitor("visit(ForStatement_noShortIf1)"); return true; }
    public void endVisit(ForStatement_noShortIf1 n) { unimplementedVisitor("endVisit(ForStatement_noShortIf1)"); }

    public boolean visit(ForStatement_full0 n) { unimplementedVisitor("visit(ForStatement_full0)"); return true; }
    public void endVisit(ForStatement_full0 n) { unimplementedVisitor("endVisit(ForStatement_full0)"); }

    public boolean visit(ForStatement_full1 n) { unimplementedVisitor("visit(ForStatement_full1)"); return true; }
    public void endVisit(ForStatement_full1 n) { unimplementedVisitor("endVisit(ForStatement_full1)"); }

    public boolean visit(ForInBinding0 n) { unimplementedVisitor("visit(ForInBinding0)"); return true; }
    public void endVisit(ForInBinding0 n) { unimplementedVisitor("endVisit(ForInBinding0)"); }

    public boolean visit(ForInBinding1 n) { unimplementedVisitor("visit(ForInBinding1)"); return true; }
    public void endVisit(ForInBinding1 n) { unimplementedVisitor("endVisit(ForInBinding1)"); }

    public boolean visit(ContinueStatement0 n) { unimplementedVisitor("visit(ContinueStatement0)"); return true; }
    public void endVisit(ContinueStatement0 n) { unimplementedVisitor("endVisit(ContinueStatement0)"); }

    public boolean visit(ContinueStatement1 n) { unimplementedVisitor("visit(ContinueStatement1)"); return true; }
    public void endVisit(ContinueStatement1 n) { unimplementedVisitor("endVisit(ContinueStatement1)"); }

    public boolean visit(BreakStatement0 n) { unimplementedVisitor("visit(BreakStatement0)"); return true; }
    public void endVisit(BreakStatement0 n) { unimplementedVisitor("endVisit(BreakStatement0)"); }

    public boolean visit(BreakStatement1 n) { unimplementedVisitor("visit(BreakStatement1)"); return true; }
    public void endVisit(BreakStatement1 n) { unimplementedVisitor("endVisit(BreakStatement1)"); }

    public boolean visit(ReturnStatement0 n) { unimplementedVisitor("visit(ReturnStatement0)"); return true; }
    public void endVisit(ReturnStatement0 n) { unimplementedVisitor("endVisit(ReturnStatement0)"); }

    public boolean visit(ReturnStatement1 n) { unimplementedVisitor("visit(ReturnStatement1)"); return true; }
    public void endVisit(ReturnStatement1 n) { unimplementedVisitor("endVisit(ReturnStatement1)"); }

    public boolean visit(TryStatement0 n) { unimplementedVisitor("visit(TryStatement0)"); return true; }
    public void endVisit(TryStatement0 n) { unimplementedVisitor("endVisit(TryStatement0)"); }

    public boolean visit(TryStatement1 n) { unimplementedVisitor("visit(TryStatement1)"); return true; }
    public void endVisit(TryStatement1 n) { unimplementedVisitor("endVisit(TryStatement1)"); }

    public boolean visit(Directive_abbrev0 n) { unimplementedVisitor("visit(Directive_abbrev0)"); return true; }
    public void endVisit(Directive_abbrev0 n) { unimplementedVisitor("endVisit(Directive_abbrev0)"); }

    public boolean visit(Directive_abbrev1 n) { unimplementedVisitor("visit(Directive_abbrev1)"); return true; }
    public void endVisit(Directive_abbrev1 n) { unimplementedVisitor("endVisit(Directive_abbrev1)"); }

    public boolean visit(Directive_abbrev2 n) { unimplementedVisitor("visit(Directive_abbrev2)"); return true; }
    public void endVisit(Directive_abbrev2 n) { unimplementedVisitor("endVisit(Directive_abbrev2)"); }

    public boolean visit(Directive_abbrev3 n) { unimplementedVisitor("visit(Directive_abbrev3)"); return true; }
    public void endVisit(Directive_abbrev3 n) { unimplementedVisitor("endVisit(Directive_abbrev3)"); }

    public boolean visit(Directive_abbrev4 n) { unimplementedVisitor("visit(Directive_abbrev4)"); return true; }
    public void endVisit(Directive_abbrev4 n) { unimplementedVisitor("endVisit(Directive_abbrev4)"); }

    public boolean visit(Directive_full0 n) { unimplementedVisitor("visit(Directive_full0)"); return true; }
    public void endVisit(Directive_full0 n) { unimplementedVisitor("endVisit(Directive_full0)"); }

    public boolean visit(Directive_full1 n) { unimplementedVisitor("visit(Directive_full1)"); return true; }
    public void endVisit(Directive_full1 n) { unimplementedVisitor("endVisit(Directive_full1)"); }

    public boolean visit(Directive_full2 n) { unimplementedVisitor("visit(Directive_full2)"); return true; }
    public void endVisit(Directive_full2 n) { unimplementedVisitor("endVisit(Directive_full2)"); }

    public boolean visit(Directive_full3 n) { unimplementedVisitor("visit(Directive_full3)"); return true; }
    public void endVisit(Directive_full3 n) { unimplementedVisitor("endVisit(Directive_full3)"); }

    public boolean visit(AnnotatableDirective_abbrev0 n) { unimplementedVisitor("visit(AnnotatableDirective_abbrev0)"); return true; }
    public void endVisit(AnnotatableDirective_abbrev0 n) { unimplementedVisitor("endVisit(AnnotatableDirective_abbrev0)"); }

    public boolean visit(AnnotatableDirective_abbrev1 n) { unimplementedVisitor("visit(AnnotatableDirective_abbrev1)"); return true; }
    public void endVisit(AnnotatableDirective_abbrev1 n) { unimplementedVisitor("endVisit(AnnotatableDirective_abbrev1)"); }

    public boolean visit(AnnotatableDirective_abbrev2 n) { unimplementedVisitor("visit(AnnotatableDirective_abbrev2)"); return true; }
    public void endVisit(AnnotatableDirective_abbrev2 n) { unimplementedVisitor("endVisit(AnnotatableDirective_abbrev2)"); }

    public boolean visit(AnnotatableDirective_abbrev3 n) { unimplementedVisitor("visit(AnnotatableDirective_abbrev3)"); return true; }
    public void endVisit(AnnotatableDirective_abbrev3 n) { unimplementedVisitor("endVisit(AnnotatableDirective_abbrev3)"); }

    public boolean visit(AnnotatableDirective_abbrev4 n) { unimplementedVisitor("visit(AnnotatableDirective_abbrev4)"); return true; }
    public void endVisit(AnnotatableDirective_abbrev4 n) { unimplementedVisitor("endVisit(AnnotatableDirective_abbrev4)"); }

    public boolean visit(AnnotatableDirective_full0 n) { unimplementedVisitor("visit(AnnotatableDirective_full0)"); return true; }
    public void endVisit(AnnotatableDirective_full0 n) { unimplementedVisitor("endVisit(AnnotatableDirective_full0)"); }

    public boolean visit(AnnotatableDirective_full1 n) { unimplementedVisitor("visit(AnnotatableDirective_full1)"); return true; }
    public void endVisit(AnnotatableDirective_full1 n) { unimplementedVisitor("endVisit(AnnotatableDirective_full1)"); }

    public boolean visit(AnnotatableDirective_full2 n) { unimplementedVisitor("visit(AnnotatableDirective_full2)"); return true; }
    public void endVisit(AnnotatableDirective_full2 n) { unimplementedVisitor("endVisit(AnnotatableDirective_full2)"); }

    public boolean visit(AnnotatableDirective_full3 n) { unimplementedVisitor("visit(AnnotatableDirective_full3)"); return true; }
    public void endVisit(AnnotatableDirective_full3 n) { unimplementedVisitor("endVisit(AnnotatableDirective_full3)"); }

    public boolean visit(AnnotatableDirective_full4 n) { unimplementedVisitor("visit(AnnotatableDirective_full4)"); return true; }
    public void endVisit(AnnotatableDirective_full4 n) { unimplementedVisitor("endVisit(AnnotatableDirective_full4)"); }

    public boolean visit(Attribute0 n) { unimplementedVisitor("visit(Attribute0)"); return true; }
    public void endVisit(Attribute0 n) { unimplementedVisitor("endVisit(Attribute0)"); }

    public boolean visit(Attribute1 n) { unimplementedVisitor("visit(Attribute1)"); return true; }
    public void endVisit(Attribute1 n) { unimplementedVisitor("endVisit(Attribute1)"); }

    public boolean visit(ImportDirective0 n) { unimplementedVisitor("visit(ImportDirective0)"); return true; }
    public void endVisit(ImportDirective0 n) { unimplementedVisitor("endVisit(ImportDirective0)"); }

    public boolean visit(ImportDirective1 n) { unimplementedVisitor("visit(ImportDirective1)"); return true; }
    public void endVisit(ImportDirective1 n) { unimplementedVisitor("endVisit(ImportDirective1)"); }

    public boolean visit(PragmaArgument0 n) { unimplementedVisitor("visit(PragmaArgument0)"); return true; }
    public void endVisit(PragmaArgument0 n) { unimplementedVisitor("endVisit(PragmaArgument0)"); }

    public boolean visit(PragmaArgument1 n) { unimplementedVisitor("visit(PragmaArgument1)"); return true; }
    public void endVisit(PragmaArgument1 n) { unimplementedVisitor("endVisit(PragmaArgument1)"); }

    public boolean visit(PragmaArgument2 n) { unimplementedVisitor("visit(PragmaArgument2)"); return true; }
    public void endVisit(PragmaArgument2 n) { unimplementedVisitor("endVisit(PragmaArgument2)"); }

    public boolean visit(PragmaArgument3 n) { unimplementedVisitor("visit(PragmaArgument3)"); return true; }
    public void endVisit(PragmaArgument3 n) { unimplementedVisitor("endVisit(PragmaArgument3)"); }

    public boolean visit(PragmaArgument4 n) { unimplementedVisitor("visit(PragmaArgument4)"); return true; }
    public void endVisit(PragmaArgument4 n) { unimplementedVisitor("endVisit(PragmaArgument4)"); }

    public boolean visit(PragmaArgument5 n) { unimplementedVisitor("visit(PragmaArgument5)"); return true; }
    public void endVisit(PragmaArgument5 n) { unimplementedVisitor("endVisit(PragmaArgument5)"); }

    public boolean visit(VariableDefinitionKind0 n) { unimplementedVisitor("visit(VariableDefinitionKind0)"); return true; }
    public void endVisit(VariableDefinitionKind0 n) { unimplementedVisitor("endVisit(VariableDefinitionKind0)"); }

    public boolean visit(VariableDefinitionKind1 n) { unimplementedVisitor("visit(VariableDefinitionKind1)"); return true; }
    public void endVisit(VariableDefinitionKind1 n) { unimplementedVisitor("endVisit(VariableDefinitionKind1)"); }

    public boolean visit(FunctionName0 n) { unimplementedVisitor("visit(FunctionName0)"); return true; }
    public void endVisit(FunctionName0 n) { unimplementedVisitor("endVisit(FunctionName0)"); }

    public boolean visit(FunctionName1 n) { unimplementedVisitor("visit(FunctionName1)"); return true; }
    public void endVisit(FunctionName1 n) { unimplementedVisitor("endVisit(FunctionName1)"); }

    public boolean visit(RestParameter0 n) { unimplementedVisitor("visit(RestParameter0)"); return true; }
    public void endVisit(RestParameter0 n) { unimplementedVisitor("endVisit(RestParameter0)"); }

    public boolean visit(RestParameter1 n) { unimplementedVisitor("visit(RestParameter1)"); return true; }
    public void endVisit(RestParameter1 n) { unimplementedVisitor("endVisit(RestParameter1)"); }

    public boolean visit(ES_PrimaryExpression0 n) { unimplementedVisitor("visit(ES_PrimaryExpression0)"); return true; }
    public void endVisit(ES_PrimaryExpression0 n) { unimplementedVisitor("endVisit(ES_PrimaryExpression0)"); }

    public boolean visit(ES_PrimaryExpression1 n) { unimplementedVisitor("visit(ES_PrimaryExpression1)"); return true; }
    public void endVisit(ES_PrimaryExpression1 n) { unimplementedVisitor("endVisit(ES_PrimaryExpression1)"); }

    public boolean visit(ES_PrimaryExpression2 n) { unimplementedVisitor("visit(ES_PrimaryExpression2)"); return true; }
    public void endVisit(ES_PrimaryExpression2 n) { unimplementedVisitor("endVisit(ES_PrimaryExpression2)"); }

    public boolean visit(ES_PrimaryExpression3 n) { unimplementedVisitor("visit(ES_PrimaryExpression3)"); return true; }
    public void endVisit(ES_PrimaryExpression3 n) { unimplementedVisitor("endVisit(ES_PrimaryExpression3)"); }

    public boolean visit(ES_PrimaryExpression4 n) { unimplementedVisitor("visit(ES_PrimaryExpression4)"); return true; }
    public void endVisit(ES_PrimaryExpression4 n) { unimplementedVisitor("endVisit(ES_PrimaryExpression4)"); }

    public boolean visit(ES_PrimaryExpression5 n) { unimplementedVisitor("visit(ES_PrimaryExpression5)"); return true; }
    public void endVisit(ES_PrimaryExpression5 n) { unimplementedVisitor("endVisit(ES_PrimaryExpression5)"); }

    public boolean visit(ES_PrimaryExpression6 n) { unimplementedVisitor("visit(ES_PrimaryExpression6)"); return true; }
    public void endVisit(ES_PrimaryExpression6 n) { unimplementedVisitor("endVisit(ES_PrimaryExpression6)"); }

    public boolean visit(ES_FullPostfixExpression0 n) { unimplementedVisitor("visit(ES_FullPostfixExpression0)"); return true; }
    public void endVisit(ES_FullPostfixExpression0 n) { unimplementedVisitor("endVisit(ES_FullPostfixExpression0)"); }

    public boolean visit(ES_FullPostfixExpression1 n) { unimplementedVisitor("visit(ES_FullPostfixExpression1)"); return true; }
    public void endVisit(ES_FullPostfixExpression1 n) { unimplementedVisitor("endVisit(ES_FullPostfixExpression1)"); }

    public boolean visit(ES_FullPostfixExpression2 n) { unimplementedVisitor("visit(ES_FullPostfixExpression2)"); return true; }
    public void endVisit(ES_FullPostfixExpression2 n) { unimplementedVisitor("endVisit(ES_FullPostfixExpression2)"); }

    public boolean visit(ES_FullPostfixExpression3 n) { unimplementedVisitor("visit(ES_FullPostfixExpression3)"); return true; }
    public void endVisit(ES_FullPostfixExpression3 n) { unimplementedVisitor("endVisit(ES_FullPostfixExpression3)"); }

    public boolean visit(ES_FullPostfixExpression4 n) { unimplementedVisitor("visit(ES_FullPostfixExpression4)"); return true; }
    public void endVisit(ES_FullPostfixExpression4 n) { unimplementedVisitor("endVisit(ES_FullPostfixExpression4)"); }

    public boolean visit(ES_UnaryExpression0 n) { unimplementedVisitor("visit(ES_UnaryExpression0)"); return true; }
    public void endVisit(ES_UnaryExpression0 n) { unimplementedVisitor("endVisit(ES_UnaryExpression0)"); }

    public boolean visit(ES_UnaryExpression1 n) { unimplementedVisitor("visit(ES_UnaryExpression1)"); return true; }
    public void endVisit(ES_UnaryExpression1 n) { unimplementedVisitor("endVisit(ES_UnaryExpression1)"); }

    public boolean visit(ES_UnaryExpression2 n) { unimplementedVisitor("visit(ES_UnaryExpression2)"); return true; }
    public void endVisit(ES_UnaryExpression2 n) { unimplementedVisitor("endVisit(ES_UnaryExpression2)"); }

    public boolean visit(ES_UnaryExpression3 n) { unimplementedVisitor("visit(ES_UnaryExpression3)"); return true; }
    public void endVisit(ES_UnaryExpression3 n) { unimplementedVisitor("endVisit(ES_UnaryExpression3)"); }

    public boolean visit(ES_UnaryExpression4 n) { unimplementedVisitor("visit(ES_UnaryExpression4)"); return true; }
    public void endVisit(ES_UnaryExpression4 n) { unimplementedVisitor("endVisit(ES_UnaryExpression4)"); }

    public boolean visit(ES_UnaryExpression5 n) { unimplementedVisitor("visit(ES_UnaryExpression5)"); return true; }
    public void endVisit(ES_UnaryExpression5 n) { unimplementedVisitor("endVisit(ES_UnaryExpression5)"); }

    public boolean visit(ES_UnaryExpression6 n) { unimplementedVisitor("visit(ES_UnaryExpression6)"); return true; }
    public void endVisit(ES_UnaryExpression6 n) { unimplementedVisitor("endVisit(ES_UnaryExpression6)"); }

    public boolean visit(ES_UnaryExpression7 n) { unimplementedVisitor("visit(ES_UnaryExpression7)"); return true; }
    public void endVisit(ES_UnaryExpression7 n) { unimplementedVisitor("endVisit(ES_UnaryExpression7)"); }

    public boolean visit(ES_UnaryExpression8 n) { unimplementedVisitor("visit(ES_UnaryExpression8)"); return true; }
    public void endVisit(ES_UnaryExpression8 n) { unimplementedVisitor("endVisit(ES_UnaryExpression8)"); }

    public boolean visit(ES_UnaryExpression9 n) { unimplementedVisitor("visit(ES_UnaryExpression9)"); return true; }
    public void endVisit(ES_UnaryExpression9 n) { unimplementedVisitor("endVisit(ES_UnaryExpression9)"); }

    public boolean visit(ES_MultiplicativeExpression0 n) { unimplementedVisitor("visit(ES_MultiplicativeExpression0)"); return true; }
    public void endVisit(ES_MultiplicativeExpression0 n) { unimplementedVisitor("endVisit(ES_MultiplicativeExpression0)"); }

    public boolean visit(ES_MultiplicativeExpression1 n) { unimplementedVisitor("visit(ES_MultiplicativeExpression1)"); return true; }
    public void endVisit(ES_MultiplicativeExpression1 n) { unimplementedVisitor("endVisit(ES_MultiplicativeExpression1)"); }

    public boolean visit(ES_MultiplicativeExpression2 n) { unimplementedVisitor("visit(ES_MultiplicativeExpression2)"); return true; }
    public void endVisit(ES_MultiplicativeExpression2 n) { unimplementedVisitor("endVisit(ES_MultiplicativeExpression2)"); }

    public boolean visit(ES_AdditiveExpression0 n) { unimplementedVisitor("visit(ES_AdditiveExpression0)"); return true; }
    public void endVisit(ES_AdditiveExpression0 n) { unimplementedVisitor("endVisit(ES_AdditiveExpression0)"); }

    public boolean visit(ES_AdditiveExpression1 n) { unimplementedVisitor("visit(ES_AdditiveExpression1)"); return true; }
    public void endVisit(ES_AdditiveExpression1 n) { unimplementedVisitor("endVisit(ES_AdditiveExpression1)"); }

    public boolean visit(ES_ShiftExpression0 n) { unimplementedVisitor("visit(ES_ShiftExpression0)"); return true; }
    public void endVisit(ES_ShiftExpression0 n) { unimplementedVisitor("endVisit(ES_ShiftExpression0)"); }

    public boolean visit(ES_ShiftExpression1 n) { unimplementedVisitor("visit(ES_ShiftExpression1)"); return true; }
    public void endVisit(ES_ShiftExpression1 n) { unimplementedVisitor("endVisit(ES_ShiftExpression1)"); }

    public boolean visit(ES_ShiftExpression2 n) { unimplementedVisitor("visit(ES_ShiftExpression2)"); return true; }
    public void endVisit(ES_ShiftExpression2 n) { unimplementedVisitor("endVisit(ES_ShiftExpression2)"); }

    public boolean visit(ES_RelationalExpression_allowIn0 n) { unimplementedVisitor("visit(ES_RelationalExpression_allowIn0)"); return true; }
    public void endVisit(ES_RelationalExpression_allowIn0 n) { unimplementedVisitor("endVisit(ES_RelationalExpression_allowIn0)"); }

    public boolean visit(ES_RelationalExpression_allowIn1 n) { unimplementedVisitor("visit(ES_RelationalExpression_allowIn1)"); return true; }
    public void endVisit(ES_RelationalExpression_allowIn1 n) { unimplementedVisitor("endVisit(ES_RelationalExpression_allowIn1)"); }

    public boolean visit(ES_RelationalExpression_allowIn2 n) { unimplementedVisitor("visit(ES_RelationalExpression_allowIn2)"); return true; }
    public void endVisit(ES_RelationalExpression_allowIn2 n) { unimplementedVisitor("endVisit(ES_RelationalExpression_allowIn2)"); }

    public boolean visit(ES_RelationalExpression_allowIn3 n) { unimplementedVisitor("visit(ES_RelationalExpression_allowIn3)"); return true; }
    public void endVisit(ES_RelationalExpression_allowIn3 n) { unimplementedVisitor("endVisit(ES_RelationalExpression_allowIn3)"); }

    public boolean visit(ES_RelationalExpression_allowIn4 n) { unimplementedVisitor("visit(ES_RelationalExpression_allowIn4)"); return true; }
    public void endVisit(ES_RelationalExpression_allowIn4 n) { unimplementedVisitor("endVisit(ES_RelationalExpression_allowIn4)"); }

    public boolean visit(ES_RelationalExpression_allowIn5 n) { unimplementedVisitor("visit(ES_RelationalExpression_allowIn5)"); return true; }
    public void endVisit(ES_RelationalExpression_allowIn5 n) { unimplementedVisitor("endVisit(ES_RelationalExpression_allowIn5)"); }

    public boolean visit(ES_RelationalExpression_allowIn6 n) { unimplementedVisitor("visit(ES_RelationalExpression_allowIn6)"); return true; }
    public void endVisit(ES_RelationalExpression_allowIn6 n) { unimplementedVisitor("endVisit(ES_RelationalExpression_allowIn6)"); }

    public boolean visit(ES_RelationalExpression_allowIn7 n) { unimplementedVisitor("visit(ES_RelationalExpression_allowIn7)"); return true; }
    public void endVisit(ES_RelationalExpression_allowIn7 n) { unimplementedVisitor("endVisit(ES_RelationalExpression_allowIn7)"); }

    public boolean visit(ES_EqualityExpression_allowIn0 n) { unimplementedVisitor("visit(ES_EqualityExpression_allowIn0)"); return true; }
    public void endVisit(ES_EqualityExpression_allowIn0 n) { unimplementedVisitor("endVisit(ES_EqualityExpression_allowIn0)"); }

    public boolean visit(ES_EqualityExpression_allowIn1 n) { unimplementedVisitor("visit(ES_EqualityExpression_allowIn1)"); return true; }
    public void endVisit(ES_EqualityExpression_allowIn1 n) { unimplementedVisitor("endVisit(ES_EqualityExpression_allowIn1)"); }

    public boolean visit(ES_EqualityExpression_allowIn2 n) { unimplementedVisitor("visit(ES_EqualityExpression_allowIn2)"); return true; }
    public void endVisit(ES_EqualityExpression_allowIn2 n) { unimplementedVisitor("endVisit(ES_EqualityExpression_allowIn2)"); }

    public boolean visit(ES_EqualityExpression_allowIn3 n) { unimplementedVisitor("visit(ES_EqualityExpression_allowIn3)"); return true; }
    public void endVisit(ES_EqualityExpression_allowIn3 n) { unimplementedVisitor("endVisit(ES_EqualityExpression_allowIn3)"); }

    public boolean visit(ES_AssignmentExpression_allowIn0 n) { unimplementedVisitor("visit(ES_AssignmentExpression_allowIn0)"); return true; }
    public void endVisit(ES_AssignmentExpression_allowIn0 n) { unimplementedVisitor("endVisit(ES_AssignmentExpression_allowIn0)"); }

    public boolean visit(ES_AssignmentExpression_allowIn1 n) { unimplementedVisitor("visit(ES_AssignmentExpression_allowIn1)"); return true; }
    public void endVisit(ES_AssignmentExpression_allowIn1 n) { unimplementedVisitor("endVisit(ES_AssignmentExpression_allowIn1)"); }

    public boolean visit(ES_AssignmentExpression_allowIn2 n) { unimplementedVisitor("visit(ES_AssignmentExpression_allowIn2)"); return true; }
    public void endVisit(ES_AssignmentExpression_allowIn2 n) { unimplementedVisitor("endVisit(ES_AssignmentExpression_allowIn2)"); }
}

