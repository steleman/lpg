/*
 *  optionValues.cpp
 *  lpg
 *
 *  Created by Robert M. Fuhrer on 3/21/11.
 *  Copyright 2011 IBM.
 */

#include "options.h"

static const std::string *TRUE_VALUE_STR = new std::string("true");
static const std::string *FALSE_VALUE_STR = new std::string("false");

void
BooleanOptionValue::parseValue(std::string *v, OptionDescriptor *od) throw(ValueFormatException)
{
    if (v == NULL) {
        if (od->isValueOptional()) {
            value = true;
        } else {
            throw ValueFormatException("Missing boolean value", od);
        }
    } else if (!v->compare(*TRUE_VALUE_STR)) {
        value = true;
    } else if (!v->compare(*FALSE_VALUE_STR)) {
        value = false;
    } else {
        throw ValueFormatException("Invalid boolean value", *v, od);
    }
}

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
    EnumOptionDescriptor *eod = static_cast<EnumOptionDescriptor*> (od);
    
    std::list<std::string> legalValues = eod->getLegalValues();

    if (v == NULL) {
        value = eod->getDefaultValue();
        return;
//      throw ValueFormatException("Missing enum value", od);
    }
    
    int endIdx = v->find_first_of(',');
    
    std::string enumValue = v->substr(0, endIdx);
    
    
    // Check that the given value is one of the allowed values
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
StringListOptionValue::addValue(const char *s)
{
    std::string v = s;
    values.push_back(v);
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
        const char *pSep = strchr(pStart, ',');
        std::string *val;

        const char *pEnd = (pSep != NULL ? pSep : pStart + strlen(pStart));
        while (*pStart != '\0' && *pStart == ' ') { // trim leading spaces
            pStart++;
        }
        if (*pStart == '"') { // trim leading quote
            pStart++;
        }
        if (*(pEnd-1) == '"') { // trim trailing quote
            pEnd--;
        }
        val = new std::string(pStart, pEnd - pStart);
        if (pSep != NULL) {
            pStart = pSep + 1;
        } else {
            pStart = NULL;
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
        const char *pEnd = strchr(pStart, ';');
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
