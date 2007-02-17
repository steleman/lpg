package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 47:  SuperExpression ::= SUPER
 *</b>
 */
public class SuperExpression0 extends AstToken implements ISuperExpression
{
    public IToken getSUPER() { return leftIToken; }

    public SuperExpression0(IToken token) { super(token); initialize(); }

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


