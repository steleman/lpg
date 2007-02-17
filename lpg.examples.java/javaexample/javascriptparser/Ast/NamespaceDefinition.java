package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 433:  NamespaceDefinition ::= NAMESPACE Identifier
 *</b>
 */
public class NamespaceDefinition extends Ast implements INamespaceDefinition
{
    private AstToken _NAMESPACE;
    private IIdentifier _Identifier;

    public AstToken getNAMESPACE() { return _NAMESPACE; }
    public IIdentifier getIdentifier() { return _Identifier; }

    public NamespaceDefinition(IToken leftIToken, IToken rightIToken,
                               AstToken _NAMESPACE,
                               IIdentifier _Identifier)
    {
        super(leftIToken, rightIToken);

        this._NAMESPACE = _NAMESPACE;
        this._Identifier = _Identifier;
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
        if (! (o instanceof NamespaceDefinition)) return false;
        NamespaceDefinition other = (NamespaceDefinition) o;
        if (! _NAMESPACE.equals(other._NAMESPACE)) return false;
        if (! _Identifier.equals(other._Identifier)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_NAMESPACE.hashCode());
        hash = hash * 31 + (_Identifier.hashCode());
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
            _NAMESPACE.accept(v);
            _Identifier.accept(v);
        }
        v.endVisit(this);
    }
}


