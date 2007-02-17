//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.runtime.java.*;

/**
 *<b>
 *<li>Rule 67:  ClassBodyDeclarations ::= ClassBodyDeclaration
 *<li>Rule 68:  ClassBodyDeclarations ::= ClassBodyDeclarations ClassBodyDeclaration
 *<li>Rule 318:  ClassBodyDeclarationsopt ::= $Empty
 *<li>Rule 319:  ClassBodyDeclarationsopt ::= ClassBodyDeclarations
 *</b>
 */
public class ClassBodyDeclarationList extends AstList implements IClassBodyDeclarations, IClassBodyDeclarationsopt
{
    public IClassBodyDeclaration getClassBodyDeclarationAt(int i) { return (IClassBodyDeclaration) getElementAt(i); }

    public ClassBodyDeclarationList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken, leftRecursive);
        initialize();
    }

    public ClassBodyDeclarationList(IClassBodyDeclaration _ClassBodyDeclaration, boolean leftRecursive)
    {
        super((Ast) _ClassBodyDeclaration, leftRecursive);
        ((Ast) _ClassBodyDeclaration).setParent(this);
        initialize();
    }

    public void add(IClassBodyDeclaration _ClassBodyDeclaration)
    {
        super.add((Ast) _ClassBodyDeclaration);
        ((Ast) _ClassBodyDeclaration).setParent(this);
    }

    public void accept(Visitor v) { for (int i = 0; i < size(); i++) getClassBodyDeclarationAt(i).accept(v); }
    public void accept(ArgumentVisitor v, Object o) { for (int i = 0; i < size(); i++) getClassBodyDeclarationAt(i).accept(v, o); }
    public Object accept(ResultVisitor v)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(getClassBodyDeclarationAt(i).accept(v));
        return result;
    }
    public Object accept(ResultArgumentVisitor v, Object o)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(getClassBodyDeclarationAt(i).accept(v, o));
        return result;
    }
}


