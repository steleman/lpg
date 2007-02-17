//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 228:  MethodInvocation ::= Name ( ArgumentListopt )
 *</b>
 */
public class MethodInvocation extends Ast implements IMethodInvocation
{
    private IName _Name;
    private AstToken _LPAREN;
    private ExpressionList _ArgumentListopt;
    private AstToken _RPAREN;

    public IName getName() { return _Name; }
    public AstToken getLPAREN() { return _LPAREN; }
    public ExpressionList getArgumentListopt() { return _ArgumentListopt; }
    public AstToken getRPAREN() { return _RPAREN; }

    public MethodInvocation(IToken leftIToken, IToken rightIToken,
                            IName _Name,
                            AstToken _LPAREN,
                            ExpressionList _ArgumentListopt,
                            AstToken _RPAREN)
    {
        super(leftIToken, rightIToken);

        this._Name = _Name;
        ((Ast) _Name).setParent(this);
        this._LPAREN = _LPAREN;
        ((Ast) _LPAREN).setParent(this);
        this._ArgumentListopt = _ArgumentListopt;
        ((Ast) _ArgumentListopt).setParent(this);
        this._RPAREN = _RPAREN;
        ((Ast) _RPAREN).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_Name);
        list.add(_LPAREN);
        list.add(_ArgumentListopt);
        list.add(_RPAREN);
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
        if (! (o instanceof MethodInvocation)) return false;
        MethodInvocation other = (MethodInvocation) o;
        if (! _Name.equals(other._Name)) return false;
        if (! _LPAREN.equals(other._LPAREN)) return false;
        if (! _ArgumentListopt.equals(other._ArgumentListopt)) return false;
        if (! _RPAREN.equals(other._RPAREN)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_Name.hashCode());
        hash = hash * 31 + (_LPAREN.hashCode());
        hash = hash * 31 + (_ArgumentListopt.hashCode());
        hash = hash * 31 + (_RPAREN.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


