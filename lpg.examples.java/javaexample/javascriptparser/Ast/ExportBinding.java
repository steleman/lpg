package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 381:  ExportBinding ::= FunctionName
 *</em>
 *<p>
 *<b>
 *<li>Rule 382:  ExportBinding ::= FunctionName = FunctionName
 *</b>
 */
public class ExportBinding extends Ast implements IExportBinding
{
    private IFunctionName _FunctionName;
    private AstToken _EQUAL;
    private IFunctionName _FunctionName3;

    public IFunctionName getFunctionName() { return _FunctionName; }
    public AstToken getEQUAL() { return _EQUAL; }
    public IFunctionName getFunctionName3() { return _FunctionName3; }

    public ExportBinding(IToken leftIToken, IToken rightIToken,
                         IFunctionName _FunctionName,
                         AstToken _EQUAL,
                         IFunctionName _FunctionName3)
    {
        super(leftIToken, rightIToken);

        this._FunctionName = _FunctionName;
        this._EQUAL = _EQUAL;
        this._FunctionName3 = _FunctionName3;
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
        if (! (o instanceof ExportBinding)) return false;
        ExportBinding other = (ExportBinding) o;
        if (! _FunctionName.equals(other._FunctionName)) return false;
        if (! _EQUAL.equals(other._EQUAL)) return false;
        if (! _FunctionName3.equals(other._FunctionName3)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_FunctionName.hashCode());
        hash = hash * 31 + (_EQUAL.hashCode());
        hash = hash * 31 + (_FunctionName3.hashCode());
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
            _FunctionName.accept(v);
            _EQUAL.accept(v);
            _FunctionName3.accept(v);
        }
        v.endVisit(this);
    }
}


