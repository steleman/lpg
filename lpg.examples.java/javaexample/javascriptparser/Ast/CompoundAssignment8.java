package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 180:  CompoundAssignment ::= &=
 *</b>
 */
public class CompoundAssignment8 extends AstToken implements ICompoundAssignment
{
    public IToken getAND_EQUAL() { return leftIToken; }

    public CompoundAssignment8(IToken token) { super(token); initialize(); }

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


