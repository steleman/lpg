package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 5:  Identifier ::= INCLUDE
 *</b>
 */
public class Identifier3 extends AstToken implements IIdentifier
{
    public IToken getINCLUDE() { return leftIToken; }

    public Identifier3(IToken token) { super(token); initialize(); }

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


