package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 385:  VariableDefinitionKind ::= VAR
 *</b>
 */
public class VariableDefinitionKind0 extends AstToken implements IVariableDefinitionKind
{
    public IToken getVAR() { return leftIToken; }

    public VariableDefinitionKind0(IToken token) { super(token); initialize(); }

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


