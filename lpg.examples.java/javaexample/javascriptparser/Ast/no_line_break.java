package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 1:  no_line_break ::= NO_LINE_BREAK
 *</b>
 */
public class no_line_break extends AstToken implements Ino_line_break
{
    public IToken getNO_LINE_BREAK() { return leftIToken; }

    public no_line_break(IToken token) { super(token); initialize(); }

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


