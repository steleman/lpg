package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 99:  AdditiveExpression ::= AdditiveExpression + MultiplicativeExpression
 *</b>
 */
public class AdditiveExpression0 extends Ast implements IAdditiveExpression
{
    private IAdditiveExpression _AdditiveExpression;
    private AstToken _PLUS;
    private IMultiplicativeExpression _MultiplicativeExpression;

    public IAdditiveExpression getAdditiveExpression() { return _AdditiveExpression; }
    public AstToken getPLUS() { return _PLUS; }
    public IMultiplicativeExpression getMultiplicativeExpression() { return _MultiplicativeExpression; }

    public AdditiveExpression0(IToken leftIToken, IToken rightIToken,
                               IAdditiveExpression _AdditiveExpression,
                               AstToken _PLUS,
                               IMultiplicativeExpression _MultiplicativeExpression)
    {
        super(leftIToken, rightIToken);

        this._AdditiveExpression = _AdditiveExpression;
        this._PLUS = _PLUS;
        this._MultiplicativeExpression = _MultiplicativeExpression;
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
        if (! (o instanceof AdditiveExpression0)) return false;
        AdditiveExpression0 other = (AdditiveExpression0) o;
        if (! _AdditiveExpression.equals(other._AdditiveExpression)) return false;
        if (! _PLUS.equals(other._PLUS)) return false;
        if (! _MultiplicativeExpression.equals(other._MultiplicativeExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_AdditiveExpression.hashCode());
        hash = hash * 31 + (_PLUS.hashCode());
        hash = hash * 31 + (_MultiplicativeExpression.hashCode());
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
            _AdditiveExpression.accept(v);
            _PLUS.accept(v);
            _MultiplicativeExpression.accept(v);
        }
        v.endVisit(this);
    }
}


