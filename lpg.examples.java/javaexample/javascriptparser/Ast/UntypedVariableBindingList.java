package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 406:  UntypedVariableBindingList ::= UntypedVariableBinding
 *</em>
 *<p>
 *<b>
 *<li>Rule 407:  UntypedVariableBindingList ::= UntypedVariableBindingList , UntypedVariableBinding
 *</b>
 */
public class UntypedVariableBindingList extends Ast implements IUntypedVariableBindingList
{
    private IUntypedVariableBindingList _UntypedVariableBindingList;
    private AstToken _COMMA;
    private UntypedVariableBinding _UntypedVariableBinding;

    public IUntypedVariableBindingList getUntypedVariableBindingList() { return _UntypedVariableBindingList; }
    public AstToken getCOMMA() { return _COMMA; }
    public UntypedVariableBinding getUntypedVariableBinding() { return _UntypedVariableBinding; }

    public UntypedVariableBindingList(IToken leftIToken, IToken rightIToken,
                                      IUntypedVariableBindingList _UntypedVariableBindingList,
                                      AstToken _COMMA,
                                      UntypedVariableBinding _UntypedVariableBinding)
    {
        super(leftIToken, rightIToken);

        this._UntypedVariableBindingList = _UntypedVariableBindingList;
        this._COMMA = _COMMA;
        this._UntypedVariableBinding = _UntypedVariableBinding;
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
        if (! (o instanceof UntypedVariableBindingList)) return false;
        UntypedVariableBindingList other = (UntypedVariableBindingList) o;
        if (! _UntypedVariableBindingList.equals(other._UntypedVariableBindingList)) return false;
        if (! _COMMA.equals(other._COMMA)) return false;
        if (! _UntypedVariableBinding.equals(other._UntypedVariableBinding)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_UntypedVariableBindingList.hashCode());
        hash = hash * 31 + (_COMMA.hashCode());
        hash = hash * 31 + (_UntypedVariableBinding.hashCode());
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
            _UntypedVariableBindingList.accept(v);
            _COMMA.accept(v);
            _UntypedVariableBinding.accept(v);
        }
        v.endVisit(this);
    }
}


