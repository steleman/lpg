package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 372:  PragmaArgument ::= TRUE
 *</b>
 */
public class PragmaArgument0 extends AstToken implements IPragmaArgument
{
    public IToken getTRUE() { return leftIToken; }

    public PragmaArgument0(IToken token) { super(token); initialize(); }

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


