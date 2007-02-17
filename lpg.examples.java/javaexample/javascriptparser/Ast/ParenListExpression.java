package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 27:  ParenListExpression ::= ParenExpression
 *</em>
 *<p>
 *<b>
 *<li>Rule 28:  ParenListExpression ::= ( ListExpression_allowIn , AssignmentExpression_allowIn )
 *</b>
 */
public class ParenListExpression extends Ast implements IParenListExpression
{
    private AstToken _LPAREN;
    private IListExpression_allowIn _ListExpression_allowIn;
    private AstToken _COMMA;
    private IAssignmentExpression_allowIn _AssignmentExpression_allowIn;
    private AstToken _RPAREN;

    public AstToken getLPAREN() { return _LPAREN; }
    public IListExpression_allowIn getListExpression_allowIn() { return _ListExpression_allowIn; }
    public AstToken getCOMMA() { return _COMMA; }
    public IAssignmentExpression_allowIn getAssignmentExpression_allowIn() { return _AssignmentExpression_allowIn; }
    public AstToken getRPAREN() { return _RPAREN; }

    public ParenListExpression(IToken leftIToken, IToken rightIToken,
                               AstToken _LPAREN,
                               IListExpression_allowIn _ListExpression_allowIn,
                               AstToken _COMMA,
                               IAssignmentExpression_allowIn _AssignmentExpression_allowIn,
                               AstToken _RPAREN)
    {
        super(leftIToken, rightIToken);

        this._LPAREN = _LPAREN;
        this._ListExpression_allowIn = _ListExpression_allowIn;
        this._COMMA = _COMMA;
        this._AssignmentExpression_allowIn = _AssignmentExpression_allowIn;
        this._RPAREN = _RPAREN;
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
        if (! (o instanceof ParenListExpression)) return false;
        ParenListExpression other = (ParenListExpression) o;
        if (! _LPAREN.equals(other._LPAREN)) return false;
        if (! _ListExpression_allowIn.equals(other._ListExpression_allowIn)) return false;
        if (! _COMMA.equals(other._COMMA)) return false;
        if (! _AssignmentExpression_allowIn.equals(other._AssignmentExpression_allowIn)) return false;
        if (! _RPAREN.equals(other._RPAREN)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_LPAREN.hashCode());
        hash = hash * 31 + (_ListExpression_allowIn.hashCode());
        hash = hash * 31 + (_COMMA.hashCode());
        hash = hash * 31 + (_AssignmentExpression_allowIn.hashCode());
        hash = hash * 31 + (_RPAREN.hashCode());
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
            _LPAREN.accept(v);
            _ListExpression_allowIn.accept(v);
            _COMMA.accept(v);
            _AssignmentExpression_allowIn.accept(v);
            _RPAREN.accept(v);
        }
        v.endVisit(this);
    }
}


