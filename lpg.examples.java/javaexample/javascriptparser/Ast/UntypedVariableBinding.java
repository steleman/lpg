package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 408:  UntypedVariableBinding ::= Identifier VariableInitialisation_allowIn
 *</b>
 */
public class UntypedVariableBinding extends Ast implements IUntypedVariableBinding
{
    private IIdentifier _Identifier;
    private VariableInitialisation_allowIn _VariableInitialisation_allowIn;

    public IIdentifier getIdentifier() { return _Identifier; }
    /**
     * The value returned by <b>getVariableInitialisation_allowIn</b> may be <b>null</b>
     */
    public VariableInitialisation_allowIn getVariableInitialisation_allowIn() { return _VariableInitialisation_allowIn; }

    public UntypedVariableBinding(IToken leftIToken, IToken rightIToken,
                                  IIdentifier _Identifier,
                                  VariableInitialisation_allowIn _VariableInitialisation_allowIn)
    {
        super(leftIToken, rightIToken);

        this._Identifier = _Identifier;
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
        if (! (o instanceof UntypedVariableBinding)) return false;
        UntypedVariableBinding other = (UntypedVariableBinding) o;
        if (! _Identifier.equals(other._Identifier)) return false;
        if (_VariableInitialisation_allowIn == null)
            if (other._VariableInitialisation_allowIn != null) return false;
            else; // continue
        else if (! _VariableInitialisation_allowIn.equals(other._VariableInitialisation_allowIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_Identifier.hashCode());
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
            _Identifier.accept(v);
            if (_VariableInitialisation_allowIn != null) _VariableInitialisation_allowIn.accept(v);
        }
        v.endVisit(this);
    }
}


