#include "CppAction.h"

//
//
//
void CppAction::ProcessRuleActionBlock(ActionBlockElement &action)
{
    //
    // TODO: Do whatever preprocessing that is required here!
    //

    ProcessActionBlock(action);

    //
    // TODO: Do whatever postprocessing that is required here!
    //
}

void CppAction::GenerateDefaultTitle(Tuple<ActionBlockElement> &) {}
ActionFileSymbol *CppAction::GenerateTitle(ActionFileLookupTable &, Tuple<ActionBlockElement> &, const char *, bool) { return NULL;}
ActionFileSymbol *CppAction::GenerateTitleAndGlobals(ActionFileLookupTable &, Tuple<ActionBlockElement> &, const char *, bool) { return NULL;}

void CppAction::GenerateVisitorHeaders(TextBuffer &, const char *, const char *) {}
void CppAction::GenerateVisitorMethods(NTC &, TextBuffer &, const char *, ClassnameElement &, BitSet &) {}
void CppAction::GenerateGetAllChildrenMethod(TextBuffer &, const char *, ClassnameElement &) {}
void CppAction::GenerateEqualsMethod(NTC &, TextBuffer &, const char *, ClassnameElement &, BitSet &) {}
void CppAction::GenerateHashcodeMethod(NTC &, TextBuffer &, const char *, ClassnameElement &, BitSet &) {}

void CppAction::GenerateSimpleVisitorInterface(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}
void CppAction::GenerateArgumentVisitorInterface(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}
void CppAction::GenerateResultVisitorInterface(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}
void CppAction::GenerateResultArgumentVisitorInterface(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}

void CppAction::GeneratePreorderVisitorInterface(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}
void CppAction::GeneratePreorderVisitorAbstractClass(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}

void CppAction::GenerateNoResultVisitorAbstractClass(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}
void CppAction::GenerateResultVisitorAbstractClass(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}

void CppAction::GenerateAstType(TextBuffer &, const char *, const char *) {}
void CppAction::GenerateAbstractAstListType(TextBuffer &, const char *, const char *) {}
void CppAction::GenerateAstTokenType(NTC &, TextBuffer &, const char *, const char *) {}
void CppAction::GenerateInterface(bool, TextBuffer &, const char *, const char *, Tuple<int> &, Tuple<int> &, Tuple<ClassnameElement> &) {}
void CppAction::GenerateCommentHeader(TextBuffer &, const char *, Tuple<int> &, Tuple<int> &) {}
void CppAction::GenerateListExtensionClass(CTC &, NTC &, TextBuffer &, const char *, SpecialArrayElement &, ClassnameElement &, Array<const char *> &) {}
void CppAction::GenerateListClass(CTC &, NTC &, TextBuffer &, const char *, ClassnameElement &, Array<const char *> &) {}
void CppAction::GenerateRuleClass(CTC &, NTC &, TextBuffer &, const char *, ClassnameElement &, Array<const char *> &) {}
void CppAction::GenerateMergedClass(CTC &,
                                    NTC &,
                                    TextBuffer &,
                                    const char *,
                                    ClassnameElement &,
                                    Tuple< Tuple<ProcessedRuleElement> > &,
                                    Array<const char *> &) {}
void CppAction::GenerateTerminalMergedClass(NTC &, TextBuffer &, const char *, ClassnameElement &, Array<const char *> &) {}
void CppAction::GenerateNullAstAllocation(TextBuffer &, int rule_no) {}
void CppAction::GenerateEnvironmentDeclaration(TextBuffer &, const char *) {}
void CppAction::GenerateListAllocation(CTC &ctc, TextBuffer &, int, RuleAllocationElement &) {}
void CppAction::GenerateAstAllocation(CTC &ctc,
                                      TextBuffer &,
                                      RuleAllocationElement &,
                                      Tuple<ProcessedRuleElement> &,
                                      Array<const char *> &, int) {}
