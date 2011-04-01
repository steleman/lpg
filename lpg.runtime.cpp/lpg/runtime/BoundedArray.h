#ifndef LPG_RUNTIME_BOUNDED_ARRAY_H
#define LPG_RUNTIME_BOUNDED_ARRAY_H

template <class T>
class BoundedArray
{
public:

    BoundedArray() : lbound(0),
                     ubound(-1),
                     info(NULL)
    {}

    BoundedArray(int lbound_, int ubound_) : lbound(lbound_),
                                             ubound(ubound_)
    {
        assert(ubound >= lbound);
        info = (new T[Size()]) - lbound;
    }

    BoundedArray(int lbound_, int ubound_, T init_value) : lbound(lbound_),
                                                           ubound(ubound_)
    {
        assert(ubound >= lbound);
        info = (new T[Size()]) - lbound;
        Initialize(init_value);
    }

    ~BoundedArray()
    {
        info += lbound;
        delete [] info;
    }

    void Initialize(T init_value)
    {
        for (int i = lbound; i <= ubound; i++)
            info[i] = init_value;
    }

    void Resize(int new_lbound, int new_ubound)
    {
        if (new_ubound < new_lbound)
        {
            info += lbound;
            delete [] info;
    
            info = NULL;
            lbound = new_lbound;
            ubound = new_ubound;
        }
        else
        {
            T *old_info = info;
            int new_size = new_ubound - new_lbound + 1;
            info = new T[new_size];
            if (old_info)
            {
                old_info += lbound;
                if (new_lbound == lbound && new_ubound > ubound)
                    memmove(info, old_info, Size() * sizeof(T));
                delete [] old_info;
            }

            info -= new_lbound;
            lbound = new_lbound;
            ubound = new_ubound;
        }

        return;
    }

    void Memset(int val = 0)
    {
        memset(info + lbound, val, Size() * sizeof(T));
    }

    void MemReset()
    {
        memset(info + lbound, 0, Size() * sizeof(T));
    }

    int Lbound() { return lbound; }
    int Ubound() { return ubound; }
    int Size() { return ubound - lbound + 1; }

    //
    // Can the tuple be indexed with i?
    //
    inline bool OutOfRange(const int i) { return (i < lbound || i > ubound); }

    //
    // Return the ith element of the array
    //
    T &operator[](const int i)
    {
        //
        // Use this code when debugging to force a crash instead of
        // allowing the assertion to be raised.
        //
        //if (i < lbound || i > ubound)
        //{
        //    BoundedArray<T> *a = NULL;
        //    a -> lbound = 0;
        //}
        assert(! OutOfRange(i));

        return info[i];
    }
private:
    int lbound,
        ubound;
    T *info;
};
#endif
