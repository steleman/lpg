/*
 *  options.cpp
 *  lpg
 *
 *  Created by Robert M. Fuhrer on 3/13/11.
 *  Copyright 2011 __MyCompanyName__. All rights reserved.
 *
 */

#include "options.h"
#include "option.h"

#include <limits.h>

OptionProcessor::OptionProcessor(Option *option)
: options(option)
{ }

void
OptionProcessor::processAnyOption(OptionValue *v)
{
    // no-op
}

std::string
trimQuotes(std::string& s)
{
    std::string result;
//  cerr << "Pre-trimmed: " << s << endl;
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
//  cerr << "Post-trimmed: " << result << endl;
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

//  cerr << "action-block filename:    " << fileName << endl;
//  cerr << "action-block block-begin: " << blockBegin << endl;
//  cerr << "action-block block-end:   " << blockEnd << endl;
    Option::BlockInfo& actionBlock = options->action_options.Next();
    actionBlock.Set(NULL, strdup(fileName.c_str()), strdup(blockBegin.c_str()), strdup(blockEnd.c_str()));
}

OptionDescriptor *astDirectory = new OptionDescriptor(PATH, "ast", "directory",
                                                      "the directory in which generated AST classes will be placed, if automatic-ast is 'toplevel'",
                                                      &OptionProcessor::processASTdirectory, true);

void
OptionProcessor::processASTdirectory(OptionValue *v)
{
    StringOptionValue *sv = static_cast<StringOptionValue*> (v);
    options->ast_directory = strdup(sv->getValue().c_str());
}

OptionDescriptor *astType = new OptionDescriptor(STRING, "ast", "type", "the name of the AST root class", &OptionProcessor::processASTtype);

void
OptionProcessor::processASTtype(OptionValue *v)
{
    StringOptionValue *sv = static_cast<StringOptionValue*> (v);
    
    options->ast_type = sv->getValue().c_str();
}

OptionDescriptor *attributes = new OptionDescriptor(STRING, "attributes", &OptionProcessor::processAttributes, true);

void
OptionProcessor::processAttributes(OptionValue *v)
{
    BooleanOptionValue *bv = static_cast<BooleanOptionValue*> (v);
    options->attributes = bv->getValue();
}

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

OptionDescriptor *debug = new OptionDescriptor(BOOLEAN, "debug", &OptionProcessor::processDebug, true);

void
OptionProcessor::processDebug(OptionValue *v)
{
    BooleanOptionValue *bv = static_cast<BooleanOptionValue*> (v);
    options->debug = bv->getValue();
}

OptionDescriptor *includeDirs = new OptionDescriptor(PATH_LIST, "include", "directory",
                                                     "a semi-colon separated list of directories to search when processing include directives",
                                                     &OptionProcessor::processIncludeDir, false);

void
OptionProcessor::processIncludeDir(OptionValue *v)
{
    PathListOptionValue *plv = static_cast<PathListOptionValue*> (v);
    std::list<std::string> values = plv->getValue();

    cerr << "argv before processing -include:" << endl;
    for(int i=0; i < options->argc; i++) {
        cerr << "  " << options->argv[i] << endl;
    }
    options->include_search_directory.Reset();
    for(std::list<std::string>::iterator i= values.begin(); i != values.end(); i++) {
        std::string path = *i;
//      cerr << "include-dir path: " << path << endl;
        options->include_search_directory.Next() = strdup(path.c_str());
    }
    cerr << "argv after:" << endl;
    for(int i=0; i < options->argc; i++) {
        cerr << "  " << options->argv[i] << endl;
    }
}

OptionDescriptor *lalr = new IntegerOptionDescriptor("lalr", "", 1, INT_MAX,
                                                     "determines how many tokens of look-ahead can be used to disambiguate",
                                                     &OptionProcessor::processLALR);

void
OptionProcessor::processLALR(OptionValue *v)
{
    IntegerOptionValue *iv = static_cast<IntegerOptionValue*> (v);
    options->lalr_level = iv->getValue();
}

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

OptionDescriptor *softKeywords = new OptionDescriptor(BOOLEAN, "soft", "keywords",
                                                      "if true, try treating keywords as identifiers if parsing fails otherwise",
                                                      &OptionProcessor::processSoftKeywords, true);

void
OptionProcessor::processSoftKeywords(OptionValue *v)
{
    BooleanOptionValue *bv = static_cast<BooleanOptionValue*> (v);
    options->soft_keywords = bv->getValue();
}

OptionDescriptor *variables = new EnumOptionDescriptor("variables", "", "none|both|terminals|nt|nonterminals",
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
    } else if (!value.compare("nonterminals") || !value.compare("nt")) {
        options->variables = Option::NON_TERMINALS;
    }
}

