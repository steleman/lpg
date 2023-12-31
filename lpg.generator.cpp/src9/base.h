#ifndef BASE_INCLUDED
#define BASE_INCLUDED

#include "util.h"
#include "tuple.h"

class Control;
class LexStream;
class Base : public Util
{
    static int MAX_LENGTH;

    Stack<int> stack;
    Array<int> first_table,
               first_item_of,
               next_item;

    BoundedArray<int> index_of,
                      nt_items;

    BoundedArray< Tuple<int> > lhs_ranked_rules;
    Tuple< Tuple<int> > SCC_in_ranks;
    Tuple<int> ordered_rules;

    //
    // nt_first is a mapping from each nonterminal A into First(A).
    // first is a mapping from all suffix index y derived from an item
    // of the form [A -> x.B y], where A and B are nonterminals and
    // x and y ar arbitrary strings, into First(y). Note that each
    // such suffixes has been mapped into a unique integer in "itemtab".
    //
    BoundedArray<BitSet> nt_first;

    //
    // LAST is a map from each grammar symbol into the set of terminals
    // that may appear last in a string derived from that symbol.
    // PREDECESSOR is a map from each grammar symbol into the set of
    // terminals that may immediately precede the symbol in question.
    //
    Array<BitSet> last,
                  predecessor;
    Array< Tuple<int> > item_of;

    struct FirstElementType
    {
        int suffix_root,
            suffix_tail,
            link;
        BitSet set;
    };
    Tuple<FirstElementType> first;

    BoundedArray<Tuple <int> > direct_produces;
    BoundedArray<BitSetWithOffset> produces;

    //
    // GENERATES_STRING is a boolean vector that indicates whether or not a given
    // non-terminal can generate a string of terminals or the empty string.
    // IS_CYCLIC is a boolean vector that indicates whether or not a given 
    // nonterminal is part of a cycle that prevent it from generating a string,
    // possibly empty, of terminals.
    //
    // GENERATES_NULL is a boolean vector that indicates whether or not a given
    // non-terminal is nullable.
    //
    // GENERATES is a map from each nonterminal into a string of terminals it
    // can produce.
    //
    BoundedArray<bool> generates_string,
                       is_cyclic,
                       generates_null;

    Control *control;
    Option *option;
    LexStream *lex_stream;
    Grammar *grammar;
    NodePool *node_pool;

    void NoRulesProduced(void);
    void ComputeClosure(int);
    // void NullablesComputation(void);
    // bool IsNullableRhs(Array<int> &, int);
    void ComputeFirst(int);
    void ComputeLast(int);
    void CheckCanGenerateNull(int);
    void CheckCanGenerateString(int);
    void ComputeStringGeneration(int);
    void ComputePredecessor(int);
    void ComputeRank(int);
    void ProcessRank(int);
    int FirstMap(int, int);
    void SuffixFirst(int);
    void ComputeProduces(int);
    void ComputeFollow(int);
    void CheckDuplicateRules(void);
    void PrintUnreachables(void);
    void PrintXref(void);
    void QuickSortSymbols(Array<int> &, int, int);
    void PrintNonTerminalFirst(void);
    void PrintSymbolMap(const char *, Array<BitSet> &);
    void PrintFollowMap(void);
    void InitRmpself(BoundedArray<BitSetWithOffset> &);

public:

    Base(Control *);

    //
    // CLOSURE is a mapping from non-terminal to a set (linked-list) of
    // non-terminals.  The set consists of non-terminals that are
    // automatically introduced via closure when the original non-terminal
    // is introduced.
    // CL_ITEMS is a mapping from each non-terminal to a set (linked list)
    // of items which are the first item of the rules generated by the
    // non-terminal in question. ADEQUATE_ITEM is a mapping from each rule
    // to the last (complete) item produced by that rule.
    // ITEM_TABLE is used to map each item into a number. Given that
    // number one can retrieve the rule the item belongs to, the position
    // of the dot,  the symbol following the dot, and FIRST of the suffix
    // following the "dot symbol". 
    //
    BoundedArray< Tuple<int> > closure,
                               clitems;

    Array<Node *> adequate_item;

    struct Itemtab
    {
        int symbol,
            rule_number,
            suffix_index,
            dot;
    };
    Array<Itemtab> item_table;

    bool IsNullable(int nt) { return generates_null[nt]; }

    Array<int> rank;

    BitSet &NonterminalFirst(int i) { return nt_first[i]; }
    BitSet &First(int i) { return first[i].set; }

    //
    // FOLLOW is a mapping from non-terminals to a set of terminals that
    // may appear immediately after the non-terminal.
    //
    BoundedArray<BitSet> follow;

    //                                                                     
    // RMPSELF is a boolean vector that indicates whether or not a given   
    // non-terminal can right-most produce itself. It is only constructed  
    // when LALR_LEVEL > 1.                                                
    //
    BoundedArray<bool> rmpself;

    //                                                                     
    // STRING_GENERATED(A) is a map from a nonterminal A into a string in the
    // language that A can generate.
    // PROSTHESIS_RULE(A) is a mapping from A into the rule that
    // was used to generate the string in STRING_GENERATED(A).                                                                     
    //                                                                     
    BoundedArray<Tuple <int> > string_generated;
    BoundedArray<int> prosthesis_rule;

    void ProcessBasicMaps(void);

    void ProcessBaseOutput(void);
};
#endif /* COMMON_INCLUDED */
