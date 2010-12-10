#include "XmlAction.h"

//
// TODO: This is a copy of the JavaAction code. Fix it for XML
//
void XmlAction::ProcessCodeActions(Tuple<ActionBlockElement> &actions, Array<const char *> &typestring, Tuple< Tuple<ProcessedRuleElement> > &processed_rule_map)
{
    //
    // We now process all action blocks that are associated with the rules.
    // During this processing the output information is buffered.
    //
    for (int k = 0; k < actions.Length(); k++)
    {
        rule_macro_table.Push(); // prepare to insert macros for this rule
        local_macro_table.Push(); // prepare to insert macros for this rule

        int rule_number = actions[k].rule_number;

        //
        // Map the position of each symbol in the right-hand side of the rule to
        // the type of the symbol in question.
        //
        Array<const char *> rule_type(grammar -> RhsSize(rule_number) + 1, NULL);
        Array<bool> is_terminal(grammar -> RhsSize(rule_number) + 1, false);
        if (grammar -> parser.types.Length() > 0)
        {
            for (int i = grammar -> FirstRhsIndex(rule_number), k = 1; i < grammar -> EndRhsIndex(rule_number); i++, k++)
            {
                int image = grammar -> rhs_sym[i];
                is_terminal[k] = grammar -> IsTerminal(image);
                rule_type[k] = typestring[image];
            }
        }

        //
        //
        //
        Tuple<ProcessedRuleElement> &processed_rule_elements = processed_rule_map[rule_number];
        Array<SimpleMacroSymbol *> macros(processed_rule_elements.Length());
        int length = 0;
        const char *line_header = "//#line ";
        for (int i = 0; i < processed_rule_elements.Length(); i++) // Insert the macros for the rules associated with this block
        {
            ProcessedRuleElement &processed_rule_element = processed_rule_elements[i];
            if (processed_rule_element.position == 0) // a null argument that is not associated with any symbol
                continue;

            const char *name = lex_stream -> NameString(processed_rule_element.token_index);
            int macro_name_length = strlen(name);
            if (*name != option -> escape)
            {
                if (! Code::IsValidVariableName(name))
                {
                    VariableSymbol *symbol = grammar -> GetSymbol(processed_rule_element.token_index);
                    int image = (symbol ? symbol -> SymbolIndex() : 0);
                    if (image != 0)
                    {
                        name = grammar -> RetrieveString(image);
                        macro_name_length = strlen(name);
                    }
                }
                macro_name_length++;
            }

            char *macro_name = new char[macro_name_length + 1];
                if (*name == option -> escape)
                    strcpy(macro_name, name);
                else
                {
                    macro_name[0] = option -> escape;
                    strcpy(&(macro_name[1]), name);
                }

                //
                // This problem can occur when the same variable is used more than once on the right-hand side of a rule.
                // The user can bypass this problem by simply renaming the variable. For example:
                //
                // Rule ::= a B a$a2
                //
                // In the example above, the second instance of a is renamed a2.
                //
                if (rule_macro_table.FindName(macro_name, macro_name_length))
                {
                    TextBuffer msg;
                    msg.Put("Illegal respecification of predefined macro \"");
                    msg.Put(macro_name);
                    msg.Put("\"");
                    option -> EmitError(processed_rule_element.token_index, msg);
                    return_code = 12;
                }

                //
                // This check addresses the case where the right-hand side of a rule contains a variable
                // with the same name as that of a predefined local macro (e.g., package)
                //
                if (FindLocalMacro(macro_name, macro_name_length))
                {
                    TextBuffer msg;
                    msg.Put("Definition of the rule macro \"");
                    msg.Put(macro_name);
                    msg.Put("\" temporarily hides the definition of a local macro with the same name");
                    option -> EmitWarning(processed_rule_element.token_index, msg);
                }

                if (! Code::IsValidVariableName(macro_name + 1))
                {
                    option -> EmitError(processed_rule_element.token_index, "Invalid use of a symbol name as a macro");
                    return_code = 12;
                }

                macros[i] = InsertRuleMacro(macro_name, processed_rule_element.position);

                if (grammar -> parser.types.Length() > 0 && option -> automatic_ast == Option::NONE)
                {
                    length += (strlen(line_header) +
                               15 + // max integer size is 11 + one space + 2 quotes for file name + newline.
                               lex_stream -> GetFileSymbol(processed_rule_element.token_index) -> NameLength());
                    if (is_terminal[processed_rule_element.position])
                         length += (2 * strlen(rule_type[processed_rule_element.position]) +
                                    macro_name_length +
                                    strlen("  = () getRhsIToken();\n") +
                                    strlen(macros[i] -> Value())
                                    + 1);
                    else length += (2 * strlen(rule_type[processed_rule_element.position]) +
                                    macro_name_length +
                                    strlen("  = () getRhsSym();\n") +
                                    strlen(macros[i] -> Value())
                                    + 1);
                }
            delete [] macro_name;
        }

        //
        //
        //
        SimpleMacroSymbol *save_symbol_declarations_macro = symbol_declarations_macro;
        char *str = new char[length + 1];
            if (length > 0)
            {
                *str = '\0';
                for (int i = 0; i < processed_rule_elements.Length(); i++) // Insert the macros for the rules associated with this block
                {
                    ProcessedRuleElement &processed_rule_element = processed_rule_elements[i];
                    SimpleMacroSymbol *macro = macros[i];
                    if (macro) // A valid macro?
                    {
                        int position = processed_rule_element.position;
                        char *macro_name = macro -> Name() + 1; // +1 to skip escape

                        strcat(str, line_header);
                        IntToString line(lex_stream -> Line(processed_rule_element.token_index));
                        strcat(str, line.String());
                        strcat(str, " \"");
                        strcat(str, FileWithoutPrefix(lex_stream -> GetFileSymbol(processed_rule_element.token_index) -> Name()).c_str());
                        strcat(str, "\"\n");

                        strcat(str, rule_type[position]);
                        strcat(str, " ");
                        strcat(str, macro_name);
                        strcat(str, " = (");
                        strcat(str, rule_type[position]);
                        strcat(str, ") ");
                        if (is_terminal[position])
                             strcat(str, "getRhsIToken(");
                        else strcat(str, "getRhsSym(");
                        strcat(str, macro -> Value());
                        strcat(str, ");");

                        if (i < processed_rule_elements.Length() - 1)
                            strcat(str, "\n");
                    }
                }

                assert(strlen(str) <= (unsigned) length);
                symbol_declarations_macro = InsertLocalMacro("symbol_declarations", str);
            }

            ProcessRuleActionBlock(actions[k]);

        delete [] str;

        symbol_declarations_macro = save_symbol_declarations_macro;

        local_macro_table.Pop(); // remove the macros for the rules associated with this block
        rule_macro_table.Pop(); // remove the macros for the rules associated with this block
    }

    return;
}



//
//
//
void XmlAction::ProcessRuleActionBlock(ActionBlockElement &action)
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
void XmlAction::ExpandExportMacro(TextBuffer *buffer, SimpleMacroSymbol *simple_macro)
{
    buffer -> Put(option -> exp_type);
    buffer -> Put(".");
    buffer -> Put(option -> exp_prefix);
    buffer -> Put(simple_macro -> Name() + 2); // skip initial escape and '_' characters
    buffer -> Put(option -> exp_suffix);
}


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
void XmlAction::GenerateAbstractAstListType(TextBuffer &, const char *, const char *) {}
void XmlAction::GenerateAstTokenType(NTC &, TextBuffer &, const char *, const char *) {}
void XmlAction::GenerateInterface(bool, TextBuffer &, const char *, const char *, Tuple<int> &, Tuple<int> &, Tuple<ClassnameElement> &) {}
void XmlAction::GenerateCommentHeader(TextBuffer &, const char *, Tuple<int> &, Tuple<int> &) {}
void XmlAction::GenerateListExtensionClass(CTC &, NTC &, TextBuffer &, const char *, SpecialArrayElement &, ClassnameElement &, Array<const char *> &) {}
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
