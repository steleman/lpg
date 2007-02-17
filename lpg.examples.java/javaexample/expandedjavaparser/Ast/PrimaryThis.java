//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 207:  PrimaryNoNewArray ::= this
 *<li>Rule 208:  PrimaryNoNewArray ::= Name . this
 *</b>
 */
public class PrimaryThis extends Ast implements IPrimaryNoNewArray
{
    private AstToken _this;
    private IName _Name;
    private AstToken _DOT;

    public AstToken getthis() { return _this; }
    /**
     * The value returned by <b>getName</b> may be <b>null</b>
     */
    public IName getName() { return _Name; }
    /**
     * The value returned by <b>getDOT</b> may be <b>null</b>
     */
    public AstToken getDOT() { return _DOT; }

    public PrimaryThis(IToken leftIToken, IToken rightIToken,
                       AstToken _this,
                       IName _Name,
                       AstToken _DOT)
    {
        super(leftIToken, rightIToken);

        this._this = _this;
        ((Ast) _this).setParent(this);
        this._Name = _Name;
        if (_Name != null) ((Ast) _Name).setParent(this);
        this._DOT = _DOT;
        if (_DOT != null) ((Ast) _DOT).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_this);
        list.add(_Name);
        list.add(_DOT);
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
        if (! (o instanceof PrimaryThis)) return false;
        PrimaryThis other = (PrimaryThis) o;
        if (! _this.equals(other._this)) return false;
        if (_Name == null)
            if (other._Name != null) return false;
            else; // continue
        else if (! _Name.equals(other._Name)) return false;
        if (_DOT == null)
            if (other._DOT != null) return false;
            else; // continue
        else if (! _DOT.equals(other._DOT)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_this.hashCode());
        hash = hash * 31 + (_Name == null ? 0 : _Name.hashCode());
        hash = hash * 31 + (_DOT == null ? 0 : _DOT.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


