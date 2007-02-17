//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<em>
 *<li>Rule 280:  ConditionalAndExpression ::= InclusiveOrExpression
 *</em>
 *<p>
 *<b>
 *<li>Rule 281:  ConditionalAndExpression ::= ConditionalAndExpression && InclusiveOrExpression
 *</b>
 */
public class ConditionalAndExpression extends Ast implements IConditionalAndExpression
{
    private IConditionalAndExpression _ConditionalAndExpression;
    private AstToken _AND_AND;
    private IInclusiveOrExpression _InclusiveOrExpression;

    public IConditionalAndExpression getConditionalAndExpression() { return _ConditionalAndExpression; }
    public AstToken getAND_AND() { return _AND_AND; }
    public IInclusiveOrExpression getInclusiveOrExpression() { return _InclusiveOrExpression; }

    public ConditionalAndExpression(IToken leftIToken, IToken rightIToken,
                                    IConditionalAndExpression _ConditionalAndExpression,
                                    AstToken _AND_AND,
                                    IInclusiveOrExpression _InclusiveOrExpression)
    {
        super(leftIToken, rightIToken);

        this._ConditionalAndExpression = _ConditionalAndExpression;
        ((Ast) _ConditionalAndExpression).setParent(this);
        this._AND_AND = _AND_AND;
        ((Ast) _AND_AND).setParent(this);
        this._InclusiveOrExpression = _InclusiveOrExpression;
        ((Ast) _InclusiveOrExpression).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_ConditionalAndExpression);
        list.add(_AND_AND);
        list.add(_InclusiveOrExpression);
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
        if (! (o instanceof ConditionalAndExpression)) return false;
        ConditionalAndExpression other = (ConditionalAndExpression) o;
        if (! _ConditionalAndExpression.equals(other._ConditionalAndExpression)) return false;
        if (! _AND_AND.equals(other._AND_AND)) return false;
        if (! _InclusiveOrExpression.equals(other._InclusiveOrExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ConditionalAndExpression.hashCode());
        hash = hash * 31 + (_AND_AND.hashCode());
        hash = hash * 31 + (_InclusiveOrExpression.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


