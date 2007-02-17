//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 181:  ForStatement ::= for ( ForInitopt ; Expressionopt ; ForUpdateopt ) Statement
 *<li>Rule 182:  ForStatementNoShortIf ::= for ( ForInitopt ; Expressionopt ; ForUpdateopt ) StatementNoShortIf$Statement
 *</b>
 */
public class ForStatement extends Ast implements IForStatement, IForStatementNoShortIf
{
    private AstToken _for;
    private AstToken _LPAREN;
    private IForInitopt _ForInitopt;
    private AstToken _SEMICOLON;
    private IExpressionopt _Expressionopt;
    private AstToken _SEMICOLON6;
    private StatementExpressionList _ForUpdateopt;
    private AstToken _RPAREN;
    private Ast _Statement;

    public AstToken getfor() { return _for; }
    public AstToken getLPAREN() { return _LPAREN; }
    /**
     * The value returned by <b>getForInitopt</b> may be <b>null</b>
     */
    public IForInitopt getForInitopt() { return _ForInitopt; }
    public AstToken getSEMICOLON() { return _SEMICOLON; }
    /**
     * The value returned by <b>getExpressionopt</b> may be <b>null</b>
     */
    public IExpressionopt getExpressionopt() { return _Expressionopt; }
    public AstToken getSEMICOLON6() { return _SEMICOLON6; }
    public StatementExpressionList getForUpdateopt() { return _ForUpdateopt; }
    public AstToken getRPAREN() { return _RPAREN; }
    public Ast getStatement() { return _Statement; }

    public ForStatement(IToken leftIToken, IToken rightIToken,
                        AstToken _for,
                        AstToken _LPAREN,
                        IForInitopt _ForInitopt,
                        AstToken _SEMICOLON,
                        IExpressionopt _Expressionopt,
                        AstToken _SEMICOLON6,
                        StatementExpressionList _ForUpdateopt,
                        AstToken _RPAREN,
                        Ast _Statement)
    {
        super(leftIToken, rightIToken);

        this._for = _for;
        ((Ast) _for).setParent(this);
        this._LPAREN = _LPAREN;
        ((Ast) _LPAREN).setParent(this);
        this._ForInitopt = _ForInitopt;
        if (_ForInitopt != null) ((Ast) _ForInitopt).setParent(this);
        this._SEMICOLON = _SEMICOLON;
        ((Ast) _SEMICOLON).setParent(this);
        this._Expressionopt = _Expressionopt;
        if (_Expressionopt != null) ((Ast) _Expressionopt).setParent(this);
        this._SEMICOLON6 = _SEMICOLON6;
        ((Ast) _SEMICOLON6).setParent(this);
        this._ForUpdateopt = _ForUpdateopt;
        ((Ast) _ForUpdateopt).setParent(this);
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
        list.add(_for);
        list.add(_LPAREN);
        list.add(_ForInitopt);
        list.add(_SEMICOLON);
        list.add(_Expressionopt);
        list.add(_SEMICOLON6);
        list.add(_ForUpdateopt);
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
        if (! (o instanceof ForStatement)) return false;
        ForStatement other = (ForStatement) o;
        if (! _for.equals(other._for)) return false;
        if (! _LPAREN.equals(other._LPAREN)) return false;
        if (_ForInitopt == null)
            if (other._ForInitopt != null) return false;
            else; // continue
        else if (! _ForInitopt.equals(other._ForInitopt)) return false;
        if (! _SEMICOLON.equals(other._SEMICOLON)) return false;
        if (_Expressionopt == null)
            if (other._Expressionopt != null) return false;
            else; // continue
        else if (! _Expressionopt.equals(other._Expressionopt)) return false;
        if (! _SEMICOLON6.equals(other._SEMICOLON6)) return false;
        if (! _ForUpdateopt.equals(other._ForUpdateopt)) return false;
        if (! _RPAREN.equals(other._RPAREN)) return false;
        if (! _Statement.equals(other._Statement)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_for.hashCode());
        hash = hash * 31 + (_LPAREN.hashCode());
        hash = hash * 31 + (_ForInitopt == null ? 0 : _ForInitopt.hashCode());
        hash = hash * 31 + (_SEMICOLON.hashCode());
        hash = hash * 31 + (_Expressionopt == null ? 0 : _Expressionopt.hashCode());
        hash = hash * 31 + (_SEMICOLON6.hashCode());
        hash = hash * 31 + (_ForUpdateopt.hashCode());
        hash = hash * 31 + (_RPAREN.hashCode());
        hash = hash * 31 + (_Statement.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


