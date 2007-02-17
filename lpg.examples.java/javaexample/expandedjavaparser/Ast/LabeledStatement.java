//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 155:  LabeledStatement ::= IDENTIFIER : Statement
 *<li>Rule 156:  LabeledStatementNoShortIf ::= IDENTIFIER : StatementNoShortIf$Statement
 *</b>
 */
public class LabeledStatement extends Ast implements ILabeledStatement, ILabeledStatementNoShortIf
{
    private AstToken _IDENTIFIER;
    private AstToken _COLON;
    private Ast _Statement;

    public AstToken getIDENTIFIER() { return _IDENTIFIER; }
    public AstToken getCOLON() { return _COLON; }
    public Ast getStatement() { return _Statement; }

    public LabeledStatement(IToken leftIToken, IToken rightIToken,
                            AstToken _IDENTIFIER,
                            AstToken _COLON,
                            Ast _Statement)
    {
        super(leftIToken, rightIToken);

        this._IDENTIFIER = _IDENTIFIER;
        ((Ast) _IDENTIFIER).setParent(this);
        this._COLON = _COLON;
        ((Ast) _COLON).setParent(this);
        this._Statement = _Statement;
        ((Ast) _Statement).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_IDENTIFIER);
        list.add(_COLON);
        list.add(_Statement);
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
        if (! (o instanceof LabeledStatement)) return false;
        LabeledStatement other = (LabeledStatement) o;
        if (! _IDENTIFIER.equals(other._IDENTIFIER)) return false;
        if (! _COLON.equals(other._COLON)) return false;
        if (! _Statement.equals(other._Statement)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_IDENTIFIER.hashCode());
        hash = hash * 31 + (_COLON.hashCode());
        hash = hash * 31 + (_Statement.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


