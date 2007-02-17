package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 311:  ReturnStatement ::= RETURN no_line_break$ ListExpression_allowIn
 *</b>
 */
public class ReturnStatement1 extends Ast implements IReturnStatement
{
    private AstToken _RETURN;
    private IListExpression_allowIn _ListExpression_allowIn;

    public AstToken getRETURN() { return _RETURN; }
    public IListExpression_allowIn getListExpression_allowIn() { return _ListExpression_allowIn; }

    public ReturnStatement1(IToken leftIToken, IToken rightIToken,
                            AstToken _RETURN,
                            IListExpression_allowIn _ListExpression_allowIn)
    {
        super(leftIToken, rightIToken);

        this._RETURN = _RETURN;
        this._ListExpression_allowIn = _ListExpression_allowIn;
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
        if (! (o instanceof ReturnStatement1)) return false;
        ReturnStatement1 other = (ReturnStatement1) o;
        if (! _RETURN.equals(other._RETURN)) return false;
        if (! _ListExpression_allowIn.equals(other._ListExpression_allowIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_RETURN.hashCode());
        hash = hash * 31 + (_ListExpression_allowIn.hashCode());
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
            _RETURN.accept(v);
            _ListExpression_allowIn.accept(v);
        }
        v.endVisit(this);
    }
}


