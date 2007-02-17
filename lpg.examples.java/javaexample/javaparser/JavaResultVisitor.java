/*
 * Created on Aug 13, 2005
 *
 */
package javaparser;

import javaparser.JavaParser.*;
import lpg.runtime.java.*;

/**
 * @author Gerry Fisher
 *
 */
public class JavaResultVisitor extends AbstractResultVisitor
{
    PrsStream prsStream;
	
    public Object unimplementedVisitor(String s) {
        System.out.println(s);
        return null;
    }

    /**
	 * 
	 */
    public JavaResultVisitor(PrsStream prsStream)
	{
		this.prsStream = prsStream;
	}

	String getSpannedText(Ast node)
    {
    	int leftSpan = node.getLeftIToken().getStartOffset();
    	int rightSpan = node.getRightIToken().getEndOffset();
    	return new String(prsStream.getInputChars(), leftSpan, rightSpan - leftSpan + 1);
    }
	
	public Object visit(CompilationUnit n) 
    {
		System.out.println("The input file is: ");
		System.out.println("\t" + prsStream.getLexStream().getFileName());
    	if (n != null)
    	{
    		PackageDeclaration pkDecl = n.getPackageDeclarationopt();
            if(pkDecl != null)
    		{
     			 String pkgName = (String)pkDecl.accept(this);
    			 System.out.println("package " + pkgName + ";");
    		}
    		else System.out.println("There is no package declaration");

            ImportDeclarationList importDecls = n.getImportDeclarationsopt();
            if (importDecls.size() > 0)
            {
                for (int i = 0; i < importDecls.size(); i++)
                    System.out.println(getSpannedText((Ast)(importDecls.getImportDeclarationAt(i))));
            }
            else System.out.println("There are no import declarations");

            TypeDeclarationList typeDecls = n.getTypeDeclarationsopt();
            if (typeDecls.size() > 0)
            {
                for (int i = 0; i < typeDecls.size(); i++)
                    typeDecls.getTypeDeclarationAt(i).accept(this);
            }
            else System.out.println("There are no type declarations");
    	}
		System.out.println("Finished");
		return null;
    }
	
    public Object visit(PackageDeclaration n) 
    {
    	return getSpannedText((Ast)n.getName());
    }

    public Object visit(EmptyDeclaration n)
    {
        // we ignore empty declarations
        return null;
    }
    
    public Object visit(ClassDeclaration n)
    {
    	ModifierList modifiers = n.getModifiersopt();
    	Super superOpt = n.getSuperopt();
    	InterfaceTypeList interfacesOpt = n.getInterfacesopt();
    	
    	if (modifiers.size() > 0) 
    		System.out.print(getSpannedText((Ast)modifiers) + " ");
    	System.out.print( "class " + getSpannedText((AstToken) n.getName()));
    	if (superOpt != null)
    		System.out.print(" " + getSpannedText((Ast)superOpt));
    	if (interfacesOpt.size() > 0)
    		System.out.print(" " + getSpannedText((Ast)interfacesOpt));
    	System.out.println(" { ... }");
    	
    	return null;
    }
    
    public Object visit(InterfaceDeclaration n)
    {
    	ModifierList modifiers = n.getModifiersopt();
    	InterfaceTypeList extendsOpt = n.getExtendsInterfacesopt();

    	if (modifiers != null) 
    		System.out.print(getSpannedText((Ast)modifiers) + " ");
    	System.out.print( "interface " + getSpannedText((AstToken) n.getName()));
    	if (extendsOpt != null)
    		System.out.print(" " + getSpannedText((Ast)extendsOpt));
    	System.out.println(" { ... }");
    	
    	return null;
    }
}
