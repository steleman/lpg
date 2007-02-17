package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 463:  ES_FullPostfixExpression ::= ES_FullPostfixExpression PropertyOperator
 *</b>
 */
public class ES_FullPostfixExpression0 extends Ast implements IES_FullPostfixExpression
{
    private IES_FullPostfixExpression _ES_FullPostfixExpression;
    private IPropertyOperator _PropertyOperator;

    public IES_FullPostfixExpression getES_FullPostfixExpression() { return _ES_FullPostfixExpression; }
    public IPropertyOperator getPropertyOperator() { return _PropertyOperator; }

    public ES_FullPostfixExpression0(IToken leftIToken, IToken rightIToken,
                                     IES_FullPostfixExpression _ES_FullPostfixExpression,
                                     IPropertyOperator _PropertyOperator)
    {
        super(leftIToken, rightIToken);

        this._ES_FullPostfixExpression = _ES_FullPostfixExpression;
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
        if (! (o instanceof ES_FullPostfixExpression0)) return false;
        ES_FullPostfixExpression0 other = (ES_FullPostfixExpression0) o;
        if (! _ES_FullPostfixExpression.equals(other._ES_FullPostfixExpression)) return false;
        if (! _PropertyOperator.equals(other._PropertyOperator)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ES_FullPostfixExpression.hashCode());
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
            _ES_FullPostfixExpression.accept(v);
            _PropertyOperator.accept(v);
        }
        v.endVisit(this);
    }
}


