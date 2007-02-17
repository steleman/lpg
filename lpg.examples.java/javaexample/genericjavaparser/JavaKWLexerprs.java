package genericjavaparser;

public class JavaKWLexerprs implements lpg.runtime.java.ParseTable, JavaKWLexersym {

    public interface IsNullable {
        public final static byte isNullable[] = {0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0
        };
    };
    public final static byte isNullable[] = IsNullable.isNullable;
    public final boolean isNullable(int index) { return isNullable[index] != 0; }

    public interface ProsthesesIndex {
        public final static byte prosthesesIndex[] = {0,
            2,1
        };
    };
    public final static byte prosthesesIndex[] = ProsthesesIndex.prosthesesIndex;
    public final int prosthesesIndex(int index) { return prosthesesIndex[index]; }

    public interface IsKeyword {
        public final static byte isKeyword[] = {0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0
        };
    };
    public final static byte isKeyword[] = IsKeyword.isKeyword;
    public final boolean isKeyword(int index) { return isKeyword[index] != 0; }

    public interface BaseCheck {
        public final static byte baseCheck[] = {0,
            8,6,7,5,4,4,5,4,5,5,
            8,7,2,6,4,4,7,5,5,7,
            5,3,4,2,10,6,10,3,9,4,
            6,3,4,7,7,9,6,6,5,6,
            8,5,6,12,4,5,6,9,4,3,
            4,8,5
        };
    };
    public final static byte baseCheck[] = BaseCheck.baseCheck;
    public final int baseCheck(int index) { return baseCheck[index]; }
    public final static byte rhs[] = baseCheck;
    public final int rhs(int index) { return rhs[index]; };

    public interface BaseAction {
        public final static char baseAction[] = {
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,56,61,12,7,60,
            19,103,42,43,28,50,99,23,52,68,
            35,58,25,101,73,48,71,107,108,109,
            81,113,114,111,83,118,120,62,121,122,
            85,115,130,129,133,135,134,141,137,142,
            144,145,146,149,153,94,157,160,162,163,
            164,165,167,166,173,176,177,178,175,182,
            187,189,190,147,191,193,194,179,195,199,
            201,204,205,207,91,208,212,213,211,220,
            218,224,222,226,98,227,232,230,233,241,
            228,243,244,246,249,251,252,254,255,256,
            257,258,261,263,262,272,273,275,276,259,
            277,282,283,286,289,288,293,295,297,296,
            299,302,298,303,305,309,311,312,313,314,
            316,321,317,330,325,326,333,334,336,320,
            340,337,342,346,345,349,352,354,356,357,
            358,367,368,359,372,364,374,375,378,380,
            382,376,383,388,389,390,391,393,394,395,
            400,403,399,409,401,412,414,416,418,421,
            422,424,425,427,428,429,432,434,435,437,
            252,252
        };
    };
    public final static char baseAction[] = BaseAction.baseAction;
    public final int baseAction(int index) { return baseAction[index]; }
    public final static char lhs[] = baseAction;
    public final int lhs(int index) { return lhs[index]; };

    public interface TermCheck {
        public final static byte termCheck[] = {0,
            0,1,2,3,4,5,0,7,8,9,
            10,0,6,13,14,15,16,17,0,19,
            2,21,0,12,0,3,4,0,6,11,
            12,9,8,6,0,17,18,3,4,15,
            6,0,0,1,3,3,12,0,7,0,
            3,0,11,11,5,4,5,0,11,0,
            0,0,13,6,7,18,7,0,1,20,
            0,12,0,6,23,18,4,7,17,9,
            0,9,0,3,0,25,2,7,6,0,
            0,9,8,0,4,2,6,0,0,2,
            0,8,0,1,6,8,0,0,0,9,
            0,5,0,0,0,2,9,0,6,0,
            0,0,2,4,16,15,5,10,0,0,
            16,2,0,0,0,7,0,4,6,5,
            0,0,2,0,0,0,0,11,0,8,
            5,3,0,7,11,3,0,13,2,0,
            1,0,0,0,0,0,0,6,4,3,
            8,8,0,1,0,0,0,0,0,14,
            5,0,6,2,10,8,0,1,0,0,
            0,2,0,0,0,2,4,9,0,21,
            0,11,4,0,0,1,0,0,2,9,
            0,0,0,6,3,3,22,0,8,0,
            1,0,19,0,1,0,0,0,3,0,
            3,0,0,1,8,0,15,20,7,10,
            0,1,0,0,1,0,4,2,0,1,
            0,0,2,0,0,0,0,0,0,8,
            0,0,0,7,2,10,12,10,7,9,
            17,0,0,1,0,0,0,3,3,21,
            9,0,0,7,3,0,1,0,0,7,
            2,4,0,1,0,0,0,0,0,5,
            4,0,0,2,0,8,11,9,0,1,
            0,0,0,0,12,0,0,7,7,0,
            0,9,9,8,0,0,22,7,12,0,
            5,2,0,0,10,0,0,2,19,0,
            1,0,10,10,0,0,5,2,0,13,
            0,0,4,0,1,0,0,0,0,4,
            3,5,4,0,20,14,0,0,2,6,
            3,0,1,0,0,0,2,0,1,0,
            1,0,0,1,3,10,13,0,0,0,
            0,2,0,0,0,1,8,5,0,0,
            0,11,0,10,5,18,0,5,0,1,
            10,0,1,0,16,0,1,0,5,2,
            0,0,2,0,0,1,0,0,0,2,
            9,0,6,0,0,1,0,14,0,0,
            0,8,0,0,13,0,0,0,0,0,
            14,0,24,0,0,0,0,0,0,0,
            0,0,0,0,0,0
        };
    };
    public final static byte termCheck[] = TermCheck.termCheck;
    public final int termCheck(int index) { return termCheck[index]; }

    public interface TermAction {
        public final static char termAction[] = {0,
            252,68,59,72,64,63,252,61,60,65,
            70,252,74,67,69,71,62,57,252,66,
            80,58,252,73,252,96,94,252,93,79,
            81,95,109,89,252,78,77,105,103,110,
            102,252,252,87,85,88,104,252,84,252,
            115,252,83,86,90,99,98,252,114,252,
            252,252,276,108,107,302,75,252,101,91,
            252,76,252,100,97,106,112,116,284,117,
            252,113,252,122,252,251,132,121,126,252,
            252,127,133,252,173,147,172,252,252,180,
            252,148,252,82,92,181,252,252,252,111,
            252,118,252,252,252,124,119,252,123,252,
            252,252,130,129,120,125,131,128,252,252,
            134,135,252,252,252,274,252,138,136,137,
            252,252,139,13,252,252,252,140,252,141,
            144,145,252,163,142,146,252,143,149,252,
            150,252,252,252,252,252,252,151,154,155,
            152,153,252,301,252,252,252,252,252,303,
            156,252,157,159,158,297,252,160,252,252,
            252,162,252,252,252,166,165,161,252,167,
            252,164,285,252,28,170,252,252,171,169,
            252,252,252,275,174,175,168,252,176,252,
            177,252,282,252,267,252,252,252,179,252,
            184,252,252,258,182,252,178,268,260,183,
            252,257,252,252,186,252,185,187,252,305,
            252,252,188,252,252,252,252,252,252,189,
            252,252,252,294,291,192,191,193,195,194,
            190,252,252,197,252,252,252,198,199,200,
            196,252,252,201,202,252,204,252,252,203,
            273,205,252,270,252,252,252,252,252,206,
            207,252,252,262,252,261,208,209,252,210,
            252,252,252,252,259,46,252,211,212,252,
            252,213,214,299,252,252,256,215,295,252,
            290,216,252,252,292,252,252,218,219,252,
            283,252,289,217,252,252,221,278,19,220,
            252,252,223,252,266,252,252,252,252,225,
            227,226,229,252,222,224,252,252,254,231,
            228,252,230,252,252,252,233,252,287,252,
            286,252,252,236,234,235,232,252,252,252,
            252,264,252,252,252,304,269,255,252,252,
            252,237,252,238,239,272,252,240,252,241,
            242,252,243,252,293,252,263,252,244,253,
            252,252,300,252,252,281,252,252,252,247,
            245,252,246,252,252,249,252,288,252,252,
            252,277,252,252,279,252,252,252,252,252,
            296,252,248
        };
    };
    public final static char termAction[] = TermAction.termAction;
    public final int termAction(int index) { return termAction[index]; }
    public final int asb(int index) { return 0; }
    public final int asr(int index) { return 0; }
    public final int nasb(int index) { return 0; }
    public final int nasr(int index) { return 0; }
    public final int terminalIndex(int index) { return 0; }
    public final int nonterminalIndex(int index) { return 0; }
    public final int scopePrefix(int index) { return 0;}
    public final int scopeSuffix(int index) { return 0;}
    public final int scopeLhs(int index) { return 0;}
    public final int scopeLa(int index) { return 0;}
    public final int scopeStateSet(int index) { return 0;}
    public final int scopeRhs(int index) { return 0;}
    public final int scopeState(int index) { return 0;}
    public final int inSymb(int index) { return 0;}
    public final String name(int index) { return null; }
    public final int getErrorSymbol() { return 0; }
    public final int getScopeUbound() { return 0; }
    public final int getScopeSize() { return 0; }
    public final int getMaxNameLength() { return 0; }

    public final static int
           NUM_STATES        = 195,
           NT_OFFSET         = 29,
           LA_STATE_OFFSET   = 305,
           MAX_LA            = 1,
           NUM_RULES         = 53,
           NUM_NONTERMINALS  = 2,
           NUM_SYMBOLS       = 31,
           SEGMENT_SIZE      = 8192,
           START_STATE       = 54,
           IDENTIFIER_SYMBOL = 0,
           EOFT_SYMBOL       = 25,
           EOLT_SYMBOL       = 30,
           ACCEPT_ACTION     = 251,
           ERROR_ACTION      = 252;

    public final static boolean BACKTRACK = false;

    public final int getNumStates() { return NUM_STATES; }
    public final int getNtOffset() { return NT_OFFSET; }
    public final int getLaStateOffset() { return LA_STATE_OFFSET; }
    public final int getMaxLa() { return MAX_LA; }
    public final int getNumRules() { return NUM_RULES; }
    public final int getNumNonterminals() { return NUM_NONTERMINALS; }
    public final int getNumSymbols() { return NUM_SYMBOLS; }
    public final int getSegmentSize() { return SEGMENT_SIZE; }
    public final int getStartState() { return START_STATE; }
    public final int getStartSymbol() { return lhs[0]; }
    public final int getIdentifierSymbol() { return IDENTIFIER_SYMBOL; }
    public final int getEoftSymbol() { return EOFT_SYMBOL; }
    public final int getEoltSymbol() { return EOLT_SYMBOL; }
    public final int getAcceptAction() { return ACCEPT_ACTION; }
    public final int getErrorAction() { return ERROR_ACTION; }
    public final boolean isValidForParser() { return isValidForParser; }
    public final boolean getBacktrack() { return BACKTRACK; }

    public final int originalState(int state) { return 0; }
    public final int asi(int state) { return 0; }
    public final int nasi(int state) { return 0; }
    public final int inSymbol(int state) { return 0; }

    public final int ntAction(int state, int sym) {
        return baseAction[state + sym];
    }

    public final int tAction(int state, int sym) {
        int i = baseAction[state],
            k = i + sym;
        return termAction[termCheck[k] == sym ? k : i];
    }
    public final int lookAhead(int la_state, int sym) {
        int k = la_state + sym;
        return termAction[termCheck[k] == sym ? k : la_state];
    }
}
