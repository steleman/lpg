package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 253:  Semicolon_abbrev ::= ;
 *</b>
 */
public class Semicolon_abbrev0 extends AstToken implements ISemicolon_abbrev
{
    public IToken getSEMICOLON() { return leftIToken; }

    public Semicolon_abbrev0(IToken token) { super(token); initialize(); }

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


