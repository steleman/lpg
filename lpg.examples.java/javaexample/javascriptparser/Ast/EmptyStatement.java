package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 261:  EmptyStatement ::= ;
 *</b>
 */
public class EmptyStatement extends AstToken implements IEmptyStatement
{
    public IToken getSEMICOLON() { return leftIToken; }

    public EmptyStatement(IToken token) { super(token); initialize(); }

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


