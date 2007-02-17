package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 361:  UseDirective ::= USE NAMESPACE ParenListExpression
 *</b>
 */
public class UseDirective extends Ast implements IUseDirective
{
    private AstToken _USE;
    private AstToken _NAMESPACE;
    private IParenListExpression _ParenListExpression;

    public AstToken getUSE() { return _USE; }
    public AstToken getNAMESPACE() { return _NAMESPACE; }
    public IParenListExpression getParenListExpression() { return _ParenListExpression; }

    public UseDirective(IToken leftIToken, IToken rightIToken,
                        AstToken _USE,
                        AstToken _NAMESPACE,
                        IParenListExpression _ParenListExpression)
    {
        super(leftIToken, rightIToken);

        this._USE = _USE;
        this._NAMESPACE = _NAMESPACE;
        this._ParenListExpression = _ParenListExpression;
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
        if (! (o instanceof UseDirective)) return false;
        UseDirective other = (UseDirective) o;
        if (! _USE.equals(other._USE)) return false;
        if (! _NAMESPACE.equals(other._NAMESPACE)) return false;
        if (! _ParenListExpression.equals(other._ParenListExpression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_USE.hashCode());
        hash = hash * 31 + (_NAMESPACE.hashCode());
        hash = hash * 31 + (_ParenListExpression.hashCode());
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
            _USE.accept(v);
            _NAMESPACE.accept(v);
            _ParenListExpression.accept(v);
        }
        v.endVisit(this);
    }
}


