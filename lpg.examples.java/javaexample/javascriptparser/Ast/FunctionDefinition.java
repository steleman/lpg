package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 409:  FunctionDefinition ::= FUNCTION FunctionName FunctionCommon
 *</b>
 */
public class FunctionDefinition extends Ast implements IFunctionDefinition
{
    private AstToken _FUNCTION;
    private IFunctionName _FunctionName;
    private FunctionCommon _FunctionCommon;

    public AstToken getFUNCTION() { return _FUNCTION; }
    public IFunctionName getFunctionName() { return _FunctionName; }
    public FunctionCommon getFunctionCommon() { return _FunctionCommon; }

    public FunctionDefinition(IToken leftIToken, IToken rightIToken,
                              AstToken _FUNCTION,
                              IFunctionName _FunctionName,
                              FunctionCommon _FunctionCommon)
    {
        super(leftIToken, rightIToken);

        this._FUNCTION = _FUNCTION;
        this._FunctionName = _FunctionName;
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
        if (! (o instanceof FunctionDefinition)) return false;
        FunctionDefinition other = (FunctionDefinition) o;
        if (! _FUNCTION.equals(other._FUNCTION)) return false;
        if (! _FunctionName.equals(other._FunctionName)) return false;
        if (! _FunctionCommon.equals(other._FunctionCommon)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_FUNCTION.hashCode());
        hash = hash * 31 + (_FunctionName.hashCode());
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
            _FunctionName.accept(v);
            _FunctionCommon.accept(v);
        }
        v.endVisit(this);
    }
}


