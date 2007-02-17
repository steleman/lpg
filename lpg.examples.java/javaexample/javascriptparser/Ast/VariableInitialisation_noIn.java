package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 395:  VariableInitialisation_noIn ::= $Empty
 *</em>
 *<p>
 *<b>
 *<li>Rule 396:  VariableInitialisation_noIn ::= = VariableInitializer_noIn
 *</b>
 */
public class VariableInitialisation_noIn extends Ast implements IVariableInitialisation_noIn
{
    private AstToken _EQUAL;
    private IVariableInitializer_noIn _VariableInitializer_noIn;

    public AstToken getEQUAL() { return _EQUAL; }
    public IVariableInitializer_noIn getVariableInitializer_noIn() { return _VariableInitializer_noIn; }

    public VariableInitialisation_noIn(IToken leftIToken, IToken rightIToken,
                                       AstToken _EQUAL,
                                       IVariableInitializer_noIn _VariableInitializer_noIn)
    {
        super(leftIToken, rightIToken);

        this._EQUAL = _EQUAL;
        this._VariableInitializer_noIn = _VariableInitializer_noIn;
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
        if (! (o instanceof VariableInitialisation_noIn)) return false;
        VariableInitialisation_noIn other = (VariableInitialisation_noIn) o;
        if (! _EQUAL.equals(other._EQUAL)) return false;
        if (! _VariableInitializer_noIn.equals(other._VariableInitializer_noIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_EQUAL.hashCode());
        hash = hash * 31 + (_VariableInitializer_noIn.hashCode());
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
            _EQUAL.accept(v);
            _VariableInitializer_noIn.accept(v);
        }
        v.endVisit(this);
    }
}


