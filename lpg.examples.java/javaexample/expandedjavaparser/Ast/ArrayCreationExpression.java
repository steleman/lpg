//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 216:  ArrayCreationExpression ::= new PrimitiveType$Type DimExprs Dimsopt
 *<li>Rule 217:  ArrayCreationExpression ::= new ClassOrInterfaceType$Type DimExprs Dimsopt
 *<li>Rule 218:  ArrayCreationExpression ::= new ArrayType$Type ArrayInitializer
 *</b>
 */
public class ArrayCreationExpression extends Ast implements IArrayCreationExpression
{
    private AstToken _new;
    private IType _Type;
    private DimExprList _DimExprs;
    private DimList _Dimsopt;
    private ArrayInitializer _ArrayInitializer;

    public AstToken getnew() { return _new; }
    public IType getType() { return _Type; }
    /**
     * The value returned by <b>getDimExprs</b> may be <b>null</b>
     */
    public DimExprList getDimExprs() { return _DimExprs; }
    /**
     * The value returned by <b>getDimsopt</b> may be <b>null</b>
     */
    public DimList getDimsopt() { return _Dimsopt; }
    /**
     * The value returned by <b>getArrayInitializer</b> may be <b>null</b>
     */
    public ArrayInitializer getArrayInitializer() { return _ArrayInitializer; }

    public ArrayCreationExpression(IToken leftIToken, IToken rightIToken,
                                   AstToken _new,
                                   IType _Type,
                                   DimExprList _DimExprs,
                                   DimList _Dimsopt,
                                   ArrayInitializer _ArrayInitializer)
    {
        super(leftIToken, rightIToken);

        this._new = _new;
        ((Ast) _new).setParent(this);
        this._Type = _Type;
        ((Ast) _Type).setParent(this);
        this._DimExprs = _DimExprs;
        if (_DimExprs != null) ((Ast) _DimExprs).setParent(this);
        this._Dimsopt = _Dimsopt;
        if (_Dimsopt != null) ((Ast) _Dimsopt).setParent(this);
        this._ArrayInitializer = _ArrayInitializer;
        if (_ArrayInitializer != null) ((Ast) _ArrayInitializer).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_new);
        list.add(_Type);
        list.add(_DimExprs);
        list.add(_Dimsopt);
        list.add(_ArrayInitializer);
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
        if (! (o instanceof ArrayCreationExpression)) return false;
        ArrayCreationExpression other = (ArrayCreationExpression) o;
        if (! _new.equals(other._new)) return false;
        if (! _Type.equals(other._Type)) return false;
        if (_DimExprs == null)
            if (other._DimExprs != null) return false;
            else; // continue
        else if (! _DimExprs.equals(other._DimExprs)) return false;
        if (_Dimsopt == null)
            if (other._Dimsopt != null) return false;
            else; // continue
        else if (! _Dimsopt.equals(other._Dimsopt)) return false;
        if (_ArrayInitializer == null)
            if (other._ArrayInitializer != null) return false;
            else; // continue
        else if (! _ArrayInitializer.equals(other._ArrayInitializer)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_new.hashCode());
        hash = hash * 31 + (_Type.hashCode());
        hash = hash * 31 + (_DimExprs == null ? 0 : _DimExprs.hashCode());
        hash = hash * 31 + (_Dimsopt == null ? 0 : _Dimsopt.hashCode());
        hash = hash * 31 + (_ArrayInitializer == null ? 0 : _ArrayInitializer.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


