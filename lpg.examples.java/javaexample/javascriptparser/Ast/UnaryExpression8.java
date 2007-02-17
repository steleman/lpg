package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 92:  UnaryExpression ::= ~ UnaryExpression
 *</b>
 */
public class UnaryExpression8 extends Ast implements IUnaryExpression
{
    private AstToken _TWIDDLE;
    private IUnaryExpression _UnaryExpression;

    public AstToken getTWIDDLE() { return _TWIDDLE; }
    public IUnaryExpression getUnaryExpression() { return _UnaryExpression; }

    public UnaryExpression8(IToken leftIToken, IToken rightIToken,
                            AstToken _TWIDDLE,
                            IUnaryExpression _UnaryExpression)
    {
        super(leftIToken, rightIToken);

        this._TWIDDLE = _TWIDDLE;
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
        if (! (o instanceof UnaryExpression8)) return false;
        UnaryExpression8 other = (UnaryExpression8) o;
        if (! _TWIDDLE.equals(other._TWIDDLE)) return false;
        if (! _UnaryExpression.equals(other._UnaryExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_TWIDDLE.hashCode());
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
            _TWIDDLE.accept(v);
            _UnaryExpression.accept(v);
        }
        v.endVisit(this);
    }
}


