package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 * is implemented by:
 *<b>
 *<ul>
 *<li>CatchClauses
 *<li>CatchClause
 *</ul>
 *</b>
 */
public interface ICatchClausesOpt
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


