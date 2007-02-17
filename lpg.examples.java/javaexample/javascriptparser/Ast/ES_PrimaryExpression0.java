package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 447:  ES_PrimaryExpression ::= NULL
 *</b>
 */
public class ES_PrimaryExpression0 extends AstToken implements IES_PrimaryExpression
{
    public IToken getNULL() { return leftIToken; }

    public ES_PrimaryExpression0(IToken token) { super(token); initialize(); }

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


