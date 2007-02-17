package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 59:  FullPostfixExpression ::= SuperExpression PropertyOperator
 *</b>
 */
public class FullPostfixExpression1 extends Ast implements IFullPostfixExpression
{
    private ISuperExpression _SuperExpression;
    private IPropertyOperator _PropertyOperator;

    public ISuperExpression getSuperExpression() { return _SuperExpression; }
    public IPropertyOperator getPropertyOperator() { return _PropertyOperator; }

    public FullPostfixExpression1(IToken leftIToken, IToken rightIToken,
                                  ISuperExpression _SuperExpression,
                                  IPropertyOperator _PropertyOperator)
    {
        super(leftIToken, rightIToken);

        this._SuperExpression = _SuperExpression;
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
        if (! (o instanceof FullPostfixExpression1)) return false;
        FullPostfixExpression1 other = (FullPostfixExpression1) o;
        if (! _SuperExpression.equals(other._SuperExpression)) return false;
        if (! _PropertyOperator.equals(other._PropertyOperator)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_SuperExpression.hashCode());
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
            _SuperExpression.accept(v);
            _PropertyOperator.accept(v);
        }
        v.endVisit(this);
    }
}


