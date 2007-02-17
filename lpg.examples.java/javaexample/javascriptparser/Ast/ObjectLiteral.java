package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 31:  ObjectLiteral ::= { FieldList }
 *</b>
 */
public class ObjectLiteral extends Ast implements IObjectLiteral
{
    private AstToken _LBRACE;
    private IFieldList _FieldList;
    private AstToken _RBRACE;

    public AstToken getLBRACE() { return _LBRACE; }
    /**
     * The value returned by <b>getFieldList</b> may be <b>null</b>
     */
    public IFieldList getFieldList() { return _FieldList; }
    public AstToken getRBRACE() { return _RBRACE; }

    public ObjectLiteral(IToken leftIToken, IToken rightIToken,
                         AstToken _LBRACE,
                         IFieldList _FieldList,
                         AstToken _RBRACE)
    {
        super(leftIToken, rightIToken);

        this._LBRACE = _LBRACE;
        this._FieldList = _FieldList;
        this._RBRACE = _RBRACE;
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
        if (! (o instanceof ObjectLiteral)) return false;
        ObjectLiteral other = (ObjectLiteral) o;
        if (! _LBRACE.equals(other._LBRACE)) return false;
        if (_FieldList == null)
            if (other._FieldList != null) return false;
            else; // continue
        else if (! _FieldList.equals(other._FieldList)) return false;
        if (! _RBRACE.equals(other._RBRACE)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_LBRACE.hashCode());
        hash = hash * 31 + (_FieldList == null ? 0 : _FieldList.hashCode());
        hash = hash * 31 + (_RBRACE.hashCode());
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
            _LBRACE.accept(v);
            if (_FieldList != null) _FieldList.accept(v);
            _RBRACE.accept(v);
        }
        v.endVisit(this);
    }
}


