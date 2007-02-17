package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 304:  WithStatement_noShortIf ::= WITH ParenListExpression Substatement_noShortIf
 *</b>
 */
public class WithStatement_noShortIf extends Ast implements IWithStatement_noShortIf
{
    private AstToken _WITH;
    private IParenListExpression _ParenListExpression;
    private ISubstatement_noShortIf _Substatement_noShortIf;

    public AstToken getWITH() { return _WITH; }
    public IParenListExpression getParenListExpression() { return _ParenListExpression; }
    public ISubstatement_noShortIf getSubstatement_noShortIf() { return _Substatement_noShortIf; }

    public WithStatement_noShortIf(IToken leftIToken, IToken rightIToken,
                                   AstToken _WITH,
                                   IParenListExpression _ParenListExpression,
                                   ISubstatement_noShortIf _Substatement_noShortIf)
    {
        super(leftIToken, rightIToken);

        this._WITH = _WITH;
        this._ParenListExpression = _ParenListExpression;
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
        if (! (o instanceof WithStatement_noShortIf)) return false;
        WithStatement_noShortIf other = (WithStatement_noShortIf) o;
        if (! _WITH.equals(other._WITH)) return false;
        if (! _ParenListExpression.equals(other._ParenListExpression)) return false;
        if (! _Substatement_noShortIf.equals(other._Substatement_noShortIf)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_WITH.hashCode());
        hash = hash * 31 + (_ParenListExpression.hashCode());
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
            _WITH.accept(v);
            _ParenListExpression.accept(v);
            _Substatement_noShortIf.accept(v);
        }
        v.endVisit(this);
    }
}


