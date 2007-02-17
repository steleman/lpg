package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 4:  Identifier ::= SET
 *</b>
 */
public class Identifier2 extends AstToken implements IIdentifier
{
    public IToken getSET() { return leftIToken; }

    public Identifier2(IToken token) { super(token); initialize(); }

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


