package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 284:  DoStatement ::= DO Substatement_abbrev WHILE ParenListExpression
 *</b>
 */
public class DoStatement extends Ast implements IDoStatement
{
    private AstToken _DO;
    private ISubstatement_abbrev _Substatement_abbrev;
    private AstToken _WHILE;
    private IParenListExpression _ParenListExpression;

    public AstToken getDO() { return _DO; }
    public ISubstatement_abbrev getSubstatement_abbrev() { return _Substatement_abbrev; }
    public AstToken getWHILE() { return _WHILE; }
    public IParenListExpression getParenListExpression() { return _ParenListExpression; }

    public DoStatement(IToken leftIToken, IToken rightIToken,
                       AstToken _DO,
                       ISubstatement_abbrev _Substatement_abbrev,
                       AstToken _WHILE,
                       IParenListExpression _ParenListExpression)
    {
        super(leftIToken, rightIToken);

        this._DO = _DO;
        this._Substatement_abbrev = _Substatement_abbrev;
        this._WHILE = _WHILE;
        this._ParenListExpression = _ParenListExpression;
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
        if (! (o instanceof DoStatement)) return false;
        DoStatement other = (DoStatement) o;
        if (! _DO.equals(other._DO)) return false;
        if (! _Substatement_abbrev.equals(other._Substatement_abbrev)) return false;
        if (! _WHILE.equals(other._WHILE)) return false;
        if (! _ParenListExpression.equals(other._ParenListExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_DO.hashCode());
        hash = hash * 31 + (_Substatement_abbrev.hashCode());
        hash = hash * 31 + (_WHILE.hashCode());
        hash = hash * 31 + (_ParenListExpression.hashCode());
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
            _DO.accept(v);
            _Substatement_abbrev.accept(v);
            _WHILE.accept(v);
            _ParenListExpression.accept(v);
        }
        v.endVisit(this);
    }
}


