package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 431:  Inheritance ::= $Empty
 *</em>
 *<p>
 *<b>
 *<li>Rule 432:  Inheritance ::= EXTENDS TypeExpression_allowIn
 *</b>
 */
public class Inheritance extends Ast implements IInheritance
{
    private AstToken _EXTENDS;
    private ITypeExpression_allowIn _TypeExpression_allowIn;

    public AstToken getEXTENDS() { return _EXTENDS; }
    public ITypeExpression_allowIn getTypeExpression_allowIn() { return _TypeExpression_allowIn; }

    public Inheritance(IToken leftIToken, IToken rightIToken,
                       AstToken _EXTENDS,
                       ITypeExpression_allowIn _TypeExpression_allowIn)
    {
        super(leftIToken, rightIToken);

        this._EXTENDS = _EXTENDS;
        this._TypeExpression_allowIn = _TypeExpression_allowIn;
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
        if (! (o instanceof Inheritance)) return false;
        Inheritance other = (Inheritance) o;
        if (! _EXTENDS.equals(other._EXTENDS)) return false;
        if (! _TypeExpression_allowIn.equals(other._TypeExpression_allowIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_EXTENDS.hashCode());
        hash = hash * 31 + (_TypeExpression_allowIn.hashCode());
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
            _EXTENDS.accept(v);
            _TypeExpression_allowIn.accept(v);
        }
        v.endVisit(this);
    }
}


