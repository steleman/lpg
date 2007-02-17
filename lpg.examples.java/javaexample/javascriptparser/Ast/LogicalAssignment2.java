package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 185:  LogicalAssignment ::= ||=
 *</b>
 */
public class LogicalAssignment2 extends AstToken implements ILogicalAssignment
{
    public IToken getOR_OR_EQUAL() { return leftIToken; }

    public LogicalAssignment2(IToken token) { super(token); initialize(); }

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


