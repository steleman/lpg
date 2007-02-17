package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 25:  ReservedNamespace ::= PRIVATE
 *</b>
 */
public class ReservedNamespace1 extends AstToken implements IReservedNamespace
{
    public IToken getPRIVATE() { return leftIToken; }

    public ReservedNamespace1(IToken token) { super(token); initialize(); }

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


