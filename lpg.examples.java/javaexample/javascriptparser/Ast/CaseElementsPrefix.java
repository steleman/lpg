package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 276:  CaseElementsPrefix ::= $Empty
 *</em>
 *<p>
 *<b>
 *<li>Rule 277:  CaseElementsPrefix ::= CaseElementsPrefix CaseElement_full
 *</b>
 */
public class CaseElementsPrefix extends Ast implements ICaseElementsPrefix
{
    private CaseElementsPrefix _CaseElementsPrefix;
    private ICaseElement_full _CaseElement_full;

    /**
     * The value returned by <b>getCaseElementsPrefix</b> may be <b>null</b>
     */
    public CaseElementsPrefix getCaseElementsPrefix() { return _CaseElementsPrefix; }
    public ICaseElement_full getCaseElement_full() { return _CaseElement_full; }

    public CaseElementsPrefix(IToken leftIToken, IToken rightIToken,
                              CaseElementsPrefix _CaseElementsPrefix,
                              ICaseElement_full _CaseElement_full)
    {
        super(leftIToken, rightIToken);

        this._CaseElementsPrefix = _CaseElementsPrefix;
        this._CaseElement_full = _CaseElement_full;
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
        if (! (o instanceof CaseElementsPrefix)) return false;
        CaseElementsPrefix other = (CaseElementsPrefix) o;
        if (_CaseElementsPrefix == null)
            if (other._CaseElementsPrefix != null) return false;
            else; // continue
        else if (! _CaseElementsPrefix.equals(other._CaseElementsPrefix)) return false;
        if (! _CaseElement_full.equals(other._CaseElement_full)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_CaseElementsPrefix == null ? 0 : _CaseElementsPrefix.hashCode());
        hash = hash * 31 + (_CaseElement_full.hashCode());
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
            if (_CaseElementsPrefix != null) _CaseElementsPrefix.accept(v);
            _CaseElement_full.accept(v);
        }
        v.endVisit(this);
    }
}


