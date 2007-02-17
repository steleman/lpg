package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 259:  Semicolon_full ::= ;
 *</b>
 */
public class Semicolon_full0 extends AstToken implements ISemicolon_full
{
    public IToken getSEMICOLON() { return leftIToken; }

    public Semicolon_full0(IToken token) { super(token); initialize(); }

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


