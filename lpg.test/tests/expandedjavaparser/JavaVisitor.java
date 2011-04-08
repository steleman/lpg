/*
 * Created on Aug 11, 2005
 *
 */
package expandedjavaparser;

import expandedjavaparser.Ast.*;

import lpg.runtime.IAst;
import lpg.runtime.PrsStream;

/**
 * @author Gerry Fisher
 *
 */
public class JavaVisitor extends AbstractVisitor 
{
    PrsStream iPrsStream;

    public JavaVisitor(PrsStream iPrsStream)
    {
        this.iPrsStream = iPrsStream;
    }

    //ArrayList importDecls;

    String getSpannedText(IAst node)
    {
        int leftSpan = node.getLeftIToken().getStartOffset(),
            rightSpan = node.getRightIToken().getEndOffset();
        return new String(iPrsStream.getInputChars(), leftSpan, rightSpan - leftSpan + 1);
    }

    public void visit(CompilationUnit n) 
    {
        System.out.println("The input file is: ");
        System.out.println("\t" + iPrsStream.getILexStream().getFileName());

        PackageDeclaration pkDecl = n.getPackageDeclarationopt();
        String[] pkgName = new String[1];
        if(pkDecl != null)
        {
            pkDecl.accept(this, pkgName);
            System.out.println("The package name is: ");
            System.out.println("\t" + pkgName[0]);
        }
        else System.out.println("There is no package declaration");
    
        ImportDeclarationList importDecls = n.getImportDeclarationsopt();

        System.out.println("The import declarations are: ");
        if (importDecls.size() == 0)
        {
            for (int i = 0; i < importDecls.size(); i++)
            {
                System.out.println("\t" + getSpannedText((IAst) importDecls.getElementAt(i)));
            }
        }
        else System.out.println("There are no import declarations");
        System.out.println("Finished");
    }

    public void visit(PackageDeclaration n, Object pkgName) 
    {
        String[] pkN = (String[]) pkgName;
        IName pkName = n.getName();
        pkN[0] = getSpannedText((IAst)pkName);
    }

    public void unimplementedVisitor(String s) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(s);
    }
}