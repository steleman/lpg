package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 312:  ThrowStatement ::= THROW no_line_break$ ListExpression_allowIn
 *</b>
 */
public class ThrowStatement extends Ast implements IThrowStatement
{
    private AstToken _THROW;
    private IListExpression_allowIn _ListExpression_allowIn;

    public AstToken getTHROW() { return _THROW; }
    public IListExpression_allowIn getListExpression_allowIn() { return _ListExpression_allowIn; }

    public ThrowStatement(IToken leftIToken, IToken rightIToken,
                          AstToken _THROW,
                          IListExpression_allowIn _ListExpression_allowIn)
    {
        super(leftIToken, rightIToken);

        this._THROW = _THROW;
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
        if (! (o instanceof ThrowStatement)) return false;
        ThrowStatement other = (ThrowStatement) o;
        if (! _THROW.equals(other._THROW)) return false;
        if (! _ListExpression_allowIn.equals(other._ListExpression_allowIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_THROW.hashCode());
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
            _THROW.accept(v);
            _ListExpression_allowIn.accept(v);
        }
        v.endVisit(this);
    }
}


