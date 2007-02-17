package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 257:  Semicolon_noShortIf ::= VirtualSemicolon
 *</b>
 */
public class Semicolon_noShortIf1 extends AstToken implements ISemicolon_noShortIf
{
    public IToken getVirtualSemicolon() { return leftIToken; }

    public Semicolon_noShortIf1(IToken token) { super(token); initialize(); }

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


