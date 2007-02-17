package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 393:  VariableInitialisation_allowIn ::= $Empty
 *</em>
 *<p>
 *<b>
 *<li>Rule 394:  VariableInitialisation_allowIn ::= = VariableInitializer_allowIn
 *</b>
 */
public class VariableInitialisation_allowIn extends Ast implements IVariableInitialisation_allowIn
{
    private AstToken _EQUAL;
    private IVariableInitializer_allowIn _VariableInitializer_allowIn;

    public AstToken getEQUAL() { return _EQUAL; }
    public IVariableInitializer_allowIn getVariableInitializer_allowIn() { return _VariableInitializer_allowIn; }

    public VariableInitialisation_allowIn(IToken leftIToken, IToken rightIToken,
                                          AstToken _EQUAL,
                                          IVariableInitializer_allowIn _VariableInitializer_allowIn)
    {
        super(leftIToken, rightIToken);

        this._EQUAL = _EQUAL;
        this._VariableInitializer_allowIn = _VariableInitializer_allowIn;
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
        if (! (o instanceof VariableInitialisation_allowIn)) return false;
        VariableInitialisation_allowIn other = (VariableInitialisation_allowIn) o;
        if (! _EQUAL.equals(other._EQUAL)) return false;
        if (! _VariableInitializer_allowIn.equals(other._VariableInitializer_allowIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_EQUAL.hashCode());
        hash = hash * 31 + (_VariableInitializer_allowIn.hashCode());
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
            _VariableInitializer_allowIn.accept(v);
        }
        v.endVisit(this);
    }
}


