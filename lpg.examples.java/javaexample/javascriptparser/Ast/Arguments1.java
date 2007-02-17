package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 79:  Arguments ::= ( ExpressionsWithRest )
 *</b>
 */
public class Arguments1 extends Ast implements IArguments
{
    private AstToken _LPAREN;
    private IExpressionsWithRest _ExpressionsWithRest;
    private AstToken _RPAREN;

    public AstToken getLPAREN() { return _LPAREN; }
    public IExpressionsWithRest getExpressionsWithRest() { return _ExpressionsWithRest; }
    public AstToken getRPAREN() { return _RPAREN; }

    public Arguments1(IToken leftIToken, IToken rightIToken,
                      AstToken _LPAREN,
                      IExpressionsWithRest _ExpressionsWithRest,
                      AstToken _RPAREN)
    {
        super(leftIToken, rightIToken);

        this._LPAREN = _LPAREN;
        this._ExpressionsWithRest = _ExpressionsWithRest;
        this._RPAREN = _RPAREN;
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
        if (! (o instanceof Arguments1)) return false;
        Arguments1 other = (Arguments1) o;
        if (! _LPAREN.equals(other._LPAREN)) return false;
        if (! _ExpressionsWithRest.equals(other._ExpressionsWithRest)) return false;
        if (! _RPAREN.equals(other._RPAREN)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_LPAREN.hashCode());
        hash = hash * 31 + (_ExpressionsWithRest.hashCode());
        hash = hash * 31 + (_RPAREN.hashCode());
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
            _LPAREN.accept(v);
            _ExpressionsWithRest.accept(v);
            _RPAREN.accept(v);
        }
        v.endVisit(this);
    }
}


