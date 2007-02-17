//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 198:  Finally ::= finally Block
 *</b>
 */
public class Finally extends Ast implements IFinally
{
    private AstToken _finally;
    private Block _Block;

    public AstToken getfinally() { return _finally; }
    public Block getBlock() { return _Block; }

    public Finally(IToken leftIToken, IToken rightIToken,
                   AstToken _finally,
                   Block _Block)
    {
        super(leftIToken, rightIToken);

        this._finally = _finally;
        ((Ast) _finally).setParent(this);
        this._Block = _Block;
        ((Ast) _Block).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_finally);
        list.add(_Block);
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
        if (! (o instanceof Finally)) return false;
        Finally other = (Finally) o;
        if (! _finally.equals(other._finally)) return false;
        if (! _Block.equals(other._Block)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_finally.hashCode());
        hash = hash * 31 + (_Block.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


