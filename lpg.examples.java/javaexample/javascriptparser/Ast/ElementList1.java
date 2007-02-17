package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 45:  ElementList ::= ElementList , LiteralElement
 *</b>
 */
public class ElementList1 extends Ast implements IElementList
{
    private IElementList _ElementList;
    private AstToken _COMMA;
    private ILiteralElement _LiteralElement;

    /**
     * The value returned by <b>getElementList</b> may be <b>null</b>
     */
    public IElementList getElementList() { return _ElementList; }
    public AstToken getCOMMA() { return _COMMA; }
    public ILiteralElement getLiteralElement() { return _LiteralElement; }

    public ElementList1(IToken leftIToken, IToken rightIToken,
                        IElementList _ElementList,
                        AstToken _COMMA,
                        ILiteralElement _LiteralElement)
    {
        super(leftIToken, rightIToken);

        this._ElementList = _ElementList;
        this._COMMA = _COMMA;
        this._LiteralElement = _LiteralElement;
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
        if (! (o instanceof ElementList1)) return false;
        ElementList1 other = (ElementList1) o;
        if (_ElementList == null)
            if (other._ElementList != null) return false;
            else; // continue
        else if (! _ElementList.equals(other._ElementList)) return false;
        if (! _COMMA.equals(other._COMMA)) return false;
        if (! _LiteralElement.equals(other._LiteralElement)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ElementList == null ? 0 : _ElementList.hashCode());
        hash = hash * 31 + (_COMMA.hashCode());
        hash = hash * 31 + (_LiteralElement.hashCode());
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
            if (_ElementList != null) _ElementList.accept(v);
            _COMMA.accept(v);
            _LiteralElement.accept(v);
        }
        v.endVisit(this);
    }
}


