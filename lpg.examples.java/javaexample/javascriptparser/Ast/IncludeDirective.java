package javascriptparser.Ast;

import lpg.runtime.java.*;


import javascriptparser.IAst;

/**
 *<b>
 *<li>Rule 364:  IncludeDirective ::= INCLUDE no_line_break$ String
 *</b>
 */
public class IncludeDirective extends Ast implements IIncludeDirective
{
    private AstToken _INCLUDE;
    private AstToken _String;

    public AstToken getINCLUDE() { return _INCLUDE; }
    public AstToken getString() { return _String; }

    public IncludeDirective(IToken leftIToken, IToken rightIToken,
                            AstToken _INCLUDE,
                            AstToken _String)
    {
        super(leftIToken, rightIToken);

        this._INCLUDE = _INCLUDE;
        this._String = _String;
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
        if (! (o instanceof IncludeDirective)) return false;
        IncludeDirective other = (IncludeDirective) o;
        if (! _INCLUDE.equals(other._INCLUDE)) return false;
        if (! _String.equals(other._String)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_INCLUDE.hashCode());
        hash = hash * 31 + (_String.hashCode());
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
            _INCLUDE.accept(v);
            _String.accept(v);
        }
        v.endVisit(this);
    }
}


