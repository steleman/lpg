package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 266:  LabeledStatement_full ::= Identifier : Substatement_full
 *</b>
 */
public class LabeledStatement_full extends Ast implements ILabeledStatement_full
{
    private IIdentifier _Identifier;
    private AstToken _COLON;
    private ISubstatement_full _Substatement_full;

    public IIdentifier getIdentifier() { return _Identifier; }
    public AstToken getCOLON() { return _COLON; }
    public ISubstatement_full getSubstatement_full() { return _Substatement_full; }

    public LabeledStatement_full(IToken leftIToken, IToken rightIToken,
                                 IIdentifier _Identifier,
                                 AstToken _COLON,
                                 ISubstatement_full _Substatement_full)
    {
        super(leftIToken, rightIToken);

        this._Identifier = _Identifier;
        this._COLON = _COLON;
        this._Substatement_full = _Substatement_full;
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
        if (! (o instanceof LabeledStatement_full)) return false;
        LabeledStatement_full other = (LabeledStatement_full) o;
        if (! _Identifier.equals(other._Identifier)) return false;
        if (! _COLON.equals(other._COLON)) return false;
        if (! _Substatement_full.equals(other._Substatement_full)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_Identifier.hashCode());
        hash = hash * 31 + (_COLON.hashCode());
        hash = hash * 31 + (_Substatement_full.hashCode());
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
            _Substatement_full.accept(v);
        }
        v.endVisit(this);
    }
}


