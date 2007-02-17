//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 178:  WhileStatement ::= while ( Expression ) Statement
 *<li>Rule 179:  WhileStatementNoShortIf ::= while ( Expression ) StatementNoShortIf$Statement
 *</b>
 */
public class WhileStatement extends Ast implements IWhileStatement, IWhileStatementNoShortIf
{
    private AstToken _while;
    private AstToken _LPAREN;
    private IExpression _Expression;
    private AstToken _RPAREN;
    private Ast _Statement;

    public AstToken getwhile() { return _while; }
    public AstToken getLPAREN() { return _LPAREN; }
    public IExpression getExpression() { return _Expression; }
    public AstToken getRPAREN() { return _RPAREN; }
    public Ast getStatement() { return _Statement; }

    public WhileStatement(IToken leftIToken, IToken rightIToken,
                          AstToken _while,
                          AstToken _LPAREN,
                          IExpression _Expression,
                          AstToken _RPAREN,
                          Ast _Statement)
    {
        super(leftIToken, rightIToken);

        this._while = _while;
        ((Ast) _while).setParent(this);
        this._LPAREN = _LPAREN;
        ((Ast) _LPAREN).setParent(this);
        this._Expression = _Expression;
        ((Ast) _Expression).setParent(this);
        this._RPAREN = _RPAREN;
        ((Ast) _RPAREN).setParent(this);
        this._Statement = _Statement;
        ((Ast) _Statement).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_while);
        list.add(_LPAREN);
        list.add(_Expression);
        list.add(_RPAREN);
        list.add(_Statement);
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
        if (! (o instanceof WhileStatement)) return false;
        WhileStatement other = (WhileStatement) o;
        if (! _while.equals(other._while)) return false;
        if (! _LPAREN.equals(other._LPAREN)) return false;
        if (! _Expression.equals(other._Expression)) return false;
        if (! _RPAREN.equals(other._RPAREN)) return false;
        if (! _Statement.equals(other._Statement)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_while.hashCode());
        hash = hash * 31 + (_LPAREN.hashCode());
        hash = hash * 31 + (_Expression.hashCode());
        hash = hash * 31 + (_RPAREN.hashCode());
        hash = hash * 31 + (_Statement.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


