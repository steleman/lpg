package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 262:  SuperStatement ::= SUPER Arguments
 *</b>
 */
public class SuperStatement extends Ast implements ISuperStatement
{
    private AstToken _SUPER;
    private IArguments _Arguments;

    public AstToken getSUPER() { return _SUPER; }
    public IArguments getArguments() { return _Arguments; }

    public SuperStatement(IToken leftIToken, IToken rightIToken,
                          AstToken _SUPER,
                          IArguments _Arguments)
    {
        super(leftIToken, rightIToken);

        this._SUPER = _SUPER;
        this._Arguments = _Arguments;
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
        if (! (o instanceof SuperStatement)) return false;
        SuperStatement other = (SuperStatement) o;
        if (! _SUPER.equals(other._SUPER)) return false;
        if (! _Arguments.equals(other._Arguments)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_SUPER.hashCode());
        hash = hash * 31 + (_Arguments.hashCode());
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
            _SUPER.accept(v);
            _Arguments.accept(v);
        }
        v.endVisit(this);
    }
}


