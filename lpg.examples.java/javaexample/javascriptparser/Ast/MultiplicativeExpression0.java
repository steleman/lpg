package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 95:  MultiplicativeExpression ::= MultiplicativeExpression * UnaryExpression
 *</b>
 */
public class MultiplicativeExpression0 extends Ast implements IMultiplicativeExpression
{
    private IMultiplicativeExpression _MultiplicativeExpression;
    private AstToken _MULTIPLY;
    private IUnaryExpression _UnaryExpression;

    public IMultiplicativeExpression getMultiplicativeExpression() { return _MultiplicativeExpression; }
    public AstToken getMULTIPLY() { return _MULTIPLY; }
    public IUnaryExpression getUnaryExpression() { return _UnaryExpression; }

    public MultiplicativeExpression0(IToken leftIToken, IToken rightIToken,
                                     IMultiplicativeExpression _MultiplicativeExpression,
                                     AstToken _MULTIPLY,
                                     IUnaryExpression _UnaryExpression)
    {
        super(leftIToken, rightIToken);

        this._MultiplicativeExpression = _MultiplicativeExpression;
        this._MULTIPLY = _MULTIPLY;
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
        if (! (o instanceof MultiplicativeExpression0)) return false;
        MultiplicativeExpression0 other = (MultiplicativeExpression0) o;
        if (! _MultiplicativeExpression.equals(other._MultiplicativeExpression)) return false;
        if (! _MULTIPLY.equals(other._MULTIPLY)) return false;
        if (! _UnaryExpression.equals(other._UnaryExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_MultiplicativeExpression.hashCode());
        hash = hash * 31 + (_MULTIPLY.hashCode());
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
            _MULTIPLY.accept(v);
            _UnaryExpression.accept(v);
        }
        v.endVisit(this);
    }
}


