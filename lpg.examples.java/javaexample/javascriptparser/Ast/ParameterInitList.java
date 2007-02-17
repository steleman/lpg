package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 419:  ParameterInitList ::= ParameterInit
 *</em>
 *<p>
 *<b>
 *<li>Rule 420:  ParameterInitList ::= ParameterInitList , ParameterInit
 *</b>
 */
public class ParameterInitList extends Ast implements IParameterInitList
{
    private IParameterInitList _ParameterInitList;
    private AstToken _COMMA;
    private IParameterInit _ParameterInit;

    public IParameterInitList getParameterInitList() { return _ParameterInitList; }
    public AstToken getCOMMA() { return _COMMA; }
    public IParameterInit getParameterInit() { return _ParameterInit; }

    public ParameterInitList(IToken leftIToken, IToken rightIToken,
                             IParameterInitList _ParameterInitList,
                             AstToken _COMMA,
                             IParameterInit _ParameterInit)
    {
        super(leftIToken, rightIToken);

        this._ParameterInitList = _ParameterInitList;
        this._COMMA = _COMMA;
        this._ParameterInit = _ParameterInit;
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
        if (! (o instanceof ParameterInitList)) return false;
        ParameterInitList other = (ParameterInitList) o;
        if (! _ParameterInitList.equals(other._ParameterInitList)) return false;
        if (! _COMMA.equals(other._COMMA)) return false;
        if (! _ParameterInit.equals(other._ParameterInit)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ParameterInitList.hashCode());
        hash = hash * 31 + (_COMMA.hashCode());
        hash = hash * 31 + (_ParameterInit.hashCode());
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
            _ParameterInitList.accept(v);
            _COMMA.accept(v);
            _ParameterInit.accept(v);
        }
        v.endVisit(this);
    }
}


