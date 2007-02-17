package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 69:  ShortNewExpression ::= NEW ShortNewSubexpression
 *</b>
 */
public class ShortNewExpression extends Ast implements IShortNewExpression
{
    private AstToken _NEW;
    private IShortNewSubexpression _ShortNewSubexpression;

    public AstToken getNEW() { return _NEW; }
    public IShortNewSubexpression getShortNewSubexpression() { return _ShortNewSubexpression; }

    public ShortNewExpression(IToken leftIToken, IToken rightIToken,
                              AstToken _NEW,
                              IShortNewSubexpression _ShortNewSubexpression)
    {
        super(leftIToken, rightIToken);

        this._NEW = _NEW;
        this._ShortNewSubexpression = _ShortNewSubexpression;
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
        if (! (o instanceof ShortNewExpression)) return false;
        ShortNewExpression other = (ShortNewExpression) o;
        if (! _NEW.equals(other._NEW)) return false;
        if (! _ShortNewSubexpression.equals(other._ShortNewSubexpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_NEW.hashCode());
        hash = hash * 31 + (_ShortNewSubexpression.hashCode());
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
            _NEW.accept(v);
            _ShortNewSubexpression.accept(v);
        }
        v.endVisit(this);
    }
}


