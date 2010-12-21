package expandedjavaparser;
import lpg.runtime.*;
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
    
    static void incrementalParserTest(JavaParser java_parser) {
    	System.out.println("****Begin Reparsing: ");

    	Ast ast = java_parser.parser(); // Parse the token stream to produce an AST

        if (ast == null) 
            System.out.println("****Failure");
        else
        {
            System.out.println("****Begin visitor: ");
            JavaResultVisitor v = new JavaResultVisitor(java_parser.getIPrsStream());
            v.visit((CompilationUnit) ast);
            System.out.println("****Success");
        }
    }

    static void incrementalLexerTest(JavaLexer java_lexer, JavaParser java_parser) {
    	System.out.println("****Begin Reparsing: ");

    	char inputChars[] = java_lexer.getILexStream().getIPrsStream().getInputChars();
        
        System.out.println("\n****The input string is: \n\n");
        System.out.println(inputChars);
        
        System.out.println("*********************\nInitial Tokens: \n");
        java_parser.getIPrsStream().dumpTokens();
        
        char new_input[] = new char[inputChars.length - 2];
        System.arraycopy(inputChars, 0, new_input, 0, 18);
        System.arraycopy(inputChars, 20, new_input, 18, new_input.length - 18);

        System.out.println("\n****The new input string (after deleting the initial \"*/\") is: \n\n");
        System.out.println("\"" + (new String(new_input)) + "\"");
        IPrsStream.Range range = java_lexer.incrementalLexer(new_input, 18, 18); // For deletion, end_offset == start_offset
        
        System.out.println("*********************\nThe new Tokens: \n");
        java.util.ArrayList<IToken> list = range.getTokenList();
        for (int i = 0; i < list.size(); i++) {
        	System.out.println(i + ". " + list.get(i).toString());
        }
        System.out.println("*********************\nThe new Token list: \n");
        java_parser.getIPrsStream().dumpTokens();
        incrementalParserTest(java_parser);
        
        System.out.println("\n****The new input string (after reinserting the \"*/\") is: \n\n");
        System.out.println("\"" + (new String(inputChars)) + "\"");
        range = java_lexer.incrementalLexer(inputChars, 18, 20); // For addition, end_offset = start_offset + length(added string) 
        
        System.out.println("*********************\nThe new Tokens: \n");
        list = range.getTokenList();
        for (int i = 0; i < list.size(); i++) {
        	System.out.println(i + ". " + list.get(i).toString());
        }
        System.out.println("*********************\nThe new Token list: \n");
        java_parser.getIPrsStream().dumpTokens();
        incrementalParserTest(java_parser);
                
        new_input = new char[inputChars.length];
        System.arraycopy(inputChars, 0, new_input, 0, new_input.length);
        new_input[18] = ' ';
        new_input[19] = ' ';
        System.out.println("\n****The new input string (after replacing the initial \"*/\" by \"  \") is: \n\n");
        System.out.println("\"" + (new String(new_input)) + "\"");
        range = java_lexer.incrementalLexer(new_input, 18, 20); // For replacement, end_offset = start_offset + length(replaced string) 
        
        System.out.println("*********************\nThe new Tokens: \n");
        list = range.getTokenList();
        for (int i = 0; i < list.size(); i++) {
        	System.out.println(i + ". " + list.get(i).toString());
        }
        System.out.println("*********************\nThe new Token list: \n");
        java_parser.getIPrsStream().dumpTokens();
        incrementalParserTest(java_parser);

        new_input = new char[inputChars.length];
        System.arraycopy(inputChars, 0, new_input, 0, new_input.length);
        new_input[18] = '*';
        new_input[19] = '/';
        System.out.println("\n****The new input string (after restoring the initial \"*/\") is: \n\n");
        System.out.println("\"" + (new String(new_input)) + "\"");
        range = java_lexer.incrementalLexer(new_input, 18, 20); // For replacement, end_offset = start_offset + length(replaced string) 
        
        System.out.println("*********************\nThe new Tokens: \n");
        list = range.getTokenList();
        for (int i = 0; i < list.size(); i++) {
        	System.out.println(i + ". " + list.get(i).toString());
        }
        System.out.println("*********************\nThe new Token list: \n");
        java_parser.getIPrsStream().dumpTokens();
        incrementalParserTest(java_parser);
        
        new_input = new char[inputChars.length - 2];
        System.arraycopy(inputChars, 0, new_input, 0, 36);
        System.arraycopy(inputChars, 38, new_input, 36, new_input.length - 36);

        System.out.println("\n****The new input string (after deleting two blank characters before the keyword \"public\') is: \n\n");
        System.out.println("\"" + (new String(new_input)) + "\"");
        range = java_lexer.incrementalLexer(new_input, 36, 36); // For deletion, end_offset = start_offset
        
        System.out.println("*********************\nThe new Tokens: \n");
        list = range.getTokenList();
        for (int i = 0; i < list.size(); i++) {
        	System.out.println(i + ". " + list.get(i).toString());
        }        
        System.out.println("*********************\nThe new Token list: \n");
        java_parser.getIPrsStream().dumpTokens();
        incrementalParserTest(java_parser);
    }

    public static void main(String[] args)
    {
        Option option;
        JavaLexer java_lexer = null;
        JavaParser java_parser = null;
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

                java_lexer = new JavaLexer(option.getFileName()); // Create the lexer

                t2 = System.currentTimeMillis();

                java_parser = new JavaParser(java_lexer.getILexStream()); // Create the parser

                v = new JavaResultVisitor(java_parser.getIPrsStream()); // Create the visitor

                t3 = System.currentTimeMillis();

                System.out.println("****Begin lexer: ");

                java_lexer.lexer(java_parser.getIPrsStream()); // Lex the stream to produce the token stream

                t4 = System.currentTimeMillis();

                System.out.println("****Begin parser: ");

                ast = java_parser.parser(); // Parse the token stream to produce an AST

                t5 = System.currentTimeMillis();
            }
            else
            {
                t1 = System.currentTimeMillis();

                java_lexer = new JavaLexer(option.getInputChars(), option.getFileName()); // Create the lexer

                t2 = System.currentTimeMillis();

                java_parser = new JavaParser(java_lexer.getILexStream()); // Create the parser

                v = new JavaResultVisitor(java_parser.getIPrsStream()); // Create the visitor

                t3 = System.currentTimeMillis();

                System.out.println("****Begin lexer: ");

//                java_lexer.lexer(java_parser.getIPrsStream()); // Lex the stream to produce the token stream
                IPrsStream tok_stream = java_parser.getIPrsStream();
                java_lexer.getILexStream().setPrsStream(java_parser.getIPrsStream());
                LexParser lex = java_lexer.getParser();
                lex.resetTokenStream(0);
                tok_stream.makeToken(0, 0, 0); // Token list must start with a bad token
                while (lex.scanNextToken())
                    ;
                int eof_index = lex.getLastToken() + 1;
                tok_stream.makeToken(eof_index, eof_index, JavaParsersym.TK_EOF_TOKEN); // and end with the end of file token
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
                java_parser.getIPrsStream().dumpTokens();
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
                    isKeyword[java_parser.getIPrsStream().mapKind(keywordsKinds[i])] = true;

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
            System.out.println("****File length = " + java_lexer.getILexStream().getStreamLength());
            System.out.println("****Number of Lines = " + (java_lexer.getILexStream().getLineCount() - 1));
            System.out.println("****Lexer Construction + input time :" + (t2 - t1));
            System.out.println("****Parser Construction time :" + (t3 - t2));           
            System.out.println("****Lexing time :" + (t4 - t3));
            System.out.println("****Parsing time :" + (t5 - t4));
            System.out.println("****Visiting time :" + (t6 - t5));
            System.out.println("****Total time :" + (t6 - t1));
            System.out.println("****Number of tokens : " + java_parser.getIPrsStream().getTokens().size());
            System.out.println("****Initial Max Memory:    \t " + r1 + ", used: " + (r1 - f1));
            System.out.println("****After Parse Max Memory:\t " + r2 + ", used: " + (r2 - f2));
            System.out.println("****After GC Max Memory:\t " + r3 + ", used: " + (r3 - f3));
            System.out.println();

// incrementalLexerTest(java_lexer, java_parser);

            return;
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
