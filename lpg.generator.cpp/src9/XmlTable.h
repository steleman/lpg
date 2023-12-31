#ifndef XmlTable_INCLUDED
#define XmlTable_INCLUDED

#include "table.h"

class XmlTable : public Table
{
protected:

    UnbufferedTextFile tab_buffer;

    void PrintTable(Array<int> &, int, int, int);
    void PrintSymbol(int, const char *);

    Option *option;
    Grammar *grammar;

public:

    XmlTable(Control *control_) : Table(control_),
                                  tab_buffer(&systab),
                                  option(control_ -> option),
                                  grammar(control_ -> grammar)
    {}

    virtual ~XmlTable() {}

    virtual void OutputTables(void);
};

#endif /* XmlTable_INCLUDED */
