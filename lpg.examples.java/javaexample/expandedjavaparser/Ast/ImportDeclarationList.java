//
// A copyright notice must contain a "C" enclosed in parentheses: (C) 
//

package expandedjavaparser.Ast;

import lpg.javaruntime.*;

/**
 *<b>
 *<li>Rule 36:  ImportDeclarations ::= ImportDeclaration
 *<li>Rule 37:  ImportDeclarations ::= ImportDeclarations ImportDeclaration
 *<li>Rule 314:  ImportDeclarationsopt ::= $Empty
 *<li>Rule 315:  ImportDeclarationsopt ::= ImportDeclarations
 *</b>
 */
public class ImportDeclarationList extends AstList implements IImportDeclarations, IImportDeclarationsopt
{
    public IImportDeclaration getImportDeclarationAt(int i) { return (IImportDeclaration) getElementAt(i); }

    public ImportDeclarationList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken, leftRecursive);
        initialize();
    }

    public ImportDeclarationList(IImportDeclaration _ImportDeclaration, boolean leftRecursive)
    {
        super((Ast) _ImportDeclaration, leftRecursive);
        ((Ast) _ImportDeclaration).setParent(this);
        initialize();
    }

    public void add(IImportDeclaration _ImportDeclaration)
    {
        super.add((Ast) _ImportDeclaration);
        ((Ast) _ImportDeclaration).setParent(this);
    }

    public void accept(Visitor v) { for (int i = 0; i < size(); i++) getImportDeclarationAt(i).accept(v); }
    public void accept(ArgumentVisitor v, Object o) { for (int i = 0; i < size(); i++) getImportDeclarationAt(i).accept(v, o); }
    public Object accept(ResultVisitor v)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(getImportDeclarationAt(i).accept(v));
        return result;
    }
    public Object accept(ResultArgumentVisitor v, Object o)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(getImportDeclarationAt(i).accept(v, o));
        return result;
    }
}


