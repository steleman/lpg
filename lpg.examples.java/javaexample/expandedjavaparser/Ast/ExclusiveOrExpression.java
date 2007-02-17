//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<em>
 *<li>Rule 276:  ExclusiveOrExpression ::= AndExpression
 *</em>
 *<p>
 *<b>
 *<li>Rule 277:  ExclusiveOrExpression ::= ExclusiveOrExpression ^ AndExpression
 *</b>
 */
public class ExclusiveOrExpression extends Ast implements IExclusiveOrExpression
{
    private IExclusiveOrExpression _ExclusiveOrExpression;
    private AstToken _XOR;
    private IAndExpression _AndExpression;

    public IExclusiveOrExpression getExclusiveOrExpression() { return _ExclusiveOrExpression; }
    public AstToken getXOR() { return _XOR; }
    public IAndExpression getAndExpression() { return _AndExpression; }

    public ExclusiveOrExpression(IToken leftIToken, IToken rightIToken,
                                 IExclusiveOrExpression _ExclusiveOrExpression,
                                 AstToken _XOR,
                                 IAndExpression _AndExpression)
    {
        super(leftIToken, rightIToken);

        this._ExclusiveOrExpression = _ExclusiveOrExpression;
        ((Ast) _ExclusiveOrExpression).setParent(this);
        this._XOR = _XOR;
        ((Ast) _XOR).setParent(this);
        this._AndExpression = _AndExpression;
        ((Ast) _AndExpression).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_ExclusiveOrExpression);
        list.add(_XOR);
        list.add(_AndExpression);
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
        if (! (o instanceof ExclusiveOrExpression)) return false;
        ExclusiveOrExpression other = (ExclusiveOrExpression) o;
        if (! _ExclusiveOrExpression.equals(other._ExclusiveOrExpression)) return false;
        if (! _XOR.equals(other._XOR)) return false;
        if (! _AndExpression.equals(other._AndExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ExclusiveOrExpression.hashCode());
        hash = hash * 31 + (_XOR.hashCode());
        hash = hash * 31 + (_AndExpression.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


