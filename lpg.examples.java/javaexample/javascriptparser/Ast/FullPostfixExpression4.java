package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 62:  FullPostfixExpression ::= PostfixExpression no_line_break$ --
 *</b>
 */
public class FullPostfixExpression4 extends Ast implements IFullPostfixExpression
{
    private IPostfixExpression _PostfixExpression;
    private AstToken _MINUS_MINUS;

    public IPostfixExpression getPostfixExpression() { return _PostfixExpression; }
    public AstToken getMINUS_MINUS() { return _MINUS_MINUS; }

    public FullPostfixExpression4(IToken leftIToken, IToken rightIToken,
                                  IPostfixExpression _PostfixExpression,
                                  AstToken _MINUS_MINUS)
    {
        super(leftIToken, rightIToken);

        this._PostfixExpression = _PostfixExpression;
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
        if (! (o instanceof FullPostfixExpression4)) return false;
        FullPostfixExpression4 other = (FullPostfixExpression4) o;
        if (! _PostfixExpression.equals(other._PostfixExpression)) return false;
        if (! _MINUS_MINUS.equals(other._MINUS_MINUS)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_PostfixExpression.hashCode());
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
            _PostfixExpression.accept(v);
            _MINUS_MINUS.accept(v);
        }
        v.endVisit(this);
    }
}


