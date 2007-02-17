package softjavaparser;

public interface SoftJavaParsersym {
    public final static int
      TK_IntegerLiteral = 58,
      TK_LongLiteral = 59,
      TK_FloatingPointLiteral = 60,
      TK_DoubleLiteral = 61,
      TK_CharacterLiteral = 62,
      TK_StringLiteral = 63,
      TK_PLUS_PLUS = 56,
      TK_MINUS_MINUS = 57,
      TK_EQUAL_EQUAL = 97,
      TK_LESS_EQUAL = 91,
      TK_GREATER_EQUAL = 92,
      TK_NOT_EQUAL = 98,
      TK_LEFT_SHIFT = 75,
      TK_RIGHT_SHIFT = 76,
      TK_UNSIGNED_RIGHT_SHIFT = 77,
      TK_PLUS_EQUAL = 78,
      TK_MINUS_EQUAL = 79,
      TK_MULTIPLY_EQUAL = 80,
      TK_DIVIDE_EQUAL = 81,
      TK_AND_EQUAL = 82,
      TK_OR_EQUAL = 83,
      TK_XOR_EQUAL = 84,
      TK_REMAINDER_EQUAL = 85,
      TK_LEFT_SHIFT_EQUAL = 86,
      TK_RIGHT_SHIFT_EQUAL = 87,
      TK_UNSIGNED_RIGHT_SHIFT_EQUAL = 88,
      TK_OR_OR = 104,
      TK_AND_AND = 99,
      TK_PLUS = 69,
      TK_MINUS = 70,
      TK_NOT = 71,
      TK_REMAINDER = 93,
      TK_XOR = 100,
      TK_AND = 101,
      TK_MULTIPLY = 90,
      TK_OR = 102,
      TK_TWIDDLE = 72,
      TK_DIVIDE = 94,
      TK_GREATER = 95,
      TK_LESS = 96,
      TK_LPAREN = 1,
      TK_RPAREN = 55,
      TK_LBRACE = 64,
      TK_RBRACE = 67,
      TK_LBRACKET = 65,
      TK_RBRACKET = 73,
      TK_SEMICOLON = 52,
      TK_QUESTION = 105,
      TK_COLON = 89,
      TK_COMMA = 68,
      TK_DOT = 66,
      TK_EQUAL = 74,
      TK_abstract = 3,
      TK_boolean = 23,
      TK_break = 24,
      TK_byte = 25,
      TK_case = 16,
      TK_catch = 17,
      TK_char = 26,
      TK_class = 13,
      TK_const = 53,
      TK_continue = 27,
      TK_default = 18,
      TK_do = 28,
      TK_double = 29,
      TK_else = 15,
      TK_extends = 19,
      TK_false = 30,
      TK_final = 4,
      TK_finally = 20,
      TK_float = 31,
      TK_for = 32,
      TK_goto = 54,
      TK_if = 33,
      TK_implements = 34,
      TK_import = 21,
      TK_instanceof = 14,
      TK_int = 35,
      TK_interface = 36,
      TK_long = 37,
      TK_native = 5,
      TK_new = 38,
      TK_null = 39,
      TK_package = 40,
      TK_private = 6,
      TK_protected = 7,
      TK_public = 8,
      TK_return = 41,
      TK_short = 42,
      TK_static = 9,
      TK_strictfp = 10,
      TK_super = 43,
      TK_switch = 44,
      TK_synchronized = 2,
      TK_this = 45,
      TK_throw = 46,
      TK_throws = 47,
      TK_transient = 11,
      TK_true = 48,
      TK_try = 49,
      TK_void = 50,
      TK_volatile = 12,
      TK_while = 22,
      TK_IDENTIFIER = 51,
      TK_EOF_TOKEN = 103,
      TK_ERROR_TOKEN = 106;

      public final static String orderedTerminalSymbols[] = {
                 "",
                 "LPAREN",
                 "synchronized",
                 "abstract",
                 "final",
                 "native",
                 "private",
                 "protected",
                 "public",
                 "static",
                 "strictfp",
                 "transient",
                 "volatile",
                 "class",
                 "instanceof",
                 "else",
                 "case",
                 "catch",
                 "default",
                 "extends",
                 "finally",
                 "import",
                 "while",
                 "boolean",
                 "break",
                 "byte",
                 "char",
                 "continue",
                 "do",
                 "double",
                 "false",
                 "float",
                 "for",
                 "if",
                 "implements",
                 "int",
                 "interface",
                 "long",
                 "new",
                 "null",
                 "package",
                 "return",
                 "short",
                 "super",
                 "switch",
                 "this",
                 "throw",
                 "throws",
                 "true",
                 "try",
                 "void",
                 "IDENTIFIER",
                 "SEMICOLON",
                 "const",
                 "goto",
                 "RPAREN",
                 "PLUS_PLUS",
                 "MINUS_MINUS",
                 "IntegerLiteral",
                 "LongLiteral",
                 "FloatingPointLiteral",
                 "DoubleLiteral",
                 "CharacterLiteral",
                 "StringLiteral",
                 "LBRACE",
                 "LBRACKET",
                 "DOT",
                 "RBRACE",
                 "COMMA",
                 "PLUS",
                 "MINUS",
                 "NOT",
                 "TWIDDLE",
                 "RBRACKET",
                 "EQUAL",
                 "LEFT_SHIFT",
                 "RIGHT_SHIFT",
                 "UNSIGNED_RIGHT_SHIFT",
                 "PLUS_EQUAL",
                 "MINUS_EQUAL",
                 "MULTIPLY_EQUAL",
                 "DIVIDE_EQUAL",
                 "AND_EQUAL",
                 "OR_EQUAL",
                 "XOR_EQUAL",
                 "REMAINDER_EQUAL",
                 "LEFT_SHIFT_EQUAL",
                 "RIGHT_SHIFT_EQUAL",
                 "UNSIGNED_RIGHT_SHIFT_EQUAL",
                 "COLON",
                 "MULTIPLY",
                 "LESS_EQUAL",
                 "GREATER_EQUAL",
                 "REMAINDER",
                 "DIVIDE",
                 "GREATER",
                 "LESS",
                 "EQUAL_EQUAL",
                 "NOT_EQUAL",
                 "AND_AND",
                 "XOR",
                 "AND",
                 "OR",
                 "EOF_TOKEN",
                 "OR_OR",
                 "QUESTION",
                 "ERROR_TOKEN"
             };

    public final static boolean isValidForParser = true;
}
