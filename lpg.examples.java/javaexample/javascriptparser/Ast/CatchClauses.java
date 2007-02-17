package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 317:  CatchClauses ::= CatchClause
 *</em>
 *<p>
 *<b>
 *<li>Rule 318:  CatchClauses ::= CatchClauses CatchClause
 *</b>
 */
public class CatchClauses extends Ast implements ICatchClauses
{
    private ICatchClauses _CatchClauses;
    private CatchClause _CatchClause;

    public ICatchClauses getCatchClauses() { return _CatchClauses; }
    public CatchClause getCatchClause() { return _CatchClause; }

    public CatchClauses(IToken leftIToken, IToken rightIToken,
                        ICatchClauses _CatchClauses,
                        CatchClause _CatchClause)
    {
        super(leftIToken, rightIToken);

        this._CatchClauses = _CatchClauses;
        this._CatchClause = _CatchClause;
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
        if (! (o instanceof CatchClauses)) return false;
        CatchClauses other = (CatchClauses) o;
        if (! _CatchClauses.equals(other._CatchClauses)) return false;
        if (! _CatchClause.equals(other._CatchClause)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_CatchClauses.hashCode());
        hash = hash * 31 + (_CatchClause.hashCode());
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
            _CatchClauses.accept(v);
            _CatchClause.accept(v);
        }
        v.endVisit(this);
    }
}


