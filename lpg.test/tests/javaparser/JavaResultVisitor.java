/*
 * Created on Aug 13, 2005
 *
 */
package javaparser;

import javaparser.JavaParser.*;
import lpg.runtime.*;

/**
 * @author Gerry Fisher
 *
 */
public class JavaResultVisitor extends AbstractResultVisitor
{
    IPrsStream iPrsStream;
	
    public Object unimplementedVisitor(String s) {
        System.out.println(s);
        return null;
    }

    /**
	 * 
	 */
    public JavaResultVisitor(IPrsStream iPrsStream)
	{
		this.iPrsStream = iPrsStream;
	}

	public Object visit(CompilationUnit n) 
    {
		System.out.println("The input file is: ");
		System.out.println("\t" + iPrsStream.getILexStream().getFileName());
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
                    System.out.println(importDecls.getImportDeclarationAt(i).toString());
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
    	return n.getName().toString();
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
    		System.out.print(modifiers.toString() + " ");
    	System.out.print( "class " + n.getName().toString());
    	if (superOpt != null)
    		System.out.print(" " + superOpt.toString());
    	if (interfacesOpt.size() > 0)
    		System.out.print(" implements " + interfacesOpt.toString());
    	System.out.println(" { ... }");
    	
    	return null;
    }
    
    public Object visit(InterfaceDeclaration n)
    {
    	ModifierList modifiers = n.getModifiersopt();
    	InterfaceTypeList extendsOpt = n.getExtendsInterfacesopt();

    	if (modifiers.size() > 0) 
    		System.out.print(modifiers.toString() + " ");
    	System.out.print("interface " + n.getName().toString());
    	if (extendsOpt != null)
    		System.out.print(" extends " + extendsOpt.toString());
    	System.out.println(" { ... }");
    	
    	return null;
    }
}
