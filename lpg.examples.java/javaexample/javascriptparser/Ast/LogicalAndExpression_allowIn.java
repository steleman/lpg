package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 144:  LogicalAndExpression_allowIn ::= BitwiseOrExpression_allowIn
 *</em>
 *<p>
 *<b>
 *<li>Rule 145:  LogicalAndExpression_allowIn ::= LogicalAndExpression_allowIn && BitwiseOrExpression_allowIn
 *</b>
 */
public class LogicalAndExpression_allowIn extends Ast implements ILogicalAndExpression_allowIn
{
    private ILogicalAndExpression_allowIn _LogicalAndExpression_allowIn;
    private AstToken _AND_AND;
    private IBitwiseOrExpression_allowIn _BitwiseOrExpression_allowIn;

    public ILogicalAndExpression_allowIn getLogicalAndExpression_allowIn() { return _LogicalAndExpression_allowIn; }
    public AstToken getAND_AND() { return _AND_AND; }
    public IBitwiseOrExpression_allowIn getBitwiseOrExpression_allowIn() { return _BitwiseOrExpression_allowIn; }

    public LogicalAndExpression_allowIn(IToken leftIToken, IToken rightIToken,
                                        ILogicalAndExpression_allowIn _LogicalAndExpression_allowIn,
                                        AstToken _AND_AND,
                                        IBitwiseOrExpression_allowIn _BitwiseOrExpression_allowIn)
    {
        super(leftIToken, rightIToken);

        this._LogicalAndExpression_allowIn = _LogicalAndExpression_allowIn;
        this._AND_AND = _AND_AND;
        this._BitwiseOrExpression_allowIn = _BitwiseOrExpression_allowIn;
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
        if (! (o instanceof LogicalAndExpression_allowIn)) return false;
        LogicalAndExpression_allowIn other = (LogicalAndExpression_allowIn) o;
        if (! _LogicalAndExpression_allowIn.equals(other._LogicalAndExpression_allowIn)) return false;
        if (! _AND_AND.equals(other._AND_AND)) return false;
        if (! _BitwiseOrExpression_allowIn.equals(other._BitwiseOrExpression_allowIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_LogicalAndExpression_allowIn.hashCode());
        hash = hash * 31 + (_AND_AND.hashCode());
        hash = hash * 31 + (_BitwiseOrExpression_allowIn.hashCode());
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
            _LogicalAndExpression_allowIn.accept(v);
            _AND_AND.accept(v);
            _BitwiseOrExpression_allowIn.accept(v);
        }
        v.endVisit(this);
    }
}


