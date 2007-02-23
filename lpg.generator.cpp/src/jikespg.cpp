#include "symbol.h"
#include "option.h"
#include "scanner.h"
#include "option.h"
#include "control.h"

#include <assert.h>
#include <new>
using namespace std;

//
//
//
int main(int argc, char *argv[])
{
    //
    // If only "lpg" or "lpg ?*" is typed, we display the help
    // screen.
    //
    if (argc == 1 || argv[1][0] == '?' || strcmp(argv[1],"-h") == 0)
    {
        Option::PrintOptionsList();
        return 4;
    }


    try
    {
        Option option(argc, (const char **) argv);
        LexStream lex_stream(&option);
        VariableLookupTable variable_table;
        MacroLookupTable *macro_table = new MacroLookupTable();
        Scanner *scanner = new Scanner(&option, &lex_stream, &variable_table, macro_table);
        scanner -> Scan();
        delete scanner;

        if (! option.quiet)
        {
            cout << "\n"
                 << Control::HEADER_INFO
                 << " Version " << Control::VERSION
                 << "\n(C) Copyright IBM Corp. 1984, 2006.\n\n";
        }

#ifdef TEST
        lex_stream.Dump(); // TODO: REMOVE THIS !!!
#endif
        if (lex_stream.NumTokens() == 0 || scanner -> NumBadTokens() > 0)
        {
            delete macro_table;
        }
        else
        {
            Control control(&option, &lex_stream, &variable_table, macro_table);
            control.grammar -> Process();

            delete macro_table;

            control.ConstructParser();
        }
    }
    catch (bad_alloc b)
    {
        cerr << "***System Failure: Out of memory" << endl;
        exit(12);
    }

    return 0;
}
