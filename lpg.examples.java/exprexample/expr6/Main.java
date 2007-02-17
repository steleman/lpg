package expr6;

public class Main
{
	public static void main(String[] args)
    {
        Option option;
        ExprLexer Expr_lexer;
        ExprParser Expr_parser;
        ExprVisitor Expr_visitor = new ExprVisitor();

        try
        {
            option = new Option(args);
            Expr_lexer = new ExprLexer(option); // Create the lexer
            Expr_parser = new ExprParser(Expr_lexer);	// Create the parser
            Expr_lexer.lexer(Expr_parser); // Lex the stream to produce the token stream
            if (option.dumpTokens())
            {
                System.out.println("\n****Output Tokens: \n");
                Expr_parser.dumpTokens();
            }
            // Parse the token stream creating an Ast and then visit the Ast to obtain the result
            System.out.println(Expr_visitor.visitAst(Expr_parser.parser()));

            return;
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}