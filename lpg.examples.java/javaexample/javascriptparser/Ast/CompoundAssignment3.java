package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 175:  CompoundAssignment ::= +=
 *</b>
 */
public class CompoundAssignment3 extends AstToken implements ICompoundAssignment
{
    public IToken getPLUS_EQUAL() { return leftIToken; }

    public CompoundAssignment3(IToken token) { super(token); initialize(); }

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


