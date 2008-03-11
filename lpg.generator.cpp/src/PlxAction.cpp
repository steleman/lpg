#include "PlxAction.h"

//
//
//
void PlxAction::ProcessRuleActionBlock(ActionBlockElement &action)
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
void PlxAction::ExpandExportMacro(TextBuffer *buffer, SimpleMacroSymbol *simple_macro)
{
    buffer -> Put(option -> exp_type);
    buffer -> Put(".");
    buffer -> Put(option -> exp_prefix);
    buffer -> Put(simple_macro -> Name() + 2); // skip initial escape and '_' characters
    buffer -> Put(option -> exp_suffix);
}


void PlxAction::GenerateDefaultTitle(Tuple<ActionBlockElement> &) {}
ActionFileSymbol *PlxAction::GenerateTitle(ActionFileLookupTable &, Tuple<ActionBlockElement> &, const char *, bool) { return NULL;}
ActionFileSymbol *PlxAction::GenerateTitleAndGlobals(ActionFileLookupTable &, Tuple<ActionBlockElement> &, const char *, bool) { return NULL;}

void PlxAction::GenerateVisitorHeaders(TextBuffer &, const char *, const char *) {}
void PlxAction::GenerateVisitorMethods(NTC &, TextBuffer &, const char *, ClassnameElement &, BitSet &) {}
void PlxAction::GenerateGetAllChildrenMethod(TextBuffer &, const char *, ClassnameElement &) {}
void PlxAction::GenerateEqualsMethod(NTC &, TextBuffer &, const char *, ClassnameElement &, BitSet &) {}
void PlxAction::GenerateHashcodeMethod(NTC &, TextBuffer &, const char *, ClassnameElement &, BitSet &) {}

void PlxAction::GenerateSimpleVisitorInterface(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}
void PlxAction::GenerateArgumentVisitorInterface(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}
void PlxAction::GenerateResultVisitorInterface(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}
void PlxAction::GenerateResultArgumentVisitorInterface(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}

void PlxAction::GeneratePreorderVisitorInterface(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}
void PlxAction::GeneratePreorderVisitorAbstractClass(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}

void PlxAction::GenerateNoResultVisitorAbstractClass(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}
void PlxAction::GenerateResultVisitorAbstractClass(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}

void PlxAction::GenerateAstType(TextBuffer &, const char *, const char *) {}
void PlxAction::GenerateAbstractAstListType(TextBuffer &, const char *, const char *) {}
void PlxAction::GenerateAstTokenType(NTC &, TextBuffer &, const char *, const char *) {}
void PlxAction::GenerateInterface(bool, TextBuffer &, const char *, const char *, Tuple<int> &, Tuple<int> &, Tuple<ClassnameElement> &) {}
void PlxAction::GenerateCommentHeader(TextBuffer &, const char *, Tuple<int> &, Tuple<int> &) {}
void PlxAction::GenerateListExtensionClass(CTC &, NTC &, TextBuffer &, const char *, SpecialArrayElement &, ClassnameElement &, Array<const char *> &) {}
void PlxAction::GenerateListClass(CTC &, NTC &, TextBuffer &, const char *, ClassnameElement &, Array<const char *> &) {}
void PlxAction::GenerateRuleClass(CTC &, NTC &, TextBuffer &, const char *, ClassnameElement &, Array<const char *> &) {}
void PlxAction::GenerateMergedClass(CTC &,
                                    NTC &,
                                    TextBuffer &,
                                    const char *,
                                    ClassnameElement &,
                                    Tuple< Tuple<ProcessedRuleElement> > &,
                                    Array<const char *> &) {}
void PlxAction::GenerateTerminalMergedClass(NTC &, TextBuffer &, const char *, ClassnameElement &, Array<const char *> &) {}
void PlxAction::GenerateNullAstAllocation(TextBuffer &, int rule_no) {}
void PlxAction::GenerateEnvironmentDeclaration(TextBuffer &, const char *) {}
void PlxAction::GenerateListAllocation(CTC &ctc, TextBuffer &, int, RuleAllocationElement &) {}
void PlxAction::GenerateAstAllocation(CTC &ctc,
                                      TextBuffer &,
                                      RuleAllocationElement &,
                                      Tuple<ProcessedRuleElement> &,
                                      Array<const char *> &, int) {}
