//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 260:  AdditiveExpression ::= AdditiveExpression - MultiplicativeExpression
 *</b>
 */
public class SubtractExpression extends Ast implements IAdditiveExpression
{
    private IAdditiveExpression _AdditiveExpression;
    private AstToken _MINUS;
    private IMultiplicativeExpression _MultiplicativeExpression;

    public IAdditiveExpression getAdditiveExpression() { return _AdditiveExpression; }
    public AstToken getMINUS() { return _MINUS; }
    public IMultiplicativeExpression getMultiplicativeExpression() { return _MultiplicativeExpression; }

    public SubtractExpression(IToken leftIToken, IToken rightIToken,
                              IAdditiveExpression _AdditiveExpression,
                              AstToken _MINUS,
                              IMultiplicativeExpression _MultiplicativeExpression)
    {
        super(leftIToken, rightIToken);

        this._AdditiveExpression = _AdditiveExpression;
        ((Ast) _AdditiveExpression).setParent(this);
        this._MINUS = _MINUS;
        ((Ast) _MINUS).setParent(this);
        this._MultiplicativeExpression = _MultiplicativeExpression;
        ((Ast) _MultiplicativeExpression).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_AdditiveExpression);
        list.add(_MINUS);
        list.add(_MultiplicativeExpression);
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
        if (! (o instanceof SubtractExpression)) return false;
        SubtractExpression other = (SubtractExpression) o;
        if (! _AdditiveExpression.equals(other._AdditiveExpression)) return false;
        if (! _MINUS.equals(other._MINUS)) return false;
        if (! _MultiplicativeExpression.equals(other._MultiplicativeExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_AdditiveExpression.hashCode());
        hash = hash * 31 + (_MINUS.hashCode());
        hash = hash * 31 + (_MultiplicativeExpression.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


