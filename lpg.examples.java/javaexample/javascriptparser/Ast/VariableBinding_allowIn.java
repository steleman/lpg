package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 391:  VariableBinding_allowIn ::= TypedIdentifier_allowIn VariableInitialisation_allowIn
 *</b>
 */
public class VariableBinding_allowIn extends Ast implements IVariableBinding_allowIn
{
    private ITypedIdentifier_allowIn _TypedIdentifier_allowIn;
    private VariableInitialisation_allowIn _VariableInitialisation_allowIn;

    public ITypedIdentifier_allowIn getTypedIdentifier_allowIn() { return _TypedIdentifier_allowIn; }
    /**
     * The value returned by <b>getVariableInitialisation_allowIn</b> may be <b>null</b>
     */
    public VariableInitialisation_allowIn getVariableInitialisation_allowIn() { return _VariableInitialisation_allowIn; }

    public VariableBinding_allowIn(IToken leftIToken, IToken rightIToken,
                                   ITypedIdentifier_allowIn _TypedIdentifier_allowIn,
                                   VariableInitialisation_allowIn _VariableInitialisation_allowIn)
    {
        super(leftIToken, rightIToken);

        this._TypedIdentifier_allowIn = _TypedIdentifier_allowIn;
        this._VariableInitialisation_allowIn = _VariableInitialisation_allowIn;
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
        if (! (o instanceof VariableBinding_allowIn)) return false;
        VariableBinding_allowIn other = (VariableBinding_allowIn) o;
        if (! _TypedIdentifier_allowIn.equals(other._TypedIdentifier_allowIn)) return false;
        if (_VariableInitialisation_allowIn == null)
            if (other._VariableInitialisation_allowIn != null) return false;
            else; // continue
        else if (! _VariableInitialisation_allowIn.equals(other._VariableInitialisation_allowIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_TypedIdentifier_allowIn.hashCode());
        hash = hash * 31 + (_VariableInitialisation_allowIn == null ? 0 : _VariableInitialisation_allowIn.hashCode());
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
            _TypedIdentifier_allowIn.accept(v);
            if (_VariableInitialisation_allowIn != null) _VariableInitialisation_allowIn.accept(v);
        }
        v.endVisit(this);
    }
}


