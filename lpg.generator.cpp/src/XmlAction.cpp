#include "XmlAction.h"

void XmlAction::GenerateDefaultTitle(Tuple<ActionBlockElement> &) {}
ActionFileSymbol *XmlAction::GenerateTitle(ActionFileLookupTable &, Tuple<ActionBlockElement> &, const char *, bool) { return NULL;}
ActionFileSymbol *XmlAction::GenerateTitleAndGlobals(ActionFileLookupTable &, Tuple<ActionBlockElement> &, const char *, bool) { return NULL;}

void XmlAction::GenerateVisitorHeaders(TextBuffer &, const char *, const char *) {}
void XmlAction::GenerateVisitorMethods(NTC &, TextBuffer &, const char *, ClassnameElement &, BitSet &) {}
void XmlAction::GenerateGetAllChildrenMethod(TextBuffer &, const char *, ClassnameElement &) {}
void XmlAction::GenerateEqualsMethod(NTC &, TextBuffer &, const char *, ClassnameElement &, BitSet &) {}
void XmlAction::GenerateHashcodeMethod(NTC &, TextBuffer &, const char *, ClassnameElement &, BitSet &) {}

void XmlAction::GenerateSimpleVisitorInterface(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}
void XmlAction::GenerateArgumentVisitorInterface(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}
void XmlAction::GenerateResultVisitorInterface(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}
void XmlAction::GenerateResultArgumentVisitorInterface(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}

void XmlAction::GeneratePreorderVisitorInterface(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}
void XmlAction::GeneratePreorderVisitorAbstractClass(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}

void XmlAction::GenerateNoResultVisitorAbstractClass(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}
void XmlAction::GenerateResultVisitorAbstractClass(TextBuffer &, const char *, const char *, SymbolLookupTable &) {}

void XmlAction::GenerateAstType(TextBuffer &, const char *, const char *) {}
void XmlAction::GenerateAstListType(TextBuffer &, const char *, const char *) {}
void XmlAction::GenerateAstTokenType(NTC &, TextBuffer &, const char *, const char *) {}
void XmlAction::GenerateInterface(bool, TextBuffer &, const char *, const char *, Tuple<int> &, Tuple<int> &, Tuple<ClassnameElement> &) {}
void XmlAction::GenerateCommentHeader(TextBuffer &, const char *, ClassnameElement &) {}
void XmlAction::GenerateListClass(CTC &, NTC &, TextBuffer &, const char *, ClassnameElement &, Array<const char *> &) {}
void XmlAction::GenerateRuleClass(CTC &, NTC &, TextBuffer &, const char *, ClassnameElement &, Array<const char *> &) {}
void XmlAction::GenerateMergedClass(CTC &,
                                 NTC &,
                                 TextBuffer &,
                                 const char *,
                                 ClassnameElement &,
                                 Tuple< Tuple<ProcessedRuleElement> > &,
                                 Array<const char *> &) {}
void XmlAction::GenerateTerminalMergedClass(NTC &, TextBuffer &, const char *, ClassnameElement &, Array<const char *> &) {}
void XmlAction::GenerateNullAstAllocation(TextBuffer &, int rule_no) {}
void XmlAction::GenerateEnvironmentDeclaration(TextBuffer &, const char *) {}
void XmlAction::GenerateListAllocation(CTC &ctc, TextBuffer &, int, RuleAllocationElement &) {}
void XmlAction::GenerateAstAllocation(CTC &ctc,
                                   TextBuffer &,
                                   RuleAllocationElement &,
                                   Tuple<ProcessedRuleElement> &,
                                   Array<const char *> &, int) {}
