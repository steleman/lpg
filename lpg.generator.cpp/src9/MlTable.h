#ifndef MlTable_INCLUDED
#define MlTable_INCLUDED

#include "table.h"

class MlTable : public Table
{
protected:

    Array<const char *> array_name;
    UnbufferedTextFile dcl_buffer;

    void Print(IntArrayInfo &);
    void non_terminal_action(void);
    void non_terminal_no_goto_default_action(void);
    void terminal_action(void);
    void terminal_shift_default_action(void);
    void terminal_lalr_k(void);
    void terminal_shift_default_lalr_k(void);
    void init_file(FILE **, const char *);
    void init_parser_files(void);
    void exit_parser_files(void);
    void PrintNames(void);
    void print_symbols(void);
    void print_exports(void);
    void print_definitions(void);
    void print_externs_and_definitions(void);
    void print_tables(void);

public:

    MlTable(Control *control_) : Table(control_),
                                 array_name(num_name_ids),
                                 dcl_buffer(&sysdcl)
    {
        array_name[NULLABLES] = "is_nullable";
        array_name[KEYWORDS] = "is_keyword";
        array_name[BASE_CHECK] = "base_check";
        array_name[BASE_ACTION] = "base_action";
        array_name[TERM_CHECK] = "term_check";
        array_name[TERM_ACTION] = "term_action";
        array_name[DEFAULT_GOTO] = "default_goto";
        array_name[DEFAULT_REDUCE] = "default_reduce";
        array_name[SHIFT_STATE] = "shift_state";
        array_name[SHIFT_CHECK] = "shift_check";
        array_name[DEFAULT_SHIFT] = "default_shift";
        array_name[ACTION_SYMBOLS_BASE] = "asb";
        array_name[ACTION_SYMBOLS_RANGE] = "asr";
        array_name[NACTION_SYMBOLS_BASE] = "nasb";
        array_name[NACTION_SYMBOLS_RANGE] = "nasr";
        array_name[TERMINAL_INDEX] = "terminal_index";
        array_name[NONTERMINAL_INDEX] = "non_terminal_index";
        array_name[SCOPE_PREFIX] = "scope_prefix";
        array_name[SCOPE_SUFFIX] = "scope_suffix";
        array_name[SCOPE_LHS_SYMBOL] = "scope_lhs";
        array_name[SCOPE_LOOK_AHEAD] = "scope_la";
        array_name[SCOPE_STATE_SET] = "scope_state_set";
        array_name[SCOPE_RIGHT_SIDE] = "scope_rhs";
        array_name[SCOPE_STATE] = "scope_state";
        array_name[IN_SYMB] = "in_symb"; 
        array_name[PROSTHESIS_RULE_INDEX] = "prosthesis_rule_index";
        array_name[NAME_START] = "!?";
    }

    virtual ~MlTable() {}

    virtual void OutputTables(void);
};

#endif /* MlTable_INCLUDED */
