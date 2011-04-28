#ifndef LPG_RUNTIME_TOKEN_STREAM_H
#define LPG_RUNTIME_TOKEN_STREAM_H

#include "Tuple.h"
#include "Token.h"
#include "Adjunct.h"

class TokenStream
{
public:
    TokenStream() : tokens_(12, 16), adjuncts_(12, 16) {}

    virtual ~TokenStream() {}

    inline Token* getToken(int i)
    {
        return &tokens_[i];
    }

    inline int getNext(int i)
      { return (++i < tokens_.Length() ? i : tokens_.Length() - 1); }

    inline int getPrevious(int i) 
      { return (i <= 0 ? 0 : i - 1); }

    inline int peek() 
      { return getNext(index_); }

    inline void reset(int i = 1) 
      { index_ = getPrevious(i); }

    inline int getTokenIndex()
      { return index_ = getNext(index_); }

    inline int getTokenIndex(int end_token)
      { return index_ = (index_ < end_token ? getNext(index_) : tokens_.Length() - 1); }

    inline unsigned getKind(int i)
      { return tokens_[i].getKind(); }

    inline int getStreamLength() { return tokens_.Length(); }

    inline void resetTokenStream(int size = 0)
      { tokens_.Reset(size); }

    inline int badToken()
      { return 0; }

    inline void makeToken(InputFile *file, int startLoc, int endLoc, int kind)
    {
        Token token(file, startLoc, endLoc, kind);
        tokens_.Push(token);
    }

    inline void makeAdjunct(InputFile *file, int startLoc, int endLoc, int kind)
    {
        Adjunct adjunct(file, startLoc, endLoc, kind);

        adjunct.setTokenIndex(tokens_.Length() - 1);
        adjuncts_.Push(adjunct);
    }

    void dump();

protected:
    Tuple<Token> tokens_;
    Tuple<Token> adjuncts_;
    int index_;
};
#endif
