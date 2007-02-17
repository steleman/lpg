//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 230:  MethodInvocation ::= super . IDENTIFIER ( ArgumentListopt )
 *<li>Rule 231:  MethodInvocation ::= Name . super . IDENTIFIER ( ArgumentListopt )
 *</b>
 */
public class SuperMethodInvocation extends Ast implements IMethodInvocation
{
    private AstToken _super;
    private AstToken _DOT;
    private AstToken _IDENTIFIER;
    private AstToken _LPAREN;
    private ExpressionList _ArgumentListopt;
    private AstToken _RPAREN;
    private IName _Name;
    private AstToken _DOT4;

    public AstToken getsuper() { return _super; }
    public AstToken getDOT() { return _DOT; }
    public AstToken getIDENTIFIER() { return _IDENTIFIER; }
    public AstToken getLPAREN() { return _LPAREN; }
    public ExpressionList getArgumentListopt() { return _ArgumentListopt; }
    public AstToken getRPAREN() { return _RPAREN; }
    /**
     * The value returned by <b>getName</b> may be <b>null</b>
     */
    public IName getName() { return _Name; }
    /**
     * The value returned by <b>getDOT4</b> may be <b>null</b>
     */
    public AstToken getDOT4() { return _DOT4; }

    public SuperMethodInvocation(IToken leftIToken, IToken rightIToken,
                                 AstToken _super,
                                 AstToken _DOT,
                                 AstToken _IDENTIFIER,
                                 AstToken _LPAREN,
                                 ExpressionList _ArgumentListopt,
                                 AstToken _RPAREN,
                                 IName _Name,
                                 AstToken _DOT4)
    {
        super(leftIToken, rightIToken);

        this._super = _super;
        ((Ast) _super).setParent(this);
        this._DOT = _DOT;
        ((Ast) _DOT).setParent(this);
        this._IDENTIFIER = _IDENTIFIER;
        ((Ast) _IDENTIFIER).setParent(this);
        this._LPAREN = _LPAREN;
        ((Ast) _LPAREN).setParent(this);
        this._ArgumentListopt = _ArgumentListopt;
        ((Ast) _ArgumentListopt).setParent(this);
        this._RPAREN = _RPAREN;
        ((Ast) _RPAREN).setParent(this);
        this._Name = _Name;
        if (_Name != null) ((Ast) _Name).setParent(this);
        this._DOT4 = _DOT4;
        if (_DOT4 != null) ((Ast) _DOT4).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_super);
        list.add(_DOT);
        list.add(_IDENTIFIER);
        list.add(_LPAREN);
        list.add(_ArgumentListopt);
        list.add(_RPAREN);
        list.add(_Name);
        list.add(_DOT4);
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
        if (! (o instanceof SuperMethodInvocation)) return false;
        SuperMethodInvocation other = (SuperMethodInvocation) o;
        if (! _super.equals(other._super)) return false;
        if (! _DOT.equals(other._DOT)) return false;
        if (! _IDENTIFIER.equals(other._IDENTIFIER)) return false;
        if (! _LPAREN.equals(other._LPAREN)) return false;
        if (! _ArgumentListopt.equals(other._ArgumentListopt)) return false;
        if (! _RPAREN.equals(other._RPAREN)) return false;
        if (_Name == null)
            if (other._Name != null) return false;
            else; // continue
        else if (! _Name.equals(other._Name)) return false;
        if (_DOT4 == null)
            if (other._DOT4 != null) return false;
            else; // continue
        else if (! _DOT4.equals(other._DOT4)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_super.hashCode());
        hash = hash * 31 + (_DOT.hashCode());
        hash = hash * 31 + (_IDENTIFIER.hashCode());
        hash = hash * 31 + (_LPAREN.hashCode());
        hash = hash * 31 + (_ArgumentListopt.hashCode());
        hash = hash * 31 + (_RPAREN.hashCode());
        hash = hash * 31 + (_Name == null ? 0 : _Name.hashCode());
        hash = hash * 31 + (_DOT4 == null ? 0 : _DOT4.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


