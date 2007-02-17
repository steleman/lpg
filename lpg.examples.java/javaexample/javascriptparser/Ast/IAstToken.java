package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 * is always implemented by <b>AstToken</b>. It is also implemented by:
 *<b>
 *<ul>
 *<li>no_line_break
 *<li>ExpressionQualifiedIdentifier
 *<li>ParenExpression
 *<li>ParenListExpression
 *<li>ObjectLiteral
 *<li>ArrayLiteral
 *<li>EmptyStatement
 *<li>Block
 *<li>LabeledStatement_abbrev
 *<li>SwitchStatement
 *<li>WhileStatement_abbrev
 *<li>WithStatement_abbrev
 *<li>FunctionDefinition
 *<li>ParameterAttributes
 *<li>ClassDefinition
 *<li>PackageName
 *<li>PackageIdentifiers
 *<li>Identifier0
 *<li>Identifier1
 *<li>Identifier2
 *<li>Identifier3
 *<li>SimpleQualifiedIdentifier0
 *<li>SimpleQualifiedIdentifier1
 *<li>PrimaryExpression0
 *<li>PrimaryExpression1
 *<li>PrimaryExpression2
 *<li>PrimaryExpression3
 *<li>PrimaryExpression4
 *<li>PrimaryExpression5
 *<li>PrimaryExpression6
 *<li>ReservedNamespace0
 *<li>ReservedNamespace1
 *<li>FunctionExpression0
 *<li>FunctionExpression1
 *<li>FieldName0
 *<li>FieldName1
 *<li>SuperExpression0
 *<li>SuperExpression1
 *<li>AttributeExpression0
 *<li>AttributeExpression1
 *<li>CompoundAssignment0
 *<li>CompoundAssignment1
 *<li>CompoundAssignment2
 *<li>CompoundAssignment3
 *<li>CompoundAssignment4
 *<li>CompoundAssignment5
 *<li>CompoundAssignment6
 *<li>CompoundAssignment7
 *<li>CompoundAssignment8
 *<li>CompoundAssignment9
 *<li>CompoundAssignment10
 *<li>LogicalAssignment0
 *<li>LogicalAssignment1
 *<li>LogicalAssignment2
 *<li>Statement_abbrev0
 *<li>Statement_abbrev1
 *<li>Statement_abbrev2
 *<li>Statement_abbrev3
 *<li>Statement_abbrev4
 *<li>Statement_abbrev5
 *<li>Statement_abbrev6
 *<li>Semicolon_abbrev0
 *<li>Semicolon_abbrev1
 *<li>Semicolon_noShortIf0
 *<li>Semicolon_noShortIf1
 *<li>Semicolon_full0
 *<li>Semicolon_full1
 *<li>IfStatement_abbrev0
 *<li>IfStatement_abbrev1
 *<li>ForStatement_abbrev0
 *<li>ForStatement_abbrev1
 *<li>ContinueStatement0
 *<li>ContinueStatement1
 *<li>BreakStatement0
 *<li>BreakStatement1
 *<li>ReturnStatement0
 *<li>ReturnStatement1
 *<li>TryStatement0
 *<li>TryStatement1
 *<li>Directive_abbrev0
 *<li>Directive_abbrev1
 *<li>Directive_abbrev2
 *<li>Directive_abbrev3
 *<li>Directive_abbrev4
 *<li>AnnotatableDirective_abbrev0
 *<li>AnnotatableDirective_abbrev1
 *<li>AnnotatableDirective_abbrev2
 *<li>AnnotatableDirective_abbrev3
 *<li>AnnotatableDirective_abbrev4
 *<li>Attribute0
 *<li>Attribute1
 *<li>PragmaArgument0
 *<li>PragmaArgument1
 *<li>PragmaArgument2
 *<li>PragmaArgument3
 *<li>PragmaArgument4
 *<li>PragmaArgument5
 *<li>VariableDefinitionKind0
 *<li>VariableDefinitionKind1
 *<li>RestParameter0
 *<li>RestParameter1
 *<li>ES_PrimaryExpression0
 *<li>ES_PrimaryExpression1
 *<li>ES_PrimaryExpression2
 *<li>ES_PrimaryExpression3
 *<li>ES_PrimaryExpression4
 *<li>ES_PrimaryExpression5
 *<li>ES_PrimaryExpression6
 *</ul>
 *</b>
 */
public interface IAstToken
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


