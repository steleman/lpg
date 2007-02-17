package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 61:  FullPostfixExpression ::= PostfixExpression no_line_break$ ++
 *</b>
 */
public class FullPostfixExpression3 extends Ast implements IFullPostfixExpression
{
    private IPostfixExpression _PostfixExpression;
    private AstToken _PLUS_PLUS;

    public IPostfixExpression getPostfixExpression() { return _PostfixExpression; }
    public AstToken getPLUS_PLUS() { return _PLUS_PLUS; }

    public FullPostfixExpression3(IToken leftIToken, IToken rightIToken,
                                  IPostfixExpression _PostfixExpression,
                                  AstToken _PLUS_PLUS)
    {
        super(leftIToken, rightIToken);

        this._PostfixExpression = _PostfixExpression;
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
        if (! (o instanceof FullPostfixExpression3)) return false;
        FullPostfixExpression3 other = (FullPostfixExpression3) o;
        if (! _PostfixExpression.equals(other._PostfixExpression)) return false;
        if (! _PLUS_PLUS.equals(other._PLUS_PLUS)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_PostfixExpression.hashCode());
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
            _PostfixExpression.accept(v);
            _PLUS_PLUS.accept(v);
        }
        v.endVisit(this);
    }
}


