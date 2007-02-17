package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 450:  ES_PrimaryExpression ::= Number
 *</b>
 */
public class ES_PrimaryExpression3 extends AstToken implements IES_PrimaryExpression
{
    public IToken getNumber() { return leftIToken; }

    public ES_PrimaryExpression3(IToken token) { super(token); initialize(); }

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


