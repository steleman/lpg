package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 58:  FullPostfixExpression ::= FullPostfixExpression PropertyOperator
 *</b>
 */
public class FullPostfixExpression0 extends Ast implements IFullPostfixExpression
{
    private IFullPostfixExpression _FullPostfixExpression;
    private IPropertyOperator _PropertyOperator;

    public IFullPostfixExpression getFullPostfixExpression() { return _FullPostfixExpression; }
    public IPropertyOperator getPropertyOperator() { return _PropertyOperator; }

    public FullPostfixExpression0(IToken leftIToken, IToken rightIToken,
                                  IFullPostfixExpression _FullPostfixExpression,
                                  IPropertyOperator _PropertyOperator)
    {
        super(leftIToken, rightIToken);

        this._FullPostfixExpression = _FullPostfixExpression;
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
        if (! (o instanceof FullPostfixExpression0)) return false;
        FullPostfixExpression0 other = (FullPostfixExpression0) o;
        if (! _FullPostfixExpression.equals(other._FullPostfixExpression)) return false;
        if (! _PropertyOperator.equals(other._PropertyOperator)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_FullPostfixExpression.hashCode());
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
            _FullPostfixExpression.accept(v);
            _PropertyOperator.accept(v);
        }
        v.endVisit(this);
    }
}


