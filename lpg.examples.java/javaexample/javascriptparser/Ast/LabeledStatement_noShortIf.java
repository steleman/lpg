package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 265:  LabeledStatement_noShortIf ::= Identifier : Substatement_noShortIf
 *</b>
 */
public class LabeledStatement_noShortIf extends Ast implements ILabeledStatement_noShortIf
{
    private IIdentifier _Identifier;
    private AstToken _COLON;
    private ISubstatement_noShortIf _Substatement_noShortIf;

    public IIdentifier getIdentifier() { return _Identifier; }
    public AstToken getCOLON() { return _COLON; }
    public ISubstatement_noShortIf getSubstatement_noShortIf() { return _Substatement_noShortIf; }

    public LabeledStatement_noShortIf(IToken leftIToken, IToken rightIToken,
                                      IIdentifier _Identifier,
                                      AstToken _COLON,
                                      ISubstatement_noShortIf _Substatement_noShortIf)
    {
        super(leftIToken, rightIToken);

        this._Identifier = _Identifier;
        this._COLON = _COLON;
        this._Substatement_noShortIf = _Substatement_noShortIf;
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
        if (! (o instanceof LabeledStatement_noShortIf)) return false;
        LabeledStatement_noShortIf other = (LabeledStatement_noShortIf) o;
        if (! _Identifier.equals(other._Identifier)) return false;
        if (! _COLON.equals(other._COLON)) return false;
        if (! _Substatement_noShortIf.equals(other._Substatement_noShortIf)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_Identifier.hashCode());
        hash = hash * 31 + (_COLON.hashCode());
        hash = hash * 31 + (_Substatement_noShortIf.hashCode());
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
            _Substatement_noShortIf.accept(v);
        }
        v.endVisit(this);
    }
}


