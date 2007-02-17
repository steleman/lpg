//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 103:  ExplicitConstructorInvocation ::= this ( ArgumentListopt ) ;
 *<li>Rule 104:  ExplicitConstructorInvocation ::= Primary . this ( ArgumentListopt ) ;
 *</b>
 */
public class ThisCall extends Ast implements IExplicitConstructorInvocation
{
    private AstToken _this;
    private AstToken _LPAREN;
    private ExpressionList _ArgumentListopt;
    private AstToken _RPAREN;
    private AstToken _SEMICOLON;
    private IPrimary _Primary;
    private AstToken _DOT;

    public AstToken getthis() { return _this; }
    public AstToken getLPAREN() { return _LPAREN; }
    public ExpressionList getArgumentListopt() { return _ArgumentListopt; }
    public AstToken getRPAREN() { return _RPAREN; }
    public AstToken getSEMICOLON() { return _SEMICOLON; }
    /**
     * The value returned by <b>getPrimary</b> may be <b>null</b>
     */
    public IPrimary getPrimary() { return _Primary; }
    /**
     * The value returned by <b>getDOT</b> may be <b>null</b>
     */
    public AstToken getDOT() { return _DOT; }

    public ThisCall(IToken leftIToken, IToken rightIToken,
                    AstToken _this,
                    AstToken _LPAREN,
                    ExpressionList _ArgumentListopt,
                    AstToken _RPAREN,
                    AstToken _SEMICOLON,
                    IPrimary _Primary,
                    AstToken _DOT)
    {
        super(leftIToken, rightIToken);

        this._this = _this;
        ((Ast) _this).setParent(this);
        this._LPAREN = _LPAREN;
        ((Ast) _LPAREN).setParent(this);
        this._ArgumentListopt = _ArgumentListopt;
        ((Ast) _ArgumentListopt).setParent(this);
        this._RPAREN = _RPAREN;
        ((Ast) _RPAREN).setParent(this);
        this._SEMICOLON = _SEMICOLON;
        ((Ast) _SEMICOLON).setParent(this);
        this._Primary = _Primary;
        if (_Primary != null) ((Ast) _Primary).setParent(this);
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
        list.add(_this);
        list.add(_LPAREN);
        list.add(_ArgumentListopt);
        list.add(_RPAREN);
        list.add(_SEMICOLON);
        list.add(_Primary);
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
        if (! (o instanceof ThisCall)) return false;
        ThisCall other = (ThisCall) o;
        if (! _this.equals(other._this)) return false;
        if (! _LPAREN.equals(other._LPAREN)) return false;
        if (! _ArgumentListopt.equals(other._ArgumentListopt)) return false;
        if (! _RPAREN.equals(other._RPAREN)) return false;
        if (! _SEMICOLON.equals(other._SEMICOLON)) return false;
        if (_Primary == null)
            if (other._Primary != null) return false;
            else; // continue
        else if (! _Primary.equals(other._Primary)) return false;
        if (_DOT == null)
            if (other._DOT != null) return false;
            else; // continue
        else if (! _DOT.equals(other._DOT)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_this.hashCode());
        hash = hash * 31 + (_LPAREN.hashCode());
        hash = hash * 31 + (_ArgumentListopt.hashCode());
        hash = hash * 31 + (_RPAREN.hashCode());
        hash = hash * 31 + (_SEMICOLON.hashCode());
        hash = hash * 31 + (_Primary == null ? 0 : _Primary.hashCode());
        hash = hash * 31 + (_DOT == null ? 0 : _DOT.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


