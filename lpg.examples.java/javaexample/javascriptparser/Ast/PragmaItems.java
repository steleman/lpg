package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 366:  PragmaItems ::= PragmaItem
 *</em>
 *<p>
 *<b>
 *<li>Rule 367:  PragmaItems ::= PragmaItems , PragmaItem
 *</b>
 */
public class PragmaItems extends Ast implements IPragmaItems
{
    private IPragmaItems _PragmaItems;
    private AstToken _COMMA;
    private IPragmaItem _PragmaItem;

    public IPragmaItems getPragmaItems() { return _PragmaItems; }
    public AstToken getCOMMA() { return _COMMA; }
    public IPragmaItem getPragmaItem() { return _PragmaItem; }

    public PragmaItems(IToken leftIToken, IToken rightIToken,
                       IPragmaItems _PragmaItems,
                       AstToken _COMMA,
                       IPragmaItem _PragmaItem)
    {
        super(leftIToken, rightIToken);

        this._PragmaItems = _PragmaItems;
        this._COMMA = _COMMA;
        this._PragmaItem = _PragmaItem;
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
        if (! (o instanceof PragmaItems)) return false;
        PragmaItems other = (PragmaItems) o;
        if (! _PragmaItems.equals(other._PragmaItems)) return false;
        if (! _COMMA.equals(other._COMMA)) return false;
        if (! _PragmaItem.equals(other._PragmaItem)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_PragmaItems.hashCode());
        hash = hash * 31 + (_COMMA.hashCode());
        hash = hash * 31 + (_PragmaItem.hashCode());
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
            _PragmaItems.accept(v);
            _COMMA.accept(v);
            _PragmaItem.accept(v);
        }
        v.endVisit(this);
    }
}


