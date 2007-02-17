//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<em>
 *<li>Rule 284:  ConditionalExpression ::= ConditionalOrExpression
 *</em>
 *<p>
 *<b>
 *<li>Rule 285:  ConditionalExpression ::= ConditionalOrExpression ? Expression : ConditionalExpression
 *</b>
 */
public class ConditionalExpression extends Ast implements IConditionalExpression
{
    private IConditionalOrExpression _ConditionalOrExpression;
    private AstToken _QUESTION;
    private IExpression _Expression;
    private AstToken _COLON;
    private IConditionalExpression _ConditionalExpression;

    public IConditionalOrExpression getConditionalOrExpression() { return _ConditionalOrExpression; }
    public AstToken getQUESTION() { return _QUESTION; }
    public IExpression getExpression() { return _Expression; }
    public AstToken getCOLON() { return _COLON; }
    public IConditionalExpression getConditionalExpression() { return _ConditionalExpression; }

    public ConditionalExpression(IToken leftIToken, IToken rightIToken,
                                 IConditionalOrExpression _ConditionalOrExpression,
                                 AstToken _QUESTION,
                                 IExpression _Expression,
                                 AstToken _COLON,
                                 IConditionalExpression _ConditionalExpression)
    {
        super(leftIToken, rightIToken);

        this._ConditionalOrExpression = _ConditionalOrExpression;
        ((Ast) _ConditionalOrExpression).setParent(this);
        this._QUESTION = _QUESTION;
        ((Ast) _QUESTION).setParent(this);
        this._Expression = _Expression;
        ((Ast) _Expression).setParent(this);
        this._COLON = _COLON;
        ((Ast) _COLON).setParent(this);
        this._ConditionalExpression = _ConditionalExpression;
        ((Ast) _ConditionalExpression).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_ConditionalOrExpression);
        list.add(_QUESTION);
        list.add(_Expression);
        list.add(_COLON);
        list.add(_ConditionalExpression);
        return list;
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
        if (! (o instanceof ConditionalExpression)) return false;
        ConditionalExpression other = (ConditionalExpression) o;
        if (! _ConditionalOrExpression.equals(other._ConditionalOrExpression)) return false;
        if (! _QUESTION.equals(other._QUESTION)) return false;
        if (! _Expression.equals(other._Expression)) return false;
        if (! _COLON.equals(other._COLON)) return false;
        if (! _ConditionalExpression.equals(other._ConditionalExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ConditionalOrExpression.hashCode());
        hash = hash * 31 + (_QUESTION.hashCode());
        hash = hash * 31 + (_Expression.hashCode());
        hash = hash * 31 + (_COLON.hashCode());
        hash = hash * 31 + (_ConditionalExpression.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


