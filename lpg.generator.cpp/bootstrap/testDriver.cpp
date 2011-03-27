/*
 *  testDriver.cpp
 *  lpg
 *
 *  Created by Robert M. Fuhrer on 3/26/11.
 *  Copyright 2011 IBM. All rights reserved.
 */

#include "LPGLexersym.h"
#include "LPGKWLexer.h"
#include "LPGLexer.h"

#include <iostream>

using namespace std;

int
main(int ac, char *av[])
{
    if (ac < 2) {
        cerr << "Usage: " << av[0] << " filename" << endl;
        return 1;
    }
    LPGLexer lexer(av[1]);
    PrsStream ps;

    lexer.lexer(&ps);

    ps.dump();
    return 0;
}
