package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 465:  ES_FullPostfixExpression ::= ES_FullPostfixExpression Arguments
 *</b>
 */
public class ES_FullPostfixExpression2 extends Ast implements IES_FullPostfixExpression
{
    private IES_FullPostfixExpression _ES_FullPostfixExpression;
    private IArguments _Arguments;

    public IES_FullPostfixExpression getES_FullPostfixExpression() { return _ES_FullPostfixExpression; }
    public IArguments getArguments() { return _Arguments; }

    public ES_FullPostfixExpression2(IToken leftIToken, IToken rightIToken,
                                     IES_FullPostfixExpression _ES_FullPostfixExpression,
                                     IArguments _Arguments)
    {
        super(leftIToken, rightIToken);

        this._ES_FullPostfixExpression = _ES_FullPostfixExpression;
        this._Arguments = _Arguments;
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
        if (! (o instanceof ES_FullPostfixExpression2)) return false;
        ES_FullPostfixExpression2 other = (ES_FullPostfixExpression2) o;
        if (! _ES_FullPostfixExpression.equals(other._ES_FullPostfixExpression)) return false;
        if (! _Arguments.equals(other._Arguments)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ES_FullPostfixExpression.hashCode());
        hash = hash * 31 + (_Arguments.hashCode());
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
            _ES_FullPostfixExpression.accept(v);
            _Arguments.accept(v);
        }
        v.endVisit(this);
    }
}


