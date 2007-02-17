package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 184:  LogicalAssignment ::= ^^=
 *</b>
 */
public class LogicalAssignment1 extends AstToken implements ILogicalAssignment
{
    public IToken getXOR_XOR_EQUAL() { return leftIToken; }

    public LogicalAssignment1(IToken token) { super(token); initialize(); }

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


