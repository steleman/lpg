#include "NTC.h"
#include "TTC.h"
#include "CTC.h"
#include "LCA.h"
#include "symbol.h"
#include "LexStream.h"
#include "action.h"

//
//
//
Action::Action(Control *control_, Blocks *action_blocks_, Grammar *grammar_, MacroLookupTable *macro_table_)
       : return_code(0),
         control(control_),
         action_blocks(action_blocks_),
         grammar(grammar_),
         option(control_ -> option),
         lex_stream(control_ -> lex_stream),
         macro_table(macro_table_)
{}


bool Action::IsNullClassname(ClassnameElement &element)
{
    return element.rule.Length() == 0 ||
           (strlen(element.real_name) == 0 &&
            (element.array_element_type_symbol == NULL ||
             element.array_element_type_symbol -> NameLength() == 0));
}

void Action::ComputeInterfaces(ClassnameElement &element, Array<const char *> &typestring, Tuple<int> &rule)
{
    SymbolLookupTable interface_set;
    for (int i = 0; i < rule.Length(); i++)
    {
        int rule_no = rule[i];
        const char *name = typestring[grammar -> rules[rule_no].lhs];
        if (interface_set.FindName(name, strlen(name)) == NULL)
        {
            interface_set.InsertName(name, strlen(name));
            element.interface.Next() = grammar -> rules[rule_no].lhs;
        }
    }
}


void Action::InsertExportMacros()
{
    for (int i = 0; i < grammar -> parser.exports.Length(); i++)
    {
        int export_token = grammar -> parser.exports[i];
        SimpleMacroSymbol *macro = InsertExportMacro(export_token);
        if (FindLocalMacro(macro -> Name(), macro -> NameLength()))
        {
            Tuple<const char *> msg;
            msg.Next() = "The name of the exported symbol ";
            msg.Next() = macro -> Name();
            msg.Next() = " conflicts with the predefined macro of the same name";
            option -> EmitError(export_token, msg);

            return_code = 12;
        }
    }
}


void Action::InsertImportedFilterMacros()
{
    for (int i = 0; i < lex_stream -> NumImportedFilters(); i++)
    {
        int export_token = lex_stream -> ImportedFilter(i);
        SimpleMacroSymbol *macro = InsertExportMacro(export_token);
        if (FindLocalMacro(macro -> Name(), macro -> NameLength()))
        {
            Tuple<const char *> msg;
            msg.Next() = "The name of the exported symbol ";
            msg.Next() = macro -> Name();
            msg.Next() = " conflicts with the predefined macro of the same name";
            option -> EmitError(export_token, msg);

            return_code = 12;
        }
    }
}


//
// We now make sure that none of the user-defined macros appear
// in either the local macro table or the export_macro_table.
//
void Action::CheckMacrosForConsistency()
{
    for (int i = 0; i < macro_table -> Size(); i++)
    {
        MacroSymbol *macro = macro_table -> Element(i);
        if (FindLocalMacro(macro -> Name(), macro -> NameLength()))
        {
            Tuple<const char *> msg;
            msg.Next() = "The user-defined macro ";
            msg.Next() = macro -> Name();
            msg.Next() = " conflicts with the predefined macro of the same name";
            option -> EmitError(macro -> Location(), msg);

            return_code = 12;
        }
        else if (FindExportMacro(macro -> Name(), macro -> NameLength()))
        {
            Tuple<const char *> msg;
            msg.Next() = "The user-defined macro ";
            msg.Next() = macro -> Name();
            msg.Next() = " conflicts with an exported symbol of the same name";
            option -> EmitError(macro -> Location(), msg);

            return_code = 12;
        }
    }
}

void Action::SetupBuiltinMacros()
{
    //
    // First, insert local macros. Then, process all actions
    //
    rule_number_macro = InsertLocalMacro("rule_number");
    rule_text_macro = InsertLocalMacro("rule_text");
    rule_size_macro = InsertLocalMacro("rule_size");
    input_file_macro = InsertLocalMacro("input_file");
    current_line_macro = InsertLocalMacro("current_line");
    next_line_macro = InsertLocalMacro("next_line");
    identifier_macro = InsertLocalMacro("#identifier",
                                        (grammar -> parser.identifier_index == 0
                                                  ? NULL
                                                  : lex_stream -> GetVariableSymbol(grammar -> parser.identifier_index) -> Name()));
    symbol_declarations_macro = InsertLocalMacro("symbol_declarations", "");

    (void) InsertLocalMacro("num_rules", grammar -> num_rules);
    (void) InsertLocalMacro("num_terminals", grammar -> num_terminals);
    (void) InsertLocalMacro("num_nonterminals", grammar -> num_nonterminals);
    (void) InsertLocalMacro("num_non_terminals", grammar -> num_nonterminals); // for upward compatibility with old version
    (void) InsertLocalMacro("num_symbols", grammar -> num_symbols);
    (void) InsertLocalMacro("template", option -> template_name);
    (void) InsertLocalMacro("file_prefix", option -> file_prefix);
    (void) InsertLocalMacro("package", option -> package);
    (void) InsertLocalMacro("ast_package", option -> ast_package);
    (void) InsertLocalMacro("ast_type", option -> ast_type);
    (void) InsertLocalMacro("exp_type", option -> exp_type);
    (void) InsertLocalMacro("prs_type", option -> prs_type);
    (void) InsertLocalMacro("sym_type", option -> sym_type);
    (void) InsertLocalMacro("action_type", option -> action_type);
    (void) InsertLocalMacro("visitor_type", option -> visitor_type);

    //
    // Process filters macros 
    //
    for (int i = 0; i < lex_stream -> NumFilterMacros(); i++)
        InsertFilterMacro(lex_stream -> FilterMacro(i).macro_name, lex_stream -> FilterMacro(i).macro_value);

    return;
}


//
//
//
void Action::ProcessAstRule(ClassnameElement &classname, int rule_no, Tuple<ProcessedRuleElement> &processed_rule_elements)
{
    SymbolLookupTable &symbol_set = classname.symbol_set;
    Tuple<int> &rhs_type_index = classname.rhs_type_index;

    assert(symbol_set.Size() == 0);
    assert(rhs_type_index.Length() == 0);

    int offset = grammar -> FirstRhsIndex(rule_no) - 1;

    for (int i = 0; i < processed_rule_elements.Length(); i++)
    {
        ProcessedRuleElement &processed_rule_element = processed_rule_elements[i];

        VariableSymbol *variable_symbol = grammar -> GetSymbol(processed_rule_element.token_index);
        int image = (variable_symbol ? variable_symbol -> SymbolIndex() : 0);
        const char *variable_name;
        int length;
        if (image != 0)
        {
            variable_name = grammar -> RetrieveString(image);
            length = strlen(variable_name);
        }
        else
        {
            variable_name = lex_stream -> NameString(processed_rule_element.token_index);
            length = lex_stream -> NameStringLength(processed_rule_element.token_index);
        }

        if (*variable_name == option -> escape)
        {
            variable_name++;
            length--;
        }
        Symbol *symbol;
        if (! symbol_set.FindName(variable_name, length))
            symbol = symbol_set.InsertName(variable_name, length);
        else
        {
            IntToString suffix(processed_rule_element.position);
            length += strlen(suffix.String());
            char *new_name = new char[length + 1];
            strcpy(new_name, variable_name);
            strcat(new_name, suffix.String());
            symbol = symbol_set.InsertName(new_name, length);

            delete [] new_name;
        }

        assert(rhs_type_index.Length() == symbol -> Index());
        processed_rule_element.symbol_index = symbol -> Index();
        processed_rule_element.type_index = grammar -> rhs_sym[offset + processed_rule_element.position];
        rhs_type_index.Next() = processed_rule_element.type_index;
    }

    return;
}


void Action::ProcessAstMergedRules(LCA &lca, ClassnameElement &element, Tuple<int> &rule, Tuple< Tuple<ProcessedRuleElement> > &processed_rule_map)
{
    SymbolLookupTable &symbol_set = element.symbol_set;
    Tuple<int> &rhs_type_index = element.rhs_type_index;
    assert(symbol_set.Size() == 0);
    assert(rhs_type_index.Length() == 0);

    Tuple<bool> is_nonterminal;
    Tuple<int> token_of_symbol;
    Tuple<int> rule_of_symbol;
    Array< Tuple<int> > rule_map(rule.Length());

    for (int k = 0; k < rule.Length(); k++)
    {
        int rule_no = rule[k],
            offset = grammar -> FirstRhsIndex(rule_no) - 1;
        Tuple<ProcessedRuleElement> &processed_rule_elements = processed_rule_map[rule_no];

        SymbolLookupTable local_set;
        for (int i = 0; i < processed_rule_elements.Length(); i++) // Insert the macros for the rules associated with this block
        {
            ProcessedRuleElement &processed_rule_element = processed_rule_elements[i];

            VariableSymbol *variable_symbol = grammar -> GetSymbol(processed_rule_element.token_index);
            int image = (variable_symbol ? variable_symbol -> SymbolIndex() : 0);
            const char *variable_name;
            int length;
            if (image != 0)
            {
                variable_name = grammar -> RetrieveString(image);
                length = strlen(variable_name);
            }
            else
            {
                variable_name = lex_stream -> NameString(processed_rule_element.token_index);
                length = lex_stream -> NameStringLength(processed_rule_element.token_index);
            }

            if (*variable_name == option -> escape)
            {
                variable_name++;
                length--;
            }

            Symbol *symbol = symbol_set.FindName(variable_name, length);
            if (! symbol)
            {
                (void) local_set.InsertName(variable_name, length);
                symbol = symbol_set.InsertName(variable_name, length);
                assert(rhs_type_index.Length() == symbol -> Index());
                rhs_type_index.Next() = grammar -> rhs_sym[offset + processed_rule_element.position];
                is_nonterminal.Next() = grammar -> IsNonTerminal(grammar -> rhs_sym[offset + processed_rule_element.position]);
                token_of_symbol.Next() = processed_rule_element.token_index - 1;
                rule_of_symbol.Next() = rule_no;
            }
            else if (local_set.FindName(variable_name, length))
            {
                IntToString suffix(processed_rule_element.position);
                length += strlen(suffix.String());
                char *new_name = new char[length + 1];
                strcpy(new_name, variable_name);
                strcat(new_name, suffix.String());
                symbol = symbol_set.FindName(new_name, length);
                if (! symbol)
                {
                    symbol = symbol_set.InsertName(new_name, length);

                    assert(rhs_type_index.Length() == symbol -> Index());
                    rhs_type_index.Next() = grammar -> rhs_sym[offset + processed_rule_element.position];
                    is_nonterminal.Next() = grammar -> IsNonTerminal(grammar -> rhs_sym[offset + processed_rule_element.position]);
                    token_of_symbol.Next() = processed_rule_element.token_index - 1;
                    rule_of_symbol.Next() = rule_no;
                }
                else
                {
                    if (grammar -> IsNonTerminal(grammar -> rhs_sym[offset + processed_rule_element.position]) &&
                        is_nonterminal[symbol -> Index()])
                        rhs_type_index[symbol -> Index()] = lca.Find(rhs_type_index[symbol -> Index()],
                                                                     grammar -> rhs_sym[offset + processed_rule_element.position]);
                }
                (void) local_set.InsertName(new_name, length);
            }
            else
            {
                (void) local_set.FindOrInsertName(variable_name, length);
                if (grammar -> IsNonTerminal(grammar -> rhs_sym[offset + processed_rule_element.position]) &&
                    is_nonterminal[symbol -> Index()])
                    rhs_type_index[symbol -> Index()] = lca.Find(rhs_type_index[symbol -> Index()],
                                                                 grammar -> rhs_sym[offset + processed_rule_element.position]);
            }

            rule_map[k].Next() = symbol -> Index();
        }
    }

    //
    //
    //
    Array<ProcessedRuleElement> symbol_map(symbol_set.Size());
    for (int i = 0; i < rule.Length(); i++)
    {
        int rule_no = rule[i];
        Tuple<ProcessedRuleElement> &processed_rule_elements = processed_rule_map[rule_no];
        assert(processed_rule_elements.Length() == rule_map[i].Length());
        symbol_map.MemReset();
        for (int j = 0; j < rule_map[i].Length(); j++)
        {
            processed_rule_elements[j].symbol_index = rule_map[i][j];
            processed_rule_elements[j].type_index = rhs_type_index[rule_map[i][j]];

            symbol_map[processed_rule_elements[j].symbol_index] = processed_rule_elements[j];
        }

        //
        // Now, we will reconstruct the processed_rule_elements for rule_no. We
        // also properly set the symbol and type indexes for null arguments.
        //
        processed_rule_elements.Reset();
        {
            for (int j = 0; j < symbol_map.Size(); j++)
            {
                ProcessedRuleElement &processed_rule_element = processed_rule_elements.Next();
                processed_rule_element = symbol_map[j];
                if (processed_rule_element.position == 0)
                {
                    processed_rule_element.symbol_index = j;
                    processed_rule_element.type_index = rhs_type_index[j];
                }
            }
        }
    }

    return;
}


void Action::ProcessCodeActions(Tuple<ActionBlockElement> &actions, Array<const char *> &typestring, Tuple< Tuple<ProcessedRuleElement> > &processed_rule_map)
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

            if (FindLocalMacro(macro_name, macro_name_length) ||
                rule_macro_table.FindName(macro_name, macro_name_length))
                 option -> EmitError(processed_rule_element.token_index, "Illegal respecification of a predefined macro");

            if (! Code::IsValidVariableName(macro_name + 1))
                option -> EmitError(processed_rule_element.token_index, "Invalid use of a symbol name as a macro");

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
                    strcat(str, lex_stream -> GetFileSymbol(processed_rule_element.token_index) -> Name());
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

        ProcessActionBlock(actions[k]);

        delete [] str;
        symbol_declarations_macro = save_symbol_declarations_macro;

        local_macro_table.Pop(); // remove the macros for the rules associated with this block
        rule_macro_table.Pop(); // remove the macros for the rules associated with this block
    }

    return;
}

void Action::CompleteClassnameInfo(LCA &lca,
                                   TTC &ttc,
                                   BoundedArray< Tuple<int> > &global_map,
                                   Array<const char *> &typestring,
                                   Tuple< Tuple<ProcessedRuleElement> > &processed_rule_map,
                                   SymbolLookupTable &classname_set,
                                   Tuple<ClassnameElement> &classname,
                                   Array<RuleAllocationElement> &rule_allocation_map)
{
    //
    // Process Array classes and Split ambiguous classnames.
    //
    for (int i = 0; i < classname.Length(); i++)
    {
        //
        // No class is generated for rules that are associated with the null classname.
        //
        if (IsNullClassname(classname[i]))
            continue;

        if (classname[i].array_element_type_symbol != NULL)
        {
            Tuple<int> &rule = classname[i].rule;

            //
            // Compute the set of nonterminals that appear on the left-hand
            // side of the set of rules associated with this list.
            //
            Tuple<int> nonterminals;
            BoundedArray< Tuple<int> > nonterminal_map(grammar -> num_terminals + 1, grammar -> num_symbols);
            {
                for (int k = 0; k < rule.Length(); k++)
                {
                    int rule_no = rule[k],
                        lhs = grammar -> rules[rule_no].lhs;
                    if (nonterminal_map[lhs].Length() == 0)
                        nonterminals.Next() = lhs;
                    nonterminal_map[lhs].Next() = rule_no;
                }
            }

            //
            // Compute the set of nonterminals that can only produce this list.
            // In other words, the set of nonterminals such that all its rules
            // are associated with this list.
            //
            BoundedArray<bool> is_list_nonterminal(grammar -> num_terminals + 1, grammar -> num_symbols);
            is_list_nonterminal.MemReset();
            for (int k = 0; k < nonterminals.Length(); k++)
            {
                int lhs = nonterminals[k];
                if (global_map[lhs].Length() == nonterminal_map[lhs].Length())
                    is_list_nonterminal[lhs] = true;
                else if (option -> warnings)
                {
                    int rule_no = global_map[lhs][0],
                        source_index = grammar -> rules[rule_no].source_index;
                    option -> EmitWarning(grammar -> parser.rules[source_index].lhs_index,
                                          "Not all rules generated by this nonterminal are associated with this list");
                }
            }

            //
            //
            //
            if (classname[i].array_element_type_symbol -> NameLength() == 0)
            {
                //
                //
                //
                int element_type_symbol_index = -1;
                for (int k = 0; k < rule.Length(); k++)
                {
                    int rule_no = rule[k],
                        offset = grammar -> FirstRhsIndex(rule_no) - 1;
                    Tuple<ProcessedRuleElement> &processed_rule_elements = processed_rule_map[rule_no];
                    rule_allocation_map[rule_no].name = classname[i].real_name;
                    for (int j = 0;  j < processed_rule_elements.Length(); j++)
                    {
                        ProcessedRuleElement &processed_rule_element = processed_rule_elements[j];
                        int symbol = grammar -> rhs_sym[offset + processed_rule_element.position];
                        if (grammar -> IsNonTerminal(symbol) && is_list_nonterminal[symbol])
                        {
                            if (rule_allocation_map[rule_no].list_symbol != 0)
                            {
                                int source_index = grammar -> rules[rule_no].source_index;
                                option -> EmitError(grammar -> parser.rules[source_index].classname_index,
                                                    "Multiple list specified on the right-hand side of this rule");
                            }
                            rule_allocation_map[rule_no].list_symbol = symbol;
                            rule_allocation_map[rule_no].list_position = processed_rule_element.position;
                        }
                        else
                        {
                            if (rule_allocation_map[rule_no].element_symbol != 0)
                            {
                                int source_index = grammar -> rules[rule_no].source_index;
                                option -> EmitError(grammar -> parser.rules[source_index].array_element_type_index,
                                                    "Multiple element symbols specified on the right-hand side of this rule");
                            }
                            rule_allocation_map[rule_no].element_symbol = symbol;
                            rule_allocation_map[rule_no].element_position = processed_rule_element.position;
                        }
                    }

                    //
                    // A rule of the form A ::= ... B ... where B is a list.
                    // Note that the ... does not have to be the empty string.
                    // For example, we might have a rule of the form:
                    // A ::= ( List )
                    //
                    //   or
                    //
                    // A ::= List ;
                    //
                    if (rule_allocation_map[rule_no].list_position == 0 && rule_allocation_map[rule_no].element_position == 0)
                         rule_allocation_map[rule_no].list_kind = RuleAllocationElement::EMPTY;
                    else if (rule_allocation_map[rule_no].list_symbol == 0)
                    {
                        rule_allocation_map[rule_no].list_kind = RuleAllocationElement::SINGLETON;
                        if (element_type_symbol_index == -1)
                            element_type_symbol_index = (grammar -> IsTerminal(rule_allocation_map[rule_no].element_symbol)
                                                             ? grammar -> Get_ast_token_interface()
                                                             : rule_allocation_map[rule_no].element_symbol);
                        else if (element_type_symbol_index != rule_allocation_map[rule_no].element_symbol)
                        {
                            element_type_symbol_index =
                                     lca.Find(element_type_symbol_index,
                                              (grammar -> IsTerminal(rule_allocation_map[rule_no].element_symbol)
                                                   ? grammar -> Get_ast_token_interface()
                                                   : rule_allocation_map[rule_no].element_symbol));
                        }
                    }
                    else if (rule_allocation_map[rule_no].element_symbol == 0)
                         rule_allocation_map[rule_no].list_kind = RuleAllocationElement::COPY_LIST;
                    else rule_allocation_map[rule_no].list_kind = RuleAllocationElement::ADD_ELEMENT;
                }

                //
                // Set the array element type for the classname and each RuleAllocationElement.
                //
                if (element_type_symbol_index == -1)
                    element_type_symbol_index = 0; // if not initialized, initialize it to "Ast" index
                CheckRecursivenessAndUpdate(nonterminals, nonterminal_map, rule_allocation_map);
                for (int j = 0; j < nonterminals.Length(); j++)
                {
                    int lhs = nonterminals[j];
                    for (int k = 0; k < nonterminal_map[lhs].Length(); k++)
                    {
                        int rule_no = nonterminal_map[lhs][k];
                        rule_allocation_map[rule_no].element_type_symbol_index = element_type_symbol_index;
                    }
                }
            }
            else
            {
                //
                //
                //
                for (int k = 0; k < rule.Length(); k++)
                {
                    int rule_no = rule[k];
                    rule_allocation_map[rule_no].name = classname[i].real_name;
                    rule_allocation_map[rule_no].element_type_symbol_index = classname[i].array_element_type_symbol -> SymbolIndex();

                    for (int j = grammar -> FirstRhsIndex(rule_no); j < grammar -> EndRhsIndex(rule_no); j++)
                    {
                        int symbol = grammar -> rhs_sym[j];
                        if (grammar -> IsNonTerminal(symbol) && is_list_nonterminal[symbol])
                        {
                            if (rule_allocation_map[rule_no].list_symbol != 0)
                            {
                                int source_index = grammar -> rules[rule_no].source_index;
                                option -> EmitError(grammar -> parser.rules[source_index].classname_index,
                                                    "Multiple list specified on the right-hand side of this rule");
                            }
                            rule_allocation_map[rule_no].list_symbol = symbol;
                            rule_allocation_map[rule_no].list_position = j - grammar -> FirstRhsIndex(rule_no) + 1;
                        }
                        else if (symbol == rule_allocation_map[rule_no].element_type_symbol_index)
                        {
                            if (rule_allocation_map[rule_no].element_symbol != 0)
                            {
                                int source_index = grammar -> rules[rule_no].source_index;
                                option -> EmitError(grammar -> parser.rules[source_index].array_element_type_index,
                                                    "Multiple element symbols specified on the right-hand side of this rule");
                            }
                            rule_allocation_map[rule_no].element_symbol = symbol;
                            rule_allocation_map[rule_no].element_position = j - grammar -> FirstRhsIndex(rule_no) + 1;
                        }
                    }

                    //
                    // A rule of the form A ::= ... B ... where B is a list.
                    // Note that the ... does not have to be the empty string.
                    // For example, we might have a rule of the form:
                    // A ::= ( List )
                    //
                    //   or
                    //
                    // A ::= List ;
                    //
                    if (rule_allocation_map[rule_no].list_position == 0 && rule_allocation_map[rule_no].element_position == 0)
                         rule_allocation_map[rule_no].list_kind = RuleAllocationElement::EMPTY;
                    else if (rule_allocation_map[rule_no].list_symbol == 0)
                         rule_allocation_map[rule_no].list_kind = RuleAllocationElement::SINGLETON;
                    else if (rule_allocation_map[rule_no].element_symbol == 0)
                         rule_allocation_map[rule_no].list_kind = RuleAllocationElement::COPY_LIST;
                    else rule_allocation_map[rule_no].list_kind = RuleAllocationElement::ADD_ELEMENT;
                }
            }

            //
            // Add the set of left-hand side nonterminals to the list of
            // interfaces for this ArrayList class. Note that the recursive
            // nonterminal must be the first element of the list.
            //
            CheckRecursivenessAndUpdate(nonterminals, nonterminal_map, rule_allocation_map);
            for (int j = 0; j < nonterminals.Length(); j++)
            {
                int lhs = nonterminals[j];
                classname[i].interface.Next() = lhs;
            }
            assert(classname[i].ungenerated_rule.Length() == 0);
        }
        else
        {
            Tuple<int> &rule = classname[i].rule;
            if (rule.Length() == 1)
            {
                int rule_no = rule[0];
                classname[i].interface.Next() = grammar -> rules[rule_no].lhs;
                ProcessAstRule(classname[i], rule_no, processed_rule_map[rule_no]);
                classname[i].is_terminal_class = (grammar -> RhsSize(rule_no) == 1 &&
                                                  ttc.IsTerminalSymbol(grammar -> rhs_sym[grammar -> FirstRhsIndex(rule_no)]));
                rule_allocation_map[rule_no].name = classname[i].real_name;
                rule_allocation_map[rule_no].is_terminal_class = classname[i].is_terminal_class;
            }
            else if (classname[i].specified_name != classname[i].real_name) // a classname was specified?
            {
                ComputeInterfaces(classname[i], typestring, rule);

                ProcessAstMergedRules(lca, classname[i], rule, processed_rule_map);

                //
                // A merged class is considered a terminal class if it contains
                // only a single attribute that is a terminal attribute. This is
                // possible when each rule associated with the merged class in
                // question is a single production; all the right-hand side 
                // symbols of these single productions are mapped into the same
                // name; and each right-hand side symbol is either a terminal or
                // it's a nonterminal associated only with terminal classes.
                //
//                classname[i].is_terminal_class = (classname[i].rhs_type_index.Length() == 1);
                classname[i].is_terminal_class = true;
                for (int k = 0; classname[i].is_terminal_class && k < rule.Length(); k++)
                {
                    int rule_no = rule[k];
                    classname[i].is_terminal_class = classname[i].is_terminal_class &&
                                                     (grammar -> RhsSize(rule_no) == 1 &&
                                                      ttc.IsTerminalSymbol(grammar -> rhs_sym[grammar -> FirstRhsIndex(rule_no)]));
                }

                {
                    for (int k = 0; k < rule.Length(); k++)
                        rule_allocation_map[rule[k]].is_terminal_class = classname[i].is_terminal_class;
                }
            }
            else // generate independent classes.
            {
                for (int k = 0; k < rule.Length(); k++)
                {
                    int rule_no = rule[k];

                    IntToString suffix(k); // Using suffix(k) is more invariant than suffix(rule_no);
                    int length = strlen(classname[i].real_name) + strlen(suffix.String());
                    char *new_name = new char[length + 1];
                    strcpy(new_name, classname[i].real_name);
                    strcat(new_name, suffix.String());

                    ClassnameElement &additional_classname = classname.Next();
                    additional_classname.rule.Next() = rule_no;
                    additional_classname.specified_name = classname_set.FindOrInsertName(new_name, strlen(new_name)) -> Name();
                    additional_classname.real_name = additional_classname.specified_name;

                    delete [] new_name;
                }
                classname[i].rule.Reset();
            }
        }
    }

    return;
}


void Action::ProcessAstActions(Tuple<ActionBlockElement> &actions,
                               Tuple<ActionBlockElement> &notice_actions,
                               Tuple<ActionBlockElement> &initial_actions,
                               Array<const char *> &typestring,
                               Tuple< Tuple<ProcessedRuleElement> > &processed_rule_map,
                               SymbolLookupTable &classname_set,
                               Tuple<ClassnameElement> &classname)
{
    ActionFileLookupTable ast_filename_table(4096);
    TextBuffer &ast_buffer = *(option -> DefaultBlock() -> ActionfileSymbol() -> BodyBuffer());
    Array<RuleAllocationElement> rule_allocation_map(grammar -> num_rules + 1);

    //
    // Map each rule into the set of action blocks that is associated with it.
    //
    Array< Tuple<ActionBlockElement> > rule_action_map(grammar -> num_rules + 1);
    {
        for (int i = 0; i < actions.Length(); i++)
            rule_action_map[actions[i].rule_number].Next() = actions[i];
    }

    //
    // For each nonterminal A, compute the set of rules that A produces.
    //
    BoundedArray< Tuple<int> > global_map(grammar -> num_terminals + 1, grammar -> num_symbols);
    {
        for (int rule_no = grammar -> FirstRule(); rule_no <= grammar -> LastRule(); rule_no++)
        {
            int lhs = grammar -> rules[rule_no].lhs;
            global_map[lhs].Next() = rule_no;
        }
    }

    TTC ttc(global_map, processed_rule_map);

    //
    // Compute the interface depences.
    //
    assert(grammar -> Get_ast_token_interface() == grammar -> num_symbols + 1);
    BoundedArray< Tuple<int> > extension_of(grammar -> num_terminals + 1, grammar -> Get_ast_token_interface());
    BoundedArray<BitSetWithOffset> extension_set(grammar -> num_terminals + 1, grammar -> Get_ast_token_interface());
    for (int nt = extension_set.Lbound(); nt <= extension_set.Ubound(); nt++)
        extension_set[nt].Initialize(extension_set.Size() + 1, extension_set.Lbound() - 1);

    for (int rule_no = grammar -> FirstRule(); rule_no <= grammar -> LastRule(); rule_no++)
    {
        int lhs = grammar -> rules[rule_no].lhs;

        if (grammar -> RhsSize(rule_no) == 1)
        {
            if (lhs != grammar -> accept_image)
            {
                int symbol = grammar -> rhs_sym[grammar -> FirstRhsIndex(rule_no)];
                if (grammar -> IsNonTerminal(symbol))
                {
                    if (! extension_set[symbol][lhs])
                    {
                        int source_index = grammar -> rules[rule_no].source_index,
                            array_index = grammar -> parser.rules[source_index].array_element_type_index;

                        //
                        // If the left-hand side is not an array(list) then it
                        // may extend the right-hand side
                        //
                        if (array_index == 0)
                        {
                            extension_set[symbol].AddElement(lhs);
                            extension_of[symbol].Next() = lhs;
                        }
                    }
                }
                else
                {
                    if (! extension_set[lhs][grammar -> Get_ast_token_interface()])
                    {
                        int source_index = grammar -> rules[rule_no].source_index,
                            array_index = grammar -> parser.rules[source_index].array_element_type_index;

                        //
                        // If the left-hand side is not an array(list) then it
                        // may extend the right-hand side
                        //
                        if (array_index == 0)
                        {
                            extension_set[lhs].AddElement(grammar -> Get_ast_token_interface());
                            extension_of[lhs].Next() = grammar -> Get_ast_token_interface();
                        }
                    }
                }
            }
        }
    }

    LCA lca(extension_of);

    CompleteClassnameInfo(lca, ttc, global_map, typestring, processed_rule_map, classname_set, classname, rule_allocation_map);

    //
    // Compute a map from each interface into the (transitive closure)
    // of the set of classes that can implement in.
    // (CTC: class transitive closure)
    //
    CTC ctc(classname, typestring, extension_of);
    BoundedArray< Tuple<int> > &interface_map = ctc.GetInterfaceMap();

    //
    // (NTC: Nonterminals that can generate null ASTs.
    //
    NTC ntc(global_map, grammar);

    //
    // First process the root class, the list class, and the Token class.
    //
    {
        const char *list = "List";
        char *ast_list_classname = new char[strlen(option -> ast_type) + strlen(list) + 1];
        strcpy(ast_list_classname, option -> ast_type);
        strcat(ast_list_classname, list);

        if (option -> automatic_ast == Option::NESTED)
        {
            GenerateAstType(ast_buffer, "    ", option -> ast_type);
            GenerateAbstractAstListType(ast_buffer, "    ", ast_list_classname);
            GenerateAstTokenType(ntc, ast_buffer, "    ", grammar -> Get_ast_token_classname());
        }
        else
        {
            assert(option -> automatic_ast == Option::TOPLEVEL);

            ActionFileSymbol *file_symbol = GenerateTitleAndGlobals(ast_filename_table,
                                                                    notice_actions,
                                                                    option -> ast_type,
                                                                    (grammar -> parser.ast_block != 0));
            GenerateAstType(*file_symbol -> BodyBuffer(), "", option -> ast_type);
            file_symbol -> Flush();

            file_symbol = GenerateTitleAndGlobals(ast_filename_table, notice_actions, ast_list_classname, false);
            GenerateAbstractAstListType(*file_symbol -> BodyBuffer(), "", ast_list_classname);
            file_symbol -> Flush();

            file_symbol = GenerateTitleAndGlobals(ast_filename_table, notice_actions, grammar -> Get_ast_token_classname(), false);
            GenerateAstTokenType(ntc, *file_symbol -> BodyBuffer(), "", grammar -> Get_ast_token_classname());
            file_symbol -> Flush();
        }

        delete [] ast_list_classname;
    }

    //
    // Generate the token interface
    //
    {
        char *ast_token_interfacename = new char[strlen(grammar -> Get_ast_token_classname()) + 2];
        strcpy(ast_token_interfacename, "I");
        strcat(ast_token_interfacename, grammar -> Get_ast_token_classname());
    
        if (option -> automatic_ast == Option::NESTED)
            GenerateInterface(true /* is token */,
                              ast_buffer,
                              (char *) "    ",
                              ast_token_interfacename,
                              extension_of[grammar -> Get_ast_token_interface()],
                              interface_map[grammar -> Get_ast_token_interface()],
                              classname);
        else 
        {
            ActionFileSymbol *file_symbol = GenerateTitleAndGlobals(ast_filename_table, notice_actions, ast_token_interfacename, false);
            GenerateInterface(true /* is token */,
                              *(file_symbol -> BodyBuffer()),
                              (char *) "",
                              ast_token_interfacename,
                              extension_of[grammar -> Get_ast_token_interface()],
                              interface_map[grammar -> Get_ast_token_interface()],
                              classname);
            file_symbol -> Flush();
        }

        delete [] ast_token_interfacename;
    }

    //
    // Generate the nonterminal interfaces.
    //
    for (int symbol = grammar -> num_terminals + 1; symbol <= grammar -> num_symbols; symbol++)
    {
        if (symbol != grammar -> accept_image)
        {
            char *interface_name = new char[strlen(grammar -> RetrieveString(symbol)) + 2];
            strcpy(interface_name, "I");
            strcat(interface_name, grammar -> RetrieveString(symbol));
    
            if (option -> automatic_ast == Option::NESTED)
                GenerateInterface(ctc.IsTerminalClass(symbol),
                                  ast_buffer,
                                  (char *) "    ",
                                  interface_name,
                                  extension_of[symbol],
                                  interface_map[symbol],
                                  classname);
            else 
            {
                ActionFileSymbol *file_symbol = extension_of[symbol].Length() > 0
                                                    ? GenerateTitle(ast_filename_table, notice_actions, interface_name, false)
                                                    : GenerateTitleAndGlobals(ast_filename_table, notice_actions, interface_name, false);
                GenerateInterface(ctc.IsTerminalClass(symbol),
                                  *(file_symbol -> BodyBuffer()),
                                  (char *) "",
                                  interface_name,
                                  extension_of[symbol],
                                  interface_map[symbol],
                                  classname);
                file_symbol -> Flush();
            }

            delete [] interface_name;
        }
    }

    //
    // Generate the rule classes.
    //
    for (int i = 0; i < classname.Length(); i++)
    {
        //
        // No class is generated for rules that are asoociated with the null classname.
        //
        if (IsNullClassname(classname[i]))
            continue;

        //
        // Figure out whether or not, classname[i] needs the environment
        // and process it if it is a List class.
        //
        Tuple<int> &rule = classname[i].rule;
        if (classname[i].array_element_type_symbol != NULL)
        {
            for (int k = 0; k < rule.Length(); k++)
            {
                int rule_no = rule[k];
                classname[i].rhs_type_index.Reset(); // expected by ProcessAstRule
                classname[i].symbol_set.Reset();     // expected by ProcessAstRule

                ProcessAstRule(classname[i], rule_no, processed_rule_map[rule_no]);

                Tuple<ActionBlockElement> &actions = rule_action_map[rule_no];
                classname[i].needs_environment = classname[i].needs_environment || (actions.Length() > 0);
            }
        }
        else
        {
            if (rule.Length() == 1)
            {
                int rule_no = rule[0];
                Tuple<ActionBlockElement> &actions = rule_action_map[rule_no];
                classname[i].needs_environment = (actions.Length() > 0);
            }
            else
            {
                assert(classname[i].specified_name != classname[i].real_name); // a classname was specified?
                for (int k = 0; k < rule.Length(); k++)
                {
                    int rule_no = rule[k];
                    rule_allocation_map[rule_no].name = classname[i].real_name;
                    Tuple<ActionBlockElement> &actions = rule_action_map[rule_no];
                    classname[i].needs_environment = classname[i].needs_environment || (actions.Length() > 0);
                }
            }
        }

        //
        // If the classes are to be generated as top-level classes, we first obtain
        // a file for this class.
        //
        ActionFileSymbol *file_symbol = (option -> automatic_ast == Option::NESTED
                                                                  ? NULL
                                                                  : GenerateTitleAndGlobals(ast_filename_table,
                                                                                            notice_actions,
                                                                                            classname[i].real_name,
                                                                                            classname[i].needs_environment));
        //
        //
        //
        if (classname[i].array_element_type_symbol != NULL)
        {
            //
            // Generate final info for the allocation of rules associated with this class
            //
            for (int k = 0; k < rule.Length(); k++)
            {
                int rule_no = rule[k];
                Tuple<ActionBlockElement> &actions = rule_action_map[rule_no];
                if (file_symbol != NULL) // option -> automatic_ast == Option::TOPLEVEL
                {
                    for (int j = 0; j < actions.Length(); j++)
                        actions[j].buffer = file_symbol -> BodyBuffer();
                }
            }

            //
            // Generate the class
            //
            GenerateListClass(ctc,
                              ntc, 
                              (option -> automatic_ast == Option::NESTED
                                                        ? ast_buffer
                                                        : *(file_symbol -> BodyBuffer())),
                              (option -> automatic_ast == Option::NESTED
                                                        ? (char *) "    "
                                                        : (char *) ""),
                              classname[i],
                              typestring);

            {
                for (int k = 0; k < rule.Length(); k++)
                {
                    int rule_no = rule[k];
                    rule_allocation_map[rule_no].needs_environment = classname[i].needs_environment;
                    Tuple<ActionBlockElement> &actions = rule_action_map[rule_no];
                    ProcessCodeActions(actions, typestring, processed_rule_map);
                }
            }
        }
        else
        {
            if (rule.Length() == 1)
            {
                int rule_no = rule[0];
                Tuple<ActionBlockElement> &actions = rule_action_map[rule_no];
                rule_allocation_map[rule_no].needs_environment = classname[i].needs_environment;
                GenerateRuleClass(ctc,
                                  ntc,
                                  (option -> automatic_ast == Option::NESTED
                                                            ? ast_buffer
                                                            : *(file_symbol -> BodyBuffer())),
                                  (option -> automatic_ast == Option::NESTED
                                                            ? (char *) "    "
                                                            : (char *) ""),
                                  classname[i],
                                  typestring);
                if (file_symbol != NULL) // option -> automatic_ast == Option::TOPLEVEL
                {
                    for (int j = 0; j < actions.Length(); j++)
                        actions[j].buffer = file_symbol -> BodyBuffer();
                }
                ProcessCodeActions(actions, typestring, processed_rule_map);
            }
            else
            {
                assert(classname[i].specified_name != classname[i].real_name); // a classname was specified?
                if (file_symbol != NULL) // option -> automatic_ast == Option::TOPLEVEL
                {
                    for (int k = 0; k < rule.Length(); k++)
                    {
                        int rule_no = rule[k];
                        Tuple<ActionBlockElement> &actions = rule_action_map[rule_no];
                        for (int j = 0; j < actions.Length(); j++)
                            actions[j].buffer = file_symbol -> BodyBuffer();
                    }
                }

                if (classname[i].is_terminal_class)
                     GenerateTerminalMergedClass(ntc,
                                                 (option -> automatic_ast == Option::NESTED
                                                                           ? ast_buffer
                                                                           : *(file_symbol -> BodyBuffer())),
                                                 (option -> automatic_ast == Option::NESTED
                                                                           ? (char *) "    "
                                                                           : (char *) ""),
                                                 classname[i],
                                                 typestring);
                else GenerateMergedClass(ctc,
                                         ntc,
                                         (option -> automatic_ast == Option::NESTED
                                                                   ? ast_buffer
                                                                   : *(file_symbol -> BodyBuffer())),
                                         (option -> automatic_ast == Option::NESTED
                                                                   ? (char *) "    "
                                                                   : (char *) ""),
                                         classname[i],
                                         processed_rule_map,
                                         typestring);

                for (int k = 0; k < rule.Length(); k++)
                {
                    int rule_no = rule[k];
                    rule_allocation_map[rule_no].needs_environment = classname[i].needs_environment;
                    Tuple<ActionBlockElement> &actions = rule_action_map[rule_no];
                    ProcessCodeActions(actions, typestring, processed_rule_map);
                }
            }
        }

        if (option -> automatic_ast == Option::NESTED) // Generate Class Closer
             ast_buffer.Put("    }\n\n");
        else
        {
            file_symbol -> BodyBuffer() -> Put("}\n\n");
            file_symbol -> Flush();
        }
    }

    //
    //
    //
    SymbolLookupTable type_set;
    type_set.FindOrInsertName(grammar -> Get_ast_token_classname(), strlen(grammar -> Get_ast_token_classname()));
    {
        for (int i = 0; i < classname.Length(); i++)
        {
            //
            // No class is generated for rules that are asoociated with the null classname.
            //
            if (! IsNullClassname(classname[i]))
                type_set.FindOrInsertName(classname[i].real_name, strlen(classname[i].real_name));
        }
    }

    //
    // Generate the visitor interfaces and Abstract classes that implements
    // the visitors.
    //
    {
        const char *visitor_type = option -> visitor_type,
                   *argument = "Argument",
                   *result = "Result",
                   *abstract = "Abstract";
        char *argument_visitor_type = new char[strlen(argument) + strlen(visitor_type) + 1],
             *result_visitor_type = new char[strlen(result) + strlen(visitor_type) + 1],
             *result_argument_visitor_type = new char[strlen(result) + strlen(argument) + strlen(visitor_type) + 1],
             *abstract_visitor_type = new char[strlen(abstract) + strlen(visitor_type) + 1],
             *abstract_result_visitor_type = new char[strlen(abstract) + strlen(result) + strlen(visitor_type) + 1];

        strcpy(argument_visitor_type, argument);
        strcat(argument_visitor_type, visitor_type);

        strcpy(result_visitor_type, result);
        strcat(result_visitor_type, visitor_type);

        strcpy(result_argument_visitor_type, result);
        strcat(result_argument_visitor_type, argument);
        strcat(result_argument_visitor_type, visitor_type);

        strcpy(abstract_visitor_type, abstract);
        strcat(abstract_visitor_type, visitor_type);

        strcpy(abstract_result_visitor_type, abstract);
        strcat(abstract_result_visitor_type, result);
        strcat(abstract_result_visitor_type, visitor_type);

        if (option -> visitor == Option::DEFAULT)
        {
            if (option -> automatic_ast == Option::NESTED)
            {
                GenerateSimpleVisitorInterface(ast_buffer, "    ", visitor_type, type_set);
                GenerateArgumentVisitorInterface(ast_buffer, "    ", argument_visitor_type, type_set);
                GenerateResultVisitorInterface(ast_buffer, "    ", result_visitor_type, type_set);
                GenerateResultArgumentVisitorInterface(ast_buffer, "    ", result_argument_visitor_type, type_set);

                GenerateNoResultVisitorAbstractClass(ast_buffer, "    ", abstract_visitor_type, type_set);
                GenerateResultVisitorAbstractClass(ast_buffer, "    ", abstract_result_visitor_type, type_set);
            }
            else
            {
                ActionFileSymbol *file_symbol = GenerateTitle(ast_filename_table, notice_actions, visitor_type, false);
                GenerateSimpleVisitorInterface(*file_symbol -> BodyBuffer(), "", visitor_type, type_set);
                file_symbol -> Flush();

                file_symbol = GenerateTitle(ast_filename_table, notice_actions, argument_visitor_type, false);
                GenerateArgumentVisitorInterface(*file_symbol -> BodyBuffer(), "", argument_visitor_type, type_set);
                file_symbol -> Flush();

                file_symbol = GenerateTitle(ast_filename_table, notice_actions, result_visitor_type, false);
                GenerateResultVisitorInterface(*file_symbol -> BodyBuffer(), "", result_visitor_type, type_set);
                file_symbol -> Flush();

                file_symbol = GenerateTitle(ast_filename_table, notice_actions, result_argument_visitor_type, false);
                GenerateResultArgumentVisitorInterface(*file_symbol -> BodyBuffer(), "", result_argument_visitor_type, type_set);
                file_symbol -> Flush();

                file_symbol = GenerateTitle(ast_filename_table, notice_actions, abstract_visitor_type, false);
                GenerateNoResultVisitorAbstractClass(*file_symbol -> BodyBuffer(), "", abstract_visitor_type, type_set);
                file_symbol -> Flush();

                file_symbol = GenerateTitle(ast_filename_table, notice_actions, abstract_result_visitor_type, false);
                GenerateResultVisitorAbstractClass(*file_symbol -> BodyBuffer(), "", abstract_result_visitor_type, type_set);
                file_symbol -> Flush();
            }
        }
        else if (option -> visitor == Option::PREORDER)
        {
            if (option -> automatic_ast == Option::NESTED)
            {
                GeneratePreorderVisitorInterface(ast_buffer, "    ", visitor_type, type_set);
                GeneratePreorderVisitorAbstractClass(ast_buffer, "    ", abstract_visitor_type, type_set);
            }
            else
            {
                ActionFileSymbol *file_symbol = GenerateTitle(ast_filename_table, notice_actions, visitor_type, false);
                GeneratePreorderVisitorInterface(*file_symbol -> BodyBuffer(), "", visitor_type, type_set);
                file_symbol -> Flush();

                file_symbol = GenerateTitle(ast_filename_table, notice_actions, abstract_visitor_type, false);
                GeneratePreorderVisitorAbstractClass(*file_symbol -> BodyBuffer(), "", abstract_visitor_type, type_set);
                file_symbol -> Flush();
            }
        }

        delete [] argument_visitor_type;
        delete [] result_visitor_type;
        delete [] result_argument_visitor_type;
        delete [] abstract_visitor_type;
        delete [] abstract_result_visitor_type;
    }

    ProcessCodeActions(initial_actions, typestring, processed_rule_map);

    int count = 0;
    {
        for (int rule_no = 1; rule_no < rule_allocation_map.Size(); rule_no++)
        {
            if ((rule_allocation_map[rule_no].name != NULL || grammar -> RhsSize(rule_no) == 0) &&
                (rule_allocation_map[rule_no].list_kind != RuleAllocationElement::COPY_LIST || rule_allocation_map[rule_no].list_position != 1))
            {
                count++;

                //
                // Check whether or not the rule is a single production
                // and if so, issue an error and stop.
                //
                if (grammar -> IsUnitProduction(rule_no))
                {
                    int source_index = grammar -> rules[rule_no].source_index;
                    option -> EmitError(grammar -> parser.rules[source_index].separator_index,
                                        "Unable to generate Ast allocation for single production");
                }

                if (count % option -> max_cases == 0)
                {
                    ProcessMacro(&ast_buffer, "SplitActions", rule_no);
                    count++;
                }

                ProcessMacro(&ast_buffer, "BeginAction", rule_no);

                if (rule_allocation_map[rule_no].list_kind != RuleAllocationElement::NOT_A_LIST)
                {
                    GenerateListAllocation(ctc,
                                           ast_buffer,
                                           rule_no,
                                           rule_allocation_map[rule_no]);
                }
                else
                {
                     if (grammar -> RhsSize(rule_no) == 0 && rule_allocation_map[rule_no].name == NULL)
                          GenerateNullAstAllocation(ast_buffer, rule_no);
                     else GenerateAstAllocation(ctc,
                                                ast_buffer,
                                                rule_allocation_map[rule_no],
                                                processed_rule_map[rule_no],
                                                typestring,
                                                rule_no);
                }

                GenerateCode(&ast_buffer, "\n          ", rule_no);
                ProcessMacro(&ast_buffer, "EndAction", rule_no);
            }
            else
            {
                //
                // Make sure that no action block is associated with a rule for
                // which no class is allocated when it is reduced.
                //
                for (int k = 0; k < rule_action_map[rule_no].Length(); k++)
                {
                    ActionBlockElement &action = rule_action_map[rule_no][k];
                    option -> EmitError(action.block_token,
                                        "Since no class is associated with this production, this code is unreachable");
                }

                ProcessMacro(&ast_buffer, "NoAction", rule_no);
            }
        }
    }

    return;
}


void Action::CheckRecursivenessAndUpdate(Tuple<int> &nonterminal_list,
                                         BoundedArray< Tuple<int> > &nonterminal_map,
                                         Array<RuleAllocationElement> &rule_allocation_map)
{
    enum { NONE, LEFT_RECURSIVE, RIGHT_RECURSIVE, AMBIGUOUS };
    for (int k = 0; k < nonterminal_list.Length(); k++)
    {
        int lhs = nonterminal_list[k];
        Tuple<int> &rule = nonterminal_map[lhs];
        int recursive = NONE;

        for (int i = 0; i < rule.Length(); i++)
        {
            int rule_no = rule[i];
            if (rule_allocation_map[rule_no].list_kind == RuleAllocationElement::ADD_ELEMENT)
            {
                if (rule_allocation_map[rule_no].list_position < rule_allocation_map[rule_no].element_position)
                {
                    if (recursive == NONE)
                         recursive = LEFT_RECURSIVE;
                    else if (recursive != LEFT_RECURSIVE)
                         recursive = AMBIGUOUS;
                }
                else
                {
                    if (recursive == NONE)
                         recursive = RIGHT_RECURSIVE;
                    else if (recursive != RIGHT_RECURSIVE)
                         recursive = AMBIGUOUS;
                }
            }
        }
    
        if (recursive == AMBIGUOUS)
        {
            int source_index = grammar -> rules[rule[0]].source_index;
            option -> EmitError(grammar -> parser.rules[source_index].lhs_index,
                                "This nonterminal is associated with both left-recursive and right-recursive rule(s)");
                                    
        }
        else if (recursive != NONE)
        {
            for (int i = 0; i < rule.Length(); i++)
            {
                int rule_no = rule[i];
                if (rule_allocation_map[rule_no].list_kind == RuleAllocationElement::EMPTY)
                    rule_allocation_map[rule_no].list_kind = (recursive == LEFT_RECURSIVE
                                                                  ? RuleAllocationElement::LEFT_RECURSIVE_EMPTY
                                                                  : RuleAllocationElement::RIGHT_RECURSIVE_EMPTY);
                else if (rule_allocation_map[rule_no].list_kind == RuleAllocationElement::SINGLETON)
                    rule_allocation_map[rule_no].list_kind = (recursive == LEFT_RECURSIVE
                                                                  ? RuleAllocationElement::LEFT_RECURSIVE_SINGLETON
                                                                  : RuleAllocationElement::RIGHT_RECURSIVE_SINGLETON);
            }
        }
        else
        {
            assert(recursive == NONE);

            //
            // Nonrecursive rules are tagged as left-recursive.
            //
            for (int i = 0; i < rule.Length(); i++)
            {
                int rule_no = rule[i];
                if (rule_allocation_map[rule_no].list_kind == RuleAllocationElement::EMPTY)
                     rule_allocation_map[rule_no].list_kind = RuleAllocationElement::LEFT_RECURSIVE_EMPTY;
                else if (rule_allocation_map[rule_no].list_kind == RuleAllocationElement::SINGLETON)
                     rule_allocation_map[rule_no].list_kind = RuleAllocationElement::LEFT_RECURSIVE_SINGLETON;
            }
        }
    }

    return;
}


//
//
//
const char *Action::SkipMargin(TextBuffer *buffer, const char *cursor, const char *tail)
{
    int length = option -> margin;

    for (int i = 0; length > 0 && cursor < tail; i++, cursor++)
    {
        if (*cursor == Code::HORIZONTAL_TAB)
             length -= (Tab::TabSize() - (i % Tab::TabSize()));
        else if (Code::IsSpaceButNotNewline(*cursor))
             length--;
        else break;
    }

    //
    // If length has a negative value, the absolute value of length
    // indicates that the number of blank characters that should be
    // written to the output file. Note that this situation occurs
    // iff a tab character is used as the last character in a margin
    // space and, when fully expanded, it overlaps the data space.
    //
    if (length < 0)
    {
        for (int j = length; j > 0; j++)
             buffer -> Put(' ');
    }

    return cursor;
}


//
//
//
void Action::ProcessActionBlock(ActionBlockElement &action)
{
    BlockSymbol *block = lex_stream -> GetBlockSymbol(action.block_token);
    TextBuffer *buffer = action.buffer;
    int rule_number = action.rule_number,
        line_no = lex_stream -> Line(action.block_token),
        start = lex_stream -> StartLocation(action.block_token) + block -> BlockBeginLength(),
        end   = lex_stream -> EndLocation(action.block_token) - block -> BlockEndLength() + 1;
    const char *head = &(lex_stream -> InputBuffer(action.block_token)[start]),
               *tail = &(lex_stream -> InputBuffer(action.block_token)[end]);

    //
    // If the block opener marker is immediately followed by a newline
    // character, skip the new line.
    // When we encounter the sequence \r\n we only consider \n as end-of-line.
    //
    // if (Code::IsNewline(*head))
    // {
    //     head++;
    //     line_no++;
    // }
    //
    //
    // If the block closer marker is immediately preceded by a newline
    // character, skip the new line.
    //
    // if (Code::IsNewline(*(tail - 1)))
    //     tail--;

    //
    //
    //
    while (head < tail)
    {
        const char *cursor;

        //
        // When we encounter the sequence \r\n we only consider \n as end-of-line.
        //
        // for (cursor = head; Code::IsNewline(*cursor); cursor++)
        //
        for (cursor = head; *cursor == '\n'; cursor++)
        {
            buffer -> PutChar(*cursor);
            line_no++;
        }

        cursor = SkipMargin(buffer, cursor, tail);

        //
        // When we encounter the sequence \r\n we only consider \n as end-of-line.
        //
        // for (head = cursor; cursor < tail && (! Code::IsNewline(*cursor)); cursor++)
        //
        for (head = cursor; (cursor < tail) && (*cursor != '\n'); cursor++)
            ;
        if (cursor > head)
            ProcessActionLine(action.location,
                              buffer,
                              lex_stream -> FileName(action.block_token),
                              head,
                              cursor,
                              line_no,
                              rule_number);
        head = cursor;
    }

    //
    // If the macro spanned only a single line, add a
    // line break to the output.
    //
    if (lex_stream -> Line(action.block_token) == lex_stream -> EndLine(action.block_token))
        buffer -> Put("\n");

    return;
}


//
// Process an action line consisting only of the macro whose name is
// specified by the parameter name. Note that it is assumed that:
//
//  1. The name does not contain the escape prefix which is added here.
//  2. The location of the output is ActionBlockElement::BODY
//  3. The file name associated with this output is the filename of the
//     default block.
//  4. The line number associated with this output is 0.
//
void Action::ProcessMacro(TextBuffer *buffer, const char *name, int rule_no)
{
    int length = strlen(name) + 1;
    char *macroname = new char[length + 1];
    macroname[0] = option -> escape;
    strcpy(&macroname[1], name);

    const char *filename = lex_stream -> FileName(grammar -> rules[rule_no].first_token_index);
    int line_offset = lex_stream -> Line(grammar -> rules[rule_no].first_token_index) - 1;

    ProcessActionLine(ActionBlockElement::BODY,
                      buffer,
                      filename,
                      macroname,
                      &macroname[length],
                      line_offset,
                      rule_no);

    delete [] macroname;

    return;
}


//
// PROCESS_ACTION_LINE takes as arguments a line of text from an action
// block and the rule number with which the block is associated.
// It first scans the text for local macro names and then for
// user defined macro names. If one is found, the macro definition is sub-
// stituted for the name. The modified action text is then printed out in
// the action file.
//
void Action::ProcessActionLine(int location, TextBuffer *buffer, const char *filename, const char *cursor, const char *tail, int line_no, int rule_no)
{
    assert(buffer);

    const char *start = cursor;
    while(cursor < tail)
    {
        //
        // If not the escape character, just print it !!!
        //
        if (*cursor != option -> escape)
        {
            buffer -> PutChar(*cursor);

            //
            // If the character just output is a new line marker then
            // skip the margin if one is specified.
            //
            if (Code::IsNewline(*cursor++))
            {
                cursor = SkipMargin(buffer, cursor, tail);
                start = cursor;
            }
        }
        else // all macro names begin with ESCAPE
        {
            //
            // Find macro name.
            //
            const char *end_cursor;
            for (end_cursor = cursor + 1;
                 end_cursor < tail && (Code::IsAlnum(*end_cursor) && *end_cursor != option -> escape);
                 end_cursor++)
                ;

            //
            // First, see if the macro is a local macro.
            // Next, check to see if it is an export_symbol macro
            // Finally, check to see if it is a user-defined macro
            //
            SimpleMacroSymbol *simple_macro;
            MacroSymbol *macro;
            if ((simple_macro = FindLocalMacro(cursor, end_cursor - cursor)) != NULL)
            {
                char *value = simple_macro -> Value();
                if (value)
                {
                    if (simple_macro == symbol_declarations_macro)
                    {
                        char *p = value;
                        while(*p)
                        {
                            char *q;
                            for (q = p + 1; *q && *q != '\n'; q++)
                                ;

                            ProcessActionLine(location,
                                              buffer,
                                              filename,
                                              p,
                                              q,
                                              line_no,
                                              rule_no);

                            p = q;
                            if (*p != '\0') // if more info to process, add offset
                            {
                                assert(*p == '\n');
                                buffer -> PutChar(*p++);
                                for (int i = 0; i < cursor - start; i++)
                                    buffer -> PutChar(' ');
                            }
                        }
                    }
                    else buffer -> Put(value);
                }
                else if (simple_macro == rule_number_macro)
                    buffer -> Put(rule_no);
                else if (simple_macro == rule_text_macro)
                {
                    if (rule_no == 0)
                        buffer -> Put("*** No Rule ***");
                    else
                    {
                        int index = rule_no - 1; // original rule index starts at 0
                        buffer -> Put(lex_stream -> NameString(grammar -> parser.rules[index].lhs_index));
                        buffer -> PutChar(' ');
                        buffer -> Put(grammar -> IsUnitProduction(rule_no) ? "->" : "::=");

                        for (int j = lex_stream -> Next(grammar -> parser.rules[index].separator_index);
                             j < grammar -> parser.rules[index].end_rhs_index;
                             j = lex_stream -> Next(j))
                        {
                            if (lex_stream -> Kind(j) == TK_SYMBOL)
                            {
                                buffer -> PutChar(' ');
                                buffer -> Put(lex_stream -> NameString(j));
                            }
                            else if (lex_stream -> Kind(j) == TK_MACRO_NAME)
                                buffer -> Put(lex_stream -> NameString(j));
                            else if (lex_stream -> Kind(j) == TK_EMPTY_KEY)
                            {
                                buffer -> PutChar(' ');
                                buffer -> PutChar(option -> escape);
                                buffer -> Put("Empty");
                            }
                        }
                    }
                }
                else if (simple_macro == rule_size_macro)
                     buffer -> Put(grammar -> RhsSize(rule_no));
                else if (simple_macro == input_file_macro)
                     buffer -> Put(filename);
                else if (simple_macro == current_line_macro)
                     buffer -> Put(line_no);
                else if (simple_macro == next_line_macro)
                     buffer -> Put(line_no + 1);
                else if (simple_macro == identifier_macro)
                {
                    buffer -> Put("IDENTIFIER");

                    InputFileSymbol *file_symbol = lex_stream -> FindOrInsertFile(filename);
                    int error_location = cursor - file_symbol -> Buffer();
                    Token *error_token = lex_stream -> GetErrorToken(file_symbol, error_location);
                    error_token -> SetEndLocation(error_location + end_cursor - cursor - 1);
                    error_token -> SetKind(0);

                    option -> EmitWarning(error_token, "No explicit user definition for $identfier - IDENTIFIER is assumed");
                }
                else assert(false);

                cursor = end_cursor + (*end_cursor == option -> escape ? 1 : 0);
            }
            else if ((simple_macro = FindRuleMacro(cursor, end_cursor - cursor)) != NULL)
            {
                char *value = simple_macro -> Value();
                assert(value);
                buffer -> Put(value);

                cursor = end_cursor + (*end_cursor == option -> escape ? 1 : 0);
            }
            else if ((simple_macro = FindFilterMacro(cursor, end_cursor - cursor)) != NULL)
            {
                char *value = simple_macro -> Value();
                assert(value);
                buffer -> Put(value);

                cursor = end_cursor + (*end_cursor == option -> escape ? 1 : 0);
            }
            else if ((simple_macro = FindExportMacro(cursor, end_cursor - cursor)) != NULL)
            {
                buffer -> Put(option -> exp_prefix);
                buffer -> Put(simple_macro -> Name() + 2); // skip initial escape and '_' characters
                buffer -> Put(option -> exp_suffix);
                cursor = end_cursor + (*end_cursor == option -> escape ? 1 : 0);
            }
            else if ((macro = FindUserDefinedMacro(cursor, end_cursor - cursor)) != NULL)
            {
                int block_token = macro -> Block();

                if (macro -> IsInUse())
                {
                    Tuple <const char *> msg;
                    msg.Next() = "Loop detected during the expansion of the macro \"";
                    msg.Next() = macro -> Name();
                    msg.Next() = "\"";
                    option -> EmitError(block_token, msg);

                    control -> Exit(12);
                }

                BlockSymbol *block = lex_stream -> GetBlockSymbol(block_token);
                if (block)
                {
                    int start = lex_stream -> StartLocation(block_token) + block -> BlockBeginLength(),
                        end   = lex_stream -> EndLocation(block_token) - block -> BlockEndLength() + 1;
                    macro -> MarkInUse();

                    //
                    // If the block containing the macro is a "default" block, then its body should
                    // be output in the current file. Otherwise, output it in the file with which
                    // it is associated.
                    //
                    ProcessActionLine(location,
                                      (block == option -> DefaultBlock()
                                             ? buffer
                                             : block -> Buffer()
                                                      ? block -> Buffer()
                                                      : location == ActionBlockElement::INITIALIZE
                                                                 ? block -> ActionfileSymbol() -> InitialHeadersBuffer()
                                                                 : location == ActionBlockElement::BODY
                                                                            ? block -> ActionfileSymbol() -> BodyBuffer()
                                                                            : block -> ActionfileSymbol() -> FinalTrailersBuffer()),
                                      filename,
                                      &(lex_stream -> InputBuffer(block_token)[start]),
                                      &(lex_stream -> InputBuffer(block_token)[end]),
                                      line_no,
                                      rule_no);
                    macro -> MarkNotInUse();

                    cursor = end_cursor + (*end_cursor == option -> escape ? 1 : 0);
                }
                else
                {
                    Tuple <const char *> msg;
                    IntToString line(line_no);
                    msg.Next() = "The macro \"";
                    msg.Next() = macro -> Name();
                    msg.Next() = "\" used in file ";
                    msg.Next() = filename;
                    msg.Next() = " at line ";
                    msg.Next() = line.String();
                    msg.Next() = " is undefined. No substitution made";

                    option -> EmitWarning(block_token, msg);

                    buffer -> PutChar(*cursor);
                    cursor++;
                }
            }
            else
            {
                int length = end_cursor - cursor;
                char *macro_name = new char[length + 1];
                memmove(macro_name, cursor, length * sizeof(char));
                macro_name[length] = '\0';
                InputFileSymbol *file_symbol = lex_stream -> FindOrInsertFile(filename);
                int error_location = cursor - file_symbol -> Buffer();
                Token *error_token = lex_stream -> GetErrorToken(file_symbol, error_location);
                error_token -> SetEndLocation(error_location + length - 1);
                error_token -> SetKind(0);

                Tuple <const char *> msg;
                msg.Next() = "The macro \"";
                msg.Next() = macro_name;
                msg.Next() = "\" is undefined. No substitution made";

                option -> EmitWarning(error_token, msg);

                delete [] macro_name;

                buffer -> PutChar(*cursor); // process the escape symbol
                cursor++;
            }
        }
    }

    return;
}


void Action::GenerateCode(TextBuffer *ast_buffer, const char *code, int rule_no)
{
    ProcessActionLine(ActionBlockElement::BODY,
                      ast_buffer,
                      option -> DefaultBlock() -> ActionfileSymbol() -> Name(),
                      code,
                      &code[strlen(code)],
                      0,
                      rule_no);
}
