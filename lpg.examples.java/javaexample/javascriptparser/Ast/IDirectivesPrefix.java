package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 * is implemented by:
 *<b>
 *<ul>
 *<li>EmptyStatement
 *<li>Block
 *<li>LabeledStatement_full
 *<li>SwitchStatement
 *<li>WhileStatement_full
 *<li>WithStatement_full
 *<li>DirectivesPrefix
 *<li>FunctionDefinition
 *<li>ClassDefinition
 *<li>Statement_full0
 *<li>Statement_full1
 *<li>Statement_full2
 *<li>Statement_full3
 *<li>Statement_full4
 *<li>Statement_full5
 *<li>Statement_full6
 *<li>IfStatement_full0
 *<li>IfStatement_full1
 *<li>ForStatement_full0
 *<li>ForStatement_full1
 *<li>TryStatement0
 *<li>TryStatement1
 *<li>Directive_full0
 *<li>Directive_full1
 *<li>Directive_full2
 *<li>Directive_full3
 *<li>AnnotatableDirective_full0
 *<li>AnnotatableDirective_full1
 *<li>AnnotatableDirective_full2
 *<li>AnnotatableDirective_full3
 *<li>AnnotatableDirective_full4
 *</ul>
 *</b>
 */
public interface IDirectivesPrefix
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


