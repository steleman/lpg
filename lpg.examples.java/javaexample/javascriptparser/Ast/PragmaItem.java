package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 368:  PragmaItem ::= PragmaExpr
 *</em>
 *<p>
 *<b>
 *<li>Rule 369:  PragmaItem ::= PragmaExpr ?
 *</b>
 */
public class PragmaItem extends Ast implements IPragmaItem
{
    private IPragmaExpr _PragmaExpr;
    private AstToken _QUESTION;

    public IPragmaExpr getPragmaExpr() { return _PragmaExpr; }
    public AstToken getQUESTION() { return _QUESTION; }

    public PragmaItem(IToken leftIToken, IToken rightIToken,
                      IPragmaExpr _PragmaExpr,
                      AstToken _QUESTION)
    {
        super(leftIToken, rightIToken);

        this._PragmaExpr = _PragmaExpr;
        this._QUESTION = _QUESTION;
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
        if (! (o instanceof PragmaItem)) return false;
        PragmaItem other = (PragmaItem) o;
        if (! _PragmaExpr.equals(other._PragmaExpr)) return false;
        if (! _QUESTION.equals(other._QUESTION)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_PragmaExpr.hashCode());
        hash = hash * 31 + (_QUESTION.hashCode());
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
            _PragmaExpr.accept(v);
            _QUESTION.accept(v);
        }
        v.endVisit(this);
    }
}


