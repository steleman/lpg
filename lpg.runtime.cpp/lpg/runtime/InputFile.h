#ifndef __LPG_RUNTIME_INPUTFILE_H
#define __LPG_RUNTIME_INPUTFILE_H

#include "tuple.h"

/*
 *  InputFile.h
 *  lpg
 *
 *  Created by Robert M. Fuhrer on 4/13/11.
 *  Copyright 2011 IBM Corporation. All rights reserved.
 */
class InputFile {
public:
    InputFile(const char *name)
    : name_(name), locked_(false), buffer_(NULL), bufferStart_(NULL), bufferLength_(0)
    { }

    virtual ~InputFile()
    {
        delete[] buffer_;
    }
    
    const char *getName() const
    {
        return name_;
    }

    void Lock()           { locked_ = true; }
    void Unlock()         { locked_ = false; }
    bool IsLocked() const { return locked_; }

    Tuple<unsigned> &LineLocation() { return lineLocations_; }
    Tuple<unsigned> *LineLocationReference() { return &lineLocations_; }
    unsigned LineLocation(int index) { return lineLocations_[index]; }

    unsigned FindLine(unsigned location);
    unsigned FindColumn(unsigned location);

    const char *Buffer() {
        if (buffer_ == NULL) { ReadInput(); }
        return bufferStart_;
    }
    int BufferLength() { return bufferLength_; }

private:
    void ReadInput();
    void scanForLineStarts();
    
    const char *name_;
    bool locked_;
    const char *buffer_;
    const char *bufferStart_;
    int bufferLength_;
    Tuple<unsigned> lineLocations_;

    //
    // If the input file is in UTF-8 format, then the first three
    // characters are a marker that indicates this.
    //
    int ByteOrderMarkSize(const char *cursor)
    {
        return (cursor[0] == (char) 0xEF &&
                cursor[1] == (char) 0xBB &&
                cursor[2] == (char) 0xBF
                ? 3
                : 0);
    }
};
#endif
