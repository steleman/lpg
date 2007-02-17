package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 484:  ES_AdditiveExpression ::= ES_AdditiveExpression + MultiplicativeExpression
 *</b>
 */
public class ES_AdditiveExpression0 extends Ast implements IES_AdditiveExpression
{
    private IES_AdditiveExpression _ES_AdditiveExpression;
    private AstToken _PLUS;
    private IMultiplicativeExpression _MultiplicativeExpression;

    public IES_AdditiveExpression getES_AdditiveExpression() { return _ES_AdditiveExpression; }
    public AstToken getPLUS() { return _PLUS; }
    public IMultiplicativeExpression getMultiplicativeExpression() { return _MultiplicativeExpression; }

    public ES_AdditiveExpression0(IToken leftIToken, IToken rightIToken,
                                  IES_AdditiveExpression _ES_AdditiveExpression,
                                  AstToken _PLUS,
                                  IMultiplicativeExpression _MultiplicativeExpression)
    {
        super(leftIToken, rightIToken);

        this._ES_AdditiveExpression = _ES_AdditiveExpression;
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
        if (! (o instanceof ES_AdditiveExpression0)) return false;
        ES_AdditiveExpression0 other = (ES_AdditiveExpression0) o;
        if (! _ES_AdditiveExpression.equals(other._ES_AdditiveExpression)) return false;
        if (! _PLUS.equals(other._PLUS)) return false;
        if (! _MultiplicativeExpression.equals(other._MultiplicativeExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ES_AdditiveExpression.hashCode());
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
            _ES_AdditiveExpression.accept(v);
            _PLUS.accept(v);
            _MultiplicativeExpression.accept(v);
        }
        v.endVisit(this);
    }
}


