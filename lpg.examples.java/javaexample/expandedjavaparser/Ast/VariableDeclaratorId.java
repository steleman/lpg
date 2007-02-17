//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 83:  VariableDeclaratorId ::= IDENTIFIER Dimsopt
 *</b>
 */
public class VariableDeclaratorId extends Ast implements IVariableDeclaratorId
{
    private AstToken _IDENTIFIER;
    private DimList _Dimsopt;

    public AstToken getIDENTIFIER() { return _IDENTIFIER; }
    public DimList getDimsopt() { return _Dimsopt; }

    public VariableDeclaratorId(IToken leftIToken, IToken rightIToken,
                                AstToken _IDENTIFIER,
                                DimList _Dimsopt)
    {
        super(leftIToken, rightIToken);

        this._IDENTIFIER = _IDENTIFIER;
        ((Ast) _IDENTIFIER).setParent(this);
        this._Dimsopt = _Dimsopt;
        ((Ast) _Dimsopt).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_IDENTIFIER);
        list.add(_Dimsopt);
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
        if (! (o instanceof VariableDeclaratorId)) return false;
        VariableDeclaratorId other = (VariableDeclaratorId) o;
        if (! _IDENTIFIER.equals(other._IDENTIFIER)) return false;
        if (! _Dimsopt.equals(other._Dimsopt)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_IDENTIFIER.hashCode());
        hash = hash * 31 + (_Dimsopt.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


