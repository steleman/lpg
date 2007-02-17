package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 392:  VariableBinding_noIn ::= TypedIdentifier_noIn VariableInitialisation_noIn
 *</b>
 */
public class VariableBinding_noIn extends Ast implements IVariableBinding_noIn
{
    private ITypedIdentifier_noIn _TypedIdentifier_noIn;
    private VariableInitialisation_noIn _VariableInitialisation_noIn;

    public ITypedIdentifier_noIn getTypedIdentifier_noIn() { return _TypedIdentifier_noIn; }
    /**
     * The value returned by <b>getVariableInitialisation_noIn</b> may be <b>null</b>
     */
    public VariableInitialisation_noIn getVariableInitialisation_noIn() { return _VariableInitialisation_noIn; }

    public VariableBinding_noIn(IToken leftIToken, IToken rightIToken,
                                ITypedIdentifier_noIn _TypedIdentifier_noIn,
                                VariableInitialisation_noIn _VariableInitialisation_noIn)
    {
        super(leftIToken, rightIToken);

        this._TypedIdentifier_noIn = _TypedIdentifier_noIn;
        this._VariableInitialisation_noIn = _VariableInitialisation_noIn;
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
        if (! (o instanceof VariableBinding_noIn)) return false;
        VariableBinding_noIn other = (VariableBinding_noIn) o;
        if (! _TypedIdentifier_noIn.equals(other._TypedIdentifier_noIn)) return false;
        if (_VariableInitialisation_noIn == null)
            if (other._VariableInitialisation_noIn != null) return false;
            else; // continue
        else if (! _VariableInitialisation_noIn.equals(other._VariableInitialisation_noIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_TypedIdentifier_noIn.hashCode());
        hash = hash * 31 + (_VariableInitialisation_noIn == null ? 0 : _VariableInitialisation_noIn.hashCode());
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
            _TypedIdentifier_noIn.accept(v);
            if (_VariableInitialisation_noIn != null) _VariableInitialisation_noIn.accept(v);
        }
        v.endVisit(this);
    }
}


