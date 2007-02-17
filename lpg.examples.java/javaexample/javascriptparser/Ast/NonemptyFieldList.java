package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 34:  NonemptyFieldList ::= LiteralField
 *</em>
 *<p>
 *<b>
 *<li>Rule 35:  NonemptyFieldList ::= NonemptyFieldList , LiteralField
 *</b>
 */
public class NonemptyFieldList extends Ast implements INonemptyFieldList
{
    private INonemptyFieldList _NonemptyFieldList;
    private AstToken _COMMA;
    private LiteralField _LiteralField;

    public INonemptyFieldList getNonemptyFieldList() { return _NonemptyFieldList; }
    public AstToken getCOMMA() { return _COMMA; }
    public LiteralField getLiteralField() { return _LiteralField; }

    public NonemptyFieldList(IToken leftIToken, IToken rightIToken,
                             INonemptyFieldList _NonemptyFieldList,
                             AstToken _COMMA,
                             LiteralField _LiteralField)
    {
        super(leftIToken, rightIToken);

        this._NonemptyFieldList = _NonemptyFieldList;
        this._COMMA = _COMMA;
        this._LiteralField = _LiteralField;
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
        if (! (o instanceof NonemptyFieldList)) return false;
        NonemptyFieldList other = (NonemptyFieldList) o;
        if (! _NonemptyFieldList.equals(other._NonemptyFieldList)) return false;
        if (! _COMMA.equals(other._COMMA)) return false;
        if (! _LiteralField.equals(other._LiteralField)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_NonemptyFieldList.hashCode());
        hash = hash * 31 + (_COMMA.hashCode());
        hash = hash * 31 + (_LiteralField.hashCode());
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
            _NonemptyFieldList.accept(v);
            _COMMA.accept(v);
            _LiteralField.accept(v);
        }
        v.endVisit(this);
    }
}


