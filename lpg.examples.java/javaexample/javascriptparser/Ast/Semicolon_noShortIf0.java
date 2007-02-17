package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 256:  Semicolon_noShortIf ::= ;
 *</b>
 */
public class Semicolon_noShortIf0 extends AstToken implements ISemicolon_noShortIf
{
    public IToken getSEMICOLON() { return leftIToken; }

    public Semicolon_noShortIf0(IToken token) { super(token); initialize(); }

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


