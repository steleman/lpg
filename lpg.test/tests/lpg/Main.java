package lpg;

import org.eclipse.imp.lpg.parser.LPGParser;
import org.eclipse.imp.lpg.parser.LPGLexer;

public class Main
{
    public static void main(String[] args)
    {
        Option option;
        LPGLexer lpg_lexer;
        LPGParser lpg_parser;

        try
        {
            option = new Option(args);
            lpg_lexer = new LPGLexer(option.getFileName()); // Create the lexer
            lpg_parser = new LPGParser(lpg_lexer.getILexStream()); // Create the parser
            lpg_lexer.lexer(lpg_parser.getIPrsStream()); // Lex the stream to produce the token stream
            if (option.dumpTokens())
            {
                System.out.println("\n****Output Tokens: \n");
                lpg_parser.getIPrsStream().dumpTokens();
            }
            Object ast = lpg_parser.parser(); // Parse the token stream to produce an AST
            if (ast == null) 
                 System.out.println("****Failure");
            //else
            //{
                //Integer result = (Integer) ast.accept(new ExprResultVisitor());
                //System.out.println(ast.toString() + " = " + result.intValue());
            //}

            return;
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}
