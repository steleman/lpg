package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 307:  ContinueStatement ::= CONTINUE no_line_break$ Identifier
 *</b>
 */
public class ContinueStatement1 extends Ast implements IContinueStatement
{
    private AstToken _CONTINUE;
    private IIdentifier _Identifier;

    public AstToken getCONTINUE() { return _CONTINUE; }
    public IIdentifier getIdentifier() { return _Identifier; }

    public ContinueStatement1(IToken leftIToken, IToken rightIToken,
                              AstToken _CONTINUE,
                              IIdentifier _Identifier)
    {
        super(leftIToken, rightIToken);

        this._CONTINUE = _CONTINUE;
        this._Identifier = _Identifier;
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
        if (! (o instanceof ContinueStatement1)) return false;
        ContinueStatement1 other = (ContinueStatement1) o;
        if (! _CONTINUE.equals(other._CONTINUE)) return false;
        if (! _Identifier.equals(other._Identifier)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_CONTINUE.hashCode());
        hash = hash * 31 + (_Identifier.hashCode());
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
            _CONTINUE.accept(v);
            _Identifier.accept(v);
        }
        v.endVisit(this);
    }
}


