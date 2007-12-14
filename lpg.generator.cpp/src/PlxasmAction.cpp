#include "PlxasmAction.h"

//
//
//
void PlxasmAction::ProcessRuleActionBlock(ActionBlockElement &action)
{
    //
    // TODO: Do whatever preprocessing that is required here!
    //

    ProcessActionBlock(action);

    //
    // TODO: Do whatever postprocessing that is required here!
    //
}

void PlxasmAction::GenerateDefaultTitle(Tuple<ActionBlockElement> &) {}
ActionFileSymbol *PlxasmAction::GenerateTitle(ActionFileLookupTable &, Tuple<ActionBlockElement> &, const char *, bool) { return NULL;}
ActionFileSymbol *PlxasmAction::GenerateTitleAndGlobals(ActionFileLookupTable &, Tuple<ActionBlockElement> &, const char *, bool) { return NULL;}

void PlxasmAction::GenerateVisitorHeaders(TextBuffer &, const char *, const char *) {}
void PlxasmAction::GenerateVisitorMethods(NTC &, TextBuffer &, const char *, ClassnameElement &, BitSet &) {}
void PlxasmAction::GenerateGetAllChildrenMethod(TextBuffer &, const char *, ClassnameElement &) {}
void PlxasmAction::GenerateEqualsMethod(NTC &, TextBuffer &, const char *, ClassnameElement &, BitSet &) {}
void PlxasmAction::GenerateHashcodeMethod(NTC &, TextBuffer &, const char *, ClassnameElement &, BitSet &) {}

void PlxasmAction::GenerateSimpleVisitorInterface(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}
void PlxasmAction::GenerateArgumentVisitorInterface(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}
void PlxasmAction::GenerateResultVisitorInterface(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}
void PlxasmAction::GenerateResultArgumentVisitorInterface(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}

void PlxasmAction::GeneratePreorderVisitorInterface(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}
void PlxasmAction::GeneratePreorderVisitorAbstractClass(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}

void PlxasmAction::GenerateNoResultVisitorAbstractClass(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}
void PlxasmAction::GenerateResultVisitorAbstractClass(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}

void PlxasmAction::GenerateAstType(TextBuffer &, const char *, const char *) {}
void PlxasmAction::GenerateAbstractAstListType(TextBuffer &, const char *, const char *) {}
void PlxasmAction::GenerateAstTokenType(NTC &, TextBuffer &, const char *, const char *) {}
void PlxasmAction::GenerateInterface(bool, TextBuffer &, const char *, const char *, Tuple<int> &, Tuple<int> &, Tuple<ClassnameElement> &) {}
void PlxasmAction::GenerateCommentHeader(TextBuffer &, const char *, Tuple<int> &, Tuple<int> &) {}
void PlxasmAction::GenerateListExtensionClass(CTC &, NTC &, TextBuffer &, const char *, SpecialArrayElement &, ClassnameElement &, Array<const char *> &) {}
void PlxasmAction::GenerateListClass(CTC &, NTC &, TextBuffer &, const char *, ClassnameElement &, Array<const char *> &) {}
void PlxasmAction::GenerateRuleClass(CTC &, NTC &, TextBuffer &, const char *, ClassnameElement &, Array<const char *> &) {}
void PlxasmAction::GenerateMergedClass(CTC &,
                                       NTC &,
                                       TextBuffer &,
                                       const char *,
                                       ClassnameElement &,
                                       Tuple< Tuple<ProcessedRuleElement> > &,
                                       Array<const char *> &) {}
void PlxasmAction::GenerateTerminalMergedClass(NTC &, TextBuffer &, const char *, ClassnameElement &, Array<const char *> &) {}
void PlxasmAction::GenerateNullAstAllocation(TextBuffer &, int rule_no) {}
void PlxasmAction::GenerateEnvironmentDeclaration(TextBuffer &, const char *) {}
void PlxasmAction::GenerateListAllocation(CTC &ctc, TextBuffer &, int, RuleAllocationElement &) {}
void PlxasmAction::GenerateAstAllocation(CTC &ctc,
                                         TextBuffer &,
                                         RuleAllocationElement &,
                                         Tuple<ProcessedRuleElement> &,
                                         Array<const char *> &, int) {}
