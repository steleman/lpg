package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 512:  ES_LogicalXorExpression_allowIn ::= ES_LogicalAndExpression_allowIn
 *</em>
 *<p>
 *<b>
 *<li>Rule 513:  ES_LogicalXorExpression_allowIn ::= ES_LogicalXorExpression_allowIn ^^ LogicalAndExpression_allowIn
 *</b>
 */
public class ES_LogicalXorExpression_allowIn extends Ast implements IES_LogicalXorExpression_allowIn
{
    private IES_LogicalXorExpression_allowIn _ES_LogicalXorExpression_allowIn;
    private AstToken _XOR_XOR;
    private ILogicalAndExpression_allowIn _LogicalAndExpression_allowIn;

    public IES_LogicalXorExpression_allowIn getES_LogicalXorExpression_allowIn() { return _ES_LogicalXorExpression_allowIn; }
    public AstToken getXOR_XOR() { return _XOR_XOR; }
    public ILogicalAndExpression_allowIn getLogicalAndExpression_allowIn() { return _LogicalAndExpression_allowIn; }

    public ES_LogicalXorExpression_allowIn(IToken leftIToken, IToken rightIToken,
                                           IES_LogicalXorExpression_allowIn _ES_LogicalXorExpression_allowIn,
                                           AstToken _XOR_XOR,
                                           ILogicalAndExpression_allowIn _LogicalAndExpression_allowIn)
    {
        super(leftIToken, rightIToken);

        this._ES_LogicalXorExpression_allowIn = _ES_LogicalXorExpression_allowIn;
        this._XOR_XOR = _XOR_XOR;
        this._LogicalAndExpression_allowIn = _LogicalAndExpression_allowIn;
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
        if (! (o instanceof ES_LogicalXorExpression_allowIn)) return false;
        ES_LogicalXorExpression_allowIn other = (ES_LogicalXorExpression_allowIn) o;
        if (! _ES_LogicalXorExpression_allowIn.equals(other._ES_LogicalXorExpression_allowIn)) return false;
        if (! _XOR_XOR.equals(other._XOR_XOR)) return false;
        if (! _LogicalAndExpression_allowIn.equals(other._LogicalAndExpression_allowIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_ES_LogicalXorExpression_allowIn.hashCode());
        hash = hash * 31 + (_XOR_XOR.hashCode());
        hash = hash * 31 + (_LogicalAndExpression_allowIn.hashCode());
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
            _ES_LogicalXorExpression_allowIn.accept(v);
            _XOR_XOR.accept(v);
            _LogicalAndExpression_allowIn.accept(v);
        }
        v.endVisit(this);
    }
}


