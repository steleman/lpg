package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 466:  ES_FullPostfixExpression ::= ES_PostfixExpression no_line_break$ ++
 *</b>
 */
public class ES_FullPostfixExpression3 extends Ast implements IES_FullPostfixExpression
{
    private IES_PostfixExpression _ES_PostfixExpression;
    private AstToken _PLUS_PLUS;

    public IES_PostfixExpression getES_PostfixExpression() { return _ES_PostfixExpression; }
    public AstToken getPLUS_PLUS() { return _PLUS_PLUS; }

    public ES_FullPostfixExpression3(IToken leftIToken, IToken rightIToken,
                                     IES_PostfixExpression _ES_PostfixExpression,
                                     AstToken _PLUS_PLUS)
    {
        super(leftIToken, rightIToken);

        this._ES_PostfixExpression = _ES_PostfixExpression;
        this._PLUS_PLUS = _PLUS_PLUS;
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
        if (! (o instanceof ES_FullPostfixExpression3)) return false;
        ES_FullPostfixExpression3 other = (ES_FullPostfixExpression3) o;
        if (! _ES_PostfixExpression.equals(other._ES_PostfixExpression)) return false;
        if (! _PLUS_PLUS.equals(other._PLUS_PLUS)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ES_PostfixExpression.hashCode());
        hash = hash * 31 + (_PLUS_PLUS.hashCode());
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
            _PLUS_PLUS.accept(v);
        }
        v.endVisit(this);
    }
}


