//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

public abstract class AbstractResultVisitor implements ResultVisitor, ResultArgumentVisitor
{
    public abstract Object unimplementedVisitor(String s);

    public Object visit(AstToken n) { return unimplementedVisitor("visit(AstToken)"); }
    public Object visit(AstToken n, Object o) { return  unimplementedVisitor("visit(AstToken, Object)"); }

    public Object visit(IntegerLiteral n) { return unimplementedVisitor("visit(IntegerLiteral)"); }
    public Object visit(IntegerLiteral n, Object o) { return  unimplementedVisitor("visit(IntegerLiteral, Object)"); }

    public Object visit(LongLiteral n) { return unimplementedVisitor("visit(LongLiteral)"); }
    public Object visit(LongLiteral n, Object o) { return  unimplementedVisitor("visit(LongLiteral, Object)"); }

    public Object visit(FloatLiteral n) { return unimplementedVisitor("visit(FloatLiteral)"); }
    public Object visit(FloatLiteral n, Object o) { return  unimplementedVisitor("visit(FloatLiteral, Object)"); }

    public Object visit(DoubleLiteral n) { return unimplementedVisitor("visit(DoubleLiteral)"); }
    public Object visit(DoubleLiteral n, Object o) { return  unimplementedVisitor("visit(DoubleLiteral, Object)"); }

    public Object visit(BooleanLiteral n) { return unimplementedVisitor("visit(BooleanLiteral)"); }
    public Object visit(BooleanLiteral n, Object o) { return  unimplementedVisitor("visit(BooleanLiteral, Object)"); }

    public Object visit(CharacterLiteral n) { return unimplementedVisitor("visit(CharacterLiteral)"); }
    public Object visit(CharacterLiteral n, Object o) { return  unimplementedVisitor("visit(CharacterLiteral, Object)"); }

    public Object visit(StringLiteral n) { return unimplementedVisitor("visit(StringLiteral)"); }
    public Object visit(StringLiteral n, Object o) { return  unimplementedVisitor("visit(StringLiteral, Object)"); }

    public Object visit(NullLiteral n) { return unimplementedVisitor("visit(NullLiteral)"); }
    public Object visit(NullLiteral n, Object o) { return  unimplementedVisitor("visit(NullLiteral, Object)"); }

    public Object visit(TrueLiteral n) { return unimplementedVisitor("visit(TrueLiteral)"); }
    public Object visit(TrueLiteral n, Object o) { return  unimplementedVisitor("visit(TrueLiteral, Object)"); }

    public Object visit(FalseLiteral n) { return unimplementedVisitor("visit(FalseLiteral)"); }
    public Object visit(FalseLiteral n, Object o) { return  unimplementedVisitor("visit(FalseLiteral, Object)"); }

    public Object visit(BooleanType n) { return unimplementedVisitor("visit(BooleanType)"); }
    public Object visit(BooleanType n, Object o) { return  unimplementedVisitor("visit(BooleanType, Object)"); }

    public Object visit(ByteType n) { return unimplementedVisitor("visit(ByteType)"); }
    public Object visit(ByteType n, Object o) { return  unimplementedVisitor("visit(ByteType, Object)"); }

    public Object visit(ShortType n) { return unimplementedVisitor("visit(ShortType)"); }
    public Object visit(ShortType n, Object o) { return  unimplementedVisitor("visit(ShortType, Object)"); }

    public Object visit(IntType n) { return unimplementedVisitor("visit(IntType)"); }
    public Object visit(IntType n, Object o) { return  unimplementedVisitor("visit(IntType, Object)"); }

    public Object visit(LongType n) { return unimplementedVisitor("visit(LongType)"); }
    public Object visit(LongType n, Object o) { return  unimplementedVisitor("visit(LongType, Object)"); }

    public Object visit(CharType n) { return unimplementedVisitor("visit(CharType)"); }
    public Object visit(CharType n, Object o) { return  unimplementedVisitor("visit(CharType, Object)"); }

    public Object visit(FloatType n) { return unimplementedVisitor("visit(FloatType)"); }
    public Object visit(FloatType n, Object o) { return  unimplementedVisitor("visit(FloatType, Object)"); }

    public Object visit(DoubleType n) { return unimplementedVisitor("visit(DoubleType)"); }
    public Object visit(DoubleType n, Object o) { return  unimplementedVisitor("visit(DoubleType, Object)"); }

    public Object visit(PrimitiveArrayType n) { return unimplementedVisitor("visit(PrimitiveArrayType)"); }
    public Object visit(PrimitiveArrayType n, Object o) { return  unimplementedVisitor("visit(PrimitiveArrayType, Object)"); }

    public Object visit(ClassOrInterfaceArrayType n) { return unimplementedVisitor("visit(ClassOrInterfaceArrayType)"); }
    public Object visit(ClassOrInterfaceArrayType n, Object o) { return  unimplementedVisitor("visit(ClassOrInterfaceArrayType, Object)"); }

    public Object visit(SimpleName n) { return unimplementedVisitor("visit(SimpleName)"); }
    public Object visit(SimpleName n, Object o) { return  unimplementedVisitor("visit(SimpleName, Object)"); }

    public Object visit(QualifiedName n) { return unimplementedVisitor("visit(QualifiedName)"); }
    public Object visit(QualifiedName n, Object o) { return  unimplementedVisitor("visit(QualifiedName, Object)"); }

    public Object visit(CompilationUnit n) { return unimplementedVisitor("visit(CompilationUnit)"); }
    public Object visit(CompilationUnit n, Object o) { return  unimplementedVisitor("visit(CompilationUnit, Object)"); }

    public Object visit(ImportDeclarationList n) { return unimplementedVisitor("visit(ImportDeclarationList)"); }
    public Object visit(ImportDeclarationList n, Object o) { return  unimplementedVisitor("visit(ImportDeclarationList, Object)"); }

    public Object visit(TypeDeclarationList n) { return unimplementedVisitor("visit(TypeDeclarationList)"); }
    public Object visit(TypeDeclarationList n, Object o) { return  unimplementedVisitor("visit(TypeDeclarationList, Object)"); }

    public Object visit(PackageDeclaration n) { return unimplementedVisitor("visit(PackageDeclaration)"); }
    public Object visit(PackageDeclaration n, Object o) { return  unimplementedVisitor("visit(PackageDeclaration, Object)"); }

    public Object visit(SingleTypeImportDeclaration n) { return unimplementedVisitor("visit(SingleTypeImportDeclaration)"); }
    public Object visit(SingleTypeImportDeclaration n, Object o) { return  unimplementedVisitor("visit(SingleTypeImportDeclaration, Object)"); }

    public Object visit(TypeImportOnDemandDeclaration n) { return unimplementedVisitor("visit(TypeImportOnDemandDeclaration)"); }
    public Object visit(TypeImportOnDemandDeclaration n, Object o) { return  unimplementedVisitor("visit(TypeImportOnDemandDeclaration, Object)"); }

    public Object visit(EmptyDeclaration n) { return unimplementedVisitor("visit(EmptyDeclaration)"); }
    public Object visit(EmptyDeclaration n, Object o) { return  unimplementedVisitor("visit(EmptyDeclaration, Object)"); }

    public Object visit(ModifierList n) { return unimplementedVisitor("visit(ModifierList)"); }
    public Object visit(ModifierList n, Object o) { return  unimplementedVisitor("visit(ModifierList, Object)"); }

    public Object visit(PublicModifier n) { return unimplementedVisitor("visit(PublicModifier)"); }
    public Object visit(PublicModifier n, Object o) { return  unimplementedVisitor("visit(PublicModifier, Object)"); }

    public Object visit(ProtectedModifier n) { return unimplementedVisitor("visit(ProtectedModifier)"); }
    public Object visit(ProtectedModifier n, Object o) { return  unimplementedVisitor("visit(ProtectedModifier, Object)"); }

    public Object visit(PrivateModifier n) { return unimplementedVisitor("visit(PrivateModifier)"); }
    public Object visit(PrivateModifier n, Object o) { return  unimplementedVisitor("visit(PrivateModifier, Object)"); }

    public Object visit(StaticModifier n) { return unimplementedVisitor("visit(StaticModifier)"); }
    public Object visit(StaticModifier n, Object o) { return  unimplementedVisitor("visit(StaticModifier, Object)"); }

    public Object visit(AbstractModifier n) { return unimplementedVisitor("visit(AbstractModifier)"); }
    public Object visit(AbstractModifier n, Object o) { return  unimplementedVisitor("visit(AbstractModifier, Object)"); }

    public Object visit(FinalModifier n) { return unimplementedVisitor("visit(FinalModifier)"); }
    public Object visit(FinalModifier n, Object o) { return  unimplementedVisitor("visit(FinalModifier, Object)"); }

    public Object visit(NativeModifier n) { return unimplementedVisitor("visit(NativeModifier)"); }
    public Object visit(NativeModifier n, Object o) { return  unimplementedVisitor("visit(NativeModifier, Object)"); }

    public Object visit(StrictfpModifier n) { return unimplementedVisitor("visit(StrictfpModifier)"); }
    public Object visit(StrictfpModifier n, Object o) { return  unimplementedVisitor("visit(StrictfpModifier, Object)"); }

    public Object visit(SynchronizedModifier n) { return unimplementedVisitor("visit(SynchronizedModifier)"); }
    public Object visit(SynchronizedModifier n, Object o) { return  unimplementedVisitor("visit(SynchronizedModifier, Object)"); }

    public Object visit(TransientModifier n) { return unimplementedVisitor("visit(TransientModifier)"); }
    public Object visit(TransientModifier n, Object o) { return  unimplementedVisitor("visit(TransientModifier, Object)"); }

    public Object visit(VolatileModifier n) { return unimplementedVisitor("visit(VolatileModifier)"); }
    public Object visit(VolatileModifier n, Object o) { return  unimplementedVisitor("visit(VolatileModifier, Object)"); }

    public Object visit(ClassDeclaration n) { return unimplementedVisitor("visit(ClassDeclaration)"); }
    public Object visit(ClassDeclaration n, Object o) { return  unimplementedVisitor("visit(ClassDeclaration, Object)"); }

    public Object visit(Super n) { return unimplementedVisitor("visit(Super)"); }
    public Object visit(Super n, Object o) { return  unimplementedVisitor("visit(Super, Object)"); }

    public Object visit(InterfaceTypeList n) { return unimplementedVisitor("visit(InterfaceTypeList)"); }
    public Object visit(InterfaceTypeList n, Object o) { return  unimplementedVisitor("visit(InterfaceTypeList, Object)"); }

    public Object visit(ClassBody n) { return unimplementedVisitor("visit(ClassBody)"); }
    public Object visit(ClassBody n, Object o) { return  unimplementedVisitor("visit(ClassBody, Object)"); }

    public Object visit(ClassBodyDeclarationList n) { return unimplementedVisitor("visit(ClassBodyDeclarationList)"); }
    public Object visit(ClassBodyDeclarationList n, Object o) { return  unimplementedVisitor("visit(ClassBodyDeclarationList, Object)"); }

    public Object visit(FieldDeclaration n) { return unimplementedVisitor("visit(FieldDeclaration)"); }
    public Object visit(FieldDeclaration n, Object o) { return  unimplementedVisitor("visit(FieldDeclaration, Object)"); }

    public Object visit(VariableDeclaratorList n) { return unimplementedVisitor("visit(VariableDeclaratorList)"); }
    public Object visit(VariableDeclaratorList n, Object o) { return  unimplementedVisitor("visit(VariableDeclaratorList, Object)"); }

    public Object visit(VariableDeclarator n) { return unimplementedVisitor("visit(VariableDeclarator)"); }
    public Object visit(VariableDeclarator n, Object o) { return  unimplementedVisitor("visit(VariableDeclarator, Object)"); }

    public Object visit(VariableDeclaratorId n) { return unimplementedVisitor("visit(VariableDeclaratorId)"); }
    public Object visit(VariableDeclaratorId n, Object o) { return  unimplementedVisitor("visit(VariableDeclaratorId, Object)"); }

    public Object visit(MethodDeclaration n) { return unimplementedVisitor("visit(MethodDeclaration)"); }
    public Object visit(MethodDeclaration n, Object o) { return  unimplementedVisitor("visit(MethodDeclaration, Object)"); }

    public Object visit(TypedMethodHeader n) { return unimplementedVisitor("visit(TypedMethodHeader)"); }
    public Object visit(TypedMethodHeader n, Object o) { return  unimplementedVisitor("visit(TypedMethodHeader, Object)"); }

    public Object visit(VoidMethodHeader n) { return unimplementedVisitor("visit(VoidMethodHeader)"); }
    public Object visit(VoidMethodHeader n, Object o) { return  unimplementedVisitor("visit(VoidMethodHeader, Object)"); }

    public Object visit(MethodDeclarator n) { return unimplementedVisitor("visit(MethodDeclarator)"); }
    public Object visit(MethodDeclarator n, Object o) { return  unimplementedVisitor("visit(MethodDeclarator, Object)"); }

    public Object visit(FormalParameterList n) { return unimplementedVisitor("visit(FormalParameterList)"); }
    public Object visit(FormalParameterList n, Object o) { return  unimplementedVisitor("visit(FormalParameterList, Object)"); }

    public Object visit(FormalParameter n) { return unimplementedVisitor("visit(FormalParameter)"); }
    public Object visit(FormalParameter n, Object o) { return  unimplementedVisitor("visit(FormalParameter, Object)"); }

    public Object visit(ClassTypeList n) { return unimplementedVisitor("visit(ClassTypeList)"); }
    public Object visit(ClassTypeList n, Object o) { return  unimplementedVisitor("visit(ClassTypeList, Object)"); }

    public Object visit(EmptyMethodBody n) { return unimplementedVisitor("visit(EmptyMethodBody)"); }
    public Object visit(EmptyMethodBody n, Object o) { return  unimplementedVisitor("visit(EmptyMethodBody, Object)"); }

    public Object visit(StaticInitializer n) { return unimplementedVisitor("visit(StaticInitializer)"); }
    public Object visit(StaticInitializer n, Object o) { return  unimplementedVisitor("visit(StaticInitializer, Object)"); }

    public Object visit(ConstructorDeclaration n) { return unimplementedVisitor("visit(ConstructorDeclaration)"); }
    public Object visit(ConstructorDeclaration n, Object o) { return  unimplementedVisitor("visit(ConstructorDeclaration, Object)"); }

    public Object visit(ConstructorDeclarator n) { return unimplementedVisitor("visit(ConstructorDeclarator)"); }
    public Object visit(ConstructorDeclarator n, Object o) { return  unimplementedVisitor("visit(ConstructorDeclarator, Object)"); }

    public Object visit(ConstructorBody n) { return unimplementedVisitor("visit(ConstructorBody)"); }
    public Object visit(ConstructorBody n, Object o) { return  unimplementedVisitor("visit(ConstructorBody, Object)"); }

    public Object visit(ThisCall n) { return unimplementedVisitor("visit(ThisCall)"); }
    public Object visit(ThisCall n, Object o) { return  unimplementedVisitor("visit(ThisCall, Object)"); }

    public Object visit(SuperCall n) { return unimplementedVisitor("visit(SuperCall)"); }
    public Object visit(SuperCall n, Object o) { return  unimplementedVisitor("visit(SuperCall, Object)"); }

    public Object visit(InterfaceDeclaration n) { return unimplementedVisitor("visit(InterfaceDeclaration)"); }
    public Object visit(InterfaceDeclaration n, Object o) { return  unimplementedVisitor("visit(InterfaceDeclaration, Object)"); }

    public Object visit(InterfaceBody n) { return unimplementedVisitor("visit(InterfaceBody)"); }
    public Object visit(InterfaceBody n, Object o) { return  unimplementedVisitor("visit(InterfaceBody, Object)"); }

    public Object visit(InterfaceMemberDeclarationList n) { return unimplementedVisitor("visit(InterfaceMemberDeclarationList)"); }
    public Object visit(InterfaceMemberDeclarationList n, Object o) { return  unimplementedVisitor("visit(InterfaceMemberDeclarationList, Object)"); }

    public Object visit(AbstractMethodDeclaration n) { return unimplementedVisitor("visit(AbstractMethodDeclaration)"); }
    public Object visit(AbstractMethodDeclaration n, Object o) { return  unimplementedVisitor("visit(AbstractMethodDeclaration, Object)"); }

    public Object visit(ArrayInitializer n) { return unimplementedVisitor("visit(ArrayInitializer)"); }
    public Object visit(ArrayInitializer n, Object o) { return  unimplementedVisitor("visit(ArrayInitializer, Object)"); }

    public Object visit(VariableInitializerList n) { return unimplementedVisitor("visit(VariableInitializerList)"); }
    public Object visit(VariableInitializerList n, Object o) { return  unimplementedVisitor("visit(VariableInitializerList, Object)"); }

    public Object visit(Block n) { return unimplementedVisitor("visit(Block)"); }
    public Object visit(Block n, Object o) { return  unimplementedVisitor("visit(Block, Object)"); }

    public Object visit(BlockStatementList n) { return unimplementedVisitor("visit(BlockStatementList)"); }
    public Object visit(BlockStatementList n, Object o) { return  unimplementedVisitor("visit(BlockStatementList, Object)"); }

    public Object visit(LocalVariableDeclarationStatement n) { return unimplementedVisitor("visit(LocalVariableDeclarationStatement)"); }
    public Object visit(LocalVariableDeclarationStatement n, Object o) { return  unimplementedVisitor("visit(LocalVariableDeclarationStatement, Object)"); }

    public Object visit(LocalVariableDeclaration n) { return unimplementedVisitor("visit(LocalVariableDeclaration)"); }
    public Object visit(LocalVariableDeclaration n, Object o) { return  unimplementedVisitor("visit(LocalVariableDeclaration, Object)"); }

    public Object visit(EmptyStatement n) { return unimplementedVisitor("visit(EmptyStatement)"); }
    public Object visit(EmptyStatement n, Object o) { return  unimplementedVisitor("visit(EmptyStatement, Object)"); }

    public Object visit(LabeledStatement n) { return unimplementedVisitor("visit(LabeledStatement)"); }
    public Object visit(LabeledStatement n, Object o) { return  unimplementedVisitor("visit(LabeledStatement, Object)"); }

    public Object visit(ExpressionStatement n) { return unimplementedVisitor("visit(ExpressionStatement)"); }
    public Object visit(ExpressionStatement n, Object o) { return  unimplementedVisitor("visit(ExpressionStatement, Object)"); }

    public Object visit(IfStatement n) { return unimplementedVisitor("visit(IfStatement)"); }
    public Object visit(IfStatement n, Object o) { return  unimplementedVisitor("visit(IfStatement, Object)"); }

    public Object visit(SwitchStatement n) { return unimplementedVisitor("visit(SwitchStatement)"); }
    public Object visit(SwitchStatement n, Object o) { return  unimplementedVisitor("visit(SwitchStatement, Object)"); }

    public Object visit(SwitchBlock n) { return unimplementedVisitor("visit(SwitchBlock)"); }
    public Object visit(SwitchBlock n, Object o) { return  unimplementedVisitor("visit(SwitchBlock, Object)"); }

    public Object visit(SwitchBlockStatementList n) { return unimplementedVisitor("visit(SwitchBlockStatementList)"); }
    public Object visit(SwitchBlockStatementList n, Object o) { return  unimplementedVisitor("visit(SwitchBlockStatementList, Object)"); }

    public Object visit(SwitchBlockStatement n) { return unimplementedVisitor("visit(SwitchBlockStatement)"); }
    public Object visit(SwitchBlockStatement n, Object o) { return  unimplementedVisitor("visit(SwitchBlockStatement, Object)"); }

    public Object visit(SwitchLabelList n) { return unimplementedVisitor("visit(SwitchLabelList)"); }
    public Object visit(SwitchLabelList n, Object o) { return  unimplementedVisitor("visit(SwitchLabelList, Object)"); }

    public Object visit(CaseLabel n) { return unimplementedVisitor("visit(CaseLabel)"); }
    public Object visit(CaseLabel n, Object o) { return  unimplementedVisitor("visit(CaseLabel, Object)"); }

    public Object visit(DefaultLabel n) { return unimplementedVisitor("visit(DefaultLabel)"); }
    public Object visit(DefaultLabel n, Object o) { return  unimplementedVisitor("visit(DefaultLabel, Object)"); }

    public Object visit(WhileStatement n) { return unimplementedVisitor("visit(WhileStatement)"); }
    public Object visit(WhileStatement n, Object o) { return  unimplementedVisitor("visit(WhileStatement, Object)"); }

    public Object visit(DoStatement n) { return unimplementedVisitor("visit(DoStatement)"); }
    public Object visit(DoStatement n, Object o) { return  unimplementedVisitor("visit(DoStatement, Object)"); }

    public Object visit(ForStatement n) { return unimplementedVisitor("visit(ForStatement)"); }
    public Object visit(ForStatement n, Object o) { return  unimplementedVisitor("visit(ForStatement, Object)"); }

    public Object visit(StatementExpressionList n) { return unimplementedVisitor("visit(StatementExpressionList)"); }
    public Object visit(StatementExpressionList n, Object o) { return  unimplementedVisitor("visit(StatementExpressionList, Object)"); }

    public Object visit(BreakStatement n) { return unimplementedVisitor("visit(BreakStatement)"); }
    public Object visit(BreakStatement n, Object o) { return  unimplementedVisitor("visit(BreakStatement, Object)"); }

    public Object visit(ContinueStatement n) { return unimplementedVisitor("visit(ContinueStatement)"); }
    public Object visit(ContinueStatement n, Object o) { return  unimplementedVisitor("visit(ContinueStatement, Object)"); }

    public Object visit(ReturnStatement n) { return unimplementedVisitor("visit(ReturnStatement)"); }
    public Object visit(ReturnStatement n, Object o) { return  unimplementedVisitor("visit(ReturnStatement, Object)"); }

    public Object visit(ThrowStatement n) { return unimplementedVisitor("visit(ThrowStatement)"); }
    public Object visit(ThrowStatement n, Object o) { return  unimplementedVisitor("visit(ThrowStatement, Object)"); }

    public Object visit(SynchronizedStatement n) { return unimplementedVisitor("visit(SynchronizedStatement)"); }
    public Object visit(SynchronizedStatement n, Object o) { return  unimplementedVisitor("visit(SynchronizedStatement, Object)"); }

    public Object visit(TryStatement n) { return unimplementedVisitor("visit(TryStatement)"); }
    public Object visit(TryStatement n, Object o) { return  unimplementedVisitor("visit(TryStatement, Object)"); }

    public Object visit(CatchClauseList n) { return unimplementedVisitor("visit(CatchClauseList)"); }
    public Object visit(CatchClauseList n, Object o) { return  unimplementedVisitor("visit(CatchClauseList, Object)"); }

    public Object visit(CatchClause n) { return unimplementedVisitor("visit(CatchClause)"); }
    public Object visit(CatchClause n, Object o) { return  unimplementedVisitor("visit(CatchClause, Object)"); }

    public Object visit(Finally n) { return unimplementedVisitor("visit(Finally)"); }
    public Object visit(Finally n, Object o) { return  unimplementedVisitor("visit(Finally, Object)"); }

    public Object visit(ParenthesizedExpression n) { return unimplementedVisitor("visit(ParenthesizedExpression)"); }
    public Object visit(ParenthesizedExpression n, Object o) { return  unimplementedVisitor("visit(ParenthesizedExpression, Object)"); }

    public Object visit(PrimaryThis n) { return unimplementedVisitor("visit(PrimaryThis)"); }
    public Object visit(PrimaryThis n, Object o) { return  unimplementedVisitor("visit(PrimaryThis, Object)"); }

    public Object visit(PrimaryClassLiteral n) { return unimplementedVisitor("visit(PrimaryClassLiteral)"); }
    public Object visit(PrimaryClassLiteral n, Object o) { return  unimplementedVisitor("visit(PrimaryClassLiteral, Object)"); }

    public Object visit(PrimaryVoidClassLiteral n) { return unimplementedVisitor("visit(PrimaryVoidClassLiteral)"); }
    public Object visit(PrimaryVoidClassLiteral n, Object o) { return  unimplementedVisitor("visit(PrimaryVoidClassLiteral, Object)"); }

    public Object visit(ClassInstanceCreationExpression n) { return unimplementedVisitor("visit(ClassInstanceCreationExpression)"); }
    public Object visit(ClassInstanceCreationExpression n, Object o) { return  unimplementedVisitor("visit(ClassInstanceCreationExpression, Object)"); }

    public Object visit(ExpressionList n) { return unimplementedVisitor("visit(ExpressionList)"); }
    public Object visit(ExpressionList n, Object o) { return  unimplementedVisitor("visit(ExpressionList, Object)"); }

    public Object visit(ArrayCreationExpression n) { return unimplementedVisitor("visit(ArrayCreationExpression)"); }
    public Object visit(ArrayCreationExpression n, Object o) { return  unimplementedVisitor("visit(ArrayCreationExpression, Object)"); }

    public Object visit(DimExprList n) { return unimplementedVisitor("visit(DimExprList)"); }
    public Object visit(DimExprList n, Object o) { return  unimplementedVisitor("visit(DimExprList, Object)"); }

    public Object visit(DimExpr n) { return unimplementedVisitor("visit(DimExpr)"); }
    public Object visit(DimExpr n, Object o) { return  unimplementedVisitor("visit(DimExpr, Object)"); }

    public Object visit(DimList n) { return unimplementedVisitor("visit(DimList)"); }
    public Object visit(DimList n, Object o) { return  unimplementedVisitor("visit(DimList, Object)"); }

    public Object visit(Dim n) { return unimplementedVisitor("visit(Dim)"); }
    public Object visit(Dim n, Object o) { return  unimplementedVisitor("visit(Dim, Object)"); }

    public Object visit(FieldAccess n) { return unimplementedVisitor("visit(FieldAccess)"); }
    public Object visit(FieldAccess n, Object o) { return  unimplementedVisitor("visit(FieldAccess, Object)"); }

    public Object visit(SuperFieldAccess n) { return unimplementedVisitor("visit(SuperFieldAccess)"); }
    public Object visit(SuperFieldAccess n, Object o) { return  unimplementedVisitor("visit(SuperFieldAccess, Object)"); }

    public Object visit(MethodInvocation n) { return unimplementedVisitor("visit(MethodInvocation)"); }
    public Object visit(MethodInvocation n, Object o) { return  unimplementedVisitor("visit(MethodInvocation, Object)"); }

    public Object visit(PrimaryMethodInvocation n) { return unimplementedVisitor("visit(PrimaryMethodInvocation)"); }
    public Object visit(PrimaryMethodInvocation n, Object o) { return  unimplementedVisitor("visit(PrimaryMethodInvocation, Object)"); }

    public Object visit(SuperMethodInvocation n) { return unimplementedVisitor("visit(SuperMethodInvocation)"); }
    public Object visit(SuperMethodInvocation n, Object o) { return  unimplementedVisitor("visit(SuperMethodInvocation, Object)"); }

    public Object visit(ArrayAccess n) { return unimplementedVisitor("visit(ArrayAccess)"); }
    public Object visit(ArrayAccess n, Object o) { return  unimplementedVisitor("visit(ArrayAccess, Object)"); }

    public Object visit(PostIncrementExpression n) { return unimplementedVisitor("visit(PostIncrementExpression)"); }
    public Object visit(PostIncrementExpression n, Object o) { return  unimplementedVisitor("visit(PostIncrementExpression, Object)"); }

    public Object visit(PostDecrementExpression n) { return unimplementedVisitor("visit(PostDecrementExpression)"); }
    public Object visit(PostDecrementExpression n, Object o) { return  unimplementedVisitor("visit(PostDecrementExpression, Object)"); }

    public Object visit(PlusUnaryExpression n) { return unimplementedVisitor("visit(PlusUnaryExpression)"); }
    public Object visit(PlusUnaryExpression n, Object o) { return  unimplementedVisitor("visit(PlusUnaryExpression, Object)"); }

    public Object visit(MinusUnaryExpression n) { return unimplementedVisitor("visit(MinusUnaryExpression)"); }
    public Object visit(MinusUnaryExpression n, Object o) { return  unimplementedVisitor("visit(MinusUnaryExpression, Object)"); }

    public Object visit(PreIncrementExpression n) { return unimplementedVisitor("visit(PreIncrementExpression)"); }
    public Object visit(PreIncrementExpression n, Object o) { return  unimplementedVisitor("visit(PreIncrementExpression, Object)"); }

    public Object visit(PreDecrementExpression n) { return unimplementedVisitor("visit(PreDecrementExpression)"); }
    public Object visit(PreDecrementExpression n, Object o) { return  unimplementedVisitor("visit(PreDecrementExpression, Object)"); }

    public Object visit(UnaryComplementExpression n) { return unimplementedVisitor("visit(UnaryComplementExpression)"); }
    public Object visit(UnaryComplementExpression n, Object o) { return  unimplementedVisitor("visit(UnaryComplementExpression, Object)"); }

    public Object visit(UnaryNotExpression n) { return unimplementedVisitor("visit(UnaryNotExpression)"); }
    public Object visit(UnaryNotExpression n, Object o) { return  unimplementedVisitor("visit(UnaryNotExpression, Object)"); }

    public Object visit(PrimitiveCastExpression n) { return unimplementedVisitor("visit(PrimitiveCastExpression)"); }
    public Object visit(PrimitiveCastExpression n, Object o) { return  unimplementedVisitor("visit(PrimitiveCastExpression, Object)"); }

    public Object visit(ClassCastExpression n) { return unimplementedVisitor("visit(ClassCastExpression)"); }
    public Object visit(ClassCastExpression n, Object o) { return  unimplementedVisitor("visit(ClassCastExpression, Object)"); }

    public Object visit(MultiplyExpression n) { return unimplementedVisitor("visit(MultiplyExpression)"); }
    public Object visit(MultiplyExpression n, Object o) { return  unimplementedVisitor("visit(MultiplyExpression, Object)"); }

    public Object visit(DivideExpression n) { return unimplementedVisitor("visit(DivideExpression)"); }
    public Object visit(DivideExpression n, Object o) { return  unimplementedVisitor("visit(DivideExpression, Object)"); }

    public Object visit(ModExpression n) { return unimplementedVisitor("visit(ModExpression)"); }
    public Object visit(ModExpression n, Object o) { return  unimplementedVisitor("visit(ModExpression, Object)"); }

    public Object visit(AddExpression n) { return unimplementedVisitor("visit(AddExpression)"); }
    public Object visit(AddExpression n, Object o) { return  unimplementedVisitor("visit(AddExpression, Object)"); }

    public Object visit(SubtractExpression n) { return unimplementedVisitor("visit(SubtractExpression)"); }
    public Object visit(SubtractExpression n, Object o) { return  unimplementedVisitor("visit(SubtractExpression, Object)"); }

    public Object visit(LeftShiftExpression n) { return unimplementedVisitor("visit(LeftShiftExpression)"); }
    public Object visit(LeftShiftExpression n, Object o) { return  unimplementedVisitor("visit(LeftShiftExpression, Object)"); }

    public Object visit(RightShiftExpression n) { return unimplementedVisitor("visit(RightShiftExpression)"); }
    public Object visit(RightShiftExpression n, Object o) { return  unimplementedVisitor("visit(RightShiftExpression, Object)"); }

    public Object visit(UnsignedRightShiftExpression n) { return unimplementedVisitor("visit(UnsignedRightShiftExpression)"); }
    public Object visit(UnsignedRightShiftExpression n, Object o) { return  unimplementedVisitor("visit(UnsignedRightShiftExpression, Object)"); }

    public Object visit(LessExpression n) { return unimplementedVisitor("visit(LessExpression)"); }
    public Object visit(LessExpression n, Object o) { return  unimplementedVisitor("visit(LessExpression, Object)"); }

    public Object visit(GreaterExpression n) { return unimplementedVisitor("visit(GreaterExpression)"); }
    public Object visit(GreaterExpression n, Object o) { return  unimplementedVisitor("visit(GreaterExpression, Object)"); }

    public Object visit(LessEqualExpression n) { return unimplementedVisitor("visit(LessEqualExpression)"); }
    public Object visit(LessEqualExpression n, Object o) { return  unimplementedVisitor("visit(LessEqualExpression, Object)"); }

    public Object visit(GreaterEqualExpression n) { return unimplementedVisitor("visit(GreaterEqualExpression)"); }
    public Object visit(GreaterEqualExpression n, Object o) { return  unimplementedVisitor("visit(GreaterEqualExpression, Object)"); }

    public Object visit(InstanceofExpression n) { return unimplementedVisitor("visit(InstanceofExpression)"); }
    public Object visit(InstanceofExpression n, Object o) { return  unimplementedVisitor("visit(InstanceofExpression, Object)"); }

    public Object visit(EqualExpression n) { return unimplementedVisitor("visit(EqualExpression)"); }
    public Object visit(EqualExpression n, Object o) { return  unimplementedVisitor("visit(EqualExpression, Object)"); }

    public Object visit(NotEqualExpression n) { return unimplementedVisitor("visit(NotEqualExpression)"); }
    public Object visit(NotEqualExpression n, Object o) { return  unimplementedVisitor("visit(NotEqualExpression, Object)"); }

    public Object visit(AndExpression n) { return unimplementedVisitor("visit(AndExpression)"); }
    public Object visit(AndExpression n, Object o) { return  unimplementedVisitor("visit(AndExpression, Object)"); }

    public Object visit(ExclusiveOrExpression n) { return unimplementedVisitor("visit(ExclusiveOrExpression)"); }
    public Object visit(ExclusiveOrExpression n, Object o) { return  unimplementedVisitor("visit(ExclusiveOrExpression, Object)"); }

    public Object visit(InclusiveOrExpression n) { return unimplementedVisitor("visit(InclusiveOrExpression)"); }
    public Object visit(InclusiveOrExpression n, Object o) { return  unimplementedVisitor("visit(InclusiveOrExpression, Object)"); }

    public Object visit(ConditionalAndExpression n) { return unimplementedVisitor("visit(ConditionalAndExpression)"); }
    public Object visit(ConditionalAndExpression n, Object o) { return  unimplementedVisitor("visit(ConditionalAndExpression, Object)"); }

    public Object visit(ConditionalOrExpression n) { return unimplementedVisitor("visit(ConditionalOrExpression)"); }
    public Object visit(ConditionalOrExpression n, Object o) { return  unimplementedVisitor("visit(ConditionalOrExpression, Object)"); }

    public Object visit(ConditionalExpression n) { return unimplementedVisitor("visit(ConditionalExpression)"); }
    public Object visit(ConditionalExpression n, Object o) { return  unimplementedVisitor("visit(ConditionalExpression, Object)"); }

    public Object visit(Assignment n) { return unimplementedVisitor("visit(Assignment)"); }
    public Object visit(Assignment n, Object o) { return  unimplementedVisitor("visit(Assignment, Object)"); }

    public Object visit(EqualOperator n) { return unimplementedVisitor("visit(EqualOperator)"); }
    public Object visit(EqualOperator n, Object o) { return  unimplementedVisitor("visit(EqualOperator, Object)"); }

    public Object visit(MultiplyEqualOperator n) { return unimplementedVisitor("visit(MultiplyEqualOperator)"); }
    public Object visit(MultiplyEqualOperator n, Object o) { return  unimplementedVisitor("visit(MultiplyEqualOperator, Object)"); }

    public Object visit(DivideEqualOperator n) { return unimplementedVisitor("visit(DivideEqualOperator)"); }
    public Object visit(DivideEqualOperator n, Object o) { return  unimplementedVisitor("visit(DivideEqualOperator, Object)"); }

    public Object visit(ModEqualOperator n) { return unimplementedVisitor("visit(ModEqualOperator)"); }
    public Object visit(ModEqualOperator n, Object o) { return  unimplementedVisitor("visit(ModEqualOperator, Object)"); }

    public Object visit(PlusEqualOperator n) { return unimplementedVisitor("visit(PlusEqualOperator)"); }
    public Object visit(PlusEqualOperator n, Object o) { return  unimplementedVisitor("visit(PlusEqualOperator, Object)"); }

    public Object visit(MinusEqualOperator n) { return unimplementedVisitor("visit(MinusEqualOperator)"); }
    public Object visit(MinusEqualOperator n, Object o) { return  unimplementedVisitor("visit(MinusEqualOperator, Object)"); }

    public Object visit(LeftShiftEqualOperator n) { return unimplementedVisitor("visit(LeftShiftEqualOperator)"); }
    public Object visit(LeftShiftEqualOperator n, Object o) { return  unimplementedVisitor("visit(LeftShiftEqualOperator, Object)"); }

    public Object visit(RightShiftEqualOperator n) { return unimplementedVisitor("visit(RightShiftEqualOperator)"); }
    public Object visit(RightShiftEqualOperator n, Object o) { return  unimplementedVisitor("visit(RightShiftEqualOperator, Object)"); }

    public Object visit(UnsignedRightShiftEqualOperator n) { return unimplementedVisitor("visit(UnsignedRightShiftEqualOperator)"); }
    public Object visit(UnsignedRightShiftEqualOperator n, Object o) { return  unimplementedVisitor("visit(UnsignedRightShiftEqualOperator, Object)"); }

    public Object visit(AndEqualOperator n) { return unimplementedVisitor("visit(AndEqualOperator)"); }
    public Object visit(AndEqualOperator n, Object o) { return  unimplementedVisitor("visit(AndEqualOperator, Object)"); }

    public Object visit(ExclusiveOrEqualOperator n) { return unimplementedVisitor("visit(ExclusiveOrEqualOperator)"); }
    public Object visit(ExclusiveOrEqualOperator n, Object o) { return  unimplementedVisitor("visit(ExclusiveOrEqualOperator, Object)"); }

    public Object visit(OrEqualOperator n) { return unimplementedVisitor("visit(OrEqualOperator)"); }
    public Object visit(OrEqualOperator n, Object o) { return  unimplementedVisitor("visit(OrEqualOperator, Object)"); }

    public Object visit(Commaopt n) { return unimplementedVisitor("visit(Commaopt)"); }
    public Object visit(Commaopt n, Object o) { return  unimplementedVisitor("visit(Commaopt, Object)"); }

    public Object visit(IDENTIFIERopt n) { return unimplementedVisitor("visit(IDENTIFIERopt)"); }
    public Object visit(IDENTIFIERopt n, Object o) { return  unimplementedVisitor("visit(IDENTIFIERopt, Object)"); }
}

