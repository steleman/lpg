package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 290:  ForStatement_noShortIf ::= FOR ( ForInitializer ; OptionalExpression ; OptionalExpression ) Substatement_noShortIf
 *</b>
 */
public class ForStatement_noShortIf0 extends Ast implements IForStatement_noShortIf
{
    private AstToken _FOR;
    private AstToken _LPAREN;
    private IForInitializer _ForInitializer;
    private AstToken _SEMICOLON;
    private IOptionalExpression _OptionalExpression;
    private AstToken _SEMICOLON6;
    private IOptionalExpression _OptionalExpression7;
    private AstToken _RPAREN;
    private ISubstatement_noShortIf _Substatement_noShortIf;

    public AstToken getFOR() { return _FOR; }
    public AstToken getLPAREN() { return _LPAREN; }
    /**
     * The value returned by <b>getForInitializer</b> may be <b>null</b>
     */
    public IForInitializer getForInitializer() { return _ForInitializer; }
    public AstToken getSEMICOLON() { return _SEMICOLON; }
    /**
     * The value returned by <b>getOptionalExpression</b> may be <b>null</b>
     */
    public IOptionalExpression getOptionalExpression() { return _OptionalExpression; }
    public AstToken getSEMICOLON6() { return _SEMICOLON6; }
    /**
     * The value returned by <b>getOptionalExpression7</b> may be <b>null</b>
     */
    public IOptionalExpression getOptionalExpression7() { return _OptionalExpression7; }
    public AstToken getRPAREN() { return _RPAREN; }
    public ISubstatement_noShortIf getSubstatement_noShortIf() { return _Substatement_noShortIf; }

    public ForStatement_noShortIf0(IToken leftIToken, IToken rightIToken,
                                   AstToken _FOR,
                                   AstToken _LPAREN,
                                   IForInitializer _ForInitializer,
                                   AstToken _SEMICOLON,
                                   IOptionalExpression _OptionalExpression,
                                   AstToken _SEMICOLON6,
                                   IOptionalExpression _OptionalExpression7,
                                   AstToken _RPAREN,
                                   ISubstatement_noShortIf _Substatement_noShortIf)
    {
        super(leftIToken, rightIToken);

        this._FOR = _FOR;
        this._LPAREN = _LPAREN;
        this._ForInitializer = _ForInitializer;
        this._SEMICOLON = _SEMICOLON;
        this._OptionalExpression = _OptionalExpression;
        this._SEMICOLON6 = _SEMICOLON6;
        this._OptionalExpression7 = _OptionalExpression7;
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
        if (! (o instanceof ForStatement_noShortIf0)) return false;
        ForStatement_noShortIf0 other = (ForStatement_noShortIf0) o;
        if (! _FOR.equals(other._FOR)) return false;
        if (! _LPAREN.equals(other._LPAREN)) return false;
        if (_ForInitializer == null)
            if (other._ForInitializer != null) return false;
            else; // continue
        else if (! _ForInitializer.equals(other._ForInitializer)) return false;
        if (! _SEMICOLON.equals(other._SEMICOLON)) return false;
        if (_OptionalExpression == null)
            if (other._OptionalExpression != null) return false;
            else; // continue
        else if (! _OptionalExpression.equals(other._OptionalExpression)) return false;
        if (! _SEMICOLON6.equals(other._SEMICOLON6)) return false;
        if (_OptionalExpression7 == null)
            if (other._OptionalExpression7 != null) return false;
            else; // continue
        else if (! _OptionalExpression7.equals(other._OptionalExpression7)) return false;
        if (! _RPAREN.equals(other._RPAREN)) return false;
        if (! _Substatement_noShortIf.equals(other._Substatement_noShortIf)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_FOR.hashCode());
        hash = hash * 31 + (_LPAREN.hashCode());
        hash = hash * 31 + (_ForInitializer == null ? 0 : _ForInitializer.hashCode());
        hash = hash * 31 + (_SEMICOLON.hashCode());
        hash = hash * 31 + (_OptionalExpression == null ? 0 : _OptionalExpression.hashCode());
        hash = hash * 31 + (_SEMICOLON6.hashCode());
        hash = hash * 31 + (_OptionalExpression7 == null ? 0 : _OptionalExpression7.hashCode());
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
            if (_ForInitializer != null) _ForInitializer.accept(v);
            _SEMICOLON.accept(v);
            if (_OptionalExpression != null) _OptionalExpression.accept(v);
            _SEMICOLON6.accept(v);
            if (_OptionalExpression7 != null) _OptionalExpression7.accept(v);
            _RPAREN.accept(v);
            _Substatement_noShortIf.accept(v);
        }
        v.endVisit(this);
    }
}


