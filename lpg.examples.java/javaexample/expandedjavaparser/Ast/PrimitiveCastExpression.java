//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 251:  CastExpression ::= ( PrimitiveType Dimsopt ) UnaryExpression
 *</b>
 */
public class PrimitiveCastExpression extends Ast implements ICastExpression
{
    private AstToken _LPAREN;
    private IPrimitiveType _PrimitiveType;
    private DimList _Dimsopt;
    private AstToken _RPAREN;
    private IUnaryExpression _UnaryExpression;

    public AstToken getLPAREN() { return _LPAREN; }
    public IPrimitiveType getPrimitiveType() { return _PrimitiveType; }
    public DimList getDimsopt() { return _Dimsopt; }
    public AstToken getRPAREN() { return _RPAREN; }
    public IUnaryExpression getUnaryExpression() { return _UnaryExpression; }

    public PrimitiveCastExpression(IToken leftIToken, IToken rightIToken,
                                   AstToken _LPAREN,
                                   IPrimitiveType _PrimitiveType,
                                   DimList _Dimsopt,
                                   AstToken _RPAREN,
                                   IUnaryExpression _UnaryExpression)
    {
        super(leftIToken, rightIToken);

        this._LPAREN = _LPAREN;
        ((Ast) _LPAREN).setParent(this);
        this._PrimitiveType = _PrimitiveType;
        ((Ast) _PrimitiveType).setParent(this);
        this._Dimsopt = _Dimsopt;
        ((Ast) _Dimsopt).setParent(this);
        this._RPAREN = _RPAREN;
        ((Ast) _RPAREN).setParent(this);
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
        list.add(_LPAREN);
        list.add(_PrimitiveType);
        list.add(_Dimsopt);
        list.add(_RPAREN);
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
        if (! (o instanceof PrimitiveCastExpression)) return false;
        PrimitiveCastExpression other = (PrimitiveCastExpression) o;
        if (! _LPAREN.equals(other._LPAREN)) return false;
        if (! _PrimitiveType.equals(other._PrimitiveType)) return false;
        if (! _Dimsopt.equals(other._Dimsopt)) return false;
        if (! _RPAREN.equals(other._RPAREN)) return false;
        if (! _UnaryExpression.equals(other._UnaryExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_LPAREN.hashCode());
        hash = hash * 31 + (_PrimitiveType.hashCode());
        hash = hash * 31 + (_Dimsopt.hashCode());
        hash = hash * 31 + (_RPAREN.hashCode());
        hash = hash * 31 + (_UnaryExpression.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


