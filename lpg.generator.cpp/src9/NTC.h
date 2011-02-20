#ifndef NTC_INCLUDED
#define NTC_INCLUDED

#include "tuple.h"
#include "control.h"


//
// NTC (Null transitive closure)
//
// A null ast can be produced for a nonterminal if either:
//     1. It produces $empty
//     2. It produces (in a single or unit production) a nonterminal that is null
//
class NTC
{
    BoundedArray<bool> is_null;
    BoundedArray<int> index_of;
    Stack<int> stack;

    Array<bool> &user_specified_null_ast;
    Grammar *grammar;

    //
    // ComputeClosure computes closure[nt] for some non-terminal NT using the
    // digraph algorithm.
    //
    void ComputeClosure(int nt)
    {
        stack.Push(nt);
        int indx = stack.Length();
        index_of[nt] = indx;

        is_null[nt] = false;

        Tuple<int> &rules = grammar -> RulesOfLhs(nt);

        for (int i = 0; i < rules.Length(); i++)
        {
            int rule_no = rules[i],
                source_index = grammar -> rules[rule_no].source_index,
                array_index = grammar -> parser.rules[source_index].array_element_type_index;
            if (array_index == 0) // not a list rule
            {
                if (grammar -> RhsSize(rule_no) == 0 || user_specified_null_ast[rule_no])
                    is_null[nt] = true;
                else if (grammar -> RhsSize(rule_no) == 1)
                {
                    int dependent = grammar -> rhs_sym[grammar -> FirstRhsIndex(rule_no)];
                    if (grammar -> IsNonTerminal(dependent))
                    {
                        if (index_of[dependent] == Util::OMEGA)
                            ComputeClosure(dependent);
                        is_null[nt] = is_null[nt] || is_null[dependent];
                        index_of[nt] = Util::Min(index_of[nt], index_of[dependent]);
                    }
                }
            }
        }

        if (index_of[nt] == indx)
        {
            for (int dependent = stack.Top(); dependent != nt; dependent = stack.Top())
            {
                is_null[dependent] = is_null[nt];
                index_of[dependent] = Util::INFINITY;
                stack.Pop();
            }

            index_of[nt] = Util::INFINITY;
            stack.Pop();
        }

        return;
    }

public:

    NTC(Array<bool> &user_specified_null_ast_, Grammar *grammar_)
        : user_specified_null_ast(user_specified_null_ast_),
          grammar(grammar_)
    {
        is_null.Resize(grammar -> FirstNonTerminal(), grammar -> LastNonTerminal());
        index_of.Resize(grammar -> FirstNonTerminal(), grammar -> LastNonTerminal());
        index_of.Initialize(Util::OMEGA);

        //
        // Calculate which nonterminal symbols only produce terminal singletons.
        //
        for (int nt = grammar -> FirstNonTerminal(); nt <= grammar -> LastNonTerminal(); nt++)
        {
            if (index_of[nt] == Util::OMEGA)
                ComputeClosure(nt);
        }
    }

    bool CanProduceNullAst(int i) { return (grammar -> IsNonTerminal(i) ? is_null[i] : false); }
};

#endif /* NTC_INCLUDED */