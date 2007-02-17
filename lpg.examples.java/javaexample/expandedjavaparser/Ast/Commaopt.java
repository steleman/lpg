//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<em>
 *<li>Rule 352:  Commaopt ::= $Empty
 *</em>
 *<p>
 *<b>
 *<li>Rule 353:  Commaopt ::= ,
 *</b>
 */
public class Commaopt extends AstToken implements ICommaopt
{
    public IToken getCOMMA() { return leftIToken; }

    public Commaopt(IToken token) { super(token); initialize(); }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


