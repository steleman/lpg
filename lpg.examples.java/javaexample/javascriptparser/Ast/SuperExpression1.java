package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 48:  SuperExpression ::= SUPER ParenExpression
 *</b>
 */
public class SuperExpression1 extends Ast implements ISuperExpression
{
    private AstToken _SUPER;
    private ParenExpression _ParenExpression;

    public AstToken getSUPER() { return _SUPER; }
    public ParenExpression getParenExpression() { return _ParenExpression; }

    public SuperExpression1(IToken leftIToken, IToken rightIToken,
                            AstToken _SUPER,
                            ParenExpression _ParenExpression)
    {
        super(leftIToken, rightIToken);

        this._SUPER = _SUPER;
        this._ParenExpression = _ParenExpression;
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
        if (! (o instanceof SuperExpression1)) return false;
        SuperExpression1 other = (SuperExpression1) o;
        if (! _SUPER.equals(other._SUPER)) return false;
        if (! _ParenExpression.equals(other._ParenExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_SUPER.hashCode());
        hash = hash * 31 + (_ParenExpression.hashCode());
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
            _SUPER.accept(v);
            _ParenExpression.accept(v);
        }
        v.endVisit(this);
    }
}


