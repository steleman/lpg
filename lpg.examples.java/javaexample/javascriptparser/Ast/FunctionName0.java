package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 411:  FunctionName ::= GET no_line_break$ Identifier
 *</b>
 */
public class FunctionName0 extends Ast implements IFunctionName
{
    private AstToken _GET;
    private IIdentifier _Identifier;

    public AstToken getGET() { return _GET; }
    public IIdentifier getIdentifier() { return _Identifier; }

    public FunctionName0(IToken leftIToken, IToken rightIToken,
                         AstToken _GET,
                         IIdentifier _Identifier)
    {
        super(leftIToken, rightIToken);

        this._GET = _GET;
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
        if (! (o instanceof FunctionName0)) return false;
        FunctionName0 other = (FunctionName0) o;
        if (! _GET.equals(other._GET)) return false;
        if (! _Identifier.equals(other._Identifier)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_GET.hashCode());
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
            _GET.accept(v);
            _Identifier.accept(v);
        }
        v.endVisit(this);
    }
}


