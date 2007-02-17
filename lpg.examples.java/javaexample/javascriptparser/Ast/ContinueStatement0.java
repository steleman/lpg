package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 306:  ContinueStatement ::= CONTINUE
 *</b>
 */
public class ContinueStatement0 extends AstToken implements IContinueStatement
{
    public IToken getCONTINUE() { return leftIToken; }

    public ContinueStatement0(IToken token) { super(token); initialize(); }

    public void accept(Visitor v)
    {
        if (! v.preVisit(this)) return;
        enter(v);
        v.postVisit(this);
    }

    public void enter(Visitor v)
    {
        v.visit(this);
        v.endVisit(this);
    }
}


