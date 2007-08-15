
#line 128 "jikespg.g"
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
        error_index,
        start_index;

    Tuple<int> terminals,
               keywords,
               exports,
               recovers;

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

    int ast_block;
    Tuple<int> notice_blocks,
               global_blocks,
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
                          dropped_rules;

    class TypeDefinition
    {
    public:
      int type_index,
          separator_index,
          symbol_index,
          block_index;
    };
    Tuple<TypeDefinition> types;

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

    void SetStartIndex(int index)
    {
        if (start_index == 0)
             start_index = index;
        else ReportError(RESPECIFICATION_OF_START_SYMBOL, index);
    }

    bool Compare(RuleDefinition &, RuleDefinition &);
    void Merge(Parser &);

    void (jikespg_act::*rule_action[128 + 1]) ();

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

    void Act27(void);

    void Act29(void);

    void Act31(void);

    void Act34(void);

    void Act35(void);

    void Act37(void);

    void Act39(void);

    void Act44(void);

    void Act47(void);

    void Act48(void);

    void Act49(void);

    void Act53(void);

    void Act54(void);

    void Act56(void);

    void Act58(void);

    void Act60(void);

    void Act62(void);

    void Act64(void);

    void Act66(void);

    void Act68(void);

    void Act69(void);

    void Act70(void);

    void Act71(void);

    void Act72(void);

    void Act73(void);

    void Act74(void);

    void Act76(void);

    void Act82(void);

    void Act84(void);

    void Act86(void);

    void Act88(void);

    void Act90(void);

    void Act95(void);

    void Act96(void);

    void Act97(void);

    void Act98(void);

    void Act112(void);

    void Act113(void);

    void Act114(void);

    void Act116(void);

    void Act118(void);

    void Act120(void);

    void Act121(void);

    void Act128(void);

#line 1290 "jikespg.g"

};
#endif

