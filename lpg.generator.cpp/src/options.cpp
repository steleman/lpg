/*
 *  options.cpp
 *  lpg
 *
 *  Created by Robert M. Fuhrer on 3/13/11.
 *  Copyright 2011 IBM. All rights reserved.
 */

#include "options.h"
#include "option.h"

#include <limits.h>

OptionProcessor::OptionProcessor(Option *option)
: options(option)
{ }

std::string
trimQuotes(std::string& s)
{
    std::string result;
    int begin= 0, len = s.length();

    while (s[begin] == ' ') {
        begin++; len--;
    }
    if (s[begin] == '"') {
        begin++; len--;
    }
    if (s[begin+len-1] == '"') {
        len--;
    }
    result += s.substr(begin, len);
    return result;
}

std::list<OptionDescriptor*> OptionDescriptor::allOptionDescriptors;

OptionDescriptor *actionBlock = new OptionDescriptor(STRING_LIST, "action", "block", &OptionProcessor::processActionBlock);

void
OptionProcessor::processActionBlock(OptionValue *v)
{
    StringListOptionValue *slv = static_cast<StringListOptionValue*> (v);
    std::list<std::string> values = slv->getValue();
    std::list<std::string>::iterator i = values.begin();
    std::string fileName = trimQuotes(*i++);
    std::string blockBegin = trimQuotes(*i++);
    std::string blockEnd = trimQuotes(*i++);

    Option::BlockInfo& actionBlock = options->action_options.Next();
    actionBlock.Set(NULL, strdup(fileName.c_str()), strdup(blockBegin.c_str()), strdup(blockEnd.c_str()));
}

OptionDescriptor *astDirectory = new PathOptionDescriptor("ast", "directory",
                                                          "the directory in which generated AST classes will be placed, if automatic-ast is 'toplevel'",
                                                          &Option::ast_directory, true);

OptionDescriptor *astType = new StringOptionDescriptor("ast", "type", "the name of the AST root class", &Option::ast_type, false);

OptionDescriptor *attributes = new BooleanOptionDescriptor("attributes", NULL, "???", &Option::attributes);

OptionDescriptor *automaticAST = new EnumOptionDescriptor("automatic", "ast", "none|nested|toplevel", "nested",
                                                          "determines where generated AST classes will be placed",
                                                          &OptionProcessor::processAutomaticAST);

void
OptionProcessor::processAutomaticAST(OptionValue *v)
{
    EnumOptionValue *ev = static_cast<EnumOptionValue*> (v);
    
    if (!ev->getValue().compare("nested")) {
        options->automatic_ast = Option::NESTED;
    } else if (!ev->getValue().compare("toplevel")) {
        options->automatic_ast = Option::TOPLEVEL;
    } else {
        options->automatic_ast = Option::NONE;
    }
}

OptionDescriptor *backtrack = new BooleanOptionDescriptor("backtrack", NULL, "???",
                                                          &Option::backtrack);
OptionDescriptor *byte = new BooleanOptionDescriptor("byte", NULL, "???",
                                                     &Option::byte);
OptionDescriptor *conflicts = new BooleanOptionDescriptor("conflicts", NULL, "???",
                                                          &Option::conflicts);
OptionDescriptor *dataDirectory = new PathOptionDescriptor("dat", "directory", "???",
                                                       &Option::dat_directory);

OptionDescriptor *dataFile = new PathOptionDescriptor("dat", "file", "???",
                                                      &Option::dat_file);

OptionDescriptor *dclFile = new PathOptionDescriptor("dcl", "file", "???",
                                                     &Option::dcl_file);

OptionDescriptor *defFile = new PathOptionDescriptor("def", "file", "???",
                                                     &Option::def_file);

OptionDescriptor *dirPrefix = new PathOptionDescriptor("directory", "prefix", "???",
                                                       &Option::directory_prefix, true);

OptionDescriptor *debug = new BooleanOptionDescriptor("debug", NULL, "???", &Option::debug);

OptionDescriptor *edit = new BooleanOptionDescriptor("edit", NULL, "???", &Option::edit);

OptionDescriptor *errorMaps = new BooleanOptionDescriptor("error", "maps", "???", &Option::error_maps);

OptionDescriptor *escapeChar = new CharOptionDescriptor("escape", NULL, "???",
                                                        &Option::escape);

OptionDescriptor *exportsTerminals = new OptionDescriptor(STRING_LIST, "export", "terminals", "???",
                                                          &OptionProcessor::processExportTerminals);

void
OptionProcessor::processExportTerminals(OptionValue *v)
{
    StringListOptionValue *slv = static_cast<StringListOptionValue*> (v);
    const std::list<std::string>& values = slv->getValue();
    if (values.size() < 1 || values.size() > 3) {
        throw ValueFormatException("Export-terminals value must be a string list of 1 to 3 elements", *v->toString(), v->getOptionDescriptor());
    }
    std::list<std::string>::const_iterator iter = values.begin();
    options->exp_file = strdup((*iter++).c_str());
    if (iter != values.end()) {
        options->exp_prefix = strdup((*iter++).c_str());
    }
    if (iter != values.end()) {
        options->exp_suffix = strdup((*iter++).c_str());
    }
}

OptionDescriptor *extendsParseTable = new StringOptionDescriptor("extends", "parsetable", "???",
                                                                 &Option::extends_parsetable, false);

OptionDescriptor *factory = new StringOptionDescriptor("factory", NULL, "???",
                                                       &Option::factory, false);

OptionDescriptor *filePrefix = new StringOptionDescriptor("file", "prefix", "???",
                                                          &Option::file_prefix, true);

//
// Can't just do the following b/c the 'filter' option affects two Option fields (filter and filter_file)
//OptionDescriptor *filter = new StringOptionDescriptor("filter", NULL, "???",
//                                                      &Option::filter, false);
//
OptionDescriptor *filter = new OptionDescriptor(STRING, "filter", &OptionProcessor::processFilter, false);

void
OptionProcessor::processFilter(OptionValue *v)
{
    StringOptionValue *sv = static_cast<StringOptionValue*> (v);
    options->filter_file.Reset();
    const char *valStr = strdup(sv->getValue().c_str());
    options->filter_file.Next() = valStr;
    options->filter = valStr;
}

OptionDescriptor *first = new BooleanOptionDescriptor("first", NULL, "???", &Option::first);

OptionDescriptor *follow = new BooleanOptionDescriptor("follow", NULL, "???", &Option::follow);

OptionDescriptor *glr = new BooleanOptionDescriptor("glr", NULL, "???", &Option::glr);

OptionDescriptor *gotoDefault = new BooleanOptionDescriptor("goto", "default", "???",
                                                            &Option::goto_default);

OptionDescriptor *ignoreBlock = new OptionDescriptor(STRING, "ignore", "block", "???",
                                                     &OptionProcessor::processIgnoreBlock);
void
OptionProcessor::processIgnoreBlock(OptionValue *v)
{
    StringOptionValue *sv = static_cast<StringOptionValue*> (v);
    if (sv->getValue().length() < 1) {
        throw ValueFormatException("Ignore-block value must be a non-empty string", *v->toString(), v->getOptionDescriptor());
    }
    const char *ignore_block = strdup(sv->getValue().c_str());
    options->action_blocks.FindOrInsertIgnoredBlock(ignore_block, strlen(ignore_block));
}

OptionDescriptor *impFile = new StringOptionDescriptor("imp", "file", "???",
                                                       &Option::imp_file);

// Can't just do the following b/c the 'import-terminals' option affects two Option fields (import_file and import_terminals)
//OptionDescriptor *importTerminals = new StringOptionDescriptor("import", "terminals", "???",
//                                                               &Option::import_terminals, false);
OptionDescriptor *importTerminals = new OptionDescriptor(STRING, "import", "terminals", "???",
                                                         &OptionProcessor::processImportTerminals);
void
OptionProcessor::processImportTerminals(OptionValue *v)
{
    StringOptionValue *sv = static_cast<StringOptionValue*> (v);
    options->import_file.Reset();
    const char *valStr = strdup(sv->getValue().c_str());
    options->import_file.Next() = valStr;
    options->import_terminals = valStr;
}

OptionDescriptor *includeDirs = new OptionDescriptor(PATH_LIST, "include", "directory",
                                                     "a semi-colon separated list of directories to search when processing include directives",
                                                     &OptionProcessor::processIncludeDir, false);

void
OptionProcessor::processIncludeDir(OptionValue *v)
{
    PathListOptionValue *plv = static_cast<PathListOptionValue*> (v);
    std::list<std::string> values = plv->getValue();
    std::string includeDirOption;

    options->include_search_directory.Reset();
    for(std::list<std::string>::iterator i= values.begin(); i != values.end(); i++) {
        std::string path = *i;
//      cerr << "include-dir path: " << path << endl;
        options->include_search_directory.Next() = strdup(path.c_str());
        if (includeDirOption.length() > 0) {
            includeDirOption += ";";
        }
        includeDirOption += path;
    }
    options->include_directory = strdup(includeDirOption.c_str());
}

OptionDescriptor *lalr = new IntegerOptionDescriptor("lalr", "", 1, INT_MAX,
                                                     "determines how many tokens of look-ahead can be used to disambiguate",
                                                     &Option::lalr_level);

OptionDescriptor *legacy = new BooleanOptionDescriptor("legacy", NULL, "???", &Option::legacy);

OptionDescriptor *list = new BooleanOptionDescriptor("list", NULL, "???", &Option::list);

OptionDescriptor *margin = new IntegerOptionDescriptor("margin", NULL, 1, INT_MAX,
                                                       "???",
                                                       &Option::margin);

OptionDescriptor *maxCases = new IntegerOptionDescriptor("max", "cases", 1, INT_MAX,
                                                         "???",
                                                         &Option::max_cases);

OptionDescriptor *names = new EnumOptionDescriptor("names", "optimized|minimum|maximum", &OptionProcessor::processNames);

void
OptionProcessor::processNames(OptionValue *v)
{
    EnumOptionValue *ev = static_cast<EnumOptionValue*> (v);
    std::string value = ev->getValue();

    if (!value.compare("optimized")) {
        options->names = Option::OPTIMIZED;
    } else if (!value.compare("minimum")) {
        options->names = Option::MINIMUM;
    } else if (!value.compare("maximum")) {
        options->names = Option::MAXIMUM;
    }
}

OptionDescriptor *ntCheck = new BooleanOptionDescriptor("nt", "check", "???", &Option::nt_check);

OptionDescriptor *orMarker = new CharOptionDescriptor("or", "marker", "???",
                                                      &Option::or_marker);

OptionDescriptor *outDirectory = new StringOptionDescriptor("out", "directory", "???",
                                                            &Option::out_directory, true);

OptionDescriptor *package = new StringOptionDescriptor("package", NULL, "???",
                                                       &Option::package, false);

OptionDescriptor *parentSaved = new BooleanOptionDescriptor("parent", "saved", "???", &Option::parent_saved);

OptionDescriptor *parseTableInterfaces = new StringOptionDescriptor("parsetable", "interfaces", "???",
                                                                    &Option::parsetable_interfaces, false);

OptionDescriptor *precedence = new BooleanOptionDescriptor("precedence", NULL,
                                                           "if true, allow conflicting actions to be ordered",
                                                           &Option::precedence, false);

OptionDescriptor *prefix = new StringOptionDescriptor("prefix", NULL, "???",
                                                      &Option::prefix, true);

OptionDescriptor *priority = new BooleanOptionDescriptor("priority", NULL, "???",
                                                         &Option::priority);

OptionDescriptor *programmingLang = new EnumOptionDescriptor("programming", "language", "c|cpp|c++|java|ml|plx|plxasm|xml",
                                                             "identifies the desired parser implementation language",
                                                             &OptionProcessor::processProgrammingLanguage);
void
OptionProcessor::processProgrammingLanguage(OptionValue *v)
{
    EnumOptionValue *ev = static_cast<EnumOptionValue*> (v);
    std::string value = ev->getValue();
    
    if (!value.compare("c")) {
        options->programming_language = Option::C;
    } else if (!value.compare("cpp") || !value.compare("c++")) {
        options->programming_language = Option::CPP;
    } else if (!value.compare("java")) {
        options->programming_language = Option::JAVA;
    } else if (!value.compare("ml")) {
        options->programming_language = Option::ML;
    } else if (!value.compare("plx")) {
        options->programming_language = Option::PLX;
    } else if (!value.compare("plxasm")) {
        options->programming_language = Option::PLXASM;
    } else if (!value.compare("xml")) {
        options->programming_language = Option::XML;
    }
}

OptionDescriptor *prsFile = new StringOptionDescriptor("prs", "file", "???",
                                                       &Option::prs_file, false);

OptionDescriptor *quiet = new BooleanOptionDescriptor("quiet", NULL,
                                                      "???",
                                                      &Option::quiet);

OptionDescriptor *readReduce = new BooleanOptionDescriptor("read", "reduce",
                                                           "???",
                                                           &Option::read_reduce);

OptionDescriptor *remapTerminals = new BooleanOptionDescriptor("remap", "terminals",
                                                               "???",
                                                               &Option::remap_terminals);

OptionDescriptor *ruleClassNames = new EnumOptionDescriptor("rule", "classnames", "sequential|stable",
                                                            "???",
                                                            &OptionProcessor::processRuleClassNames);
void
OptionProcessor::processRuleClassNames(OptionValue *v)
{
    EnumOptionValue *ev = static_cast<EnumOptionValue*> (v);
    std::string value = ev->getValue();
    
    if (!value.compare("sequential")) {
        options->rule_classnames = Option::SEQUENTIAL;
    } else if (!value.compare("stable")) {
        options->rule_classnames = Option::STABLE;
    }
}

OptionDescriptor *scopes = new BooleanOptionDescriptor("scopes", NULL,
                                                       "???",
                                                       &Option::scopes);

OptionDescriptor *serialize = new BooleanOptionDescriptor("serialize", NULL,
                                                          "???",
                                                          &Option::serialize);

OptionDescriptor *shiftDefault = new BooleanOptionDescriptor("shift", "default",
                                                             "???",
                                                             &Option::shift_default);

OptionDescriptor *singleProductions = new BooleanOptionDescriptor("single", "productions",
                                                           "???",
                                                           &Option::single_productions);

OptionDescriptor *slr = new BooleanOptionDescriptor("slr", NULL,
                                                    "???",
                                                    &Option::slr);

OptionDescriptor *softKeywords = new BooleanOptionDescriptor("soft", "keywords",
                                                             "if true, try treating keywords as identifiers if parsing fails otherwise",
                                                             &Option::soft_keywords);

OptionDescriptor *states = new BooleanOptionDescriptor("states", NULL,
                                                       "???",
                                                       &Option::states);

OptionDescriptor *suffix = new StringOptionDescriptor("suffix", NULL, "???",
                                                      &Option::suffix, true);

OptionDescriptor *symFile = new StringOptionDescriptor("sym", "file", "???",
                                                       &Option::sym_file, false);

OptionDescriptor *tabFile = new StringOptionDescriptor("tab", "file", "???",
                                                       &Option::tab_file, false);

OptionDescriptor *table = new EnumOptionDescriptor("table", NULL, "c|cpp|c++|java|ml|plx|plxasm|xml",
                                                      "???",
                                                      &OptionProcessor::processTable);
void
OptionProcessor::processTable(OptionValue *v)
{
    EnumOptionValue *ev = static_cast<EnumOptionValue*> (v);
    std::string value = ev->getValue();

    if (!value.compare("none")) {
        options->table = false;
        options->programming_language = Option::XML;
    } else if (!value.compare("c")) {
        options->programming_language = Option::C;
    } else if (!value.compare("cpp") || !value.compare("c++")) {
        options->programming_language = Option::CPP;
    } else if (!value.compare("java")) {
        options->programming_language = Option::JAVA;
    } else if (!value.compare("ml")) {
        options->programming_language = Option::ML;
    } else if (!value.compare("plx")) {
        options->programming_language = Option::PLX;
    } else if (!value.compare("plxasm")) {
        options->programming_language = Option::PLXASM;
    } else if (!value.compare("xml")) {
        options->programming_language = Option::XML;
    }
}

OptionDescriptor *template_ = new StringOptionDescriptor("template", NULL, "???",
                                                         &Option::template_name, false);

OptionDescriptor *trace = new EnumOptionDescriptor("trace", NULL, "conflicts|full",
                                                   "???",
                                                   &OptionProcessor::processTrace);
void
OptionProcessor::processTrace(OptionValue *v)
{
    EnumOptionValue *ev = static_cast<EnumOptionValue*> (v);
    std::string value = ev->getValue();
    
    if (!value.compare("conflicts")) {
        options->trace = Option::CONFLICTS;
    } else if (!value.compare("full")) {
        options->trace = Option::FULL;
    }
}

OptionDescriptor *trailers = new OptionDescriptor(STRING_LIST, "trailers", NULL, "???",
                                                  &OptionProcessor::processTrailers);
void
OptionProcessor::processTrailers(OptionValue *v)
{
    StringListOptionValue *slv = static_cast<StringListOptionValue*> (v);
    const std::list<std::string>& values = slv->getValue();
    if (values.size() != 3) {
        throw ValueFormatException("Trailers value must be a string list of 3 elements", *v->toString(), v->getOptionDescriptor());
    }
    std::list<std::string>::const_iterator iter = values.begin();
    const char *filename = strdup((*iter++).c_str());
    const char *block_begin = strdup((*iter++).c_str());
    const char *block_end = strdup((*iter++).c_str());
    options->trailer_options.Next().Set(NULL, filename, block_begin, block_end);
}

OptionDescriptor *variables = new EnumOptionDescriptor("variables", "", "none|both|terminals|nt|nonterminals|non-terminals",
                                                       "determines the set of right-hand side symbols for which local variables will be defined within action blocks",
                                                       &OptionProcessor::processVariables);
void
OptionProcessor::processVariables(OptionValue *v)
{
    EnumOptionValue *ev = static_cast<EnumOptionValue*> (v);
    std::string value = ev->getValue();
    
    if (!value.compare("none")) {
        options->variables = Option::NONE;
    } else if (!value.compare("both")) {
        options->variables = Option::BOTH;
    } else if (!value.compare("terminals")) {
        options->variables = Option::TERMINALS;
    } else if (!value.compare("nonterminals") || !value.compare("non_terminals") || !value.compare("nt")) {
        options->variables = Option::NON_TERMINALS;
    }
}

OptionDescriptor *verbose = new BooleanOptionDescriptor("verbose", NULL,
                                                        "???",
                                                        &Option::verbose);

OptionDescriptor *visitor = new EnumOptionDescriptor("visitor", NULL, "none|default|preorder",
                                                     "???",
                                                     &OptionProcessor::processVisitor);
void
OptionProcessor::processVisitor(OptionValue *v)
{
    EnumOptionValue *ev = static_cast<EnumOptionValue*> (v);
    std::string value = ev->getValue();
    
    if (!value.compare("none")) {
        options->visitor = Option::NONE;
    } else if (!value.compare("default")) {
        options->visitor = Option::DEFAULT;
    } else if (!value.compare("preorder")) {
        options->visitor = Option::PREORDER;
    }
}

OptionDescriptor *visitorType = new StringOptionDescriptor("visitor", "type", "???",
                                                           &Option::visitor_type, false);

OptionDescriptor *warnings = new BooleanOptionDescriptor("warnings", NULL,
                                                         "???",
                                                         &Option::warnings);

OptionDescriptor *xref = new BooleanOptionDescriptor("xref", NULL,
                                                     "???",
                                                     &Option::xref);
