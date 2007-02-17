package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 91:  UnaryExpression ::= - NegatedMinLong
 *</b>
 */
public class UnaryExpression7 extends Ast implements IUnaryExpression
{
    private AstToken _MINUS;
    private AstToken _NegatedMinLong;

    public AstToken getMINUS() { return _MINUS; }
    public AstToken getNegatedMinLong() { return _NegatedMinLong; }

    public UnaryExpression7(IToken leftIToken, IToken rightIToken,
                            AstToken _MINUS,
                            AstToken _NegatedMinLong)
    {
        super(leftIToken, rightIToken);

        this._MINUS = _MINUS;
        this._NegatedMinLong = _NegatedMinLong;
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
        if (! (o instanceof UnaryExpression7)) return false;
        UnaryExpression7 other = (UnaryExpression7) o;
        if (! _MINUS.equals(other._MINUS)) return false;
        if (! _NegatedMinLong.equals(other._NegatedMinLong)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_MINUS.hashCode());
        hash = hash * 31 + (_NegatedMinLong.hashCode());
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
            _NegatedMinLong.accept(v);
        }
        v.endVisit(this);
    }
}


