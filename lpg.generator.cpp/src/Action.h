#ifndef action_INCLUDED
#define action_INCLUDED

#include "tuple.h"
#include "option.h"
#include "LexStream.h"
#include "symbol.h"
#include "set.h"

class Grammar;
class LCA;
class CTC;
class NTC;
class TTC;
class ClassnameElement;
class ProcessedRuleElement;
class RuleAllocationElement;
class ActionBlockElement;

class Control;
class Blocks;

class Action
{
public:

    Action(Control *, Blocks *, Grammar *, MacroLookupTable *);
    virtual ~Action() {}

    int return_code; 

protected:

    Control *control;
    Blocks *action_blocks;
    Grammar *grammar;
    Option *option;
    LexStream *lex_stream;

    MacroLookupTable *macro_table;

    SimpleMacroLookupTable local_macro_table,
                           rule_macro_table,
                           filter_macro_table,
                           export_macro_table;

    SimpleMacroSymbol *rule_number_macro,
                      *rule_text_macro,
                      *rule_size_macro,
                      *input_file_macro,
                      *current_line_macro,
                      *next_line_macro,
                      *identifier_macro,
                      *symbol_declarations_macro;

    SimpleMacroSymbol *InsertLocalMacro(const char *str, const char *value = NULL)
    {
        int length = strlen(str) + 1;
        char *macro_name = new char[length + 1];
        macro_name[0] = option -> escape;
        strcpy(&(macro_name[1]), str);

        SimpleMacroSymbol *macro_symbol = local_macro_table.InsertName(macro_name, length);
        if (value)
            macro_symbol -> SetValue(value);

        delete [] macro_name;

        return macro_symbol;
    }

    SimpleMacroSymbol *InsertLocalMacro(const char *macro_name, int value)
    {
        IntToString num(value);
        return InsertLocalMacro(macro_name, num.String());
    }

    SimpleMacroSymbol *InsertExportMacro(int export_token)
    {
        const char *str = lex_stream -> NameString(export_token);
        int length = lex_stream -> NameStringLength(export_token);

        char *macro_name = new char[length + 3];
        macro_name[0] = option -> escape;
        macro_name[1] = '_';
        strncpy(&(macro_name[2]), str, length);
        macro_name[length + 2] = '\0';

        SimpleMacroSymbol *macro_symbol = export_macro_table.FindOrInsertName(macro_name, length + 2);

        delete [] macro_name;

        return macro_symbol;
    }

    SimpleMacroSymbol *InsertFilterMacro(const char *name, char *value)
    {
        int length = strlen(name);
        char *macro_name = new char[length + 2];
        macro_name[0] = option -> escape;
        strncpy(&(macro_name[1]), name, length);
        macro_name[length + 1] = '\0';

        SimpleMacroSymbol *macro_symbol = filter_macro_table.FindOrInsertName(macro_name, length + 1);
        macro_symbol -> SetValue(value);

        delete [] macro_name;

        return macro_symbol;
    }

    SimpleMacroSymbol *InsertRuleMacro(const char *macro_name, char *value)
    {
        int length = strlen(macro_name);
        SimpleMacroSymbol *macro_symbol = rule_macro_table.InsertName(macro_name, length);
        assert(value);
        macro_symbol -> SetValue(value);

        return macro_symbol;
    }

    inline SimpleMacroSymbol *InsertRuleMacro(const char *macro_name, int value)
    {
        IntToString num(value);
        return InsertRuleMacro(macro_name, num.String());
    }

    SimpleMacroSymbol *FindLocalMacro(const char *str, int length)
    {
        char *macro_name = new char[length + 1];
        for (int i = 0; i < length; i++)
            macro_name[i] = Code::ToLower(str[i]);
        macro_name[length] = '\0';

        SimpleMacroSymbol *macro_symbol = local_macro_table.FindName(macro_name, length);

        delete [] macro_name;

        return macro_symbol;
    }

    inline SimpleMacroSymbol *FindRuleMacro(const char *str, int length)
    {
        return rule_macro_table.FindName(str, length);
    }

    inline SimpleMacroSymbol *FindFilterMacro(const char *str, int length)
    {
        return filter_macro_table.FindName(str, length);
    }

    inline SimpleMacroSymbol *FindExportMacro(const char *str, int length)
    {
        return export_macro_table.FindName(str, length);
    }

    inline MacroSymbol *FindUserDefinedMacro(const char *str, int length)
    {
        return macro_table -> FindName(str, length);
    }

    /**
     * The local functions below are language-independent functions that
     * can be shared by all output languages.
     */
public:
    int LocalMacroTableSize() { return local_macro_table.Size(); }
    SimpleMacroSymbol *GetLocalMacro(int i) { return local_macro_table[i]; }

    int FilterMacroTableSize() { return filter_macro_table.Size(); }
    SimpleMacroSymbol *GetFilterMacro(int i) { return filter_macro_table[i]; }

    void InsertExportMacros();
    void InsertImportedFilterMacros();
    void CheckMacrosForConsistency();
    void SetupBuiltinMacros();

    const char *SkipMargin(TextBuffer *, const char *, const char *);
    void ProcessAstRule(ClassnameElement &, int, Tuple<ProcessedRuleElement> &);
    void ProcessAstMergedRules(LCA &, ClassnameElement &, Tuple<int> &, Tuple< Tuple<ProcessedRuleElement> > &);
    void ProcessCodeActions(Tuple<ActionBlockElement> &, Array<const char *> &, Tuple< Tuple<ProcessedRuleElement> > &);
    void CompleteClassnameInfo(LCA &,
                               TTC &,
                               BoundedArray< Tuple<int> > &,
                               Array<const char *> &,
                               Tuple< Tuple<ProcessedRuleElement> > &,
                               SymbolLookupTable &,
                               Tuple<ClassnameElement> &,
                               Array<RuleAllocationElement> &);
    void ProcessAstActions(Tuple<ActionBlockElement> &,
                           Tuple<ActionBlockElement> &,
                           Tuple<ActionBlockElement> &,
                           Array<const char *> &,
                           Tuple< Tuple<ProcessedRuleElement> > &,
                           SymbolLookupTable &,
                           Tuple<ClassnameElement> &);
    void ProcessActionBlock(ActionBlockElement &);
    void ProcessMacro(TextBuffer *, const char *, int);
    void ProcessActionLine(int, TextBuffer *, const char *, const char *, const char *, int, int);
    void GenerateCode(TextBuffer *, const char *, int);

protected:
    void ComputeInterfaces(ClassnameElement &, Array<const char *> &, Tuple<int> &);
    void CheckRecursivenessAndUpdate(Tuple<int> &, BoundedArray< Tuple<int> > &, Array<RuleAllocationElement> &);
    bool IsNullClassname(ClassnameElement &);

    /**
     * The virtual functions below are language-dependent functions that
     * must be implemented for each output language. Note that they are
     * declared here as asbstract (= 0;) functions.
     */
public:
    virtual const char *GetDefaultTerminalType() = 0;
    virtual const char *GetDefaultNonterminalType() = 0;
    virtual void GenerateDefaultTitle(Tuple<ActionBlockElement> &) = 0;
protected:
    virtual ActionFileSymbol *GenerateTitle(ActionFileLookupTable &, Tuple<ActionBlockElement> &, const char *, bool) = 0;
    virtual ActionFileSymbol *GenerateTitleAndGlobals(ActionFileLookupTable &, Tuple<ActionBlockElement> &, const char *, bool) = 0;

    virtual void GenerateVisitorHeaders(TextBuffer &, const char *, const char *) = 0;
    virtual void GenerateVisitorMethods(NTC &, TextBuffer &, const char *, ClassnameElement &, BitSet &) = 0;
    virtual void GenerateGetAllChildrenMethod(TextBuffer &, const char *, ClassnameElement &) = 0;
    virtual void GenerateEqualsMethod(NTC &, TextBuffer &, const char *, ClassnameElement &, BitSet &) = 0;
    virtual void GenerateHashcodeMethod(NTC &, TextBuffer &, const char *, ClassnameElement &, BitSet &) = 0;

    virtual void GenerateSimpleVisitorInterface(TextBuffer &, const char *, const char *, SymbolLookupTable &) = 0;
    virtual void GenerateArgumentVisitorInterface(TextBuffer &, const char *, const char *, SymbolLookupTable &) = 0;
    virtual void GenerateResultVisitorInterface(TextBuffer &, const char *, const char *, SymbolLookupTable &) = 0;
    virtual void GenerateResultArgumentVisitorInterface(TextBuffer &, const char *, const char *, SymbolLookupTable &) = 0;

    virtual void GeneratePreorderVisitorInterface(TextBuffer &, const char *, const char *, SymbolLookupTable &) = 0;
    virtual void GeneratePreorderVisitorAbstractClass(TextBuffer &, const char *, const char *, SymbolLookupTable &) = 0;

    virtual void GenerateNoResultVisitorAbstractClass(TextBuffer &, const char *, const char *, SymbolLookupTable &) = 0;
    virtual void GenerateResultVisitorAbstractClass(TextBuffer &, const char *, const char *, SymbolLookupTable &) = 0;

    virtual void GenerateAstType(TextBuffer &, const char *, const char *) = 0;
    virtual void GenerateAstListType(TextBuffer &, const char *, const char *) = 0;
    virtual void GenerateAstTokenType(NTC &, TextBuffer &, const char *, const char *) = 0;
    virtual void GenerateInterface(bool,
                                   TextBuffer &,
                                   const char *,
                                   const char *,
                                   Tuple<int> &,
                                   Tuple<int> &,
                                   Tuple<ClassnameElement> &) = 0;
    virtual void GenerateCommentHeader(TextBuffer &, const char *, ClassnameElement &) = 0;
    virtual void GenerateListClass(CTC &, NTC &, TextBuffer &, const char *, ClassnameElement &, Array<const char *> &) = 0;
    virtual void GenerateRuleClass(CTC &, NTC &, TextBuffer &, const char *, ClassnameElement &, Array<const char *> &) = 0;
    virtual void GenerateMergedClass(CTC &,
                                     NTC &,
                                     TextBuffer &,
                                     const char *,
                                     ClassnameElement &,
                                     Tuple< Tuple<ProcessedRuleElement> > &,
                                     Array<const char *> &) = 0;
    virtual void GenerateTerminalMergedClass(NTC &, TextBuffer &, const char *, ClassnameElement &, Array<const char *> &) = 0;
    virtual void GenerateNullAstAllocation(TextBuffer &, int rule_no) = 0;
    virtual void GenerateEnvironmentDeclaration(TextBuffer &, const char *) = 0;
    virtual void GenerateListAllocation(CTC &ctc, TextBuffer &, int, RuleAllocationElement &) = 0;
    virtual void GenerateAstAllocation(CTC &ctc,
                                       TextBuffer &,
                                       RuleAllocationElement &,
                                       Tuple<ProcessedRuleElement> &,
                                       Array<const char *> &, int) = 0;
};
#endif /* action_INCLUDED */
