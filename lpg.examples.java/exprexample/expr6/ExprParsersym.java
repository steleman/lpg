package expr6;

public interface ExprParsersym {
    public final static int
      TK_PLUS = 1,
      TK_MULTIPLY = 2,
      TK_LPAREN = 3,
      TK_RPAREN = 4,
      TK_COMMA = 5,
      TK_EOF_TOKEN = 6,
      TK_IntegerLiteral = 7,
      TK_ERROR_TOKEN = 8;

      public final static String orderedTerminalSymbols[] = {
                 "",
                 "PLUS",
                 "MULTIPLY",
                 "LPAREN",
                 "RPAREN",
                 "COMMA",
                 "EOF_TOKEN",
                 "IntegerLiteral",
                 "ERROR_TOKEN"
             };

    public final static boolean isValidForParser = true;
}
