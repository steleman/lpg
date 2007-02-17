//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 221:  DimExpr ::= [ Expression ]
 *</b>
 */
public class DimExpr extends Ast implements IDimExpr
{
    private AstToken _LBRACKET;
    private IExpression _Expression;
    private AstToken _RBRACKET;

    public AstToken getLBRACKET() { return _LBRACKET; }
    public IExpression getExpression() { return _Expression; }
    public AstToken getRBRACKET() { return _RBRACKET; }

    public DimExpr(IToken leftIToken, IToken rightIToken,
                   AstToken _LBRACKET,
                   IExpression _Expression,
                   AstToken _RBRACKET)
    {
        super(leftIToken, rightIToken);

        this._LBRACKET = _LBRACKET;
        ((Ast) _LBRACKET).setParent(this);
        this._Expression = _Expression;
        ((Ast) _Expression).setParent(this);
        this._RBRACKET = _RBRACKET;
        ((Ast) _RBRACKET).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_LBRACKET);
        list.add(_Expression);
        list.add(_RBRACKET);
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
        if (! (o instanceof DimExpr)) return false;
        DimExpr other = (DimExpr) o;
        if (! _LBRACKET.equals(other._LBRACKET)) return false;
        if (! _Expression.equals(other._Expression)) return false;
        if (! _RBRACKET.equals(other._RBRACKET)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_LBRACKET.hashCode());
        hash = hash * 31 + (_Expression.hashCode());
        hash = hash * 31 + (_RBRACKET.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


