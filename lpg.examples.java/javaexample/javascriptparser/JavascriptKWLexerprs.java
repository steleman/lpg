package javascriptparser;

public class JavascriptKWLexerprs implements lpg.javaruntime.ParseTable, JavascriptKWLexersym {

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
            2,5,4,5,5,5,8,7,6,2,
            4,6,7,5,5,7,3,8,2,6,
            2,10,2,9,3,4,7,7,6,6,
            6,5,6,4,5,4,3,6,3,3,
            4,5,4,8,8,4,4,10,9,4,
            6,9,12,6,9,8,7,3,7,3
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
            1,1,1,1,1,1,1,1,1,1,
            1,1,63,10,115,30,78,86,107,27,
            23,121,45,49,15,29,53,96,61,119,
            84,57,44,123,126,68,93,127,130,132,
            51,99,133,134,136,138,139,144,141,103,
            148,145,149,102,65,151,154,152,155,159,
            163,72,165,77,167,172,79,170,176,177,
            178,181,179,182,186,188,190,191,194,197,
            199,200,204,206,209,210,211,212,214,216,
            217,218,222,225,228,108,223,229,234,235,
            237,239,241,243,245,246,248,114,254,249,
            259,252,261,264,266,262,269,267,270,272,
            275,274,277,276,278,288,289,282,290,293,
            295,296,297,300,306,302,311,309,313,314,
            301,316,315,321,323,327,322,329,330,332,
            333,334,338,335,343,344,347,348,350,359,
            349,354,360,362,363,364,366,367,371,368,
            377,379,380,372,385,387,390,394,393,399,
            395,381,401,405,407,408,411,412,415,413,
            403,417,421,426,428,424,429,431,433,434,
            441,436,438,447,443,445,450,452,454,455,
            458,459,461,463,466,467,468,470,472,473,
            477,273,273
        };
    };
    public final static char baseAction[] = BaseAction.baseAction;
    public final int baseAction(int index) { return baseAction[index]; }
    public final static char lhs[] = baseAction;
    public final int lhs(int index) { return lhs[index]; };

    public interface TermCheck {
        public final static byte termCheck[] = {0,
            0,1,2,3,4,5,6,7,8,0,
            10,11,12,13,0,15,16,17,4,19,
            6,21,0,1,2,0,0,13,0,0,
            1,3,18,11,25,7,10,9,9,11,
            14,19,20,0,0,2,20,3,0,1,
            0,3,0,3,10,11,0,5,6,11,
            0,11,6,3,0,5,2,0,4,9,
            20,0,8,2,7,23,0,0,0,8,
            2,5,4,0,7,0,15,4,3,13,
            0,14,0,17,9,0,1,5,0,7,
            17,0,0,2,9,7,0,0,10,7,
            4,9,5,0,0,2,9,4,0,18,
            0,1,0,9,2,0,0,2,10,0,
            1,0,0,0,2,0,10,0,0,6,
            0,3,7,0,0,2,15,0,0,5,
            0,0,15,0,0,8,0,17,0,6,
            6,10,0,5,0,15,0,19,4,0,
            1,0,6,11,3,0,0,0,0,4,
            0,0,0,5,3,0,9,0,1,0,
            0,1,16,0,14,6,0,12,0,0,
            4,2,9,0,1,0,8,2,0,0,
            0,0,2,0,5,0,0,0,1,11,
            5,0,0,7,0,1,5,0,0,2,
            8,3,21,0,0,22,0,4,0,1,
            0,5,0,1,0,0,1,0,0,9,
            3,0,18,0,3,11,8,4,0,1,
            0,0,2,0,1,0,0,2,0,0,
            9,0,4,0,0,0,0,0,1,8,
            7,0,7,14,10,19,10,0,0,0,
            3,3,0,4,0,0,0,1,3,0,
            0,0,21,11,10,0,5,2,0,10,
            0,1,0,0,0,0,16,2,6,11,
            0,0,0,10,2,11,0,7,0,0,
            4,0,0,0,0,14,0,0,7,10,
            7,4,0,0,10,13,0,0,0,0,
            22,8,6,0,1,8,14,8,0,0,
            2,0,0,0,16,0,0,0,2,6,
            0,0,5,12,15,13,0,7,0,0,
            0,2,2,18,0,1,0,16,12,0,
            12,5,0,0,0,6,3,5,0,1,
            0,1,0,9,0,1,0,0,1,3,
            0,0,0,3,0,1,0,1,0,8,
            0,9,20,0,4,0,1,0,0,2,
            0,1,0,0,11,0,8,0,6,6,
            0,1,0,8,0,8,0,1,6,0,
            6,0,1,0,0,2,2,0,0,10,
            0,1,0,1,7,0,0,0,2,0,
            12,0,0,1,9,4,0,0,0,0,
            0,0,13,0,0,0,0,0,12,0,
            0,24,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0
        };
    };
    public final static byte termCheck[] = TermCheck.termCheck;
    public final int termCheck(int index) { return termCheck[index]; }

    public interface TermAction {
        public final static char termAction[] = {0,
            273,76,69,80,70,64,73,74,78,273,
            71,68,77,75,273,72,65,79,296,66,
            104,67,273,92,96,273,273,292,273,273,
            82,109,105,95,272,108,90,107,83,106,
            91,94,93,273,273,331,89,100,273,102,
            273,103,273,126,99,98,273,112,110,101,
            273,127,119,116,21,115,143,273,144,114,
            310,273,142,151,122,111,273,273,273,150,
            159,155,160,273,84,273,152,274,87,156,
            273,85,273,154,86,273,113,123,273,124,
            118,273,273,140,283,129,273,273,128,137,
            88,136,182,273,273,193,183,194,273,141,
            273,97,273,81,120,273,273,121,117,273,
            312,273,273,273,333,273,313,273,273,130,
            273,133,131,273,273,134,125,273,273,139,
            273,273,132,273,273,138,273,135,273,146,
            147,290,273,148,273,145,273,298,153,273,
            161,273,157,149,158,273,273,273,273,162,
            273,273,273,163,164,273,320,273,165,273,
            273,309,323,273,316,166,273,314,273,273,
            307,169,167,273,170,273,168,171,273,273,
            273,273,174,273,173,273,273,273,178,172,
            299,273,273,177,273,180,179,273,273,181,
            184,185,175,273,273,176,273,186,273,188,
            273,187,273,284,273,273,191,273,273,189,
            192,273,319,273,197,190,196,195,273,276,
            273,273,198,273,315,273,273,199,273,273,
            200,273,201,273,273,273,273,273,208,204,
            205,273,207,203,305,202,206,273,273,273,
            209,210,273,212,273,273,273,216,215,273,
            273,273,211,213,214,273,219,218,273,217,
            273,287,273,273,273,273,223,224,221,220,
            273,273,273,222,279,225,273,226,273,273,
            278,273,273,273,273,277,273,35,228,227,
            229,327,273,273,230,311,273,273,273,273,
            275,304,303,273,324,302,306,231,273,273,
            232,273,273,273,233,273,273,15,293,237,
            273,273,240,235,234,236,273,239,273,273,
            273,285,250,238,273,282,273,243,241,273,
            242,244,273,273,273,245,246,247,273,248,
            273,301,273,249,273,300,273,273,332,251,
            273,273,273,252,273,254,273,330,273,253,
            273,255,289,273,286,273,256,273,273,281,
            273,329,273,273,257,273,258,273,259,260,
            273,261,273,262,273,263,273,264,265,273,
            291,273,280,273,273,317,328,273,273,318,
            273,297,273,322,266,273,273,273,268,273,
            325,273,273,270,267,321,273,273,273,273,
            273,273,295,273,273,273,273,273,326,273,
            273,269
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
           NUM_STATES        = 209,
           NT_OFFSET         = 29,
           LA_STATE_OFFSET   = 333,
           MAX_LA            = 1,
           NUM_RULES         = 60,
           NUM_NONTERMINALS  = 2,
           NUM_SYMBOLS       = 31,
           SEGMENT_SIZE      = 8192,
           START_STATE       = 61,
           IDENTIFIER_SYMBOL = 0,
           EOFT_SYMBOL       = 25,
           EOLT_SYMBOL       = 30,
           ACCEPT_ACTION     = 272,
           ERROR_ACTION      = 273;

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
