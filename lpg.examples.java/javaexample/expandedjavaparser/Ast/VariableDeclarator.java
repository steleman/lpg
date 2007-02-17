//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<em>
 *<li>Rule 81:  VariableDeclarator ::= VariableDeclaratorId
 *</em>
 *<p>
 *<b>
 *<li>Rule 82:  VariableDeclarator ::= VariableDeclaratorId = VariableInitializer
 *</b>
 */
public class VariableDeclarator extends Ast implements IVariableDeclarator
{
    private VariableDeclaratorId _VariableDeclaratorId;
    private AstToken _EQUAL;
    private IVariableInitializer _VariableInitializer;

    public VariableDeclaratorId getVariableDeclaratorId() { return _VariableDeclaratorId; }
    public AstToken getEQUAL() { return _EQUAL; }
    public IVariableInitializer getVariableInitializer() { return _VariableInitializer; }

    public VariableDeclarator(IToken leftIToken, IToken rightIToken,
                              VariableDeclaratorId _VariableDeclaratorId,
                              AstToken _EQUAL,
                              IVariableInitializer _VariableInitializer)
    {
        super(leftIToken, rightIToken);

        this._VariableDeclaratorId = _VariableDeclaratorId;
        ((Ast) _VariableDeclaratorId).setParent(this);
        this._EQUAL = _EQUAL;
        ((Ast) _EQUAL).setParent(this);
        this._VariableInitializer = _VariableInitializer;
        ((Ast) _VariableInitializer).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_VariableDeclaratorId);
        list.add(_EQUAL);
        list.add(_VariableInitializer);
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
        if (! (o instanceof VariableDeclarator)) return false;
        VariableDeclarator other = (VariableDeclarator) o;
        if (! _VariableDeclaratorId.equals(other._VariableDeclaratorId)) return false;
        if (! _EQUAL.equals(other._EQUAL)) return false;
        if (! _VariableInitializer.equals(other._VariableInitializer)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_VariableDeclaratorId.hashCode());
        hash = hash * 31 + (_EQUAL.hashCode());
        hash = hash * 31 + (_VariableInitializer.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


