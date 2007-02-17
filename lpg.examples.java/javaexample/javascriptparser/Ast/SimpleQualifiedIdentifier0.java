package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 7:  SimpleQualifiedIdentifier ::= Identifier :: Identifier
 *</b>
 */
public class SimpleQualifiedIdentifier0 extends Ast implements ISimpleQualifiedIdentifier
{
    private IIdentifier _Identifier;
    private AstToken _COLON_COLON;
    private IIdentifier _Identifier3;

    public IIdentifier getIdentifier() { return _Identifier; }
    public AstToken getCOLON_COLON() { return _COLON_COLON; }
    public IIdentifier getIdentifier3() { return _Identifier3; }

    public SimpleQualifiedIdentifier0(IToken leftIToken, IToken rightIToken,
                                      IIdentifier _Identifier,
                                      AstToken _COLON_COLON,
                                      IIdentifier _Identifier3)
    {
        super(leftIToken, rightIToken);

        this._Identifier = _Identifier;
        this._COLON_COLON = _COLON_COLON;
        this._Identifier3 = _Identifier3;
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
        if (! (o instanceof SimpleQualifiedIdentifier0)) return false;
        SimpleQualifiedIdentifier0 other = (SimpleQualifiedIdentifier0) o;
        if (! _Identifier.equals(other._Identifier)) return false;
        if (! _COLON_COLON.equals(other._COLON_COLON)) return false;
        if (! _Identifier3.equals(other._Identifier3)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_Identifier.hashCode());
        hash = hash * 31 + (_COLON_COLON.hashCode());
        hash = hash * 31 + (_Identifier3.hashCode());
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
            _Identifier.accept(v);
            _COLON_COLON.accept(v);
            _Identifier3.accept(v);
        }
        v.endVisit(this);
    }
}


