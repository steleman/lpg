package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 86:  UnaryExpression ::= TYPEOF UnaryExpression
 *</b>
 */
public class UnaryExpression2 extends Ast implements IUnaryExpression
{
    private AstToken _TYPEOF;
    private IUnaryExpression _UnaryExpression;

    public AstToken getTYPEOF() { return _TYPEOF; }
    public IUnaryExpression getUnaryExpression() { return _UnaryExpression; }

    public UnaryExpression2(IToken leftIToken, IToken rightIToken,
                            AstToken _TYPEOF,
                            IUnaryExpression _UnaryExpression)
    {
        super(leftIToken, rightIToken);

        this._TYPEOF = _TYPEOF;
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
        if (! (o instanceof UnaryExpression2)) return false;
        UnaryExpression2 other = (UnaryExpression2) o;
        if (! _TYPEOF.equals(other._TYPEOF)) return false;
        if (! _UnaryExpression.equals(other._UnaryExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_TYPEOF.hashCode());
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
            _TYPEOF.accept(v);
            _UnaryExpression.accept(v);
        }
        v.endVisit(this);
    }
}


