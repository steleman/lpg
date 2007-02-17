package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 386:  VariableDefinitionKind ::= CONST
 *</b>
 */
public class VariableDefinitionKind1 extends AstToken implements IVariableDefinitionKind
{
    public IToken getCONST() { return leftIToken; }

    public VariableDefinitionKind1(IToken token) { super(token); initialize(); }

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


