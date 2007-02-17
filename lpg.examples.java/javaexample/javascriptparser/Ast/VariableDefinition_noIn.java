package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 384:  VariableDefinition_noIn ::= VariableDefinitionKind VariableBindingList_noIn
 *</b>
 */
public class VariableDefinition_noIn extends Ast implements IVariableDefinition_noIn
{
    private IVariableDefinitionKind _VariableDefinitionKind;
    private IVariableBindingList_noIn _VariableBindingList_noIn;

    public IVariableDefinitionKind getVariableDefinitionKind() { return _VariableDefinitionKind; }
    public IVariableBindingList_noIn getVariableBindingList_noIn() { return _VariableBindingList_noIn; }

    public VariableDefinition_noIn(IToken leftIToken, IToken rightIToken,
                                   IVariableDefinitionKind _VariableDefinitionKind,
                                   IVariableBindingList_noIn _VariableBindingList_noIn)
    {
        super(leftIToken, rightIToken);

        this._VariableDefinitionKind = _VariableDefinitionKind;
        this._VariableBindingList_noIn = _VariableBindingList_noIn;
        initialize();
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        //
        // The super call test is not required for now because an Ast node
        // can only extend the root Ast, AstToken and AstList and none of
        // these nodes contain additional children.
        //
        // if (! super.equals(o)) return false;
        //
        if (! (o instanceof VariableDefinition_noIn)) return false;
        VariableDefinition_noIn other = (VariableDefinition_noIn) o;
        if (! _VariableDefinitionKind.equals(other._VariableDefinitionKind)) return false;
        if (! _VariableBindingList_noIn.equals(other._VariableBindingList_noIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_VariableDefinitionKind.hashCode());
        hash = hash * 31 + (_VariableBindingList_noIn.hashCode());
        return hash;
    }

    public void accept(Visitor v)
    {
        if (! v.preVisit(this)) return;
        enter(v);
        v.postVisit(this);
    }

    public void enter(Visitor v)
    {
        boolean checkChildren = v.visit(this);
        if (checkChildren)
        {
            _VariableDefinitionKind.accept(v);
            _VariableBindingList_noIn.accept(v);
        }
        v.endVisit(this);
    }
}


