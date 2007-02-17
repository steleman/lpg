package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 243:  Substatement_noShortIf ::= SimpleVariableDefinition Semicolon_noShortIf
 *</b>
 */
public class Substatement_noShortIf0 extends Ast implements ISubstatement_noShortIf
{
    private SimpleVariableDefinition _SimpleVariableDefinition;
    private ISemicolon_noShortIf _Semicolon_noShortIf;

    public SimpleVariableDefinition getSimpleVariableDefinition() { return _SimpleVariableDefinition; }
    /**
     * The value returned by <b>getSemicolon_noShortIf</b> may be <b>null</b>
     */
    public ISemicolon_noShortIf getSemicolon_noShortIf() { return _Semicolon_noShortIf; }

    public Substatement_noShortIf0(IToken leftIToken, IToken rightIToken,
                                   SimpleVariableDefinition _SimpleVariableDefinition,
                                   ISemicolon_noShortIf _Semicolon_noShortIf)
    {
        super(leftIToken, rightIToken);

        this._SimpleVariableDefinition = _SimpleVariableDefinition;
        this._Semicolon_noShortIf = _Semicolon_noShortIf;
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
        if (! (o instanceof Substatement_noShortIf0)) return false;
        Substatement_noShortIf0 other = (Substatement_noShortIf0) o;
        if (! _SimpleVariableDefinition.equals(other._SimpleVariableDefinition)) return false;
        if (_Semicolon_noShortIf == null)
            if (other._Semicolon_noShortIf != null) return false;
            else; // continue
        else if (! _Semicolon_noShortIf.equals(other._Semicolon_noShortIf)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_SimpleVariableDefinition.hashCode());
        hash = hash * 31 + (_Semicolon_noShortIf == null ? 0 : _Semicolon_noShortIf.hashCode());
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
            if (_Semicolon_noShortIf != null) _Semicolon_noShortIf.accept(v);
        }
        v.endVisit(this);
    }
}


