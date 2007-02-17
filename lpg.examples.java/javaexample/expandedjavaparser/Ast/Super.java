//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 62:  Super ::= extends ClassType
 *</b>
 */
public class Super extends Ast implements ISuper
{
    private AstToken _extends;
    private IClassType _ClassType;

    public AstToken getextends() { return _extends; }
    public IClassType getClassType() { return _ClassType; }

    public Super(IToken leftIToken, IToken rightIToken,
                 AstToken _extends,
                 IClassType _ClassType)
    {
        super(leftIToken, rightIToken);

        this._extends = _extends;
        ((Ast) _extends).setParent(this);
        this._ClassType = _ClassType;
        ((Ast) _ClassType).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_extends);
        list.add(_ClassType);
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
        if (! (o instanceof Super)) return false;
        Super other = (Super) o;
        if (! _extends.equals(other._extends)) return false;
        if (! _ClassType.equals(other._ClassType)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_extends.hashCode());
        hash = hash * 31 + (_ClassType.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


