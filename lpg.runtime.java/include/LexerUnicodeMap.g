%Terminals
    u0000
    u0001
    u0002
    u0003
    u0004
    u0005
    u0006
    u0007
    u0008
    u0009 -- HT
    u000A -- LF
    u000B
    u000C -- FF
    u000D -- CR
    u000E
    u000F
    u0010
    u0011
    u0012
    u0013
    u0014
    u0015
    u0016
    u0017
    u0018
    u0019
    u001A
    u001B
    u001C
    u001D
    u001E
    u001F
    u0020 ::= ' '
    u0021 ::= '!'
    u0022 ::= '"'
    u0023 ::= '#'
    u0024 ::= '$'
    u0025 ::= '%'
    u0026 ::= '&'
    u0027 ::= "'"
    u0028 ::= '('
    u0029 ::= ')'
    u002A ::= '*'
    u002B ::= '+'
    u002C ::= ','
    u002D ::= '-'
    u002E ::= '.'
    u002F ::= '/'
    u0030 ::= '0'
    u0031 ::= '1'
    u0032 ::= '2'
    u0033 ::= '3'
    u0034 ::= '4'
    u0035 ::= '5'
    u0036 ::= '6'
    u0037 ::= '7'
    u0038 ::= '8'
    u0039 ::= '9'
    u003A ::= ':'
    u003B ::= ';'
    u003C ::= '<'
    u003D ::= '='
    u003E ::= '>'
    u003F ::= '?'
    u0040 ::= '@'
    u0041 ::= 'A'
    u0042 ::= 'B'
    u0043 ::= 'C'
    u0044 ::= 'D'
    u0045 ::= 'E'
    u0046 ::= 'F'
    u0047 ::= 'G'
    u0048 ::= 'H'
    u0049 ::= 'I'
    u004A ::= 'J'
    u004B ::= 'K'
    u004C ::= 'L'
    u004D ::= 'M'
    u004E ::= 'N'
    u004F ::= 'O'
    u0050 ::= 'P'
    u0051 ::= 'Q'
    u0052 ::= 'R'
    u0053 ::= 'S'
    u0054 ::= 'T'
    u0055 ::= 'U'
    u0056 ::= 'V'
    u0057 ::= 'W'
    u0058 ::= 'X'
    u0059 ::= 'Y'
    u005A ::= 'Z'
    u005B ::= '['
    u005C ::= '\'
    u005D ::= ']'
    u005E ::= '^'
    u005F ::= '_'
    u0060 ::= '`'
    u0061 ::= 'a'
    u0062 ::= 'b'
    u0063 ::= 'c'
    u0064 ::= 'd'
    u0065 ::= 'e'
    u0066 ::= 'f'
    u0067 ::= 'g'
    u0068 ::= 'h'
    u0069 ::= 'i'
    u006A ::= 'j'
    u006B ::= 'k'
    u006C ::= 'l'
    u006D ::= 'm'
    u006E ::= 'n'
    u006F ::= 'o'
    u0070 ::= 'p'
    u0071 ::= 'q'
    u0072 ::= 'r'
    u0073 ::= 's'
    u0074 ::= 't'
    u0075 ::= 'u'
    u0076 ::= 'v'
    u0077 ::= 'w'
    u0078 ::= 'x'
    u0079 ::= 'y'
    u007A ::= 'z'
    u007B ::= '{'
    u007C ::= '|'
    u007D ::= '}'
    u007E ::= '~'
    u007F
    
    UNUSED
%End

%Headers
    --
    -- Additional methods for the action class not provided in the template
    --
    /.
        //
        // The Lexer contains an array of characters as the input stream to be parsed.
        // There are methods to retrieve and classify characters.
        // The lexparser "token" is implemented simply as the index of the next character in the array.
        // The Lexer extends the abstract class LpgLexStream with an implementation of the abstract
        // method getKind.  The template defines the Lexer class and the lexer() method.
        // A driver creates the action class, "Lexer", passing an Option object to the constructor.
        //
        $kw_lexer_class kwLexer;
        boolean printTokens;
        private final static int ECLIPSE_TAB_VALUE = 4;

        public int [] getKeywordKinds() { return kwLexer.getKeywordKinds(); }

        public $action_type(String filename) throws java.io.IOException
        {
            this(filename, ECLIPSE_TAB_VALUE);
            this.kwLexer = new $kw_lexer_class(getInputChars(), $_IDENTIFIER);
        }

        public void initialize(char [] content, String filename)
        {
            super.initialize(content, filename);
            if (this.kwLexer == null)
                 this.kwLexer = new $kw_lexer_class(getInputChars(), $_IDENTIFIER);
            else this.kwLexer.setInputChars(getInputChars());
        }
        
        final void makeToken(int kind)
        {
            int startOffset = getLeftSpan(),
                endOffset = getRightSpan();
            makeToken(startOffset, endOffset, kind);
            if (printTokens) printValue(startOffset, endOffset);
        }

        final void makeComment(int kind)
        {
            int startOffset = getLeftSpan(),
                endOffset = getRightSpan();
            super.getPrsStream().makeAdjunct(startOffset, endOffset, kind);
        }

        final void skipToken()
        {
            if (printTokens) printValue(getLeftSpan(), getRightSpan());
        }
        
        final void checkForKeyWord()
        {
            int startOffset = getLeftSpan(),
                endOffset = getRightSpan(),
            kwKind = kwLexer.lexer(startOffset, endOffset);
            makeToken(startOffset, endOffset, kwKind);
            if (printTokens) printValue(startOffset, endOffset);
        }
        
        final void printValue(int startOffset, int endOffset)
        {
            String s = new String(getInputChars(), startOffset, endOffset - startOffset + 1);
            System.out.print(s);
        }

        //
        //
        //
        static byte tokenKind[] = new byte[0x10000]; // 0x10000 == 65536
        static
        {
            tokenKind[0x0000] = Char_u0000;           // 000    0x00
            tokenKind[0x0001] = Char_u0001;           // 001    0x01
            tokenKind[0x0002] = Char_u0002;           // 002    0x02
            tokenKind[0x0003] = Char_u0003;           // 003    0x03
            tokenKind[0x0004] = Char_u0004;           // 004    0x04
            tokenKind[0x0005] = Char_u0005;           // 005    0x05
            tokenKind[0x0006] = Char_u0006;           // 006    0x06
            tokenKind[0x0007] = Char_u0007;           // 007    0x07
            tokenKind[0x0008] = Char_u0008;           // 008    0x08
            tokenKind[0x0009] = Char_HT;              // 009    0x09
            tokenKind[0x000A] = Char_LF;              // 010    0x0A
            tokenKind[0x000B] = Char_u000B;           // 011    0x0B
            tokenKind[0x000C] = Char_FF;              // 012    0x0C
            tokenKind[0x000D] = Char_CR;              // 013    0x0D
            tokenKind[0x000E] = Char_u000E;           // 014    0x0E
            tokenKind[0x000F] = Char_u000F;           // 015    0x0F
            tokenKind[0x0010] = Char_u0010;           // 016    0x10
            tokenKind[0x0011] = Char_u0011;           // 017    0x11
            tokenKind[0x0012] = Char_u0012;           // 018    0x12
            tokenKind[0x0013] = Char_u0013;           // 019    0x13
            tokenKind[0x0014] = Char_u0014;           // 020    0x14
            tokenKind[0x0015] = Char_u0015;           // 021    0x15
            tokenKind[0x0016] = Char_u0016;           // 022    0x16
            tokenKind[0x0017] = Char_u0017;           // 023    0x17
            tokenKind[0x0018] = Char_u0018;           // 024    0x18
            tokenKind[0x0019] = Char_u0019;           // 025    0x19
            tokenKind[0x001A] = Char_u001A;           // 026    0x1A
            tokenKind[0x001B] = Char_u001B;           // 027    0x1B
            tokenKind[0x001C] = Char_u001C;           // 028    0x1C
            tokenKind[0x001D] = Char_u001D;           // 029    0x1D
            tokenKind[0x001E] = Char_u001E;           // 030    0x1E
            tokenKind[0x001F] = Char_u001F;           // 031    0x1F
            tokenKind[0x0020] = Char_u0020;           // 032    0x20
            tokenKind[0x0021] = Char_u0021;           // 033    0x21
            tokenKind[0x0022] = Char_u0022;           // 034    0x22
            tokenKind[0x0023] = Char_u0023;           // 035    0x23
            tokenKind[0x0024] = Char_u0024;           // 036    0x24
            tokenKind[0x0025] = Char_u0025;           // 037    0x25
            tokenKind[0x0026] = Char_u0026;           // 038    0x26
            tokenKind[0x0027] = Char_u0027;           // 039    0x27
            tokenKind[0x0028] = Char_u0028;           // 040    0x28
            tokenKind[0x0029] = Char_u0029;           // 041    0x29
            tokenKind[0x002A] = Char_u002A;           // 042    0x2A
            tokenKind[0x002B] = Char_u002B;           // 043    0x2B
            tokenKind[0x002C] = Char_u002C;           // 044    0x2C
            tokenKind[0x002D] = Char_u002D;           // 045    0x2D
            tokenKind[0x002E] = Char_u002E;           // 046    0x2E
            tokenKind[0x002F] = Char_u002F;           // 047    0x2F
            tokenKind[0x0030] = Char_u0030;           // 048    0x30
            tokenKind[0x0031] = Char_u0031;           // 049    0x31
            tokenKind[0x0032] = Char_u0032;           // 050    0x32
            tokenKind[0x0033] = Char_u0033;           // 051    0x33
            tokenKind[0x0034] = Char_u0034;           // 052    0x34
            tokenKind[0x0035] = Char_u0035;           // 053    0x35
            tokenKind[0x0036] = Char_u0036;           // 054    0x36
            tokenKind[0x0037] = Char_u0037;           // 055    0x37
            tokenKind[0x0038] = Char_u0038;           // 056    0x38
            tokenKind[0x0039] = Char_u0039;           // 057    0x39
            tokenKind[0x003A] = Char_u003A;           // 058    0x3A
            tokenKind[0x003B] = Char_u003B;           // 059    0x3B
            tokenKind[0x003C] = Char_u003C;           // 060    0x3C
            tokenKind[0x003D] = Char_u003D;           // 061    0x3D
            tokenKind[0x003E] = Char_u003E;           // 062    0x3E
            tokenKind[0x003F] = Char_u003F;           // 063    0x3F
            tokenKind[0x0040] = Char_u0040;           // 064    0x40
            tokenKind[0x0041] = Char_u0041;           // 065    0x41
            tokenKind[0x0042] = Char_u0042;           // 066    0x42
            tokenKind[0x0043] = Char_u0043;           // 067    0x43
            tokenKind[0x0044] = Char_u0044;           // 068    0x44
            tokenKind[0x0045] = Char_u0045;           // 069    0x45
            tokenKind[0x0046] = Char_u0046;           // 070    0x46
            tokenKind[0x0047] = Char_u0047;           // 071    0x47
            tokenKind[0x0048] = Char_u0048;           // 072    0x48
            tokenKind[0x0049] = Char_u0049;           // 073    0x49
            tokenKind[0x004A] = Char_u004A;           // 074    0x4A
            tokenKind[0x004B] = Char_u004B;           // 075    0x4B
            tokenKind[0x004C] = Char_u004C;           // 076    0x4C
            tokenKind[0x004D] = Char_u004D;           // 077    0x4D
            tokenKind[0x004E] = Char_u004E;           // 078    0x4E
            tokenKind[0x004F] = Char_u004F;           // 079    0x4F
            tokenKind[0x0050] = Char_u0050;           // 080    0x50
            tokenKind[0x0051] = Char_u0051;           // 081    0x51
            tokenKind[0x0052] = Char_u0052;           // 082    0x52
            tokenKind[0x0053] = Char_u0053;           // 083    0x53
            tokenKind[0x0054] = Char_u0054;           // 084    0x54
            tokenKind[0x0055] = Char_u0055;           // 085    0x55
            tokenKind[0x0056] = Char_u0056;           // 086    0x56
            tokenKind[0x0057] = Char_u0057;           // 087    0x57
            tokenKind[0x0058] = Char_u0058;           // 088    0x58
            tokenKind[0x0059] = Char_u0059;           // 089    0x59
            tokenKind[0x005A] = Char_u005A;           // 090    0x5A
            tokenKind[0x005B] = Char_u005B;           // 091    0x5B
            tokenKind[0x005C] = Char_u005C;           // 092    0x5C
            tokenKind[0x005D] = Char_u005D;           // 093    0x5D
            tokenKind[0x005E] = Char_u005E;           // 094    0x5E
            tokenKind[0x005F] = Char_u005F;           // 095    0x5F
            tokenKind[0x0060] = Char_u0060;           // 096    0x60
            tokenKind[0x0061] = Char_u0061;           // 097    0x61
            tokenKind[0x0062] = Char_u0062;           // 098    0x62
            tokenKind[0x0063] = Char_u0063;           // 099    0x63
            tokenKind[0x0064] = Char_u0064;           // 100    0x64
            tokenKind[0x0065] = Char_u0065;           // 101    0x65
            tokenKind[0x0066] = Char_u0066;           // 102    0x66
            tokenKind[0x0067] = Char_u0067;           // 103    0x67
            tokenKind[0x0068] = Char_u0068;           // 104    0x68
            tokenKind[0x0069] = Char_u0069;           // 105    0x69
            tokenKind[0x006A] = Char_u006A;           // 106    0x6A
            tokenKind[0x006B] = Char_u006B;           // 107    0x6B
            tokenKind[0x006C] = Char_u006C;           // 108    0x6C
            tokenKind[0x006D] = Char_u006D;           // 109    0x6D
            tokenKind[0x006E] = Char_u006E;           // 110    0x6E
            tokenKind[0x006F] = Char_u006F;           // 111    0x6F
            tokenKind[0x0070] = Char_u0070;           // 112    0x70
            tokenKind[0x0071] = Char_u0071;           // 113    0x71
            tokenKind[0x0072] = Char_u0072;           // 114    0x72
            tokenKind[0x0073] = Char_u0073;           // 115    0x73
            tokenKind[0x0074] = Char_u0074;           // 116    0x74
            tokenKind[0x0075] = Char_u0075;           // 117    0x75
            tokenKind[0x0076] = Char_u0076;           // 118    0x76
            tokenKind[0x0077] = Char_u0077;           // 119    0x77
            tokenKind[0x0078] = Char_u0078;           // 120    0x78
            tokenKind[0x0079] = Char_u0079;           // 121    0x79
            tokenKind[0x007A] = Char_u007A;           // 122    0x7A
            tokenKind[0x007B] = Char_u007B;           // 123    0x7B
            tokenKind[0x007C] = Char_u007C;           // 124    0x7C
            tokenKind[0x007D] = Char_u007D;           // 125    0x7D
            tokenKind[0x007E] = Char_u007E;           // 126    0x7E
            tokenKind[0x007F] = Char_u007F;           // 127    0x7F

            tokenKind[0xFFFF] = Char_EOF;

            //
            // Every other character not yet assigned is treated initially as unused
            //
            for (int i = 0x007F; i < 0xFFFF; i++)
                if (tokenKind[i] == 0) tokenKind[i] = Char_UNUSED;
        };
                
        public final int getKind(int i)  // Classify character at ith location
        {
            return (i >= getStreamLength()
                       ? '\uffff'
                       : tokenKind[getIntValue(i)]);
        }
    ./
%End
