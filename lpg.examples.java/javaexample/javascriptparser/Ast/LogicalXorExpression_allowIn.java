package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 148:  LogicalXorExpression_allowIn ::= LogicalAndExpression_allowIn
 *</em>
 *<p>
 *<b>
 *<li>Rule 149:  LogicalXorExpression_allowIn ::= LogicalXorExpression_allowIn ^^ LogicalAndExpression_allowIn
 *</b>
 */
public class LogicalXorExpression_allowIn extends Ast implements ILogicalXorExpression_allowIn
{
    private ILogicalXorExpression_allowIn _LogicalXorExpression_allowIn;
    private AstToken _XOR_XOR;
    private ILogicalAndExpression_allowIn _LogicalAndExpression_allowIn;

    public ILogicalXorExpression_allowIn getLogicalXorExpression_allowIn() { return _LogicalXorExpression_allowIn; }
    public AstToken getXOR_XOR() { return _XOR_XOR; }
    public ILogicalAndExpression_allowIn getLogicalAndExpression_allowIn() { return _LogicalAndExpression_allowIn; }

    public LogicalXorExpression_allowIn(IToken leftIToken, IToken rightIToken,
                                        ILogicalXorExpression_allowIn _LogicalXorExpression_allowIn,
                                        AstToken _XOR_XOR,
                                        ILogicalAndExpression_allowIn _LogicalAndExpression_allowIn)
    {
        super(leftIToken, rightIToken);

        this._LogicalXorExpression_allowIn = _LogicalXorExpression_allowIn;
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
        if (! (o instanceof LogicalXorExpression_allowIn)) return false;
        LogicalXorExpression_allowIn other = (LogicalXorExpression_allowIn) o;
        if (! _LogicalXorExpression_allowIn.equals(other._LogicalXorExpression_allowIn)) return false;
        if (! _XOR_XOR.equals(other._XOR_XOR)) return false;
        if (! _LogicalAndExpression_allowIn.equals(other._LogicalAndExpression_allowIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_LogicalXorExpression_allowIn.hashCode());
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
            _LogicalXorExpression_allowIn.accept(v);
            _XOR_XOR.accept(v);
            _LogicalAndExpression_allowIn.accept(v);
        }
        v.endVisit(this);
    }
}


