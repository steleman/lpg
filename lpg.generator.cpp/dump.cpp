#ifdef TEST

#include "LexStream.h"
#include "code.h"
#include "jikespg_sym.h"

#include <stdio.h>
#include <iostream>
using namespace std;

//
// THIS IS TEMPORARY CODE THAT WILL DISAPPEAR at some point !!!
//
static const char *TK_INCLUDE_KEY_STRING       = "TK_INCLUDE_KEY",
                  *TK_DEFINE_KEY_STRING        = "TK_DEFINE_KEY",
                  *TK_DROPSYMBOLS_KEY_STRING   = "TK_DROPSYMBOLS_KEY",
                  *TK_DROPRULES_KEY_STRING     = "TK_DROPRULES_KEY",
                  *TK_MACRO_NAME_STRING        = "TK_MACRO_NAME",
                  *TK_SYMBOL_STRING            = "TK_SYMBOL",
                  *TK_BLOCK_STRING             = "TK_BLOCK",
                  *TK_TERMINALS_KEY_STRING     = "TK_TERMINALS_KEY",
                  *TK_SOFTKEYWORDS_KEY_STRING  = "TK_SOFTKEYWORDS_KEY",
                  *TK_TYPES_KEY_STRING         = "TK_TYPES_KEY",
                  *TK_IMPORT_KEY_STRING        = "TK_IMPORT_KEY",
                  *TK_EOL_KEY_STRING           = "TK_EOL_KEY",
                  *TK_EOF_KEY_STRING           = "TK_EOF_KEY",
                  *TK_ERROR_KEY_STRING         = "TK_ERROR_KEY",
                  *TK_IDENTIFIER_KEY_STRING    = "TK_IDENTIFIER_KEY",
                  *TK_ALIAS_KEY_STRING         = "TK_ALIAS_KEY",
                  *TK_START_KEY_STRING         = "TK_START_KEY",
                  *TK_RULES_KEY_STRING         = "TK_RULES_KEY",
                  *TK_EQUIVALENCE_STRING       = "TK_EQUIVALENCE",
                  *TK_ARROW_STRING             = "TK_ARROW",
                  *TK_NAMES_KEY_STRING         = "TK_NAMES_KEY",
                  *TK_END_KEY_STRING           = "TK_END_KEY",
                  *TK_EMPTY_KEY_STRING         = "TK_EMPTY_KEY",
                  *TK_OR_MARKER_STRING         = "TK_OR_MARKER",
                  *TK_EOF_STRING               = "TK_EOF",
                  *NULL_STRING                 = "";

static const char *token_type(unsigned char kind)
{
    switch(kind)
    {
        case TK_INCLUDE_KEY:       return TK_INCLUDE_KEY_STRING;
        case TK_DEFINE_KEY:        return TK_DEFINE_KEY_STRING;
        case TK_DROPSYMBOLS_KEY:   return TK_DROPSYMBOLS_KEY_STRING;
        case TK_DROPRULES_KEY:     return TK_DROPRULES_KEY_STRING;
        case TK_TERMINALS_KEY:     return TK_TERMINALS_KEY_STRING;
        case TK_SOFTKEYWORDS_KEY:  return TK_SOFTKEYWORDS_KEY_STRING;
        case TK_TYPES_KEY:         return TK_TYPES_KEY_STRING;
        case TK_IMPORT_KEY:        return TK_IMPORT_KEY_STRING;
        case TK_EOL_KEY:           return TK_EOL_KEY_STRING;
        case TK_EOF_KEY:           return TK_EOF_KEY_STRING;
        case TK_ERROR_KEY:         return TK_ERROR_KEY_STRING;
        case TK_IDENTIFIER_KEY:    return TK_IDENTIFIER_KEY_STRING;
        case TK_ALIAS_KEY:         return TK_ALIAS_KEY_STRING;
        case TK_EMPTY_KEY:         return TK_EMPTY_KEY_STRING;
        case TK_START_KEY:         return TK_START_KEY_STRING;
        case TK_RULES_KEY:         return TK_RULES_KEY_STRING;
        case TK_NAMES_KEY:         return TK_NAMES_KEY_STRING;
        case TK_END_KEY:           return TK_END_KEY_STRING;
        case TK_MACRO_NAME:        return TK_MACRO_NAME_STRING;
        case TK_SYMBOL:            return TK_SYMBOL_STRING;
        case TK_BLOCK:             return TK_BLOCK_STRING;
        case TK_EQUIVALENCE:       return TK_EQUIVALENCE_STRING;
        case TK_ARROW:             return TK_ARROW_STRING;
        case TK_OR_MARKER:         return TK_OR_MARKER_STRING;
        case TK_EOF:               return TK_EOF_STRING;
        default:                   return NULL_STRING;
    }
}

void LexStream::Dump()
{
    FILE *tokfile;
    char *tokfile_name = "a.tok";

    if ((tokfile = fopen(tokfile_name, "w")) == NULL)
    {
        cout << "*** Cannot open file " << tokfile_name << "\n";
        return;
    }

    if (NumTokens() == 0)
        return;

    LexStream::TokenIndex tok = 0;
    Reset();
    do
    {
        tok = Gettoken();

        fprintf(tokfile, "%6d ", tok);
        fprintf(tokfile, " %s",FileName(tok));
        fprintf(tokfile, ", %cline %d.%d-%d.%d: %s %s\n",
                         (AfterEol(tok) ? '*' : ' '),
                         Line(tok),
                         Column(tok),
                         EndLine(tok),
                         EndColumn(tok),
                         token_type(Kind(tok)),
                         NameString(tok));
    } while (Kind(tok) != TK_EOF);

    fprintf(tokfile, "\n");
    fflush(tokfile);

    if (tokfile)
        fclose(tokfile);

    return;
}

#endif
