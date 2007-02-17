//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 211:  ClassInstanceCreationExpression ::= new ClassType ( ArgumentListopt ) ClassBodyopt
 *<li>Rule 212:  ClassInstanceCreationExpression ::= Primary$expression . new SimpleName$ClassType ( ArgumentListopt ) ClassBodyopt
 *<li>Rule 213:  ClassInstanceCreationExpression ::= Name$expression . new SimpleName$ClassType ( ArgumentListopt ) ClassBodyopt
 *</b>
 */
public class ClassInstanceCreationExpression extends Ast implements IClassInstanceCreationExpression
{
    private AstToken _new;
    private IClassType _ClassType;
    private AstToken _LPAREN;
    private ExpressionList _ArgumentListopt;
    private AstToken _RPAREN;
    private ClassBody _ClassBodyopt;
    private IPostfixExpression _expression;
    private AstToken _DOT;

    public AstToken getnew() { return _new; }
    public IClassType getClassType() { return _ClassType; }
    public AstToken getLPAREN() { return _LPAREN; }
    public ExpressionList getArgumentListopt() { return _ArgumentListopt; }
    public AstToken getRPAREN() { return _RPAREN; }
    /**
     * The value returned by <b>getClassBodyopt</b> may be <b>null</b>
     */
    public ClassBody getClassBodyopt() { return _ClassBodyopt; }
    /**
     * The value returned by <b>getexpression</b> may be <b>null</b>
     */
    public IPostfixExpression getexpression() { return _expression; }
    /**
     * The value returned by <b>getDOT</b> may be <b>null</b>
     */
    public AstToken getDOT() { return _DOT; }

    public ClassInstanceCreationExpression(IToken leftIToken, IToken rightIToken,
                                           AstToken _new,
                                           IClassType _ClassType,
                                           AstToken _LPAREN,
                                           ExpressionList _ArgumentListopt,
                                           AstToken _RPAREN,
                                           ClassBody _ClassBodyopt,
                                           IPostfixExpression _expression,
                                           AstToken _DOT)
    {
        super(leftIToken, rightIToken);

        this._new = _new;
        ((Ast) _new).setParent(this);
        this._ClassType = _ClassType;
        ((Ast) _ClassType).setParent(this);
        this._LPAREN = _LPAREN;
        ((Ast) _LPAREN).setParent(this);
        this._ArgumentListopt = _ArgumentListopt;
        ((Ast) _ArgumentListopt).setParent(this);
        this._RPAREN = _RPAREN;
        ((Ast) _RPAREN).setParent(this);
        this._ClassBodyopt = _ClassBodyopt;
        if (_ClassBodyopt != null) ((Ast) _ClassBodyopt).setParent(this);
        this._expression = _expression;
        if (_expression != null) ((Ast) _expression).setParent(this);
        this._DOT = _DOT;
        if (_DOT != null) ((Ast) _DOT).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_new);
        list.add(_ClassType);
        list.add(_LPAREN);
        list.add(_ArgumentListopt);
        list.add(_RPAREN);
        list.add(_ClassBodyopt);
        list.add(_expression);
        list.add(_DOT);
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
        if (! (o instanceof ClassInstanceCreationExpression)) return false;
        ClassInstanceCreationExpression other = (ClassInstanceCreationExpression) o;
        if (! _new.equals(other._new)) return false;
        if (! _ClassType.equals(other._ClassType)) return false;
        if (! _LPAREN.equals(other._LPAREN)) return false;
        if (! _ArgumentListopt.equals(other._ArgumentListopt)) return false;
        if (! _RPAREN.equals(other._RPAREN)) return false;
        if (_ClassBodyopt == null)
            if (other._ClassBodyopt != null) return false;
            else; // continue
        else if (! _ClassBodyopt.equals(other._ClassBodyopt)) return false;
        if (_expression == null)
            if (other._expression != null) return false;
            else; // continue
        else if (! _expression.equals(other._expression)) return false;
        if (_DOT == null)
            if (other._DOT != null) return false;
            else; // continue
        else if (! _DOT.equals(other._DOT)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_new.hashCode());
        hash = hash * 31 + (_ClassType.hashCode());
        hash = hash * 31 + (_LPAREN.hashCode());
        hash = hash * 31 + (_ArgumentListopt.hashCode());
        hash = hash * 31 + (_RPAREN.hashCode());
        hash = hash * 31 + (_ClassBodyopt == null ? 0 : _ClassBodyopt.hashCode());
        hash = hash * 31 + (_expression == null ? 0 : _expression.hashCode());
        hash = hash * 31 + (_DOT == null ? 0 : _DOT.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


