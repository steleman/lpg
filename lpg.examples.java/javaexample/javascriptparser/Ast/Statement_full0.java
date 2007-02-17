package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 222:  Statement_full ::= ExpressionStatement Semicolon_full
 *</b>
 */
public class Statement_full0 extends Ast implements IStatement_full
{
    private IExpressionStatement _ExpressionStatement;
    private ISemicolon_full _Semicolon_full;

    public IExpressionStatement getExpressionStatement() { return _ExpressionStatement; }
    public ISemicolon_full getSemicolon_full() { return _Semicolon_full; }

    public Statement_full0(IToken leftIToken, IToken rightIToken,
                           IExpressionStatement _ExpressionStatement,
                           ISemicolon_full _Semicolon_full)
    {
        super(leftIToken, rightIToken);

        this._ExpressionStatement = _ExpressionStatement;
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
        if (! (o instanceof Statement_full0)) return false;
        Statement_full0 other = (Statement_full0) o;
        if (! _ExpressionStatement.equals(other._ExpressionStatement)) return false;
        if (! _Semicolon_full.equals(other._Semicolon_full)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ExpressionStatement.hashCode());
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
            _ExpressionStatement.accept(v);
            _Semicolon_full.accept(v);
        }
        v.endVisit(this);
    }
}


