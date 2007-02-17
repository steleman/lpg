package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 97:  MultiplicativeExpression ::= MultiplicativeExpression % UnaryExpression
 *</b>
 */
public class MultiplicativeExpression2 extends Ast implements IMultiplicativeExpression
{
    private IMultiplicativeExpression _MultiplicativeExpression;
    private AstToken _REMAINDER;
    private IUnaryExpression _UnaryExpression;

    public IMultiplicativeExpression getMultiplicativeExpression() { return _MultiplicativeExpression; }
    public AstToken getREMAINDER() { return _REMAINDER; }
    public IUnaryExpression getUnaryExpression() { return _UnaryExpression; }

    public MultiplicativeExpression2(IToken leftIToken, IToken rightIToken,
                                     IMultiplicativeExpression _MultiplicativeExpression,
                                     AstToken _REMAINDER,
                                     IUnaryExpression _UnaryExpression)
    {
        super(leftIToken, rightIToken);

        this._MultiplicativeExpression = _MultiplicativeExpression;
        this._REMAINDER = _REMAINDER;
        this._UnaryExpression = _UnaryExpression;
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
        if (! (o instanceof MultiplicativeExpression2)) return false;
        MultiplicativeExpression2 other = (MultiplicativeExpression2) o;
        if (! _MultiplicativeExpression.equals(other._MultiplicativeExpression)) return false;
        if (! _REMAINDER.equals(other._REMAINDER)) return false;
        if (! _UnaryExpression.equals(other._UnaryExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_MultiplicativeExpression.hashCode());
        hash = hash * 31 + (_REMAINDER.hashCode());
        hash = hash * 31 + (_UnaryExpression.hashCode());
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
            _MultiplicativeExpression.accept(v);
            _REMAINDER.accept(v);
            _UnaryExpression.accept(v);
        }
        v.endVisit(this);
    }
}


