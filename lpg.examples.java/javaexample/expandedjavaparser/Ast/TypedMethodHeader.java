//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 87:  MethodHeader ::= Modifiersopt Type MethodDeclarator Throwsopt
 *</b>
 */
public class TypedMethodHeader extends Ast implements IMethodHeader
{
    private ModifierList _Modifiersopt;
    private IType _Type;
    private MethodDeclarator _MethodDeclarator;
    private ClassTypeList _Throwsopt;

    public ModifierList getModifiersopt() { return _Modifiersopt; }
    public IType getType() { return _Type; }
    public MethodDeclarator getMethodDeclarator() { return _MethodDeclarator; }
    public ClassTypeList getThrowsopt() { return _Throwsopt; }

    public TypedMethodHeader(IToken leftIToken, IToken rightIToken,
                             ModifierList _Modifiersopt,
                             IType _Type,
                             MethodDeclarator _MethodDeclarator,
                             ClassTypeList _Throwsopt)
    {
        super(leftIToken, rightIToken);

        this._Modifiersopt = _Modifiersopt;
        ((Ast) _Modifiersopt).setParent(this);
        this._Type = _Type;
        ((Ast) _Type).setParent(this);
        this._MethodDeclarator = _MethodDeclarator;
        ((Ast) _MethodDeclarator).setParent(this);
        this._Throwsopt = _Throwsopt;
        ((Ast) _Throwsopt).setParent(this);
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
        list.add(_MethodDeclarator);
        list.add(_Throwsopt);
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
        if (! (o instanceof TypedMethodHeader)) return false;
        TypedMethodHeader other = (TypedMethodHeader) o;
        if (! _Modifiersopt.equals(other._Modifiersopt)) return false;
        if (! _Type.equals(other._Type)) return false;
        if (! _MethodDeclarator.equals(other._MethodDeclarator)) return false;
        if (! _Throwsopt.equals(other._Throwsopt)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_Modifiersopt.hashCode());
        hash = hash * 31 + (_Type.hashCode());
        hash = hash * 31 + (_MethodDeclarator.hashCode());
        hash = hash * 31 + (_Throwsopt.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


