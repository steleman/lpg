//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 157:  ExpressionStatement ::= StatementExpression ;
 *</b>
 */
public class ExpressionStatement extends Ast implements IExpressionStatement
{
    private IStatementExpression _StatementExpression;
    private AstToken _SEMICOLON;

    public IStatementExpression getStatementExpression() { return _StatementExpression; }
    public AstToken getSEMICOLON() { return _SEMICOLON; }

    public ExpressionStatement(IToken leftIToken, IToken rightIToken,
                               IStatementExpression _StatementExpression,
                               AstToken _SEMICOLON)
    {
        super(leftIToken, rightIToken);

        this._StatementExpression = _StatementExpression;
        ((Ast) _StatementExpression).setParent(this);
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
        list.add(_StatementExpression);
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
        if (! (o instanceof ExpressionStatement)) return false;
        ExpressionStatement other = (ExpressionStatement) o;
        if (! _StatementExpression.equals(other._StatementExpression)) return false;
        if (! _SEMICOLON.equals(other._SEMICOLON)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_StatementExpression.hashCode());
        hash = hash * 31 + (_SEMICOLON.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


