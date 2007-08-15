#include "CTC.h"
#include "NTC.h"
#include "JavaAction.h"

//
//
//
void JavaAction::GenerateDefaultTitle(Tuple<ActionBlockElement> &notice_actions)
{
    //
    // If one or more notice blocks were specified, process and
    // print the notice at the beginning of each action file.
    //
    if (notice_actions.Length() > 0)
    {
        for (int i = 0; i < notice_actions.Length(); i++)
            ProcessActionBlock(notice_actions[i]);
        TextBuffer *buffer = notice_actions[0].buffer; // get proper buffer from first action
        buffer -> Put("\n");
        action_blocks -> PutNotice(*buffer);
    }

    //
    // Issue the package state
    //
    TextBuffer *buffer = (option -> DefaultBlock() -> Buffer()
                              ? option -> DefaultBlock() -> Buffer()
                              : option -> DefaultBlock() -> ActionfileSymbol() -> InitialHeadersBuffer());
    if (*option -> package != '\0')
    {
        buffer -> Put("package ");
        buffer -> Put(option -> package);
        buffer -> Put(";\n\n");
    }
    if (option -> automatic_ast &&
        strcmp(option -> package, option -> ast_package) != 0 &&
        *option -> ast_package != '\0')
    {
        buffer -> Put("import ");
        buffer -> Put(option -> ast_package);
        buffer -> Put(".*;\n");
    }

    return;
}


//
// First construct a file for this type. Write the title information to its header
// buffer and return the file.
//
ActionFileSymbol *JavaAction::GenerateTitle(ActionFileLookupTable &ast_filename_table,
                                            Tuple<ActionBlockElement> &notice_actions,
                                            const char *type_name,
                                            bool needs_environment)
{
    const char *filetype = (option -> programming_language == Option::JAVA
                                ? ".java"
                                : (option -> programming_language == Option::ML
                                       ? ".ml"
                                       : (option -> programming_language == Option::PLX || option -> programming_language == Option::PLXASM
                                              ? ".copy"
                                              : (option -> programming_language == Option::C || option -> programming_language == Option::CPP
                                                     ? ".h"
                                                     : ".xml"))));
    int filename_length = strlen(option -> ast_directory_prefix) + strlen(type_name) + strlen(filetype);
    char *filename = new char[filename_length + 1];
    strcpy(filename, option -> ast_directory_prefix);
    strcat(filename, type_name);
    strcat(filename, filetype);

    ActionFileSymbol *file_symbol = ast_filename_table.FindOrInsertName(filename, filename_length);
    TextBuffer *buffer = file_symbol -> InitialHeadersBuffer();
    if (notice_actions.Length() > 0)
    {
        //
        // Copy each notice action block, in turn, into a new
        // ActionBLockElement; redirect its output to this buffer
        // and process it.
        //
        for (int i = 0; i < notice_actions.Length(); i++)
        {
            ActionBlockElement action = notice_actions[i];
            action.buffer = buffer;
            ProcessActionBlock(action);
        }
        buffer -> Put("\n");
    }
    if (*option -> ast_package != '\0')
    {
        buffer -> Put("package ");
        buffer -> Put(option -> ast_package);
        buffer -> Put(";\n\n");
    }

    if (needs_environment &&
        strcmp(option -> ast_package, option -> package) != 0 &&
        *option -> package != '\0')
    {
        buffer -> Put("import ");
        buffer -> Put(option -> package);
        buffer -> Put(".*;\n");
    }

    delete [] filename;

    return file_symbol;
}


ActionFileSymbol *JavaAction::GenerateTitleAndGlobals(ActionFileLookupTable &ast_filename_table,
                                                      Tuple<ActionBlockElement> &notice_actions,
                                                      const char *type_name,
                                                      bool needs_environment)
{
    ActionFileSymbol *file_symbol = GenerateTitle(ast_filename_table, notice_actions, type_name, needs_environment);
    for (int i = 0; i < grammar -> parser.global_blocks.Length(); i++)
    {
        ActionBlockElement action;
        action.rule_number = 0;
        action.location = ActionBlockElement::INITIALIZE; // does not matter - block must be default block...
        action.block_token = grammar -> parser.global_blocks[i];
        action.buffer = file_symbol -> InitialHeadersBuffer();

        ProcessActionBlock(action);
        action.buffer -> Put("\n");
    }

    return file_symbol;
}


//
//
//
void JavaAction::GenerateEnvironmentDeclaration(TextBuffer &ast_buffer, const char *indentation)
{
    ast_buffer.Put(indentation); ast_buffer.Put("    private ");
                                 ast_buffer.Put(option -> action_type);
                                 ast_buffer.Put(" environment;\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    public ");
                                 ast_buffer.Put(option -> action_type);
                                 ast_buffer.Put(" getEnvironment() { return environment; }\n\n");
}

//
//
//
void JavaAction::GenerateVisitorHeaders(TextBuffer &ast_buffer, const char *indentation, const char *modifiers)
{
    if (option -> visitor != Option::NONE)
    {
        char *header = new char[strlen(indentation) + strlen(modifiers) + 9];
        strcpy(header, indentation);
        strcat(header, modifiers);

        ast_buffer.Put(header);
        ast_buffer.Put("void accept(");
        ast_buffer.Put(option -> visitor_type);
        ast_buffer.Put(" v);");

        if (option -> visitor == Option::DEFAULT)
        {
            ast_buffer.Put("\n");

            ast_buffer.Put(header);
            ast_buffer.Put("void accept(Argument");
            ast_buffer.Put(option -> visitor_type);
            ast_buffer.Put(" v, Object o);\n");

            ast_buffer.Put(header);
            ast_buffer.Put("Object accept(Result");
            ast_buffer.Put(option -> visitor_type);
            ast_buffer.Put(" v);\n");

            ast_buffer.Put(header);
            ast_buffer.Put("Object accept(ResultArgument");
            ast_buffer.Put(option -> visitor_type);
            ast_buffer.Put(" v, Object o);");
        }
        ast_buffer.Put("\n");

        delete [] header;
    }

    return;
}


//
//
//
void JavaAction::GenerateVisitorMethods(NTC &ntc,
                                        TextBuffer &ast_buffer,
                                        const char *indentation,
                                        ClassnameElement &element,
                                        BitSet &optimizable_symbol_set)
{
    if (option -> visitor == Option::DEFAULT)
    {
        ast_buffer.Put("\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    public void accept(");
                                     ast_buffer.Put(option -> visitor_type);
                                     ast_buffer.Put(" v) { v.visit(this); }\n");

        ast_buffer.Put(indentation); ast_buffer.Put("    public void accept(Argument");
                                     ast_buffer.Put(option -> visitor_type);
                                     ast_buffer.Put(" v, Object o) { v.visit(this, o); }\n");

        ast_buffer.Put(indentation); ast_buffer.Put("    public Object accept(Result");
                                     ast_buffer.Put(option -> visitor_type);
                                     ast_buffer.Put(" v) { return v.visit(this); }\n");

        ast_buffer.Put(indentation); ast_buffer.Put("    public Object accept(ResultArgument");
                                     ast_buffer.Put(option -> visitor_type);
                                     ast_buffer.Put(" v, Object o) { return v.visit(this, o); }\n");
    }
    else if (option -> visitor == Option::PREORDER)
    {
        ast_buffer.Put("\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    public void accept(");
                                     ast_buffer.Put(option -> visitor_type);
                                     ast_buffer.Put(" v)\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    {\n");
        ast_buffer.Put(indentation); ast_buffer.Put("        if (! v.preVisit(this)) return;\n");
        ast_buffer.Put(indentation); ast_buffer.Put("        enter(v);\n");
        ast_buffer.Put(indentation); ast_buffer.Put("        v.postVisit(this);\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    }\n\n");

        ast_buffer.Put(indentation); ast_buffer.Put("    public void enter(");
                                     ast_buffer.Put(option -> visitor_type);
                                     ast_buffer.Put(" v)\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    {\n");
        SymbolLookupTable &symbol_set = element.symbol_set;
        Tuple<int> &rhs_type_index = element.rhs_type_index;
        if (element.is_terminal_class || symbol_set.Size() == 0)
        {
            ast_buffer.Put(indentation); ast_buffer.Put("        v.visit(this);\n");
        }
        else
        {
            ast_buffer.Put(indentation); ast_buffer.Put("        boolean checkChildren = v.visit(this);\n");
            ast_buffer.Put(indentation); ast_buffer.Put("        if (checkChildren)\n");
            if (symbol_set.Size() > 1)
            {
                ast_buffer.Put(indentation); ast_buffer.Put("        {\n");
            }

            for (int i = 0; i < symbol_set.Size(); i++)
            {
                ast_buffer.Put(indentation); ast_buffer.Put("            ");
                if ((! optimizable_symbol_set[i]) || ntc.CanProduceNullAst(rhs_type_index[i]))
                {
                    ast_buffer.Put("if (_");
                    ast_buffer.Put(symbol_set[i] -> Name());
                    ast_buffer.Put(" != null) ");
                }
                ast_buffer.Put("_");
                ast_buffer.Put(symbol_set[i] -> Name());
                ast_buffer.Put(".accept(v);\n");
            }

            if (symbol_set.Size() > 1)
            {
                ast_buffer.Put(indentation); ast_buffer.Put("        }\n");
            }
        }
        ast_buffer.Put(indentation); ast_buffer.Put("        v.endVisit(this);\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    }\n");
    }

    return;
}


//
//
//
void JavaAction::GenerateGetAllChildrenMethod(TextBuffer &ast_buffer,
                                              const char *indentation,
                                              ClassnameElement &element)
{
    if (! element.is_terminal_class)
    {
        SymbolLookupTable &symbol_set = element.symbol_set;

        ast_buffer.Put("\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    /**\n");
        ast_buffer.Put(indentation); ast_buffer.Put("     * A list of all children of this node, including the null ones.\n");
        ast_buffer.Put(indentation); ast_buffer.Put("     */\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    public java.util.ArrayList getAllChildren()\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    {\n");
        ast_buffer.Put(indentation); ast_buffer.Put("        java.util.ArrayList list = new java.util.ArrayList();\n");
        for (int i = 0; i < symbol_set.Size(); i++)
        {
            ast_buffer.Put(indentation); ast_buffer.Put("        list.add(_");
                                         ast_buffer.Put(symbol_set[i] -> Name());
                                         ast_buffer.Put(");\n");
        }
        ast_buffer.Put(indentation); ast_buffer.Put("        return list;\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    }\n");
    }

    return;
}


//
//
//
void JavaAction::GenerateEqualsMethod(NTC &ntc,
                                      TextBuffer &ast_buffer,
                                      const char *indentation,
                                      ClassnameElement &element,
                                      BitSet &optimizable_symbol_set)
{
    if (! element.is_terminal_class)
    {
        SymbolLookupTable &symbol_set = element.symbol_set;
        Tuple<int> &rhs_type_index = element.rhs_type_index;

        ast_buffer.Put("\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    public boolean equals(Object o)\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    {\n");
        ast_buffer.Put(indentation); ast_buffer.Put("        if (o == this) return true;\n");
        ast_buffer.Put(indentation); ast_buffer.Put("        //\n");
        ast_buffer.Put(indentation); ast_buffer.Put("        // The super call test is not required for now because an Ast node\n");
        ast_buffer.Put(indentation); ast_buffer.Put("        // can only extend the root Ast, AstToken and AstList and none of\n");
        ast_buffer.Put(indentation); ast_buffer.Put("        // these nodes contain additional children.\n");
        ast_buffer.Put(indentation); ast_buffer.Put("        //\n");
        ast_buffer.Put(indentation); ast_buffer.Put("        // if (! super.equals(o)) return false;\n");
        ast_buffer.Put(indentation); ast_buffer.Put("        //\n");
        ast_buffer.Put(indentation); ast_buffer.Put("        if (! (o instanceof ");
                                     ast_buffer.Put(element.real_name);
                                     ast_buffer.Put(")) return false;\n");
        if (symbol_set.Size() > 0)
        {
            ast_buffer.Put(indentation); ast_buffer.Put("        ");
                                         ast_buffer.Put(element.real_name);
                                         ast_buffer.Put(" other = (");
                                         ast_buffer.Put(element.real_name);
                                         ast_buffer.Put(") o;\n");

            for (int i = 0; i < symbol_set.Size(); i++)
            {
                ast_buffer.Put(indentation); ast_buffer.Put("        ");
                if ((! optimizable_symbol_set[i]) || ntc.CanProduceNullAst(rhs_type_index[i]))
                {
                                                 ast_buffer.Put("if (_");
                                                 ast_buffer.Put(symbol_set[i] -> Name());
                                                 ast_buffer.Put(" == null)\n");
                    ast_buffer.Put(indentation); ast_buffer.Put("            if (other._");
                                                 ast_buffer.Put(symbol_set[i] -> Name());
                                                 ast_buffer.Put(" != null) return false;\n");
                    ast_buffer.Put(indentation); ast_buffer.Put("            else; // continue\n");
                    ast_buffer.Put(indentation); ast_buffer.Put("        else ");
                }
                ast_buffer.Put("if (! _");
                ast_buffer.Put(symbol_set[i] -> Name());
                ast_buffer.Put(".equals(other._");
                ast_buffer.Put(symbol_set[i] -> Name());
                ast_buffer.Put(")) return false;\n");
            }
        }
        ast_buffer.Put(indentation); ast_buffer.Put("        return true;\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    }\n");
    }

    return;
}


//
//
//
void JavaAction::GenerateHashcodeMethod(NTC &ntc,
                                        TextBuffer &ast_buffer,
                                        const char *indentation,
                                        ClassnameElement &element,
                                        BitSet &optimizable_symbol_set)
{
    if (! element.is_terminal_class)
    {
        SymbolLookupTable &symbol_set = element.symbol_set;
        Tuple<int> &rhs_type_index = element.rhs_type_index;

        ast_buffer.Put("\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    public int hashCode()\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    {\n");

        ast_buffer.Put(indentation); ast_buffer.Put("        int hash = 7;\n");
        for (int i = 0; i < symbol_set.Size(); i++)
        {
            ast_buffer.Put(indentation); ast_buffer.Put("        hash = hash * 31 + (_");
            ast_buffer.Put(symbol_set[i] -> Name());
            if ((! optimizable_symbol_set[i]) || ntc.CanProduceNullAst(rhs_type_index[i]))
            {
                ast_buffer.Put(" == null ? 0 : _");
                ast_buffer.Put(symbol_set[i] -> Name());
            }
            ast_buffer.Put(".hashCode());\n");
        }
        ast_buffer.Put(indentation); ast_buffer.Put("        return hash;\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    }\n");
    }

    return;
}


//
//
//
void JavaAction::GenerateSimpleVisitorInterface(TextBuffer &ast_buffer,
                                                const char *indentation,
                                                const char *interface_name,
                                                SymbolLookupTable &type_set)
{
    ast_buffer.Put(indentation); ast_buffer.Put("public interface ");
                                 ast_buffer.Put(interface_name);
                                 ast_buffer.Put("\n");
    ast_buffer.Put(indentation); ast_buffer.Put("{\n");
    for (int i = 0; i < type_set.Size(); i++)
    {
        Symbol *symbol = type_set[i];
        ast_buffer.Put(indentation); ast_buffer.Put("    void visit");
                                     ast_buffer.Put("(");
                                     ast_buffer.Put(symbol -> Name());
                                     ast_buffer.Put(" n);\n");
    }

    ast_buffer.Put(indentation); ast_buffer.Put("}\n");
}

//
//
//
void JavaAction::GenerateArgumentVisitorInterface(TextBuffer &ast_buffer,
                                                  const char *indentation,
                                                  const char *interface_name,
                                                  SymbolLookupTable &type_set)
{
    ast_buffer.Put(indentation); ast_buffer.Put("public interface ");
                                 ast_buffer.Put(interface_name);
                                 ast_buffer.Put("\n");
    ast_buffer.Put(indentation); ast_buffer.Put("{\n");
    for (int i = 0; i < type_set.Size(); i++)
    {
        Symbol *symbol = type_set[i];
        ast_buffer.Put(indentation); ast_buffer.Put("    void visit");
                                     ast_buffer.Put("(");
                                     ast_buffer.Put(symbol -> Name());
                                     ast_buffer.Put(" n, Object o);\n");
    }

    ast_buffer.Put(indentation); ast_buffer.Put("}\n");
}

//
//
//
void JavaAction::GenerateResultVisitorInterface(TextBuffer &ast_buffer,
                                                const char *indentation,
                                                const char *interface_name,
                                                SymbolLookupTable &type_set)
{
    ast_buffer.Put(indentation); ast_buffer.Put("public interface ");
                                 ast_buffer.Put(interface_name);
                                 ast_buffer.Put("\n");
    ast_buffer.Put(indentation); ast_buffer.Put("{\n");
    for (int i = 0; i < type_set.Size(); i++)
    {
        Symbol *symbol = type_set[i];
        ast_buffer.Put(indentation); ast_buffer.Put("    Object visit");
                                     ast_buffer.Put("(");
                                     ast_buffer.Put(symbol -> Name());
                                     ast_buffer.Put(" n);\n");
    }

    ast_buffer.Put(indentation); ast_buffer.Put("}\n");
}

//
//
//
void JavaAction::GenerateResultArgumentVisitorInterface(TextBuffer &ast_buffer,
                                                        const char *indentation,
                                                        const char *interface_name,
                                                        SymbolLookupTable &type_set)
{
    ast_buffer.Put(indentation); ast_buffer.Put("public interface ");
    ast_buffer.Put(interface_name);
    ast_buffer.Put("\n");
    ast_buffer.Put(indentation); ast_buffer.Put("{\n");
    for (int i = 0; i < type_set.Size(); i++)
    {
        Symbol *symbol = type_set[i];
        ast_buffer.Put(indentation); ast_buffer.Put("    Object visit");
                                     ast_buffer.Put("(");
                                     ast_buffer.Put(symbol -> Name());
                                     ast_buffer.Put(" n, Object o);\n");
    }

    ast_buffer.Put(indentation); ast_buffer.Put("}\n");
}


//
//
//
void JavaAction::GeneratePreorderVisitorInterface(TextBuffer &ast_buffer,
                                                  const char *indentation,
                                                  const char *interface_name,
                                                  SymbolLookupTable &type_set)
{
    assert(option -> visitor == Option::PREORDER);
    ast_buffer.Put(indentation); ast_buffer.Put("public interface ");
                                 ast_buffer.Put(interface_name);
                                 ast_buffer.Put("\n");
    ast_buffer.Put(indentation); ast_buffer.Put("{\n");

    ast_buffer.Put(indentation); ast_buffer.Put("    boolean preVisit(");
                                 ast_buffer.Put(option -> ast_type);
                                 ast_buffer.Put(" element);\n\n");

    ast_buffer.Put(indentation); ast_buffer.Put("    void postVisit(");
                                 ast_buffer.Put(option -> ast_type);
                                 ast_buffer.Put(" element);\n\n");
    for (int i = 0; i < type_set.Size(); i++)
    {
        Symbol *symbol = type_set[i];
        ast_buffer.Put(indentation); ast_buffer.Put("    boolean visit");
                                     ast_buffer.Put("(");
                                     ast_buffer.Put(symbol -> Name());
                                     ast_buffer.Put(" n);\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    void endVisit");
                                     ast_buffer.Put("(");
                                     ast_buffer.Put(symbol -> Name());
                                     ast_buffer.Put(" n);\n");
        if (i + 1 < type_set.Size())
            ast_buffer.Put("\n");
    }

    ast_buffer.Put(indentation); ast_buffer.Put("}\n\n");

    return;
}


//
//
//
void JavaAction::GenerateNoResultVisitorAbstractClass(TextBuffer &ast_buffer,
                                                      const char *indentation,
                                                      const char *classname,
                                                      SymbolLookupTable &type_set)
{
    ast_buffer.Put(indentation); ast_buffer.Put(option -> automatic_ast == Option::NESTED ? "static " : "");
                                 ast_buffer.Put("public abstract class ");
                                 ast_buffer.Put(classname);
                                 ast_buffer.Put(" implements ");
                                 ast_buffer.Put(option -> visitor_type);
                                 ast_buffer.Put(", Argument");
                                 ast_buffer.Put(option -> visitor_type);
                                 ast_buffer.Put("\n");
    ast_buffer.Put(indentation); ast_buffer.Put("{\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    public abstract void unimplementedVisitor(String s);\n\n");
    for (int i = 0; i < type_set.Size(); i++)
    {
        Symbol *symbol = type_set[i];
        ast_buffer.Put(indentation); ast_buffer.Put("    public void visit");
                                     ast_buffer.Put("(");
                                     ast_buffer.Put(symbol -> Name());
                                     ast_buffer.Put(" n) { unimplementedVisitor(\"visit(");
                                     ast_buffer.Put(symbol -> Name());
                                     ast_buffer.Put(")\"); }\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    public void visit");
                                     ast_buffer.Put("(");
                                     ast_buffer.Put(symbol -> Name());
                                     ast_buffer.Put(" n, Object o) { unimplementedVisitor(\"visit(");
                                     ast_buffer.Put(symbol -> Name());
                                     ast_buffer.Put(", Object)\"); }\n");
        if (i + 1 < type_set.Size())
            ast_buffer.Put("\n");
    }

    ast_buffer.Put(indentation); ast_buffer.Put("}\n");
}

//
//
//
void JavaAction::GenerateResultVisitorAbstractClass(TextBuffer &ast_buffer,
                                                    const char *indentation,
                                                    const char *classname,
                                                    SymbolLookupTable &type_set)
{
    ast_buffer.Put(indentation); ast_buffer.Put(option -> automatic_ast == Option::NESTED ? "static " : "");
                                 ast_buffer.Put("public abstract class ");
                                 ast_buffer.Put(classname);
                                 ast_buffer.Put(" implements Result");
                                 ast_buffer.Put(option -> visitor_type);
                                 ast_buffer.Put(", ResultArgument");
                                 ast_buffer.Put(option -> visitor_type);
                                 ast_buffer.Put("\n");
    ast_buffer.Put(indentation); ast_buffer.Put("{\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    public abstract Object unimplementedVisitor(String s);\n\n");
    for (int i = 0; i < type_set.Size(); i++)
    {
        Symbol *symbol = type_set[i];
        ast_buffer.Put(indentation); ast_buffer.Put("    public Object visit(");
                                     ast_buffer.Put(symbol -> Name());
                                     ast_buffer.Put(" n) { return unimplementedVisitor(\"visit(");
                                     ast_buffer.Put(symbol -> Name());
                                     ast_buffer.Put(")\"); }\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    public Object visit(");
                                     ast_buffer.Put(symbol -> Name());
                                     ast_buffer.Put(" n, Object o) { return  unimplementedVisitor(\"visit(");
                                     ast_buffer.Put(symbol -> Name());
                                     ast_buffer.Put(", Object)\"); }\n");
        if (i + 1 < type_set.Size())
            ast_buffer.Put("\n");
    }

    ast_buffer.Put(indentation); ast_buffer.Put("}\n");
}


//
//
//
void JavaAction::GeneratePreorderVisitorAbstractClass(TextBuffer &ast_buffer,
                                                      const char *indentation,
                                                      const char *classname,
                                                      SymbolLookupTable &type_set)
{
    assert(option -> visitor == Option::PREORDER);
    ast_buffer.Put(indentation); ast_buffer.Put(option -> automatic_ast == Option::NESTED ? "static " : "");
                                 ast_buffer.Put("public abstract class ");
                                 ast_buffer.Put(classname);
                                 ast_buffer.Put(" implements ");
                                 ast_buffer.Put(option -> visitor_type);
                                 ast_buffer.Put("\n");
    ast_buffer.Put(indentation); ast_buffer.Put("{\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    public abstract void unimplementedVisitor(String s);\n\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    public boolean preVisit(");
                                 ast_buffer.Put(option -> ast_type);
                                 ast_buffer.Put(" element) { return true; }\n\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    public void postVisit(");
                                 ast_buffer.Put(option -> ast_type);
                                 ast_buffer.Put(" element) {}\n\n");
    for (int i = 0; i < type_set.Size(); i++)
    {
        Symbol *symbol = type_set[i];
        ast_buffer.Put(indentation); ast_buffer.Put("    public boolean visit");
                                     ast_buffer.Put("(");
                                     ast_buffer.Put(symbol -> Name());
                                     ast_buffer.Put(" n) { unimplementedVisitor(\"visit(");
                                     ast_buffer.Put(symbol -> Name());
                                     ast_buffer.Put(")\"); return true; }\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    public void endVisit");
                                     ast_buffer.Put("(");
                                     ast_buffer.Put(symbol -> Name());
                                     ast_buffer.Put(" n) { unimplementedVisitor(\"endVisit(");
                                     ast_buffer.Put(symbol -> Name());
                                     ast_buffer.Put(")\"); }\n");
        if (i + 1 < type_set.Size())
            ast_buffer.Put("\n");
    }

    ast_buffer.Put(indentation); ast_buffer.Put("}\n");

    return;
}


//
// Generate the the Ast root classes
//
void JavaAction::GenerateAstType(TextBuffer &ast_buffer,
                                 const char *indentation,
                                 const char *classname)
{
    /*
     * First, generate the main root class
     */
    ast_buffer.Put(indentation); ast_buffer.Put(option -> automatic_ast == Option::NESTED ? "static " : "");
                                 ast_buffer.Put("public abstract class ");
                                 ast_buffer.Put(classname);
                                 ast_buffer.Put(" implements IAst\n");
    ast_buffer.Put(indentation); ast_buffer.Put("{\n");
    if (option -> glr)
    {
        ast_buffer.Put(indentation); ast_buffer.Put("    private Ast nextAst = null;\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    public IAst getNextAst() { return nextAst; }\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    public void setNextAst(IAst n) { nextAst = n; }\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    public void resetNextAst() { nextAst = null; }\n");
    }
    else ast_buffer.Put(indentation); ast_buffer.Put("    public IAst getNextAst() { return null; }\n");

    ast_buffer.Put(indentation); ast_buffer.Put("    protected IToken leftIToken,\n");
    ast_buffer.Put(indentation); ast_buffer.Put("                     rightIToken;\n");
    if (option -> parent_saved)
    {
        ast_buffer.Put(indentation); ast_buffer.Put("    protected IAst parent = null;\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    protected void setParent(IAst parent) { this.parent = parent; }\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    public IAst getParent() { return parent; }\n");\
    }
    else
    {
        ast_buffer.Put(indentation); ast_buffer.Put("    public IAst getParent()\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    {\n");
        ast_buffer.Put(indentation); ast_buffer.Put("        throw new UnsupportedOperationException(\"noparent-saved option in effect\");\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    }\n");
    }

    ast_buffer.Put("\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    public IToken getLeftIToken() { return leftIToken; }\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    public IToken getRightIToken() { return rightIToken; }\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    public IToken[] getPrecedingAdjuncts() { return leftIToken.getPrecedingAdjuncts(); }\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    public IToken[] getFollowingAdjuncts() { return rightIToken.getFollowingAdjuncts(); }\n\n");

    ast_buffer.Put(indentation); ast_buffer.Put("    public String toString()\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    {\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        return leftIToken.getPrsStream().toString(leftIToken, rightIToken);\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    }\n\n");

    ast_buffer.Put(indentation); ast_buffer.Put("    public ");
                                 ast_buffer.Put(classname);
                                 ast_buffer.Put("(IToken token) { this.leftIToken = this.rightIToken = token; }\n");

    ast_buffer.Put(indentation); ast_buffer.Put("    public ");
                                 ast_buffer.Put(classname);
                                 ast_buffer.Put("(IToken leftIToken, IToken rightIToken)\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    {\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        this.leftIToken = leftIToken;\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        this.rightIToken = rightIToken;\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    }\n\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    void initialize() {}\n");
    if (grammar -> parser.ast_block != 0)
    {
        ActionBlockElement action;
        action.rule_number = 0;
        action.location = ActionBlockElement::INITIALIZE; // does not matter - block must be default block...
        action.block_token = grammar -> parser.ast_block;
        action.buffer = &ast_buffer;
        ProcessActionBlock(action);
    }

    ast_buffer.Put("\n");
    if (option -> parent_saved)
    {
        ast_buffer.Put(indentation); ast_buffer.Put("    /**\n");
        ast_buffer.Put(indentation); ast_buffer.Put("     * A list of all children of this node, excluding the null ones.\n");
        ast_buffer.Put(indentation); ast_buffer.Put("     */\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    public java.util.ArrayList getChildren()\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    {\n");
        ast_buffer.Put(indentation); ast_buffer.Put("        java.util.ArrayList list = getAllChildren();\n");
        ast_buffer.Put(indentation); ast_buffer.Put("        int k = -1;\n");
        ast_buffer.Put(indentation); ast_buffer.Put("        for (int i = 0; i < list.size(); i++)\n");
        ast_buffer.Put(indentation); ast_buffer.Put("        {\n");
        ast_buffer.Put(indentation); ast_buffer.Put("            Object element = list.get(i);\n");
        ast_buffer.Put(indentation); ast_buffer.Put("            if (element != null)\n");
        ast_buffer.Put(indentation); ast_buffer.Put("            {\n");
        ast_buffer.Put(indentation); ast_buffer.Put("                if (++k != i)\n");
        ast_buffer.Put(indentation); ast_buffer.Put("                    list.set(k, element);\n");
        ast_buffer.Put(indentation); ast_buffer.Put("            }\n");
        ast_buffer.Put(indentation); ast_buffer.Put("        }\n");
        ast_buffer.Put(indentation); ast_buffer.Put("        for (int i = list.size() - 1; i > k; i--) // remove extraneous elements\n");
        ast_buffer.Put(indentation); ast_buffer.Put("            list.remove(i);\n");
        ast_buffer.Put(indentation); ast_buffer.Put("        return list;\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    }\n\n");

        ast_buffer.Put(indentation); ast_buffer.Put("    /**\n");
        ast_buffer.Put(indentation); ast_buffer.Put("     * A list of all children of this node, including the null ones.\n");
        ast_buffer.Put(indentation); ast_buffer.Put("     */\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    public abstract java.util.ArrayList getAllChildren();\n");
    }
    else
    {
        ast_buffer.Put(indentation); ast_buffer.Put("    public java.util.ArrayList getChildren()\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    {\n");
        ast_buffer.Put(indentation); ast_buffer.Put("        throw new UnsupportedOperationException(\"noparent-saved option in effect\");\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    }\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    public java.util.ArrayList getAllChildren() { return getChildren(); }\n");
    }

    ast_buffer.Put("\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    /**\n");
    ast_buffer.Put(indentation); ast_buffer.Put("     * Since the Ast type has no children, any two instances of it are equal.\n");
    ast_buffer.Put(indentation); ast_buffer.Put("     */\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    public boolean equals(Object o) { return o instanceof ");
                                 ast_buffer.Put(classname);
                                 ast_buffer.Put("; }\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    public abstract int hashCode();\n");

    GenerateVisitorHeaders(ast_buffer, indentation, "    public abstract ");

    ast_buffer.Put(indentation); ast_buffer.Put("}\n\n");

    return;
}


//
// Generate the the Ast list class
//
void JavaAction::GenerateAstListType(TextBuffer &ast_buffer,
                                     const char *indentation,
                                     const char *classname)
{
    /*
     * Generate the List root class
     */
    ast_buffer.Put(indentation); ast_buffer.Put(option -> automatic_ast == Option::NESTED ? "static " : "");
                                 ast_buffer.Put("public abstract class ");
                                 ast_buffer.Put(classname);
                                 ast_buffer.Put(" extends ");
                                 ast_buffer.Put(option -> ast_type);
                                 ast_buffer.Put("\n");
    ast_buffer.Put(indentation); ast_buffer.Put("{\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    private boolean leftRecursive;\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    private java.util.ArrayList list;\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    public int size() { return list.size(); }\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    public ");
                                 ast_buffer.Put(option -> ast_type);
                                 ast_buffer.Put(" getElementAt(int i) { return (");
                                 ast_buffer.Put(option -> ast_type);
                                 ast_buffer.Put(") list.get(leftRecursive ? i : list.size() - 1 - i); }\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    public java.util.ArrayList getArrayList()\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    {\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        if (! leftRecursive) // reverse the list \n");
    ast_buffer.Put(indentation); ast_buffer.Put("        {\n");
    ast_buffer.Put(indentation); ast_buffer.Put("            for (int i = 0, n = list.size() - 1; i < n; i++, n--)\n");
    ast_buffer.Put(indentation); ast_buffer.Put("            {\n");
    ast_buffer.Put(indentation); ast_buffer.Put("                Object ith = list.get(i),\n");
    ast_buffer.Put(indentation); ast_buffer.Put("                       nth = list.get(n);\n");
    ast_buffer.Put(indentation); ast_buffer.Put("                list.set(i, nth);\n");
    ast_buffer.Put(indentation); ast_buffer.Put("                list.set(n, ith);\n");
    ast_buffer.Put(indentation); ast_buffer.Put("            }\n");
    ast_buffer.Put(indentation); ast_buffer.Put("            leftRecursive = true;\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        }\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        return list;\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    }\n");

    ast_buffer.Put(indentation); ast_buffer.Put("    public void add(");
                                 ast_buffer.Put(option -> ast_type);
                                 ast_buffer.Put(" element)\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    {\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        list.add(element);\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        if (leftRecursive)\n");
    ast_buffer.Put(indentation); ast_buffer.Put("             rightIToken = element.getRightIToken();\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        else leftIToken = element.getLeftIToken();\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    }\n\n");

    // generate constructors for list class
    ast_buffer.Put(indentation); ast_buffer.Put("    public ");
                                 ast_buffer.Put(classname);
                                 ast_buffer.Put("(IToken leftIToken, IToken rightIToken, boolean leftRecursive)\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    {\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        super(leftIToken, rightIToken);\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        this.leftRecursive = leftRecursive;\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        list = new java.util.ArrayList();\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    }\n\n");

    ast_buffer.Put(indentation); ast_buffer.Put("    public ");
                                 ast_buffer.Put(classname);
                                 ast_buffer.Put("(");
                                 ast_buffer.Put(option -> ast_type);
                                 ast_buffer.Put(" element, boolean leftRecursive)\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    {\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        this(element.getLeftIToken(), element.getRightIToken(), leftRecursive);\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        list.add(element);\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    }\n\n");

    if (option -> parent_saved)
    {
        ast_buffer.Put(indentation); ast_buffer.Put("    /**\n");
        ast_buffer.Put(indentation); ast_buffer.Put("     * Make a copy of the list and return it. Note that we obtain the local list by\n");
        ast_buffer.Put(indentation); ast_buffer.Put("     * invoking getArrayList so as to make sure that the list we return is in proper order.\n");
        ast_buffer.Put(indentation); ast_buffer.Put("     */\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    public java.util.ArrayList getAllChildren()\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    {\n");
        ast_buffer.Put(indentation); ast_buffer.Put("        return (java.util.ArrayList) getArrayList().clone();\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    }\n\n");
    }

    ast_buffer.Put(indentation); ast_buffer.Put("    public boolean equals(Object o)\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    {\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        if (o == this) return true;\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        if (this.getClass() != o.getClass()) return false;\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        ");
                                 ast_buffer.Put(classname);
                                 ast_buffer.Put(" other = (");
                                 ast_buffer.Put(classname);
                                 ast_buffer.Put(") o;\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        if (size() != other.size()) return false;\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        for (int i = 0; i < size(); i++)\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        {\n");
    ast_buffer.Put(indentation); ast_buffer.Put("            ");
                                 ast_buffer.Put(option -> ast_type);
                                 ast_buffer.Put(" element = getElementAt(i);\n");
    ast_buffer.Put(indentation); ast_buffer.Put("            if (element == null)\n");
    ast_buffer.Put(indentation); ast_buffer.Put("                if (other.getElementAt(i) != null) return false;\n");
    ast_buffer.Put(indentation); ast_buffer.Put("                else;\n");
    ast_buffer.Put(indentation); ast_buffer.Put("            else if (! element.equals(other.getElementAt(i)))\n");
    ast_buffer.Put(indentation); ast_buffer.Put("                return false;\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        }\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        return true;\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    }\n\n");

    ast_buffer.Put(indentation); ast_buffer.Put("    public int hashCode()\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    {\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        int hash = 7;\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        for (int i = 0; i < size(); i++)\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        {\n");
    ast_buffer.Put(indentation); ast_buffer.Put("            ");
                                 ast_buffer.Put(option -> ast_type);
                                 ast_buffer.Put(" element = getElementAt(i);\n");
    ast_buffer.Put(indentation); ast_buffer.Put("            hash = hash * 31 + (element == null ? 0 : element.hashCode());\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        }\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        return hash;\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    }\n");

    //
    // TODO: REMOVE THIS ... no longer needed.
    //
    //    ast_buffer.Put(indentation); ast_buffer.Put("    public abstract boolean equals(Object o);\n");
    //    ast_buffer.Put(indentation); ast_buffer.Put("    public abstract int hashCode();\n");
    ast_buffer.Put(indentation); ast_buffer.Put("}\n\n");

    return;
}


//
// Generate the the Ast token class
//
void JavaAction::GenerateAstTokenType(NTC &ntc, TextBuffer &ast_buffer,
                                      const char *indentation,
                                      const char *classname)
{
    /*
     * Generate the Token root class
     */
    ast_buffer.Put(indentation); ast_buffer.Put(option -> automatic_ast == Option::NESTED ? "static " : "");
                                 ast_buffer.Put("public class ");
                                 ast_buffer.Put(classname);
                                 ast_buffer.Put(" extends ");
                                 ast_buffer.Put(option -> ast_type);
                                 ast_buffer.Put(" implements I");
                                 ast_buffer.Put(classname);
                                 ast_buffer.Put("\n");
    ast_buffer.Put(indentation); ast_buffer.Put("{\n");

    ast_buffer.Put(indentation); ast_buffer.Put("    public ");
                                 ast_buffer.Put(classname);
                                 ast_buffer.Put("(IToken token) { super(token); }\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    public IToken getIToken() { return leftIToken; }\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    public String toString() { return leftIToken.toString(); }\n\n");

    ClassnameElement element; // generate a temporary element with no symbols in its symbol set.
    element.real_name = (char *) classname;
    BitSet optimizable_symbol_set(element.symbol_set.Size(), BitSet::UNIVERSE);

    if (option -> parent_saved)
    {
        ast_buffer.Put(indentation); ast_buffer.Put("    /**\n");
        ast_buffer.Put(indentation); ast_buffer.Put("     * A token class has no children. So, we return the empty list.\n");
        ast_buffer.Put(indentation); ast_buffer.Put("     */\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    public java.util.ArrayList getAllChildren() { return new java.util.ArrayList(); }\n\n");
    }

    ast_buffer.Put(indentation); ast_buffer.Put("    public boolean equals(Object o)\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    {\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        if (o == this) return true;\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        if (! (o instanceof ");
                                 ast_buffer.Put(classname);
                                 ast_buffer.Put(")) return false;\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        ");
                                 ast_buffer.Put(classname);
                                 ast_buffer.Put(" other = (");
                                 ast_buffer.Put(classname);
                                 ast_buffer.Put(") o;\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        return toString().equals(other.toString());\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    }\n\n");

    ast_buffer.Put(indentation); ast_buffer.Put("    public int hashCode()\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    {\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        return toString().hashCode();\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    }\n");

    //
    // TODO: REMOVE THIS ... no longer needed.
    //
    // GenerateHashcodeMethod(ntc, ast_buffer, indentation, element, optimizable_symbol_set);
    GenerateVisitorMethods(ntc, ast_buffer, indentation, element, optimizable_symbol_set);

    ast_buffer.Put(indentation); ast_buffer.Put("}\n\n");

    return;
}


//
//
//
void JavaAction::GenerateCommentHeader(TextBuffer &ast_buffer,
                                       const char *indentation,
                                       ClassnameElement &element)
{
    const char *rule_info = " *<li>Rule $rule_number:  $rule_text",
               *ungenerated_rule_info = " *<li>Rule $rule_number:  $rule_text";
    ast_buffer.Put(indentation); ast_buffer.Put("/**");
    if (element.ungenerated_rule.Length() > 0)
    {
        ast_buffer.Put("\n");
        ast_buffer.Put(indentation);
        ast_buffer.Put(" *<em>");
        for (int i = 0; i < element.ungenerated_rule.Length(); i++)
        {
            int rule_no = element.ungenerated_rule[i];
            ast_buffer.Put("\n");
            ast_buffer.Put(indentation);
            ProcessActionLine(ActionBlockElement::BODY,
                              &ast_buffer,
                              option -> DefaultBlock() -> ActionfileSymbol() -> Name(),
                              ungenerated_rule_info,
                              &ungenerated_rule_info[strlen(ungenerated_rule_info)],
                              0,
                              rule_no);
        }
        ast_buffer.Put("\n");
        ast_buffer.Put(indentation);
        ast_buffer.Put(" *</em>\n");
        ast_buffer.Put(indentation);
        ast_buffer.Put(" *<p>");
    }
    ast_buffer.Put("\n");
    ast_buffer.Put(indentation);
    ast_buffer.Put(" *<b>");
    for (int i = 0; i < element.rule.Length(); i++)
    {
        int rule_no = element.rule[i];
        ast_buffer.Put("\n");
        ast_buffer.Put(indentation);
        ProcessActionLine(ActionBlockElement::BODY,
                          &ast_buffer,
                          option -> DefaultBlock() -> ActionfileSymbol() -> Name(),
                          rule_info,
                          &rule_info[strlen(rule_info)],
                          0,
                          rule_no);
    }

    ast_buffer.Put("\n");
    ast_buffer.Put(indentation);
    ast_buffer.Put(" *</b>\n");
    ast_buffer.Put(indentation);
    ast_buffer.Put(" */\n");
}


//
//
//
void JavaAction::GenerateListClass(CTC &ctc,
                                   NTC &ntc,
                                   TextBuffer &ast_buffer,
                                   const char *indentation,
                                   ClassnameElement &element,
                                   Array<const char *> &typestring)
{
    Tuple<int> &interface = element.interface;
    assert(element.array_element_type_symbol != NULL);
    const char *classname = element.real_name,
               *element_name = element.array_element_type_symbol -> Name(),
               *element_type = ctc.FindBestTypeFor(element.array_element_type_symbol -> SymbolIndex());

    GenerateCommentHeader(ast_buffer, indentation, element);

    ast_buffer.Put(indentation); ast_buffer.Put(option -> automatic_ast == Option::NESTED ? "static " : "");
                                 ast_buffer.Put("public class ");
                                 ast_buffer.Put(classname);
                                 ast_buffer.Put(" extends ");
                                 ast_buffer.Put(option -> ast_type);
                                 ast_buffer.Put("List implements ");
    for (int i = 0; i < interface.Length() - 1; i++)
    {
        ast_buffer.Put(typestring[element.interface[i]]);
        ast_buffer.Put(", ");
    }
    ast_buffer.Put(typestring[element.interface[interface.Length() - 1]]);
    ast_buffer.Put("\n");
    ast_buffer.Put(indentation); ast_buffer.Put("{\n");

    if (element.needs_environment)
        GenerateEnvironmentDeclaration(ast_buffer, indentation);

    if (ntc.CanProduceNullAst(element.array_element_type_symbol -> SymbolIndex()))
    {
        ast_buffer.Put(indentation); ast_buffer.Put("    /**\n");
        ast_buffer.Put(indentation); ast_buffer.Put("     * The value returned by <b>get");
                                     ast_buffer.Put(element_name);
                                     ast_buffer.Put("At</b> may be <b>null</b>\n");
        ast_buffer.Put(indentation); ast_buffer.Put("     */\n");
    }
    ast_buffer.Put(indentation); ast_buffer.Put("    public ");
                                 ast_buffer.Put(element_type);
                                 ast_buffer.Put(" get");
                                 ast_buffer.Put(element_name);
                                 ast_buffer.Put("At(int i) { return (");
                                 ast_buffer.Put(element_type);
                                 ast_buffer.Put(") getElementAt(i); }\n\n");

    //
    // generate constructors
    //
    ast_buffer.Put(indentation); ast_buffer.Put("    public ");
                                 ast_buffer.Put(classname);
                                 ast_buffer.Put("(");
                                 if (element.needs_environment)
                                 {
                                     ast_buffer.Put(option -> action_type);
                                     ast_buffer.Put(" environment, ");
                                 }
                                 ast_buffer.Put("IToken leftIToken, IToken rightIToken, boolean leftRecursive)\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    {\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        super(leftIToken, rightIToken, leftRecursive);\n");
    if (element.needs_environment)
    {
        ast_buffer.Put(indentation);
        ast_buffer.Put("        this.environment = environment;\n");
    }
    ast_buffer.Put(indentation); ast_buffer.Put("        initialize();\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    }\n\n");

    ast_buffer.Put(indentation); ast_buffer.Put("    public ");
                                 ast_buffer.Put(classname);
                                 ast_buffer.Put("(");
                                 if (element.needs_environment)
                                 {
                                     ast_buffer.Put(option -> action_type);
                                     ast_buffer.Put(" environment, ");
                                 }
                                 ast_buffer.Put(element_type);
                                 ast_buffer.Put(" _");
                                 ast_buffer.Put(element_name);
                                 ast_buffer.Put(", boolean leftRecursive)\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    {\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        super((");
                                 ast_buffer.Put(option -> ast_type);
                                 ast_buffer.Put(") _");
                                 ast_buffer.Put(element_name);
                                 ast_buffer.Put(", leftRecursive);\n");
    if (option -> parent_saved)
    {
        ast_buffer.Put(indentation); ast_buffer.Put("        ");
        if (ntc.CanProduceNullAst(element.array_element_type_symbol -> SymbolIndex()))
        {
            ast_buffer.Put("if (_");
            ast_buffer.Put(element_name);
            ast_buffer.Put(" != null) ");
        }
        ast_buffer.Put("((");
        ast_buffer.Put(option -> ast_type);
        ast_buffer.Put(") _");
        ast_buffer.Put(element_name);
        ast_buffer.Put(").setParent(this);\n");
    }
    if (element.needs_environment)
    {
        ast_buffer.Put(indentation);
        ast_buffer.Put("        this.environment = environment;\n");
    }
    ast_buffer.Put(indentation); ast_buffer.Put("        initialize();\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    }\n");
    ast_buffer.Put("\n");

    ast_buffer.Put(indentation); ast_buffer.Put("    public ");
                                 ast_buffer.Put("void add(");
                                 ast_buffer.Put(element_type);
                                 ast_buffer.Put(" _");
                                 ast_buffer.Put(element_name);
                                 ast_buffer.Put(")\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    {\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        super.add((");
                                 ast_buffer.Put(option -> ast_type);
                                 ast_buffer.Put(") _");
                                 ast_buffer.Put(element_name);
                                 ast_buffer.Put(");\n");
    if (option -> parent_saved)
    {
        ast_buffer.Put(indentation); ast_buffer.Put("        ");
        if (ntc.CanProduceNullAst(element.array_element_type_symbol -> SymbolIndex()))
        {
            ast_buffer.Put("if (_");
            ast_buffer.Put(element_name);
            ast_buffer.Put(" != null) ");
        }
        ast_buffer.Put("((");
        ast_buffer.Put(option -> ast_type);
        ast_buffer.Put(") _");
        ast_buffer.Put(element_name);
        ast_buffer.Put(").setParent(this);\n");
    }
    ast_buffer.Put(indentation); ast_buffer.Put("    }\n");

    //
    // Generate the "equals" method
    //
    //
    // TODO: REMOVE THIS ... no longer needed.
    //
    /*
    ast_buffer.Put("\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    public boolean equals(Object o)\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    {\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        if (o == this) return true;\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        if (! (o instanceof ");
                                 ast_buffer.Put(classname);
                                 ast_buffer.Put(")) return false;\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        ");
                                 ast_buffer.Put(classname);
                                 ast_buffer.Put(" other = (");
                                 ast_buffer.Put(classname);
    ast_buffer.Put(indentation); ast_buffer.Put(") o;\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        if (size() != other.size()) return false;\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        for (int i = 0; i < size(); i++)\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        {\n");
    ast_buffer.Put(indentation); ast_buffer.Put("            ");
    char *element_typename = ctc.FindUniqueTypeFor(element.array_element_type_symbol -> SymbolIndex());
    if (element_typename != NULL)
         ast_buffer.Put(element_typename);
    else ast_buffer.Put(typestring[element.array_element_type_symbol -> SymbolIndex()]);
    ast_buffer.Put(" element = get");
    ast_buffer.Put(element_name);
    ast_buffer.Put("At(i);\n");
    ast_buffer.Put(indentation); ast_buffer.Put("            ");
    if (ntc.CanProduceNullAst(element.array_element_type_symbol -> SymbolIndex()))
    {
        ast_buffer.Put("if (element == null && other.get");
                                     ast_buffer.Put(element_name);
                                     ast_buffer.Put("At(i) != null) return false;\n");
        ast_buffer.Put(indentation); ast_buffer.Put("            else ");
    }
    ast_buffer.Put(indentation); ast_buffer.Put("if (! element.equals(other.get");
                                 ast_buffer.Put(element_name);
                                 ast_buffer.Put("At(i))) return false;\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        }\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        return true;\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    }\n");

    //
    // Generate the "hashCode" method
    //
    ast_buffer.Put("\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    public int hashCode()\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    {\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        int hash = 7;\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        for (int i = 0; i < size(); i++)\n");
    ast_buffer.Put(indentation); ast_buffer.Put("            hash = hash * 31 + (get");
                                 ast_buffer.Put(element_name);
    if (ntc.CanProduceNullAst(element.array_element_type_symbol -> SymbolIndex()))
    {
        ast_buffer.Put("At(i) == null ? 0 : get");
        ast_buffer.Put(element_name);
    }
    ast_buffer.Put("At(i).hashCode());\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        return hash;\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    }\n");
    */

    //
    // Generate visitor methods.
    //
    if (option -> visitor == Option::DEFAULT)
    {
        ast_buffer.Put("\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    public void accept(");
                                     ast_buffer.Put(option -> visitor_type);
        if (ctc.FindUniqueTypeFor(element.array_element_type_symbol -> SymbolIndex()) != NULL)
        {
            ast_buffer.Put(" v) { for (int i = 0; i < size(); i++) v.visit"
                           "("
                           "get");
            ast_buffer.Put(element_name);
            ast_buffer.Put("At(i)"
                           "); }\n");
        }
        else
        {
            ast_buffer.Put(" v) { for (int i = 0; i < size(); i++) get");
            ast_buffer.Put(element_name);
            ast_buffer.Put("At(i).accept(v); }\n");
        }

        ast_buffer.Put(indentation); ast_buffer.Put("    public void accept(Argument");
                                     ast_buffer.Put(option -> visitor_type);
        if (ctc.FindUniqueTypeFor(element.array_element_type_symbol -> SymbolIndex()) != NULL)
        {
            ast_buffer.Put(" v, Object o) { for (int i = 0; i < size(); i++) v.visit"
                           "("
                           "get");
            ast_buffer.Put(element_name);
            ast_buffer.Put("At(i), o");
            ast_buffer.Put("); }\n");
        }
        else
        {
            ast_buffer.Put(" v, Object o) { for (int i = 0; i < size(); i++) get");
            ast_buffer.Put(element_name);
            ast_buffer.Put("At(i).accept(v, o); }\n");
        }

        //
        // Code cannot be generated to automatically visit a node that
        // can return a value. These cases are left up to the user.
        //
        ast_buffer.Put(indentation); ast_buffer.Put("    public Object accept(Result");
                                     ast_buffer.Put(option -> visitor_type);
        if (ctc.FindUniqueTypeFor(element.array_element_type_symbol -> SymbolIndex()) != NULL)
        {
                                         ast_buffer.Put(" v)\n");
            ast_buffer.Put(indentation); ast_buffer.Put("    {\n");
            ast_buffer.Put(indentation); ast_buffer.Put("        java.util.ArrayList result = new java.util.ArrayList();\n");
            ast_buffer.Put(indentation); ast_buffer.Put("        for (int i = 0; i < size(); i++)\n");
            ast_buffer.Put(indentation); ast_buffer.Put("            result.add(v.visit(get");
                                         ast_buffer.Put(element_name);
                                         ast_buffer.Put("At(i)));\n");
            ast_buffer.Put(indentation); ast_buffer.Put("        return result;\n");
            ast_buffer.Put(indentation); ast_buffer.Put("    }\n");
        }
        else
        {
                                         ast_buffer.Put(" v)\n");
            ast_buffer.Put(indentation); ast_buffer.Put("    {\n");
            ast_buffer.Put(indentation); ast_buffer.Put("        java.util.ArrayList result = new java.util.ArrayList();\n");
            ast_buffer.Put(indentation); ast_buffer.Put("        for (int i = 0; i < size(); i++)\n");
            ast_buffer.Put(indentation); ast_buffer.Put("            result.add(get");
                                         ast_buffer.Put(element_name);
                                         ast_buffer.Put("At(i).accept(v));\n");
            ast_buffer.Put(indentation); ast_buffer.Put("        return result;\n");
            ast_buffer.Put(indentation); ast_buffer.Put("    }\n");
        }

        ast_buffer.Put(indentation); ast_buffer.Put("    public Object accept(ResultArgument");
                                     ast_buffer.Put(option -> visitor_type);
        if (ctc.FindUniqueTypeFor(element.array_element_type_symbol -> SymbolIndex()) != NULL)
        {
                                         ast_buffer.Put(" v, Object o)\n");
            ast_buffer.Put(indentation); ast_buffer.Put("    {\n");
            ast_buffer.Put(indentation); ast_buffer.Put("        java.util.ArrayList result = new java.util.ArrayList();\n");
            ast_buffer.Put(indentation); ast_buffer.Put("        for (int i = 0; i < size(); i++)\n");
            ast_buffer.Put(indentation); ast_buffer.Put("            result.add(v.visit(get");
                                         ast_buffer.Put(element_name);
                                         ast_buffer.Put("At(i), o));\n");
            ast_buffer.Put(indentation); ast_buffer.Put("        return result;\n");
            ast_buffer.Put(indentation); ast_buffer.Put("    }\n");
        }
        else
        {
                                         ast_buffer.Put(" v, Object o)\n");
            ast_buffer.Put(indentation); ast_buffer.Put("    {\n");
            ast_buffer.Put(indentation); ast_buffer.Put("        java.util.ArrayList result = new java.util.ArrayList();\n");
            ast_buffer.Put(indentation); ast_buffer.Put("        for (int i = 0; i < size(); i++)\n");
            ast_buffer.Put(indentation); ast_buffer.Put("            result.add(get");
                                         ast_buffer.Put(element_name);
                                         ast_buffer.Put("At(i).accept(v, o));\n");
            ast_buffer.Put(indentation); ast_buffer.Put("        return result;\n");
            ast_buffer.Put(indentation); ast_buffer.Put("    }\n");
        }
    }
    else if (option -> visitor == Option::PREORDER)
    {
        ast_buffer.Put("\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    public void accept(");
                                     ast_buffer.Put(option -> visitor_type);
                                     ast_buffer.Put(" v)\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    {\n");
        ast_buffer.Put(indentation); ast_buffer.Put("        if (! v.preVisit(this)) return;\n");
        ast_buffer.Put(indentation); ast_buffer.Put("        enter(v);\n");
        ast_buffer.Put(indentation); ast_buffer.Put("        v.postVisit(this);\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    }\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    public void enter(");
                                     ast_buffer.Put(option -> visitor_type);
                                     ast_buffer.Put(" v)\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    {\n");
        ast_buffer.Put(indentation); ast_buffer.Put("        boolean checkChildren = v.visit(this);\n");
        ast_buffer.Put(indentation); ast_buffer.Put("        if (checkChildren)\n");
        ast_buffer.Put(indentation); ast_buffer.Put("        {\n");
        ast_buffer.Put(indentation); ast_buffer.Put("            for (int i = 0; i < size(); i++)\n");
        ast_buffer.Put(indentation); ast_buffer.Put("            {\n");
        ast_buffer.Put(indentation); ast_buffer.Put("                ");

        char *element_typename = ctc.FindUniqueTypeFor(element.array_element_type_symbol -> SymbolIndex());
        if (element_typename != NULL)
        {
            ast_buffer.Put(element_typename);
            ast_buffer.Put(" element = get");
            ast_buffer.Put(element_name);
            ast_buffer.Put("At(i);\n");
            if (ntc.CanProduceNullAst(element.array_element_type_symbol -> SymbolIndex()))
            {
                ast_buffer.Put(indentation); ast_buffer.Put("                if (element != null)");
                ast_buffer.Put(indentation); ast_buffer.Put("                {\n");
                ast_buffer.Put(indentation); ast_buffer.Put("                    if (! v.preVisit(element)) continue;\n");
                ast_buffer.Put(indentation); ast_buffer.Put("                    element.enter(v);\n");
                ast_buffer.Put(indentation); ast_buffer.Put("                    v.postVisit(element);\n");
                ast_buffer.Put(indentation); ast_buffer.Put("                }\n");
            }
            else
            {
                ast_buffer.Put(indentation); ast_buffer.Put("                if (! v.preVisit(element)) continue;\n");
                ast_buffer.Put(indentation); ast_buffer.Put("                element.enter(v);\n");
                ast_buffer.Put(indentation); ast_buffer.Put("                v.postVisit(element);\n");
            }
        }
        else
        {
            ast_buffer.Put(typestring[element.array_element_type_symbol -> SymbolIndex()]);
            ast_buffer.Put(" element = get");
            ast_buffer.Put(element_name);
            ast_buffer.Put("At(i);\n");
            ast_buffer.Put(indentation); ast_buffer.Put("                ");
            if (ntc.CanProduceNullAst(element.array_element_type_symbol -> SymbolIndex()))
                ast_buffer.Put("if (element != null) ");
            ast_buffer.Put("element.accept(v);\n");
        }
        ast_buffer.Put(indentation); ast_buffer.Put("            }\n");
        ast_buffer.Put(indentation); ast_buffer.Put("        }\n");
        ast_buffer.Put(indentation); ast_buffer.Put("        v.endVisit(this);\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    }\n");
    }

    return;
}


//
// Generate a generic rule class
//
void JavaAction::GenerateRuleClass(CTC &ctc,
                                   NTC &ntc,
                                   TextBuffer &ast_buffer,
                                   const char *indentation,
                                   ClassnameElement &element,
                                   Array<const char *> &typestring)
{
    char *classname = element.real_name;
    SymbolLookupTable &symbol_set = element.symbol_set;
    Tuple<int> &rhs_type_index = element.rhs_type_index;

    BitSet optimizable_symbol_set(element.symbol_set.Size(), BitSet::UNIVERSE);

    GenerateCommentHeader(ast_buffer, indentation, element);

    assert(element.rule.Length() == 1);
    int rule_no = element.rule[0];

    ast_buffer.Put(indentation); ast_buffer.Put(option -> automatic_ast == Option::NESTED ? "static " : "");
                                 ast_buffer.Put("public class ");
                                 ast_buffer.Put(classname);
                                 ast_buffer.Put(" extends ");
    if (element.is_terminal_class)
    {
        ast_buffer.Put(grammar -> Get_ast_token_classname());
        ast_buffer.Put(" implements ");
        ast_buffer.Put(typestring[grammar -> rules[rule_no].lhs]);
        ast_buffer.Put("\n");
        ast_buffer.Put(indentation); ast_buffer.Put("{\n");
        if (element.needs_environment)
            GenerateEnvironmentDeclaration(ast_buffer, indentation);
        if (symbol_set.Size() == 1) // if the right-hand side contains a symbol ...
        {
            ast_buffer.Put(indentation); ast_buffer.Put("    public IToken get");
                                         ast_buffer.Put(symbol_set[0] -> Name());
                                         ast_buffer.Put("() { return leftIToken; }\n\n");
        }
        ast_buffer.Put(indentation); ast_buffer.Put("    public ");
                                     ast_buffer.Put(classname);
                                     ast_buffer.Put("(");
        if (element.needs_environment)
        {
            ast_buffer.Put(option -> action_type);
            ast_buffer.Put(" environment, IToken token)");
            ast_buffer.Put(indentation); ast_buffer.Put("    {\n");
            ast_buffer.Put(indentation); ast_buffer.Put("        super(token);\n");
            ast_buffer.Put(indentation); ast_buffer.Put("        this.environment = environment;\n");
            ast_buffer.Put(indentation); ast_buffer.Put("        initialize();\n");
            ast_buffer.Put(indentation); ast_buffer.Put("    }\n");
        }
        else ast_buffer.Put("IToken token) { super(token); initialize(); }\n");
    }
    else 
    {
        ast_buffer.Put(option -> ast_type);
        ast_buffer.Put(" implements ");
        ast_buffer.Put(typestring[grammar -> rules[rule_no].lhs]);
        ast_buffer.Put("\n");
        ast_buffer.Put(indentation); ast_buffer.Put("{\n");
        if (element.needs_environment)
            GenerateEnvironmentDeclaration(ast_buffer, indentation);

        if (symbol_set.Size() > 0)
        {
            {
                for (int i = 0; i < symbol_set.Size(); i++)
                {
                    ast_buffer.Put(indentation); ast_buffer.Put("    private ");
                                                 ast_buffer.Put(ctc.FindBestTypeFor(rhs_type_index[i]));
                                                 ast_buffer.Put(" _");
                                                 ast_buffer.Put(symbol_set[i] -> Name());
                                                 ast_buffer.Put(";\n");
                }
            }
            ast_buffer.Put("\n");

            for (int i = 0; i < symbol_set.Size(); i++)
            {
                if (ntc.CanProduceNullAst(rhs_type_index[i]))
                {
                    ast_buffer.Put(indentation); ast_buffer.Put("    /**\n");
                    ast_buffer.Put(indentation); ast_buffer.Put("     * The value returned by <b>get");
                                                 ast_buffer.Put(symbol_set[i] -> Name());
                                                 ast_buffer.Put("</b> may be <b>null</b>\n");
                    ast_buffer.Put(indentation); ast_buffer.Put("     */\n");
                }

                ast_buffer.Put(indentation); ast_buffer.Put("    public ");
                                             ast_buffer.Put(ctc.FindBestTypeFor(rhs_type_index[i]));
                                             ast_buffer.Put(" get");
                                             ast_buffer.Put(symbol_set[i] -> Name());
                                             ast_buffer.Put("() { return _");
                                             ast_buffer.Put(symbol_set[i] -> Name());
                                             ast_buffer.Put("; }\n");
            }
            ast_buffer.Put("\n");
        }

        //
        // generate constructor
        //
        const char *header = "    public ";
        ast_buffer.Put(indentation);
        ast_buffer.Put(header);
        ast_buffer.Put(classname);
        int length = strlen(indentation) + strlen(header) + strlen(classname);

        ast_buffer.Put("(");
        if (element.needs_environment)
        {
            ast_buffer.Put(option -> action_type);
            ast_buffer.Put(" environment, ");
        }
        ast_buffer.Put("IToken leftIToken, IToken rightIToken");
        ast_buffer.Put(symbol_set.Size() == 0 ? ")\n" : ",\n");
        {
            for (int i = 0; i < symbol_set.Size(); i++)
            {
                for (int k = 0; k <= length; k++)
                    ast_buffer.PutChar(' ');
                ast_buffer.Put(ctc.FindBestTypeFor(rhs_type_index[i]));
                ast_buffer.Put(" _");
                ast_buffer.Put(symbol_set[i] -> Name());
                ast_buffer.Put(i == symbol_set.Size() - 1 ? ")\n" : ",\n");
            }
        }
        ast_buffer.Put(indentation); ast_buffer.Put("    {\n");
        ast_buffer.Put(indentation); ast_buffer.Put("        super(leftIToken, rightIToken);\n\n");
        if (element.needs_environment)
        {
            ast_buffer.Put(indentation);
            ast_buffer.Put("        this.environment = environment;\n");
        }
        for (int i = 0; i < symbol_set.Size(); i++)
        {
            ast_buffer.Put(indentation); ast_buffer.Put("        this._");
                                         ast_buffer.Put(symbol_set[i] -> Name());
                                         ast_buffer.Put(" = _");
                                         ast_buffer.Put(symbol_set[i] -> Name());
                                         ast_buffer.Put(";\n");

            if (option -> parent_saved)
            {
                ast_buffer.Put(indentation); ast_buffer.Put("        ");
                if ((! optimizable_symbol_set[i]) || ntc.CanProduceNullAst(rhs_type_index[i]))
                {
                    ast_buffer.Put("if (_");
                    ast_buffer.Put(symbol_set[i] -> Name());
                    ast_buffer.Put(" != null) ");
                }

                ast_buffer.Put("((");
                ast_buffer.Put(option -> ast_type);
                ast_buffer.Put(") _");
                ast_buffer.Put(symbol_set[i] -> Name());
                ast_buffer.Put(").setParent(this);\n");
            }
        }

        ast_buffer.Put(indentation); ast_buffer.Put("        initialize();\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    }\n");
    }

    if (option -> parent_saved)
        GenerateGetAllChildrenMethod(ast_buffer, indentation, element);
    GenerateEqualsMethod(ntc, ast_buffer, indentation, element, optimizable_symbol_set);
    GenerateHashcodeMethod(ntc, ast_buffer, indentation, element, optimizable_symbol_set);
    GenerateVisitorMethods(ntc, ast_buffer, indentation, element, optimizable_symbol_set);

    return;
}


//
// Generate Ast class
//
void JavaAction::GenerateTerminalMergedClass(NTC &ntc, 
                                             TextBuffer &ast_buffer,
                                             const char *indentation,
                                             ClassnameElement &element,
                                             Array<const char *> &typestring)
{
    char *classname = element.real_name;
    GenerateCommentHeader(ast_buffer, indentation, element);

    ast_buffer.Put(indentation); ast_buffer.Put(option -> automatic_ast == Option::NESTED ? "static " : "");
                                 ast_buffer.Put("public class ");
                                 ast_buffer.Put(classname);
                                 ast_buffer.Put(" extends ");
                                 ast_buffer.Put(grammar -> Get_ast_token_classname());
                                 ast_buffer.Put(" implements ");
    for (int i = 0; i < element.interface.Length() - 1; i++)
    {
        ast_buffer.Put(typestring[element.interface[i]]);
        ast_buffer.Put(", ");
    }
    ast_buffer.Put(typestring[element.interface[element.interface.Length() - 1]]);
    ast_buffer.Put("\n");
    ast_buffer.Put(indentation); ast_buffer.Put("{\n");
    if (element.needs_environment)
        GenerateEnvironmentDeclaration(ast_buffer, indentation);
    SymbolLookupTable &symbol_set = element.symbol_set;
    if (symbol_set.Size() == 1) // if the right-hand side contains a symbol ...
    {
        ast_buffer.Put(indentation); ast_buffer.Put("    public IToken get");
                                     ast_buffer.Put(symbol_set[0] -> Name());
                                     ast_buffer.Put("() { return leftIToken; }\n\n");
    }
    ast_buffer.Put(indentation); ast_buffer.Put("    public ");
                                 ast_buffer.Put(classname);
                                 ast_buffer.Put("(");
                                 if (element.needs_environment)
                                 {
                                     ast_buffer.Put(option -> action_type);
                                     ast_buffer.Put(" environment, IToken token)");
                                     ast_buffer.Put(indentation); ast_buffer.Put("    {\n");
                                     ast_buffer.Put(indentation); ast_buffer.Put("        super(token);\n");
                                     ast_buffer.Put(indentation); ast_buffer.Put("        this.environment = environment;\n");
                                     ast_buffer.Put(indentation); ast_buffer.Put("        initialize();\n");
                                     ast_buffer.Put(indentation); ast_buffer.Put("    }\n");
                                 }
                                 else ast_buffer.Put("IToken token) { super(token); initialize(); }\n");

    BitSet optimizable_symbol_set(element.symbol_set.Size(), BitSet::UNIVERSE);
    GenerateHashcodeMethod(ntc, ast_buffer, indentation, element, optimizable_symbol_set);
    GenerateVisitorMethods(ntc, ast_buffer, indentation, element, optimizable_symbol_set);

    return;
}


//
// Generate Ast class
//
void JavaAction::GenerateMergedClass(CTC &ctc,
                                     NTC &ntc,
                                     TextBuffer &ast_buffer,
                                     const char *indentation,
                                     ClassnameElement &element,
                                     Tuple< Tuple<ProcessedRuleElement> > &processed_rule_map,
                                     Array<const char *> &typestring)
{
    char *classname = element.real_name;
    SymbolLookupTable &symbol_set = element.symbol_set;
    Tuple<int> &rhs_type_index = element.rhs_type_index;

    GenerateCommentHeader(ast_buffer, indentation, element);

    ast_buffer.Put(indentation); ast_buffer.Put(option -> automatic_ast == Option::NESTED ? "static " : "");
                                 ast_buffer.Put("public class ");
                                 ast_buffer.Put(classname);
                                 ast_buffer.Put(" extends ");
                                 ast_buffer.Put(option -> ast_type);
                                 ast_buffer.Put(" implements ");
    {
        for (int i = 0; i < element.interface.Length() - 1; i++)
        {
            ast_buffer.Put(typestring[element.interface[i]]);
            ast_buffer.Put(", ");
        }
    }
    ast_buffer.Put(typestring[element.interface[element.interface.Length() - 1]]);
    ast_buffer.Put("\n");
    ast_buffer.Put(indentation); ast_buffer.Put("{\n");
    if (element.needs_environment)
        GenerateEnvironmentDeclaration(ast_buffer, indentation);
    {
        for (int i = 0; i < symbol_set.Size(); i++)
        {
            ast_buffer.Put(indentation); ast_buffer.Put("    private ");
                                         ast_buffer.Put(ctc.FindBestTypeFor(rhs_type_index[i]));
                                         ast_buffer.Put(" _");
                                         ast_buffer.Put(symbol_set[i] -> Name());
                                         ast_buffer.Put(";\n");
        }
    }
    ast_buffer.Put("\n");

    //
    // Compute the set of symbols that always appear in an instance creation
    // of this merged class for which a null instance allocation will never occur.
    //
    BitSet optimizable_symbol_set(element.symbol_set.Size(), BitSet::UNIVERSE);
    Tuple<int> &rule = element.rule;
    {
        for (int i = 0; i < rule.Length(); i++)
        {
            int rule_no = rule[i];
            Tuple<ProcessedRuleElement> &processed_rule_elements = processed_rule_map[rule_no];
            for (int k = 0; k < processed_rule_elements.Length(); k++)
            {
                if (processed_rule_elements[k].position == 0 ||
                    ntc.CanProduceNullAst(grammar -> rhs_sym[processed_rule_elements[k].position]))
                     optimizable_symbol_set.RemoveElement(k);
            }
        }
    }

    {
        for (int i = 0; i < symbol_set.Size(); i++)
        {
            if ((! optimizable_symbol_set[i]) || ntc.CanProduceNullAst(rhs_type_index[i]))
            {
                ast_buffer.Put(indentation); ast_buffer.Put("    /**\n");
                ast_buffer.Put(indentation); ast_buffer.Put("     * The value returned by <b>get");
                                             ast_buffer.Put(symbol_set[i] -> Name());
                                             ast_buffer.Put("</b> may be <b>null</b>\n");
                ast_buffer.Put(indentation); ast_buffer.Put("     */\n");
            }

            ast_buffer.Put(indentation); ast_buffer.Put("    public ");
                                         ast_buffer.Put(ctc.FindBestTypeFor(rhs_type_index[i]));
                                         ast_buffer.Put(" get");
                                         ast_buffer.Put(symbol_set[i] -> Name());
                                         ast_buffer.Put("() { return _");
                                         ast_buffer.Put(symbol_set[i] -> Name());
                                         ast_buffer.Put("; }\n");
        }
    }
    ast_buffer.Put("\n");


    //
    // generate merged constructor
    //
    const char *header = "    public ";
    ast_buffer.Put(indentation);
    ast_buffer.Put(header);
    ast_buffer.Put(classname);
    int length = strlen(indentation) + strlen(header) + strlen(classname);

    ast_buffer.Put("(");
    if (element.needs_environment)
    {
        ast_buffer.Put(option -> action_type);
        ast_buffer.Put(" environment, ");
    }
    ast_buffer.Put("IToken leftIToken, IToken rightIToken");
    ast_buffer.Put(symbol_set.Size() == 0 ? ")\n" : ",\n");
    {
        for (int i = 0; i < symbol_set.Size(); i++)
        {
            for (int k = 0; k <= length; k++)
                ast_buffer.PutChar(' ');
            ast_buffer.Put(ctc.FindBestTypeFor(rhs_type_index[i]));
            ast_buffer.Put(" _");
            ast_buffer.Put(symbol_set[i] -> Name());
            ast_buffer.Put(i == symbol_set.Size() - 1 ? ")\n" : ",\n");
        }
    }
    ast_buffer.Put(indentation); ast_buffer.Put("    {\n");
    ast_buffer.Put(indentation); ast_buffer.Put("        super(leftIToken, rightIToken);\n\n");
    if (element.needs_environment)
    {
        ast_buffer.Put(indentation);
        ast_buffer.Put("        this.environment = environment;\n");
    }
    for (int i = 0; i < symbol_set.Size(); i++)
    {
        ast_buffer.Put(indentation); ast_buffer.Put("        this._");
                                     ast_buffer.Put(symbol_set[i] -> Name());
                                     ast_buffer.Put(" = _");
                                     ast_buffer.Put(symbol_set[i] -> Name());
                                     ast_buffer.Put(";\n");

        if (option -> parent_saved)
        {
            ast_buffer.Put(indentation); ast_buffer.Put("        ");
            if ((! optimizable_symbol_set[i]) || ntc.CanProduceNullAst(rhs_type_index[i]))
            {
                ast_buffer.Put("if (_");
                ast_buffer.Put(symbol_set[i] -> Name());
                ast_buffer.Put(" != null) ");
            }

            ast_buffer.Put("((");
            ast_buffer.Put(option -> ast_type);
            ast_buffer.Put(") _");
            ast_buffer.Put(symbol_set[i] -> Name());
            ast_buffer.Put(").setParent(this);\n");
        }
    }

    ast_buffer.Put(indentation); ast_buffer.Put("        initialize();\n");
    ast_buffer.Put(indentation); ast_buffer.Put("    }\n");

    if (option -> parent_saved)
        GenerateGetAllChildrenMethod(ast_buffer, indentation, element);
    GenerateEqualsMethod(ntc, ast_buffer, indentation, element, optimizable_symbol_set);
    GenerateHashcodeMethod(ntc, ast_buffer, indentation, element, optimizable_symbol_set);
    GenerateVisitorMethods(ntc, ast_buffer, indentation, element, optimizable_symbol_set);

    return;
}


void JavaAction::GenerateInterface(bool is_terminal,
                                   TextBuffer &ast_buffer,
                                   const char *indentation,
                                   const char *interface_name,
                                   Tuple<int> &extension,
                                   Tuple<int> &classes,
                                   Tuple<ClassnameElement> &classname)
{
    ast_buffer.Put(indentation); ast_buffer.Put("/**");
    if (is_terminal)
    {
        ast_buffer.Put("\n");
        ast_buffer.Put(indentation);  ast_buffer.Put(" * is always implemented by <b>");
                                      ast_buffer.Put(grammar -> Get_ast_token_classname());
                                      ast_buffer.Put("</b>. It is also implemented by");
    }
    else 
    {
        ast_buffer.Put("\n");
        ast_buffer.Put(indentation);
        ast_buffer.Put(" * is implemented by");
    }

    if (classes.Length() == 1)
    {
        ast_buffer.Put(" <b>");
        ast_buffer.Put(classname[classes[0]].real_name);
        ast_buffer.Put("</b>");
    }
    else
    {
        ast_buffer.Put(":\n");
        ast_buffer.Put(indentation);
        ast_buffer.Put(" *<b>\n");
        ast_buffer.Put(indentation); ast_buffer.Put(" *<ul>");
        for (int i = 0; i < classes.Length(); i++)
        {
            ast_buffer.Put("\n");
            ast_buffer.Put(indentation);
            ast_buffer.Put(" *<li>");
            ast_buffer.Put(classname[classes[i]].real_name);
        }
        ast_buffer.Put("\n");
        ast_buffer.Put(indentation);
        ast_buffer.Put(" *</ul>\n");
        ast_buffer.Put(indentation);
        ast_buffer.Put(" *</b>");
    }

    ast_buffer.Put("\n");
    ast_buffer.Put(indentation);
    ast_buffer.Put(" */\n");

    ast_buffer.Put(indentation); ast_buffer.Put("public interface ");
                                 ast_buffer.Put(interface_name);
    if (extension.Length() > 0)
    {
        ast_buffer.Put(" extends ");
        for (int k = 0; k < extension.Length() - 1; k++)
        {
            ast_buffer.PutChar('I');
            ast_buffer.Put(extension[k] == grammar -> Get_ast_token_interface()
                               ? grammar -> Get_ast_token_classname()
                               : grammar -> RetrieveString(extension[k]));
            ast_buffer.Put(", ");
        }
        ast_buffer.PutChar('I');
        ast_buffer.Put(extension[extension.Length() - 1] == grammar -> Get_ast_token_interface()
                               ? grammar -> Get_ast_token_classname()
                               : grammar -> RetrieveString(extension[extension.Length() - 1]));
        ast_buffer.Put(" {}\n\n");
    }
    else
    {
        ast_buffer.Put("\n");
        ast_buffer.Put(indentation); ast_buffer.Put("{\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    public IToken getLeftIToken();\n");
        ast_buffer.Put(indentation); ast_buffer.Put("    public IToken getRightIToken();\n");
        ast_buffer.Put("\n");
        GenerateVisitorHeaders(ast_buffer, indentation, "    ");
        ast_buffer.Put(indentation); ast_buffer.Put("}\n\n");
    }

    return;
}


//
//
//
void JavaAction::GenerateNullAstAllocation(TextBuffer &ast_buffer, int rule_no)
{
    const char *code = "\n                    setResult(null);";
    GenerateCode(&ast_buffer, code, rule_no);

    return;
}

//
//
//
void JavaAction::GenerateAstAllocation(CTC &ctc,
                                       TextBuffer &ast_buffer,
                                       RuleAllocationElement &allocation_element,
                                       Tuple<ProcessedRuleElement> &processed_rule_elements,
                                       Array<const char *> &typestring,
                                       int rule_no)
{
    char *classname = allocation_element.name;

    // 
    // Copy these two arrays into a local tuple for CONVENIENCE.
    // 
    Tuple<int> position,
               type_index;
    for (int i = 0; i < processed_rule_elements.Length(); i++)
    {
        position.Next() = processed_rule_elements[i].position;
        type_index.Next() = processed_rule_elements[i].type_index;
    }

    // 
    // Convenient constant declarations.
    // 
    const char *space = "\n                    ",
               *space4 = "    ",
               *newkey = option -> factory,
               *lparen = "(",
               *comma = ",",
               *rparen = ")",
               *trailer = ");";
    int extra_space_length = strlen(space) + strlen(space4) + strlen(newkey) + strlen(classname) + 1;
    char *extra_space = new char[extra_space_length + 1];
    extra_space[0] = '\n';
    {
        for (int i = 1; i < extra_space_length; i++)
            extra_space[i] = ' ';
    }
    extra_space[extra_space_length] = '\0';

    //
    // TODO: We simply generate a comment as a reminder that the previous nonterminal
    // allocated for this token should be deleted when using a language such as C/C++
    // that does not have a garbage collector.
    //
    //    if (allocation_element.is_terminal_class && type_index.Length() == 1 && IsNonTerminal(type_index[0]))
    //    {
    //        GenerateCode(&ast_buffer, space, rule_no);
    //        GenerateCode(&ast_buffer, "// When garbage collection is not available, delete ", rule_no);
    //        GenerateCode(&ast_buffer, "getRhsSym(", rule_no);
    //        IntToString index(position[0]);
    //        GenerateCode(&ast_buffer, index.String(), rule_no);
    //        GenerateCode(&ast_buffer, rparen, rule_no);
    //    }
    if (allocation_element.is_terminal_class && (grammar -> RhsSize(rule_no) == 1 && grammar -> IsNonTerminal(grammar -> rhs_sym[grammar -> FirstRhsIndex(rule_no)])))
    {
        GenerateCode(&ast_buffer, space, rule_no);
        GenerateCode(&ast_buffer, "//", rule_no);
        GenerateCode(&ast_buffer, space, rule_no);
        GenerateCode(&ast_buffer, "// When garbage collection is not available, delete ", rule_no);
        GenerateCode(&ast_buffer, "getRhsSym(1)", rule_no);
        GenerateCode(&ast_buffer, space, rule_no);
        GenerateCode(&ast_buffer, "//", rule_no);
    }
    GenerateCode(&ast_buffer, space, rule_no);
    GenerateCode(&ast_buffer, "setResult(", rule_no);
    GenerateCode(&ast_buffer, space, rule_no);
    GenerateCode(&ast_buffer, space4, rule_no);
    GenerateCode(&ast_buffer, newkey, rule_no);
    GenerateCode(&ast_buffer, classname, rule_no);
    GenerateCode(&ast_buffer, lparen, rule_no);
    if (allocation_element.needs_environment)
    {
        GenerateCode(&ast_buffer, option -> action_type, rule_no);
        GenerateCode(&ast_buffer, ".this, ", rule_no);
    }
    if (allocation_element.is_terminal_class)
    {
        GenerateCode(&ast_buffer, "getRhsIToken(1)", rule_no);
        //
        // TODO: Old bad idea. Remove at some point...
        //
        //
        //        assert(position.Length() <= 1);
        //
        //        GenerateCode(&ast_buffer, "getRhsIToken(", rule_no);
        //        IntToString index(position.Length() == 0 ? 1 : position[0]);
        //        GenerateCode(&ast_buffer, index.String(), rule_no);
        //        GenerateCode(&ast_buffer, rparen, rule_no);
    }
    else
    {
        GenerateCode(&ast_buffer, "getLeftIToken()", rule_no);
        GenerateCode(&ast_buffer, ", ", rule_no);
        GenerateCode(&ast_buffer, "getRightIToken()", rule_no);
        if (position.Length() > 0)
        {
            GenerateCode(&ast_buffer, comma, rule_no);
            GenerateCode(&ast_buffer, extra_space, rule_no);
    
            int offset = grammar -> FirstRhsIndex(rule_no) - 1;
            for (int i = 0; i < position.Length(); i++)
            {
                if (position[i] == 0)
                {
                    GenerateCode(&ast_buffer, lparen, rule_no);
                    GenerateCode(&ast_buffer, ctc.FindBestTypeFor(type_index[i]), rule_no);
                    GenerateCode(&ast_buffer, rparen, rule_no);
                    GenerateCode(&ast_buffer, "null", rule_no);
                }
                else
                {
                    int symbol = grammar -> rhs_sym[offset + position[i]];
                    if (grammar -> IsTerminal(symbol))
                    {
                        const char *actual_type = ctc.FindBestTypeFor(type_index[i]);

		        if (strcmp(actual_type, grammar -> Get_ast_token_classname()) != 0)
                        {
                            GenerateCode(&ast_buffer, lparen, rule_no);
                            GenerateCode(&ast_buffer, actual_type, rule_no);
                            GenerateCode(&ast_buffer, rparen, rule_no);
                        }

                        GenerateCode(&ast_buffer, newkey, rule_no);
                        GenerateCode(&ast_buffer, grammar -> Get_ast_token_classname(), rule_no);
                        GenerateCode(&ast_buffer, lparen, rule_no);
                        GenerateCode(&ast_buffer, "getRhsIToken(", rule_no);
                        IntToString index(position[i]);
                        GenerateCode(&ast_buffer, index.String(), rule_no);
                        GenerateCode(&ast_buffer, rparen, rule_no);
                    }
                    else
                    {
                        GenerateCode(&ast_buffer, lparen, rule_no);
                        GenerateCode(&ast_buffer, ctc.FindBestTypeFor(type_index[i]), rule_no);
                        GenerateCode(&ast_buffer, rparen, rule_no);
                        GenerateCode(&ast_buffer, "getRhsSym(", rule_no);
                        IntToString index(position[i]);
                        GenerateCode(&ast_buffer, index.String(), rule_no);
                    }
    
                    GenerateCode(&ast_buffer, rparen, rule_no);
                }
        
                if (i != position.Length() - 1)
                {
                    GenerateCode(&ast_buffer, comma, rule_no);
                    GenerateCode(&ast_buffer, extra_space, rule_no);
                }
            }
        }
    }

    GenerateCode(&ast_buffer, rparen, rule_no);
    GenerateCode(&ast_buffer, space, rule_no);
    GenerateCode(&ast_buffer, trailer, rule_no);

    delete [] extra_space;

    return;
}

//
//
//
void JavaAction::GenerateListAllocation(CTC &ctc,
                                        TextBuffer &ast_buffer,
                                        int rule_no,
                                        RuleAllocationElement &allocation_element)
{
    const char *space = "\n                    ",
               *space4 = "    ",
               *newkey = option -> factory,
               *lparen = "(",
               *comma = ",",
               *rparen = ")",
               *trailer = ");";
    int extra_space_length = strlen(space) + strlen(space4) + strlen(newkey) + strlen(allocation_element.name) + 1;
    char *extra_space = new char[extra_space_length + 1];
    extra_space[0] = '\n';
    for (int i = 1; i < extra_space_length; i++)
        extra_space[i] = ' ';
    extra_space[extra_space_length] = '\0';

    if (allocation_element.list_kind == RuleAllocationElement::LEFT_RECURSIVE_EMPTY ||
        allocation_element.list_kind == RuleAllocationElement::RIGHT_RECURSIVE_EMPTY ||
        allocation_element.list_kind == RuleAllocationElement::LEFT_RECURSIVE_SINGLETON ||
        allocation_element.list_kind == RuleAllocationElement::RIGHT_RECURSIVE_SINGLETON)
    {
        GenerateCode(&ast_buffer, space, rule_no);
        GenerateCode(&ast_buffer, "setResult(", rule_no);
        GenerateCode(&ast_buffer, space, rule_no);
        GenerateCode(&ast_buffer, space4, rule_no);

        GenerateCode(&ast_buffer, newkey, rule_no);
        GenerateCode(&ast_buffer, allocation_element.name, rule_no);
        GenerateCode(&ast_buffer, lparen, rule_no);
        if (allocation_element.needs_environment)
        {
            GenerateCode(&ast_buffer, option -> action_type, rule_no);
            GenerateCode(&ast_buffer, ".this, ", rule_no);
        }
        if (allocation_element.list_kind == RuleAllocationElement::LEFT_RECURSIVE_EMPTY ||
            allocation_element.list_kind == RuleAllocationElement::RIGHT_RECURSIVE_EMPTY)
        {
            GenerateCode(&ast_buffer, "getLeftIToken()", rule_no);
            GenerateCode(&ast_buffer, ", ", rule_no);
            GenerateCode(&ast_buffer, "getRightIToken()", rule_no);
            GenerateCode(&ast_buffer, comma, rule_no);
            if (allocation_element.list_kind == RuleAllocationElement::LEFT_RECURSIVE_EMPTY)
                 GenerateCode(&ast_buffer, " true /* left recursive */", rule_no);
            else GenerateCode(&ast_buffer, " false /* not left recursive */", rule_no);
        }
        else
        {
            assert(allocation_element.list_kind == RuleAllocationElement::LEFT_RECURSIVE_SINGLETON ||
                   allocation_element.list_kind == RuleAllocationElement::RIGHT_RECURSIVE_SINGLETON);

            if (grammar -> IsTerminal(allocation_element.element_symbol))
            {
                GenerateCode(&ast_buffer, newkey, rule_no);
                GenerateCode(&ast_buffer, grammar -> Get_ast_token_classname(), rule_no);
                GenerateCode(&ast_buffer, lparen, rule_no);
                GenerateCode(&ast_buffer, "getRhsIToken(", rule_no);
                IntToString index(allocation_element.element_position);
                GenerateCode(&ast_buffer, index.String(), rule_no);
                GenerateCode(&ast_buffer, rparen, rule_no);
            }
            else
            {
                GenerateCode(&ast_buffer, lparen, rule_no);
                GenerateCode(&ast_buffer, ctc.FindBestTypeFor(allocation_element.element_type_symbol_index), rule_no);
                GenerateCode(&ast_buffer, rparen, rule_no);
                GenerateCode(&ast_buffer, "getRhsSym(", rule_no);
                IntToString index(allocation_element.element_position);
                GenerateCode(&ast_buffer, index.String(), rule_no);
            }
    
            GenerateCode(&ast_buffer, rparen, rule_no);
            GenerateCode(&ast_buffer, comma, rule_no);
            if (allocation_element.list_kind == RuleAllocationElement::LEFT_RECURSIVE_SINGLETON)
                 GenerateCode(&ast_buffer, " true /* left recursive */", rule_no);
            else GenerateCode(&ast_buffer, " false /* not left recursive */", rule_no);
        }

        GenerateCode(&ast_buffer, rparen, rule_no);
        GenerateCode(&ast_buffer, space, rule_no);
    }
    else
    {
        //
        // Add new element to list
        //
        if (allocation_element.list_kind == RuleAllocationElement::ADD_ELEMENT)
        {
            GenerateCode(&ast_buffer, space, rule_no);
            GenerateCode(&ast_buffer, lparen, rule_no);
            GenerateCode(&ast_buffer, lparen, rule_no);
            GenerateCode(&ast_buffer, allocation_element.name, rule_no);
            GenerateCode(&ast_buffer, rparen, rule_no);
            GenerateCode(&ast_buffer, "getRhsSym(", rule_no);
            IntToString index(allocation_element.list_position);
            GenerateCode(&ast_buffer, index.String(), rule_no);
            GenerateCode(&ast_buffer, ")).add(", rule_no);
            if (grammar -> IsTerminal(allocation_element.element_symbol))
            {
                GenerateCode(&ast_buffer, newkey, rule_no);
                GenerateCode(&ast_buffer, grammar -> Get_ast_token_classname(), rule_no);
                GenerateCode(&ast_buffer, lparen, rule_no);
                GenerateCode(&ast_buffer, "getRhsIToken(", rule_no);
                IntToString index(allocation_element.element_position);
                GenerateCode(&ast_buffer, index.String(), rule_no);
                GenerateCode(&ast_buffer, rparen, rule_no);
            }
            else
            {
                GenerateCode(&ast_buffer, lparen, rule_no);
                GenerateCode(&ast_buffer, ctc.FindBestTypeFor(allocation_element.element_type_symbol_index), rule_no);
                GenerateCode(&ast_buffer, rparen, rule_no);
                GenerateCode(&ast_buffer, "getRhsSym(", rule_no);
                IntToString index(allocation_element.element_position);
                GenerateCode(&ast_buffer, index.String(), rule_no);
            }

            if (allocation_element.list_position != 1) // a right-recursive rule? set the list as result
            {
                GenerateCode(&ast_buffer, rparen, rule_no);
                GenerateCode(&ast_buffer, trailer, rule_no);

                GenerateCode(&ast_buffer, space, rule_no);
                GenerateCode(&ast_buffer, "setResult(", rule_no);
                GenerateCode(&ast_buffer, "getRhsSym(", rule_no);
                IntToString index(allocation_element.list_position);
                GenerateCode(&ast_buffer, index.String(), rule_no);
            }
        }

        //
        // Copy a list that is not the first element on the right-hand side of the rule
        //
        else
        {
            assert(allocation_element.list_kind == RuleAllocationElement::COPY_LIST);

            GenerateCode(&ast_buffer, space, rule_no);
            GenerateCode(&ast_buffer, "setResult(", rule_no);
            GenerateCode(&ast_buffer, lparen, rule_no);
            GenerateCode(&ast_buffer, allocation_element.name, rule_no);
            GenerateCode(&ast_buffer, rparen, rule_no);
            GenerateCode(&ast_buffer, "getRhsSym(", rule_no);
            IntToString index(allocation_element.list_position);
            GenerateCode(&ast_buffer, index.String(), rule_no);
        }

        GenerateCode(&ast_buffer, rparen, rule_no);
    }

    GenerateCode(&ast_buffer, trailer, rule_no);
 
    delete [] extra_space;

    return;
}
