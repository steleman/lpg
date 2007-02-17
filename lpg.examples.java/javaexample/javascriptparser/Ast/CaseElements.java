package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 273:  CaseElements ::= $Empty
 *<li>Rule 274:  CaseElements ::= CaseLabel
 *</em>
 *<p>
 *<b>
 *<li>Rule 275:  CaseElements ::= CaseLabel CaseElementsPrefix CaseElement_abbrev
 *</b>
 */
public class CaseElements extends Ast implements ICaseElements
{
    private ICaseLabel _CaseLabel;
    private CaseElementsPrefix _CaseElementsPrefix;
    private ICaseElement_abbrev _CaseElement_abbrev;

    public ICaseLabel getCaseLabel() { return _CaseLabel; }
    /**
     * The value returned by <b>getCaseElementsPrefix</b> may be <b>null</b>
     */
    public CaseElementsPrefix getCaseElementsPrefix() { return _CaseElementsPrefix; }
    public ICaseElement_abbrev getCaseElement_abbrev() { return _CaseElement_abbrev; }

    public CaseElements(IToken leftIToken, IToken rightIToken,
                        ICaseLabel _CaseLabel,
                        CaseElementsPrefix _CaseElementsPrefix,
                        ICaseElement_abbrev _CaseElement_abbrev)
    {
        super(leftIToken, rightIToken);

        this._CaseLabel = _CaseLabel;
        this._CaseElementsPrefix = _CaseElementsPrefix;
        this._CaseElement_abbrev = _CaseElement_abbrev;
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
        if (! (o instanceof CaseElements)) return false;
        CaseElements other = (CaseElements) o;
        if (! _CaseLabel.equals(other._CaseLabel)) return false;
        if (_CaseElementsPrefix == null)
            if (other._CaseElementsPrefix != null) return false;
            else; // continue
        else if (! _CaseElementsPrefix.equals(other._CaseElementsPrefix)) return false;
        if (! _CaseElement_abbrev.equals(other._CaseElement_abbrev)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_CaseLabel.hashCode());
        hash = hash * 31 + (_CaseElementsPrefix == null ? 0 : _CaseElementsPrefix.hashCode());
        hash = hash * 31 + (_CaseElement_abbrev.hashCode());
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
            _CaseLabel.accept(v);
            if (_CaseElementsPrefix != null) _CaseElementsPrefix.accept(v);
            _CaseElement_abbrev.accept(v);
        }
        v.endVisit(this);
    }
}


