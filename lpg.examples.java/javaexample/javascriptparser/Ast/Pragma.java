package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 365:  Pragma ::= USE PragmaItems
 *</b>
 */
public class Pragma extends Ast implements IPragma
{
    private AstToken _USE;
    private IPragmaItems _PragmaItems;

    public AstToken getUSE() { return _USE; }
    public IPragmaItems getPragmaItems() { return _PragmaItems; }

    public Pragma(IToken leftIToken, IToken rightIToken,
                  AstToken _USE,
                  IPragmaItems _PragmaItems)
    {
        super(leftIToken, rightIToken);

        this._USE = _USE;
        this._PragmaItems = _PragmaItems;
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
        if (! (o instanceof Pragma)) return false;
        Pragma other = (Pragma) o;
        if (! _USE.equals(other._USE)) return false;
        if (! _PragmaItems.equals(other._PragmaItems)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_USE.hashCode());
        hash = hash * 31 + (_PragmaItems.hashCode());
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
            _USE.accept(v);
            _PragmaItems.accept(v);
        }
        v.endVisit(this);
    }
}


