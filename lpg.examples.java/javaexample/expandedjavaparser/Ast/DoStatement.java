//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 180:  DoStatement ::= do Statement while ( Expression ) ;
 *</b>
 */
public class DoStatement extends Ast implements IDoStatement
{
    private AstToken _do;
    private IStatement _Statement;
    private AstToken _while;
    private AstToken _LPAREN;
    private IExpression _Expression;
    private AstToken _RPAREN;
    private AstToken _SEMICOLON;

    public AstToken getdo() { return _do; }
    public IStatement getStatement() { return _Statement; }
    public AstToken getwhile() { return _while; }
    public AstToken getLPAREN() { return _LPAREN; }
    public IExpression getExpression() { return _Expression; }
    public AstToken getRPAREN() { return _RPAREN; }
    public AstToken getSEMICOLON() { return _SEMICOLON; }

    public DoStatement(IToken leftIToken, IToken rightIToken,
                       AstToken _do,
                       IStatement _Statement,
                       AstToken _while,
                       AstToken _LPAREN,
                       IExpression _Expression,
                       AstToken _RPAREN,
                       AstToken _SEMICOLON)
    {
        super(leftIToken, rightIToken);

        this._do = _do;
        ((Ast) _do).setParent(this);
        this._Statement = _Statement;
        ((Ast) _Statement).setParent(this);
        this._while = _while;
        ((Ast) _while).setParent(this);
        this._LPAREN = _LPAREN;
        ((Ast) _LPAREN).setParent(this);
        this._Expression = _Expression;
        ((Ast) _Expression).setParent(this);
        this._RPAREN = _RPAREN;
        ((Ast) _RPAREN).setParent(this);
        this._SEMICOLON = _SEMICOLON;
        ((Ast) _SEMICOLON).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_do);
        list.add(_Statement);
        list.add(_while);
        list.add(_LPAREN);
        list.add(_Expression);
        list.add(_RPAREN);
        list.add(_SEMICOLON);
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
        if (! (o instanceof DoStatement)) return false;
        DoStatement other = (DoStatement) o;
        if (! _do.equals(other._do)) return false;
        if (! _Statement.equals(other._Statement)) return false;
        if (! _while.equals(other._while)) return false;
        if (! _LPAREN.equals(other._LPAREN)) return false;
        if (! _Expression.equals(other._Expression)) return false;
        if (! _RPAREN.equals(other._RPAREN)) return false;
        if (! _SEMICOLON.equals(other._SEMICOLON)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_do.hashCode());
        hash = hash * 31 + (_Statement.hashCode());
        hash = hash * 31 + (_while.hashCode());
        hash = hash * 31 + (_LPAREN.hashCode());
        hash = hash * 31 + (_Expression.hashCode());
        hash = hash * 31 + (_RPAREN.hashCode());
        hash = hash * 31 + (_SEMICOLON.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


