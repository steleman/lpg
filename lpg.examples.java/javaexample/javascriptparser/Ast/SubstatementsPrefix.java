package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 251:  SubstatementsPrefix ::= $Empty
 *</em>
 *<p>
 *<b>
 *<li>Rule 252:  SubstatementsPrefix ::= SubstatementsPrefix Substatement_full
 *</b>
 */
public class SubstatementsPrefix extends Ast implements ISubstatementsPrefix
{
    private SubstatementsPrefix _SubstatementsPrefix;
    private ISubstatement_full _Substatement_full;

    /**
     * The value returned by <b>getSubstatementsPrefix</b> may be <b>null</b>
     */
    public SubstatementsPrefix getSubstatementsPrefix() { return _SubstatementsPrefix; }
    public ISubstatement_full getSubstatement_full() { return _Substatement_full; }

    public SubstatementsPrefix(IToken leftIToken, IToken rightIToken,
                               SubstatementsPrefix _SubstatementsPrefix,
                               ISubstatement_full _Substatement_full)
    {
        super(leftIToken, rightIToken);

        this._SubstatementsPrefix = _SubstatementsPrefix;
        this._Substatement_full = _Substatement_full;
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
        if (! (o instanceof SubstatementsPrefix)) return false;
        SubstatementsPrefix other = (SubstatementsPrefix) o;
        if (_SubstatementsPrefix == null)
            if (other._SubstatementsPrefix != null) return false;
            else; // continue
        else if (! _SubstatementsPrefix.equals(other._SubstatementsPrefix)) return false;
        if (! _Substatement_full.equals(other._Substatement_full)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_SubstatementsPrefix == null ? 0 : _SubstatementsPrefix.hashCode());
        hash = hash * 31 + (_Substatement_full.hashCode());
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
            _Substatement_full.accept(v);
        }
        v.endVisit(this);
    }
}


