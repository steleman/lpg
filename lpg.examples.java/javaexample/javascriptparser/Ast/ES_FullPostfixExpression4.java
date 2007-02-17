package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 467:  ES_FullPostfixExpression ::= ES_PostfixExpression no_line_break$ --
 *</b>
 */
public class ES_FullPostfixExpression4 extends Ast implements IES_FullPostfixExpression
{
    private IES_PostfixExpression _ES_PostfixExpression;
    private AstToken _MINUS_MINUS;

    public IES_PostfixExpression getES_PostfixExpression() { return _ES_PostfixExpression; }
    public AstToken getMINUS_MINUS() { return _MINUS_MINUS; }

    public ES_FullPostfixExpression4(IToken leftIToken, IToken rightIToken,
                                     IES_PostfixExpression _ES_PostfixExpression,
                                     AstToken _MINUS_MINUS)
    {
        super(leftIToken, rightIToken);

        this._ES_PostfixExpression = _ES_PostfixExpression;
        this._MINUS_MINUS = _MINUS_MINUS;
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
        if (! (o instanceof ES_FullPostfixExpression4)) return false;
        ES_FullPostfixExpression4 other = (ES_FullPostfixExpression4) o;
        if (! _ES_PostfixExpression.equals(other._ES_PostfixExpression)) return false;
        if (! _MINUS_MINUS.equals(other._MINUS_MINUS)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ES_PostfixExpression.hashCode());
        hash = hash * 31 + (_MINUS_MINUS.hashCode());
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
            _ES_PostfixExpression.accept(v);
            _MINUS_MINUS.accept(v);
        }
        v.endVisit(this);
    }
}


