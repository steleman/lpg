package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 82:  RestExpression ::= ... AssignmentExpression_allowIn
 *</b>
 */
public class RestExpression extends Ast implements IRestExpression
{
    private AstToken _ETC;
    private IAssignmentExpression_allowIn _AssignmentExpression_allowIn;

    public AstToken getETC() { return _ETC; }
    public IAssignmentExpression_allowIn getAssignmentExpression_allowIn() { return _AssignmentExpression_allowIn; }

    public RestExpression(IToken leftIToken, IToken rightIToken,
                          AstToken _ETC,
                          IAssignmentExpression_allowIn _AssignmentExpression_allowIn)
    {
        super(leftIToken, rightIToken);

        this._ETC = _ETC;
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
        if (! (o instanceof RestExpression)) return false;
        RestExpression other = (RestExpression) o;
        if (! _ETC.equals(other._ETC)) return false;
        if (! _AssignmentExpression_allowIn.equals(other._AssignmentExpression_allowIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ETC.hashCode());
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
            _ETC.accept(v);
            _AssignmentExpression_allowIn.accept(v);
        }
        v.endVisit(this);
    }
}


