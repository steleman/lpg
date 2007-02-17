package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 235:  Statement_full ::= ThrowStatement Semicolon_full
 *</b>
 */
public class Statement_full6 extends Ast implements IStatement_full
{
    private ThrowStatement _ThrowStatement;
    private ISemicolon_full _Semicolon_full;

    public ThrowStatement getThrowStatement() { return _ThrowStatement; }
    public ISemicolon_full getSemicolon_full() { return _Semicolon_full; }

    public Statement_full6(IToken leftIToken, IToken rightIToken,
                           ThrowStatement _ThrowStatement,
                           ISemicolon_full _Semicolon_full)
    {
        super(leftIToken, rightIToken);

        this._ThrowStatement = _ThrowStatement;
        this._Semicolon_full = _Semicolon_full;
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
        if (! (o instanceof Statement_full6)) return false;
        Statement_full6 other = (Statement_full6) o;
        if (! _ThrowStatement.equals(other._ThrowStatement)) return false;
        if (! _Semicolon_full.equals(other._Semicolon_full)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ThrowStatement.hashCode());
        hash = hash * 31 + (_Semicolon_full.hashCode());
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
            _ThrowStatement.accept(v);
            _Semicolon_full.accept(v);
        }
        v.endVisit(this);
    }
}


