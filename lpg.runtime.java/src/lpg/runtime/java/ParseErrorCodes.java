package lpg.runtime.java;

public interface ParseErrorCodes
{
    public static final int  LEX_ERROR_CODE = 0,
                             ERROR_CODE = 1,
                             BEFORE_CODE = 2,
                             INSERTION_CODE = 3,
                             INVALID_CODE = 4,
                             SUBSTITUTION_CODE = 5,
                             SECONDARY_CODE = 5,
                             DELETION_CODE = 6,
                             MERGE_CODE = 7,
                             MISPLACED_CODE = 8,
                             SCOPE_CODE = 9,
                             EOF_CODE = 10,
                             INVALID_TOKEN_CODE = 11,
                             ERROR_RULE_ERROR_CODE = 11,
                             ERROR_RULE_WARNING_CODE = 12,
                             NO_MESSAGE_CODE = 14;

    public static final String errorMsgText[] = {
        /* LEX_ERROR_CODE */                       "unexpected character ignored",
        /* ERROR_CODE */                           "parsing terminated at this token",
        /* BEFORE_CODE */                          "inserted before this token",
        /* INSERTION_CODE */                       "expected after this token",
        /* INVALID_CODE */                         "unexpected input discarded",
        /* SUBSTITUTION_CODE, SECONDARY_CODE */    "expected instead of this input",
        /* DELETION_CODE */                        "unexpected token(s) ignored",
        /* MERGE_CODE */                           "formed from merged tokens",
        /* MISPLACED_CODE */                       "misplaced construct(s)",
        /* SCOPE_CODE */                           "inserted to complete scope",
        /* EOF_CODE */                             "reached after this token",
        /* INVALID_TOKEN_CODE, ERROR_RULE_ERROR */ "is invalid",
        /* ERROR_RULE_WARNING */                   "is ignored",
        /* NO_MESSAGE_CODE */                      ""
    };

}
        
