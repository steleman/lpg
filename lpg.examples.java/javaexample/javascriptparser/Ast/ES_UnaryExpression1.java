package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 470:  ES_UnaryExpression ::= VOID UnaryExpression
 *</b>
 */
public class ES_UnaryExpression1 extends Ast implements IES_UnaryExpression
{
    private AstToken _VOID;
    private IUnaryExpression _UnaryExpression;

    public AstToken getVOID() { return _VOID; }
    public IUnaryExpression getUnaryExpression() { return _UnaryExpression; }

    public ES_UnaryExpression1(IToken leftIToken, IToken rightIToken,
                               AstToken _VOID,
                               IUnaryExpression _UnaryExpression)
    {
        super(leftIToken, rightIToken);

        this._VOID = _VOID;
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
        if (! (o instanceof ES_UnaryExpression1)) return false;
        ES_UnaryExpression1 other = (ES_UnaryExpression1) o;
        if (! _VOID.equals(other._VOID)) return false;
        if (! _UnaryExpression.equals(other._UnaryExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_VOID.hashCode());
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
            _VOID.accept(v);
            _UnaryExpression.accept(v);
        }
        v.endVisit(this);
    }
}


