//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 173:  SwitchBlockStatement ::= SwitchLabels BlockStatements
 *</b>
 */
public class SwitchBlockStatement extends Ast implements ISwitchBlockStatement
{
    private SwitchLabelList _SwitchLabels;
    private BlockStatementList _BlockStatements;

    public SwitchLabelList getSwitchLabels() { return _SwitchLabels; }
    public BlockStatementList getBlockStatements() { return _BlockStatements; }

    public SwitchBlockStatement(IToken leftIToken, IToken rightIToken,
                                SwitchLabelList _SwitchLabels,
                                BlockStatementList _BlockStatements)
    {
        super(leftIToken, rightIToken);

        this._SwitchLabels = _SwitchLabels;
        ((Ast) _SwitchLabels).setParent(this);
        this._BlockStatements = _BlockStatements;
        ((Ast) _BlockStatements).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_SwitchLabels);
        list.add(_BlockStatements);
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
        if (! (o instanceof SwitchBlockStatement)) return false;
        SwitchBlockStatement other = (SwitchBlockStatement) o;
        if (! _SwitchLabels.equals(other._SwitchLabels)) return false;
        if (! _BlockStatements.equals(other._BlockStatements)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_SwitchLabels.hashCode());
        hash = hash * 31 + (_BlockStatements.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


