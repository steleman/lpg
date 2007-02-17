package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 514:  ES_LogicalOrExpression_allowIn ::= ES_LogicalXorExpression_allowIn
 *</em>
 *<p>
 *<b>
 *<li>Rule 515:  ES_LogicalOrExpression_allowIn ::= ES_LogicalOrExpression_allowIn || LogicalXorExpression_allowIn
 *</b>
 */
public class ES_LogicalOrExpression_allowIn extends Ast implements IES_LogicalOrExpression_allowIn
{
    private IES_LogicalOrExpression_allowIn _ES_LogicalOrExpression_allowIn;
    private AstToken _OR_OR;
    private ILogicalXorExpression_allowIn _LogicalXorExpression_allowIn;

    public IES_LogicalOrExpression_allowIn getES_LogicalOrExpression_allowIn() { return _ES_LogicalOrExpression_allowIn; }
    public AstToken getOR_OR() { return _OR_OR; }
    public ILogicalXorExpression_allowIn getLogicalXorExpression_allowIn() { return _LogicalXorExpression_allowIn; }

    public ES_LogicalOrExpression_allowIn(IToken leftIToken, IToken rightIToken,
                                          IES_LogicalOrExpression_allowIn _ES_LogicalOrExpression_allowIn,
                                          AstToken _OR_OR,
                                          ILogicalXorExpression_allowIn _LogicalXorExpression_allowIn)
    {
        super(leftIToken, rightIToken);

        this._ES_LogicalOrExpression_allowIn = _ES_LogicalOrExpression_allowIn;
        this._OR_OR = _OR_OR;
        this._LogicalXorExpression_allowIn = _LogicalXorExpression_allowIn;
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
        if (! (o instanceof ES_LogicalOrExpression_allowIn)) return false;
        ES_LogicalOrExpression_allowIn other = (ES_LogicalOrExpression_allowIn) o;
        if (! _ES_LogicalOrExpression_allowIn.equals(other._ES_LogicalOrExpression_allowIn)) return false;
        if (! _OR_OR.equals(other._OR_OR)) return false;
        if (! _LogicalXorExpression_allowIn.equals(other._LogicalXorExpression_allowIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ES_LogicalOrExpression_allowIn.hashCode());
        hash = hash * 31 + (_OR_OR.hashCode());
        hash = hash * 31 + (_LogicalXorExpression_allowIn.hashCode());
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
            _ES_LogicalOrExpression_allowIn.accept(v);
            _OR_OR.accept(v);
            _LogicalXorExpression_allowIn.accept(v);
        }
        v.endVisit(this);
    }
}


