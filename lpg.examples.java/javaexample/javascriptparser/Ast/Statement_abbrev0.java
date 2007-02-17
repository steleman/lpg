package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 192:  Statement_abbrev ::= ExpressionStatement Semicolon_abbrev
 *</b>
 */
public class Statement_abbrev0 extends Ast implements IStatement_abbrev
{
    private IExpressionStatement _ExpressionStatement;
    private ISemicolon_abbrev _Semicolon_abbrev;

    public IExpressionStatement getExpressionStatement() { return _ExpressionStatement; }
    /**
     * The value returned by <b>getSemicolon_abbrev</b> may be <b>null</b>
     */
    public ISemicolon_abbrev getSemicolon_abbrev() { return _Semicolon_abbrev; }

    public Statement_abbrev0(IToken leftIToken, IToken rightIToken,
                             IExpressionStatement _ExpressionStatement,
                             ISemicolon_abbrev _Semicolon_abbrev)
    {
        super(leftIToken, rightIToken);

        this._ExpressionStatement = _ExpressionStatement;
        this._Semicolon_abbrev = _Semicolon_abbrev;
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
        if (! (o instanceof Statement_abbrev0)) return false;
        Statement_abbrev0 other = (Statement_abbrev0) o;
        if (! _ExpressionStatement.equals(other._ExpressionStatement)) return false;
        if (_Semicolon_abbrev == null)
            if (other._Semicolon_abbrev != null) return false;
            else; // continue
        else if (! _Semicolon_abbrev.equals(other._Semicolon_abbrev)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ExpressionStatement.hashCode());
        hash = hash * 31 + (_Semicolon_abbrev == null ? 0 : _Semicolon_abbrev.hashCode());
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
            if (_Semicolon_abbrev != null) _Semicolon_abbrev.accept(v);
        }
        v.endVisit(this);
    }
}


