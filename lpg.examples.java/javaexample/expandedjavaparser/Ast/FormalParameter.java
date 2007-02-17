//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 92:  FormalParameter ::= Modifiersopt Type VariableDeclaratorId
 *</b>
 */
public class FormalParameter extends Ast implements IFormalParameter
{
    private ModifierList _Modifiersopt;
    private IType _Type;
    private VariableDeclaratorId _VariableDeclaratorId;

    public ModifierList getModifiersopt() { return _Modifiersopt; }
    public IType getType() { return _Type; }
    public VariableDeclaratorId getVariableDeclaratorId() { return _VariableDeclaratorId; }

    public FormalParameter(IToken leftIToken, IToken rightIToken,
                           ModifierList _Modifiersopt,
                           IType _Type,
                           VariableDeclaratorId _VariableDeclaratorId)
    {
        super(leftIToken, rightIToken);

        this._Modifiersopt = _Modifiersopt;
        ((Ast) _Modifiersopt).setParent(this);
        this._Type = _Type;
        ((Ast) _Type).setParent(this);
        this._VariableDeclaratorId = _VariableDeclaratorId;
        ((Ast) _VariableDeclaratorId).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_Modifiersopt);
        list.add(_Type);
        list.add(_VariableDeclaratorId);
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
        if (! (o instanceof FormalParameter)) return false;
        FormalParameter other = (FormalParameter) o;
        if (! _Modifiersopt.equals(other._Modifiersopt)) return false;
        if (! _Type.equals(other._Type)) return false;
        if (! _VariableDeclaratorId.equals(other._VariableDeclaratorId)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_Modifiersopt.hashCode());
        hash = hash * 31 + (_Type.hashCode());
        hash = hash * 31 + (_VariableDeclaratorId.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


