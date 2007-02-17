package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 424:  ParameterInit ::= Parameter
 *</em>
 *<p>
 *<b>
 *<li>Rule 425:  ParameterInit ::= Parameter = AssignmentExpression_allowIn
 *</b>
 */
public class ParameterInit extends Ast implements IParameterInit
{
    private Parameter _Parameter;
    private AstToken _EQUAL;
    private IAssignmentExpression_allowIn _AssignmentExpression_allowIn;

    public Parameter getParameter() { return _Parameter; }
    public AstToken getEQUAL() { return _EQUAL; }
    public IAssignmentExpression_allowIn getAssignmentExpression_allowIn() { return _AssignmentExpression_allowIn; }

    public ParameterInit(IToken leftIToken, IToken rightIToken,
                         Parameter _Parameter,
                         AstToken _EQUAL,
                         IAssignmentExpression_allowIn _AssignmentExpression_allowIn)
    {
        super(leftIToken, rightIToken);

        this._Parameter = _Parameter;
        this._EQUAL = _EQUAL;
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
        if (! (o instanceof ParameterInit)) return false;
        ParameterInit other = (ParameterInit) o;
        if (! _Parameter.equals(other._Parameter)) return false;
        if (! _EQUAL.equals(other._EQUAL)) return false;
        if (! _AssignmentExpression_allowIn.equals(other._AssignmentExpression_allowIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_Parameter.hashCode());
        hash = hash * 31 + (_EQUAL.hashCode());
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
            _Parameter.accept(v);
            _EQUAL.accept(v);
            _AssignmentExpression_allowIn.accept(v);
        }
        v.endVisit(this);
    }
}


