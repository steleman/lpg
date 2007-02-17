package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 269:  IfStatement_full ::= IF ParenListExpression Substatement_full
 *</b>
 */
public class IfStatement_full0 extends Ast implements IIfStatement_full
{
    private AstToken _IF;
    private IParenListExpression _ParenListExpression;
    private ISubstatement_full _Substatement_full;

    public AstToken getIF() { return _IF; }
    public IParenListExpression getParenListExpression() { return _ParenListExpression; }
    public ISubstatement_full getSubstatement_full() { return _Substatement_full; }

    public IfStatement_full0(IToken leftIToken, IToken rightIToken,
                             AstToken _IF,
                             IParenListExpression _ParenListExpression,
                             ISubstatement_full _Substatement_full)
    {
        super(leftIToken, rightIToken);

        this._IF = _IF;
        this._ParenListExpression = _ParenListExpression;
        this._Substatement_full = _Substatement_full;
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
        if (! (o instanceof IfStatement_full0)) return false;
        IfStatement_full0 other = (IfStatement_full0) o;
        if (! _IF.equals(other._IF)) return false;
        if (! _ParenListExpression.equals(other._ParenListExpression)) return false;
        if (! _Substatement_full.equals(other._Substatement_full)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_IF.hashCode());
        hash = hash * 31 + (_ParenListExpression.hashCode());
        hash = hash * 31 + (_Substatement_full.hashCode());
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
            _IF.accept(v);
            _ParenListExpression.accept(v);
            _Substatement_full.accept(v);
        }
        v.endVisit(this);
    }
}


