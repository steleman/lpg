//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 89:  MethodDeclarator ::= IDENTIFIER ( FormalParameterListopt ) Dimsopt
 *</b>
 */
public class MethodDeclarator extends Ast implements IMethodDeclarator
{
    private AstToken _IDENTIFIER;
    private AstToken _LPAREN;
    private FormalParameterList _FormalParameterListopt;
    private AstToken _RPAREN;
    private DimList _Dimsopt;

    public AstToken getIDENTIFIER() { return _IDENTIFIER; }
    public AstToken getLPAREN() { return _LPAREN; }
    public FormalParameterList getFormalParameterListopt() { return _FormalParameterListopt; }
    public AstToken getRPAREN() { return _RPAREN; }
    public DimList getDimsopt() { return _Dimsopt; }

    public MethodDeclarator(IToken leftIToken, IToken rightIToken,
                            AstToken _IDENTIFIER,
                            AstToken _LPAREN,
                            FormalParameterList _FormalParameterListopt,
                            AstToken _RPAREN,
                            DimList _Dimsopt)
    {
        super(leftIToken, rightIToken);

        this._IDENTIFIER = _IDENTIFIER;
        ((Ast) _IDENTIFIER).setParent(this);
        this._LPAREN = _LPAREN;
        ((Ast) _LPAREN).setParent(this);
        this._FormalParameterListopt = _FormalParameterListopt;
        ((Ast) _FormalParameterListopt).setParent(this);
        this._RPAREN = _RPAREN;
        ((Ast) _RPAREN).setParent(this);
        this._Dimsopt = _Dimsopt;
        ((Ast) _Dimsopt).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_IDENTIFIER);
        list.add(_LPAREN);
        list.add(_FormalParameterListopt);
        list.add(_RPAREN);
        list.add(_Dimsopt);
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
        if (! (o instanceof MethodDeclarator)) return false;
        MethodDeclarator other = (MethodDeclarator) o;
        if (! _IDENTIFIER.equals(other._IDENTIFIER)) return false;
        if (! _LPAREN.equals(other._LPAREN)) return false;
        if (! _FormalParameterListopt.equals(other._FormalParameterListopt)) return false;
        if (! _RPAREN.equals(other._RPAREN)) return false;
        if (! _Dimsopt.equals(other._Dimsopt)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_IDENTIFIER.hashCode());
        hash = hash * 31 + (_LPAREN.hashCode());
        hash = hash * 31 + (_FormalParameterListopt.hashCode());
        hash = hash * 31 + (_RPAREN.hashCode());
        hash = hash * 31 + (_Dimsopt.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


