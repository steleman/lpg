package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 342:  AnnotatableDirective_full ::= VariableDefinition_allowIn Semicolon_full
 *</b>
 */
public class AnnotatableDirective_full0 extends Ast implements IAnnotatableDirective_full
{
    private VariableDefinition_allowIn _VariableDefinition_allowIn;
    private ISemicolon_full _Semicolon_full;

    public VariableDefinition_allowIn getVariableDefinition_allowIn() { return _VariableDefinition_allowIn; }
    public ISemicolon_full getSemicolon_full() { return _Semicolon_full; }

    public AnnotatableDirective_full0(IToken leftIToken, IToken rightIToken,
                                      VariableDefinition_allowIn _VariableDefinition_allowIn,
                                      ISemicolon_full _Semicolon_full)
    {
        super(leftIToken, rightIToken);

        this._VariableDefinition_allowIn = _VariableDefinition_allowIn;
        this._Semicolon_full = _Semicolon_full;
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
        if (! (o instanceof AnnotatableDirective_full0)) return false;
        AnnotatableDirective_full0 other = (AnnotatableDirective_full0) o;
        if (! _VariableDefinition_allowIn.equals(other._VariableDefinition_allowIn)) return false;
        if (! _Semicolon_full.equals(other._Semicolon_full)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_VariableDefinition_allowIn.hashCode());
        hash = hash * 31 + (_Semicolon_full.hashCode());
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
            _VariableDefinition_allowIn.accept(v);
            _Semicolon_full.accept(v);
        }
        v.endVisit(this);
    }
}


