package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 67:  FullNewSubexpression ::= FullNewSubexpression PropertyOperator
 *</b>
 */
public class FullNewSubexpression0 extends Ast implements IFullNewSubexpression
{
    private IFullNewSubexpression _FullNewSubexpression;
    private IPropertyOperator _PropertyOperator;

    public IFullNewSubexpression getFullNewSubexpression() { return _FullNewSubexpression; }
    public IPropertyOperator getPropertyOperator() { return _PropertyOperator; }

    public FullNewSubexpression0(IToken leftIToken, IToken rightIToken,
                                 IFullNewSubexpression _FullNewSubexpression,
                                 IPropertyOperator _PropertyOperator)
    {
        super(leftIToken, rightIToken);

        this._FullNewSubexpression = _FullNewSubexpression;
        this._PropertyOperator = _PropertyOperator;
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
        if (! (o instanceof FullNewSubexpression0)) return false;
        FullNewSubexpression0 other = (FullNewSubexpression0) o;
        if (! _FullNewSubexpression.equals(other._FullNewSubexpression)) return false;
        if (! _PropertyOperator.equals(other._PropertyOperator)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_FullNewSubexpression.hashCode());
        hash = hash * 31 + (_PropertyOperator.hashCode());
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
            _FullNewSubexpression.accept(v);
            _PropertyOperator.accept(v);
        }
        v.endVisit(this);
    }
}


