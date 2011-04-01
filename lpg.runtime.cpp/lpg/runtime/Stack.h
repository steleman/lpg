#ifndef LPG_RUNTIME_STACK_H
#define LPG_RUNTIME_STACK_H

#include "Tuple.h"

template <class T>
class Stack : private Tuple<T>
{
public:
    bool IsEmpty() { return Length() == 0; }

    int Length() { return Tuple<T>::Length(); }

    void Reset(int n = 0) { Tuple<T>::Reset(n); }

    void Push(T t)
    {
        Tuple<T>::Next() = t;
    }

    T Pop()
    {
        assert(! IsEmpty());
        int last_index = Length() - 1;
        T t = (*this)[last_index];
        Reset(last_index);

        return t;
    }

    void Pop(T &t)
    {
        assert(! IsEmpty());
        int last_index = Length() - 1;
        t = (*this)[last_index];
        Reset(last_index);

        return;
    }

    T &Top()
    {
        assert(! IsEmpty());
        return (*this)[Length() - 1];
    }
};

#endif
