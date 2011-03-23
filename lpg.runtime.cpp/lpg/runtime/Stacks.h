#ifndef LPG_RUNTIME_STACKS_INCLUDED
#define LPG_RUNTIME_STACKS_INCLUDED

#include <limits.h>
#include <iostream>

#include "tuple.h"
#include "Adjunct.h"

class Stacks
{
protected:
    int          stateStackTop_;
    Array<int>   stateStack_;
    Array<int>   locationStack_;
    Array<void*> parseStack_;
    enum { STACK_INCREMENT = 256 };

    Stacks() : stateStackTop_(-1) {}

    void reallocateStacks()
    {
        int new_size = stateStack_.Size() + STACK_INCREMENT;
    
        assert(new_size <= SHRT_MAX);
        stateStack_.Resize(new_size);
        locationStack_.Resize(new_size);
        parseStack_.Resize(new_size);
    
        return;
    }

public:
    inline void setSym(void* sym)
    {
        parseStack_[stateStackTop_] = sym;
    }
    inline void* getSym(int i) 
    {
        return parseStack_[stateStackTop_ + (i - 1)]; 
    }
    inline int getToken(int i)
    {
        return locationStack_[stateStackTop_ + (i - 1)];
    }
};

#endif
