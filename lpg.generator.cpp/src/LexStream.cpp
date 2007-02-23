#include "LexStream.h"
#include "control.h"
#include "code.h"
#include "tab.h"

#include <sys/stat.h>
#include <iostream>
using namespace std;

static const char *TK_DEFINE_KEY_name           = "%Define",
                  *TK_MACRO_NAME_name           = "TK_MACRO_NAME",
                  *TK_SYMBOL_name               = "TK_SYMBOL",
                  *TK_BLOCK_name                = "TK_BLOCK",
                  *TK_TERMINALS_KEY_name        = "%Terminals",
                  *TK_SOFTKEYWORDS_KEY_name     = "%SoftKeywords",
                  *TK_EOL_KEY_name              = "%Eol",
                  *TK_EOF_KEY_name              = "%Eof",
                  *TK_ERROR_KEY_name            = "%Error",
                  *TK_IDENTIFIER_KEY_name       = "%Identifier",
                  *TK_ALIAS_KEY_name            = "%Alias",
                  *TK_START_KEY_name            = "%Start",
                  *TK_RULES_KEY_name            = "%Rules",
                  *TK_EQUIVALENCE_name          = "::=",
                  *TK_PRIORITY_EQUIVALENCE_name = "::=?",
                  *TK_ARROW_name                = "->",
                  *TK_PRIORITY_ARROW_name       = "->?",
                  *TK_NAMES_KEY_name            = "%Names",
                  *TK_END_KEY_name              = "%End",
                  *TK_OR_MARKER_name            = "|",
                  *TK_HEADERS_KEY_name          = "%Headers",
                  *TK_TRAILERS_KEY_name         = "%Trailers",
                  *TK_EOF_name                  = "%Eof",
                  *NULL_STRING                  = "";

const char *LexStream::KeywordName(int kind)
{
    switch(kind)
    {
        case TK_DEFINE_KEY:                 return TK_DEFINE_KEY_name;
        case TK_MACRO_NAME:                 return TK_MACRO_NAME_name;
        case TK_SYMBOL:                     return TK_SYMBOL_name;
        case TK_BLOCK:                      return TK_BLOCK_name;
        case TK_TERMINALS_KEY:              return TK_TERMINALS_KEY_name;
        case TK_SOFTKEYWORDS_KEY:           return TK_SOFTKEYWORDS_KEY_name;
        case TK_EOL_KEY:                    return TK_EOL_KEY_name;
        case TK_EOF_KEY:                    return TK_EOF_KEY_name;
        case TK_ERROR_KEY:                  return TK_ERROR_KEY_name;
        case TK_IDENTIFIER_KEY:             return TK_IDENTIFIER_KEY_name;
        case TK_ALIAS_KEY:                  return TK_ALIAS_KEY_name;
        case TK_START_KEY:                  return TK_START_KEY_name;
        case TK_RULES_KEY:                  return TK_RULES_KEY_name;
        case TK_EQUIVALENCE:                return TK_EQUIVALENCE_name;
        case TK_PRIORITY_EQUIVALENCE:       return TK_PRIORITY_EQUIVALENCE_name;
        case TK_ARROW:                      return TK_ARROW_name;
        case TK_PRIORITY_ARROW:             return TK_PRIORITY_ARROW_name;
        case TK_NAMES_KEY:                  return TK_NAMES_KEY_name;
        case TK_END_KEY:                    return TK_END_KEY_name;
        case TK_OR_MARKER:                  return TK_OR_MARKER_name;
        case TK_HEADERS_KEY:                return TK_HEADERS_KEY_name;
        case TK_TRAILERS_KEY:               return TK_TRAILERS_KEY_name;
        case TK_EOF:                        return TK_EOF_name;

        default:                            break;
    }

    return NULL_STRING;
}


InputFileSymbol *LexStream::FindOrInsertFile(Tuple<const char *> &search_directory, const char *filename)
{
    //
    // Look in the search directory path for the filename.
    //
    char *full_filename = NULL;
    int filename_length = strlen(filename);
    for (int i = 0; i < search_directory.Length(); i++)
    {
        const char *directory_name = search_directory[i];
        int directory_name_length = strlen(directory_name),
            length = directory_name_length + filename_length;
        full_filename = new char[length + 2];
        strcpy(full_filename, directory_name);
        int index = directory_name_length;
        if (directory_name_length > 0 &&
            directory_name[directory_name_length - 1] != '\\' &&
            directory_name[directory_name_length - 1] != '/')
            full_filename[index++] = '/';
        if (*filename == '<') // remove brackets from bracketed symbols: <...>
        {
            strncpy(&(full_filename[index]), filename + 1, filename_length - 2);
            full_filename[index + (filename_length - 2)] = '\0';
        }
        else strcpy(&(full_filename[index]), filename);

        struct stat status;
        if (stat(full_filename, &status) == 0)
            break;
        delete [] full_filename;
        full_filename = NULL;
    }

    InputFileSymbol *file_symbol = NULL;
    if (full_filename != NULL)
    {
        //
        // Turn all backslashes into forward slashes in filename.
        //
        for (char *s = full_filename; *s != '\0'; s++)
        {
            if (*s == '\\')
                *s = '/';
        }

        //
        // No need to normalize full_filename as if two separate
        // names are used to access the same file, eventually, we
        // will have to revisit one of the names again. Therefore,
        // at worst, it may take a bit longer to detect the loop,
        // but sooner or later, it will be detected.
        //
        file_symbol = file_table.FindOrInsertName(full_filename, strlen(full_filename));
    }

    delete [] full_filename;

    return file_symbol;
} 
