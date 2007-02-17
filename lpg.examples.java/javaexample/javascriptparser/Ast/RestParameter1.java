package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 427:  RestParameter ::= ... ParameterAttributes Identifier
 *</b>
 */
public class RestParameter1 extends Ast implements IRestParameter
{
    private AstToken _ETC;
    private ParameterAttributes _ParameterAttributes;
    private IIdentifier _Identifier;

    public AstToken getETC() { return _ETC; }
    /**
     * The value returned by <b>getParameterAttributes</b> may be <b>null</b>
     */
    public ParameterAttributes getParameterAttributes() { return _ParameterAttributes; }
    public IIdentifier getIdentifier() { return _Identifier; }

    public RestParameter1(IToken leftIToken, IToken rightIToken,
                          AstToken _ETC,
                          ParameterAttributes _ParameterAttributes,
                          IIdentifier _Identifier)
    {
        super(leftIToken, rightIToken);

        this._ETC = _ETC;
        this._ParameterAttributes = _ParameterAttributes;
        this._Identifier = _Identifier;
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
        if (! (o instanceof RestParameter1)) return false;
        RestParameter1 other = (RestParameter1) o;
        if (! _ETC.equals(other._ETC)) return false;
        if (_ParameterAttributes == null)
            if (other._ParameterAttributes != null) return false;
            else; // continue
        else if (! _ParameterAttributes.equals(other._ParameterAttributes)) return false;
        if (! _Identifier.equals(other._Identifier)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ETC.hashCode());
        hash = hash * 31 + (_ParameterAttributes == null ? 0 : _ParameterAttributes.hashCode());
        hash = hash * 31 + (_Identifier.hashCode());
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
            _ETC.accept(v);
            if (_ParameterAttributes != null) _ParameterAttributes.accept(v);
            _Identifier.accept(v);
        }
        v.endVisit(this);
    }
}


