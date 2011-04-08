package expr1;


    //#line 123 "LexerTemplateF.gi
import lpg.runtime.*;

    //#line 128 "LexerTemplateF.gi

public class ExprLexer extends Object implements RuleAction
{
    private ExprLexerLpgLexStream lexStream;
    
    private static ParseTable prs = new ExprLexerprs();
    public ParseTable getParseTable() { return prs; }

    private LexParser lexParser = new LexParser();
    public LexParser getParser() { return lexParser; }

    public int getToken(int i) { return lexParser.getToken(i); }
    public int getRhsFirstTokenIndex(int i) { return lexParser.getFirstToken(i); }
    public int getRhsLastTokenIndex(int i) { return lexParser.getLastToken(i); }

    public int getLeftSpan() { return lexParser.getToken(1); }
    public int getRightSpan() { return lexParser.getLastToken(); }

    public void resetKeywordLexer()
    {
        if (kwLexer == null)
              this.kwLexer = new NoKWLexer(lexStream.getInputChars(), 0);
        else this.kwLexer.setInputChars(lexStream.getInputChars());
    }

    public void reset(String filename, int tab) throws java.io.IOException
    {
        lexStream = new ExprLexerLpgLexStream(filename, tab);
        lexParser.reset((ILexStream) lexStream, prs, (RuleAction) this);
        resetKeywordLexer();
    }

    public void reset(char[] input_chars, String filename)
    {
        reset(input_chars, filename, 1);
    }
    
    public void reset(char[] input_chars, String filename, int tab)
    {
        lexStream = new ExprLexerLpgLexStream(input_chars, filename, tab);
        lexParser.reset((ILexStream) lexStream, prs, (RuleAction) this);
        resetKeywordLexer();
    }
    
    public ExprLexer(String filename, int tab) throws java.io.IOException 
    {
        reset(filename, tab);
    }

    public ExprLexer(char[] input_chars, String filename, int tab)
    {
        reset(input_chars, filename, tab);
    }

    public ExprLexer(char[] input_chars, String filename)
    {
        reset(input_chars, filename, 1);
    }

    public ExprLexer() {}

    public ILexStream getILexStream() { return lexStream; }

    /**
     * @deprecated replaced by {@link #getILexStream()}
     */
    public ILexStream getLexStream() { return lexStream; }

    private void initializeLexer(IPrsStream prsStream, int start_offset, int end_offset)
    {
        if (lexStream.getInputChars() == null)
            throw new NullPointerException("LexStream was not initialized");
        lexStream.setPrsStream(prsStream);
        prsStream.makeToken(start_offset, end_offset, 0); // Token list must start with a bad token
    }

    private void addEOF(IPrsStream prsStream, int end_offset)
    {
        prsStream.makeToken(end_offset, end_offset, ExprParsersym.TK_EOF_TOKEN); // and end with the end of file token
        prsStream.setStreamLength(prsStream.getSize());
    }

    public void lexer(IPrsStream prsStream)
    {
        lexer(null, prsStream);
    }
    
    public void lexer(Monitor monitor, IPrsStream prsStream)
    {
        initializeLexer(prsStream, 0, -1);
        lexParser.parseCharacters(monitor);  // Lex the input characters
        addEOF(prsStream, lexStream.getStreamIndex());
    }

    public void lexer(IPrsStream prsStream, int start_offset, int end_offset)
    {
        lexer(null, prsStream, start_offset, end_offset);
    }
    
    public void lexer(Monitor monitor, IPrsStream prsStream, int start_offset, int end_offset)
    {
        if (start_offset <= 1)
             initializeLexer(prsStream, 0, -1);
        else initializeLexer(prsStream, start_offset - 1, start_offset - 1);

        lexParser.parseCharacters(monitor, start_offset, end_offset);

        addEOF(prsStream, (end_offset >= lexStream.getStreamIndex() ? lexStream.getStreamIndex() : end_offset + 1));
    }
    
    public IPrsStream.Range incrementalLexer(char[] input_chars, int start_change_offset, int end_change_offset) {
        int offset_adjustment = input_chars.length - lexStream.getStreamLength();
//*System.out.println("The offset adjustment is " + offset_adjustment);
        if (start_change_offset <= 0 && start_change_offset < input_chars.length)
            throw new IndexOutOfBoundsException("The start offset " + start_change_offset +
                                                " is out of bounds for range 0.." + (input_chars.length - 1));
        if (end_change_offset <= 0 && end_change_offset < input_chars.length)
            throw new IndexOutOfBoundsException("The end offset " + end_change_offset +
                                                " is out of bounds for range 0.." + (input_chars.length - 1));
        
        //
        // Get the potential list of tokens to be rescanned
        //
        java.util.ArrayList<IToken> affected_tokens = lexStream.getIPrsStream().incrementalResetAtCharacterOffset(start_change_offset); 
        
        //
        // If the change occured between the first two affected tokens (or adjunct) and not immediately
        // on the characted after the first token (or adjunct), restart the scanning after the first
        // affected token. Otherwise, rescan the first token.
        //
        int affected_index = 0;
        int repair_offset = start_change_offset;
        if (affected_tokens.size() > 0) {
            if (affected_tokens.get(0).getEndOffset() + 1 < start_change_offset) {
                 repair_offset = affected_tokens.get(0).getEndOffset() + 1;
                 if (affected_tokens.get(0) instanceof Token)
                     lexStream.getIPrsStream().makeToken(affected_tokens.get(0), 0);
                else lexStream.getIPrsStream().makeAdjunct(affected_tokens.get(0), 0);
                affected_index++;                    
            }
            else repair_offset = affected_tokens.get(0).getStartOffset();
        } 

        lexStream.setInputChars(input_chars);
        lexStream.setStreamLength(input_chars.length);
        lexStream.computeLineOffsets(repair_offset);

        int first_new_token_index = lexStream.getIPrsStream().getTokens().size(),
            first_new_adjunct_index = lexStream.getIPrsStream().getAdjuncts().size();
        
        resetKeywordLexer();
        lexParser.resetTokenStream(repair_offset);
        int next_offset;
        do {
//*System.out.println("Scanning token starting at " + (lexStream.peek() - 1));            
            next_offset = lexParser.incrementalParseCharacters();
//*System.out.print("***Remaining string: \"");
//*for (int i = next_offset; i < input_chars.length; i++)
//*System.out.print(input_chars[i]);
//*System.out.println("\"");                    
            while (affected_index < affected_tokens.size() && 
                   affected_tokens.get(affected_index).getStartOffset() + offset_adjustment < next_offset)
//*{
//*System.out.println("---Skipping token " + affected_index + ": \"" + affected_tokens.get(affected_index).toString() +
//*"\" starting at adjusted offset " + (affected_tokens.get(affected_index).getStartOffset() + offset_adjustment));                           
                affected_index++;
//*}
        } while(next_offset <= end_change_offset &&          // still in the damage region and ...
                (affected_index < affected_tokens.size() &&  // not resynchronized with a token in the list of affected tokens
                 affected_tokens.get(affected_index).getStartOffset() + offset_adjustment != next_offset));

        //
        // If any new tokens were added, compute the first and the last one.
        //
        IToken first_new_token = null,
               last_new_token = null;
        if (first_new_token_index < lexStream.getIPrsStream().getTokens().size()) {
            first_new_token = lexStream.getIPrsStream().getTokenAt(first_new_token_index);
            last_new_token = lexStream.getIPrsStream().getTokenAt(lexStream.getIPrsStream().getTokens().size() - 1);
        }
        //
        // If an adjunct was added prior to the first real token, chose it instead as the first token.
        // Similarly, if adjucts were added after the last token, chose the last adjunct added as the last token.
        //
        if (first_new_adjunct_index < lexStream.getIPrsStream().getAdjuncts().size()) {
            if (first_new_token == null ||
                lexStream.getIPrsStream().getAdjunctAt(first_new_adjunct_index).getStartOffset() <
                first_new_token.getStartOffset()) {
                first_new_token = lexStream.getIPrsStream().getAdjunctAt(first_new_adjunct_index);
            }
            if (last_new_token == null ||
                lexStream.getIPrsStream().getAdjunctAt(lexStream.getIPrsStream().getAdjuncts().size() - 1).getEndOffset() >
                last_new_token.getEndOffset()) {
                last_new_token = lexStream.getIPrsStream().getAdjunctAt(lexStream.getIPrsStream().getAdjuncts().size() - 1);
            }
        }
        
        //
        // For all remainng tokens (and adjuncts) in the list of affected tokens add them to the
        // list of tokens (and adjuncts).
        //
        for (int i = affected_index; i < affected_tokens.size(); i++) {
            if (affected_tokens.get(i) instanceof Token)
                 lexStream.getIPrsStream().makeToken(affected_tokens.get(i), offset_adjustment);
            else lexStream.getIPrsStream().makeAdjunct(affected_tokens.get(i), offset_adjustment);
//*System.out.println("+++Added affected token " + i + ": \"" + affected_tokens.get(i).toString() +
//*"\" starting at adjusted offset " + (affected_tokens.get(i).getStartOffset() + offset_adjustment));                           
        }
        
        return new IPrsStream.Range(lexStream.getIPrsStream(), first_new_token, last_new_token);
    }

    /**
     * If a parse stream was not passed to this Lexical analyser then we
     * simply report a lexical error. Otherwise, we produce a bad token.
     */
    public void reportLexicalError(int startLoc, int endLoc) {
        IPrsStream prs_stream = lexStream.getIPrsStream();
        if (prs_stream == null)
            lexStream.reportLexicalError(startLoc, endLoc);
        else {
            //
            // Remove any token that may have been processed that fall in the
            // range of the lexical error... then add one error token that spans
            // the error range.
            //
            for (int i = prs_stream.getSize() - 1; i > 0; i--) {
                if (prs_stream.getStartOffset(i) >= startLoc)
                     prs_stream.removeLastToken();
                else break;
            }
            prs_stream.makeToken(startLoc, endLoc, 0); // add an error token to the prsStream
        }        
    }

    //#line 9 "LexerVeryBasicMapF.gi

    static public class NoKWLexer
    {
        public int[] getKeywordKinds() { return null; }

        public int lexer(int curtok, int lasttok) { return 0; }

        public void setInputChars(char[] inputChars) { }

        final int getKind(int c) { return 0; }

        public NoKWLexer(char[] inputChars, int identifierKind) { }
    }

    //#line 5 "LexerBasicMapF.gi

    //
    // The Lexer contains an array of characters as the input stream to be parsed.
    // There are methods to retrieve and classify characters.
    // The lexparser "token" is implemented simply as the index of the next character in the array.
    // The Lexer extends the abstract class LpgLexStream with an implementation of the abstract
    // method getKind.  The template defines the Lexer class and the lexer() method.
    // A driver creates the action class, "Lexer", passing an Option object to the constructor.
    //
    NoKWLexer kwLexer;
    boolean printTokens;
    private final static int ECLIPSE_TAB_VALUE = 4;

    public int [] getKeywordKinds() { return kwLexer.getKeywordKinds(); }

    public ExprLexer(String filename) throws java.io.IOException
    {
        this(filename, ECLIPSE_TAB_VALUE);
        this.kwLexer = new NoKWLexer(lexStream.getInputChars(), 0);
    }

    /**
     * @deprecated function replaced by {@link #reset(char [] content, String filename)}
     */
    public void initialize(char [] content, String filename)
    {
        reset(content, filename);
    }
    
    final void makeToken(int left_token, int right_token, int kind)
    {
        lexStream.makeToken(left_token, right_token, kind);
    }
    
    final void makeToken(int kind)
    {
        int startOffset = getLeftSpan(),
            endOffset = getRightSpan();
        lexStream.makeToken(startOffset, endOffset, kind);
        if (printTokens) printValue(startOffset, endOffset);
    }

    final void makeComment(int kind)
    {
        int startOffset = getLeftSpan(),
            endOffset = getRightSpan();
        lexStream.getIPrsStream().makeAdjunct(startOffset, endOffset, kind);
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
        lexStream.makeToken(startOffset, endOffset, kwKind);
        if (printTokens) printValue(startOffset, endOffset);
    }
    
    //
    // This flavor of checkForKeyWord is necessary when the default kind
    // (which is returned when the keyword filter doesn't match) is something
    // other than _IDENTIFIER.
    //
    final void checkForKeyWord(int defaultKind)
    {
        int startOffset = getLeftSpan(),
            endOffset = getRightSpan(),
            kwKind = kwLexer.lexer(startOffset, endOffset);
        if (kwKind == 0)
            kwKind = defaultKind;
        lexStream.makeToken(startOffset, endOffset, kwKind);
        if (printTokens) printValue(startOffset, endOffset);
    }
    
    final void printValue(int startOffset, int endOffset)
    {
        String s = new String(lexStream.getInputChars(), startOffset, endOffset - startOffset + 1);
        System.out.print(s);
    }

    //
    //
    //
    static class ExprLexerLpgLexStream extends LpgLexStream
    {
    public final static int tokenKind[] =
    {
        ExprLexersym.Char_CtlCharNotWS,    // 000    0x00
        ExprLexersym.Char_CtlCharNotWS,    // 001    0x01
        ExprLexersym.Char_CtlCharNotWS,    // 002    0x02
        ExprLexersym.Char_CtlCharNotWS,    // 003    0x03
        ExprLexersym.Char_CtlCharNotWS,    // 004    0x04
        ExprLexersym.Char_CtlCharNotWS,    // 005    0x05
        ExprLexersym.Char_CtlCharNotWS,    // 006    0x06
        ExprLexersym.Char_CtlCharNotWS,    // 007    0x07
        ExprLexersym.Char_CtlCharNotWS,    // 008    0x08
        ExprLexersym.Char_HT,              // 009    0x09
        ExprLexersym.Char_LF,              // 010    0x0A
        ExprLexersym.Char_CtlCharNotWS,    // 011    0x0B
        ExprLexersym.Char_FF,              // 012    0x0C
        ExprLexersym.Char_CR,              // 013    0x0D
        ExprLexersym.Char_CtlCharNotWS,    // 014    0x0E
        ExprLexersym.Char_CtlCharNotWS,    // 015    0x0F
        ExprLexersym.Char_CtlCharNotWS,    // 016    0x10
        ExprLexersym.Char_CtlCharNotWS,    // 017    0x11
        ExprLexersym.Char_CtlCharNotWS,    // 018    0x12
        ExprLexersym.Char_CtlCharNotWS,    // 019    0x13
        ExprLexersym.Char_CtlCharNotWS,    // 020    0x14
        ExprLexersym.Char_CtlCharNotWS,    // 021    0x15
        ExprLexersym.Char_CtlCharNotWS,    // 022    0x16
        ExprLexersym.Char_CtlCharNotWS,    // 023    0x17
        ExprLexersym.Char_CtlCharNotWS,    // 024    0x18
        ExprLexersym.Char_CtlCharNotWS,    // 025    0x19
        ExprLexersym.Char_CtlCharNotWS,    // 026    0x1A
        ExprLexersym.Char_CtlCharNotWS,    // 027    0x1B
        ExprLexersym.Char_CtlCharNotWS,    // 028    0x1C
        ExprLexersym.Char_CtlCharNotWS,    // 029    0x1D
        ExprLexersym.Char_CtlCharNotWS,    // 030    0x1E
        ExprLexersym.Char_CtlCharNotWS,    // 031    0x1F
        ExprLexersym.Char_Space,           // 032    0x20
        ExprLexersym.Char_Exclamation,     // 033    0x21
        ExprLexersym.Char_DoubleQuote,     // 034    0x22
        ExprLexersym.Char_Sharp,           // 035    0x23
        ExprLexersym.Char_DollarSign,      // 036    0x24
        ExprLexersym.Char_Percent,         // 037    0x25
        ExprLexersym.Char_Ampersand,       // 038    0x26
        ExprLexersym.Char_SingleQuote,     // 039    0x27
        ExprLexersym.Char_LeftParen,       // 040    0x28
        ExprLexersym.Char_RightParen,      // 041    0x29
        ExprLexersym.Char_Star,            // 042    0x2A
        ExprLexersym.Char_Plus,            // 043    0x2B
        ExprLexersym.Char_Comma,           // 044    0x2C
        ExprLexersym.Char_Minus,           // 045    0x2D
        ExprLexersym.Char_Dot,             // 046    0x2E
        ExprLexersym.Char_Slash,           // 047    0x2F
        ExprLexersym.Char_0,               // 048    0x30
        ExprLexersym.Char_1,               // 049    0x31
        ExprLexersym.Char_2,               // 050    0x32
        ExprLexersym.Char_3,               // 051    0x33
        ExprLexersym.Char_4,               // 052    0x34
        ExprLexersym.Char_5,               // 053    0x35
        ExprLexersym.Char_6,               // 054    0x36
        ExprLexersym.Char_7,               // 055    0x37
        ExprLexersym.Char_8,               // 056    0x38
        ExprLexersym.Char_9,               // 057    0x39
        ExprLexersym.Char_Colon,           // 058    0x3A
        ExprLexersym.Char_SemiColon,       // 059    0x3B
        ExprLexersym.Char_LessThan,        // 060    0x3C
        ExprLexersym.Char_Equal,           // 061    0x3D
        ExprLexersym.Char_GreaterThan,     // 062    0x3E
        ExprLexersym.Char_QuestionMark,    // 063    0x3F
        ExprLexersym.Char_AtSign,          // 064    0x40
        ExprLexersym.Char_A,               // 065    0x41
        ExprLexersym.Char_B,               // 066    0x42
        ExprLexersym.Char_C,               // 067    0x43
        ExprLexersym.Char_D,               // 068    0x44
        ExprLexersym.Char_E,               // 069    0x45
        ExprLexersym.Char_F,               // 070    0x46
        ExprLexersym.Char_G,               // 071    0x47
        ExprLexersym.Char_H,               // 072    0x48
        ExprLexersym.Char_I,               // 073    0x49
        ExprLexersym.Char_J,               // 074    0x4A
        ExprLexersym.Char_K,               // 075    0x4B
        ExprLexersym.Char_L,               // 076    0x4C
        ExprLexersym.Char_M,               // 077    0x4D
        ExprLexersym.Char_N,               // 078    0x4E
        ExprLexersym.Char_O,               // 079    0x4F
        ExprLexersym.Char_P,               // 080    0x50
        ExprLexersym.Char_Q,               // 081    0x51
        ExprLexersym.Char_R,               // 082    0x52
        ExprLexersym.Char_S,               // 083    0x53
        ExprLexersym.Char_T,               // 084    0x54
        ExprLexersym.Char_U,               // 085    0x55
        ExprLexersym.Char_V,               // 086    0x56
        ExprLexersym.Char_W,               // 087    0x57
        ExprLexersym.Char_X,               // 088    0x58
        ExprLexersym.Char_Y,               // 089    0x59
        ExprLexersym.Char_Z,               // 090    0x5A
        ExprLexersym.Char_LeftBracket,     // 091    0x5B
        ExprLexersym.Char_BackSlash,       // 092    0x5C
        ExprLexersym.Char_RightBracket,    // 093    0x5D
        ExprLexersym.Char_Caret,           // 094    0x5E
        ExprLexersym.Char__,               // 095    0x5F
        ExprLexersym.Char_BackQuote,       // 096    0x60
        ExprLexersym.Char_a,               // 097    0x61
        ExprLexersym.Char_b,               // 098    0x62
        ExprLexersym.Char_c,               // 099    0x63
        ExprLexersym.Char_d,               // 100    0x64
        ExprLexersym.Char_e,               // 101    0x65
        ExprLexersym.Char_f,               // 102    0x66
        ExprLexersym.Char_g,               // 103    0x67
        ExprLexersym.Char_h,               // 104    0x68
        ExprLexersym.Char_i,               // 105    0x69
        ExprLexersym.Char_j,               // 106    0x6A
        ExprLexersym.Char_k,               // 107    0x6B
        ExprLexersym.Char_l,               // 108    0x6C
        ExprLexersym.Char_m,               // 109    0x6D
        ExprLexersym.Char_n,               // 110    0x6E
        ExprLexersym.Char_o,               // 111    0x6F
        ExprLexersym.Char_p,               // 112    0x70
        ExprLexersym.Char_q,               // 113    0x71
        ExprLexersym.Char_r,               // 114    0x72
        ExprLexersym.Char_s,               // 115    0x73
        ExprLexersym.Char_t,               // 116    0x74
        ExprLexersym.Char_u,               // 117    0x75
        ExprLexersym.Char_v,               // 118    0x76
        ExprLexersym.Char_w,               // 119    0x77
        ExprLexersym.Char_x,               // 120    0x78
        ExprLexersym.Char_y,               // 121    0x79
        ExprLexersym.Char_z,               // 122    0x7A
        ExprLexersym.Char_LeftBrace,       // 123    0x7B
        ExprLexersym.Char_VerticalBar,     // 124    0x7C
        ExprLexersym.Char_RightBrace,      // 125    0x7D
        ExprLexersym.Char_Tilde,           // 126    0x7E

        ExprLexersym.Char_AfterASCII,      // for all chars in range 128..65534
        ExprLexersym.Char_EOF              // for '\uffff' or 65535 
    };
            
    public final int getKind(int i)  // Classify character at ith location
    {
        int c = (i >= getStreamLength() ? '\uffff' : getCharValue(i));
        return (c < 128 // ASCII Character
                  ? tokenKind[c]
                  : c == '\uffff'
                       ? ExprLexersym.Char_EOF
                       : ExprLexersym.Char_AfterASCII);
    }

    public String[] orderedExportedSymbols() { return ExprParsersym.orderedTerminalSymbols; }

    public ExprLexerLpgLexStream(String filename, int tab) throws java.io.IOException
    {
        super(filename, tab);
    }

    public ExprLexerLpgLexStream(char[] input_chars, String filename, int tab)
    {
        super(input_chars, filename, tab);
    }

    public ExprLexerLpgLexStream(char[] input_chars, String filename)
    {
        super(input_chars, filename, 1);
    }
    }

    //#line 366 "LexerTemplateF.gi

    public void ruleAction(int ruleNumber)
    {
        switch(ruleNumber)
        {

            //
            // Rule 1:  Token ::= IntegerLiteral
            //
            case 1: { 
            
                makeToken(ExprParsersym.TK_IntegerLiteral);
                break;
            }
            //
            // Rule 2:  Token ::= +
            //
            case 2: { 
            
                makeToken(ExprParsersym.TK_PLUS);
                break;
            }
            //
            // Rule 3:  Token ::= *
            //
            case 3: { 
            
                makeToken(ExprParsersym.TK_MULTIPLY);
                break;
            }
            //
            // Rule 4:  Token ::= (
            //
            case 4: { 
            
                makeToken(ExprParsersym.TK_LPAREN);
                break;
            }
            //
            // Rule 5:  Token ::= )
            //
            case 5: { 
            
                makeToken(ExprParsersym.TK_RPAREN);
                break;
            }
            //
            // Rule 6:  Token ::= WS
            //
            case 6: { 
            
                skipToken();
                break;
            }
    //#line 370 "LexerTemplateF.gi

    
            default:
                break;
        }
        return;
    }
}

