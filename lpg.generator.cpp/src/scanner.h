#ifndef scanner_INCLUDED
#define scanner_INCLUDED

#include "code.h"
#include "jikespg_sym.h"
#include "option.h"
#include "LexStream.h"
#include "symbol.h"
#include "tuple.h"

class Arguments
{
public:
    Arguments(Option *option, const char *filename, const char *exp_file, const char *exp_prefix, const char *exp_suffix) : argc(7)
    {
        const char *quiet_header = "-quiet",
                   *noquiet_header = "-noquiet",
                   *export_header = "-export_terminals=(\"",
                   *include_header = "-include=",
                   *package_header = "-package=",
                   *ast_directory_header = "-ast_directory=";
        char *quiet_arg = new char[strlen(noquiet_header) + 1],
             *export_arg = new char[strlen(export_header) +
                                    strlen(exp_file) +
                                    strlen(exp_prefix) +
                                    strlen(exp_suffix) + 11],
             *include_arg = new char[strlen(include_header) + strlen(option -> include_directory) + 1],
             *package_arg = new char[strlen(package_header) + strlen(option -> package) + 1],
             *ast_directory_arg = new char[strlen(ast_directory_header) + strlen(option -> ast_directory) + 1];

        strcpy(quiet_arg, option -> quiet ? quiet_header : noquiet_header);

        strcpy(export_arg, export_header);
        strcat(export_arg, exp_file);
        strcat(export_arg, "\", \"");
        strcat(export_arg, exp_prefix);
        strcat(export_arg, "\", \"");
        strcat(export_arg, exp_suffix);
        strcat(export_arg, "\")");

        strcpy(include_arg, include_header);
        strcat(include_arg, option -> include_directory);

        strcpy(package_arg, package_header);
        strcat(package_arg, option -> package);

        strcpy(ast_directory_arg, ast_directory_header);
        strcat(ast_directory_arg, option -> ast_directory);

        argv = new const char *[argc];
        argv[0] = NULL;
        argv[1] = quiet_arg;
        argv[2] = export_arg;
        argv[3] = include_arg;
        argv[4] = package_arg;
        argv[5] = ast_directory_arg;
        argv[6] = filename;
    }

    ~Arguments()
    {
        for (int i = 1; i < argc - 2; i++)
            delete [] ((char *) argv[i]);
        delete [] argv;
    }

    int argc;
    const char **argv;
};


class ImportArguments : public Arguments
{
public:
    ImportArguments(Option *option, const char *filename) : Arguments(option, 
                                                                      filename,
                                                                      option -> sym_file,
                                                                      option -> prefix,
                                                                      option -> suffix)
    {}
};


class FilterArguments : public Arguments
{
public:
    FilterArguments(Option *option, const char *filename) : Arguments(option, 
                                                                      filename,
                                                                      option -> exp_file,
                                                                      option -> exp_prefix,
                                                                      option -> exp_suffix)
    {}
};


//
// The Scanner object
//
class Scanner : public Code
{
public:

    Scanner(Option *option_,
            LexStream *lex_stream_,
            VariableLookupTable *variable_table_,
            MacroLookupTable *macro_table_) : option(option_),
                                              lex_stream(lex_stream_),
                                              variable_table(variable_table_),
                                              macro_table(macro_table_),
                                              action_blocks(&(option_ -> ActionBlocks())),
                                              input_file(NULL)
    {}

    ~Scanner() {}

    void Scan();
    void Scan(int);

    inline int NumBadTokens() { return bad_tokens.Length(); }

private:
    enum StreamErrorKind
    {
        NO_ERROR,
        NO_INPUT,
        NO_TEMPLATE,
        NO_INCLUDE,
        RECURSIVE_INCLUDE,
        BAD_UNICODE,
        BAD_OCTAL_ASCII_CODE,
        ISOLATED_BACKSLASH,
        UNDELIMITED_STRING_SYMBOL,
        UNTERMINATED_STRING_SYMBOL,
        UNTERMINATED_BRACKET_SYMBOL,
        UNTERMINATED_BLOCK
    };

    class BadToken
    {
    public:
        int msg_code,
            token_index;

        void Initialize(int msg_code_, int token_index_)
        {
            msg_code = msg_code_;
            token_index = token_index_;
        }
    };

    Option *option;
    LexStream *lex_stream;
    VariableLookupTable *variable_table;
    MacroLookupTable *macro_table;
    Blocks *action_blocks;

    InputFileSymbol *input_file;
    Tuple<unsigned> *line_location;
    char *input_buffer,
         *cursor;
    Token *current_token;
    int current_token_index;

    enum { SCAN_KEYWORD_SIZE = 24 + 1 };

    static int (*scan_keyword[SCAN_KEYWORD_SIZE]) (char *p1);
    static int ScanKeyword0(char *p1);
    static int ScanKeyword4(char *p1);
    static int ScanKeyword6(char *p1);
    static int ScanKeyword7(char *p1);
    static int ScanKeyword8(char *p1);
    static int ScanKeyword9(char *p1);
    static int ScanKeyword10(char *p1);
    static int ScanKeyword11(char *p1);
    static int ScanKeyword12(char *p1);
    static int ScanKeyword13(char *p1);
    static int ScanKeyword24(char *p1);

    void ReportErrors();
    void ScanOptions(InputFileSymbol *);
    void SkipOptions();
    void ImportTerminals(const char *);
    void ProcessFilters(const char *);
    void Scan(char *, char *);
    void ScanComment();
    void SkipSpaces();

    void Setup();
    void ClassifyBlock(Tuple<BlockSymbol *> &);

    void (Scanner::*classify_token[256])();

    void ClassifyBadToken();
    void ClassifyEscapedSymbol();
    void ClassifySingleQuotedSymbol();
    void ClassifyDoubleQuotedSymbol();
    void ClassifyLess();
    void ClassifySymbol();
    void ClassifyEquivalence();
    void ClassifyArrow();
    void ClassifyOr();
    void ClassifyEof();

    void ImportFiles(int, int);
    int IncludeFile(const char *);

    void ResetBadTokens() { bad_tokens.Reset(); }
    void AddBadToken(int error_kind, LexStream::TokenIndex index) { bad_tokens.Next().Initialize(error_kind, index); }

    Tuple<BadToken> bad_tokens;
};

#endif
