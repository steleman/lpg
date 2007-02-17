package javascriptparser;
import lpg.javaruntime.*;
import javascriptparser.Ast.*;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            Option option = new Option(args);
            JavascriptLexer javascript_lexer = new JavascriptLexer(option); // Create the lexer
            JavascriptParser javascript_parser = new JavascriptParser(javascript_lexer); // Create the parser
            Ast ast;

            //
            // Lex the stream to produce the token stream and tell us if the 
            // stream is legal.
            //
            PrsStream tok_stream = (PrsStream) javascript_parser;
            DeterministicParser driver = javascript_parser.getParser();
            ParseTable parse_table = javascript_parser.getParseTable();
            System.out.println("****Begin lexer: ");
            if (javascript_lexer.lexer(null,
                                       tok_stream,
                                       driver,
                                       parse_table))
            {
                 System.out.println("****Begin parser: ");
                 ast = (Ast) driver.parseActions();
            }
            else
            {
                DiagnoseParser diagnoseParser = new DiagnoseParser(tok_stream, parse_table);
                diagnoseParser.diagnose();
                ast = null;
            }

            if (ast == null) 
                 System.out.println("****Failure");
            else System.out.println("****Success");

            if (option.dumpTokens())
            {
                System.out.println("\n****Output Tokens: \n");
                tok_stream.dumpTokens();
            }

            if (option.dumpKeywords())
            {
                //
                //  Compute and print the set of keywords
                //
                String tokenKindNames[] = javascript_parser.orderedTerminalSymbols();
                boolean isKeyword[] = new boolean[tokenKindNames.length];

                int keywordsKinds[] = javascript_lexer.getKeywordKinds();
                for (int i = 1; i < keywordsKinds.length; i++)
                    isKeyword[javascript_parser.mapKind(keywordsKinds[i])] = true;

                    System.out.println();
                    System.out.println("The keywords are:");
                    for (int i = 0; i < isKeyword.length; i++)
                        if (isKeyword[i])
                            System.out.println("    " + tokenKindNames[i]);
            }
         
            System.out.println("****File length = " + javascript_lexer.getStreamLength());
            System.out.println("****Number of Lines = " + (javascript_lexer.getLineCount() - 1));
            System.out.println("****Number of tokens : " + javascript_parser.getTokens().size());
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
