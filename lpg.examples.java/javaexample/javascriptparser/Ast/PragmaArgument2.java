package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 374:  PragmaArgument ::= Number
 *</b>
 */
public class PragmaArgument2 extends AstToken implements IPragmaArgument
{
    public IToken getNumber() { return leftIToken; }

    public PragmaArgument2(IToken token) { super(token); initialize(); }

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


