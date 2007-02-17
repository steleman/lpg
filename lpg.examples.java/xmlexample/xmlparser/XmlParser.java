package xmlparser;

import lpg.runtime.java.*;

public class XmlParser extends Utf8LpgLexStream implements XmlParsersym, RuleAction
{
    private static ParseTable prs = new XmlParserprs();
    private DeterministicParser dtParser;

    private void setResult(Object object) { dtParser.setSym1(object); }
    public DeterministicParser getParser() { return dtParser; }
    public Object getRhsSym(int i) { return dtParser.getSym(i); }
    public int getRhsTokenIndex(int i) { return dtParser.getToken(i); }
    public int getRhsFirstTokenIndex(int i) { return dtParser.getFirstToken(i); }
    public int getRhsLastTokenIndex(int i) { return dtParser.getLastToken(i); }

    public int getLeftSpan() { return dtParser.getFirstToken(); }
    public int getRightSpan() { return dtParser.getLastToken(); }

    public XmlParser(String filename, int tab) throws java.io.IOException 
    {
        super(filename, tab);
    }

    public String[] orderedExportedSymbols() { return orderedTerminalSymbols; }
    public int getEOFTokenKind() { return XmlParserprs.EOFT_SYMBOL; }
    public Utf8LpgLexStream getLexStream() { return (Utf8LpgLexStream) this; }

    public Ast parser()
    {
        return parser(null, 0);
    }
        
    public Ast parser(Monitor monitor)
    {
        return parser(monitor, 0);
    }
        
    public Ast parser(int error_repair_count)
    {
        return parser(null, error_repair_count);
    }
        
    public Ast parser(Monitor monitor, int error_repair_count)
    {
        try
        {
            dtParser = new DeterministicParser(this, prs, this);
        }
        catch (NotDeterministicParseTableException e)
        {
            System.out.println("****Error: Regenerate XmlParserprs.java with -NOBACKTRACK option");
            System.exit(1);
        }
        catch (BadParseSymFileException e)
        {
            System.out.println("****Error: Bad Parser Symbol File -- XmlParsersym.java. Regenerate XmlParserprs.java");
            System.exit(1);
        }
        dtParser.setMonitor(monitor);

        try
        {
            return (Ast) dtParser.parse();
        }
        catch (BadParseException e)
        {
            reset(e.error_token); // point to error token

            System.out.print("Error detected on character " + e.error_token);
            if (e.error_token < getStreamLength())
                 System.out.print(" at line " + getLine(e.error_token) + ", column " + getColumn(e.error_token));
            else System.out.print(" at end of file ");
            System.out.println(" with kind " + getKind(e.error_token));
        }

        return null;
    }


    private final static int ECLIPSE_TAB_VALUE = 4;
    private byte buffer[];
    private int lastIndex;

    //
    //
    //
    public XmlParser(Option option) throws java.io.IOException
    {
        this(option.getFileName(), ECLIPSE_TAB_VALUE);
        this.buffer = getInputBytes();
        this.lastIndex = getLastIndex();
    }

    //
    // Local functions for XML actions.
    //
    final String getTokenText(int name)
    {
        return getName(getRhsFirstTokenIndex(name), getRhsLastTokenIndex(name));
    }

    //
    // Conpute location of name and return string
    //
    final String getLocation(int name)
    {
        int left_tok = getRhsFirstTokenIndex(name),
            right_tok = getRhsLastTokenIndex(name);
        return getFileName() + ':' + getLine(left_tok) + ':'
                                   + getColumn(left_tok) + ':'
                                   + getLine(right_tok) + ':'
                                   + getColumn(right_tok) + ": ";
    }

    //
    // Print error message for unmatched tags.
    //
    final void reportUnmatchedTagnames(int SName, int EName)
    {
        String start_name = "\"" + getTokenText(SName) + "\"",
               end_name = "\"" + getTokenText(EName) + "\"";
        System.out.println(getLocation(EName) +
                           " The ending tag name " + end_name +
                           " does not match the starting tag name " + start_name +
                           " at location " +
                           getLocation(SName));
    }

    //
    // Check whether or not two tag names are equal.
    //
    final void checkNames(int SName, int EName)
    {
        int i,
            j,
            end1 = getNext(getRhsLastTokenIndex(SName)),
            end2 = getNext(getRhsLastTokenIndex(EName));
        for (i = getRhsFirstTokenIndex(SName), j = getRhsFirstTokenIndex(EName); i < end1; i++, j++)
        {
            if (buffer[i] != buffer[j])
                break;
        }

        if (i < end1 || j < end2)
            reportUnmatchedTagnames(SName, EName);

        return;
    }

    //
    // Compute the kind of UTF8 sequence starting at index i.
    //
    public final int getKind(int i)  // Classify character at ith location
    {
        int c = (i > lastIndex ? 0xFFFF : getUnicodeValue(i));
        return (c < 0x10000 ? tokenKind[c]
                            : c < 0x110000 ? Char_OtherValidChar
                                           : Char_Unused);
    }

    //**********************************************************************
    //
    // Construct and initialize the XML character lookup table.
    //
    //**********************************************************************
    static byte tokenKind[] = new byte[0x10000]; // 0x10000 == 65536
    static
    {
        //
        // Char ::= #x9
        //        | #xA
        //        | #xD
        //        | [#x20-#xD7FF]
        //        | [#xE000-#xFFFD]
        //        | [#x10000-#x10FFFF] /* any Unicode character, excluding the surrogate blocks, FFFE, and FFFF. */ 

        // 
        // Note that in Java, we can only go up to #xFFFF
        // 
        tokenKind[0x0000] = Char_Unused;     // U0000 -- NUL    (Null char.)
        tokenKind[0x0001] = Char_Unused;     // U0001 -- SOH    (Start of Header)
        tokenKind[0x0002] = Char_Unused;     // U0002 -- STX    (Start of Text)
        tokenKind[0x0003] = Char_Unused;     // U0003 -- ETX    (End of Text)
        tokenKind[0x0004] = Char_Unused;     // U0004 -- EOT    (End of Transmission)
        tokenKind[0x0005] = Char_Unused;     // U0005 -- ENQ    (Enquiry)
        tokenKind[0x0006] = Char_Unused;     // U0006 -- ACK    (Acknowledgment)
        tokenKind[0x0007] = Char_Unused;     // U0007 -- BEL    (Bell)
        tokenKind[0x0008] = Char_Unused;     // U0008 --  BS    (Backspace)
        tokenKind[0x0009] = Char_HT;         // HT ::= U0009    (Horizontal Tab)     
        tokenKind[0x000A] = Char_LF;         // LF ::= U000A    (Line Feed)     
        tokenKind[0x000B] = Char_Unused;     // U000B --  VT    (Vertical Tab)
        tokenKind[0x000C] = Char_Unused;     // U000C --  FF    (Form Feed)     
        tokenKind[0x000D] = Char_CR;         // CR ::= U000D    (Carriage Return)     
        tokenKind[0x000E] = Char_Unused;     // U000E --  SO    (Shift Out)
        tokenKind[0x000F] = Char_Unused;     // U000F --  SI    (Shift In)
        tokenKind[0x0010] = Char_Unused;     // U0010 -- DLE    (Data Link Escape)
        tokenKind[0x0011] = Char_Unused;     // U0011 -- DC1 (XON) (Device Control 1)
        tokenKind[0x0012] = Char_Unused;     // U0012 -- DC2       (Device Control 2)
        tokenKind[0x0013] = Char_Unused;     // U0013 -- DC3 (XOFF)(Device Control 3)
        tokenKind[0x0014] = Char_Unused;     // U0014 -- DC4       (Device Control 4)
        tokenKind[0x0015] = Char_Unused;     // U0015 -- NAK    (Negative Acknowledgement)
        tokenKind[0x0016] = Char_Unused;     // U0016 -- SYN    (Synchronous Idle)
        tokenKind[0x0017] = Char_Unused;     // U0017 -- ETB    (End of Trans. Block)
        tokenKind[0x0018] = Char_Unused;     // U0018 -- CAN    (Cancel)
        tokenKind[0x0019] = Char_Unused;     // U0019 --  EM    (End of Medium)
        tokenKind[0x001A] = Char_Unused;     // U001A -- SUB    (Substitute)
        tokenKind[0x001B] = Char_Unused;     // U001B -- ESC    (Escape)
        tokenKind[0x001C] = Char_Unused;     // U001C --  FS    (File Separator)
        tokenKind[0x001D] = Char_Unused;     // U001D --  GS    (Group Separator)
        tokenKind[0x001E] = Char_Unused;     // U001E --  RS    (Request to Send)(Record Separator)
        tokenKind[0x001F] = Char_Unused;     // U001F --  US    (Unit Separator)
        tokenKind[0x0020] = Char_Space;      // Space ::= U0020 (Space)     

        tokenKind[0x0021] = Char_Exclamation;   // 021 (exclamation mark)
        tokenKind[0x0022] = Char_DoubleQuote;   // 022 (double quote)
        tokenKind[0x0023] = Char_Sharp;         // 023 (number sign)
        tokenKind[0x0024] = Char_DollarSign;    // 024 (dollar sign)
        tokenKind[0x0025] = Char_Percent;       // 025 (percent)
        tokenKind[0x0026] = Char_Ampersand;     // 026 (ampersand)
        tokenKind[0x0027] = Char_SingleQuote;   // 027 (single quote)
        tokenKind[0x0028] = Char_LeftParen;     // 028 (left/opening parenthesis)
        tokenKind[0x0029] = Char_RightParen;    // 029 (right/closing parenthesis)
        tokenKind[0x002A] = Char_Star;          // 02A (asterisk)
        tokenKind[0x002B] = Char_Plus;          // 02B (plus)
        tokenKind[0x002C] = Char_Comma;         // 02C (comma)
        tokenKind[0x002D] = Char_Minus;         // 02D (minus or dash)
        tokenKind[0x002E] = Char_Dot;           // 02E (dot)
        tokenKind[0x002F] = Char_Slash;         // 02F (forward slash)

        tokenKind[0x0030] = Char_0;   // 0 -- 030
        tokenKind[0x0031] = Char_1;   // 1 -- 031
        tokenKind[0x0032] = Char_2;   // 2 -- 032
        tokenKind[0x0033] = Char_3;   // 3 -- 033
        tokenKind[0x0034] = Char_4;   // 4 -- 034
        tokenKind[0x0035] = Char_5;   // 5 -- 035
        tokenKind[0x0036] = Char_6;   // 6 -- 036
        tokenKind[0x0037] = Char_7;   // 7 -- 037
        tokenKind[0x0038] = Char_8;   // 8 -- 038
        tokenKind[0x0039] = Char_9;   // 9 -- 039

        tokenKind[0x003A] = Char_Colon;         // Colon        ::= ':' -- 03A (colon)
        tokenKind[0x003B] = Char_SemiColon;     // SemiColon    ::= ';' -- 03B (semi-colon)
        tokenKind[0x003C] = Char_LessThan;      // LessThan     ::= '<' -- 03C (less than)
        tokenKind[0x003D] = Char_Equal;         // Equal        ::= '=' -- 03D (equal sign)
        tokenKind[0x003E] = Char_GreaterThan;   // GreaterThan  ::= '>' -- 03E (greater than)
        tokenKind[0x003F] = Char_QuestionMark;  // QuestionMark ::= '?' -- 03F (question mark)
        tokenKind[0x0040] = Char_AtSign;        // AtSign       ::= '@' -- 040 (AT symbol)

        tokenKind[0x0041] = Char_A;   // A -- 041
        tokenKind[0x0042] = Char_B;   // B -- 042
        tokenKind[0x0043] = Char_C;   // C -- 043
        tokenKind[0x0044] = Char_D;   // D -- 044
        tokenKind[0x0045] = Char_E;   // E -- 045
        tokenKind[0x0046] = Char_F;   // F -- 046
        tokenKind[0x0047] = Char_G;   // G -- 047
        tokenKind[0x0048] = Char_H;   // H -- 048
        tokenKind[0x0049] = Char_I;   // I -- 049
        tokenKind[0x004A] = Char_J;   // J -- 04A
        tokenKind[0x004B] = Char_K;   // K -- 04B
        tokenKind[0x004C] = Char_L;   // L -- 04C
        tokenKind[0x004D] = Char_M;   // M -- 04D
        tokenKind[0x004E] = Char_N;   // N -- 04E
        tokenKind[0x004F] = Char_O;   // O -- 04F
        tokenKind[0x0050] = Char_P;   // P -- 050
        tokenKind[0x0051] = Char_Q;   // Q -- 051
        tokenKind[0x0052] = Char_R;   // R -- 052
        tokenKind[0x0053] = Char_S;   // S -- 053
        tokenKind[0x0054] = Char_T;   // T -- 054
        tokenKind[0x0055] = Char_U;   // U -- 055
        tokenKind[0x0056] = Char_V;   // V -- 056
        tokenKind[0x0057] = Char_W;   // W -- 057
        tokenKind[0x0058] = Char_X;   // X -- 058
        tokenKind[0x0059] = Char_Y;   // Y -- 059
        tokenKind[0x005A] = Char_Z;   // Z -- 05A

        tokenKind[0x005B] = Char_LeftBracket;   // LeftBracket  ::= '[' -- 05B (left/opening bracket)
        tokenKind[0x005C] = Char_BackSlash;     // BackSlash    ::= '\' -- 05C (back slash)
        tokenKind[0x005D] = Char_RightBracket;  // RightBracket ::= ']' -- 05D (right/closing bracket)
        tokenKind[0x005E] = Char_Caret;         // Caret        ::= '^' -- 05E (caret/cirumflex)
        tokenKind[0x005F] = Char__;             // _ -- 05F (underscore)
        tokenKind[0x0060] = Char_BackQuote;     // BackQuote    ::= '`' -- 060 (backquote)

        tokenKind[0x0061] = Char_a;   // a -- 061
        tokenKind[0x0062] = Char_b;   // b -- 062
        tokenKind[0x0063] = Char_c;   // c -- 063
        tokenKind[0x0064] = Char_d;   // d -- 064
        tokenKind[0x0065] = Char_e;   // e -- 065
        tokenKind[0x0066] = Char_f;   // f -- 066
        tokenKind[0x0067] = Char_g;   // g -- 067
        tokenKind[0x0068] = Char_h;   // h -- 068
        tokenKind[0x0069] = Char_i;   // i -- 069
        tokenKind[0x006A] = Char_j;   // j -- 06A
        tokenKind[0x006B] = Char_k;   // k -- 06B
        tokenKind[0x006C] = Char_l;   // l -- 06C
        tokenKind[0x006D] = Char_m;   // m -- 06D
        tokenKind[0x006E] = Char_n;   // n -- 06E
        tokenKind[0x006F] = Char_o;   // o -- 06F
        tokenKind[0x0070] = Char_p;   // p -- 070
        tokenKind[0x0071] = Char_q;   // q -- 071
        tokenKind[0x0072] = Char_r;   // r -- 072
        tokenKind[0x0073] = Char_s;   // s -- 073
        tokenKind[0x0074] = Char_t;   // t -- 074
        tokenKind[0x0075] = Char_u;   // u -- 075
        tokenKind[0x0076] = Char_v;   // v -- 076
        tokenKind[0x0077] = Char_w;   // w -- 077
        tokenKind[0x0078] = Char_x;   // x -- 078
        tokenKind[0x0079] = Char_y;   // y -- 079
        tokenKind[0x007A] = Char_z;   // z -- 07A

        tokenKind[0x007B] = Char_LeftBrace;   // LeftBrace    ::= '{' -- 07B (left/opening brace)
        tokenKind[0x007C] = Char_VerticalBar; // VerticalBar  ::= '|' -- 07C (vertical bar)
        tokenKind[0x007D] = Char_RightBrace;  // RightBrace   ::= '}' -- 07D (right/closing brace)
        tokenKind[0x007E] = Char_Tilde;       // Tilde        ::= '~' -- 07E (tilde)

        tokenKind[0xFFFE] = Char_Unused;
        tokenKind[0xFFFF] = Char_EOF;

        //
        // The three characters sequence that form the UTF-8 byte order mark.
        //
        for (int i = 0x00C0; i <= 0x00D6; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x00D8; i <= 0x00F6; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x00F8; i <= 0x00FF; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0100; i <= 0x0131; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0134; i <= 0x013E; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0141; i <= 0x0148; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x014A; i <= 0x017E; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0180; i <= 0x01C3; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x01CD; i <= 0x01F0; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x01F4; i <= 0x01F5; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x01FA; i <= 0x0217; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0250; i <= 0x02A8; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x02BB; i <= 0x02C1; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;
        tokenKind[0x0386] = Char_NonAsciiBaseChar;

        for (int i = 0x0388; i <= 0x038A; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        tokenKind[0x038C] = Char_NonAsciiBaseChar;

        for (int i = 0x038E; i <= 0x03A1; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x03A3; i <= 0x03CE; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x03D0; i <= 0x03D6; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        tokenKind[0x03DA] = Char_NonAsciiBaseChar;
        tokenKind[0x03DC] = Char_NonAsciiBaseChar;
        tokenKind[0x03DE] = Char_NonAsciiBaseChar;
        tokenKind[0x03E0] = Char_NonAsciiBaseChar;

        for (int i = 0x03E2; i <= 0x03F3; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0401; i <= 0x040C; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x040E; i <= 0x044F; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0451; i <= 0x045C; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x045E; i <= 0x0481; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0490; i <= 0x04C4; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x04C7; i <= 0x04C8; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x04CB; i <= 0x04CC; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x04D0; i <= 0x04EB; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x04EE; i <= 0x04F5; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x04F8; i <= 0x04F9; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0531; i <= 0x0556; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        tokenKind[0x0559] = Char_NonAsciiBaseChar;

        for (int i = 0x0561; i <= 0x0586; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x05D0; i <= 0x05EA; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x05F0; i <= 0x05F2; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0621; i <= 0x063A; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0641; i <= 0x064A; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0671; i <= 0x06B7; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x06BA; i <= 0x06BE; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x06C0; i <= 0x06CE; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x06D0; i <= 0x06D3; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;
        tokenKind[0x06D5] = Char_NonAsciiBaseChar;

        for (int i = 0x06E5; i <= 0x06E6; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0905; i <= 0x0939; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        tokenKind[0x093D] = Char_NonAsciiBaseChar;

        for (int i = 0x0958; i <= 0x0961; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0985; i <= 0x098C; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x098F; i <= 0x0990; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0993; i <= 0x09A8; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x09AA; i <= 0x09B0; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        tokenKind[0x09B2] = Char_NonAsciiBaseChar;

        for (int i = 0x09B6; i <= 0x09B9; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x09DC; i <= 0x09DD; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x09DF; i <= 0x09E1; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x09F0; i <= 0x09F1; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0A05; i <= 0x0A0A; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0A0F; i <= 0x0A10; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0A13; i <= 0x0A28; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0A2A; i <= 0x0A30; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0A32; i <= 0x0A33; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0A35; i <= 0x0A36; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0A38; i <= 0x0A39; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0A59; i <= 0x0A5C; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        tokenKind[0x0A5E] = Char_NonAsciiBaseChar;

        for (int i = 0x0A72; i <= 0x0A74; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0A85; i <= 0x0A8B; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        tokenKind[0x0A8D] = Char_NonAsciiBaseChar;

        for (int i = 0x0A8F; i <= 0x0A91; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0A93; i <= 0x0AA8; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0AAA; i <= 0x0AB0; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0AB2; i <= 0x0AB3; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0AB5; i <= 0x0AB9; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        tokenKind[0x0ABD] = Char_NonAsciiBaseChar;
        tokenKind[0x0AE0] = Char_NonAsciiBaseChar;

        for (int i = 0x0B05; i <= 0x0B0C; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0B0F; i <= 0x0B10; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0B13; i <= 0x0B28; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0B2A; i <= 0x0B30; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0B32; i <= 0x0B33; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0B36; i <= 0x0B39; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        tokenKind[0x0B3D] = Char_NonAsciiBaseChar;

        for (int i = 0x0B5C; i <= 0x0B5D; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0B5F; i <= 0x0B61; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0B85; i <= 0x0B8A; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0B8E; i <= 0x0B90; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0B92; i <= 0x0B95; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0B99; i <= 0x0B9A; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        tokenKind[0x0B9C] = Char_NonAsciiBaseChar;

        for (int i = 0x0B9E; i <= 0x0B9F; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0BA3; i <= 0x0BA4; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0BA8; i <= 0x0BAA; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0BAE; i <= 0x0BB5; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0BB7; i <= 0x0BB9; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0C05; i <= 0x0C0C; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0C0E; i <= 0x0C10; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0C12; i <= 0x0C28; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0C2A; i <= 0x0C33; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0C35; i <= 0x0C39; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0C60; i <= 0x0C61; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0C85; i <= 0x0C8C; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0C8E; i <= 0x0C90; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0C92; i <= 0x0CA8; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0CAA; i <= 0x0CB3; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0CB5; i <= 0x0CB9; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        tokenKind[0x0CDE] = Char_NonAsciiBaseChar;

        for (int i = 0x0CE0; i <= 0x0CE1; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0D05; i <= 0x0D0C; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0D0E; i <= 0x0D10; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0D12; i <= 0x0D28; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0D2A; i <= 0x0D39; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0D60; i <= 0x0D61; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0E01; i <= 0x0E2E; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        tokenKind[0x0E30] = Char_NonAsciiBaseChar;

        for (int i = 0x0E32; i <= 0x0E33; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0E40; i <= 0x0E45; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0E81; i <= 0x0E82; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        tokenKind[0x0E84] = Char_NonAsciiBaseChar;

        for (int i = 0x0E87; i <= 0x0E88; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        tokenKind[0x0E8A] = Char_NonAsciiBaseChar;
        tokenKind[0x0E8D] = Char_NonAsciiBaseChar;

        for (int i = 0x0E94; i <= 0x0E97; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0E99; i <= 0x0E9F; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0EA1; i <= 0x0EA3; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        tokenKind[0x0EA5] = Char_NonAsciiBaseChar;
        tokenKind[0x0EA7] = Char_NonAsciiBaseChar;

        for (int i = 0x0EAA; i <= 0x0EAB; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0EAD; i <= 0x0EAE; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        tokenKind[0x0EB0] = Char_NonAsciiBaseChar;

        for (int i = 0x0EB2; i <= 0x0EB3; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        tokenKind[0x0EBD] = Char_NonAsciiBaseChar;

        for (int i = 0x0EC0; i <= 0x0EC4; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0F40; i <= 0x0F47; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x0F49; i <= 0x0F69; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x10A0; i <= 0x10C5; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x10D0; i <= 0x10F6; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        tokenKind[0x1100] = Char_NonAsciiBaseChar;

        for (int i = 0x1102; i <= 0x1103; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x1105; i <= 0x1107; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        tokenKind[0x1109] = Char_NonAsciiBaseChar;

        for (int i = 0x110B; i <= 0x110C; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x110E; i <= 0x1112; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        tokenKind[0x113C] = Char_NonAsciiBaseChar;
        tokenKind[0x113E] = Char_NonAsciiBaseChar;
        tokenKind[0x1140] = Char_NonAsciiBaseChar;
        tokenKind[0x114C] = Char_NonAsciiBaseChar;
        tokenKind[0x114E] = Char_NonAsciiBaseChar;
        tokenKind[0x1150] = Char_NonAsciiBaseChar;

        for (int i = 0x1154; i <= 0x1155; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        tokenKind[0x1159] = Char_NonAsciiBaseChar;

        for (int i = 0x115F; i <= 0x1161; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        tokenKind[0x1163] = Char_NonAsciiBaseChar;
        tokenKind[0x1165] = Char_NonAsciiBaseChar;
        tokenKind[0x1167] = Char_NonAsciiBaseChar;
        tokenKind[0x1169] = Char_NonAsciiBaseChar;

        for (int i = 0x116D; i <= 0x116E; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x1172; i <= 0x1173; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        tokenKind[0x1175] = Char_NonAsciiBaseChar;
        tokenKind[0x119E] = Char_NonAsciiBaseChar;
        tokenKind[0x11A8] = Char_NonAsciiBaseChar;
        tokenKind[0x11AB] = Char_NonAsciiBaseChar;

        for (int i = 0x11AE; i <= 0x11AF; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x11B7; i <= 0x11B8; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;
        tokenKind[0x11BA] = Char_NonAsciiBaseChar;

        for (int i = 0x11BC; i <= 0x11C2; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        tokenKind[0x11EB] = Char_NonAsciiBaseChar;
        tokenKind[0x11F0] = Char_NonAsciiBaseChar;
        tokenKind[0x11F9] = Char_NonAsciiBaseChar;

        for (int i = 0x1E00; i <= 0x1E9B; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x1EA0; i <= 0x1EF9; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x1F00; i <= 0x1F15; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x1F18; i <= 0x1F1D; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x1F20; i <= 0x1F45; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x1F48; i <= 0x1F4D; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x1F50; i <= 0x1F57; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        tokenKind[0x1F59] = Char_NonAsciiBaseChar;
        tokenKind[0x1F5B] = Char_NonAsciiBaseChar;
        tokenKind[0x1F5D] = Char_NonAsciiBaseChar;

        for (int i = 0x1F5F; i <= 0x1F7D; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x1F80; i <= 0x1FB4; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x1FB6; i <= 0x1FBC; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        tokenKind[0x1FBE] = Char_NonAsciiBaseChar;

        for (int i = 0x1FC2; i <= 0x1FC4; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x1FC6; i <= 0x1FCC; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x1FD0; i <= 0x1FD3; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x1FD6; i <= 0x1FDB; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x1FE0; i <= 0x1FEC; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x1FF2; i <= 0x1FF4; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x1FF6; i <= 0x1FFC; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        tokenKind[0x2126] = Char_NonAsciiBaseChar;

        for (int i = 0x212A; i <= 0x212B; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        tokenKind[0x212E] = Char_NonAsciiBaseChar;

        for (int i = 0x2180; i <= 0x2182; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x3041; i <= 0x3094; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x30A1; i <= 0x30FA; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x3105; i <= 0x312C; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0xAC00; i <= 0xD7A3; i++)
            tokenKind[i] = Char_NonAsciiBaseChar;

        for (int i = 0x4E00; i <= 0x9FA5; i++)
            tokenKind[i] = Char_Ideographic;

        tokenKind[0x3007] = Char_Ideographic;

        for (int i = 0x3021; i <= 0x3029; i++)
            tokenKind[i] = Char_Ideographic;

        for (int i = 0x0300; i <= 0x0345; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0360; i <= 0x0361; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0483; i <= 0x0486; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0591; i <= 0x05A1; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x05A3; i <= 0x05B9; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x05BB; i <= 0x05BD; i++)
            tokenKind[i] = Char_CombiningChar;

        tokenKind[0x05BF] = Char_CombiningChar;

        for (int i = 0x05C1; i <= 0x05C2; i++)
            tokenKind[i] = Char_CombiningChar;

        tokenKind[0x05C4] = Char_CombiningChar;

        for (int i = 0x064B; i <= 0x0652; i++)
            tokenKind[i] = Char_CombiningChar;

        tokenKind[0x0670] = Char_CombiningChar;

        for (int i = 0x06D6; i <= 0x06DC; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x06DD; i <= 0x06DF; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x06E0; i <= 0x06E4; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x06E7; i <= 0x06E8; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x06EA; i <= 0x06ED; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0901; i <= 0x0903; i++)
            tokenKind[i] = Char_CombiningChar;

        tokenKind[0x093C] = Char_CombiningChar;

        for (int i = 0x093E; i <= 0x094C; i++)
            tokenKind[i] = Char_CombiningChar;

        tokenKind[0x094D] = Char_CombiningChar;

        for (int i = 0x0951; i <= 0x0954; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0962; i <= 0x0963; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0981; i <= 0x0983; i++)
            tokenKind[i] = Char_CombiningChar;

        tokenKind[0x09BC] = Char_CombiningChar;
        tokenKind[0x09BE] = Char_CombiningChar;
        tokenKind[0x09BF] = Char_CombiningChar;

        for (int i = 0x09C0; i <= 0x09C4; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x09C7; i <= 0x09C8; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x09CB; i <= 0x09CD; i++)
            tokenKind[i] = Char_CombiningChar;

        tokenKind[0x09D7] = Char_CombiningChar;

        for (int i = 0x09E2; i <= 0x09E3; i++)
            tokenKind[i] = Char_CombiningChar;

        tokenKind[0x0A02] = Char_CombiningChar;
        tokenKind[0x0A3C] = Char_CombiningChar;
        tokenKind[0x0A3E] = Char_CombiningChar;
        tokenKind[0x0A3F] = Char_CombiningChar;

        for (int i = 0x0A40; i <= 0x0A42; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0A47; i <= 0x0A48; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0A4B; i <= 0x0A4D; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0A70; i <= 0x0A71; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0A81; i <= 0x0A83; i++)
            tokenKind[i] = Char_CombiningChar;

        tokenKind[0x0ABC] = Char_CombiningChar;

        for (int i = 0x0ABE; i <= 0x0AC5; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0AC7; i <= 0x0AC9; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0ACB; i <= 0x0ACD; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0B01; i <= 0x0B03; i++)
            tokenKind[i] = Char_CombiningChar;

        tokenKind[0x0B3C] = Char_CombiningChar;

        for (int i = 0x0B3E; i <= 0x0B43; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0B47; i <= 0x0B48; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0B4B; i <= 0x0B4D; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0B56; i <= 0x0B57; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0B82; i <= 0x0B83; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0BBE; i <= 0x0BC2; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0BC6; i <= 0x0BC8; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0BCA; i <= 0x0BCD; i++)
            tokenKind[i] = Char_CombiningChar;

        tokenKind[0x0BD7] = Char_CombiningChar;

        for (int i = 0x0C01; i <= 0x0C03; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0C3E; i <= 0x0C44; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0C46; i <= 0x0C48; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0C4A; i <= 0x0C4D; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0C55; i <= 0x0C56; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0C82; i <= 0x0C83; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0CBE; i <= 0x0CC4; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0CC6; i <= 0x0CC8; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0CCA; i <= 0x0CCD; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0CD5; i <= 0x0CD6; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0D02; i <= 0x0D03; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0D3E; i <= 0x0D43; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0D46; i <= 0x0D48; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0D4A; i <= 0x0D4D; i++)
            tokenKind[i] = Char_CombiningChar;

        tokenKind[0x0D57] = Char_CombiningChar;
        tokenKind[0x0E31] = Char_CombiningChar;

        for (int i = 0x0E34; i <= 0x0E3A; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0E47; i <= 0x0E4E; i++)
            tokenKind[i] = Char_CombiningChar;

        tokenKind[0x0EB1] = Char_CombiningChar;

        for (int i = 0x0EB4; i <= 0x0EB9; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0EBB; i <= 0x0EBC; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0EC8; i <= 0x0ECD; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0F18; i <= 0x0F19; i++)
            tokenKind[i] = Char_CombiningChar;

        tokenKind[0x0F35] = Char_CombiningChar;
        tokenKind[0x0F37] = Char_CombiningChar;
        tokenKind[0x0F39] = Char_CombiningChar;
        tokenKind[0x0F3E] = Char_CombiningChar;
        tokenKind[0x0F3F] = Char_CombiningChar;

        for (int i = 0x0F71; i <= 0x0F84; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0F86; i <= 0x0F8B; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0F90; i <= 0x0F95; i++)
            tokenKind[i] = Char_CombiningChar;

        tokenKind[0x0F97] = Char_CombiningChar;

        for (int i = 0x0F99; i <= 0x0FAD; i++)
            tokenKind[i] = Char_CombiningChar;

        for (int i = 0x0FB1; i <= 0x0FB7; i++)
            tokenKind[i] = Char_CombiningChar;

        tokenKind[0x0FB9] = Char_CombiningChar;

        for (int i = 0x20D0; i <= 0x20DC; i++)
            tokenKind[i] = Char_CombiningChar;

        tokenKind[0x20E1] = Char_CombiningChar;

        for (int i = 0x302A; i <= 0x302F; i++)
            tokenKind[i] = Char_CombiningChar;

        tokenKind[0x3099] = Char_CombiningChar;
        tokenKind[0x309A  ] = Char_CombiningChar;

        for (int i = 0x0660; i <= 0x0669; i++)
            tokenKind[i] = Char_NonAsciiDigit;

        for (int i = 0x06F0; i <= 0x06F9; i++)
            tokenKind[i] = Char_NonAsciiDigit;

        for (int i = 0x0966; i <= 0x096F; i++)
            tokenKind[i] = Char_NonAsciiDigit;

        for (int i = 0x09E6; i <= 0x09EF; i++)
            tokenKind[i] = Char_NonAsciiDigit;

        for (int i = 0x0A66; i <= 0x0A6F; i++)
            tokenKind[i] = Char_NonAsciiDigit;

        for (int i = 0x0AE6; i <= 0x0AEF; i++)
            tokenKind[i] = Char_NonAsciiDigit;

        for (int i = 0x0B66; i <= 0x0B6F; i++)
            tokenKind[i] = Char_NonAsciiDigit;

        for (int i = 0x0BE7; i <= 0x0BEF; i++)
            tokenKind[i] = Char_NonAsciiDigit;

        for (int i = 0x0C66; i <= 0x0C6F; i++)
            tokenKind[i] = Char_NonAsciiDigit;

        for (int i = 0x0CE6; i <= 0x0CEF; i++)
            tokenKind[i] = Char_NonAsciiDigit;

        for (int i = 0x0D66; i <= 0x0D6F; i++)
            tokenKind[i] = Char_NonAsciiDigit;

        for (int i = 0x0E50; i <= 0x0E59; i++)
            tokenKind[i] = Char_NonAsciiDigit;

        for (int i = 0x0ED0; i <= 0x0ED9; i++)
            tokenKind[i] = Char_NonAsciiDigit;

        for (int i = 0x0F20; i <= 0x0F29; i++)
            tokenKind[i] = Char_NonAsciiDigit;

        tokenKind[0x00B7] = Char_Extender;

        tokenKind[0x02D0] = Char_Extender;
        tokenKind[0x02D1] = Char_Extender;
        tokenKind[0x0387] = Char_Extender;
        tokenKind[0x0640] = Char_Extender;
        tokenKind[0x0E46] = Char_Extender;
        tokenKind[0x0EC6] = Char_Extender;
        tokenKind[0x3005] = Char_Extender;

        for (int i = 0x3031; i <= 0x3035; i++)
            tokenKind[i] = Char_Extender;

        for (int i = 0x309D; i <= 0x309E; i++)
            tokenKind[i] = Char_Extender;

        for (int i = 0x30FC; i <= 0x30FE; i++)
            tokenKind[i] = Char_Extender;

        //
        // Every other character not yet assigned is treated as a OtherValidChar
        //
        for (int i = 0x007F; i < 0xFFFF; i++)
            if (tokenKind[i] == 0) tokenKind[i] = Char_OtherValidChar;
    }

    public void ruleAction(int ruleNumber)
    {
        switch (ruleNumber)
        {
 
            //
            // Rule 330:  document ::= prolog element Misc*$
            //
            case 330: {
                
                setResult(new Ast());
                break;
            }
     
            //
            // Rule 331:  document ::= ExtSubsetMarker extSubset
            //
            case 331: {
                
                setResult(new Ast());
                break;
            }
     
            //
            // Rule 332:  document ::= ExtParserEntMarker extParsedEnt
            //
            case 332: {
                
                setResult(new Ast());
                break;
            }
     
            //
            // Rule 1520:  element ::= < QName$SName Attributes > content < / QName$EName >
            //
            case 1520: {
                
                checkNames(2, 8);
                setResult(new Ast());
                break;
            }
     
            //
            // Rule 1521:  element ::= < QName$SName Attributes WhiteSpaces > content < / QName$EName >
            //
            case 1521: {
                
                setResult(new Ast());
                break;
            }
     
            //
            // Rule 1522:  element ::= < QName$SName Attributes > content < / QName$EName WhiteSpaces >
            //
            case 1522: {
                
                setResult(new Ast());
                break;
            }
     
            //
            // Rule 1523:  element ::= < QName$SName Attributes WhiteSpaces > content < / QName$EName WhiteSpaces$ >
            //
            case 1523: {
                
                setResult(new Ast());
                break;
            }
    
    
            default:
                break;
        }
        return;
    }
}

