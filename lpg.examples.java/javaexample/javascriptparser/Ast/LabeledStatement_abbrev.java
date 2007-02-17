package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 264:  LabeledStatement_abbrev ::= Identifier : Substatement_abbrev
 *</b>
 */
public class LabeledStatement_abbrev extends Ast implements ILabeledStatement_abbrev
{
    private IIdentifier _Identifier;
    private AstToken _COLON;
    private ISubstatement_abbrev _Substatement_abbrev;

    public IIdentifier getIdentifier() { return _Identifier; }
    public AstToken getCOLON() { return _COLON; }
    public ISubstatement_abbrev getSubstatement_abbrev() { return _Substatement_abbrev; }

    public LabeledStatement_abbrev(IToken leftIToken, IToken rightIToken,
                                   IIdentifier _Identifier,
                                   AstToken _COLON,
                                   ISubstatement_abbrev _Substatement_abbrev)
    {
        super(leftIToken, rightIToken);

        this._Identifier = _Identifier;
        this._COLON = _COLON;
        this._Substatement_abbrev = _Substatement_abbrev;
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
        if (! (o instanceof LabeledStatement_abbrev)) return false;
        LabeledStatement_abbrev other = (LabeledStatement_abbrev) o;
        if (! _Identifier.equals(other._Identifier)) return false;
        if (! _COLON.equals(other._COLON)) return false;
        if (! _Substatement_abbrev.equals(other._Substatement_abbrev)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_Identifier.hashCode());
        hash = hash * 31 + (_COLON.hashCode());
        hash = hash * 31 + (_Substatement_abbrev.hashCode());
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
            _Identifier.accept(v);
            _COLON.accept(v);
            _Substatement_abbrev.accept(v);
        }
        v.endVisit(this);
    }
}


