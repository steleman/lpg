package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 403:  TypedIdentifier_noIn ::= Identifier
 *</em>
 *<p>
 *<b>
 *<li>Rule 404:  TypedIdentifier_noIn ::= Identifier : TypeExpression_noIn
 *</b>
 */
public class TypedIdentifier_noIn extends Ast implements ITypedIdentifier_noIn
{
    private IIdentifier _Identifier;
    private AstToken _COLON;
    private ITypeExpression_noIn _TypeExpression_noIn;

    public IIdentifier getIdentifier() { return _Identifier; }
    public AstToken getCOLON() { return _COLON; }
    public ITypeExpression_noIn getTypeExpression_noIn() { return _TypeExpression_noIn; }

    public TypedIdentifier_noIn(IToken leftIToken, IToken rightIToken,
                                IIdentifier _Identifier,
                                AstToken _COLON,
                                ITypeExpression_noIn _TypeExpression_noIn)
    {
        super(leftIToken, rightIToken);

        this._Identifier = _Identifier;
        this._COLON = _COLON;
        this._TypeExpression_noIn = _TypeExpression_noIn;
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
        if (! (o instanceof TypedIdentifier_noIn)) return false;
        TypedIdentifier_noIn other = (TypedIdentifier_noIn) o;
        if (! _Identifier.equals(other._Identifier)) return false;
        if (! _COLON.equals(other._COLON)) return false;
        if (! _TypeExpression_noIn.equals(other._TypeExpression_noIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_Identifier.hashCode());
        hash = hash * 31 + (_COLON.hashCode());
        hash = hash * 31 + (_TypeExpression_noIn.hashCode());
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
            _Identifier.accept(v);
            _COLON.accept(v);
            _TypeExpression_noIn.accept(v);
        }
        v.endVisit(this);
    }
}


