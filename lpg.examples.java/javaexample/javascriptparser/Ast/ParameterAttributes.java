package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 422:  ParameterAttributes ::= $Empty
 *</em>
 *<p>
 *<b>
 *<li>Rule 423:  ParameterAttributes ::= CONST
 *</b>
 */
public class ParameterAttributes extends AstToken implements IParameterAttributes
{
    public IToken getCONST() { return leftIToken; }

    public ParameterAttributes(IToken token) { super(token); initialize(); }

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


