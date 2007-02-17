package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 449:  ES_PrimaryExpression ::= FALSE
 *</b>
 */
public class ES_PrimaryExpression2 extends AstToken implements IES_PrimaryExpression
{
    public IToken getFALSE() { return leftIToken; }

    public ES_PrimaryExpression2(IToken token) { super(token); initialize(); }

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


