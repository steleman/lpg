package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 80:  ExpressionsWithRest ::= RestExpression
 *</em>
 *<p>
 *<b>
 *<li>Rule 81:  ExpressionsWithRest ::= ListExpression_allowIn , RestExpression
 *</b>
 */
public class ExpressionsWithRest extends Ast implements IExpressionsWithRest
{
    private IListExpression_allowIn _ListExpression_allowIn;
    private AstToken _COMMA;
    private RestExpression _RestExpression;

    public IListExpression_allowIn getListExpression_allowIn() { return _ListExpression_allowIn; }
    public AstToken getCOMMA() { return _COMMA; }
    public RestExpression getRestExpression() { return _RestExpression; }

    public ExpressionsWithRest(IToken leftIToken, IToken rightIToken,
                               IListExpression_allowIn _ListExpression_allowIn,
                               AstToken _COMMA,
                               RestExpression _RestExpression)
    {
        super(leftIToken, rightIToken);

        this._ListExpression_allowIn = _ListExpression_allowIn;
        this._COMMA = _COMMA;
        this._RestExpression = _RestExpression;
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
        if (! (o instanceof ExpressionsWithRest)) return false;
        ExpressionsWithRest other = (ExpressionsWithRest) o;
        if (! _ListExpression_allowIn.equals(other._ListExpression_allowIn)) return false;
        if (! _COMMA.equals(other._COMMA)) return false;
        if (! _RestExpression.equals(other._RestExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ListExpression_allowIn.hashCode());
        hash = hash * 31 + (_COMMA.hashCode());
        hash = hash * 31 + (_RestExpression.hashCode());
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
            _ListExpression_allowIn.accept(v);
            _COMMA.accept(v);
            _RestExpression.accept(v);
        }
        v.endVisit(this);
    }
}


