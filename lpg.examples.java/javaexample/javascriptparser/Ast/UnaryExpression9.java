package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 93:  UnaryExpression ::= ! UnaryExpression
 *</b>
 */
public class UnaryExpression9 extends Ast implements IUnaryExpression
{
    private AstToken _NOT;
    private IUnaryExpression _UnaryExpression;

    public AstToken getNOT() { return _NOT; }
    public IUnaryExpression getUnaryExpression() { return _UnaryExpression; }

    public UnaryExpression9(IToken leftIToken, IToken rightIToken,
                            AstToken _NOT,
                            IUnaryExpression _UnaryExpression)
    {
        super(leftIToken, rightIToken);

        this._NOT = _NOT;
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
        if (! (o instanceof UnaryExpression9)) return false;
        UnaryExpression9 other = (UnaryExpression9) o;
        if (! _NOT.equals(other._NOT)) return false;
        if (! _UnaryExpression.equals(other._UnaryExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_NOT.hashCode());
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
            _NOT.accept(v);
            _UnaryExpression.accept(v);
        }
        v.endVisit(this);
    }
}


