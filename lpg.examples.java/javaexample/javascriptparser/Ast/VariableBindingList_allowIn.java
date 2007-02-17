package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 387:  VariableBindingList_allowIn ::= VariableBinding_allowIn
 *</em>
 *<p>
 *<b>
 *<li>Rule 388:  VariableBindingList_allowIn ::= VariableBindingList_allowIn , VariableBinding_allowIn
 *</b>
 */
public class VariableBindingList_allowIn extends Ast implements IVariableBindingList_allowIn
{
    private IVariableBindingList_allowIn _VariableBindingList_allowIn;
    private AstToken _COMMA;
    private VariableBinding_allowIn _VariableBinding_allowIn;

    public IVariableBindingList_allowIn getVariableBindingList_allowIn() { return _VariableBindingList_allowIn; }
    public AstToken getCOMMA() { return _COMMA; }
    public VariableBinding_allowIn getVariableBinding_allowIn() { return _VariableBinding_allowIn; }

    public VariableBindingList_allowIn(IToken leftIToken, IToken rightIToken,
                                       IVariableBindingList_allowIn _VariableBindingList_allowIn,
                                       AstToken _COMMA,
                                       VariableBinding_allowIn _VariableBinding_allowIn)
    {
        super(leftIToken, rightIToken);

        this._VariableBindingList_allowIn = _VariableBindingList_allowIn;
        this._COMMA = _COMMA;
        this._VariableBinding_allowIn = _VariableBinding_allowIn;
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
        if (! (o instanceof VariableBindingList_allowIn)) return false;
        VariableBindingList_allowIn other = (VariableBindingList_allowIn) o;
        if (! _VariableBindingList_allowIn.equals(other._VariableBindingList_allowIn)) return false;
        if (! _COMMA.equals(other._COMMA)) return false;
        if (! _VariableBinding_allowIn.equals(other._VariableBinding_allowIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_VariableBindingList_allowIn.hashCode());
        hash = hash * 31 + (_COMMA.hashCode());
        hash = hash * 31 + (_VariableBinding_allowIn.hashCode());
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
            _VariableBindingList_allowIn.accept(v);
            _COMMA.accept(v);
            _VariableBinding_allowIn.accept(v);
        }
        v.endVisit(this);
    }
}


