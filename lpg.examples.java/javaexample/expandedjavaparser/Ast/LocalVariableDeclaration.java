//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import expandedjavaparser.*;
import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 130:  LocalVariableDeclaration ::= Modifiers Type VariableDeclarators
 *<li>Rule 131:  LocalVariableDeclaration ::= Type VariableDeclarators
 *</b>
 */
public class LocalVariableDeclaration extends Ast implements ILocalVariableDeclaration
{
    private JavaParser environment;
    public JavaParser getEnvironment() { return environment; }

    private ModifierList _Modifiers;
    private IType _Type;
    private VariableDeclaratorList _VariableDeclarators;

    /**
     * The value returned by <b>getModifiers</b> may be <b>null</b>
     */
    public ModifierList getModifiers() { return _Modifiers; }
    public IType getType() { return _Type; }
    public VariableDeclaratorList getVariableDeclarators() { return _VariableDeclarators; }

    public LocalVariableDeclaration(JavaParser environment, IToken leftIToken, IToken rightIToken,
                                    ModifierList _Modifiers,
                                    IType _Type,
                                    VariableDeclaratorList _VariableDeclarators)
    {
        super(leftIToken, rightIToken);

        this.environment = environment;
        this._Modifiers = _Modifiers;
        if (_Modifiers != null) ((Ast) _Modifiers).setParent(this);
        this._Type = _Type;
        ((Ast) _Type).setParent(this);
        this._VariableDeclarators = _VariableDeclarators;
        ((Ast) _VariableDeclarators).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_Modifiers);
        list.add(_Type);
        list.add(_VariableDeclarators);
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
        if (! (o instanceof LocalVariableDeclaration)) return false;
        LocalVariableDeclaration other = (LocalVariableDeclaration) o;
        if (_Modifiers == null)
            if (other._Modifiers != null) return false;
            else; // continue
        else if (! _Modifiers.equals(other._Modifiers)) return false;
        if (! _Type.equals(other._Type)) return false;
        if (! _VariableDeclarators.equals(other._VariableDeclarators)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_Modifiers == null ? 0 : _Modifiers.hashCode());
        hash = hash * 31 + (_Type.hashCode());
        hash = hash * 31 + (_VariableDeclarators.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }

    public void initialize()
    {
        if (_Modifiers == null)
        {
            IToken left = environment.getLeftIToken(),
                   right = environment.getPrevious(left);
            _Modifiers = new ModifierList(left, right, true);
        }
    }
}


