#ifndef OPTIONS_INCLUDED
#define OPTIONS_INCLUDED

/*
 *  options.h
 *  lpg
 *
 *  Created by Robert M. Fuhrer on 3/13/11.
 *  Copyright 2011 IBM. All rights reserved.
 */

#include "code.h"
#include "util.h"

#include <string>
#include <list>

enum OptionType {
    BOOLEAN,
    CHAR,
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
    typedef bool Option::*BooleanValueField;
    typedef int Option::*IntegerValueField;
    typedef const char *Option::*StringValueField;
    typedef char Option::*CharValueField;

    typedef void (OptionProcessor::*ValueHandler)(OptionValue *);

    OptionProcessor(Option *);
    
    void processActionBlock(OptionValue *v);
    void processAutomaticAST(OptionValue *v);
    void processExportTerminals(OptionValue *v);
    void processFilter(OptionValue *v);
    void processIgnoreBlock(OptionValue *v);
    void processImportTerminals(OptionValue *v);
    void processIncludeDir(OptionValue *v);
    void processNames(OptionValue *v);
    void processProgrammingLanguage(OptionValue *v);
    void processRuleClassNames(OptionValue *v);
    void processTable(OptionValue *v);
    void processTrace(OptionValue *v);
    void processTrailers(OptionValue *v);
    void processVariables(OptionValue *v);
    void processVisitor(OptionValue *v);

    Option *getOptions() const { return options; }

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
    
    virtual void processSetting(OptionProcessor *processor, OptionValue *value);

    static const std::list<OptionDescriptor*>& getAllDescriptors();

    static std::string describeAllOptions();

protected:
    OptionDescriptor(OptionType type, const char *word1, const char *word2, const char *descrip, bool valueOptional);
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

class BooleanOptionDescriptor : public OptionDescriptor {
public:
    BooleanOptionDescriptor(const char *word1, const char *word2, const char *descrip, OptionProcessor::BooleanValueField, bool valueOptional=true);

    void processSetting(OptionProcessor *, OptionValue *);

private:
    OptionProcessor::BooleanValueField boolField;
};

class IntegerOptionDescriptor : public OptionDescriptor {
public:
    IntegerOptionDescriptor(const char *word1, int min, int max, OptionProcessor::ValueHandler handler);
    IntegerOptionDescriptor(const char *word1, const char *word2, int min, int max, OptionProcessor::ValueHandler handler);
    IntegerOptionDescriptor(const char *word1, const char *word2, int min, int max, const char *descrip,
                            OptionProcessor::ValueHandler handler);
    IntegerOptionDescriptor(const char *word1, const char *word2, int min, int max, const char *descrip,
                            OptionProcessor::IntegerValueField, bool valueOpt=false);
    
    int getMinValue() const { return minValue; }
    int getMaxValue() const { return maxValue; }
    
    std::string getTypeDescriptor() const;
    
    void processSetting(OptionProcessor *, OptionValue *);
    
private:
    int minValue, maxValue;
    OptionProcessor::IntegerValueField intField;
};

class StringOptionDescriptor : public OptionDescriptor {
public:
    StringOptionDescriptor(const char *word1, const char *word2, const char *descrip,
                           OptionProcessor::StringValueField, bool emptyOk=false);

    void processSetting(OptionProcessor *, OptionValue *);

protected:
    StringOptionDescriptor(OptionType type, const char *word1, const char *word2, const char *descrip,
                           OptionProcessor::StringValueField, bool emptyOk=false);
    bool emptyOk;
    OptionProcessor::StringValueField stringField;
};

class CharOptionDescriptor : public StringOptionDescriptor {
public:
    CharOptionDescriptor(const char *word1, const char *word2, const char *descrip,
                         OptionProcessor::CharValueField);

    void processSetting(OptionProcessor *, OptionValue *);

private:
    OptionProcessor::CharValueField charField;
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

class PathOptionDescriptor : public StringOptionDescriptor {
public:
    PathOptionDescriptor(const char *word1, const char *word2, const char *descrip,
                         OptionProcessor::StringValueField, bool emptyOk=false);

    void processSetting(OptionProcessor *, OptionValue *);
};

class ValueFormatException {
public:
    ValueFormatException(const char *msg, OptionDescriptor *od)
    : msg(msg), valueStr(NULL), optDesc(od)
    { }
    
    ValueFormatException(const char *msg, const std::string& s, OptionDescriptor *od)
    : msg(msg), valueStr(s), optDesc(od)
    { }
    
    ValueFormatException(const std::string& msg, const std::string& s, OptionDescriptor *od)
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
    OptionDescriptor *findOption(const char *&start, bool& flag);
    bool IsDelimiter(char c);
    std::string *getOptionValue(const char *&p);
    
    std::list<OptionDescriptor*> allOptions;
};

#endif
