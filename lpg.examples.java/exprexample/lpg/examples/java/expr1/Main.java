package lpg.examples.java.expr1;
import lpg.examples.java.expr1.ExprAst.*;

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
            Expr_lexer = new ExprLexer(option); // Create the lexer
            Expr_parser = new ExprParser(Expr_lexer); // Create the parser
            Expr_lexer.lexer(Expr_parser); // Lex the stream to produce the token stream
            if (option.dumpTokens())
            {
                System.out.println("\n****Output Tokens: \n");
                Expr_parser.dumpTokens();
            }
            ast = Expr_parser.parser(); // Parse the token stream to produce an AST
            if (ast == null) 
                 System.out.println("****Failure");
            else
            {
                Integer result = (Integer) ast.accept(new ExprResultVisitor());
                System.out.println("The value is : " + result.intValue());
            }

            return;
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}