package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 300:  ForInBinding ::= Attributes no_line_break$ VariableDefinitionKind VariableBinding_noIn
 *</b>
 */
public class ForInBinding1 extends Ast implements IForInBinding
{
    private IAttributes _Attributes;
    private IVariableDefinitionKind _VariableDefinitionKind;
    private VariableBinding_noIn _VariableBinding_noIn;

    public IAttributes getAttributes() { return _Attributes; }
    public IVariableDefinitionKind getVariableDefinitionKind() { return _VariableDefinitionKind; }
    public VariableBinding_noIn getVariableBinding_noIn() { return _VariableBinding_noIn; }

    public ForInBinding1(IToken leftIToken, IToken rightIToken,
                         IAttributes _Attributes,
                         IVariableDefinitionKind _VariableDefinitionKind,
                         VariableBinding_noIn _VariableBinding_noIn)
    {
        super(leftIToken, rightIToken);

        this._Attributes = _Attributes;
        this._VariableDefinitionKind = _VariableDefinitionKind;
        this._VariableBinding_noIn = _VariableBinding_noIn;
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
        if (! (o instanceof ForInBinding1)) return false;
        ForInBinding1 other = (ForInBinding1) o;
        if (! _Attributes.equals(other._Attributes)) return false;
        if (! _VariableDefinitionKind.equals(other._VariableDefinitionKind)) return false;
        if (! _VariableBinding_noIn.equals(other._VariableBinding_noIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_Attributes.hashCode());
        hash = hash * 31 + (_VariableDefinitionKind.hashCode());
        hash = hash * 31 + (_VariableBinding_noIn.hashCode());
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
            _Attributes.accept(v);
            _VariableDefinitionKind.accept(v);
            _VariableBinding_noIn.accept(v);
        }
        v.endVisit(this);
    }
}


