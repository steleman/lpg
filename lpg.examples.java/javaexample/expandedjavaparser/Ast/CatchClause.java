//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 197:  CatchClause ::= catch ( FormalParameter ) Block
 *</b>
 */
public class CatchClause extends Ast implements ICatchClause
{
    private AstToken _catch;
    private AstToken _LPAREN;
    private FormalParameter _FormalParameter;
    private AstToken _RPAREN;
    private Block _Block;

    public AstToken getcatch() { return _catch; }
    public AstToken getLPAREN() { return _LPAREN; }
    public FormalParameter getFormalParameter() { return _FormalParameter; }
    public AstToken getRPAREN() { return _RPAREN; }
    public Block getBlock() { return _Block; }

    public CatchClause(IToken leftIToken, IToken rightIToken,
                       AstToken _catch,
                       AstToken _LPAREN,
                       FormalParameter _FormalParameter,
                       AstToken _RPAREN,
                       Block _Block)
    {
        super(leftIToken, rightIToken);

        this._catch = _catch;
        ((Ast) _catch).setParent(this);
        this._LPAREN = _LPAREN;
        ((Ast) _LPAREN).setParent(this);
        this._FormalParameter = _FormalParameter;
        ((Ast) _FormalParameter).setParent(this);
        this._RPAREN = _RPAREN;
        ((Ast) _RPAREN).setParent(this);
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
        list.add(_catch);
        list.add(_LPAREN);
        list.add(_FormalParameter);
        list.add(_RPAREN);
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
        if (! (o instanceof CatchClause)) return false;
        CatchClause other = (CatchClause) o;
        if (! _catch.equals(other._catch)) return false;
        if (! _LPAREN.equals(other._LPAREN)) return false;
        if (! _FormalParameter.equals(other._FormalParameter)) return false;
        if (! _RPAREN.equals(other._RPAREN)) return false;
        if (! _Block.equals(other._Block)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_catch.hashCode());
        hash = hash * 31 + (_LPAREN.hashCode());
        hash = hash * 31 + (_FormalParameter.hashCode());
        hash = hash * 31 + (_RPAREN.hashCode());
        hash = hash * 31 + (_Block.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


