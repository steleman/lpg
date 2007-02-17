//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 252:  CastExpression ::= ( Expression$Name ) UnaryExpressionNotPlusMinus
 *<li>Rule 253:  CastExpression ::= ( Name$Name Dims ) UnaryExpressionNotPlusMinus
 *</b>
 */
public class ClassCastExpression extends Ast implements ICastExpression
{
    private AstToken _LPAREN;
    private IExpression _Name;
    private AstToken _RPAREN;
    private IUnaryExpressionNotPlusMinus _UnaryExpressionNotPlusMinus;
    private DimList _Dims;

    public AstToken getLPAREN() { return _LPAREN; }
    public IExpression getName() { return _Name; }
    public AstToken getRPAREN() { return _RPAREN; }
    public IUnaryExpressionNotPlusMinus getUnaryExpressionNotPlusMinus() { return _UnaryExpressionNotPlusMinus; }
    /**
     * The value returned by <b>getDims</b> may be <b>null</b>
     */
    public DimList getDims() { return _Dims; }

    public ClassCastExpression(IToken leftIToken, IToken rightIToken,
                               AstToken _LPAREN,
                               IExpression _Name,
                               AstToken _RPAREN,
                               IUnaryExpressionNotPlusMinus _UnaryExpressionNotPlusMinus,
                               DimList _Dims)
    {
        super(leftIToken, rightIToken);

        this._LPAREN = _LPAREN;
        ((Ast) _LPAREN).setParent(this);
        this._Name = _Name;
        ((Ast) _Name).setParent(this);
        this._RPAREN = _RPAREN;
        ((Ast) _RPAREN).setParent(this);
        this._UnaryExpressionNotPlusMinus = _UnaryExpressionNotPlusMinus;
        ((Ast) _UnaryExpressionNotPlusMinus).setParent(this);
        this._Dims = _Dims;
        if (_Dims != null) ((Ast) _Dims).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_LPAREN);
        list.add(_Name);
        list.add(_RPAREN);
        list.add(_UnaryExpressionNotPlusMinus);
        list.add(_Dims);
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
        if (! (o instanceof ClassCastExpression)) return false;
        ClassCastExpression other = (ClassCastExpression) o;
        if (! _LPAREN.equals(other._LPAREN)) return false;
        if (! _Name.equals(other._Name)) return false;
        if (! _RPAREN.equals(other._RPAREN)) return false;
        if (! _UnaryExpressionNotPlusMinus.equals(other._UnaryExpressionNotPlusMinus)) return false;
        if (_Dims == null)
            if (other._Dims != null) return false;
            else; // continue
        else if (! _Dims.equals(other._Dims)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_LPAREN.hashCode());
        hash = hash * 31 + (_Name.hashCode());
        hash = hash * 31 + (_RPAREN.hashCode());
        hash = hash * 31 + (_UnaryExpressionNotPlusMinus.hashCode());
        hash = hash * 31 + (_Dims == null ? 0 : _Dims.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


