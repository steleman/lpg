//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 171:  SwitchBlockStatements ::= SwitchBlockStatement
 *<li>Rule 172:  SwitchBlockStatements ::= SwitchBlockStatements SwitchBlockStatement
 *<li>Rule 348:  SwitchBlockStatementsopt ::= $Empty
 *<li>Rule 349:  SwitchBlockStatementsopt ::= SwitchBlockStatements
 *</b>
 */
public class SwitchBlockStatementList extends AstList implements ISwitchBlockStatements, ISwitchBlockStatementsopt
{
    public SwitchBlockStatement getSwitchBlockStatementAt(int i) { return (SwitchBlockStatement) getElementAt(i); }

    public SwitchBlockStatementList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken, leftRecursive);
        initialize();
    }

    public SwitchBlockStatementList(SwitchBlockStatement _SwitchBlockStatement, boolean leftRecursive)
    {
        super((Ast) _SwitchBlockStatement, leftRecursive);
        ((Ast) _SwitchBlockStatement).setParent(this);
        initialize();
    }

    public void add(SwitchBlockStatement _SwitchBlockStatement)
    {
        super.add((Ast) _SwitchBlockStatement);
        ((Ast) _SwitchBlockStatement).setParent(this);
    }

    public void accept(Visitor v) { for (int i = 0; i < size(); i++) v.visit(getSwitchBlockStatementAt(i)); }
    public void accept(ArgumentVisitor v, Object o) { for (int i = 0; i < size(); i++) v.visit(getSwitchBlockStatementAt(i), o); }
    public Object accept(ResultVisitor v)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(v.visit(getSwitchBlockStatementAt(i)));
        return result;
    }
    public Object accept(ResultArgumentVisitor v, Object o)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(v.visit(getSwitchBlockStatementAt(i), o));
        return result;
    }
}


