package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 177:  CompoundAssignment ::= <<=
 *</b>
 */
public class CompoundAssignment5 extends AstToken implements ICompoundAssignment
{
    public IToken getLEFT_SHIFT_EQUAL() { return leftIToken; }

    public CompoundAssignment5(IToken token) { super(token); initialize(); }

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


