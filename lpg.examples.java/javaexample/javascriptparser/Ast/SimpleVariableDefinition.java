package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 405:  SimpleVariableDefinition ::= VAR UntypedVariableBindingList
 *</b>
 */
public class SimpleVariableDefinition extends Ast implements ISimpleVariableDefinition
{
    private AstToken _VAR;
    private IUntypedVariableBindingList _UntypedVariableBindingList;

    public AstToken getVAR() { return _VAR; }
    public IUntypedVariableBindingList getUntypedVariableBindingList() { return _UntypedVariableBindingList; }

    public SimpleVariableDefinition(IToken leftIToken, IToken rightIToken,
                                    AstToken _VAR,
                                    IUntypedVariableBindingList _UntypedVariableBindingList)
    {
        super(leftIToken, rightIToken);

        this._VAR = _VAR;
        this._UntypedVariableBindingList = _UntypedVariableBindingList;
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
        if (! (o instanceof SimpleVariableDefinition)) return false;
        SimpleVariableDefinition other = (SimpleVariableDefinition) o;
        if (! _VAR.equals(other._VAR)) return false;
        if (! _UntypedVariableBindingList.equals(other._UntypedVariableBindingList)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_VAR.hashCode());
        hash = hash * 31 + (_UntypedVariableBindingList.hashCode());
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
            _VAR.accept(v);
            _UntypedVariableBindingList.accept(v);
        }
        v.endVisit(this);
    }
}


