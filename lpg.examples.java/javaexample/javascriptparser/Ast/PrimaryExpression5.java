package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 17:  PrimaryExpression ::= THIS
 *</b>
 */
public class PrimaryExpression5 extends AstToken implements IPrimaryExpression
{
    public IToken getTHIS() { return leftIToken; }

    public PrimaryExpression5(IToken token) { super(token); initialize(); }

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


