#include "CAction.h"

//
//
//
void CAction::ProcessRuleActionBlock(ActionBlockElement &action)
{
    //
    // TODO: Do whatever preprocessing that is required here!
    //

    ProcessActionBlock(action);

    //
    // TODO: Do whatever postprocessing that is required here!
    //
}

//
//
//
void CAction::ExpandExportMacro(TextBuffer *buffer, SimpleMacroSymbol *simple_macro)
{
    buffer -> Put(option -> exp_type);
    buffer -> Put(".");
    buffer -> Put(option -> exp_prefix);
    buffer -> Put(simple_macro -> Name() + 2); // skip initial escape and '_' characters
    buffer -> Put(option -> exp_suffix);
}


void CAction::GenerateDefaultTitle(Tuple<ActionBlockElement> &) {}
ActionFileSymbol *CAction::GenerateTitle(ActionFileLookupTable &, Tuple<ActionBlockElement> &, const char *, bool) { return NULL;}
ActionFileSymbol *CAction::GenerateTitleAndGlobals(ActionFileLookupTable &, Tuple<ActionBlockElement> &, const char *, bool) { return NULL;}

void CAction::GenerateVisitorHeaders(TextBuffer &, const char *, const char *) {}
void CAction::GenerateVisitorMethods(NTC &, TextBuffer &, const char *, ClassnameElement &, BitSet &) {}
void CAction::GenerateGetAllChildrenMethod(TextBuffer &, const char *, ClassnameElement &) {}
void CAction::GenerateEqualsMethod(NTC &, TextBuffer &, const char *, ClassnameElement &, BitSet &) {}
void CAction::GenerateHashcodeMethod(NTC &, TextBuffer &, const char *, ClassnameElement &, BitSet &) {}

void CAction::GenerateSimpleVisitorInterface(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}
void CAction::GenerateArgumentVisitorInterface(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}
void CAction::GenerateResultVisitorInterface(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}
void CAction::GenerateResultArgumentVisitorInterface(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}

void CAction::GeneratePreorderVisitorInterface(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}
void CAction::GeneratePreorderVisitorAbstractClass(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}

void CAction::GenerateNoResultVisitorAbstractClass(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}
void CAction::GenerateResultVisitorAbstractClass(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}

void CAction::GenerateAstType(TextBuffer &, const char *, const char *) {}
void CAction::GenerateAbstractAstListType(TextBuffer &, const char *, const char *) {}
void CAction::GenerateAstTokenType(NTC &, TextBuffer &, const char *, const char *) {}
void CAction::GenerateInterface(bool, TextBuffer &, const char *, const char *, Tuple<int> &, Tuple<int> &, Tuple<ClassnameElement> &) {}
void CAction::GenerateCommentHeader(TextBuffer &, const char *, Tuple<int> &, Tuple<int> &) {}
void CAction::GenerateListExtensionClass(CTC &, NTC &, TextBuffer &, const char *, SpecialArrayElement &, ClassnameElement &, Array<const char *> &) {}
void CAction::GenerateListClass(CTC &, NTC &, TextBuffer &, const char *, ClassnameElement &, Array<const char *> &) {}
void CAction::GenerateRuleClass(CTC &, NTC &, TextBuffer &, const char *, ClassnameElement &, Array<const char *> &) {}
void CAction::GenerateMergedClass(CTC &,
                                  NTC &,
                                  TextBuffer &,
                                  const char *,
                                  ClassnameElement &,
                                  Tuple< Tuple<ProcessedRuleElement> > &,
                                  Array<const char *> &) {}
void CAction::GenerateTerminalMergedClass(NTC &, TextBuffer &, const char *, ClassnameElement &, Array<const char *> &) {}
void CAction::GenerateNullAstAllocation(TextBuffer &, int rule_no) {}
void CAction::GenerateEnvironmentDeclaration(TextBuffer &, const char *) {}
void CAction::GenerateListAllocation(CTC &ctc, TextBuffer &, int, RuleAllocationElement &) {}
void CAction::GenerateAstAllocation(CTC &ctc,
                                    TextBuffer &,
                                    RuleAllocationElement &,
                                    Tuple<ProcessedRuleElement> &,
                                    Array<const char *> &, int) {}
