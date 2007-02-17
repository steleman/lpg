package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 228:  Statement_full ::= DoStatement Semicolon_full
 *</b>
 */
public class Statement_full2 extends Ast implements IStatement_full
{
    private DoStatement _DoStatement;
    private ISemicolon_full _Semicolon_full;

    public DoStatement getDoStatement() { return _DoStatement; }
    public ISemicolon_full getSemicolon_full() { return _Semicolon_full; }

    public Statement_full2(IToken leftIToken, IToken rightIToken,
                           DoStatement _DoStatement,
                           ISemicolon_full _Semicolon_full)
    {
        super(leftIToken, rightIToken);

        this._DoStatement = _DoStatement;
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
        if (! (o instanceof Statement_full2)) return false;
        Statement_full2 other = (Statement_full2) o;
        if (! _DoStatement.equals(other._DoStatement)) return false;
        if (! _Semicolon_full.equals(other._Semicolon_full)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_DoStatement.hashCode());
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
            _DoStatement.accept(v);
            _Semicolon_full.accept(v);
        }
        v.endVisit(this);
    }
}


