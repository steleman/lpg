package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 285:  WhileStatement_abbrev ::= WHILE ParenListExpression Substatement_abbrev
 *</b>
 */
public class WhileStatement_abbrev extends Ast implements IWhileStatement_abbrev
{
    private AstToken _WHILE;
    private IParenListExpression _ParenListExpression;
    private ISubstatement_abbrev _Substatement_abbrev;

    public AstToken getWHILE() { return _WHILE; }
    public IParenListExpression getParenListExpression() { return _ParenListExpression; }
    public ISubstatement_abbrev getSubstatement_abbrev() { return _Substatement_abbrev; }

    public WhileStatement_abbrev(IToken leftIToken, IToken rightIToken,
                                 AstToken _WHILE,
                                 IParenListExpression _ParenListExpression,
                                 ISubstatement_abbrev _Substatement_abbrev)
    {
        super(leftIToken, rightIToken);

        this._WHILE = _WHILE;
        this._ParenListExpression = _ParenListExpression;
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
        if (! (o instanceof WhileStatement_abbrev)) return false;
        WhileStatement_abbrev other = (WhileStatement_abbrev) o;
        if (! _WHILE.equals(other._WHILE)) return false;
        if (! _ParenListExpression.equals(other._ParenListExpression)) return false;
        if (! _Substatement_abbrev.equals(other._Substatement_abbrev)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_WHILE.hashCode());
        hash = hash * 31 + (_ParenListExpression.hashCode());
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
            _WHILE.accept(v);
            _ParenListExpression.accept(v);
            _Substatement_abbrev.accept(v);
        }
        v.endVisit(this);
    }
}

