package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 383:  VariableDefinition_allowIn ::= VariableDefinitionKind VariableBindingList_allowIn
 *</b>
 */
public class VariableDefinition_allowIn extends Ast implements IVariableDefinition_allowIn
{
    private IVariableDefinitionKind _VariableDefinitionKind;
    private IVariableBindingList_allowIn _VariableBindingList_allowIn;

    public IVariableDefinitionKind getVariableDefinitionKind() { return _VariableDefinitionKind; }
    public IVariableBindingList_allowIn getVariableBindingList_allowIn() { return _VariableBindingList_allowIn; }

    public VariableDefinition_allowIn(IToken leftIToken, IToken rightIToken,
                                      IVariableDefinitionKind _VariableDefinitionKind,
                                      IVariableBindingList_allowIn _VariableBindingList_allowIn)
    {
        super(leftIToken, rightIToken);

        this._VariableDefinitionKind = _VariableDefinitionKind;
        this._VariableBindingList_allowIn = _VariableBindingList_allowIn;
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
        if (! (o instanceof VariableDefinition_allowIn)) return false;
        VariableDefinition_allowIn other = (VariableDefinition_allowIn) o;
        if (! _VariableDefinitionKind.equals(other._VariableDefinitionKind)) return false;
        if (! _VariableBindingList_allowIn.equals(other._VariableBindingList_allowIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_VariableDefinitionKind.hashCode());
        hash = hash * 31 + (_VariableBindingList_allowIn.hashCode());
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
            _VariableBindingList_allowIn.accept(v);
        }
        v.endVisit(this);
    }
}


