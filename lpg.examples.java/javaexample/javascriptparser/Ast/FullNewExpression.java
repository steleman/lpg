package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 63:  FullNewExpression ::= NEW FullNewSubexpression Arguments
 *</b>
 */
public class FullNewExpression extends Ast implements IFullNewExpression
{
    private AstToken _NEW;
    private IFullNewSubexpression _FullNewSubexpression;
    private IArguments _Arguments;

    public AstToken getNEW() { return _NEW; }
    public IFullNewSubexpression getFullNewSubexpression() { return _FullNewSubexpression; }
    public IArguments getArguments() { return _Arguments; }

    public FullNewExpression(IToken leftIToken, IToken rightIToken,
                             AstToken _NEW,
                             IFullNewSubexpression _FullNewSubexpression,
                             IArguments _Arguments)
    {
        super(leftIToken, rightIToken);

        this._NEW = _NEW;
        this._FullNewSubexpression = _FullNewSubexpression;
        this._Arguments = _Arguments;
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
        if (! (o instanceof FullNewExpression)) return false;
        FullNewExpression other = (FullNewExpression) o;
        if (! _NEW.equals(other._NEW)) return false;
        if (! _FullNewSubexpression.equals(other._FullNewSubexpression)) return false;
        if (! _Arguments.equals(other._Arguments)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_NEW.hashCode());
        hash = hash * 31 + (_FullNewSubexpression.hashCode());
        hash = hash * 31 + (_Arguments.hashCode());
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
            _FullNewSubexpression.accept(v);
            _Arguments.accept(v);
        }
        v.endVisit(this);
    }
}


