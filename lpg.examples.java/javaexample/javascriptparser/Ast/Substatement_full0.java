package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 247:  Substatement_full ::= SimpleVariableDefinition Semicolon_full
 *</b>
 */
public class Substatement_full0 extends Ast implements ISubstatement_full
{
    private SimpleVariableDefinition _SimpleVariableDefinition;
    private ISemicolon_full _Semicolon_full;

    public SimpleVariableDefinition getSimpleVariableDefinition() { return _SimpleVariableDefinition; }
    public ISemicolon_full getSemicolon_full() { return _Semicolon_full; }

    public Substatement_full0(IToken leftIToken, IToken rightIToken,
                              SimpleVariableDefinition _SimpleVariableDefinition,
                              ISemicolon_full _Semicolon_full)
    {
        super(leftIToken, rightIToken);

        this._SimpleVariableDefinition = _SimpleVariableDefinition;
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
        if (! (o instanceof Substatement_full0)) return false;
        Substatement_full0 other = (Substatement_full0) o;
        if (! _SimpleVariableDefinition.equals(other._SimpleVariableDefinition)) return false;
        if (! _Semicolon_full.equals(other._Semicolon_full)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_SimpleVariableDefinition.hashCode());
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
            _SimpleVariableDefinition.accept(v);
            _Semicolon_full.accept(v);
        }
        v.endVisit(this);
    }
}


