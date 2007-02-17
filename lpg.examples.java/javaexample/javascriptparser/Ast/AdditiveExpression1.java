package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 100:  AdditiveExpression ::= AdditiveExpression - MultiplicativeExpression
 *</b>
 */
public class AdditiveExpression1 extends Ast implements IAdditiveExpression
{
    private IAdditiveExpression _AdditiveExpression;
    private AstToken _MINUS;
    private IMultiplicativeExpression _MultiplicativeExpression;

    public IAdditiveExpression getAdditiveExpression() { return _AdditiveExpression; }
    public AstToken getMINUS() { return _MINUS; }
    public IMultiplicativeExpression getMultiplicativeExpression() { return _MultiplicativeExpression; }

    public AdditiveExpression1(IToken leftIToken, IToken rightIToken,
                               IAdditiveExpression _AdditiveExpression,
                               AstToken _MINUS,
                               IMultiplicativeExpression _MultiplicativeExpression)
    {
        super(leftIToken, rightIToken);

        this._AdditiveExpression = _AdditiveExpression;
        this._MINUS = _MINUS;
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
        if (! (o instanceof AdditiveExpression1)) return false;
        AdditiveExpression1 other = (AdditiveExpression1) o;
        if (! _AdditiveExpression.equals(other._AdditiveExpression)) return false;
        if (! _MINUS.equals(other._MINUS)) return false;
        if (! _MultiplicativeExpression.equals(other._MultiplicativeExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_AdditiveExpression.hashCode());
        hash = hash * 31 + (_MINUS.hashCode());
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
            _MINUS.accept(v);
            _MultiplicativeExpression.accept(v);
        }
        v.endVisit(this);
    }
}


