package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 14:  PrimaryExpression ::= FALSE
 *</b>
 */
public class PrimaryExpression2 extends AstToken implements IPrimaryExpression
{
    public IToken getFALSE() { return leftIToken; }

    public PrimaryExpression2(IToken token) { super(token); initialize(); }

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


