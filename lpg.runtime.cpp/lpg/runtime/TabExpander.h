#ifndef LPG_RUNTIME_TAB_EXPANDER_H
#define LPG_RUNTIME_TAB_EXPANDER_H

class TabExpander
{
public:
    enum { DEFAULT_TAB_SIZE = 8 };

    inline static int TabSize() { return tab_size; }
    inline static void SetTabSize(int value) { tab_size = value; }

    static int strlen(const char *line, int start, int end);

private:
    static int tab_size;
};
#endif
