package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 36:  LiteralField ::= FieldName : AssignmentExpression_allowIn
 *</b>
 */
public class LiteralField extends Ast implements ILiteralField
{
    private IFieldName _FieldName;
    private AstToken _COLON;
    private IAssignmentExpression_allowIn _AssignmentExpression_allowIn;

    public IFieldName getFieldName() { return _FieldName; }
    public AstToken getCOLON() { return _COLON; }
    public IAssignmentExpression_allowIn getAssignmentExpression_allowIn() { return _AssignmentExpression_allowIn; }

    public LiteralField(IToken leftIToken, IToken rightIToken,
                        IFieldName _FieldName,
                        AstToken _COLON,
                        IAssignmentExpression_allowIn _AssignmentExpression_allowIn)
    {
        super(leftIToken, rightIToken);

        this._FieldName = _FieldName;
        this._COLON = _COLON;
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
        if (! (o instanceof LiteralField)) return false;
        LiteralField other = (LiteralField) o;
        if (! _FieldName.equals(other._FieldName)) return false;
        if (! _COLON.equals(other._COLON)) return false;
        if (! _AssignmentExpression_allowIn.equals(other._AssignmentExpression_allowIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_FieldName.hashCode());
        hash = hash * 31 + (_COLON.hashCode());
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
            _FieldName.accept(v);
            _COLON.accept(v);
            _AssignmentExpression_allowIn.accept(v);
        }
        v.endVisit(this);
    }
}


