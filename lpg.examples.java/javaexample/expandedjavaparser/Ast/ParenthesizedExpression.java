//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 206:  PrimaryNoNewArray ::= ( Expression )
 *</b>
 */
public class ParenthesizedExpression extends Ast implements IPrimaryNoNewArray
{
    private AstToken _LPAREN;
    private IExpression _Expression;
    private AstToken _RPAREN;

    public AstToken getLPAREN() { return _LPAREN; }
    public IExpression getExpression() { return _Expression; }
    public AstToken getRPAREN() { return _RPAREN; }

    public ParenthesizedExpression(IToken leftIToken, IToken rightIToken,
                                   AstToken _LPAREN,
                                   IExpression _Expression,
                                   AstToken _RPAREN)
    {
        super(leftIToken, rightIToken);

        this._LPAREN = _LPAREN;
        ((Ast) _LPAREN).setParent(this);
        this._Expression = _Expression;
        ((Ast) _Expression).setParent(this);
        this._RPAREN = _RPAREN;
        ((Ast) _RPAREN).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_LPAREN);
        list.add(_Expression);
        list.add(_RPAREN);
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
        if (! (o instanceof ParenthesizedExpression)) return false;
        ParenthesizedExpression other = (ParenthesizedExpression) o;
        if (! _LPAREN.equals(other._LPAREN)) return false;
        if (! _Expression.equals(other._Expression)) return false;
        if (! _RPAREN.equals(other._RPAREN)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_LPAREN.hashCode());
        hash = hash * 31 + (_Expression.hashCode());
        hash = hash * 31 + (_RPAREN.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


