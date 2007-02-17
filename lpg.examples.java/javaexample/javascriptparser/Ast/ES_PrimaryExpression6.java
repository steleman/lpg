package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 453:  ES_PrimaryExpression ::= RegularExpression
 *</b>
 */
public class ES_PrimaryExpression6 extends AstToken implements IES_PrimaryExpression
{
    public IToken getRegularExpression() { return leftIToken; }

    public ES_PrimaryExpression6(IToken token) { super(token); initialize(); }

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


