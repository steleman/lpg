package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 412:  FunctionName ::= SET no_line_break$ Identifier
 *</b>
 */
public class FunctionName1 extends Ast implements IFunctionName
{
    private AstToken _SET;
    private IIdentifier _Identifier;

    public AstToken getSET() { return _SET; }
    public IIdentifier getIdentifier() { return _Identifier; }

    public FunctionName1(IToken leftIToken, IToken rightIToken,
                         AstToken _SET,
                         IIdentifier _Identifier)
    {
        super(leftIToken, rightIToken);

        this._SET = _SET;
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
        if (! (o instanceof FunctionName1)) return false;
        FunctionName1 other = (FunctionName1) o;
        if (! _SET.equals(other._SET)) return false;
        if (! _Identifier.equals(other._Identifier)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_SET.hashCode());
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
            _SET.accept(v);
            _Identifier.accept(v);
        }
        v.endVisit(this);
    }
}


