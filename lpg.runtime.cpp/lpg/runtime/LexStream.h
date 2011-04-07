#ifndef LPG_RUNTIME_LEXSTREAM_H
#define LPG_RUNTIME_LEXSTREAM_H

#include <limits.h>

#include "tuple.h"
#include "Stacks.h"
#include "PrsStream.h"

class LexStream
{
protected:
    PrsStream  *prsStream_;
    const char *fileName_;
    const char *inputChars_;
    int        streamLength_;
    int        index_;

public:
    LexStream(const char* fileName) :
        prsStream_(NULL), fileName_(fileName)
    {
        FILE*  fp;
        size_t size, n;
        fp = fopen(fileName, "r");
        if (!fp) { exit(1); }

        fseek(fp, 0, SEEK_END); 
        size = ftell(fp); 
        fseek(fp, 0, SEEK_SET);

        int charLen = size + 3;
        char *tmp = new char[charLen+1];
        n = fread(tmp, 1, size, fp);
        tmp[n] = 0xff; tmp[n+1] = 0;
        streamLength_ = charLen;
        fclose(fp);
        inputChars_ = tmp;
    }

    virtual ~LexStream() { delete[] inputChars_; }

    virtual void ruleAction(int n) {}

    virtual int lexer(PrsStream* ps) =0;

    void setInputChars(const char *chars)
    {
        inputChars_ = chars;
        index_ = -1;
        streamLength_ = strlen(inputChars_);
    }

    inline const char* getInputChars()
    {
        return inputChars_;
    }

    inline int getInputLength()
    {
        return streamLength_;
    }

    const char *getFileName()
    {
        return fileName_;
    }

    inline void setStreamIndex(int index)
    {
        index_ = index;
    }

    inline int getStreamIndex()
    {
        return index_;
    }

    inline void setStreamLength(int len)
    {
        streamLength_ = len;
    }

    inline int getStreamLength()
    {
        return streamLength_;
    }

    inline int getCharValue(int idx)
    {
        return inputChars_[idx];
    }

    inline int getToken()
    {
        return index_ = getNext(index_);
    }
    
    inline int getToken(int end_token)
    {
        return index_ = (index_ < end_token ? getNext(index_) : streamLength_);
    }
    
//    virtual int getKind(int i) = 0;
    
    int getNext(int i) { return (++i < streamLength_ ? i : streamLength_); }
    
    int getPrevious(int i) { return (i <= 0 ? 0 : i - 1); }
    
    int peek() { return getNext(index_); }
    
    void reset(int i) { index_ = i - 1; }
    
    void reset() { index_ = -1; }

    inline void makeToken(int startLoc, int endLoc, int kind)
    {
        prsStream_->makeToken(inputChars_, startLoc, endLoc, kind);
    }

    inline void makeAdjunct(int startLoc, int endLoc, int kind)
    {
        prsStream_->makeAdjunct(inputChars_, startLoc, endLoc, kind);
    }

    void reportLexicalError(int left_loc, int right_loc)
    {
        const char *msg = (right_loc >= streamLength_) ? "End-of-file" : "Invalid token";
        std::cerr << fileName_ << ", line " << left_loc << ", column " << right_loc << ": " << msg <<  std::endl;
    }

    inline void dump()
    {
        prsStream_->dump();
    }
};
#endif
