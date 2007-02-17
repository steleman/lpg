package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 * is implemented by:
 *<b>
 *<ul>
 *<li>EmptyStatement
 *<li>Block
 *<li>LabeledStatement_abbrev
 *<li>SwitchStatement
 *<li>WhileStatement_abbrev
 *<li>WithStatement_abbrev
 *<li>FunctionDefinition
 *<li>ClassDefinition
 *<li>Statement_abbrev0
 *<li>Statement_abbrev1
 *<li>Statement_abbrev2
 *<li>Statement_abbrev3
 *<li>Statement_abbrev4
 *<li>Statement_abbrev5
 *<li>Statement_abbrev6
 *<li>IfStatement_abbrev0
 *<li>IfStatement_abbrev1
 *<li>CaseLabel0
 *<li>CaseLabel1
 *<li>ForStatement_abbrev0
 *<li>ForStatement_abbrev1
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
 *</ul>
 *</b>
 */
public interface ICaseElement_abbrev
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


