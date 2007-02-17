//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<em>
 *<li>Rule 354:  IDENTIFIERopt ::= $Empty
 *</em>
 *<p>
 *<b>
 *<li>Rule 355:  IDENTIFIERopt ::= IDENTIFIER
 *</b>
 */
public class IDENTIFIERopt extends AstToken implements IIDENTIFIERopt
{
    public IToken getIDENTIFIER() { return leftIToken; }

    public IDENTIFIERopt(IToken token) { super(token); initialize(); }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


