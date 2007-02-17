//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<em>
 *<li>Rule 278:  InclusiveOrExpression ::= ExclusiveOrExpression
 *</em>
 *<p>
 *<b>
 *<li>Rule 279:  InclusiveOrExpression ::= InclusiveOrExpression | ExclusiveOrExpression
 *</b>
 */
public class InclusiveOrExpression extends Ast implements IInclusiveOrExpression
{
    private IInclusiveOrExpression _InclusiveOrExpression;
    private AstToken _OR;
    private IExclusiveOrExpression _ExclusiveOrExpression;

    public IInclusiveOrExpression getInclusiveOrExpression() { return _InclusiveOrExpression; }
    public AstToken getOR() { return _OR; }
    public IExclusiveOrExpression getExclusiveOrExpression() { return _ExclusiveOrExpression; }

    public InclusiveOrExpression(IToken leftIToken, IToken rightIToken,
                                 IInclusiveOrExpression _InclusiveOrExpression,
                                 AstToken _OR,
                                 IExclusiveOrExpression _ExclusiveOrExpression)
    {
        super(leftIToken, rightIToken);

        this._InclusiveOrExpression = _InclusiveOrExpression;
        ((Ast) _InclusiveOrExpression).setParent(this);
        this._OR = _OR;
        ((Ast) _OR).setParent(this);
        this._ExclusiveOrExpression = _ExclusiveOrExpression;
        ((Ast) _ExclusiveOrExpression).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_InclusiveOrExpression);
        list.add(_OR);
        list.add(_ExclusiveOrExpression);
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
        if (! (o instanceof InclusiveOrExpression)) return false;
        InclusiveOrExpression other = (InclusiveOrExpression) o;
        if (! _InclusiveOrExpression.equals(other._InclusiveOrExpression)) return false;
        if (! _OR.equals(other._OR)) return false;
        if (! _ExclusiveOrExpression.equals(other._ExclusiveOrExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_InclusiveOrExpression.hashCode());
        hash = hash * 31 + (_OR.hashCode());
        hash = hash * 31 + (_ExclusiveOrExpression.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


