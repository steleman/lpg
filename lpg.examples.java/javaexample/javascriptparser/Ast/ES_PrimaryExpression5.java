package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 452:  ES_PrimaryExpression ::= THIS
 *</b>
 */
public class ES_PrimaryExpression5 extends AstToken implements IES_PrimaryExpression
{
    public IToken getTHIS() { return leftIToken; }

    public ES_PrimaryExpression5(IToken token) { super(token); initialize(); }

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


