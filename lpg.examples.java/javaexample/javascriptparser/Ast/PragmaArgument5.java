package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 377:  PragmaArgument ::= String
 *</b>
 */
public class PragmaArgument5 extends AstToken implements IPragmaArgument
{
    public IToken getString() { return leftIToken; }

    public PragmaArgument5(IToken token) { super(token); initialize(); }

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


