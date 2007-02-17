package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 41:  ArrayLiteral ::= [ ElementList ]
 *</b>
 */
public class ArrayLiteral extends Ast implements IArrayLiteral
{
    private AstToken _LBRACKET;
    private IElementList _ElementList;
    private AstToken _RBRACKET;

    public AstToken getLBRACKET() { return _LBRACKET; }
    /**
     * The value returned by <b>getElementList</b> may be <b>null</b>
     */
    public IElementList getElementList() { return _ElementList; }
    public AstToken getRBRACKET() { return _RBRACKET; }

    public ArrayLiteral(IToken leftIToken, IToken rightIToken,
                        AstToken _LBRACKET,
                        IElementList _ElementList,
                        AstToken _RBRACKET)
    {
        super(leftIToken, rightIToken);

        this._LBRACKET = _LBRACKET;
        this._ElementList = _ElementList;
        this._RBRACKET = _RBRACKET;
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
        if (! (o instanceof ArrayLiteral)) return false;
        ArrayLiteral other = (ArrayLiteral) o;
        if (! _LBRACKET.equals(other._LBRACKET)) return false;
        if (_ElementList == null)
            if (other._ElementList != null) return false;
            else; // continue
        else if (! _ElementList.equals(other._ElementList)) return false;
        if (! _RBRACKET.equals(other._RBRACKET)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_LBRACKET.hashCode());
        hash = hash * 31 + (_ElementList == null ? 0 : _ElementList.hashCode());
        hash = hash * 31 + (_RBRACKET.hashCode());
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
            _LBRACKET.accept(v);
            if (_ElementList != null) _ElementList.accept(v);
            _RBRACKET.accept(v);
        }
        v.endVisit(this);
    }
}


