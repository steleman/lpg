/*
 * Created on Aug 11, 2005
 *
 */
package javaparser;

import javaparser.JavaParser.AbstractVisitor;
import javaparser.JavaParser.Ast;
import javaparser.JavaParser.CompilationUnit;
import javaparser.JavaParser.IName;
import javaparser.JavaParser.ImportDeclarationList;
import javaparser.JavaParser.PackageDeclaration;

import lpg.javaruntime.PrsStream;

/**
 * @author Gerry Fisher
 *
 */
public class JavaVisitor extends AbstractVisitor 
{
    PrsStream prsStream;
	
    public JavaVisitor(PrsStream prsStream)
	{
		this.prsStream = prsStream;
	}
	
	//ArrayList importDecls;
	
	String getSpannedText(Ast node)
    {
    	int leftSpan = node.getLeftIToken().getStartOffset();
    	int rightSpan = node.getRightIToken().getEndOffset();
    	return new String(prsStream.getInputChars(), leftSpan, rightSpan - leftSpan + 1);
    }
	
	public void visit(CompilationUnit n) 
    {
		System.out.println("The input file is: ");
		System.out.println("\t" + prsStream.getLexStream().getFileName());

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
       			System.out.println("\t" + getSpannedText(importDecls.getElementAt(i)));
            }
        }
        else System.out.println("There are no import declarations");
		System.out.println("Finished");
    }
	
    public void visit(PackageDeclaration n, Object pkgName) 
    {
    	String[] pkN = (String[]) pkgName;
    	IName pkName = n.getName();
    	pkN[0] = getSpannedText((Ast)pkName);
    }

	public void unimplementedVisitor(String s) {
		// TODO Auto-generated method stub
        throw new UnsupportedOperationException(s);
	}
}