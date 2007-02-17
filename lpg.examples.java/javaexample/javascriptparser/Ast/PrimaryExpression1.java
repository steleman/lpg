package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 13:  PrimaryExpression ::= TRUE
 *</b>
 */
public class PrimaryExpression1 extends AstToken implements IPrimaryExpression
{
    public IToken getTRUE() { return leftIToken; }

    public PrimaryExpression1(IToken token) { super(token); initialize(); }

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


