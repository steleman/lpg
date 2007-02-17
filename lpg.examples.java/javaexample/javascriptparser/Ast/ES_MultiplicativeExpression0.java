package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 480:  ES_MultiplicativeExpression ::= ES_MultiplicativeExpression * UnaryExpression
 *</b>
 */
public class ES_MultiplicativeExpression0 extends Ast implements IES_MultiplicativeExpression
{
    private IES_MultiplicativeExpression _ES_MultiplicativeExpression;
    private AstToken _MULTIPLY;
    private IUnaryExpression _UnaryExpression;

    public IES_MultiplicativeExpression getES_MultiplicativeExpression() { return _ES_MultiplicativeExpression; }
    public AstToken getMULTIPLY() { return _MULTIPLY; }
    public IUnaryExpression getUnaryExpression() { return _UnaryExpression; }

    public ES_MultiplicativeExpression0(IToken leftIToken, IToken rightIToken,
                                        IES_MultiplicativeExpression _ES_MultiplicativeExpression,
                                        AstToken _MULTIPLY,
                                        IUnaryExpression _UnaryExpression)
    {
        super(leftIToken, rightIToken);

        this._ES_MultiplicativeExpression = _ES_MultiplicativeExpression;
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
        if (! (o instanceof ES_MultiplicativeExpression0)) return false;
        ES_MultiplicativeExpression0 other = (ES_MultiplicativeExpression0) o;
        if (! _ES_MultiplicativeExpression.equals(other._ES_MultiplicativeExpression)) return false;
        if (! _MULTIPLY.equals(other._MULTIPLY)) return false;
        if (! _UnaryExpression.equals(other._UnaryExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ES_MultiplicativeExpression.hashCode());
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
            _ES_MultiplicativeExpression.accept(v);
            _MULTIPLY.accept(v);
            _UnaryExpression.accept(v);
        }
        v.endVisit(this);
    }
}


