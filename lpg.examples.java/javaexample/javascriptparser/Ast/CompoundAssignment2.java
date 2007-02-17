package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 174:  CompoundAssignment ::= %=
 *</b>
 */
public class CompoundAssignment2 extends AstToken implements ICompoundAssignment
{
    public IToken getREMAINDER_EQUAL() { return leftIToken; }

    public CompoundAssignment2(IToken token) { super(token); initialize(); }

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


