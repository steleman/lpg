
#line 129 "jikespg.g"
#ifndef jikespg_act_INCLUDED
#define jikespg_act_INCLUDED

#include "Stacks.h"
#include <assert.h>

class Control;
class Parser;
class jikespg_act : public Stacks
{
public:
    //
    //
    //
    jikespg_act(Control *control_,
                LexStream *lex_stream_,
                VariableLookupTable *variable_table_,
                MacroLookupTable *macro_table_);

    //
    //
    //
    int identifier_index,
        eol_index,
        eof_index,
        error_index;

    Tuple<int> terminals,
               keywords,
               exports,
               recovers,
               start_indexes;

    class PredecessorSetDefinition
    {
    public:
        int lhs_index,
            rhs_index;
    };
    Tuple<PredecessorSetDefinition> predecessor_candidates;

    class AliasDefinition
    {
    public:
        int lhs_index,
            rhs_index;
    };
    Tuple<AliasDefinition> aliases;

    class NameDefinition
    {
    public:
        int lhs_index,
            rhs_index;
    };
    Tuple<NameDefinition> names;

    Tuple<int> notice_blocks,
               global_blocks,
               ast_blocks,
               header_blocks,
               initial_blocks,
               trailer_blocks;

    class RuleDefinition
    {
    public:
      int lhs_index,
          classname_index,
          array_element_type_index,
          separator_index,
          end_rhs_index;
    };
    Tuple<RuleDefinition> rules,
                          dropped_rules,
                          prostheses;

    class TypeDefinition
    {
    public:
      int type_index,
          separator_index,
          symbol_index,
          block_index;
    };
    Tuple<TypeDefinition> types;

    class ImportedStartIndexes
    {
    public:
        int import_file_index;
        Tuple<int> start_indexes;
    };
    Tuple<ImportedStartIndexes> imported_start_indexes;

protected:

    Control *control;
    Option *option;
    LexStream *lex_stream;
    VariableLookupTable *variable_table;
    MacroLookupTable *macro_table;

    TokenObject curtok;

    //
    //
    //
    enum
    {
        MACRO_EXPECTED_INSTEAD_OF_SYMBOL,
        SYMBOL_EXPECTED_INSTEAD_OF_MACRO,
        RESPECIFICATION_OF_ERROR_SYMBOL,
        RESPECIFICATION_OF_IDENTIFIER_SYMBOL,
        RESPECIFICATION_OF_EOL_SYMBOL,
        RESPECIFICATION_OF_EOF_SYMBOL,
        RESPECIFICATION_OF_START_SYMBOL,
        RECURSIVE_IMPORT
    };
    void ReportError(int, int);

    void SetIdentifierIndex(int index)
    {
        if (identifier_index == 0)
             identifier_index = index;
        else ReportError(RESPECIFICATION_OF_IDENTIFIER_SYMBOL, index);
    }

    void SetEolIndex(int index)
    {
        if (eol_index == 0)
             eol_index = index;
        else ReportError(RESPECIFICATION_OF_EOL_SYMBOL, index);
    }

    void SetEofIndex(int index)
    {
        if (eof_index == 0)
             eof_index = index;
        else ReportError(RESPECIFICATION_OF_EOF_SYMBOL, index);
    }

    void SetErrorIndex(int index)
    {
        if (error_index == 0)
             error_index = index;
        else ReportError(RESPECIFICATION_OF_ERROR_SYMBOL, index);
    }

    bool Compare(RuleDefinition &, RuleDefinition &);
    void Merge(int, Parser &);

    void (jikespg_act::*rule_action[138 + 1]) ();

    void ChangeMacroToVariable(int index)
    {
        const char *variable_name = lex_stream -> NameString(index);
        int length = lex_stream -> NameStringLength(index);

        VariableSymbol *variable_symbol = variable_table -> FindName(variable_name, length);
        if (variable_symbol == NULL)
        {
            variable_symbol = variable_table -> InsertName(variable_name, length);
            ReportError(SYMBOL_EXPECTED_INSTEAD_OF_MACRO, index);
        }

        lex_stream -> GetTokenReference(index) -> SetSymbol(variable_symbol);
    }

    void AddVariableName(int index)
    {
        const char *variable_name = lex_stream -> NameString(index) + 1; // +1 to skip the Escape symbol
        int length = lex_stream -> NameStringLength(index) - 1;

        VariableSymbol *variable_symbol = variable_table -> FindName(variable_name, length);
        if (variable_symbol == NULL)
            variable_symbol = variable_table -> InsertName(variable_name, length);

        lex_stream -> GetTokenReference(index) -> SetSymbol(variable_symbol);
    }

    void BadAction(void) { assert(false); }

    void NoAction(void) {}

    void Act1(void);

    void Act29(void);

    void Act31(void);

    void Act33(void);

    void Act36(void);

    void Act37(void);

    void Act39(void);

    void Act41(void);

    void Act46(void);

    void Act49(void);

    void Act50(void);

    void Act51(void);

    void Act55(void);

    void Act56(void);

    void Act58(void);

    void Act61(void);

    void Act62(void);

    void Act63(void);

    void Act67(void);

    void Act69(void);

    void Act71(void);

    void Act73(void);

    void Act75(void);

    void Act77(void);

    void Act78(void);

    void Act79(void);

    void Act80(void);

    void Act81(void);

    void Act82(void);

    void Act83(void);

    void Act85(void);

    void Act92(void);

    void Act94(void);

    void Act96(void);

    void Act98(void);

    void Act100(void);

    void Act105(void);

    void Act106(void);

    void Act107(void);

    void Act108(void);

    void Act122(void);

    void Act123(void);

    void Act124(void);

    void Act126(void);

    void Act128(void);

    void Act130(void);

    void Act131(void);

    void Act138(void);

#line 1400 "jikespg.g"

};
#endif

