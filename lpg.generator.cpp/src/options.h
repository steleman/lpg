#ifndef OPTIONS_INCLUDED
#define OPTIONS_INCLUDED

/*
 *  options.h
 *  lpg
 *
 *  Created by Robert M. Fuhrer on 3/13/11.
 *  Copyright 2011 . All rights reserved.
 */

#include "code.h"
#include "util.h"

#include <string>
#include <list>
#include <iostream>

enum OptionType {
    BOOLEAN,
    ENUM,
    INTEGER,
    STRING,
    STRING_LIST,
    PATH,
    PATH_LIST
};

class Option;
class OptionValue;

class OptionProcessor {
public:
    typedef void (OptionProcessor::*ValueHandler)(OptionValue *);
    
    OptionProcessor(Option *);
    
    void processAnyOption(OptionValue *v);

    void processActionBlock(OptionValue *v);
    void processASTdirectory(OptionValue *v);
    void processASTtype(OptionValue *v);
    void processAttributes(OptionValue *v);
    void processAutomaticAST(OptionValue *v);
    void processDebug(OptionValue *v);
    void processIncludeDir(OptionValue *v);
    void processLALR(OptionValue *v);
    void processNames(OptionValue *v);
    void processSoftKeywords(OptionValue *v);
    void processVariables(OptionValue *v);
    
private:
    Option *options;
};

class OptionDescriptor {
public:
    OptionDescriptor(OptionType type, const char *word1, OptionProcessor::ValueHandler handler, bool valueOptional = false);
    OptionDescriptor(OptionType type, const char *word1, const char *word2, OptionProcessor::ValueHandler handler, bool valueOptional = false);
    OptionDescriptor(OptionType type, const char *word1, const char *word2, const char *descrip, OptionProcessor::ValueHandler handler, bool valueOptional = false);

    const char *getWord1() const { return word1; }
    const char *getWord2() const { return (word2 != NULL) ? word2 : ""; }
    const std::string& getName() const { return name; }
    const char *getDescription() const { return description; }
    OptionType getType() const { return type; }
    virtual std::string getTypeDescriptor() const;
    bool isValueOptional() const { return valueOptional; }
    
    OptionValue *createValue();
    
    void processSetting(OptionProcessor *processor, OptionValue *value);

    static const std::list<OptionDescriptor*>& getAllDescriptors();

    static std::string describeAllOptions();

protected:
    void setupName();
    
    const OptionType type;
    const char *word1;
    const char *word2; // may be null
    std::string name;
    const char *description;
    const bool valueOptional;
    OptionProcessor::ValueHandler valueHandler;

    static std::list<OptionDescriptor*> allOptionDescriptors;
};

class EnumOptionDescriptor : public OptionDescriptor {
public:
    EnumOptionDescriptor(const char *word1, const char *enumValues, OptionProcessor::ValueHandler handler);
    EnumOptionDescriptor(const char *word1, const char *word2, const char *enumValues, OptionProcessor::ValueHandler handler);
    EnumOptionDescriptor(const char *word1, const char *word2, const char *enumValues,
                         const char *descrip, OptionProcessor::ValueHandler handler);
    EnumOptionDescriptor(const char *word1, const char *word2, const char *enumValues,
                         const char *defValue, const char *descrip, OptionProcessor::ValueHandler handler);
    
    const std::list<std::string>& getLegalValues() const { return legalValues; }
    const char *getDefaultValue() const { return defaultValue; }
    
    std::string getTypeDescriptor() const;

private:
    void setupEnumValues(const char *);

    std::list<std::string> legalValues;
    const char *defaultValue;
};

class IntegerOptionDescriptor : public OptionDescriptor {
public:
    IntegerOptionDescriptor(const char *word1, int min, int max, OptionProcessor::ValueHandler handler);
    IntegerOptionDescriptor(const char *word1, const char *word2, int min, int max, OptionProcessor::ValueHandler handler);
    IntegerOptionDescriptor(const char *word1, const char *word2, int min, int max, const char *descrip,
                            OptionProcessor::ValueHandler handler);

    int getMinValue() const { return minValue; }
    int getMaxValue() const { return maxValue; }

    std::string getTypeDescriptor() const;

private:
    int minValue, maxValue;
};

class ValueFormatException {
public:
    ValueFormatException(const char *msg, OptionDescriptor *od)
    : msg(msg), valueStr(NULL), optDesc(od)
    { }
    
    ValueFormatException(const char *msg, std::string& s, OptionDescriptor *od)
    : msg(msg), valueStr(s), optDesc(od)
    { }
    
    ValueFormatException(std::string& msg, std::string& s, OptionDescriptor *od)
    : msg(msg), valueStr(s), optDesc(od)
    { }
    
    const std::string& message() { return msg; }
    const std::string& value() { return valueStr; }
    const OptionDescriptor *optionDescriptor() { return optDesc; }
    
private:
    std::string msg;
    std::string valueStr;
    OptionDescriptor *optDesc;
};

class OptionValue : public Code, public Util {
public:
    OptionDescriptor *getOptionDescriptor() const { return optionDesc; }
    
    virtual void parseValue(std::string *v, OptionDescriptor *od) throw(ValueFormatException) = 0;
    virtual const std::string *toString() = 0;
    
protected:
    OptionValue(OptionDescriptor *od) : optionDesc(od) { }
    
private:
    OptionDescriptor *optionDesc;
};

class BooleanOptionValue : public OptionValue {
public:
    BooleanOptionValue(OptionDescriptor *od) : OptionValue(od) { }
    
    void setValue(bool v) { value = v; }
    bool getValue() { return value; }
    
    void parseValue(std::string *v, OptionDescriptor *od) throw(ValueFormatException);
    const std::string *toString();
    
private:
    bool value;
};

class IntegerOptionValue : public OptionValue {
public:
    IntegerOptionValue(OptionDescriptor *od) : OptionValue(od) { }
    
    void setValue(int v) { value = v; }
    int getValue() { return value; }
    
    void parseValue(std::string *v, OptionDescriptor *od) throw(ValueFormatException);
    const std::string *toString();

private:
    int value;
};

class StringOptionValue : public OptionValue {
public:
    StringOptionValue(OptionDescriptor *od) : OptionValue(od) { }

    void setValue(const char *v) { value = v; }
    const std::string& getValue() { return value; }

    void parseValue(std::string *v, OptionDescriptor *od) throw(ValueFormatException);
    const std::string *toString();

protected:
    std::string value;
};

class EnumOptionValue : public StringOptionValue {
public:
    EnumOptionValue(OptionDescriptor *od) : StringOptionValue(od) { }

    void parseValue(std::string *v, OptionDescriptor *od) throw(ValueFormatException);
};

class PathOptionValue : public StringOptionValue {
public:
    PathOptionValue(OptionDescriptor *od) : StringOptionValue(od) { }
};

class StringListOptionValue : public OptionValue {
public:
    StringListOptionValue(OptionDescriptor *od) : OptionValue(od) { }

    const std::list<std::string>& getValue() { return values; }
    void addValue(const char *v);
    void addValues(const StringListOptionValue &other);

    void parseValue(std::string *v, OptionDescriptor *od) throw(ValueFormatException);
    const std::string *toString();

protected:
    std::list<std::string> values;
};

class PathListOptionValue : public StringListOptionValue {
public:
    PathListOptionValue(OptionDescriptor *od) : StringListOptionValue(od) { }

    void parseValue(std::string *v, OptionDescriptor *od) throw(ValueFormatException);
    const std::string *toString();
};

class OptionParser : public Code, public Util {
public:
    OptionParser(const std::list<OptionDescriptor*> descriptors);

    OptionValue *parse(const char *&start) throw(ValueFormatException);

private:
    OptionDescriptor *findOption(const char *&start);
    bool IsDelimiter(char c);
    std::string *getOptionValue(const char *&p);
    
    std::list<OptionDescriptor*> allOptions;
};

#endif
