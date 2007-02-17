package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 448:  ES_PrimaryExpression ::= TRUE
 *</b>
 */
public class ES_PrimaryExpression1 extends AstToken implements IES_PrimaryExpression
{
    public IToken getTRUE() { return leftIToken; }

    public ES_PrimaryExpression1(IToken token) { super(token); initialize(); }

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


