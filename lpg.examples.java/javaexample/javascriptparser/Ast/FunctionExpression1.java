package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 30:  FunctionExpression ::= FUNCTION Identifier FunctionCommon
 *</b>
 */
public class FunctionExpression1 extends Ast implements IFunctionExpression
{
    private AstToken _FUNCTION;
    private IIdentifier _Identifier;
    private FunctionCommon _FunctionCommon;

    public AstToken getFUNCTION() { return _FUNCTION; }
    public IIdentifier getIdentifier() { return _Identifier; }
    public FunctionCommon getFunctionCommon() { return _FunctionCommon; }

    public FunctionExpression1(IToken leftIToken, IToken rightIToken,
                               AstToken _FUNCTION,
                               IIdentifier _Identifier,
                               FunctionCommon _FunctionCommon)
    {
        super(leftIToken, rightIToken);

        this._FUNCTION = _FUNCTION;
        this._Identifier = _Identifier;
        this._FunctionCommon = _FunctionCommon;
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
        if (! (o instanceof FunctionExpression1)) return false;
        FunctionExpression1 other = (FunctionExpression1) o;
        if (! _FUNCTION.equals(other._FUNCTION)) return false;
        if (! _Identifier.equals(other._Identifier)) return false;
        if (! _FunctionCommon.equals(other._FunctionCommon)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_FUNCTION.hashCode());
        hash = hash * 31 + (_Identifier.hashCode());
        hash = hash * 31 + (_FunctionCommon.hashCode());
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
            _FUNCTION.accept(v);
            _Identifier.accept(v);
            _FunctionCommon.accept(v);
        }
        v.endVisit(this);
    }
}


