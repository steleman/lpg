package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 389:  VariableBindingList_noIn ::= VariableBinding_noIn
 *</em>
 *<p>
 *<b>
 *<li>Rule 390:  VariableBindingList_noIn ::= VariableBindingList_noIn , VariableBinding_noIn
 *</b>
 */
public class VariableBindingList_noIn extends Ast implements IVariableBindingList_noIn
{
    private IVariableBindingList_noIn _VariableBindingList_noIn;
    private AstToken _COMMA;
    private VariableBinding_noIn _VariableBinding_noIn;

    public IVariableBindingList_noIn getVariableBindingList_noIn() { return _VariableBindingList_noIn; }
    public AstToken getCOMMA() { return _COMMA; }
    public VariableBinding_noIn getVariableBinding_noIn() { return _VariableBinding_noIn; }

    public VariableBindingList_noIn(IToken leftIToken, IToken rightIToken,
                                    IVariableBindingList_noIn _VariableBindingList_noIn,
                                    AstToken _COMMA,
                                    VariableBinding_noIn _VariableBinding_noIn)
    {
        super(leftIToken, rightIToken);

        this._VariableBindingList_noIn = _VariableBindingList_noIn;
        this._COMMA = _COMMA;
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
        if (! (o instanceof VariableBindingList_noIn)) return false;
        VariableBindingList_noIn other = (VariableBindingList_noIn) o;
        if (! _VariableBindingList_noIn.equals(other._VariableBindingList_noIn)) return false;
        if (! _COMMA.equals(other._COMMA)) return false;
        if (! _VariableBinding_noIn.equals(other._VariableBinding_noIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_VariableBindingList_noIn.hashCode());
        hash = hash * 31 + (_COMMA.hashCode());
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
            _VariableBindingList_noIn.accept(v);
            _COMMA.accept(v);
            _VariableBinding_noIn.accept(v);
        }
        v.endVisit(this);
    }
}


