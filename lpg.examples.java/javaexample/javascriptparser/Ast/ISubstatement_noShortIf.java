package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 * is implemented by:
 *<b>
 *<ul>
 *<li>EmptyStatement
 *<li>Block
 *<li>LabeledStatement_noShortIf
 *<li>IfStatement_noShortIf
 *<li>SwitchStatement
 *<li>WhileStatement_noShortIf
 *<li>WithStatement_noShortIf
 *<li>Statement_noShortIf0
 *<li>Statement_noShortIf1
 *<li>Statement_noShortIf2
 *<li>Statement_noShortIf3
 *<li>Statement_noShortIf4
 *<li>Statement_noShortIf5
 *<li>Statement_noShortIf6
 *<li>Substatement_noShortIf0
 *<li>Substatement_noShortIf1
 *<li>ForStatement_noShortIf0
 *<li>ForStatement_noShortIf1
 *<li>TryStatement0
 *<li>TryStatement1
 *</ul>
 *</b>
 */
public interface ISubstatement_noShortIf
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


