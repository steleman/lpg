package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 223:  Statement_full ::= SuperStatement Semicolon_full
 *</b>
 */
public class Statement_full1 extends Ast implements IStatement_full
{
    private SuperStatement _SuperStatement;
    private ISemicolon_full _Semicolon_full;

    public SuperStatement getSuperStatement() { return _SuperStatement; }
    public ISemicolon_full getSemicolon_full() { return _Semicolon_full; }

    public Statement_full1(IToken leftIToken, IToken rightIToken,
                           SuperStatement _SuperStatement,
                           ISemicolon_full _Semicolon_full)
    {
        super(leftIToken, rightIToken);

        this._SuperStatement = _SuperStatement;
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
        if (! (o instanceof Statement_full1)) return false;
        Statement_full1 other = (Statement_full1) o;
        if (! _SuperStatement.equals(other._SuperStatement)) return false;
        if (! _Semicolon_full.equals(other._Semicolon_full)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_SuperStatement.hashCode());
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
            _SuperStatement.accept(v);
            _Semicolon_full.accept(v);
        }
        v.endVisit(this);
    }
}


