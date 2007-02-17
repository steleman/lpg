package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 375:  PragmaArgument ::= - Number
 *</b>
 */
public class PragmaArgument3 extends Ast implements IPragmaArgument
{
    private AstToken _MINUS;
    private AstToken _Number;

    public AstToken getMINUS() { return _MINUS; }
    public AstToken getNumber() { return _Number; }

    public PragmaArgument3(IToken leftIToken, IToken rightIToken,
                           AstToken _MINUS,
                           AstToken _Number)
    {
        super(leftIToken, rightIToken);

        this._MINUS = _MINUS;
        this._Number = _Number;
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
        if (! (o instanceof PragmaArgument3)) return false;
        PragmaArgument3 other = (PragmaArgument3) o;
        if (! _MINUS.equals(other._MINUS)) return false;
        if (! _Number.equals(other._Number)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_MINUS.hashCode());
        hash = hash * 31 + (_Number.hashCode());
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
            _MINUS.accept(v);
            _Number.accept(v);
        }
        v.endVisit(this);
    }
}


