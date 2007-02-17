package expr5;

public interface ExprParsersym {
    public final static int
      TK_PLUS = 1,
      TK_MULTIPLY = 2,
      TK_LPAREN = 3,
      TK_RPAREN = 4,
      TK_EOF_TOKEN = 5,
      TK_IntegerLiteral = 6,
      TK_ERROR_TOKEN = 7;

      public final static String orderedTerminalSymbols[] = {
                 "",
                 "PLUS",
                 "MULTIPLY",
                 "LPAREN",
                 "RPAREN",
                 "EOF_TOKEN",
                 "IntegerLiteral",
                 "ERROR_TOKEN"
             };

    public final static boolean isValidForParser = true;
}
