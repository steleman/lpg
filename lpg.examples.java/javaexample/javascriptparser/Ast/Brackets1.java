package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 75:  Brackets ::= [ ListExpression_allowIn ]
 *</b>
 */
public class Brackets1 extends Ast implements IBrackets
{
    private AstToken _LBRACKET;
    private IListExpression_allowIn _ListExpression_allowIn;
    private AstToken _RBRACKET;

    public AstToken getLBRACKET() { return _LBRACKET; }
    public IListExpression_allowIn getListExpression_allowIn() { return _ListExpression_allowIn; }
    public AstToken getRBRACKET() { return _RBRACKET; }

    public Brackets1(IToken leftIToken, IToken rightIToken,
                     AstToken _LBRACKET,
                     IListExpression_allowIn _ListExpression_allowIn,
                     AstToken _RBRACKET)
    {
        super(leftIToken, rightIToken);

        this._LBRACKET = _LBRACKET;
        this._ListExpression_allowIn = _ListExpression_allowIn;
        this._RBRACKET = _RBRACKET;
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
        if (! (o instanceof Brackets1)) return false;
        Brackets1 other = (Brackets1) o;
        if (! _LBRACKET.equals(other._LBRACKET)) return false;
        if (! _ListExpression_allowIn.equals(other._ListExpression_allowIn)) return false;
        if (! _RBRACKET.equals(other._RBRACKET)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_LBRACKET.hashCode());
        hash = hash * 31 + (_ListExpression_allowIn.hashCode());
        hash = hash * 31 + (_RBRACKET.hashCode());
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
            _LBRACKET.accept(v);
            _ListExpression_allowIn.accept(v);
            _RBRACKET.accept(v);
        }
        v.endVisit(this);
    }
}


