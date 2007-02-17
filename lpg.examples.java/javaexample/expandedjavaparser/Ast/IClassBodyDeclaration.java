//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 * is implemented by:
 *<b>
 *<ul>
 *<li>EmptyDeclaration
 *<li>ClassDeclaration
 *<li>FieldDeclaration
 *<li>MethodDeclaration
 *<li>StaticInitializer
 *<li>ConstructorDeclaration
 *<li>InterfaceDeclaration
 *<li>Block
 *</ul>
 *</b>
 */
public interface IClassBodyDeclaration
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
    void accept(ArgumentVisitor v, Object o);
    Object accept(ResultVisitor v);
    Object accept(ResultArgumentVisitor v, Object o);
}


