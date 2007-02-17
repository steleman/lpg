package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 60:  FullPostfixExpression ::= FullPostfixExpression Arguments
 *</b>
 */
public class FullPostfixExpression2 extends Ast implements IFullPostfixExpression
{
    private IFullPostfixExpression _FullPostfixExpression;
    private IArguments _Arguments;

    public IFullPostfixExpression getFullPostfixExpression() { return _FullPostfixExpression; }
    public IArguments getArguments() { return _Arguments; }

    public FullPostfixExpression2(IToken leftIToken, IToken rightIToken,
                                  IFullPostfixExpression _FullPostfixExpression,
                                  IArguments _Arguments)
    {
        super(leftIToken, rightIToken);

        this._FullPostfixExpression = _FullPostfixExpression;
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
        if (! (o instanceof FullPostfixExpression2)) return false;
        FullPostfixExpression2 other = (FullPostfixExpression2) o;
        if (! _FullPostfixExpression.equals(other._FullPostfixExpression)) return false;
        if (! _Arguments.equals(other._Arguments)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_FullPostfixExpression.hashCode());
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
            _FullPostfixExpression.accept(v);
            _Arguments.accept(v);
        }
        v.endVisit(this);
    }
}


