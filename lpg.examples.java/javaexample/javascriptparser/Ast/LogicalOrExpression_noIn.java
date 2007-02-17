package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 154:  LogicalOrExpression_noIn ::= LogicalXorExpression_noIn
 *</em>
 *<p>
 *<b>
 *<li>Rule 155:  LogicalOrExpression_noIn ::= LogicalOrExpression_noIn || LogicalXorExpression_noIn
 *</b>
 */
public class LogicalOrExpression_noIn extends Ast implements ILogicalOrExpression_noIn
{
    private ILogicalOrExpression_noIn _LogicalOrExpression_noIn;
    private AstToken _OR_OR;
    private ILogicalXorExpression_noIn _LogicalXorExpression_noIn;

    public ILogicalOrExpression_noIn getLogicalOrExpression_noIn() { return _LogicalOrExpression_noIn; }
    public AstToken getOR_OR() { return _OR_OR; }
    public ILogicalXorExpression_noIn getLogicalXorExpression_noIn() { return _LogicalXorExpression_noIn; }

    public LogicalOrExpression_noIn(IToken leftIToken, IToken rightIToken,
                                    ILogicalOrExpression_noIn _LogicalOrExpression_noIn,
                                    AstToken _OR_OR,
                                    ILogicalXorExpression_noIn _LogicalXorExpression_noIn)
    {
        super(leftIToken, rightIToken);

        this._LogicalOrExpression_noIn = _LogicalOrExpression_noIn;
        this._OR_OR = _OR_OR;
        this._LogicalXorExpression_noIn = _LogicalXorExpression_noIn;
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
        if (! (o instanceof LogicalOrExpression_noIn)) return false;
        LogicalOrExpression_noIn other = (LogicalOrExpression_noIn) o;
        if (! _LogicalOrExpression_noIn.equals(other._LogicalOrExpression_noIn)) return false;
        if (! _OR_OR.equals(other._OR_OR)) return false;
        if (! _LogicalXorExpression_noIn.equals(other._LogicalXorExpression_noIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_LogicalOrExpression_noIn.hashCode());
        hash = hash * 31 + (_OR_OR.hashCode());
        hash = hash * 31 + (_LogicalXorExpression_noIn.hashCode());
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
            _LogicalOrExpression_noIn.accept(v);
            _OR_OR.accept(v);
            _LogicalXorExpression_noIn.accept(v);
        }
        v.endVisit(this);
    }
}


