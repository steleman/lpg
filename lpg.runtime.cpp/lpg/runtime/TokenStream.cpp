/*
 *  TokenStream.cpp
 *  lpg
 *
 *  Created by Robert M. Fuhrer on 4/28/11.
 *  Copyright 2011 IBM Corporation. All rights reserved.
 *
 */

#include "TokenStream.h"

void
TokenStream::dump()
{
    InputFile *f = NULL;
    
    printf("  TOTAL TOKENS: %d\n", tokens_.Length());
    for (int i = 0; i < tokens_.Length(); i++) {
        Token& token = tokens_[i];
        
        if (token.getInputFile() != f) {
            printf("FILE: %s\n", token.getInputFile()->getName());
            f = token.getInputFile();
        }
        printf("% 4d [%5d..%5d: <%d,%d>..<%d,%d>] : [% 4d] %s\n", i, 
               token.getStartOffset(),
               token.getEndOffset(),
               token.getLine(),
               token.getColumn(),
               token.getEndLine(),
               token.getEndColumn(),
               token.getKind(),
               token.getValue());
    }
//    printf("TOKENS(%d)\n", tokens_.Length());
//    for (int i = 0; i < tokens_.Length(); i++) {
//        printf("% 4d [%5d..%5d] : [% 4d] %s\n", i, 
//               tokens_[i].getStartOffset(),
//               tokens_[i].getEndOffset(),
//               tokens_[i].getKind(),
//               tokens_[i].getValue());
//    }
}
