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
 *<li>Statement_full0
 *<li>Statement_full1
 *<li>Statement_full2
 *<li>Statement_full3
 *<li>Statement_full4
 *<li>Statement_full5
 *<li>Statement_full6
 *<li>Substatement_full0
 *<li>Substatement_full1
 *<li>IfStatement_full0
 *<li>IfStatement_full1
 *<li>ForStatement_full0
 *<li>ForStatement_full1
 *<li>TryStatement0
 *<li>TryStatement1
 *</ul>
 *</b>
 */
public interface ISubstatement_full
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


