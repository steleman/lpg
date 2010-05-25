#ifndef option_INCLUDED
#define option_INCLUDED

#include "util.h"
#include "code.h"
#include "tuple.h"
#include "blocks.h"
#include "symbol.h"

class LexStream;
class Token;
class VariableSymbol;
class Option : public Code, public Util
{
public:

    FILE *syslis;

    enum
    {
        //
        // Possible values for option "names"
        //
        MINIMUM = 1,
        MAXIMUM = 2,
        OPTIMIZED = 3,

        //
        // Possible values for rule_classnames
        //
        SEQUENTIAL = 1,
        STABLE = 2,

        //
        // Possible values for option "programming_language"
        //
        NONE = 0,
        XML = 1,
        C = 2,
        CPP = 3,
        JAVA = 4,
        PLX = 5,
        PLXASM = 6,
        ML = 7,

        //
        // Possible values for option "trace"
        //
        // NONE = 0,
        //
        CONFLICTS = 1,
        FULL = 2,

        //
        // Possible values for option "automatic_ast"
        //
        // NONE = 0,
        //
        NESTED = 1,
        TOPLEVEL = 2,

        //
        // Possible values for option "variables"
        //
        // NONE = 0,
        //
        BOTH = 1,
        NON_TERMINALS = 2,
        TERMINALS = 3,

        //
        // Possible values for option "visitor"
        //
        // NONE = 0,
        //
        DEFAULT = 1,
        PREORDER = 2
    };

    int return_code;

    const char *home_directory;
    Tuple<const char *> include_search_directory,
                        template_search_directory,
                        filter_file,
                        import_file;

    const char *template_directory,
               *ast_directory_prefix;

    bool attributes,
         backtrack,
         legacy,
         list,
         glr,
         slr,
         verbose,
         first,
         follow,
         priority,
         edit,
         states,
         xref,
         nt_check,
         conflicts,
         read_reduce,
         remap_terminals,
         goto_default,
         shift_default,
         byte,
         warnings,
         single_productions,
         error_maps,
         debug,
         parent_saved,
         scopes,
         serialize,
         soft_keywords,
         table;

    int lalr_level,
        margin,
        max_cases,
        names,
        rule_classnames,
        trace,
        programming_language,
        automatic_ast,
        variables,
        visitor;

    char escape,
         or_marker;

    const char *factory,
               *file_prefix,

               *grm_file,
               *lis_file,
               *tab_file,

               *dat_directory,
               *dat_file,
               *dcl_file,
               *def_file,
               *prs_file,
               *sym_file,
               *imp_file,
               *exp_file,
               *exp_prefix,
               *exp_suffix,

               *out_directory,
               *ast_directory,
               *ast_package;

    //private:
    const char *ast_type;
    //public:
    const char *exp_type,
               *prs_type,
               *sym_type,
               *dcl_type,
               *imp_type,
               *def_type,
               *action_type,
               *visitor_type,

               *filter,
               *import_terminals,
               *include_directory,
               *template_name,
               *extends_parsetable,
               *parsetable_interfaces,
               *package,
               *prefix,
               *suffix;

    bool quiet;

    TextBuffer report;
    LexStream *lex_stream;

    void SetLexStream(LexStream *lex_stream_) { this -> lex_stream = lex_stream_; }

    void FlushReport()
    {
        assert(syslis);
        report.Print(syslis);
        report.Flush(stdout);
    }

    Token *GetTokenLocation(const char *, int);
    void EmitHeader(Token *, const char *);
    void EmitHeader(Token *, Token *, const char *);
    void Emit(Token *, const char *, const char *);
    void Emit(Token *, const char *, Tuple<const char *> &);
    void Emit(Token *, Token *, const char *, const char *);
    void Emit(Token *, Token *, const char *, Tuple<const char *> &);
    void EmitError(int, const char *);
    void EmitError(int, Tuple<const char *> &);
    void EmitWarning(int, const char *);
    void EmitWarning(int, Tuple<const char *> &);
    void EmitInformative(int, const char *);
    void EmitInformative(int, Tuple<const char *> &);

    void EmitError(Token *token, const char *msg)                { Emit(token, "Error: ", msg); return_code = 12; }
    void EmitError(Token *token, Tuple<const char *> &msg)       { Emit(token, "Error: ", msg); return_code = 12; }
    void EmitWarning(Token *token, const char *msg)              { Emit(token, "Warning: ", msg); }
    void EmitWarning(Token *token, Tuple<const char *> &msg)     { Emit(token, "Warning: ", msg); }
    void EmitInformative(Token *token, const char *msg)          { Emit(token, "Informative: ", msg); }
    void EmitInformative(Token *token, Tuple<const char *> &msg) { Emit(token, "Informative: ", msg); }

    void EmitError(Token *startToken, Token *endToken, const char *msg)                { Emit(startToken, endToken, "Error: ", msg); return_code = 12; }
    void EmitError(Token *startToken, Token *endToken, Tuple<const char *> &msg)       { Emit(startToken, endToken, "Error: ", msg); return_code = 12; }
    void EmitWarning(Token *startToken, Token *endToken, const char *msg)              { Emit(startToken, endToken, "Warning: ", msg); }
    void EmitWarning(Token *startToken, Token *endToken, Tuple<const char *> &msg)     { Emit(startToken, endToken, "Warning: ", msg); }
    void EmitInformative(Token *startToken, Token *endToken, const char *msg)          { Emit(startToken, endToken, "Informative: ", msg); }
    void EmitInformative(Token *startToken, Token *endToken, Tuple<const char *> &msg) { Emit(startToken, endToken, "Informative: ", msg); }

    void InvalidValueError(const char *, const char *, int);
    void InvalidTripletValueError(const char *, int, const char *, const char *);

    Option(int argc_, const char **argv_) : argc(argc_),
                                            argv(argv_)
    {
        syslis = NULL;

        dat_directory_location = NULL;
        out_directory_location = NULL;
        ast_directory_location = NULL;
        escape_location = NULL;
        or_marker_location = NULL;

        lex_stream = NULL;

        return_code = 0;
        quiet = false;
        automatic_ast = NONE;
        attributes = false;
        backtrack = false;
        legacy = true;
        list = false;
        glr = false;
        slr = false;
        verbose = false;
        first = false;
        follow = false;
        priority = true;
        edit = false;
        states = false;
        xref = false;
        nt_check = false;
        conflicts = true;
        read_reduce = true;
        remap_terminals = true;
        goto_default = false;
        shift_default = false;
        byte = true;
        warnings = true;
        single_productions = false;
        error_maps = false;
        debug = false;
        parent_saved = false;
        scopes = false;
        serialize = false;
        soft_keywords = false;
        table = false;
        variables = NONE;
        visitor = NONE;
        lalr_level = 1;
        margin = 0;
        max_cases = 1024;
        names = OPTIMIZED;
        rule_classnames = SEQUENTIAL;
        trace = CONFLICTS;
        programming_language = XML;
        escape = ' ';
        or_marker = '|';
        factory = NULL;
        file_prefix = NULL;
        grm_file = NULL;
        lis_file = NULL;
        tab_file = NULL;
        dat_directory = NULL;
        dat_file = NULL;
        dcl_file = NULL;
        def_file = NULL;
        prs_file = NULL;
        sym_file = NULL;
        imp_file = NULL;
        exp_file = NULL;
        exp_prefix = NULL;
        exp_suffix = NULL;
        out_directory = NULL;
        ast_directory = NULL;
        ast_package = NULL;
        ast_type = NULL;
        exp_type = NULL;
        prs_type = NULL;
        sym_type = NULL;
        dcl_type = NULL;
        imp_type = NULL;
        def_type = NULL;
        action_type = NULL;
        visitor_type = NULL;
        filter = NULL;
        import_terminals = NULL;
        include_directory = NULL;
        template_name = NULL;
        extends_parsetable = NULL;
        parsetable_interfaces = NULL;
        package = NULL;
        prefix = NULL;
        suffix = NULL;
        default_action_prefix = NULL;
        default_action_file = NULL;

        for (int c = 0; c < 128; c++)
            classify_option[c] = &Option::ClassifyBadOption;

        classify_option[(int) 'a'] = &Option::ClassifyA;
        classify_option[(int) 'A'] = &Option::ClassifyA;

        classify_option[(int) 'b'] = &Option::ClassifyB;
        classify_option[(int) 'B'] = &Option::ClassifyB;

        classify_option[(int) 'c'] = &Option::ClassifyC;
        classify_option[(int) 'C'] = &Option::ClassifyC;

        classify_option[(int) 'd'] = &Option::ClassifyD;
        classify_option[(int) 'D'] = &Option::ClassifyD;

        classify_option[(int) 'e'] = &Option::ClassifyE;
        classify_option[(int) 'E'] = &Option::ClassifyE;

        classify_option[(int) 'f'] = &Option::ClassifyF;
        classify_option[(int) 'F'] = &Option::ClassifyF;

        classify_option[(int) 'g'] = &Option::ClassifyG;
        classify_option[(int) 'G'] = &Option::ClassifyG;

        classify_option[(int) 'h'] = &Option::ClassifyH;
        classify_option[(int) 'H'] = &Option::ClassifyH;

        classify_option[(int) 'i'] = &Option::ClassifyI;
        classify_option[(int) 'I'] = &Option::ClassifyI;

        classify_option[(int) 'l'] = &Option::ClassifyL;
        classify_option[(int) 'L'] = &Option::ClassifyL;

        classify_option[(int) 'm'] = &Option::ClassifyM;
        classify_option[(int) 'M'] = &Option::ClassifyM;

        classify_option[(int) 'n'] = &Option::ClassifyN;
        classify_option[(int) 'N'] = &Option::ClassifyN;

        classify_option[(int) 'o'] = &Option::ClassifyO;
        classify_option[(int) 'O'] = &Option::ClassifyO;

        classify_option[(int) 'p'] = &Option::ClassifyP;
        classify_option[(int) 'P'] = &Option::ClassifyP;

        classify_option[(int) 'q'] = &Option::ClassifyQ;
        classify_option[(int) 'Q'] = &Option::ClassifyQ;

        classify_option[(int) 'r'] = &Option::ClassifyR;
        classify_option[(int) 'R'] = &Option::ClassifyR;

        classify_option[(int) 's'] = &Option::ClassifyS;
        classify_option[(int) 'S'] = &Option::ClassifyS;

        classify_option[(int) 't'] = &Option::ClassifyT;
        classify_option[(int) 'T'] = &Option::ClassifyT;

        classify_option[(int) 'v'] = &Option::ClassifyV;
        classify_option[(int) 'V'] = &Option::ClassifyV;

        classify_option[(int) 'w'] = &Option::ClassifyW;
        classify_option[(int) 'W'] = &Option::ClassifyW;

        classify_option[(int) 'x'] = &Option::ClassifyX;
        classify_option[(int) 'X'] = &Option::ClassifyX;

        //
        //
        //
        if (argc > 1)
        {
            //
            // Process the LPG_TEMPLATE and LPG_INCLUDE environment variables, if they
            // were specified.
            //
            const char *main_input_file = argv[argc - 1],
                       *lpg_template = getenv("LPG_TEMPLATE"),
                       *lpg_include = getenv("LPG_INCLUDE");

            this -> home_directory = GetPrefix(main_input_file);
            char *temp = NewString(strlen(home_directory) +
                                   (lpg_template == NULL ? 0 : strlen(lpg_template)) +
                                   4);
            template_directory = temp;
            strcpy(temp, home_directory);
            if (lpg_template != NULL)
            {
                strcat(temp, ";");
                strcat(temp, lpg_template);
            }
            ProcessPath(template_search_directory, template_directory);

            temp = NewString(strlen(home_directory) +
                             (lpg_include == NULL ? 0 : strlen(lpg_include)) +
                             4);
            include_directory = temp;
            strcpy(temp, home_directory);
            if (lpg_include != NULL)
            {
                strcat(temp, ";");
                strcat(temp, lpg_include);
            }
            ProcessPath(include_search_directory, temp);

            int length = strlen(main_input_file);
            char *temp_file_prefix = NewString(length + 3);
            file_prefix = temp_file_prefix;

            grm_file = NewString(length + 3);

            char *temp_lis_file = NewString(length + 3);
            lis_file = temp_lis_file;

            char *temp_tab_file = NewString(length + 3);
            tab_file = temp_tab_file;

            //
            // Turn all backslashes into forward slashes in filename.
            //
            char *p = (char *) grm_file;
            for (const char *s = main_input_file; *s != '\0'; s++)
                *p++ = (*s == '\\' ? '/' : *s);
            *p = '\0'; // add terminating '\0'

            int slash_index,
                dot_index = -1;
            for (slash_index = length - 1;
                 slash_index >= 0 && grm_file[slash_index] != '\\' && grm_file[slash_index] != '/';
                 slash_index--)
            {
                if (grm_file[slash_index] == '.')
                    dot_index = slash_index;
            }

            const char *slash = (slash_index >= 0 ? &grm_file[slash_index] : NULL),
                       *dot = (dot_index >= 0 ? &grm_file[dot_index] : NULL),
                       *start = (slash ? slash + 1 : grm_file);
            if (dot == NULL) // if filename has no extension, copy it.
            {
                strcpy(temp_file_prefix, start);
                strcpy(temp_lis_file, start);
                strcpy(temp_tab_file, start);

                strcat(((char *) grm_file), ".g"); // add .g extension for input file
            }
            else // if file name contains an extension copy up to the dot
            {
                memcpy(temp_file_prefix, start, dot - start);
                memcpy(temp_lis_file, start, dot - start);
                memcpy(temp_tab_file, start, dot - start);
                temp_lis_file[dot - start] = '\0';
                temp_tab_file[dot - start] = '\0';
                temp_file_prefix[dot - start] = '\0';
            }

            strcat(temp_lis_file, ".l"); // add .l extension for listing file
            strcat(temp_tab_file, ".t"); // add .t extension for table file

            syslis = fopen(lis_file, "w");
            if (syslis  == (FILE *) NULL)
            {
                fprintf(stderr, "***ERROR: Listing file \"%s\" cannot be openned.\n", lis_file);
                throw 12;
            }
        }

        return;
    }

    ~Option()
    {
        //
        // Release all temporary strings now to save space.
        //
        for (int i = 0; i < temp_string.Length(); i++)
            delete [] temp_string[i];

        FlushReport();
        fclose(syslis); // close listing file

        return;
    }

    void ProcessUserOptions(InputFileSymbol *, char *, int);
    void ProcessCommandOptions();
    void CompleteOptionProcessing();
    void PrintOptionsInEffect();

    static void PrintOptionsList(void);

    Blocks &ActionBlocks() { return action_blocks; }
    BlockSymbol *DefaultBlock(void) { return default_block; }
    ActionFileSymbol *DefaultActionFile(void) { return default_action_file; }
    const char *DefaultActionPrefix(void) { return default_action_prefix; }

    const char *GetFilename(const char *);

private:

    int argc;
    const char **argv;

    class BlockInfo
    {
    public:
        Token *location;
        const char *filename,
                   *block_begin,
                   *block_end;
        void Set(Token *location_, const char *filename_, const char *block_begin_, const char *block_end_)
        {
            location = location_;
            filename = filename_;
            block_begin = block_begin_;
            block_end = block_end_;
        }
    };
    Tuple<BlockInfo> action_options,
                     header_options,
                     trailer_options;

    Token *dat_directory_location,
          *out_directory_location,
          *ast_directory_location,
          *escape_location,
          *or_marker_location;

    Blocks action_blocks;

    static const char *default_block_begin;
    static const char *default_block_end;

    InputFileSymbol *input_file_symbol;
    const char *buffer_ptr,
               *parm_ptr;

    BlockSymbol *default_block;
    ActionFileSymbol *default_action_file;
    const char *default_action_prefix;

    Tuple<char *> temp_string;
    char *NewString(int n) { return temp_string.Next() = new char[n]; }
    char *NewString(const char *in)
    {
        char *out = new char[strlen(in) + 1];
        temp_string.Next() = out;
        strcpy(out, in);
        return out;
    }
    char *NewString(const char *in, int length)
    {
        char *out = new char[length + 1];
        temp_string.Next() = out;
        strncpy(out, in, length);
        out[length] = NULL_CHAR;
        return out;
    }

    const char *AllocateString(const char *);
    const char *AllocateString(const char *, char);
    const char *AllocateString(const char *, const char *);
    const char *AllocateString(const char *, int);
    bool IsDelimiter(char);
    const char *CleanUp(const char *);
    const char *ValuedOption(const char *);
    const char *GetValue(const char *, const char *&);
    const char *GetStringValue(const char *, const char *&);
    int OptionMatch(const char *, const char *, const char *);

    const char *(Option::*classify_option[128])(const char *, bool);

    const char *ClassifyA(const char *, bool = true);
    const char *ClassifyB(const char *, bool = true);
    const char *ClassifyC(const char *, bool = true);
    const char *ClassifyD(const char *, bool = true);
    const char *ClassifyE(const char *, bool = true);
    const char *ClassifyF(const char *, bool = true);
    const char *ClassifyG(const char *, bool = true);
    const char *ClassifyH(const char *, bool = true);
    const char *ClassifyI(const char *, bool = true);
    const char *ClassifyL(const char *, bool = true);
    const char *ClassifyM(const char *, bool = true);
    const char *ClassifyN(const char *, bool = true);
    const char *ClassifyO(const char *, bool = true);
    const char *ClassifyP(const char *, bool = true);
    const char *ClassifyQ(const char *, bool = true);
    const char *ClassifyR(const char *, bool = true);
    const char *ClassifyS(const char *, bool = true);
    const char *ClassifyT(const char *, bool = true);
    const char *ClassifyV(const char *, bool = true);
    const char *ClassifyW(const char *, bool = true);
    const char *ClassifyX(const char *, bool = true);
    const char *ClassifyBadOption(const char *, bool = true);
    const char *AdvancePastOption(const char *);

    const char *ReportAmbiguousOption(const char *, const char *);
    const char *ReportMissingValue(const char *, const char *);
    const char *ReportValueNotRequired(const char *, const char *);

    void ProcessBlock(BlockInfo &);
    void ProcessHeader(BlockInfo &);
    void ProcessTrailer(BlockInfo &);
    void CheckBlockMarker(Token *, const char *);
    void CheckGlobalOptionsConsistency();
    void CheckAutomaticAst();

    void ProcessOptions(const char *);
    void ProcessPath(Tuple<const char *> &, const char *, const char * = NULL);
    const char *GetPrefix(const char *);
    const char *GetFile(const char *, const char *, const char *);
    const char *GetType(const char *);
    const char *ExpandFilename(const char *);
    void CheckDirectory(Token *, const char *);
};

#endif
