package expr1;
import expr1.ExprAst.*;

public class Main
{
    public static void main(String[] args)
    {
        Option option;
        ExprLexer Expr_lexer;
        ExprParser Expr_parser;

        Ast ast;

        try
        {
            option = new Option(args);
            Expr_lexer = new ExprLexer(option.getFileName()); // Create the lexer
            Expr_parser = new ExprParser(Expr_lexer.getILexStream()); // Create the parser
            Expr_lexer.lexer(Expr_parser.getIPrsStream()); // Lex the stream to produce the token stream
            if (option.dumpTokens())
            {
                System.out.println("\n****Output Tokens: \n");
                Expr_parser.getIPrsStream().dumpTokens();
            }
            ast = Expr_parser.parser(); // Parse the token stream to produce an AST
            if (ast == null) 
                 System.out.println("****Failure");
            else
            {
                Integer result = (Integer) ast.accept(new ExprResultVisitor());
                System.out.println(ast.toString() + " = " + result.intValue());
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