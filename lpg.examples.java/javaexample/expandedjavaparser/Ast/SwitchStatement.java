//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 168:  SwitchStatement ::= switch ( Expression ) SwitchBlock
 *</b>
 */
public class SwitchStatement extends Ast implements ISwitchStatement
{
    private AstToken _switch;
    private AstToken _LPAREN;
    private IExpression _Expression;
    private AstToken _RPAREN;
    private SwitchBlock _SwitchBlock;

    public AstToken getswitch() { return _switch; }
    public AstToken getLPAREN() { return _LPAREN; }
    public IExpression getExpression() { return _Expression; }
    public AstToken getRPAREN() { return _RPAREN; }
    public SwitchBlock getSwitchBlock() { return _SwitchBlock; }

    public SwitchStatement(IToken leftIToken, IToken rightIToken,
                           AstToken _switch,
                           AstToken _LPAREN,
                           IExpression _Expression,
                           AstToken _RPAREN,
                           SwitchBlock _SwitchBlock)
    {
        super(leftIToken, rightIToken);

        this._switch = _switch;
        ((Ast) _switch).setParent(this);
        this._LPAREN = _LPAREN;
        ((Ast) _LPAREN).setParent(this);
        this._Expression = _Expression;
        ((Ast) _Expression).setParent(this);
        this._RPAREN = _RPAREN;
        ((Ast) _RPAREN).setParent(this);
        this._SwitchBlock = _SwitchBlock;
        ((Ast) _SwitchBlock).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_switch);
        list.add(_LPAREN);
        list.add(_Expression);
        list.add(_RPAREN);
        list.add(_SwitchBlock);
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
        if (! (o instanceof SwitchStatement)) return false;
        SwitchStatement other = (SwitchStatement) o;
        if (! _switch.equals(other._switch)) return false;
        if (! _LPAREN.equals(other._LPAREN)) return false;
        if (! _Expression.equals(other._Expression)) return false;
        if (! _RPAREN.equals(other._RPAREN)) return false;
        if (! _SwitchBlock.equals(other._SwitchBlock)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_switch.hashCode());
        hash = hash * 31 + (_LPAREN.hashCode());
        hash = hash * 31 + (_Expression.hashCode());
        hash = hash * 31 + (_RPAREN.hashCode());
        hash = hash * 31 + (_SwitchBlock.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


