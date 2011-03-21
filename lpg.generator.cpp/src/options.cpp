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

std::list<OptionDescriptor*> OptionDescriptor::allOptionDescriptors;

OptionDescriptor::OptionDescriptor(OptionType t, const char *wd1, OptionProcessor::ValueHandler handler, bool valueOpt)
: type(t), word1(wd1), word2(NULL), description(NULL), valueOptional(valueOpt), valueHandler(handler)
{
    setupName();
    allOptionDescriptors.push_back(this);
}

OptionDescriptor::OptionDescriptor(OptionType t, const char *wd1, const char *wd2,
                                   OptionProcessor::ValueHandler handler, bool valueOpt)
: type(t), word1(wd1), word2(wd2), description(NULL), valueOptional(valueOpt), valueHandler(handler)
{
    setupName();
    allOptionDescriptors.push_back(this);
}

OptionDescriptor::OptionDescriptor(OptionType t, const char *wd1, const char *wd2, const char *descrip,
                                   OptionProcessor::ValueHandler handler, bool valueOpt)
: type(t), word1(wd1), word2(wd2), description(descrip), valueOptional(valueOpt), valueHandler(handler)
{
    setupName();
    allOptionDescriptors.push_back(this);
}

void
OptionDescriptor::setupName()
{
    name = word1;
    if (word2 != NULL && strlen(word2) > 0) {
        name.append("-");
        name.append(word2);
    }
}

const std::list<OptionDescriptor*>&
OptionDescriptor::getAllDescriptors()
{
    return allOptionDescriptors;
}

std::string
OptionDescriptor::getTypeDescriptor() const
{
    OptionType type = getType();
    std::string result;

    switch (type) {
        case BOOLEAN: {
            result += "boolean";
            break;
        }
        case STRING: {
            result += "string";
            break;
        }
        case STRING_LIST: {
            result += "string_list";
            break;
        }
        case PATH: {
            result += "path";
            break;
        }
        case PATH_LIST: {
            result += "path_list";
            break;
        }
        default: {
            result += "invalid type";
            break;
        }
    }
    return result;
}

std::string
OptionDescriptor::describeAllOptions()
{
    std::string result;

    for (std::list<OptionDescriptor*>::iterator i= allOptionDescriptors.begin(); i != allOptionDescriptors.end(); i++) {
        OptionDescriptor *od = *i;
        result += "  ";
        result += od->getName();
        if (od->isValueOptional()) {
            result += "{";
        }
        result += "=";
        result += od->getTypeDescriptor();
        if (od->isValueOptional()) {
            result += "}";
        }
        if (od->getDescription() != NULL) {
            result += "\n    ";
            result += od->getDescription();
        }
        result += '\n';
    }
    return result;
}

void
OptionDescriptor::processSetting(OptionProcessor *processor, OptionValue *v)
{
    OptionDescriptor *od = v->getOptionDescriptor();
    
    cerr << "Setting option '" << od->getName() << "' to value " << *v->toString() << endl;
    
    (processor->*valueHandler)(v);
}

OptionValue *
OptionDescriptor::createValue()
{
    switch (getType()) {
        case BOOLEAN: {
            BooleanOptionValue *bv = new BooleanOptionValue(this);
            return bv;
        }
        case ENUM: {
            EnumOptionValue *ev = new EnumOptionValue(this);
            return ev;
        }
        case INTEGER: {
            IntegerOptionValue *iv = new IntegerOptionValue(this);
            return iv;
        }
        case PATH: {
            PathOptionValue *pv = new PathOptionValue(this);
            return pv;
        }
        case STRING: {
            StringOptionValue *sv = new StringOptionValue(this);
            return sv;
        }
        case STRING_LIST: {
            StringListOptionValue *slv = new StringListOptionValue(this);
            return slv;
        }
        case PATH_LIST: {
            PathListOptionValue *plv = new PathListOptionValue(this);
            return plv;
        }
        default:
            return NULL; // shouldn't happen
    }
}

EnumOptionDescriptor::EnumOptionDescriptor(const char *wd1, const char *enumValues, OptionProcessor::ValueHandler handler)
: OptionDescriptor(ENUM, wd1, handler, false)
{
    setupName();
    setupEnumValues(enumValues);
}

EnumOptionDescriptor::EnumOptionDescriptor(const char *wd1, const char *wd2, const char *enumValues, OptionProcessor::ValueHandler handler)
: OptionDescriptor(ENUM, wd1, wd2, handler, false)
{
    setupName();
    setupEnumValues(enumValues);
}

EnumOptionDescriptor::EnumOptionDescriptor(const char *wd1, const char *wd2, const char *enumValues,
                                           const char *descrip, OptionProcessor::ValueHandler handler)
: OptionDescriptor(ENUM, wd1, wd2, descrip, handler, false)
{
    setupName();
    setupEnumValues(enumValues);
}

void
EnumOptionDescriptor::setupEnumValues(const char *enumValues)
{
    char *copy = new char[strlen(enumValues)+1];
    strcpy(copy, enumValues);
    char *pStart = copy;
    do {
        char *pEnd = strchr(pStart, '|');
        std::string *val;
        
        if (pEnd == NULL) {
            val = new std::string(pStart);
            pStart = pEnd;
        } else {
            val = new std::string(pStart, pEnd - pStart);
            pStart = pEnd+1;
        }
        
        legalValues.push_back(*val);
        delete val;
    } while (pStart != NULL);
    delete[] copy;
}

std::string
EnumOptionDescriptor::getTypeDescriptor() const
{
    std::string result;
    const std::list<std::string>& legalValues = getLegalValues();
    
    for (std::list<std::string>::const_iterator i= legalValues.begin(); i != legalValues.end(); i++) {
        if (i != legalValues.begin()) {
            result += " | ";
        }
        result += *i;
    }
    return result;
}

IntegerOptionDescriptor::IntegerOptionDescriptor(const char *wd1, int min, int max, OptionProcessor::ValueHandler handler)
: OptionDescriptor(INTEGER, wd1, NULL, handler, false), minValue(min), maxValue(max)
{
}

IntegerOptionDescriptor::IntegerOptionDescriptor(const char *wd1, const char *wd2, int min, int max, OptionProcessor::ValueHandler handler)
: OptionDescriptor(INTEGER, wd1, wd2, handler, false), minValue(min), maxValue(max)
{
}

IntegerOptionDescriptor::IntegerOptionDescriptor(const char *wd1, const char *wd2, int min, int max,
                                                 const char *descrip, OptionProcessor::ValueHandler handler)
: OptionDescriptor(INTEGER, wd1, wd2, descrip, handler, false), minValue(min), maxValue(max)
{
}

std::string
IntegerOptionDescriptor::getTypeDescriptor() const
{
    std::string result;

    result += "int";

    if (this->minValue != INT_MIN && this->maxValue == INT_MAX) {
        IntToString minStr(this->minValue);
        result += "[ >= ";
        result += minStr.String();
        result += "]";
    } else if (this->minValue == INT_MIN && this->maxValue != INT_MAX) {
        IntToString maxStr(this->maxValue);
        result += "[ <= ";
        result += maxStr.String();
        result += "]";
    } else {
        IntToString minStr(this->minValue);
        IntToString maxStr(this->maxValue);
        result += "[";
        result += minStr.String();
        result += "..";
        result += maxStr.String();
        result += "]";
    }

    return result;
}

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

OptionDescriptor *automaticAST = new EnumOptionDescriptor("automatic", "ast", "none|nested|toplevel",
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

//  options->include_search_directory.Reset();
    for(std::list<std::string>::iterator i= values.begin(); i != values.end(); i++) {
        std::string path = *i;
//      cerr << "include-dir path: " << path << endl;
        options->include_search_directory.Next() = strdup(path.c_str());
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

OptionDescriptor *
OptionValue::getOptionDescriptor()
{
    return optionDesc;
}

void
StringListOptionValue::addValue(const char *s)
{
    std::string v = s;
    values.push_back(v);
}

OptionParser::OptionParser(const std::list<OptionDescriptor*> opts)
{
    allOptions = opts;
}

bool
OptionParser::IsDelimiter(char c)
{
    return (c == NULL_CHAR || c == ',' || Code::IsSpace(c));
}

OptionDescriptor *
OptionParser::findOption(const char *&start)
{
    for (std::list<OptionDescriptor*>::iterator i=allOptions.begin(); i != allOptions.end(); i++) {
        OptionDescriptor *od = *i;
        const char *p = start;
        const char *word1 = od->getWord1();
        const char *word2 = od->getWord2();
        
        if ((p[0] == *word1 || p[0] == ToUpper(*word1)) &&
            (word2 != NULL && (p[1] == *word2 || p[1] == ToUpper(*word2)) &&
             (p[2] == '=' || IsDelimiter(p[2])) ||
             word2 == NULL && (p[2] == '=' || IsDelimiter(p[2])))) {
                start += 2;
                return od;
            }
        
        int length1 = strlen(word1);
        int length = length1 + strlen(word2) + 1; // +1 for separator
        char *name = new char[length + 1];
        
        strcpy(name, word1);
        strcat(name, word2);
        int i = strxsub(p, name) - 1;
        
        strcpy(name, word1);
        strcat(name, "_");
        strcat(name, word2);
        
        i = Max(i, strxsub(p, name) - 1);
        
        name[length1] = '-';
        
        i = Max(i, strxsub(p, name) - 1);
        
        delete [] name;
        
        if (start[i+1] == '=' || IsDelimiter(start[i+1])) {
            start += i + 1;
            return od;
        }
    }
    return NULL;
}

void
BooleanOptionValue::parseValue(std::string *v, OptionDescriptor *od) throw(ValueFormatException)
{
    if (v == NULL) {
        if (od->isValueOptional()) {
            value = true;
        } else {
            throw ValueFormatException("Missing boolean value", od);
        }
    } else if (!v->compare("true")) {
        value = true;
    } else if (!v->compare("false")) {
        value = false;
    } else {
        throw ValueFormatException("Invalid boolean value", *v, od);
    }
}

static const std::string *TRUE_VALUE_STR = new std::string("true");
static const std::string *FALSE_VALUE_STR = new std::string("false");

const std::string *
BooleanOptionValue::toString()
{
    return value ? TRUE_VALUE_STR : FALSE_VALUE_STR;
}

void
IntegerOptionValue::parseValue(std::string *v, OptionDescriptor *od) throw(ValueFormatException)
{
    if (v == NULL) {
        if (od->isValueOptional()) {
            value = 0;
        } else {
            throw ValueFormatException("Missing integer value", od);
        }
    }
    
    const IntegerOptionDescriptor *id = static_cast<const IntegerOptionDescriptor*> (od);
    const char *vs = v->c_str();
    
    if (!verify(vs)) {
        throw ValueFormatException("Invalid integer value", *v, od);
    } else {
        int iv = atoi(vs);
        if (iv < id->getMinValue() || iv > id->getMaxValue()) {
            throw ValueFormatException("Integer value outside allowable range", *v, od);
        }
        value = iv;
    }
}

const std::string *
IntegerOptionValue::toString()
{
    IntToString i2s(value);
    std::string *result = new std::string(i2s.String());
    return result;
}

void
StringOptionValue::parseValue(std::string *v, OptionDescriptor *od) throw(ValueFormatException)
{
    if (v == NULL) {
        throw ValueFormatException("Missing string value", od);
    }
    if (v->length() == 0) {
        value = *v;
    } else if (v->at(0) == '\'') {
        if (v->at(v->length()-1) != '\'') {
            throw ValueFormatException("String option value must be quoted", *v, od);
        }
        // trim quotes
        value = v->substr(1, v->length() - 2);
    } else {
        value = v->substr(0, v->length());
    }
}

const std::string *
StringOptionValue::toString()
{
    std::string *result = new std::string(value.c_str());
    return result;
}

void
EnumOptionValue::parseValue(std::string *v, OptionDescriptor *od) throw(ValueFormatException)
{
    if (v == NULL) {
        throw ValueFormatException("Missing enum value", od);
    }
    
    int endIdx = v->find_first_of(',');
    
    std::string enumValue = v->substr(0, endIdx);
    
    EnumOptionDescriptor *eod = static_cast<EnumOptionDescriptor*> (od);
    
    // Check that the given value is one of the allowed values
    std::list<std::string> legalValues = eod->getLegalValues();
    
    bool found = false;
    for (std::list<std::string>::iterator i = legalValues.begin(); i != legalValues.end(); i++) {
        if (!(*i).compare(enumValue)) {
            found = true;
            break;
        }
    }
    if (!found) {
        // TODO say what are the legal values
        std::string msg;
        msg.append("Legal values are: {");
        for (std::list<std::string>::iterator i = legalValues.begin(); i != legalValues.end(); i++) {
            if (i != legalValues.begin()) {
                msg.append(" |");
            }
            msg.append(" ");
            msg.append(*i);
        }        
        msg.append(" }");
        throw ValueFormatException(msg, *v, od);
    }
    value = *v;
}

void
StringListOptionValue::parseValue(std::string *v, OptionDescriptor *od) throw(ValueFormatException)
{
    if (v == NULL) {
        throw ValueFormatException("Missing list-of-strings value", od);
    }
    
    // Trim surrounding ()'s, and split string at commas
    // Work on a copy
    const char *p = v->c_str();
    if (p[0] != '(') {
        throw ValueFormatException("String-list-valued option must be enclosed in parentheses", *v, od);
    }
    if (p[strlen(p)-1] != ')') {
        throw ValueFormatException("String-list-valued option must be enclosed in parentheses", *v, od);
    }
    char *pCopy = strdup(p+1); // trim leading '('
    pCopy[strlen(pCopy)-1] = '\0'; // trim trailing ')'
    
    const char *pStart = pCopy;
    do {
        char *pEnd = strchr(pStart, ',');
        std::string *val;
        
        if (pEnd == NULL) {
            val = new std::string(pStart);
            pStart = pEnd;
        } else {
            val = new std::string(pStart, pEnd - pStart);
            pStart = pEnd + 1;
        }
        
        values.push_back(*val);
        delete val;
    } while (pStart != NULL);

    free(pCopy);
}

const std::string *
StringListOptionValue::toString()
{
    std::string *result = new std::string();
    
    for (std::list<std::string>::iterator i = values.begin(); i != values.end(); i++) {
        if (i != values.begin()) {
            result->append(",");
        }
        result->append(*i);
    }
    return result;
}

void
PathListOptionValue::parseValue(std::string *v, OptionDescriptor *od) throw(ValueFormatException)
{
    if (v == NULL) {
        throw ValueFormatException("Missing path-list value", od);
    }
    
    // Split string at semicolons
    const char *pStart = v->c_str();
    do {
        char *pEnd = strchr(pStart, ';');
        std::string *val;
        
        if (pEnd == NULL) {
            val = new std::string(pStart);
            pStart = pEnd;
        } else {
            val = new std::string(pStart, pEnd - pStart);
            pStart = pEnd + 1;
        }
        
        values.push_back(*val);
        delete val;
    } while (pStart != NULL);
}

const std::string *
PathListOptionValue::toString()
{
    std::string *result = new std::string();
    
    for (std::list<std::string>::iterator i = values.begin(); i != values.end(); i++) {
        if (i != values.begin()) {
            result->append(";");
        }
        result->append(*i);
    }
    return result;
}

std::string *
OptionParser::getOptionValue(const char *&p)
{
    if (p != NULL && *p == '=') {
        int plen = strlen(p+1);
        const char *delim;
        
        if (p[1] == '(') {
            // A parenthesized string list
            delim = strchr(p, ')');
            delim = strchr(delim, ',');
        } else {
            delim = strchr(p, ',');
        }

        int len = (delim != NULL) ? delim - p - 1 : plen;
        std::string *result = new std::string(p+1, len);

        p += result->length() + 1;
        return result;
    }
    return NULL;
}

OptionValue *
OptionParser::parse(const char *&start) throw(ValueFormatException)
{
    OptionDescriptor *od = findOption(start);

    if (od != NULL) {
        // This option is a match
        std::string *optValueStr = getOptionValue(start);
        OptionValue *optValue = od->createValue();
        
        optValue->parseValue(optValueStr, od);
        return optValue;
    }
    return NULL;
}
