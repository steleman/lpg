//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

public abstract class AbstractVisitor implements Visitor, ArgumentVisitor
{
    public abstract void unimplementedVisitor(String s);

    public void visit(AstToken n) { unimplementedVisitor("visit(AstToken)"); }
    public void visit(AstToken n, Object o) { unimplementedVisitor("visit(AstToken, Object)"); }

    public void visit(IntegerLiteral n) { unimplementedVisitor("visit(IntegerLiteral)"); }
    public void visit(IntegerLiteral n, Object o) { unimplementedVisitor("visit(IntegerLiteral, Object)"); }

    public void visit(LongLiteral n) { unimplementedVisitor("visit(LongLiteral)"); }
    public void visit(LongLiteral n, Object o) { unimplementedVisitor("visit(LongLiteral, Object)"); }

    public void visit(FloatLiteral n) { unimplementedVisitor("visit(FloatLiteral)"); }
    public void visit(FloatLiteral n, Object o) { unimplementedVisitor("visit(FloatLiteral, Object)"); }

    public void visit(DoubleLiteral n) { unimplementedVisitor("visit(DoubleLiteral)"); }
    public void visit(DoubleLiteral n, Object o) { unimplementedVisitor("visit(DoubleLiteral, Object)"); }

    public void visit(BooleanLiteral n) { unimplementedVisitor("visit(BooleanLiteral)"); }
    public void visit(BooleanLiteral n, Object o) { unimplementedVisitor("visit(BooleanLiteral, Object)"); }

    public void visit(CharacterLiteral n) { unimplementedVisitor("visit(CharacterLiteral)"); }
    public void visit(CharacterLiteral n, Object o) { unimplementedVisitor("visit(CharacterLiteral, Object)"); }

    public void visit(StringLiteral n) { unimplementedVisitor("visit(StringLiteral)"); }
    public void visit(StringLiteral n, Object o) { unimplementedVisitor("visit(StringLiteral, Object)"); }

    public void visit(NullLiteral n) { unimplementedVisitor("visit(NullLiteral)"); }
    public void visit(NullLiteral n, Object o) { unimplementedVisitor("visit(NullLiteral, Object)"); }

    public void visit(TrueLiteral n) { unimplementedVisitor("visit(TrueLiteral)"); }
    public void visit(TrueLiteral n, Object o) { unimplementedVisitor("visit(TrueLiteral, Object)"); }

    public void visit(FalseLiteral n) { unimplementedVisitor("visit(FalseLiteral)"); }
    public void visit(FalseLiteral n, Object o) { unimplementedVisitor("visit(FalseLiteral, Object)"); }

    public void visit(BooleanType n) { unimplementedVisitor("visit(BooleanType)"); }
    public void visit(BooleanType n, Object o) { unimplementedVisitor("visit(BooleanType, Object)"); }

    public void visit(ByteType n) { unimplementedVisitor("visit(ByteType)"); }
    public void visit(ByteType n, Object o) { unimplementedVisitor("visit(ByteType, Object)"); }

    public void visit(ShortType n) { unimplementedVisitor("visit(ShortType)"); }
    public void visit(ShortType n, Object o) { unimplementedVisitor("visit(ShortType, Object)"); }

    public void visit(IntType n) { unimplementedVisitor("visit(IntType)"); }
    public void visit(IntType n, Object o) { unimplementedVisitor("visit(IntType, Object)"); }

    public void visit(LongType n) { unimplementedVisitor("visit(LongType)"); }
    public void visit(LongType n, Object o) { unimplementedVisitor("visit(LongType, Object)"); }

    public void visit(CharType n) { unimplementedVisitor("visit(CharType)"); }
    public void visit(CharType n, Object o) { unimplementedVisitor("visit(CharType, Object)"); }

    public void visit(FloatType n) { unimplementedVisitor("visit(FloatType)"); }
    public void visit(FloatType n, Object o) { unimplementedVisitor("visit(FloatType, Object)"); }

    public void visit(DoubleType n) { unimplementedVisitor("visit(DoubleType)"); }
    public void visit(DoubleType n, Object o) { unimplementedVisitor("visit(DoubleType, Object)"); }

    public void visit(PrimitiveArrayType n) { unimplementedVisitor("visit(PrimitiveArrayType)"); }
    public void visit(PrimitiveArrayType n, Object o) { unimplementedVisitor("visit(PrimitiveArrayType, Object)"); }

    public void visit(ClassOrInterfaceArrayType n) { unimplementedVisitor("visit(ClassOrInterfaceArrayType)"); }
    public void visit(ClassOrInterfaceArrayType n, Object o) { unimplementedVisitor("visit(ClassOrInterfaceArrayType, Object)"); }

    public void visit(SimpleName n) { unimplementedVisitor("visit(SimpleName)"); }
    public void visit(SimpleName n, Object o) { unimplementedVisitor("visit(SimpleName, Object)"); }

    public void visit(QualifiedName n) { unimplementedVisitor("visit(QualifiedName)"); }
    public void visit(QualifiedName n, Object o) { unimplementedVisitor("visit(QualifiedName, Object)"); }

    public void visit(CompilationUnit n) { unimplementedVisitor("visit(CompilationUnit)"); }
    public void visit(CompilationUnit n, Object o) { unimplementedVisitor("visit(CompilationUnit, Object)"); }

    public void visit(ImportDeclarationList n) { unimplementedVisitor("visit(ImportDeclarationList)"); }
    public void visit(ImportDeclarationList n, Object o) { unimplementedVisitor("visit(ImportDeclarationList, Object)"); }

    public void visit(TypeDeclarationList n) { unimplementedVisitor("visit(TypeDeclarationList)"); }
    public void visit(TypeDeclarationList n, Object o) { unimplementedVisitor("visit(TypeDeclarationList, Object)"); }

    public void visit(PackageDeclaration n) { unimplementedVisitor("visit(PackageDeclaration)"); }
    public void visit(PackageDeclaration n, Object o) { unimplementedVisitor("visit(PackageDeclaration, Object)"); }

    public void visit(SingleTypeImportDeclaration n) { unimplementedVisitor("visit(SingleTypeImportDeclaration)"); }
    public void visit(SingleTypeImportDeclaration n, Object o) { unimplementedVisitor("visit(SingleTypeImportDeclaration, Object)"); }

    public void visit(TypeImportOnDemandDeclaration n) { unimplementedVisitor("visit(TypeImportOnDemandDeclaration)"); }
    public void visit(TypeImportOnDemandDeclaration n, Object o) { unimplementedVisitor("visit(TypeImportOnDemandDeclaration, Object)"); }

    public void visit(EmptyDeclaration n) { unimplementedVisitor("visit(EmptyDeclaration)"); }
    public void visit(EmptyDeclaration n, Object o) { unimplementedVisitor("visit(EmptyDeclaration, Object)"); }

    public void visit(ModifierList n) { unimplementedVisitor("visit(ModifierList)"); }
    public void visit(ModifierList n, Object o) { unimplementedVisitor("visit(ModifierList, Object)"); }

    public void visit(PublicModifier n) { unimplementedVisitor("visit(PublicModifier)"); }
    public void visit(PublicModifier n, Object o) { unimplementedVisitor("visit(PublicModifier, Object)"); }

    public void visit(ProtectedModifier n) { unimplementedVisitor("visit(ProtectedModifier)"); }
    public void visit(ProtectedModifier n, Object o) { unimplementedVisitor("visit(ProtectedModifier, Object)"); }

    public void visit(PrivateModifier n) { unimplementedVisitor("visit(PrivateModifier)"); }
    public void visit(PrivateModifier n, Object o) { unimplementedVisitor("visit(PrivateModifier, Object)"); }

    public void visit(StaticModifier n) { unimplementedVisitor("visit(StaticModifier)"); }
    public void visit(StaticModifier n, Object o) { unimplementedVisitor("visit(StaticModifier, Object)"); }

    public void visit(AbstractModifier n) { unimplementedVisitor("visit(AbstractModifier)"); }
    public void visit(AbstractModifier n, Object o) { unimplementedVisitor("visit(AbstractModifier, Object)"); }

    public void visit(FinalModifier n) { unimplementedVisitor("visit(FinalModifier)"); }
    public void visit(FinalModifier n, Object o) { unimplementedVisitor("visit(FinalModifier, Object)"); }

    public void visit(NativeModifier n) { unimplementedVisitor("visit(NativeModifier)"); }
    public void visit(NativeModifier n, Object o) { unimplementedVisitor("visit(NativeModifier, Object)"); }

    public void visit(StrictfpModifier n) { unimplementedVisitor("visit(StrictfpModifier)"); }
    public void visit(StrictfpModifier n, Object o) { unimplementedVisitor("visit(StrictfpModifier, Object)"); }

    public void visit(SynchronizedModifier n) { unimplementedVisitor("visit(SynchronizedModifier)"); }
    public void visit(SynchronizedModifier n, Object o) { unimplementedVisitor("visit(SynchronizedModifier, Object)"); }

    public void visit(TransientModifier n) { unimplementedVisitor("visit(TransientModifier)"); }
    public void visit(TransientModifier n, Object o) { unimplementedVisitor("visit(TransientModifier, Object)"); }

    public void visit(VolatileModifier n) { unimplementedVisitor("visit(VolatileModifier)"); }
    public void visit(VolatileModifier n, Object o) { unimplementedVisitor("visit(VolatileModifier, Object)"); }

    public void visit(ClassDeclaration n) { unimplementedVisitor("visit(ClassDeclaration)"); }
    public void visit(ClassDeclaration n, Object o) { unimplementedVisitor("visit(ClassDeclaration, Object)"); }

    public void visit(Super n) { unimplementedVisitor("visit(Super)"); }
    public void visit(Super n, Object o) { unimplementedVisitor("visit(Super, Object)"); }

    public void visit(InterfaceTypeList n) { unimplementedVisitor("visit(InterfaceTypeList)"); }
    public void visit(InterfaceTypeList n, Object o) { unimplementedVisitor("visit(InterfaceTypeList, Object)"); }

    public void visit(ClassBody n) { unimplementedVisitor("visit(ClassBody)"); }
    public void visit(ClassBody n, Object o) { unimplementedVisitor("visit(ClassBody, Object)"); }

    public void visit(ClassBodyDeclarationList n) { unimplementedVisitor("visit(ClassBodyDeclarationList)"); }
    public void visit(ClassBodyDeclarationList n, Object o) { unimplementedVisitor("visit(ClassBodyDeclarationList, Object)"); }

    public void visit(FieldDeclaration n) { unimplementedVisitor("visit(FieldDeclaration)"); }
    public void visit(FieldDeclaration n, Object o) { unimplementedVisitor("visit(FieldDeclaration, Object)"); }

    public void visit(VariableDeclaratorList n) { unimplementedVisitor("visit(VariableDeclaratorList)"); }
    public void visit(VariableDeclaratorList n, Object o) { unimplementedVisitor("visit(VariableDeclaratorList, Object)"); }

    public void visit(VariableDeclarator n) { unimplementedVisitor("visit(VariableDeclarator)"); }
    public void visit(VariableDeclarator n, Object o) { unimplementedVisitor("visit(VariableDeclarator, Object)"); }

    public void visit(VariableDeclaratorId n) { unimplementedVisitor("visit(VariableDeclaratorId)"); }
    public void visit(VariableDeclaratorId n, Object o) { unimplementedVisitor("visit(VariableDeclaratorId, Object)"); }

    public void visit(MethodDeclaration n) { unimplementedVisitor("visit(MethodDeclaration)"); }
    public void visit(MethodDeclaration n, Object o) { unimplementedVisitor("visit(MethodDeclaration, Object)"); }

    public void visit(TypedMethodHeader n) { unimplementedVisitor("visit(TypedMethodHeader)"); }
    public void visit(TypedMethodHeader n, Object o) { unimplementedVisitor("visit(TypedMethodHeader, Object)"); }

    public void visit(VoidMethodHeader n) { unimplementedVisitor("visit(VoidMethodHeader)"); }
    public void visit(VoidMethodHeader n, Object o) { unimplementedVisitor("visit(VoidMethodHeader, Object)"); }

    public void visit(MethodDeclarator n) { unimplementedVisitor("visit(MethodDeclarator)"); }
    public void visit(MethodDeclarator n, Object o) { unimplementedVisitor("visit(MethodDeclarator, Object)"); }

    public void visit(FormalParameterList n) { unimplementedVisitor("visit(FormalParameterList)"); }
    public void visit(FormalParameterList n, Object o) { unimplementedVisitor("visit(FormalParameterList, Object)"); }

    public void visit(FormalParameter n) { unimplementedVisitor("visit(FormalParameter)"); }
    public void visit(FormalParameter n, Object o) { unimplementedVisitor("visit(FormalParameter, Object)"); }

    public void visit(ClassTypeList n) { unimplementedVisitor("visit(ClassTypeList)"); }
    public void visit(ClassTypeList n, Object o) { unimplementedVisitor("visit(ClassTypeList, Object)"); }

    public void visit(EmptyMethodBody n) { unimplementedVisitor("visit(EmptyMethodBody)"); }
    public void visit(EmptyMethodBody n, Object o) { unimplementedVisitor("visit(EmptyMethodBody, Object)"); }

    public void visit(StaticInitializer n) { unimplementedVisitor("visit(StaticInitializer)"); }
    public void visit(StaticInitializer n, Object o) { unimplementedVisitor("visit(StaticInitializer, Object)"); }

    public void visit(ConstructorDeclaration n) { unimplementedVisitor("visit(ConstructorDeclaration)"); }
    public void visit(ConstructorDeclaration n, Object o) { unimplementedVisitor("visit(ConstructorDeclaration, Object)"); }

    public void visit(ConstructorDeclarator n) { unimplementedVisitor("visit(ConstructorDeclarator)"); }
    public void visit(ConstructorDeclarator n, Object o) { unimplementedVisitor("visit(ConstructorDeclarator, Object)"); }

    public void visit(ConstructorBody n) { unimplementedVisitor("visit(ConstructorBody)"); }
    public void visit(ConstructorBody n, Object o) { unimplementedVisitor("visit(ConstructorBody, Object)"); }

    public void visit(ThisCall n) { unimplementedVisitor("visit(ThisCall)"); }
    public void visit(ThisCall n, Object o) { unimplementedVisitor("visit(ThisCall, Object)"); }

    public void visit(SuperCall n) { unimplementedVisitor("visit(SuperCall)"); }
    public void visit(SuperCall n, Object o) { unimplementedVisitor("visit(SuperCall, Object)"); }

    public void visit(InterfaceDeclaration n) { unimplementedVisitor("visit(InterfaceDeclaration)"); }
    public void visit(InterfaceDeclaration n, Object o) { unimplementedVisitor("visit(InterfaceDeclaration, Object)"); }

    public void visit(InterfaceBody n) { unimplementedVisitor("visit(InterfaceBody)"); }
    public void visit(InterfaceBody n, Object o) { unimplementedVisitor("visit(InterfaceBody, Object)"); }

    public void visit(InterfaceMemberDeclarationList n) { unimplementedVisitor("visit(InterfaceMemberDeclarationList)"); }
    public void visit(InterfaceMemberDeclarationList n, Object o) { unimplementedVisitor("visit(InterfaceMemberDeclarationList, Object)"); }

    public void visit(AbstractMethodDeclaration n) { unimplementedVisitor("visit(AbstractMethodDeclaration)"); }
    public void visit(AbstractMethodDeclaration n, Object o) { unimplementedVisitor("visit(AbstractMethodDeclaration, Object)"); }

    public void visit(ArrayInitializer n) { unimplementedVisitor("visit(ArrayInitializer)"); }
    public void visit(ArrayInitializer n, Object o) { unimplementedVisitor("visit(ArrayInitializer, Object)"); }

    public void visit(VariableInitializerList n) { unimplementedVisitor("visit(VariableInitializerList)"); }
    public void visit(VariableInitializerList n, Object o) { unimplementedVisitor("visit(VariableInitializerList, Object)"); }

    public void visit(Block n) { unimplementedVisitor("visit(Block)"); }
    public void visit(Block n, Object o) { unimplementedVisitor("visit(Block, Object)"); }

    public void visit(BlockStatementList n) { unimplementedVisitor("visit(BlockStatementList)"); }
    public void visit(BlockStatementList n, Object o) { unimplementedVisitor("visit(BlockStatementList, Object)"); }

    public void visit(LocalVariableDeclarationStatement n) { unimplementedVisitor("visit(LocalVariableDeclarationStatement)"); }
    public void visit(LocalVariableDeclarationStatement n, Object o) { unimplementedVisitor("visit(LocalVariableDeclarationStatement, Object)"); }

    public void visit(LocalVariableDeclaration n) { unimplementedVisitor("visit(LocalVariableDeclaration)"); }
    public void visit(LocalVariableDeclaration n, Object o) { unimplementedVisitor("visit(LocalVariableDeclaration, Object)"); }

    public void visit(EmptyStatement n) { unimplementedVisitor("visit(EmptyStatement)"); }
    public void visit(EmptyStatement n, Object o) { unimplementedVisitor("visit(EmptyStatement, Object)"); }

    public void visit(LabeledStatement n) { unimplementedVisitor("visit(LabeledStatement)"); }
    public void visit(LabeledStatement n, Object o) { unimplementedVisitor("visit(LabeledStatement, Object)"); }

    public void visit(ExpressionStatement n) { unimplementedVisitor("visit(ExpressionStatement)"); }
    public void visit(ExpressionStatement n, Object o) { unimplementedVisitor("visit(ExpressionStatement, Object)"); }

    public void visit(IfStatement n) { unimplementedVisitor("visit(IfStatement)"); }
    public void visit(IfStatement n, Object o) { unimplementedVisitor("visit(IfStatement, Object)"); }

    public void visit(SwitchStatement n) { unimplementedVisitor("visit(SwitchStatement)"); }
    public void visit(SwitchStatement n, Object o) { unimplementedVisitor("visit(SwitchStatement, Object)"); }

    public void visit(SwitchBlock n) { unimplementedVisitor("visit(SwitchBlock)"); }
    public void visit(SwitchBlock n, Object o) { unimplementedVisitor("visit(SwitchBlock, Object)"); }

    public void visit(SwitchBlockStatementList n) { unimplementedVisitor("visit(SwitchBlockStatementList)"); }
    public void visit(SwitchBlockStatementList n, Object o) { unimplementedVisitor("visit(SwitchBlockStatementList, Object)"); }

    public void visit(SwitchBlockStatement n) { unimplementedVisitor("visit(SwitchBlockStatement)"); }
    public void visit(SwitchBlockStatement n, Object o) { unimplementedVisitor("visit(SwitchBlockStatement, Object)"); }

    public void visit(SwitchLabelList n) { unimplementedVisitor("visit(SwitchLabelList)"); }
    public void visit(SwitchLabelList n, Object o) { unimplementedVisitor("visit(SwitchLabelList, Object)"); }

    public void visit(CaseLabel n) { unimplementedVisitor("visit(CaseLabel)"); }
    public void visit(CaseLabel n, Object o) { unimplementedVisitor("visit(CaseLabel, Object)"); }

    public void visit(DefaultLabel n) { unimplementedVisitor("visit(DefaultLabel)"); }
    public void visit(DefaultLabel n, Object o) { unimplementedVisitor("visit(DefaultLabel, Object)"); }

    public void visit(WhileStatement n) { unimplementedVisitor("visit(WhileStatement)"); }
    public void visit(WhileStatement n, Object o) { unimplementedVisitor("visit(WhileStatement, Object)"); }

    public void visit(DoStatement n) { unimplementedVisitor("visit(DoStatement)"); }
    public void visit(DoStatement n, Object o) { unimplementedVisitor("visit(DoStatement, Object)"); }

    public void visit(ForStatement n) { unimplementedVisitor("visit(ForStatement)"); }
    public void visit(ForStatement n, Object o) { unimplementedVisitor("visit(ForStatement, Object)"); }

    public void visit(StatementExpressionList n) { unimplementedVisitor("visit(StatementExpressionList)"); }
    public void visit(StatementExpressionList n, Object o) { unimplementedVisitor("visit(StatementExpressionList, Object)"); }

    public void visit(BreakStatement n) { unimplementedVisitor("visit(BreakStatement)"); }
    public void visit(BreakStatement n, Object o) { unimplementedVisitor("visit(BreakStatement, Object)"); }

    public void visit(ContinueStatement n) { unimplementedVisitor("visit(ContinueStatement)"); }
    public void visit(ContinueStatement n, Object o) { unimplementedVisitor("visit(ContinueStatement, Object)"); }

    public void visit(ReturnStatement n) { unimplementedVisitor("visit(ReturnStatement)"); }
    public void visit(ReturnStatement n, Object o) { unimplementedVisitor("visit(ReturnStatement, Object)"); }

    public void visit(ThrowStatement n) { unimplementedVisitor("visit(ThrowStatement)"); }
    public void visit(ThrowStatement n, Object o) { unimplementedVisitor("visit(ThrowStatement, Object)"); }

    public void visit(SynchronizedStatement n) { unimplementedVisitor("visit(SynchronizedStatement)"); }
    public void visit(SynchronizedStatement n, Object o) { unimplementedVisitor("visit(SynchronizedStatement, Object)"); }

    public void visit(TryStatement n) { unimplementedVisitor("visit(TryStatement)"); }
    public void visit(TryStatement n, Object o) { unimplementedVisitor("visit(TryStatement, Object)"); }

    public void visit(CatchClauseList n) { unimplementedVisitor("visit(CatchClauseList)"); }
    public void visit(CatchClauseList n, Object o) { unimplementedVisitor("visit(CatchClauseList, Object)"); }

    public void visit(CatchClause n) { unimplementedVisitor("visit(CatchClause)"); }
    public void visit(CatchClause n, Object o) { unimplementedVisitor("visit(CatchClause, Object)"); }

    public void visit(Finally n) { unimplementedVisitor("visit(Finally)"); }
    public void visit(Finally n, Object o) { unimplementedVisitor("visit(Finally, Object)"); }

    public void visit(ParenthesizedExpression n) { unimplementedVisitor("visit(ParenthesizedExpression)"); }
    public void visit(ParenthesizedExpression n, Object o) { unimplementedVisitor("visit(ParenthesizedExpression, Object)"); }

    public void visit(PrimaryThis n) { unimplementedVisitor("visit(PrimaryThis)"); }
    public void visit(PrimaryThis n, Object o) { unimplementedVisitor("visit(PrimaryThis, Object)"); }

    public void visit(PrimaryClassLiteral n) { unimplementedVisitor("visit(PrimaryClassLiteral)"); }
    public void visit(PrimaryClassLiteral n, Object o) { unimplementedVisitor("visit(PrimaryClassLiteral, Object)"); }

    public void visit(PrimaryVoidClassLiteral n) { unimplementedVisitor("visit(PrimaryVoidClassLiteral)"); }
    public void visit(PrimaryVoidClassLiteral n, Object o) { unimplementedVisitor("visit(PrimaryVoidClassLiteral, Object)"); }

    public void visit(ClassInstanceCreationExpression n) { unimplementedVisitor("visit(ClassInstanceCreationExpression)"); }
    public void visit(ClassInstanceCreationExpression n, Object o) { unimplementedVisitor("visit(ClassInstanceCreationExpression, Object)"); }

    public void visit(ExpressionList n) { unimplementedVisitor("visit(ExpressionList)"); }
    public void visit(ExpressionList n, Object o) { unimplementedVisitor("visit(ExpressionList, Object)"); }

    public void visit(ArrayCreationExpression n) { unimplementedVisitor("visit(ArrayCreationExpression)"); }
    public void visit(ArrayCreationExpression n, Object o) { unimplementedVisitor("visit(ArrayCreationExpression, Object)"); }

    public void visit(DimExprList n) { unimplementedVisitor("visit(DimExprList)"); }
    public void visit(DimExprList n, Object o) { unimplementedVisitor("visit(DimExprList, Object)"); }

    public void visit(DimExpr n) { unimplementedVisitor("visit(DimExpr)"); }
    public void visit(DimExpr n, Object o) { unimplementedVisitor("visit(DimExpr, Object)"); }

    public void visit(DimList n) { unimplementedVisitor("visit(DimList)"); }
    public void visit(DimList n, Object o) { unimplementedVisitor("visit(DimList, Object)"); }

    public void visit(Dim n) { unimplementedVisitor("visit(Dim)"); }
    public void visit(Dim n, Object o) { unimplementedVisitor("visit(Dim, Object)"); }

    public void visit(FieldAccess n) { unimplementedVisitor("visit(FieldAccess)"); }
    public void visit(FieldAccess n, Object o) { unimplementedVisitor("visit(FieldAccess, Object)"); }

    public void visit(SuperFieldAccess n) { unimplementedVisitor("visit(SuperFieldAccess)"); }
    public void visit(SuperFieldAccess n, Object o) { unimplementedVisitor("visit(SuperFieldAccess, Object)"); }

    public void visit(MethodInvocation n) { unimplementedVisitor("visit(MethodInvocation)"); }
    public void visit(MethodInvocation n, Object o) { unimplementedVisitor("visit(MethodInvocation, Object)"); }

    public void visit(PrimaryMethodInvocation n) { unimplementedVisitor("visit(PrimaryMethodInvocation)"); }
    public void visit(PrimaryMethodInvocation n, Object o) { unimplementedVisitor("visit(PrimaryMethodInvocation, Object)"); }

    public void visit(SuperMethodInvocation n) { unimplementedVisitor("visit(SuperMethodInvocation)"); }
    public void visit(SuperMethodInvocation n, Object o) { unimplementedVisitor("visit(SuperMethodInvocation, Object)"); }

    public void visit(ArrayAccess n) { unimplementedVisitor("visit(ArrayAccess)"); }
    public void visit(ArrayAccess n, Object o) { unimplementedVisitor("visit(ArrayAccess, Object)"); }

    public void visit(PostIncrementExpression n) { unimplementedVisitor("visit(PostIncrementExpression)"); }
    public void visit(PostIncrementExpression n, Object o) { unimplementedVisitor("visit(PostIncrementExpression, Object)"); }

    public void visit(PostDecrementExpression n) { unimplementedVisitor("visit(PostDecrementExpression)"); }
    public void visit(PostDecrementExpression n, Object o) { unimplementedVisitor("visit(PostDecrementExpression, Object)"); }

    public void visit(PlusUnaryExpression n) { unimplementedVisitor("visit(PlusUnaryExpression)"); }
    public void visit(PlusUnaryExpression n, Object o) { unimplementedVisitor("visit(PlusUnaryExpression, Object)"); }

    public void visit(MinusUnaryExpression n) { unimplementedVisitor("visit(MinusUnaryExpression)"); }
    public void visit(MinusUnaryExpression n, Object o) { unimplementedVisitor("visit(MinusUnaryExpression, Object)"); }

    public void visit(PreIncrementExpression n) { unimplementedVisitor("visit(PreIncrementExpression)"); }
    public void visit(PreIncrementExpression n, Object o) { unimplementedVisitor("visit(PreIncrementExpression, Object)"); }

    public void visit(PreDecrementExpression n) { unimplementedVisitor("visit(PreDecrementExpression)"); }
    public void visit(PreDecrementExpression n, Object o) { unimplementedVisitor("visit(PreDecrementExpression, Object)"); }

    public void visit(UnaryComplementExpression n) { unimplementedVisitor("visit(UnaryComplementExpression)"); }
    public void visit(UnaryComplementExpression n, Object o) { unimplementedVisitor("visit(UnaryComplementExpression, Object)"); }

    public void visit(UnaryNotExpression n) { unimplementedVisitor("visit(UnaryNotExpression)"); }
    public void visit(UnaryNotExpression n, Object o) { unimplementedVisitor("visit(UnaryNotExpression, Object)"); }

    public void visit(PrimitiveCastExpression n) { unimplementedVisitor("visit(PrimitiveCastExpression)"); }
    public void visit(PrimitiveCastExpression n, Object o) { unimplementedVisitor("visit(PrimitiveCastExpression, Object)"); }

    public void visit(ClassCastExpression n) { unimplementedVisitor("visit(ClassCastExpression)"); }
    public void visit(ClassCastExpression n, Object o) { unimplementedVisitor("visit(ClassCastExpression, Object)"); }

    public void visit(MultiplyExpression n) { unimplementedVisitor("visit(MultiplyExpression)"); }
    public void visit(MultiplyExpression n, Object o) { unimplementedVisitor("visit(MultiplyExpression, Object)"); }

    public void visit(DivideExpression n) { unimplementedVisitor("visit(DivideExpression)"); }
    public void visit(DivideExpression n, Object o) { unimplementedVisitor("visit(DivideExpression, Object)"); }

    public void visit(ModExpression n) { unimplementedVisitor("visit(ModExpression)"); }
    public void visit(ModExpression n, Object o) { unimplementedVisitor("visit(ModExpression, Object)"); }

    public void visit(AddExpression n) { unimplementedVisitor("visit(AddExpression)"); }
    public void visit(AddExpression n, Object o) { unimplementedVisitor("visit(AddExpression, Object)"); }

    public void visit(SubtractExpression n) { unimplementedVisitor("visit(SubtractExpression)"); }
    public void visit(SubtractExpression n, Object o) { unimplementedVisitor("visit(SubtractExpression, Object)"); }

    public void visit(LeftShiftExpression n) { unimplementedVisitor("visit(LeftShiftExpression)"); }
    public void visit(LeftShiftExpression n, Object o) { unimplementedVisitor("visit(LeftShiftExpression, Object)"); }

    public void visit(RightShiftExpression n) { unimplementedVisitor("visit(RightShiftExpression)"); }
    public void visit(RightShiftExpression n, Object o) { unimplementedVisitor("visit(RightShiftExpression, Object)"); }

    public void visit(UnsignedRightShiftExpression n) { unimplementedVisitor("visit(UnsignedRightShiftExpression)"); }
    public void visit(UnsignedRightShiftExpression n, Object o) { unimplementedVisitor("visit(UnsignedRightShiftExpression, Object)"); }

    public void visit(LessExpression n) { unimplementedVisitor("visit(LessExpression)"); }
    public void visit(LessExpression n, Object o) { unimplementedVisitor("visit(LessExpression, Object)"); }

    public void visit(GreaterExpression n) { unimplementedVisitor("visit(GreaterExpression)"); }
    public void visit(GreaterExpression n, Object o) { unimplementedVisitor("visit(GreaterExpression, Object)"); }

    public void visit(LessEqualExpression n) { unimplementedVisitor("visit(LessEqualExpression)"); }
    public void visit(LessEqualExpression n, Object o) { unimplementedVisitor("visit(LessEqualExpression, Object)"); }

    public void visit(GreaterEqualExpression n) { unimplementedVisitor("visit(GreaterEqualExpression)"); }
    public void visit(GreaterEqualExpression n, Object o) { unimplementedVisitor("visit(GreaterEqualExpression, Object)"); }

    public void visit(InstanceofExpression n) { unimplementedVisitor("visit(InstanceofExpression)"); }
    public void visit(InstanceofExpression n, Object o) { unimplementedVisitor("visit(InstanceofExpression, Object)"); }

    public void visit(EqualExpression n) { unimplementedVisitor("visit(EqualExpression)"); }
    public void visit(EqualExpression n, Object o) { unimplementedVisitor("visit(EqualExpression, Object)"); }

    public void visit(NotEqualExpression n) { unimplementedVisitor("visit(NotEqualExpression)"); }
    public void visit(NotEqualExpression n, Object o) { unimplementedVisitor("visit(NotEqualExpression, Object)"); }

    public void visit(AndExpression n) { unimplementedVisitor("visit(AndExpression)"); }
    public void visit(AndExpression n, Object o) { unimplementedVisitor("visit(AndExpression, Object)"); }

    public void visit(ExclusiveOrExpression n) { unimplementedVisitor("visit(ExclusiveOrExpression)"); }
    public void visit(ExclusiveOrExpression n, Object o) { unimplementedVisitor("visit(ExclusiveOrExpression, Object)"); }

    public void visit(InclusiveOrExpression n) { unimplementedVisitor("visit(InclusiveOrExpression)"); }
    public void visit(InclusiveOrExpression n, Object o) { unimplementedVisitor("visit(InclusiveOrExpression, Object)"); }

    public void visit(ConditionalAndExpression n) { unimplementedVisitor("visit(ConditionalAndExpression)"); }
    public void visit(ConditionalAndExpression n, Object o) { unimplementedVisitor("visit(ConditionalAndExpression, Object)"); }

    public void visit(ConditionalOrExpression n) { unimplementedVisitor("visit(ConditionalOrExpression)"); }
    public void visit(ConditionalOrExpression n, Object o) { unimplementedVisitor("visit(ConditionalOrExpression, Object)"); }

    public void visit(ConditionalExpression n) { unimplementedVisitor("visit(ConditionalExpression)"); }
    public void visit(ConditionalExpression n, Object o) { unimplementedVisitor("visit(ConditionalExpression, Object)"); }

    public void visit(Assignment n) { unimplementedVisitor("visit(Assignment)"); }
    public void visit(Assignment n, Object o) { unimplementedVisitor("visit(Assignment, Object)"); }

    public void visit(EqualOperator n) { unimplementedVisitor("visit(EqualOperator)"); }
    public void visit(EqualOperator n, Object o) { unimplementedVisitor("visit(EqualOperator, Object)"); }

    public void visit(MultiplyEqualOperator n) { unimplementedVisitor("visit(MultiplyEqualOperator)"); }
    public void visit(MultiplyEqualOperator n, Object o) { unimplementedVisitor("visit(MultiplyEqualOperator, Object)"); }

    public void visit(DivideEqualOperator n) { unimplementedVisitor("visit(DivideEqualOperator)"); }
    public void visit(DivideEqualOperator n, Object o) { unimplementedVisitor("visit(DivideEqualOperator, Object)"); }

    public void visit(ModEqualOperator n) { unimplementedVisitor("visit(ModEqualOperator)"); }
    public void visit(ModEqualOperator n, Object o) { unimplementedVisitor("visit(ModEqualOperator, Object)"); }

    public void visit(PlusEqualOperator n) { unimplementedVisitor("visit(PlusEqualOperator)"); }
    public void visit(PlusEqualOperator n, Object o) { unimplementedVisitor("visit(PlusEqualOperator, Object)"); }

    public void visit(MinusEqualOperator n) { unimplementedVisitor("visit(MinusEqualOperator)"); }
    public void visit(MinusEqualOperator n, Object o) { unimplementedVisitor("visit(MinusEqualOperator, Object)"); }

    public void visit(LeftShiftEqualOperator n) { unimplementedVisitor("visit(LeftShiftEqualOperator)"); }
    public void visit(LeftShiftEqualOperator n, Object o) { unimplementedVisitor("visit(LeftShiftEqualOperator, Object)"); }

    public void visit(RightShiftEqualOperator n) { unimplementedVisitor("visit(RightShiftEqualOperator)"); }
    public void visit(RightShiftEqualOperator n, Object o) { unimplementedVisitor("visit(RightShiftEqualOperator, Object)"); }

    public void visit(UnsignedRightShiftEqualOperator n) { unimplementedVisitor("visit(UnsignedRightShiftEqualOperator)"); }
    public void visit(UnsignedRightShiftEqualOperator n, Object o) { unimplementedVisitor("visit(UnsignedRightShiftEqualOperator, Object)"); }

    public void visit(AndEqualOperator n) { unimplementedVisitor("visit(AndEqualOperator)"); }
    public void visit(AndEqualOperator n, Object o) { unimplementedVisitor("visit(AndEqualOperator, Object)"); }

    public void visit(ExclusiveOrEqualOperator n) { unimplementedVisitor("visit(ExclusiveOrEqualOperator)"); }
    public void visit(ExclusiveOrEqualOperator n, Object o) { unimplementedVisitor("visit(ExclusiveOrEqualOperator, Object)"); }

    public void visit(OrEqualOperator n) { unimplementedVisitor("visit(OrEqualOperator)"); }
    public void visit(OrEqualOperator n, Object o) { unimplementedVisitor("visit(OrEqualOperator, Object)"); }

    public void visit(Commaopt n) { unimplementedVisitor("visit(Commaopt)"); }
    public void visit(Commaopt n, Object o) { unimplementedVisitor("visit(Commaopt, Object)"); }

    public void visit(IDENTIFIERopt n) { unimplementedVisitor("visit(IDENTIFIERopt)"); }
    public void visit(IDENTIFIERopt n, Object o) { unimplementedVisitor("visit(IDENTIFIERopt, Object)"); }
}

