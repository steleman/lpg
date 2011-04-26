package lpg;

import org.eclipse.imp.lpg.parser.LPGParser;
import org.eclipse.imp.lpg.parser.LPGParser.ASTNode;
import org.eclipse.imp.lpg.parser.LPGLexer;

import lpg.JavaActionBlockAutomaticVisitor;
import lpg.JavaActionBlockUserDefinedVisitor;
import lpg.JavaActionBlockVisitor;

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

            ASTNode ast = (ASTNode) lpg_parser.parser(); // Parse the token stream to produce an AST

            if (ast == null) { 
                if (option.expectErrors()) {
                    System.out.println("****Failure [expected]");
                } else {
                    System.out.println("****Unexpected failure!");
                }
            } else {
                JavaActionBlockVisitor visitor;
                if (option.automaticAST()) { // TODO should probably read this from the grammar options instead
                    visitor = new JavaActionBlockAutomaticVisitor();
                } else {
                    visitor = new JavaActionBlockUserDefinedVisitor();
                }
                visitor.reset(lpg_parser);
                ast.accept(visitor);
                if (visitor.hadParseErrors() && !option.expectErrors()) {
                    System.exit(1);
                }
            }

            if (!option.expectErrors() && ast == null) {
                System.exit(1);
            }

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
