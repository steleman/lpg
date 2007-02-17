package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 15:  PrimaryExpression ::= Number
 *</b>
 */
public class PrimaryExpression3 extends AstToken implements IPrimaryExpression
{
    public IToken getNumber() { return leftIToken; }

    public PrimaryExpression3(IToken token) { super(token); initialize(); }

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


