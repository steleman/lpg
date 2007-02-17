//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 34:  QualifiedName ::= Name . IDENTIFIER
 *</b>
 */
public class QualifiedName extends Ast implements IQualifiedName
{
    private IName _Name;
    private AstToken _DOT;
    private AstToken _IDENTIFIER;

    public IName getName() { return _Name; }
    public AstToken getDOT() { return _DOT; }
    public AstToken getIDENTIFIER() { return _IDENTIFIER; }

    public QualifiedName(IToken leftIToken, IToken rightIToken,
                         IName _Name,
                         AstToken _DOT,
                         AstToken _IDENTIFIER)
    {
        super(leftIToken, rightIToken);

        this._Name = _Name;
        ((Ast) _Name).setParent(this);
        this._DOT = _DOT;
        ((Ast) _DOT).setParent(this);
        this._IDENTIFIER = _IDENTIFIER;
        ((Ast) _IDENTIFIER).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_Name);
        list.add(_DOT);
        list.add(_IDENTIFIER);
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
        if (! (o instanceof QualifiedName)) return false;
        QualifiedName other = (QualifiedName) o;
        if (! _Name.equals(other._Name)) return false;
        if (! _DOT.equals(other._DOT)) return false;
        if (! _IDENTIFIER.equals(other._IDENTIFIER)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_Name.hashCode());
        hash = hash * 31 + (_DOT.hashCode());
        hash = hash * 31 + (_IDENTIFIER.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


