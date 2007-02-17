//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 38:  TypeDeclarations ::= TypeDeclaration
 *<li>Rule 39:  TypeDeclarations ::= TypeDeclarations TypeDeclaration
 *<li>Rule 316:  TypeDeclarationsopt ::= $Empty
 *<li>Rule 317:  TypeDeclarationsopt ::= TypeDeclarations
 *</b>
 */
public class TypeDeclarationList extends AstList implements ITypeDeclarations, ITypeDeclarationsopt
{
    public ITypeDeclaration getTypeDeclarationAt(int i) { return (ITypeDeclaration) getElementAt(i); }

    public TypeDeclarationList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken, leftRecursive);
        initialize();
    }

    public TypeDeclarationList(ITypeDeclaration _TypeDeclaration, boolean leftRecursive)
    {
        super((Ast) _TypeDeclaration, leftRecursive);
        ((Ast) _TypeDeclaration).setParent(this);
        initialize();
    }

    public void add(ITypeDeclaration _TypeDeclaration)
    {
        super.add((Ast) _TypeDeclaration);
        ((Ast) _TypeDeclaration).setParent(this);
    }

    public void accept(Visitor v) { for (int i = 0; i < size(); i++) getTypeDeclarationAt(i).accept(v); }
    public void accept(ArgumentVisitor v, Object o) { for (int i = 0; i < size(); i++) getTypeDeclarationAt(i).accept(v, o); }
    public Object accept(ResultVisitor v)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(getTypeDeclarationAt(i).accept(v));
        return result;
    }
    public Object accept(ResultArgumentVisitor v, Object o)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(getTypeDeclarationAt(i).accept(v, o));
        return result;
    }
}


