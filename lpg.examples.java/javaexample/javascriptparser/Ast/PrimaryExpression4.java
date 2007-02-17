package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 16:  PrimaryExpression ::= String
 *</b>
 */
public class PrimaryExpression4 extends AstToken implements IPrimaryExpression
{
    public IToken getString() { return leftIToken; }

    public PrimaryExpression4(IToken token) { super(token); initialize(); }

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


