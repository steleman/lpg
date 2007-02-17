package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 186:  ListExpression_allowIn ::= AssignmentExpression_allowIn
 *</em>
 *<p>
 *<b>
 *<li>Rule 187:  ListExpression_allowIn ::= ListExpression_allowIn , AssignmentExpression_allowIn
 *</b>
 */
public class ListExpression_allowIn extends Ast implements IListExpression_allowIn
{
    private IListExpression_allowIn _ListExpression_allowIn;
    private AstToken _COMMA;
    private IAssignmentExpression_allowIn _AssignmentExpression_allowIn;

    public IListExpression_allowIn getListExpression_allowIn() { return _ListExpression_allowIn; }
    public AstToken getCOMMA() { return _COMMA; }
    public IAssignmentExpression_allowIn getAssignmentExpression_allowIn() { return _AssignmentExpression_allowIn; }

    public ListExpression_allowIn(IToken leftIToken, IToken rightIToken,
                                  IListExpression_allowIn _ListExpression_allowIn,
                                  AstToken _COMMA,
                                  IAssignmentExpression_allowIn _AssignmentExpression_allowIn)
    {
        super(leftIToken, rightIToken);

        this._ListExpression_allowIn = _ListExpression_allowIn;
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
        if (! (o instanceof ListExpression_allowIn)) return false;
        ListExpression_allowIn other = (ListExpression_allowIn) o;
        if (! _ListExpression_allowIn.equals(other._ListExpression_allowIn)) return false;
        if (! _COMMA.equals(other._COMMA)) return false;
        if (! _AssignmentExpression_allowIn.equals(other._AssignmentExpression_allowIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ListExpression_allowIn.hashCode());
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
            _ListExpression_allowIn.accept(v);
            _COMMA.accept(v);
            _AssignmentExpression_allowIn.accept(v);
        }
        v.endVisit(this);
    }
}


