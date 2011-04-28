/*
 *  InputFile.cpp
 *  lpg
 *
 *  Created by Robert M. Fuhrer on 4/13/11.
 *  Copyright 2011 IBM Corporation. All rights reserved.
 *
 */

#include "InputFile.h"
#include "code.h"
#include "TabExpander.h"

#include <sys/stat.h>
#include <errno.h>
#include <iostream>

using namespace std;

void
InputFile::ReadInput()
{
    if (buffer_ != NULL) // file already read in
        return;
    
    const char *filename = getName();
    struct stat status;

    int rc = stat(filename, &status);

    if (rc != 0) {
        if (errno == ENOENT) {
            cerr << "File '" << filename << "' does not exist." << endl;
        } else {
            cerr << "Error " << errno << " attempting to access file information for '" << filename << "'" << endl;
        }

        bufferStart_ = buffer_ = NULL;
        bufferLength_ = 0;
        return;
    }

    FILE *srcfile = fopen(filename, "rb");

    if (srcfile != NULL)
    {
        char *buf_tmp;
        buf_tmp = new char[status.st_size + 4];
        size_t file_size = fread(buf_tmp + 1, sizeof(char), status.st_size, srcfile);
        fclose(srcfile);

        int mark_size = ByteOrderMarkSize(buf_tmp + 1);
        if (mark_size > 0)
            strncpy(buf_tmp, buf_tmp + 1, mark_size);
        buf_tmp[mark_size] = '\n';
        bufferStart_ = buf_tmp + mark_size;
        
        char *source_tail = &(buf_tmp[file_size]); // point to last character read from the file.
        //
        // Remove all trailing spaces
        //
        while((source_tail > bufferStart_) && Code::IsSpace(*source_tail))
            source_tail--;

        // The following code was in the original InputFileSymbol.ReadInput(), but it
        // didn't handle EOF correctly, b/c the scanner expects 0xff as the EOF marker.
        // Presumably just a minor difference between the expectation of the hand-written
        // scanner vs. a bootstrapped one...
//        //
//        // If the very last character is not CTL_Z then add CTL_Z
//        //
//        if (*source_tail != Code::CTL_Z)
//        {
//            if (*source_tail != Code::LINE_FEED)
//                *(++source_tail) = Code::LINE_FEED; // if the last character is not end-of-line, add end-of-line
//            *(++source_tail) = Code::CTL_Z;         // Mark end-of-file
//        }
//        *(++source_tail) = Code::NULL_CHAR; // add gate
        if (*source_tail != 0xff) {
            if (*source_tail != '\n') {
                *(++source_tail) = '\n'; // add EOL before EOF
            }
            *(++source_tail) = 0xff; // add EOF marker
        }
        *(++source_tail) = '\0'; // add null char for safety
        
        buffer_ = buf_tmp;
        bufferLength_ = source_tail - bufferStart_;

        scanForLineStarts();
    } else {
        char *buf_tmp;
        buffer_ = buf_tmp = new char[1];
        buf_tmp[0] = 0xff;
//      buf_tmp[0] = Code::CTL_Z;
//      buf_tmp[1] = Code::NULL_CHAR;
        bufferStart_ = buffer_;
        bufferLength_ = 1;
    }
    
    return;
}

void
InputFile::scanForLineStarts()
{
    const char *pEnd = bufferStart_ + bufferLength_;

    for(const char *p = bufferStart_; p < pEnd; p++) {
        if (*p == '\n') { // For the sequence \r\n only count \n.
            lineLocations_.Next() = p + 1 - bufferStart_;
        }
    }
}

unsigned
InputFile::FindLine(unsigned location)
{
    int lo = 0,
    hi = lineLocations_.Length() - 1;
    
    if (hi == 0)
        return 0;
    
    //
    // we can place the exit test at the bottom of the loop
    // since the line_location array will always contain at least
    // one element.
    //
    do
    {
        int mid = (lo + hi) / 2;
        
        if (lineLocations_[mid] == location)
            return mid;
        if (lineLocations_[mid] < location)
            lo = mid + 1;
        else hi = mid - 1;
    } while (lo < hi);
    
    return (lineLocations_[lo] > location ? lo - 1 : lo);
}

unsigned
InputFile::FindColumn(unsigned location)
{
    int index = FindLine(location);
    
    return (index <= 0 ? 0 : TabExpander::strlen(Buffer(), LineLocation(index), location));
}
