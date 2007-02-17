//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 232:  ArrayAccess ::= Name$Base [ Expression ]
 *<li>Rule 233:  ArrayAccess ::= PrimaryNoNewArray$Base [ Expression ]
 *</b>
 */
public class ArrayAccess extends Ast implements IArrayAccess
{
    private IPostfixExpression _Base;
    private AstToken _LBRACKET;
    private IExpression _Expression;
    private AstToken _RBRACKET;

    public IPostfixExpression getBase() { return _Base; }
    public AstToken getLBRACKET() { return _LBRACKET; }
    public IExpression getExpression() { return _Expression; }
    public AstToken getRBRACKET() { return _RBRACKET; }

    public ArrayAccess(IToken leftIToken, IToken rightIToken,
                       IPostfixExpression _Base,
                       AstToken _LBRACKET,
                       IExpression _Expression,
                       AstToken _RBRACKET)
    {
        super(leftIToken, rightIToken);

        this._Base = _Base;
        ((Ast) _Base).setParent(this);
        this._LBRACKET = _LBRACKET;
        ((Ast) _LBRACKET).setParent(this);
        this._Expression = _Expression;
        ((Ast) _Expression).setParent(this);
        this._RBRACKET = _RBRACKET;
        ((Ast) _RBRACKET).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_Base);
        list.add(_LBRACKET);
        list.add(_Expression);
        list.add(_RBRACKET);
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
        if (! (o instanceof ArrayAccess)) return false;
        ArrayAccess other = (ArrayAccess) o;
        if (! _Base.equals(other._Base)) return false;
        if (! _LBRACKET.equals(other._LBRACKET)) return false;
        if (! _Expression.equals(other._Expression)) return false;
        if (! _RBRACKET.equals(other._RBRACKET)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_Base.hashCode());
        hash = hash * 31 + (_LBRACKET.hashCode());
        hash = hash * 31 + (_Expression.hashCode());
        hash = hash * 31 + (_RBRACKET.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


