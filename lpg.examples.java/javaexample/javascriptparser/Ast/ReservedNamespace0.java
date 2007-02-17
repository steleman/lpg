package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 24:  ReservedNamespace ::= PUBLIC
 *</b>
 */
public class ReservedNamespace0 extends AstToken implements IReservedNamespace
{
    public IToken getPUBLIC() { return leftIToken; }

    public ReservedNamespace0(IToken token) { super(token); initialize(); }

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


