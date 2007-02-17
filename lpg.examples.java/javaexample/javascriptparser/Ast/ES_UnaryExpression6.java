package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 475:  ES_UnaryExpression ::= - UnaryExpression
 *</b>
 */
public class ES_UnaryExpression6 extends Ast implements IES_UnaryExpression
{
    private AstToken _MINUS;
    private IUnaryExpression _UnaryExpression;

    public AstToken getMINUS() { return _MINUS; }
    public IUnaryExpression getUnaryExpression() { return _UnaryExpression; }

    public ES_UnaryExpression6(IToken leftIToken, IToken rightIToken,
                               AstToken _MINUS,
                               IUnaryExpression _UnaryExpression)
    {
        super(leftIToken, rightIToken);

        this._MINUS = _MINUS;
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
        if (! (o instanceof ES_UnaryExpression6)) return false;
        ES_UnaryExpression6 other = (ES_UnaryExpression6) o;
        if (! _MINUS.equals(other._MINUS)) return false;
        if (! _UnaryExpression.equals(other._UnaryExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_MINUS.hashCode());
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
            _MINUS.accept(v);
            _UnaryExpression.accept(v);
        }
        v.endVisit(this);
    }
}


