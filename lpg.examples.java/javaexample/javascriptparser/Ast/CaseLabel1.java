package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 283:  CaseLabel ::= DEFAULT :
 *</b>
 */
public class CaseLabel1 extends Ast implements ICaseLabel
{
    private AstToken _DEFAULT;
    private AstToken _COLON;

    public AstToken getDEFAULT() { return _DEFAULT; }
    public AstToken getCOLON() { return _COLON; }

    public CaseLabel1(IToken leftIToken, IToken rightIToken,
                      AstToken _DEFAULT,
                      AstToken _COLON)
    {
        super(leftIToken, rightIToken);

        this._DEFAULT = _DEFAULT;
        this._COLON = _COLON;
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
        if (! (o instanceof CaseLabel1)) return false;
        CaseLabel1 other = (CaseLabel1) o;
        if (! _DEFAULT.equals(other._DEFAULT)) return false;
        if (! _COLON.equals(other._COLON)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_DEFAULT.hashCode());
        hash = hash * 31 + (_COLON.hashCode());
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
            _DEFAULT.accept(v);
            _COLON.accept(v);
        }
        v.endVisit(this);
    }
}


