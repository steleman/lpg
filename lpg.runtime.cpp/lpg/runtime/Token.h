#ifndef LPG_RUNTIME_TOKEN_INCLUDED
#define LPG_RUNTIME_TOKEN_INCLUDED

#include <stdio.h>
#include <string.h>

class Token
{
public:
    Token(Token& t) :
        src_(t.src_), yytext_(NULL), kind_(t.kind_),
        startOffset_(t.startOffset_), endOffset_(t.endOffset_) { }

    Token() :
        src_(NULL), yytext_(NULL), kind_(0),
        startOffset_(0), endOffset_(0) {}

    Token(const  char* src, const int startOffset, const int endOffset, const int kind) :
        src_(src), yytext_(NULL), kind_(kind), 
        startOffset_(startOffset), endOffset_(endOffset) {}

    ~Token()
    {
        delete[] yytext_;
    }

    inline const int getKind() { return kind_; }

    inline const char* toString() { return getValue(); }

    int getStartOffset() { return startOffset_; }
    int getEndOffset() { return endOffset_; }

    const char* getValue()
    {
        if (yytext_) return yytext_;
        // TODO: Lock.
        int size = endOffset_ - startOffset_ + 1;
        yytext_ = new char[size + 1];
        strncpy(yytext_, src_ + startOffset_, size);
        yytext_[size] = 0;
        // printf("getValue:%d:%d:%s\n", startOffset_, endOffset_, buf);
        return yytext_;
    }

private:
    const  char* src_;
    char*        yytext_;
    int          kind_, startOffset_, endOffset_;
};

#endif
