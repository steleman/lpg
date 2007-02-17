package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 152:  LogicalOrExpression_allowIn ::= LogicalXorExpression_allowIn
 *</em>
 *<p>
 *<b>
 *<li>Rule 153:  LogicalOrExpression_allowIn ::= LogicalOrExpression_allowIn || LogicalXorExpression_allowIn
 *</b>
 */
public class LogicalOrExpression_allowIn extends Ast implements ILogicalOrExpression_allowIn
{
    private ILogicalOrExpression_allowIn _LogicalOrExpression_allowIn;
    private AstToken _OR_OR;
    private ILogicalXorExpression_allowIn _LogicalXorExpression_allowIn;

    public ILogicalOrExpression_allowIn getLogicalOrExpression_allowIn() { return _LogicalOrExpression_allowIn; }
    public AstToken getOR_OR() { return _OR_OR; }
    public ILogicalXorExpression_allowIn getLogicalXorExpression_allowIn() { return _LogicalXorExpression_allowIn; }

    public LogicalOrExpression_allowIn(IToken leftIToken, IToken rightIToken,
                                       ILogicalOrExpression_allowIn _LogicalOrExpression_allowIn,
                                       AstToken _OR_OR,
                                       ILogicalXorExpression_allowIn _LogicalXorExpression_allowIn)
    {
        super(leftIToken, rightIToken);

        this._LogicalOrExpression_allowIn = _LogicalOrExpression_allowIn;
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
        if (! (o instanceof LogicalOrExpression_allowIn)) return false;
        LogicalOrExpression_allowIn other = (LogicalOrExpression_allowIn) o;
        if (! _LogicalOrExpression_allowIn.equals(other._LogicalOrExpression_allowIn)) return false;
        if (! _OR_OR.equals(other._OR_OR)) return false;
        if (! _LogicalXorExpression_allowIn.equals(other._LogicalXorExpression_allowIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_LogicalOrExpression_allowIn.hashCode());
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
            _LogicalOrExpression_allowIn.accept(v);
            _OR_OR.accept(v);
            _LogicalXorExpression_allowIn.accept(v);
        }
        v.endVisit(this);
    }
}


