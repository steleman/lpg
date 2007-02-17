package javaparser;

import javaparser.JavaParser.Ast;
import javaparser.JavaParser.CompilationUnit;

public class Main
{
	public static void main(String[] args)
    {
        Option option;
        JavaLexer java_lexer;
        JavaParser java_parser;
        Ast ast;

        Runtime r = Runtime.getRuntime();
        long r1, r2, r3;
        long f1, f2, f3;
        long t1, t2, t3, t4, t5, t6;

        try
        {
            System.gc();

            r1 = r.totalMemory();
            f1 = r.freeMemory();


            option = new Option(args);

            t1 = System.currentTimeMillis();

            java_lexer = new JavaLexer(option); // Create the lexer

            t2 = System.currentTimeMillis();

            java_parser = new JavaParser(java_lexer);	// Create the parser

            JavaResultVisitor v = new JavaResultVisitor(java_parser);		// Create the visitor

            t3 = System.currentTimeMillis();

        	System.out.println("****Begin lexer: ");

            java_lexer.lexer(java_parser); // Lex the stream to produce the token stream

            t4 = System.currentTimeMillis();

        	System.out.println("****Begin parser: ");

            ast = java_parser.parser(); // Parse the token stream to produce an AST

            t5 = System.currentTimeMillis();

            if (ast == null) 
            	System.out.println("****Failure");
            else
            {
            	System.out.println("****Begin visitor: ");
            	v.visit((CompilationUnit) ast);
            	System.out.println("****Success");
            }

            t6 = System.currentTimeMillis();


            r2 = r.totalMemory();
            f2 = r.freeMemory();

            System.gc();

            r3 = r.totalMemory();
            f3 = r.freeMemory();

            if (option.dumpTokens())
            {
                System.out.println("\n****Output Tokens: \n");
                java_parser.dumpTokens();
            }

            if (option.dumpKeywords())
            {
                //
                //  Compute and print the set of keywords
                //
                String tokenKindNames[] = java_parser.orderedTerminalSymbols();
                boolean isKeyword[] = new boolean[tokenKindNames.length];

                int keywordsKinds[] = java_lexer.getKeywordKinds();
                for (int i = 1; i < keywordsKinds.length; i++)
                    isKeyword[java_parser.mapKind(keywordsKinds[i])] = true;

                System.out.println();
                System.out.println("The keywords are:");
                for (int i = 0; i < isKeyword.length; i++)
                	if (isKeyword[i])
                		System.out.println("    " + tokenKindNames[i]);
                //
                // Usually, we would use this info to construct the function:
                //
                // boolean isKeyword[] = null;
                // public boolean isKeyword(int kind)
                // {
                //     if (isKeyword == null)
                //     {
                //         String tokenKindNames[] = java_parser.orderedTerminalSymbols();
                //         isKeyword[] = new boolean[tokenKindNames.length];
                //         int keywordsKinds[] = java_lexer.getKeywordKinds();
                //         for (int i = 1; i < keywordsKinds.length; i++)
                //            isKeyword[java_parser.mapKind(keywordsKinds[i])] = true;
                //     }
                //     return isKeyword[kind];
                // }
            }
         
            System.out.println("\n****Parsing statistics: \n");
            System.out.println("****File length = " + java_lexer.getStreamLength());
            System.out.println("****Number of Lines = " + (java_lexer.getLineCount() - 1));
            System.out.println("****Lexer Construction + input time :" + (t2 - t1));
            System.out.println("****Parser Construction time :" + (t3 - t2));           
            System.out.println("****Lexing time :" + (t4 - t3));
            System.out.println("****Parsing time :" + (t5 - t4));
            System.out.println("****Visiting time :" + (t6 - t5));
            System.out.println("****Total time :" + (t6 - t1));
            System.out.println("****Number of tokens : " + java_parser.getTokens().size());
            System.out.println("****Initial Max Memory:    \t " + r1 + ", used: " + (r1 - f1));
            System.out.println("****After Parse Max Memory:\t " + r2 + ", used: " + (r2 - f2));
            System.out.println("****After GC Max Memory:\t " + r3 + ", used: " + (r3 - f3));
            System.out.println();

            return;
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
