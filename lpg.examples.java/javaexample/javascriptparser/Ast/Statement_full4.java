package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 233:  Statement_full ::= BreakStatement Semicolon_full
 *</b>
 */
public class Statement_full4 extends Ast implements IStatement_full
{
    private IBreakStatement _BreakStatement;
    private ISemicolon_full _Semicolon_full;

    public IBreakStatement getBreakStatement() { return _BreakStatement; }
    public ISemicolon_full getSemicolon_full() { return _Semicolon_full; }

    public Statement_full4(IToken leftIToken, IToken rightIToken,
                           IBreakStatement _BreakStatement,
                           ISemicolon_full _Semicolon_full)
    {
        super(leftIToken, rightIToken);

        this._BreakStatement = _BreakStatement;
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
        if (! (o instanceof Statement_full4)) return false;
        Statement_full4 other = (Statement_full4) o;
        if (! _BreakStatement.equals(other._BreakStatement)) return false;
        if (! _Semicolon_full.equals(other._Semicolon_full)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_BreakStatement.hashCode());
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
            _BreakStatement.accept(v);
            _Semicolon_full.accept(v);
        }
        v.endVisit(this);
    }
}


