package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 8:  SimpleQualifiedIdentifier ::= ReservedNamespace :: Identifier
 *</b>
 */
public class SimpleQualifiedIdentifier1 extends Ast implements ISimpleQualifiedIdentifier
{
    private IReservedNamespace _ReservedNamespace;
    private AstToken _COLON_COLON;
    private IIdentifier _Identifier;

    public IReservedNamespace getReservedNamespace() { return _ReservedNamespace; }
    public AstToken getCOLON_COLON() { return _COLON_COLON; }
    public IIdentifier getIdentifier() { return _Identifier; }

    public SimpleQualifiedIdentifier1(IToken leftIToken, IToken rightIToken,
                                      IReservedNamespace _ReservedNamespace,
                                      AstToken _COLON_COLON,
                                      IIdentifier _Identifier)
    {
        super(leftIToken, rightIToken);

        this._ReservedNamespace = _ReservedNamespace;
        this._COLON_COLON = _COLON_COLON;
        this._Identifier = _Identifier;
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
        if (! (o instanceof SimpleQualifiedIdentifier1)) return false;
        SimpleQualifiedIdentifier1 other = (SimpleQualifiedIdentifier1) o;
        if (! _ReservedNamespace.equals(other._ReservedNamespace)) return false;
        if (! _COLON_COLON.equals(other._COLON_COLON)) return false;
        if (! _Identifier.equals(other._Identifier)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ReservedNamespace.hashCode());
        hash = hash * 31 + (_COLON_COLON.hashCode());
        hash = hash * 31 + (_Identifier.hashCode());
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
            _ReservedNamespace.accept(v);
            _COLON_COLON.accept(v);
            _Identifier.accept(v);
        }
        v.endVisit(this);
    }
}


