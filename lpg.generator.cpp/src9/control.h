#ifndef CONTROL_INCLUDED
#define CONTROL_INCLUDED

#include "option.h"
#include "grammar.h"
#include "node.h"
#include "base.h"
#include "dfa.h"
#include "pda.h"
#include "produce.h"

//
//
//
class Generator;
class Table;

class Control
{
    void PrintBasicStatistics(void);
    void PrintAllStatistics(Generator *, Table *);

public:

    Control(Option *option_,
            LexStream *lex_stream_,
            VariableLookupTable *variable_table_,
            MacroLookupTable *macro_table_) : option(option_),
                                              lex_stream(lex_stream_),
                                              variable_table(variable_table_),
                                              macro_table(macro_table_),

                                              node_pool(NULL),
                                              grammar(NULL),
                                              base(NULL),
                                              dfa(NULL),
                                              produce(NULL),
                                              pda(NULL)
    {
        node_pool = new NodePool();
        grammar = new Grammar(this);
        base = new Base(this);
        dfa = new Dfa(this);
        produce = new Produce(this);
        pda = new Pda(this);

        //
        // Flush buffer to print options and initial reports
        //
        if (! option -> quiet)
            option -> FlushReport();
    }

    //
    // Close listing file and destroy the objects allocated in the constructor.
    //
    ~Control() { CleanUp(); }

    void CleanUp()
    {
        delete node_pool; node_pool = NULL;
        delete grammar; grammar = NULL;
        delete base; base = NULL;
        delete produce; produce = NULL;
        delete dfa; dfa = NULL;
        delete pda; pda = NULL;
    }

    enum
    {
        SYMBOL_SIZE = 256,
        PRINT_LINE_SIZE = 80
    };

    static const char HEADER_INFO[],
                      VERSION[];

    void PrintHeading(int code = 0)
    {
        fprintf(option -> syslis, "\f\n\n %-39s%s\n\n", HEADER_INFO, VERSION);
        return;
    }

    void InvalidateFile(const char *, const char *);
    void Exit(int);

    void Process(void);

    Option *option;
    LexStream *lex_stream;
    VariableLookupTable *variable_table;
    MacroLookupTable *macro_table;
    NodePool *node_pool;
    Base *base;
    Dfa *dfa;
    Pda *pda;
    Produce *produce;
    Grammar *grammar;
};
#endif /* CONTROL_INCLUDED */
