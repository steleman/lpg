#ifndef PRODUCE_INCLUDED
#define PRODUCE_INCLUDED

#include "util.h"

class Control;
class Base;
class Dfa;

class Produce : public Util
{
    enum { SCOPE_SIZE = 101 /* 101 is prime */ };

    Stack<int> stack;
    Tuple<int> index_of,
               item_list,
               next_item,
               scope_table;
    int scope_top;

    struct ScopeElement
    {
        int link,
            index,
            size,
            item;
    };
    Tuple<ScopeElement> scope_element;

    BoundedArray<int>  item_of;
    BoundedArray<bool> symbol_seen;
    BoundedArray<Tuple<int> > direct_produces;
    BoundedArray<BitSetWithOffset> produces,
                                   right_produces,
                                   left_produces;
    BoundedArray<bool> useful;

    void compute_produces(BoundedArray<BitSetWithOffset> &, int symbol);
    void process_scopes(void);
    bool is_item_prefix_nullable(int item_no);
    bool is_scope(int item_no);
    bool scope_check(int lhs_symbol, int target, int source);
    int insert_prefix(int item_no);
    bool is_prefix_equal(int item_no, int item_no2);
    int insert_suffix(int item_no);
    bool is_suffix_equal(int item_no1, int item_no2);
    int get_shift_symbol(int lhs_symbol);

    Control *control;
    Option *option;
    Grammar *grammar;
    Base *base;
    Dfa *dfa;

public:

    //
    //  The variables below are global counters.
    //
    int num_error_rules;

    Tuple<int> gd_index,
               gd_range;

    Array<int> scope_prefix,
               scope_suffix,
               scope_lhs_symbol,
               scope_look_ahead,
               scope_state_set;

    Array<int> scope_right_side,
               scope_state;

    bool IsUseful(int nt) { return useful[nt]; }

    void ProcessAdvancedMaps(void);
    void ProcessScopesOutput(void);

    Produce(Control *);

    ~Produce()
    {}
};

#endif
