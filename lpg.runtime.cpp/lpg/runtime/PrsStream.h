#ifndef LPG_RUNTIME_PRSSTREAM_INCLUDED
#define LPG_RUNTIME_PRSSTREAM_INCLUDED

#include "tuple.h"
#include "Token.h"

class PrsStream
{
public:
    PrsStream() : tokens_(12, 16), adjuncts_(12, 16) {}
    virtual ~PrsStream() {}

    inline int getNext(int i)
      { return (++i < tokens_.Length() ? i : tokens_.Length() - 1); }

    inline int getPrevious(int i) 
      { return (i <= 0 ? 0 : i - 1); }

    inline int peek() 
      { return getNext(index_); }

    inline void reset(int i = 1) 
      { index_ = getPrevious(i); }

    inline int getToken()
      { return index_ = getNext(index_); }

    inline int getToken(int end_token)
      { return index_ = (index_ < end_token ? getNext(index_) : tokens_.Length() - 1); }

    inline int badToken()
      { return 0; }

    inline unsigned getKind(int i)
      { return tokens_[i].getKind(); }

    inline void resetTokenStream(int size = 0)
      { tokens_.Reset(size); }

    inline void makeToken(const char* inputChars, int startLoc, int endLoc, int kind)
    {
        Token token(inputChars, startLoc, endLoc, kind);
        tokens_.Push(token);
    }

    inline void makeAdjunct(const char* inputChars, int startLoc, int endLoc, int kind)
    {
        Adjunct adjunct(inputChars, startLoc, endLoc, kind);
        adjunct.setTokenIndex(tokens_.Length() - 1);
        adjuncts_.Push(adjunct);
    }

    void dump()
    {
        printf("TOKENS(%d)\n", tokens_.Length());
        for (int i = 0; i < tokens_.Length(); i++) {
            printf("% 4d [%d..%d] : [% 4d] %s\n", i, 
		   tokens_[i].getStartOffset(),
		   tokens_[i].getEndOffset(),
                   tokens_[i].getKind(),
                   tokens_[i].getValue());
        }
    }

    inline Token* getToken(int i)
    {
        return &tokens_[i];
    }

protected:
    Tuple<Token> tokens_;
    Tuple<Token> adjuncts_;
    int index_;
};
#endif
