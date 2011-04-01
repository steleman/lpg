#ifndef LPG_RUNTIME_CONVERTIBLE_ARRAY_H
#define LPG_RUNTIME_CONVERTIBLE_ARRAY_H

#include "Tuple.h"

template <class T>
class ConvertibleArray : public Tuple<T>
{
public:

    ConvertibleArray(int estimate = 0) : Tuple<T>(estimate),
                                         array(NULL)
    {}

    ConvertibleArray(int log_blksize, int base_increment) : Tuple<T>(log_blksize, base_increment),
                                                            array(NULL)
    {}

    ~ConvertibleArray() { delete [] array; }

    //
    // This function converts a tuple into a regular array and destroys the
    // original tuple.
    //
    inline T *&Array()
    {
        if ((! array) && Tuple<T>::top > 0)
        {
            array = new T[Tuple<T>::top];

            int i = 0,
                processed_size = 0,
                n = (Tuple<T>::top - 1) >> Tuple<T>::log_blksize; // the last non-empty slot!
            while (i < n)
            {
                memmove(&array[processed_size], Tuple<T>::base[i] + processed_size, Tuple<T>::Blksize() * sizeof(T));
                delete [] (Tuple<T>::base[i] + processed_size);
                i++;
                processed_size += Tuple<T>::Blksize();
            }
            memmove(&array[processed_size], Tuple<T>::base[n] + processed_size, (Tuple<T>::top - processed_size) * sizeof(T));
            delete [] (Tuple<T>::base[n] + processed_size);
            Tuple<T>::base.Resize(0);
            Tuple<T>::size = 0;
        }

        return array;
    }

    inline T& operator[](const int i)
    {
        //
        // Use this code when debugging to force a crash instead of
        // allowing the assertion to be raised.
        //
        // if (! (i >= 0 && i < top))
        // {
        //     ConvertibleArray<T> *p = NULL;
        //     p -> array = 0;
        // }
        assert(! Tuple<T>::OutOfRange(i));

        return (array ? array[i] : Tuple<T>::base[i >> Tuple<T>::log_blksize][i]);
    }

    inline void Resize(const int n = 0) { assert(false); }
    inline void Reset(const int n = 0) { assert(false); }
    inline T& Next()
    {
        assert(! array);

        int i = Tuple<T>::NextIndex();
        return Tuple<T>::base[i >> Tuple<T>::log_blksize][i];
    }
    inline Tuple<T>& operator=(const Tuple<T>& rhs)
    {
        assert(false);
        return *this;
    }

private:
    T *array;
};

#endif
