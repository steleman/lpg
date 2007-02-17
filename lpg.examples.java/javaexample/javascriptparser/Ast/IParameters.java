package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 * is implemented by:
 *<b>
 *<ul>
 *<li>NonemptyParameters
 *<li>ParameterInitList
 *<li>Parameter
 *<li>ParameterInit
 *<li>RestParameter0
 *<li>RestParameter1
 *</ul>
 *</b>
 */
public interface IParameters
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
}


