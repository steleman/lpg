package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 217:  Statement_noShortIf ::= ContinueStatement Semicolon_noShortIf
 *</b>
 */
public class Statement_noShortIf3 extends Ast implements IStatement_noShortIf
{
    private IContinueStatement _ContinueStatement;
    private ISemicolon_noShortIf _Semicolon_noShortIf;

    public IContinueStatement getContinueStatement() { return _ContinueStatement; }
    /**
     * The value returned by <b>getSemicolon_noShortIf</b> may be <b>null</b>
     */
    public ISemicolon_noShortIf getSemicolon_noShortIf() { return _Semicolon_noShortIf; }

    public Statement_noShortIf3(IToken leftIToken, IToken rightIToken,
                                IContinueStatement _ContinueStatement,
                                ISemicolon_noShortIf _Semicolon_noShortIf)
    {
        super(leftIToken, rightIToken);

        this._ContinueStatement = _ContinueStatement;
        this._Semicolon_noShortIf = _Semicolon_noShortIf;
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
        if (! (o instanceof Statement_noShortIf3)) return false;
        Statement_noShortIf3 other = (Statement_noShortIf3) o;
        if (! _ContinueStatement.equals(other._ContinueStatement)) return false;
        if (_Semicolon_noShortIf == null)
            if (other._Semicolon_noShortIf != null) return false;
            else; // continue
        else if (! _Semicolon_noShortIf.equals(other._Semicolon_noShortIf)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ContinueStatement.hashCode());
        hash = hash * 31 + (_Semicolon_noShortIf == null ? 0 : _Semicolon_noShortIf.hashCode());
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
            _ContinueStatement.accept(v);
            if (_Semicolon_noShortIf != null) _Semicolon_noShortIf.accept(v);
        }
        v.endVisit(this);
    }
}


