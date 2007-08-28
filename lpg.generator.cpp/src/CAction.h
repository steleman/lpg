#ifndef CAction_INCLUDED
#define CAction_INCLUDED

#include "action.h"
#include "control.h"

class CAction : public Action
{
public:

    CAction(Control *control_, Blocks *action_blocks_, Grammar *grammar_, MacroLookupTable *macro_table_)
           : Action(control_, action_blocks_, grammar_, macro_table_)
    {
        if (option -> automatic_ast != Option::NONE)
        {
            control_ -> option -> EmitError(0, "Cannot automatically generate AST for programming language C");
            return_code = 12;
        }
    }
    virtual ~CAction() {}
 
    virtual const char *GetDefaultTerminalType() { return "void *"; }
    virtual const char *GetDefaultNonterminalType() { return "void *"; }
    virtual void GenerateDefaultTitle(Tuple<ActionBlockElement> &);
    virtual ActionFileSymbol *GenerateTitle(ActionFileLookupTable &, Tuple<ActionBlockElement> &, const char *, bool);
    virtual ActionFileSymbol *GenerateTitleAndGlobals(ActionFileLookupTable &, Tuple<ActionBlockElement> &, const char *, bool);

    virtual void GenerateVisitorHeaders(TextBuffer &, const char *, const char *);
    virtual void GenerateVisitorMethods(NTC &, TextBuffer &, const char *, ClassnameElement &, BitSet &);
    virtual void GenerateGetAllChildrenMethod(TextBuffer &, const char *, ClassnameElement &);
    virtual void GenerateEqualsMethod(NTC &, TextBuffer &, const char *, ClassnameElement &, BitSet &);
    virtual void GenerateHashcodeMethod(NTC &, TextBuffer &, const char *, ClassnameElement &, BitSet &);

    virtual void GenerateSimpleVisitorInterface(TextBuffer &, const char *, const char *, SymbolLookupTable &);
    virtual void GenerateArgumentVisitorInterface(TextBuffer &, const char *, const char *, SymbolLookupTable &);
    virtual void GenerateResultVisitorInterface(TextBuffer &, const char *, const char *, SymbolLookupTable &);
    virtual void GenerateResultArgumentVisitorInterface(TextBuffer &, const char *, const char *, SymbolLookupTable &);

    virtual void GeneratePreorderVisitorInterface(TextBuffer &, const char *, const char *, SymbolLookupTable &);
    virtual void GeneratePreorderVisitorAbstractClass(TextBuffer &, const char *, const char *, SymbolLookupTable &);

    virtual void GenerateNoResultVisitorAbstractClass(TextBuffer &, const char *, const char *, SymbolLookupTable &);
    virtual void GenerateResultVisitorAbstractClass(TextBuffer &, const char *, const char *, SymbolLookupTable &);

    virtual void GenerateAstType(TextBuffer &, const char *, const char *);
    virtual void GenerateAbstractAstListType(TextBuffer &, const char *, const char *);
    virtual void GenerateAstTokenType(NTC &, TextBuffer &, const char *, const char *);
    virtual void GenerateInterface(bool, TextBuffer &, const char *, const char *, Tuple<int> &, Tuple<int> &, Tuple<ClassnameElement> &);
    virtual void GenerateCommentHeader(TextBuffer &, const char *, Tuple<int> &, Tuple<int> &);
    virtual void GenerateListExtensionClass(CTC &, NTC &, TextBuffer &, const char *, SpecialArrayElement &, ClassnameElement &, Array<const char *> &);
    virtual void GenerateListClass(CTC &, NTC &, TextBuffer &, const char *, ClassnameElement &, Array<const char *> &);
    virtual void GenerateRuleClass(CTC &, NTC &, TextBuffer &, const char *, ClassnameElement &, Array<const char *> &);
    virtual void GenerateMergedClass(CTC &,
                                     NTC &,
                                     TextBuffer &,
                                     const char *,
                                     ClassnameElement &,
                                     Tuple< Tuple<ProcessedRuleElement> > &,
                                     Array<const char *> &);
    virtual void GenerateTerminalMergedClass(NTC &, TextBuffer &, const char *, ClassnameElement &, Array<const char *> &);
    virtual void GenerateNullAstAllocation(TextBuffer &, int rule_no);
    virtual void GenerateEnvironmentDeclaration(TextBuffer &, const char *);
    virtual void GenerateListAllocation(CTC &ctc, TextBuffer &, int, RuleAllocationElement &);
    virtual void GenerateAstAllocation(CTC &ctc,
                                       TextBuffer &,
                                       RuleAllocationElement &,
                                       Tuple<ProcessedRuleElement> &,
                                       Array<const char *> &, int);
};

#endif /* CAction_INCLUDED */
