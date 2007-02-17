//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 177:  SwitchLabel ::= default :
 *</b>
 */
public class DefaultLabel extends Ast implements ISwitchLabel
{
    private AstToken _default;
    private AstToken _COLON;

    public AstToken getdefault() { return _default; }
    public AstToken getCOLON() { return _COLON; }

    public DefaultLabel(IToken leftIToken, IToken rightIToken,
                        AstToken _default,
                        AstToken _COLON)
    {
        super(leftIToken, rightIToken);

        this._default = _default;
        ((Ast) _default).setParent(this);
        this._COLON = _COLON;
        ((Ast) _COLON).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_default);
        list.add(_COLON);
        return list;
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
        if (! (o instanceof DefaultLabel)) return false;
        DefaultLabel other = (DefaultLabel) o;
        if (! _default.equals(other._default)) return false;
        if (! _COLON.equals(other._COLON)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_default.hashCode());
        hash = hash * 31 + (_COLON.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


