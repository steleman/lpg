/*
 *  optionDesc.cpp
 *  lpg
 *
 *  Created by Robert M. Fuhrer on 3/21/11.
 *  Copyright 2011 IBM.
 */

#include "options.h"

#include <iostream>
#include <limits>

using namespace std;

OptionDescriptor::OptionDescriptor(OptionType t, const char *wd1, const char *wd2, const char *descrip, bool valueOpt)
: type(t), word1(wd1), word2(wd2), description(descrip), valueOptional(valueOpt)
{
    setupName();
    allOptionDescriptors.push_back(this);
}

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
//  OptionDescriptor *od = v->getOptionDescriptor();

//  cerr << "Setting option '" << od->getName() << "' to value " << *v->toString() << endl;
    
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

BooleanOptionDescriptor::BooleanOptionDescriptor(const char *wd1, const char *wd2, const char *descrip,
                                                 OptionProcessor::BooleanValueField field, bool valueOpt)

: OptionDescriptor(BOOLEAN, wd1, wd2, descrip, valueOpt), boolField(field)
{
}

void
BooleanOptionDescriptor::processSetting(OptionProcessor *processor, OptionValue *v)
{
    BooleanOptionValue *bv = static_cast<BooleanOptionValue*> (v);
    Option *options = processor->getOptions();

    options->*boolField = bv->getValue();
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

IntegerOptionDescriptor::IntegerOptionDescriptor(const char *wd1, const char *wd2, int min, int max, const char *descrip,
                                                 OptionProcessor::IntegerValueField field, bool valueOpt)
: OptionDescriptor(INTEGER, wd1, wd2, descrip, valueOpt), minValue(min), maxValue(max), intField(field)
{
}

void
IntegerOptionDescriptor::processSetting(OptionProcessor *processor, OptionValue *v)
{
    IntegerOptionValue *iv = static_cast<IntegerOptionValue*> (v);
    Option *options = processor->getOptions();

    options->*intField = iv->getValue();
}

std::string
IntegerOptionDescriptor::getTypeDescriptor() const
{
    std::string result;
    
    result += "int";

    if (this->minValue != std::numeric_limits<int>::min() && this->maxValue == std::numeric_limits<int>::max()) {
        IntToString minStr(this->minValue);
        result += "[ >= ";
        result += minStr.String();
        result += "]";
    } else if (this->minValue == std::numeric_limits<int>::min() && this->maxValue != std::numeric_limits<int>::max()) {
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

StringOptionDescriptor::StringOptionDescriptor(const char *wd1, const char *wd2, const char *descrip,
                                               OptionProcessor::StringValueField field, bool emptyOk)
: OptionDescriptor(STRING, wd1, wd2, descrip, false), emptyOk(emptyOk), stringField(field)
{
}

StringOptionDescriptor::StringOptionDescriptor(OptionType t, const char *wd1, const char *wd2, const char *descrip,
                                               OptionProcessor::StringValueField field, bool emptyOk)
: OptionDescriptor(t, wd1, wd2, descrip, false), emptyOk(emptyOk), stringField(field)
{
}

void
StringOptionDescriptor::processSetting(OptionProcessor *processor, OptionValue *v)
{
    StringOptionValue *sv = static_cast<StringOptionValue*> (v);
    Option *options = processor->getOptions();

    if (v == NULL || sv->getValue().length() == 0) {
        if (emptyOk) {
            options->*stringField = strdup("");
        } else {
            throw ValueFormatException("Empty string not allowed for option", *v->toString(), v->getOptionDescriptor());
        }

    } else {
        options->*stringField = strdup(sv->getValue().c_str());
    }
}

CharOptionDescriptor::CharOptionDescriptor(const char *wd1, const char *wd2, const char *descrip,
                                           OptionProcessor::CharValueField field)
: StringOptionDescriptor(CHAR, wd1, wd2, descrip, false), charField(field)
{
}

void
CharOptionDescriptor::processSetting(OptionProcessor *processor, OptionValue *v)
{
    StringOptionValue *sv = static_cast<StringOptionValue*> (v);
    Option *options = processor->getOptions();

    if (v == NULL || sv->getValue().length() == 0) {
        throw ValueFormatException("Empty string not allowed for option", *v->toString(), v->getOptionDescriptor());
    } else {
        options->*charField = sv->getValue().at(0);
    }
}

PathOptionDescriptor::PathOptionDescriptor(const char *wd1, const char *wd2, const char *descrip,
                                           OptionProcessor::StringValueField field, bool emptyOk)
: StringOptionDescriptor(PATH, wd1, wd2, descrip, field, emptyOk)
{
}

void
PathOptionDescriptor::processSetting(OptionProcessor *processor, OptionValue *v)
{
    StringOptionDescriptor::processSetting(processor, v);

    // TODO Verify that path exists?
}

EnumOptionDescriptor::EnumOptionDescriptor(const char *wd1, const char *enumValues, OptionProcessor::ValueHandler handler)
: OptionDescriptor(ENUM, wd1, handler, false), defaultValue(NULL)
{
    setupName();
    setupEnumValues(enumValues);
}

EnumOptionDescriptor::EnumOptionDescriptor(const char *wd1, const char *wd2, const char *enumValues, OptionProcessor::ValueHandler handler)
: OptionDescriptor(ENUM, wd1, wd2, handler, false), defaultValue(NULL)
{
    setupName();
    setupEnumValues(enumValues);
}

EnumOptionDescriptor::EnumOptionDescriptor(const char *wd1, const char *wd2, const char *enumValues,
                                           const char *descrip, OptionProcessor::ValueHandler handler)
: OptionDescriptor(ENUM, wd1, wd2, descrip, handler, false), defaultValue(NULL)
{
    setupName();
    setupEnumValues(enumValues);
}

EnumOptionDescriptor::EnumOptionDescriptor(const char *wd1, const char *wd2, const char *enumValues, const char *defValue,
                                           const char *descrip, OptionProcessor::ValueHandler handler)
: OptionDescriptor(ENUM, wd1, wd2, descrip, handler, false), defaultValue(defValue)
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
