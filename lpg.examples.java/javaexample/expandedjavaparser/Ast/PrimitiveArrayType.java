//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 27:  ArrayType ::= PrimitiveType Dims
 *</b>
 */
public class PrimitiveArrayType extends Ast implements IArrayType
{
    private IPrimitiveType _PrimitiveType;
    private DimList _Dims;

    public IPrimitiveType getPrimitiveType() { return _PrimitiveType; }
    public DimList getDims() { return _Dims; }

    public PrimitiveArrayType(IToken leftIToken, IToken rightIToken,
                              IPrimitiveType _PrimitiveType,
                              DimList _Dims)
    {
        super(leftIToken, rightIToken);

        this._PrimitiveType = _PrimitiveType;
        ((Ast) _PrimitiveType).setParent(this);
        this._Dims = _Dims;
        ((Ast) _Dims).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_PrimitiveType);
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
        if (! (o instanceof PrimitiveArrayType)) return false;
        PrimitiveArrayType other = (PrimitiveArrayType) o;
        if (! _PrimitiveType.equals(other._PrimitiveType)) return false;
        if (! _Dims.equals(other._Dims)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_PrimitiveType.hashCode());
        hash = hash * 31 + (_Dims.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


