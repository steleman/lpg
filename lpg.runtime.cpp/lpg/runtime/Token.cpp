/*
 *  Token.cpp
 *  lpg
 *
 *  Created by Robert M. Fuhrer on 4/15/11.
 *  Copyright 2011 IBM Corporation. All rights reserved.
 */

#include "Token.h"
#include "tab.h"

//unsigned
//Token::FindLine(Tuple<unsigned> &line_location, unsigned location)
//{
//    int lo = 0,
//    hi = line_location.Length() - 1;
//    
//    if (hi == 0)
//        return 0;
//    
//    //
//    // we can place the exit test at the bottom of the loop
//    // since the line_location array will always contain at least
//    // one element.
//    //
//    do
//    {
//        int mid = (lo + hi) / 2;
//        
//        if (line_location[mid] == location)
//            return mid;
//        if (line_location[mid] < location)
//            lo = mid + 1;
//        else hi = mid - 1;
//    } while (lo < hi);
//    
//    return (line_location[lo] > location ? lo - 1 : lo);
//}
//
//unsigned
//Token::FindColumn(InputFile *file, unsigned location)
//{
//    int index = FindLine(file -> LineLocation(), location);
//
//    return (index == 0 ? 0 : Tab::strlen(file -> Buffer(), file -> LineLocation(index), location));
//}
