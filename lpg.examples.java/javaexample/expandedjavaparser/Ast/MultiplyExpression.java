//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 255:  MultiplicativeExpression ::= MultiplicativeExpression * UnaryExpression
 *</b>
 */
public class MultiplyExpression extends Ast implements IMultiplicativeExpression
{
    private IMultiplicativeExpression _MultiplicativeExpression;
    private AstToken _MULTIPLY;
    private IUnaryExpression _UnaryExpression;

    public IMultiplicativeExpression getMultiplicativeExpression() { return _MultiplicativeExpression; }
    public AstToken getMULTIPLY() { return _MULTIPLY; }
    public IUnaryExpression getUnaryExpression() { return _UnaryExpression; }

    public MultiplyExpression(IToken leftIToken, IToken rightIToken,
                              IMultiplicativeExpression _MultiplicativeExpression,
                              AstToken _MULTIPLY,
                              IUnaryExpression _UnaryExpression)
    {
        super(leftIToken, rightIToken);

        this._MultiplicativeExpression = _MultiplicativeExpression;
        ((Ast) _MultiplicativeExpression).setParent(this);
        this._MULTIPLY = _MULTIPLY;
        ((Ast) _MULTIPLY).setParent(this);
        this._UnaryExpression = _UnaryExpression;
        ((Ast) _UnaryExpression).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_MultiplicativeExpression);
        list.add(_MULTIPLY);
        list.add(_UnaryExpression);
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
        if (! (o instanceof MultiplyExpression)) return false;
        MultiplyExpression other = (MultiplyExpression) o;
        if (! _MultiplicativeExpression.equals(other._MultiplicativeExpression)) return false;
        if (! _MULTIPLY.equals(other._MULTIPLY)) return false;
        if (! _UnaryExpression.equals(other._UnaryExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_MultiplicativeExpression.hashCode());
        hash = hash * 31 + (_MULTIPLY.hashCode());
        hash = hash * 31 + (_UnaryExpression.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}

