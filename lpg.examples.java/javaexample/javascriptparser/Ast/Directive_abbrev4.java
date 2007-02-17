package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 327:  Directive_abbrev ::= ERROR_TOKEN
 *</b>
 */
public class Directive_abbrev4 extends AstToken implements IDirective_abbrev
{
    public IToken getERROR_TOKEN() { return leftIToken; }

    public Directive_abbrev4(IToken token) { super(token); initialize(); }

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


