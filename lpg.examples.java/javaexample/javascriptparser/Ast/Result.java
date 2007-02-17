package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 428:  Result ::= $Empty
 *</em>
 *<p>
 *<b>
 *<li>Rule 429:  Result ::= : TypeExpression_allowIn
 *</b>
 */
public class Result extends Ast implements IResult
{
    private AstToken _COLON;
    private ITypeExpression_allowIn _TypeExpression_allowIn;

    public AstToken getCOLON() { return _COLON; }
    public ITypeExpression_allowIn getTypeExpression_allowIn() { return _TypeExpression_allowIn; }

    public Result(IToken leftIToken, IToken rightIToken,
                  AstToken _COLON,
                  ITypeExpression_allowIn _TypeExpression_allowIn)
    {
        super(leftIToken, rightIToken);

        this._COLON = _COLON;
        this._TypeExpression_allowIn = _TypeExpression_allowIn;
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
        if (! (o instanceof Result)) return false;
        Result other = (Result) o;
        if (! _COLON.equals(other._COLON)) return false;
        if (! _TypeExpression_allowIn.equals(other._TypeExpression_allowIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_COLON.hashCode());
        hash = hash * 31 + (_TypeExpression_allowIn.hashCode());
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
            _COLON.accept(v);
            _TypeExpression_allowIn.accept(v);
        }
        v.endVisit(this);
    }
}


