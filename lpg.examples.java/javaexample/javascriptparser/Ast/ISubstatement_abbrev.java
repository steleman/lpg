package javascriptparser.Ast;

import lpg.runtime.java.*;


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
 *<li>Statement_abbrev0
 *<li>Statement_abbrev1
 *<li>Statement_abbrev2
 *<li>Statement_abbrev3
 *<li>Statement_abbrev4
 *<li>Statement_abbrev5
 *<li>Statement_abbrev6
 *<li>Substatement_abbrev0
 *<li>Substatement_abbrev1
 *<li>IfStatement_abbrev0
 *<li>IfStatement_abbrev1
 *<li>ForStatement_abbrev0
 *<li>ForStatement_abbrev1
 *<li>TryStatement0
 *<li>TryStatement1
 *</ul>
 *</b>
 */
public interface ISubstatement_abbrev
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


