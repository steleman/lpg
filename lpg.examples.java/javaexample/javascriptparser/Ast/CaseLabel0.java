package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 282:  CaseLabel ::= CASE ListExpression_allowIn :
 *</b>
 */
public class CaseLabel0 extends Ast implements ICaseLabel
{
    private AstToken _CASE;
    private IListExpression_allowIn _ListExpression_allowIn;
    private AstToken _COLON;

    public AstToken getCASE() { return _CASE; }
    public IListExpression_allowIn getListExpression_allowIn() { return _ListExpression_allowIn; }
    public AstToken getCOLON() { return _COLON; }

    public CaseLabel0(IToken leftIToken, IToken rightIToken,
                      AstToken _CASE,
                      IListExpression_allowIn _ListExpression_allowIn,
                      AstToken _COLON)
    {
        super(leftIToken, rightIToken);

        this._CASE = _CASE;
        this._ListExpression_allowIn = _ListExpression_allowIn;
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
        if (! (o instanceof CaseLabel0)) return false;
        CaseLabel0 other = (CaseLabel0) o;
        if (! _CASE.equals(other._CASE)) return false;
        if (! _ListExpression_allowIn.equals(other._ListExpression_allowIn)) return false;
        if (! _COLON.equals(other._COLON)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_CASE.hashCode());
        hash = hash * 31 + (_ListExpression_allowIn.hashCode());
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
            _CASE.accept(v);
            _ListExpression_allowIn.accept(v);
            _COLON.accept(v);
        }
        v.endVisit(this);
    }
}


