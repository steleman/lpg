package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 18:  PrimaryExpression ::= RegularExpression
 *</b>
 */
public class PrimaryExpression6 extends AstToken implements IPrimaryExpression
{
    public IToken getRegularExpression() { return leftIToken; }

    public PrimaryExpression6(IToken token) { super(token); initialize(); }

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


