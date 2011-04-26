package expr4;

public class Main
{
	public static void main(String[] args)
    {
        Option option;
        ExprLexer Expr_lexer;
        ExprParser Expr_parser;

        Integer ast;

        try
        {
            option = new Option(args);
            Expr_lexer = new ExprLexer(option.getFileName()); // Create the lexer
            Expr_parser = new ExprParser(Expr_lexer.getILexStream());	// Create the parser
            Expr_lexer.lexer(Expr_parser.getIPrsStream()); // Lex the stream to produce the token stream
            if (option.dumpTokens())
            {
                System.out.println("\n****Output Tokens: \n");
                Expr_parser.getIPrsStream().dumpTokens();
            }

            ast = Expr_parser.parser(); // Parse the token stream to produce an AST

            if (ast == null) { 
                if (option.expectErrors()) {
                    System.out.println("****Failure [expected]");
                } else {
                    System.out.println("****Unexpected failure!");
                }
            } else {
            	option.readInputChars();
            	System.out.println(new String(option.getInputChars()) + " = " + ast.intValue());
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
