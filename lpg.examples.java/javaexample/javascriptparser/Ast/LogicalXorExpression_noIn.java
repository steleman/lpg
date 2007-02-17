package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 150:  LogicalXorExpression_noIn ::= LogicalAndExpression_noIn
 *</em>
 *<p>
 *<b>
 *<li>Rule 151:  LogicalXorExpression_noIn ::= LogicalXorExpression_noIn ^^ LogicalAndExpression_noIn
 *</b>
 */
public class LogicalXorExpression_noIn extends Ast implements ILogicalXorExpression_noIn
{
    private ILogicalXorExpression_noIn _LogicalXorExpression_noIn;
    private AstToken _XOR_XOR;
    private ILogicalAndExpression_noIn _LogicalAndExpression_noIn;

    public ILogicalXorExpression_noIn getLogicalXorExpression_noIn() { return _LogicalXorExpression_noIn; }
    public AstToken getXOR_XOR() { return _XOR_XOR; }
    public ILogicalAndExpression_noIn getLogicalAndExpression_noIn() { return _LogicalAndExpression_noIn; }

    public LogicalXorExpression_noIn(IToken leftIToken, IToken rightIToken,
                                     ILogicalXorExpression_noIn _LogicalXorExpression_noIn,
                                     AstToken _XOR_XOR,
                                     ILogicalAndExpression_noIn _LogicalAndExpression_noIn)
    {
        super(leftIToken, rightIToken);

        this._LogicalXorExpression_noIn = _LogicalXorExpression_noIn;
        this._XOR_XOR = _XOR_XOR;
        this._LogicalAndExpression_noIn = _LogicalAndExpression_noIn;
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
        if (! (o instanceof LogicalXorExpression_noIn)) return false;
        LogicalXorExpression_noIn other = (LogicalXorExpression_noIn) o;
        if (! _LogicalXorExpression_noIn.equals(other._LogicalXorExpression_noIn)) return false;
        if (! _XOR_XOR.equals(other._XOR_XOR)) return false;
        if (! _LogicalAndExpression_noIn.equals(other._LogicalAndExpression_noIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_LogicalXorExpression_noIn.hashCode());
        hash = hash * 31 + (_XOR_XOR.hashCode());
        hash = hash * 31 + (_LogicalAndExpression_noIn.hashCode());
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
            _LogicalXorExpression_noIn.accept(v);
            _XOR_XOR.accept(v);
            _LogicalAndExpression_noIn.accept(v);
        }
        v.endVisit(this);
    }
}


