package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 416:  NonemptyParameters ::= ParameterInitList
 *<li>Rule 417:  NonemptyParameters ::= RestParameter
 *</em>
 *<p>
 *<b>
 *<li>Rule 418:  NonemptyParameters ::= ParameterInitList RestParameter
 *</b>
 */
public class NonemptyParameters extends Ast implements INonemptyParameters
{
    private IParameterInitList _ParameterInitList;
    private IRestParameter _RestParameter;

    public IParameterInitList getParameterInitList() { return _ParameterInitList; }
    public IRestParameter getRestParameter() { return _RestParameter; }

    public NonemptyParameters(IToken leftIToken, IToken rightIToken,
                              IParameterInitList _ParameterInitList,
                              IRestParameter _RestParameter)
    {
        super(leftIToken, rightIToken);

        this._ParameterInitList = _ParameterInitList;
        this._RestParameter = _RestParameter;
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
        if (! (o instanceof NonemptyParameters)) return false;
        NonemptyParameters other = (NonemptyParameters) o;
        if (! _ParameterInitList.equals(other._ParameterInitList)) return false;
        if (! _RestParameter.equals(other._RestParameter)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ParameterInitList.hashCode());
        hash = hash * 31 + (_RestParameter.hashCode());
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
            _ParameterInitList.accept(v);
            _RestParameter.accept(v);
        }
        v.endVisit(this);
    }
}


