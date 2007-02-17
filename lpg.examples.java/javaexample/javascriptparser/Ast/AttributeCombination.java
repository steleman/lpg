package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 356:  AttributeCombination ::= Attribute no_line_break$ Attributes
 *</b>
 */
public class AttributeCombination extends Ast implements IAttributeCombination
{
    private IAttribute _Attribute;
    private IAttributes _Attributes;

    public IAttribute getAttribute() { return _Attribute; }
    public IAttributes getAttributes() { return _Attributes; }

    public AttributeCombination(IToken leftIToken, IToken rightIToken,
                                IAttribute _Attribute,
                                IAttributes _Attributes)
    {
        super(leftIToken, rightIToken);

        this._Attribute = _Attribute;
        this._Attributes = _Attributes;
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
        if (! (o instanceof AttributeCombination)) return false;
        AttributeCombination other = (AttributeCombination) o;
        if (! _Attribute.equals(other._Attribute)) return false;
        if (! _Attributes.equals(other._Attributes)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_Attribute.hashCode());
        hash = hash * 31 + (_Attributes.hashCode());
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
            _Attribute.accept(v);
            _Attributes.accept(v);
        }
        v.endVisit(this);
    }
}


