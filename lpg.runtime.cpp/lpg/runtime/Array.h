#ifndef LPG_RUNTIME_ARRAY_H
#define LPG_RUNTIME_ARRAY_H

#include <string.h>
#include <stdlib.h>

//
// Wrapper for a simple array
//
template <class T>
class Array
{
    int size;
    T *info;

public:
    Array() : size(0),
              info(NULL)
    {}

    Array(int size_) : size(size_)
    {
        info = new T[size];
    }

    Array(int size_, T value) : size(size_)
    {
        info = new T[size];
        Initialize(value);

        return;
    }

    ~Array()
    {
        delete [] info;
    }

    void Initialize(T init_value)
    {
        for (int i = 0; i < size; i++)
            info[i] = init_value;
    }

    void Resize(int new_size)
    {
        if (new_size > size)
        {
            T *old_info = info;
            info = (T *) memmove(new T[new_size], old_info, size * sizeof(T));
            delete [] old_info;
        }
        size = new_size;

        return;
    }

    void Reallocate(int new_size)
    {
        if (new_size > size)
        {
            T *old_info = info;
            info = (T *) new T[new_size];
            delete [] old_info;
        }
        size = new_size;

        return;
    }

    //
    // Set all fields in the array to val.
    //
    void Memset(int val = 0)
    {
        memset(info, val, size * sizeof(T));
    }

    //
    // Set all field in the array to 0 starting at index i.
    //
    void MemReset(int i = 0)
    {
        if (size == 0)
            return;

        //
        // Use this code when debugging to force a crash instead of
        // allowing the assertion to be raised.
        //
        //if (i < 0 || i >= size)
        //{
        //    Array<T> *a = NULL;
        //    a -> size = 0;
        //}
        assert(! OutOfRange(i));

        int length = size - i;
        memset(&info[i], 0, length * sizeof(T));
    }

    int Size() { return size; }

    //
    // Can the array be indexed with i?
    //
    inline bool OutOfRange(const int i) { return (i < 0 || i >= size); }

    //
    // Return the ith element of the array
    //
    T &operator[](const int i)
    {
        //
        // Use this code when debugging to force a crash instead of
        // allowing the assertion to be raised.
        //
        //if (i < 0 || i >= size)
        //{
        //    Array<T> *a = NULL;
        //    a -> size = 0;
        //}
        assert(! OutOfRange(i));

        return info[i];
    }
};
#endif
