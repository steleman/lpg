package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 183:  LogicalAssignment ::= &&=
 *</b>
 */
public class LogicalAssignment0 extends AstToken implements ILogicalAssignment
{
    public IToken getAND_AND_EQUAL() { return leftIToken; }

    public LogicalAssignment0(IToken token) { super(token); initialize(); }

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


