package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 53:  AttributeExpression ::= AttributeExpression PropertyOperator
 *</b>
 */
public class AttributeExpression0 extends Ast implements IAttributeExpression
{
    private IAttributeExpression _AttributeExpression;
    private IPropertyOperator _PropertyOperator;

    public IAttributeExpression getAttributeExpression() { return _AttributeExpression; }
    public IPropertyOperator getPropertyOperator() { return _PropertyOperator; }

    public AttributeExpression0(IToken leftIToken, IToken rightIToken,
                                IAttributeExpression _AttributeExpression,
                                IPropertyOperator _PropertyOperator)
    {
        super(leftIToken, rightIToken);

        this._AttributeExpression = _AttributeExpression;
        this._PropertyOperator = _PropertyOperator;
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
        if (! (o instanceof AttributeExpression0)) return false;
        AttributeExpression0 other = (AttributeExpression0) o;
        if (! _AttributeExpression.equals(other._AttributeExpression)) return false;
        if (! _PropertyOperator.equals(other._PropertyOperator)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_AttributeExpression.hashCode());
        hash = hash * 31 + (_PropertyOperator.hashCode());
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
            _AttributeExpression.accept(v);
            _PropertyOperator.accept(v);
        }
        v.endVisit(this);
    }
}


