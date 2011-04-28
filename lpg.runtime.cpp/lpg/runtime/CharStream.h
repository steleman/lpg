#ifndef LPG_RUNTIME_CHARSTREAM_H
#define LPG_RUNTIME_CHARSTREAM_H

#include "tuple.h"
#include "InputFile.h"
#include "TokenStream.h"

#include <iostream>

class CharStream
{
protected:
    InputFile   inputFile_;
    const char  *inputChars_;  // cached from input file
    int         streamLength_; // cached from input file
    int         index_;        // index of current char in stream
    TokenStream *tokenStream_; // where created tokens go

public:
    CharStream(const char* fileName) :
        inputFile_(fileName), tokenStream_(NULL)
    {
        inputChars_ = inputFile_.Buffer();
        streamLength_ = inputFile_.BufferLength();
    }

    virtual ~CharStream() {
//      delete[] inputChars_; // don't do this; we don't own the buffer
    }

    // Derived classes must implement
    virtual int lexer(TokenStream* ts) = 0;

    // Most derived classes should implement
    virtual void ruleAction(int n) {}

    inline const char* getInputChars()
    {
        return inputChars_;
    }

// Is there any diff betw. "input length" and "stream length"??
    inline int getInputLength()
    {
        return streamLength_;
    }

    const char *getFileName()
    {
        return inputFile_.getName();
    }

    inline void setStreamIndex(int index)
    {
        index_ = index;
    }

    inline int getStreamIndex()
    {
        return index_;
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
    
    int getNext(int i) { return (++i < streamLength_ ? i : streamLength_); }
    
    int getPrevious(int i) { return (i <= 0 ? 0 : i - 1); }
    
    int peek() { return getNext(index_); }
    
    void reset(int i) { index_ = i - 1; }
    
    void reset() { index_ = -1; }

//
// TODO
// The token factory methods arguably don't belong here on the LexStream/CharStream.
// On the other hand, it does make writing the rule actions a bit less verbose...
//

    inline void makeToken(int startLoc, int endLoc, int kind)
    {
        tokenStream_->makeToken(&inputFile_, startLoc, endLoc, kind);
    }

    inline void makeAdjunct(int startLoc, int endLoc, int kind)
    {
        tokenStream_->makeAdjunct(&inputFile_, startLoc, endLoc, kind);
    }

    void reportLexicalError(int left_loc, int right_loc)
    {
        const char *msg = (right_loc >= streamLength_) ? "End-of-file" : "Invalid token";
        char errorChar = inputFile_.Buffer()[index_];

        std::cerr << inputFile_.getName() << ", line " << inputFile_.FindLine(left_loc) << ", column " << inputFile_.FindColumn(left_loc)
                  << " at char '" << errorChar << "' (value " << ((int) errorChar) << "): " << msg <<  std::endl;
    }

    inline void dump()
    {
        tokenStream_->dump();
    }
};
#endif
