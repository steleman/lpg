package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 309:  BreakStatement ::= BREAK no_line_break$ Identifier
 *</b>
 */
public class BreakStatement1 extends Ast implements IBreakStatement
{
    private AstToken _BREAK;
    private IIdentifier _Identifier;

    public AstToken getBREAK() { return _BREAK; }
    public IIdentifier getIdentifier() { return _Identifier; }

    public BreakStatement1(IToken leftIToken, IToken rightIToken,
                           AstToken _BREAK,
                           IIdentifier _Identifier)
    {
        super(leftIToken, rightIToken);

        this._BREAK = _BREAK;
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
        if (! (o instanceof BreakStatement1)) return false;
        BreakStatement1 other = (BreakStatement1) o;
        if (! _BREAK.equals(other._BREAK)) return false;
        if (! _Identifier.equals(other._Identifier)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_BREAK.hashCode());
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
            _BREAK.accept(v);
            _Identifier.accept(v);
        }
        v.endVisit(this);
    }
}


