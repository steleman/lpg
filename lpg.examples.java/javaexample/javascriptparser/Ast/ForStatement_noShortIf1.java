package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 291:  ForStatement_noShortIf ::= FOR ( ForInBinding IN ListExpression_allowIn ) Substatement_noShortIf
 *</b>
 */
public class ForStatement_noShortIf1 extends Ast implements IForStatement_noShortIf
{
    private AstToken _FOR;
    private AstToken _LPAREN;
    private IForInBinding _ForInBinding;
    private AstToken _IN;
    private IListExpression_allowIn _ListExpression_allowIn;
    private AstToken _RPAREN;
    private ISubstatement_noShortIf _Substatement_noShortIf;

    public AstToken getFOR() { return _FOR; }
    public AstToken getLPAREN() { return _LPAREN; }
    public IForInBinding getForInBinding() { return _ForInBinding; }
    public AstToken getIN() { return _IN; }
    public IListExpression_allowIn getListExpression_allowIn() { return _ListExpression_allowIn; }
    public AstToken getRPAREN() { return _RPAREN; }
    public ISubstatement_noShortIf getSubstatement_noShortIf() { return _Substatement_noShortIf; }

    public ForStatement_noShortIf1(IToken leftIToken, IToken rightIToken,
                                   AstToken _FOR,
                                   AstToken _LPAREN,
                                   IForInBinding _ForInBinding,
                                   AstToken _IN,
                                   IListExpression_allowIn _ListExpression_allowIn,
                                   AstToken _RPAREN,
                                   ISubstatement_noShortIf _Substatement_noShortIf)
    {
        super(leftIToken, rightIToken);

        this._FOR = _FOR;
        this._LPAREN = _LPAREN;
        this._ForInBinding = _ForInBinding;
        this._IN = _IN;
        this._ListExpression_allowIn = _ListExpression_allowIn;
        this._RPAREN = _RPAREN;
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
        if (! (o instanceof ForStatement_noShortIf1)) return false;
        ForStatement_noShortIf1 other = (ForStatement_noShortIf1) o;
        if (! _FOR.equals(other._FOR)) return false;
        if (! _LPAREN.equals(other._LPAREN)) return false;
        if (! _ForInBinding.equals(other._ForInBinding)) return false;
        if (! _IN.equals(other._IN)) return false;
        if (! _ListExpression_allowIn.equals(other._ListExpression_allowIn)) return false;
        if (! _RPAREN.equals(other._RPAREN)) return false;
        if (! _Substatement_noShortIf.equals(other._Substatement_noShortIf)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_FOR.hashCode());
        hash = hash * 31 + (_LPAREN.hashCode());
        hash = hash * 31 + (_ForInBinding.hashCode());
        hash = hash * 31 + (_IN.hashCode());
        hash = hash * 31 + (_ListExpression_allowIn.hashCode());
        hash = hash * 31 + (_RPAREN.hashCode());
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
            _FOR.accept(v);
            _LPAREN.accept(v);
            _ForInBinding.accept(v);
            _IN.accept(v);
            _ListExpression_allowIn.accept(v);
            _RPAREN.accept(v);
            _Substatement_noShortIf.accept(v);
        }
        v.endVisit(this);
    }
}


