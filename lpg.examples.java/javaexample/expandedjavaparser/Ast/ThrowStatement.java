//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 191:  ThrowStatement ::= throw Expression ;
 *</b>
 */
public class ThrowStatement extends Ast implements IThrowStatement
{
    private AstToken _throw;
    private IExpression _Expression;
    private AstToken _SEMICOLON;

    public AstToken getthrow() { return _throw; }
    public IExpression getExpression() { return _Expression; }
    public AstToken getSEMICOLON() { return _SEMICOLON; }

    public ThrowStatement(IToken leftIToken, IToken rightIToken,
                          AstToken _throw,
                          IExpression _Expression,
                          AstToken _SEMICOLON)
    {
        super(leftIToken, rightIToken);

        this._throw = _throw;
        ((Ast) _throw).setParent(this);
        this._Expression = _Expression;
        ((Ast) _Expression).setParent(this);
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
        list.add(_throw);
        list.add(_Expression);
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
        if (! (o instanceof ThrowStatement)) return false;
        ThrowStatement other = (ThrowStatement) o;
        if (! _throw.equals(other._throw)) return false;
        if (! _Expression.equals(other._Expression)) return false;
        if (! _SEMICOLON.equals(other._SEMICOLON)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_throw.hashCode());
        hash = hash * 31 + (_Expression.hashCode());
        hash = hash * 31 + (_SEMICOLON.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


