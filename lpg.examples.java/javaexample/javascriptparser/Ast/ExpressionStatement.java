package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 445:  ExpressionStatement ::= ES_AssignmentExpression_allowIn
 *</em>
 *<p>
 *<b>
 *<li>Rule 446:  ExpressionStatement ::= ExpressionStatement , AssignmentExpression_allowIn
 *</b>
 */
public class ExpressionStatement extends Ast implements IExpressionStatement
{
    private IExpressionStatement _ExpressionStatement;
    private AstToken _COMMA;
    private IAssignmentExpression_allowIn _AssignmentExpression_allowIn;

    public IExpressionStatement getExpressionStatement() { return _ExpressionStatement; }
    public AstToken getCOMMA() { return _COMMA; }
    public IAssignmentExpression_allowIn getAssignmentExpression_allowIn() { return _AssignmentExpression_allowIn; }

    public ExpressionStatement(IToken leftIToken, IToken rightIToken,
                               IExpressionStatement _ExpressionStatement,
                               AstToken _COMMA,
                               IAssignmentExpression_allowIn _AssignmentExpression_allowIn)
    {
        super(leftIToken, rightIToken);

        this._ExpressionStatement = _ExpressionStatement;
        this._COMMA = _COMMA;
        this._AssignmentExpression_allowIn = _AssignmentExpression_allowIn;
        initialize();
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
        if (! _ExpressionStatement.equals(other._ExpressionStatement)) return false;
        if (! _COMMA.equals(other._COMMA)) return false;
        if (! _AssignmentExpression_allowIn.equals(other._AssignmentExpression_allowIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ExpressionStatement.hashCode());
        hash = hash * 31 + (_COMMA.hashCode());
        hash = hash * 31 + (_AssignmentExpression_allowIn.hashCode());
        return hash;
    }

    public void accept(Visitor v)
    {
        if (! v.preVisit(this)) return;
        enter(v);
        v.postVisit(this);
    }

    public void enter(Visitor v)
    {
        boolean checkChildren = v.visit(this);
        if (checkChildren)
        {
            _ExpressionStatement.accept(v);
            _COMMA.accept(v);
            _AssignmentExpression_allowIn.accept(v);
        }
        v.endVisit(this);
    }
}


