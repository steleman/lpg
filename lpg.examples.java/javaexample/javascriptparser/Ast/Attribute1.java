package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 359:  Attribute ::= FALSE
 *</b>
 */
public class Attribute1 extends AstToken implements IAttribute
{
    public IToken getFALSE() { return leftIToken; }

    public Attribute1(IToken token) { super(token); initialize(); }

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


