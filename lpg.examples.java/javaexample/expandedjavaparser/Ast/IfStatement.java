//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 165:  IfThenStatement ::= if ( Expression ) Statement$thenStmt
 *<li>Rule 166:  IfThenElseStatement ::= if ( Expression ) StatementNoShortIf$thenStmt else Statement$elseStmt
 *<li>Rule 167:  IfThenElseStatementNoShortIf ::= if ( Expression ) StatementNoShortIf$thenStmt else StatementNoShortIf$elseStmt
 *</b>
 */
public class IfStatement extends Ast implements IIfThenStatement, IIfThenElseStatement, IIfThenElseStatementNoShortIf
{
    private AstToken _if;
    private AstToken _LPAREN;
    private IExpression _Expression;
    private AstToken _RPAREN;
    private Ast _thenStmt;
    private AstToken _else;
    private Ast _elseStmt;

    public AstToken getif() { return _if; }
    public AstToken getLPAREN() { return _LPAREN; }
    public IExpression getExpression() { return _Expression; }
    public AstToken getRPAREN() { return _RPAREN; }
    public Ast getthenStmt() { return _thenStmt; }
    /**
     * The value returned by <b>getelse</b> may be <b>null</b>
     */
    public AstToken getelse() { return _else; }
    /**
     * The value returned by <b>getelseStmt</b> may be <b>null</b>
     */
    public Ast getelseStmt() { return _elseStmt; }

    public IfStatement(IToken leftIToken, IToken rightIToken,
                       AstToken _if,
                       AstToken _LPAREN,
                       IExpression _Expression,
                       AstToken _RPAREN,
                       Ast _thenStmt,
                       AstToken _else,
                       Ast _elseStmt)
    {
        super(leftIToken, rightIToken);

        this._if = _if;
        ((Ast) _if).setParent(this);
        this._LPAREN = _LPAREN;
        ((Ast) _LPAREN).setParent(this);
        this._Expression = _Expression;
        ((Ast) _Expression).setParent(this);
        this._RPAREN = _RPAREN;
        ((Ast) _RPAREN).setParent(this);
        this._thenStmt = _thenStmt;
        ((Ast) _thenStmt).setParent(this);
        this._else = _else;
        if (_else != null) ((Ast) _else).setParent(this);
        this._elseStmt = _elseStmt;
        if (_elseStmt != null) ((Ast) _elseStmt).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_if);
        list.add(_LPAREN);
        list.add(_Expression);
        list.add(_RPAREN);
        list.add(_thenStmt);
        list.add(_else);
        list.add(_elseStmt);
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
        if (! (o instanceof IfStatement)) return false;
        IfStatement other = (IfStatement) o;
        if (! _if.equals(other._if)) return false;
        if (! _LPAREN.equals(other._LPAREN)) return false;
        if (! _Expression.equals(other._Expression)) return false;
        if (! _RPAREN.equals(other._RPAREN)) return false;
        if (! _thenStmt.equals(other._thenStmt)) return false;
        if (_else == null)
            if (other._else != null) return false;
            else; // continue
        else if (! _else.equals(other._else)) return false;
        if (_elseStmt == null)
            if (other._elseStmt != null) return false;
            else; // continue
        else if (! _elseStmt.equals(other._elseStmt)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_if.hashCode());
        hash = hash * 31 + (_LPAREN.hashCode());
        hash = hash * 31 + (_Expression.hashCode());
        hash = hash * 31 + (_RPAREN.hashCode());
        hash = hash * 31 + (_thenStmt.hashCode());
        hash = hash * 31 + (_else == null ? 0 : _else.hashCode());
        hash = hash * 31 + (_elseStmt == null ? 0 : _elseStmt.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


