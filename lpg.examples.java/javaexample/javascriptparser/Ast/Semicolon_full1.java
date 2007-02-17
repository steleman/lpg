package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 260:  Semicolon_full ::= VirtualSemicolon
 *</b>
 */
public class Semicolon_full1 extends AstToken implements ISemicolon_full
{
    public IToken getVirtualSemicolon() { return leftIToken; }

    public Semicolon_full1(IToken token) { super(token); initialize(); }

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


