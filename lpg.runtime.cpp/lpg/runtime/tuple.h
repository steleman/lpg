#ifndef LPG_RUNTIME_TUPLE_H
#define LPG_RUNTIME_TUPLE_H

#include <string.h>
#include <stdlib.h>
#include <stdio.h>
#include <assert.h>

#include "Array.h"

//
// This Tuple template class can be used to construct a dynamic
// array of arbitrary objects. The space for the array is allocated
// in blocks of size 2**LOG_BLKSIZE. In declaring a tuple the user
// may specify an estimate of how many elements he expects. Based
// on that estimate, suitable values are calculated for log_blksize
// and base_increment. If these estimates are found to be off later,
// more space will be allocated.
//
template <class T>
class Tuple
{
protected:

    enum { DEFAULT_LOG_BLKSIZE = 3, DEFAULT_BASE_INCREMENT = 4 };

    Array<T *> base;
    int top,
        size;

    int log_blksize,
        base_increment;

    inline int Blksize() { return (1 << log_blksize); }

    //
    // Allocate another block of storage for the dynamic array.
    //
    inline void AllocateMoreSpace()
    {
        //
        // The variable size always indicates the maximum number of
        // elements that has been allocated for the array.
        // Initially, it is set to 0 to indicate that the array is empty.
        // The pool of available elements is divided into segments of size
        // 2**log_blksize each. Each segment is pointed to by a slot in
        // the array base.
        //
        // By dividing size by the size of the segment we obtain the
        // index for the next segment in base. If base is full, it is
        // reallocated.
        //
        //
        int k = size >> log_blksize; /* which segment? */

        //
        // If the base is overflowed, reallocate it and initialize the new elements to NULL.
        //
        if (k == base.Size())
        {
            base.Resize(k == 0 ? base_increment : k * 2);
            base.MemReset(k); // initialize the new base elements
        }

        //
        // We allocate a new segment and place its adjusted address in
        // base[k]. The adjustment allows us to index the segment directly,
        // instead of having to perform a subtraction for each reference.
        // See operator[] below.
        //
        base[k] = new T[Blksize()];
        base[k] -= size;

        //
        // Finally, we update SIZE.
        //
        size += Blksize();

        return;
    }

public:

    //
    // This function is invoked with an integer argument n. It ensures
    // that enough space is allocated for n elements in the dynamic array.
    // I.e., that the array will be indexable in the range  (0..n-1)
    //
    // Note that this function can be used as a garbage collector.  When
    // invoked with no argument(or 0), it frees up all dynamic space that
    // was allocated for the array.
    //
    inline void Resize(const int n = 0)
    {
        //if (n < 0)
        //{
        //    Tuple<T> *p = NULL;
        //    p -> top = 0;
        //}
        assert(n >= 0);

        //
        // If array did not previously contain enough space, allocate
        // the necessary additional space. Otherwise, if the array had
        // more blocks than are needed, release the extra blocks.
        //
        if (n > size)
        {
            do
            {
                AllocateMoreSpace();
            } while (n > size);
        }
        else if (n < size)
        {
            // slot is the index of the base element whose block
            // will contain the (n-1)th element.
            int slot = (n <= 0 ? -1 : (n - 1) >> log_blksize);

            for (int k = (size >> log_blksize) - 1; k > slot; k--)
            {
                size -= Blksize();
                base[k] += size;
                delete [] base[k];
                base[k] = NULL;
            }

            if (slot < 0)
                base.Resize(0);
        }

        top  = n;
    }

    //
    // This function is used to reset the size of a dynamic array without
    // allocating or deallocting space. It may be invoked with an integer
    // argument n which indicates the new size or with no argument which
    // indicates that the size should be reset to 0.
    //
    inline void Reset(const int n = 0)
    {
        //
        // Use this code when debugging to force a crash instead of
        // allowing the assertion to be raised.
        //
        // if (! (n >= 0 && n <= top))
        // {
        //     Tuple<T> *p = NULL;
        //     p -> top = 0;
        // }
        //
        assert(n >= 0 && n <= top);

        top = n;
    }

    //
    // Return length of the dynamic array.
    //
    inline int Length() { return top; }

    //
    // Can the tuple be indexed with i?
    //
    inline bool OutOfRange(const int i) { return (i < 0 || i >= top); }

    //
    // Return a reference to the ith element of the dynamic array.
    //
    // Note that no check is made here to ensure that 0 <= i < top.
    // Such a check might be useful for debugging and a range exception
    // should be thrown if it yields true.
    //
    inline T& operator[](const int i)
    {
        //
        // Use this code when debugging to force a crash instead of
        // allowing the assertion to be raised.
        //
        //if (! (i >= 0 && i < top))
        //{
        //    Tuple<T> *p = NULL;
        //    p -> top = 0;
        //}
        assert(! OutOfRange(i));

        return base[i >> log_blksize][i];
    }

    //
    // Add an element to the dynamic array and return the top index.
    //
    inline int NextIndex()
    {
        int i = top++;
        if (i == size)
            AllocateMoreSpace();
        return i;
    }

    inline void Push(T elt) { this -> Next() = elt; }

    //
    // Not "return (*this)[--top]" because that may violate an invariant
    // in operator[].
    //
    inline T Pop() { assert(top!=0); top--; return base[top >> log_blksize][top]; }
    inline T Top() { assert(top!=0); return (*this)[top-1]; }

    //
    // Add an element to the dynamic array and return a reference to
    // that new element.
    //
    inline T& Next() { int i = NextIndex(); return base[i >> log_blksize][i]; }

    //
    // Assignment of a dynamic array to another.
    //
    inline Tuple<T>& operator=(Tuple<T>& rhs)
    {
        if (this != &rhs)
        {
            Resize(rhs.top);
            for (int i = 0; i < rhs.top; i++)
                base[i >> log_blksize][i] = rhs.base[i >> log_blksize][i];
        }

        return *this;
    }

    //
    // Equality comparison of a dynamic array to another.
    //
    bool operator==(Tuple<T>& rhs)
    {
        if (this != &rhs)
        {
            if (this -> top != rhs.top)
                return false;
            for (int i = 0; i < rhs.top; i++)
            {
                if (base[i >> log_blksize][i] != rhs.base[i >> log_blksize][i])
                    return false;
            }
        }
        return true;
    }

    //
    // Constructor of a Tuple
    //
    Tuple(unsigned estimate = 0)
    {
        if (estimate == 0)
        {
            log_blksize = DEFAULT_LOG_BLKSIZE;
            base_increment = DEFAULT_BASE_INCREMENT;
        }
        else
        {
            for (log_blksize = 1; (((unsigned) 1 << log_blksize) < estimate) && (log_blksize < 31); log_blksize++)
                ;
            if (log_blksize <= DEFAULT_LOG_BLKSIZE)
                base_increment = 1;
            else if (log_blksize < 13)
            {
                base_increment = (unsigned) 1 << (log_blksize - 4);
                log_blksize = 4;
            }
            else
            {
                base_increment = (unsigned) 1 << (log_blksize - 8);
                log_blksize = 8;
            }
            base_increment++; // add a little margin to avoid reallocating the base.
        }

        size = 0;
        top = 0;
    }

    //
    // Constructor of a Tuple
    //
    Tuple(int log_blksize_, int base_increment_) : log_blksize(log_blksize_),
                                                   base_increment(base_increment_)
    {
        size = 0;
        top = 0;
    }

    //
    // Initialization of a dynamic array.
    //
    Tuple(Tuple<T>& rhs) : log_blksize(rhs.log_blksize),
                           base_increment(rhs.base_increment)
    {
        size = 0;
        *this = rhs;
    }

    //
    // Destructor of a dynamic array.
    //
    ~Tuple() { Resize(0); }

    void Initialize(T value)
    {
        for (int i = 0; i < top; i++)
            (*this)[i] = value;
        return;
    }

    void Reverse()
    {
        for (int head = 0, tail = Length() - 1; head < tail; head++, tail--)
        {
            T temp = (*this)[head];
            (*this)[head] = (*this)[tail];
            (*this)[tail] = temp;

        }

        return;
    }

    // ********************************************************************************************** //

    //
    // Return the total size of temporary space allocated.
    //
    inline size_t SpaceAllocated(void)
    {
        return ((base.Size() * sizeof(T **)) + (size * sizeof(T)));
    }

    //
    // Return the total size of temporary space used.
    //
    inline size_t SpaceUsed(void)
    {
        return (((size >> log_blksize) * sizeof(T **)) + (top * sizeof(T)));
    }
};

#endif /* #ifndef TUPLE_H */
