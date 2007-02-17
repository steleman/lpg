package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 358:  Attribute ::= TRUE
 *</b>
 */
public class Attribute0 extends AstToken implements IAttribute
{
    public IToken getTRUE() { return leftIToken; }

    public Attribute0(IToken token) { super(token); initialize(); }

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


