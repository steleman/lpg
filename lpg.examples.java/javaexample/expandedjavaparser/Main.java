package expandedjavaparser;
import lpg.runtime.java.*;
import expandedjavaparser.JavaLexer;
import expandedjavaparser.JavaParser;
import expandedjavaparser.JavaResultVisitor;
import expandedjavaparser.Option;
import expandedjavaparser.Ast.*;

public class Main
{
    static public String toString(int i)
    {
        if (i < 128 && (! Character.isWhitespace((char)i)))
            return "\'" + ((char) i) + "\'";
        else if (i <= 0xF)
             return "\'" + "\\u000" + Integer.toHexString(i).toUpperCase() + "\'";
        else if (i <= 0xFF)
             return "\'" + "\\u00" + Integer.toHexString(i).toUpperCase() + "\'";
        else if (i <= 0xFFF)
             return "\'" + "\\u0" + Integer.toHexString(i).toUpperCase() + "\'";
        else return "\'" + "\\u" + Integer.toHexString(i).toUpperCase() + "\'";
    }
    
    static public void doSomething()
    {
        boolean start[] = new boolean[65536];
        boolean middle[] = new boolean[65536];
        for (int i = 0; i < 65536; i++)
        {
            if (Character.isJavaIdentifierStart((char)i))
            {
//                System.out.println("" + ((char) i) + " " + Integer.toString(i) + " 0x" + Integer.toHexString(i));
                start[i] = true;
            }
            else start[i] = false;
        }
        System.out.println();
        for (int i = 0; i < 65536; i++)
        {
        if (Character.isJavaIdentifierPart((char)i) && (! Character.isJavaIdentifierStart((char)i)))
        {
//            System.out.println("" + ((char) i) + " " + Integer.toString(i) + " 0x" + Integer.toHexString(i));
            middle[i] = true;
        }
        else middle[i] = false;
        }
        /*
        System.out.println();
        for (int i = 0; i < 65536; i++)
        {
            if (start[i] && (!middle[i]))
                System.out.println(Integer.toString(i) + " is a start but not a middle");
        }
        System.out.println();
        for (int i = 0; i < 65536; i++)
        {
            if ((!start[i]) && middle[i])
                System.out.println(Integer.toString(i) + " is a middle but not a start");
        }
        */
        System.out.println("The start ranges are:");
        int k = 0;
        while(k < 65536)
        {
            while(k < 65536 && (! start[k]))
                k++;
            int start_index = k;
            while(k < 65536 && start[k])
                k++;
            if (start_index == k -1)
                 System.out.println("    " + toString(start_index));
            else System.out.println("    " + toString(start_index) + ".." + toString(k - 1));
        }
        System.out.println("The middle ranges are:");
        k = 0;
        while(k < 65536)
        {
            while(k < 65536 && (! start[k]))
                k++;
            int start_index = k;
            while(k < 65536 && start[k])
                k++;
            if (start_index == k -1)
                 System.out.println("    " + toString(start_index));
            else System.out.println("    " + toString(start_index) + ".." + toString(k - 1));
        }
    }

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

            JavaResultVisitor v;
            
            if (! option.incremental())
            {
                t1 = System.currentTimeMillis();

                java_lexer = new JavaLexer(option); // Create the lexer

                t2 = System.currentTimeMillis();

                java_parser = new JavaParser(java_lexer); // Create the parser

                v = new JavaResultVisitor(java_parser); // Create the visitor

                t3 = System.currentTimeMillis();

                System.out.println("****Begin lexer: ");

                java_lexer.lexer(java_parser); // Lex the stream to produce the token stream

                t4 = System.currentTimeMillis();

                System.out.println("****Begin parser: ");

                ast = java_parser.parser(); // Parse the token stream to produce an AST

                t5 = System.currentTimeMillis();
            }
            else
            {
                t1 = System.currentTimeMillis();

                java_lexer = new JavaLexer(option); // Create the lexer

                t2 = System.currentTimeMillis();

                java_parser = new JavaParser(java_lexer); // Create the parser

                v = new JavaResultVisitor(java_parser); // Create the visitor

                t3 = System.currentTimeMillis();

                System.out.println("****Begin lexer: ");

//                java_lexer.lexer(java_parser); // Lex the stream to produce the token stream
                PrsStream tok_stream = (PrsStream) java_parser;
                java_lexer.setPrsStream((PrsStream) java_parser);
                LexParser lex = java_lexer.getParser();
                lex.resetTokenStream(0);
                tok_stream.makeToken(0, 0, 0); // Token list must start with a bad token
                while (lex.scanNextToken())
                    ;
                int eof_index = lex.getLastToken() + 1;
                tok_stream.makeToken(eof_index, eof_index, java_lexer.TK_EOF_TOKEN); // and end with the end of file token
                tok_stream.setStreamLength(tok_stream.getSize());

                t4 = System.currentTimeMillis();

                System.out.println("****Begin parser: ");

                DeterministicParser driver = java_parser.getParser();
                ParseTable parse_table = java_parser.getParseTable();
                int sym[] = new int[parse_table.getMaxLa()];
                tok_stream.reset();
                for (int i = 0; i < sym.length; i++)
                {
                    int curtok = tok_stream.getToken();
                    sym[i] = tok_stream.getKind(curtok);
                }
            
                int index = 0;
                driver.resetParser();
                int act;
                for (act = driver.parse(sym, index);
                     act < parse_table.getAcceptAction();
                     act = driver.parse(sym, index))
                {
                    sym[index] = tok_stream.getKind(tok_stream.getToken());
                    index = ((index + 1) % sym.length);
                }

                try
                {
                    ast = (Ast) driver.parseActions();
                }
                catch (BadParseException e)
                {
                    tok_stream.reset(e.error_token); // point to error token

                    DiagnoseParser diagnoseParser = new DiagnoseParser(tok_stream, parse_table);
                    diagnoseParser.diagnose(e.error_token);
                    ast = null;
                }

                t5 = System.currentTimeMillis();
            }

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