//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 111:  InterfaceMemberDeclarations ::= InterfaceMemberDeclaration
 *<li>Rule 112:  InterfaceMemberDeclarations ::= InterfaceMemberDeclarations InterfaceMemberDeclaration
 *<li>Rule 336:  InterfaceMemberDeclarationsopt ::= $Empty
 *<li>Rule 337:  InterfaceMemberDeclarationsopt ::= InterfaceMemberDeclarations
 *</b>
 */
public class InterfaceMemberDeclarationList extends AstList implements IInterfaceMemberDeclarations, IInterfaceMemberDeclarationsopt
{
    public IInterfaceMemberDeclaration getInterfaceMemberDeclarationAt(int i) { return (IInterfaceMemberDeclaration) getElementAt(i); }

    public InterfaceMemberDeclarationList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken, leftRecursive);
        initialize();
    }

    public InterfaceMemberDeclarationList(IInterfaceMemberDeclaration _InterfaceMemberDeclaration, boolean leftRecursive)
    {
        super((Ast) _InterfaceMemberDeclaration, leftRecursive);
        ((Ast) _InterfaceMemberDeclaration).setParent(this);
        initialize();
    }

    public void add(IInterfaceMemberDeclaration _InterfaceMemberDeclaration)
    {
        super.add((Ast) _InterfaceMemberDeclaration);
        ((Ast) _InterfaceMemberDeclaration).setParent(this);
    }

    public void accept(Visitor v) { for (int i = 0; i < size(); i++) getInterfaceMemberDeclarationAt(i).accept(v); }
    public void accept(ArgumentVisitor v, Object o) { for (int i = 0; i < size(); i++) getInterfaceMemberDeclarationAt(i).accept(v, o); }
    public Object accept(ResultVisitor v)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(getInterfaceMemberDeclarationAt(i).accept(v));
        return result;
    }
    public Object accept(ResultArgumentVisitor v, Object o)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(getInterfaceMemberDeclarationAt(i).accept(v, o));
        return result;
    }
}


