//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 293:  AssignmentOperator ::= *=
 *</b>
 */
public class MultiplyEqualOperator extends AstToken implements IAssignmentOperator
{
    public IToken getMULTIPLY_EQUAL() { return leftIToken; }

    public MultiplyEqualOperator(IToken token) { super(token); initialize(); }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


