#ifndef PDA_INCLUDED
#define PDA_INCLUDED

class Control;
class Produce;
class Resolve;
class Sp;

class Pda : public Util
{
public:

    bool not_lrk;

    int max_la_state,
        highest_level,
        num_reductions,
        num_shift_reduce_conflicts,
        num_reduce_reduce_conflicts,
        num_shift_shift_conflicts,
        num_soft_shift_reduce_conflicts,
        num_soft_reduce_reduce_conflicts;

    //
    // Constructor
    //
    Pda(Control *control_);

    void ProcessPDA(void);
    void ProcessPDAOutput(void);
    void LaTraverse(int, int);
    void PrintShiftState(int);

private:

    friend class Resolve;
    friend class Sp;

    Control *control;
    Option *option;
    Grammar *grammar;
    Base *base;
    Dfa *dfa;
    Produce *produce;

    //
    // STACK is used in la_traverse to construct a stack of symbols.
    // The boolean vector SINGLE_COMPLETE_ITEM identifies states whose
    // kernel consists of a single final item and other conditions allows
    // us to compute default reductions for such states.
    // The vector LA_BASE is used in COMPUTE_READ and TRACE_LALR_PATH to
    // identify states whose read sets can be completely computed from
    // their kernel items.
    //
    Stack<int> stack;
    Array<bool> single_complete_item;
    Array<int> la_base;
    int la_top;

    //
    // CONFLICT_SYMBOLS is a mapping from each state into a set of terminal    
    // symbols on which an LALR(1) conflict was detected in the state in       
    // question.                                                               
    //
    typedef Tuple<int> int_tuple;
    Tuple<int_tuple> conflict_symbols;

    //
    // Add SYMBOL to the set of symbols CONFLICT_SYMBOLS[STATE_NO].
    //
    void AddConflictSymbol(int state_no, int symbol)
    {
        conflict_symbols[state_no].Next() = symbol;
    }

    //                                                                         
    // LA_INDEX and LA_SET are temporary look-ahead sets, each of which will   
    // be pointed to by a GOTO action, and the associated set will be          
    // initialized to READ_SET(S), where S is the state identified by the GOTO 
    // action in question. READ_SET(S) is a set of terminals on which an action
    // is defined in state S. See COMPUTE_READ for more details.               
    // LA_TOP is used to compute the number of such sets needed.               
    //                                                                         
    // The boolean variable NOT_LRK is used to mark whether or not a grammar   
    // is not LR(k) for any k. NOT_LRK is marked true when either:             
    //    1. The grammar contains a nonterminal A such that A =>+rm A          
    //    2. The automaton contains a cycle with each of its edges labeled     
    //       with a nullable nonterminal.                                      
    // (Note that these are not the only conditions under which a grammar is   
    //  not LR(k). In fact, it is an undecidable problem.)                     
    // The variable HIGHEST_LEVEL is used to indicate the highest number of    
    // lookahead that was necessary to resolve all conflicts for a given       
    // grammar. If we can detect that the grammar is not LALR(k), we set       
    // HIGHEST_LEVEL to INFINITY.                                              
    //
    Array<BitSet> read_set,
                  la_set;
    Array<int> la_index;

    void TraceLalrPath(int, int);
    void ComputeRead(void);
    void ComputeLa(int, int, BitSet &);

    int MaximumSymbolNameLength(int);
    void PrintShifts(Dfa::ShiftHeader &, int);
    void PrintGotos(Dfa::GotoHeader &, int);
    void PrintReductions(Dfa::ReduceHeader &, int);
    void PrintLaState(int);

    void ProcessConflictActions();
};

#endif
