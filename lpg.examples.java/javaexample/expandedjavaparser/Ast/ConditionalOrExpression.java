//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<em>
 *<li>Rule 282:  ConditionalOrExpression ::= ConditionalAndExpression
 *</em>
 *<p>
 *<b>
 *<li>Rule 283:  ConditionalOrExpression ::= ConditionalOrExpression || ConditionalAndExpression
 *</b>
 */
public class ConditionalOrExpression extends Ast implements IConditionalOrExpression
{
    private IConditionalOrExpression _ConditionalOrExpression;
    private AstToken _OR_OR;
    private IConditionalAndExpression _ConditionalAndExpression;

    public IConditionalOrExpression getConditionalOrExpression() { return _ConditionalOrExpression; }
    public AstToken getOR_OR() { return _OR_OR; }
    public IConditionalAndExpression getConditionalAndExpression() { return _ConditionalAndExpression; }

    public ConditionalOrExpression(IToken leftIToken, IToken rightIToken,
                                   IConditionalOrExpression _ConditionalOrExpression,
                                   AstToken _OR_OR,
                                   IConditionalAndExpression _ConditionalAndExpression)
    {
        super(leftIToken, rightIToken);

        this._ConditionalOrExpression = _ConditionalOrExpression;
        ((Ast) _ConditionalOrExpression).setParent(this);
        this._OR_OR = _OR_OR;
        ((Ast) _OR_OR).setParent(this);
        this._ConditionalAndExpression = _ConditionalAndExpression;
        ((Ast) _ConditionalAndExpression).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_ConditionalOrExpression);
        list.add(_OR_OR);
        list.add(_ConditionalAndExpression);
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
        if (! (o instanceof ConditionalOrExpression)) return false;
        ConditionalOrExpression other = (ConditionalOrExpression) o;
        if (! _ConditionalOrExpression.equals(other._ConditionalOrExpression)) return false;
        if (! _OR_OR.equals(other._OR_OR)) return false;
        if (! _ConditionalAndExpression.equals(other._ConditionalAndExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ConditionalOrExpression.hashCode());
        hash = hash * 31 + (_OR_OR.hashCode());
        hash = hash * 31 + (_ConditionalAndExpression.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


