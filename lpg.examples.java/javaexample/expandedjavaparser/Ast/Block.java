//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 123:  Block ::= { BlockStatementsopt }
 *</b>
 */
public class Block extends Ast implements IBlock
{
    private AstToken _LBRACE;
    private BlockStatementList _BlockStatementsopt;
    private AstToken _RBRACE;

    public AstToken getLBRACE() { return _LBRACE; }
    public BlockStatementList getBlockStatementsopt() { return _BlockStatementsopt; }
    public AstToken getRBRACE() { return _RBRACE; }

    public Block(IToken leftIToken, IToken rightIToken,
                 AstToken _LBRACE,
                 BlockStatementList _BlockStatementsopt,
                 AstToken _RBRACE)
    {
        super(leftIToken, rightIToken);

        this._LBRACE = _LBRACE;
        ((Ast) _LBRACE).setParent(this);
        this._BlockStatementsopt = _BlockStatementsopt;
        ((Ast) _BlockStatementsopt).setParent(this);
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
        list.add(_BlockStatementsopt);
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
        if (! (o instanceof Block)) return false;
        Block other = (Block) o;
        if (! _LBRACE.equals(other._LBRACE)) return false;
        if (! _BlockStatementsopt.equals(other._BlockStatementsopt)) return false;
        if (! _RBRACE.equals(other._RBRACE)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_LBRACE.hashCode());
        hash = hash * 31 + (_BlockStatementsopt.hashCode());
        hash = hash * 31 + (_RBRACE.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


