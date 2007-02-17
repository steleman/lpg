package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 188:  ListExpression_noIn ::= AssignmentExpression_noIn
 *</em>
 *<p>
 *<b>
 *<li>Rule 189:  ListExpression_noIn ::= ListExpression_noIn , AssignmentExpression_noIn
 *</b>
 */
public class ListExpression_noIn extends Ast implements IListExpression_noIn
{
    private IListExpression_noIn _ListExpression_noIn;
    private AstToken _COMMA;
    private IAssignmentExpression_noIn _AssignmentExpression_noIn;

    public IListExpression_noIn getListExpression_noIn() { return _ListExpression_noIn; }
    public AstToken getCOMMA() { return _COMMA; }
    public IAssignmentExpression_noIn getAssignmentExpression_noIn() { return _AssignmentExpression_noIn; }

    public ListExpression_noIn(IToken leftIToken, IToken rightIToken,
                               IListExpression_noIn _ListExpression_noIn,
                               AstToken _COMMA,
                               IAssignmentExpression_noIn _AssignmentExpression_noIn)
    {
        super(leftIToken, rightIToken);

        this._ListExpression_noIn = _ListExpression_noIn;
        this._COMMA = _COMMA;
        this._AssignmentExpression_noIn = _AssignmentExpression_noIn;
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
        if (! (o instanceof ListExpression_noIn)) return false;
        ListExpression_noIn other = (ListExpression_noIn) o;
        if (! _ListExpression_noIn.equals(other._ListExpression_noIn)) return false;
        if (! _COMMA.equals(other._COMMA)) return false;
        if (! _AssignmentExpression_noIn.equals(other._AssignmentExpression_noIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ListExpression_noIn.hashCode());
        hash = hash * 31 + (_COMMA.hashCode());
        hash = hash * 31 + (_AssignmentExpression_noIn.hashCode());
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
            _ListExpression_noIn.accept(v);
            _COMMA.accept(v);
            _AssignmentExpression_noIn.accept(v);
        }
        v.endVisit(this);
    }
}


