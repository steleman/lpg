package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 373:  PragmaArgument ::= FALSE
 *</b>
 */
public class PragmaArgument1 extends AstToken implements IPragmaArgument
{
    public IToken getFALSE() { return leftIToken; }

    public PragmaArgument1(IToken token) { super(token); initialize(); }

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


