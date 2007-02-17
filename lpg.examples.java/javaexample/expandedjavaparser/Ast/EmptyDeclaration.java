//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 47:  TypeDeclaration ::= ;
 *<li>Rule 77:  ClassMemberDeclaration ::= ;
 *<li>Rule 117:  InterfaceMemberDeclaration ::= ;
 *</b>
 */
public class EmptyDeclaration extends AstToken implements ITypeDeclaration, IClassMemberDeclaration, IInterfaceMemberDeclaration
{
    public IToken getSEMICOLON() { return leftIToken; }

    public EmptyDeclaration(IToken token) { super(token); initialize(); }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


