package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 249:  Substatements ::= $Empty
 *</em>
 *<p>
 *<b>
 *<li>Rule 250:  Substatements ::= SubstatementsPrefix Substatement_abbrev
 *</b>
 */
public class Substatements extends Ast implements ISubstatements
{
    private SubstatementsPrefix _SubstatementsPrefix;
    private ISubstatement_abbrev _Substatement_abbrev;

    /**
     * The value returned by <b>getSubstatementsPrefix</b> may be <b>null</b>
     */
    public SubstatementsPrefix getSubstatementsPrefix() { return _SubstatementsPrefix; }
    public ISubstatement_abbrev getSubstatement_abbrev() { return _Substatement_abbrev; }

    public Substatements(IToken leftIToken, IToken rightIToken,
                         SubstatementsPrefix _SubstatementsPrefix,
                         ISubstatement_abbrev _Substatement_abbrev)
    {
        super(leftIToken, rightIToken);

        this._SubstatementsPrefix = _SubstatementsPrefix;
        this._Substatement_abbrev = _Substatement_abbrev;
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
        if (! (o instanceof Substatements)) return false;
        Substatements other = (Substatements) o;
        if (_SubstatementsPrefix == null)
            if (other._SubstatementsPrefix != null) return false;
            else; // continue
        else if (! _SubstatementsPrefix.equals(other._SubstatementsPrefix)) return false;
        if (! _Substatement_abbrev.equals(other._Substatement_abbrev)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_SubstatementsPrefix == null ? 0 : _SubstatementsPrefix.hashCode());
        hash = hash * 31 + (_Substatement_abbrev.hashCode());
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
            if (_SubstatementsPrefix != null) _SubstatementsPrefix.accept(v);
            _Substatement_abbrev.accept(v);
        }
        v.endVisit(this);
    }
}


