//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<em>
 *<li>Rule 274:  AndExpression ::= EqualityExpression
 *</em>
 *<p>
 *<b>
 *<li>Rule 275:  AndExpression ::= AndExpression & EqualityExpression
 *</b>
 */
public class AndExpression extends Ast implements IAndExpression
{
    private IAndExpression _AndExpression;
    private AstToken _AND;
    private IEqualityExpression _EqualityExpression;

    public IAndExpression getAndExpression() { return _AndExpression; }
    public AstToken getAND() { return _AND; }
    public IEqualityExpression getEqualityExpression() { return _EqualityExpression; }

    public AndExpression(IToken leftIToken, IToken rightIToken,
                         IAndExpression _AndExpression,
                         AstToken _AND,
                         IEqualityExpression _EqualityExpression)
    {
        super(leftIToken, rightIToken);

        this._AndExpression = _AndExpression;
        ((Ast) _AndExpression).setParent(this);
        this._AND = _AND;
        ((Ast) _AND).setParent(this);
        this._EqualityExpression = _EqualityExpression;
        ((Ast) _EqualityExpression).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_AndExpression);
        list.add(_AND);
        list.add(_EqualityExpression);
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
        if (! (o instanceof AndExpression)) return false;
        AndExpression other = (AndExpression) o;
        if (! _AndExpression.equals(other._AndExpression)) return false;
        if (! _AND.equals(other._AND)) return false;
        if (! _EqualityExpression.equals(other._EqualityExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_AndExpression.hashCode());
        hash = hash * 31 + (_AND.hashCode());
        hash = hash * 31 + (_EqualityExpression.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


