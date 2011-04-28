#ifndef LPG_RUNTIME_TOKEN_H
#define LPG_RUNTIME_TOKEN_H

#include <stdio.h>
#include <string.h>

#include "InputFile.h"

class Token
{
public:
    Token(const Token& t) :
        inputFile_(t.inputFile_), image_(NULL), kind_(t.kind_),
        startOffset_(t.startOffset_), endOffset_(t.endOffset_) { }

    Token() :
        inputFile_(NULL), image_(NULL), kind_(0),
        startOffset_(0), endOffset_(0) {}

    Token(InputFile *file, const int startOffset, const int endOffset, const unsigned kind) :
        inputFile_(file), image_(NULL), kind_(kind), 
        startOffset_(startOffset), endOffset_(endOffset) {}

    ~Token()
    {
        delete[] image_;
    }

    InputFile *getInputFile() const { return inputFile_; }
    void SetInputFile(InputFile *f) { inputFile_ = f; delete[] image_; image_ = NULL; }

    inline unsigned getKind() const { return kind_; }
    inline unsigned Kind() const    { return kind_; }
    void SetKind(unsigned kind) { kind_ = kind; }

    const char* toString() { return getValue(); }

    unsigned getStartOffset() const { return startOffset_; }
    unsigned StartLocation()  const { return getStartOffset(); }
    void SetLocation(unsigned loc) { startOffset_ = loc; endOffset_ = loc; }

    unsigned getEndOffset()   const { return endOffset_; }
    unsigned EndLocation()    const { return getEndOffset(); }
    void SetEndLocation(unsigned loc) { endOffset_ = loc; }

    const char* getValue()
    {
        if (image_) return image_;
        if (inputFile_->Buffer() == NULL && startOffset_ == 0 && endOffset_ == 0) {
            return "<EOF>";
        }
        // TODO: Lock.
        int size = endOffset_ - startOffset_ + 1;
        char *tmp = new char[size + 1];
        strncpy(tmp, inputFile_->Buffer() + startOffset_, size);
        tmp[size] = 0;
        // printf("getValue:%d:%d:%s\n", startOffset_, endOffset_, buf);
        image_ = tmp;
        return image_;
    }

    unsigned getLine() const    { return inputFile_ -> FindLine(getStartOffset()); }
    unsigned Line() const       { return inputFile_ -> FindLine(getStartOffset()); }

    unsigned getEndLine() const { return inputFile_ -> FindLine(getEndOffset());  }
    unsigned EndLine() const    { return inputFile_ -> FindLine(getEndOffset());  }

    unsigned getColumn() const    { return inputFile_ -> FindColumn(getStartOffset()); }
    unsigned Column() const       { return inputFile_ -> FindColumn(getStartOffset()); }

    unsigned getEndColumn() const { return inputFile_ -> FindColumn(getEndOffset()); }
    unsigned EndColumn() const    { return inputFile_ -> FindColumn(getEndOffset()); }

//  static unsigned FindLine(Tuple<unsigned> &line_location, unsigned location);
//  static unsigned FindColumn(InputFile *file, unsigned location);

private:
    InputFile*  inputFile_;
//  const char* src_;
    const char* image_;
    unsigned    kind_, startOffset_, endOffset_;
};

//template<class T>
//class DataToken : public Token {
//public:
//    DataToken(InputFile* file, int startOffset, int endOffset, int kind, T *data)
//      : Token(file, startOffset, endOffset, kind), data_(data)
//    { }
//
//    void setData(T *val) { data_ = val; }
//    T *getData() { return data_; }
//
//private:
//    T*          data_;
//};
#endif
