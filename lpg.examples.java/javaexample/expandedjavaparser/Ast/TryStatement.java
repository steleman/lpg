//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 193:  TryStatement ::= try Block Catches$Catchesopt
 *<li>Rule 194:  TryStatement ::= try Block Catchesopt Finally
 *</b>
 */
public class TryStatement extends Ast implements ITryStatement
{
    private AstToken _try;
    private Block _Block;
    private Ast _Catchesopt;
    private Finally _Finally;

    public AstToken gettry() { return _try; }
    public Block getBlock() { return _Block; }
    public Ast getCatchesopt() { return _Catchesopt; }
    /**
     * The value returned by <b>getFinally</b> may be <b>null</b>
     */
    public Finally getFinally() { return _Finally; }

    public TryStatement(IToken leftIToken, IToken rightIToken,
                        AstToken _try,
                        Block _Block,
                        Ast _Catchesopt,
                        Finally _Finally)
    {
        super(leftIToken, rightIToken);

        this._try = _try;
        ((Ast) _try).setParent(this);
        this._Block = _Block;
        ((Ast) _Block).setParent(this);
        this._Catchesopt = _Catchesopt;
        ((Ast) _Catchesopt).setParent(this);
        this._Finally = _Finally;
        if (_Finally != null) ((Ast) _Finally).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_try);
        list.add(_Block);
        list.add(_Catchesopt);
        list.add(_Finally);
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
        if (! (o instanceof TryStatement)) return false;
        TryStatement other = (TryStatement) o;
        if (! _try.equals(other._try)) return false;
        if (! _Block.equals(other._Block)) return false;
        if (! _Catchesopt.equals(other._Catchesopt)) return false;
        if (_Finally == null)
            if (other._Finally != null) return false;
            else; // continue
        else if (! _Finally.equals(other._Finally)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_try.hashCode());
        hash = hash * 31 + (_Block.hashCode());
        hash = hash * 31 + (_Catchesopt.hashCode());
        hash = hash * 31 + (_Finally == null ? 0 : _Finally.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


