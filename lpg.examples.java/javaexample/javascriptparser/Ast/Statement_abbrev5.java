package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 204:  Statement_abbrev ::= ReturnStatement Semicolon_abbrev
 *</b>
 */
public class Statement_abbrev5 extends Ast implements IStatement_abbrev
{
    private IReturnStatement _ReturnStatement;
    private ISemicolon_abbrev _Semicolon_abbrev;

    public IReturnStatement getReturnStatement() { return _ReturnStatement; }
    /**
     * The value returned by <b>getSemicolon_abbrev</b> may be <b>null</b>
     */
    public ISemicolon_abbrev getSemicolon_abbrev() { return _Semicolon_abbrev; }

    public Statement_abbrev5(IToken leftIToken, IToken rightIToken,
                             IReturnStatement _ReturnStatement,
                             ISemicolon_abbrev _Semicolon_abbrev)
    {
        super(leftIToken, rightIToken);

        this._ReturnStatement = _ReturnStatement;
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
        if (! (o instanceof Statement_abbrev5)) return false;
        Statement_abbrev5 other = (Statement_abbrev5) o;
        if (! _ReturnStatement.equals(other._ReturnStatement)) return false;
        if (_Semicolon_abbrev == null)
            if (other._Semicolon_abbrev != null) return false;
            else; // continue
        else if (! _Semicolon_abbrev.equals(other._Semicolon_abbrev)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ReturnStatement.hashCode());
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
            _ReturnStatement.accept(v);
            if (_Semicolon_abbrev != null) _Semicolon_abbrev.accept(v);
        }
        v.endVisit(this);
    }
}


