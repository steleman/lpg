#include "TabExpander.h"
#include "Code.h"

int TabExpander::tab_size = TabExpander::DEFAULT_TAB_SIZE;

//
// Compute the length of a character string segment after expanding tabs.
//
int TabExpander::strlen(const char *line, int start, int end)
{
    for (int i = start--; i <= end; i++)
    {
        if (line[i] == Code::HORIZONTAL_TAB)
        {
            int offset = (i - start) - 1;
            start -= ((tab_size - 1) - offset % tab_size);
        }
    }

    return (end - start);
}
