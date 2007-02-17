//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 226:  FieldAccess ::= super . IDENTIFIER
 *<li>Rule 227:  FieldAccess ::= Name . super . IDENTIFIER
 *</b>
 */
public class SuperFieldAccess extends Ast implements IFieldAccess
{
    private AstToken _super;
    private AstToken _DOT;
    private AstToken _IDENTIFIER;
    private IName _Name;
    private AstToken _DOT4;

    public AstToken getsuper() { return _super; }
    public AstToken getDOT() { return _DOT; }
    public AstToken getIDENTIFIER() { return _IDENTIFIER; }
    /**
     * The value returned by <b>getName</b> may be <b>null</b>
     */
    public IName getName() { return _Name; }
    /**
     * The value returned by <b>getDOT4</b> may be <b>null</b>
     */
    public AstToken getDOT4() { return _DOT4; }

    public SuperFieldAccess(IToken leftIToken, IToken rightIToken,
                            AstToken _super,
                            AstToken _DOT,
                            AstToken _IDENTIFIER,
                            IName _Name,
                            AstToken _DOT4)
    {
        super(leftIToken, rightIToken);

        this._super = _super;
        ((Ast) _super).setParent(this);
        this._DOT = _DOT;
        ((Ast) _DOT).setParent(this);
        this._IDENTIFIER = _IDENTIFIER;
        ((Ast) _IDENTIFIER).setParent(this);
        this._Name = _Name;
        if (_Name != null) ((Ast) _Name).setParent(this);
        this._DOT4 = _DOT4;
        if (_DOT4 != null) ((Ast) _DOT4).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_super);
        list.add(_DOT);
        list.add(_IDENTIFIER);
        list.add(_Name);
        list.add(_DOT4);
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
        if (! (o instanceof SuperFieldAccess)) return false;
        SuperFieldAccess other = (SuperFieldAccess) o;
        if (! _super.equals(other._super)) return false;
        if (! _DOT.equals(other._DOT)) return false;
        if (! _IDENTIFIER.equals(other._IDENTIFIER)) return false;
        if (_Name == null)
            if (other._Name != null) return false;
            else; // continue
        else if (! _Name.equals(other._Name)) return false;
        if (_DOT4 == null)
            if (other._DOT4 != null) return false;
            else; // continue
        else if (! _DOT4.equals(other._DOT4)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_super.hashCode());
        hash = hash * 31 + (_DOT.hashCode());
        hash = hash * 31 + (_IDENTIFIER.hashCode());
        hash = hash * 31 + (_Name == null ? 0 : _Name.hashCode());
        hash = hash * 31 + (_DOT4 == null ? 0 : _DOT4.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


