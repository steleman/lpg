package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 146:  LogicalAndExpression_noIn ::= BitwiseOrExpression_noIn
 *</em>
 *<p>
 *<b>
 *<li>Rule 147:  LogicalAndExpression_noIn ::= LogicalAndExpression_noIn && BitwiseOrExpression_noIn
 *</b>
 */
public class LogicalAndExpression_noIn extends Ast implements ILogicalAndExpression_noIn
{
    private ILogicalAndExpression_noIn _LogicalAndExpression_noIn;
    private AstToken _AND_AND;
    private IBitwiseOrExpression_noIn _BitwiseOrExpression_noIn;

    public ILogicalAndExpression_noIn getLogicalAndExpression_noIn() { return _LogicalAndExpression_noIn; }
    public AstToken getAND_AND() { return _AND_AND; }
    public IBitwiseOrExpression_noIn getBitwiseOrExpression_noIn() { return _BitwiseOrExpression_noIn; }

    public LogicalAndExpression_noIn(IToken leftIToken, IToken rightIToken,
                                     ILogicalAndExpression_noIn _LogicalAndExpression_noIn,
                                     AstToken _AND_AND,
                                     IBitwiseOrExpression_noIn _BitwiseOrExpression_noIn)
    {
        super(leftIToken, rightIToken);

        this._LogicalAndExpression_noIn = _LogicalAndExpression_noIn;
        this._AND_AND = _AND_AND;
        this._BitwiseOrExpression_noIn = _BitwiseOrExpression_noIn;
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
        if (! (o instanceof LogicalAndExpression_noIn)) return false;
        LogicalAndExpression_noIn other = (LogicalAndExpression_noIn) o;
        if (! _LogicalAndExpression_noIn.equals(other._LogicalAndExpression_noIn)) return false;
        if (! _AND_AND.equals(other._AND_AND)) return false;
        if (! _BitwiseOrExpression_noIn.equals(other._BitwiseOrExpression_noIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_LogicalAndExpression_noIn.hashCode());
        hash = hash * 31 + (_AND_AND.hashCode());
        hash = hash * 31 + (_BitwiseOrExpression_noIn.hashCode());
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
            _LogicalAndExpression_noIn.accept(v);
            _AND_AND.accept(v);
            _BitwiseOrExpression_noIn.accept(v);
        }
        v.endVisit(this);
    }
}


