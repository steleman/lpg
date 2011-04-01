#ifndef LPG_RUNTIME_LEXSTREAM_H
#define LPG_RUNTIME_LEXSTREAM_H

#include <limits.h>

#include "tuple.h"
#include "Stacks.h"
#include "PrsStream.h"

class LexStream
{
protected:
    PrsStream *prsStream_;
    char      *inputChars_;
public:
    LexStream(const char* fileName) :
        prsStream_(NULL)
    {
        FILE*  fp;
        size_t size, n;
        fp = fopen(fileName, "r");
        if (!fp) { exit(1); }

        fseek(fp, 0, SEEK_END); 
        size = ftell(fp); 
        fseek(fp, 0, SEEK_SET);

        inputChars_ = new char[size+4];
        n = fread(inputChars_, 1, size, fp);
        inputChars_[n] = 0xff; inputChars_[n+1] = 0;
        fclose(fp);
    }
    virtual ~LexStream() { delete[] inputChars_; }
    virtual void ruleAction(int n) {};
    virtual int lexer(PrsStream* ps) =0;
    inline char* getInputChars()
      { return inputChars_; }

    inline void makeToken(int startLoc, int endLoc, int kind)
    {
        prsStream_->makeToken(inputChars_, startLoc, endLoc, kind);
    }

    inline void makeAdjunct(int startLoc, int endLoc, int kind)
    {
        prsStream_->makeAdjunct(inputChars_, startLoc, endLoc, kind);
    }

    inline void dump()
    { prsStream_->dump(); }
};
#endif
