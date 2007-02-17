package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 54:  AttributeExpression ::= AttributeExpression Arguments
 *</b>
 */
public class AttributeExpression1 extends Ast implements IAttributeExpression
{
    private IAttributeExpression _AttributeExpression;
    private IArguments _Arguments;

    public IAttributeExpression getAttributeExpression() { return _AttributeExpression; }
    public IArguments getArguments() { return _Arguments; }

    public AttributeExpression1(IToken leftIToken, IToken rightIToken,
                                IAttributeExpression _AttributeExpression,
                                IArguments _Arguments)
    {
        super(leftIToken, rightIToken);

        this._AttributeExpression = _AttributeExpression;
        this._Arguments = _Arguments;
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
        if (! (o instanceof AttributeExpression1)) return false;
        AttributeExpression1 other = (AttributeExpression1) o;
        if (! _AttributeExpression.equals(other._AttributeExpression)) return false;
        if (! _Arguments.equals(other._Arguments)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_AttributeExpression.hashCode());
        hash = hash * 31 + (_Arguments.hashCode());
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
            _Arguments.accept(v);
        }
        v.endVisit(this);
    }
}


