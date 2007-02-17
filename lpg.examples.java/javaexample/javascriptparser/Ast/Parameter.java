package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 421:  Parameter ::= ParameterAttributes TypedIdentifier_allowIn
 *</b>
 */
public class Parameter extends Ast implements IParameter
{
    private ParameterAttributes _ParameterAttributes;
    private ITypedIdentifier_allowIn _TypedIdentifier_allowIn;

    /**
     * The value returned by <b>getParameterAttributes</b> may be <b>null</b>
     */
    public ParameterAttributes getParameterAttributes() { return _ParameterAttributes; }
    public ITypedIdentifier_allowIn getTypedIdentifier_allowIn() { return _TypedIdentifier_allowIn; }

    public Parameter(IToken leftIToken, IToken rightIToken,
                     ParameterAttributes _ParameterAttributes,
                     ITypedIdentifier_allowIn _TypedIdentifier_allowIn)
    {
        super(leftIToken, rightIToken);

        this._ParameterAttributes = _ParameterAttributes;
        this._TypedIdentifier_allowIn = _TypedIdentifier_allowIn;
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
        if (! (o instanceof Parameter)) return false;
        Parameter other = (Parameter) o;
        if (_ParameterAttributes == null)
            if (other._ParameterAttributes != null) return false;
            else; // continue
        else if (! _ParameterAttributes.equals(other._ParameterAttributes)) return false;
        if (! _TypedIdentifier_allowIn.equals(other._TypedIdentifier_allowIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ParameterAttributes == null ? 0 : _ParameterAttributes.hashCode());
        hash = hash * 31 + (_TypedIdentifier_allowIn.hashCode());
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
            if (_ParameterAttributes != null) _ParameterAttributes.accept(v);
            _TypedIdentifier_allowIn.accept(v);
        }
        v.endVisit(this);
    }
}


