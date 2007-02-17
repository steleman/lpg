package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 73:  PropertyOperator ::= Brackets
 *</em>
 *<p>
 *<b>
 *<li>Rule 72:  PropertyOperator ::= . QualifiedIdentifier
 *</b>
 */
public class PropertyOperator extends Ast implements IPropertyOperator
{
    private AstToken _PERIOD;
    private IQualifiedIdentifier _QualifiedIdentifier;

    public AstToken getPERIOD() { return _PERIOD; }
    public IQualifiedIdentifier getQualifiedIdentifier() { return _QualifiedIdentifier; }

    public PropertyOperator(IToken leftIToken, IToken rightIToken,
                            AstToken _PERIOD,
                            IQualifiedIdentifier _QualifiedIdentifier)
    {
        super(leftIToken, rightIToken);

        this._PERIOD = _PERIOD;
        this._QualifiedIdentifier = _QualifiedIdentifier;
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
        if (! (o instanceof PropertyOperator)) return false;
        PropertyOperator other = (PropertyOperator) o;
        if (! _PERIOD.equals(other._PERIOD)) return false;
        if (! _QualifiedIdentifier.equals(other._QualifiedIdentifier)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_PERIOD.hashCode());
        hash = hash * 31 + (_QualifiedIdentifier.hashCode());
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
            _PERIOD.accept(v);
            _QualifiedIdentifier.accept(v);
        }
        v.endVisit(this);
    }
}


