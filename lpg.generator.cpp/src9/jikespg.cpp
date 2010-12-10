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

    //
    // We declare the scanner first and initialize it to NULL in case
    // an exceptional condition occurs and it has to be deleted.
    // See try/catch below.
    //
    Scanner *scanner = NULL;

    try
    {
        Option option(argc, (const char **) argv);
        LexStream lex_stream(&option);
        VariableLookupTable variable_table;
        MacroLookupTable macro_table;

        scanner = new Scanner(&option, &lex_stream, &variable_table, &macro_table);
        scanner -> Scan();

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
        if (lex_stream.NumTokens() == 0 || scanner -> NumErrorTokens() > 0)
        {
            //
            // Save some space by deleting the scanner.
            //
            // Note that the scanner is set to NULL after being
            // deleted to avoid a dangling pointer situation that may occur in
            // case an exceptional condition occurs. See try/catch below.
            //
            delete scanner; scanner = NULL; // Note use of scanner in test above... DO NOT move this command!
        }
        else
        {
            delete scanner; scanner = NULL; // Note use of scanner in if statement above... DO NOT move this command!

            Control control(&option, &lex_stream, &variable_table, &macro_table);
            control.Process();
        }
    }
    catch (bad_alloc b)
    {
        cerr << "***OS System Failure: Out of memory" << endl;
        cerr.flush();

        delete scanner;
        exit(12);
    }
    catch (int code)
    {
        delete scanner;
        exit(code);
    }
    catch (const char *str)
    {
        cerr <<"*** " << str << endl;
        cerr.flush();

        delete scanner;
        exit(12);
    }

    return 0;
}
