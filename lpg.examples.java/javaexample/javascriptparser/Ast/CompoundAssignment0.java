package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 172:  CompoundAssignment ::= *=
 *</b>
 */
public class CompoundAssignment0 extends AstToken implements ICompoundAssignment
{
    public IToken getMULTIPLY_EQUAL() { return leftIToken; }

    public CompoundAssignment0(IToken token) { super(token); initialize(); }

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


