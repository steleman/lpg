#include "control.h"
#include "generator.h"
#include "Action.h"
#include "CAction.h"
#include "CppAction.h"
#include "PlxAction.h"
#include "PlxasmAction.h"
#include "JavaAction.h"
#include "MlAction.h"
#include "XmlAction.h"
#include "table.h"
#include "CTable.h"
#include "CppTable.h"
#include "JavaTable.h"
#include "PlxTable.h"
#include "PlxasmTable.h"
#include "MlTable.h"
#include "XmlTable.h"

#include <string.h>
#include <iostream>
using namespace std;

const char Control::HEADER_INFO[]  = "IBM LALR Parser Generator",
           Control::VERSION[] = "2.0.21 (" __DATE__ ")";

//
//
//
void Control::Process(void)
{
    Blocks *action_blocks = &(option -> ActionBlocks());
    Action *action = (option -> programming_language == Option::C
                          ? new CAction(this, action_blocks, grammar, macro_table)
                          : (option -> programming_language == Option::CPP
                                 ? new CppAction(this, action_blocks, grammar, macro_table)
                                 : (option -> programming_language == Option::JAVA
                                        ? new JavaAction(this, action_blocks, grammar, macro_table)
                                        : (option -> programming_language == Option::PLX
                                               ? new PlxAction(this, action_blocks, grammar, macro_table)
                                               : (option -> programming_language == Option::PLXASM
                                                      ? new PlxasmAction(this, action_blocks, grammar, macro_table)
                                                      : (option -> programming_language == Option::ML
                                                             ? new MlAction(this, action_blocks, grammar, macro_table)
                                                             : (Action *) new XmlAction(this, action_blocks, grammar, macro_table)))))));

    //
    // ProcessGrammar:
    //
    try
    {
        grammar -> ProcessInput(action);
    }
    catch(int code)
    {
        CleanUp();
        throw code;
    }
    catch (const char *str)
    {
        CleanUp();
        throw str;
    }

    //
    // By the time this function is invoked, the source input has already
    // been fully processed. More specifically, the scanner is invoked in the
    // main program, jikespg.cpp. The parser and the grammar are constructed
    // and invoked in the constructor of this object, Control::Control.
    //
    Generator *generator = NULL;
    Table *table = NULL;

    //
    // ConstructParser:
    //
    try
    {
        //
        // If the user only wanted to edit his grammar, we quit the program.
        //
        if (option -> edit)
        {
            if (option -> first || option -> follow || option -> xref)
            {
                base -> ProcessBasicMaps();
                grammar -> ProcessGrammarOutput(action);
                base -> ProcessBaseOutput();
            }

            PrintBasicStatistics();

            return;
        }

        base -> ProcessBasicMaps();                       // Build basic maps
        dfa -> ProcessDFA();                              // build state automaton
        produce -> ProcessAdvancedMaps();                 // build scopes maps and others,...
        grammar -> ProcessActions(action, base, produce); // generate AST nodes and actions
        pda -> ProcessPDA();                              // Build Reduce map

        grammar -> ProcessGrammarOutput(action);
        base -> ProcessBaseOutput();
        produce -> ProcessScopesOutput();
        pda -> ProcessPDAOutput();

        //
        // Free up some space!
        //
        delete action; action= NULL; // action no longer needed.
        macro_table -> Reset();      // macro table no longer needed.

        //
        // If the tables are requested, we process them.
        //
        if (option -> table)
        {
            if (option -> goto_default && option -> nt_check)
                option -> EmitError(0, "The options GOTO_DEFAULT and NT_CHECK are incompatible. Tables not generated");
            else
            {
                generator = new Generator(this);
                generator -> ProcessCompressionAndGeneration();
                table = (option -> programming_language == Option::C
			 ? new CTable(this)
                                : (option -> programming_language == Option::CPP
                                       ? new CppTable(this)
                                       : (option -> programming_language == Option::JAVA
                                              ? new JavaTable(this)
                                              : (option -> programming_language == Option::PLX
                                                     ? new PlxTable(this)
                                                     : (option -> programming_language == Option::PLXASM
                                                            ? new PlxasmTable(this)
                                                            : (option -> programming_language == Option::ML
                                                                   ? new MlTable(this)
                                                                   : (Table *) new XmlTable(this)))))));
                generator -> Generate(table);
                table -> OutputTables();
                if (option -> states)
                    table -> PrintStateMaps();
            }
        }

        PrintAllStatistics(generator, table);

        option -> FlushReport();

        delete generator; generator = NULL;
        delete table; table = NULL;
    }
    catch(int code)
    {
        delete generator;
        delete table;

        CleanUp();
        throw code;
    }
    catch (const char *str)
    {
        delete generator;
        delete table;

        CleanUp();
        throw str;
    }

    return;
}


void Control::InvalidateFile(const char *filename, const char *filetype)
{
    FILE *file = fopen(filename, "wb");
    if (file == NULL) // could not open file...
        return;

    UnbufferedTextFile buffer(&file);

    switch(option -> programming_language)
    {
        case Option::CPP:
        case Option::C:
             break;
        case Option::PLXASM:
        case Option::PLX:
             break;
        case Option::JAVA:
             if (strlen(option -> package) > 0)
             {
                 buffer.Put("package ");
                 buffer.Put(option -> package);
                 buffer.Put(";\n\n");
             }
             buffer.Put("/**\n"
                        " * This class is invalid because LPG stopped while processing\n"
                        " * the grammar file \"");
             buffer.Put(option -> grm_file);
             buffer.Put("\"\n");
             buffer.Put(" */\n"
                        "public class Bad");
             buffer.Put(filetype);
             buffer.Put(" {}\n\n");
             break;
        case Option::ML:
             break;
        case Option::XML:
             break;
        default:
             break;
    }

    buffer.Flush();
    fclose(file);

    return;
}


//
//
//
void Control::PrintBasicStatistics(void)
{
    if (option -> quiet)
        return;

    option -> report.Put("\nNumber of Terminals: ");
    option -> report.Put(grammar -> num_terminals - 1); //-1 for %empty
    option -> report.PutChar('\n');
    option -> report.Put("Number of Nonterminals: ");
    option -> report.Put(grammar -> num_nonterminals - 1); // -1 for %ACC
    option -> report.PutChar('\n');
    option -> report.Put("Number of Productions: ");
    option -> report.Put(grammar -> num_rules + 1);
    option -> report.PutChar('\n');

    if (option -> single_productions)
    {
        option -> report.Put("Number of Single Productions: ");
        option -> report.Put(grammar -> num_single_productions);
        option -> report.PutChar('\n');
    }

    option -> report.Put("Number of Items: ");
    option -> report.Put(grammar -> num_items);
    option -> report.PutChar('\n');

    option -> FlushReport();

    return;
}

//
//
//
void Control::PrintAllStatistics(Generator *generator, Table *table)
{
    if (option -> quiet)
        return;

    PrintBasicStatistics();

    if (option -> scopes)
    {
        option -> report.Put("Number of Scopes: ");
        option -> report.Put(produce -> scope_prefix.Size());
        option -> report.PutChar('\n');
    }

    option -> report.Put("Number of States: ");
    option -> report.Put(dfa -> num_states);
    option -> report.PutChar('\n');

    if (pda -> max_la_state > dfa -> num_states)
    {
        option -> report.Put("Number of look-ahead states: ");
        option -> report.Put(pda -> max_la_state - dfa -> num_states);
        option -> report.PutChar('\n');
    }

    option -> report.Put("Number of Shift actions: ");
    option -> report.Put(dfa -> num_shifts);
    option -> report.PutChar('\n');

    option -> report.Put("Number of Goto actions: ");
    option -> report.Put(dfa -> num_gotos);
    option -> report.PutChar('\n');

    if (option -> read_reduce)
    {
        option -> report.Put("Number of Shift/Reduce actions: ");
        option -> report.Put(dfa -> num_shift_reduces);
        option -> report.PutChar('\n');
        option -> report.Put("Number of Goto/Reduce actions: ");
        option -> report.Put(dfa -> num_goto_reduces);
        option -> report.PutChar('\n');
    }

    option -> report.Put("Number of Reduce actions: ");
    option -> report.Put(pda -> num_reductions);
    option -> report.PutChar('\n');

    if (! pda -> not_lrk)
    {
        option -> report.Put("Number of Shift-Reduce conflicts: ");
        option -> report.Put(pda -> num_shift_reduce_conflicts);
        option -> report.PutChar('\n');
        option -> report.Put("Number of Reduce-Reduce conflicts: ");
        option -> report.Put(pda -> num_reduce_reduce_conflicts);
        option -> report.PutChar('\n');
    }

    if (grammar -> keywords.Length() > 0)
    {
        option -> report.Put("Number of Keyword/Identifier Shift conflicts: ");
        option -> report.Put(pda -> num_shift_shift_conflicts);
        option -> report.PutChar('\n');
        option -> report.Put("Number of Keyword/Identifier Shift-Reduce conflicts: ");
        option -> report.Put(pda -> num_soft_shift_reduce_conflicts);
        option -> report.PutChar('\n');
        option -> report.Put("Number of Keyword/Identifier Reduce-Reduce conflicts: ");
        option -> report.Put(pda -> num_soft_reduce_reduce_conflicts);
        option -> report.PutChar('\n');
    }

    option -> report.Put(generator -> GetReport());
    table -> PrintReport();

    option -> FlushReport();

    return;
}


//
//
//
void Control::Exit(int code)
{
    InvalidateFile(option -> prs_file, option -> prs_type);
    InvalidateFile(option -> sym_file, option -> sym_type);
    if (grammar -> exported_symbols.Length() > 0)
        InvalidateFile(option -> exp_file, option -> exp_type);
    switch(option -> programming_language)
    {
        case Option::CPP:
        case Option::C:
             InvalidateFile(option -> dcl_file, option -> dcl_type);
             break;
        case Option::PLXASM:
        case Option::PLX:
             InvalidateFile(option -> dcl_file, option -> dcl_type);
             InvalidateFile(option -> def_file, option -> def_type);
             InvalidateFile(option -> imp_file, option -> imp_type);
             break;
        case Option::JAVA:
             break;
        case Option::ML:
             InvalidateFile(option -> dcl_file, option -> dcl_type);
             InvalidateFile(option -> imp_file, option -> imp_type);
             break;
        case Option::XML:
             break;
        default:
             break;
    }

    //
    // Before exiting, flush the report buffer.
    //
    option -> FlushReport();

    CleanUp();

    throw code;

    return;
}
