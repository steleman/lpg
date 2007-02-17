//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 120:  ArrayInitializer ::= { VariableInitializersopt Commaopt }
 *</b>
 */
public class ArrayInitializer extends Ast implements IArrayInitializer
{
    private AstToken _LBRACE;
    private VariableInitializerList _VariableInitializersopt;
    private Commaopt _Commaopt;
    private AstToken _RBRACE;

    public AstToken getLBRACE() { return _LBRACE; }
    public VariableInitializerList getVariableInitializersopt() { return _VariableInitializersopt; }
    /**
     * The value returned by <b>getCommaopt</b> may be <b>null</b>
     */
    public Commaopt getCommaopt() { return _Commaopt; }
    public AstToken getRBRACE() { return _RBRACE; }

    public ArrayInitializer(IToken leftIToken, IToken rightIToken,
                            AstToken _LBRACE,
                            VariableInitializerList _VariableInitializersopt,
                            Commaopt _Commaopt,
                            AstToken _RBRACE)
    {
        super(leftIToken, rightIToken);

        this._LBRACE = _LBRACE;
        ((Ast) _LBRACE).setParent(this);
        this._VariableInitializersopt = _VariableInitializersopt;
        ((Ast) _VariableInitializersopt).setParent(this);
        this._Commaopt = _Commaopt;
        if (_Commaopt != null) ((Ast) _Commaopt).setParent(this);
        this._RBRACE = _RBRACE;
        ((Ast) _RBRACE).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_LBRACE);
        list.add(_VariableInitializersopt);
        list.add(_Commaopt);
        list.add(_RBRACE);
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
        if (! (o instanceof ArrayInitializer)) return false;
        ArrayInitializer other = (ArrayInitializer) o;
        if (! _LBRACE.equals(other._LBRACE)) return false;
        if (! _VariableInitializersopt.equals(other._VariableInitializersopt)) return false;
        if (_Commaopt == null)
            if (other._Commaopt != null) return false;
            else; // continue
        else if (! _Commaopt.equals(other._Commaopt)) return false;
        if (! _RBRACE.equals(other._RBRACE)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_LBRACE.hashCode());
        hash = hash * 31 + (_VariableInitializersopt.hashCode());
        hash = hash * 31 + (_Commaopt == null ? 0 : _Commaopt.hashCode());
        hash = hash * 31 + (_RBRACE.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


