#ifndef LPG_RUNTIME_ADJUNCT_H
#define LPG_RUNTIME_ADJUNCT_H

#include "Token.h"

class Adjunct : public Token
{
    int tokenIndex;
public:
    Adjunct(const char* src, const int startOffset, const int endOffset, const int kind) :
        Token(src, startOffset, endOffset, kind) {}

    void setTokenIndex(int idx)
    {
        tokenIndex = idx;
    }
};
#endif
