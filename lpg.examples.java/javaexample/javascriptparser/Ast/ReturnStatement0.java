package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 310:  ReturnStatement ::= RETURN
 *</b>
 */
public class ReturnStatement0 extends AstToken implements IReturnStatement
{
    public IToken getRETURN() { return leftIToken; }

    public ReturnStatement0(IToken token) { super(token); initialize(); }

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


