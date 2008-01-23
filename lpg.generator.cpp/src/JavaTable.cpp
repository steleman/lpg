#include "partition.h"
#include "JavaTable.h"

#include <iostream>
using namespace std;

//
//
//
void JavaTable::PrintHeader(const char *type, const char *name, const char *initial_elements)
{
    prs_buffer.Put("\n    public interface ");
    prs_buffer.Put(Code::ToUpper(*name)); // capitalize the first letter
    prs_buffer.Put(name + 1);
    prs_buffer.Put(" {\n"
                   "        public final static ");
    prs_buffer.Put(type);
    prs_buffer.Put(' ');
    prs_buffer.Put(name);
    prs_buffer.Put("[] = {");
    prs_buffer.Put(initial_elements);
    prs_buffer.Put('\n');

    return;
}


//
//
//
void JavaTable::PrintTrailer()
{
    prs_buffer.Put("        };\n"
                   "    };\n");
    return;
}

//
//
//
void JavaTable::PrintTrailerAndVariable(const char *type, const char *name)
{
    PrintTrailer();
    prs_buffer.Put("    public final static ");
    prs_buffer.Put(type);
    prs_buffer.Put(' ');
    prs_buffer.Put(name);
    prs_buffer.Put("[] = ");
    prs_buffer.Put(Code::ToUpper(*name));
    prs_buffer.Put(name + 1);
    prs_buffer.Put('.');
    prs_buffer.Put(name);
    prs_buffer.Put(";\n");

    return;
}


//
//
//
void JavaTable::PrintIntsSubrange(int init, int gate, Array<int> &array)
{
    prs_buffer.Pad();
    int k = 0;
    for (int i = init; i < gate; i++)
    {
        prs_buffer.Put(array[i]);
        prs_buffer.Put(',');
        k++;
        if (k == 10 && i != gate - 1)
        {
            prs_buffer.Put('\n');
            prs_buffer.Pad();
            k = 0;
        }
    }
    if (k != 0)
    {
        prs_buffer.UnputChar(); // remove last comma, if possible
        prs_buffer.Put('\n');
    }

    return;
}


//
//
//
void JavaTable::Print(IntArrayInfo &array_info)
{
    const char *type = type_name[array_info.type_id];
    const char *name = array_name[array_info.name_id];
    Array<int> &array = array_info.array;

    //
    // If the first element is 0, write it out on the initial line.
    //
    int init = (array[0] == 0 ? 1 : 0);
    const char *initial_elements = (init == 1 ? "0," : "");

    if (NeedsSegmentation(array))
    {
        int length = strlen(name);
        IntToString suffix(0);
        char *subname = new char[length + 3];
        strcpy(subname, name);
        strcat(subname, suffix.String());

        PrintHeader(type, subname, initial_elements);
        PrintIntsSubrange(init, MAX_ARRAY_SIZE, array);
        PrintTrailer();

        int num_segments = array.Size() / MAX_ARRAY_SIZE + (array.Size() % MAX_ARRAY_SIZE ? 1 : 0);
        for (int i = 1; i < num_segments; i++)
        {
            IntToString suffix(i);
            strcpy(subname, name);
            strcat(subname, suffix.String());

            PrintHeader(type, subname);
            init = MAX_ARRAY_SIZE * i;
            PrintIntsSubrange(init, Util::Min(init + MAX_ARRAY_SIZE, array.Size()), array);
            PrintTrailer();
        }

        prs_buffer.Put("\n    public final static ");
        prs_buffer.Put(type);
        prs_buffer.Put(' ');
        prs_buffer.Put(name);
        prs_buffer.Put("[] = new ");
        prs_buffer.Put(type);
        prs_buffer.Put('[');
        {
            for (int k = 0; k < num_segments; k++)
            {
                IntToString suffix(k);
                prs_buffer.Put(Code::ToUpper(*name));
                prs_buffer.Put(name + 1);
                prs_buffer.Put(suffix.String());
                prs_buffer.Put('.');
                prs_buffer.Put(name);
                prs_buffer.Put(suffix.String());
                prs_buffer.Put(".length");
                if (k < num_segments - 1)
                    prs_buffer.Put(" + ");
            }
        }
        prs_buffer.Put("];");
        prs_buffer.Put("\n    {");
        prs_buffer.Put("\n        int index = 0;");
        for (int k = 0; k < num_segments; k++)
        {
            prs_buffer.Put("\n        System.arraycopy(");
            IntToString suffix(k);
            prs_buffer.Put(Code::ToUpper(*name));
            prs_buffer.Put(name + 1);
            prs_buffer.Put(suffix.String());
            prs_buffer.Put('.');
            prs_buffer.Put(name);
            prs_buffer.Put(suffix.String());
            prs_buffer.Put(", 0, ");
            prs_buffer.Put(name);
            prs_buffer.Put(", index, ");
            prs_buffer.Put(Code::ToUpper(*name));
            prs_buffer.Put(name + 1);
            prs_buffer.Put(suffix.String());
            prs_buffer.Put('.');
            prs_buffer.Put(name);
            prs_buffer.Put(suffix.String());
            prs_buffer.Put(".length);");
            if (k < num_segments - 1)
            {
                prs_buffer.Put("\n        index += ");
                prs_buffer.Put(Code::ToUpper(*name));
                prs_buffer.Put(name + 1);
                prs_buffer.Put(suffix.String());
                prs_buffer.Put('.');
                prs_buffer.Put(name);
                prs_buffer.Put(suffix.String());
                prs_buffer.Put(".length;");
            }
        }
        prs_buffer.Put("\n    };\n");
    }
    else
    {
        PrintHeader(type, name, initial_elements);
        PrintIntsSubrange(init, array.Size(), array);
        PrintTrailerAndVariable(type, name);
    }

    //
    // Generate a function with the same name as the array.
    // The function takes an integer argument and returns
    // the corresponding element in the array.
    //
    prs_buffer.Put("    public final ");
    prs_buffer.Put(array_info.type_id == Table::B ? "boolean " : "int ");
    prs_buffer.Put(name);
    prs_buffer.Put("(int index) { return ");
    prs_buffer.Put(name);
    prs_buffer.Put("[index]");
    if (array_info.type_id == Table::B)
        prs_buffer.Put(" != 0");
    prs_buffer.Put("; }\n");

    return;
}


//
//
//
void JavaTable::PrintNames()
{
    PrintHeader("String", "name");
    char tok[Control::SYMBOL_SIZE + 1];
    for (int i = 0; i < name_info.Size(); i++)
    {
        strcpy(tok, name_info[i]);
        prs_buffer.Pad();
        prs_buffer.Put('\"');
        int k = 0,
            len = NameLength(i);
        for (int j = 0; j < len; j++)
        {
            if (tok[j] == '\"' || tok[j] == '\\')
                prs_buffer.Put('\\');

            if (tok[j] == '\n')
                 prs_buffer.Put(option -> escape);
            else prs_buffer.Put(tok[j]);
            k++;
            if (k == 30 && (! (j == len - 1)))
            {
                k = 0;
                prs_buffer.Put('\"');
                prs_buffer.Put(' ');
                prs_buffer.Put('+');
                prs_buffer.Put('\n');
                prs_buffer.Pad();
                prs_buffer.Put('\"');
            }
        }
        prs_buffer.Put('\"');
        if (i < name_info.Size() - 1)
            prs_buffer.Put(',');
        prs_buffer.Put('\n');
    }
    PrintTrailerAndVariable("String", "name");
    prs_buffer.Put("    public final String name(int index) { return name[index]; }\n\n");

    return;
}


void JavaTable::WriteData(TypeId type_id, Array<int> &array)
{
    if (type_id == B || type_id == I8)
    {
        for (int i = 0; i < array.Size(); i++)
        {
            unsigned char c = array[i] & 0xFF;
            data_buffer.Put(c);
        }
    }
    else if (type_id == I16 || type_id == U16)
    {
        for (int i = 0; i < array.Size(); i++)
        {
            int num = array[i];
            unsigned char c1 = (num >> 8) & 0xFF,
                          c2 = (num & 0xFF);
            data_buffer.Put(c1);
            data_buffer.Put(c2);
        }
    }
    else
    {
        assert(type_id == I32);
        for (int i = 0; i < array.Size(); i++)
        {
            int num = array[i];
            unsigned char c1 = (num >> 24),
                          c2 = (num >> 16) & 0xFF,
                          c3 = (num >> 8) & 0xFF,
                          c4 = (num & 0xFF);
            data_buffer.Put(c1);
            data_buffer.Put(c2);
            data_buffer.Put(c3);
            data_buffer.Put(c4);
        }
    }

    return;
}

//
//
//
void JavaTable::Serialize(IntArrayInfo &array_info)
{
    prs_buffer.Put("    public final static ");
    prs_buffer.Put(type_name[array_info.type_id]);
    prs_buffer.Put(' ');
    prs_buffer.Put(array_name[array_info.name_id]);
    prs_buffer.Put("[] = new ");
    prs_buffer.Put(type_name[array_info.type_id]);
    prs_buffer.Put('[');
    prs_buffer.Put(array_info.array.Size());
    prs_buffer.Put("];\n");

    prs_buffer.Put("    public final ");
    prs_buffer.Put(array_info.type_id == Table::B ? "boolean " : "int ");
    prs_buffer.Put(array_name[array_info.name_id]);
    prs_buffer.Put("(int index) { return ");
    prs_buffer.Put(array_name[array_info.name_id]);
    prs_buffer.Put("[index]");
    if (array_info.type_id == Table::B)
        prs_buffer.Put(" != 0");
    prs_buffer.Put("; }\n");

    WriteData(array_info.type_id, array_info.array);

    return;
}


//
//
//
void JavaTable::SerializeNames()
{
    prs_buffer.Put("    public final static String name[] = new String[");
    prs_buffer.Put(name_info.Size());
    prs_buffer.Put("];\n"
                   "    public final String name(int index) { return name[index]; }\n\n");

    Array<int> name_length(name_info.Size());
    for (int i = 0; i < name_length.Size(); i++)
        name_length[i] = NameLength(i);

    WriteData(Type(0, max_name_length), name_length);

    for (int k = 0; k < name_info.Size(); k++)
    {
        for (char *p = name_info[k]; *p; p++)
            data_buffer.Put(*p);
    }

    return;
}


//
//
//
void JavaTable::non_terminal_action(void)
{
    prs_buffer.Put("    public final int ntAction(int state, int sym) {\n"
                   "        return (baseCheck[state + sym] == sym)\n"
                   "                             ? baseAction[state + sym]\n"
                   "                             : defaultGoto[sym];\n"
                   "    }\n\n");
    return;
}


//
//
//
void JavaTable::non_terminal_no_goto_default_action(void)
{
    prs_buffer.Put("    public final int ntAction(int state, int sym) {\n"
                   "        return baseAction[state + sym];\n"
                   "    }\n\n");

    return;
}


//
//
//
void JavaTable::terminal_action(void)
{
    prs_buffer.Put("    public final int tAction(int state, int sym) {\n"
                   "        int i = baseAction[state],\n"
                   "            k = i + sym;\n"
                   "        return termAction[termCheck[k] == sym ? k : i];\n"
                   "    }\n"
                   "    public final int lookAhead(int la_state, int sym) {\n"
                   "        int k = la_state + sym;\n"
                   "        return termAction[termCheck[k] == sym ? k : la_state];\n"
                   "    }\n");

    return;
}


//
//
//
void JavaTable::terminal_shift_default_action(void)
{
    prs_buffer.Put("    public final int tAction(int state, int sym) {\n"
                   "        if (sym == 0)\n"
                   "            return ERROR_ACTION;\n"
                   "        int i = baseAction[state],\n"
                   "            k = i + sym;\n"
                   "        if (termCheck[k] == sym)\n"
                   "            return termAction[k];\n"
                   "        i = termAction[i];\n"
                   "        return (shiftCheck[shiftState[i] + sym] == sym\n"
                   "                                ? defaultShift[sym]\n"
                   "                                : defaultReduce[i]);\n"
                   "    }\n"
                   "    public final int lookAhead(int la_state, int sym) {\n"
                   "        int k = la_state + sym;\n"
                   "        if (termCheck[k] == sym)\n"
                   "            return termAction[k];\n"
                   "        int i = termAction[la_state];\n"
                   "        return (shiftCheck[shiftState[i] + sym] == sym\n"
                   "                                ? defaultShift[sym]\n"
                   "                                : defaultReduce[i]);\n"
                   "    }\n");
    return;
}


//
//
//
void JavaTable::init_file(FILE **file, const char *file_name)
{
    if ((*file = fopen(file_name, "wb")) == NULL)
    {
        Tuple<const char *> msg;
        msg.Next() = "Output file \"";
        msg.Next() = file_name;
        msg.Next() = "\" could not be opened";

        option -> EmitError(0, msg);
        Table::Exit(12);
    }

    grammar -> NoticeBuffer().Print(*file);

    return;
}


//
//
//
void JavaTable::init_parser_files(void)
{
    init_file(&sysprs, option -> prs_file);
    init_file(&syssym, option -> sym_file);
    if (grammar -> exported_symbols.Length() > 0)
        init_file(&sysexp, option -> exp_file);

    if (option -> serialize)
        init_file(&sysdat, option -> dat_file);

    return;
}


//
//
//
void JavaTable::exit_parser_files(void)
{
    fclose(sysprs);
    fclose(syssym);

    if (grammar -> exported_symbols.Length() > 0)
        fclose(sysexp);

    if (option -> serialize)
        fclose(sysdat);

    return;
}


//
//
//
void JavaTable::print_deserialization_functions(int buffer_size)
{
    prs_buffer.Put("\n"
                   "    private static int offset = 0;\n"
                   "\n"
                   "    static private void read(byte buffer[], int array[]) throws java.io.IOException {\n"
                   "        for (int i = 0; i < array.length; i++)\n"
                   "            array[i] = (int) ((buffer[offset++] << 24) +\n"
                   "                              ((buffer[offset++] & 0xFF) << 16) +\n"
                   "                              ((buffer[offset++] & 0xFF) << 8) +\n"
                   "                               (buffer[offset++] & 0xFF));\n"
                   "    }\n"
                   "\n"
                   "    static private void read(byte buffer[], short array[]) throws java.io.IOException {\n"
                   "        for (int i = 0; i < array.length; i++)\n"
                   "            array[i] = (short) ((buffer[offset++] << 8) + (buffer[offset++] & 0xFF));\n"
                   "    }\n"
                   "\n"
                   "    static private void read(byte buffer[], char array[]) throws java.io.IOException {\n"
                   "        for (int i = 0; i < array.length; i++)\n"
                   "            array[i] = (char) (((buffer[offset++] & 0xFF) << 8) + (buffer[offset++] & 0xFF));\n"
                   "    }\n"
                   "\n"
                   "    static private void read(byte buffer[], byte array[]) throws java.io.IOException {\n"
                   "        System.arraycopy(buffer, offset, array, 0, array.length);\n"
                   "        offset += array.length;\n"
                   "    }\n"
                   "\n"
                   "    static private void read(byte buffer[], String array[]) throws java.io.IOException {\n"
                   "        ");
    const char *string_length_type = type_name[Type(0, max_name_length)];
    prs_buffer.Put(string_length_type);
    prs_buffer.Put(" string_length[] = new ");
    prs_buffer.Put(string_length_type);
    prs_buffer.Put("[array.length];\n"
                   "        read(buffer, string_length);\n"
                   "        for (int i = 0; i < array.length; i++) {\n"
                   "            array[i] = new String(buffer, offset, string_length[i]);\n"
                   "            offset += string_length[i];\n"
                   "        }\n"
                   "    }\n"
                   "\n"
                   "    static {\n"
                   "        try {\n"
                   "            java.io.File file = new java.io.File(\"");
    prs_buffer.PutStringLiteral(option -> dat_file);
    prs_buffer.Put("\");\n"
                   "            java.io.FileInputStream infile = new java.io.FileInputStream(file);\n"
                   "            final byte buffer[] = new byte[");
    prs_buffer.Put(buffer_size);
    prs_buffer.Put("];\n"
                   "\n"
                   "            //\n"
                   "            // Normally, we should be able to read the content of infile with\n"
                   "            // the single statement: infile.read(buffer);\n"
                   "            // However, there appears to be a problem with this statement\n"
                   "            // when it is used in an eclipse plugin - in that case, only 8192\n"
                   "            // bytes are read, regardless of the length of buffer. Therefore, we\n"
                   "            // have to replace the single statement above with the loop below...\n"
                   "            //\n"
                   "            int current_index = 0;\n"
                   "            do {\n"
                   "                int num_read = infile.read(buffer, current_index, buffer.length - current_index);\n"
                   "                current_index += num_read;\n"
                   "            } while (current_index < buffer.length);\n"
                   "\n");

    for (int i = 0; i < data.Length(); i++)
    {
        prs_buffer.Put("            read(buffer, ");
        prs_buffer.Put(array_name[data[i].name_id]);
        prs_buffer.Put(");\n");
    }

    if (option -> error_maps)
        prs_buffer.Put("            read(buffer, name);\n");

    prs_buffer.Put("        }\n"
                   "        catch(java.io.IOException e) {\n"
                   "            System.out.println(\"*** Illegal or corrupted LPG data file\");\n"
                   "            System.exit(12);\n"
                   "        }\n"
                   "        catch(Exception e) {\n"
                   "            System.out.println(\"*** Unable to Initialize LPG tables\");\n"
                   "            System.exit(12);\n"
                   "        }\n"
                   "    }\n"
                   "\n");
}


//
//
//
void JavaTable::print_symbols(void)
{
    Array<char *> symbol_name(grammar -> num_terminals + 1);
    int symbol;
    char sym_line[Control::SYMBOL_SIZE +       /* max length of a token symbol  */
                  2 * MAX_PARM_SIZE + /* max length of prefix + suffix */
                  64];                /* +64 for error messages lines  */
                                  /* or other fillers(blank, =,...)*/

    strcpy(sym_line, "");
    if (strlen(option -> package) > 0)
    {
        strcat(sym_line, "package ");
        strcat(sym_line, option -> package);
        strcat(sym_line, ";\n\n");
    }
    strcat(sym_line, "public interface ");
    strcat(sym_line, option -> sym_type);
    strcat(sym_line, " {\n    public final static int\n");

    //
    // We write the terminal symbols map.
    //
    symbol_name[0] = NULL;
    for (symbol = grammar -> FirstTerminal(); symbol <= grammar -> LastTerminal(); symbol++)
    {
        char *tok = grammar -> RetrieveString(symbol);

        fprintf(syssym, "%s", sym_line);

        if (tok[0] == '\n' || tok[0] == option -> escape)
        {
            tok[0] = option -> escape;

            Tuple<const char *> msg;
            msg.Next() = "Escaped symbol ";
            msg.Next() = tok;
            msg.Next() = " may be an invalid Java variable.";
            option -> EmitWarning(grammar -> RetrieveTokenLocation(symbol), msg);
        }
        else if (strpbrk(tok, "!%^&*()-+={}[];:\"`~|\\,.<>/?\'") != NULL)
        {
            Tuple<const char *> msg;
            msg.Next() = tok;
            msg.Next() = " is an invalid Java variable name.";
            option -> EmitError(grammar -> RetrieveTokenLocation(symbol), msg);
        }

        strcpy(sym_line, "      ");
        strcat(sym_line, option -> prefix);
        strcat(sym_line, tok);
        strcat(sym_line, option -> suffix);
        strcat(sym_line, " = ");
        IntToString num(symbol_map[symbol]);
        strcat(sym_line, num.String());
        strcat(sym_line, (symbol < grammar -> LastTerminal() ? ",\n" : ";\n"));

        symbol_name[symbol_map[symbol]] = tok;
    }

    fprintf(syssym, "%s", sym_line);

    fprintf(syssym, "\n    public final static String orderedTerminalSymbols[] = {\n"
                    "                 \"\",\n");
    for (int i = 1; i < grammar -> num_terminals; i++)
        fprintf(syssym, "                 \"%s\",\n", symbol_name[i]);
    fprintf(syssym, "                 \"%s\"\n             };\n",
            symbol_name[grammar -> num_terminals]);
    fprintf(syssym, "\n    public final static int numTokenKinds = orderedTerminalSymbols.length;");
    fprintf(syssym, "\n    public final static boolean isValidForParser = true;\n}\n");

    return;
}


//
//
//
void JavaTable::print_exports(void)
{
    Array<char *> symbol_name(grammar -> exported_symbols.Length() + 1);
    char exp_line[Control::SYMBOL_SIZE + 64];  /* max length of a token symbol  */
                                               /* +64 for error messages lines  */
                                               /* or other fillers(blank, =,...)*/

    strcpy(exp_line, "");
    if (strlen(option -> package) > 0)
    {
        strcat(exp_line, "package ");
        strcat(exp_line, option -> package);
        strcat(exp_line, ";\n\n");
    }
    strcat(exp_line, "public interface ");
    strcat(exp_line, option -> exp_type);
    strcat(exp_line, " {\n    public final static int\n");

    //
    // We write the exported terminal symbols and map
    // them according to the order in which they were specified.
    //
    symbol_name[0] = NULL;
    for (int i = 1; i <= grammar -> exported_symbols.Length(); i++)
    {
        VariableSymbol *variable_symbol = grammar -> exported_symbols[i - 1];
        char *tok = new char[variable_symbol -> NameLength() + 1];
        strcpy(tok, variable_symbol -> Name());

        fprintf(sysexp, "%s", exp_line);

        if (tok[0] == '\n' || tok[0] == option -> escape)
        {
            tok[0] = option -> escape;

            Tuple<const char *> msg;
            msg.Next() = "Escaped exported symbol ";
            msg.Next() = tok;
            msg.Next() = " may be an invalid Java variable.";
            option -> EmitWarning(variable_symbol -> Location(), msg);
        }
        else if (strpbrk(tok, "!%^&*()-+={}[];:\"`~|\\,.<>/?\'") != NULL)
        {
            Tuple<const char *> msg;
            msg.Next() = "Exported symbol \"";
            msg.Next() = tok;
            msg.Next() = "\" is an invalid Java variable name.";
            option -> EmitError(variable_symbol -> Location(), msg);
        }

        strcpy(exp_line, "      ");
        strcat(exp_line, option -> exp_prefix);
        strcat(exp_line, tok);
        strcat(exp_line, option -> exp_suffix);
        strcat(exp_line, " = ");
        IntToString num(i);
        strcat(exp_line, num.String());
        strcat(exp_line, (i < grammar -> exported_symbols.Length() ? ",\n" : ";\n"));
                          
        symbol_name[i] = tok;
    }

    fprintf(sysexp, "%s", exp_line);
    fprintf(sysexp, "\n    public final static String orderedTerminalSymbols[] = {\n"
                    "                 \"\",\n");
    {
        for (int i = 1; i < grammar -> exported_symbols.Length(); i++)
        {
            fprintf(sysexp, "                 \"%s\",\n", symbol_name[i]);
            delete [] symbol_name[i];
        }
    }
    fprintf(sysexp, "                 \"%s\"\n             };\n",
            symbol_name[grammar -> exported_symbols.Length()]);
    delete [] symbol_name[grammar -> exported_symbols.Length()];

    fprintf(sysexp, "\n\n    public final static int numTokenKinds = orderedTerminalSymbols.length;");
    fprintf(sysexp, "\n    public final static boolean isValidForParser = false;\n}\n");

    return;
}


//
//
//
void JavaTable::print_definitions(void)
{
    if (option -> error_maps)
    {
        prs_buffer.Put("    public final static int\n");
        prs_buffer.Put("           ERROR_SYMBOL      = ");
        prs_buffer.Put(grammar -> error_image);
        prs_buffer.Put(",\n");

        prs_buffer.Put("           SCOPE_UBOUND      = ");
        prs_buffer.Put(pda -> scope_prefix.Size() - 1);
        prs_buffer.Put(",\n");

        prs_buffer.Put("           SCOPE_SIZE        = ");
        prs_buffer.Put(pda -> scope_prefix.Size());
        prs_buffer.Put(",\n");

        prs_buffer.Put("           MAX_NAME_LENGTH   = ");
        prs_buffer.Put(max_name_length);
        prs_buffer.Put(";\n\n");
        prs_buffer.Put("    public final int getErrorSymbol() { return ERROR_SYMBOL; }\n"
                       "    public final int getScopeUbound() { return SCOPE_UBOUND; }\n"
                       "    public final int getScopeSize() { return SCOPE_SIZE; }\n"
                       "    public final int getMaxNameLength() { return MAX_NAME_LENGTH; }\n\n");
    }
    else
    {
        prs_buffer.Put("    public final int getErrorSymbol() { return 0; }\n"
                       "    public final int getScopeUbound() { return 0; }\n"
                       "    public final int getScopeSize() { return 0; }\n"
                       "    public final int getMaxNameLength() { return 0; }\n\n");
    }

    prs_buffer.Put("    public final static int\n");
    prs_buffer.Put("           NUM_STATES        = ");
    prs_buffer.Put(pda -> num_states);
    prs_buffer.Put(",\n");

    prs_buffer.Put("           NT_OFFSET         = ");
    prs_buffer.Put(grammar -> num_terminals);
    prs_buffer.Put(",\n");

    prs_buffer.Put("           LA_STATE_OFFSET   = ");
    prs_buffer.Put(option -> read_reduce ? error_act + grammar -> num_rules : error_act);
    prs_buffer.Put(",\n");

    prs_buffer.Put("           MAX_LA            = ");
    prs_buffer.Put(pda -> highest_level);
    prs_buffer.Put(",\n");

    prs_buffer.Put("           NUM_RULES         = ");
    prs_buffer.Put(grammar -> num_rules);
    prs_buffer.Put(",\n");

    prs_buffer.Put("           NUM_NONTERMINALS  = ");
    prs_buffer.Put(grammar -> num_nonterminals);
    prs_buffer.Put(",\n");

    prs_buffer.Put("           NUM_SYMBOLS       = ");
    prs_buffer.Put(grammar -> num_symbols);
    prs_buffer.Put(",\n");

    prs_buffer.Put("           SEGMENT_SIZE      = ");
    prs_buffer.Put(MAX_ARRAY_SIZE);
    prs_buffer.Put(",\n");

    prs_buffer.Put("           START_STATE       = ");
    prs_buffer.Put(start_state);
    prs_buffer.Put(",\n");

    prs_buffer.Put("           IDENTIFIER_SYMBOL = ");
    prs_buffer.Put(grammar -> identifier_image);
    prs_buffer.Put(",\n");

    prs_buffer.Put("           EOFT_SYMBOL       = ");
    prs_buffer.Put(grammar -> eof_image);
    prs_buffer.Put(",\n");

    prs_buffer.Put("           EOLT_SYMBOL       = ");
    prs_buffer.Put(grammar -> eol_image);
    prs_buffer.Put(",\n");

    prs_buffer.Put("           ACCEPT_ACTION     = ");
    prs_buffer.Put(accept_act);
    prs_buffer.Put(",\n");

    prs_buffer.Put("           ERROR_ACTION      = ");
    prs_buffer.Put(error_act);
    prs_buffer.Put(";\n\n");

    prs_buffer.Put("    public final static boolean BACKTRACK = ");
    prs_buffer.Put(option -> backtrack ? "true" : "false");
    prs_buffer.Put(";\n\n");
    prs_buffer.Put("    public final int getNumStates() { return NUM_STATES; }\n"
                   "    public final int getNtOffset() { return NT_OFFSET; }\n"
                   "    public final int getLaStateOffset() { return LA_STATE_OFFSET; }\n"
                   "    public final int getMaxLa() { return MAX_LA; }\n"
                   "    public final int getNumRules() { return NUM_RULES; }\n"
                   "    public final int getNumNonterminals() { return NUM_NONTERMINALS; }\n"
                   "    public final int getNumSymbols() { return NUM_SYMBOLS; }\n"
                   "    public final int getSegmentSize() { return SEGMENT_SIZE; }\n"
                   "    public final int getStartState() { return START_STATE; }\n"
                   "    public final int getStartSymbol() { return lhs[0]; }\n"
                   "    public final int getIdentifierSymbol() { return IDENTIFIER_SYMBOL; }\n"
                   "    public final int getEoftSymbol() { return EOFT_SYMBOL; }\n"
                   "    public final int getEoltSymbol() { return EOLT_SYMBOL; }\n"
                   "    public final int getAcceptAction() { return ACCEPT_ACTION; }\n"
                   "    public final int getErrorAction() { return ERROR_ACTION; }\n"
                   "    public final boolean isValidForParser() { return isValidForParser; }\n"
                   "    public final boolean getBacktrack() { return BACKTRACK; }\n\n");

    return;
}


//
//
//
void JavaTable::print_externs(void)
{
    if (option -> error_maps || option -> debug)
    {
        prs_buffer.Put("    public final int originalState(int state) {\n");
        prs_buffer.Put("        return -baseCheck[state];\n");
        prs_buffer.Put("    }\n");
    }
    else
    {
        prs_buffer.Put("    public final int originalState(int state) { return 0; }\n");
    }

    if (option -> error_maps)
    {
        prs_buffer.Put("    public final int asi(int state) {\n"
                       "        return asb[originalState(state)];\n"
                       "    }\n"
                       "    public final int nasi(int state) {\n"
                       "        return nasb[originalState(state)];\n"
                       "    }\n"
                       "    public final int inSymbol(int state) {\n"
                       "        return inSymb[originalState(state)];\n"
                       "    }\n");
    }
    else
    {
        prs_buffer.Put("    public final int asi(int state) { return 0; }\n"
                       "    public final int nasi(int state) { return 0; }\n"
                       "    public final int inSymbol(int state) { return 0; }\n");
    }

    prs_buffer.Put("\n");

    if (option -> goto_default)
         non_terminal_action();
    else non_terminal_no_goto_default_action();

    if (option -> shift_default)
         terminal_shift_default_action();
    else terminal_action();

    return;
}


//
//
//
void JavaTable::print_serialized_tables(void)
{
    int buffer_size = 0;
    for (int i = 0; i < data.Length(); i++)
    {
        IntArrayInfo &array_info = data[i];
        Serialize(array_info);
        buffer_size += array_info.num_bytes;
        switch(array_info.name_id)
        {
            case BASE_CHECK:
                 prs_buffer.Put("    public final static ");
                 prs_buffer.Put(type_name[array_info.type_id]);
                 prs_buffer.Put(" rhs[] = ");
                 prs_buffer.Put(array_name[array_info.name_id]);
                 prs_buffer.Put(";\n"
                                "    public final int rhs(int index) { return rhs[index]; };\n");

                 break;
            case BASE_ACTION:
                 prs_buffer.Put("    public final static ");
                 prs_buffer.Put(type_name[array_info.type_id]);
                 prs_buffer.Put(" lhs[] = ");
                 prs_buffer.Put(array_name[array_info.name_id]);
                 prs_buffer.Put(";\n"
                                "    public final int lhs(int index) { return lhs[index]; };\n");
                 break;
            default:
                 break;
        }
    }

    if (option -> error_maps)
    {
        //
        // If error_maps are requested but not the scope maps, we generate
        // shells for the scope maps to allow an error recovery system that
        // might depend on such maps to compile.
        //
        if (pda -> scope_prefix.Size() == 0)
        {
            prs_buffer.Put("    public final static int scopePrefix[] = null;\n"
                           "    public final int scopePrefix(int index) { return 0;}\n\n"
                           "    public final static int scopeSuffix[] = null;\n"
                           "    public final int scopeSuffix(int index) { return 0;}\n\n"
                           "    public final static int scopeLhs[] = null;\n"
                           "    public final int scopeLhs(int index) { return 0;}\n\n"
                           "    public final static int scopeLa[] = null;\n"
                           "    public final int scopeLa(int index) { return 0;}\n\n"
                           "    public final static int scopeStateSet[] = null;\n"
                           "    public final int scopeStateSet(int index) { return 0;}\n\n"
                           "    public final static int scopeRhs[] = null;\n"
                           "    public final int scopeRhs(int index) { return 0;}\n\n"
                           "    public final static int scopeState[] = null;\n"
                           "    public final int scopeState(int index) { return 0;}\n\n"
                           "    public final static int inSymb[] = null;\n"
                           "    public final int inSymb(int index) { return 0;}\n\n");
        }

        SerializeNames();
        int type_id = Type(0, max_name_length);
        buffer_size += ((type_id == B || type_id == I8 ? 1 : type_id == I32 ? 4 : 2) * name_info.Size());
        buffer_size += (name_start.array[name_start.array.Size() - 1] - 1);
    }
    else
    {
        prs_buffer.Put("    public final int asb(int index) { return 0; }\n"
                       "    public final int asr(int index) { return 0; }\n"
                       "    public final int nasb(int index) { return 0; }\n"
                       "    public final int nasr(int index) { return 0; }\n"
                       "    public final int terminalIndex(int index) { return 0; }\n"
                       "    public final int nonterminalIndex(int index) { return 0; }\n"
                       "    public final int scopePrefix(int index) { return 0;}\n"
                       "    public final int scopeSuffix(int index) { return 0;}\n"
                       "    public final int scopeLhs(int index) { return 0;}\n"
                       "    public final int scopeLa(int index) { return 0;}\n"
                       "    public final int scopeStateSet(int index) { return 0;}\n"
                       "    public final int scopeRhs(int index) { return 0;}\n"
                       "    public final int scopeState(int index) { return 0;}\n"
                       "    public final int inSymb(int index) { return 0;}\n"
                       "    public final String name(int index) { return null; }\n");
    }

    print_deserialization_functions(buffer_size);

    data_buffer.Flush();

    return;
}


//
//
//
void JavaTable::print_source_tables(void)
{
    for (int i = 0; i < data.Length(); i++)
    {
        IntArrayInfo &array_info = data[i];
        Print(array_info);
        switch(array_info.name_id)
        {
            case BASE_CHECK:
                prs_buffer.Put("    public final static ");
                prs_buffer.Put(type_name[array_info.type_id]);
                prs_buffer.Put(" rhs[] = ");
                prs_buffer.Put(array_name[array_info.name_id]);
                prs_buffer.Put(";\n"
                               "    public final int rhs(int index) { return rhs[index]; };\n");

                break;
            case BASE_ACTION:
                prs_buffer.Put("    public final static ");
                prs_buffer.Put(type_name[array_info.type_id]);
                prs_buffer.Put(" lhs[] = ");
                prs_buffer.Put(array_name[array_info.name_id]);
                prs_buffer.Put(";\n"
                               "    public final int lhs(int index) { return lhs[index]; };\n");
                break;
            default:
                break;
        }
    }

    if (option -> error_maps)
    {
        //
        // If error_maps are requested but not the scope maps, we generate
        // shells for the scope maps to allow an error recovery system that
        // might depend on such maps to compile.
        //
        if (pda -> scope_prefix.Size() == 0)
        {
            prs_buffer.Put("    public final static int scopePrefix[] = null;\n"
                           "    public final int scopePrefix(int index) { return 0;}\n\n"
                           "    public final static int scopeSuffix[] = null;\n"
                           "    public final int scopeSuffix(int index) { return 0;}\n\n"
                           "    public final static int scopeLhs[] = null;\n"
                           "    public final int scopeLhs(int index) { return 0;}\n\n"
                           "    public final static int scopeLa[] = null;\n"
                           "    public final int scopeLa(int index) { return 0;}\n\n"
                           "    public final static int scopeStateSet[] = null;\n"
                           "    public final int scopeStateSet(int index) { return 0;}\n\n"
                           "    public final static int scopeRhs[] = null;\n"
                           "    public final int scopeRhs(int index) { return 0;}\n\n"
                           "    public final static int scopeState[] = null;\n"
                           "    public final int scopeState(int index) { return 0;}\n\n"
                           "    public final static int inSymb[] = null;\n"
                           "    public final int inSymb(int index) { return 0;}\n\n");
        }

        PrintNames();
    }
    else
    {


        prs_buffer.Put("    public final int asb(int index) { return 0; }\n"
                       "    public final int asr(int index) { return 0; }\n"
                       "    public final int nasb(int index) { return 0; }\n"
                       "    public final int nasr(int index) { return 0; }\n"
                       "    public final int terminalIndex(int index) { return 0; }\n"
                       "    public final int nonterminalIndex(int index) { return 0; }\n"
                       "    public final int scopePrefix(int index) { return 0;}\n"
                       "    public final int scopeSuffix(int index) { return 0;}\n"
                       "    public final int scopeLhs(int index) { return 0;}\n"
                       "    public final int scopeLa(int index) { return 0;}\n"
                       "    public final int scopeStateSet(int index) { return 0;}\n"
                       "    public final int scopeRhs(int index) { return 0;}\n"
                       "    public final int scopeState(int index) { return 0;}\n"
                       "    public final int inSymb(int index) { return 0;}\n"
                       "    public final String name(int index) { return null; }\n");
    }

    return;
}


//
//
//
void JavaTable::PrintTables(void)
{
    init_parser_files();

    if (strlen(option -> package) > 0)
    {
        prs_buffer.Put("package ");
        prs_buffer.Put(option -> package);
        prs_buffer.Put(";\n\n");
    }
    prs_buffer.Put("public class ");
    prs_buffer.Put(option -> prs_type);
    if (option -> extends_parsetable)
    {
        prs_buffer.Put(" extends ");
        prs_buffer.Put(option -> extends_parsetable);
    }
    prs_buffer.Put(" implements ");
    if (option -> parsetable_interfaces)
    {
        prs_buffer.Put(option -> parsetable_interfaces);
        prs_buffer.Put(", ");
    }
    prs_buffer.Put(option -> sym_type);
    prs_buffer.Put(" {\n");

    if (option -> serialize)
         print_serialized_tables();
    else print_source_tables();

    print_definitions();
    print_externs();

    prs_buffer.Put("}\n");
    prs_buffer.Flush();

    print_symbols();

    if (grammar -> exported_symbols.Length() > 0)
        print_exports();

    exit_parser_files();

    return;
}
