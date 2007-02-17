package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 426:  RestParameter ::= ...
 *</b>
 */
public class RestParameter0 extends AstToken implements IRestParameter
{
    public IToken getETC() { return leftIToken; }

    public RestParameter0(IToken token) { super(token); initialize(); }

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


