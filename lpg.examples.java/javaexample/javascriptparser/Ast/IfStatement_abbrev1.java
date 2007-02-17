package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 268:  IfStatement_abbrev ::= IF ParenListExpression Substatement_noShortIf ELSE Substatement_abbrev
 *</b>
 */
public class IfStatement_abbrev1 extends Ast implements IIfStatement_abbrev
{
    private AstToken _IF;
    private IParenListExpression _ParenListExpression;
    private ISubstatement_noShortIf _Substatement_noShortIf;
    private AstToken _ELSE;
    private ISubstatement_abbrev _Substatement_abbrev;

    public AstToken getIF() { return _IF; }
    public IParenListExpression getParenListExpression() { return _ParenListExpression; }
    public ISubstatement_noShortIf getSubstatement_noShortIf() { return _Substatement_noShortIf; }
    public AstToken getELSE() { return _ELSE; }
    public ISubstatement_abbrev getSubstatement_abbrev() { return _Substatement_abbrev; }

    public IfStatement_abbrev1(IToken leftIToken, IToken rightIToken,
                               AstToken _IF,
                               IParenListExpression _ParenListExpression,
                               ISubstatement_noShortIf _Substatement_noShortIf,
                               AstToken _ELSE,
                               ISubstatement_abbrev _Substatement_abbrev)
    {
        super(leftIToken, rightIToken);

        this._IF = _IF;
        this._ParenListExpression = _ParenListExpression;
        this._Substatement_noShortIf = _Substatement_noShortIf;
        this._ELSE = _ELSE;
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
        if (! (o instanceof IfStatement_abbrev1)) return false;
        IfStatement_abbrev1 other = (IfStatement_abbrev1) o;
        if (! _IF.equals(other._IF)) return false;
        if (! _ParenListExpression.equals(other._ParenListExpression)) return false;
        if (! _Substatement_noShortIf.equals(other._Substatement_noShortIf)) return false;
        if (! _ELSE.equals(other._ELSE)) return false;
        if (! _Substatement_abbrev.equals(other._Substatement_abbrev)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_IF.hashCode());
        hash = hash * 31 + (_ParenListExpression.hashCode());
        hash = hash * 31 + (_Substatement_noShortIf.hashCode());
        hash = hash * 31 + (_ELSE.hashCode());
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
            _IF.accept(v);
            _ParenListExpression.accept(v);
            _Substatement_noShortIf.accept(v);
            _ELSE.accept(v);
            _Substatement_abbrev.accept(v);
        }
        v.endVisit(this);
    }
}


