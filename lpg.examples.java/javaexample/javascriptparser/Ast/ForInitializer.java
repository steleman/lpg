package javascriptparser.Ast;

import lpg.javaruntime.*;


import javascriptparser.IAst;

/**
 *<em>
 *<li>Rule 294:  ForInitializer ::= $Empty
 *<li>Rule 295:  ForInitializer ::= ListExpression_noIn
 *<li>Rule 296:  ForInitializer ::= VariableDefinition_noIn
 *</em>
 *<p>
 *<b>
 *<li>Rule 297:  ForInitializer ::= Attributes no_line_break$ VariableDefinition_noIn
 *</b>
 */
public class ForInitializer extends Ast implements IForInitializer
{
    private IAttributes _Attributes;
    private VariableDefinition_noIn _VariableDefinition_noIn;

    public IAttributes getAttributes() { return _Attributes; }
    public VariableDefinition_noIn getVariableDefinition_noIn() { return _VariableDefinition_noIn; }

    public ForInitializer(IToken leftIToken, IToken rightIToken,
                          IAttributes _Attributes,
                          VariableDefinition_noIn _VariableDefinition_noIn)
    {
        super(leftIToken, rightIToken);

        this._Attributes = _Attributes;
        this._VariableDefinition_noIn = _VariableDefinition_noIn;
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
        if (! (o instanceof ForInitializer)) return false;
        ForInitializer other = (ForInitializer) o;
        if (! _Attributes.equals(other._Attributes)) return false;
        if (! _VariableDefinition_noIn.equals(other._VariableDefinition_noIn)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_Attributes.hashCode());
        hash = hash * 31 + (_VariableDefinition_noIn.hashCode());
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
            _Attributes.accept(v);
            _VariableDefinition_noIn.accept(v);
        }
        v.endVisit(this);
    }
}


