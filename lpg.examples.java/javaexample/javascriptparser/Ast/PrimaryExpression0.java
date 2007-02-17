package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 12:  PrimaryExpression ::= NULL
 *</b>
 */
public class PrimaryExpression0 extends AstToken implements IPrimaryExpression
{
    public IToken getNULL() { return leftIToken; }

    public PrimaryExpression0(IToken token) { super(token); initialize(); }

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


