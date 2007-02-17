package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 474:  ES_UnaryExpression ::= + UnaryExpression
 *</b>
 */
public class ES_UnaryExpression5 extends Ast implements IES_UnaryExpression
{
    private AstToken _PLUS;
    private IUnaryExpression _UnaryExpression;

    public AstToken getPLUS() { return _PLUS; }
    public IUnaryExpression getUnaryExpression() { return _UnaryExpression; }

    public ES_UnaryExpression5(IToken leftIToken, IToken rightIToken,
                               AstToken _PLUS,
                               IUnaryExpression _UnaryExpression)
    {
        super(leftIToken, rightIToken);

        this._PLUS = _PLUS;
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
        if (! (o instanceof ES_UnaryExpression5)) return false;
        ES_UnaryExpression5 other = (ES_UnaryExpression5) o;
        if (! _PLUS.equals(other._PLUS)) return false;
        if (! _UnaryExpression.equals(other._UnaryExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_PLUS.hashCode());
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
            _PLUS.accept(v);
            _UnaryExpression.accept(v);
        }
        v.endVisit(this);
    }
}


